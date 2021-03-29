package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import d.b.h0.a.f;
import d.b.i0.a2.a;
/* loaded from: classes5.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    public static final int WX_NOTINSTALL_CODE = 123456;
    public Intent mIntentForShare;
    public NavigationBar mNavigationBar;
    public IWXAPI mWxAPI;

    private void onHandleReqFromWeixinToTieba(ShowMessageFromWX.Req req) {
        String str = req.message.messageExt;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.startsWith("tid=")) {
                String[] split = str.split("&");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str2 = split[i];
                        if (str2 != null && str2.startsWith("tid=")) {
                            str = UrlSchemaHelper.SCHEMA_TYPE_PB + str2.substring(4);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if (str.startsWith(f.f49575a) && f.c(Uri.parse(str))) {
                UtilHelper.dealOneScheme(getPageContext().getPageActivity(), str);
            } else {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
            }
        } finally {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IWXAPI iwxapi;
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2921332, (Class) null);
        setContentView(R.layout.layout_sapi_webview_login);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.sapi_login_navi);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(R.string.login));
        try {
            this.mWxAPI = WXAPIFactory.createWXAPI(getActivity(), TbConfig.WEIXIN_SHARE_APP_ID, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Intent intent = getIntent();
        this.mIntentForShare = intent;
        if (intent == null || (iwxapi = this.mWxAPI) == null) {
            return;
        }
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        IWXAPI iwxapi;
        super.onNewIntent(intent);
        setIntent(intent);
        this.mIntentForShare = intent;
        if (intent == null || (iwxapi = this.mWxAPI) == null) {
            return;
        }
        iwxapi.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        if (baseReq.getType() == 4 && (baseReq instanceof ShowMessageFromWX.Req)) {
            onHandleReqFromWeixinToTieba((ShowMessageFromWX.Req) baseReq);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp == null) {
            return;
        }
        int type = baseResp.getType();
        if (1 == type) {
            a aVar = new a();
            aVar.f51899a = this;
            aVar.f51900b = baseResp;
            MessageManager.getInstance().runTask(2921351, null, aVar);
            closeActivity();
        } else if (2 == type && (baseResp instanceof SendMessageToWX.Resp)) {
            SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
            int i = resp.errCode;
            String str = resp.errStr;
            if (str == null) {
                str = "";
            }
            Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            intent.putExtra("weixin_result_errCode", i);
            intent.putExtra("weixin_result_errMsg", str);
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016450, Boolean.TRUE));
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
            } else if (i == -2) {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
            } else if (i == 123456) {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
            } else {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
            }
            BdBaseApplication.getInst().sendBroadcast(intent);
            closeActivity();
        }
    }
}

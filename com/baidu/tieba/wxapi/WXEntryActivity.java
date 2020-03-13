package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.a;
import com.baidu.webkit.internal.ETAG;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes8.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    private IWXAPI kVL;
    private Intent kVM;
    private NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
        setContentView(R.layout.layout_sapi_webview_login);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.sapi_login_navi);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getResources().getString(R.string.login));
        try {
            this.kVL = WXAPIFactory.createWXAPI(getActivity(), TbConfig.WEIXIN_SHARE_APP_ID, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.kVM = getIntent();
        if (this.kVM != null && this.kVL != null) {
            this.kVL.handleIntent(getIntent(), this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.kVM = intent;
        if (this.kVM != null && this.kVL != null) {
            this.kVL.handleIntent(intent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        switch (baseReq.getType()) {
            case 3:
            default:
                return;
            case 4:
                if (baseReq instanceof ShowMessageFromWX.Req) {
                    a((ShowMessageFromWX.Req) baseReq);
                    return;
                }
                return;
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp != null) {
            int type = baseResp.getType();
            if (1 == type) {
                a aVar = new a();
                aVar.iye = this;
                aVar.iyf = baseResp;
                MessageManager.getInstance().runTask(2921351, null, aVar);
                closeActivity();
            } else if (2 == type && (baseResp instanceof SendMessageToWX.Resp)) {
                SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
                int i = resp.errCode;
                String str = resp.errStr != null ? resp.errStr : "";
                Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
                intent.putExtra("weixin_result_errCode", i);
                intent.putExtra("weixin_result_errMsg", str);
                if (i == 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WX_SHARE_SUCCESS, true));
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

    private void a(ShowMessageFromWX.Req req) {
        int i = 0;
        String str = req.message.messageExt;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.startsWith("tid=")) {
                    String[] split = str.split(ETAG.ITEM_SEPARATOR);
                    int length = split.length;
                    while (true) {
                        if (i < length) {
                            String str2 = split[i];
                            if (str2 == null || !str2.startsWith("tid=")) {
                                i++;
                            } else {
                                str = UrlSchemaHelper.SCHEMA_TYPE_PB + str2.substring(4);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (str.startsWith(f.cHZ) && f.n(Uri.parse(str))) {
                    UtilHelper.dealOneScheme(getPageContext().getPageActivity(), str);
                } else {
                    ba.aGG().b(getPageContext(), new String[]{str});
                }
            } finally {
                closeActivity();
            }
        }
    }
}

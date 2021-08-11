package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.a.g;
import c.a.p0.g2.a;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
/* loaded from: classes7.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int WX_NOTINSTALL_CODE = 123456;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent mIntentForShare;
    public NavigationBar mNavigationBar;
    public IWXAPI mWxAPI;

    public WXEntryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void onHandleReqFromWeixinToTieba(ShowMessageFromWX.Req req) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, req) == null) {
            String str = req.message.messageExt;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (str.startsWith("tid=")) {
                    String[] split = str.split("&");
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            String str2 = split[i2];
                            if (str2 != null && str2.startsWith("tid=")) {
                                str = UrlSchemaHelper.SCHEMA_TYPE_PB + str2.substring(4);
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                if (str.startsWith(g.f12331a) && g.c(Uri.parse(str))) {
                    UtilHelper.dealOneScheme(getPageContext().getPageActivity(), str);
                } else {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
                }
            } finally {
                closeActivity();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IWXAPI iwxapi;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        IWXAPI iwxapi;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.mIntentForShare = intent;
            if (intent == null || (iwxapi = this.mWxAPI) == null) {
                return;
            }
            iwxapi.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, baseReq) == null) && baseReq.getType() == 4 && (baseReq instanceof ShowMessageFromWX.Req)) {
            onHandleReqFromWeixinToTieba((ShowMessageFromWX.Req) baseReq);
        }
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, baseResp) == null) || baseResp == null) {
            return;
        }
        int type = baseResp.getType();
        if (1 == type) {
            a aVar = new a();
            aVar.f18026a = this;
            aVar.f18027b = baseResp;
            MessageManager.getInstance().runTask(2921351, null, aVar);
            closeActivity();
        } else if (2 == type && (baseResp instanceof SendMessageToWX.Resp)) {
            SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
            int i2 = resp.errCode;
            String str = resp.errStr;
            if (str == null) {
                str = "";
            }
            Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            intent.putExtra("weixin_result_errCode", i2);
            intent.putExtra("weixin_result_errMsg", str);
            if (i2 == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016450, Boolean.TRUE));
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_SUCCESS);
            } else if (i2 == -2) {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_CANCLE);
            } else if (i2 == 123456) {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
            } else {
                intent.putExtra(WXEntryActivityConfig.KEY_RESULT_WX_SHARE, WXEntryActivityConfig.WX_SHARE_FAIL);
            }
            BdBaseApplication.getInst().sendBroadcast(intent);
            closeActivity();
        }
    }
}

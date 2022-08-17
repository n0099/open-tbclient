package com.baidu.tieba.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.repackage.jr7;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class WXEntryActivity extends BaseActivity<WXEntryActivity> implements IWXAPIEventHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IWXAPI a;
    public Intent b;
    public NavigationBar c;

    public WXEntryActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
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
            setContentView(R.layout.obfuscated_res_0x7f0d04f6);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091c79);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(getResources().getString(R.string.obfuscated_res_0x7f0f0a5c));
            try {
                this.a = WXAPIFactory.createWXAPI(getActivity(), TbConfig.WEIXIN_SHARE_APP_ID, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent intent = getIntent();
            this.b = intent;
            if (intent == null || (iwxapi = this.a) == null) {
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
            this.b = intent;
            if (intent == null || (iwxapi = this.a) == null) {
                return;
            }
            iwxapi.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, baseReq) == null) && baseReq.getType() == 4 && (baseReq instanceof ShowMessageFromWX.Req)) {
            z1((ShowMessageFromWX.Req) baseReq);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, baseResp) == null) || baseResp == null) {
            return;
        }
        int type = baseResp.getType();
        if (1 != type && 19 != type) {
            if (2 == type && (baseResp instanceof SendMessageToWX.Resp)) {
                SendMessageToWX.Resp resp = (SendMessageToWX.Resp) baseResp;
                int i = resp.errCode;
                String str = resp.errStr;
                if (str == null) {
                    str = "";
                }
                Intent intent = new Intent(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
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
                return;
            }
            return;
        }
        jr7 jr7Var = new jr7();
        jr7Var.a = this;
        jr7Var.b = baseResp;
        MessageManager.getInstance().runTask(2921351, null, jr7Var);
        closeActivity();
    }

    public final void z1(ShowMessageFromWX.Req req) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, req) == null) {
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
                if (str.startsWith(BdUniDispatchSchemeController.SCHEME) && BdUniDispatchSchemeController.isUniScheme(Uri.parse(str))) {
                    UtilHelper.dealOneScheme(getPageContext().getPageActivity(), str);
                } else {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
                }
            } finally {
                closeActivity();
            }
        }
    }
}

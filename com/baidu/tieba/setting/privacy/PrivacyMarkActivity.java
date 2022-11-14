package com.baidu.tieba.setting.privacy;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.mj8;
import com.baidu.tieba.py4;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PrivacyMarkActivity extends BaseActivity<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mj8 a;
    public HttpMessageListener b;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivacyMarkActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PrivacyMarkActivity privacyMarkActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privacyMarkActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = privacyMarkActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                String operation = privacySettingMessage.getOperation();
                int type = privacySettingMessage.getType();
                if (httpResponsedMessage.getError() == 0 && !httpResponsedMessage.hasError()) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    py4 k = py4.k();
                    k.w(operation + currentAccount, type);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921499, null));
                    return;
                }
                if (PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE.equals(operation)) {
                    this.a.a.r();
                } else if (PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE.equals(operation)) {
                    this.a.a.s();
                }
                if (httpResponsedMessage.getError() != -1 && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0f56);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                }
            }
        }
    }

    public PrivacyMarkActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.q();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
            int intExtra2 = getIntent().getIntExtra(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
            if (intExtra != 1 && intExtra != 3) {
                intExtra = 1;
            }
            if (intExtra2 != 1 && intExtra2 != 3) {
                intExtra2 = 1;
            }
            mj8 mj8Var = new mj8(getPageContext(), (intExtra << 2) | intExtra2);
            this.a = mj8Var;
            setContentView(mj8Var.o());
            registerListener(this.b);
        }
    }
}

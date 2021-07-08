package com.baidu.tieba.setting.privacy;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.o0.r.d0.b;
/* loaded from: classes4.dex */
public class PrivacyMarkActivity extends BaseActivity<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.z2.e.a privacyMarkView;
    public HttpMessageListener setPrivateHttpListener;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrivacyMarkActivity f20845a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PrivacyMarkActivity privacyMarkActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privacyMarkActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20845a = privacyMarkActivity;
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
                    b j = b.j();
                    j.v(operation + currentAccount, type);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921499, null));
                    return;
                }
                if (PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE.equals(operation)) {
                    this.f20845a.privacyMarkView.m();
                } else if (PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE.equals(operation)) {
                    this.f20845a.privacyMarkView.n();
                }
                if (httpResponsedMessage.getError() != -1 && j.z()) {
                    this.f20845a.showToast(R.string.privacy_setting_failed);
                } else {
                    this.f20845a.showToast(R.string.neterror);
                }
            }
        }
    }

    public PrivacyMarkActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.setPrivateHttpListener = new a(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.privacyMarkView.l();
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
            d.a.p0.z2.e.a aVar = new d.a.p0.z2.e.a(getPageContext(), (intExtra << 2) | intExtra2);
            this.privacyMarkView = aVar;
            setContentView(aVar.j());
            registerListener(this.setPrivateHttpListener);
        }
    }
}

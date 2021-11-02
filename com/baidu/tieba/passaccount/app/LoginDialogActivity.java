package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.e;
import b.a.e.e.m.h;
import b.a.q0.b.d;
import b.a.q0.s.l.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes9.dex */
public class LoginDialogActivity extends SuspendedActivity implements b.a.q0.x0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup contentView;
    public b.a.r0.i2.c.a dialogControl;
    public String dialogType;
    public String locate;
    public ILoginListener loginListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public final a.InterfaceC0685a mReLoginCallback;
    public String operator;
    public String phoneNum;
    public String searchUrl;
    public String shareModelJSONStr;
    public String sign;

    /* loaded from: classes9.dex */
    public class a implements a.InterfaceC0685a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LoginDialogActivity f52042a;

        public a(LoginDialogActivity loginDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52042a = loginDialogActivity;
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                this.f52042a.closeLoadingDialog();
                this.f52042a.showToast(str2);
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f52042a.showLoading();
            }
        }

        @Override // b.a.q0.s.l.a.InterfaceC0685a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                this.f52042a.closeLoadingDialog();
                this.f52042a.onLoginSuccess(accountData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginDialogActivity f52043e;

        public b(LoginDialogActivity loginDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52043e = loginDialogActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.f52043e.searchUrl)) {
                return;
            }
            UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f52043e.getPageContext(), new String[]{this.f52043e.searchUrl});
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f52044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LoginDialogActivity f52045f;

        public c(LoginDialogActivity loginDialogActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52045f = loginDialogActivity;
            this.f52044e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.s.l.c.g(this.f52044e);
                b.a.q0.s.a0.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    public LoginDialogActivity() {
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
        this.mReLoginCallback = new a(this);
    }

    private void continueDoSearchProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            e.a().post(new b(this));
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
            this.phoneNum = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
            this.operator = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
            this.sign = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
            this.searchUrl = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_URL);
            this.locate = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_LOCATE);
            this.dialogType = getIntent().getStringExtra(LoginDialogActivityConfig.LOGIN_DIALOG_DATA_TYPE);
            Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
            if (serializableExtra instanceof ILoginListener) {
                this.loginListener = (ILoginListener) serializableExtra;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginSuccess(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, accountData) == null) {
            saveAccountInfo(accountData);
            b.a.q0.s.a0.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
            TbadkCoreApplication.getInst().onUserChanged(getIntent());
            finishForResult(-1);
            if (d.f()) {
                b.a.q0.a.d.y().r();
            }
            continueDoSearchProcess();
        }
    }

    private void saveAccountInfo(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, accountData) == null) {
            h.a().c(new c(this, accountData));
            b.a.q0.s.a0.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            b.a.q0.m.a.f(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    public void addLoginSuccessLog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getIntent() == null) {
            return;
        }
        DialogLoginHelper.addLoginDialogSuccessLog(this.locate, this.dialogType, str);
    }

    public void finishForResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ILoginListener iLoginListener = this.loginListener;
            if (iLoginListener != null) {
                if (i2 == 0) {
                    iLoginListener.onFail();
                } else if (i2 == -1) {
                    iLoginListener.onSuccess();
                } else {
                    iLoginListener.onCancel();
                }
                this.loginListener = null;
            }
            Intent intent = new Intent();
            intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
            setResult(i2, intent);
            finish();
        }
    }

    public ILoginListener getLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loginListener : (ILoginListener) invokeV.objValue;
    }

    @Override // b.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.r0.i2.c.a aVar = this.dialogControl;
            if (aVar != null) {
                return aVar.getResultIntent();
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public b.a.q0.x0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, linearLayout, navigationBar)) == null) {
            this.contentView = linearLayout;
            navigationBar.setVisibility(8);
            if (getIntent() == null) {
                finish();
                return this;
            }
            initData();
            if (TextUtils.isEmpty(this.shareModelJSONStr)) {
                this.dialogControl = new b.a.r0.i2.c.b(this.phoneNum, this.operator, this.sign);
            } else {
                this.dialogControl = new b.a.r0.i2.c.c(this.shareModelJSONStr);
            }
            this.dialogControl.a(this, linearLayout);
            return this;
        }
        return (b.a.q0.x0.a) invokeLL.objValue;
    }

    @Override // b.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.x0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // b.a.q0.x0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.contentView.setBackgroundResource(R.color.transparent);
            b.a.r0.i2.c.a aVar = this.dialogControl;
            if (aVar != null) {
                aVar.onViewChangeSkinType(i2);
            }
        }
    }

    public void passLoginCancel() {
        ILoginListener iLoginListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iLoginListener = this.loginListener) == null) {
            return;
        }
        iLoginListener.onCancel();
        this.loginListener = null;
    }

    public void passLoginFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            finishForResult(0);
        }
    }

    public void passLoginSucc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.mAccountLoginTask = b.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
                return;
            }
            closeLoadingDialog();
            finishForResult(0);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void showLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || getPageContext() == null) {
            return;
        }
        if (getLoadingDialog() == null || !getLoadingDialog().c()) {
            showLoadingDialog(getPageContext().getString(R.string.sapi_logining));
            if (getLoadingDialog() != null) {
                getLoadingDialog().f(false);
                getLoadingDialog().g(false);
            }
        }
    }
}

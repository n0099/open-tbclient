package com.baidu.tieba.passaccount.app;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
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
import com.repackage.ao7;
import com.repackage.bm4;
import com.repackage.dm4;
import com.repackage.mg;
import com.repackage.mh4;
import com.repackage.ns4;
import com.repackage.pg;
import com.repackage.s85;
import com.repackage.sk4;
import com.repackage.yn7;
import com.repackage.zn7;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class LoginDialogActivity extends SuspendedActivity implements s85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup contentView;
    public yn7 dialogControl;
    public String dialogType;
    public String locate;
    public ILoginListener loginListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public final bm4.a mReLoginCallback;
    public String minePageStatisticKey;
    public String minePageStatisticLocate;
    public String operator;
    public String phoneNum;
    public String searchUrl;
    public String shareModelJSONStr;
    public String sign;

    /* loaded from: classes3.dex */
    public class a implements bm4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginDialogActivity a;

        public a(LoginDialogActivity loginDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginDialogActivity;
        }

        @Override // com.repackage.bm4.a
        public void a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                this.a.closeLoadingDialog();
                this.a.showToast(str2);
            }
        }

        @Override // com.repackage.bm4.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.showLoading();
            }
        }

        @Override // com.repackage.bm4.a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                this.a.closeLoadingDialog();
                this.a.onLoginSuccess(accountData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginDialogActivity a;

        public b(LoginDialogActivity loginDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginDialogActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.a.searchUrl)) {
                return;
            }
            UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{this.a.searchUrl});
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;
        public final /* synthetic */ LoginDialogActivity b;

        public c(LoginDialogActivity loginDialogActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginDialogActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = loginDialogActivity;
            this.a = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dm4.g(this.a);
                ns4.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    public LoginDialogActivity() {
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
        this.mReLoginCallback = new a(this);
    }

    private void continueDoSearchProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            mg.a().post(new b(this));
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
            this.minePageStatisticKey = getIntent().getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_KEY);
            this.minePageStatisticLocate = getIntent().getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE);
            Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
            if (serializableExtra instanceof ILoginListener) {
                this.loginListener = (ILoginListener) serializableExtra;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoginSuccess(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, accountData) == null) {
            saveAccountInfo(accountData);
            ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
            TbadkCoreApplication.getInst().onUserChanged(getIntent());
            finishForResult(-1);
            if (UbsABTestHelper.isBackUserTest()) {
                mh4.x().r();
            }
            continueDoSearchProcess();
        }
    }

    private void saveAccountInfo(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, accountData) == null) {
            pg.a().c(new c(this, accountData));
            ns4.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            sk4.g(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    public void addLoginSuccessLog(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getIntent() == null) {
            return;
        }
        DialogLoginHelper.addLoginDialogSuccessLog(this.locate, this.dialogType, str);
        DialogLoginHelper.addMinePageLoginDialogSuccessLog(this.minePageStatisticKey, this.minePageStatisticLocate);
    }

    public void finishForResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            ILoginListener iLoginListener = this.loginListener;
            if (iLoginListener != null) {
                if (i == 0) {
                    iLoginListener.onFail();
                } else if (i == -1) {
                    iLoginListener.onSuccess();
                } else {
                    iLoginListener.onCancel();
                }
                this.loginListener = null;
            }
            Intent intent = new Intent();
            intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
            setResult(i, intent);
            finish();
        }
    }

    public ILoginListener getLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loginListener : (ILoginListener) invokeV.objValue;
    }

    @Override // com.repackage.s85
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            yn7 yn7Var = this.dialogControl;
            if (yn7Var != null) {
                return yn7Var.getResultIntent();
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public s85 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
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
                this.dialogControl = new zn7(this.phoneNum, this.operator, this.sign);
            } else {
                this.dialogControl = new ao7(this.shareModelJSONStr);
            }
            this.dialogControl.a(this, linearLayout);
            return this;
        }
        return (s85) invokeLL.objValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.repackage.s85
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.contentView.setBackgroundResource(R.color.transparent);
            yn7 yn7Var = this.dialogControl;
            if (yn7Var != null) {
                yn7Var.onViewChangeSkinType(i);
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
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this, true);
            loginActivityConfig.setFrom(getPreExtraPageKey());
            loginActivityConfig.setFromDialog("dialog_fail");
            loginActivityConfig.start();
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
                this.mAccountLoginTask = bm4.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
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
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1027));
            if (getLoadingDialog() != null) {
                getLoadingDialog().f(false);
                getLoadingDialog().g(false);
            }
        }
    }
}

package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.i;
import com.baidu.wallet.paysdk.beans.x;
import com.baidu.wallet.paysdk.datamodel.CheckPwdErrorContent;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public class PwdCheckActivity extends PwdBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_WHAT_IS_PAY_PASSWORD = 56;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public x f26793a;

    /* renamed from: b  reason: collision with root package name */
    public String f26794b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26795c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26796e;

    public PwdCheckActivity() {
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
        this.f26795c = false;
        this.f26796e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, "PwdCheckActivity");
            userInfoBean.setResponseCallback(this);
            userInfoBean.execBean();
        }
    }

    public void forgetPasswd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
            Activity activity = getActivity();
            baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
            this.f26796e = true;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i2 == this.f26793a.getBeanId()) {
                resetPwd();
                if (this.isOpenHalfScreenPwdVerify) {
                    StatisticManager.onEventEnd(StatServiceEvent.CHECK_HALFSCREEN_PASSWORD, i3);
                } else {
                    StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, i3);
                }
                WalletGlobalUtils.safeDismissDialog(this, 0);
                if (i3 == 100018) {
                    this.mDialogMsg = str;
                    hideErrorMsg();
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(this, 17, "");
                } else if (TextUtils.isEmpty(str)) {
                } else {
                    showErrorMsg(str);
                }
            } else if (i2 == 6) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                if (i3 != 100035 && i3 != 100036) {
                    super.handleFailure(i2, i3, str);
                } else {
                    PassUtil.passNormalized(getActivity(), str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PwdCheckActivity f26801a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f26801a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                        public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                                if (super.onNormalize(context, i4, map)) {
                                    this.f26801a.d();
                                    return false;
                                }
                                this.f26801a.finish();
                                return false;
                            }
                            return invokeLIL.booleanValue;
                        }
                    });
                }
            } else if (i2 == 529) {
                resetPwd();
                WalletGlobalUtils.safeDismissDialog(this, 0);
                if (i3 == 100015) {
                    showErrorMsg(str);
                } else if (i3 == 100018) {
                    if (TextUtils.isEmpty(str)) {
                        str = ResUtils.getString(getActivity(), "ebpay_pass_locked_tip");
                    }
                    this.mDialogMsg = str;
                    showErrorMsg(str);
                } else {
                    GlobalUtils.toast(getActivity(), str);
                }
            } else {
                super.handleFailure(i2, i3, str);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            if (i2 != this.f26793a.getBeanId()) {
                if (i2 == 6) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
                    directPayContentResponse.user.decrypt();
                    directPayContentResponse.pay.easypay.decrypt();
                    directPayContentResponse.storeResponse(getActivity());
                    forgetPasswd(this.f26794b);
                    return;
                } else if (i2 == 529) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.INTERMEDIARYPAY_CHECK_PWD_REQUEST, 0);
                    PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
                    GlobalUtils.toast(this, str);
                    finishWithoutAnim();
                    return;
                } else {
                    super.handleResponse(i2, obj, str);
                    return;
                }
            }
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (this.isOpenHalfScreenPwdVerify) {
                StatisticManager.onEventEnd(StatServiceEvent.CHECK_HALFSCREEN_PASSWORD, 0);
            } else {
                StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, 0);
            }
            PwdRequest pwdRequest = this.mPwdRequest;
            if (pwdRequest.mFrom == 2) {
                pwdRequest.mSessionKey = str;
                pwdRequest.mRequestType = 3;
                startActivity(new Intent(getActivity(), PwdSetAndConfirmActivity.class));
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26800a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26800a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f26800a.finishWithoutAnim();
                        }
                    }
                }, 500L);
                return;
            }
            finishWithoutAnim();
            BaiduWalletUtils.startActivityAnim(this);
            if (BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f26794b)) {
                PasswordController.getPassWordInstance().checkPwdSucceed(str);
            } else {
                PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.mPwdRequest.mFrom;
            if (i2 == 1) {
                if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f26794b)) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.INTERMEDIARYPAY_CLICK_CANCLE);
                }
                PasswordController.getPassWordInstance().checkPwdFail(2, "");
            } else if (i2 == 2) {
                PasswordController.getPassWordInstance().editPwdFail(-1, "");
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            if (i2 == 529) {
                resetPwd();
                PayStatisticsUtil.onEventEnd(StatServiceEvent.INTERMEDIARYPAY_CHECK_PWD_REQUEST, i3);
                WalletGlobalUtils.safeDismissDialog(this, 0);
                CheckPwdErrorContent checkPwdErrorContent = null;
                if (obj != null && (obj instanceof CheckPwdErrorContent)) {
                    checkPwdErrorContent = (CheckPwdErrorContent) obj;
                }
                if (checkPwdErrorContent != null && "1".equalsIgnoreCase(checkPwdErrorContent.need_close_page)) {
                    PasswordController.getPassWordInstance().checkPwdFail(i3, str);
                    GlobalUtils.toast(this, str);
                    finishWithoutAnim();
                    return;
                }
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                return;
            }
            resetPwd();
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.mForgetPasswd) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
            c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, bundle) != null) {
            return;
        }
        super.onCreate(bundle);
        getWindow().setSoftInputMode(2);
        if (bundle == null) {
            this.f26794b = getIntent().getStringExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY);
        } else {
            this.f26794b = bundle.getString(SapiAccount.SAPI_ACCOUNT_FROMTYPE);
        }
        this.f26793a = (x) PayBeanFactory.getInstance().getBean((Context) this, getMobilePwdBeanId(), "PwdCheckActivity");
        if (this.mPwdRequest == null) {
            finish();
            return;
        }
        String string = ResUtils.getString(getActivity(), "ebpay_pwd_check_title");
        String string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_verify");
        String str = "ebpay_check_pwd_close_hce";
        if (this.mPwdRequest.mFrom == 2) {
            string = ResUtils.getString(getActivity(), "ebpay_pwd_check_tip_modify_pwd");
            str = "ebpay_check_pwd_modify_pwd";
        } else {
            if (BeanConstants.FROM_PASSFREE_SAVE.equals(this.f26794b)) {
                string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_save");
                str = "ebpay_check_pwd_save";
            } else {
                if (BeanConstants.FROM_UNBIND.equals(this.f26794b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_unbind_card");
                } else if (BeanConstants.FROM_BIND_PAY.equals(this.f26794b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_bind_or_complete_card");
                } else if (BeanConstants.FROM_COMPLETE_PAY.equals(this.f26794b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_complete_pay");
                } else if (!BeanConstants.FROM_BIND.equals(this.f26794b) && !BeanConstants.FROM_COMPLETE.equals(this.f26794b)) {
                    if (BeanConstants.FROM_CLOSE_SHOWCODE.equals(this.f26794b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_close_showcode");
                    } else if (BeanConstants.FROM_FINGERPRINT_PAY.equals(this.f26794b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_tip_save");
                    } else if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f26794b)) {
                        string = ResUtils.getString(getActivity(), "ebpay_intermediarypay_pwdcheck_tip");
                        str = "ebpay_intermediarypay_pwdcheck";
                    } else if (BeanConstants.FROM_CLOSE_HCE.equals(this.f26794b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_close_hce");
                    } else if (BeanConstants.FROM_OPEN_HCE_PAY.equals(this.f26794b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_open_hce");
                    } else if (BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f26794b) && this.isOpenHalfScreenPwdVerify) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_use_explain");
                    }
                    str = "ebpay_check_pwd_close_showcode";
                } else {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_bind_or_complete_card");
                }
                str = "ebpay_check_pwd";
            }
            this.mTip.setText(string);
            if (TextUtils.isEmpty(string2)) {
                this.mSubTip.setText(string2);
                this.mSubTip.setVisibility(0);
            } else {
                this.mSubTip.setVisibility(8);
            }
            initActionBar(str);
            this.mForgetPasswd.setOnClickListener(this);
            this.mSafeEditText.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdCheckActivity f26797a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f26798b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26797a = this;
                    this.f26798b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f26798b) {
                        return;
                    }
                    PayStatisticsUtil.onEvent(StatServiceEvent.CHECK_CLICK_PWD);
                    this.f26798b = true;
                }
            });
            EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            if (this.isOpenHalfScreenPwdVerify) {
                return;
            }
            a();
            b();
            return;
        }
        string2 = "";
        this.mTip.setText(string);
        if (TextUtils.isEmpty(string2)) {
        }
        initActionBar(str);
        this.mForgetPasswd.setOnClickListener(this);
        this.mSafeEditText.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PwdCheckActivity f26797a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f26798b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = objArr;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26797a = this;
                this.f26798b = false;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f26798b) {
                    return;
                }
                PayStatisticsUtil.onEvent(StatServiceEvent.CHECK_CLICK_PWD);
                this.f26798b = true;
            }
        });
        EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        if (this.isOpenHalfScreenPwdVerify) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans("PwdCheckActivity");
            if (this.f26796e) {
                PasswordController.getPassWordInstance().clearForgetPasswdCallback();
            }
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) || event == null) {
            return;
        }
        if (BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
            if (event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                        if (this.mPwdRequest != null) {
                            PayRequestCache.getInstance().addBeanRequestToCache(this.mPwdRequest.getRequestId(), this.mPwdRequest);
                        }
                        int i2 = 0;
                        try {
                            i2 = jSONObject.getInt("is_bind_card");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (1 == i2 && PayRequestCache.getInstance().isPaying()) {
                            new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.10
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ PwdCheckActivity f26799a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f26799a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
                                        BaiduPayDelegate.getInstance().reOrderPay(this.f26799a.getActivity());
                                    }
                                }
                            }, 1000L);
                        }
                        hideErrorMsg();
                        this.f26795c = true;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else if ("ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            if (i2 == 17) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26802a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26802a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdCheckActivity pwdCheckActivity = this.f26802a;
                            pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                            WalletGlobalUtils.safeDismissDialog(this.f26802a, 17);
                            this.f26802a.c();
                        }
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26803a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26803a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdCheckActivity pwdCheckActivity = this.f26803a;
                            pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_know"));
                            WalletGlobalUtils.safeDismissDialog(this.f26803a, 17);
                        }
                    }
                });
            } else if (i2 == 55) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(WalletGlobalUtils.showStr);
                promptDialog2.hideTitle();
                promptDialog2.hideNegativeButton();
                promptDialog2.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26804a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26804a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26804a.mAct, 55);
                        }
                    }
                });
            } else if (i2 != 56) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(ResUtils.string(this, "ebpay_pwd_check_msg_for_halfscreen_pwd_verify"));
                promptDialog3.setTitleText(ResUtils.getString(this, "ebpay_pwd_use_explain") + "？");
                promptDialog3.setCanceledOnTouchOutside(false);
                promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_title_find_pwd"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26805a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26805a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdCheckActivity pwdCheckActivity = this.f26805a;
                            pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                            WalletGlobalUtils.safeDismissDialog(this.f26805a, 56);
                            if (!TextUtils.isEmpty(this.f26805a.f26794b) && BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f26805a.f26794b)) {
                                this.f26805a.f26795c = false;
                                this.f26805a.d();
                                return;
                            }
                            PwdCheckActivity pwdCheckActivity2 = this.f26805a;
                            pwdCheckActivity2.forgetPasswd(pwdCheckActivity2.f26794b);
                        }
                    }
                });
                promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdCheckActivity f26806a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26806a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdCheckActivity pwdCheckActivity = this.f26806a;
                            pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_know"));
                            WalletGlobalUtils.safeDismissDialog(this.f26806a, 56);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 6) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
                if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                    resetPwd();
                    return;
                }
                this.mPwdRequest.mPayPass = getPwd();
                WalletGlobalUtils.safeShowDialog(this, 0, "");
                if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f26794b)) {
                    PayStatisticsUtil.onEventStart(StatServiceEvent.INTERMEDIARYPAY_CHECK_PWD_REQUEST);
                    i iVar = (i) PayBeanFactory.getInstance().getBean((Context) this, 529, "PwdCheckActivity");
                    iVar.setResponseCallback(this);
                    iVar.execBean();
                    return;
                }
                if (this.isOpenHalfScreenPwdVerify) {
                    StatisticManager.onEventStart(StatServiceEvent.CHECK_HALFSCREEN_PASSWORD);
                } else {
                    StatisticManager.onEventStart(StatServiceEvent.CHECK_PASSWORD);
                }
                this.f26793a.setResponseCallback(this);
                if (this.isOpenHalfScreenPwdVerify) {
                    this.f26793a.a(this.extraFromH5);
                    this.f26793a.a(this.isOpenHalfScreenPwdVerify);
                }
                this.f26793a.execBean();
                return;
            }
            this.mErrorTip.setVisibility(4);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString(SapiAccount.SAPI_ACCOUNT_FROMTYPE, this.f26794b);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (safeKeyBoardEditText = this.mSafeEditText) == null) {
                return;
            }
            safeKeyBoardEditText.requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.mSubTipWrap == null) {
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_WHAT_IS_PAY_PASSWORD);
        this.mSubTipWrap.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PwdCheckActivity f26809a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26809a = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                        ViewHelper.setAlpha(this.f26809a.mSubTipWrap, 1.0f);
                        return false;
                    }
                    ViewHelper.setAlpha(this.f26809a.mSubTipWrap, 0.5f);
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
        this.mSubTipWrap.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PwdCheckActivity f26810a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26810a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    WalletGlobalUtils.safeDismissDialog(this.f26810a, 0);
                    WalletGlobalUtils.safeShowDialog(this.f26810a, 56, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if ((TextUtils.isEmpty(this.f26794b) || (!BeanConstants.FROM_B_SAO_C_TYPE.equalsIgnoreCase(this.f26794b) && !BeanConstants.FROM_PASSFREE_SAVE.equalsIgnoreCase(this.f26794b))) && !BeanConstants.FROM_CLOSE_SHOWCODE.equals(this.f26794b) && !BeanConstants.FROM_VOICEPRINT_PAY.equals(this.f26794b) && !BeanConstants.FROM_FINGERPRINT_PAY.equals(this.f26794b) && !BeanConstants.FROM_CLOSE_HCE.equals(this.f26794b) && !BeanConstants.FROM_OPEN_HCE_PAY.equals(this.f26794b) && !BeanConstants.FROM_CHECK_FOR_SP.equals(this.f26794b) && !BeanConstants.FROM_COMMON_CHECK_PWD.equals(this.f26794b) && !BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f26794b) && !this.f26795c) {
                forgetPasswd(this.f26794b);
                return;
            }
            this.f26795c = false;
            d();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.mLeftImageGoback == null) {
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CLOSE_HALFSCREEN_PWD_VERIFY);
        this.mLeftImageGoback.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PwdCheckActivity f26807a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26807a = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                        ViewHelper.setAlpha(this.f26807a.mLeftImageGoback, 1.0f);
                        return false;
                    }
                    ViewHelper.setAlpha(this.f26807a.mLeftImageGoback, 0.5f);
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
        this.mLeftImageGoback.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PwdCheckActivity f26808a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26808a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f26808a.getActivity());
                    this.f26808a.onBackPressed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || TextUtils.isEmpty(BeanConstants.API_VERIFY_MOBILE_PWD_NEW)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(BeanConstants.API_VERIFY_MOBILE_PWD_NEW);
        arrayList.add(str);
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_CLICK_HALFSCREEN_PWD_VERIFY_ALERT_ACTION, arrayList);
    }
}

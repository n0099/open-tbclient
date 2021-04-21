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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
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
    public static final int DIALOG_WHAT_IS_PAY_PASSWORD = 56;

    /* renamed from: a  reason: collision with root package name */
    public x f25839a;

    /* renamed from: b  reason: collision with root package name */
    public String f25840b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25841c = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25842e = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, "PwdCheckActivity");
        userInfoBean.setResponseCallback(this);
        userInfoBean.execBean();
    }

    public void forgetPasswd(String str) {
        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
        Activity activity = getActivity();
        baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
        this.f25842e = true;
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        if (i == this.f25839a.getBeanId()) {
            resetPwd();
            if (this.isOpenHalfScreenPwdVerify) {
                StatisticManager.onEventEnd(StatServiceEvent.CHECK_HALFSCREEN_PASSWORD, i2);
            } else {
                StatisticManager.onEventEnd(StatServiceEvent.CHECK_PASSWORD, i2);
            }
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i2 == 100018) {
                this.mDialogMsg = str;
                hideErrorMsg();
                this.mPayErrorCode = i2;
                this.mBeanId = i;
                WalletGlobalUtils.safeShowDialog(this, 17, "");
            } else if (TextUtils.isEmpty(str)) {
            } else {
                showErrorMsg(str);
            }
        } else if (i == 6) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i2 != 100035 && i2 != 100036) {
                super.handleFailure(i, i2, str);
            } else {
                PassUtil.passNormalized(getActivity(), str, i2 == 100036 ? 2 : 1, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.12
                    @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(Context context, int i3, Map<String, String> map) {
                        if (super.onNormalize(context, i3, map)) {
                            PwdCheckActivity.this.d();
                            return false;
                        }
                        PwdCheckActivity.this.finish();
                        return false;
                    }
                });
            }
        } else if (i == 529) {
            resetPwd();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i2 == 100015) {
                showErrorMsg(str);
            } else if (i2 == 100018) {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(getActivity(), "ebpay_pass_locked_tip");
                }
                this.mDialogMsg = str;
                showErrorMsg(str);
            } else {
                GlobalUtils.toast(getActivity(), str);
            }
        } else {
            super.handleFailure(i, i2, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        if (i != this.f25839a.getBeanId()) {
            if (i == 6) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
                directPayContentResponse.user.decrypt();
                directPayContentResponse.pay.easypay.decrypt();
                directPayContentResponse.storeResponse(getActivity());
                forgetPasswd(this.f25840b);
                return;
            } else if (i == 529) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.INTERMEDIARYPAY_CHECK_PWD_REQUEST, 0);
                PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
                GlobalUtils.toast(this, str);
                finishWithoutAnim();
                return;
            } else {
                super.handleResponse(i, obj, str);
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
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    PwdCheckActivity.this.finishWithoutAnim();
                }
            }, 500L);
            return;
        }
        finishWithoutAnim();
        BaiduWalletUtils.startActivityAnim(this);
        if (BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f25840b)) {
            PasswordController.getPassWordInstance().checkPwdSucceed(str);
        } else {
            PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.mPwdRequest.mFrom;
        if (i == 1) {
            if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f25840b)) {
                PayStatisticsUtil.onEvent(StatServiceEvent.INTERMEDIARYPAY_CLICK_CANCLE);
            }
            PasswordController.getPassWordInstance().checkPwdFail(2, "");
        } else if (i == 2) {
            PasswordController.getPassWordInstance().editPwdFail(-1, "");
        }
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        if (i == 529) {
            resetPwd();
            PayStatisticsUtil.onEventEnd(StatServiceEvent.INTERMEDIARYPAY_CHECK_PWD_REQUEST, i2);
            WalletGlobalUtils.safeDismissDialog(this, 0);
            CheckPwdErrorContent checkPwdErrorContent = null;
            if (obj != null && (obj instanceof CheckPwdErrorContent)) {
                checkPwdErrorContent = (CheckPwdErrorContent) obj;
            }
            if (checkPwdErrorContent != null && "1".equalsIgnoreCase(checkPwdErrorContent.need_close_page)) {
                PasswordController.getPassWordInstance().checkPwdFail(i2, str);
                GlobalUtils.toast(this, str);
                finishWithoutAnim();
                return;
            }
            super.onBeanExecFailureWithErrContent(i, i2, str, obj);
            return;
        }
        resetPwd();
        super.onBeanExecFailureWithErrContent(i, i2, str, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mForgetPasswd) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
            c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(2);
        if (bundle == null) {
            this.f25840b = getIntent().getStringExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY);
        } else {
            this.f25840b = bundle.getString("fromType");
        }
        this.f25839a = (x) PayBeanFactory.getInstance().getBean((Context) this, getMobilePwdBeanId(), "PwdCheckActivity");
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
            if (BeanConstants.FROM_PASSFREE_SAVE.equals(this.f25840b)) {
                string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_save");
                str = "ebpay_check_pwd_save";
            } else {
                if (BeanConstants.FROM_UNBIND.equals(this.f25840b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_unbind_card");
                } else if (BeanConstants.FROM_BIND_PAY.equals(this.f25840b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_bind_or_complete_card");
                } else if (BeanConstants.FROM_COMPLETE_PAY.equals(this.f25840b)) {
                    string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_complete_pay");
                } else if (!BeanConstants.FROM_BIND.equals(this.f25840b) && !BeanConstants.FROM_COMPLETE.equals(this.f25840b)) {
                    if (BeanConstants.FROM_CLOSE_SHOWCODE.equals(this.f25840b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_close_showcode");
                    } else if (BeanConstants.FROM_FINGERPRINT_PAY.equals(this.f25840b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_tip_save");
                    } else if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f25840b)) {
                        string = ResUtils.getString(getActivity(), "ebpay_intermediarypay_pwdcheck_tip");
                        str = "ebpay_intermediarypay_pwdcheck";
                    } else if (BeanConstants.FROM_CLOSE_HCE.equals(this.f25840b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_close_hce");
                    } else if (BeanConstants.FROM_OPEN_HCE_PAY.equals(this.f25840b)) {
                        string2 = ResUtils.getString(getActivity(), "ebpay_pwd_check_sub_tip_for_open_hce");
                    } else if (BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f25840b) && this.isOpenHalfScreenPwdVerify) {
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
            this.mSafeEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.1

                /* renamed from: b  reason: collision with root package name */
                public boolean f25844b = false;

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (this.f25844b) {
                        return;
                    }
                    PayStatisticsUtil.onEvent(StatServiceEvent.CHECK_CLICK_PWD);
                    this.f25844b = true;
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
        this.mSafeEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.1

            /* renamed from: b  reason: collision with root package name */
            public boolean f25844b = false;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.f25844b) {
                    return;
                }
                PayStatisticsUtil.onEvent(StatServiceEvent.CHECK_CLICK_PWD);
                this.f25844b = true;
            }
        });
        EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        if (this.isOpenHalfScreenPwdVerify) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans("PwdCheckActivity");
        if (this.f25842e) {
            PasswordController.getPassWordInstance().clearForgetPasswdCallback();
        }
        EventBus.getInstance().unregister(this);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        if (event != null) {
            if (BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
                if (event.mEventObj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                        if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                            if (this.mPwdRequest != null) {
                                PayRequestCache.getInstance().addBeanRequestToCache(this.mPwdRequest.getRequestId(), this.mPwdRequest);
                            }
                            int i = 0;
                            try {
                                i = jSONObject.getInt("is_bind_card");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (1 == i && PayRequestCache.getInstance().isPaying()) {
                                new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.10
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
                                        BaiduPayDelegate.getInstance().reOrderPay(PwdCheckActivity.this.getActivity());
                                    }
                                }, 1000L);
                            }
                            hideErrorMsg();
                            this.f25841c = true;
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i == 17) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 17);
                    PwdCheckActivity.this.c();
                }
            });
            promptDialog.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 17);
                }
            });
        } else if (i == 55) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(WalletGlobalUtils.showStr);
            promptDialog2.hideTitle();
            promptDialog2.hideNegativeButton();
            promptDialog2.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this.mAct, 55);
                }
            });
        } else if (i != 56) {
            super.onPrepareDialog(i, dialog);
        } else {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(ResUtils.string(this, "ebpay_pwd_check_msg_for_halfscreen_pwd_verify"));
            promptDialog3.setTitleText(ResUtils.getString(this, "ebpay_pwd_use_explain") + "？");
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_title_find_pwd"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 56);
                    if (!TextUtils.isEmpty(PwdCheckActivity.this.f25840b) && BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(PwdCheckActivity.this.f25840b)) {
                        PwdCheckActivity.this.f25841c = false;
                        PwdCheckActivity.this.d();
                        return;
                    }
                    PwdCheckActivity pwdCheckActivity2 = PwdCheckActivity.this;
                    pwdCheckActivity2.forgetPasswd(pwdCheckActivity2.f25840b);
                }
            });
            promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 56);
                }
            });
        }
    }

    @Override // com.baidu.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i) {
        if (i == 6) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
            if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                resetPwd();
                return;
            }
            this.mPwdRequest.mPayPass = getPwd();
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (BeanConstants.FROM_CHECK_FOR_SP.equals(this.f25840b)) {
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
            this.f25839a.setResponseCallback(this);
            if (this.isOpenHalfScreenPwdVerify) {
                this.f25839a.a(this.extraFromH5);
                this.f25839a.a(this.isOpenHalfScreenPwdVerify);
            }
            this.f25839a.execBean();
            return;
        }
        this.mErrorTip.setVisibility(4);
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.paysdk.ui.PwdBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fromType", this.f25840b);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (!z || (safeKeyBoardEditText = this.mSafeEditText) == null) {
            return;
        }
        safeKeyBoardEditText.requestFocus();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
    }

    private void b() {
        if (this.mSubTipWrap == null) {
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_WHAT_IS_PAY_PASSWORD);
        this.mSubTipWrap.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                    ViewHelper.setAlpha(PwdCheckActivity.this.mSubTipWrap, 1.0f);
                    return false;
                }
                ViewHelper.setAlpha(PwdCheckActivity.this.mSubTipWrap, 0.5f);
                return false;
            }
        });
        this.mSubTipWrap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 0);
                WalletGlobalUtils.safeShowDialog(PwdCheckActivity.this, 56, "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if ((TextUtils.isEmpty(this.f25840b) || (!BeanConstants.FROM_B_SAO_C_TYPE.equalsIgnoreCase(this.f25840b) && !BeanConstants.FROM_PASSFREE_SAVE.equalsIgnoreCase(this.f25840b))) && !BeanConstants.FROM_CLOSE_SHOWCODE.equals(this.f25840b) && !BeanConstants.FROM_VOICEPRINT_PAY.equals(this.f25840b) && !BeanConstants.FROM_FINGERPRINT_PAY.equals(this.f25840b) && !BeanConstants.FROM_CLOSE_HCE.equals(this.f25840b) && !BeanConstants.FROM_OPEN_HCE_PAY.equals(this.f25840b) && !BeanConstants.FROM_CHECK_FOR_SP.equals(this.f25840b) && !BeanConstants.FROM_COMMON_CHECK_PWD.equals(this.f25840b) && !BeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.f25840b) && !this.f25841c) {
            forgetPasswd(this.f25840b);
            return;
        }
        this.f25841c = false;
        d();
    }

    private void a() {
        if (this.mLeftImageGoback == null) {
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CLOSE_HALFSCREEN_PWD_VERIFY);
        this.mLeftImageGoback.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                    ViewHelper.setAlpha(PwdCheckActivity.this.mLeftImageGoback, 1.0f);
                    return false;
                }
                ViewHelper.setAlpha(PwdCheckActivity.this.mLeftImageGoback, 0.5f);
                return false;
            }
        });
        this.mLeftImageGoback.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PwdCheckActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GlobalUtils.hideKeyboard(PwdCheckActivity.this.getActivity());
                PwdCheckActivity.this.onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(BeanConstants.API_VERIFY_MOBILE_PWD_NEW)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(BeanConstants.API_VERIFY_MOBILE_PWD_NEW);
        arrayList.add(str);
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_CLICK_HALFSCREEN_PWD_VERIFY_ALERT_ACTION, arrayList);
    }
}

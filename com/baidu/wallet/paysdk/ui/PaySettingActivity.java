package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.PaySetListBean;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.ac;
import com.baidu.wallet.paysdk.datamodel.PaySetResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.datamodel.RiskControlResponseForNoPwd;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.NonePayingProcess;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.SwitchButton;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class PaySettingActivity extends PayBaseBeanActivity implements View.OnClickListener, NonePayingProcess {
    public static final String APPLY_SUCCESS = "apply_success";
    public static final int DIALOG_FINGERPRINT_SETPASSWORD = 50;
    public static final int ERROR_CODE_GO_TO_AUTH = 5140;
    public static final String OPENED = "opened";
    public static final String PHONE = "phone";
    public static final String PWD = "pwd";
    public static a m;
    public PaySetResponse A;
    public View B;
    public TextView E;
    public TextView F;

    /* renamed from: a  reason: collision with root package name */
    public TextView f25924a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25925b;

    /* renamed from: c  reason: collision with root package name */
    public View f25926c;

    /* renamed from: d  reason: collision with root package name */
    public View f25927d;

    /* renamed from: e  reason: collision with root package name */
    public View f25928e;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f25930g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25931h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f25932i;
    public SwitchButton j;
    public PaySetResponse.Paymethod_info k;
    public boolean r;
    public TextView x;
    public String y;
    public RiskControlResponseForNoPwd z;

    /* renamed from: f  reason: collision with root package name */
    public final String f25929f = PaySettingActivity.class.getSimpleName();
    public boolean l = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public int s = 0;
    public final int t = 0;
    public final int u = 1;
    public boolean v = false;
    public boolean w = false;
    public boolean C = false;
    public boolean D = false;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    private void g() {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            return;
        }
        PasswordController.getPassWordInstance().setPasswdByUser(getActivity(), new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.3
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str) {
                PaySettingActivity.this.h();
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str) {
                PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                if (pwdRequest == null) {
                    PaySettingActivity.this.h();
                } else {
                    PaySettingActivity.this.b(pwdRequest.mPayPass);
                }
            }
        });
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i2 = this.s;
        if (i2 == 0) {
            toast(getActivity(), "bd_wallet_fingerprint_reg_failed", false);
        } else if (i2 == 1) {
            toast(getActivity(), "ebpay_setting_fail", false);
        }
    }

    public static void setPaySettingChangeListener(a aVar) {
        m = aVar;
    }

    public static void toast(Context context, String str, boolean z) {
        TextView textView;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        String string = ResUtils.getString(context, str);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int drawable = ResUtils.drawable(context, z ? "wallet_base_setting_icon_win_white" : "wallet_base_setting_icon_lose_white");
        Context applicationContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(applicationContext).inflate(ResUtils.layout(applicationContext, "wallet_base_setting_toast"), (ViewGroup) null);
        if (inflate == null || (textView = (TextView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_message"))) == null) {
            return;
        }
        textView.setText(string);
        ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_icon"));
        if (imageView != null && drawable > 0) {
            imageView.setImageResource(drawable);
            imageView.setVisibility(0);
        }
        Toast toast = new Toast(applicationContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public void gotoSaveFreePay(boolean z) {
        if (z) {
            if (this.r) {
                f();
                return;
            }
            this.s = 1;
            WalletGlobalUtils.safeShowDialog(this, 50, "");
            return;
        }
        a(false);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i3 != 5140 && i2 != 531) {
            if (i3 != 100035 && i3 != 100036) {
                super.handleFailure(i2, i3, str);
            } else if (this.D) {
                return;
            } else {
                this.D = true;
                PassUtil.passNormalized(getActivity(), str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.7
                    @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                        PaySettingActivity.this.D = false;
                        if (super.onNormalize(context, i4, map)) {
                            PaySettingActivity.this.a();
                            PaySettingActivity.this.d();
                        } else {
                            PaySettingActivity.this.finish();
                        }
                        return false;
                    }
                });
                return;
            }
        }
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i2 == 576) {
            toast(getActivity(), "ebpay_setting_fail", false);
        } else if (i2 == 1) {
            c(false);
        } else if (i2 != 6) {
            if (i2 == 531) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 3, "");
            }
        } else if (i3 == 5140 || i3 == 5139) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_from", "3");
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, i3 == 5140 ? "9" : "0");
            BaiduPayDelegate.getInstance().doRNAuth(getActivity(), hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.9
                @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                public void onRNAuthResult(int i4, String str2) {
                    if (i4 == 0) {
                        PaySettingActivity.this.d();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this, -1);
        if (i2 == 544) {
            PaySetResponse paySetResponse = (PaySetResponse) obj;
            if (paySetResponse != null) {
                this.A = paySetResponse;
                this.f25931h.setText(ResUtils.string(getActivity(), "ebpay_personal_settings"));
                PaySetResponse.Fingerprint fingerprint = paySetResponse.fingerprint;
                if (fingerprint != null) {
                    a(fingerprint);
                }
                this.r = paySetResponse.passfree_info.has_mobile_pwd == 1;
                a(paySetResponse.passfree_info);
                b(paySetResponse);
                a(paySetResponse);
                if ("tieba".equalsIgnoreCase(com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID)) {
                    return;
                }
                a(paySetResponse.facepay_url);
            }
        } else if (i2 == 576) {
            toast(getActivity(), "ebpay_setting_suc", true);
            SwitchButton switchButton = this.j;
            switchButton.setChecked(!switchButton.isChecked());
        } else if (i2 == 6) {
            g();
            this.r = PayDataCache.getInstance().hasMobilePwd();
        } else if (i2 == 531) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            RiskControlResponseForNoPwd riskControlResponseForNoPwd = (RiskControlResponseForNoPwd) obj;
            this.z = riskControlResponseForNoPwd;
            if (riskControlResponseForNoPwd.checkResponseValidity()) {
                if (this.z.isNeedSms()) {
                    this.y = this.z.mobile;
                }
                a(true);
                return;
            }
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "fp_get_data_fail"));
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 8 && i3 == 100) {
            a();
            this.l = true;
        }
        if (1 == i2 && -1 == i3) {
            b(intent.getBooleanExtra(APPLY_SUCCESS, true));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PaySetResponse.Paymethod_info paymethod_info;
        PaySetResponse.PayInfoBean[] payInfoBeanArr;
        if (view.getId() != ResUtils.id(this, "layout_pay_sort") || (paymethod_info = this.k) == null || (payInfoBeanArr = paymethod_info.sorted_list) == null || payInfoBeanArr.length == 0) {
            return;
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_PAY_SEQUENCE);
        if (NetworkUtils.isNetworkAvailable(this)) {
            PaySetResponse.Paymethod_info paymethod_info2 = this.k;
            startActivityForResult(PaySortSettingActivity.getStartIntent(this, paymethod_info2.sorted_list, paymethod_info2.paymethod_type), 8);
            return;
        }
        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_setting_activity"));
        if (bundle != null) {
            this.A = (PaySetResponse) bundle.getSerializable("paysetresponse");
        }
        initActionBar("bd_wallet_pay_setting");
        b();
        c();
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(this.f25929f);
        boolean z = (!this.l && this.p == this.f25932i.isChecked() && this.o == this.j.isChecked()) ? false : true;
        a aVar = m;
        if (aVar != null) {
            aVar.a(z);
        }
        m = null;
        if (this.v) {
            PasswordController.getPassWordInstance().clearBindCardCallback();
        }
        if (this.w) {
            PasswordController.getPassWordInstance().clearCheckPwdListener();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 50) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setCancelable(true);
            int string = ResUtils.string(getActivity(), "bd_wallet_fingerprint_no_pwd_tips");
            if (this.s == 1) {
                string = ResUtils.string(getActivity(), "bd_wallet_passfree_no_pwd_tips");
            }
            int string2 = ResUtils.string(getActivity(), "bd_wallet_fingerprint_set_pwd");
            promptDialog.setMessage(string);
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PaySettingActivity.this, 50);
                }
            });
            promptDialog.setPositiveBtn(string2, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PaySettingActivity.this, 50);
                    PaySettingActivity.this.d();
                }
            });
        } else if (12 == i2) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(ResUtils.string(getActivity(), "bd_wallet_fingerprint_close_tip"));
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PaySettingActivity.this, 12);
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PaySettingActivity.this, 12);
                }
            });
        } else if (3 == i2) {
            final PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(this.mDialogMsg);
            promptDialog3.hideNegativeButton();
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    promptDialog3.dismiss();
                }
            });
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.C) {
            this.C = false;
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("paysetresponse", this.A);
        super.onSaveInstanceState(bundle);
    }

    public void register() {
        final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this).getFingerprintPay();
        if (fingerprintPay == null) {
            GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
        } else {
            fingerprintPay.open(getActivity(), new FingerprintCallback() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.17
                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    if (i2 == 0) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_SUCCESS);
                        PaySettingActivity.toast(PaySettingActivity.this.getActivity(), "wallet_fp_open_success", true);
                        PaySettingActivity.this.a();
                    } else if (i2 == 1) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_CANCLE);
                    } else if (i2 == 2) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_FAILED);
                        if (TextUtils.isEmpty(str)) {
                            str = ResUtils.getString(PaySettingActivity.this.getActivity(), "wallet_fp_try_too_many_times_try_later");
                        }
                        GlobalUtils.toast(PaySettingActivity.this.getActivity(), str, 1);
                    }
                    fingerprintPay.destory();
                }
            });
        }
    }

    public void setFingerPaySwitch(boolean z) {
        PaySetResponse.Fingerprint fingerprint;
        if (z) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_CLICK);
            if (!WalletFingerprint.getInstance(getActivity()).hasEnrollFingerprint()) {
                e();
                return;
            } else if (!this.r) {
                this.s = 0;
                WalletGlobalUtils.safeShowDialog(this, 50, "");
                return;
            } else {
                register();
                return;
            }
        }
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_CLOSE_CLICK);
        WalletFingerprint.FpType fpType = null;
        PaySetResponse paySetResponse = this.A;
        if (paySetResponse != null && (fingerprint = paySetResponse.fingerprint) != null && fingerprint.user_reg == 1) {
            if (fingerprint.is_otp == 1) {
                fpType = WalletFingerprint.FpType.SYSTEM_FINGERPRINT;
            } else {
                fpType = WalletFingerprint.FpType.FIDO_FINGERPRINT;
            }
        }
        final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this).getFingerprintPay(fpType);
        if (fingerprintPay != null) {
            fingerprintPay.close(getActivity(), new FingerprintCallback() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.8
                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    if (i2 == 0) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_CLOSE_SUCCESS);
                        PaySettingActivity.toast(PaySettingActivity.this.getActivity(), "wallet_fp_close_succ", true);
                        PaySettingActivity.this.e(false);
                    } else {
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_CLOSE_FAILED);
                        PaySettingActivity.toast(PaySettingActivity.this.getActivity(), "wallet_fp_close_failed", false);
                    }
                    fingerprintPay.destory();
                }
            });
        } else {
            GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, this.f25929f);
        if (this.s == 0) {
            userInfoBean.setCheckPrePassSign(1, "3");
        }
        userInfoBean.setResponseCallback(this);
        userInfoBean.execBean();
        WalletGlobalUtils.safeShowDialog(this, -1, "");
    }

    private void e() {
        final PromptDialog promptDialog = new PromptDialog(this.mAct);
        promptDialog.setTitleText(ResUtils.getString(getActivity(), "bd_wallet_fingerprint_enable_dialog_title"));
        promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                promptDialog.dismiss();
            }
        });
        promptDialog.hideMessage();
        promptDialog.hideNegativeButton();
        promptDialog.show();
    }

    private void f() {
        BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD, this.f25929f);
        bean.setResponseCallback(this);
        bean.execBean();
        WalletGlobalUtils.safeShowDialog(this, 0, "");
    }

    private void c() {
        this.f25930g.setOnClickListener(this);
        this.j.setOnCheckedListener(new SwitchButton.a() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.1
            @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
            public void a(boolean z) {
                LogUtil.d("switch_btn" + z);
                if (z) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_OPEN_FREE_PASS);
                } else {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLOSE_FREE_PASS);
                }
                PaySettingActivity.this.j.setChecked(!z);
                if (NetworkUtils.isNetworkAvailable(PaySettingActivity.this)) {
                    PaySettingActivity.this.gotoSaveFreePay(z);
                } else {
                    GlobalUtils.toast(PaySettingActivity.this.getActivity(), ResUtils.getString(PaySettingActivity.this.getActivity(), "ebpay_no_network"));
                }
            }
        });
        this.f25932i.setOnCheckedListener(new SwitchButton.a() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.10
            @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
            public void a(boolean z) {
                if (!NetworkUtils.isNetworkAvailable(PaySettingActivity.this.getActivity())) {
                    GlobalUtils.toast(PaySettingActivity.this.getActivity(), ResUtils.getString(PaySettingActivity.this.getActivity(), "ebpay_no_network"));
                    return;
                }
                LogUtil.d("switch_btn" + z);
                if (z) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINGERPRINT_REGISTER);
                } else {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINGER_UNREGISTER);
                }
                PaySettingActivity.this.setFingerPaySwitch(z);
            }
        });
    }

    private void b() {
        this.f25924a = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_payfree_tips"));
        this.f25925b = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_payfree_url"));
        this.E = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_finger_tips"));
        this.F = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_finger_url"));
        this.f25926c = findViewById(ResUtils.id(this, "bd_wallet_switch_fingerfree"));
        this.f25927d = findViewById(ResUtils.id(this, "bd_wallet_divider_finger"));
        this.f25928e = findViewById(ResUtils.id(this, "bd_wallet_divider_finger_below"));
        this.f25930g = (RelativeLayout) findViewById(ResUtils.id(this, "layout_pay_sort"));
        this.f25931h = (TextView) findViewById(ResUtils.id(this, "tv_pay_sort"));
        this.j = (SwitchButton) findViewById(ResUtils.id(this, "switch_btn_litterpay"));
        this.f25932i = (SwitchButton) findViewById(ResUtils.id(this, "switch_btn_fingerpay"));
        this.x = (TextView) findViewById(ResUtils.id(this, "label_pass_free"));
        this.B = findViewById(ResUtils.id(this, "bd_wallet_face_pay_layout"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        PaySetListBean paySetListBean = (PaySetListBean) PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_PAY_SETTING, this.f25929f);
        paySetListBean.setResponseCallback(this);
        paySetListBean.execBean();
        WalletGlobalUtils.safeShowDialog(this, -1, "");
    }

    private void c(boolean z) {
        if (this.f25926c == null) {
            return;
        }
        int i2 = z ? 0 : 8;
        this.f25926c.setVisibility(i2);
        this.f25927d.setVisibility(i2);
        this.f25928e.setVisibility(i2);
        if (this.E == null) {
            return;
        }
        d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        this.f25932i.setChecked(z);
    }

    private void a(boolean z) {
        if (z) {
            PasswordController.getPassWordInstance().checkPwd(this, BeanConstants.FROM_PASSFREE_SAVE, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.2
                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    if (i2 == 2) {
                        return;
                    }
                    LogUtil.e("gq", "errorcode" + i2, null);
                    PaySettingActivity.toast(PaySettingActivity.this.getActivity(), "ebpay_setting_fail", false);
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    if (PaySettingActivity.this.z == null || !PaySettingActivity.this.z.isNeedSms()) {
                        PaySettingActivity.this.b(true, str);
                    } else {
                        PaySettingActivity.this.a(true, str);
                    }
                }
            });
            this.w = true;
            return;
        }
        b(false, "");
    }

    private void d(boolean z) {
        PaySetResponse paySetResponse;
        PaySetResponse.Fingerprint fingerprint;
        PaySetResponse.FingerprintProtocol fingerprintProtocol;
        if (z && (paySetResponse = this.A) != null && (fingerprint = paySetResponse.fingerprint) != null && (fingerprintProtocol = fingerprint.fingerprint_protocol) != null) {
            if (!TextUtils.isEmpty(fingerprintProtocol.fingerprint_protocol_prefix)) {
                this.E.setText(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_prefix);
                this.E.setVisibility(0);
                if (!TextUtils.isEmpty(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_msg) && !TextUtils.isEmpty(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_url)) {
                    this.F.setText(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_msg);
                    this.F.setVisibility(0);
                    this.F.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            PaySettingActivity paySettingActivity = PaySettingActivity.this;
                            baiduWalletDelegate.openH5Module(paySettingActivity, paySettingActivity.A.fingerprint.fingerprint_protocol.fingerprint_protocol_url, false);
                        }
                    });
                    return;
                }
                this.E.setVisibility(8);
                this.F.setVisibility(8);
                return;
            }
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            return;
        }
        this.E.setVisibility(8);
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        Intent intent = new Intent(this, WalletSmsActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 9);
        intent.putExtra("phone", this.y);
        intent.putExtra(OPENED, z);
        intent.putExtra(PWD, str);
        startActivityForResultWithoutAnim(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, String str) {
        ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, this.f25929f);
        String seed = PasswordController.getSeed();
        acVar.a(PasswordController.handlePwd(str, seed), SafePay.getInstance().encryptProxy(seed), z ? "1" : "2", "20000");
        acVar.setResponseCallback(this);
        acVar.execBean();
        WalletGlobalUtils.safeShowDialog(this, -1, "");
    }

    private void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.B.setVisibility(0);
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PaySettingActivity.this.C = true;
                    BaiduWalletDelegate.getInstance().openH5Module(PaySettingActivity.this.getActivity(), str, true);
                }
            });
            return;
        }
        this.B.setVisibility(8);
    }

    private void a(PaySetResponse.Fingerprint fingerprint) {
        if (fingerprint.device_support == 1) {
            c(true);
        } else {
            c(false);
        }
        if (fingerprint.user_reg == 1) {
            if (fingerprint.is_otp == 1 && WalletFingerprint.getInstance(getActivity()).hasOTPToken()) {
                e(true);
            } else if (fingerprint.is_otp != 1) {
                e(true);
            } else {
                e(false);
            }
        } else {
            e(false);
        }
        if (this.q) {
            return;
        }
        this.q = true;
        this.p = this.f25932i.isChecked();
    }

    private void b(boolean z) {
        toast(getActivity(), z ? "ebpay_setting_suc" : "ebpay_setting_fail", z);
        if (z) {
            SwitchButton switchButton = this.j;
            switchButton.setChecked(!switchButton.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.r = true;
        int i2 = this.s;
    }

    private void b(PaySetResponse paySetResponse) {
        PaySetResponse.Paymethod_info paymethod_info;
        PaySetResponse.PayInfoBean[] payInfoBeanArr;
        if (paySetResponse == null || (paymethod_info = paySetResponse.paymethod_info) == null || (payInfoBeanArr = paymethod_info.sorted_list) == null || payInfoBeanArr.length <= 0) {
            return;
        }
        this.k = paymethod_info;
    }

    private void a(final PaySetResponse paySetResponse) {
        PaySetResponse.PayFreeInfo payFreeInfo;
        PaySetResponse.PassFreeProtocol passFreeProtocol;
        PaySetResponse.PayFreeInfo payFreeInfo2;
        PaySetResponse.PassFreeProtocol passFreeProtocol2;
        if (paySetResponse != null && (payFreeInfo = paySetResponse.passfree_info) != null && (passFreeProtocol = payFreeInfo.passfree_protocol) != null && !TextUtils.isEmpty(passFreeProtocol.passfree_protocol_prefix)) {
            this.f25924a.setText(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_prefix);
            this.f25924a.setVisibility(8);
            if (paySetResponse != null && (payFreeInfo2 = paySetResponse.passfree_info) != null && (passFreeProtocol2 = payFreeInfo2.passfree_protocol) != null && !TextUtils.isEmpty(passFreeProtocol2.passfree_protocol_url) && !TextUtils.isEmpty(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_msg)) {
                this.f25925b.setText(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_msg);
                this.f25925b.setVisibility(8);
                this.f25925b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BaiduWalletDelegate.getInstance().openH5Module(PaySettingActivity.this, paySetResponse.passfree_info.passfree_protocol.passfree_protocol_url, false);
                    }
                });
                return;
            }
            this.f25924a.setVisibility(8);
            this.f25925b.setVisibility(8);
            return;
        }
        this.f25924a.setVisibility(8);
        this.f25925b.setVisibility(8);
    }

    private void a(PaySetResponse.PayFreeInfo payFreeInfo) {
        if (payFreeInfo != null && payFreeInfo.passfree_flag == 1) {
            this.j.setChecked(true);
        } else {
            this.j.setChecked(false);
        }
        if (!this.n) {
            this.n = true;
            this.o = this.j.isChecked();
        }
        String string = ResUtils.getString(getActivity(), "ebpay_no_pass_pay");
        if (payFreeInfo != null && !TextUtils.isEmpty(payFreeInfo.passfree_button_msg)) {
            string = payFreeInfo.passfree_button_msg;
        }
        this.x.setText(string);
    }
}

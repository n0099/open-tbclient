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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPLY_SUCCESS = "apply_success";
    public static final int DIALOG_FINGERPRINT_SETPASSWORD = 50;
    public static final int ERROR_CODE_GO_TO_AUTH = 5140;
    public static final String OPENED = "opened";
    public static final String PHONE = "phone";
    public static final String PWD = "pwd";
    public static a m;
    public transient /* synthetic */ FieldHolder $fh;
    public PaySetResponse A;
    public View B;
    public boolean C;
    public boolean D;
    public TextView E;
    public TextView F;

    /* renamed from: a  reason: collision with root package name */
    public TextView f26735a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26736b;

    /* renamed from: c  reason: collision with root package name */
    public View f26737c;

    /* renamed from: d  reason: collision with root package name */
    public View f26738d;

    /* renamed from: e  reason: collision with root package name */
    public View f26739e;

    /* renamed from: f  reason: collision with root package name */
    public final String f26740f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26741g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26742h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchButton f26743i;
    public SwitchButton j;
    public PaySetResponse.Paymethod_info k;
    public boolean l;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public final int t;
    public final int u;
    public boolean v;
    public boolean w;
    public TextView x;
    public String y;
    public RiskControlResponseForNoPwd z;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public PaySettingActivity() {
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
        this.f26740f = PaySettingActivity.class.getSimpleName();
        this.l = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = 0;
        this.t = 0;
        this.u = 1;
        this.v = false;
        this.w = false;
        this.C = false;
        this.D = false;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || PayDataCache.getInstance().hasMobilePwd()) {
            return;
        }
        PasswordController.getPassWordInstance().setPasswdByUser(getActivity(), new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PaySettingActivity f26755a;

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
                this.f26755a = this;
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    this.f26755a.h();
                }
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                    if (pwdRequest == null) {
                        this.f26755a.h();
                    } else {
                        this.f26755a.b(pwdRequest.mPayPass);
                    }
                }
            }
        });
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            int i2 = this.s;
            if (i2 == 0) {
                toast(getActivity(), "bd_wallet_fingerprint_reg_failed", false);
            } else if (i2 == 1) {
                toast(getActivity(), "ebpay_setting_fail", false);
            }
        }
    }

    public static void setPaySettingChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, aVar) == null) {
            m = aVar;
        }
    }

    public static void toast(Context context, String str, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65571, null, context, str, z) == null) || context == null || TextUtils.isEmpty(str)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
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
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 != 5140 && i2 != 531) {
                if (i3 != 100035 && i3 != 100036) {
                    super.handleFailure(i2, i3, str);
                } else if (this.D) {
                    return;
                } else {
                    this.D = true;
                    PassUtil.passNormalized(getActivity(), str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PaySettingActivity f26761a;

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
                            this.f26761a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                        public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, context, i4, map)) == null) {
                                this.f26761a.D = false;
                                if (super.onNormalize(context, i4, map)) {
                                    this.f26761a.a();
                                    this.f26761a.d();
                                } else {
                                    this.f26761a.finish();
                                }
                                return false;
                            }
                            return invokeLIL.booleanValue;
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
                BaiduPayDelegate.getInstance().doRNAuth(getActivity(), hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26762a;

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
                        this.f26762a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) && i4 == 0) {
                            this.f26762a.d();
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            if (i2 == 544) {
                PaySetResponse paySetResponse = (PaySetResponse) obj;
                if (paySetResponse != null) {
                    this.A = paySetResponse;
                    this.f26742h.setText(ResUtils.string(getActivity(), "ebpay_personal_settings"));
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
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 8 && i3 == 100) {
                a();
                this.l = true;
            }
            if (1 == i2 && -1 == i3) {
                b(intent.getBooleanExtra(APPLY_SUCCESS, true));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PaySetResponse.Paymethod_info paymethod_info;
        PaySetResponse.PayInfoBean[] payInfoBeanArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || view.getId() != ResUtils.id(this, "layout_pay_sort") || (paymethod_info = this.k) == null || (payInfoBeanArr = paymethod_info.sorted_list) == null || payInfoBeanArr.length == 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(this.f26740f);
            boolean z = (!this.l && this.p == this.f26743i.isChecked() && this.o == this.j.isChecked()) ? false : true;
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, dialog) == null) {
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
                promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26746a;

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
                        this.f26746a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26746a, 50);
                        }
                    }
                });
                promptDialog.setPositiveBtn(string2, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26747a;

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
                        this.f26747a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26747a, 50);
                            this.f26747a.d();
                        }
                    }
                });
            } else if (12 == i2) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(ResUtils.string(getActivity(), "bd_wallet_fingerprint_close_tip"));
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26748a;

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
                        this.f26748a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26748a, 12);
                        }
                    }
                });
                promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26749a;

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
                        this.f26749a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26749a, 12);
                        }
                    }
                });
            } else if (3 == i2) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.hideNegativeButton();
                promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f26750a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26751b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26751b = this;
                        this.f26750a = promptDialog3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26750a.dismiss();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (this.C) {
                this.C = false;
                a();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            bundle.putSerializable("paysetresponse", this.A);
            super.onSaveInstanceState(bundle);
        }
    }

    public void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this).getFingerprintPay();
            if (fingerprintPay == null) {
                GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
            } else {
                fingerprintPay.open(getActivity(), new FingerprintCallback(this, fingerprintPay) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PaySettingActivity this$0;
                    public final /* synthetic */ IFingerprintPay val$fingerprintPay;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fingerprintPay};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$fingerprintPay = fingerprintPay;
                    }

                    @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                    public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                            if (i2 == 0) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_SUCCESS);
                                PaySettingActivity.toast(this.this$0.getActivity(), "wallet_fp_open_success", true);
                                this.this$0.a();
                            } else if (i2 == 1) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_CANCLE);
                            } else if (i2 == 2) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_OPEN_FAILED);
                                if (TextUtils.isEmpty(str)) {
                                    str = ResUtils.getString(this.this$0.getActivity(), "wallet_fp_try_too_many_times_try_later");
                                }
                                GlobalUtils.toast(this.this$0.getActivity(), str, 1);
                            }
                            this.val$fingerprintPay.destory();
                        }
                    }
                });
            }
        }
    }

    public void setFingerPaySwitch(boolean z) {
        PaySetResponse.Fingerprint fingerprint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
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
            IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this).getFingerprintPay(fpType);
            if (fingerprintPay != null) {
                fingerprintPay.close(getActivity(), new FingerprintCallback(this, fingerprintPay) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PaySettingActivity this$0;
                    public final /* synthetic */ IFingerprintPay val$fingerprintPay;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fingerprintPay};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$fingerprintPay = fingerprintPay;
                    }

                    @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                    public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                            if (i2 == 0) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_CLOSE_SUCCESS);
                                PaySettingActivity.toast(this.this$0.getActivity(), "wallet_fp_close_succ", true);
                                this.this$0.e(false);
                            } else {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SETTING_CLOSE_FAILED);
                                PaySettingActivity.toast(this.this$0.getActivity(), "wallet_fp_close_failed", false);
                            }
                            this.val$fingerprintPay.destory();
                        }
                    }
                });
            } else {
                GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, this.f26740f);
            if (this.s == 0) {
                userInfoBean.setCheckPrePassSign(1, "3");
            }
            userInfoBean.setResponseCallback(this);
            userInfoBean.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            PromptDialog promptDialog = new PromptDialog(this.mAct);
            promptDialog.setTitleText(ResUtils.getString(getActivity(), "bd_wallet_fingerprint_enable_dialog_title"));
            promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f26752a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PaySettingActivity f26753b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26753b = this;
                    this.f26752a = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f26752a.dismiss();
                    }
                }
            });
            promptDialog.hideMessage();
            promptDialog.hideNegativeButton();
            promptDialog.show();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this, PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD, this.f26740f);
            bean.setResponseCallback(this);
            bean.execBean();
            WalletGlobalUtils.safeShowDialog(this, 0, "");
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.f26741g.setOnClickListener(this);
            this.j.setOnCheckedListener(new SwitchButton.a(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PaySettingActivity f26744a;

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
                    this.f26744a = this;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        LogUtil.d("switch_btn" + z);
                        if (z) {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_OPEN_FREE_PASS);
                        } else {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLOSE_FREE_PASS);
                        }
                        this.f26744a.j.setChecked(!z);
                        if (NetworkUtils.isNetworkAvailable(this.f26744a)) {
                            this.f26744a.gotoSaveFreePay(z);
                        } else {
                            GlobalUtils.toast(this.f26744a.getActivity(), ResUtils.getString(this.f26744a.getActivity(), "ebpay_no_network"));
                        }
                    }
                }
            });
            this.f26743i.setOnCheckedListener(new SwitchButton.a(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PaySettingActivity f26745a;

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
                    this.f26745a = this;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (!NetworkUtils.isNetworkAvailable(this.f26745a.getActivity())) {
                            GlobalUtils.toast(this.f26745a.getActivity(), ResUtils.getString(this.f26745a.getActivity(), "ebpay_no_network"));
                            return;
                        }
                        LogUtil.d("switch_btn" + z);
                        if (z) {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINGERPRINT_REGISTER);
                        } else {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINGER_UNREGISTER);
                        }
                        this.f26745a.setFingerPaySwitch(z);
                    }
                }
            });
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f26735a = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_payfree_tips"));
            this.f26736b = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_payfree_url"));
            this.E = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_finger_tips"));
            this.F = (TextView) findViewById(ResUtils.id(this, "ebpay_pay_finger_url"));
            this.f26737c = findViewById(ResUtils.id(this, "bd_wallet_switch_fingerfree"));
            this.f26738d = findViewById(ResUtils.id(this, "bd_wallet_divider_finger"));
            this.f26739e = findViewById(ResUtils.id(this, "bd_wallet_divider_finger_below"));
            this.f26741g = (RelativeLayout) findViewById(ResUtils.id(this, "layout_pay_sort"));
            this.f26742h = (TextView) findViewById(ResUtils.id(this, "tv_pay_sort"));
            this.j = (SwitchButton) findViewById(ResUtils.id(this, "switch_btn_litterpay"));
            this.f26743i = (SwitchButton) findViewById(ResUtils.id(this, "switch_btn_fingerpay"));
            this.x = (TextView) findViewById(ResUtils.id(this, "label_pass_free"));
            this.B = findViewById(ResUtils.id(this, "bd_wallet_face_pay_layout"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PaySetListBean paySetListBean = (PaySetListBean) PayBeanFactory.getInstance().getBean((Context) this, 544, this.f26740f);
            paySetListBean.setResponseCallback(this);
            paySetListBean.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65558, this, z) == null) || this.f26737c == null) {
            return;
        }
        int i2 = z ? 0 : 8;
        this.f26737c.setVisibility(i2);
        this.f26738d.setVisibility(i2);
        this.f26739e.setVisibility(i2);
        if (this.E == null) {
            return;
        }
        d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, this, z) == null) {
            this.f26743i.setChecked(z);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            if (z) {
                PasswordController.getPassWordInstance().checkPwd(this, BeanConstants.FROM_PASSFREE_SAVE, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26754a;

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
                        this.f26754a = this;
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || i2 == 2) {
                            return;
                        }
                        LogUtil.e("gq", "errorcode" + i2, null);
                        PaySettingActivity.toast(this.f26754a.getActivity(), "ebpay_setting_fail", false);
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onSucceed(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            if (this.f26754a.z == null || !this.f26754a.z.isNeedSms()) {
                                this.f26754a.b(true, str);
                            } else {
                                this.f26754a.a(true, str);
                            }
                        }
                    }
                });
                this.w = true;
                return;
            }
            b(false, "");
        }
    }

    private void d(boolean z) {
        PaySetResponse paySetResponse;
        PaySetResponse.Fingerprint fingerprint;
        PaySetResponse.FingerprintProtocol fingerprintProtocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, this, z) == null) {
            if (z && (paySetResponse = this.A) != null && (fingerprint = paySetResponse.fingerprint) != null && (fingerprintProtocol = fingerprint.fingerprint_protocol) != null) {
                if (!TextUtils.isEmpty(fingerprintProtocol.fingerprint_protocol_prefix)) {
                    this.E.setText(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_prefix);
                    this.E.setVisibility(0);
                    if (!TextUtils.isEmpty(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_msg) && !TextUtils.isEmpty(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_url)) {
                        this.F.setText(this.A.fingerprint.fingerprint_protocol.fingerprint_protocol_msg);
                        this.F.setVisibility(0);
                        this.F.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ PaySettingActivity f26758a;

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
                                this.f26758a = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                    PaySettingActivity paySettingActivity = this.f26758a;
                                    baiduWalletDelegate.openH5Module(paySettingActivity, paySettingActivity.A.fingerprint.fingerprint_protocol.fingerprint_protocol_url, false);
                                }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, this, z, str) == null) {
            Intent intent = new Intent(this, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 9);
            intent.putExtra("phone", this.y);
            intent.putExtra(OPENED, z);
            intent.putExtra(PWD, str);
            startActivityForResultWithoutAnim(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65554, this, z, str) == null) {
            ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, this.f26740f);
            String seed = PasswordController.getSeed();
            acVar.a(PasswordController.handlePwd(str, seed), SafePay.getInstance().encryptProxy(seed), z ? "1" : "2", "20000");
            acVar.setResponseCallback(this);
            acVar.execBean();
            WalletGlobalUtils.safeShowDialog(this, -1, "");
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.B.setVisibility(0);
                this.B.setOnClickListener(new View.OnClickListener(this, str) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f26756a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PaySettingActivity f26757b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26757b = this;
                        this.f26756a = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26757b.C = true;
                            BaiduWalletDelegate.getInstance().openH5Module(this.f26757b.getActivity(), this.f26756a, true);
                        }
                    }
                });
                return;
            }
            this.B.setVisibility(8);
        }
    }

    private void a(PaySetResponse.Fingerprint fingerprint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, fingerprint) == null) {
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
            this.p = this.f26743i.isChecked();
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            toast(getActivity(), z ? "ebpay_setting_suc" : "ebpay_setting_fail", z);
            if (z) {
                SwitchButton switchButton = this.j;
                switchButton.setChecked(!switchButton.isChecked());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, str) == null) {
            this.r = true;
            int i2 = this.s;
        }
    }

    private void b(PaySetResponse paySetResponse) {
        PaySetResponse.Paymethod_info paymethod_info;
        PaySetResponse.PayInfoBean[] payInfoBeanArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, paySetResponse) == null) || paySetResponse == null || (paymethod_info = paySetResponse.paymethod_info) == null || (payInfoBeanArr = paymethod_info.sorted_list) == null || payInfoBeanArr.length <= 0) {
            return;
        }
        this.k = paymethod_info;
    }

    private void a(PaySetResponse paySetResponse) {
        PaySetResponse.PayFreeInfo payFreeInfo;
        PaySetResponse.PassFreeProtocol passFreeProtocol;
        PaySetResponse.PayFreeInfo payFreeInfo2;
        PaySetResponse.PassFreeProtocol passFreeProtocol2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, paySetResponse) == null) {
            if (paySetResponse != null && (payFreeInfo = paySetResponse.passfree_info) != null && (passFreeProtocol = payFreeInfo.passfree_protocol) != null && !TextUtils.isEmpty(passFreeProtocol.passfree_protocol_prefix)) {
                this.f26735a.setText(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_prefix);
                this.f26735a.setVisibility(8);
                if (paySetResponse != null && (payFreeInfo2 = paySetResponse.passfree_info) != null && (passFreeProtocol2 = payFreeInfo2.passfree_protocol) != null && !TextUtils.isEmpty(passFreeProtocol2.passfree_protocol_url) && !TextUtils.isEmpty(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_msg)) {
                    this.f26736b.setText(paySetResponse.passfree_info.passfree_protocol.passfree_protocol_msg);
                    this.f26736b.setVisibility(8);
                    this.f26736b.setOnClickListener(new View.OnClickListener(this, paySetResponse) { // from class: com.baidu.wallet.paysdk.ui.PaySettingActivity.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PaySetResponse f26759a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ PaySettingActivity f26760b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, paySetResponse};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f26760b = this;
                            this.f26759a = paySetResponse;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                BaiduWalletDelegate.getInstance().openH5Module(this.f26760b, this.f26759a.passfree_info.passfree_protocol.passfree_protocol_url, false);
                            }
                        }
                    });
                    return;
                }
                this.f26735a.setVisibility(8);
                this.f26736b.setVisibility(8);
                return;
            }
            this.f26735a.setVisibility(8);
            this.f26736b.setVisibility(8);
        }
    }

    private void a(PaySetResponse.PayFreeInfo payFreeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, payFreeInfo) == null) {
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
}

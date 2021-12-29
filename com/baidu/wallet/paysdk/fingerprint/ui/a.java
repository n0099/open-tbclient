package com.baidu.wallet.paysdk.fingerprint.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.AnimUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.security.KeyStoreException;
@RequiresApi(api = 23)
/* loaded from: classes13.dex */
public class a extends DialogFragment implements b {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f54099b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f54100c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f54101d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54102e;

    /* renamed from: f  reason: collision with root package name */
    public Button f54103f;

    /* renamed from: g  reason: collision with root package name */
    public Button f54104g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.b.a f54105h;

    /* renamed from: i  reason: collision with root package name */
    public FingerprintCallback f54106i;

    /* renamed from: j  reason: collision with root package name */
    public int f54107j;

    /* renamed from: k  reason: collision with root package name */
    public IFingerprintPay.Action f54108k;
    public String l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(696842933, "Lcom/baidu/wallet/paysdk/fingerprint/ui/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(696842933, "Lcom/baidu/wallet/paysdk/fingerprint/ui/a;");
                return;
            }
        }
        a = a.class.getSimpleName();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.f54100c = activity;
            super.onAttach(activity);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, ResUtils.style(this.f54100c, "EbpayPromptDialog"));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            LayoutInflater from = LayoutInflater.from(this.f54100c);
            this.f54099b = from;
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.f54100c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
            this.f54101d = viewGroup2;
            this.f54103f = (Button) viewGroup2.findViewById(ResUtils.id(this.f54100c, "negative_btn"));
            this.f54104g = (Button) this.f54101d.findViewById(ResUtils.id(this.f54100c, "positive_btn"));
            this.f54102e = (TextView) this.f54101d.findViewById(ResUtils.id(this.f54100c, "fingerprint_title"));
            getDialog().setCanceledOnTouchOutside(false);
            setCancelable(false);
            this.f54103f.setVisibility(8);
            this.f54104g.setVisibility(0);
            a(this.f54104g);
            this.f54104g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatHelper.cachePayWay(1);
                        this.a.b();
                        this.a.f54105h.a();
                        if (this.a.f54106i != null) {
                            this.a.f54106i.onAuthorizeResult(this.a.f54108k, 1, "cancle");
                        }
                        this.a.dismissAllowingStateLoss();
                    }
                }
            });
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (PayDataCache.getInstance().isPaySettingOpenFingerprintPay()) {
                PayDataCache.getInstance().setPaySettingOpenFingerprintPay(false);
                string = ResUtils.getString(this.f54100c, "wallet_fp_open_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
                string = ResUtils.getString(this.f54100c, "wallet_fp_upgrade_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
                string = ResUtils.getString(this.f54100c, "wallet_fp_reopen_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 1) {
                string = ResUtils.getString(this.f54100c, "wallet_fp_open_content");
            } else {
                string = ResUtils.getString(this.f54100c, "wallet_fp_bdwallet_fingerprintpay");
            }
            this.f54102e.setText(string);
            return this.f54101d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.f54100c = null;
            com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.f54105h;
            if (aVar != null) {
                aVar.d();
                this.f54105h = null;
            }
            this.f54101d = null;
            this.f54106i = null;
            this.f54099b = null;
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            this.f54105h.a();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.f54105h.a(this.f54107j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f54107j == 1) {
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.f54100c, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback(this, aVar) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f54109b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54109b = this;
                    this.a = aVar;
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        String unused = a.a;
                        this.a.destroyBean();
                        StatisticManager.onEvent("fp_close_system_failed_after_get_otptoken");
                    }
                }

                @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        String unused = a.a;
                        this.a.destroyBean();
                    }
                }
            });
            aVar.execBean();
        }
    }

    public static a a(Activity activity, int i2, String str, FingerprintCallback fingerprintCallback) throws KeyStoreException {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, activity, i2, str, fingerprintCallback)) == null) {
            a aVar = new a();
            if (i2 == 1 && TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(" operaterData cannot be null when openning fingerprintpay !");
            }
            if (i2 == 1) {
                aVar.f54108k = IFingerprintPay.Action.OPEN;
                aVar.l = SecurePay.getInstance().localDecrypt1(str.split("\\|")[0]);
            } else {
                aVar.f54108k = IFingerprintPay.Action.VERIFY;
            }
            com.baidu.wallet.paysdk.fingerprint.b.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.b.a(activity.getApplicationContext());
            aVar.f54105h = aVar2;
            aVar2.a(aVar);
            aVar.f54105h.a(str);
            aVar.f54107j = i2;
            aVar.f54106i = fingerprintCallback;
            aVar.f54100c = activity;
            return aVar;
        }
        return (a) invokeLILL.objValue;
    }

    private void a(Button button) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, button) == null) {
            View findViewById = this.f54101d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "dxm_wallet_base_dialog_btn_selector"));
            button.setText("取消");
            TextPaint paint = button.getPaint();
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.b
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            if (i2 == 0) {
                FingerprintCallback fingerprintCallback = this.f54106i;
                if (fingerprintCallback != null) {
                    fingerprintCallback.onAuthorizeResult(this.f54108k, 0, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -3) {
                StatisticManager.onEvent("fp_fingerprint_changed");
                b();
                this.f54105h.a();
                FingerprintCallback fingerprintCallback2 = this.f54106i;
                if (fingerprintCallback2 != null) {
                    fingerprintCallback2.onAuthorizeResult(this.f54108k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -6 || i2 == -4) {
                if (i2 == -4) {
                    StatisticManager.onEvent("fp_verify_error_3_times_auto_changeto_pwdpay");
                } else {
                    StatisticManager.onEvent("fp_verify_error_fingerprint_setdisable_fp_serval_seconds");
                }
                b();
                this.f54105h.a();
                FingerprintCallback fingerprintCallback3 = this.f54106i;
                if (fingerprintCallback3 != null) {
                    fingerprintCallback3.onAuthorizeResult(this.f54108k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -1) {
                if (this.f54106i != null) {
                    b();
                    this.f54106i.onAuthorizeResult(this.f54108k, 2, "");
                }
                this.f54105h.a();
                dismissAllowingStateLoss();
            } else if (i2 == -5) {
                if (this.f54107j == 1) {
                    this.f54104g.setVisibility(8);
                } else {
                    this.f54104g.setVisibility(0);
                    this.f54104g.setText(ResUtils.getString(this.f54100c, "wallet_cashdesk_pwd_pay"));
                }
                this.f54103f.setVisibility(0);
                a(this.f54103f);
                this.f54102e.setVisibility(0);
                this.f54102e.setText(str);
                AnimUtils.startSharkAnim(this.f54102e);
                this.f54104g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("fp_error_fingerprint_click_pwdpay");
                            this.a.f54105h.a();
                            if (this.a.f54106i != null) {
                                this.a.f54106i.onAuthorizeResult(this.a.f54108k, 3, "");
                            }
                            this.a.dismissAllowingStateLoss();
                        }
                    }
                });
                this.f54103f.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.b();
                            this.a.f54105h.a();
                            if (this.a.f54106i != null) {
                                this.a.f54106i.onAuthorizeResult(this.a.f54108k, 1, "");
                            }
                            this.a.dismissAllowingStateLoss();
                        }
                    }
                });
            } else if (i2 == -7) {
                com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.f54105h;
                if (aVar != null) {
                    aVar.a();
                }
                FingerprintCallback fingerprintCallback4 = this.f54106i;
                if (fingerprintCallback4 != null) {
                    fingerprintCallback4.onAuthorizeResult(this.f54108k, -7, str);
                }
                dismissAllowingStateLoss();
            } else {
                b();
                FingerprintCallback fingerprintCallback5 = this.f54106i;
                if (fingerprintCallback5 != null) {
                    fingerprintCallback5.onAuthorizeResult(this.f54108k, 2, "");
                }
                this.f54105h.a();
                dismissAllowingStateLoss();
            }
        }
    }
}

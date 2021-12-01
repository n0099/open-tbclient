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
/* loaded from: classes12.dex */
public class a extends DialogFragment implements b {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f53516b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f53517c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f53518d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53519e;

    /* renamed from: f  reason: collision with root package name */
    public Button f53520f;

    /* renamed from: g  reason: collision with root package name */
    public Button f53521g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.b.a f53522h;

    /* renamed from: i  reason: collision with root package name */
    public FingerprintCallback f53523i;

    /* renamed from: j  reason: collision with root package name */
    public int f53524j;

    /* renamed from: k  reason: collision with root package name */
    public IFingerprintPay.Action f53525k;
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
            this.f53517c = activity;
            super.onAttach(activity);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, ResUtils.style(this.f53517c, "EbpayPromptDialog"));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            LayoutInflater from = LayoutInflater.from(this.f53517c);
            this.f53516b = from;
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.f53517c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
            this.f53518d = viewGroup2;
            this.f53520f = (Button) viewGroup2.findViewById(ResUtils.id(this.f53517c, "negative_btn"));
            this.f53521g = (Button) this.f53518d.findViewById(ResUtils.id(this.f53517c, "positive_btn"));
            this.f53519e = (TextView) this.f53518d.findViewById(ResUtils.id(this.f53517c, "fingerprint_title"));
            getDialog().setCanceledOnTouchOutside(false);
            setCancelable(false);
            this.f53520f.setVisibility(8);
            this.f53521g.setVisibility(0);
            a(this.f53521g);
            this.f53521g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.1
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
                        this.a.f53522h.a();
                        if (this.a.f53523i != null) {
                            this.a.f53523i.onAuthorizeResult(this.a.f53525k, 1, "cancle");
                        }
                        this.a.dismissAllowingStateLoss();
                    }
                }
            });
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (PayDataCache.getInstance().isPaySettingOpenFingerprintPay()) {
                PayDataCache.getInstance().setPaySettingOpenFingerprintPay(false);
                string = ResUtils.getString(this.f53517c, "wallet_fp_open_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
                string = ResUtils.getString(this.f53517c, "wallet_fp_upgrade_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
                string = ResUtils.getString(this.f53517c, "wallet_fp_reopen_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 1) {
                string = ResUtils.getString(this.f53517c, "wallet_fp_open_content");
            } else {
                string = ResUtils.getString(this.f53517c, "wallet_fp_bdwallet_fingerprintpay");
            }
            this.f53519e.setText(string);
            return this.f53518d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.f53517c = null;
            com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.f53522h;
            if (aVar != null) {
                aVar.d();
                this.f53522h = null;
            }
            this.f53518d = null;
            this.f53523i = null;
            this.f53516b = null;
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            this.f53522h.a();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.f53522h.a(this.f53524j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f53524j == 1) {
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.f53517c, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback(this, aVar) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f53526b;

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
                    this.f53526b = this;
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
                aVar.f53525k = IFingerprintPay.Action.OPEN;
                aVar.l = SecurePay.getInstance().localDecrypt1(str.split("\\|")[0]);
            } else {
                aVar.f53525k = IFingerprintPay.Action.VERIFY;
            }
            com.baidu.wallet.paysdk.fingerprint.b.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.b.a(activity.getApplicationContext());
            aVar.f53522h = aVar2;
            aVar2.a(aVar);
            aVar.f53522h.a(str);
            aVar.f53524j = i2;
            aVar.f53523i = fingerprintCallback;
            aVar.f53517c = activity;
            return aVar;
        }
        return (a) invokeLILL.objValue;
    }

    private void a(Button button) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, button) == null) {
            View findViewById = this.f53518d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
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
                FingerprintCallback fingerprintCallback = this.f53523i;
                if (fingerprintCallback != null) {
                    fingerprintCallback.onAuthorizeResult(this.f53525k, 0, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -3) {
                StatisticManager.onEvent("fp_fingerprint_changed");
                b();
                this.f53522h.a();
                FingerprintCallback fingerprintCallback2 = this.f53523i;
                if (fingerprintCallback2 != null) {
                    fingerprintCallback2.onAuthorizeResult(this.f53525k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -6 || i2 == -4) {
                if (i2 == -4) {
                    StatisticManager.onEvent("fp_verify_error_3_times_auto_changeto_pwdpay");
                } else {
                    StatisticManager.onEvent("fp_verify_error_fingerprint_setdisable_fp_serval_seconds");
                }
                b();
                this.f53522h.a();
                FingerprintCallback fingerprintCallback3 = this.f53523i;
                if (fingerprintCallback3 != null) {
                    fingerprintCallback3.onAuthorizeResult(this.f53525k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -1) {
                if (this.f53523i != null) {
                    b();
                    this.f53523i.onAuthorizeResult(this.f53525k, 2, "");
                }
                this.f53522h.a();
                dismissAllowingStateLoss();
            } else if (i2 == -5) {
                if (this.f53524j == 1) {
                    this.f53521g.setVisibility(8);
                } else {
                    this.f53521g.setVisibility(0);
                    this.f53521g.setText(ResUtils.getString(this.f53517c, "wallet_cashdesk_pwd_pay"));
                }
                this.f53520f.setVisibility(0);
                a(this.f53520f);
                this.f53519e.setVisibility(0);
                this.f53519e.setText(str);
                AnimUtils.startSharkAnim(this.f53519e);
                this.f53521g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.2
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
                            this.a.f53522h.a();
                            if (this.a.f53523i != null) {
                                this.a.f53523i.onAuthorizeResult(this.a.f53525k, 3, "");
                            }
                            this.a.dismissAllowingStateLoss();
                        }
                    }
                });
                this.f53520f.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.3
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
                            this.a.f53522h.a();
                            if (this.a.f53523i != null) {
                                this.a.f53523i.onAuthorizeResult(this.a.f53525k, 1, "");
                            }
                            this.a.dismissAllowingStateLoss();
                        }
                    }
                });
            } else if (i2 == -7) {
                com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.f53522h;
                if (aVar != null) {
                    aVar.a();
                }
                FingerprintCallback fingerprintCallback4 = this.f53523i;
                if (fingerprintCallback4 != null) {
                    fingerprintCallback4.onAuthorizeResult(this.f53525k, -7, str);
                }
                dismissAllowingStateLoss();
            } else {
                b();
                FingerprintCallback fingerprintCallback5 = this.f53523i;
                if (fingerprintCallback5 != null) {
                    fingerprintCallback5.onAuthorizeResult(this.f53525k, 2, "");
                }
                this.f53522h.a();
                dismissAllowingStateLoss();
            }
        }
    }
}

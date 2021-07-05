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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.AnimUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.NonePayingProcess;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.security.KeyStoreException;
@RequiresApi(api = 23)
/* loaded from: classes6.dex */
public class a extends DialogFragment implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f26022a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f26023b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f26024c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f26025d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26026e;

    /* renamed from: f  reason: collision with root package name */
    public Button f26027f;

    /* renamed from: g  reason: collision with root package name */
    public Button f26028g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a.a f26029h;

    /* renamed from: i  reason: collision with root package name */
    public FingerprintCallback f26030i;
    public int j;
    public IFingerprintPay.Action k;
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
        f26022a = a.class.getSimpleName();
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
            this.f26024c = activity;
            super.onAttach(activity);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, ResUtils.style(this.f26024c, "EbpayPromptDialog"));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            LayoutInflater from = LayoutInflater.from(this.f26024c);
            this.f26023b = from;
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.f26024c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
            this.f26025d = viewGroup2;
            this.f26027f = (Button) viewGroup2.findViewById(ResUtils.id(this.f26024c, "negative_btn"));
            this.f26028g = (Button) this.f26025d.findViewById(ResUtils.id(this.f26024c, "positive_btn"));
            this.f26026e = (TextView) this.f26025d.findViewById(ResUtils.id(this.f26024c, "fingerprint_title"));
            getDialog().setCanceledOnTouchOutside(false);
            setCancelable(false);
            this.f26027f.setVisibility(8);
            this.f26028g.setVisibility(0);
            a(this.f26028g);
            this.f26028g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f26031a;

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
                    this.f26031a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatHelper.cachePayWay(1);
                        this.f26031a.b();
                        this.f26031a.f26029h.a();
                        if (this.f26031a.f26030i != null) {
                            this.f26031a.f26030i.onAuthorizeResult(this.f26031a.k, 1, "cancle");
                        }
                        this.f26031a.dismissAllowingStateLoss();
                    }
                }
            });
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            Activity activity = this.f26024c;
            if (activity instanceof NonePayingProcess) {
                string = ResUtils.getString(activity, "wallet_fp_open_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
                string = ResUtils.getString(activity, "wallet_fp_upgrade_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
                string = ResUtils.getString(this.f26024c, "wallet_fp_reopen_content");
            } else if (payRequest != null && payRequest.FP_Guide_Strategy == 1) {
                string = ResUtils.getString(this.f26024c, "wallet_fp_open_content");
            } else {
                string = ResUtils.getString(this.f26024c, "wallet_fp_bdwallet_fingerprintpay");
            }
            this.f26026e.setText(string);
            return this.f26025d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.f26024c = null;
            com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f26029h;
            if (aVar != null) {
                aVar.d();
                this.f26029h = null;
            }
            this.f26025d = null;
            this.f26030i = null;
            this.f26023b = null;
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPause();
            this.f26029h.a();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.f26029h.a(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.j == 1) {
            com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.f26024c, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, f26022a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback(this, aVar) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.baidu.wallet.paysdk.fingerprint.bean.a f26034a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f26035b;

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
                    this.f26035b = this;
                    this.f26034a = aVar;
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                        LogUtil.d(a.f26022a, "close system fingerprint failed!");
                        this.f26034a.destroyBean();
                        StatisticManager.onEvent(StatServiceEvent.EVENT_FP_CLOSE_SYSTEM_FAILED_AFTER_GET_OTPTOKEN);
                    }
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                        LogUtil.d(a.f26022a, "close system fingerprint success!");
                        this.f26034a.destroyBean();
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
                aVar.k = IFingerprintPay.Action.OPEN;
                aVar.l = SafePay.getInstance().localDecrypt(str.split("\\|")[0]);
            } else {
                aVar.k = IFingerprintPay.Action.VERIFY;
            }
            com.baidu.wallet.paysdk.fingerprint.a.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.a.a(activity.getApplicationContext());
            aVar.f26029h = aVar2;
            aVar2.a(aVar);
            aVar.f26029h.a(str);
            aVar.j = i2;
            aVar.f26030i = fingerprintCallback;
            aVar.f26024c = activity;
            return aVar;
        }
        return (a) invokeLILL.objValue;
    }

    private void a(Button button) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, button) == null) {
            View findViewById = this.f26025d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "wallet_base_dialog_btn_selector"));
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
                FingerprintCallback fingerprintCallback = this.f26030i;
                if (fingerprintCallback != null) {
                    fingerprintCallback.onAuthorizeResult(this.k, 0, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -3) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_FINGERPRINT_CHANGED);
                b();
                this.f26029h.a();
                FingerprintCallback fingerprintCallback2 = this.f26030i;
                if (fingerprintCallback2 != null) {
                    fingerprintCallback2.onAuthorizeResult(this.k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -6 || i2 == -4) {
                if (i2 == -4) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_3_TIMES_AUTO_CHANGETO_PWDPAY);
                } else {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_SETDISABLE_SERVAL_SECONDS);
                }
                b();
                this.f26029h.a();
                FingerprintCallback fingerprintCallback3 = this.f26030i;
                if (fingerprintCallback3 != null) {
                    fingerprintCallback3.onAuthorizeResult(this.k, 2, str);
                }
                dismissAllowingStateLoss();
            } else if (i2 == -1) {
                if (this.f26030i != null) {
                    b();
                    this.f26030i.onAuthorizeResult(this.k, 2, "");
                }
                this.f26029h.a();
                dismissAllowingStateLoss();
            } else if (i2 == -5) {
                if (this.j == 1) {
                    this.f26028g.setVisibility(8);
                } else {
                    this.f26028g.setVisibility(0);
                    this.f26028g.setText(ResUtils.getString(this.f26024c, "wallet_cashdesk_pwd_pay"));
                }
                this.f26027f.setVisibility(0);
                a(this.f26027f);
                this.f26026e.setVisibility(0);
                this.f26026e.setText(str);
                AnimUtils.startSharkAnim(this.f26026e);
                this.f26028g.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f26032a;

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
                        this.f26032a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_ERROR_FP_CLICK_PWDPAY);
                            this.f26032a.f26029h.a();
                            if (this.f26032a.f26030i != null) {
                                this.f26032a.f26030i.onAuthorizeResult(this.f26032a.k, 3, "");
                            }
                            this.f26032a.dismissAllowingStateLoss();
                        }
                    }
                });
                this.f26027f.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f26033a;

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
                        this.f26033a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26033a.b();
                            this.f26033a.f26029h.a();
                            if (this.f26033a.f26030i != null) {
                                this.f26033a.f26030i.onAuthorizeResult(this.f26033a.k, 1, "");
                            }
                            this.f26033a.dismissAllowingStateLoss();
                        }
                    }
                });
            } else {
                b();
                FingerprintCallback fingerprintCallback4 = this.f26030i;
                if (fingerprintCallback4 != null) {
                    fingerprintCallback4.onAuthorizeResult(this.k, 2, "");
                }
                this.f26029h.a();
                dismissAllowingStateLoss();
            }
        }
    }
}

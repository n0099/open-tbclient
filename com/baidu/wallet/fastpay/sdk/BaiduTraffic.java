package com.baidu.wallet.fastpay.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.fastpay.datamodel.GetTrafficOrderResponse;
import com.baidu.wallet.fastpay.sdk.a;
import com.baidu.wallet.paysdk.ui.WalletMobileResultActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"UseSparseArrays", "StaticFieldLeak"})
/* loaded from: classes5.dex */
public class BaiduTraffic {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24824a = "BaiduTraffic";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f24825b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, a> f24826c;

    /* renamed from: com.baidu.wallet.fastpay.sdk.BaiduTraffic$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements PayCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetTrafficOrderResponse f24827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f24828b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaiduTraffic f24829c;

        @Override // com.baidu.android.pay.PayCallBack
        public boolean isHideLoadingDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.android.pay.PayCallBack
        public void onPayResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (i2 != 0 && i2 != 1) {
                    a a2 = this.f24829c.a(this.f24828b);
                    if (a2 != null) {
                        a2.a(this.f24828b, 0, new a.C0263a(i2, ""));
                        this.f24829c.b(this.f24828b);
                        return;
                    }
                    return;
                }
                GetTrafficOrderResponse getTrafficOrderResponse = this.f24827a;
                if (getTrafficOrderResponse != null && !TextUtils.isEmpty(getTrafficOrderResponse.orderNo) && this.f24827a.isGotoResultActivity()) {
                    GetTrafficOrderResponse.Params params = this.f24827a.params;
                    WalletMobileResultActivity.gotoBusniessResultPage(this.f24829c.f24825b, false, this.f24827a.orderNo, params != null ? params.pay_desc : "", i2 == 1, new ResultPageStateListener(this, i2) { // from class: com.baidu.wallet.fastpay.sdk.BaiduTraffic.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f24830a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f24831b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24831b = this;
                            this.f24830a = i2;
                        }

                        @Override // com.baidu.wallet.api.ResultPageStateListener
                        public void onConfirm() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(this.f24830a);
                                AnonymousClass1 anonymousClass1 = this.f24831b;
                                a a3 = anonymousClass1.f24829c.a(anonymousClass1.f24828b);
                                if (a3 != null) {
                                    a3.a(this.f24831b.f24828b, 1, payStateTrafficModle);
                                    AnonymousClass1 anonymousClass12 = this.f24831b;
                                    anonymousClass12.f24829c.b(anonymousClass12.f24828b);
                                }
                            }
                        }
                    });
                    return;
                }
                PayStateTrafficModle payStateTrafficModle = new PayStateTrafficModle(i2);
                a a3 = this.f24829c.a(this.f24828b);
                if (a3 != null) {
                    a3.a(this.f24828b, 1, payStateTrafficModle);
                    this.f24829c.b(this.f24828b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class PayStateTrafficModle implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PAY_STATUS_CANCEL = 2;
        public static final int PAY_STATUS_PAYING = 1;
        public static final int PAY_STATUS_SUCCESS = 0;
        public static final long serialVersionUID = 393136306694361260L;
        public transient /* synthetic */ FieldHolder $fh;
        public int statecode;

        public PayStateTrafficModle(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.statecode = i2;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, int i3, a.C0263a c0263a);

        void a(int i2, int i3, Object obj);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BaiduTraffic f24832a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1637807269, "Lcom/baidu/wallet/fastpay/sdk/BaiduTraffic$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1637807269, "Lcom/baidu/wallet/fastpay/sdk/BaiduTraffic$b;");
                    return;
                }
            }
            f24832a = new BaiduTraffic(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(498853849, "Lcom/baidu/wallet/fastpay/sdk/BaiduTraffic;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(498853849, "Lcom/baidu/wallet/fastpay/sdk/BaiduTraffic;");
        }
    }

    public /* synthetic */ BaiduTraffic(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(int i2) {
        Map<Integer, a> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (map = this.f24826c) == null || map.size() <= 0) {
            return;
        }
        this.f24826c.remove(Integer.valueOf(i2));
    }

    public BaiduTraffic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24826c = new HashMap();
    }

    public static BaiduTraffic a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.f24832a : (BaiduTraffic) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? Pattern.compile("^1[0-9]{10}$").matcher(str).matches() : invokeL.booleanValue;
    }

    public a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Map<Integer, a> map = this.f24826c;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return this.f24826c.get(Integer.valueOf(i2));
        }
        return (a) invokeI.objValue;
    }
}

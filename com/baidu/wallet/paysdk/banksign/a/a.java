package com.baidu.wallet.paysdk.banksign.a;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f62668a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f62669b;

    /* renamed from: c  reason: collision with root package name */
    public String f62670c;

    /* renamed from: d  reason: collision with root package name */
    public String f62671d;

    /* renamed from: e  reason: collision with root package name */
    public String f62672e;

    /* renamed from: f  reason: collision with root package name */
    public String f62673f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f62674g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62675h;

    /* renamed from: i  reason: collision with root package name */
    public String f62676i;

    /* renamed from: j  reason: collision with root package name */
    public j f62677j;
    public PayTypeActivity k;
    public OrderConfirmActivity l;

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1854a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f62678a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1120470548, "Lcom/baidu/wallet/paysdk/banksign/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1120470548, "Lcom/baidu/wallet/paysdk/banksign/a/a$a;");
                    return;
                }
            }
            f62678a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1382169975, "Lcom/baidu/wallet/paysdk/banksign/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1382169975, "Lcom/baidu/wallet/paysdk/banksign/a/a;");
                return;
            }
        }
        f62668a = Pattern.compile("(.*)(selected_card_no=[^&]+)(.*)");
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1854a.f62678a : (a) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62676i : (String) invokeV.objValue;
    }

    public OrderConfirmActivity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (OrderConfirmActivity) invokeV.objValue;
    }

    public PayTypeActivity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (PayTypeActivity) invokeV.objValue;
    }

    public j e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f62677j : (j) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f62675h : invokeV.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f62671d : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f62670c : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f62672e : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f62673f : (String) invokeV.objValue;
    }

    public byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f62674g : (byte[]) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f62669b : (String) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f62674g = null;
            this.f62677j = null;
            this.l = null;
            this.k = null;
        }
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
                return;
            }
        }
        this.f62675h = false;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f62676i = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f62671d = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f62670c = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f62672e = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f62673f = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f62669b = str;
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        String group;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            String orderExtraInfo = PayDataCache.getInstance().getOrderExtraInfo();
            PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str;
            if (TextUtils.isEmpty(orderExtraInfo)) {
                return null;
            }
            Matcher matcher = f62668a.matcher(orderExtraInfo);
            if (!matcher.matches() || 3 != matcher.groupCount() || (group = matcher.group(2)) == null || str == null) {
                return orderExtraInfo;
            }
            String encode = Uri.encode(str);
            return orderExtraInfo.replace(group, "selected_card_no=" + encode);
        }
        return (String) invokeL.objValue;
    }

    public void a(OrderConfirmActivity orderConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, orderConfirmActivity) == null) {
            this.l = orderConfirmActivity;
        }
    }

    public void a(PayTypeActivity payTypeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payTypeActivity) == null) {
            this.k = payTypeActivity;
        }
    }

    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.f62677j = jVar;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f62675h = z;
        }
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            this.f62674g = bArr;
        }
    }
}

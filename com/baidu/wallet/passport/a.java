package com.baidu.wallet.passport;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f59458a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f59459b = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f59460c;

    /* renamed from: d  reason: collision with root package name */
    public String f59461d;

    /* renamed from: com.baidu.wallet.passport.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.passport.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1808a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f59462a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1056476018, "Lcom/baidu/wallet/passport/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1056476018, "Lcom/baidu/wallet/passport/a$a;");
                    return;
                }
            }
            f59462a = new a(null);
        }

        public C1808a() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394395023, "Lcom/baidu/wallet/passport/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394395023, "Lcom/baidu/wallet/passport/a;");
                return;
            }
        }
        f59458a = new String[]{"dxmpay.com", "duxiaoman.com", "baifubao.com", "8.baidu.com", "wallet.baidu.com", "umoney.baidu.com", "icash.baidu.com", "yqh.baidu.com", "ibeauty.baidu.com", "front.baidu.com", "activity8.baidu.com", "qianbao.baidu.com", "dxmbaoxian.com", "oneicash.baidu.com", "twoicash.baidu.com", "threeicash.baidu.com", "onejin.baidu.com", "twojin.baidu.com", "threejin.baidu.com", "dxmcash.baidu.com", "dxmoney.baidu.com", "fincash.baidu.com", "www.baiyingfund.com", "www.duxiaomanfund.com"};
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, i2);
            Date time = calendar.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            this.f59461d = simpleDateFormat.format(time);
            LogUtil.d("--DxmCookieManager---cookie----expires--->" + this.f59461d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(-8, "");
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
        this.f59460c = BaiduWalletDelegate.getInstance().getAppContext();
    }

    private String[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            try {
                return (String[]) JsonUtils.fromJson(str, String[].class);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1808a.f59462a : (a) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a(8, str);
        }
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, str) == null) {
            try {
                a(i2);
                String[] b2 = b(SdkInitResponse.getInstance().getCookiesSyncDomainList(this.f59460c));
                if (b2 == null) {
                    LogUtil.d("Cookie", "use default: " + Arrays.toString(f59458a));
                    b2 = f59458a;
                }
                CookieSyncManager.createInstance(this.f59460c);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                String str2 = "OPENBDUSS=" + str;
                String str3 = ";expires=" + this.f59461d;
                LogUtil.d("------------------DxmCookieManager start setCookie--------------");
                for (String str4 : b2) {
                    if (!str4.startsWith(".")) {
                        str4 = "." + str4;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(";path=/");
                    sb.append(str3);
                    sb.append(";domain=");
                    sb.append(str4);
                    sb.append(";httponly");
                    sb.append(";secure");
                    LogUtil.d("---DxmCookieManager---setCookie value--->" + sb.toString());
                    cookieManager.setCookie("https://www" + str4, sb.toString());
                }
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.getInstance().sync();
                } else {
                    cookieManager.flush();
                }
            } catch (Exception e2) {
                LogUtil.d(e2.getMessage());
            }
        }
    }
}

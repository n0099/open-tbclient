package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public final class qh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a = false;
    public static final q31 b;
    public static final qh0 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public a(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (qh0.s()) {
                    if (qh0.a(qh0.c)) {
                        Log.d("AdDeepLinkStayTime", "tryToPostStayTrans: canceled for return before N!");
                        return;
                    }
                    return;
                }
                long j = this.a;
                if (j < 0) {
                    return;
                }
                if (j > System.currentTimeMillis()) {
                    if (qh0.a(qh0.c)) {
                        Log.d("AdDeepLinkStayTime", "tryToPostDeepLinkStayTrans: 留意，时间戳读写出现了异常，抛弃脏数据。");
                        return;
                    }
                    return;
                }
                w31.e(new ClogBuilder().y(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).j(GrsBaseInfo.CountryCodeSource.APP).p(this.b).k(String.valueOf(this.a)).l(String.valueOf(System.currentTimeMillis())).m("1"));
                qh0.y();
                if (qh0.a(qh0.c)) {
                    Log.d("AdDeepLinkStayTime", "tryToPostStayTrans: successfully made a deepLink stay trans!");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948091696, "Lcom/baidu/tieba/qh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948091696, "Lcom/baidu/tieba/qh0;");
                return;
            }
        }
        c = new qh0();
        q31 b2 = t31.a().b("nad_deeplink_stay_time");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().ge…\"nad_deeplink_stay_time\")");
        b = b2;
    }

    public qh0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b.getInt("sp_key_stay_time", 15) * 1000;
        }
        return invokeV.longValue;
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b.getBoolean("key_deep_link_open", false);
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return b.getBoolean("key_no_need_post_deep_link_trans_on_cold_boot", false);
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String f = t61.f("ad_deeplink_stay_time_ext");
            if (f == null) {
                return "";
            }
            return f;
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return b.getLong("key_deep_link_open_time", -1L);
        }
        return invokeV.longValue;
    }

    @JvmStatic
    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String string = b.getString("key_deep_link_source_activity", "");
            if (string == null) {
                return "";
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            c.n();
            c.o();
            c.r();
            c.m();
            c.q();
            c.p();
        }
    }

    @JvmStatic
    public static final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return b.getBoolean("key_deep_link_return_before_time_threshold", false);
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            b.d("key_deep_link_open", true);
        }
    }

    @JvmStatic
    public static final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            b.g("key_deep_link_open_time", System.currentTimeMillis());
        }
    }

    @JvmStatic
    public static final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            b.d("key_no_need_post_deep_link_trans_on_cold_boot", true);
        }
    }

    @JvmStatic
    public static final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            b.d("key_deep_link_return_before_time_threshold", true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t61.j("", "ad_deeplink_stay_time_ext");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.d("key_deep_link_open", false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.g("key_deep_link_open_time", -1L);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.h("key_deep_link_source_activity", "");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.d("key_no_need_post_deep_link_trans_on_cold_boot", false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.d("key_deep_link_return_before_time_threshold", false);
        }
    }

    @JvmStatic
    public static final void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, str) != null) || TextUtils.isEmpty(str) || b(str)) {
            return;
        }
        new Handler().postDelayed(new a(j(), str), c());
    }

    public static final /* synthetic */ boolean a(qh0 qh0Var) {
        return a;
    }

    @JvmStatic
    public static final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            l();
            u();
            v();
            t(str);
            x(str, false);
            A(str);
        }
    }

    @JvmStatic
    public static final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            t61.j(str, "ad_deeplink_stay_time_ext");
        }
    }

    @JvmStatic
    public static final void w(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, activity) == null) && activity != null) {
            b.h("key_deep_link_source_activity", activity.getLocalClassName());
        }
    }

    @JvmStatic
    public static final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                if (str != null) {
                    String obj = StringsKt__StringsKt.trimEnd((CharSequence) str).toString();
                    if (obj != null) {
                        boolean z = b.getBoolean(obj, true);
                        if (a) {
                            Log.d("AdDeepLinkStayTime", "saveIfFinishedPostThisAd: extParam=" + obj + " | finished=" + z);
                        }
                        return z;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final void g(long j, String boot, long j2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), boot, Long.valueOf(j2), str}) == null) {
            Intrinsics.checkNotNullParameter(boot, "boot");
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j < 0) {
            } else {
                if (j > j2) {
                    if (a) {
                        Log.d("AdDeepLinkStayTime", "postDeepLinkStayTime: 留意，出现了两次打点混淆的情况，为避免污染数据，放弃上传本次打点。");
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(boot, "boot_from_background")) {
                    str2 = "1";
                } else if (TextUtils.equals(boot, "boot_from_cold")) {
                    str2 = "2";
                } else {
                    return;
                }
                w31.e(new ClogBuilder().y(ClogBuilder.LogType.DEEPLINK_STAY_TIME).p(str).k(String.valueOf(j)).l(String.valueOf(j2)).m(str2));
                x(str, true);
                if (a) {
                    Log.d("AdDeepLinkStayTime", "postDeepLinkStayTime: post a deepLink stay time on " + boot);
                }
            }
        }
    }

    @JvmStatic
    public static final void h(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j < 0) {
            } else {
                if (j > j2) {
                    if (a) {
                        Log.d("AdDeepLinkStayTime", "postDeepLinkStayTrans: 留意，出现了两次打点混淆的情况，为避免污染数据，放弃上传本次打点。");
                        return;
                    }
                    return;
                }
                w31.e(new ClogBuilder().y(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).j(GrsBaseInfo.CountryCodeSource.APP).p(str).k(String.valueOf(j)).l(String.valueOf(j2)).m("2"));
                if (a) {
                    Log.d("AdDeepLinkStayTime", "postDeepLinkStayTrans: post last deepLink stay trans when cold boot.");
                }
            }
        }
    }

    @JvmStatic
    public static final void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) && str != null) {
            if (str != null) {
                String obj = StringsKt__StringsKt.trimEnd((CharSequence) str).toString();
                if (obj != null) {
                    b.d(obj, z);
                    if (a) {
                        Log.d("AdDeepLinkStayTime", "saveIfFinishedPostThisAd: extParam=" + obj + " | finished=" + z);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }
}

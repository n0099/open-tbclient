package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class jo2 extends mo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public long d;

    /* loaded from: classes4.dex */
    public final class a extends jo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a J1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ii3
        public /* bridge */ /* synthetic */ ii3 a() {
            J1();
            return this;
        }

        @Override // com.baidu.tieba.jo2, com.baidu.tieba.mo2
        public /* bridge */ /* synthetic */ mo2 Q0(int i) {
            return super.Q0(i);
        }

        @Override // com.baidu.tieba.jo2, com.baidu.tieba.po2
        public /* bridge */ /* synthetic */ po2 update(Bundle bundle) {
            return super.update(bundle);
        }

        @Override // com.baidu.tieba.jo2, com.baidu.tieba.mo2
        public /* bridge */ /* synthetic */ mo2 v0(String str) {
            return super.v0(str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889948, "Lcom/baidu/tieba/jo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889948, "Lcom/baidu/tieba/jo2;");
                return;
            }
        }
        e = wj1.a;
    }

    public jo2() {
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

    @Override // com.baidu.tieba.po2
    public Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle D = super.D();
            p02.g(D);
            String H = H();
            if (!TextUtils.isEmpty(H)) {
                D.putString("mAppId", H);
            }
            return D;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null && !TextUtils.isEmpty(f0.appId)) {
                return f0.appId;
            }
            return super.H();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null && !TextUtils.isEmpty(f0.appKey)) {
                return f0.appKey;
            }
            return super.I();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null && !TextUtils.isEmpty(f0.appName)) {
                return f0.appName;
            }
            return super.K();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null && !TextUtils.isEmpty(f0.iconUrl)) {
                return f0.iconUrl;
            }
            return super.Q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public int d0() {
        InterceptResult invokeV;
        int orientation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                orientation = -1;
            } else {
                orientation = f0.getOrientation();
            }
            if (-1 >= orientation) {
                return super.d0();
            }
            return orientation;
        }
        return invokeV.intValue;
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.description;
        }
        return (String) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0;
            }
            return f0.appStatus;
        }
        return invokeV.intValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.statusDetail;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo2
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0;
            }
            return f0.type;
        }
        return invokeV.intValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public long i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return 0L;
            }
            return f0.pkgSize;
        }
        return invokeV.longValue;
    }

    public SwanAppBearInfo k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return null;
            }
            String str = f0.bearInfo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new SwanAppBearInfo(str);
        }
        return (SwanAppBearInfo) invokeV.objValue;
    }

    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            }
            return f0.payProtected;
        }
        return invokeV.intValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return null;
            }
            return f0.quickAppKey;
        }
        return (String) invokeV.objValue;
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.resumeDate;
        }
        return (String) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.serviceCategory;
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.subjectInfo;
        }
        return (String) invokeV.objValue;
    }

    public long u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return String.valueOf(f0.versionCode);
        }
        return (String) invokeV.objValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 == null) {
                return "";
            }
            return f0.versionName;
        }
        return (String) invokeV.objValue;
    }

    public static jo2 d1(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            boolean z = e;
            return new a().update(intent);
        }
        return (jo2) invokeL.objValue;
    }

    public static String x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
                return str.substring(1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public jo2 A1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appKey = str;
            }
            return (jo2) super.w0(str);
        }
        return (jo2) invokeL.objValue;
    }

    public jo2 B1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appName = str;
            }
            return (jo2) super.x0(str);
        }
        return (jo2) invokeL.objValue;
    }

    public jo2 C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            super.E0(str);
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.iconUrl = str;
                return (jo2) super.E0(str);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mo2
    /* renamed from: D1 */
    public jo2 Q0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.setOrientation(i);
                return (jo2) super.Q0(i);
            }
            return (jo2) a();
        }
        return (jo2) invokeI.objValue;
    }

    public jo2 E1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.serviceCategory = str;
                return (jo2) super.U0(str);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    public jo2 F1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.subjectInfo = str;
                return (jo2) super.W0(str);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    public jo2 G1(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (this.d < 1 && j > 0) {
                this.d = j;
                return (jo2) super.Y0(j);
            }
            return (jo2) a();
        }
        return (jo2) invokeJ.objValue;
    }

    public jo2 y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.description = str;
                return (jo2) super.t0(str);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mo2
    /* renamed from: z1 */
    public jo2 v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            super.v0(str);
            PMSAppInfo f0 = f0();
            if (f0 != null) {
                f0.appId = str;
                return (jo2) super.v0(str);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    public static String l1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, swanAppConfigData)) == null) {
            if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
                return null;
            }
            String f = eh3.f(str);
            if (ty2.k(f)) {
                return eh3.i(str, n73.b);
            }
            if (!swanAppConfigData.p(e73.b(f))) {
                return null;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String m1(jo2 jo2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jo2Var, swanAppConfigData)) == null) {
            return l1(x1(jo2Var.e0()), swanAppConfigData);
        }
        return (String) invokeLL.objValue;
    }

    public static String n1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, swanAppConfigData)) == null) {
            if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
                return l1(x1(o1(str)), swanAppConfigData);
            }
            if (e) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
                return null;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String o1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            String j = eh3.j(parse);
            if (TextUtils.isEmpty(j)) {
                if (e) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
                }
                return null;
            }
            String n = eh3.n(j, parse, true);
            if (TextUtils.isEmpty(n)) {
                if (e) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
                }
                return null;
            }
            String i = eh3.i(parse.getEncodedQuery(), n73.b);
            if (e) {
                Log.d("SwanAppLaunchInfo", "query: " + i);
            }
            if (!TextUtils.isEmpty(i)) {
                n = n + "?" + i;
            }
            if (e) {
                Log.d("SwanAppLaunchInfo", "launch path - " + n);
            }
            return n;
        }
        return (String) invokeL.objValue;
    }

    public jo2 H1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            PMSAppInfo f0 = f0();
            if (!TextUtils.isEmpty(str) && f0 != null) {
                try {
                    f0.versionCode = Integer.parseInt(str);
                    return (jo2) super.b1(str);
                } catch (NumberFormatException e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    public jo2 update(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, intent)) == null) {
            if (intent == null) {
                return (jo2) a();
            }
            update(intent.getExtras());
            if (lo2.a(intent)) {
                I0("1250000000000000");
                x("box_cold_launch", -1L);
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }

    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "SwanAppLaunchInfo{mAppId='" + H() + "', mAppKey='" + I() + "', mAppTitle='" + K() + "', pmsAppInfo is null='" + l0() + "', launchFrom='" + T() + "', launchScheme='" + W() + "', page='" + e0() + "', mErrorCode=" + f1() + ", mErrorDetail='" + g1() + "', mErrorMsg='" + h1() + "', mResumeDate='" + r1() + "', maxSwanVersion='" + Z() + "', minSwanVersion='" + a0() + "', mVersion='" + v1() + "', mType=" + getType() + ", extraData=" + P() + ", isDebug=" + n0() + ", isLocalDebug=" + p0() + ", targetSwanVersion='" + k0() + "', swanCoreVersion=" + j0() + ", appFrameType=" + G() + ", consoleSwitch=" + m0() + ", orientation=" + d0() + ", versionCode='" + w1() + "', launchFlags=" + S() + ", swanAppStartTime=" + u1() + ", extStartTimestamp=" + N() + ", remoteDebug='" + g0() + "', extJSonObject=" + M() + ", launchId=" + V() + '}';
        }
        return (String) invokeV.objValue;
    }

    public JSONObject j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String W = W();
            if (W != null) {
                String queryParameter = Uri.parse(W).getQueryParameter("_swaninfo");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return new JSONObject(queryParameter).optJSONObject("baidusearch");
                    } catch (JSONException e2) {
                        if (e) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.po2
    public jo2 update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bundle)) == null) {
            if (bundle == null) {
                return (jo2) a();
            }
            p02.h(bundle);
            tw2.e().h(bundle);
            super.update(bundle);
            if (TextUtils.isEmpty(bundle.getString("mPage"))) {
                B("mPage");
            }
            return (jo2) a();
        }
        return (jo2) invokeL.objValue;
    }
}

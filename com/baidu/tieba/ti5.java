package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ModifyClass
/* loaded from: classes6.dex */
public class ti5 {
    public static /* synthetic */ Interceptable $ic;
    public static ti5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948182185, "Lcom/baidu/tieba/ti5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948182185, "Lcom/baidu/tieba/ti5;");
        }
    }

    @Modify(description = "广告-热启动是否开启debug模式", type = 33)
    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static double i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public static String m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i != -1) {
                return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "PLG_Other" : "PLG_CPC" : "PLG_OperateHighly" : "PLG_OperateNormal" : "PLG_GD";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public ti5() {
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

    @Modify(description = "广告-禁止初始化穿山甲", type = 33)
    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (ry4.l().m("key_fun_cjs_init", 1) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化广点通", type = 33)
    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ry4.l().m("key_fun_gdt_init", 1) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化快手", type = 33)
    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (ry4.l().m("key_fun_ks_init", 1) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-FRS页面混排广告条数", type = 33)
    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return ry4.l().m("key_mix_frs_ad_count", 5);
        }
        return invokeV.intValue;
    }

    public static synchronized ti5 j() {
        InterceptResult invokeV;
        ti5 ti5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (ti5.class) {
                if (a == null) {
                    a = new ti5();
                }
                ti5Var = a;
            }
            return ti5Var;
        }
        return (ti5) invokeV.objValue;
    }

    public static int k() {
        InterceptResult invokeV;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int s = s();
            int t = t();
            if (s == t || (min = Math.min(s, t)) <= 0 || min >= 10000) {
                return 1000;
            }
            return min;
        }
        return invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            int s = s();
            int t = t();
            if (s == t || (max = Math.max(s, t)) <= 0 || max >= 10000) {
                return 1400;
            }
            return max;
        }
        return invokeV.intValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (w()) {
                if (te1.b() && u()) {
                    return true;
                }
                return false;
            }
            return u();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏广告第一次超时时间(新)", type = 33)
    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return ry4.l().m("key_splash_new_policy_first_timeout", 1000);
        }
        return invokeV.intValue;
    }

    @Modify(description = "广告-开屏广告第二次超时时间(新)", type = 33)
    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return ry4.l().m("key_splash_new_policy_second_timeout", 1400);
        }
        return invokeV.intValue;
    }

    @Modify(description = "广告-开屏是否展示小熊开关(新)", type = 33)
    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (ry4.l().m("key_splash_new_policy_bear_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章CPC开关(新)", type = 33)
    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (ry4.l().m("key_splash_new_policy_plg_cpc_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章开关(新)", type = 33)
    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (ry4.l().m("key_splash_new_policy_plg_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
        }
        return (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String h = h();
            if (!TextUtils.isEmpty(h)) {
                tg.h().k(h, 10, null, 0, 0, null, new Object[0]);
            }
        }
    }

    public static String g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            List<ux6> j = vx6.m().j(str);
            JSONArray jSONArray = new JSONArray();
            for (ux6 ux6Var : j) {
                for (int i2 = 0; i2 < ux6Var.e && jSONArray.length() < i; i2++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ux6Var.d + i2);
                        jSONObject.put("ecpm", String.valueOf(ux6Var.f));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return qi.j(jSONArray.toString().getBytes(StandardCharsets.UTF_8));
        }
        return (String) invokeLI.objValue;
    }

    public long b(File file, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
            long j = 0;
            if (TextUtils.isEmpty(str) || file == null) {
                return 0L;
            }
            InputStream inputStream = null;
            try {
                Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
                if (executeSync != null && executeSync.code() == 200) {
                    InputStream byteStream = executeSync.body().byteStream();
                    if (byteStream != null) {
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                j = FileUtils.copyStream(byteStream, fileOutputStream);
                            } catch (Exception e) {
                                e = e;
                                inputStream = byteStream;
                                try {
                                    TiebaStatic.log(e.toString());
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    return j;
                                } catch (Throwable th) {
                                    th = th;
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = byteStream;
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    inputStream = byteStream;
                } else {
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(fileOutputStream);
            return j;
        }
        return invokeLL.longValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (!UbsABTestHelper.isFrsFunAdSdkTest()) {
                return false;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z || o(str) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(Object obj) {
        InterceptResult invokeL;
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) {
            if (obj instanceof jt4) {
                return true;
            }
            if (obj instanceof yu4) {
                ks8Var = ((yu4) obj).t.funAdData;
            } else if (obj instanceof ThreadData) {
                ks8Var = ((ThreadData) obj).funAdData;
            } else if (obj instanceof PostData) {
                ks8Var = ((PostData) obj).v0;
            } else {
                ks8Var = null;
            }
            if (ks8Var != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            int i = 0;
            for (ux6 ux6Var : vx6.m().j(str)) {
                i += ux6Var.e;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Modify(description = "广告-是否需要请求frs页面的小熊广告", type = 33)
    public static boolean r() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (ry4.l().m("splash_origin_ad_strategy_key", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && !z2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

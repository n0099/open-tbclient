package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BaiduBqtInitSwitch;
import com.baidu.tbadk.switchs.GdtInitSwitch;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
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
/* loaded from: classes7.dex */
public class pq5 {
    public static /* synthetic */ Interceptable $ic;
    public static pq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948070709, "Lcom/baidu/tieba/pq5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948070709, "Lcom/baidu/tieba/pq5;");
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

    public static double h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public static String l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i != -1) {
                return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "PLG_Other" : "PLG_CPC" : "PLG_OperateHighly" : "PLG_OperateNormal" : "PLG_GD";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public pq5() {
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

    @Modify(description = "广告-禁止初始化百度百青藤", type = 33)
    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return !BaiduBqtInitSwitch.isOn();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化广点通", type = 33)
    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return !GdtInitSwitch.isOn();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-FRS页面混排广告条数", type = 33)
    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return SharedPrefHelper.getInstance().getInt("key_mix_frs_ad_count", 5);
        }
        return invokeV.intValue;
    }

    public static synchronized pq5 i() {
        InterceptResult invokeV;
        pq5 pq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (pq5.class) {
                if (a == null) {
                    a = new pq5();
                }
                pq5Var = a;
            }
            return pq5Var;
        }
        return (pq5) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            int r = r();
            int s = s();
            if (r == s || (min = Math.min(r, s)) <= 0 || min >= 10000) {
                return 1000;
            }
            return min;
        }
        return invokeV.intValue;
    }

    public static int k() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int r = r();
            int s = s();
            if (r == s || (max = Math.max(r, s)) <= 0 || max >= 10000) {
                return 1400;
            }
            return max;
        }
        return invokeV.intValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (v()) {
                if (fe1.b() && t()) {
                    return true;
                }
                return false;
            }
            return t();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏广告第一次超时时间(新)", type = 33)
    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return SharedPrefHelper.getInstance().getInt("key_splash_new_policy_first_timeout", 1000);
        }
        return invokeV.intValue;
    }

    @Modify(description = "广告-开屏广告第二次超时时间(新)", type = 33)
    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return SharedPrefHelper.getInstance().getInt("key_splash_new_policy_second_timeout", 1400);
        }
        return invokeV.intValue;
    }

    @Modify(description = "广告-开屏是否展示小熊开关(新)", type = 33)
    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("key_splash_new_policy_bear_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章CPC开关(新)", type = 33)
    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("key_splash_new_policy_plg_cpc_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章开关(新)", type = 33)
    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("key_splash_new_policy_plg_enable", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
        }
        return (String) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String g = g();
            if (!TextUtils.isEmpty(g)) {
                BdResourceLoader.getInstance().loadResource(g, 10, null, 0, 0, null, new Object[0]);
            }
        }
    }

    public static String f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            List<us7> j = vs7.m().j(str);
            JSONArray jSONArray = new JSONArray();
            for (us7 us7Var : j) {
                for (int i2 = 0; i2 < us7Var.e && jSONArray.length() < i; i2++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", us7Var.d + i2);
                        jSONObject.put(SplashAd.KEY_BIDFAIL_ECPM, String.valueOf(us7Var.f));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return tc.j(jSONArray.toString().getBytes(StandardCharsets.UTF_8));
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

    public static boolean m(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (!UbsABTestHelper.isFrsFunAdSdkTest()) {
                return false;
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z || n(str) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(Object obj) {
        InterceptResult invokeL;
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) {
            if (obj instanceof bx4) {
                return true;
            }
            if (obj instanceof py4) {
                neaVar = ((py4) obj).t.funAdData;
            } else if (obj instanceof ThreadData) {
                neaVar = ((ThreadData) obj).funAdData;
            } else if (obj instanceof pea) {
                neaVar = ((pea) obj).y0;
            } else {
                neaVar = null;
            }
            if (neaVar != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            int i = 0;
            for (us7 us7Var : vs7.m().j(str)) {
                i += us7Var.e;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Modify(description = "广告-是否需要请求frs页面的小熊广告", type = 33)
    public static boolean q() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("splash_origin_ad_strategy_key", 1) == 1) {
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

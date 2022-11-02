package com.baidu.tieba;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes6.dex */
public class zw4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;
    public static boolean b = false;
    public static String c = null;
    public static int d = 0;
    public static String e = null;
    public static int f = 99;
    public static int g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948374354, "Lcom/baidu/tieba/zw4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948374354, "Lcom/baidu/tieba/zw4;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            h(TbadkCoreApplication.getInst());
            i();
            int i = 1;
            if (g >= 1) {
                i = 2;
            }
            c("c14483", 0, i);
        }
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            i();
            return g;
        }
        return invokeV.intValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && g < 0) {
            g = ky4.k().l("app_restart_times", 0);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            e = c;
            f = d;
            r();
        }
    }

    public static void b(Context context) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (g < 0) {
                g = context.getSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, 0).getInt("app_restart_times", 0);
            }
            h(context);
            if (g < 1) {
                i = 1;
            } else {
                i = 2;
            }
            d("c14429", 1, i);
        }
    }

    public static void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j) == null) {
            i();
            int i = 2;
            StatisticItem addParam = new StatisticItem("c14429").addParam("obj_type", 2);
            if (g < 1) {
                i = 1;
            }
            TiebaStatic.log(addParam.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
        }
    }

    public static void c(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void d(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            String str2 = str + "_lastTime";
            long j = a.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j)));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.putLong(str2, currentTimeMillis);
            edit.commit();
        }
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = "";
            if (f == 99) {
                String c2 = kb5.c();
                if (wi.isEmpty(c2)) {
                    return "";
                }
                return c2;
            }
            if (!StringUtils.isNull(e)) {
                str = e;
            }
            return wi.getUrlEncode(str);
        }
        return (String) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            i();
            StatisticItem statisticItem = new StatisticItem("c14484");
            int i = 1;
            if (g >= 1) {
                i = 2;
            }
            TiebaStatic.log(statisticItem.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void m() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_type", dx4.a().b());
            if (dx4.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(addParam.addParam("obj_param1", i).addParam("obj_source", 6));
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            i();
            h(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            q("c14429", edit);
            q("c14483", edit);
            q("c14482", edit);
            a = null;
        }
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString != null && dataString.startsWith("custom")) {
                StringBuilder sb = new StringBuilder();
                sb.append(dataString);
                sb.append(".action.");
                sb.append(intent.getAction());
                if (intent.getCategories() != null) {
                    sb.append("categories.");
                    for (String str : intent.getCategories()) {
                        sb.append(str);
                        sb.append(".");
                    }
                }
                return sb.toString();
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    public static void u(Activity activity) {
        ActivityManager activityManager;
        ActivityManager.AppTask appTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, null, activity) == null) && activity != null && activity.getClass() != null && Build.VERSION.SDK_INT >= 23 && (activityManager = (ActivityManager) activity.getSystemService("activity")) != null && (appTask = (ActivityManager.AppTask) ListUtils.getItem(activityManager.getAppTasks(), 0)) != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null && activity.getClass().getName().equals(appTask.getTaskInfo().baseActivity.getClassName())) {
            String g2 = g(appTask.getTaskInfo().baseIntent);
            s(g2, wi.isEmpty(g2));
            w();
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void l(String str, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            i();
            StatisticItem statisticItem = new StatisticItem("c14430");
            int i3 = 2;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem addParam = statisticItem.addParam("obj_type", i);
            if (g < 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_source", i2);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                i3 = 1;
            }
            TiebaStatic.log(addParam2.addParam("obj_param1", i3).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
        }
    }

    public static void t(AppLaunchInfoFetcher.Type type, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65556, null, type, intent) != null) || f < 99) {
            return;
        }
        if (type == AppLaunchInfoFetcher.Type.BROADCAST) {
            d = 98;
            c = "CallReceiver";
        } else if (type == AppLaunchInfoFetcher.Type.SERVICE) {
            d = 98;
            c = "CallService";
        } else if (type == AppLaunchInfoFetcher.Type.ACTIVITY) {
            if (intent != null) {
                String dataString = intent.getDataString();
                s(dataString, wi.isEmpty(dataString));
            } else {
                v("intent=null", 100);
            }
        } else {
            d = 101;
            c = "START_TYPE_FOR_UNKNOWN";
        }
        w();
    }

    public static void n(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", dx4.a().b());
            if (dx4.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 8);
            if (dx4.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void o(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", dx4.a().b());
            if (dx4.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 7);
            if (dx4.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void q(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65553, null, str, editor) != null) || (stringSet = a.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null) {
                if (split.length == 3) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
                } else if (split.length == 4) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]).addParam(TiebaStatic.Params.OBJ_PARAM4, split[3]));
                }
            }
        }
        editor.remove(str).apply();
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", f + "");
            hashMap.put("start_scheme", e());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void s(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65555, null, str, z) == null) {
            c = str;
            d = z ? 1 : 0;
        }
    }

    @Deprecated
    public static void v(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65558, null, str, i) == null) {
            int i2 = f;
            if (i2 == 99 || i2 == 100) {
                d = i;
                c = str;
                w();
            }
        }
    }
}

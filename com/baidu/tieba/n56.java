package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.PrintStream;
/* loaded from: classes7.dex */
public class n56 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 0;
    public static String b = "5";
    public static String c = "6";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947953498, "Lcom/baidu/tieba/n56;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947953498, "Lcom/baidu/tieba/n56;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(h56.b);
            if (file.exists()) {
                FileHelper.deleteFileOrDir(file);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", "").apply();
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).getString("bc_splash_info_new", "");
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - a;
            if (0 < j && j < 500) {
                return true;
            }
            a = currentTimeMillis;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void b(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            File file2 = new File(h56.b);
            if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3 != null && !file3.equals(file)) {
                    FileHelper.deleteFileOrDir(file3);
                }
            }
        }
    }

    public static void f(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, adInfo) == null) {
            TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", p46.a(adInfo).toString()).apply();
        }
    }

    public static void g(p46 p46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, p46Var) == null) {
            if (p46Var == null) {
                c();
            } else {
                TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info_new", 0).edit().putString("bc_splash_info_new", p46Var.toString()).apply();
            }
        }
    }

    public static void h(String str, String str2, String str3, String str4, int i, int i2, boolean z, long j) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param("resource_id", Math.max(i2, 0));
            if (z) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            StatisticItem param2 = param.param("obj_param1", i3).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, j);
            if (!StringUtils.isNull(str3)) {
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            }
            if (StringUtils.isNull(str4)) {
                param2.param(TiebaStatic.Params.OBJ_TO, str4);
            }
            TiebaStatic.log(param2);
        }
    }

    public static void i(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, str2, str3, str4, str5, str6, Long.valueOf(j)}) == null) {
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", str).param("obj_type", "a064").param("obj_locate", str2).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, j);
            if (!StringUtils.isNull(str4)) {
                param.param(TiebaStatic.Params.OBJ_TO, str4);
            }
            if (!StringUtils.isNull(str3)) {
                param.param("topic_id", str3);
            }
            if (!StringUtils.isNull(str5)) {
                param.param("obj_param1", str5);
                if (TbadkCoreApplication.getInst().isDebugMode() || GlobalBuildConfig.isTiebaDebugTool()) {
                    PrintStream printStream = System.out;
                    printStream.println("TbFunAdSdk show sid:" + str5 + " aid:" + str4 + " adAppId:" + str6);
                }
            }
            if (!StringUtils.isNull(str6)) {
                param.param(TiebaStatic.Params.OBJ_PARAM2, str6);
            }
            TiebaStatic.log(param);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0056 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    public static File j(Context context, Uri uri) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, uri)) == null) {
            ?? r1 = 0;
            if (context == null || uri == null) {
                return null;
            }
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (contentResolver == null) {
                    return null;
                }
                try {
                    cursor = contentResolver.query(uri, new String[]{"_id", "_data"}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                if (TextUtils.isEmpty(string)) {
                                    Closeables.closeSafely(cursor);
                                    return null;
                                }
                                Uri parse = Uri.parse(string);
                                if (parse != null) {
                                    String uri2 = parse.toString();
                                    if (!TextUtils.isEmpty(uri2)) {
                                        File file = new File(uri2);
                                        Closeables.closeSafely(cursor);
                                        return file;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            Closeables.closeSafely(cursor);
                            return null;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely((Cursor) r1);
                    throw th;
                }
                Closeables.closeSafely(cursor);
                return null;
            } catch (Throwable th2) {
                th = th2;
                r1 = context;
            }
        } else {
            return (File) invokeLL.objValue;
        }
    }
}

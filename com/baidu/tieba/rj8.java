package com.baidu.tieba;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rj8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1500;
    public static int b = 500;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948123657, "Lcom/baidu/tieba/rj8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948123657, "Lcom/baidu/tieba/rj8;");
        }
    }

    public static void a() {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (!StrangeCleanSwitch.isOn()) {
                Logger.addLog("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
                return;
            }
            try {
                try {
                    lj8.d().f();
                    d = d();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                boolean b2 = b(d);
                Logger.addLog("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + b2, new Object[0]);
            } finally {
                lj8.d().b();
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                lj8 d = lj8.d();
                return d.c("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteStrange", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return SharedPrefHelper.getInstance().getInt("key_max_stranger", a);
        }
        return invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        List<String> e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                e = e();
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getStrangeData", new Object[0]);
            }
            if (e != null && e.size() != 0) {
                int c = c();
                Logger.addLog("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + e.size() + " max is " + c, new Object[0]);
                if (e.size() > c) {
                    int i = 2000;
                    if (2000 >= e.size() - c) {
                        i = e.size() - c;
                    }
                    boolean z = true;
                    for (String str : e.subList(0, i)) {
                        if (!z) {
                            sb.append(",");
                        } else {
                            z = false;
                        }
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = lj8.d().e("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(cursor.getString(cursor.getColumnIndex(TbEnum.ParamKey.GID)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
                }
                return arrayList;
            } finally {
                ei.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public static void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            int i2 = b;
            if (i < i2) {
                i = i2;
            }
            SharedPrefHelper.getInstance().putInt("key_max_stranger", i);
        }
    }
}

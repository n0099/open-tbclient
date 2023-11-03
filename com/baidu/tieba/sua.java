package com.baidu.tieba;

import android.app.Application;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes8.dex */
public class sua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RemindRecommendMessage a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                RemindRecommendMessage remindRecommendMessage = new RemindRecommendMessage();
                JSONObject jSONObject = new JSONObject(str);
                remindRecommendMessage.title = jSONObject.optString("title");
                remindRecommendMessage.url = jSONObject.optString("url");
                remindRecommendMessage.picture = jSONObject.optString("picture");
                remindRecommendMessage.name = jSONObject.optString("name");
                remindRecommendMessage.isLocal = false;
                return remindRecommendMessage;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (RemindRecommendMessage) invokeL.objValue;
    }

    public static String g(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dataRes)) == null) {
            if (dataRes != null && dataRes.local_dialog != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", dataRes.local_dialog.title);
                    jSONObject.put("picture", dataRes.local_dialog.picture);
                    jSONObject.put("url", dataRes.local_dialog.url);
                    jSONObject.put("name", dataRes.local_dialog.name);
                    return jSONObject.toString();
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("sync_local_dialog", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static long c(long j) {
        InterceptResult invokeJ;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            String str = "12:05:00";
            String loadString = TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_dialog_time", "12:05:00");
            if (!TextUtils.isEmpty(loadString)) {
                str = loadString;
            }
            String[] split = str.split(":");
            int i4 = 5;
            if (split != null && split.length == 3) {
                i2 = JavaTypesHelper.toInt(split[0], 12);
                i3 = JavaTypesHelper.toInt(split[1], 5);
                i = JavaTypesHelper.toInt(split[2], 0);
            } else {
                i = 0;
                i2 = 12;
                i3 = 5;
            }
            if (i2 >= 0 && i2 <= 23 && i3 >= 0 && i3 <= 59 && i >= 0 && i <= 59) {
                i4 = i3;
            } else {
                i = 0;
                i2 = 12;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.set(12, i4);
            calendar.set(13, i);
            Application app = TbadkCoreApplication.getInst().getApp();
            if (app != null && app.getContentResolver() != null && DateFormat.is24HourFormat(app)) {
                calendar.set(11, i2);
            } else {
                if (i2 >= 12) {
                    i2 -= 12;
                    calendar.set(9, 1);
                } else {
                    calendar.set(9, 0);
                }
                calendar.set(10, i2);
            }
            return calendar.getTimeInMillis();
        }
        return invokeJ.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TbadkSettings.getInst().loadInt(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_server_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            Time time = new Time();
            time.set(j);
            int i = time.year;
            int i2 = time.month;
            int i3 = time.monthDay;
            time.set(System.currentTimeMillis());
            if (i == time.year && i2 == time.month && i3 == time.monthDay) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}

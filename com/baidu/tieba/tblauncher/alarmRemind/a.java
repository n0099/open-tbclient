package com.baidu.tieba.tblauncher.alarmRemind;

import android.app.Application;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.tencent.open.SocialConstants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes22.dex */
public class a {
    public static boolean dzJ() {
        return TbadkSettings.getInst().loadInt(new StringBuilder().append(TbadkCoreApplication.getCurrentAccount()).append(SharedPrefConfig.REMIND_RECOMMEND_SERVER_SWITCH).toString(), 1) == 1;
    }

    public static RemindRecommendMessage SW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            RemindRecommendMessage remindRecommendMessage = new RemindRecommendMessage();
            JSONObject jSONObject = new JSONObject(str);
            remindRecommendMessage.title = jSONObject.optString("title");
            remindRecommendMessage.url = jSONObject.optString("url");
            remindRecommendMessage.picture = jSONObject.optString(SocialConstants.PARAM_AVATAR_URI);
            remindRecommendMessage.name = jSONObject.optString("name");
            remindRecommendMessage.isLocal = false;
            return remindRecommendMessage;
        } catch (JSONException e) {
            return null;
        }
    }

    public static String c(DataRes dataRes) {
        if (dataRes == null || dataRes.local_dialog == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", dataRes.local_dialog.title);
            jSONObject.put(SocialConstants.PARAM_AVATAR_URI, dataRes.local_dialog.picture);
            jSONObject.put("url", dataRes.local_dialog.url);
            jSONObject.put("name", dataRes.local_dialog.name);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    public static long gE(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        String loadString = TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_RECOMMEND_DLALOG_TIME, "12:05:00");
        if (TextUtils.isEmpty(loadString)) {
            loadString = "12:05:00";
        }
        String[] split = loadString.split(":");
        if (split == null || split.length != 3) {
            i = 0;
            i2 = 5;
            i3 = 12;
        } else {
            i3 = com.baidu.adp.lib.f.b.toInt(split[0], 12);
            i2 = com.baidu.adp.lib.f.b.toInt(split[1], 5);
            i = com.baidu.adp.lib.f.b.toInt(split[2], 0);
        }
        if (i3 < 0 || i3 > 23 || i2 < 0 || i2 > 59 || i < 0 || i > 59) {
            i = 0;
            i2 = 5;
            i4 = 12;
        } else {
            i4 = i3;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(12, i2);
        calendar.set(13, i);
        Application app = TbadkCoreApplication.getInst().getApp();
        if (app != null && app.getContentResolver() != null && DateFormat.is24HourFormat(app)) {
            calendar.set(11, i4);
        } else {
            if (i4 >= 12) {
                i4 -= 12;
                calendar.set(9, 1);
            } else {
                calendar.set(9, 0);
            }
            calendar.set(10, i4);
        }
        return calendar.getTimeInMillis();
    }

    public static long dJR() {
        return gE(System.currentTimeMillis());
    }

    public static boolean isTaday(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }

    public static boolean dJS() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.SYNC_LOCAL_DOALOG, 1) == 1;
    }
}

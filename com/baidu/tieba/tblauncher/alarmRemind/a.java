package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class a {
    public static boolean ayP() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    public static RemindRecommendMessage mI(String str) {
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
            jSONObject.put("picture", dataRes.local_dialog.picture);
            jSONObject.put("url", dataRes.local_dialog.url);
            jSONObject.put("name", dataRes.local_dialog.name);
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    public static long bM(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        String loadString = TbadkSettings.getInst().loadString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_dialog_time", "12:05:00");
        if (TextUtils.isEmpty(loadString)) {
            loadString = "12:05:00";
        }
        String[] split = loadString.split(":");
        if (split == null || split.length != 3) {
            i = 0;
            i2 = 5;
            i3 = 12;
        } else {
            i3 = com.baidu.adp.lib.h.b.g(split[0], 12);
            i2 = com.baidu.adp.lib.h.b.g(split[1], 5);
            i = com.baidu.adp.lib.h.b.g(split[2], 0);
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
        if (DateFormat.is24HourFormat(TbadkCoreApplication.m411getInst().getApp())) {
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

    public static long aHk() {
        return bM(System.currentTimeMillis());
    }

    public static boolean bN(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }

    public static boolean aHl() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getInt("sync_local_dialog", 1) == 1;
    }
}

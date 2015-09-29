package com.baidu.tieba.tblauncher.alarmRemind;

import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Pair;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tieba.i;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class a {
    public static final HashMap<Integer, Pair<String, String>> dda = new HashMap<>();

    static {
        dda.put(0, new Pair<>("川藏线明信片，一路新奇视界，送给亲爱的你", "twzb:pid=4005265545"));
        dda.put(1, new Pair<>("参加哥们婚礼，结果发现他老婆不是人……", "twzb:pid=4008011749"));
        dda.put(2, new Pair<>("详述我和DotA不得不说的故事", "twzb:pid=4005340036"));
        dda.put(3, new Pair<>("九岁那年，爷爷给我找个漂亮女鬼做媳妇……", "twzb:pid=4011574531"));
        dda.put(4, new Pair<>("古代人豪无节操，无下限的毁你所有三观！", "twzb:pid=4010449631"));
        dda.put(5, new Pair<>("国漫的崛起，国漫不再是只给未成年看的，未来可能看到的巅峰国", "http://tieba.baidu.com/p/3859340532"));
        dda.put(6, new Pair<>("讲述:第一次给奇葩相亲女发好人卡", "http://tieba.baidu.com/p/3871991340"));
    }

    public static RemindRecommendMessage ayC() {
        int i = 0;
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_index";
        int loadInt = TbadkSettings.getInst().loadInt(str, 0);
        if (dda == null || dda.size() < 1) {
            return null;
        }
        int i2 = (loadInt < 0 || loadInt >= dda.size()) ? 0 : loadInt;
        RemindRecommendMessage remindRecommendMessage = new RemindRecommendMessage();
        Pair<String, String> pair = dda.get(Integer.valueOf(i2));
        if (pair != null) {
            remindRecommendMessage.title = (String) pair.first;
            remindRecommendMessage.url = (String) pair.second;
            remindRecommendMessage.picture = "";
            remindRecommendMessage.name = TbadkCoreApplication.m411getInst().getString(i.h.remind_recommend_default);
            remindRecommendMessage.isLocal = true;
            int i3 = i2 + 1;
            if (i3 >= 0 && i3 < dda.size()) {
                i = i3;
            }
            TbadkSettings.getInst().saveInt(str, i);
        }
        return remindRecommendMessage;
    }

    public static boolean aqC() {
        return TbadkSettings.getInst().loadInt(new StringBuilder(String.valueOf(TbadkCoreApplication.getCurrentAccount())).append("remind_recommend_server_switch").toString(), 1) == 1;
    }

    public static RemindRecommendMessage lL(String str) {
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

    public static long ayD() {
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
            i3 = com.baidu.adp.lib.g.b.g(split[0], 12);
            i2 = com.baidu.adp.lib.g.b.g(split[1], 5);
            i = com.baidu.adp.lib.g.b.g(split[2], 0);
        }
        if (i3 < 0 || i3 > 23 || i2 < 0 || i2 > 59 || i < 0 || i > 59) {
            i = 0;
            i2 = 5;
            i4 = 12;
        } else {
            i4 = i3;
        }
        Calendar calendar = Calendar.getInstance();
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
}

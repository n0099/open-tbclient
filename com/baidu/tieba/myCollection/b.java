package com.baidu.tieba.myCollection;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class b {
    private static b fGM;
    private volatile boolean fGN = false;

    private b() {
    }

    public static b bdn() {
        if (fGM == null) {
            synchronized (b.class) {
                if (fGM == null) {
                    fGM = new b();
                }
            }
        }
        return fGM;
    }

    public void jV(boolean z) {
        this.fGN = z;
    }

    public void jW(boolean z) {
        if (this.fGN) {
            z = false;
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void bdo() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("collect_request_time_key", System.currentTimeMillis());
    }

    public boolean bdp() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("collect_request_time_key", -1L);
        if (j == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
    }

    public void bdq() {
        if (bdp()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            bdo();
        }
    }

    public void bdr() {
        Context context;
        Calendar bds = bds();
        if (bds != null && (context = TbadkCoreApplication.getInst().getContext()) != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
            intent.setPackage(context.getPackageName());
            Calendar calendar = Calendar.getInstance();
            calendar.set(14, 0);
            if (bds.before(calendar)) {
                bds.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, bds.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
        }
    }

    private Calendar bds() {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("collect_update_time_key", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        try {
            JSONArray jSONArray = new JSONArray(string);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    Calendar calendar2 = (Calendar) calendar.clone();
                    calendar2.setTime(simpleDateFormat.parse(optString));
                    calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5));
                    arrayList.add(calendar2);
                }
            }
        } catch (ParseException e) {
            BdLog.e(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<Calendar>() { // from class: com.baidu.tieba.myCollection.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(Calendar calendar3, Calendar calendar4) {
                return calendar3.before(calendar4) ? -1 : 1;
            }
        });
        Calendar calendar3 = (Calendar) arrayList.get(0);
        Calendar calendar4 = (Calendar) arrayList.get(arrayList.size() - 1);
        if (arrayList.size() != 1 && !calendar3.after(calendar) && !calendar4.before(calendar)) {
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                Calendar calendar5 = (Calendar) arrayList.get(i2);
                if (!calendar5.before(calendar)) {
                    return calendar5;
                }
            }
            return null;
        }
        return calendar3;
    }
}

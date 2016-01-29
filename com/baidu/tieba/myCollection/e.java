package com.baidu.tieba.myCollection;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class e {
    private static e cEE;
    private volatile boolean cEF = false;

    private e() {
    }

    public static e ana() {
        if (cEE == null) {
            synchronized (e.class) {
                if (cEE == null) {
                    cEE = new e();
                }
            }
        }
        return cEE;
    }

    public void eM(boolean z) {
        this.cEF = z;
    }

    public void eN(boolean z) {
        if (this.cEF) {
            z = false;
        }
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void anb() {
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("collect_request_time_key", System.currentTimeMillis());
    }

    public boolean anc() {
        long j = com.baidu.tbadk.core.sharedPref.b.uO().getLong("collect_request_time_key", -1L);
        if (j == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
    }

    public void and() {
        if (anc()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            anb();
        }
    }

    public void ane() {
        Context context;
        Calendar anf = anf();
        if (anf != null && (context = TbadkCoreApplication.m411getInst().getContext()) != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
            intent.setClass(context, CollectUpdateReceiver.class);
            Calendar calendar = Calendar.getInstance();
            calendar.set(14, 0);
            if (anf.before(calendar)) {
                anf.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, anf.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
        }
    }

    private Calendar anf() {
        String string = com.baidu.tbadk.core.sharedPref.b.uO().getString("collect_update_time_key", null);
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
        Collections.sort(arrayList, new f(this));
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

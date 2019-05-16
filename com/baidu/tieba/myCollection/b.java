package com.baidu.tieba.myCollection;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class b {
    private static b hrP;
    private volatile boolean hrQ = false;

    private b() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117) { // from class: com.baidu.tieba.myCollection.b.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                List<String> list = Collections.EMPTY_LIST;
                if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
                    list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
                } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
                    list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
                }
                if (!list.isEmpty()) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("collect_update_time_key", new JSONArray((Collection) list).toString());
                    b.bML().bMP();
                }
            }
        });
        com.baidu.tieba.tbadkCore.a.a.a(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, com.baidu.tieba.tbadkCore.a.a.bn("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static b bML() {
        if (hrP == null) {
            synchronized (b.class) {
                if (hrP == null) {
                    hrP = new b();
                }
            }
        }
        return hrP;
    }

    public void no(boolean z) {
        this.hrQ = z;
    }

    public void np(boolean z) {
        if (this.hrQ) {
            z = false;
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void bMM() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("collect_request_time_key", System.currentTimeMillis());
    }

    public boolean bMN() {
        long j = com.baidu.tbadk.core.sharedPref.b.agM().getLong("collect_request_time_key", -1L);
        if (j == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
    }

    public void bMO() {
        if (bMN()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            bMM();
        }
    }

    public void bMP() {
        Context context;
        Calendar bMQ = bMQ();
        if (bMQ != null && (context = TbadkCoreApplication.getInst().getContext()) != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
            intent.setPackage(context.getPackageName());
            Calendar calendar = Calendar.getInstance();
            calendar.set(14, 0);
            if (bMQ.before(calendar)) {
                bMQ.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, bMQ.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
        }
    }

    private Calendar bMQ() {
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("collect_update_time_key", null);
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
        Collections.sort(arrayList, new Comparator<Calendar>() { // from class: com.baidu.tieba.myCollection.b.2
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

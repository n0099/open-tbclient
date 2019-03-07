package com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.b.a {
    @Override // com.baidu.tbadk.b.a
    public String key() {
        return "interview/registerInterviewNotice";
    }

    @Override // com.baidu.tbadk.b.a, com.baidu.tbadk.b.f
    public h a(Object obj, HashMap<String, String> hashMap, String str) {
        long j;
        int i;
        Map.Entry<String, String> next;
        Context context = TbadkCoreApplication.getInst().getContext();
        h hVar = new h();
        hVar.bsH = str;
        if (obj instanceof com.baidu.tieba.lego.card.model.a) {
            com.baidu.tieba.lego.card.model.a aVar = (com.baidu.tieba.lego.card.model.a) obj;
            boolean bzR = aVar.bzR();
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(context, AlarmReceiver.class);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            intent.putExtra("uid", TbadkCoreApplication.getCurrentAccount());
            intent.setData(Uri.parse(currentAccount));
            int i2 = 0;
            long j2 = 0;
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            while (true) {
                j = j2;
                i = i2;
                if (!it.hasNext() || (next = it.next()) == null) {
                    break;
                }
                intent.putExtra(next.getKey(), next.getValue());
                if ("task_id".equals(next.getKey())) {
                    i = Integer.parseInt(next.getValue());
                } else if ("s_time".equals(next.getKey())) {
                    j = 1000 * Long.parseLong(next.getValue());
                }
                j2 = j;
                i2 = i;
            }
            am amVar = new am(aVar.bzT());
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, "");
            if (bzR) {
                amVar.bJ("obj_type", "2");
                BdToast.b(context, context.getString(d.j.interview_close_tip)).abh();
                PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 536870912);
                if (broadcast != null) {
                    alarmManager.cancel(broadcast);
                    broadcast.cancel();
                }
                hVar.result = false;
            } else {
                amVar.bJ("obj_type", "1");
                BdToast.b(context, context.getString(d.j.interview_open_tip)).abh();
                alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
                hVar.result = true;
            }
            TiebaStatic.log(amVar);
            aVar.lX(hVar.result);
        }
        return hVar;
    }
}

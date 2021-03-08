package com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
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
        hVar.eIa = str;
        if (obj instanceof com.baidu.tieba.lego.card.model.a) {
            com.baidu.tieba.lego.card.model.a aVar = (com.baidu.tieba.lego.card.model.a) obj;
            boolean dbS = aVar.dbS();
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
            ar arVar = new ar(aVar.dbU());
            arVar.dR("obj_id", "");
            if (dbS) {
                arVar.dR("obj_type", "2");
                BdToast.b(context, context.getString(R.string.interview_close_tip)).bqF();
                PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 536870912);
                if (broadcast != null) {
                    alarmManager.cancel(broadcast);
                    broadcast.cancel();
                }
                hVar.result = false;
            } else {
                arVar.dR("obj_type", "1");
                BdToast.b(context, context.getString(R.string.interview_open_tip)).bqF();
                alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
                hVar.result = true;
            }
            TiebaStatic.log(arVar);
            aVar.tG(hVar.result);
        }
        return hVar;
    }
}

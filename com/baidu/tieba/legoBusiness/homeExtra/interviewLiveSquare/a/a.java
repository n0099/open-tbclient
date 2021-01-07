package com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.b.a {
    @Override // com.baidu.tbadk.b.a
    public String key() {
        return "interview/checkInterviewNoticeStatus";
    }

    @Override // com.baidu.tbadk.b.a, com.baidu.tbadk.b.f
    public h a(Object obj, HashMap<String, String> hashMap, String str) {
        Map.Entry<String, String> next;
        Context baseContext = TbadkCoreApplication.getInst().getBaseContext();
        h hVar = new h();
        hVar.eJd = str;
        if (obj instanceof com.baidu.tieba.lego.card.model.a) {
            com.baidu.tieba.lego.card.model.a aVar = (com.baidu.tieba.lego.card.model.a) obj;
            Intent intent = new Intent(baseContext, AlarmReceiver.class);
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext() && (next = it.next()) != null) {
                intent.putExtra(next.getKey(), next.getValue());
                i = "task_id".equals(next.getKey()) ? Integer.parseInt(next.getValue()) : i;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            intent.setData(Uri.parse(currentAccount));
            hVar.result = PendingIntent.getBroadcast(baseContext, i, intent, 536870912) != null;
            aVar.ty(true);
            aVar.tx(hVar.result);
        }
        return hVar;
    }
}

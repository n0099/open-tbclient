package com.baidu.tieba.pb.main;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.a = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.data.aj ajVar;
        List<DownloadData> data;
        com.baidu.tieba.data.aj ajVar2;
        Context context;
        if (customResponsedMessage != null) {
            ajVar = this.a.a;
            if (ajVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                ajVar2 = this.a.a;
                ArrayList<com.baidu.tieba.d.a.f> o = ajVar2.o();
                if (o != null && o.size() != 0) {
                    Iterator<com.baidu.tieba.d.a.f> it = o.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.d.a.f next = it.next();
                        if (next != null && next.p() != null && !TextUtils.isEmpty(next.p().g)) {
                            com.baidu.tieba.d.a.a p = next.p();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && p.g.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.a(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.ba.c(next2.getStatusMsg())) {
                                            context = this.a.b;
                                            com.baidu.adp.lib.util.j.a(context, next2.getStatusMsg());
                                        }
                                        next.a(0);
                                    } else if (status == 1) {
                                        next.a(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.a.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends CustomMessageListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(az azVar, int i) {
        super(i);
        this.a = azVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.data.af afVar;
        com.baidu.tieba.data.af afVar2;
        List<DownloadData> data;
        Context context;
        if (customResponsedMessage != null) {
            afVar = this.a.a;
            if (afVar != null) {
                afVar2 = this.a.a;
                com.baidu.tieba.data.ae o = afVar2.o();
                if (o != null && customResponsedMessage.getCmd() == 2003122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    for (DownloadData downloadData : data) {
                        if (downloadData != null && downloadData.getId().equals(o.d())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                o.a(2);
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.be.c(downloadData.getStatusMsg())) {
                                    context = this.a.b;
                                    com.baidu.adp.lib.util.k.a(context, downloadData.getStatusMsg());
                                }
                                o.a(0);
                            } else if (status == 1) {
                                o.a(1);
                            }
                            this.a.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            }
        }
    }
}

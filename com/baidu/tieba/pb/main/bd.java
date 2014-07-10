package com.baidu.tieba.pb.main;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends CustomMessageListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i) {
        super(i);
        this.a = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.data.ai aiVar;
        com.baidu.tieba.data.ai aiVar2;
        List<DownloadData> data;
        Context context;
        if (customResponsedMessage != null) {
            aiVar = this.a.a;
            if (aiVar != null) {
                aiVar2 = this.a.a;
                com.baidu.tieba.data.ah n = aiVar2.n();
                if (n != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                    for (DownloadData downloadData : data) {
                        if (downloadData != null && downloadData.getId().equals(n.d())) {
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                n.a(2);
                            } else if (status == 2 || status == 4) {
                                if (!com.baidu.tbadk.core.util.bm.c(downloadData.getStatusMsg())) {
                                    context = this.a.b;
                                    com.baidu.adp.lib.util.j.a(context, downloadData.getStatusMsg());
                                }
                                n.a(0);
                            } else if (status == 1) {
                                n.a(1);
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

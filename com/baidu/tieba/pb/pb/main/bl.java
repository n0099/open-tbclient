package com.baidu.tieba.pb.pb.main;

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
public class bl extends CustomMessageListener {
    final /* synthetic */ bk bJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bk bkVar, int i) {
        super(i);
        this.bJg = bkVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.pb.a.b bVar;
        List<DownloadData> data;
        com.baidu.tieba.pb.a.b bVar2;
        PbActivity pbActivity;
        if (customResponsedMessage != null) {
            bVar = this.bJg.bIY;
            if (bVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                bVar2 = this.bJg.bIY;
                ArrayList<com.baidu.tieba.tbadkCore.c.i> Zh = bVar2.Zh();
                if (Zh != null && Zh.size() != 0) {
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it = Zh.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next = it.next();
                        if (next != null && next.amF() != null && !TextUtils.isEmpty(next.amF().apk_name)) {
                            com.baidu.tieba.tbadkCore.c.a amF = next.amF();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && amF.apk_name.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.in(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.bd.isEmpty(next2.getStatusMsg())) {
                                            pbActivity = this.bJg.bIT;
                                            com.baidu.adp.lib.util.n.showToast(pbActivity.getPageContext().getContext(), next2.getStatusMsg());
                                        }
                                        next.in(0);
                                    } else if (status == 1) {
                                        next.in(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bJg.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

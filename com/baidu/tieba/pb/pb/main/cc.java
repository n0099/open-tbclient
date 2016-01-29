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
public class cc extends CustomMessageListener {
    final /* synthetic */ cb cOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(cb cbVar, int i) {
        super(i);
        this.cOa = cbVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.pb.a.c cVar;
        List<DownloadData> data;
        com.baidu.tieba.pb.a.c cVar2;
        PbActivity pbActivity;
        if (customResponsedMessage != null) {
            cVar = this.cOa.cJZ;
            if (cVar != null && !PbActivity.cMq && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                cVar2 = this.cOa.cJZ;
                ArrayList<com.baidu.tieba.tbadkCore.data.q> aoN = cVar2.aoN();
                if (aoN != null && aoN.size() != 0) {
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it = aoN.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next = it.next();
                        if (next != null && next.aMl() != null && !TextUtils.isEmpty(next.aMl().apk_name)) {
                            com.baidu.tieba.tbadkCore.data.d aMl = next.aMl();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && aMl.apk_name.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.oh(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.aw.isEmpty(next2.getStatusMsg())) {
                                            pbActivity = this.cOa.cNL;
                                            com.baidu.adp.lib.util.k.showToast(pbActivity.getPageContext().getContext(), next2.getStatusMsg());
                                        }
                                        next.oh(0);
                                    } else if (status == 1) {
                                        next.oh(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.cOa.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

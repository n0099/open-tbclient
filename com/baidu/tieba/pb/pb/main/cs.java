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
public class cs extends CustomMessageListener {
    final /* synthetic */ cq dig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs(cq cqVar, int i) {
        super(i);
        this.dig = cqVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.pb.data.e eVar;
        PbActivity pbActivity;
        List<DownloadData> data;
        com.baidu.tieba.pb.data.e eVar2;
        PbActivity pbActivity2;
        if (customResponsedMessage != null) {
            eVar = this.dig.ddq;
            if (eVar != null) {
                pbActivity = this.dig.dfw;
                if (!com.baidu.adp.base.l.q(pbActivity.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    eVar2 = this.dig.ddq;
                    ArrayList<com.baidu.tieba.tbadkCore.data.r> avF = eVar2.avF();
                    if (avF != null && avF.size() != 0) {
                        Iterator<com.baidu.tieba.tbadkCore.data.r> it = avF.iterator();
                        boolean z = false;
                        while (it.hasNext()) {
                            com.baidu.tieba.tbadkCore.data.r next = it.next();
                            if (next != null && next.aTh() != null && !TextUtils.isEmpty(next.aTh().apk_name)) {
                                com.baidu.tieba.tbadkCore.data.e aTh = next.aTh();
                                Iterator<DownloadData> it2 = data.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    DownloadData next2 = it2.next();
                                    if (next2 != null && aTh.apk_name.equals(next2.getId())) {
                                        int status = next2.getStatus();
                                        if (status == 3 || status == 0) {
                                            next.pq(2);
                                        } else if (status == 2 || status == 4) {
                                            if (!com.baidu.tbadk.core.util.ay.isEmpty(next2.getStatusMsg())) {
                                                pbActivity2 = this.dig.dfw;
                                                com.baidu.adp.lib.util.k.showToast(pbActivity2.getPageContext().getContext(), next2.getStatusMsg());
                                            }
                                            next.pq(0);
                                        } else if (status == 1) {
                                            next.pq(1);
                                        }
                                        z = true;
                                    }
                                }
                            }
                        }
                        if (z) {
                            this.dig.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}

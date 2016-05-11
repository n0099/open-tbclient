package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb extends CustomMessageListener {
    final /* synthetic */ bz dkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(bz bzVar, int i) {
        super(i);
        this.dkp = bzVar;
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
        boolean z;
        if (customResponsedMessage != null) {
            eVar = this.dkp.dfK;
            if (eVar != null) {
                pbActivity = this.dkp.dhY;
                if (!com.baidu.adp.base.l.q(pbActivity.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    Iterator<DownloadData> it = data.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next().getStatus() == 0) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        this.dkp.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

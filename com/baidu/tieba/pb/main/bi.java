package com.baidu.tieba.pb.main;

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
public class bi extends CustomMessageListener {
    final /* synthetic */ bh bvG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bh bhVar, int i) {
        super(i);
        this.bvG = bhVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.data.ah ahVar;
        List<DownloadData> data;
        com.baidu.tieba.data.ah ahVar2;
        PbActivity pbActivity;
        if (customResponsedMessage != null) {
            ahVar = this.bvG.bvt;
            if (ahVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                ahVar2 = this.bvG.bvt;
                ArrayList<com.baidu.tieba.d.a.f> zS = ahVar2.zS();
                if (zS != null && zS.size() != 0) {
                    Iterator<com.baidu.tieba.d.a.f> it = zS.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.d.a.f next = it.next();
                        if (next != null && next.abq() != null && !TextUtils.isEmpty(next.abq().apk_name)) {
                            com.baidu.tieba.d.a.a abq = next.abq();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && abq.apk_name.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.hf(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.ay.aA(next2.getStatusMsg())) {
                                            pbActivity = this.bvG.bvu;
                                            com.baidu.adp.lib.util.m.showToast(pbActivity, next2.getStatusMsg());
                                        }
                                        next.hf(0);
                                    } else if (status == 1) {
                                        next.hf(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bvG.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

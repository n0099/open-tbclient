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
public class bi extends CustomMessageListener {
    final /* synthetic */ bh bLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bh bhVar, int i) {
        super(i);
        this.bLm = bhVar;
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
            bVar = this.bLm.bLe;
            if (bVar != null && customResponsedMessage.getCmd() == 2001122 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                bVar2 = this.bLm.bLe;
                ArrayList<com.baidu.tieba.tbadkCore.data.i> aay = bVar2.aay();
                if (aay != null && aay.size() != 0) {
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it = aay.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next = it.next();
                        if (next != null && next.aor() != null && !TextUtils.isEmpty(next.aor().apk_name)) {
                            com.baidu.tieba.tbadkCore.data.a aor = next.aor();
                            Iterator<DownloadData> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                DownloadData next2 = it2.next();
                                if (next2 != null && aor.apk_name.equals(next2.getId())) {
                                    int status = next2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.iJ(2);
                                    } else if (status == 2 || status == 4) {
                                        if (!com.baidu.tbadk.core.util.bb.isEmpty(next2.getStatusMsg())) {
                                            pbActivity = this.bLm.bKZ;
                                            com.baidu.adp.lib.util.n.showToast(pbActivity.getPageContext().getContext(), next2.getStatusMsg());
                                        }
                                        next.iJ(0);
                                    } else if (status == 1) {
                                        next.iJ(1);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.bLm.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}

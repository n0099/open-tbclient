package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.c.c;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a iIF;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nWQ;
    private List<SimpleForum> nWR;
    private boolean nWS;
    private ArrayList<TransmitForumData> grW = new ArrayList<>();
    private a.InterfaceC0876a nWT = new a.InterfaceC0876a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0876a
        public void onError() {
            b.this.dXP();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0876a
        public void t(List<SimpleForum> list, int i) {
            b.this.nWR = list;
            b.this.mPrivateThread = i;
            b.this.cwi();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nWQ = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nWQ.a(this.nWT);
        this.nWQ.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        this.grW.clear();
        if (x.getCount(this.nWR) > 0) {
            for (SimpleForum simpleForum : this.nWR) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.grW.add(transmitForumData);
                }
            }
        }
        if (this.iIF != null) {
            this.iIF.a(this.grW, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXP() {
        if (!this.nWS) {
            if (this.iIF != null) {
                this.iIF.a(null, false, 2, 0);
            }
            this.nWS = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cwb() {
        if (this.iIF != null && this.nWQ != null) {
            this.nWS = false;
            this.nWQ.setThreadTitle(null);
            this.nWQ.setThreadContent(null);
            this.nWQ.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iIF = aVar;
    }
}

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
    private com.baidu.tieba.write.transmit.model.a nWP;
    private List<SimpleForum> nWQ;
    private boolean nWR;
    private ArrayList<TransmitForumData> grW = new ArrayList<>();
    private a.InterfaceC0914a nWS = new a.InterfaceC0914a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0914a
        public void onError() {
            b.this.dXQ();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0914a
        public void t(List<SimpleForum> list, int i) {
            b.this.nWQ = list;
            b.this.mPrivateThread = i;
            b.this.cwj();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nWP = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nWP.a(this.nWS);
        this.nWP.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        this.grW.clear();
        if (x.getCount(this.nWQ) > 0) {
            for (SimpleForum simpleForum : this.nWQ) {
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
    public void dXQ() {
        if (!this.nWR) {
            if (this.iIF != null) {
                this.iIF.a(null, false, 2, 0);
            }
            this.nWR = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cwc() {
        if (this.iIF != null && this.nWP != null) {
            this.nWR = false;
            this.nWP.setThreadTitle(null);
            this.nWP.setThreadContent(null);
            this.nWP.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iIF = aVar;
    }
}

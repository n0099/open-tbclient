package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.c.c;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes8.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a iJW;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a ocR;
    private List<SimpleForum> ocS;
    private boolean ocT;
    private ArrayList<TransmitForumData> gqm = new ArrayList<>();
    private a.InterfaceC0902a ocU = new a.InterfaceC0902a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0902a
        public void onError() {
            b.this.dWu();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0902a
        public void t(List<SimpleForum> list, int i) {
            b.this.ocS = list;
            b.this.mPrivateThread = i;
            b.this.ctK();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.ocR = new com.baidu.tieba.write.transmit.model.a(gen);
        this.ocR.a(this.ocU);
        this.ocR.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctK() {
        this.gqm.clear();
        if (y.getCount(this.ocS) > 0) {
            for (SimpleForum simpleForum : this.ocS) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.gqm.add(transmitForumData);
                }
            }
        }
        if (this.iJW != null) {
            this.iJW.a(this.gqm, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWu() {
        if (!this.ocT) {
            if (this.iJW != null) {
                this.iJW.a(null, false, 2, 0);
            }
            this.ocT = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void ctD() {
        if (this.iJW != null && this.ocR != null) {
            this.ocT = false;
            this.ocR.setThreadTitle(null);
            this.ocR.setThreadContent(null);
            this.ocR.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iJW = aVar;
    }
}

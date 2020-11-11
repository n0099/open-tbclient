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
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a ikI;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nDQ;
    private List<SimpleForum> nDR;
    private boolean nDS;
    private ArrayList<TransmitForumData> fZE = new ArrayList<>();
    private a.InterfaceC0880a nDT = new a.InterfaceC0880a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0880a
        public void onError() {
            b.this.dSS();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0880a
        public void t(List<SimpleForum> list, int i) {
            b.this.nDR = list;
            b.this.mPrivateThread = i;
            b.this.cpz();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nDQ = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nDQ.a(this.nDT);
        this.nDQ.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpz() {
        this.fZE.clear();
        if (y.getCount(this.nDR) > 0) {
            for (SimpleForum simpleForum : this.nDR) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fZE.add(transmitForumData);
                }
            }
        }
        if (this.ikI != null) {
            this.ikI.a(this.fZE, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSS() {
        if (!this.nDS) {
            if (this.ikI != null) {
                this.ikI.a(null, false, 2, 0);
            }
            this.nDS = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cps() {
        if (this.ikI != null && this.nDQ != null) {
            this.nDS = false;
            this.nDQ.setThreadTitle(null);
            this.nDQ.setThreadContent(null);
            this.nDQ.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.ikI = aVar;
    }
}

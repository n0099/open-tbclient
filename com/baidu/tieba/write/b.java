package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d.c;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.d.c {
    private c.a ilw;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nFn;
    private List<SimpleForum> nFo;
    private boolean nFp;
    private ArrayList<TransmitForumData> fZl = new ArrayList<>();
    private a.InterfaceC0883a nFq = new a.InterfaceC0883a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0883a
        public void onError() {
            b.this.dSR();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0883a
        public void t(List<SimpleForum> list, int i) {
            b.this.nFo = list;
            b.this.mPrivateThread = i;
            b.this.cpa();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nFn = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nFn.a(this.nFq);
        this.nFn.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpa() {
        this.fZl.clear();
        if (y.getCount(this.nFo) > 0) {
            for (SimpleForum simpleForum : this.nFo) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fZl.add(transmitForumData);
                }
            }
        }
        if (this.ilw != null) {
            this.ilw.a(this.fZl, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSR() {
        if (!this.nFp) {
            if (this.ilw != null) {
                this.ilw.a(null, false, 2, 0);
            }
            this.nFp = true;
        }
    }

    @Override // com.baidu.tieba.d.c
    public void coT() {
        if (this.ilw != null && this.nFn != null) {
            this.nFp = false;
            this.nFn.setThreadTitle(null);
            this.nFn.setThreadContent(null);
            this.nFn.loadData();
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.ilw = aVar;
    }
}

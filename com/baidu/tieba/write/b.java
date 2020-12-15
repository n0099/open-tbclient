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
    private c.a iws;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nTv;
    private List<SimpleForum> nTw;
    private boolean nTx;
    private ArrayList<TransmitForumData> ghy = new ArrayList<>();
    private a.InterfaceC0899a nTy = new a.InterfaceC0899a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void onError() {
            b.this.dYm();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void t(List<SimpleForum> list, int i) {
            b.this.nTw = list;
            b.this.mPrivateThread = i;
            b.this.ctp();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nTv = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nTv.a(this.nTy);
        this.nTv.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctp() {
        this.ghy.clear();
        if (y.getCount(this.nTw) > 0) {
            for (SimpleForum simpleForum : this.nTw) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.ghy.add(transmitForumData);
                }
            }
        }
        if (this.iws != null) {
            this.iws.a(this.ghy, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYm() {
        if (!this.nTx) {
            if (this.iws != null) {
                this.iws.a(null, false, 2, 0);
            }
            this.nTx = true;
        }
    }

    @Override // com.baidu.tieba.d.c
    public void cti() {
        if (this.iws != null && this.nTv != null) {
            this.nTx = false;
            this.nTv.setThreadTitle(null);
            this.nTv.setThreadContent(null);
            this.nTv.loadData();
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.iws = aVar;
    }
}

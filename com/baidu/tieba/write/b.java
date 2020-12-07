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
    private c.a iwq;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nTt;
    private List<SimpleForum> nTu;
    private boolean nTv;
    private ArrayList<TransmitForumData> ghw = new ArrayList<>();
    private a.InterfaceC0899a nTw = new a.InterfaceC0899a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void onError() {
            b.this.dYl();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0899a
        public void t(List<SimpleForum> list, int i) {
            b.this.nTu = list;
            b.this.mPrivateThread = i;
            b.this.cto();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nTt = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nTt.a(this.nTw);
        this.nTt.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cto() {
        this.ghw.clear();
        if (y.getCount(this.nTu) > 0) {
            for (SimpleForum simpleForum : this.nTu) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.ghw.add(transmitForumData);
                }
            }
        }
        if (this.iwq != null) {
            this.iwq.a(this.ghw, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYl() {
        if (!this.nTv) {
            if (this.iwq != null) {
                this.iwq.a(null, false, 2, 0);
            }
            this.nTv = true;
        }
    }

    @Override // com.baidu.tieba.d.c
    public void cth() {
        if (this.iwq != null && this.nTt != null) {
            this.nTv = false;
            this.nTt.setThreadTitle(null);
            this.nTt.setThreadContent(null);
            this.nTt.loadData();
        }
    }

    @Override // com.baidu.tieba.d.c
    public void a(c.a aVar) {
        this.iwq = aVar;
    }
}

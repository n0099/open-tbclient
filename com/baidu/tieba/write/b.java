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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a iDY;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nSl;
    private List<SimpleForum> nSm;
    private boolean nSn;
    private ArrayList<TransmitForumData> gnp = new ArrayList<>();
    private a.InterfaceC0897a nSo = new a.InterfaceC0897a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0897a
        public void onError() {
            b.this.dTY();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0897a
        public void t(List<SimpleForum> list, int i) {
            b.this.nSm = list;
            b.this.mPrivateThread = i;
            b.this.csr();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nSl = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nSl.a(this.nSo);
        this.nSl.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        this.gnp.clear();
        if (x.getCount(this.nSm) > 0) {
            for (SimpleForum simpleForum : this.nSm) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.gnp.add(transmitForumData);
                }
            }
        }
        if (this.iDY != null) {
            this.iDY.a(this.gnp, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTY() {
        if (!this.nSn) {
            if (this.iDY != null) {
                this.iDY.a(null, false, 2, 0);
            }
            this.nSn = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void csk() {
        if (this.iDY != null && this.nSl != null) {
            this.nSn = false;
            this.nSl.setThreadTitle(null);
            this.nSl.setThreadContent(null);
            this.nSl.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iDY = aVar;
    }
}

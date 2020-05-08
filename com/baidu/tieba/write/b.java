package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0546a gBU;
    private com.baidu.tieba.write.transmit.model.a lwJ;
    private List<SimpleForum> lwK;
    private boolean lwL;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eIF = new ArrayList<>();
    private a.InterfaceC0701a lwM = new a.InterfaceC0701a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0701a
        public void onError() {
            b.this.deO();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0701a
        public void c(List<SimpleForum> list, int i) {
            b.this.lwK = list;
            b.this.mPrivateThread = i;
            b.this.bGg();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.lwJ = new com.baidu.tieba.write.transmit.model.a(gen);
        this.lwJ.a(this.lwM);
        this.lwJ.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        this.eIF.clear();
        if (v.getCount(this.lwK) > 0) {
            for (SimpleForum simpleForum : this.lwK) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.eIF.add(transmitForumData);
                }
            }
        }
        if (this.gBU != null) {
            this.gBU.a(this.eIF, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deO() {
        if (!this.lwL) {
            if (this.gBU != null) {
                this.gBU.a(null, false, 2, 0);
            }
            this.lwL = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bFU() {
        if (this.gBU != null && this.lwJ != null) {
            this.lwL = false;
            this.lwJ.setThreadTitle(null);
            this.lwJ.setThreadContent(null);
            this.lwJ.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0546a interfaceC0546a) {
        this.gBU = interfaceC0546a;
    }
}

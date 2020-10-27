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
    private c.a ieL;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nxW;
    private List<SimpleForum> nxX;
    private boolean nxY;
    private ArrayList<TransmitForumData> fTO = new ArrayList<>();
    private a.InterfaceC0865a nxZ = new a.InterfaceC0865a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0865a
        public void onError() {
            b.this.dQq();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0865a
        public void t(List<SimpleForum> list, int i) {
            b.this.nxX = list;
            b.this.mPrivateThread = i;
            b.this.cmY();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nxW = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nxW.a(this.nxZ);
        this.nxW.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmY() {
        this.fTO.clear();
        if (y.getCount(this.nxX) > 0) {
            for (SimpleForum simpleForum : this.nxX) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fTO.add(transmitForumData);
                }
            }
        }
        if (this.ieL != null) {
            this.ieL.a(this.fTO, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQq() {
        if (!this.nxY) {
            if (this.ieL != null) {
                this.ieL.a(null, false, 2, 0);
            }
            this.nxY = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cmR() {
        if (this.ieL != null && this.nxW != null) {
            this.nxY = false;
            this.nxW.setThreadTitle(null);
            this.nxW.setThreadContent(null);
            this.nxW.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.ieL = aVar;
    }
}

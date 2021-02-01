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
    private c.a iJI;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a ocq;
    private List<SimpleForum> ocs;
    private boolean oct;
    private ArrayList<TransmitForumData> gpY = new ArrayList<>();
    private a.InterfaceC0900a ocu = new a.InterfaceC0900a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0900a
        public void onError() {
            b.this.dWm();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0900a
        public void t(List<SimpleForum> list, int i) {
            b.this.ocs = list;
            b.this.mPrivateThread = i;
            b.this.ctD();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.ocq = new com.baidu.tieba.write.transmit.model.a(gen);
        this.ocq.a(this.ocu);
        this.ocq.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctD() {
        this.gpY.clear();
        if (y.getCount(this.ocs) > 0) {
            for (SimpleForum simpleForum : this.ocs) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.gpY.add(transmitForumData);
                }
            }
        }
        if (this.iJI != null) {
            this.iJI.a(this.gpY, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWm() {
        if (!this.oct) {
            if (this.iJI != null) {
                this.iJI.a(null, false, 2, 0);
            }
            this.oct = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void ctw() {
        if (this.iJI != null && this.ocq != null) {
            this.oct = false;
            this.ocq.setThreadTitle(null);
            this.ocq.setThreadContent(null);
            this.ocq.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iJI = aVar;
    }
}

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
/* loaded from: classes13.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0489a fWQ;
    private com.baidu.tieba.write.transmit.model.a kNo;
    private List<SimpleForum> kNp;
    private boolean kNq;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eiP = new ArrayList<>();
    private a.InterfaceC0635a kNr = new a.InterfaceC0635a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0635a
        public void onError() {
            b.this.cUw();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0635a
        public void b(List<SimpleForum> list, int i) {
            b.this.kNp = list;
            b.this.mPrivateThread = i;
            b.this.bww();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kNo = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kNo.a(this.kNr);
        this.kNo.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        this.eiP.clear();
        if (v.getCount(this.kNp) > 0) {
            for (SimpleForum simpleForum : this.kNp) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.eiP.add(transmitForumData);
                }
            }
        }
        if (this.fWQ != null) {
            this.fWQ.a(this.eiP, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUw() {
        if (!this.kNq) {
            if (this.fWQ != null) {
                this.fWQ.a(null, false, 2, 0);
            }
            this.kNq = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bwl() {
        if (this.fWQ != null && this.kNo != null) {
            this.kNq = false;
            this.kNo.setThreadTitle(null);
            this.kNo.setThreadContent(null);
            this.kNo.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fWQ = interfaceC0489a;
    }
}

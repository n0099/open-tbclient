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
    private a.InterfaceC0596a gQO;
    private com.baidu.tieba.write.transmit.model.a lRi;
    private List<SimpleForum> lRj;
    private boolean lRk;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eVq = new ArrayList<>();
    private a.InterfaceC0755a lRl = new a.InterfaceC0755a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0755a
        public void onError() {
            b.this.dmu();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0755a
        public void g(List<SimpleForum> list, int i) {
            b.this.lRj = list;
            b.this.mPrivateThread = i;
            b.this.bMC();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.lRi = new com.baidu.tieba.write.transmit.model.a(gen);
        this.lRi.a(this.lRl);
        this.lRi.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMC() {
        this.eVq.clear();
        if (v.getCount(this.lRj) > 0) {
            for (SimpleForum simpleForum : this.lRj) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.eVq.add(transmitForumData);
                }
            }
        }
        if (this.gQO != null) {
            this.gQO.a(this.eVq, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmu() {
        if (!this.lRk) {
            if (this.gQO != null) {
                this.gQO.a(null, false, 2, 0);
            }
            this.lRk = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bMq() {
        if (this.gQO != null && this.lRi != null) {
            this.lRk = false;
            this.lRi.setThreadTitle(null);
            this.lRi.setThreadContent(null);
            this.lRi.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0596a interfaceC0596a) {
        this.gQO = interfaceC0596a;
    }
}

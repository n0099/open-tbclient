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
    private a.InterfaceC0596a gQD;
    private com.baidu.tieba.write.transmit.model.a lPX;
    private List<SimpleForum> lPY;
    private boolean lPZ;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eVf = new ArrayList<>();
    private a.InterfaceC0754a lQa = new a.InterfaceC0754a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0754a
        public void onError() {
            b.this.dmf();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0754a
        public void g(List<SimpleForum> list, int i) {
            b.this.lPY = list;
            b.this.mPrivateThread = i;
            b.this.bMA();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.lPX = new com.baidu.tieba.write.transmit.model.a(gen);
        this.lPX.a(this.lQa);
        this.lPX.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        this.eVf.clear();
        if (v.getCount(this.lPY) > 0) {
            for (SimpleForum simpleForum : this.lPY) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.eVf.add(transmitForumData);
                }
            }
        }
        if (this.gQD != null) {
            this.gQD.a(this.eVf, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmf() {
        if (!this.lPZ) {
            if (this.gQD != null) {
                this.gQD.a(null, false, 2, 0);
            }
            this.lPZ = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bMo() {
        if (this.gQD != null && this.lPX != null) {
            this.lPZ = false;
            this.lPX.setThreadTitle(null);
            this.lPX.setThreadContent(null);
            this.lPX.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0596a interfaceC0596a) {
        this.gQD = interfaceC0596a;
    }
}

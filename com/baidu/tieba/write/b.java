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
    private a.InterfaceC0525a gBO;
    private com.baidu.tieba.write.transmit.model.a lwF;
    private List<SimpleForum> lwG;
    private boolean lwH;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eIA = new ArrayList<>();
    private a.InterfaceC0680a lwI = new a.InterfaceC0680a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0680a
        public void onError() {
            b.this.deR();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0680a
        public void c(List<SimpleForum> list, int i) {
            b.this.lwG = list;
            b.this.mPrivateThread = i;
            b.this.bGi();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.lwF = new com.baidu.tieba.write.transmit.model.a(gen);
        this.lwF.a(this.lwI);
        this.lwF.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        this.eIA.clear();
        if (v.getCount(this.lwG) > 0) {
            for (SimpleForum simpleForum : this.lwG) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.eIA.add(transmitForumData);
                }
            }
        }
        if (this.gBO != null) {
            this.gBO.a(this.eIA, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deR() {
        if (!this.lwH) {
            if (this.gBO != null) {
                this.gBO.a(null, false, 2, 0);
            }
            this.lwH = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bFW() {
        if (this.gBO != null && this.lwF != null) {
            this.lwH = false;
            this.lwF.setThreadTitle(null);
            this.lwF.setThreadContent(null);
            this.lwF.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0525a interfaceC0525a) {
        this.gBO = interfaceC0525a;
    }
}

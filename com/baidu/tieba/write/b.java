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
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a iLF;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a oeW;
    private List<SimpleForum> oeX;
    private boolean oeY;
    private ArrayList<TransmitForumData> grV = new ArrayList<>();
    private a.InterfaceC0908a oeZ = new a.InterfaceC0908a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0908a
        public void onError() {
            b.this.dWC();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0908a
        public void t(List<SimpleForum> list, int i) {
            b.this.oeX = list;
            b.this.mPrivateThread = i;
            b.this.ctQ();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.oeW = new com.baidu.tieba.write.transmit.model.a(gen);
        this.oeW.a(this.oeZ);
        this.oeW.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctQ() {
        this.grV.clear();
        if (y.getCount(this.oeX) > 0) {
            for (SimpleForum simpleForum : this.oeX) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.grV.add(transmitForumData);
                }
            }
        }
        if (this.iLF != null) {
            this.iLF.a(this.grV, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWC() {
        if (!this.oeY) {
            if (this.iLF != null) {
                this.iLF.a(null, false, 2, 0);
            }
            this.oeY = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void ctJ() {
        if (this.iLF != null && this.oeW != null) {
            this.oeY = false;
            this.oeW.setThreadTitle(null);
            this.oeW.setThreadContent(null);
            this.oeW.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.iLF = aVar;
    }
}

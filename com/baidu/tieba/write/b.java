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
    private c.a hSk;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a nlv;
    private List<SimpleForum> nlw;
    private boolean nlx;
    private ArrayList<TransmitForumData> fLx = new ArrayList<>();
    private a.InterfaceC0850a nly = new a.InterfaceC0850a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0850a
        public void onError() {
            b.this.dNi();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0850a
        public void s(List<SimpleForum> list, int i) {
            b.this.nlw = list;
            b.this.mPrivateThread = i;
            b.this.cjR();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.nlv = new com.baidu.tieba.write.transmit.model.a(gen);
        this.nlv.a(this.nly);
        this.nlv.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjR() {
        this.fLx.clear();
        if (y.getCount(this.nlw) > 0) {
            for (SimpleForum simpleForum : this.nlw) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fLx.add(transmitForumData);
                }
            }
        }
        if (this.hSk != null) {
            this.hSk.a(this.fLx, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNi() {
        if (!this.nlx) {
            if (this.hSk != null) {
                this.hSk.a(null, false, 2, 0);
            }
            this.nlx = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cjK() {
        if (this.hSk != null && this.nlv != null) {
            this.nlx = false;
            this.nlv.setThreadTitle(null);
            this.nlv.setThreadContent(null);
            this.nlv.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hSk = aVar;
    }
}

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
/* loaded from: classes3.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a hjh;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a mtv;
    private List<SimpleForum> mtw;
    private boolean mtx;
    private ArrayList<TransmitForumData> fkE = new ArrayList<>();
    private a.InterfaceC0782a mty = new a.InterfaceC0782a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0782a
        public void onError() {
            b.this.dtX();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0782a
        public void t(List<SimpleForum> list, int i) {
            b.this.mtw = list;
            b.this.mPrivateThread = i;
            b.this.bST();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mtv = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mtv.a(this.mty);
        this.mtv.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        this.fkE.clear();
        if (x.getCount(this.mtw) > 0) {
            for (SimpleForum simpleForum : this.mtw) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fkE.add(transmitForumData);
                }
            }
        }
        if (this.hjh != null) {
            this.hjh.a(this.fkE, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtX() {
        if (!this.mtx) {
            if (this.hjh != null) {
                this.hjh.a(null, false, 2, 0);
            }
            this.mtx = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void bSM() {
        if (this.hjh != null && this.mtv != null) {
            this.mtx = false;
            this.mtv.setThreadTitle(null);
            this.mtv.setThreadContent(null);
            this.mtv.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hjh = aVar;
    }
}

package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.c.c;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class b implements com.baidu.tieba.c.c {
    private c.a hdx;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a mlu;
    private List<SimpleForum> mlv;
    private boolean mlw;
    private ArrayList<TransmitForumData> ffB = new ArrayList<>();
    private a.InterfaceC0772a mlx = new a.InterfaceC0772a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0772a
        public void onError() {
            b.this.dqL();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0772a
        public void h(List<SimpleForum> list, int i) {
            b.this.mlv = list;
            b.this.mPrivateThread = i;
            b.this.bPI();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mlu = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mlu.a(this.mlx);
        this.mlu.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPI() {
        this.ffB.clear();
        if (w.getCount(this.mlv) > 0) {
            for (SimpleForum simpleForum : this.mlv) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.ffB.add(transmitForumData);
                }
            }
        }
        if (this.hdx != null) {
            this.hdx.a(this.ffB, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqL() {
        if (!this.mlw) {
            if (this.hdx != null) {
                this.hdx.a(null, false, 2, 0);
            }
            this.mlw = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void bPB() {
        if (this.hdx != null && this.mlu != null) {
            this.mlw = false;
            this.mlu.setThreadTitle(null);
            this.mlu.setThreadContent(null);
            this.mlu.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hdx = aVar;
    }
}

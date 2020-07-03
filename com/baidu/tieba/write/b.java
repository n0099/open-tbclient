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
    private com.baidu.tieba.write.transmit.model.a mlr;
    private List<SimpleForum> mls;
    private boolean mlt;
    private ArrayList<TransmitForumData> ffB = new ArrayList<>();
    private a.InterfaceC0771a mlu = new a.InterfaceC0771a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0771a
        public void onError() {
            b.this.dqH();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0771a
        public void h(List<SimpleForum> list, int i) {
            b.this.mls = list;
            b.this.mPrivateThread = i;
            b.this.bPH();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mlr = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mlr.a(this.mlu);
        this.mlr.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPH() {
        this.ffB.clear();
        if (w.getCount(this.mls) > 0) {
            for (SimpleForum simpleForum : this.mls) {
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
    public void dqH() {
        if (!this.mlt) {
            if (this.hdx != null) {
                this.hdx.a(null, false, 2, 0);
            }
            this.mlt = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void bPA() {
        if (this.hdx != null && this.mlr != null) {
            this.mlt = false;
            this.mlr.setThreadTitle(null);
            this.mlr.setThreadContent(null);
            this.mlr.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hdx = aVar;
    }
}

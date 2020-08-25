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
    private c.a hwe;
    private com.baidu.tieba.write.transmit.model.a mLK;
    private List<SimpleForum> mLL;
    private boolean mLM;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> fwa = new ArrayList<>();
    private a.InterfaceC0835a mLN = new a.InterfaceC0835a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void onError() {
            b.this.dFt();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void w(List<SimpleForum> list, int i) {
            b.this.mLL = list;
            b.this.mPrivateThread = i;
            b.this.cdf();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mLK = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mLK.a(this.mLN);
        this.mLK.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdf() {
        this.fwa.clear();
        if (y.getCount(this.mLL) > 0) {
            for (SimpleForum simpleForum : this.mLL) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fwa.add(transmitForumData);
                }
            }
        }
        if (this.hwe != null) {
            this.hwe.a(this.fwa, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFt() {
        if (!this.mLM) {
            if (this.hwe != null) {
                this.hwe.a(null, false, 2, 0);
            }
            this.mLM = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void ccY() {
        if (this.hwe != null && this.mLK != null) {
            this.mLM = false;
            this.mLK.setThreadTitle(null);
            this.mLK.setThreadContent(null);
            this.mLK.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hwe = aVar;
    }
}

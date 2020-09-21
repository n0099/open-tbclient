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
    private c.a hDo;
    private int mPrivateThread;
    private com.baidu.tieba.write.transmit.model.a mVW;
    private List<SimpleForum> mVX;
    private boolean mVY;
    private ArrayList<TransmitForumData> fzo = new ArrayList<>();
    private a.InterfaceC0832a mVZ = new a.InterfaceC0832a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0832a
        public void onError() {
            b.this.dJw();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0832a
        public void w(List<SimpleForum> list, int i) {
            b.this.mVX = list;
            b.this.mPrivateThread = i;
            b.this.cgv();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mVW = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mVW.a(this.mVZ);
        this.mVW.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgv() {
        this.fzo.clear();
        if (y.getCount(this.mVX) > 0) {
            for (SimpleForum simpleForum : this.mVX) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fzo.add(transmitForumData);
                }
            }
        }
        if (this.hDo != null) {
            this.hDo.a(this.fzo, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJw() {
        if (!this.mVY) {
            if (this.hDo != null) {
                this.hDo.a(null, false, 2, 0);
            }
            this.mVY = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void cgo() {
        if (this.hDo != null && this.mVW != null) {
            this.mVY = false;
            this.mVW.setThreadTitle(null);
            this.mVW.setThreadContent(null);
            this.mVW.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hDo = aVar;
    }
}

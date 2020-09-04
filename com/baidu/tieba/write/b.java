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
    private c.a hwk;
    private com.baidu.tieba.write.transmit.model.a mMc;
    private List<SimpleForum> mMd;
    private boolean mMe;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> fwe = new ArrayList<>();
    private a.InterfaceC0835a mMf = new a.InterfaceC0835a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void onError() {
            b.this.dFC();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0835a
        public void w(List<SimpleForum> list, int i) {
            b.this.mMd = list;
            b.this.mPrivateThread = i;
            b.this.cdg();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.mMc = new com.baidu.tieba.write.transmit.model.a(gen);
        this.mMc.a(this.mMf);
        this.mMc.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdg() {
        this.fwe.clear();
        if (y.getCount(this.mMd) > 0) {
            for (SimpleForum simpleForum : this.mMd) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                    transmitForumData.tabItemDatas = new ArrayList<>();
                    for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                        if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                            transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                        }
                    }
                    this.fwe.add(transmitForumData);
                }
            }
        }
        if (this.hwk != null) {
            this.hwk.a(this.fwe, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFC() {
        if (!this.mMe) {
            if (this.hwk != null) {
                this.hwk.a(null, false, 2, 0);
            }
            this.mMe = true;
        }
    }

    @Override // com.baidu.tieba.c.c
    public void ccZ() {
        if (this.hwk != null && this.mMc != null) {
            this.mMe = false;
            this.mMc.setThreadTitle(null);
            this.mMc.setThreadContent(null);
            this.mMc.loadData();
        }
    }

    @Override // com.baidu.tieba.c.c
    public void a(c.a aVar) {
        this.hwk = aVar;
    }
}

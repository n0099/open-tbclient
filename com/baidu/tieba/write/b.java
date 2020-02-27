package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.c.a;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes13.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0489a fVT;
    private com.baidu.tieba.write.transmit.model.a kLr;
    private List<SimpleForum> kLs;
    private boolean kLt;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eil = new ArrayList<>();
    private a.InterfaceC0634a kLu = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            b.this.cTZ();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            b.this.kLs = list;
            b.this.mPrivateThread = i;
            b.this.bwo();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kLr = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kLr.a(this.kLu);
        this.kLr.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwo() {
        this.eil.clear();
        if (v.getCount(this.kLs) > 0) {
            for (SimpleForum simpleForum : this.kLs) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.eil.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fVT != null) {
            this.fVT.a(this.eil, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTZ() {
        if (!this.kLt) {
            if (this.fVT != null) {
                this.fVT.a(null, false, 2, 0);
            }
            this.kLt = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bwd() {
        if (this.fVT != null && this.kLr != null) {
            this.kLt = false;
            this.kLr.setThreadTitle(null);
            this.kLr.setThreadContent(null);
            this.kLr.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fVT = interfaceC0489a;
    }
}

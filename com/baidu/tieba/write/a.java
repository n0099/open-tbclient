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
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.c.a {
    private a.InterfaceC0295a eYn;
    private com.baidu.tieba.write.transmit.model.a jMj;
    private List<SimpleForum> jMk;
    private boolean jMl;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dPQ = new ArrayList<>();
    private a.InterfaceC0435a jMm = new a.InterfaceC0435a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void onError() {
            a.this.czy();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void g(List<SimpleForum> list, int i) {
            a.this.jMk = list;
            a.this.mPrivateThread = i;
            a.this.bbH();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jMj = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jMj.a(this.jMm);
        this.jMj.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbH() {
        this.dPQ.clear();
        if (v.Z(this.jMk) > 0) {
            for (SimpleForum simpleForum : this.jMk) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dPQ.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eYn != null) {
            this.eYn.a(this.dPQ, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czy() {
        if (!this.jMl) {
            if (this.eYn != null) {
                this.eYn.a(null, false, 2, 0);
            }
            this.jMl = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bbt() {
        if (this.eYn != null && this.jMj != null) {
            this.jMl = false;
            this.jMj.setThreadTitle(null);
            this.jMj.setThreadContent(null);
            this.jMj.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0295a interfaceC0295a) {
        this.eYn = interfaceC0295a;
    }
}

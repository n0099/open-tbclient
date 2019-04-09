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
    private a.InterfaceC0273a eDg;
    private com.baidu.tieba.write.transmit.model.a jkS;
    private List<SimpleForum> jkT;
    private boolean jkU;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dBB = new ArrayList<>();
    private a.InterfaceC0411a jkV = new a.InterfaceC0411a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void onError() {
            a.this.cnV();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void g(List<SimpleForum> list, int i) {
            a.this.jkT = list;
            a.this.mPrivateThread = i;
            a.this.aSv();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jkS = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jkS.a(this.jkV);
        this.jkS.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSv() {
        this.dBB.clear();
        if (v.S(this.jkT) > 0) {
            for (SimpleForum simpleForum : this.jkT) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dBB.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eDg != null) {
            this.eDg.a(this.dBB, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnV() {
        if (!this.jkU) {
            if (this.eDg != null) {
                this.eDg.a(null, false, 2, 0);
            }
            this.jkU = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aSg() {
        if (this.eDg != null && this.jkS != null) {
            this.jkU = false;
            this.jkS.setThreadTitle(null);
            this.jkS.setThreadContent(null);
            this.jkS.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.eDg = interfaceC0273a;
    }
}

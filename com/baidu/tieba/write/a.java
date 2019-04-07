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
    private a.InterfaceC0273a eDf;
    private com.baidu.tieba.write.transmit.model.a jkR;
    private List<SimpleForum> jkS;
    private boolean jkT;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dBA = new ArrayList<>();
    private a.InterfaceC0411a jkU = new a.InterfaceC0411a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void onError() {
            a.this.cnV();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void g(List<SimpleForum> list, int i) {
            a.this.jkS = list;
            a.this.mPrivateThread = i;
            a.this.aSv();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jkR = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jkR.a(this.jkU);
        this.jkR.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSv() {
        this.dBA.clear();
        if (v.S(this.jkS) > 0) {
            for (SimpleForum simpleForum : this.jkS) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dBA.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eDf != null) {
            this.eDf.a(this.dBA, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnV() {
        if (!this.jkT) {
            if (this.eDf != null) {
                this.eDf.a(null, false, 2, 0);
            }
            this.jkT = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aSg() {
        if (this.eDf != null && this.jkR != null) {
            this.jkT = false;
            this.jkR.setThreadTitle(null);
            this.jkR.setThreadContent(null);
            this.jkR.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.eDf = interfaceC0273a;
    }
}

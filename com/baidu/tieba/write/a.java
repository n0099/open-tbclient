package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.c.a;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.c.a {
    private a.InterfaceC0138a cQp;
    private com.baidu.tieba.write.transmit.model.a hrg;
    private List<SimpleForum> hrh;
    private boolean hri;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bTf = new ArrayList<>();
    private a.InterfaceC0255a hrj = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            a.this.bGx();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            a.this.hrh = list;
            a.this.mPrivateThread = i;
            a.this.aks();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hrg = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hrg.a(this.hrj);
        this.hrg.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        this.bTf.clear();
        if (w.z(this.hrh) > 0) {
            for (SimpleForum simpleForum : this.hrh) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bTf.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cQp != null) {
            this.cQp.a(this.bTf, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGx() {
        if (!this.hri) {
            if (this.cQp != null) {
                this.cQp.a(null, false, 2, 0);
            }
            this.hri = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void ake() {
        if (this.cQp != null && this.hrg != null) {
            this.hri = false;
            this.hrg.setThreadTitle(null);
            this.hrg.setThreadContent(null);
            this.hrg.SK();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0138a interfaceC0138a) {
        this.cQp = interfaceC0138a;
    }
}

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
    private a.InterfaceC0273a eDu;
    private com.baidu.tieba.write.transmit.model.a jld;
    private List<SimpleForum> jle;
    private boolean jlf;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dCk = new ArrayList<>();
    private a.InterfaceC0411a jlg = new a.InterfaceC0411a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void onError() {
            a.this.cnX();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void g(List<SimpleForum> list, int i) {
            a.this.jle = list;
            a.this.mPrivateThread = i;
            a.this.aSx();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jld = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jld.a(this.jlg);
        this.jld.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSx() {
        this.dCk.clear();
        if (v.S(this.jle) > 0) {
            for (SimpleForum simpleForum : this.jle) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dCk.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eDu != null) {
            this.eDu.a(this.dCk, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnX() {
        if (!this.jlf) {
            if (this.eDu != null) {
                this.eDu.a(null, false, 2, 0);
            }
            this.jlf = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aSi() {
        if (this.eDu != null && this.jld != null) {
            this.jlf = false;
            this.jld.setThreadTitle(null);
            this.jld.setThreadContent(null);
            this.jld.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.eDu = interfaceC0273a;
    }
}

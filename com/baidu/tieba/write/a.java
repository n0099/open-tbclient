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
    private a.InterfaceC0234a eDy;
    private com.baidu.tieba.write.transmit.model.a jll;
    private List<SimpleForum> jlm;
    private boolean jln;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dCo = new ArrayList<>();
    private a.InterfaceC0318a jlo = new a.InterfaceC0318a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0318a
        public void onError() {
            a.this.cnU();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0318a
        public void g(List<SimpleForum> list, int i) {
            a.this.jlm = list;
            a.this.mPrivateThread = i;
            a.this.aSy();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jll = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jll.a(this.jlo);
        this.jll.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSy() {
        this.dCo.clear();
        if (v.S(this.jlm) > 0) {
            for (SimpleForum simpleForum : this.jlm) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dCo.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eDy != null) {
            this.eDy.a(this.dCo, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnU() {
        if (!this.jln) {
            if (this.eDy != null) {
                this.eDy.a(null, false, 2, 0);
            }
            this.jln = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aSj() {
        if (this.eDy != null && this.jll != null) {
            this.jln = false;
            this.jll.setThreadTitle(null);
            this.jll.setThreadContent(null);
            this.jll.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0234a interfaceC0234a) {
        this.eDy = interfaceC0234a;
    }
}

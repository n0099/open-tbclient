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
    private com.baidu.tieba.write.transmit.model.a jkS;
    private List<SimpleForum> jkT;
    private boolean jkU;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dCo = new ArrayList<>();
    private a.InterfaceC0315a jkV = new a.InterfaceC0315a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0315a
        public void onError() {
            a.this.cnK();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0315a
        public void g(List<SimpleForum> list, int i) {
            a.this.jkT = list;
            a.this.mPrivateThread = i;
            a.this.aSx();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jkS = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jkS.a(this.jkV);
        this.jkS.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSx() {
        this.dCo.clear();
        if (v.S(this.jkT) > 0) {
            for (SimpleForum simpleForum : this.jkT) {
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
    public void cnK() {
        if (!this.jkU) {
            if (this.eDy != null) {
                this.eDy.a(null, false, 2, 0);
            }
            this.jkU = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aSi() {
        if (this.eDy != null && this.jkS != null) {
            this.jkU = false;
            this.jkS.setThreadTitle(null);
            this.jkS.setThreadContent(null);
            this.jkS.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0234a interfaceC0234a) {
        this.eDy = interfaceC0234a;
    }
}

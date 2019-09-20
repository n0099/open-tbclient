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
    private a.InterfaceC0304a eZT;
    private com.baidu.tieba.write.transmit.model.a jOE;
    private List<SimpleForum> jOF;
    private boolean jOG;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dRB = new ArrayList<>();
    private a.InterfaceC0446a jOH = new a.InterfaceC0446a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0446a
        public void onError() {
            a.this.cAm();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0446a
        public void g(List<SimpleForum> list, int i) {
            a.this.jOF = list;
            a.this.mPrivateThread = i;
            a.this.bcl();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jOE = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jOE.a(this.jOH);
        this.jOE.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        this.dRB.clear();
        if (v.Z(this.jOF) > 0) {
            for (SimpleForum simpleForum : this.jOF) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dRB.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eZT != null) {
            this.eZT.a(this.dRB, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAm() {
        if (!this.jOG) {
            if (this.eZT != null) {
                this.eZT.a(null, false, 2, 0);
            }
            this.jOG = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bbX() {
        if (this.eZT != null && this.jOE != null) {
            this.jOG = false;
            this.jOE.setThreadTitle(null);
            this.jOE.setThreadContent(null);
            this.jOE.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0304a interfaceC0304a) {
        this.eZT = interfaceC0304a;
    }
}

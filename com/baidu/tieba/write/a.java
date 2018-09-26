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
    private a.InterfaceC0136a cYP;
    private com.baidu.tieba.write.transmit.model.a hAj;
    private List<SimpleForum> hAk;
    private boolean hAl;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bZO = new ArrayList<>();
    private a.InterfaceC0261a hAm = new a.InterfaceC0261a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0261a
        public void onError() {
            a.this.bId();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0261a
        public void r(List<SimpleForum> list, int i) {
            a.this.hAk = list;
            a.this.mPrivateThread = i;
            a.this.amF();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hAj = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hAj.a(this.hAm);
        this.hAj.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amF() {
        this.bZO.clear();
        if (v.y(this.hAk) > 0) {
            for (SimpleForum simpleForum : this.hAk) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bZO.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cYP != null) {
            this.cYP.a(this.bZO, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bId() {
        if (!this.hAl) {
            if (this.cYP != null) {
                this.cYP.a(null, false, 2, 0);
            }
            this.hAl = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void amq() {
        if (this.cYP != null && this.hAj != null) {
            this.hAl = false;
            this.hAj.setThreadTitle(null);
            this.hAj.setThreadContent(null);
            this.hAj.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0136a interfaceC0136a) {
        this.cYP = interfaceC0136a;
    }
}

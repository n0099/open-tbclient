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
    private a.InterfaceC0136a cSY;
    private com.baidu.tieba.write.transmit.model.a hsp;
    private List<SimpleForum> hsq;
    private boolean hsr;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bTZ = new ArrayList<>();
    private a.InterfaceC0255a hss = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            a.this.bFm();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            a.this.hsq = list;
            a.this.mPrivateThread = i;
            a.this.akT();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hsp = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hsp.a(this.hss);
        this.hsp.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akT() {
        this.bTZ.clear();
        if (w.y(this.hsq) > 0) {
            for (SimpleForum simpleForum : this.hsq) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bTZ.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cSY != null) {
            this.cSY.a(this.bTZ, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFm() {
        if (!this.hsr) {
            if (this.cSY != null) {
                this.cSY.a(null, false, 2, 0);
            }
            this.hsr = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void akF() {
        if (this.cSY != null && this.hsp != null) {
            this.hsr = false;
            this.hsp.setThreadTitle(null);
            this.hsp.setThreadContent(null);
            this.hsp.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0136a interfaceC0136a) {
        this.cSY = interfaceC0136a;
    }
}

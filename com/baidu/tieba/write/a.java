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
    private a.InterfaceC0137a cSr;
    private com.baidu.tieba.write.transmit.model.a hna;
    private List<SimpleForum> hnb;
    private boolean hnc;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bQW = new ArrayList<>();
    private a.InterfaceC0253a hnd = new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void onError() {
            a.this.bFX();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void q(List<SimpleForum> list, int i) {
            a.this.hnb = list;
            a.this.mPrivateThread = i;
            a.this.akY();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hna = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hna.a(this.hnd);
        this.hna.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        this.bQW.clear();
        if (w.y(this.hnb) > 0) {
            for (SimpleForum simpleForum : this.hnb) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bQW.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cSr != null) {
            this.cSr.a(this.bQW, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFX() {
        if (!this.hnc) {
            if (this.cSr != null) {
                this.cSr.a(null, false, 2, 0);
            }
            this.hnc = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void akK() {
        if (this.cSr != null && this.hna != null) {
            this.hnc = false;
            this.hna.setThreadTitle(null);
            this.hna.setThreadContent(null);
            this.hna.So();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0137a interfaceC0137a) {
        this.cSr = interfaceC0137a;
    }
}

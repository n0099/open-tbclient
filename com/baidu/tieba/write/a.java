package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d.a;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.d.a {
    private a.InterfaceC0124a cIf;
    private com.baidu.tieba.write.transmit.model.a hae;
    private List<SimpleForum> haf;
    private boolean hag;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bHH = new ArrayList<>();
    private a.InterfaceC0236a hah = new a.InterfaceC0236a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void onError() {
            a.this.bAT();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void p(List<SimpleForum> list, int i) {
            a.this.haf = list;
            a.this.mPrivateThread = i;
            a.this.ahk();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hae = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hae.a(this.hah);
        this.hae.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahk() {
        this.bHH.clear();
        if (v.v(this.haf) > 0) {
            for (SimpleForum simpleForum : this.haf) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bHH.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cIf != null) {
            this.cIf.a(this.bHH, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAT() {
        if (!this.hag) {
            if (this.cIf != null) {
                this.cIf.a(null, false, 2, 0);
            }
            this.hag = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void ahc() {
        if (this.cIf != null && this.hae != null) {
            this.hag = false;
            this.hae.setThreadTitle(null);
            this.hae.setThreadContent(null);
            this.hae.OT();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0124a interfaceC0124a) {
        this.cIf = interfaceC0124a;
    }
}

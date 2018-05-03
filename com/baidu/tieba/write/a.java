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
    private a.InterfaceC0124a cIc;
    private com.baidu.tieba.write.transmit.model.a hab;
    private List<SimpleForum> hac;
    private boolean had;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bHG = new ArrayList<>();
    private a.InterfaceC0236a hae = new a.InterfaceC0236a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void onError() {
            a.this.bAT();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void p(List<SimpleForum> list, int i) {
            a.this.hac = list;
            a.this.mPrivateThread = i;
            a.this.ahk();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hab = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hab.a(this.hae);
        this.hab.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahk() {
        this.bHG.clear();
        if (v.v(this.hac) > 0) {
            for (SimpleForum simpleForum : this.hac) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bHG.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cIc != null) {
            this.cIc.a(this.bHG, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAT() {
        if (!this.had) {
            if (this.cIc != null) {
                this.cIc.a(null, false, 2, 0);
            }
            this.had = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void ahc() {
        if (this.cIc != null && this.hab != null) {
            this.had = false;
            this.hab.setThreadTitle(null);
            this.hab.setThreadContent(null);
            this.hab.OT();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0124a interfaceC0124a) {
        this.cIc = interfaceC0124a;
    }
}

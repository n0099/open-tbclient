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
    private a.InterfaceC0124a cJl;
    private com.baidu.tieba.write.transmit.model.a hbf;
    private List<SimpleForum> hbg;
    private boolean hbh;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bIV = new ArrayList<>();
    private a.InterfaceC0236a hbi = new a.InterfaceC0236a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void onError() {
            a.this.bAR();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void p(List<SimpleForum> list, int i) {
            a.this.hbg = list;
            a.this.mPrivateThread = i;
            a.this.ahk();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hbf = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hbf.a(this.hbi);
        this.hbf.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahk() {
        this.bIV.clear();
        if (v.v(this.hbg) > 0) {
            for (SimpleForum simpleForum : this.hbg) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bIV.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cJl != null) {
            this.cJl.a(this.bIV, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAR() {
        if (!this.hbh) {
            if (this.cJl != null) {
                this.cJl.a(null, false, 2, 0);
            }
            this.hbh = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void ahc() {
        if (this.cJl != null && this.hbf != null) {
            this.hbh = false;
            this.hbf.setThreadTitle(null);
            this.hbf.setThreadContent(null);
            this.hbf.OQ();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0124a interfaceC0124a) {
        this.cJl = interfaceC0124a;
    }
}

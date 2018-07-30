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
    private a.InterfaceC0136a cTb;
    private com.baidu.tieba.write.transmit.model.a hsn;
    private List<SimpleForum> hso;
    private boolean hsp;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> bUa = new ArrayList<>();
    private a.InterfaceC0255a hsq = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            a.this.bFi();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            a.this.hso = list;
            a.this.mPrivateThread = i;
            a.this.akR();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hsn = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hsn.a(this.hsq);
        this.hsn.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akR() {
        this.bUa.clear();
        if (w.y(this.hso) > 0) {
            for (SimpleForum simpleForum : this.hso) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.bUa.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.cTb != null) {
            this.cTb.a(this.bUa, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFi() {
        if (!this.hsp) {
            if (this.cTb != null) {
                this.cTb.a(null, false, 2, 0);
            }
            this.hsp = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void akD() {
        if (this.cTb != null && this.hsn != null) {
            this.hsp = false;
            this.hsn.setThreadTitle(null);
            this.hsn.setThreadContent(null);
            this.hsn.SS();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0136a interfaceC0136a) {
        this.cTb = interfaceC0136a;
    }
}

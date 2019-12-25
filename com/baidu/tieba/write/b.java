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
/* loaded from: classes10.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0477a fQr;
    private com.baidu.tieba.write.transmit.model.a kHf;
    private List<SimpleForum> kHg;
    private boolean kHh;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eea = new ArrayList<>();
    private a.InterfaceC0621a kHi = new a.InterfaceC0621a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0621a
        public void onError() {
            b.this.cRG();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0621a
        public void b(List<SimpleForum> list, int i) {
            b.this.kHg = list;
            b.this.mPrivateThread = i;
            b.this.btI();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kHf = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kHf.a(this.kHi);
        this.kHf.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        this.eea.clear();
        if (v.getCount(this.kHg) > 0) {
            for (SimpleForum simpleForum : this.kHg) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.eea.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fQr != null) {
            this.fQr.a(this.eea, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRG() {
        if (!this.kHh) {
            if (this.fQr != null) {
                this.fQr.a(null, false, 2, 0);
            }
            this.kHh = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void btx() {
        if (this.fQr != null && this.kHf != null) {
            this.kHh = false;
            this.kHf.setThreadTitle(null);
            this.kHf.setThreadContent(null);
            this.kHf.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0477a interfaceC0477a) {
        this.fQr = interfaceC0477a;
    }
}

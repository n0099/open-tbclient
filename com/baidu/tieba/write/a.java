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
    private a.InterfaceC0295a eXZ;
    private com.baidu.tieba.write.transmit.model.a jLc;
    private List<SimpleForum> jLd;
    private boolean jLe;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dPJ = new ArrayList<>();
    private a.InterfaceC0435a jLf = new a.InterfaceC0435a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void onError() {
            a.this.czd();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0435a
        public void g(List<SimpleForum> list, int i) {
            a.this.jLd = list;
            a.this.mPrivateThread = i;
            a.this.bbF();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jLc = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jLc.a(this.jLf);
        this.jLc.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbF() {
        this.dPJ.clear();
        if (v.Z(this.jLd) > 0) {
            for (SimpleForum simpleForum : this.jLd) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dPJ.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eXZ != null) {
            this.eXZ.a(this.dPJ, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czd() {
        if (!this.jLe) {
            if (this.eXZ != null) {
                this.eXZ.a(null, false, 2, 0);
            }
            this.jLe = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bbr() {
        if (this.eXZ != null && this.jLc != null) {
            this.jLe = false;
            this.jLc.setThreadTitle(null);
            this.jLc.setThreadContent(null);
            this.jLc.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0295a interfaceC0295a) {
        this.eXZ = interfaceC0295a;
    }
}

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
/* loaded from: classes11.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0481a fTB;
    private com.baidu.tieba.write.transmit.model.a kKL;
    private List<SimpleForum> kKM;
    private boolean kKN;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eei = new ArrayList<>();
    private a.InterfaceC0626a kKO = new a.InterfaceC0626a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void onError() {
            b.this.cSL();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void b(List<SimpleForum> list, int i) {
            b.this.kKM = list;
            b.this.mPrivateThread = i;
            b.this.buK();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kKL = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kKL.a(this.kKO);
        this.kKL.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        this.eei.clear();
        if (v.getCount(this.kKM) > 0) {
            for (SimpleForum simpleForum : this.kKM) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.eei.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fTB != null) {
            this.fTB.a(this.eei, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSL() {
        if (!this.kKN) {
            if (this.fTB != null) {
                this.fTB.a(null, false, 2, 0);
            }
            this.kKN = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void buz() {
        if (this.fTB != null && this.kKL != null) {
            this.kKN = false;
            this.kKL.setThreadTitle(null);
            this.kKL.setThreadContent(null);
            this.kKL.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0481a interfaceC0481a) {
        this.fTB = interfaceC0481a;
    }
}

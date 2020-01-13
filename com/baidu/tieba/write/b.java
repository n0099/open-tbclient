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
    private com.baidu.tieba.write.transmit.model.a kKG;
    private List<SimpleForum> kKH;
    private boolean kKI;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eei = new ArrayList<>();
    private a.InterfaceC0626a kKJ = new a.InterfaceC0626a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void onError() {
            b.this.cSJ();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void b(List<SimpleForum> list, int i) {
            b.this.kKH = list;
            b.this.mPrivateThread = i;
            b.this.buK();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kKG = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kKG.a(this.kKJ);
        this.kKG.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        this.eei.clear();
        if (v.getCount(this.kKH) > 0) {
            for (SimpleForum simpleForum : this.kKH) {
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
    public void cSJ() {
        if (!this.kKI) {
            if (this.fTB != null) {
                this.fTB.a(null, false, 2, 0);
            }
            this.kKI = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void buz() {
        if (this.fTB != null && this.kKG != null) {
            this.kKI = false;
            this.kKG.setThreadTitle(null);
            this.kKG.setThreadContent(null);
            this.kKG.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0481a interfaceC0481a) {
        this.fTB = interfaceC0481a;
    }
}

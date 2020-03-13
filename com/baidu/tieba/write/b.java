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
/* loaded from: classes13.dex */
public class b implements com.baidu.tieba.c.a {
    private a.InterfaceC0489a fWi;
    private com.baidu.tieba.write.transmit.model.a kLF;
    private List<SimpleForum> kLG;
    private boolean kLH;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eiz = new ArrayList<>();
    private a.InterfaceC0634a kLI = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            b.this.cUc();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            b.this.kLG = list;
            b.this.mPrivateThread = i;
            b.this.bwr();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kLF = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kLF.a(this.kLI);
        this.kLF.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        this.eiz.clear();
        if (v.getCount(this.kLG) > 0) {
            for (SimpleForum simpleForum : this.kLG) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.eiz.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fWi != null) {
            this.fWi.a(this.eiz, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUc() {
        if (!this.kLH) {
            if (this.fWi != null) {
                this.fWi.a(null, false, 2, 0);
            }
            this.kLH = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bwg() {
        if (this.fWi != null && this.kLF != null) {
            this.kLH = false;
            this.kLF.setThreadTitle(null);
            this.kLF.setThreadContent(null);
            this.kLF.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fWi = interfaceC0489a;
    }
}

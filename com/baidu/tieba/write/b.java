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
    private a.InterfaceC0489a fVV;
    private com.baidu.tieba.write.transmit.model.a kLt;
    private List<SimpleForum> kLu;
    private boolean kLv;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> eim = new ArrayList<>();
    private a.InterfaceC0634a kLw = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.b.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            b.this.cUb();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            b.this.kLu = list;
            b.this.mPrivateThread = i;
            b.this.bwq();
        }
    };

    public b() {
        BdUniqueId gen = BdUniqueId.gen();
        this.kLt = new com.baidu.tieba.write.transmit.model.a(gen);
        this.kLt.a(this.kLw);
        this.kLt.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwq() {
        this.eim.clear();
        if (v.getCount(this.kLu) > 0) {
            for (SimpleForum simpleForum : this.kLu) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.eim.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fVV != null) {
            this.fVV.a(this.eim, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUb() {
        if (!this.kLv) {
            if (this.fVV != null) {
                this.fVV.a(null, false, 2, 0);
            }
            this.kLv = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bwf() {
        if (this.fVV != null && this.kLt != null) {
            this.kLv = false;
            this.kLt.setThreadTitle(null);
            this.kLt.setThreadContent(null);
            this.kLt.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0489a interfaceC0489a) {
        this.fVV = interfaceC0489a;
    }
}

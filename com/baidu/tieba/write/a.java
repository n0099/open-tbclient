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
    private a.InterfaceC0195a dik;
    private com.baidu.tieba.write.transmit.model.a hJh;
    private List<SimpleForum> hJi;
    private boolean hJj;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> ciz = new ArrayList<>();
    private a.InterfaceC0324a hJk = new a.InterfaceC0324a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0324a
        public void onError() {
            a.this.bKO();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0324a
        public void h(List<SimpleForum> list, int i) {
            a.this.hJi = list;
            a.this.mPrivateThread = i;
            a.this.apG();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hJh = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hJh.a(this.hJk);
        this.hJh.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apG() {
        this.ciz.clear();
        if (v.H(this.hJi) > 0) {
            for (SimpleForum simpleForum : this.hJi) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.ciz.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dik != null) {
            this.dik.a(this.ciz, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKO() {
        if (!this.hJj) {
            if (this.dik != null) {
                this.dik.a(null, false, 2, 0);
            }
            this.hJj = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void apr() {
        if (this.dik != null && this.hJh != null) {
            this.hJj = false;
            this.hJh.setThreadTitle(null);
            this.hJh.setThreadContent(null);
            this.hJh.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0195a interfaceC0195a) {
        this.dik = interfaceC0195a;
    }
}

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
    private a.InterfaceC0205a doS;
    private com.baidu.tieba.write.transmit.model.a hQs;
    private List<SimpleForum> hQt;
    private boolean hQu;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cmr = new ArrayList<>();
    private a.InterfaceC0338a hQv = new a.InterfaceC0338a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void onError() {
            a.this.bMU();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void h(List<SimpleForum> list, int i) {
            a.this.hQt = list;
            a.this.mPrivateThread = i;
            a.this.ars();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hQs = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hQs.a(this.hQv);
        this.hQs.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ars() {
        this.cmr.clear();
        if (v.H(this.hQt) > 0) {
            for (SimpleForum simpleForum : this.hQt) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cmr.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.doS != null) {
            this.doS.a(this.cmr, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMU() {
        if (!this.hQu) {
            if (this.doS != null) {
                this.doS.a(null, false, 2, 0);
            }
            this.hQu = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void ard() {
        if (this.doS != null && this.hQs != null) {
            this.hQu = false;
            this.hQs.setThreadTitle(null);
            this.hQs.setThreadContent(null);
            this.hQs.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.doS = interfaceC0205a;
    }
}

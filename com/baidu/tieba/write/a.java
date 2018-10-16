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
    private a.InterfaceC0170a dhf;
    private com.baidu.tieba.write.transmit.model.a hHw;
    private List<SimpleForum> hHx;
    private boolean hHy;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cip = new ArrayList<>();
    private a.InterfaceC0296a hHz = new a.InterfaceC0296a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void onError() {
            a.this.bLp();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void h(List<SimpleForum> list, int i) {
            a.this.hHx = list;
            a.this.mPrivateThread = i;
            a.this.aqe();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hHw = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hHw.a(this.hHz);
        this.hHw.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        this.cip.clear();
        if (v.I(this.hHx) > 0) {
            for (SimpleForum simpleForum : this.hHx) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cip.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dhf != null) {
            this.dhf.a(this.cip, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLp() {
        if (!this.hHy) {
            if (this.dhf != null) {
                this.dhf.a(null, false, 2, 0);
            }
            this.hHy = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void apP() {
        if (this.dhf != null && this.hHw != null) {
            this.hHy = false;
            this.hHw.setThreadTitle(null);
            this.hHw.setThreadContent(null);
            this.hHw.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0170a interfaceC0170a) {
        this.dhf = interfaceC0170a;
    }
}

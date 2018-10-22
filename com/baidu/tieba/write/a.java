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
    private com.baidu.tieba.write.transmit.model.a hHx;
    private List<SimpleForum> hHy;
    private boolean hHz;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cip = new ArrayList<>();
    private a.InterfaceC0296a hHA = new a.InterfaceC0296a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void onError() {
            a.this.bLp();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void h(List<SimpleForum> list, int i) {
            a.this.hHy = list;
            a.this.mPrivateThread = i;
            a.this.aqf();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hHx = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hHx.a(this.hHA);
        this.hHx.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqf() {
        this.cip.clear();
        if (v.I(this.hHy) > 0) {
            for (SimpleForum simpleForum : this.hHy) {
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
        if (!this.hHz) {
            if (this.dhf != null) {
                this.dhf.a(null, false, 2, 0);
            }
            this.hHz = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void apQ() {
        if (this.dhf != null && this.hHx != null) {
            this.hHz = false;
            this.hHx.setThreadTitle(null);
            this.hHx.setThreadContent(null);
            this.hHx.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0170a interfaceC0170a) {
        this.dhf = interfaceC0170a;
    }
}

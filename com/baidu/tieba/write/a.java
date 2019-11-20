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
    private a.InterfaceC0393a fbN;
    private com.baidu.tieba.write.transmit.model.a jLT;
    private List<SimpleForum> jLU;
    private boolean jLV;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> hNx = new ArrayList<>();
    private a.InterfaceC0541a jLW = new a.InterfaceC0541a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void onError() {
            a.this.cxv();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void d(List<SimpleForum> list, int i) {
            a.this.jLU = list;
            a.this.mPrivateThread = i;
            a.this.bcl();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jLT = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jLT.a(this.jLW);
        this.jLT.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        this.hNx.clear();
        if (v.getCount(this.jLU) > 0) {
            for (SimpleForum simpleForum : this.jLU) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.hNx.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fbN != null) {
            this.fbN.a(this.hNx, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxv() {
        if (!this.jLV) {
            if (this.fbN != null) {
                this.fbN.a(null, false, 2, 0);
            }
            this.jLV = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bca() {
        if (this.fbN != null && this.jLT != null) {
            this.jLV = false;
            this.jLT.setThreadTitle(null);
            this.jLT.setThreadContent(null);
            this.jLT.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0393a interfaceC0393a) {
        this.fbN = interfaceC0393a;
    }
}

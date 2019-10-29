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
    private a.InterfaceC0393a fcE;
    private com.baidu.tieba.write.transmit.model.a jMK;
    private List<SimpleForum> jML;
    private boolean jMM;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> hOo = new ArrayList<>();
    private a.InterfaceC0541a jMN = new a.InterfaceC0541a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void onError() {
            a.this.cxx();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0541a
        public void d(List<SimpleForum> list, int i) {
            a.this.jML = list;
            a.this.mPrivateThread = i;
            a.this.bcn();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jMK = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jMK.a(this.jMN);
        this.jMK.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcn() {
        this.hOo.clear();
        if (v.getCount(this.jML) > 0) {
            for (SimpleForum simpleForum : this.jML) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.hOo.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.fcE != null) {
            this.fcE.a(this.hOo, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        if (!this.jMM) {
            if (this.fcE != null) {
                this.fcE.a(null, false, 2, 0);
            }
            this.jMM = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void bcc() {
        if (this.fcE != null && this.jMK != null) {
            this.jMM = false;
            this.jMK.setThreadTitle(null);
            this.jMK.setThreadContent(null);
            this.jMK.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0393a interfaceC0393a) {
        this.fcE = interfaceC0393a;
    }
}

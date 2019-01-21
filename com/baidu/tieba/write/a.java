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
    private a.InterfaceC0205a dss;
    private com.baidu.tieba.write.transmit.model.a hUL;
    private List<SimpleForum> hUM;
    private boolean hUN;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cno = new ArrayList<>();
    private a.InterfaceC0337a hUO = new a.InterfaceC0337a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void onError() {
            a.this.bOs();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void h(List<SimpleForum> list, int i) {
            a.this.hUM = list;
            a.this.mPrivateThread = i;
            a.this.asF();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hUL = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hUL.a(this.hUO);
        this.hUL.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asF() {
        this.cno.clear();
        if (v.H(this.hUM) > 0) {
            for (SimpleForum simpleForum : this.hUM) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cno.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dss != null) {
            this.dss.a(this.cno, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOs() {
        if (!this.hUN) {
            if (this.dss != null) {
                this.dss.a(null, false, 2, 0);
            }
            this.hUN = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void asq() {
        if (this.dss != null && this.hUL != null) {
            this.hUN = false;
            this.hUL.setThreadTitle(null);
            this.hUL.setThreadContent(null);
            this.hUL.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.dss = interfaceC0205a;
    }
}

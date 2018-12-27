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
    private a.InterfaceC0205a drI;
    private com.baidu.tieba.write.transmit.model.a hTD;
    private List<SimpleForum> hTE;
    private boolean hTF;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cmC = new ArrayList<>();
    private a.InterfaceC0338a hTG = new a.InterfaceC0338a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void onError() {
            a.this.bNK();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void h(List<SimpleForum> list, int i) {
            a.this.hTE = list;
            a.this.mPrivateThread = i;
            a.this.ash();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hTD = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hTD.a(this.hTG);
        this.hTD.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ash() {
        this.cmC.clear();
        if (v.H(this.hTE) > 0) {
            for (SimpleForum simpleForum : this.hTE) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cmC.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.drI != null) {
            this.drI.a(this.cmC, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNK() {
        if (!this.hTF) {
            if (this.drI != null) {
                this.drI.a(null, false, 2, 0);
            }
            this.hTF = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void arS() {
        if (this.drI != null && this.hTD != null) {
            this.hTF = false;
            this.hTD.setThreadTitle(null);
            this.hTD.setThreadContent(null);
            this.hTD.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.drI = interfaceC0205a;
    }
}

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
    private a.InterfaceC0292a eSX;
    private com.baidu.tieba.write.transmit.model.a jDW;
    private List<SimpleForum> jDX;
    private boolean jDY;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dMa = new ArrayList<>();
    private a.InterfaceC0430a jDZ = new a.InterfaceC0430a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void onError() {
            a.this.cwb();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void g(List<SimpleForum> list, int i) {
            a.this.jDX = list;
            a.this.mPrivateThread = i;
            a.this.aZD();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jDW = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jDW.a(this.jDZ);
        this.jDW.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZD() {
        this.dMa.clear();
        if (v.Z(this.jDX) > 0) {
            for (SimpleForum simpleForum : this.jDX) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dMa.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eSX != null) {
            this.eSX.a(this.dMa, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwb() {
        if (!this.jDY) {
            if (this.eSX != null) {
                this.eSX.a(null, false, 2, 0);
            }
            this.jDY = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aZp() {
        if (this.eSX != null && this.jDW != null) {
            this.jDY = false;
            this.jDW.setThreadTitle(null);
            this.jDW.setThreadContent(null);
            this.jDW.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0292a interfaceC0292a) {
        this.eSX = interfaceC0292a;
    }
}

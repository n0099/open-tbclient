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
    private a.InterfaceC0292a eSY;
    private com.baidu.tieba.write.transmit.model.a jEa;
    private List<SimpleForum> jEb;
    private boolean jEc;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> dMb = new ArrayList<>();
    private a.InterfaceC0430a jEd = new a.InterfaceC0430a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void onError() {
            a.this.cwc();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void g(List<SimpleForum> list, int i) {
            a.this.jEb = list;
            a.this.mPrivateThread = i;
            a.this.aZG();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.jEa = new com.baidu.tieba.write.transmit.model.a(gen);
        this.jEa.a(this.jEd);
        this.jEa.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZG() {
        this.dMb.clear();
        if (v.Z(this.jEb) > 0) {
            for (SimpleForum simpleForum : this.jEb) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.dMb.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.eSY != null) {
            this.eSY.a(this.dMb, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
        if (!this.jEc) {
            if (this.eSY != null) {
                this.eSY.a(null, false, 2, 0);
            }
            this.jEc = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void aZs() {
        if (this.eSY != null && this.jEa != null) {
            this.jEc = false;
            this.jEa.setThreadTitle(null);
            this.jEa.setThreadContent(null);
            this.jEa.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0292a interfaceC0292a) {
        this.eSY = interfaceC0292a;
    }
}

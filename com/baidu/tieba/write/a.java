package com.baidu.tieba.write;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d.a;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.d.a {
    private a.InterfaceC0139a dpK;
    private com.baidu.tieba.write.transmit.model.a hDe;
    private List<SimpleForum> hDf;
    private boolean hDg;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> crv = new ArrayList<>();
    private a.InterfaceC0254a hDh = new a.InterfaceC0254a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void onError() {
            a.this.bFA();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void t(List<SimpleForum> list, int i) {
            a.this.hDf = list;
            a.this.mPrivateThread = i;
            a.this.anl();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hDe = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hDe.a(this.hDh);
        this.hDe.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anl() {
        this.crv.clear();
        if (v.D(this.hDf) > 0) {
            for (SimpleForum simpleForum : this.hDf) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.crv.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dpK != null) {
            this.dpK.a(this.crv, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFA() {
        if (!this.hDg) {
            if (this.dpK != null) {
                this.dpK.a(null, false, 2, 0);
            }
            this.hDg = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void and() {
        if (this.dpK != null && this.hDe != null) {
            this.hDg = false;
            this.hDe.setThreadTitle(null);
            this.hDe.setThreadContent(null);
            this.hDe.Ws();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0139a interfaceC0139a) {
        this.dpK = interfaceC0139a;
    }
}

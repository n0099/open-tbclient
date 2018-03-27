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
    private a.InterfaceC0139a dpN;
    private com.baidu.tieba.write.transmit.model.a hDC;
    private List<SimpleForum> hDD;
    private boolean hDE;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cry = new ArrayList<>();
    private a.InterfaceC0254a hDF = new a.InterfaceC0254a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void onError() {
            a.this.bFF();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0254a
        public void t(List<SimpleForum> list, int i) {
            a.this.hDD = list;
            a.this.mPrivateThread = i;
            a.this.anm();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hDC = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hDC.a(this.hDF);
        this.hDC.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anm() {
        this.cry.clear();
        if (v.D(this.hDD) > 0) {
            for (SimpleForum simpleForum : this.hDD) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cry.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dpN != null) {
            this.dpN.a(this.cry, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFF() {
        if (!this.hDE) {
            if (this.dpN != null) {
                this.dpN.a(null, false, 2, 0);
            }
            this.hDE = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void ane() {
        if (this.dpN != null && this.hDC != null) {
            this.hDE = false;
            this.hDC.setThreadTitle(null);
            this.hDC.setThreadContent(null);
            this.hDC.Wt();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0139a interfaceC0139a) {
        this.dpN = interfaceC0139a;
    }
}

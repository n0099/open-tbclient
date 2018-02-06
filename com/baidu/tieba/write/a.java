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
    private a.InterfaceC0138a dpW;
    private com.baidu.tieba.write.transmit.model.a hDr;
    private List<SimpleForum> hDs;
    private boolean hDt;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> crH = new ArrayList<>();
    private a.InterfaceC0253a hDu = new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void onError() {
            a.this.bFB();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void t(List<SimpleForum> list, int i) {
            a.this.hDs = list;
            a.this.mPrivateThread = i;
            a.this.anm();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hDr = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hDr.a(this.hDu);
        this.hDr.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anm() {
        this.crH.clear();
        if (v.D(this.hDs) > 0) {
            for (SimpleForum simpleForum : this.hDs) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.crH.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dpW != null) {
            this.dpW.a(this.crH, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (!this.hDt) {
            if (this.dpW != null) {
                this.dpW.a(null, false, 2, 0);
            }
            this.hDt = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public void ane() {
        if (this.dpW != null && this.hDr != null) {
            this.hDt = false;
            this.hDr.setThreadTitle(null);
            this.hDr.setThreadContent(null);
            this.hDr.Wt();
        }
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0138a interfaceC0138a) {
        this.dpW = interfaceC0138a;
    }
}

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
    private a.InterfaceC0205a dsr;
    private com.baidu.tieba.write.transmit.model.a hUK;
    private List<SimpleForum> hUL;
    private boolean hUM;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> cnn = new ArrayList<>();
    private a.InterfaceC0337a hUN = new a.InterfaceC0337a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void onError() {
            a.this.bOs();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void h(List<SimpleForum> list, int i) {
            a.this.hUL = list;
            a.this.mPrivateThread = i;
            a.this.asF();
        }
    };

    public a() {
        BdUniqueId gen = BdUniqueId.gen();
        this.hUK = new com.baidu.tieba.write.transmit.model.a(gen);
        this.hUK.a(this.hUN);
        this.hUK.setRequestId(gen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asF() {
        this.cnn.clear();
        if (v.H(this.hUL) > 0) {
            for (SimpleForum simpleForum : this.hUL) {
                if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                    this.cnn.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                }
            }
        }
        if (this.dsr != null) {
            this.dsr.a(this.cnn, true, 2, this.mPrivateThread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOs() {
        if (!this.hUM) {
            if (this.dsr != null) {
                this.dsr.a(null, false, 2, 0);
            }
            this.hUM = true;
        }
    }

    @Override // com.baidu.tieba.c.a
    public void asq() {
        if (this.dsr != null && this.hUK != null) {
            this.hUM = false;
            this.hUK.setThreadTitle(null);
            this.hUK.setThreadContent(null);
            this.hUK.loadData();
        }
    }

    @Override // com.baidu.tieba.c.a
    public void a(a.InterfaceC0205a interfaceC0205a) {
        this.dsr = interfaceC0205a;
    }
}

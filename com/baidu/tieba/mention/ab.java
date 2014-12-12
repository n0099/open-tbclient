package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.mvc.d.c<ad, ae> implements com.baidu.tbadk.mvc.model.d<ae> {
    private SingleMentionActivity brP;
    private com.baidu.tbadk.mvc.e.b brT;
    private FeedData brU;
    private q brV;
    private ad bsr;
    private ac bss;
    private s bst;

    public ab(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.brP = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bsr = new ad();
        this.bss = new ac(this.brP.getPageContext(), this.bsr);
        this.bss.a((com.baidu.tbadk.mvc.model.q) this);
        this.bss.setUniqueId(getUniqueId());
        this.bst = new s(this.brP.getPageContext());
        this.bst.a(this);
        this.bst.setUniqueId(getUniqueId());
        this.brV = new q();
        this.brT = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xk() {
        if (this.bss.isLoading() || !this.brT.xK()) {
            return false;
        }
        this.brT.aQ(true);
        this.brT.aS(true);
        this.bsr.b(this.brU);
        this.bss.setNeedCache(false);
        this.bss.xv();
        a(this.brT);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aO(boolean z) {
        if (this.bss.isLoading()) {
            return false;
        }
        this.brU = null;
        this.bsr.reset();
        this.bss.setNeedCache(true);
        this.bss.xv();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kK() {
        this.bst.a((com.baidu.tbadk.mvc.b.e) this.bsr);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ad adVar, ae aeVar) {
        boolean a = super.a((ab) adVar, (ad) aeVar);
        if (adVar.getUpdateType() != 4) {
            this.brV.TR().clear();
        }
        this.brV.a(aeVar);
        if (aeVar != null && aeVar.TR() != null && aeVar.TR().size() > 0) {
            this.brU = aeVar.TR().get(aeVar.TR().size() - 1);
            this.brT.aR(true);
            if (adVar != null) {
                adVar.OC();
            }
        } else {
            this.brU = null;
            this.brT.aR(false);
        }
        this.brT.aQ(false);
        this.brT.aP(false);
        b(this.brV);
        a(this.brT);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<ae>> readCacheRespMsg, ReadCacheMessage<ae> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bsr, readCacheRespMsg.getData().get(0));
        }
        this.brU = null;
        this.bsr.reset();
        this.bss.setNeedCache(true);
        this.bss.xv();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ae>> writeCacheRespMsg, WriteCacheMessage<ae> writeCacheMessage) {
    }
}

package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.d<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private com.baidu.tbadk.mvc.e.b aCX;
    private SingleMentionActivity bFQ;
    private h bFR;
    private g bFS;
    private a bFT;
    private FeedData bFU;
    private q bFV;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bFQ = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bFR = new h();
        this.bFS = new g(this.bFQ.getPageContext(), this.bFR);
        this.bFS.a((com.baidu.tbadk.mvc.model.q) this);
        this.bFS.setUniqueId(getUniqueId());
        this.bFT = new a(this.bFQ.getPageContext());
        this.bFT.a(this);
        this.bFT.setUniqueId(getUniqueId());
        this.bFV = new q();
        this.aCX = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BA() {
        if (this.bFS.isLoading() || !this.aCX.Ca()) {
            return false;
        }
        this.aCX.bd(true);
        this.aCX.bf(true);
        this.bFR.b(this.bFU);
        this.bFS.setNeedCache(false);
        this.bFS.BL();
        a(this.aCX);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        if (this.bFS.isLoading()) {
            return false;
        }
        this.bFU = null;
        this.bFR.reset();
        this.bFS.setNeedCache(true);
        this.bFS.BL();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        this.bFT.a((com.baidu.tbadk.mvc.b.e) this.bFR);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.bFV.Zo().clear();
        }
        this.bFV.a(iVar);
        if (iVar != null && iVar.Zo() != null && iVar.Zo().size() > 0) {
            this.bFU = iVar.Zo().get(iVar.Zo().size() - 1);
            if (this.bFV.Zp() != null) {
                this.aCX.be(this.bFV.Zp().qR() == 1);
            } else {
                this.aCX.be(true);
            }
            if (hVar != null) {
                hVar.RR();
            }
            this.aCX.bf(true);
        } else {
            this.bFU = null;
            this.aCX.be(false);
            this.aCX.bf(false);
        }
        this.aCX.bd(false);
        this.aCX.bc(false);
        b(this.bFV);
        a(this.aCX);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bFR, readCacheRespMsg.getData().get(0));
        }
        this.bFU = null;
        this.bFR.reset();
        this.bFS.setNeedCache(true);
        this.bFS.BL();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

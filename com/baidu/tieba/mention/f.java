package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.d<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private com.baidu.tbadk.mvc.e.b aCY;
    private SingleMentionActivity bFR;
    private h bFS;
    private g bFT;
    private a bFU;
    private FeedData bFV;
    private q bFW;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bFR = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bFS = new h();
        this.bFT = new g(this.bFR.getPageContext(), this.bFS);
        this.bFT.a((com.baidu.tbadk.mvc.model.q) this);
        this.bFT.setUniqueId(getUniqueId());
        this.bFU = new a(this.bFR.getPageContext());
        this.bFU.a(this);
        this.bFU.setUniqueId(getUniqueId());
        this.bFW = new q();
        this.aCY = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BB() {
        if (this.bFT.isLoading() || !this.aCY.Cb()) {
            return false;
        }
        this.aCY.bd(true);
        this.aCY.bf(true);
        this.bFS.b(this.bFV);
        this.bFT.setNeedCache(false);
        this.bFT.BM();
        a(this.aCY);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        if (this.bFT.isLoading()) {
            return false;
        }
        this.bFV = null;
        this.bFS.reset();
        this.bFT.setNeedCache(true);
        this.bFT.BM();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        this.bFU.a((com.baidu.tbadk.mvc.b.e) this.bFS);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.bFW.Zp().clear();
        }
        this.bFW.a(iVar);
        if (iVar != null && iVar.Zp() != null && iVar.Zp().size() > 0) {
            this.bFV = iVar.Zp().get(iVar.Zp().size() - 1);
            if (this.bFW.Zq() != null) {
                this.aCY.be(this.bFW.Zq().qR() == 1);
            } else {
                this.aCY.be(true);
            }
            if (hVar != null) {
                hVar.RS();
            }
            this.aCY.bf(true);
        } else {
            this.bFV = null;
            this.aCY.be(false);
            this.aCY.bf(false);
        }
        this.aCY.bd(false);
        this.aCY.bc(false);
        b(this.bFW);
        a(this.aCY);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bFS, readCacheRespMsg.getData().get(0));
        }
        this.bFV = null;
        this.bFS.reset();
        this.bFT.setNeedCache(true);
        this.bFT.BM();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

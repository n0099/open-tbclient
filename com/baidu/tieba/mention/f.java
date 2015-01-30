package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.c<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private SingleMentionActivity btl;
    private h btm;
    private g bto;
    private a btp;
    private com.baidu.tbadk.mvc.e.b btq;
    private FeedData btr;
    private q bts;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btl = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.btm = new h();
        this.bto = new g(this.btl.getPageContext(), this.btm);
        this.bto.a((com.baidu.tbadk.mvc.model.q) this);
        this.bto.setUniqueId(getUniqueId());
        this.btp = new a(this.btl.getPageContext());
        this.btp.a(this);
        this.btp.setUniqueId(getUniqueId());
        this.bts = new q();
        this.btq = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xA() {
        if (this.bto.isLoading() || !this.btq.ya()) {
            return false;
        }
        this.btq.aS(true);
        this.btq.aU(true);
        this.btm.b(this.btr);
        this.bto.setNeedCache(false);
        this.bto.xL();
        a(this.btq);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aQ(boolean z) {
        if (this.bto.isLoading()) {
            return false;
        }
        this.btr = null;
        this.btm.reset();
        this.bto.setNeedCache(true);
        this.bto.xL();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kK() {
        this.btp.a((com.baidu.tbadk.mvc.b.e) this.btm);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.bts.Uo().clear();
        }
        this.bts.a(iVar);
        if (iVar != null && iVar.Uo() != null && iVar.Uo().size() > 0) {
            this.btr = iVar.Uo().get(iVar.Uo().size() - 1);
            this.btq.aT(true);
            if (hVar != null) {
                hVar.OZ();
            }
        } else {
            this.btr = null;
            this.btq.aT(false);
        }
        this.btq.aS(false);
        this.btq.aR(false);
        b(this.bts);
        a(this.btq);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.btm, readCacheRespMsg.getData().get(0));
        }
        this.btr = null;
        this.btm.reset();
        this.bto.setNeedCache(true);
        this.bto.xL();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

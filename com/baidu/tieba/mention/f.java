package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.c<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private SingleMentionActivity btk;
    private h btl;
    private g btm;
    private a bto;
    private com.baidu.tbadk.mvc.e.b btp;
    private FeedData btq;
    private q btr;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btk = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.btl = new h();
        this.btm = new g(this.btk.getPageContext(), this.btl);
        this.btm.a((com.baidu.tbadk.mvc.model.q) this);
        this.btm.setUniqueId(getUniqueId());
        this.bto = new a(this.btk.getPageContext());
        this.bto.a(this);
        this.bto.setUniqueId(getUniqueId());
        this.btr = new q();
        this.btp = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xu() {
        if (this.btm.isLoading() || !this.btp.xU()) {
            return false;
        }
        this.btp.aS(true);
        this.btp.aU(true);
        this.btl.b(this.btq);
        this.btm.setNeedCache(false);
        this.btm.xF();
        a(this.btp);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aQ(boolean z) {
        if (this.btm.isLoading()) {
            return false;
        }
        this.btq = null;
        this.btl.reset();
        this.btm.setNeedCache(true);
        this.btm.xF();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kD() {
        this.bto.a((com.baidu.tbadk.mvc.b.e) this.btl);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.btr.Uj().clear();
        }
        this.btr.a(iVar);
        if (iVar != null && iVar.Uj() != null && iVar.Uj().size() > 0) {
            this.btq = iVar.Uj().get(iVar.Uj().size() - 1);
            this.btp.aT(true);
            if (hVar != null) {
                hVar.OU();
            }
        } else {
            this.btq = null;
            this.btp.aT(false);
        }
        this.btp.aS(false);
        this.btp.aR(false);
        b(this.btr);
        a(this.btp);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.btl, readCacheRespMsg.getData().get(0));
        }
        this.btq = null;
        this.btl.reset();
        this.btm.setNeedCache(true);
        this.btm.xF();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

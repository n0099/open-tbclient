package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.d<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private com.baidu.tbadk.mvc.e.b aBe;
    private SingleMentionActivity bCI;
    private h bCJ;
    private g bCK;
    private a bCL;
    private FeedData bCM;
    private q bCN;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bCI = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bCJ = new h();
        this.bCK = new g(this.bCI.getPageContext(), this.bCJ);
        this.bCK.a((com.baidu.tbadk.mvc.model.q) this);
        this.bCK.setUniqueId(getUniqueId());
        this.bCL = new a(this.bCI.getPageContext());
        this.bCL.a(this);
        this.bCL.setUniqueId(getUniqueId());
        this.bCN = new q();
        this.aBe = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AI() {
        if (this.bCK.isLoading() || !this.aBe.Bi()) {
            return false;
        }
        this.aBe.aW(true);
        this.aBe.aY(true);
        this.bCJ.b(this.bCM);
        this.bCK.setNeedCache(false);
        this.bCK.AT();
        a(this.aBe);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        if (this.bCK.isLoading()) {
            return false;
        }
        this.bCM = null;
        this.bCJ.reset();
        this.bCK.setNeedCache(true);
        this.bCK.AT();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        this.bCL.a((com.baidu.tbadk.mvc.b.e) this.bCJ);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.bCN.XD().clear();
        }
        this.bCN.a(iVar);
        if (iVar != null && iVar.XD() != null && iVar.XD().size() > 0) {
            this.bCM = iVar.XD().get(iVar.XD().size() - 1);
            if (this.bCN.XE() != null) {
                this.aBe.aX(this.bCN.XE().ql() == 1);
            } else {
                this.aBe.aX(true);
            }
            if (hVar != null) {
                hVar.Qq();
            }
            this.aBe.aY(true);
        } else {
            this.bCM = null;
            this.aBe.aX(false);
            this.aBe.aY(false);
        }
        this.aBe.aW(false);
        this.aBe.aV(false);
        b(this.bCN);
        a(this.aBe);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bCJ, readCacheRespMsg.getData().get(0));
        }
        this.bCM = null;
        this.bCJ.reset();
        this.bCK.setNeedCache(true);
        this.bCK.AT();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

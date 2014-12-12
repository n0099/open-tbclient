package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.d.c<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private SingleMentionActivity brP;
    private h brQ;
    private g brR;
    private a brS;
    private com.baidu.tbadk.mvc.e.b brT;
    private FeedData brU;
    private q brV;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.brP = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.brQ = new h();
        this.brR = new g(this.brP.getPageContext(), this.brQ);
        this.brR.a((com.baidu.tbadk.mvc.model.q) this);
        this.brR.setUniqueId(getUniqueId());
        this.brS = new a(this.brP.getPageContext());
        this.brS.a(this);
        this.brS.setUniqueId(getUniqueId());
        this.brV = new q();
        this.brT = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xk() {
        if (this.brR.isLoading() || !this.brT.xK()) {
            return false;
        }
        this.brT.aQ(true);
        this.brT.aS(true);
        this.brQ.b(this.brU);
        this.brR.setNeedCache(false);
        this.brR.xv();
        a(this.brT);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aO(boolean z) {
        if (this.brR.isLoading()) {
            return false;
        }
        this.brU = null;
        this.brQ.reset();
        this.brR.setNeedCache(true);
        this.brR.xv();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kK() {
        this.brS.a((com.baidu.tbadk.mvc.b.e) this.brQ);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.brV.TR().clear();
        }
        this.brV.a(iVar);
        if (iVar != null && iVar.TR() != null && iVar.TR().size() > 0) {
            this.brU = iVar.TR().get(iVar.TR().size() - 1);
            this.brT.aR(true);
            if (hVar != null) {
                hVar.OC();
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
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.brQ, readCacheRespMsg.getData().get(0));
        }
        this.brU = null;
        this.brQ.reset();
        this.brR.setNeedCache(true);
        this.brR.xv();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
    }
}

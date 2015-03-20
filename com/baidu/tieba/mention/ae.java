package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.mvc.d.d<ag, ah> implements com.baidu.tbadk.mvc.model.d<ah> {
    private com.baidu.tbadk.mvc.e.b aBe;
    private SingleMentionActivity bCI;
    private FeedData bCM;
    private q bCN;
    private ag bDj;
    private af bDk;
    private v bDl;

    public ae(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bCI = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bDj = new ag();
        this.bDk = new af(this.bCI.getPageContext(), this.bDj);
        this.bDk.a((com.baidu.tbadk.mvc.model.q) this);
        this.bDk.setUniqueId(getUniqueId());
        this.bDl = new v(this.bCI.getPageContext());
        this.bDl.a(this);
        this.bDl.setUniqueId(getUniqueId());
        this.bCN = new q();
        this.aBe = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AI() {
        if (this.bDk.isLoading() || !this.aBe.Bi()) {
            return false;
        }
        this.aBe.aW(true);
        this.aBe.aY(true);
        this.bDj.b(this.bCM);
        this.bDk.setNeedCache(false);
        this.bDk.AT();
        a(this.aBe);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        if (this.bDk.isLoading()) {
            return false;
        }
        this.bCM = null;
        this.bDj.reset();
        this.bDk.setNeedCache(true);
        this.bDk.AT();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        this.bDl.a((com.baidu.tbadk.mvc.b.e) this.bDj);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ag agVar, ah ahVar) {
        boolean a = super.a((ae) agVar, (ag) ahVar);
        if (agVar.getUpdateType() != 4) {
            this.bCN.XD().clear();
        }
        this.bCN.a(ahVar);
        if (ahVar != null && ahVar.XD() != null && ahVar.XD().size() > 0) {
            this.bCM = ahVar.XD().get(ahVar.XD().size() - 1);
            if (this.bCN.XE() != null) {
                this.aBe.aX(this.bCN.XE().ql() == 1);
            } else {
                this.aBe.aX(true);
            }
            if (agVar != null) {
                agVar.Qq();
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
    public void a(ReadCacheRespMsg<List<ah>> readCacheRespMsg, ReadCacheMessage<ah> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bDj, readCacheRespMsg.getData().get(0));
        }
        this.bCM = null;
        this.bDj.reset();
        this.bDk.setNeedCache(true);
        this.bDk.AT();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ah>> writeCacheRespMsg, WriteCacheMessage<ah> writeCacheMessage) {
    }
}

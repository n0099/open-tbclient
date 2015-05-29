package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.mvc.d.d<ag, ah> implements com.baidu.tbadk.mvc.model.d<ah> {
    private com.baidu.tbadk.mvc.e.b aCX;
    private SingleMentionActivity bFQ;
    private FeedData bFU;
    private q bFV;
    private ag bGr;
    private af bGs;
    private v bGt;

    public ae(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bFQ = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bGr = new ag();
        this.bGs = new af(this.bFQ.getPageContext(), this.bGr);
        this.bGs.a((com.baidu.tbadk.mvc.model.q) this);
        this.bGs.setUniqueId(getUniqueId());
        this.bGt = new v(this.bFQ.getPageContext());
        this.bGt.a(this);
        this.bGt.setUniqueId(getUniqueId());
        this.bFV = new q();
        this.aCX = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BA() {
        if (this.bGs.isLoading() || !this.aCX.Ca()) {
            return false;
        }
        this.aCX.bd(true);
        this.aCX.bf(true);
        this.bGr.b(this.bFU);
        this.bGs.setNeedCache(false);
        this.bGs.BL();
        a(this.aCX);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        if (this.bGs.isLoading()) {
            return false;
        }
        this.bFU = null;
        this.bGr.reset();
        this.bGs.setNeedCache(true);
        this.bGs.BL();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        this.bGt.a((com.baidu.tbadk.mvc.b.e) this.bGr);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ag agVar, ah ahVar) {
        boolean a = super.a((ae) agVar, (ag) ahVar);
        if (agVar.getUpdateType() != 4) {
            this.bFV.Zo().clear();
        }
        this.bFV.a(ahVar);
        if (ahVar != null && ahVar.Zo() != null && ahVar.Zo().size() > 0) {
            this.bFU = ahVar.Zo().get(ahVar.Zo().size() - 1);
            if (this.bFV.Zp() != null) {
                this.aCX.be(this.bFV.Zp().qR() == 1);
            } else {
                this.aCX.be(true);
            }
            if (agVar != null) {
                agVar.RR();
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
    public void a(ReadCacheRespMsg<List<ah>> readCacheRespMsg, ReadCacheMessage<ah> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bGr, readCacheRespMsg.getData().get(0));
        }
        this.bFU = null;
        this.bGr.reset();
        this.bGs.setNeedCache(true);
        this.bGs.BL();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ah>> writeCacheRespMsg, WriteCacheMessage<ah> writeCacheMessage) {
    }
}

package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.mvc.d.d<ag, ah> implements com.baidu.tbadk.mvc.model.d<ah> {
    private com.baidu.tbadk.mvc.e.b aCY;
    private SingleMentionActivity bFR;
    private FeedData bFV;
    private q bFW;
    private ag bGs;
    private af bGt;
    private v bGu;

    public ae(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bFR = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bGs = new ag();
        this.bGt = new af(this.bFR.getPageContext(), this.bGs);
        this.bGt.a((com.baidu.tbadk.mvc.model.q) this);
        this.bGt.setUniqueId(getUniqueId());
        this.bGu = new v(this.bFR.getPageContext());
        this.bGu.a(this);
        this.bGu.setUniqueId(getUniqueId());
        this.bFW = new q();
        this.aCY = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean BB() {
        if (this.bGt.isLoading() || !this.aCY.Cb()) {
            return false;
        }
        this.aCY.bd(true);
        this.aCY.bf(true);
        this.bGs.b(this.bFV);
        this.bGt.setNeedCache(false);
        this.bGt.BM();
        a(this.aCY);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean bb(boolean z) {
        if (this.bGt.isLoading()) {
            return false;
        }
        this.bFV = null;
        this.bGs.reset();
        this.bGt.setNeedCache(true);
        this.bGt.BM();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        this.bGu.a((com.baidu.tbadk.mvc.b.e) this.bGs);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ag agVar, ah ahVar) {
        boolean a = super.a((ae) agVar, (ag) ahVar);
        if (agVar.getUpdateType() != 4) {
            this.bFW.Zp().clear();
        }
        this.bFW.a(ahVar);
        if (ahVar != null && ahVar.Zp() != null && ahVar.Zp().size() > 0) {
            this.bFV = ahVar.Zp().get(ahVar.Zp().size() - 1);
            if (this.bFW.Zq() != null) {
                this.aCY.be(this.bFW.Zq().qR() == 1);
            } else {
                this.aCY.be(true);
            }
            if (agVar != null) {
                agVar.RS();
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
    public void a(ReadCacheRespMsg<List<ah>> readCacheRespMsg, ReadCacheMessage<ah> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bGs, readCacheRespMsg.getData().get(0));
        }
        this.bFV = null;
        this.bGs.reset();
        this.bGt.setNeedCache(true);
        this.bGt.BM();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ah>> writeCacheRespMsg, WriteCacheMessage<ah> writeCacheMessage) {
    }
}

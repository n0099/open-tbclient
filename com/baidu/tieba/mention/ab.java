package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.mvc.d.c<ad, ae> implements com.baidu.tbadk.mvc.model.d<ae> {
    private ad btO;
    private ac btP;
    private s btQ;
    private SingleMentionActivity btl;
    private com.baidu.tbadk.mvc.e.b btq;
    private FeedData btr;
    private q bts;

    public ab(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btl = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.btO = new ad();
        this.btP = new ac(this.btl.getPageContext(), this.btO);
        this.btP.a((com.baidu.tbadk.mvc.model.q) this);
        this.btP.setUniqueId(getUniqueId());
        this.btQ = new s(this.btl.getPageContext());
        this.btQ.a(this);
        this.btQ.setUniqueId(getUniqueId());
        this.bts = new q();
        this.btq = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xA() {
        if (this.btP.isLoading() || !this.btq.ya()) {
            return false;
        }
        this.btq.aS(true);
        this.btq.aU(true);
        this.btO.b(this.btr);
        this.btP.setNeedCache(false);
        this.btP.xL();
        a(this.btq);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aQ(boolean z) {
        if (this.btP.isLoading()) {
            return false;
        }
        this.btr = null;
        this.btO.reset();
        this.btP.setNeedCache(true);
        this.btP.xL();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kK() {
        this.btQ.a((com.baidu.tbadk.mvc.b.e) this.btO);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ad adVar, ae aeVar) {
        boolean a = super.a((ab) adVar, (ad) aeVar);
        if (adVar.getUpdateType() != 4) {
            this.bts.Uo().clear();
        }
        this.bts.a(aeVar);
        if (aeVar != null && aeVar.Uo() != null && aeVar.Uo().size() > 0) {
            this.btr = aeVar.Uo().get(aeVar.Uo().size() - 1);
            this.btq.aT(true);
            if (adVar != null) {
                adVar.OZ();
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
    public void a(ReadCacheRespMsg<List<ae>> readCacheRespMsg, ReadCacheMessage<ae> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.btO, readCacheRespMsg.getData().get(0));
        }
        this.btr = null;
        this.btO.reset();
        this.btP.setNeedCache(true);
        this.btP.xL();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ae>> writeCacheRespMsg, WriteCacheMessage<ae> writeCacheMessage) {
    }
}

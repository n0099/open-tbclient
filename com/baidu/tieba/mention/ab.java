package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.mvc.d.c<ad, ae> implements com.baidu.tbadk.mvc.model.d<ae> {
    private ad btN;
    private ac btO;
    private s btP;
    private SingleMentionActivity btk;
    private com.baidu.tbadk.mvc.e.b btp;
    private FeedData btq;
    private q btr;

    public ab(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.btk = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.btN = new ad();
        this.btO = new ac(this.btk.getPageContext(), this.btN);
        this.btO.a((com.baidu.tbadk.mvc.model.q) this);
        this.btO.setUniqueId(getUniqueId());
        this.btP = new s(this.btk.getPageContext());
        this.btP.a(this);
        this.btP.setUniqueId(getUniqueId());
        this.btr = new q();
        this.btp = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.c
    protected boolean xu() {
        if (this.btO.isLoading() || !this.btp.xU()) {
            return false;
        }
        this.btp.aS(true);
        this.btp.aU(true);
        this.btN.b(this.btq);
        this.btO.setNeedCache(false);
        this.btO.xF();
        a(this.btp);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean aQ(boolean z) {
        if (this.btO.isLoading()) {
            return false;
        }
        this.btq = null;
        this.btN.reset();
        this.btO.setNeedCache(true);
        this.btO.xF();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean kD() {
        this.btP.a((com.baidu.tbadk.mvc.b.e) this.btN);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ad adVar, ae aeVar) {
        boolean a = super.a((ab) adVar, (ad) aeVar);
        if (adVar.getUpdateType() != 4) {
            this.btr.Uj().clear();
        }
        this.btr.a(aeVar);
        if (aeVar != null && aeVar.Uj() != null && aeVar.Uj().size() > 0) {
            this.btq = aeVar.Uj().get(aeVar.Uj().size() - 1);
            this.btp.aT(true);
            if (adVar != null) {
                adVar.OU();
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
    public void a(ReadCacheRespMsg<List<ae>> readCacheRespMsg, ReadCacheMessage<ae> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.btN, readCacheRespMsg.getData().get(0));
        }
        this.btq = null;
        this.btN.reset();
        this.btO.setNeedCache(true);
        this.btO.xF();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ae>> writeCacheRespMsg, WriteCacheMessage<ae> writeCacheMessage) {
    }
}

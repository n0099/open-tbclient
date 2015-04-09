package com.baidu.tieba.mention;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends com.baidu.tbadk.mvc.d.d<ag, ah> implements com.baidu.tbadk.mvc.model.d<ah> {
    private com.baidu.tbadk.mvc.e.b aBm;
    private SingleMentionActivity bCV;
    private FeedData bCZ;
    private q bDa;
    private ag bDw;
    private af bDx;
    private v bDy;

    public ae(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bCV = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bDw = new ag();
        this.bDx = new af(this.bCV.getPageContext(), this.bDw);
        this.bDx.a((com.baidu.tbadk.mvc.model.q) this);
        this.bDx.setUniqueId(getUniqueId());
        this.bDy = new v(this.bCV.getPageContext());
        this.bDy.a(this);
        this.bDy.setUniqueId(getUniqueId());
        this.bDa = new q();
        this.aBm = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AO() {
        if (this.bDx.isLoading() || !this.aBm.Bo()) {
            return false;
        }
        if (I(this.bDa.XP())) {
            b(this.bDa);
        }
        this.aBm.aW(true);
        this.aBm.aY(true);
        this.bDw.b(this.bCZ);
        this.bDx.setNeedCache(false);
        this.bDx.AZ();
        a(this.aBm);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        if (this.bDx.isLoading()) {
            return false;
        }
        this.bCZ = null;
        this.bDw.reset();
        this.bDx.setNeedCache(true);
        this.bDx.AZ();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        this.bDy.a((com.baidu.tbadk.mvc.b.e) this.bDw);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(ag agVar, ah ahVar) {
        boolean a = super.a((ae) agVar, (ag) ahVar);
        if (agVar.getUpdateType() != 4) {
            this.bDa.XP().clear();
        }
        this.bDa.a(ahVar);
        if (ahVar != null && ahVar.XP() != null && ahVar.XP().size() > 0) {
            this.bCZ = ahVar.XP().get(ahVar.XP().size() - 1);
            if (this.bDa.XQ() != null) {
                this.aBm.aX(this.bDa.XQ().ql() == 1);
            } else {
                this.aBm.aX(true);
            }
            if (agVar != null) {
                agVar.QD();
            }
            this.aBm.aY(true);
        } else {
            this.bCZ = null;
            this.aBm.aX(false);
            this.aBm.aY(false);
        }
        this.aBm.aW(false);
        this.aBm.aV(false);
        b(this.bDa);
        a(this.aBm);
        return a;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<ah>> readCacheRespMsg, ReadCacheMessage<ah> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bDw, readCacheRespMsg.getData().get(0));
        }
        this.bCZ = null;
        this.bDw.reset();
        this.bDx.setNeedCache(true);
        this.bDx.AZ();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ah>> writeCacheRespMsg, WriteCacheMessage<ah> writeCacheMessage) {
    }

    private boolean I(ArrayList<FeedData> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        int size = (arrayList.size() + 20) - TbadkCoreApplication.m411getInst().getListItemRule().uF();
        if (size > 0 && arrayList.size() > size) {
            for (int i = 0; i < size; i++) {
                arrayList.remove(0);
            }
        }
        return size > 0;
    }
}

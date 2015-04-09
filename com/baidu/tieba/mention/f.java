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
public class f extends com.baidu.tbadk.mvc.d.d<h, i> implements com.baidu.tbadk.mvc.model.d<i> {
    private com.baidu.tbadk.mvc.e.b aBm;
    private SingleMentionActivity bCV;
    private h bCW;
    private g bCX;
    private a bCY;
    private FeedData bCZ;
    private q bDa;

    public f(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity);
        this.bCV = singleMentionActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        this.bCW = new h();
        this.bCX = new g(this.bCV.getPageContext(), this.bCW);
        this.bCX.a((com.baidu.tbadk.mvc.model.q) this);
        this.bCX.setUniqueId(getUniqueId());
        this.bCY = new a(this.bCV.getPageContext());
        this.bCY.a(this);
        this.bCY.setUniqueId(getUniqueId());
        this.bDa = new q();
        this.aBm = new com.baidu.tbadk.mvc.e.b();
    }

    @Override // com.baidu.tbadk.mvc.d.d
    protected boolean AO() {
        if (this.bCX.isLoading() || !this.aBm.Bo()) {
            return false;
        }
        if (I(this.bDa.XP())) {
            b(this.bDa);
        }
        this.aBm.aW(true);
        this.aBm.aY(true);
        this.bCW.b(this.bCZ);
        this.bCX.setNeedCache(false);
        this.bCX.AZ();
        a(this.aBm);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    protected boolean aU(boolean z) {
        if (this.bCX.isLoading()) {
            return false;
        }
        this.bCZ = null;
        this.bCW.reset();
        this.bCX.setNeedCache(true);
        this.bCX.AZ();
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        this.bCY.a((com.baidu.tbadk.mvc.b.e) this.bCW);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(h hVar, i iVar) {
        boolean a = super.a((f) hVar, (h) iVar);
        if (hVar.getUpdateType() != 4) {
            this.bDa.XP().clear();
        }
        this.bDa.a(iVar);
        if (iVar != null && iVar.XP() != null && iVar.XP().size() > 0) {
            this.bCZ = iVar.XP().get(iVar.XP().size() - 1);
            if (this.bDa.XQ() != null) {
                this.aBm.aX(this.bDa.XQ().ql() == 1);
            } else {
                this.aBm.aX(true);
            }
            if (hVar != null) {
                hVar.QD();
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
    public void a(ReadCacheRespMsg<List<i>> readCacheRespMsg, ReadCacheMessage<i> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            a(this.bCW, readCacheRespMsg.getData().get(0));
        }
        this.bCZ = null;
        this.bCW.reset();
        this.bCX.setNeedCache(true);
        this.bCX.AZ();
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<i>> writeCacheRespMsg, WriteCacheMessage<i> writeCacheMessage) {
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

package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.c<f, g> {
    public final c bPc;
    public final f bPd;
    private d bPe;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bPc = new c();
        this.bPd = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bPd.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bPc.acN());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bPd.j(bundle);
        }
        this.bPe = new d(AL().getPageContext(), this.bPd);
        this.bPe.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bPc.hG(bundle.getInt("KeyIntentPraiseId"));
        }
        AM().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean oM() {
        this.bPe.BM();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bPc.a(gVar);
        this.bPd.acR();
        this.bPc.setStatus(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        if (this.bPd.getPageNum() > 5) {
            this.bPc.setStatus(1003);
        }
        if (this.bPc.acO() >= this.bPc.acN()) {
            this.bPc.setStatus(BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE);
        }
        b(this.bPc);
        return true;
    }
}

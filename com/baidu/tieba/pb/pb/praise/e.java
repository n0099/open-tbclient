package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.c<f, g> {
    public final c bPb;
    public final f bPc;
    private d bPd;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bPb = new c();
        this.bPc = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bPc.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bPb.acM());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bPc.j(bundle);
        }
        this.bPd = new d(AK().getPageContext(), this.bPc);
        this.bPd.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bPb.hG(bundle.getInt("KeyIntentPraiseId"));
        }
        AL().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean oM() {
        this.bPd.BL();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bPb.a(gVar);
        this.bPc.acQ();
        this.bPb.setStatus(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        if (this.bPc.getPageNum() > 5) {
            this.bPb.setStatus(1003);
        }
        if (this.bPb.acN() >= this.bPb.acM()) {
            this.bPb.setStatus(BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE);
        }
        b(this.bPb);
        return true;
    }
}

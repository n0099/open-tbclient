package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.c<f, g> {
    public final c bMN;
    public final f bMO;
    private d bMP;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bMN = new c();
        this.bMO = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bMO.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bMN.abF());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bMO.j(bundle);
        }
        this.bMP = new d(zS().getPageContext(), this.bMO);
        this.bMP.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bMN.hq(bundle.getInt("KeyIntentPraiseId"));
        }
        zT().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean ow() {
        this.bMP.AT();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bMN.a(gVar);
        this.bMO.abJ();
        this.bMN.setStatus(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        if (this.bMO.getPageNum() > 5) {
            this.bMN.setStatus(1003);
        }
        if (this.bMN.abG() >= this.bMN.abF()) {
            this.bMN.setStatus(BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE);
        }
        b(this.bMN);
        return true;
    }
}

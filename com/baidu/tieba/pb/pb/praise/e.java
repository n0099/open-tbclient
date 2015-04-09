package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.c<f, g> {
    public final c bNd;
    public final f bNe;
    private d bNf;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bNd = new c();
        this.bNe = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bNe.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bNd.abU());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bNe.j(bundle);
        }
        this.bNf = new d(zY().getPageContext(), this.bNe);
        this.bNf.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bNd.hs(bundle.getInt("KeyIntentPraiseId"));
        }
        zZ().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean ow() {
        this.bNf.AZ();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bNd.a(gVar);
        this.bNe.abY();
        this.bNd.setStatus(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        if (this.bNe.getPageNum() > 5) {
            this.bNd.setStatus(1003);
        }
        if (this.bNd.abV() >= this.bNd.abU()) {
            this.bNd.setStatus(BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE);
        }
        b(this.bNd);
        return true;
    }
}

package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.model.j;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.a<f, g> {
    public final c bzE;
    public final f bzF;
    private d bzG;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bzE = new c();
        this.bzF = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bzF.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bzE.Yz());
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void b(Bundle bundle) {
        super.b(bundle);
        if (bundle != null) {
            this.bzF.l(bundle);
        }
        this.bzG = new d(sZ(), this.bzF);
        this.bzG.a((j) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bzE.gR(bundle.getInt("KeyIntentPraiseId"));
        }
        ta().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean tz() {
        this.bzG.tN();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bzE.a(gVar);
        this.bzF.YD();
        this.bzE.setStatus(1001);
        if (this.bzF.getPageNum() > 5) {
            this.bzE.setStatus(1003);
        }
        if (this.bzE.YA() >= this.bzE.Yz()) {
            this.bzE.setStatus(1002);
        }
        a(this.bzE);
        return true;
    }
}

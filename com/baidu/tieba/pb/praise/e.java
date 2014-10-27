package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.model.j;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.a<f, g> {
    public final c bzq;
    public final f bzr;
    private d bzs;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bzq = new c();
        this.bzr = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bzr.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bzq.Yw());
    }

    @Override // com.baidu.tbadk.mvc.core.a
    public void b(Bundle bundle) {
        super.b(bundle);
        if (bundle != null) {
            this.bzr.l(bundle);
        }
        this.bzs = new d(sX(), this.bzr);
        this.bzs.a((j) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bzq.gR(bundle.getInt("KeyIntentPraiseId"));
        }
        sY().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean tx() {
        this.bzs.tL();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bzq.a(gVar);
        this.bzr.YA();
        this.bzq.setStatus(1001);
        if (this.bzr.getPageNum() > 5) {
            this.bzq.setStatus(1003);
        }
        if (this.bzq.Yx() >= this.bzq.Yw()) {
            this.bzq.setStatus(1002);
        }
        a(this.bzq);
        return true;
    }
}

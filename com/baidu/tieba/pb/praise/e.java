package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.b<f, g> {
    public final c bDw;
    public final f bDx;
    private d bDy;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bDw = new c();
        this.bDx = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bDx.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bDw.YX());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bDx.l(bundle);
        }
        this.bDy = new d(ww().getPageContext(), this.bDx);
        this.bDy.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bDw.gX(bundle.getInt("KeyIntentPraiseId"));
        }
        wx().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean kK() {
        this.bDy.xv();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bDw.a(gVar);
        this.bDx.Zb();
        this.bDw.setStatus(1001);
        if (this.bDx.getPageNum() > 5) {
            this.bDw.setStatus(1003);
        }
        if (this.bDw.YY() >= this.bDw.YX()) {
            this.bDw.setStatus(1002);
        }
        b(this.bDw);
        return true;
    }
}

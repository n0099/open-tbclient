package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.b<f, g> {
    public final c bFg;
    public final f bFh;
    private d bFi;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bFg = new c();
        this.bFh = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bFh.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bFg.Zx());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bFh.l(bundle);
        }
        this.bFi = new d(wG().getPageContext(), this.bFh);
        this.bFi.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bFg.hg(bundle.getInt("KeyIntentPraiseId"));
        }
        wH().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean kD() {
        this.bFi.xF();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bFg.a(gVar);
        this.bFh.ZB();
        this.bFg.setStatus(1001);
        if (this.bFh.getPageNum() > 5) {
            this.bFg.setStatus(1003);
        }
        if (this.bFg.Zy() >= this.bFg.Zx()) {
            this.bFg.setStatus(1002);
        }
        b(this.bFg);
        return true;
    }
}

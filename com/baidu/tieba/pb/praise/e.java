package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.tbadk.mvc.model.r;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.d.b<f, g> {
    public final c bFh;
    public final f bFi;
    private d bFj;

    public e(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bFh = new c();
        this.bFi = new f();
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(this.bFi.toBundle());
        bundle.putInt("KeyIntentPraiseId", this.bFh.ZC());
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.bFi.l(bundle);
        }
        this.bFj = new d(wM().getPageContext(), this.bFi);
        this.bFj.a((r) this);
        if (bundle.containsKey("KeyIntentPraiseId")) {
            this.bFh.hg(bundle.getInt("KeyIntentPraiseId"));
        }
        wN().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    protected boolean kK() {
        this.bFj.xL();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(f fVar, g gVar) {
        this.bFh.a(gVar);
        this.bFi.ZG();
        this.bFh.setStatus(1001);
        if (this.bFi.getPageNum() > 5) {
            this.bFh.setStatus(1003);
        }
        if (this.bFh.ZD() >= this.bFh.ZC()) {
            this.bFh.setStatus(1002);
        }
        b(this.bFh);
        return true;
    }
}

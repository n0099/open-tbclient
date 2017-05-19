package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a ebl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ebl = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.ebl.ebk;
        forbidActivity2 = this.ebl.ebk;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_success));
        forbidActivity3 = this.ebl.ebk;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.ebl.ebk;
        forbidActivity2 = this.ebl.ebk;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_failure));
    }
}

package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a dUR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dUR = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.dUR.dUQ;
        forbidActivity2 = this.dUR.dUQ;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(r.j.forbid_success));
        forbidActivity3 = this.dUR.dUQ;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.dUR.dUQ;
        forbidActivity2 = this.dUR.dUQ;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(r.j.forbid_failure));
    }
}

package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ddy = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.ddy.ddx;
        forbidActivity2 = this.ddy.ddx;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_success));
        forbidActivity3 = this.ddy.ddx;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.ddy.ddx;
        forbidActivity2 = this.ddy.ddx;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_failure));
    }
}

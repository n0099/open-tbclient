package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a dWj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dWj = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.dWj.dWi;
        forbidActivity2 = this.dWj.dWi;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(u.j.forbid_success));
        forbidActivity3 = this.dWj.dWi;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.dWj.dWi;
        forbidActivity2 = this.dWj.dWi;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(u.j.forbid_failure));
    }
}

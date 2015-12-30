package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.n;
import com.baidu.tieba.pb.account.forbid.f;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a cBn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cBn = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.cBn.cBm;
        forbidActivity2 = this.cBn.cBm;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(n.j.forbid_success));
        forbidActivity3 = this.cBn.cBm;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.cBn.cBm;
        forbidActivity2 = this.cBn.cBm;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(n.j.forbid_failure));
    }
}

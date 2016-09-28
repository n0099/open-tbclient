package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a ekm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ekm = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.ekm.ekl;
        forbidActivity2 = this.ekm.ekl;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(r.j.forbid_success));
        forbidActivity3 = this.ekm.ekl;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.ekm.ekl;
        forbidActivity2 = this.ekm.ekl;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(r.j.forbid_failure));
    }
}

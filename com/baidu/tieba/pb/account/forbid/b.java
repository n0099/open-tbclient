package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a eio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eio = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.eio.ein;
        forbidActivity2 = this.eio.ein;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_success));
        forbidActivity3 = this.eio.ein;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.eio.ein;
        forbidActivity2 = this.eio.ein;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_failure));
    }
}

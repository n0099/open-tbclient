package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a epF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.epF = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.epF.epE;
        forbidActivity2 = this.epF.epE;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_success));
        forbidActivity3 = this.epF.epE;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.epF.epE;
        forbidActivity2 = this.epF.epE;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_failure));
    }
}

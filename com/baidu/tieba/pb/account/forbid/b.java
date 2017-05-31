package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a egI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.egI = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.egI.egH;
        forbidActivity2 = this.egI.egH;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_success));
        forbidActivity3 = this.egI.egH;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.egI.egH;
        forbidActivity2 = this.egI.egH;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(w.l.forbid_failure));
    }
}

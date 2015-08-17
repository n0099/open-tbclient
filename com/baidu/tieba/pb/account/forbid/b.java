package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.i;
import com.baidu.tieba.pb.account.forbid.f;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a bYs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYs = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.bYs.bYr;
        forbidActivity2 = this.bYs.bYr;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(i.C0057i.forbid_success));
        forbidActivity3 = this.bYs.bYr;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.bYs.bYr;
        forbidActivity2 = this.bYs.bYr;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(i.C0057i.forbid_failure));
    }
}

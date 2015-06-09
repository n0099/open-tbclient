package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a bIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bIG = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.bIG.bIF;
        forbidActivity2 = this.bIG.bIF;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.forbid_success));
        forbidActivity3 = this.bIG.bIF;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.bIG.bIF;
        forbidActivity2 = this.bIG.bIF;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.forbid_failure));
    }
}

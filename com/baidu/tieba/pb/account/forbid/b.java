package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a bFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bFx = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.bFx.bFw;
        forbidActivity2 = this.bFx.bFw;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(y.forbid_success));
        forbidActivity3 = this.bFx.bFw;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.bFx.bFw;
        forbidActivity2 = this.bFx.bFw;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(y.forbid_failure));
    }
}

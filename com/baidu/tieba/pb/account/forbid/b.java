package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.pb.account.forbid.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a cHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cHT = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.cHT.cHS;
        forbidActivity2 = this.cHT.cHS;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_success));
        forbidActivity3 = this.cHT.cHS;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.cHT.cHS;
        forbidActivity2 = this.cHT.cHS;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(t.j.forbid_failure));
    }
}

package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.n;
import com.baidu.tieba.pb.account.forbid.f;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a cxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cxG = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.cxG.cxF;
        forbidActivity2 = this.cxG.cxF;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(n.i.forbid_success));
        forbidActivity3 = this.cxG.cxF;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.cxG.cxF;
        forbidActivity2 = this.cxG.cxF;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(n.i.forbid_failure));
    }
}

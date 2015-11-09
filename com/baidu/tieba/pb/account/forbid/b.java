package com.baidu.tieba.pb.account.forbid;

import com.baidu.tieba.i;
import com.baidu.tieba.pb.account.forbid.f;
/* loaded from: classes.dex */
class b implements f.b {
    final /* synthetic */ a cfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cfg = aVar;
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.cfg.cff;
        forbidActivity2 = this.cfg.cff;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(i.h.forbid_success));
        forbidActivity3 = this.cfg.cff;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.pb.account.forbid.f.b
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.cfg.cff;
        forbidActivity2 = this.cfg.cff;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(i.h.forbid_failure));
    }
}

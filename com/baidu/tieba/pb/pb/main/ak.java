package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ak extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        fx fxVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        fx fxVar2;
        ForumManageModel forumManageModel4;
        fx fxVar3;
        fx fxVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.enc.elT;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.enc.ele;
                    pbModel.aLa();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.crt || bVar.eyS <= 0 || bVar.fEp == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.enc.getPageContext(), 2, 1);
                    }
                    this.enc.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    fxVar4 = this.enc.elU;
                    fxVar4.a(1, dVar.AM, dVar.fEr, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.enc;
                    forumManageModel3 = this.enc.elT;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    fxVar2 = this.enc.elU;
                    forumManageModel4 = this.enc.elT;
                    fxVar2.a(forumManageModel4.getLoadDataMode(), fVar.AM, fVar.fEr, false);
                    fxVar3 = this.enc.elU;
                    fxVar3.ak(fVar.fEt);
                    return;
                default:
                    return;
            }
        }
        fxVar = this.enc.elU;
        forumManageModel = this.enc.elT;
        fxVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

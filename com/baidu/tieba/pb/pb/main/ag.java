package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ey eyVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        ey eyVar2;
        ForumManageModel forumManageModel4;
        ey eyVar3;
        ey eyVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.ejU.eiR;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.ejU.eif;
                    pbModel.aLQ();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.clG || bVar.etI <= 0 || bVar.fxY == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.ejU.getPageContext(), 2, 1);
                    }
                    this.ejU.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    eyVar4 = this.ejU.eiS;
                    eyVar4.a(1, dVar.AJ, dVar.fya, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ejU;
                    forumManageModel3 = this.ejU.eiR;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    eyVar2 = this.ejU.eiS;
                    forumManageModel4 = this.ejU.eiR;
                    eyVar2.a(forumManageModel4.getLoadDataMode(), fVar.AJ, fVar.fya, false);
                    eyVar3 = this.ejU.eiS;
                    eyVar3.al(fVar.fyc);
                    return;
                default:
                    return;
            }
        }
        eyVar = this.ejU.eiS;
        forumManageModel = this.ejU.eiR;
        eyVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

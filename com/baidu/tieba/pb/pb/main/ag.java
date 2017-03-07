package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        fa faVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        fa faVar2;
        ForumManageModel forumManageModel4;
        fa faVar3;
        fa faVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.elO.ekL;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.elO.ejZ;
                    pbModel.aLH();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.cnh || bVar.evD <= 0 || bVar.fwo == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.elO.getPageContext(), 2, 1);
                    }
                    this.elO.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    faVar4 = this.elO.ekM;
                    faVar4.a(1, dVar.Bi, dVar.fwq, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.elO;
                    forumManageModel3 = this.elO.ekL;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    faVar2 = this.elO.ekM;
                    forumManageModel4 = this.elO.ekL;
                    faVar2.a(forumManageModel4.getLoadDataMode(), fVar.Bi, fVar.fwq, false);
                    faVar3 = this.elO.ekM;
                    faVar3.al(fVar.fws);
                    return;
                default:
                    return;
            }
        }
        faVar = this.elO.ekM;
        forumManageModel = this.elO.ekL;
        faVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

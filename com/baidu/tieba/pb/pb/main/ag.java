package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ez ezVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        ez ezVar2;
        ForumManageModel forumManageModel4;
        ez ezVar3;
        ez ezVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.eiV.ehU;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.eiV.ehh;
                    pbModel.aMl();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.clJ || bVar.esp <= 0 || bVar.frR == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eiV.getPageContext(), 2, 1);
                    }
                    this.eiV.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    ezVar4 = this.eiV.ehV;
                    ezVar4.a(1, dVar.tT, dVar.frT, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.eiV;
                    forumManageModel3 = this.eiV.ehU;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    ezVar2 = this.eiV.ehV;
                    forumManageModel4 = this.eiV.ehU;
                    ezVar2.a(forumManageModel4.getLoadDataMode(), fVar.tT, fVar.frT, false);
                    ezVar3 = this.eiV.ehV;
                    ezVar3.al(fVar.frV);
                    return;
                default:
                    return;
            }
        }
        ezVar = this.eiV.ehV;
        forumManageModel = this.eiV.ehU;
        ezVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

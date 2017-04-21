package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.emk = pbActivity;
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
            forumManageModel2 = this.emk.elh;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.emk.ekv;
                    pbModel.aMR();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.cnZ || bVar.evY <= 0 || bVar.fAo == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.emk.getPageContext(), 2, 1);
                    }
                    this.emk.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    eyVar4 = this.emk.eli;
                    eyVar4.a(1, dVar.AM, dVar.fAq, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.emk;
                    forumManageModel3 = this.emk.elh;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    eyVar2 = this.emk.eli;
                    forumManageModel4 = this.emk.elh;
                    eyVar2.a(forumManageModel4.getLoadDataMode(), fVar.AM, fVar.fAq, false);
                    eyVar3 = this.emk.eli;
                    eyVar3.al(fVar.fAs);
                    return;
                default:
                    return;
            }
        }
        eyVar = this.emk.eli;
        forumManageModel = this.emk.elh;
        eyVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

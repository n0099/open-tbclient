package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class ah extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        fm fmVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        fm fmVar2;
        ForumManageModel forumManageModel4;
        fm fmVar3;
        fm fmVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.ehy.egs;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.ehy.efE;
                    pbModel.aKg();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.ckU || bVar.erG <= 0 || bVar.fwx == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.ehy.getPageContext(), 2, 1);
                    }
                    this.ehy.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    fmVar4 = this.ehy.egt;
                    fmVar4.a(1, dVar.AM, dVar.fwz, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ehy;
                    forumManageModel3 = this.ehy.egs;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    fmVar2 = this.ehy.egt;
                    forumManageModel4 = this.ehy.egs;
                    fmVar2.a(forumManageModel4.getLoadDataMode(), fVar.AM, fVar.fwz, false);
                    fmVar3 = this.ehy.egt;
                    fmVar3.ak(fVar.fwB);
                    return;
                default:
                    return;
            }
        }
        fmVar = this.ehy.egt;
        forumManageModel = this.ehy.egs;
        fmVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

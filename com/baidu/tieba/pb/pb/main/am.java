package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* loaded from: classes.dex */
class am extends com.baidu.adp.base.f {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        gg ggVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ForumManageModel forumManageModel3;
        gg ggVar2;
        ForumManageModel forumManageModel4;
        gg ggVar3;
        gg ggVar4;
        PbModel pbModel;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.ewh.euT;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    pbModel = this.ewh.eue;
                    pbModel.aOX();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.czh || bVar.eIp <= 0 || bVar.fOu == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.ewh.getPageContext(), 2, 1);
                    }
                    this.ewh.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    ggVar4 = this.ewh.euU;
                    ggVar4.a(1, dVar.AM, dVar.fOw, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ewh;
                    forumManageModel3 = this.ewh.euT;
                    pbActivity.a(forumManageModel3.getLoadDataMode(), (ForumManageModel.f) obj);
                    return;
                case 6:
                    ForumManageModel.f fVar = (ForumManageModel.f) obj;
                    ggVar2 = this.ewh.euU;
                    forumManageModel4 = this.ewh.euT;
                    ggVar2.a(forumManageModel4.getLoadDataMode(), fVar.AM, fVar.fOw, false);
                    ggVar3 = this.ewh.euU;
                    ggVar3.am(fVar.fOy);
                    return;
                default:
                    return;
            }
        }
        ggVar = this.ewh.euU;
        forumManageModel = this.ewh.euT;
        ggVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.esV.esF;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.clG || bVar.etI <= 0 || bVar.fxY == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.esV.getPageContext(), 3, 1);
                    }
                    this.esV.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.esV.esG;
                    aoVar2.a(1, dVar.AJ, dVar.fya, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.esV.esG;
        forumManageModel = this.esV.esF;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

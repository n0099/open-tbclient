package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.erC.erm;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.clJ || bVar.esp <= 0 || bVar.frR == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.erC.getPageContext(), 3, 1);
                    }
                    this.erC.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.erC.ern;
                    aoVar2.a(1, dVar.tT, dVar.frT, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.erC.ern;
        forumManageModel = this.erC.erm;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

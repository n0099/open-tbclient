package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.eye.exO;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.crt || bVar.eyS <= 0 || bVar.fEp == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eye.getPageContext(), 3, 1);
                    }
                    this.eye.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.eye.exP;
                    aoVar2.a(1, dVar.AM, dVar.fEr, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.eye.exP;
        forumManageModel = this.eye.exO;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

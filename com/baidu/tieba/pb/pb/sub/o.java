package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.euQ.euA;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.cnh || bVar.evD <= 0 || bVar.fwo == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.euQ.getPageContext(), 3, 1);
                    }
                    this.euQ.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.euQ.euB;
                    aoVar2.a(1, dVar.Bi, dVar.fwq, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.euQ.euB;
        forumManageModel = this.euQ.euA;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

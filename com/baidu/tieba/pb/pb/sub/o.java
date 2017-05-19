package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.eqU.eqE;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.ckU || bVar.erG <= 0 || bVar.fwx == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eqU.getPageContext(), 3, 1);
                    }
                    this.eqU.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.eqU.eqF;
                    aoVar2.a(1, dVar.AM, dVar.fwz, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.eqU.eqF;
        forumManageModel = this.eqU.eqE;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

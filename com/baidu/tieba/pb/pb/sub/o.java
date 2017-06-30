package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.eHC.eHm;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.czh || bVar.eIp <= 0 || bVar.fOu == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eHC.getPageContext(), 3, 1);
                    }
                    this.eHC.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.eHC.eHn;
                    aoVar2.a(1, dVar.AM, dVar.fOw, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.eHC.eHn;
        forumManageModel = this.eHC.eHm;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

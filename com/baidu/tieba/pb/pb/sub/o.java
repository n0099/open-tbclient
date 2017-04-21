package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.model.ForumManageModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        ao aoVar;
        ForumManageModel forumManageModel;
        ForumManageModel forumManageModel2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            forumManageModel2 = this.evm.euW;
            switch (forumManageModel2.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.cnZ || bVar.evY <= 0 || bVar.fAo == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.evm.getPageContext(), 3, 1);
                    }
                    this.evm.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    aoVar2 = this.evm.euX;
                    aoVar2.a(1, dVar.AM, dVar.fAq, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.evm.euX;
        forumManageModel = this.evm.euW;
        aoVar.a(forumManageModel.getLoadDataMode(), false, (String) null, false);
    }
}

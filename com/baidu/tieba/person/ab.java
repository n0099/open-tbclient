package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ab implements p.a {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.cqM = rVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aiU;
        PersonBarActivity aiU2;
        PersonBarActivity aiU3;
        aiU = this.cqM.aiU();
        if (aiU != null) {
            this.cqM.cqz = 1;
            aiU2 = this.cqM.aiU();
            if (aiU2 != null) {
                aiU3 = this.cqM.aiU();
                if (aiU3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cqM.cqz);
                    requestGetLivableForumList.setPageSize(this.cqM.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cqM.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cqM.KA();
        }
    }
}

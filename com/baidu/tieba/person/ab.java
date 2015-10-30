package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ab implements p.a {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.cpq = rVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aio;
        PersonBarActivity aio2;
        PersonBarActivity aio3;
        aio = this.cpq.aio();
        if (aio != null) {
            this.cpq.cpd = 1;
            aio2 = this.cpq.aio();
            if (aio2 != null) {
                aio3 = this.cpq.aio();
                if (aio3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cpq.cpd);
                    requestGetLivableForumList.setPageSize(this.cpq.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cpq.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cpq.Kk();
        }
    }
}

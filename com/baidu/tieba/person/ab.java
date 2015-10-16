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
        PersonBarActivity ais;
        PersonBarActivity ais2;
        PersonBarActivity ais3;
        ais = this.cpq.ais();
        if (ais != null) {
            this.cpq.cpd = 1;
            ais2 = this.cpq.ais();
            if (ais2 != null) {
                ais3 = this.cpq.ais();
                if (ais3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cpq.cpd);
                    requestGetLivableForumList.setPageSize(this.cpq.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cpq.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cpq.Ko();
        }
    }
}

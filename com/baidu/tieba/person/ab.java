package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ab implements x.a {
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.cjC = rVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity agt;
        PersonBarActivity agt2;
        PersonBarActivity agt3;
        agt = this.cjC.agt();
        if (agt != null) {
            this.cjC.cjp = 1;
            agt2 = this.cjC.agt();
            if (agt2 != null) {
                agt3 = this.cjC.agt();
                if (agt3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cjC.cjp);
                    requestGetLivableForumList.setPageSize(this.cjC.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cjC.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cjC.Kt();
        }
    }
}

package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ab implements x.a {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.ciI = rVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity agd;
        PersonBarActivity agd2;
        PersonBarActivity agd3;
        agd = this.ciI.agd();
        if (agd != null) {
            this.ciI.civ = 1;
            agd2 = this.ciI.agd();
            if (agd2 != null) {
                agd3 = this.ciI.agd();
                if (agd3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.ciI.civ);
                    requestGetLivableForumList.setPageSize(this.ciI.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.ciI.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.ciI.KF();
        }
    }
}

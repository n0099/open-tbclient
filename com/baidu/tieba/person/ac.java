package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ac implements r.a {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.cOw = sVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aoI;
        PersonBarActivity aoI2;
        PersonBarActivity aoI3;
        aoI = this.cOw.aoI();
        if (aoI != null) {
            this.cOw.cOk = 1;
            aoI2 = this.cOw.aoI();
            if (aoI2 != null) {
                aoI3 = this.cOw.aoI();
                if (aoI3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cOw.cOk);
                    requestGetLivableForumList.setPageSize(this.cOw.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cOw.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cOw.Mo();
        }
    }
}

package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ac implements q.a {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.cKg = sVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        PersonBarActivity anx;
        PersonBarActivity anx2;
        PersonBarActivity anx3;
        anx = this.cKg.anx();
        if (anx != null) {
            this.cKg.cJU = 1;
            anx2 = this.cKg.anx();
            if (anx2 != null) {
                anx3 = this.cKg.anx();
                if (anx3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cKg.cJU);
                    requestGetLivableForumList.setPageSize(this.cKg.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cKg.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cKg.LV();
        }
    }
}

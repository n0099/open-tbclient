package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class v implements t.b {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eeh = tVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        PersonBarActivity aKx;
        PersonBarActivity aKx2;
        PersonBarActivity aKx3;
        aKx = this.eeh.aKx();
        if (aKx != null) {
            this.eeh.edU = 1;
            aKx2 = this.eeh.aKx();
            if (aKx2 != null) {
                aKx3 = this.eeh.aKx();
                if (aKx3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.eeh.edU);
                    requestGetLivableForumList.setPageSize(this.eeh.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.eeh.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.eeh.refreshData();
        }
    }
}

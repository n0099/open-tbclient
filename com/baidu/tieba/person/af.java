package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(v vVar) {
        this.bSc = vVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        PersonBarActivity aem;
        PersonBarActivity aem2;
        PersonBarActivity aem3;
        aem = this.bSc.aem();
        if (aem != null) {
            this.bSc.bRQ = 1;
            aem2 = this.bSc.aem();
            if (aem2 != null) {
                aem3 = this.bSc.aem();
                if (aem3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.bSc.bRQ);
                    requestGetLivableForumList.setPageSize(this.bSc.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.c.toInt(TbadkCoreApplication.getCurrentAccount(), 0));
                    this.bSc.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.bSc.WT();
        }
    }
}

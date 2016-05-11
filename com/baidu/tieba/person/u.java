package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class u implements t.b {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.dvP = sVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        PersonBarActivity aBC;
        PersonBarActivity aBC2;
        PersonBarActivity aBC3;
        aBC = this.dvP.aBC();
        if (aBC != null) {
            this.dvP.dvC = 1;
            aBC2 = this.dvP.aBC();
            if (aBC2 != null) {
                aBC3 = this.dvP.aBC();
                if (aBC3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.dvP.dvC);
                    requestGetLivableForumList.setPageSize(this.dvP.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.dvP.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.dvP.OP();
        }
    }
}

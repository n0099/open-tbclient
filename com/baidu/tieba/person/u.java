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
        PersonBarActivity aBF;
        PersonBarActivity aBF2;
        PersonBarActivity aBF3;
        aBF = this.dvP.aBF();
        if (aBF != null) {
            this.dvP.dvC = 1;
            aBF2 = this.dvP.aBF();
            if (aBF2 != null) {
                aBF3 = this.dvP.aBF();
                if (aBF3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.dvP.dvC);
                    requestGetLivableForumList.setPageSize(this.dvP.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.dvP.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.dvP.OR();
        }
    }
}

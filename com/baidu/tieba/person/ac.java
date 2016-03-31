package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ac implements s.a {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.dst = sVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        PersonBarActivity aBf;
        PersonBarActivity aBf2;
        PersonBarActivity aBf3;
        aBf = this.dst.aBf();
        if (aBf != null) {
            this.dst.dsg = 1;
            aBf2 = this.dst.aBf();
            if (aBf2 != null) {
                aBf3 = this.dst.aBf();
                if (aBf3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.dst.dsg);
                    requestGetLivableForumList.setPageSize(this.dst.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.dst.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.dst.PW();
        }
    }
}

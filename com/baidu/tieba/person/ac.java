package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class ac implements r.a {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.cXR = sVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        PersonBarActivity atz;
        PersonBarActivity atz2;
        PersonBarActivity atz3;
        atz = this.cXR.atz();
        if (atz != null) {
            this.cXR.cXE = 1;
            atz2 = this.cXR.atz();
            if (atz2 != null) {
                atz3 = this.cXR.atz();
                if (atz3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cXR.cXE);
                    requestGetLivableForumList.setPageSize(this.cXR.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cXR.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.cXR.Oh();
        }
    }
}

package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.v;
/* loaded from: classes.dex */
class u implements BdListView.e {
    final /* synthetic */ s cXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cXR = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        String str;
        boolean z;
        PersonBarActivity atz;
        if (this.cXR.hasMore) {
            z = this.cXR.cwB;
            if (!z) {
                this.cXR.cwB = true;
                this.cXR.cXA.Ob();
                atz = this.cXR.atz();
                if (atz.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.cXR.cXE);
                    requestGetLivableForumList.setPageSize(this.cXR.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.cXR.sendMessage(requestGetLivableForumList);
                    return;
                }
                this.cXR.iT(this.cXR.cXE);
                return;
            }
            return;
        }
        v.a aVar = this.cXR.cXA;
        str = this.cXR.cXH;
        aVar.ld(str);
    }
}

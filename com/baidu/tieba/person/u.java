package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class u implements BdListView.e {
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cOw = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity aoI;
        if (this.cOw.hasMore) {
            this.cOw.cOg.Mi();
            aoI = this.cOw.aoI();
            if (aoI.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cOw.cOk);
                requestGetLivableForumList.setPageSize(this.cOw.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cOw.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cOw.iw(this.cOw.cOk);
            return;
        }
        u.a aVar = this.cOw.cOg;
        str = this.cOw.cOn;
        aVar.kT(str);
    }
}

package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class u implements BdListView.e {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cKg = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity anx;
        if (this.cKg.hasMore) {
            this.cKg.cJQ.LP();
            anx = this.cKg.anx();
            if (anx.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cKg.cJU);
                requestGetLivableForumList.setPageSize(this.cKg.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cKg.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cKg.hW(this.cKg.cJU);
            return;
        }
        u.a aVar = this.cKg.cJQ;
        str = this.cKg.cJX;
        aVar.kW(str);
    }
}

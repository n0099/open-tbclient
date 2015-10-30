package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ r cpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cpq = rVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity aio;
        if (this.cpq.hasMore) {
            this.cpq.coZ.Kf();
            aio = this.cpq.aio();
            if (aio.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cpq.cpd);
                requestGetLivableForumList.setPageSize(this.cpq.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cpq.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cpq.gW(this.cpq.cpd);
            return;
        }
        u.a aVar = this.cpq.coZ;
        str = this.cpq.cpg;
        aVar.kb(str);
    }
}

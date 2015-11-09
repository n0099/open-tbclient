package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ r cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cqM = rVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity aiU;
        if (this.cqM.hasMore) {
            this.cqM.cqv.Kv();
            aiU = this.cqM.aiU();
            if (aiU.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cqM.cqz);
                requestGetLivableForumList.setPageSize(this.cqM.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cqM.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cqM.hj(this.cqM.cqz);
            return;
        }
        u.a aVar = this.cqM.cqv;
        str = this.cqM.cqC;
        aVar.ke(str);
    }
}

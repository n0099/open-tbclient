package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ r cjC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cjC = rVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity agt;
        if (this.cjC.hasMore) {
            this.cjC.cjl.Ko();
            agt = this.cjC.agt();
            if (agt.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cjC.cjp);
                requestGetLivableForumList.setPageSize(this.cjC.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cjC.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cjC.gQ(this.cjC.cjp);
            return;
        }
        u.a aVar = this.cjC.cjl;
        str = this.cjC.cjs;
        aVar.jG(str);
    }
}

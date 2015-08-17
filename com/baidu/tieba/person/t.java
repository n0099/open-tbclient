package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.p;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ r ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.ciI = rVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity agd;
        if (this.ciI.hasMore) {
            this.ciI.cir.KA();
            agd = this.ciI.agd();
            if (agd.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.ciI.civ);
                requestGetLivableForumList.setPageSize(this.ciI.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.ciI.sendMessage(requestGetLivableForumList);
                return;
            }
            this.ciI.gG(this.ciI.civ);
            return;
        }
        p.a aVar = this.ciI.cir;
        str = this.ciI.ciy;
        aVar.jz(str);
    }
}

package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.post.u;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ r cpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cpf = rVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        String str;
        PersonBarActivity ais;
        if (this.cpf.hasMore) {
            this.cpf.coO.Kj();
            ais = this.cpf.ais();
            if (ais.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.cpf.coS);
                requestGetLivableForumList.setPageSize(this.cpf.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.cpf.sendMessage(requestGetLivableForumList);
                return;
            }
            this.cpf.gW(this.cpf.coS);
            return;
        }
        u.a aVar = this.cpf.coO;
        str = this.cpf.coV;
        aVar.kb(str);
    }
}

package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.s;
/* loaded from: classes.dex */
class u implements BdListView.e {
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.dst = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        String str;
        boolean z;
        PersonBarActivity aBf;
        if (this.dst.hasMore) {
            z = this.dst.cLw;
            if (!z) {
                this.dst.cLw = true;
                this.dst.dsc.PQ();
                aBf = this.dst.aBf();
                if (aBf.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.dst.dsg);
                    requestGetLivableForumList.setPageSize(this.dst.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.dst.sendMessage(requestGetLivableForumList);
                    return;
                }
                this.dst.jz(this.dst.dsg);
                return;
            }
            return;
        }
        s.a aVar = this.dst.dsc;
        str = this.dst.dsj;
        aVar.ml(str);
    }
}

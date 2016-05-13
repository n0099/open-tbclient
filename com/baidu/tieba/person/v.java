package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.s;
/* loaded from: classes.dex */
class v implements BdListView.e {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.dvP = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        String str;
        boolean z;
        PersonBarActivity aBF;
        if (this.dvP.hasMore) {
            z = this.dvP.cMs;
            if (!z) {
                this.dvP.cMs = true;
                this.dvP.dvy.OL();
                aBF = this.dvP.aBF();
                if (aBF.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.dvP.dvC);
                    requestGetLivableForumList.setPageSize(this.dvP.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.dvP.sendMessage(requestGetLivableForumList);
                    return;
                }
                this.dvP.jc(this.dvP.dvC);
                return;
            }
            return;
        }
        s.a aVar = this.dvP.dvy;
        str = this.dvP.dvF;
        aVar.mp(str);
    }
}

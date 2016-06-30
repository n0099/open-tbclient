package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.person.t;
/* loaded from: classes.dex */
class w implements BdListView.e {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.eeh = tVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        String str;
        boolean z;
        PersonBarActivity aKx;
        if (this.eeh.hasMore) {
            z = this.eeh.dsg;
            if (!z) {
                this.eeh.dsg = true;
                this.eeh.edQ.Un();
                aKx = this.eeh.aKx();
                if (aKx.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.eeh.edU);
                    requestGetLivableForumList.setPageSize(this.eeh.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.eeh.sendMessage(requestGetLivableForumList);
                    return;
                }
                this.eeh.kE(this.eeh.edU);
                return;
            }
            return;
        }
        t.a aVar = this.eeh.edQ;
        str = this.eeh.edX;
        aVar.nU(str);
    }
}

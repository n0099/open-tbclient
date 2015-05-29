package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(v vVar) {
        this.bSb = vVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        PersonBarActivity ael;
        PersonBarActivity ael2;
        PersonBarActivity ael3;
        ael = this.bSb.ael();
        if (ael != null) {
            this.bSb.bRP = 1;
            ael2 = this.bSb.ael();
            if (ael2 != null) {
                ael3 = this.bSb.ael();
                if (ael3.getRequestCode() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.bSb.bRP);
                    requestGetLivableForumList.setPageSize(this.bSb.pageSize);
                    requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.c.toInt(TbadkCoreApplication.getCurrentAccount(), 0));
                    this.bSb.sendMessage(requestGetLivableForumList);
                    return;
                }
            }
            this.bSb.WS();
        }
    }
}

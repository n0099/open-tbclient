package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class x implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.bSb = vVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        String str;
        PersonBarActivity ael;
        if (this.bSb.hasMore) {
            this.bSb.bRL.JL();
            ael = this.bSb.ael();
            if (ael.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.bSb.bRP);
                requestGetLivableForumList.setPageSize(this.bSb.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.c.toInt(TbadkCoreApplication.getCurrentAccount(), 0));
                this.bSb.sendMessage(requestGetLivableForumList);
                return;
            }
            this.bSb.hO(this.bSb.bRP);
            return;
        }
        com.baidu.tieba.person.post.z zVar = this.bSb.bRL;
        str = this.bSb.bRS;
        zVar.iF(str);
    }
}

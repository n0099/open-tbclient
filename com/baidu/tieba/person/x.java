package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
/* loaded from: classes.dex */
class x implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ v bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.bSc = vVar;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        String str;
        PersonBarActivity aem;
        if (this.bSc.hasMore) {
            this.bSc.bRM.JM();
            aem = this.bSc.aem();
            if (aem.getRequestCode() == 23011) {
                RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                requestGetLivableForumList.setGetLikeForum(1);
                requestGetLivableForumList.setPageNo(this.bSc.bRQ);
                requestGetLivableForumList.setPageSize(this.bSc.pageSize);
                requestGetLivableForumList.setUserId(com.baidu.adp.lib.g.c.toInt(TbadkCoreApplication.getCurrentAccount(), 0));
                this.bSc.sendMessage(requestGetLivableForumList);
                return;
            }
            this.bSc.hO(this.bSc.bRQ);
            return;
        }
        com.baidu.tieba.person.post.z zVar = this.bSc.bRM;
        str = this.bSc.bRT;
        zVar.iF(str);
    }
}

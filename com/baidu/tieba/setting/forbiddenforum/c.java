package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class c {
    private BdUniqueId agC;
    private a neh;
    private d pageData;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a eDt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692) { // from class: com.baidu.tieba.setting.forbiddenforum.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.agC) {
                    if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                        pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                    } else {
                        pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                    }
                    if (responsedMessage.getError() == 0) {
                        if (c.this.mPageNum == 1 && (pageData == null || y.isEmpty(pageData.dataList))) {
                            if (c.this.neh != null) {
                                c.this.neh.a(null);
                            }
                        } else if (pageData != null) {
                            c.this.pageData.dataList.addAll(pageData.dataList);
                            if (y.isEmpty(pageData.dataList)) {
                                c.this.pageData.hasMore = false;
                            } else {
                                c.this.pageData.hasMore = pageData.hasMore;
                                c.e(c.this);
                            }
                            if (c.this.neh != null) {
                                c.this.neh.a(pageData);
                            }
                        }
                    } else if (c.this.neh != null) {
                        c.this.neh.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(d dVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(c cVar) {
        int i = cVar.mPageNum;
        cVar.mPageNum = i + 1;
        return i;
    }

    public c(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
        this.eDt.setTag(this.agC);
        MessageManager.getInstance().registerListener(this.eDt);
        brf();
        brg();
        this.pageData = new d();
    }

    public void bEN() {
        ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
        forbiddenForumReqMsg.pageSize = 20;
        forbiddenForumReqMsg.pageNum = this.mPageNum;
        forbiddenForumReqMsg.setTag(this.agC);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public d getPageData() {
        return this.pageData;
    }

    private void brf() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309692);
        bVar.setResponsedClass(ForbiddenForumSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void brg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Sv(String str) {
        if (this.pageData != null && !y.isEmpty(this.pageData.dataList)) {
            for (b bVar : this.pageData.dataList) {
                if (bVar != null && bVar.forumId != null && bVar.forumId.equals(str)) {
                    this.pageData.dataList.remove(bVar);
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        this.neh = aVar;
    }
}

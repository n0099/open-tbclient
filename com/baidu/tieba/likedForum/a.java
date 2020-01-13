package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes6.dex */
public class a {
    private List<ForumInfo> gMW;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private InterfaceC0541a ibg = null;
    private com.baidu.adp.framework.listener.a gZI = new com.baidu.adp.framework.listener.a(1003316, CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST) { // from class: com.baidu.tieba.likedForum.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.mRequestId == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.ibg != null) {
                                a.this.ibg.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                            a.this.gMW = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                        }
                        if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                            a.this.gMW = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                        }
                        if (a.this.ibg != null) {
                            a.this.ibg.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.gMW);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0541a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gZI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gZI);
        this.gZI.getHttpMessageListener().setSelfListener(true);
        this.gZI.getSocketMessageListener().setSelfListener(true);
    }

    public boolean loadData() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        getBottleForumListReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void a(InterfaceC0541a interfaceC0541a) {
        this.ibg = interfaceC0541a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gZI);
    }
}

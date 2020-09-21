package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes20.dex */
public class a {
    private List<ForumInfo> iEW;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private InterfaceC0729a kcv = null;
    private com.baidu.adp.framework.listener.a netMessageListener = new com.baidu.adp.framework.listener.a(1003316, CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST) { // from class: com.baidu.tieba.likedForum.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.mRequestId == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.kcv != null) {
                                a.this.kcv.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                            a.this.iEW = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                        }
                        if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                            a.this.iEW = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                        }
                        if (a.this.kcv != null) {
                            a.this.kcv.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.iEW);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0729a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.netMessageListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.netMessageListener);
        this.netMessageListener.getHttpMessageListener().setSelfListener(true);
        this.netMessageListener.getSocketMessageListener().setSelfListener(true);
    }

    public boolean loadData() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        getBottleForumListReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void a(InterfaceC0729a interfaceC0729a) {
        this.kcv = interfaceC0729a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }
}

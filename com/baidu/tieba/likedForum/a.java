package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes.dex */
public class a {
    private List<ForumInfo> dOw;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private InterfaceC0132a faP = null;
    private com.baidu.adp.framework.listener.a ecQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440) { // from class: com.baidu.tieba.likedForum.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.mRequestId == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.faP != null) {
                                a.this.faP.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                            a.this.dOw = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                        }
                        if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                            a.this.dOw = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                        }
                        if (a.this.faP != null) {
                            a.this.faP.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.dOw);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0132a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.ecQ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ecQ);
        this.ecQ.getHttpMessageListener().setSelfListener(true);
        this.ecQ.getSocketMessageListener().setSelfListener(true);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public boolean Na() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        getBottleForumListReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void auK() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, this.mBdUniqueId);
        MessageManager.getInstance().removeMessage(309440, this.mBdUniqueId);
    }

    public void a(InterfaceC0132a interfaceC0132a) {
        this.faP = interfaceC0132a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.ecQ);
    }
}

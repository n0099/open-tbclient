package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes.dex */
public class a {
    private List<ForumInfo> ehL;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0104a ehM = null;
    private com.baidu.adp.framework.listener.a dnB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440) { // from class: com.baidu.tieba.likedForum.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                    if (responsedMessage.hasError()) {
                        if (a.this.ehM != null) {
                            a.this.ehM.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                        a.this.ehL = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.ehL = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.ehM != null) {
                        a.this.ehM.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.ehL);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0104a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.dnB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dnB);
    }

    public boolean Fr() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void akY() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, this.mBdUniqueId);
        MessageManager.getInstance().removeMessage(309440, this.mBdUniqueId);
    }

    public void a(InterfaceC0104a interfaceC0104a) {
        this.ehM = interfaceC0104a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dnB);
    }
}

package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class a {
    private List<ForumInfo> fyr;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private InterfaceC0332a gMe = null;
    private com.baidu.adp.framework.listener.a fKm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440) { // from class: com.baidu.tieba.likedForum.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetBottleForumListHttpResMessage) || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.mRequestId == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.gMe != null) {
                                a.this.gMe.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetBottleForumListHttpResMessage) {
                            a.this.fyr = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                        }
                        if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                            a.this.fyr = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                        }
                        if (a.this.gMe != null) {
                            a.this.gMe.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.fyr);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0332a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.fKm.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fKm);
        this.fKm.getHttpMessageListener().setSelfListener(true);
        this.fKm.getSocketMessageListener().setSelfListener(true);
    }

    public boolean aou() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        getBottleForumListReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void a(InterfaceC0332a interfaceC0332a) {
        this.gMe = interfaceC0332a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.fKm);
    }
}

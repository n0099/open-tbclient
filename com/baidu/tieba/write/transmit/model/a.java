package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a {
    private List<SimpleForum> dck;
    private com.baidu.adp.framework.listener.a dqK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.mRequestId == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.hdZ != null) {
                                a.this.hdZ.bFD();
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                            a.this.dck = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumHttpResMessage) responsedMessage).getPrivateThread();
                        }
                        if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                            a.this.dck = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumSocketResMessage) responsedMessage).getPrivateThread();
                        }
                        if (a.this.hdZ != null) {
                            a.this.hdZ.r(a.this.dck, a.this.privateThread);
                        }
                    }
                }
            }
        }
    };
    private String forumId;
    private InterfaceC0158a hdZ;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private int privateThread;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0158a {
        void bFD();

        void r(List<SimpleForum> list, int i);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.dqK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dqK);
        this.dqK.getHttpMessageListener().setSelfListener(true);
        this.dqK.getSocketMessageListener().setSelfListener(true);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public void Om() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        getRepostForumReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void and() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, this.mBdUniqueId);
        MessageManager.getInstance().removeMessage(309450, this.mBdUniqueId);
    }

    public void setThreadTitle(String str) {
        this.threadTitle = str;
    }

    public void setThreadContent(String str) {
        this.threadContent = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getRecommendExt() {
        return this.recommendExt;
    }

    public void a(InterfaceC0158a interfaceC0158a) {
        this.hdZ = interfaceC0158a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dqK);
    }
}

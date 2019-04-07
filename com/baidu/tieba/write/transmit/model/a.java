package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.adp.framework.listener.a fKa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.mRequestId == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.jkU != null) {
                                a.this.jkU.onError();
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                            a.this.fyf = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumHttpResMessage) responsedMessage).getPrivateThread();
                        }
                        if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                            a.this.fyf = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumSocketResMessage) responsedMessage).getPrivateThread();
                        }
                        if (a.this.jkU != null) {
                            a.this.jkU.g(a.this.fyf, a.this.privateThread);
                        }
                    }
                }
            }
        }
    };
    private String forumId;
    private List<SimpleForum> fyf;
    private InterfaceC0411a jkU;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private int privateThread;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0411a {
        void g(List<SimpleForum> list, int i);

        void onError();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.fKa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fKa);
        this.fKa.getHttpMessageListener().setSelfListener(true);
        this.fKa.getSocketMessageListener().setSelfListener(true);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public void loadData() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        getRepostForumReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void beW() {
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

    public void a(InterfaceC0411a interfaceC0411a) {
        this.jkU = interfaceC0411a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.fKa);
    }
}

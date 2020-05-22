package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a {
    private String forumId;
    private com.baidu.adp.framework.listener.a gWa = new com.baidu.adp.framework.listener.a(1003323, CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.mRequestId == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.lQa != null) {
                                a.this.lQa.onError();
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                            a.this.hPi = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumHttpResMessage) responsedMessage).getPrivateThread();
                        }
                        if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                            a.this.hPi = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumSocketResMessage) responsedMessage).getPrivateThread();
                        }
                        if (a.this.lQa != null) {
                            a.this.lQa.g(a.this.hPi, a.this.privateThread);
                        }
                    }
                }
            }
        }
    };
    private List<SimpleForum> hPi;
    private InterfaceC0754a lQa;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private int privateThread;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0754a {
        void g(List<SimpleForum> list, int i);

        void onError();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.gWa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gWa);
        this.gWa.getHttpMessageListener().setSelfListener(true);
        this.gWa.getSocketMessageListener().setSelfListener(true);
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

    public void bXE() {
        MessageManager.getInstance().removeMessage(1003323, this.mBdUniqueId);
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM, this.mBdUniqueId);
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

    public void a(InterfaceC0754a interfaceC0754a) {
        this.lQa = interfaceC0754a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gWa);
    }
}

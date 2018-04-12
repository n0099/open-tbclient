package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.adp.framework.listener.a dDs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.mRequestId == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                        if (responsedMessage.hasError()) {
                            if (a.this.hah != null) {
                                a.this.hah.onError();
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                            a.this.dss = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumHttpResMessage) responsedMessage).getPrivateThread();
                        }
                        if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                            a.this.dss = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                            a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                            a.this.privateThread = ((GetRepostForumSocketResMessage) responsedMessage).getPrivateThread();
                        }
                        if (a.this.hah != null) {
                            a.this.hah.p(a.this.dss, a.this.privateThread);
                        }
                    }
                }
            }
        }
    };
    private List<SimpleForum> dss;
    private String forumId;
    private InterfaceC0236a hah;
    private BdUniqueId mBdUniqueId;
    private BdUniqueId mRequestId;
    private int privateThread;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0236a {
        void onError();

        void p(List<SimpleForum> list, int i);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.dDs.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dDs);
        this.dDs.getHttpMessageListener().setSelfListener(true);
        this.dDs.getSocketMessageListener().setSelfListener(true);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public void OT() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        getRepostForumReqMessage.setRequestId(this.mRequestId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void arg() {
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

    public void a(InterfaceC0236a interfaceC0236a) {
        this.hah = interfaceC0236a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dDs);
    }
}

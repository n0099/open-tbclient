package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.framework.listener.a bEP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.hasError()) {
                        if (a.this.gzd != null) {
                            a.this.gzd.bxA();
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                        a.this.dUA = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        a.this.dUA = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (a.this.gzd != null) {
                        a.this.gzd.B(a.this.dUA);
                    }
                }
            }
        }
    };
    private List<SimpleForum> dUA;
    private String forumId;
    private InterfaceC0125a gzd;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0125a {
        void B(List<SimpleForum> list);

        void bxA();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.bEP.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bEP);
    }

    public void Pr() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void aDN() {
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

    public void a(InterfaceC0125a interfaceC0125a) {
        this.gzd = interfaceC0125a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bEP);
    }
}

package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.adp.framework.listener.a dnB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.hasError()) {
                        if (a.this.gQf != null) {
                            a.this.gQf.bCo();
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                        a.this.ehL = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        a.this.ehL = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (a.this.gQf != null) {
                        a.this.gQf.B(a.this.ehL);
                    }
                }
            }
        }
    };
    private List<SimpleForum> ehL;
    private String forumId;
    private InterfaceC0143a gQf;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0143a {
        void B(List<SimpleForum> list);

        void bCo();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.dnB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dnB);
    }

    public void RG() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void akY() {
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

    public void a(InterfaceC0143a interfaceC0143a) {
        this.gQf = interfaceC0143a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dnB);
    }
}

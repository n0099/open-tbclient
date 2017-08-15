package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.framework.listener.a bFy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.hasError()) {
                        if (a.this.gAV != null) {
                            a.this.gAV.byi();
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                        a.this.dWw = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        a.this.dWw = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (a.this.gAV != null) {
                        a.this.gAV.B(a.this.dWw);
                    }
                }
            }
        }
    };
    private List<SimpleForum> dWw;
    private String forumId;
    private InterfaceC0126a gAV;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0126a {
        void B(List<SimpleForum> list);

        void byi();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.bFy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bFy);
    }

    public void Py() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void aEu() {
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

    public void a(InterfaceC0126a interfaceC0126a) {
        this.gAV = interfaceC0126a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bFy);
    }
}

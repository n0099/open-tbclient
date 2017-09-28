package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.adp.framework.listener.a dfH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450) { // from class: com.baidu.tieba.write.transmit.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetRepostForumHttpResMessage) || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                    if (responsedMessage.hasError()) {
                        if (a.this.gFx != null) {
                            a.this.gFx.byQ();
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof GetRepostForumHttpResMessage) {
                        a.this.eak = ((GetRepostForumHttpResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumHttpResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        a.this.eak = ((GetRepostForumSocketResMessage) responsedMessage).getForumList();
                        a.this.recommendExt = ((GetRepostForumSocketResMessage) responsedMessage).getRecommendExtension();
                    }
                    if (a.this.gFx != null) {
                        a.this.gFx.A(a.this.eak);
                    }
                }
            }
        }
    };
    private List<SimpleForum> eak;
    private String forumId;
    private InterfaceC0139a gFx;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139a {
        void A(List<SimpleForum> list);

        void byQ();
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.dfH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dfH);
    }

    public void Qj() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void aiD() {
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

    public void a(InterfaceC0139a interfaceC0139a) {
        this.gFx = interfaceC0139a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dfH);
    }
}

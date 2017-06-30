package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.framework.listener.a bzy = new b(this, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
    private List<SimpleForum> dKG;
    private String forumId;
    private InterfaceC0088a gdx;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void brw();

        void ci(List<SimpleForum> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.bzy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bzy);
    }

    public void OZ() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void aBZ() {
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

    public void a(InterfaceC0088a interfaceC0088a) {
        this.gdx = interfaceC0088a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bzy);
    }
}

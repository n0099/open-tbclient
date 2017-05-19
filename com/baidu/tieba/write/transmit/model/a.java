package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class a {
    private com.baidu.adp.framework.listener.a crw = new b(this, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
    private List<SimpleForum> dwN;
    private InterfaceC0083a fOW;
    private String forumId;
    private BdUniqueId mBdUniqueId;
    private String recommendExt;
    private String threadContent;
    private String threadTitle;

    /* renamed from: com.baidu.tieba.write.transmit.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        void bna();

        void onSuccess(List<SimpleForum> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.crw.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.crw);
    }

    public void NA() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.threadTitle);
        getRepostForumReqMessage.setThreadContent(this.threadContent);
        getRepostForumReqMessage.setForumId(this.forumId);
        getRepostForumReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void aWS() {
        MessageManager.getInstance().removeMessage(this.mBdUniqueId);
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

    public void a(InterfaceC0083a interfaceC0083a) {
        this.fOW = interfaceC0083a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.crw);
    }
}

package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes.dex */
public class a {
    private List<ForumInfo> dKG;
    private BdUniqueId mBdUniqueId;
    private InterfaceC0073a dKH = null;
    private com.baidu.adp.framework.listener.a bzy = new b(this, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.bzy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bzy);
    }

    public boolean EX() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void aBZ() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, this.mBdUniqueId);
        MessageManager.getInstance().removeMessage(309440, this.mBdUniqueId);
    }

    public void a(InterfaceC0073a interfaceC0073a) {
        this.dKH = interfaceC0073a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bzy);
    }
}

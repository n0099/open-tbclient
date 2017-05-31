package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes.dex */
public class a {
    private List<ForumInfo> dCm;
    private InterfaceC0070a dCn = null;
    private com.baidu.adp.framework.listener.a byl = new b(this, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.byl);
    }

    public boolean EA() {
        MessageManager.getInstance().sendMessage(new GetBottleForumListReqMessage());
        return false;
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.dCn = interfaceC0070a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.byl);
    }
}

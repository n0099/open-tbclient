package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes.dex */
public class a {
    private List<ForumInfo> dwN;
    private InterfaceC0070a dwO = null;
    private com.baidu.adp.framework.listener.a crw = new b(this, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);

    /* renamed from: com.baidu.tieba.likedForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.crw);
    }

    public boolean EG() {
        MessageManager.getInstance().sendMessage(new GetBottleForumListReqMessage());
        return false;
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.dwO = interfaceC0070a;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.crw);
    }
}

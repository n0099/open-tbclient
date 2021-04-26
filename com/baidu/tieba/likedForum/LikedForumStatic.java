package com.baidu.tieba.likedForum;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.d3.d0.a;
/* loaded from: classes4.dex */
public class LikedForumStatic {
    static {
        a.h(309440, GetBottleForumListSocketResMessage.class, false, false);
        a.c(309440, CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, TbConfig.CMD_GET_BOTTLE_FORUM_LIST, GetBottleForumListHttpResMessage.class, false, false, true, false);
    }
}

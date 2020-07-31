package com.baidu.tieba.likedForum;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes15.dex */
public class LikedForumStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST, GetBottleForumListSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST, 1003316, TbConfig.CMD_GET_BOTTLE_FORUM_LIST, GetBottleForumListHttpResMessage.class, false, false, true, false);
    }
}

package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
/* loaded from: classes.dex */
public class SelectFriendActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(SelectFriendActivityConfig.class, SelectFriendActivity.class);
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_LIST, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        tbHttpMessageTask.setResponsedClass(ResponseFriendListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }
}

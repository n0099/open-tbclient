package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.FRSPageSocketResponsedMessage;
import com.baidu.tieba.frs.FrsPageHttpResponseMessage;
import com.baidu.tieba.person.post.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.post.UserPostPageSocketResponsedMessage;
/* loaded from: classes.dex */
public class j {
    public static void a() {
        b();
        c();
    }

    public static void b() {
        a(MessageTypes.CMD_FRS_PAGE, FRSPageSocketResponsedMessage.class, false);
        a(MessageTypes.CMD_USER_POST_PAGE, UserPostPageSocketResponsedMessage.class, false);
    }

    private static void c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.FRS_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/page?cmd=" + MessageTypes.CMD_FRS_PAGE);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfig.USER_POST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/feed/userpost?cmd=" + MessageTypes.CMD_USER_POST_PAGE);
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.setTimeOut(new com.baidu.adp.framework.c.g(ad.c().H(), ad.c().I(), ad.c().J()));
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }
}

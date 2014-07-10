package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.FRSPageSocketResponsedMessage;
import com.baidu.tieba.frs.FrsPageHttpResponseMessage;
import com.baidu.tieba.message.ResponseFriendFeedMessage;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
import com.baidu.tieba.person.dg;
import com.baidu.tieba.person.dh;
import com.baidu.tieba.person.post.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.post.UserPostPageSocketResponsedMessage;
/* loaded from: classes.dex */
public class n {
    public static void a() {
        b();
        d();
        c();
    }

    public static void b() {
        a(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME);
        a(301001, FRSPageSocketResponsedMessage.class, false);
        a(303002, UserPostPageSocketResponsedMessage.class, false);
        a(303003, ResponseFriendFeedMessage.class, false);
        com.baidu.adp.framework.client.socket.coder.d.a().a(301001);
        com.baidu.adp.framework.client.socket.coder.d.a().a(303002);
    }

    private static void c() {
        a(2001172, com.baidu.tieba.message.a.a.class);
        a(2001186, dh.class);
        a(2001187, dg.class);
        a(2001190, com.baidu.tieba.pb.history.i.class);
        a(2001191, com.baidu.tieba.pb.history.j.class);
    }

    private static com.baidu.tbadk.task.a a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(i, cls.newInstance());
            MessageManager.getInstance().registerTask(aVar);
            return aVar;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001703, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/frs/page?cmd=301001");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1001503, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/feed/userpost?cmd=303002");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(false);
        tbHttpMessageTask2.setIsNeedAddCommenParam(false);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask2.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1001506, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1002002, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return a(i, cls, z, SocketMessageTask.DupLicateMode.NONE);
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.a(dupLicateMode);
        bVar.d(false);
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }
}

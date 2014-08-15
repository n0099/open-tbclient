package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class NeighborsStatic {
    static {
        a((int) CmdConfigHttp.CLEAR_LOCATION_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CLEAR_LOCATION_INFO, true, (Class<? extends HttpResponsedMessage>) TbHttpResponsedMessage.class);
        a(303004, (Class<? extends SocketResponsedMessage>) ResponseGetNeighborsMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_WAITING);
    }

    private static void a(int i, String str, boolean z, Class<? extends HttpResponsedMessage> cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, str);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.setParallel(com.baidu.tbadk.k.b());
        bVar.a(dupLicateMode);
        MessageManager.getInstance().registerTask(bVar);
    }
}

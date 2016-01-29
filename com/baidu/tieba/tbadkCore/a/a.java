package com.baidu.tieba.tbadkCore.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
/* loaded from: classes.dex */
public class a {
    private static int dVO = 1;

    public static com.baidu.tbadk.task.a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
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

    public static String am(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    public static b c(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return a(i, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
    }

    public static b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        return a(i, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
    }

    public static b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        b bVar = new b(i);
        bVar.setResponsedClass(cls);
        bVar.j(z);
        bVar.a(dupLicateMode);
        bVar.setRetry(dVO);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(bVar);
        bVar.setNeedEncrypt(z2);
        return bVar;
    }

    public static TbHttpMessageTask a(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, am(str, i));
        tbHttpMessageTask.setIsNeedLogin(z);
        tbHttpMessageTask.setIsNeedTbs(z2);
        tbHttpMessageTask.setIsNeedAddCommenParam(z3);
        tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().unRegisterTask(i2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        return tbHttpMessageTask;
    }
}

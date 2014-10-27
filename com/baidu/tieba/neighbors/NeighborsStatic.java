package com.baidu.tieba.neighbors;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class NeighborsStatic {
    private static View.OnClickListener Hd = new m();
    private static com.baidu.tbadk.b.a ant;
    private static com.baidu.tbadk.core.dialog.d buh;
    private static com.baidu.tbadk.core.dialog.d bui;

    static {
        a((int) CmdConfigHttp.CLEAR_LOCATION_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CLEAR_LOCATION_INFO, true, (Class<? extends HttpResponsedMessage>) TbHttpResponsedMessage.class);
        a(303004, (Class<? extends SocketResponsedMessage>) ResponseGetNeighborsMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        n nVar = new n(2009501);
        nVar.setPriority(1);
        MessageManager.getInstance().registerListener(nVar);
        buh = new o();
        bui = new p();
    }

    private static void a(int i, String str, boolean z, Class<? extends HttpResponsedMessage> cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, str);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(cls);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.setResponsedClass(cls);
        bVar.f(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        bVar.a(dupLicateMode);
        MessageManager.getInstance().registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void VU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) ant.getContext());
        aVar.aX(v.warning_location_switch_off).a(v.isopen, buh).b(v.cancel, bui).kT();
        aVar.kW();
    }
}

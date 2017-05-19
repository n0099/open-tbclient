package com.baidu.tieba.yunpush;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class PushStatic {
    private static void boQ() {
        bW(TbadkApplication.getInst());
    }

    private static void boR() {
        bX(TbadkCoreApplication.m9getInst());
    }

    private static void bW(Context context) {
        Log.e("BaiduYunPush", "start push");
        Log.e("BaiduYunPush", "start push1");
        PushManager.enableHuaweiProxy(context, true);
        Log.e("BaiduYunPush", "start push2");
        Log.e("BaiduYunPush", "start push3");
        PushManager.startWork(context, 0, k.getMetaValue(context, "api_key"));
        Log.e("BaiduYunPush", "start push4 ");
    }

    private static void bX(Context context) {
        Log.e("BaiduYunPush", "stop push");
        if (com.baidu.tbadk.core.sharedPref.b.tX().getBoolean(String.valueOf(TbConfig.getVersion()) + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            Log.e("BaiduYunPush", "stop push pushservice is working");
            PushManager.stopWork(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void boS() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.m9getInst().isBaiduYunPushAvailable()) {
                Log.e("BaiduYunPush", "switch available");
                boQ();
                return;
            }
            Log.e("BaiduYunPush", "switch close");
            boR();
        }
    }

    static {
        Log.e("BaiduYunPush", "push static init load static " + System.currentTimeMillis());
        registerListener();
        DG();
        if (TbadkCoreApplication.m9getInst().isMainProcess(false)) {
            new Thread(new a()).start();
        }
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_PUSH_COMMANDSERVICE_ONSTARTCOMMAND));
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.CMD_PUSH_PUSHMESSAGERECEIVER_ONRECEIVE));
        MessageManager.getInstance().registerListener(new e(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONCREATE));
        MessageManager.getInstance().registerListener(new f(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONDESTROY));
        MessageManager.getInstance().registerListener(new g(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONUNBIND));
        MessageManager.getInstance().registerListener(new h(CmdConfigCustom.CMD_PUSH_PUSHSERVICERECEIVER_ONRECEIVE));
        MessageManager.getInstance().registerListener(new i(CmdConfigCustom.CMD_PUSH_REGISTRATIONRECEIVER_ONRECEIVE));
    }

    private static void DG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONSTARTCOMMAND, new j());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONBIND, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}

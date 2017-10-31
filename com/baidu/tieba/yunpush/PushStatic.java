package com.baidu.tieba.yunpush;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes2.dex */
public class PushStatic {
    private static CustomMessageListener gYC = new CustomMessageListener(0) { // from class: com.baidu.tieba.yunpush.PushStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.yunpush.PushStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.e("BaiduYunPush", "push static init " + System.currentTimeMillis());
                        PushStatic.bFz();
                    }
                }).start();
            }
        }
    };

    private static void bFx() {
        cb(TbadkApplication.getInst());
    }

    private static void bFy() {
        cc(TbadkCoreApplication.getInst());
    }

    private static void cb(Context context) {
        Log.e("BaiduYunPush", "start push");
        Log.e("BaiduYunPush", "start push1");
        PushManager.enableHuaweiProxy(context, true);
        Log.e("BaiduYunPush", "start push2");
        PushManager.enableXiaomiProxy(context, true, "2882303761517130520", "5651713089520");
        Log.e("BaiduYunPush", "start push3");
        PushManager.startWork(context, 0, a.getMetaValue(context, "api_key"));
        Log.e("BaiduYunPush", "start push4 ");
    }

    private static void cc(Context context) {
        Log.e("BaiduYunPush", "stop push");
        if (b.getInstance().getBoolean(TbConfig.getVersion() + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            Log.e("BaiduYunPush", "stop push pushservice is working");
            PushManager.stopWork(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bFz() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.getInst().isBaiduYunPushAvailable()) {
                Log.e("BaiduYunPush", "switch available");
                bFx();
                return;
            }
            Log.e("BaiduYunPush", "switch close");
            bFy();
        }
    }

    static {
        Log.e("BaiduYunPush", "push static init load static " + System.currentTimeMillis());
        MessageManager.getInstance().registerListener(CmdConfigCustom.MAINTAB_ONCREATE_END, gYC);
    }
}

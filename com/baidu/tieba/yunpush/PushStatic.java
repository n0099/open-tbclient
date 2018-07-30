package com.baidu.tieba.yunpush;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes3.dex */
public class PushStatic {
    private static CustomMessageListener hBY = new CustomMessageListener(0) { // from class: com.baidu.tieba.yunpush.PushStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.yunpush.PushStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PushStatic.bIQ();
                    }
                }).start();
            }
        }
    };

    private static void bIO() {
        ct(TbadkApplication.getInst());
    }

    private static void bIP() {
        cu(TbadkCoreApplication.getInst());
    }

    private static void ct(Context context) {
        PushManager.enableHuaweiProxy(context, true);
        PushManager.enableXiaomiProxy(context, true, "2882303761517130520", "5651713089520");
        PushManager.enableMeizuProxy(context, true, "111848", "39e9cd05b2294f848dd1c10993e76b59");
        PushManager.startWork(context, 0, a.getMetaValue(context, "api_key"));
    }

    private static void cu(Context context) {
        if (b.getInstance().getBoolean(TbConfig.getVersion() + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            PushManager.stopWork(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bIQ() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.getInst().isBaiduYunPushAvailable()) {
                bIO();
            } else {
                bIP();
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(2007015, hBY);
    }
}

package com.baidu.tieba.yunpush;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.t.cc;
/* loaded from: classes3.dex */
public class PushStatic {
    private static CustomMessageListener jWA = new CustomMessageListener(0) { // from class: com.baidu.tieba.yunpush.PushStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.yunpush.PushStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PushStatic.cAQ();
                    }
                }).start();
            }
        }
    };

    private static void cAO() {
        en(TbadkApplication.getInst());
    }

    private static void cAP() {
        eo(TbadkCoreApplication.getInst());
    }

    private static void en(Context context) {
        PushManager.enableHuaweiProxy(context, true);
        PushManager.enableXiaomiProxy(context, true, "2882303761517130520", "5651713089520");
        if (cc.isOn()) {
            PushManager.enableOppoProxy(context, true, "2gA5b7NGq5OgccGk80GG8s4w0", "68Bba1d8dD3aE0B1065c01062ce63034");
        }
        PushManager.enableMeizuProxy(context, true, "111848", "39e9cd05b2294f848dd1c10993e76b59");
        PushManager.enableVivoProxy(context, true);
        PushManager.startWork(context, 0, a.getMetaValue(context, Constants.API_KEY));
    }

    private static void eo(Context context) {
        if (b.alP().getBoolean(TbConfig.getVersion() + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            PushManager.stopWork(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cAQ() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.getInst().isBaiduYunPushAvailable()) {
                cAO();
            } else {
                cAP();
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MAINTAB_ONCREATE_END, jWA);
    }
}

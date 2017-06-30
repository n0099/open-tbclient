package com.baidu.tieba.yunpush;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class PushStatic {
    private static CustomMessageListener gnr = new a(0);

    private static void bve() {
        bR(TbadkApplication.getInst());
    }

    private static void bvf() {
        bS(TbadkCoreApplication.m9getInst());
    }

    private static void bR(Context context) {
        Log.e("BaiduYunPush", "start push");
        Log.e("BaiduYunPush", "start push1");
        PushManager.enableHuaweiProxy(context, true);
        Log.e("BaiduYunPush", "start push2");
        PushManager.enableXiaomiProxy(context, true, "2882303761517130520", "5651713089520");
        Log.e("BaiduYunPush", "start push3");
        PushManager.startWork(context, 0, c.getMetaValue(context, "api_key"));
        Log.e("BaiduYunPush", "start push4 ");
    }

    private static void bS(Context context) {
        Log.e("BaiduYunPush", "stop push");
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(String.valueOf(TbConfig.getVersion()) + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            Log.e("BaiduYunPush", "stop push pushservice is working");
            PushManager.stopWork(context);
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.yunpush.b.run():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$0() {
        bvg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bvg() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.m9getInst().isBaiduYunPushAvailable()) {
                Log.e("BaiduYunPush", "switch available");
                bve();
                return;
            }
            Log.e("BaiduYunPush", "switch close");
            bvf();
        }
    }

    static {
        Log.e("BaiduYunPush", "push static init load static " + System.currentTimeMillis());
        MessageManager.getInstance().registerListener(CmdConfigCustom.MAINTAB_ONCREATE_END, gnr);
    }
}

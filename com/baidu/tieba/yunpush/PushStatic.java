package com.baidu.tieba.yunpush;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.YunPushOppoproxyEnableSwitch;
import d.b.h0.r.d0.b;
/* loaded from: classes5.dex */
public class PushStatic {

    /* renamed from: a  reason: collision with root package name */
    public static CustomMessageListener f22627a = new a(0);

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.yunpush.PushStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0231a implements Runnable {
            public RunnableC0231a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                PushStatic.d();
            }
        }

        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new RunnableC0231a(this)).start();
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(2007015, f22627a);
    }

    public static void b() {
        e(TbadkApplication.getInst());
    }

    public static void c() {
        f(TbadkCoreApplication.getInst());
    }

    public static void d() {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (TbadkCoreApplication.getInst().isBaiduYunPushAvailable()) {
                b();
            } else {
                c();
            }
        }
    }

    public static void e(Context context) {
        PushManager.enableHuaweiProxy(context, true);
        PushManager.enableXiaomiProxy(context, true, "2882303761517130520", "5651713089520");
        if (YunPushOppoproxyEnableSwitch.isOn()) {
            PushManager.enableOppoProxy(context, true, "2gA5b7NGq5OgccGk80GG8s4w0", "68Bba1d8dD3aE0B1065c01062ce63034");
        }
        PushManager.enableMeizuProxy(context, true, "111848", "39e9cd05b2294f848dd1c10993e76b59");
        PushManager.enableVivoProxy(context, true);
        PushManager.startWork(context, 0, d.b.i0.v3.a.a(context, Constants.API_KEY));
    }

    public static void f(Context context) {
        b i = b.i();
        if (i.g(TbConfig.getVersion() + BaiduYunPushMessageReceiver.KEY_SHAREDPRE_PUSH_STARTWORK, false)) {
            PushManager.stopWork(context);
        }
    }
}

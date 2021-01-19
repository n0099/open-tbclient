package com.baidu.tieba.passaccount.a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.passaccount.a.c;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b {
    private static volatile b lye;
    private a lyf;
    private AtomicBoolean lyg = new AtomicBoolean(false);
    private AtomicBoolean lyh = new AtomicBoolean(false);

    /* loaded from: classes7.dex */
    public interface a {
        void b(j.c cVar);
    }

    public static b dhS() {
        if (lye == null) {
            synchronized (b.class) {
                if (lye == null) {
                    lye = new b();
                }
            }
        }
        return lye;
    }

    private b() {
    }

    private void a(j jVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar == null || session == null) {
            a((j.c) null);
        } else if (jVar.getType() == 0) {
            Oh(jVar.getAuthToken());
        } else if (jVar.getType() == 1) {
            Oi(session.bduss);
        } else if (jVar.getType() == 2) {
            Oj(session.bduss);
        } else if (jVar.getType() == 3) {
            dhT();
        }
    }

    private void Oh(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Oi(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Oj(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void dhT() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(j jVar, a aVar) {
        if (this.lyh.compareAndSet(false, true)) {
            if (this.lyg.compareAndSet(false, true)) {
                try {
                    a(jVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.lyg.set(false);
                }
            } else if (!dhV()) {
                try {
                    a(jVar, aVar);
                } catch (Exception e2) {
                    this.lyg.set(false);
                }
            }
            this.lyh.set(false);
        }
    }

    public void a(j.c cVar) {
        if (this.lyf != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.lyf.b(cVar);
        }
        this.lyf = null;
        this.lyg.set(false);
    }

    public void z(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void uj(boolean z) {
        a(new j.c(false));
        if (z) {
            dhU();
        }
    }

    public void uk(boolean z) {
        a(new j.c(z));
    }

    public void A(boolean z, String str) {
        c.dhY().a((c.a) null);
        a(new j.b(z, str));
    }

    private void dhU() {
        com.baidu.tbadk.coreExtra.a.c bvw;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.bkF();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.zr(currentAccountObj.getID());
        if (ReloginManager.brp().brs() && !TextUtils.isEmpty(currentAccountObj.getID()) && (bvw = com.baidu.tbadk.coreExtra.a.a.bvw()) != null) {
            bvw.f(currentAccountObj);
        }
        ReloginManager.brp().e(null);
    }

    private boolean dhV() {
        ComponentName dhW = dhW();
        if (dhW != null) {
            return AuthActivity.class.getName().equals(dhW.getClassName()) || LivenessRecogActivity.class.getName().equals(dhW.getClassName());
        }
        return false;
    }

    private ComponentName dhW() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                        return runningTaskInfo.topActivity;
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void a(a aVar) {
        this.lyf = aVar;
    }

    public static void registerTask() {
        dhX();
    }

    private static void dhX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<j>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    j data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.bvS() != null) {
                            data.bvS().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.bvS() != null) {
                            data.bvS().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.dhS().b(data, new C0821b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0821b implements a {
        private j lyi;

        public C0821b(j jVar) {
            this.lyi = jVar;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(j.c cVar) {
            if (this.lyi != null && this.lyi.bvS() != null) {
                this.lyi.bvS().b(cVar);
            }
        }
    }
}

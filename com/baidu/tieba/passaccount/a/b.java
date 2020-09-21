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
/* loaded from: classes20.dex */
public class b {
    private static volatile b kCf;
    private a kCg;
    private AtomicBoolean kCh = new AtomicBoolean(false);
    private AtomicBoolean kCi = new AtomicBoolean(false);

    /* loaded from: classes20.dex */
    public interface a {
        void b(j.c cVar);
    }

    public static b cXW() {
        if (kCf == null) {
            synchronized (b.class) {
                if (kCf == null) {
                    kCf = new b();
                }
            }
        }
        return kCf;
    }

    private b() {
    }

    private void a(j jVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar == null || session == null) {
            a((j.c) null);
        } else if (jVar.getType() == 0) {
            NB(jVar.getAuthToken());
        } else if (jVar.getType() == 1) {
            NC(session.bduss);
        } else if (jVar.getType() == 2) {
            ND(session.bduss);
        } else if (jVar.getType() == 3) {
            cXX();
        }
    }

    private void NB(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void NC(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void ND(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void cXX() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(j jVar, a aVar) {
        if (this.kCi.compareAndSet(false, true)) {
            if (this.kCh.compareAndSet(false, true)) {
                try {
                    a(jVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.kCh.set(false);
                }
            } else if (!cXZ()) {
                try {
                    a(jVar, aVar);
                } catch (Exception e2) {
                    this.kCh.set(false);
                }
            }
            this.kCi.set(false);
        }
    }

    public void a(j.c cVar) {
        if (this.kCg != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.kCg.b(cVar);
        }
        this.kCg = null;
        this.kCh.set(false);
    }

    public void w(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void sA(boolean z) {
        a(new j.c(false));
        if (z) {
            cXY();
        }
    }

    public void sB(boolean z) {
        a(new j.c(z));
    }

    public void x(boolean z, String str) {
        c.cYc().a((c.a) null);
        a(new j.b(z, str));
    }

    private void cXY() {
        com.baidu.tbadk.coreExtra.a.c bnd;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.bcK();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.zj(currentAccountObj.getID());
        if (ReloginManager.biX().bja() && !TextUtils.isEmpty(currentAccountObj.getID()) && (bnd = com.baidu.tbadk.coreExtra.a.a.bnd()) != null) {
            bnd.f(currentAccountObj);
        }
        ReloginManager.biX().e(null);
    }

    private boolean cXZ() {
        ComponentName cYa = cYa();
        if (cYa != null) {
            return AuthActivity.class.getName().equals(cYa.getClassName()) || LivenessRecogActivity.class.getName().equals(cYa.getClassName());
        }
        return false;
    }

    private ComponentName cYa() {
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
        this.kCg = aVar;
    }

    public static void registerTask() {
        cYb();
    }

    private static void cYb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<j>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    j data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.bny() != null) {
                            data.bny().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.bny() != null) {
                            data.bny().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.cXW().b(data, new C0756b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    static class C0756b implements a {
        private j kCj;

        public C0756b(j jVar) {
            this.kCj = jVar;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(j.c cVar) {
            if (this.kCj != null && this.kCj.bny() != null) {
                this.kCj.bny().b(cVar);
            }
        }
    }
}

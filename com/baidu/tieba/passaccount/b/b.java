package com.baidu.tieba.passaccount.b;

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
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.baidu.tieba.passaccount.b.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class b {
    private static volatile b lHg;
    private a lHh;
    private AtomicBoolean lHi = new AtomicBoolean(false);
    private AtomicBoolean lHj = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public interface a {
        void b(j.c cVar);
    }

    public static b dkl() {
        if (lHg == null) {
            synchronized (b.class) {
                if (lHg == null) {
                    lHg = new b();
                }
            }
        }
        return lHg;
    }

    private b() {
    }

    private void a(j jVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar == null || session == null) {
            a((j.c) null);
        } else if (jVar.getType() == 0) {
            OZ(jVar.getAuthToken());
        } else if (jVar.getType() == 1) {
            Pa(session.bduss);
        } else if (jVar.getType() == 2) {
            Pb(session.bduss);
        } else if (jVar.getType() == 3) {
            dkm();
        }
    }

    private void OZ(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Pa(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Pb(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void dkm() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(j jVar, a aVar) {
        if (this.lHj.compareAndSet(false, true)) {
            if (this.lHi.compareAndSet(false, true)) {
                try {
                    a(jVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.lHi.set(false);
                }
            } else if (!dko()) {
                try {
                    a(jVar, aVar);
                } catch (Exception e2) {
                    this.lHi.set(false);
                }
            }
            this.lHj.set(false);
        }
    }

    public void a(j.c cVar) {
        if (this.lHh != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.lHh.b(cVar);
        }
        this.lHh = null;
        this.lHi.set(false);
    }

    public void G(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void uw(boolean z) {
        a(new j.c(false));
        if (z) {
            dkn();
        }
    }

    public void ux(boolean z) {
        a(new j.c(z));
    }

    public void H(boolean z, String str) {
        c.dkr().a((c.a) null);
        a(new j.b(z, str));
    }

    private void dkn() {
        com.baidu.tbadk.coreExtra.a.c bvP;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.bkX();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.zI(currentAccountObj.getID());
        if (ReloginManager.brI().brL() && !TextUtils.isEmpty(currentAccountObj.getID()) && (bvP = com.baidu.tbadk.coreExtra.a.a.bvP()) != null) {
            bvP.f(currentAccountObj);
        }
        ReloginManager.brI().e(null);
    }

    private boolean dko() {
        ComponentName dkp = dkp();
        if (dkp != null) {
            return AuthActivity.class.getName().equals(dkp.getClassName()) || LivenessRecogActivity.class.getName().equals(dkp.getClassName());
        }
        return false;
    }

    private ComponentName dkp() {
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
        this.lHh = aVar;
    }

    public static void registerTask() {
        dkq();
    }

    private static void dkq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<j>() { // from class: com.baidu.tieba.passaccount.b.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    j data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.bwl() != null) {
                            data.bwl().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.bwl() != null) {
                            data.bwl().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.dkl().b(data, new C0824b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static class C0824b implements a {
        private j lHk;

        public C0824b(j jVar) {
            this.lHk = jVar;
        }

        @Override // com.baidu.tieba.passaccount.b.b.a
        public void b(j.c cVar) {
            if (this.lHk != null && this.lHk.bwl() != null) {
                this.lHk.bwl().b(cVar);
            }
        }
    }
}

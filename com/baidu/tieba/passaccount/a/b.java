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
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tieba.passaccount.a.c;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class b {
    private static volatile b kef;
    private a keg;
    private AtomicBoolean keh = new AtomicBoolean(false);
    private AtomicBoolean kei = new AtomicBoolean(false);

    /* loaded from: classes15.dex */
    public interface a {
        void b(i.c cVar);
    }

    public static b cJA() {
        if (kef == null) {
            synchronized (b.class) {
                if (kef == null) {
                    kef = new b();
                }
            }
        }
        return kef;
    }

    private b() {
    }

    private void a(i iVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (iVar == null || session == null) {
            a((i.c) null);
        } else if (iVar.getType() == 0) {
            Kg(iVar.getAuthToken());
        } else if (iVar.getType() == 1) {
            loadModifyPwd(session.bduss);
        } else if (iVar.getType() == 2) {
            Kh(session.bduss);
        } else if (iVar.getType() == 3) {
            cJB();
        }
    }

    private void Kg(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void loadModifyPwd(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Kh(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void cJB() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(i iVar, a aVar) {
        if (this.kei.compareAndSet(false, true)) {
            if (this.keh.compareAndSet(false, true)) {
                try {
                    a(iVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.keh.set(false);
                }
            } else if (!cJD()) {
                try {
                    a(iVar, aVar);
                } catch (Exception e2) {
                    this.keh.set(false);
                }
            }
            this.kei.set(false);
        }
    }

    public void a(i.c cVar) {
        if (this.keg != null) {
            if (cVar == null) {
                cVar = new i.c(false);
            }
            this.keg.b(cVar);
        }
        this.keg = null;
        this.keh.set(false);
    }

    public void v(boolean z, String str) {
        a(new i.a(z, str));
    }

    public void rJ(boolean z) {
        a(new i.c(false));
        if (z) {
            cJC();
        }
    }

    public void rK(boolean z) {
        a(new i.c(z));
    }

    public void w(boolean z, String str) {
        c.cJG().a((c.a) null);
        a(new i.b(z, str));
    }

    private void cJC() {
        com.baidu.tbadk.coreExtra.a.c bdD;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.aTz();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.wC(currentAccountObj.getID());
        if (ReloginManager.aZI().aZL() && !TextUtils.isEmpty(currentAccountObj.getID()) && (bdD = com.baidu.tbadk.coreExtra.a.a.bdD()) != null) {
            bdD.f(currentAccountObj);
        }
        ReloginManager.aZI().e(null);
    }

    private boolean cJD() {
        ComponentName cJE = cJE();
        if (cJE != null) {
            return AuthActivity.class.getName().equals(cJE.getClassName()) || LivenessRecogActivity.class.getName().equals(cJE.getClassName());
        }
        return false;
    }

    private ComponentName cJE() {
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
        this.keg = aVar;
    }

    public static void registerTask() {
        cJF();
    }

    private static void cJF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<i>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<i> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    i data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.bdY() != null) {
                            data.bdY().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.bdY() != null) {
                            data.bdY().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.cJA().b(data, new C0708b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    static class C0708b implements a {
        private i kej;

        public C0708b(i iVar) {
            this.kej = iVar;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(i.c cVar) {
            if (this.kej != null && this.kej.bdY() != null) {
                this.kej.bdY().b(cVar);
            }
        }
    }
}

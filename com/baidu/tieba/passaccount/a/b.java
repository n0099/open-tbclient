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
/* loaded from: classes21.dex */
public class b {
    private static volatile b kRq;
    private a kRr;
    private AtomicBoolean kRs = new AtomicBoolean(false);
    private AtomicBoolean kRt = new AtomicBoolean(false);

    /* loaded from: classes21.dex */
    public interface a {
        void b(j.c cVar);
    }

    public static b dbF() {
        if (kRq == null) {
            synchronized (b.class) {
                if (kRq == null) {
                    kRq = new b();
                }
            }
        }
        return kRq;
    }

    private b() {
    }

    private void a(j jVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar == null || session == null) {
            a((j.c) null);
        } else if (jVar.getType() == 0) {
            Oq(jVar.getAuthToken());
        } else if (jVar.getType() == 1) {
            Or(session.bduss);
        } else if (jVar.getType() == 2) {
            Os(session.bduss);
        } else if (jVar.getType() == 3) {
            dbG();
        }
    }

    private void Oq(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Or(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Os(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void dbG() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(j jVar, a aVar) {
        if (this.kRt.compareAndSet(false, true)) {
            if (this.kRs.compareAndSet(false, true)) {
                try {
                    a(jVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.kRs.set(false);
                }
            } else if (!dbI()) {
                try {
                    a(jVar, aVar);
                } catch (Exception e2) {
                    this.kRs.set(false);
                }
            }
            this.kRt.set(false);
        }
    }

    public void a(j.c cVar) {
        if (this.kRr != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.kRr.b(cVar);
        }
        this.kRr = null;
        this.kRs.set(false);
    }

    public void w(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void th(boolean z) {
        a(new j.c(false));
        if (z) {
            dbH();
        }
    }

    public void ti(boolean z) {
        a(new j.c(z));
    }

    public void x(boolean z, String str) {
        c.dbL().a((c.a) null);
        a(new j.b(z, str));
    }

    private void dbH() {
        com.baidu.tbadk.coreExtra.a.c bpN;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.bfs();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.zV(currentAccountObj.getID());
        if (ReloginManager.blG().blJ() && !TextUtils.isEmpty(currentAccountObj.getID()) && (bpN = com.baidu.tbadk.coreExtra.a.a.bpN()) != null) {
            bpN.f(currentAccountObj);
        }
        ReloginManager.blG().e(null);
    }

    private boolean dbI() {
        ComponentName dbJ = dbJ();
        if (dbJ != null) {
            return AuthActivity.class.getName().equals(dbJ.getClassName()) || LivenessRecogActivity.class.getName().equals(dbJ.getClassName());
        }
        return false;
    }

    private ComponentName dbJ() {
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
        this.kRr = aVar;
    }

    public static void registerTask() {
        dbK();
    }

    private static void dbK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<j>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    j data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.bqi() != null) {
                            data.bqi().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.bqi() != null) {
                            data.bqi().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.dbF().b(data, new C0774b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    static class C0774b implements a {
        private j kRu;

        public C0774b(j jVar) {
            this.kRu = jVar;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(j.c cVar) {
            if (this.kRu != null && this.kRu.bqi() != null) {
                this.kRu.bqi().b(cVar);
            }
        }
    }
}

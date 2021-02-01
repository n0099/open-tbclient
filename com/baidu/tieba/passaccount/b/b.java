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
    private static volatile b lGS;
    private a lGT;
    private AtomicBoolean lGU = new AtomicBoolean(false);
    private AtomicBoolean lGV = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public interface a {
        void b(j.c cVar);
    }

    public static b dke() {
        if (lGS == null) {
            synchronized (b.class) {
                if (lGS == null) {
                    lGS = new b();
                }
            }
        }
        return lGS;
    }

    private b() {
    }

    private void a(j jVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (jVar == null || session == null) {
            a((j.c) null);
        } else if (jVar.getType() == 0) {
            OY(jVar.getAuthToken());
        } else if (jVar.getType() == 1) {
            OZ(session.bduss);
        } else if (jVar.getType() == 2) {
            Pa(session.bduss);
        } else if (jVar.getType() == 3) {
            dkf();
        }
    }

    private void OY(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 0);
        intent.putExtra("EXTRA_AUTH_TOKEN", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void OZ(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 1);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void Pa(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void dkf() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(j jVar, a aVar) {
        if (this.lGV.compareAndSet(false, true)) {
            if (this.lGU.compareAndSet(false, true)) {
                try {
                    a(jVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.lGU.set(false);
                }
            } else if (!dkh()) {
                try {
                    a(jVar, aVar);
                } catch (Exception e2) {
                    this.lGU.set(false);
                }
            }
            this.lGV.set(false);
        }
    }

    public void a(j.c cVar) {
        if (this.lGT != null) {
            if (cVar == null) {
                cVar = new j.c(false);
            }
            this.lGT.b(cVar);
        }
        this.lGT = null;
        this.lGU.set(false);
    }

    public void G(boolean z, String str) {
        a(new j.a(z, str));
    }

    public void uw(boolean z) {
        a(new j.c(false));
        if (z) {
            dkg();
        }
    }

    public void ux(boolean z) {
        a(new j.c(z));
    }

    public void H(boolean z, String str) {
        c.dkk().a((c.a) null);
        a(new j.b(z, str));
    }

    private void dkg() {
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

    private boolean dkh() {
        ComponentName dki = dki();
        if (dki != null) {
            return AuthActivity.class.getName().equals(dki.getClassName()) || LivenessRecogActivity.class.getName().equals(dki.getClassName());
        }
        return false;
    }

    private ComponentName dki() {
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
        this.lGT = aVar;
    }

    public static void registerTask() {
        dkj();
    }

    private static void dkj() {
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
                        b.dke().b(data, new C0823b(data));
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
    static class C0823b implements a {
        private j lGW;

        public C0823b(j jVar) {
            this.lGW = jVar;
        }

        @Override // com.baidu.tieba.passaccount.b.b.a
        public void b(j.c cVar) {
            if (this.lGW != null && this.lGW.bwl() != null) {
                this.lGW.bwl().b(cVar);
            }
        }
    }
}

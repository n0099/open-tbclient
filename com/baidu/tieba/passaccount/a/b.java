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
/* loaded from: classes8.dex */
public class b {
    private static volatile b jBU;
    private a jBV;
    private AtomicBoolean jBW = new AtomicBoolean(false);
    private AtomicBoolean jBX = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public interface a {
        void b(i.c cVar);
    }

    public static b cBA() {
        if (jBU == null) {
            synchronized (b.class) {
                if (jBU == null) {
                    jBU = new b();
                }
            }
        }
        return jBU;
    }

    private b() {
    }

    private void a(i iVar, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (iVar == null || session == null) {
            a((i.c) null);
        } else if (iVar.getType() == 0) {
            IS(iVar.getAuthToken());
        } else if (iVar.getType() == 1) {
            loadModifyPwd(session.bduss);
        } else if (iVar.getType() == 2) {
            IT(session.bduss);
        } else if (iVar.getType() == 3) {
            cBB();
        }
    }

    private void IS(String str) {
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

    private void IT(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void cBB() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(i iVar, a aVar) {
        if (this.jBX.compareAndSet(false, true)) {
            if (this.jBW.compareAndSet(false, true)) {
                try {
                    a(iVar, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.jBW.set(false);
                }
            } else if (!cBD()) {
                try {
                    a(iVar, aVar);
                } catch (Exception e2) {
                    this.jBW.set(false);
                }
            }
            this.jBX.set(false);
        }
    }

    public void a(i.c cVar) {
        if (this.jBV != null) {
            if (cVar == null) {
                cVar = new i.c(false);
            }
            this.jBV.b(cVar);
        }
        this.jBV = null;
        this.jBW.set(false);
    }

    public void t(boolean z, String str) {
        a(new i.a(z, str));
    }

    public void qQ(boolean z) {
        a(new i.c(false));
        if (z) {
            cBC();
        }
    }

    public void qR(boolean z) {
        a(new i.c(z));
    }

    public void u(boolean z, String str) {
        c.cBG().a((c.a) null);
        a(new i.b(z, str));
    }

    private void cBC() {
        com.baidu.tbadk.coreExtra.a.c aXA;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.aNU();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.vo(currentAccountObj.getID());
        if (ReloginManager.aTQ().aTT() && !TextUtils.isEmpty(currentAccountObj.getID()) && (aXA = com.baidu.tbadk.coreExtra.a.a.aXA()) != null) {
            aXA.f(currentAccountObj);
        }
        ReloginManager.aTQ().e(null);
    }

    private boolean cBD() {
        ComponentName cBE = cBE();
        if (cBE != null) {
            return AuthActivity.class.getName().equals(cBE.getClassName()) || LivenessRecogActivity.class.getName().equals(cBE.getClassName());
        }
        return false;
    }

    private ComponentName cBE() {
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
        this.jBV = aVar;
    }

    public static void Fv() {
        cBF();
    }

    private static void cBF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<i>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<i> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    i data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() == 0 && TextUtils.isEmpty(authToken)) {
                        if (data.aXW() != null) {
                            data.aXW().b(null);
                        }
                    } else if (data.getType() == 4) {
                        l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        if (data.aXW() != null) {
                            data.aXW().b(null);
                        }
                    } else {
                        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
                        b.cBA().b(data, new C0680b(data));
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static class C0680b implements a {
        private i jBY;

        public C0680b(i iVar) {
            this.jBY = iVar;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(i.c cVar) {
            if (this.jBY != null && this.jBY.aXW() != null) {
                this.jBY.aXW().b(cVar);
            }
        }
    }
}

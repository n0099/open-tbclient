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
import com.baidu.pass.biometrics.face.liveness.activity.LivenessLoadingActivity;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.coreExtra.data.AuthVerifyData;
import com.baidu.tieba.passaccount.a.c;
import com.baidu.tieba.passaccount.app.AuthActivity;
import com.baidu.tieba.passaccount.app.RemindActivity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {
    private static volatile b hFd;
    private a hFe;
    private AtomicBoolean hFf = new AtomicBoolean(false);
    private AtomicBoolean hFg = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    public interface a {
        void b(AuthVerifyData.c cVar);
    }

    public static b bRN() {
        if (hFd == null) {
            synchronized (b.class) {
                if (hFd == null) {
                    hFd = new b();
                }
            }
        }
        return hFd;
    }

    private b() {
    }

    private void a(AuthVerifyData authVerifyData, a aVar) {
        a(aVar);
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (authVerifyData == null || session == null) {
            a((AuthVerifyData.c) null);
        } else if (authVerifyData.getType() == 0) {
            Bz(authVerifyData.getAuthToken());
        } else if (authVerifyData.getType() == 1) {
            loadModifyPwd(session.bduss);
        } else if (authVerifyData.getType() == 2) {
            BA(session.bduss);
        } else if (authVerifyData.getType() == 3) {
            bRO();
        }
    }

    private void Bz(String str) {
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

    private void BA(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra("EXTRA_TYPE", 2);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void bRO() {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        Intent intent = new Intent(context, RemindActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void b(AuthVerifyData authVerifyData, a aVar) {
        if (this.hFg.compareAndSet(false, true)) {
            if (this.hFf.compareAndSet(false, true)) {
                try {
                    a(authVerifyData, aVar);
                } catch (Exception e) {
                    BdStatisticsManager.getInstance().error("passloaderror", 0L, (String) null, "Exception", e.toString());
                    this.hFf.set(false);
                }
            } else if (!bRQ()) {
                try {
                    a(authVerifyData, aVar);
                } catch (Exception e2) {
                    this.hFf.set(false);
                }
            }
            this.hFg.set(false);
        }
    }

    public void a(AuthVerifyData.c cVar) {
        if (this.hFe != null) {
            if (cVar == null) {
                cVar = new AuthVerifyData.c(false);
            }
            this.hFe.b(cVar);
        }
        this.hFe = null;
        this.hFf.set(false);
    }

    public void r(boolean z, String str) {
        a(new AuthVerifyData.a(z, str));
    }

    public void nS(boolean z) {
        a(new AuthVerifyData.c(false));
        if (z) {
            bRP();
        }
    }

    public void nT(boolean z) {
        a(new AuthVerifyData.c(z));
    }

    public void s(boolean z, String str) {
        c.bRU().a((c.a) null);
        a(new AuthVerifyData.b(z, str));
    }

    private void bRP() {
        com.baidu.tbadk.coreExtra.a.c alK;
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.a.b.acj();
        }
        if (currentAccountObj == null || (TextUtils.isEmpty(currentAccountObj.getAccount()) && TextUtils.isEmpty(currentAccountObj.getAccountNameShow()))) {
            Handler handler = TbadkCoreApplication.getInst().handler;
            handler.sendMessage(handler.obtainMessage(1));
            return;
        }
        com.baidu.tbadk.core.a.b.ml(currentAccountObj.getID());
        if (ReloginManager.ahJ().ahM() && !TextUtils.isEmpty(currentAccountObj.getID()) && (alK = com.baidu.tbadk.coreExtra.a.a.alK()) != null) {
            alK.f(currentAccountObj);
        }
        ReloginManager.ahJ().e(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRQ() {
        ComponentName bRR = bRR();
        if (bRR != null) {
            return AuthActivity.class.getName().equals(bRR.getClassName()) || LivenessRecogActivity.class.getName().equals(bRR.getClassName()) || LivenessLoadingActivity.class.getName().equals(bRR.getClassName());
        }
        return false;
    }

    private ComponentName bRR() {
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
        this.hFe = aVar;
    }

    public static void registerTask() {
        bRS();
        bRT();
    }

    private static void bRS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921372, new CustomMessageTask.CustomRunnable<AuthVerifyData>() { // from class: com.baidu.tieba.passaccount.a.b.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<AuthVerifyData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    AuthVerifyData data = customMessage.getData();
                    String authToken = data.getAuthToken();
                    if (data.getType() != 0 || !TextUtils.isEmpty(authToken)) {
                        if (data.getType() == 4) {
                            l.showToast(TbadkCoreApplication.getInst(), "验证失败，请您稍后再试");
                        } else {
                            MessageManager.getInstance().runTask(2921332, (Class) null);
                            b.bRN().b(data, new C0369b(data));
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bRT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921373, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.passaccount.a.b.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921373, Boolean.valueOf(b.bRN().bRQ()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* renamed from: com.baidu.tieba.passaccount.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0369b implements a {
        private AuthVerifyData hFh;

        public C0369b(AuthVerifyData authVerifyData) {
            this.hFh = authVerifyData;
        }

        @Override // com.baidu.tieba.passaccount.a.b.a
        public void b(AuthVerifyData.c cVar) {
            this.hFh.setResult(cVar);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921372, this.hFh));
        }
    }
}

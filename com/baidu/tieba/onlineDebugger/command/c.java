package com.baidu.tieba.onlineDebugger.command;

import android.app.ActivityManager;
import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ b dIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dIa = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashSet hashSet = new HashSet(10);
        HashSet hashSet2 = new HashSet(10);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) BdBaseApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.startsWith(BdBaseApplication.getInst().getPackageName()) && runningAppProcessInfo.pid != Process.myPid() && hashSet.contains(runningAppProcessInfo.processName)) {
                    hashSet2.add(Integer.valueOf(runningAppProcessInfo.pid));
                }
            }
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            BdLog.e("pidSet " + num);
            Process.killProcess(num.intValue());
        }
        BdLog.e("myPid " + Process.myPid());
        Process.killProcess(Process.myPid());
    }
}

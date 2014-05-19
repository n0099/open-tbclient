package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.model.bb;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private static String a = null;
    private o b = null;
    private int c = 0;
    private bb d = null;
    private Handler e = new Handler();
    private Runnable f = new n(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bd.class, TiebaSyncService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new o(this, null);
        this.b.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancel();
        }
        this.c = 11;
        this.e.removeCallbacks(this.f);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.c = 0;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            sendBroadcast(new Intent(com.baidu.tieba.data.d.d()));
            BdLog.i(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.d.c().getNewVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        String aPKMd5;
        try {
            if (i == com.baidu.tbadk.core.sharedPref.b.a().a("version_code", 0)) {
                aPKMd5 = com.baidu.tbadk.core.sharedPref.b.a().a("apk_md5", "");
            } else {
                com.baidu.tbadk.core.sharedPref.b.a().b("version_code", i);
                aPKMd5 = UtilHelper.getAPKMd5(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(TbadkApplication.m252getInst().getPackageName(), 0));
                com.baidu.tbadk.core.sharedPref.b.a().b("apk_md5", aPKMd5);
            }
            return aPKMd5;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
            return null;
        }
    }
}

package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.b.b.e.p.l;
import d.b.h0.r.k;
import d.b.i0.r1.d;
/* loaded from: classes5.dex */
public class SyncLoginService extends BdBaseService {
    public static String mStatistics;
    public b mSyncTask = null;
    public Handler mHandler = new Handler();
    public Runnable mRunnable = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SyncLoginService.this.checkPassV6Switch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPassV6Switch() {
        b bVar = this.mSyncTask;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(this, null);
        this.mSyncTask = bVar2;
        bVar2.execute(new String[0]);
    }

    public static void setMsgType(String str) {
        mStatistics = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVar = this.mSyncTask;
        if (bVar != null) {
            bVar.cancel();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        checkPassV6Switch();
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, d> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20929a;

        public b() {
            this.f20929a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d doInBackground(String... strArr) {
            d dVar = null;
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/switch");
                this.f20929a = netWork;
                netWork.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                StringBuffer stringBuffer = new StringBuffer(15);
                stringBuffer.append(String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f20929a.addPostData("_phone_screen", stringBuffer.toString());
                this.f20929a.addPostData("scr_w", String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                this.f20929a.addPostData("scr_h", String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f20929a.addPostData("scr_dip", String.valueOf(l.h(TbadkCoreApplication.getInst().getApp())));
                String str = "0";
                if (d.b.h0.s.d.d.d().e() > 0) {
                    this.f20929a.addPostData("_msg_status", "0");
                } else {
                    this.f20929a.addPostData("_msg_status", "1");
                }
                String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
                if (activeVersion != null) {
                    if (activeVersion.length() >= 1) {
                        str = activeVersion;
                    }
                    this.f20929a.addPostData("_active", str);
                }
                this.f20929a.addPostData("_pic_quality", String.valueOf(k.c().e()));
                if (SyncLoginService.mStatistics != null) {
                    this.f20929a.addPostData("_msg_type", SyncLoginService.mStatistics);
                }
                String packageName = TbadkCoreApplication.getInst().getPackageName();
                this.f20929a.addPostData("package", packageName);
                int versionCode = TbadkCoreApplication.getInst().getVersionCode();
                NetWork netWork2 = this.f20929a;
                netWork2.addPostData("versioncode", versionCode + "");
                this.f20929a.addPostData("signmd5", TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(packageName, 64)));
                this.f20929a.addPostData(PackageTable.MD5, d.b.i0.l.a());
                String postNetData = this.f20929a.postNetData();
                if (this.f20929a.getNetContext().getResponse().isRequestSuccess()) {
                    d dVar2 = new d();
                    try {
                        dVar2.a(postNetData);
                        String unused = SyncLoginService.mStatistics = null;
                        return dVar2;
                    } catch (Exception e2) {
                        e = e2;
                        dVar = dVar2;
                        BdLog.e(e.getMessage());
                        return dVar;
                    }
                }
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d dVar) {
            super.onPostExecute(dVar);
            SyncLoginService.this.mSyncTask = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            SyncLoginService.this.mSyncTask = null;
            NetWork netWork = this.f20929a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        public /* synthetic */ b(SyncLoginService syncLoginService, a aVar) {
            this();
        }
    }
}

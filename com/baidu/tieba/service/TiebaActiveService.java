package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes4.dex */
public class TiebaActiveService extends BdBaseService {
    public static final int ACTIVE_FAIL = 1;
    public static final int ACTIVE_SUCC = 2;
    public b mActiveTask = null;
    public int mHaveRetry = 0;
    public Handler mHandler = new Handler();
    public Runnable mRunnable = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TiebaActiveService.this.sendActive();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20617a;

        public b() {
            this.f20617a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            TiebaActiveService.this.mActiveTask = null;
            NetWork netWork = this.f20617a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                NetWork netWork = new NetWork("http://114.113.149.3:8086/partnersService");
                this.f20617a = netWork;
                netWork.addPostData("apk", TbadkCoreApplication.getInst().getApp().getPackageName());
                this.f20617a.addPostData("imei", TbadkCoreApplication.getInst().getImei());
                this.f20617a.addPostData("model", Build.MODEL);
                this.f20617a.addPostData("edition", TbConfig.getVersion());
                this.f20617a.addPostData("system", Build.VERSION.SDK);
                this.f20617a.getNetContext().getRequest().getNetWorkParam().mIsBaiduServer = false;
                String postNetData = this.f20617a.postNetData();
                if (this.f20617a.isNetSuccess()) {
                    return postNetData;
                }
                return null;
            } catch (Exception e2) {
                d.b.h0.r.d0.b.j().v("active", 1);
                BdLog.e(e2.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            TiebaActiveService.this.mActiveTask = null;
            if (str == null) {
                TiebaActiveService.access$308(TiebaActiveService.this);
                if (TiebaActiveService.this.mHaveRetry < 10) {
                    TiebaActiveService.this.mHandler.removeCallbacks(TiebaActiveService.this.mRunnable);
                    TiebaActiveService.this.mHandler.postDelayed(TiebaActiveService.this.mRunnable, 60000L);
                } else {
                    d.b.h0.r.d0.b.j().v("active", 1);
                    TiebaActiveService.this.stopSelf();
                }
            }
            d.b.h0.r.d0.b.j().v("active", 2);
            TiebaActiveService.this.stopSelf();
        }

        public /* synthetic */ b(TiebaActiveService tiebaActiveService, a aVar) {
            this();
        }
    }

    public static /* synthetic */ int access$308(TiebaActiveService tiebaActiveService) {
        int i = tiebaActiveService.mHaveRetry;
        tiebaActiveService.mHaveRetry = i + 1;
        return i;
    }

    private String getChannelByShare() {
        return d.b.h0.r.d0.b.j().p("channel_id", null);
    }

    private String getChannelyFile() {
        String str = null;
        try {
            File GetFile = FileHelper.GetFile(TbConfig.CHANNEL_FILE);
            if (GetFile != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                str = bufferedReader.readLine();
                bufferedReader.close();
                return str;
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "TiebaActiveService.getChannelyFile");
            return str;
        }
    }

    private boolean isActived() {
        try {
            String channelByShare = getChannelByShare();
            if (channelByShare == null) {
                String channelyFile = getChannelyFile();
                if (channelyFile != null && channelyFile.length() > 0) {
                    saveChannelToShare(channelyFile);
                    return true;
                }
                saveChannelToShare("aishide");
                saveChannelToFile("aishide");
                return false;
            }
            saveChannelToFile(channelByShare);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return true;
        }
    }

    private void saveChannelToFile(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            File CreateFile = FileHelper.CreateFile(TbConfig.CHANNEL_FILE);
            if (CreateFile != null) {
                FileWriter fileWriter = new FileWriter(CreateFile);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "TiebaActiveService.saveChannelToFile");
        }
    }

    private void saveChannelToShare(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        d.b.h0.r.d0.b.j().x("channel_id", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendActive() {
        b bVar = this.mActiveTask;
        if (bVar != null) {
            bVar.cancel();
        }
        b bVar2 = new b(this, null);
        this.mActiveTask = bVar2;
        bVar2.execute(new String[0]);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVar = this.mActiveTask;
        if (bVar != null) {
            bVar.cancel();
        }
        this.mHaveRetry = 11;
        this.mHandler.removeCallbacks(this.mRunnable);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (isActived() && d.b.h0.r.d0.b.j().k("active", 2) != 1) {
            stopSelf();
        } else {
            sendActive();
        }
    }
}

package com.baidu.tieba.lc;

import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseService;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
/* loaded from: classes.dex */
public class TiebaLcUpdateService extends BdBaseService {
    private b mLcUpdateAsyncTask;

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        startUpdate((ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA));
    }

    private void startUpdate(ClientUpdateInfo clientUpdateInfo) {
        if (clientUpdateInfo != null) {
            if (this.mLcUpdateAsyncTask != null) {
                this.mLcUpdateAsyncTask.cancel();
                this.mLcUpdateAsyncTask = null;
            }
            this.mLcUpdateAsyncTask = new b(clientUpdateInfo);
            this.mLcUpdateAsyncTask.execute(new String[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mLcUpdateAsyncTask != null) {
            this.mLcUpdateAsyncTask.cancel();
            this.mLcUpdateAsyncTask = null;
        }
        super.onDestroy();
    }
}

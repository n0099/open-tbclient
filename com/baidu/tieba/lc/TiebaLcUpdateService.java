package com.baidu.tieba.lc;

import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.baidu.adp.base.BdBaseService;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import d.b.i0.h1.b;
/* loaded from: classes4.dex */
public class TiebaLcUpdateService extends BdBaseService {
    public b mLcUpdateAsyncTask;

    private void startUpdate(ClientUpdateInfo clientUpdateInfo) {
        if (clientUpdateInfo == null) {
            return;
        }
        b bVar = this.mLcUpdateAsyncTask;
        if (bVar != null) {
            bVar.cancel();
            this.mLcUpdateAsyncTask = null;
        }
        b bVar2 = new b(clientUpdateInfo);
        this.mLcUpdateAsyncTask = bVar2;
        bVar2.execute(new String[0]);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        b bVar = this.mLcUpdateAsyncTask;
        if (bVar != null) {
            bVar.cancel();
            this.mLcUpdateAsyncTask = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        startUpdate((ClientUpdateInfo) intent.getSerializableExtra(LcUpdateDialogActivityConfig.KEY_LC_UPDATE_DATA));
    }
}

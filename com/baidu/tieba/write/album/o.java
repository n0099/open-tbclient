package com.baidu.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class o {
    private static o ctU;
    private ContentObserver ctV;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<s> lE = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable ctW = new p(this);

    public static o apO() {
        if (ctU == null) {
            ctU = new o();
            ctU.init(TbadkCoreApplication.m411getInst());
        }
        return ctU;
    }

    private o() {
    }

    private void init(Context context) {
        this.mReceiver = new q(this);
        this.ctV = new r(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.ctV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            fc(true);
            return;
        }
        this.handler.removeCallbacks(this.ctW);
        this.handler.postDelayed(this.ctW, 2000L);
    }

    public void fc(boolean z) {
        Iterator<s> it = this.lE.iterator();
        while (it.hasNext()) {
            it.next().fd(z);
        }
    }

    public void a(s sVar) {
        if (sVar != null && !this.lE.contains(sVar)) {
            this.lE.add(sVar);
        }
    }

    public void b(s sVar) {
        if (this.lE.contains(sVar)) {
            this.lE.remove(sVar);
        }
    }

    public void removeAllListeners() {
        this.lE.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
        m411getInst.unregisterReceiver(this.mReceiver);
        m411getInst.getContentResolver().unregisterContentObserver(this.ctV);
        ctU = null;
    }
}

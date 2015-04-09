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
    private static o cuk;
    private ContentObserver cul;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<s> lE = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable cum = new p(this);

    public static o aqd() {
        if (cuk == null) {
            cuk = new o();
            cuk.init(TbadkCoreApplication.m411getInst());
        }
        return cuk;
    }

    private o() {
    }

    private void init(Context context) {
        this.mReceiver = new q(this);
        this.cul = new r(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.cul);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            fa(true);
            return;
        }
        this.handler.removeCallbacks(this.cum);
        this.handler.postDelayed(this.cum, 2000L);
    }

    public void fa(boolean z) {
        Iterator<s> it = this.lE.iterator();
        while (it.hasNext()) {
            it.next().fb(z);
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
        m411getInst.getContentResolver().unregisterContentObserver(this.cul);
        cuk = null;
    }
}

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
public class p {
    private static p fHx;
    private ContentObserver fHy;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> bG = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable fHz = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void lI(boolean z);
    }

    public static p bnm() {
        if (fHx == null) {
            synchronized (p.class) {
                if (fHx == null) {
                    fHx = new p();
                    fHx.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return fHx;
    }

    private p() {
    }

    private void init(Context context) {
        this.mReceiver = new r(this);
        this.fHy = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fHy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            lH(true);
            return;
        }
        this.handler.removeCallbacks(this.fHz);
        this.handler.postDelayed(this.fHz, 2000L);
    }

    public void lH(boolean z) {
        Iterator<a> it = this.bG.iterator();
        while (it.hasNext()) {
            it.next().lI(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.bG.contains(aVar)) {
            this.bG.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.bG.contains(aVar)) {
            this.bG.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.bG.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
        m9getInst.unregisterReceiver(this.mReceiver);
        m9getInst.getContentResolver().unregisterContentObserver(this.fHy);
        this.handler.removeCallbacks(this.fHz);
        fHx = null;
    }
}

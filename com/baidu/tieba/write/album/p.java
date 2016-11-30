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
    private static p gkr;
    private BroadcastReceiver gks;
    private ContentObserver gkt;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> bH = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gku = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void mk(boolean z);
    }

    public static p buT() {
        if (gkr == null) {
            synchronized (p.class) {
                if (gkr == null) {
                    gkr = new p();
                    gkr.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return gkr;
    }

    private p() {
    }

    private void init(Context context) {
        this.gks = new r(this);
        this.gkt = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.gks, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gkt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            mj(true);
            return;
        }
        this.handler.removeCallbacks(this.gku);
        this.handler.postDelayed(this.gku, 2000L);
    }

    public void mj(boolean z) {
        Iterator<a> it = this.bH.iterator();
        while (it.hasNext()) {
            it.next().mk(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.bH.contains(aVar)) {
            this.bH.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.bH.contains(aVar)) {
            this.bH.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.bH.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
        m9getInst.unregisterReceiver(this.gks);
        m9getInst.getContentResolver().unregisterContentObserver(this.gkt);
        this.handler.removeCallbacks(this.gku);
        gkr = null;
    }
}

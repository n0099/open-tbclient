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
    private static p eYi;
    private BroadcastReceiver eYj;
    private ContentObserver eYk;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> bH = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable eYl = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void ku(boolean z);
    }

    public static p bbD() {
        if (eYi == null) {
            synchronized (p.class) {
                if (eYi == null) {
                    eYi = new p();
                    eYi.init(TbadkCoreApplication.m11getInst());
                }
            }
        }
        return eYi;
    }

    private p() {
    }

    private void init(Context context) {
        this.eYj = new r(this);
        this.eYk = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.eYj, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.eYk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            kt(true);
            return;
        }
        this.handler.removeCallbacks(this.eYl);
        this.handler.postDelayed(this.eYl, 2000L);
    }

    public void kt(boolean z) {
        Iterator<a> it = this.bH.iterator();
        while (it.hasNext()) {
            it.next().ku(z);
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
        TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
        m11getInst.unregisterReceiver(this.eYj);
        m11getInst.getContentResolver().unregisterContentObserver(this.eYk);
        this.handler.removeCallbacks(this.eYl);
        eYi = null;
    }
}

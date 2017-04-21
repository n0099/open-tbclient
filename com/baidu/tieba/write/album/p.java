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
    private static p fPW;
    private ContentObserver fPX;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jr = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable fPY = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void lU(boolean z);
    }

    public static p boK() {
        if (fPW == null) {
            synchronized (p.class) {
                if (fPW == null) {
                    fPW = new p();
                    fPW.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return fPW;
    }

    private p() {
    }

    private void init(Context context) {
        this.mReceiver = new r(this);
        this.fPX = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fPX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            lT(true);
            return;
        }
        this.handler.removeCallbacks(this.fPY);
        this.handler.postDelayed(this.fPY, 2000L);
    }

    public void lT(boolean z) {
        Iterator<a> it = this.jr.iterator();
        while (it.hasNext()) {
            it.next().lU(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.jr.contains(aVar)) {
            this.jr.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.jr.contains(aVar)) {
            this.jr.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.jr.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
        m9getInst.unregisterReceiver(this.mReceiver);
        m9getInst.getContentResolver().unregisterContentObserver(this.fPX);
        this.handler.removeCallbacks(this.fPY);
        fPW = null;
    }
}

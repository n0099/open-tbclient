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
    private static p gcM;
    private BroadcastReceiver gcN;
    private ContentObserver gcO;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> bH = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gcP = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void lL(boolean z);
    }

    public static p bsy() {
        if (gcM == null) {
            synchronized (p.class) {
                if (gcM == null) {
                    gcM = new p();
                    gcM.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return gcM;
    }

    private p() {
    }

    private void init(Context context) {
        this.gcN = new r(this);
        this.gcO = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.gcN, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gcO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            lK(true);
            return;
        }
        this.handler.removeCallbacks(this.gcP);
        this.handler.postDelayed(this.gcP, 2000L);
    }

    public void lK(boolean z) {
        Iterator<a> it = this.bH.iterator();
        while (it.hasNext()) {
            it.next().lL(z);
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
        m9getInst.unregisterReceiver(this.gcN);
        m9getInst.getContentResolver().unregisterContentObserver(this.gcO);
        this.handler.removeCallbacks(this.gcP);
        gcM = null;
    }
}

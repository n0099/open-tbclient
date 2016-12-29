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
    private static p fyT;
    private BroadcastReceiver fyU;
    private ContentObserver fyV;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> bH = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable fyW = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void ly(boolean z);
    }

    public static p blO() {
        if (fyT == null) {
            synchronized (p.class) {
                if (fyT == null) {
                    fyT = new p();
                    fyT.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return fyT;
    }

    private p() {
    }

    private void init(Context context) {
        this.fyU = new r(this);
        this.fyV = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.fyU, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fyV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            lx(true);
            return;
        }
        this.handler.removeCallbacks(this.fyW);
        this.handler.postDelayed(this.fyW, 2000L);
    }

    public void lx(boolean z) {
        Iterator<a> it = this.bH.iterator();
        while (it.hasNext()) {
            it.next().ly(z);
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
        m9getInst.unregisterReceiver(this.fyU);
        m9getInst.getContentResolver().unregisterContentObserver(this.fyV);
        this.handler.removeCallbacks(this.fyW);
        fyT = null;
    }
}

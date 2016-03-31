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
    private static p eHo;
    private BroadcastReceiver eHp;
    private ContentObserver eHq;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> lG = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable eHr = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void jo(boolean z);
    }

    public static p aZo() {
        if (eHo == null) {
            synchronized (p.class) {
                if (eHo == null) {
                    eHo = new p();
                    eHo.init(TbadkCoreApplication.m411getInst());
                }
            }
        }
        return eHo;
    }

    private p() {
    }

    private void init(Context context) {
        this.eHp = new r(this);
        this.eHq = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.eHp, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.eHq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            jn(true);
            return;
        }
        this.handler.removeCallbacks(this.eHr);
        this.handler.postDelayed(this.eHr, 2000L);
    }

    public void jn(boolean z) {
        Iterator<a> it = this.lG.iterator();
        while (it.hasNext()) {
            it.next().jo(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.lG.contains(aVar)) {
            this.lG.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.lG.contains(aVar)) {
            this.lG.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.lG.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
        m411getInst.unregisterReceiver(this.eHp);
        m411getInst.getContentResolver().unregisterContentObserver(this.eHq);
        this.handler.removeCallbacks(this.eHr);
        eHo = null;
    }
}

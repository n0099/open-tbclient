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
    private static p dLn;
    private BroadcastReceiver dLo;
    private ContentObserver dLp;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable dLq = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void hD(boolean z);
    }

    public static p aHI() {
        if (dLn == null) {
            synchronized (p.class) {
                if (dLn == null) {
                    dLn = new p();
                    dLn.init(TbadkCoreApplication.m411getInst());
                }
            }
        }
        return dLn;
    }

    private p() {
    }

    private void init(Context context) {
        this.dLo = new r(this);
        this.dLp = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.dLo, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.dLp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            hC(true);
            return;
        }
        this.handler.removeCallbacks(this.dLq);
        this.handler.postDelayed(this.dLq, 2000L);
    }

    public void hC(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().hD(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.mListeners.contains(aVar)) {
            this.mListeners.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.mListeners.contains(aVar)) {
            this.mListeners.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
        m411getInst.unregisterReceiver(this.dLo);
        m411getInst.getContentResolver().unregisterContentObserver(this.dLp);
        this.handler.removeCallbacks(this.dLq);
        dLn = null;
    }
}

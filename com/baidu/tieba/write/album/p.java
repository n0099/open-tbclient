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
    private static p dSM;
    private BroadcastReceiver dSN;
    private ContentObserver dSO;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable dSP = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void hM(boolean z);
    }

    public static p aKd() {
        if (dSM == null) {
            synchronized (p.class) {
                if (dSM == null) {
                    dSM = new p();
                    dSM.init(TbadkCoreApplication.m411getInst());
                }
            }
        }
        return dSM;
    }

    private p() {
    }

    private void init(Context context) {
        this.dSN = new r(this);
        this.dSO = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.dSN, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.dSO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            hL(true);
            return;
        }
        this.handler.removeCallbacks(this.dSP);
        this.handler.postDelayed(this.dSP, 2000L);
    }

    public void hL(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().hM(z);
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
        m411getInst.unregisterReceiver(this.dSN);
        m411getInst.getContentResolver().unregisterContentObserver(this.dSO);
        this.handler.removeCallbacks(this.dSP);
        dSM = null;
    }
}

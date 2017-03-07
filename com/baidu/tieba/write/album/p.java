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
    private static p fLR;
    private ContentObserver fLS;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jr = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable fLT = new q(this);

    /* loaded from: classes.dex */
    public interface a {
        void lH(boolean z);
    }

    public static p bmZ() {
        if (fLR == null) {
            synchronized (p.class) {
                if (fLR == null) {
                    fLR = new p();
                    fLR.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return fLR;
    }

    private p() {
    }

    private void init(Context context) {
        this.mReceiver = new r(this);
        this.fLS = new s(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.fLS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            lG(true);
            return;
        }
        this.handler.removeCallbacks(this.fLT);
        this.handler.postDelayed(this.fLT, 2000L);
    }

    public void lG(boolean z) {
        Iterator<a> it = this.jr.iterator();
        while (it.hasNext()) {
            it.next().lH(z);
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
        m9getInst.getContentResolver().unregisterContentObserver(this.fLS);
        this.handler.removeCallbacks(this.fLT);
        fLR = null;
    }
}

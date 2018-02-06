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
/* loaded from: classes2.dex */
public class f {
    private static f hFb;
    private ContentObserver hFc;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> sB = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable hFd = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nF(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void nG(boolean z);
    }

    public static f bGu() {
        if (hFb == null) {
            synchronized (f.class) {
                if (hFb == null) {
                    hFb = new f();
                    hFb.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return hFb;
    }

    private f() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.f.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                f.this.ae(intent);
            }
        };
        this.hFc = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.hFd);
                f.this.handler.postDelayed(f.this.hFd, 2000L);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.hFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nF(true);
            return;
        }
        this.handler.removeCallbacks(this.hFd);
        this.handler.postDelayed(this.hFd, 2000L);
    }

    public void nF(boolean z) {
        Iterator<a> it = this.sB.iterator();
        while (it.hasNext()) {
            it.next().nG(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.sB.contains(aVar)) {
            this.sB.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.sB.contains(aVar)) {
            this.sB.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.sB.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.mReceiver);
        inst.getContentResolver().unregisterContentObserver(this.hFc);
        this.handler.removeCallbacks(this.hFd);
        hFb = null;
    }
}

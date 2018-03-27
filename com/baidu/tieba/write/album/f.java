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
    private static f hFm;
    private ContentObserver hFn;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> sA = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable hFo = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nK(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void nL(boolean z);
    }

    public static f bGy() {
        if (hFm == null) {
            synchronized (f.class) {
                if (hFm == null) {
                    hFm = new f();
                    hFm.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return hFm;
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
        this.hFn = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.hFo);
                f.this.handler.postDelayed(f.this.hFo, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.hFn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nK(true);
            return;
        }
        this.handler.removeCallbacks(this.hFo);
        this.handler.postDelayed(this.hFo, 2000L);
    }

    public void nK(boolean z) {
        Iterator<a> it = this.sA.iterator();
        while (it.hasNext()) {
            it.next().nL(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.sA.contains(aVar)) {
            this.sA.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.sA.contains(aVar)) {
            this.sA.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.sA.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.mReceiver);
        inst.getContentResolver().unregisterContentObserver(this.hFn);
        this.handler.removeCallbacks(this.hFo);
        hFm = null;
    }
}

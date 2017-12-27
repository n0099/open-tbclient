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
    private static f hNC;
    private ContentObserver hND;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> sB = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable hNE = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.os(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void ot(boolean z);
    }

    public static f bMe() {
        if (hNC == null) {
            synchronized (f.class) {
                if (hNC == null) {
                    hNC = new f();
                    hNC.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return hNC;
    }

    private f() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.f.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                f.this.ah(intent);
            }
        };
        this.hND = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.hNE);
                f.this.handler.postDelayed(f.this.hNE, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.hND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            os(true);
            return;
        }
        this.handler.removeCallbacks(this.hNE);
        this.handler.postDelayed(this.hNE, 2000L);
    }

    public void os(boolean z) {
        Iterator<a> it = this.sB.iterator();
        while (it.hasNext()) {
            it.next().ot(z);
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
        inst.getContentResolver().unregisterContentObserver(this.hND);
        this.handler.removeCallbacks(this.hNE);
        hNC = null;
    }
}

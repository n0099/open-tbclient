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
    private static f gRY;
    private ContentObserver gRZ;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jq = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gSa = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nw(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void nx(boolean z);
    }

    public static f bDj() {
        if (gRY == null) {
            synchronized (f.class) {
                if (gRY == null) {
                    gRY = new f();
                    gRY.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return gRY;
    }

    private f() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.f.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                f.this.ab(intent);
            }
        };
        this.gRZ = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.gSa);
                f.this.handler.postDelayed(f.this.gSa, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gRZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nw(true);
            return;
        }
        this.handler.removeCallbacks(this.gSa);
        this.handler.postDelayed(this.gSa, 2000L);
    }

    public void nw(boolean z) {
        Iterator<a> it = this.jq.iterator();
        while (it.hasNext()) {
            it.next().nx(z);
        }
    }

    public void a(a aVar) {
        if (aVar != null && !this.jq.contains(aVar)) {
            this.jq.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.jq.contains(aVar)) {
            this.jq.remove(aVar);
        }
    }

    public void removeAllListeners() {
        this.jq.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.mReceiver);
        inst.getContentResolver().unregisterContentObserver(this.gRZ);
        this.handler.removeCallbacks(this.gSa);
        gRY = null;
    }
}

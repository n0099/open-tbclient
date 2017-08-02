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
public class f {
    private static f gzv;
    private ContentObserver gzw;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jr = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gzx = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nb(false);
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void nc(boolean z);
    }

    public static f byi() {
        if (gzv == null) {
            synchronized (f.class) {
                if (gzv == null) {
                    gzv = new f();
                    gzv.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return gzv;
    }

    private f() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.f.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                f.this.ad(intent);
            }
        };
        this.gzw = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.gzx);
                f.this.handler.postDelayed(f.this.gzx, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gzw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nb(true);
            return;
        }
        this.handler.removeCallbacks(this.gzx);
        this.handler.postDelayed(this.gzx, 2000L);
    }

    public void nb(boolean z) {
        Iterator<a> it = this.jr.iterator();
        while (it.hasNext()) {
            it.next().nc(z);
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
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.mReceiver);
        inst.getContentResolver().unregisterContentObserver(this.gzw);
        this.handler.removeCallbacks(this.gzx);
        gzv = null;
    }
}

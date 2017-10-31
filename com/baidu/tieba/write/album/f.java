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
    private static f gQQ;
    private ContentObserver gQR;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jq = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gQS = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.no(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void np(boolean z);
    }

    public static f bCX() {
        if (gQQ == null) {
            synchronized (f.class) {
                if (gQQ == null) {
                    gQQ = new f();
                    gQQ.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return gQQ;
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
        this.gQR = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.gQS);
                f.this.handler.postDelayed(f.this.gQS, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gQR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            no(true);
            return;
        }
        this.handler.removeCallbacks(this.gQS);
        this.handler.postDelayed(this.gQS, 2000L);
    }

    public void no(boolean z) {
        Iterator<a> it = this.jq.iterator();
        while (it.hasNext()) {
            it.next().np(z);
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
        inst.getContentResolver().unregisterContentObserver(this.gQR);
        this.handler.removeCallbacks(this.gQS);
        gQQ = null;
    }
}

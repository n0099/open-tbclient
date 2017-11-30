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
    private static f hcM;
    private ContentObserver hcN;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jq = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable hcO = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nX(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void nY(boolean z);
    }

    public static f bFK() {
        if (hcM == null) {
            synchronized (f.class) {
                if (hcM == null) {
                    hcM = new f();
                    hcM.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return hcM;
    }

    private f() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.f.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                f.this.ag(intent);
            }
        };
        this.hcN = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.hcO);
                f.this.handler.postDelayed(f.this.hcO, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.hcN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nX(true);
            return;
        }
        this.handler.removeCallbacks(this.hcO);
        this.handler.postDelayed(this.hcO, 2000L);
    }

    public void nX(boolean z) {
        Iterator<a> it = this.jq.iterator();
        while (it.hasNext()) {
            it.next().nY(z);
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
        inst.getContentResolver().unregisterContentObserver(this.hcN);
        this.handler.removeCallbacks(this.hcO);
        hcM = null;
    }
}

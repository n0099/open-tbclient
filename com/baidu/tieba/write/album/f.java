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
    private static f gGS;
    private ContentObserver gGT;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jq = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gGU = new Runnable() { // from class: com.baidu.tieba.write.album.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.nq(false);
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void nr(boolean z);
    }

    public static f bzz() {
        if (gGS == null) {
            synchronized (f.class) {
                if (gGS == null) {
                    gGS = new f();
                    gGS.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return gGS;
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
        this.gGT = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.f.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                f.this.handler.removeCallbacks(f.this.gGU);
                f.this.handler.postDelayed(f.this.gGU, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gGT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            nq(true);
            return;
        }
        this.handler.removeCallbacks(this.gGU);
        this.handler.postDelayed(this.gGU, 2000L);
    }

    public void nq(boolean z) {
        Iterator<a> it = this.jq.iterator();
        while (it.hasNext()) {
            it.next().nr(z);
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
        inst.getContentResolver().unregisterContentObserver(this.gGT);
        this.handler.removeCallbacks(this.gGU);
        gGS = null;
    }
}

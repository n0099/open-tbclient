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
/* loaded from: classes3.dex */
public class d {
    private static d jGj;
    private ContentObserver jGk;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable jGl = new Runnable() { // from class: com.baidu.tieba.write.album.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.rQ(false);
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void rR(boolean z);
    }

    public static d cxj() {
        if (jGj == null) {
            synchronized (d.class) {
                if (jGj == null) {
                    jGj = new d();
                    jGj.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return jGj;
    }

    private d() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.d.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                d.this.aB(intent);
            }
        };
        this.jGk = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.d.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                d.this.handler.removeCallbacks(d.this.jGl);
                d.this.handler.postDelayed(d.this.jGl, 2000L);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.jGk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            rQ(true);
            return;
        }
        this.handler.removeCallbacks(this.jGl);
        this.handler.postDelayed(this.jGl, 2000L);
    }

    public void rQ(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().rR(z);
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
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.mReceiver);
        inst.getContentResolver().unregisterContentObserver(this.jGk);
        this.handler.removeCallbacks(this.jGl);
        jGj = null;
    }
}

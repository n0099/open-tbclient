package com.baidu.tieba.write.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {
    private static d hSk;
    private ContentObserver hSl;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable hSm = new Runnable() { // from class: com.baidu.tieba.write.album.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ow(false);
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void ox(boolean z);
    }

    public static d bNM() {
        if (hSk == null) {
            synchronized (d.class) {
                if (hSk == null) {
                    hSk = new d();
                    hSk.init(TbadkCoreApplication.getInst());
                }
            }
        }
        return hSk;
    }

    private d() {
    }

    private void init(Context context) {
        this.mReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.write.album.d.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                d.this.ah(intent);
            }
        };
        this.hSl = new ContentObserver(this.mHandler) { // from class: com.baidu.tieba.write.album.d.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                d.this.handler.removeCallbacks(d.this.hSm);
                d.this.handler.postDelayed(d.this.hSm, SystemScreenshotManager.DELAY_TIME);
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
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.hSl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            ow(true);
            return;
        }
        this.handler.removeCallbacks(this.hSm);
        this.handler.postDelayed(this.hSm, SystemScreenshotManager.DELAY_TIME);
    }

    public void ow(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().ox(z);
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
        inst.getContentResolver().unregisterContentObserver(this.hSl);
        this.handler.removeCallbacks(this.hSm);
        hSk = null;
    }
}

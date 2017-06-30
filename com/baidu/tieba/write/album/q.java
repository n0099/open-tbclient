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
public class q {
    private static q gfj;
    private ContentObserver gfk;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> jr = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable gfl = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void mw(boolean z);
    }

    public static q bsr() {
        if (gfj == null) {
            synchronized (q.class) {
                if (gfj == null) {
                    gfj = new q();
                    gfj.init(TbadkCoreApplication.m9getInst());
                }
            }
        }
        return gfj;
    }

    private q() {
    }

    private void init(Context context) {
        this.mReceiver = new s(this);
        this.gfk = new t(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.gfk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            mv(true);
            return;
        }
        this.handler.removeCallbacks(this.gfl);
        this.handler.postDelayed(this.gfl, 2000L);
    }

    public void mv(boolean z) {
        Iterator<a> it = this.jr.iterator();
        while (it.hasNext()) {
            it.next().mw(z);
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
        TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
        m9getInst.unregisterReceiver(this.mReceiver);
        m9getInst.getContentResolver().unregisterContentObserver(this.gfk);
        this.handler.removeCallbacks(this.gfl);
        gfj = null;
    }
}

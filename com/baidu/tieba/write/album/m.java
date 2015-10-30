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
public class m {
    private static m dkz;
    private BroadcastReceiver dkA;
    private ContentObserver dkB;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<a> mListeners = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable dkC = new n(this);

    /* loaded from: classes.dex */
    public interface a {
        void gS(boolean z);
    }

    public static m aBv() {
        if (dkz == null) {
            dkz = new m();
            dkz.init(TbadkCoreApplication.m411getInst());
        }
        return dkz;
    }

    private m() {
    }

    private void init(Context context) {
        this.dkA = new o(this);
        this.dkB = new p(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.dkA, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.dkB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            gR(true);
            return;
        }
        this.handler.removeCallbacks(this.dkC);
        this.handler.postDelayed(this.dkC, 2000L);
    }

    public void gR(boolean z) {
        Iterator<a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().gS(z);
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
        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
        m411getInst.unregisterReceiver(this.dkA);
        m411getInst.getContentResolver().unregisterContentObserver(this.dkB);
        dkz = null;
    }
}

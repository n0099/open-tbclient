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
    private static q cyD;
    private ContentObserver cyE;
    private BroadcastReceiver mReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<u> lE = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable cyF = new r(this);

    public static q arU() {
        if (cyD == null) {
            cyD = new q();
            cyD.init(TbadkCoreApplication.m411getInst());
        }
        return cyD;
    }

    private q() {
    }

    private void init(Context context) {
        this.mReceiver = new s(this);
        this.cyE = new t(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.mReceiver, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.cyE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            fw(true);
            return;
        }
        this.handler.removeCallbacks(this.cyF);
        this.handler.postDelayed(this.cyF, 2000L);
    }

    public void fw(boolean z) {
        Iterator<u> it = this.lE.iterator();
        while (it.hasNext()) {
            it.next().fx(z);
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.lE.contains(uVar)) {
            this.lE.add(uVar);
        }
    }

    public void b(u uVar) {
        if (this.lE.contains(uVar)) {
            this.lE.remove(uVar);
        }
    }

    public void removeAllListeners() {
        this.lE.clear();
    }

    public void destory() {
        removeAllListeners();
        TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
        m411getInst.unregisterReceiver(this.mReceiver);
        m411getInst.getContentResolver().unregisterContentObserver(this.cyE);
        cyD = null;
    }
}

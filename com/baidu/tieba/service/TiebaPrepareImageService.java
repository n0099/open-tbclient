package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends Service {
    public static volatile boolean a = false;
    private int f;
    private int b = 0;
    private Uri c = null;
    private m d = null;
    private Handler e = new Handler();
    private Runnable g = new l(this);

    public static void a(int i, Uri uri, int i2) {
        Intent intent = new Intent(TiebaApplication.b(), TiebaPrepareImageService.class);
        intent.putExtra("request_code", i);
        intent.putExtra("max_size", i2);
        intent.setData(uri);
        TiebaApplication.b().startService(intent);
    }

    public static void a() {
        TiebaApplication.b().stopService(new Intent(TiebaApplication.b(), TiebaPrepareImageService.class));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.a();
        }
        this.e.removeCallbacks(this.g);
        this.d = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            a(intent);
        }
    }

    private void a(Intent intent) {
        if (this.d != null) {
            this.d.a();
        }
        this.c = intent.getData();
        this.b = intent.getIntExtra("request_code", 0);
        this.f = intent.getIntExtra("max_size", 600);
        TiebaApplication.b().a((com.baidu.tieba.e) null);
        if (!a) {
            this.d = new m(this, this.b, this.c);
            this.d.execute(new Object[0]);
            return;
        }
        this.e.postDelayed(this.g, 1000L);
    }
}

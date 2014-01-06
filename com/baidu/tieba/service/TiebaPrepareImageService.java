package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class TiebaPrepareImageService extends Service {
    public static volatile boolean a = false;
    private int f;
    private int g;
    private int b = 0;
    private Uri c = null;
    private p d = null;
    private final Handler e = new Handler();
    private final Runnable h = new o(this);

    public static void a(int i, Uri uri, int i2, int i3) {
        Intent intent = new Intent(TiebaApplication.g(), TiebaPrepareImageService.class);
        intent.putExtra(SocialConstants.PARAM_REQUEST_CODE, i);
        intent.putExtra("max_size", i2);
        intent.putExtra("display_size", i3);
        intent.setData(uri);
        TiebaApplication.g().startService(intent);
    }

    public static void a(int i, Uri uri, int i2) {
        a(i, uri, i2, 0);
    }

    public static void a() {
        TiebaApplication.g().stopService(new Intent(TiebaApplication.g(), TiebaPrepareImageService.class));
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
            this.d.cancel();
        }
        this.e.removeCallbacks(this.h);
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
            this.d.cancel();
        }
        this.c = intent.getData();
        this.b = intent.getIntExtra(SocialConstants.PARAM_REQUEST_CODE, 0);
        this.f = intent.getIntExtra("max_size", 750);
        this.g = intent.getIntExtra("display_size", 0);
        TiebaApplication.g().a((com.baidu.tieba.j) null);
        if (!a) {
            this.d = new p(this, this.b, this.c);
            this.d.execute(new Object[0]);
            return;
        }
        this.e.postDelayed(this.h, 1000L);
    }
}

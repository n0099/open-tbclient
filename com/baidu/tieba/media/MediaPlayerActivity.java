package com.baidu.tieba.media;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.d.w;
import com.baidu.tieba.d.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MediaPlayerActivity extends Activity implements BVideoView.OnCompletionListener, BVideoView.OnErrorListener, BVideoView.OnInfoListener, BVideoView.OnPlayingBufferCacheListener, BVideoView.OnPreparedListener {
    private q j;
    private HandlerThread k;
    private a a = null;
    private t b = null;
    private n c = null;
    private String d = null;
    private AlertDialog e = null;
    private final int f = 0;
    private final Object g = new Object();
    private int h = 0;
    private PowerManager.WakeLock i = null;
    private r l = null;
    private ArrayList m = new ArrayList();
    private s n = s.PLAYER_IDLE;

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, MediaPlayerActivity.class);
        intent.setData(Uri.parse(str));
        intent.putExtra("init_network_info", w.c(activity));
        activity.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        g();
        c();
        d();
        e();
        j();
    }

    private void c() {
        this.k = new HandlerThread("event handler thread", 10);
        this.k.start();
        this.j = new q(this, this.k.getLooper());
    }

    private void d() {
        this.b = new t(this);
        this.a = new a(this);
        this.b.a();
    }

    private void e() {
        this.c = new n();
        this.c.a();
    }

    private void f() {
        z zVar = (z) getIntent().getSerializableExtra("init_network_info");
        if (zVar != null) {
            this.m.add(zVar);
        }
    }

    private void g() {
        Uri data = getIntent().getData();
        if (data != null) {
            String scheme = data.getScheme();
            if (scheme != null && (scheme.equals("http") || scheme.equals("https") || scheme.equals("rtsp") || scheme.equals("bdhd"))) {
                this.d = data.toString();
            } else {
                this.d = data.getPath();
            }
        }
    }

    private void h() {
        if (this.i == null) {
            this.i = ((PowerManager) getSystemService("power")).newWakeLock(10, getClass().getCanonicalName());
            this.i.acquire();
        }
    }

    private void i() {
        if (this.i != null) {
            if (this.i.isHeld()) {
                this.i.release();
            }
            this.i = null;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        a();
    }

    public void a() {
        if (this.n == s.PLAYER_PREPARED) {
            this.h = this.b.c();
            com.baidu.adp.lib.e.b.d("onPause:stopPlayback, mLastPos=" + this.h);
        }
        this.b.d();
        this.c.b();
        i();
    }

    public void b() {
        h();
        this.j.sendEmptyMessage(0);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.baidu.adp.lib.e.b.d("onStop");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.e.b.d("onDestroy");
        this.c.c();
        if (this.k != null && this.k.isAlive()) {
            this.k.quit();
        }
        k();
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnInfoListener
    public boolean onInfo(int i, int i2) {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnErrorListener
    public boolean onError(int i, int i2) {
        com.baidu.adp.lib.e.b.d("onError");
        if (this.c.b(this.d)) {
            this.c.b();
        }
        this.n = s.PLAYER_IDLE;
        synchronized (this.g) {
            this.g.notify();
        }
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnCompletionListener
    public void onCompletion() {
        int b = this.b.b();
        int c = this.b.c();
        if (this.c.b(this.d)) {
            this.c.b();
        }
        com.baidu.adp.lib.e.b.d("onCompletion" + b + c);
        this.n = s.PLAYER_IDLE;
        synchronized (this.g) {
            this.g.notify();
            com.baidu.adp.lib.e.b.d("notify status to idle");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPreparedListener
    public void onPrepared() {
        com.baidu.adp.lib.e.b.d("onPrepared");
        this.n = s.PLAYER_PREPARED;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPlayingBufferCacheListener
    public void onPlayingBufferCache(int i) {
        com.baidu.adp.lib.e.b.d("cache percent:" + i);
    }

    private void j() {
        this.l = new r(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.l, intentFilter);
    }

    private void k() {
        if (this.l != null) {
            unregisterReceiver(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogInterface.OnClickListener l() {
        return new o(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogInterface.OnClickListener m() {
        return new p(this);
    }
}

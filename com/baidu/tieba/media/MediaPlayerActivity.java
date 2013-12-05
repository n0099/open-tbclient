package com.baidu.tieba.media;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MediaPlayerActivity extends Activity implements BVideoView.OnCompletionListener, BVideoView.OnErrorListener, BVideoView.OnInfoListener, BVideoView.OnPlayingBufferCacheListener, BVideoView.OnPreparedListener {
    private f j;
    private HandlerThread k;

    /* renamed from: a  reason: collision with root package name */
    private a f1926a = null;
    private h b = null;
    private c c = null;
    private String d = null;
    private AlertDialog e = null;
    private final int f = 0;
    private final Object g = new Object();
    private int h = 0;
    private PowerManager.WakeLock i = null;
    private g l = null;
    private ArrayList<UtilHelper.NetworkStateInfo> m = new ArrayList<>();
    private PLAYER_STATUS n = PLAYER_STATUS.PLAYER_IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PLAYER_STATUS {
        PLAYER_IDLE,
        PLAYER_PREPARING,
        PLAYER_PREPARED
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            f();
            g();
            c();
            d();
            e();
            j();
        } catch (NullPointerException e) {
            com.baidu.adp.lib.h.g.a((Context) this, (int) R.string.error_play);
            finish();
        }
    }

    private void c() {
        this.k = new HandlerThread("event handler thread", 10);
        this.k.start();
        this.j = new f(this, this.k.getLooper());
    }

    private void d() {
        this.b = new h(this);
        this.f1926a = new a(this);
        this.b.a();
    }

    private void e() {
        this.c = new c();
        this.c.a();
    }

    private void f() {
        UtilHelper.NetworkStateInfo networkStateInfo = (UtilHelper.NetworkStateInfo) getIntent().getSerializableExtra("init_network_info");
        if (networkStateInfo != null) {
            this.m.add(networkStateInfo);
        }
    }

    private void g() {
        Uri data = getIntent().getData();
        if (data != null) {
            String scheme = data.getScheme();
            if (scheme != null && (scheme.equals("http") || scheme.equals("https") || scheme.equals("rtsp") || scheme.equals("bdhd") || scheme.equals("ed2k"))) {
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
        if (this.n == PLAYER_STATUS.PLAYER_PREPARED) {
            this.h = this.b.c();
            com.baidu.adp.lib.h.e.e("onPause:stopPlayback, mLastPos=" + this.h);
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
        com.baidu.adp.lib.h.e.e("onStop");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.e.e("onDestroy");
        if (this.c != null) {
            this.c.c();
        }
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
        com.baidu.adp.lib.h.e.e("onError");
        if (this.c.b(this.d)) {
            this.c.b();
        }
        this.n = PLAYER_STATUS.PLAYER_IDLE;
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
        com.baidu.adp.lib.h.e.e("onCompletion" + b + "" + c);
        this.n = PLAYER_STATUS.PLAYER_IDLE;
        synchronized (this.g) {
            this.g.notify();
            com.baidu.adp.lib.h.e.e("notify status to idle");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPreparedListener
    public void onPrepared() {
        com.baidu.adp.lib.h.e.e("onPrepared");
        this.n = PLAYER_STATUS.PLAYER_PREPARED;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPlayingBufferCacheListener
    public void onPlayingBufferCache(int i) {
        com.baidu.adp.lib.h.e.e("cache percent:" + i);
    }

    private void j() {
        this.l = new g(this, null);
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
        return new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogInterface.OnClickListener m() {
        return new e(this);
    }
}

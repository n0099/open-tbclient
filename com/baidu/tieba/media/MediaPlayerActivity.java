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
import android.widget.Toast;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MediaPlayerActivity extends Activity implements BVideoView.OnCompletionListener, BVideoView.OnErrorListener, BVideoView.OnInfoListener, BVideoView.OnPlayingBufferCacheListener, BVideoView.OnPreparedListener {
    private o j;
    private HandlerThread k;

    /* renamed from: a  reason: collision with root package name */
    private a f1331a = null;
    private q b = null;
    private l c = null;
    private String d = null;
    private AlertDialog e = null;
    private final int f = 0;
    private final Object g = new Object();
    private int h = 0;
    private PowerManager.WakeLock i = null;
    private p l = null;
    private ArrayList<UtilHelper.NetworkStateInfo> m = new ArrayList<>();
    private PLAYER_STATUS n = PLAYER_STATUS.PLAYER_IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PLAYER_STATUS {
        PLAYER_IDLE,
        PLAYER_PREPARING,
        PLAYER_PREPARED;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PLAYER_STATUS[] valuesCustom() {
            PLAYER_STATUS[] valuesCustom = values();
            int length = valuesCustom.length;
            PLAYER_STATUS[] player_statusArr = new PLAYER_STATUS[length];
            System.arraycopy(valuesCustom, 0, player_statusArr, 0, length);
            return player_statusArr;
        }
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, MediaPlayerActivity.class);
        intent.setData(Uri.parse(str));
        intent.putExtra("init_network_info", UtilHelper.i(activity));
        activity.startActivity(intent);
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
            Toast.makeText(this, (int) R.string.error_play, 0).show();
            finish();
        }
    }

    private void c() {
        this.k = new HandlerThread("event handler thread", 10);
        this.k.start();
        this.j = new o(this, this.k.getLooper());
    }

    private void d() {
        this.b = new q(this);
        this.f1331a = new a(this);
        this.b.a();
    }

    private void e() {
        this.c = new l();
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
            com.baidu.adp.lib.f.d.d("onPause:stopPlayback, mLastPos=" + this.h);
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
        com.baidu.adp.lib.f.d.d("onStop");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.f.d.d("onDestroy");
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
        com.baidu.adp.lib.f.d.d("onError");
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
        com.baidu.adp.lib.f.d.d("onCompletion" + b + c);
        this.n = PLAYER_STATUS.PLAYER_IDLE;
        synchronized (this.g) {
            this.g.notify();
            com.baidu.adp.lib.f.d.d("notify status to idle");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPreparedListener
    public void onPrepared() {
        com.baidu.adp.lib.f.d.d("onPrepared");
        this.n = PLAYER_STATUS.PLAYER_PREPARED;
    }

    @Override // com.baidu.cyberplayer.sdk.BVideoView.OnPlayingBufferCacheListener
    public void onPlayingBufferCache(int i) {
        com.baidu.adp.lib.f.d.d("cache percent:" + i);
    }

    private void j() {
        this.l = new p(this, null);
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
        return new m(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogInterface.OnClickListener m() {
        return new n(this);
    }
}

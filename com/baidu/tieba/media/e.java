package com.baidu.tieba.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
import com.baidu.cyberplayer.sdk.BEngineManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.w;
import com.baidu.tieba.d.z;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class e {
    private static final String[] l = {"RET_NEW_PACKAGE_INSTALLED", "RET_NO_NEW_PACKAGE", "RET_STOPPED", "RET_CANCELED", "RET_FAILED_STORAGE_IO", "RET_FAILED_NETWORK", "RET_FAILED_ALREADY_RUNNING", "RET_FAILED_OTHERS", "RET_FAILED_ALREADY_INSTALLED", "RET_FAILED_INVALID_APK"};
    private a a;
    private Activity b;
    private BEngineManager.OnEngineListener c = null;
    private DialogInterface.OnClickListener d = null;
    private DialogInterface.OnClickListener e = null;
    private Handler f = new f(this);
    private m g = m.STOP;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private String k = null;

    public e(Activity activity) {
        this.a = null;
        this.b = null;
        if (activity == null) {
            throw new InvalidParameterException("MediaPlayerHelper activity is null");
        }
        this.b = activity;
        this.a = new a(this.b);
        BCyberPlayerFactory.init(this.b);
    }

    private DialogInterface.OnClickListener b() {
        if (this.d == null) {
            this.d = new g(this);
        }
        return this.d;
    }

    private DialogInterface.OnClickListener c() {
        if (this.e == null) {
            this.e = new h(this);
        }
        return this.e;
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            if (!TiebaApplication.aT()) {
                this.a.b();
                return;
            }
            this.k = str;
            z c = w.c(this.b);
            if (e()) {
                if (c == z.WIFI) {
                    d();
                } else if (c == z.TwoG) {
                    this.a.a(b());
                } else if (c == z.ThreeG) {
                    this.a.b(b());
                } else {
                    this.a.a();
                }
            } else if (c == z.WIFI) {
                this.a.c(c());
            } else if (c == z.TwoG) {
                this.a.d(c());
            } else if (c == z.ThreeG) {
                this.a.e(c());
            } else {
                this.a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k != null && this.k.length() > 0) {
            MediaPlayerActivity.a(this.b, this.k);
        }
    }

    private boolean e() {
        return BCyberPlayerFactory.createEngineManager().EngineInstalled();
    }

    private void f() {
        this.h = new i(this);
        this.i = new j(this);
        this.j = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = i;
        message.arg2 = i2;
        if (this.f.hasMessages(0)) {
            this.f.removeMessages(0);
        }
        this.f.sendMessageAtFrontOfQueue(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        this.f.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        f();
        this.a.a(this.h, this.j);
        BEngineManager createEngineManager = BCyberPlayerFactory.createEngineManager();
        if (this.c == null) {
            this.c = new l(this);
        }
        this.g = m.DOWNLOADING;
        createEngineManager.installAsync(this.c);
    }
}

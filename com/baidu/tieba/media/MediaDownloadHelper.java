package com.baidu.tieba.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.cyberplayer.sdk.BCyberPlayerFactory;
import com.baidu.cyberplayer.sdk.BEngineManager;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class MediaDownloadHelper {
    private static final String[] l = {"RET_NEW_PACKAGE_INSTALLED", "RET_NO_NEW_PACKAGE", "RET_STOPPED", "RET_CANCELED", "RET_FAILED_STORAGE_IO", "RET_FAILED_NETWORK", "RET_FAILED_ALREADY_RUNNING", "RET_FAILED_OTHERS", "RET_FAILED_ALREADY_INSTALLED", "RET_FAILED_INVALID_APK"};

    /* renamed from: a  reason: collision with root package name */
    private a f1329a;
    private Activity b;
    private BEngineManager.OnEngineListener c = null;
    private DialogInterface.OnClickListener d = null;
    private DialogInterface.OnClickListener e = null;
    private Handler f = new e(this);
    private DOWNLOAD_STAT g = DOWNLOAD_STAT.STOP;
    private View.OnClickListener h = null;
    private View.OnClickListener i = null;
    private View.OnClickListener j = null;
    private String k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum DOWNLOAD_STAT {
        DOWNLOADING,
        PAUSE,
        STOP;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DOWNLOAD_STAT[] valuesCustom() {
            DOWNLOAD_STAT[] valuesCustom = values();
            int length = valuesCustom.length;
            DOWNLOAD_STAT[] download_statArr = new DOWNLOAD_STAT[length];
            System.arraycopy(valuesCustom, 0, download_statArr, 0, length);
            return download_statArr;
        }
    }

    public MediaDownloadHelper(Activity activity) {
        this.f1329a = null;
        this.b = null;
        if (activity == null) {
            throw new InvalidParameterException("MediaPlayerHelper activity is null");
        }
        this.b = activity;
        this.f1329a = new a(this.b);
        BCyberPlayerFactory.init(this.b);
    }

    private DialogInterface.OnClickListener b() {
        if (this.d == null) {
            this.d = new f(this);
        }
        return this.d;
    }

    private DialogInterface.OnClickListener c() {
        if (this.e == null) {
            this.e = new g(this);
        }
        return this.e;
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            if (!TiebaApplication.aN()) {
                this.f1329a.b();
                return;
            }
            this.k = str;
            UtilHelper.NetworkStateInfo i = UtilHelper.i(this.b);
            if (e()) {
                if (i == UtilHelper.NetworkStateInfo.WIFI) {
                    d();
                } else if (i == UtilHelper.NetworkStateInfo.TwoG) {
                    this.f1329a.a(b());
                } else if (i == UtilHelper.NetworkStateInfo.ThreeG) {
                    this.f1329a.b(b());
                } else {
                    this.f1329a.a();
                }
            } else if (i == UtilHelper.NetworkStateInfo.WIFI) {
                this.f1329a.c(c());
            } else if (i == UtilHelper.NetworkStateInfo.TwoG) {
                this.f1329a.d(c());
            } else if (i == UtilHelper.NetworkStateInfo.ThreeG) {
                this.f1329a.e(c());
            } else {
                this.f1329a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k != null && this.k.length() > 0) {
            MediaPlayerActivity.a(this.b, this.k);
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.b, "baidu_video", "play", 1);
            }
        }
    }

    private boolean e() {
        return BCyberPlayerFactory.createEngineManager().EngineInstalled();
    }

    private void f() {
        this.h = new h(this);
        this.i = new i(this);
        this.j = new j(this);
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
        this.f1329a.a(this.h, this.j);
        BEngineManager createEngineManager = BCyberPlayerFactory.createEngineManager();
        if (this.c == null) {
            this.c = new k(this);
        }
        this.g = DOWNLOAD_STAT.DOWNLOADING;
        createEngineManager.installAsync(this.c);
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.b, "baidu_video", "install", 1);
        }
    }
}

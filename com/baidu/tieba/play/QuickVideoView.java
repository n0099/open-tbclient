package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.f;
import java.net.URI;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static g fyo;
    private Map<String, String> AN;
    private f.d aTA;
    private f.b aTB;
    private f.c aTC;
    private f.a aTz;
    private b bFV;
    private f.a fyA;
    private f.b fyB;
    private b.InterfaceC0116b fyC;
    private n fyl;
    private String fym;
    private f fyn;
    private boolean fyp;
    private a fyq;
    private boolean fyr;
    private int fys;
    private boolean fyt;
    private int fyu;
    private boolean fyv;
    private SurfaceTexture fyw;
    private boolean fyx;
    private TextureView.SurfaceTextureListener fyy;
    private f.d fyz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bfB();

        i getMediaProgressObserver();

        String hs(String str);

        void onCompletion();

        void onPause();

        void onPrepared();

        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fyx = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fyo = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fyp = false;
        this.fyr = false;
        this.fys = 0;
        this.fyt = false;
        this.fyu = -1;
        this.fyv = false;
        this.fyw = null;
        this.fyx = true;
        this.fyy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fyr) {
                    QuickVideoView.this.fyr = false;
                    if (QuickVideoView.this.fyn != null) {
                        QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fyn != null && QuickVideoView.this.fyv) {
                    QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.fyu);
                }
                QuickVideoView.this.fyw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fyn != null) {
                    QuickVideoView.this.fyn.release();
                }
                if (!QuickVideoView.this.fyr) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onStop();
                    }
                    if (QuickVideoView.this.bFV != null) {
                        QuickVideoView.this.bFV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fyw = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fyz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aTA != null) {
                    QuickVideoView.this.aTA.onPrepared(fVar);
                }
                if (QuickVideoView.this.fyq != null) {
                    QuickVideoView.this.fyq.onPrepared();
                }
                if (QuickVideoView.this.fyp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fyl != null && fVar != null) {
                    QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fym)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fym).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fym;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fyA = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fyt || QuickVideoView.this.fyq == null) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onCompletion();
                    }
                    QuickVideoView.this.fyp = false;
                    if (QuickVideoView.this.aTz != null) {
                        QuickVideoView.this.aTz.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fyq.bfB());
                QuickVideoView.this.start();
            }
        };
        this.fyB = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aTB == null || QuickVideoView.this.aTB.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aTC = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fys = i2;
                    if (QuickVideoView.this.fyl != null && fVar != null) {
                        QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fyC = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aTB != null) {
                            QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fym = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aTB != null) {
                        QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyp = false;
        this.fyr = false;
        this.fys = 0;
        this.fyt = false;
        this.fyu = -1;
        this.fyv = false;
        this.fyw = null;
        this.fyx = true;
        this.fyy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fyr) {
                    QuickVideoView.this.fyr = false;
                    if (QuickVideoView.this.fyn != null) {
                        QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fyn != null && QuickVideoView.this.fyv) {
                    QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.fyu);
                }
                QuickVideoView.this.fyw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fyn != null) {
                    QuickVideoView.this.fyn.release();
                }
                if (!QuickVideoView.this.fyr) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onStop();
                    }
                    if (QuickVideoView.this.bFV != null) {
                        QuickVideoView.this.bFV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fyw = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fyz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aTA != null) {
                    QuickVideoView.this.aTA.onPrepared(fVar);
                }
                if (QuickVideoView.this.fyq != null) {
                    QuickVideoView.this.fyq.onPrepared();
                }
                if (QuickVideoView.this.fyp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fyl != null && fVar != null) {
                    QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fym)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fym).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fym;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fyA = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fyt || QuickVideoView.this.fyq == null) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onCompletion();
                    }
                    QuickVideoView.this.fyp = false;
                    if (QuickVideoView.this.aTz != null) {
                        QuickVideoView.this.aTz.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fyq.bfB());
                QuickVideoView.this.start();
            }
        };
        this.fyB = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aTB == null || QuickVideoView.this.aTB.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aTC = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fys = i2;
                    if (QuickVideoView.this.fyl != null && fVar != null) {
                        QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fyC = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aTB != null) {
                            QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fym = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aTB != null) {
                        QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyp = false;
        this.fyr = false;
        this.fys = 0;
        this.fyt = false;
        this.fyu = -1;
        this.fyv = false;
        this.fyw = null;
        this.fyx = true;
        this.fyy = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fyr) {
                    QuickVideoView.this.fyr = false;
                    if (QuickVideoView.this.fyn != null) {
                        QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fyn != null && QuickVideoView.this.fyv) {
                    QuickVideoView.this.fyn.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.AN, surfaceTexture, QuickVideoView.this.fyu);
                }
                QuickVideoView.this.fyw = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fyn != null) {
                    QuickVideoView.this.fyn.release();
                }
                if (!QuickVideoView.this.fyr) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onStop();
                    }
                    if (QuickVideoView.this.bFV != null) {
                        QuickVideoView.this.bFV.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fyw = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fyz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aTA != null) {
                    QuickVideoView.this.aTA.onPrepared(fVar);
                }
                if (QuickVideoView.this.fyq != null) {
                    QuickVideoView.this.fyq.onPrepared();
                }
                if (QuickVideoView.this.fyp) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fyl != null && fVar != null) {
                    QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fym)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fym).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fym;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fyA = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fyt || QuickVideoView.this.fyq == null) {
                    if (QuickVideoView.this.fyq != null) {
                        QuickVideoView.this.fyq.onCompletion();
                    }
                    QuickVideoView.this.fyp = false;
                    if (QuickVideoView.this.aTz != null) {
                        QuickVideoView.this.aTz.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fyq.bfB());
                QuickVideoView.this.start();
            }
        };
        this.fyB = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aTB == null || QuickVideoView.this.aTB.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aTC = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fys = i22;
                    if (QuickVideoView.this.fyl != null && fVar != null) {
                        QuickVideoView.this.fyl.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fys);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fyC = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aTB != null) {
                            QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fym = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aTB != null) {
                        QuickVideoView.this.aTB.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fyl = new n(context);
        this.fyl.setSurfaceTextureListener(this.fyy);
        if (fyo != null) {
            this.fyn = fyo.JV();
        }
        if (this.fyn != null) {
            this.fyn.setOnPreparedListener(this.fyz);
            this.fyn.setOnCompletionListener(this.fyA);
            this.fyn.setOnErrorListener(this.fyB);
            this.fyn.a(this.aTC);
        }
        ai.k(this, d.e.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(10, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void setVideoPath(String str) {
        if (this.fyq != null) {
            str = this.fyq.hs(str);
            if (this.fyq.getMediaProgressObserver() != null) {
                this.fyq.getMediaProgressObserver().setPlayer(this);
            }
        }
        if (!al.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        bfy();
        this.fyr = true;
        this.mUri = uri;
        this.AN = map;
        this.fys = 0;
        removeView(this.fyl);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fyx) {
            addView(this.fyl, layoutParams);
        } else {
            addView(this.fyl, 0, layoutParams);
        }
        ai.k(this, d.e.cp_bg_line_k);
    }

    private void bfy() {
        this.fyr = false;
        this.fyp = false;
        if (this.fyn != null) {
            this.fyn.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void stopPlayback() {
        this.fym = null;
        bfy();
        this.fyt = false;
        if (this.fyq != null) {
            this.fyq.onStop();
        }
        com.baidu.tieba.play.a.b.bfR().a((b.InterfaceC0116b) null);
    }

    public void setOnPreparedListener(f.d dVar) {
        this.aTA = dVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aTz = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aTB = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fyp = true;
        if (this.fyn != null) {
            if (this.fyw != null && this.fyv && !this.fyn.isExistInRemote()) {
                this.fyn.a(this.mContext, this.mUri, this.AN, this.fyw, this.fyu);
                return;
            } else {
                this.fyn.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fyq != null) {
            this.fyq.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fyn != null) {
            this.fyn.pause();
        }
        if (this.fyq != null) {
            this.fyq.onPause();
        }
        this.fyp = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fyn != null) {
            return this.fyn.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fyn != null) {
            return this.fyn.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fyn != null) {
            this.fyn.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fyn != null) {
            return this.fyn.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fyn != null) {
            this.fyn.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fyu = i;
    }

    public int getRecoveryState() {
        return this.fyu;
    }

    public void setNeedRecovery(boolean z) {
        this.fyv = z;
    }

    public void setLooping(boolean z) {
        this.fyt = z;
    }

    public boolean bfz() {
        return this.fyp;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.bFV = bVar;
    }

    public void setBusiness(a aVar) {
        this.fyq = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fyt = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fyn;
    }

    private boolean bfA() {
        return (com.baidu.adp.lib.b.d.eW().af("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hh() || this.fyn == null || CustomPlayerSwitchStatic.bfo() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bfA() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bfR().a(this.fyC);
        return com.baidu.tieba.play.a.b.bfR().qF(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fyn == null || this.fyw == null) {
            this.fym = str;
            URI uri = new URI(this.mUri.toString());
            this.fyn.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.AN, this.fyw, this.mUri.getHost());
            start();
        }
    }
}

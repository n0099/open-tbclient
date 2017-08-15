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
    private static g fBt;
    private Map<String, String> Cp;
    private f.a aUM;
    private f.d aUN;
    private f.b aUO;
    private f.c aUP;
    private b bHO;
    private boolean fBA;
    private SurfaceTexture fBB;
    private boolean fBC;
    private TextureView.SurfaceTextureListener fBD;
    private f.d fBE;
    private f.a fBF;
    private f.b fBG;
    private b.InterfaceC0116b fBH;
    private n fBq;
    private String fBr;
    private f fBs;
    private boolean fBu;
    private a fBv;
    private boolean fBw;
    private int fBx;
    private boolean fBy;
    private int fBz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bgr();

        i getMediaProgressObserver();

        String hx(String str);

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
        this.fBC = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fBt = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fBu = false;
        this.fBw = false;
        this.fBx = 0;
        this.fBy = false;
        this.fBz = -1;
        this.fBA = false;
        this.fBB = null;
        this.fBC = true;
        this.fBD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.fBs != null) {
                        QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBs != null && QuickVideoView.this.fBA) {
                    QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBz);
                }
                QuickVideoView.this.fBB = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBs != null) {
                    QuickVideoView.this.fBs.release();
                }
                if (!QuickVideoView.this.fBw) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onStop();
                    }
                    if (QuickVideoView.this.bHO != null) {
                        QuickVideoView.this.bHO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBB = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBE = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUN != null) {
                    QuickVideoView.this.aUN.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBv != null) {
                    QuickVideoView.this.fBv.onPrepared();
                }
                if (QuickVideoView.this.fBu) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBq != null && fVar != null) {
                    QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBr)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBr).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBr;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBF = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBy || QuickVideoView.this.fBv == null) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onCompletion();
                    }
                    QuickVideoView.this.fBu = false;
                    if (QuickVideoView.this.aUM != null) {
                        QuickVideoView.this.aUM.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBv.bgr());
                QuickVideoView.this.start();
            }
        };
        this.fBG = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUO == null || QuickVideoView.this.aUO.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUP = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fBx = i2;
                    if (QuickVideoView.this.fBq != null && fVar != null) {
                        QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBH = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bU(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUO != null) {
                            QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBr = null;
                    } else {
                        QuickVideoView.this.bT(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUO != null) {
                        QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBu = false;
        this.fBw = false;
        this.fBx = 0;
        this.fBy = false;
        this.fBz = -1;
        this.fBA = false;
        this.fBB = null;
        this.fBC = true;
        this.fBD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.fBs != null) {
                        QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBs != null && QuickVideoView.this.fBA) {
                    QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBz);
                }
                QuickVideoView.this.fBB = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBs != null) {
                    QuickVideoView.this.fBs.release();
                }
                if (!QuickVideoView.this.fBw) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onStop();
                    }
                    if (QuickVideoView.this.bHO != null) {
                        QuickVideoView.this.bHO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBB = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBE = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUN != null) {
                    QuickVideoView.this.aUN.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBv != null) {
                    QuickVideoView.this.fBv.onPrepared();
                }
                if (QuickVideoView.this.fBu) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBq != null && fVar != null) {
                    QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBr)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBr).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBr;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBF = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBy || QuickVideoView.this.fBv == null) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onCompletion();
                    }
                    QuickVideoView.this.fBu = false;
                    if (QuickVideoView.this.aUM != null) {
                        QuickVideoView.this.aUM.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBv.bgr());
                QuickVideoView.this.start();
            }
        };
        this.fBG = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUO == null || QuickVideoView.this.aUO.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUP = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fBx = i2;
                    if (QuickVideoView.this.fBq != null && fVar != null) {
                        QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBH = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bU(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUO != null) {
                            QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBr = null;
                    } else {
                        QuickVideoView.this.bT(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUO != null) {
                        QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBu = false;
        this.fBw = false;
        this.fBx = 0;
        this.fBy = false;
        this.fBz = -1;
        this.fBA = false;
        this.fBB = null;
        this.fBC = true;
        this.fBD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.fBs != null) {
                        QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBs != null && QuickVideoView.this.fBA) {
                    QuickVideoView.this.fBs.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBz);
                }
                QuickVideoView.this.fBB = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBs != null) {
                    QuickVideoView.this.fBs.release();
                }
                if (!QuickVideoView.this.fBw) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onStop();
                    }
                    if (QuickVideoView.this.bHO != null) {
                        QuickVideoView.this.bHO.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBB = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBE = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUN != null) {
                    QuickVideoView.this.aUN.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBv != null) {
                    QuickVideoView.this.fBv.onPrepared();
                }
                if (QuickVideoView.this.fBu) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBq != null && fVar != null) {
                    QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBr)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBr).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBr;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBF = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBy || QuickVideoView.this.fBv == null) {
                    if (QuickVideoView.this.fBv != null) {
                        QuickVideoView.this.fBv.onCompletion();
                    }
                    QuickVideoView.this.fBu = false;
                    if (QuickVideoView.this.aUM != null) {
                        QuickVideoView.this.aUM.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBv.bgr());
                QuickVideoView.this.start();
            }
        };
        this.fBG = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aUO == null || QuickVideoView.this.aUO.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aUP = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fBx = i22;
                    if (QuickVideoView.this.fBq != null && fVar != null) {
                        QuickVideoView.this.fBq.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBx);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBH = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bU(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUO != null) {
                            QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBr = null;
                    } else {
                        QuickVideoView.this.bT(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUO != null) {
                        QuickVideoView.this.aUO.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fBq = new n(context);
        this.fBq.setSurfaceTextureListener(this.fBD);
        if (fBt != null) {
            this.fBs = fBt.Kb();
        }
        if (this.fBs != null) {
            this.fBs.setOnPreparedListener(this.fBE);
            this.fBs.setOnCompletionListener(this.fBF);
            this.fBs.setOnErrorListener(this.fBG);
            this.fBs.a(this.aUP);
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
        if (this.fBv != null) {
            str = this.fBv.hx(str);
            if (this.fBv.getMediaProgressObserver() != null) {
                this.fBv.getMediaProgressObserver().setPlayer(this);
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
        bgo();
        this.fBw = true;
        this.mUri = uri;
        this.Cp = map;
        this.fBx = 0;
        removeView(this.fBq);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fBC) {
            addView(this.fBq, layoutParams);
        } else {
            addView(this.fBq, 0, layoutParams);
        }
        ai.k(this, d.e.cp_bg_line_k);
    }

    private void bgo() {
        this.fBw = false;
        this.fBu = false;
        if (this.fBs != null) {
            this.fBs.release();
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
        this.fBr = null;
        bgo();
        this.fBy = false;
        if (this.fBv != null) {
            this.fBv.onStop();
        }
        com.baidu.tieba.play.a.b.bgH().a((b.InterfaceC0116b) null);
    }

    public void setOnPreparedListener(f.d dVar) {
        this.aUN = dVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aUM = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aUO = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fBu = true;
        if (this.fBs != null) {
            if (this.fBB != null && this.fBA && !this.fBs.isExistInRemote()) {
                this.fBs.a(this.mContext, this.mUri, this.Cp, this.fBB, this.fBz);
                return;
            } else {
                this.fBs.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fBv != null) {
            this.fBv.onStart();
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
        if (this.fBs != null) {
            this.fBs.pause();
        }
        if (this.fBv != null) {
            this.fBv.onPause();
        }
        this.fBu = false;
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
        if (this.fBs != null) {
            return this.fBs.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fBs != null) {
            return this.fBs.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fBs != null) {
            this.fBs.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fBs != null) {
            return this.fBs.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fBs != null) {
            this.fBs.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fBz = i;
    }

    public int getRecoveryState() {
        return this.fBz;
    }

    public void setNeedRecovery(boolean z) {
        this.fBA = z;
    }

    public void setLooping(boolean z) {
        this.fBy = z;
    }

    public boolean bgp() {
        return this.fBu;
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
        this.bHO = bVar;
    }

    public void setBusiness(a aVar) {
        this.fBv = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fBy = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fBs;
    }

    private boolean bgq() {
        return (com.baidu.adp.lib.b.d.fh().al("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hr() || this.fBs == null || CustomPlayerSwitchStatic.bge() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bgq() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bgH().a(this.fBH);
        return com.baidu.tieba.play.a.b.bgH().qM(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fBs == null || this.fBB == null) {
            this.fBr = str;
            URI uri = new URI(this.mUri.toString());
            this.fBs.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Cp, this.fBB, this.mUri.getHost());
            start();
        }
    }
}

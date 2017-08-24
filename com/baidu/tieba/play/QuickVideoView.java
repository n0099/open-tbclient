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
    private static g fBv;
    private Map<String, String> Cp;
    private f.a aUN;
    private f.d aUO;
    private f.b aUP;
    private f.c aUQ;
    private b bHP;
    private boolean fBA;
    private int fBB;
    private boolean fBC;
    private SurfaceTexture fBD;
    private boolean fBE;
    private TextureView.SurfaceTextureListener fBF;
    private f.d fBG;
    private f.a fBH;
    private f.b fBI;
    private b.InterfaceC0116b fBJ;
    private n fBs;
    private String fBt;
    private f fBu;
    private boolean fBw;
    private a fBx;
    private boolean fBy;
    private int fBz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bgm();

        i getMediaProgressObserver();

        String hA(String str);

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
        this.fBE = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fBv = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fBw = false;
        this.fBy = false;
        this.fBz = 0;
        this.fBA = false;
        this.fBB = -1;
        this.fBC = false;
        this.fBD = null;
        this.fBE = true;
        this.fBF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fBy) {
                    QuickVideoView.this.fBy = false;
                    if (QuickVideoView.this.fBu != null) {
                        QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBu != null && QuickVideoView.this.fBC) {
                    QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBB);
                }
                QuickVideoView.this.fBD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBu != null) {
                    QuickVideoView.this.fBu.release();
                }
                if (!QuickVideoView.this.fBy) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onStop();
                    }
                    if (QuickVideoView.this.bHP != null) {
                        QuickVideoView.this.bHP.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBD = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBG = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUO != null) {
                    QuickVideoView.this.aUO.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBx != null) {
                    QuickVideoView.this.fBx.onPrepared();
                }
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBs != null && fVar != null) {
                    QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBt)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBt).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBt;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBH = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBA || QuickVideoView.this.fBx == null) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onCompletion();
                    }
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBx.bgm());
                QuickVideoView.this.start();
            }
        };
        this.fBI = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUP == null || QuickVideoView.this.aUP.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUQ = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fBz = i2;
                    if (QuickVideoView.this.fBs != null && fVar != null) {
                        QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBJ = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUP != null) {
                            QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBt = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUP != null) {
                        QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBw = false;
        this.fBy = false;
        this.fBz = 0;
        this.fBA = false;
        this.fBB = -1;
        this.fBC = false;
        this.fBD = null;
        this.fBE = true;
        this.fBF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fBy) {
                    QuickVideoView.this.fBy = false;
                    if (QuickVideoView.this.fBu != null) {
                        QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBu != null && QuickVideoView.this.fBC) {
                    QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBB);
                }
                QuickVideoView.this.fBD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBu != null) {
                    QuickVideoView.this.fBu.release();
                }
                if (!QuickVideoView.this.fBy) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onStop();
                    }
                    if (QuickVideoView.this.bHP != null) {
                        QuickVideoView.this.bHP.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBD = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBG = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUO != null) {
                    QuickVideoView.this.aUO.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBx != null) {
                    QuickVideoView.this.fBx.onPrepared();
                }
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBs != null && fVar != null) {
                    QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBt)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBt).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBt;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBH = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBA || QuickVideoView.this.fBx == null) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onCompletion();
                    }
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBx.bgm());
                QuickVideoView.this.start();
            }
        };
        this.fBI = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUP == null || QuickVideoView.this.aUP.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUQ = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fBz = i2;
                    if (QuickVideoView.this.fBs != null && fVar != null) {
                        QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBJ = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUP != null) {
                            QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBt = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUP != null) {
                        QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBw = false;
        this.fBy = false;
        this.fBz = 0;
        this.fBA = false;
        this.fBB = -1;
        this.fBC = false;
        this.fBD = null;
        this.fBE = true;
        this.fBF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fBy) {
                    QuickVideoView.this.fBy = false;
                    if (QuickVideoView.this.fBu != null) {
                        QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fBu != null && QuickVideoView.this.fBC) {
                    QuickVideoView.this.fBu.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cp, surfaceTexture, QuickVideoView.this.fBB);
                }
                QuickVideoView.this.fBD = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fBu != null) {
                    QuickVideoView.this.fBu.release();
                }
                if (!QuickVideoView.this.fBy) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onStop();
                    }
                    if (QuickVideoView.this.bHP != null) {
                        QuickVideoView.this.bHP.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fBD = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBG = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUO != null) {
                    QuickVideoView.this.aUO.onPrepared(fVar);
                }
                if (QuickVideoView.this.fBx != null) {
                    QuickVideoView.this.fBx.onPrepared();
                }
                if (QuickVideoView.this.fBw) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fBs != null && fVar != null) {
                    QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fBt)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fBt).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fBt;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBH = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fBA || QuickVideoView.this.fBx == null) {
                    if (QuickVideoView.this.fBx != null) {
                        QuickVideoView.this.fBx.onCompletion();
                    }
                    QuickVideoView.this.fBw = false;
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fBx.bgm());
                QuickVideoView.this.start();
            }
        };
        this.fBI = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aUP == null || QuickVideoView.this.aUP.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aUQ = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fBz = i22;
                    if (QuickVideoView.this.fBs != null && fVar != null) {
                        QuickVideoView.this.fBs.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fBz);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fBJ = new b.InterfaceC0116b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0116b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUP != null) {
                            QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fBt = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUP != null) {
                        QuickVideoView.this.aUP.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fBs = new n(context);
        this.fBs.setSurfaceTextureListener(this.fBF);
        if (fBv != null) {
            this.fBu = fBv.Kb();
        }
        if (this.fBu != null) {
            this.fBu.setOnPreparedListener(this.fBG);
            this.fBu.setOnCompletionListener(this.fBH);
            this.fBu.setOnErrorListener(this.fBI);
            this.fBu.a(this.aUQ);
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
        if (this.fBx != null) {
            str = this.fBx.hA(str);
            if (this.fBx.getMediaProgressObserver() != null) {
                this.fBx.getMediaProgressObserver().setPlayer(this);
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
        bgj();
        this.fBy = true;
        this.mUri = uri;
        this.Cp = map;
        this.fBz = 0;
        removeView(this.fBs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fBE) {
            addView(this.fBs, layoutParams);
        } else {
            addView(this.fBs, 0, layoutParams);
        }
        ai.k(this, d.e.cp_bg_line_k);
    }

    private void bgj() {
        this.fBy = false;
        this.fBw = false;
        if (this.fBu != null) {
            this.fBu.release();
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
        this.fBt = null;
        bgj();
        this.fBA = false;
        if (this.fBx != null) {
            this.fBx.onStop();
        }
        com.baidu.tieba.play.a.b.bgC().a((b.InterfaceC0116b) null);
    }

    public void setOnPreparedListener(f.d dVar) {
        this.aUO = dVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aUN = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aUP = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fBw = true;
        if (this.fBu != null) {
            if (this.fBD != null && this.fBC && !this.fBu.isExistInRemote()) {
                this.fBu.a(this.mContext, this.mUri, this.Cp, this.fBD, this.fBB);
                return;
            } else {
                this.fBu.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fBx != null) {
            this.fBx.onStart();
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
        if (this.fBu != null) {
            this.fBu.pause();
        }
        if (this.fBx != null) {
            this.fBx.onPause();
        }
        this.fBw = false;
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
        if (this.fBu != null) {
            return this.fBu.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fBu != null) {
            return this.fBu.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fBu != null) {
            this.fBu.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fBu != null) {
            return this.fBu.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fBu != null) {
            this.fBu.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fBB = i;
    }

    public int getRecoveryState() {
        return this.fBB;
    }

    public void setNeedRecovery(boolean z) {
        this.fBC = z;
    }

    public void setLooping(boolean z) {
        this.fBA = z;
    }

    public boolean bgk() {
        return this.fBw;
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
        this.bHP = bVar;
    }

    public void setBusiness(a aVar) {
        this.fBx = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fBA = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fBu;
    }

    private boolean bgl() {
        return (com.baidu.adp.lib.b.d.fh().am("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hr() || this.fBu == null || CustomPlayerSwitchStatic.bfZ() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bgl() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bgC().a(this.fBJ);
        return com.baidu.tieba.play.a.b.bgC().qR(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fBu == null || this.fBD == null) {
            this.fBt = str;
            URI uri = new URI(this.mUri.toString());
            this.fBu.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Cp, this.fBD, this.mUri.getHost());
            start();
        }
    }
}

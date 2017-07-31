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
    private static g fzA;
    private Map<String, String> Cn;
    private f.a aUL;
    private f.d aUM;
    private f.b aUN;
    private f.c aUO;
    private b bHf;
    private boolean fzB;
    private a fzC;
    private boolean fzD;
    private int fzE;
    private boolean fzF;
    private int fzG;
    private boolean fzH;
    private SurfaceTexture fzI;
    private boolean fzJ;
    private TextureView.SurfaceTextureListener fzK;
    private f.d fzL;
    private f.a fzM;
    private f.b fzN;
    private b.InterfaceC0115b fzO;
    private n fzx;
    private String fzy;
    private f fzz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bfL();

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
        this.fzJ = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fzA = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fzB = false;
        this.fzD = false;
        this.fzE = 0;
        this.fzF = false;
        this.fzG = -1;
        this.fzH = false;
        this.fzI = null;
        this.fzJ = true;
        this.fzK = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fzD) {
                    QuickVideoView.this.fzD = false;
                    if (QuickVideoView.this.fzz != null) {
                        QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzz != null && QuickVideoView.this.fzH) {
                    QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.fzG);
                }
                QuickVideoView.this.fzI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzz != null) {
                    QuickVideoView.this.fzz.release();
                }
                if (!QuickVideoView.this.fzD) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onStop();
                    }
                    if (QuickVideoView.this.bHf != null) {
                        QuickVideoView.this.bHf.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fzI = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fzL = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUM != null) {
                    QuickVideoView.this.aUM.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzC != null) {
                    QuickVideoView.this.fzC.onPrepared();
                }
                if (QuickVideoView.this.fzB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzx != null && fVar != null) {
                    QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzy)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fzy).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fzM = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fzF || QuickVideoView.this.fzC == null) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onCompletion();
                    }
                    QuickVideoView.this.fzB = false;
                    if (QuickVideoView.this.aUL != null) {
                        QuickVideoView.this.aUL.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzC.bfL());
                QuickVideoView.this.start();
            }
        };
        this.fzN = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUN == null || QuickVideoView.this.aUN.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUO = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fzE = i2;
                    if (QuickVideoView.this.fzx != null && fVar != null) {
                        QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fzO = new b.InterfaceC0115b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0115b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUN != null) {
                            QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzy = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzB = false;
        this.fzD = false;
        this.fzE = 0;
        this.fzF = false;
        this.fzG = -1;
        this.fzH = false;
        this.fzI = null;
        this.fzJ = true;
        this.fzK = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fzD) {
                    QuickVideoView.this.fzD = false;
                    if (QuickVideoView.this.fzz != null) {
                        QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzz != null && QuickVideoView.this.fzH) {
                    QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.fzG);
                }
                QuickVideoView.this.fzI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzz != null) {
                    QuickVideoView.this.fzz.release();
                }
                if (!QuickVideoView.this.fzD) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onStop();
                    }
                    if (QuickVideoView.this.bHf != null) {
                        QuickVideoView.this.bHf.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fzI = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fzL = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUM != null) {
                    QuickVideoView.this.aUM.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzC != null) {
                    QuickVideoView.this.fzC.onPrepared();
                }
                if (QuickVideoView.this.fzB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzx != null && fVar != null) {
                    QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzy)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fzy).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fzM = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fzF || QuickVideoView.this.fzC == null) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onCompletion();
                    }
                    QuickVideoView.this.fzB = false;
                    if (QuickVideoView.this.aUL != null) {
                        QuickVideoView.this.aUL.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzC.bfL());
                QuickVideoView.this.start();
            }
        };
        this.fzN = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUN == null || QuickVideoView.this.aUN.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUO = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fzE = i2;
                    if (QuickVideoView.this.fzx != null && fVar != null) {
                        QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fzO = new b.InterfaceC0115b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0115b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUN != null) {
                            QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzy = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzB = false;
        this.fzD = false;
        this.fzE = 0;
        this.fzF = false;
        this.fzG = -1;
        this.fzH = false;
        this.fzI = null;
        this.fzJ = true;
        this.fzK = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fzD) {
                    QuickVideoView.this.fzD = false;
                    if (QuickVideoView.this.fzz != null) {
                        QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzz != null && QuickVideoView.this.fzH) {
                    QuickVideoView.this.fzz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Cn, surfaceTexture, QuickVideoView.this.fzG);
                }
                QuickVideoView.this.fzI = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzz != null) {
                    QuickVideoView.this.fzz.release();
                }
                if (!QuickVideoView.this.fzD) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onStop();
                    }
                    if (QuickVideoView.this.bHf != null) {
                        QuickVideoView.this.bHf.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fzI = null;
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fzL = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUM != null) {
                    QuickVideoView.this.aUM.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzC != null) {
                    QuickVideoView.this.fzC.onPrepared();
                }
                if (QuickVideoView.this.fzB) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzx != null && fVar != null) {
                    QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzy)) {
                    TiebaStatic.log(new aj("c12199").aa("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).aa("obj_param2", QuickVideoView.this.fzy).aa("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fzM = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fzF || QuickVideoView.this.fzC == null) {
                    if (QuickVideoView.this.fzC != null) {
                        QuickVideoView.this.fzC.onCompletion();
                    }
                    QuickVideoView.this.fzB = false;
                    if (QuickVideoView.this.aUL != null) {
                        QuickVideoView.this.aUL.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzC.bfL());
                QuickVideoView.this.start();
            }
        };
        this.fzN = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aUN == null || QuickVideoView.this.aUN.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aUO = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fzE = i22;
                    if (QuickVideoView.this.fzx != null && fVar != null) {
                        QuickVideoView.this.fzx.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fzE);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.fzO = new b.InterfaceC0115b() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.a.b.InterfaceC0115b
            public void bT(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUN != null) {
                            QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzy = null;
                    } else {
                        QuickVideoView.this.bS(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUN != null) {
                        QuickVideoView.this.aUN.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fzx = new n(context);
        this.fzx.setSurfaceTextureListener(this.fzK);
        if (fzA != null) {
            this.fzz = fzA.Kb();
        }
        if (this.fzz != null) {
            this.fzz.setOnPreparedListener(this.fzL);
            this.fzz.setOnCompletionListener(this.fzM);
            this.fzz.setOnErrorListener(this.fzN);
            this.fzz.a(this.aUO);
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
        if (this.fzC != null) {
            str = this.fzC.hx(str);
            if (this.fzC.getMediaProgressObserver() != null) {
                this.fzC.getMediaProgressObserver().setPlayer(this);
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
        bfI();
        this.fzD = true;
        this.mUri = uri;
        this.Cn = map;
        this.fzE = 0;
        removeView(this.fzx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fzJ) {
            addView(this.fzx, layoutParams);
        } else {
            addView(this.fzx, 0, layoutParams);
        }
        ai.k(this, d.e.cp_bg_line_k);
    }

    private void bfI() {
        this.fzD = false;
        this.fzB = false;
        if (this.fzz != null) {
            this.fzz.release();
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
        this.fzy = null;
        bfI();
        this.fzF = false;
        if (this.fzC != null) {
            this.fzC.onStop();
        }
        com.baidu.tieba.play.a.b.bgb().a((b.InterfaceC0115b) null);
    }

    public void setOnPreparedListener(f.d dVar) {
        this.aUM = dVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aUL = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aUN = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fzB = true;
        if (this.fzz != null) {
            if (this.fzI != null && this.fzH && !this.fzz.isExistInRemote()) {
                this.fzz.a(this.mContext, this.mUri, this.Cn, this.fzI, this.fzG);
                return;
            } else {
                this.fzz.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fzC != null) {
            this.fzC.onStart();
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
        if (this.fzz != null) {
            this.fzz.pause();
        }
        if (this.fzC != null) {
            this.fzC.onPause();
        }
        this.fzB = false;
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
        if (this.fzz != null) {
            return this.fzz.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fzz != null) {
            return this.fzz.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fzz != null) {
            this.fzz.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fzz != null) {
            return this.fzz.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fzz != null) {
            this.fzz.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fzG = i;
    }

    public int getRecoveryState() {
        return this.fzG;
    }

    public void setNeedRecovery(boolean z) {
        this.fzH = z;
    }

    public void setLooping(boolean z) {
        this.fzF = z;
    }

    public boolean bfJ() {
        return this.fzB;
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
        this.bHf = bVar;
    }

    public void setBusiness(a aVar) {
        this.fzC = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fzF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fzz;
    }

    private boolean bfK() {
        return (com.baidu.adp.lib.b.d.fh().al("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hr() || this.fzz == null || CustomPlayerSwitchStatic.bfy() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bfK() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bgb().a(this.fzO);
        return com.baidu.tieba.play.a.b.bgb().qK(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fzz == null || this.fzI == null) {
            this.fzy = str;
            URI uri = new URI(this.mUri.toString());
            this.fzz.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Cn, this.fzI, this.mUri.getHost());
            start();
        }
    }
}

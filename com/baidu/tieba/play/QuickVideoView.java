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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.f;
import java.net.URI;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static g fzX;
    private Map<String, String> Aj;
    private f.a aUv;
    private f.e aUw;
    private f.b aUx;
    private f.c aUy;
    private f.d aUz;
    private b bKJ;
    private boolean fAa;
    private int fAb;
    private boolean fAc;
    private int fAd;
    private boolean fAe;
    private SurfaceTexture fAf;
    private boolean fAg;
    private boolean fAh;
    private TextureView.SurfaceTextureListener fAi;
    private f.e fAj;
    private f.a fAk;
    private f.b fAl;
    private b.InterfaceC0118b fAm;
    private n fzU;
    private String fzV;
    private f fzW;
    private boolean fzY;
    private a fzZ;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bfC();

        i getMediaProgressObserver();

        String hw(String str);

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
        this.fAh = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fzX = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fzY = false;
        this.fAa = false;
        this.fAb = 0;
        this.fAc = false;
        this.fAd = -1;
        this.fAe = false;
        this.fAf = null;
        this.fAh = true;
        this.fAi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fAf != null && QuickVideoView.this.fAf != surfaceTexture) {
                    QuickVideoView.this.fAf.release();
                    QuickVideoView.this.fAf = null;
                }
                if (QuickVideoView.this.fAa) {
                    QuickVideoView.this.fAa = false;
                    if (QuickVideoView.this.fzW != null) {
                        QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzW != null && QuickVideoView.this.fAe) {
                    QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAd);
                }
                QuickVideoView.this.fAf = surfaceTexture;
                QuickVideoView.this.fAg = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzW != null) {
                    QuickVideoView.this.fzW.release();
                }
                if (!QuickVideoView.this.fAa) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onStop();
                    }
                    if (QuickVideoView.this.bKJ != null) {
                        QuickVideoView.this.bKJ.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAg) {
                    QuickVideoView.this.fAf = null;
                }
                return QuickVideoView.this.fAg;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fAj = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUw != null) {
                    QuickVideoView.this.aUw.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzZ != null) {
                    QuickVideoView.this.fzZ.onPrepared();
                }
                if (QuickVideoView.this.fzY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzU != null && fVar != null) {
                    QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzV)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fzV).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzV;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fAk = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAc || QuickVideoView.this.fzZ == null) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onCompletion();
                    }
                    QuickVideoView.this.fzY = false;
                    if (QuickVideoView.this.aUv != null) {
                        QuickVideoView.this.aUv.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzZ.bfC());
                QuickVideoView.this.start();
            }
        };
        this.fAl = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUx == null || QuickVideoView.this.aUx.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUy = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fAb = i2;
                    if (QuickVideoView.this.fzU != null && fVar != null) {
                        QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAg = true;
            }
        };
        this.fAm = new b.InterfaceC0118b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0118b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUx != null) {
                            QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzV = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUx != null) {
                        QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzY = false;
        this.fAa = false;
        this.fAb = 0;
        this.fAc = false;
        this.fAd = -1;
        this.fAe = false;
        this.fAf = null;
        this.fAh = true;
        this.fAi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fAf != null && QuickVideoView.this.fAf != surfaceTexture) {
                    QuickVideoView.this.fAf.release();
                    QuickVideoView.this.fAf = null;
                }
                if (QuickVideoView.this.fAa) {
                    QuickVideoView.this.fAa = false;
                    if (QuickVideoView.this.fzW != null) {
                        QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzW != null && QuickVideoView.this.fAe) {
                    QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAd);
                }
                QuickVideoView.this.fAf = surfaceTexture;
                QuickVideoView.this.fAg = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzW != null) {
                    QuickVideoView.this.fzW.release();
                }
                if (!QuickVideoView.this.fAa) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onStop();
                    }
                    if (QuickVideoView.this.bKJ != null) {
                        QuickVideoView.this.bKJ.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAg) {
                    QuickVideoView.this.fAf = null;
                }
                return QuickVideoView.this.fAg;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fAj = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUw != null) {
                    QuickVideoView.this.aUw.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzZ != null) {
                    QuickVideoView.this.fzZ.onPrepared();
                }
                if (QuickVideoView.this.fzY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzU != null && fVar != null) {
                    QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzV)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fzV).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzV;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fAk = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAc || QuickVideoView.this.fzZ == null) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onCompletion();
                    }
                    QuickVideoView.this.fzY = false;
                    if (QuickVideoView.this.aUv != null) {
                        QuickVideoView.this.aUv.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzZ.bfC());
                QuickVideoView.this.start();
            }
        };
        this.fAl = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUx == null || QuickVideoView.this.aUx.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUy = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fAb = i2;
                    if (QuickVideoView.this.fzU != null && fVar != null) {
                        QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAg = true;
            }
        };
        this.fAm = new b.InterfaceC0118b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0118b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUx != null) {
                            QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzV = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUx != null) {
                        QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzY = false;
        this.fAa = false;
        this.fAb = 0;
        this.fAc = false;
        this.fAd = -1;
        this.fAe = false;
        this.fAf = null;
        this.fAh = true;
        this.fAi = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fAf != null && QuickVideoView.this.fAf != surfaceTexture) {
                    QuickVideoView.this.fAf.release();
                    QuickVideoView.this.fAf = null;
                }
                if (QuickVideoView.this.fAa) {
                    QuickVideoView.this.fAa = false;
                    if (QuickVideoView.this.fzW != null) {
                        QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fzW != null && QuickVideoView.this.fAe) {
                    QuickVideoView.this.fzW.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAd);
                }
                QuickVideoView.this.fAf = surfaceTexture;
                QuickVideoView.this.fAg = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fzW != null) {
                    QuickVideoView.this.fzW.release();
                }
                if (!QuickVideoView.this.fAa) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onStop();
                    }
                    if (QuickVideoView.this.bKJ != null) {
                        QuickVideoView.this.bKJ.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAg) {
                    QuickVideoView.this.fAf = null;
                }
                return QuickVideoView.this.fAg;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fAj = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUw != null) {
                    QuickVideoView.this.aUw.onPrepared(fVar);
                }
                if (QuickVideoView.this.fzZ != null) {
                    QuickVideoView.this.fzZ.onPrepared();
                }
                if (QuickVideoView.this.fzY) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fzU != null && fVar != null) {
                    QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fzV)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fzV).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fzV;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fAk = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAc || QuickVideoView.this.fzZ == null) {
                    if (QuickVideoView.this.fzZ != null) {
                        QuickVideoView.this.fzZ.onCompletion();
                    }
                    QuickVideoView.this.fzY = false;
                    if (QuickVideoView.this.aUv != null) {
                        QuickVideoView.this.aUv.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fzZ.bfC());
                QuickVideoView.this.start();
            }
        };
        this.fAl = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aUx == null || QuickVideoView.this.aUx.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aUy = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fAb = i22;
                    if (QuickVideoView.this.fzU != null && fVar != null) {
                        QuickVideoView.this.fzU.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAb);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUz = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAg = true;
            }
        };
        this.fAm = new b.InterfaceC0118b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0118b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUx != null) {
                            QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fzV = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUx != null) {
                        QuickVideoView.this.aUx.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fzU = new n(context);
        this.fzU.setSurfaceTextureListener(this.fAi);
        if (fzX != null) {
            this.fzW = fzX.Kk();
        }
        if (this.fzW != null) {
            this.fzW.setOnPreparedListener(this.fAj);
            this.fzW.setOnCompletionListener(this.fAk);
            this.fzW.setOnErrorListener(this.fAl);
            this.fzW.a(this.aUy);
            this.fzW.a(this.aUz);
        }
        aj.k(this, d.e.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void setVideoPath(String str) {
        if (this.fzZ != null) {
            str = this.fzZ.hw(str);
            if (this.fzZ.getMediaProgressObserver() != null) {
                this.fzZ.getMediaProgressObserver().setPlayer(this);
            }
        }
        if (!am.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        bfz();
        this.fAa = true;
        this.mUri = uri;
        this.Aj = map;
        this.fAb = 0;
        removeView(this.fzU);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fAh) {
            addView(this.fzU, layoutParams);
        } else {
            addView(this.fzU, 0, layoutParams);
        }
        aj.k(this, d.e.cp_bg_line_k);
    }

    private void bfz() {
        this.fAa = false;
        this.fzY = false;
        if (this.fzW != null) {
            this.fzW.release();
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
        this.fzV = null;
        bfz();
        this.fAc = false;
        if (this.fzZ != null) {
            this.fzZ.onStop();
        }
        com.baidu.tieba.play.a.b.bfS().a((b.InterfaceC0118b) null);
    }

    public void setOnPreparedListener(f.e eVar) {
        this.aUw = eVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aUv = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aUx = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fzY = true;
        if (this.fzW != null) {
            if (this.fAf != null && this.fAe && !this.fzW.isExistInRemote()) {
                this.fzW.a(this.mContext, this.mUri, this.Aj, this.fAf, this.fAd);
                return;
            } else {
                this.fzW.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fzZ != null) {
            this.fzZ.onStart();
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
        if (this.fzW != null) {
            this.fzW.pause();
        }
        if (this.fzZ != null) {
            this.fzZ.onPause();
        }
        this.fzY = false;
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
        if (this.fzW != null) {
            return this.fzW.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fzW != null) {
            return this.fzW.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fzW != null) {
            this.fzW.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fzW != null) {
            return this.fzW.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fzW != null) {
            this.fzW.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fAd = i;
    }

    public int getRecoveryState() {
        return this.fAd;
    }

    public void setNeedRecovery(boolean z) {
        this.fAe = z;
    }

    public void setLooping(boolean z) {
        this.fAc = z;
    }

    public boolean bfA() {
        return this.fzY;
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
        this.bKJ = bVar;
    }

    public void setBusiness(a aVar) {
        this.fzZ = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fAc = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fzW;
    }

    private boolean bfB() {
        return (com.baidu.adp.lib.b.d.eW().af("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hi() || this.fzW == null || CustomPlayerSwitchStatic.bfk() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bfB() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bfS().a(this.fAm);
        return com.baidu.tieba.play.a.b.bfS().qD(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fzW == null || this.fAf == null) {
            this.fzV = str;
            URI uri = new URI(this.mUri.toString());
            this.fzW.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Aj, this.fAf, this.mUri.getHost());
            start();
        }
    }
}

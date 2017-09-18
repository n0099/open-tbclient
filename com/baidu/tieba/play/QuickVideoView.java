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
    private static g fAQ;
    private Map<String, String> Aj;
    private f.a aUs;
    private f.e aUt;
    private f.b aUu;
    private f.c aUv;
    private f.d aUw;
    private b bLA;
    private n fAN;
    private String fAO;
    private f fAP;
    private boolean fAR;
    private a fAS;
    private boolean fAT;
    private int fAU;
    private boolean fAV;
    private int fAW;
    private boolean fAX;
    private SurfaceTexture fAY;
    private boolean fAZ;
    private boolean fBa;
    private TextureView.SurfaceTextureListener fBb;
    private f.e fBc;
    private f.a fBd;
    private f.b fBe;
    private b.InterfaceC0117b fBf;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        String bfN();

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
        this.fBa = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, g.class);
        if (runTask != null) {
            fAQ = (g) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fAR = false;
        this.fAT = false;
        this.fAU = 0;
        this.fAV = false;
        this.fAW = -1;
        this.fAX = false;
        this.fAY = null;
        this.fBa = true;
        this.fBb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fAY != null && QuickVideoView.this.fAY != surfaceTexture) {
                    QuickVideoView.this.fAY.release();
                    QuickVideoView.this.fAY = null;
                }
                if (QuickVideoView.this.fAT) {
                    QuickVideoView.this.fAT = false;
                    if (QuickVideoView.this.fAP != null) {
                        QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fAP != null && QuickVideoView.this.fAX) {
                    QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAW);
                }
                QuickVideoView.this.fAY = surfaceTexture;
                QuickVideoView.this.fAZ = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fAP != null) {
                    QuickVideoView.this.fAP.release();
                }
                if (!QuickVideoView.this.fAT) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onStop();
                    }
                    if (QuickVideoView.this.bLA != null) {
                        QuickVideoView.this.bLA.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAZ) {
                    QuickVideoView.this.fAY = null;
                }
                return QuickVideoView.this.fAZ;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBc = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUt != null) {
                    QuickVideoView.this.aUt.onPrepared(fVar);
                }
                if (QuickVideoView.this.fAS != null) {
                    QuickVideoView.this.fAS.onPrepared();
                }
                if (QuickVideoView.this.fAR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fAN != null && fVar != null) {
                    QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fAO)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fAO).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fAO;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBd = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAV || QuickVideoView.this.fAS == null) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onCompletion();
                    }
                    QuickVideoView.this.fAR = false;
                    if (QuickVideoView.this.aUs != null) {
                        QuickVideoView.this.aUs.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fAS.bfN());
                QuickVideoView.this.start();
            }
        };
        this.fBe = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUu == null || QuickVideoView.this.aUu.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUv = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fAU = i2;
                    if (QuickVideoView.this.fAN != null && fVar != null) {
                        QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUw = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAZ = true;
            }
        };
        this.fBf = new b.InterfaceC0117b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0117b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUu != null) {
                            QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fAO = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUu != null) {
                        QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAR = false;
        this.fAT = false;
        this.fAU = 0;
        this.fAV = false;
        this.fAW = -1;
        this.fAX = false;
        this.fAY = null;
        this.fBa = true;
        this.fBb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fAY != null && QuickVideoView.this.fAY != surfaceTexture) {
                    QuickVideoView.this.fAY.release();
                    QuickVideoView.this.fAY = null;
                }
                if (QuickVideoView.this.fAT) {
                    QuickVideoView.this.fAT = false;
                    if (QuickVideoView.this.fAP != null) {
                        QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fAP != null && QuickVideoView.this.fAX) {
                    QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAW);
                }
                QuickVideoView.this.fAY = surfaceTexture;
                QuickVideoView.this.fAZ = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fAP != null) {
                    QuickVideoView.this.fAP.release();
                }
                if (!QuickVideoView.this.fAT) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onStop();
                    }
                    if (QuickVideoView.this.bLA != null) {
                        QuickVideoView.this.bLA.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAZ) {
                    QuickVideoView.this.fAY = null;
                }
                return QuickVideoView.this.fAZ;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBc = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUt != null) {
                    QuickVideoView.this.aUt.onPrepared(fVar);
                }
                if (QuickVideoView.this.fAS != null) {
                    QuickVideoView.this.fAS.onPrepared();
                }
                if (QuickVideoView.this.fAR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fAN != null && fVar != null) {
                    QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fAO)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fAO).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fAO;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBd = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAV || QuickVideoView.this.fAS == null) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onCompletion();
                    }
                    QuickVideoView.this.fAR = false;
                    if (QuickVideoView.this.aUs != null) {
                        QuickVideoView.this.aUs.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fAS.bfN());
                QuickVideoView.this.start();
            }
        };
        this.fBe = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                if (QuickVideoView.this.b(fVar, i, i2) || QuickVideoView.this.aUu == null || QuickVideoView.this.aUu.onError(fVar, i, i2)) {
                }
                return true;
            }
        };
        this.aUv = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fAU = i2;
                    if (QuickVideoView.this.fAN != null && fVar != null) {
                        QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUw = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAZ = true;
            }
        };
        this.fBf = new b.InterfaceC0117b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0117b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUu != null) {
                            QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fAO = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUu != null) {
                        QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAR = false;
        this.fAT = false;
        this.fAU = 0;
        this.fAV = false;
        this.fAW = -1;
        this.fAX = false;
        this.fAY = null;
        this.fBa = true;
        this.fBb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fAY != null && QuickVideoView.this.fAY != surfaceTexture) {
                    QuickVideoView.this.fAY.release();
                    QuickVideoView.this.fAY = null;
                }
                if (QuickVideoView.this.fAT) {
                    QuickVideoView.this.fAT = false;
                    if (QuickVideoView.this.fAP != null) {
                        QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fAP != null && QuickVideoView.this.fAX) {
                    QuickVideoView.this.fAP.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fAW);
                }
                QuickVideoView.this.fAY = surfaceTexture;
                QuickVideoView.this.fAZ = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fAP != null) {
                    QuickVideoView.this.fAP.release();
                }
                if (!QuickVideoView.this.fAT) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onStop();
                    }
                    if (QuickVideoView.this.bLA != null) {
                        QuickVideoView.this.bLA.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fAZ) {
                    QuickVideoView.this.fAY = null;
                }
                return QuickVideoView.this.fAZ;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fBc = new f.e() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (QuickVideoView.this.aUt != null) {
                    QuickVideoView.this.aUt.onPrepared(fVar);
                }
                if (QuickVideoView.this.fAS != null) {
                    QuickVideoView.this.fAS.onPrepared();
                }
                if (QuickVideoView.this.fAR) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fAN != null && fVar != null) {
                    QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fAO)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fAO).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fAO;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
            }
        };
        this.fBd = new f.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(f fVar) {
                if (!QuickVideoView.this.fAV || QuickVideoView.this.fAS == null) {
                    if (QuickVideoView.this.fAS != null) {
                        QuickVideoView.this.fAS.onCompletion();
                    }
                    QuickVideoView.this.fAR = false;
                    if (QuickVideoView.this.aUs != null) {
                        QuickVideoView.this.aUs.onCompletion(fVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fAS.bfN());
                QuickVideoView.this.start();
            }
        };
        this.fBe = new f.b() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                if (QuickVideoView.this.b(fVar, i2, i22) || QuickVideoView.this.aUu == null || QuickVideoView.this.aUu.onError(fVar, i2, i22)) {
                }
                return true;
            }
        };
        this.aUv = new f.c() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.f.c
            public boolean a(f fVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fAU = i22;
                    if (QuickVideoView.this.fAN != null && fVar != null) {
                        QuickVideoView.this.fAN.P(fVar.getVideoWidth(), fVar.getVideoHeight(), QuickVideoView.this.fAU);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aUw = new f.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.f.d
            public void onReleaseFinished() {
                QuickVideoView.this.fAZ = true;
            }
        };
        this.fBf = new b.InterfaceC0117b() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.a.b.InterfaceC0117b
            public void bV(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        if (QuickVideoView.this.aUu != null) {
                            QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                        }
                    } else if (QuickVideoView.this.mUri == null || !str2.equals(QuickVideoView.this.mUri.getHost())) {
                        QuickVideoView.this.fAO = null;
                    } else {
                        QuickVideoView.this.bU(str, str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    if (QuickVideoView.this.aUu != null) {
                        QuickVideoView.this.aUu.onError(null, -400, SapiErrorCode.NETWORK_FAILED);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fAN = new n(context);
        this.fAN.setSurfaceTextureListener(this.fBb);
        if (fAQ != null) {
            this.fAP = fAQ.Kk();
        }
        if (this.fAP != null) {
            this.fAP.setOnPreparedListener(this.fBc);
            this.fAP.setOnCompletionListener(this.fBd);
            this.fAP.setOnErrorListener(this.fBe);
            this.fAP.a(this.aUv);
            this.fAP.a(this.aUw);
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
        if (this.fAS != null) {
            str = this.fAS.hw(str);
            if (this.fAS.getMediaProgressObserver() != null) {
                this.fAS.getMediaProgressObserver().setPlayer(this);
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
        bfK();
        this.fAT = true;
        this.mUri = uri;
        this.Aj = map;
        this.fAU = 0;
        removeView(this.fAN);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fBa) {
            addView(this.fAN, layoutParams);
        } else {
            addView(this.fAN, 0, layoutParams);
        }
        aj.k(this, d.e.cp_bg_line_k);
    }

    private void bfK() {
        this.fAT = false;
        this.fAR = false;
        if (this.fAP != null) {
            this.fAP.release();
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
        this.fAO = null;
        bfK();
        this.fAV = false;
        if (this.fAS != null) {
            this.fAS.onStop();
        }
        com.baidu.tieba.play.a.b.bgd().a((b.InterfaceC0117b) null);
    }

    public void setOnPreparedListener(f.e eVar) {
        this.aUt = eVar;
    }

    public void setOnCompletionListener(f.a aVar) {
        this.aUs = aVar;
    }

    public void setOnErrorListener(f.b bVar) {
        this.aUu = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fAR = true;
        if (this.fAP != null) {
            if (this.fAY != null && this.fAX && !this.fAP.isExistInRemote()) {
                this.fAP.a(this.mContext, this.mUri, this.Aj, this.fAY, this.fAW);
                return;
            } else {
                this.fAP.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fAS != null) {
            this.fAS.onStart();
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
        if (this.fAP != null) {
            this.fAP.pause();
        }
        if (this.fAS != null) {
            this.fAS.onPause();
        }
        this.fAR = false;
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
        if (this.fAP != null) {
            return this.fAP.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fAP != null) {
            return this.fAP.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fAP != null) {
            this.fAP.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fAP != null) {
            return this.fAP.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fAP != null) {
            this.fAP.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fAW = i;
    }

    public int getRecoveryState() {
        return this.fAW;
    }

    public void setNeedRecovery(boolean z) {
        this.fAX = z;
    }

    public void setLooping(boolean z) {
        this.fAV = z;
    }

    public boolean bfL() {
        return this.fAR;
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
        this.bLA = bVar;
    }

    public void setBusiness(a aVar) {
        this.fAS = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fAV = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public f getPlayer() {
        return this.fAP;
    }

    private boolean bfM() {
        return (com.baidu.adp.lib.b.d.eW().af("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hi() || this.fAP == null || CustomPlayerSwitchStatic.bfv() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(f fVar, int i, int i2) {
        if (!bfM() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bgd().a(this.fBf);
        return com.baidu.tieba.play.a.b.bgd().qF(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fAP == null || this.fAY == null) {
            this.fAO = str;
            URI uri = new URI(this.mUri.toString());
            this.fAP.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Aj, this.fAY, this.mUri.getHost());
            start();
        }
    }
}

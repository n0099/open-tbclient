package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.b {
    private static h fwP;
    private Map<String, String> Am;
    private g.a aVQ;
    private g.f aVR;
    private g.b aVS;
    private g.c aVT;
    private g.d aVU;
    private g.InterfaceC0121g aVV;
    private g.e aVW;
    private b bKK;
    private a fwC;
    private o fwM;
    private String fwN;
    private g fwO;
    private boolean fwQ;
    private d fwR;
    private boolean fwS;
    private int fwT;
    private boolean fwU;
    private int fwV;
    private boolean fwW;
    private SurfaceTexture fwX;
    private boolean fwY;
    private boolean fwZ;
    private com.baidu.tieba.play.b.a fxa;
    private TextureView.SurfaceTextureListener fxb;
    private g.f fxc;
    private g.a fxd;
    private g.InterfaceC0121g fxe;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void beb();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fwZ = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fwP = (h) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fwQ = false;
        this.fwS = false;
        this.fwT = 0;
        this.fwU = false;
        this.fwV = -1;
        this.fwW = false;
        this.fwX = null;
        this.fwZ = true;
        this.fxb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fwX != null && QuickVideoView.this.fwX != surfaceTexture) {
                    QuickVideoView.this.fwX.release();
                    QuickVideoView.this.fwX = null;
                }
                if (QuickVideoView.this.fwS) {
                    QuickVideoView.this.fwS = false;
                    if (QuickVideoView.this.fwO != null) {
                        QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fwO != null && QuickVideoView.this.fwW) {
                    QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fwV);
                    if (QuickVideoView.this.fwC != null) {
                        QuickVideoView.this.fwC.beb();
                    }
                }
                QuickVideoView.this.fwX = surfaceTexture;
                QuickVideoView.this.fwY = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fwO != null) {
                    QuickVideoView.this.fwO.release();
                }
                if (!QuickVideoView.this.fwS) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onStop();
                    }
                    if (QuickVideoView.this.bKK != null) {
                        QuickVideoView.this.bKK.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fwY) {
                    QuickVideoView.this.fwX = null;
                }
                return QuickVideoView.this.fwY;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxc = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aVR != null) {
                    QuickVideoView.this.aVR.onPrepared(gVar);
                }
                if (QuickVideoView.this.fwR != null) {
                    QuickVideoView.this.fwR.onPrepared();
                }
                if (QuickVideoView.this.fwQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fwM != null && gVar != null) {
                    QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fwN)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fwN).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fwN;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxa != null && QuickVideoView.this.fxa.beD()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxd = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fwU || QuickVideoView.this.fwR == null) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onCompletion();
                    }
                    QuickVideoView.this.fwQ = false;
                    if (QuickVideoView.this.aVQ != null) {
                        QuickVideoView.this.aVQ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fwR.bec());
                QuickVideoView.this.start();
            }
        };
        this.aVT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxa != null ? QuickVideoView.this.fxa.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bek();
                    if (QuickVideoView.this.aVS == null || QuickVideoView.this.aVS.onError(gVar, i2, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i4 = 0;
                    } else {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fxe = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aVV != null) {
                    QuickVideoView.this.aVV.a(gVar);
                }
            }
        };
        this.aVU = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fwT = i2;
                    if (QuickVideoView.this.fwM != null && gVar != null) {
                        QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aVW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fwY = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fwQ = false;
        this.fwS = false;
        this.fwT = 0;
        this.fwU = false;
        this.fwV = -1;
        this.fwW = false;
        this.fwX = null;
        this.fwZ = true;
        this.fxb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fwX != null && QuickVideoView.this.fwX != surfaceTexture) {
                    QuickVideoView.this.fwX.release();
                    QuickVideoView.this.fwX = null;
                }
                if (QuickVideoView.this.fwS) {
                    QuickVideoView.this.fwS = false;
                    if (QuickVideoView.this.fwO != null) {
                        QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fwO != null && QuickVideoView.this.fwW) {
                    QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fwV);
                    if (QuickVideoView.this.fwC != null) {
                        QuickVideoView.this.fwC.beb();
                    }
                }
                QuickVideoView.this.fwX = surfaceTexture;
                QuickVideoView.this.fwY = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fwO != null) {
                    QuickVideoView.this.fwO.release();
                }
                if (!QuickVideoView.this.fwS) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onStop();
                    }
                    if (QuickVideoView.this.bKK != null) {
                        QuickVideoView.this.bKK.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fwY) {
                    QuickVideoView.this.fwX = null;
                }
                return QuickVideoView.this.fwY;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxc = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aVR != null) {
                    QuickVideoView.this.aVR.onPrepared(gVar);
                }
                if (QuickVideoView.this.fwR != null) {
                    QuickVideoView.this.fwR.onPrepared();
                }
                if (QuickVideoView.this.fwQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fwM != null && gVar != null) {
                    QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fwN)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fwN).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fwN;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxa != null && QuickVideoView.this.fxa.beD()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxd = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fwU || QuickVideoView.this.fwR == null) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onCompletion();
                    }
                    QuickVideoView.this.fwQ = false;
                    if (QuickVideoView.this.aVQ != null) {
                        QuickVideoView.this.aVQ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fwR.bec());
                QuickVideoView.this.start();
            }
        };
        this.aVT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxa != null ? QuickVideoView.this.fxa.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bek();
                    if (QuickVideoView.this.aVS == null || QuickVideoView.this.aVS.onError(gVar, i2, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i4 = 0;
                    } else {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fxe = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aVV != null) {
                    QuickVideoView.this.aVV.a(gVar);
                }
            }
        };
        this.aVU = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fwT = i2;
                    if (QuickVideoView.this.fwM != null && gVar != null) {
                        QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aVW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fwY = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fwQ = false;
        this.fwS = false;
        this.fwT = 0;
        this.fwU = false;
        this.fwV = -1;
        this.fwW = false;
        this.fwX = null;
        this.fwZ = true;
        this.fxb = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fwX != null && QuickVideoView.this.fwX != surfaceTexture) {
                    QuickVideoView.this.fwX.release();
                    QuickVideoView.this.fwX = null;
                }
                if (QuickVideoView.this.fwS) {
                    QuickVideoView.this.fwS = false;
                    if (QuickVideoView.this.fwO != null) {
                        QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fwO != null && QuickVideoView.this.fwW) {
                    QuickVideoView.this.fwO.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fwV);
                    if (QuickVideoView.this.fwC != null) {
                        QuickVideoView.this.fwC.beb();
                    }
                }
                QuickVideoView.this.fwX = surfaceTexture;
                QuickVideoView.this.fwY = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fwO != null) {
                    QuickVideoView.this.fwO.release();
                }
                if (!QuickVideoView.this.fwS) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onStop();
                    }
                    if (QuickVideoView.this.bKK != null) {
                        QuickVideoView.this.bKK.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fwY) {
                    QuickVideoView.this.fwX = null;
                }
                return QuickVideoView.this.fwY;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxc = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.aVR != null) {
                    QuickVideoView.this.aVR.onPrepared(gVar);
                }
                if (QuickVideoView.this.fwR != null) {
                    QuickVideoView.this.fwR.onPrepared();
                }
                if (QuickVideoView.this.fwQ) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fwM != null && gVar != null) {
                    QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fwN)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fwN).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fwN;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxa != null && QuickVideoView.this.fxa.beD()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxd = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fwU || QuickVideoView.this.fwR == null) {
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.onCompletion();
                    }
                    QuickVideoView.this.fwQ = false;
                    if (QuickVideoView.this.aVQ != null) {
                        QuickVideoView.this.aVQ.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fwR.bec());
                QuickVideoView.this.start();
            }
        };
        this.aVT = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i2, i22, i3);
                if (!(QuickVideoView.this.fxa != null ? QuickVideoView.this.fxa.a(gVar, i2, i22, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bek();
                    if (QuickVideoView.this.aVS == null || QuickVideoView.this.aVS.onError(gVar, i22, i3)) {
                    }
                } else {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i4 = 0;
                    } else {
                        i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                }
                return true;
            }
        };
        this.fxe = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aVV != null) {
                    QuickVideoView.this.aVV.a(gVar);
                }
            }
        };
        this.aVU = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fwT = i22;
                    if (QuickVideoView.this.fwM != null && gVar != null) {
                        QuickVideoView.this.fwM.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fwT);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aVW = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fwY = true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fwM = new o(context);
        this.fwM.setSurfaceTextureListener(this.fxb);
        if (fwP != null) {
            this.fwO = fwP.Kw();
        }
        if (this.fwO != null) {
            this.fwO.setOnPreparedListener(this.fxc);
            this.fwO.setOnCompletionListener(this.fxd);
            this.fwO.a(this.aVT);
            this.fwO.setOnSeekCompleteListener(this.fxe);
            this.fwO.a(this.aVU);
            this.fwO.a(this.aVW);
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
        this.fxa = new com.baidu.tieba.play.b.a(this);
    }

    public void setVideoPath(String str) {
        if (this.fwR != null) {
            str = this.fwR.hs(str);
            if (this.fwR.getMediaProgressObserver() != null) {
                this.fwR.getMediaProgressObserver().setPlayer(this);
            }
        }
        if (!am.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    private void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    private void a(Uri uri, Map<String, String> map) {
        beh();
        this.fwS = true;
        this.mUri = uri;
        this.Am = map;
        this.fwT = 0;
        removeView(this.fwM);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fwZ) {
            addView(this.fwM, layoutParams);
        } else {
            addView(this.fwM, 0, layoutParams);
        }
        aj.k(this, d.e.cp_bg_line_k);
    }

    private void beh() {
        this.fwS = false;
        this.fwQ = false;
        if (this.fwO != null) {
            this.fwO.release();
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
        this.fwN = null;
        beh();
        this.fwU = false;
        if (this.fwR != null) {
            this.fwR.onStop();
        }
        com.baidu.tieba.play.a.b.beB().a((b.InterfaceC0118b) null);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aVR = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aVQ = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aVS = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0121g interfaceC0121g) {
        this.aVV = interfaceC0121g;
    }

    @Override // com.baidu.tieba.play.b.b
    public void a(g gVar, int i, int i2, int i3, String str) {
        if (getCurrentPosition() <= 0 || this.fwO == null || !this.fwO.isPlaying() || this.fwX == null) {
            try {
                this.fwN = str;
                URI uri = new URI(this.mUri.toString());
                this.fwO.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Am, this.fwX, this.mUri.getHost());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void b(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fwO.a(this.mContext, this.mUri, this.Am, this.fwX, this.mUri.getHost());
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void c(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fwO.forceUseSystemMediaPlayer(true);
            }
            this.fwO.a(this.mContext, this.mUri, this.Am, this.fwX, this.mUri.getHost());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fwQ = true;
        if (this.fwO != null) {
            if (this.fwX != null && this.fwW && !this.fwO.isExistInRemote()) {
                this.fwO.a(this.mContext, this.mUri, this.Am, this.fwX, this.fwV);
                if (this.fwC != null) {
                    this.fwC.beb();
                    return;
                }
                return;
            }
            this.fwO.start();
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fwR != null) {
            this.fwR.onStart();
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
        if (this.fwO != null) {
            this.fwO.pause();
        }
        if (this.fwR != null) {
            this.fwR.onPause();
        }
        this.fwQ = false;
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
        if (this.fwO != null) {
            return this.fwO.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fwO != null) {
            return this.fwO.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fwO != null) {
            this.fwO.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fwO != null) {
            return this.fwO.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fwO != null) {
            this.fwO.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fwV = i;
    }

    public int getRecoveryState() {
        return this.fwV;
    }

    public void setNeedRecovery(boolean z) {
        this.fwW = z;
    }

    public void setLooping(boolean z) {
        this.fwU = z;
    }

    public boolean bei() {
        return this.fwQ;
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
        this.bKK = bVar;
    }

    public void setBusiness(d dVar) {
        this.fwR = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fwU = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fwO != null) {
            this.fwO.GL();
        }
    }

    public g getPlayer() {
        return this.fwO;
    }

    public int getPlayerType() {
        if (this.fwO == null) {
            return -300;
        }
        return this.fwO.getPlayerType();
    }

    public boolean bej() {
        int i = 1;
        int i2 = 0;
        if (this.fxa != null) {
            boolean a2 = this.fxa.a(this.fwO, getPlayerType(), 0, -4399, this.mUri);
            if (a2) {
                if (getPlayerType() != -100) {
                    i2 = getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i2));
            }
            return a2;
        }
        if (getPlayerType() == -100) {
            i = 0;
        } else if (getPlayerType() != -200) {
            i = 2;
        }
        TiebaStatic.log(new ak("c12194").r("obj_type", i));
        bek();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bek() {
        int i;
        int i2 = 2;
        if (getPlayerType() == -100) {
            i = 0;
        } else {
            i = getPlayerType() == -200 ? 1 : 2;
        }
        if (Build.CPU_ABI.toLowerCase().contains("v7")) {
            i2 = 0;
        } else if (Build.CPU_ABI.toLowerCase().contains("arm")) {
            i2 = 1;
        } else if (!Build.CPU_ABI.toLowerCase().contains("86")) {
            if (Build.CPU_ABI.toLowerCase().contains("mips")) {
                i2 = 3;
            } else {
                i2 = 4;
            }
        }
        TiebaStatic.log(new ak("c12029").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1).r("obj_param2", i2));
    }

    public void setOnRecoveryCallback(a aVar) {
        this.fwC = aVar;
    }
}

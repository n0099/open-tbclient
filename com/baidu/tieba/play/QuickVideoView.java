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
    private static h fxd;
    private Map<String, String> Al;
    private g.a aWd;
    private g.f aWe;
    private g.b aWf;
    private g.c aWg;
    private g.d aWh;
    private g.InterfaceC0121g aWi;
    private g.e aWj;
    private b bKW;
    private a fwQ;
    private o fxa;
    private String fxb;
    private g fxc;
    private boolean fxe;
    private d fxf;
    private boolean fxg;
    private int fxh;
    private boolean fxi;
    private int fxj;
    private boolean fxl;
    private SurfaceTexture fxm;
    private boolean fxn;
    private boolean fxo;
    private com.baidu.tieba.play.b.a fxp;
    private TextureView.SurfaceTextureListener fxq;
    private g.f fxr;
    private g.a fxs;
    private g.InterfaceC0121g fxt;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void beg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fxo = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fxd = (h) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fxe = false;
        this.fxg = false;
        this.fxh = 0;
        this.fxi = false;
        this.fxj = -1;
        this.fxl = false;
        this.fxm = null;
        this.fxo = true;
        this.fxq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fxm != null && QuickVideoView.this.fxm != surfaceTexture) {
                    QuickVideoView.this.fxm.release();
                    QuickVideoView.this.fxm = null;
                }
                if (QuickVideoView.this.fxg) {
                    QuickVideoView.this.fxg = false;
                    if (QuickVideoView.this.fxc != null) {
                        QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxc != null && QuickVideoView.this.fxl) {
                    QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxj);
                    if (QuickVideoView.this.fwQ != null) {
                        QuickVideoView.this.fwQ.beg();
                    }
                }
                QuickVideoView.this.fxm = surfaceTexture;
                QuickVideoView.this.fxn = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxc != null) {
                    QuickVideoView.this.fxc.release();
                }
                if (!QuickVideoView.this.fxg) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxn) {
                    QuickVideoView.this.fxm = null;
                }
                return QuickVideoView.this.fxn;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxf != null) {
                    QuickVideoView.this.fxf.onPrepared();
                }
                if (QuickVideoView.this.fxe) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxa != null && gVar != null) {
                    QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxb)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxb).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxb;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxp != null && QuickVideoView.this.fxp.beI()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxi || QuickVideoView.this.fxf == null) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onCompletion();
                    }
                    QuickVideoView.this.fxe = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxf.beh());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxp != null ? QuickVideoView.this.fxp.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bep();
                    if (QuickVideoView.this.aWf == null || QuickVideoView.this.aWf.onError(gVar, i2, i3)) {
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
        this.fxt = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aWi != null) {
                    QuickVideoView.this.aWi.a(gVar);
                }
            }
        };
        this.aWh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fxh = i2;
                    if (QuickVideoView.this.fxa != null && gVar != null) {
                        QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aWj = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fxn = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxe = false;
        this.fxg = false;
        this.fxh = 0;
        this.fxi = false;
        this.fxj = -1;
        this.fxl = false;
        this.fxm = null;
        this.fxo = true;
        this.fxq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fxm != null && QuickVideoView.this.fxm != surfaceTexture) {
                    QuickVideoView.this.fxm.release();
                    QuickVideoView.this.fxm = null;
                }
                if (QuickVideoView.this.fxg) {
                    QuickVideoView.this.fxg = false;
                    if (QuickVideoView.this.fxc != null) {
                        QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxc != null && QuickVideoView.this.fxl) {
                    QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxj);
                    if (QuickVideoView.this.fwQ != null) {
                        QuickVideoView.this.fwQ.beg();
                    }
                }
                QuickVideoView.this.fxm = surfaceTexture;
                QuickVideoView.this.fxn = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxc != null) {
                    QuickVideoView.this.fxc.release();
                }
                if (!QuickVideoView.this.fxg) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxn) {
                    QuickVideoView.this.fxm = null;
                }
                return QuickVideoView.this.fxn;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxf != null) {
                    QuickVideoView.this.fxf.onPrepared();
                }
                if (QuickVideoView.this.fxe) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxa != null && gVar != null) {
                    QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxb)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxb).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxb;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxp != null && QuickVideoView.this.fxp.beI()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxi || QuickVideoView.this.fxf == null) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onCompletion();
                    }
                    QuickVideoView.this.fxe = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxf.beh());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxp != null ? QuickVideoView.this.fxp.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bep();
                    if (QuickVideoView.this.aWf == null || QuickVideoView.this.aWf.onError(gVar, i2, i3)) {
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
        this.fxt = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aWi != null) {
                    QuickVideoView.this.aWi.a(gVar);
                }
            }
        };
        this.aWh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fxh = i2;
                    if (QuickVideoView.this.fxa != null && gVar != null) {
                        QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aWj = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fxn = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxe = false;
        this.fxg = false;
        this.fxh = 0;
        this.fxi = false;
        this.fxj = -1;
        this.fxl = false;
        this.fxm = null;
        this.fxo = true;
        this.fxq = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fxm != null && QuickVideoView.this.fxm != surfaceTexture) {
                    QuickVideoView.this.fxm.release();
                    QuickVideoView.this.fxm = null;
                }
                if (QuickVideoView.this.fxg) {
                    QuickVideoView.this.fxg = false;
                    if (QuickVideoView.this.fxc != null) {
                        QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxc != null && QuickVideoView.this.fxl) {
                    QuickVideoView.this.fxc.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxj);
                    if (QuickVideoView.this.fwQ != null) {
                        QuickVideoView.this.fwQ.beg();
                    }
                }
                QuickVideoView.this.fxm = surfaceTexture;
                QuickVideoView.this.fxn = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxc != null) {
                    QuickVideoView.this.fxc.release();
                }
                if (!QuickVideoView.this.fxg) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxn) {
                    QuickVideoView.this.fxm = null;
                }
                return QuickVideoView.this.fxn;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxr = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxf != null) {
                    QuickVideoView.this.fxf.onPrepared();
                }
                if (QuickVideoView.this.fxe) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxa != null && gVar != null) {
                    QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxb)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxb).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxb;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxp != null && QuickVideoView.this.fxp.beI()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxs = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxi || QuickVideoView.this.fxf == null) {
                    if (QuickVideoView.this.fxf != null) {
                        QuickVideoView.this.fxf.onCompletion();
                    }
                    QuickVideoView.this.fxe = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxf.beh());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i2, i22, i3);
                if (!(QuickVideoView.this.fxp != null ? QuickVideoView.this.fxp.a(gVar, i2, i22, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.bep();
                    if (QuickVideoView.this.aWf == null || QuickVideoView.this.aWf.onError(gVar, i22, i3)) {
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
        this.fxt = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void a(g gVar) {
                if (QuickVideoView.this.aWi != null) {
                    QuickVideoView.this.aWi.a(gVar);
                }
            }
        };
        this.aWh = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.6
            @Override // com.baidu.tieba.play.g.d
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fxh = i22;
                    if (QuickVideoView.this.fxa != null && gVar != null) {
                        QuickVideoView.this.fxa.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxh);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        this.aWj = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.7
            @Override // com.baidu.tieba.play.g.e
            public void onReleaseFinished() {
                QuickVideoView.this.fxn = true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fxa = new o(context);
        this.fxa.setSurfaceTextureListener(this.fxq);
        if (fxd != null) {
            this.fxc = fxd.KC();
        }
        if (this.fxc != null) {
            this.fxc.setOnPreparedListener(this.fxr);
            this.fxc.setOnCompletionListener(this.fxs);
            this.fxc.a(this.aWg);
            this.fxc.setOnSeekCompleteListener(this.fxt);
            this.fxc.a(this.aWh);
            this.fxc.a(this.aWj);
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
        this.fxp = new com.baidu.tieba.play.b.a(this);
    }

    public void setVideoPath(String str) {
        if (this.fxf != null) {
            str = this.fxf.ht(str);
            if (this.fxf.getMediaProgressObserver() != null) {
                this.fxf.getMediaProgressObserver().setPlayer(this);
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
        bem();
        this.fxg = true;
        this.mUri = uri;
        this.Al = map;
        this.fxh = 0;
        removeView(this.fxa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fxo) {
            addView(this.fxa, layoutParams);
        } else {
            addView(this.fxa, 0, layoutParams);
        }
        aj.k(this, d.e.cp_bg_line_k);
    }

    private void bem() {
        this.fxg = false;
        this.fxe = false;
        if (this.fxc != null) {
            this.fxc.release();
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
        this.fxb = null;
        bem();
        this.fxi = false;
        if (this.fxf != null) {
            this.fxf.onStop();
        }
        com.baidu.tieba.play.a.b.beG().a((b.InterfaceC0118b) null);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aWe = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aWd = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aWf = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0121g interfaceC0121g) {
        this.aWi = interfaceC0121g;
    }

    @Override // com.baidu.tieba.play.b.b
    public void a(g gVar, int i, int i2, int i3, String str) {
        if (getCurrentPosition() <= 0 || this.fxc == null || !this.fxc.isPlaying() || this.fxm == null) {
            try {
                this.fxb = str;
                URI uri = new URI(this.mUri.toString());
                this.fxc.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Al, this.fxm, this.mUri.getHost());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void b(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fxc.a(this.mContext, this.mUri, this.Al, this.fxm, this.mUri.getHost());
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void c(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fxc.forceUseSystemMediaPlayer(true);
            }
            this.fxc.a(this.mContext, this.mUri, this.Al, this.fxm, this.mUri.getHost());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fxe = true;
        if (this.fxc != null) {
            if (this.fxm != null && this.fxl && !this.fxc.isExistInRemote()) {
                this.fxc.a(this.mContext, this.mUri, this.Al, this.fxm, this.fxj);
                if (this.fwQ != null) {
                    this.fwQ.beg();
                    return;
                }
                return;
            }
            this.fxc.start();
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fxf != null) {
            this.fxf.onStart();
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
        if (this.fxc != null) {
            this.fxc.pause();
        }
        if (this.fxf != null) {
            this.fxf.onPause();
        }
        this.fxe = false;
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
        if (this.fxc != null) {
            return this.fxc.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fxc != null) {
            return this.fxc.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fxc != null) {
            this.fxc.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fxc != null) {
            return this.fxc.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fxc != null) {
            this.fxc.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fxj = i;
    }

    public int getRecoveryState() {
        return this.fxj;
    }

    public void setNeedRecovery(boolean z) {
        this.fxl = z;
    }

    public void setLooping(boolean z) {
        this.fxi = z;
    }

    public boolean ben() {
        return this.fxe;
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
        this.bKW = bVar;
    }

    public void setBusiness(d dVar) {
        this.fxf = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fxi = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fxc != null) {
            this.fxc.GR();
        }
    }

    public g getPlayer() {
        return this.fxc;
    }

    public int getPlayerType() {
        if (this.fxc == null) {
            return -300;
        }
        return this.fxc.getPlayerType();
    }

    public boolean beo() {
        int i = 1;
        int i2 = 0;
        if (this.fxp != null) {
            boolean a2 = this.fxp.a(this.fxc, getPlayerType(), 0, -4399, this.mUri);
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
        bep();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bep() {
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
        this.fwQ = aVar;
    }
}

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
    private static h fxe;
    private Map<String, String> Al;
    private g.a aWd;
    private g.f aWe;
    private g.b aWf;
    private g.c aWg;
    private g.d aWh;
    private g.InterfaceC0121g aWi;
    private g.e aWj;
    private b bKW;
    private a fwR;
    private o fxb;
    private String fxc;
    private g fxd;
    private boolean fxf;
    private d fxg;
    private boolean fxh;
    private int fxi;
    private boolean fxj;
    private int fxl;
    private boolean fxm;
    private SurfaceTexture fxn;
    private boolean fxo;
    private boolean fxp;
    private com.baidu.tieba.play.b.a fxq;
    private TextureView.SurfaceTextureListener fxr;
    private g.f fxs;
    private g.a fxt;
    private g.InterfaceC0121g fxu;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void beh();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fxp = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fxe = (h) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fxf = false;
        this.fxh = false;
        this.fxi = 0;
        this.fxj = false;
        this.fxl = -1;
        this.fxm = false;
        this.fxn = null;
        this.fxp = true;
        this.fxr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fxn != null && QuickVideoView.this.fxn != surfaceTexture) {
                    QuickVideoView.this.fxn.release();
                    QuickVideoView.this.fxn = null;
                }
                if (QuickVideoView.this.fxh) {
                    QuickVideoView.this.fxh = false;
                    if (QuickVideoView.this.fxd != null) {
                        QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxd != null && QuickVideoView.this.fxm) {
                    QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxl);
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.beh();
                    }
                }
                QuickVideoView.this.fxn = surfaceTexture;
                QuickVideoView.this.fxo = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxd != null) {
                    QuickVideoView.this.fxd.release();
                }
                if (!QuickVideoView.this.fxh) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxo) {
                    QuickVideoView.this.fxn = null;
                }
                return QuickVideoView.this.fxo;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxg != null) {
                    QuickVideoView.this.fxg.onPrepared();
                }
                if (QuickVideoView.this.fxf) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxb != null && gVar != null) {
                    QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxc)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxc).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxc;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxq != null && QuickVideoView.this.fxq.beJ()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxj || QuickVideoView.this.fxg == null) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onCompletion();
                    }
                    QuickVideoView.this.fxf = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxg.bei());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxq != null ? QuickVideoView.this.fxq.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.beq();
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
        this.fxu = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
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
                    QuickVideoView.this.fxi = i2;
                    if (QuickVideoView.this.fxb != null && gVar != null) {
                        QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
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
                QuickVideoView.this.fxo = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxf = false;
        this.fxh = false;
        this.fxi = 0;
        this.fxj = false;
        this.fxl = -1;
        this.fxm = false;
        this.fxn = null;
        this.fxp = true;
        this.fxr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fxn != null && QuickVideoView.this.fxn != surfaceTexture) {
                    QuickVideoView.this.fxn.release();
                    QuickVideoView.this.fxn = null;
                }
                if (QuickVideoView.this.fxh) {
                    QuickVideoView.this.fxh = false;
                    if (QuickVideoView.this.fxd != null) {
                        QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxd != null && QuickVideoView.this.fxm) {
                    QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxl);
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.beh();
                    }
                }
                QuickVideoView.this.fxn = surfaceTexture;
                QuickVideoView.this.fxo = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxd != null) {
                    QuickVideoView.this.fxd.release();
                }
                if (!QuickVideoView.this.fxh) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxo) {
                    QuickVideoView.this.fxn = null;
                }
                return QuickVideoView.this.fxo;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxg != null) {
                    QuickVideoView.this.fxg.onPrepared();
                }
                if (QuickVideoView.this.fxf) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxb != null && gVar != null) {
                    QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxc)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxc).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxc;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxq != null && QuickVideoView.this.fxq.beJ()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxj || QuickVideoView.this.fxg == null) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onCompletion();
                    }
                    QuickVideoView.this.fxf = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxg.bei());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i, i2, i3);
                if (!(QuickVideoView.this.fxq != null ? QuickVideoView.this.fxq.a(gVar, i, i2, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.beq();
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
        this.fxu = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
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
                    QuickVideoView.this.fxi = i2;
                    if (QuickVideoView.this.fxb != null && gVar != null) {
                        QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
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
                QuickVideoView.this.fxo = true;
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxf = false;
        this.fxh = false;
        this.fxi = 0;
        this.fxj = false;
        this.fxl = -1;
        this.fxm = false;
        this.fxn = null;
        this.fxp = true;
        this.fxr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fxn != null && QuickVideoView.this.fxn != surfaceTexture) {
                    QuickVideoView.this.fxn.release();
                    QuickVideoView.this.fxn = null;
                }
                if (QuickVideoView.this.fxh) {
                    QuickVideoView.this.fxh = false;
                    if (QuickVideoView.this.fxd != null) {
                        QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                } else if (QuickVideoView.this.fxd != null && QuickVideoView.this.fxm) {
                    QuickVideoView.this.fxd.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Al, surfaceTexture, QuickVideoView.this.fxl);
                    if (QuickVideoView.this.fwR != null) {
                        QuickVideoView.this.fwR.beh();
                    }
                }
                QuickVideoView.this.fxn = surfaceTexture;
                QuickVideoView.this.fxo = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fxd != null) {
                    QuickVideoView.this.fxd.release();
                }
                if (!QuickVideoView.this.fxh) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onStop();
                    }
                    if (QuickVideoView.this.bKW != null) {
                        QuickVideoView.this.bKW.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fxo) {
                    QuickVideoView.this.fxn = null;
                }
                return QuickVideoView.this.fxo;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fxs = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.aWe != null) {
                    QuickVideoView.this.aWe.onPrepared(gVar);
                }
                if (QuickVideoView.this.fxg != null) {
                    QuickVideoView.this.fxg.onPrepared();
                }
                if (QuickVideoView.this.fxf) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fxb != null && gVar != null) {
                    QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fxc)) {
                    TiebaStatic.log(new ak("c12199").ad("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ad("obj_param2", QuickVideoView.this.fxc).ad("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fxc;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fxq != null && QuickVideoView.this.fxq.beJ()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fxt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!QuickVideoView.this.fxj || QuickVideoView.this.fxg == null) {
                    if (QuickVideoView.this.fxg != null) {
                        QuickVideoView.this.fxg.onCompletion();
                    }
                    QuickVideoView.this.fxf = false;
                    if (QuickVideoView.this.aWd != null) {
                        QuickVideoView.this.aWd.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fxg.bei());
                QuickVideoView.this.start();
            }
        };
        this.aWg = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.W(i2, i22, i3);
                if (!(QuickVideoView.this.fxq != null ? QuickVideoView.this.fxq.a(gVar, i2, i22, i3, QuickVideoView.this.mUri) : false)) {
                    QuickVideoView.this.beq();
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
        this.fxu = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.QuickVideoView.5
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
                    QuickVideoView.this.fxi = i22;
                    if (QuickVideoView.this.fxb != null && gVar != null) {
                        QuickVideoView.this.fxb.V(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fxi);
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
                QuickVideoView.this.fxo = true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fxb = new o(context);
        this.fxb.setSurfaceTextureListener(this.fxr);
        if (fxe != null) {
            this.fxd = fxe.KC();
        }
        if (this.fxd != null) {
            this.fxd.setOnPreparedListener(this.fxs);
            this.fxd.setOnCompletionListener(this.fxt);
            this.fxd.a(this.aWg);
            this.fxd.setOnSeekCompleteListener(this.fxu);
            this.fxd.a(this.aWh);
            this.fxd.a(this.aWj);
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
        this.fxq = new com.baidu.tieba.play.b.a(this);
    }

    public void setVideoPath(String str) {
        if (this.fxg != null) {
            str = this.fxg.ht(str);
            if (this.fxg.getMediaProgressObserver() != null) {
                this.fxg.getMediaProgressObserver().setPlayer(this);
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
        ben();
        this.fxh = true;
        this.mUri = uri;
        this.Al = map;
        this.fxi = 0;
        removeView(this.fxb);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fxp) {
            addView(this.fxb, layoutParams);
        } else {
            addView(this.fxb, 0, layoutParams);
        }
        aj.k(this, d.e.cp_bg_line_k);
    }

    private void ben() {
        this.fxh = false;
        this.fxf = false;
        if (this.fxd != null) {
            this.fxd.release();
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
        this.fxc = null;
        ben();
        this.fxj = false;
        if (this.fxg != null) {
            this.fxg.onStop();
        }
        com.baidu.tieba.play.a.b.beH().a((b.InterfaceC0118b) null);
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
        if (getCurrentPosition() <= 0 || this.fxd == null || !this.fxd.isPlaying() || this.fxn == null) {
            try {
                this.fxc = str;
                URI uri = new URI(this.mUri.toString());
                this.fxd.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Al, this.fxn, this.mUri.getHost());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void b(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fxd.a(this.mContext, this.mUri, this.Al, this.fxn, this.mUri.getHost());
        }
    }

    @Override // com.baidu.tieba.play.b.b
    public void c(g gVar, int i, int i2, int i3) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fxd.forceUseSystemMediaPlayer(true);
            }
            this.fxd.a(this.mContext, this.mUri, this.Al, this.fxn, this.mUri.getHost());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fxf = true;
        if (this.fxd != null) {
            if (this.fxn != null && this.fxm && !this.fxd.isExistInRemote()) {
                this.fxd.a(this.mContext, this.mUri, this.Al, this.fxn, this.fxl);
                if (this.fwR != null) {
                    this.fwR.beh();
                    return;
                }
                return;
            }
            this.fxd.start();
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fxg != null) {
            this.fxg.onStart();
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
        if (this.fxd != null) {
            this.fxd.pause();
        }
        if (this.fxg != null) {
            this.fxg.onPause();
        }
        this.fxf = false;
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
        if (this.fxd != null) {
            return this.fxd.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fxd != null) {
            return this.fxd.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fxd != null) {
            this.fxd.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fxd != null) {
            return this.fxd.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fxd != null) {
            this.fxd.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fxl = i;
    }

    public int getRecoveryState() {
        return this.fxl;
    }

    public void setNeedRecovery(boolean z) {
        this.fxm = z;
    }

    public void setLooping(boolean z) {
        this.fxj = z;
    }

    public boolean beo() {
        return this.fxf;
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
        this.fxg = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fxj = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fxd != null) {
            this.fxd.GR();
        }
    }

    public g getPlayer() {
        return this.fxd;
    }

    public int getPlayerType() {
        if (this.fxd == null) {
            return -300;
        }
        return this.fxd.getPlayerType();
    }

    public boolean bep() {
        int i = 1;
        int i2 = 0;
        if (this.fxq != null) {
            boolean a2 = this.fxq.a(this.fxd, getPlayerType(), 0, -4399, this.mUri);
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
        beq();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
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
        this.fwR = aVar;
    }
}

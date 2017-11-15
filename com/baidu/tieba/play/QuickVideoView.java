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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.c.a;
import com.baidu.tieba.play.g;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.d.c {
    private static h fFW;
    private static com.baidu.tieba.play.b.c fFX;
    private Map<String, String> Am;
    private String aMq;
    private g.a aWi;
    private g.InterfaceC0124g aWj;
    private g.b aWk;
    private g.c aWl;
    private g.e aWm;
    private g.h aWn;
    private g.f aWo;
    private g.j aWp;
    private g.d aWq;
    private g.i aWr;
    private final CustomMessageListener aWz;
    private b bSE;
    private a fFJ;
    private o fFT;
    private String fFU;
    private g fFV;
    private com.baidu.tieba.play.b.b fFY;
    private String fFZ;
    private boolean fGa;
    private d fGb;
    private boolean fGc;
    private int fGd;
    private boolean fGe;
    private int fGf;
    private boolean fGg;
    private SurfaceTexture fGh;
    private boolean fGi;
    private boolean fGj;
    private com.baidu.tieba.play.d.a fGk;
    private boolean fGl;
    private boolean fGm;
    private String fGn;
    private com.baidu.tieba.play.c.a fGo;
    private long fGp;
    private a.InterfaceC0120a fGq;
    private TextureView.SurfaceTextureListener fGr;
    private g.InterfaceC0124g fGs;
    private g.a fGt;
    private g.h fGu;
    private Runnable fGv;
    private Runnable fGw;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bhr();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fGj = z;
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fFW = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_MONITOR_FACTORY, com.baidu.tieba.play.b.c.class);
        if (runTask2 != null) {
            fFX = (com.baidu.tieba.play.b.c) runTask2.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fGa = false;
        this.fGc = false;
        this.fGd = 0;
        this.fGe = false;
        this.fGf = -1;
        this.fGg = false;
        this.fGh = null;
        this.fGj = true;
        this.fGq = new a.InterfaceC0120a() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void bN(String str, String str2) {
                ak akVar = new ak("c12620");
                akVar.r("obj_locate", 1);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.1
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom", 1);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void j(String str, String str2, final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.2
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }
        };
        this.fGr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fGh != null && QuickVideoView.this.fGh != surfaceTexture) {
                    QuickVideoView.this.fGh.release();
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fGc) {
                    QuickVideoView.this.fGc = false;
                    if (QuickVideoView.this.fFV != null) {
                        QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMY();
                    }
                } else if (QuickVideoView.this.fFV != null && QuickVideoView.this.fGg) {
                    QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fGf);
                    if (QuickVideoView.this.fFJ != null) {
                        QuickVideoView.this.fFJ.bhr();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMZ();
                    }
                }
                QuickVideoView.this.fGh = surfaceTexture;
                QuickVideoView.this.fGi = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFV != null) {
                    QuickVideoView.this.fFV.release();
                }
                if (!QuickVideoView.this.fGc) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onStop();
                    }
                    if (QuickVideoView.this.bSE != null) {
                        QuickVideoView.this.bSE.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fGi) {
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fFY != null && QuickVideoView.this.fFY.oM(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFY = null;
                }
                return QuickVideoView.this.fGi;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fGs = new g.InterfaceC0124g() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.aNa();
                }
                if (QuickVideoView.this.aWj != null) {
                    QuickVideoView.this.aWj.onPrepared(gVar);
                }
                if (QuickVideoView.this.fGb != null) {
                    QuickVideoView.this.fGb.onPrepared();
                }
                if (QuickVideoView.this.fGa) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFT != null && gVar != null) {
                    QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFU)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFU).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFU;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fGk != null && QuickVideoView.this.fGk.bia()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fGt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oL(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
                if (!QuickVideoView.this.fGe || QuickVideoView.this.fGb == null) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onCompletion();
                    }
                    QuickVideoView.this.fGa = false;
                    if (QuickVideoView.this.aWi != null) {
                        QuickVideoView.this.aWi.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFZ = null;
                QuickVideoView.this.fGp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                QuickVideoView.this.start();
            }
        };
        this.aWl = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.d.a.Z(i, i2, i3);
                if (QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    if (QuickVideoView.this.fGb != null && !StringUtils.isNull(QuickVideoView.this.fGb.bhs())) {
                        String uri = QuickVideoView.this.mUri.toString();
                        if (!uri.contains("http")) {
                            File file = new File(uri);
                            if (file.exists()) {
                                QuickVideoView.this.setLocalVideoMd5(com.baidu.adp.lib.util.s.e(com.baidu.tbadk.core.util.k.q(file)));
                            }
                            com.baidu.tieba.play.d.a.rd(uri);
                        }
                        QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fGb.bhs());
                    }
                } else {
                    QuickVideoView.this.bhB();
                }
                boolean z = false;
                if (QuickVideoView.this.fGk != null) {
                    z = QuickVideoView.this.fGk.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                }
                if (QuickVideoView.this.fFY != null && z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (QuickVideoView.this.fGb != null && !QuickVideoView.this.fGm && !z && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs())) && !QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    z = true;
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFY != null && !z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (!z) {
                    QuickVideoView.this.bhD();
                    if (QuickVideoView.this.aWk == null || QuickVideoView.this.aWk.onError(gVar, i2, i3)) {
                        return true;
                    }
                    return true;
                }
                if (QuickVideoView.this.getPlayerType() == -100) {
                    i4 = 0;
                } else {
                    i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                return true;
            }
        };
        this.fGu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fGv, 500L);
                if (QuickVideoView.this.aWn != null) {
                    QuickVideoView.this.aWn.a(gVar);
                }
            }
        };
        this.aWm = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fGd = i2;
                    if (QuickVideoView.this.fFT != null && gVar != null) {
                        QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNb();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNc();
                    QuickVideoView.this.fGl = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fGv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fGl = false;
            }
        };
        this.aWo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fGi = true;
            }
        };
        this.aWp = new g.j() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.j
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.f(i, i2, str);
                }
            }
        };
        this.aWq = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oN(str);
                }
            }
        };
        this.aWr = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.i
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fGp = j;
                }
            }
        };
        this.fGw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fGb != null && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs()))) {
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGa = false;
        this.fGc = false;
        this.fGd = 0;
        this.fGe = false;
        this.fGf = -1;
        this.fGg = false;
        this.fGh = null;
        this.fGj = true;
        this.fGq = new a.InterfaceC0120a() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void bN(String str, String str2) {
                ak akVar = new ak("c12620");
                akVar.r("obj_locate", 1);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.1
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom", 1);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void j(String str, String str2, final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.2
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }
        };
        this.fGr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fGh != null && QuickVideoView.this.fGh != surfaceTexture) {
                    QuickVideoView.this.fGh.release();
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fGc) {
                    QuickVideoView.this.fGc = false;
                    if (QuickVideoView.this.fFV != null) {
                        QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMY();
                    }
                } else if (QuickVideoView.this.fFV != null && QuickVideoView.this.fGg) {
                    QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fGf);
                    if (QuickVideoView.this.fFJ != null) {
                        QuickVideoView.this.fFJ.bhr();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMZ();
                    }
                }
                QuickVideoView.this.fGh = surfaceTexture;
                QuickVideoView.this.fGi = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFV != null) {
                    QuickVideoView.this.fFV.release();
                }
                if (!QuickVideoView.this.fGc) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onStop();
                    }
                    if (QuickVideoView.this.bSE != null) {
                        QuickVideoView.this.bSE.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fGi) {
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fFY != null && QuickVideoView.this.fFY.oM(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFY = null;
                }
                return QuickVideoView.this.fGi;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fGs = new g.InterfaceC0124g() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.aNa();
                }
                if (QuickVideoView.this.aWj != null) {
                    QuickVideoView.this.aWj.onPrepared(gVar);
                }
                if (QuickVideoView.this.fGb != null) {
                    QuickVideoView.this.fGb.onPrepared();
                }
                if (QuickVideoView.this.fGa) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFT != null && gVar != null) {
                    QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFU)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFU).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFU;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fGk != null && QuickVideoView.this.fGk.bia()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fGt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oL(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
                if (!QuickVideoView.this.fGe || QuickVideoView.this.fGb == null) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onCompletion();
                    }
                    QuickVideoView.this.fGa = false;
                    if (QuickVideoView.this.aWi != null) {
                        QuickVideoView.this.aWi.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFZ = null;
                QuickVideoView.this.fGp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                QuickVideoView.this.start();
            }
        };
        this.aWl = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.d.a.Z(i, i2, i3);
                if (QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    if (QuickVideoView.this.fGb != null && !StringUtils.isNull(QuickVideoView.this.fGb.bhs())) {
                        String uri = QuickVideoView.this.mUri.toString();
                        if (!uri.contains("http")) {
                            File file = new File(uri);
                            if (file.exists()) {
                                QuickVideoView.this.setLocalVideoMd5(com.baidu.adp.lib.util.s.e(com.baidu.tbadk.core.util.k.q(file)));
                            }
                            com.baidu.tieba.play.d.a.rd(uri);
                        }
                        QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fGb.bhs());
                    }
                } else {
                    QuickVideoView.this.bhB();
                }
                boolean z = false;
                if (QuickVideoView.this.fGk != null) {
                    z = QuickVideoView.this.fGk.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                }
                if (QuickVideoView.this.fFY != null && z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (QuickVideoView.this.fGb != null && !QuickVideoView.this.fGm && !z && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs())) && !QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    z = true;
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFY != null && !z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (!z) {
                    QuickVideoView.this.bhD();
                    if (QuickVideoView.this.aWk == null || QuickVideoView.this.aWk.onError(gVar, i2, i3)) {
                        return true;
                    }
                    return true;
                }
                if (QuickVideoView.this.getPlayerType() == -100) {
                    i4 = 0;
                } else {
                    i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                return true;
            }
        };
        this.fGu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fGv, 500L);
                if (QuickVideoView.this.aWn != null) {
                    QuickVideoView.this.aWn.a(gVar);
                }
            }
        };
        this.aWm = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fGd = i2;
                    if (QuickVideoView.this.fFT != null && gVar != null) {
                        QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNb();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNc();
                    QuickVideoView.this.fGl = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fGv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fGl = false;
            }
        };
        this.aWo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fGi = true;
            }
        };
        this.aWp = new g.j() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.j
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.f(i, i2, str);
                }
            }
        };
        this.aWq = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oN(str);
                }
            }
        };
        this.aWr = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.i
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fGp = j;
                }
            }
        };
        this.fGw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fGb != null && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs()))) {
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGa = false;
        this.fGc = false;
        this.fGd = 0;
        this.fGe = false;
        this.fGf = -1;
        this.fGg = false;
        this.fGh = null;
        this.fGj = true;
        this.fGq = new a.InterfaceC0120a() { // from class: com.baidu.tieba.play.QuickVideoView.1
            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void bN(String str, String str2) {
                ak akVar = new ak("c12620");
                akVar.r("obj_locate", 1);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.1
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom", 1);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.play.c.a.InterfaceC0120a
            public void j(String str, String str2, final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", str2);
                TiebaStatic.log(akVar);
                if (TextUtils.equals(str2, QuickVideoView.this.aMq) && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.1.2
                        @Override // com.baidu.tieba.play.b.a
                        public void J(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void K(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.play.b.a
                        public void L(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }
        };
        this.fGr = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fGh != null && QuickVideoView.this.fGh != surfaceTexture) {
                    QuickVideoView.this.fGh.release();
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fGc) {
                    QuickVideoView.this.fGc = false;
                    if (QuickVideoView.this.fFV != null) {
                        QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMY();
                    }
                } else if (QuickVideoView.this.fFV != null && QuickVideoView.this.fGg) {
                    QuickVideoView.this.fFV.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fGf);
                    if (QuickVideoView.this.fFJ != null) {
                        QuickVideoView.this.fFJ.bhr();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fFY.aMZ();
                    }
                }
                QuickVideoView.this.fGh = surfaceTexture;
                QuickVideoView.this.fGi = false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (QuickVideoView.this.fFV != null) {
                    QuickVideoView.this.fFV.release();
                }
                if (!QuickVideoView.this.fGc) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onStop();
                    }
                    if (QuickVideoView.this.bSE != null) {
                        QuickVideoView.this.bSE.onSurfaceDestroyed();
                    }
                }
                if (QuickVideoView.this.fGi) {
                    QuickVideoView.this.fGh = null;
                }
                if (QuickVideoView.this.fFY != null && QuickVideoView.this.fFY.oM(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fFY = null;
                }
                return QuickVideoView.this.fGi;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fGs = new g.InterfaceC0124g() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.aNa();
                }
                if (QuickVideoView.this.aWj != null) {
                    QuickVideoView.this.aWj.onPrepared(gVar);
                }
                if (QuickVideoView.this.fGb != null) {
                    QuickVideoView.this.fGb.onPrepared();
                }
                if (QuickVideoView.this.fGa) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFT != null && gVar != null) {
                    QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fFU)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fFU).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fFU;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fGk != null && QuickVideoView.this.fGk.bia()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fGt = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oL(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
                if (!QuickVideoView.this.fGe || QuickVideoView.this.fGb == null) {
                    if (QuickVideoView.this.fGb != null) {
                        QuickVideoView.this.fGb.onCompletion();
                    }
                    QuickVideoView.this.fGa = false;
                    if (QuickVideoView.this.aWi != null) {
                        QuickVideoView.this.aWi.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fFZ = null;
                QuickVideoView.this.fGp = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                QuickVideoView.this.start();
            }
        };
        this.aWl = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.d.a.Z(i2, i22, i3);
                if (QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    if (QuickVideoView.this.fGb != null && !StringUtils.isNull(QuickVideoView.this.fGb.bhs())) {
                        String uri = QuickVideoView.this.mUri.toString();
                        if (!uri.contains("http")) {
                            File file = new File(uri);
                            if (file.exists()) {
                                QuickVideoView.this.setLocalVideoMd5(com.baidu.adp.lib.util.s.e(com.baidu.tbadk.core.util.k.q(file)));
                            }
                            com.baidu.tieba.play.d.a.rd(uri);
                        }
                        QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fGb.bhs());
                    }
                } else {
                    QuickVideoView.this.bhB();
                }
                boolean z = false;
                if (QuickVideoView.this.fGk != null) {
                    z = QuickVideoView.this.fGk.a(gVar, i2, i22, i3, QuickVideoView.this.mUri);
                }
                if (QuickVideoView.this.fFY != null && z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (QuickVideoView.this.fGb != null && !QuickVideoView.this.fGm && !z && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs())) && !QuickVideoView.qV(QuickVideoView.this.mUri.toString())) {
                    z = true;
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fFY != null && !z) {
                    QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fGp);
                    QuickVideoView.this.fFY = null;
                }
                QuickVideoView.this.fGp = 0L;
                if (!z) {
                    QuickVideoView.this.bhD();
                    if (QuickVideoView.this.aWk == null || QuickVideoView.this.aWk.onError(gVar, i22, i3)) {
                        return true;
                    }
                    return true;
                }
                if (QuickVideoView.this.getPlayerType() == -100) {
                    i4 = 0;
                } else {
                    i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                return true;
            }
        };
        this.fGu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.h
            public void a(g gVar) {
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fGv, 500L);
                if (QuickVideoView.this.aWn != null) {
                    QuickVideoView.this.aWn.a(gVar);
                }
            }
        };
        this.aWm = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fGd = i22;
                    if (QuickVideoView.this.fFT != null && gVar != null) {
                        QuickVideoView.this.fFT.Y(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fGd);
                        return true;
                    }
                    return true;
                } else if ((i2 == 701 || i22 == 701) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNb();
                    return true;
                } else if ((i2 == 702 || i22 == 702) && QuickVideoView.this.fFY != null && !QuickVideoView.this.fGl) {
                    QuickVideoView.this.fFY.aNc();
                    QuickVideoView.this.fGl = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fGv);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fGv = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fGl = false;
            }
        };
        this.aWo = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.f
            public void onReleaseFinished() {
                QuickVideoView.this.fGi = true;
            }
        };
        this.aWp = new g.j() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.j
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.f(i2, i22, str);
                }
            }
        };
        this.aWq = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oN(str);
                }
            }
        };
        this.aWr = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // com.baidu.tieba.play.g.i
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fGp = j;
                }
            }
        };
        this.fGw = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fGb != null && QuickVideoView.qV(QuickVideoView.this.fGb.hB(QuickVideoView.this.fGb.bhs()))) {
                    QuickVideoView.this.fFV.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fGk.bia();
                    QuickVideoView.this.fGm = true;
                    if (QuickVideoView.this.fFY != null) {
                        QuickVideoView.this.fFZ = QuickVideoView.this.fFY.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fGp);
                        QuickVideoView.this.fFY = null;
                    }
                    QuickVideoView.this.fGp = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fGb.bhs());
                    QuickVideoView.this.start();
                }
            }
        };
        this.aWz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fFY != null) {
                    QuickVideoView.this.fFY.oK(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fFY = null;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fFT = new o(context);
        this.fFT.setSurfaceTextureListener(this.fGr);
        if (fFW != null) {
            this.fFV = fFW.KQ();
        }
        if (this.fFV != null) {
            this.fFV.setOnPreparedListener(this.fGs);
            this.fFV.setOnCompletionListener(this.fGt);
            this.fFV.a(this.aWl);
            this.fFV.setOnSeekCompleteListener(this.fGu);
            this.fFV.a(this.aWm);
            this.fFV.a(this.aWo);
            this.fFV.a(this.aWp);
            this.fFV.a(this.aWq);
            this.fFV.a(this.aWr);
        }
        aj.k(this, d.C0080d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fGk = new com.baidu.tieba.play.d.a(this);
        MessageManager.getInstance().registerListener(this.aWz);
        this.fGo = new com.baidu.tieba.play.c.a(this.fGq);
    }

    public void setVideoPath(String str) {
        if (this.fFY != null) {
            this.fFY.aNh();
            this.fFY = null;
        }
        if (!am.isEmpty(str)) {
            this.fGn = str;
            if (e(Uri.parse(str)) != null) {
                this.fFY.aMX();
            }
            if (this.fGb != null) {
                str = this.fGb.hB(str);
                if (this.fGb.getMediaProgressObserver() != null) {
                    this.fGb.getMediaProgressObserver().setPlayer(this);
                }
                if (this.fGo != null) {
                    if (com.baidu.tieba.play.c.a.rb(str)) {
                        this.fGo.bP(str, this.aMq);
                        this.fGo.bhW();
                    } else {
                        this.fGo.clearPath();
                    }
                }
            }
            setVideoURI(Uri.parse(str));
        }
    }

    public void bM(String str, String str2) {
        this.aMq = str2;
        if (this.fGk != null) {
            this.fGk.clear();
        }
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
            if (fFX != null) {
                this.fFY = fFX.F(this.aMq, str, "");
                if (this.fFY != null) {
                    this.fFY.a(-300, -44399, -44399, getLocateSource(), false, this.fGp);
                    this.fFY = null;
                }
            }
        }
        this.fFZ = null;
        this.fGp = 0L;
        setVideoPath(str);
    }

    private void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    private void a(Uri uri, Map<String, String> map) {
        if (e(uri) != null) {
            this.fFY.oI(uri.toString());
        }
        bhy();
        this.fGc = true;
        this.mUri = uri;
        this.Am = map;
        this.fGd = 0;
        removeView(this.fFT);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fGj) {
            addView(this.fFT, layoutParams);
        } else {
            addView(this.fFT, 0, layoutParams);
        }
        aj.k(this, d.C0080d.cp_bg_line_k);
    }

    private void bhy() {
        this.fGc = false;
        this.fGa = false;
        if (this.fFV != null) {
            this.fFV.release();
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
        if (this.fGk != null) {
            this.fGk.clear();
        }
        this.fFU = null;
        bhy();
        this.fGe = false;
        if (this.fGb != null) {
            this.fGb.onStop();
        }
        com.baidu.tieba.play.a.b.bhV().a((b.InterfaceC0119b) null);
        if (this.fFY != null && this.fFY.oM(getLocateSource())) {
            this.fFY = null;
        }
    }

    public void setOnPreparedListener(g.InterfaceC0124g interfaceC0124g) {
        this.aWj = interfaceC0124g;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aWi = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aWk = bVar;
    }

    public void setOnSeekCompleteListener(g.h hVar) {
        this.aWn = hVar;
    }

    @Override // com.baidu.tieba.play.d.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4) {
        if (getCurrentPosition() <= 0 || this.fFV == null || !this.fFV.isPlaying() || this.fGh == null) {
            try {
                this.fFU = str;
                URI uri = new URI(this.mUri.toString());
                this.fFV.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Am, this.fGh, this.mUri.getHost());
                if (e(this.mUri) != null) {
                    this.fFY.a(0, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.d.c
    public void a(g gVar, int i, int i2, int i3, int i4) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fFV.a(this.mContext, this.mUri, this.Am, this.fGh, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fFY.a(1, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.d.c
    public void b(g gVar, int i, int i2, int i3, int i4) {
        if (this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fFV.forceUseSystemMediaPlayer(true);
            }
            this.fFV.a(this.mContext, this.mUri, this.Am, this.fGh, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fFY.a(2, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fGa = true;
        if (this.fFV != null) {
            if (this.fGh != null && this.fGg && !this.fFV.isExistInRemote()) {
                this.fFV.a(this.mContext, this.mUri, this.Am, this.fGh, this.fGf);
                if (this.fFJ != null) {
                    this.fFJ.bhr();
                }
                if (e(this.mUri) != null) {
                    this.fFY.aMZ();
                    return;
                }
                return;
            }
            this.fFV.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fGb != null) {
            this.fGb.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (e(this.mUri) != null) {
            this.fFY.pb(this.fFV.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fFV != null) {
            this.fFV.pause();
        }
        if (this.fGb != null) {
            this.fGb.onPause();
        }
        this.fGa = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fFY != null) {
            this.fFY.aNd();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fFV != null) {
            return this.fFV.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fFV != null) {
            return this.fFV.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.fGl = true;
        if (this.fFV != null) {
            this.fFV.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fFV != null) {
            return this.fFV.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fFV != null) {
            this.fFV.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fGf = i;
    }

    public int getRecoveryState() {
        return this.fGf;
    }

    public void setNeedRecovery(boolean z) {
        this.fGg = z;
    }

    public void setLooping(boolean z) {
        this.fGe = z;
    }

    public boolean bhz() {
        return this.fGa;
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
        this.bSE = bVar;
    }

    public void setBusiness(d dVar) {
        this.fGb = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fGe = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fFV != null) {
            this.fFV.Hi();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGv);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGw);
        MessageManager.getInstance().unRegisterListener(this.aWz);
        if (this.fGk != null) {
            this.fGk.clear();
        }
        if (this.fGo != null) {
            this.fGo.clearPath();
        }
    }

    public g getPlayer() {
        return this.fFV;
    }

    public int getPlayerType() {
        if (this.fFV == null) {
            return -300;
        }
        return this.fFV.getPlayerType();
    }

    public boolean bhA() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.fGm) {
            if (this.fFY != null) {
                this.fFZ = this.fFY.a(getPlayerType(), -4399, -4399, getLocateSource(), false, this.fGp);
                this.fFY = null;
            }
            this.fGp = 0L;
            if (getPlayerType() == -100) {
                i = 0;
            } else {
                i = getPlayerType() == -200 ? 1 : 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i));
            bhD();
            return false;
        } else if (this.fGk != null) {
            boolean a2 = this.fGk.a(this.fFV, getPlayerType(), 0, -4399, this.mUri);
            if (a2) {
                if (getPlayerType() != -100) {
                    i3 = getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i3));
            }
            if (this.fFY != null) {
                this.fFZ = this.fFY.a(getPlayerType(), -4399, -4399, getLocateSource(), a2, this.fGp);
                this.fFY = null;
            }
            this.fGp = 0L;
            return a2;
        } else {
            if (getPlayerType() == -100) {
                i2 = 0;
            } else if (getPlayerType() != -200) {
                i2 = 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i2));
            bhD();
            return false;
        }
    }

    public void bhB() {
        if (this.fGb != null) {
            this.fGb.bht();
        }
    }

    public void bhC() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fGw);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fGw, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
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
        this.fFJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fGb instanceof n) || ((n) this.fGb).bhI() == null) ? "" : ((n) this.fGb).bhI().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.play.b.b e(Uri uri) {
        String uri2;
        if (this.fFY != null) {
            return this.fFY;
        }
        if (!StringUtils.isNull(this.fGn)) {
            uri2 = this.fGn;
        } else if (fFX != null && this.fGb != null && !StringUtils.isNull(this.fGb.bhs())) {
            uri2 = this.fGb.bhs();
        } else {
            uri2 = (fFX == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2)) {
            this.fFY = fFX.F(this.aMq, uri2, this.fFZ);
        }
        this.fFZ = null;
        this.fGp = 0L;
        return this.fFY;
    }

    public static boolean qV(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("127.0.0.1") || !str.contains("http");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalVideoMd5(final String str) {
        if (this.fFY != null && !StringUtils.isNull(str)) {
            this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.7
                @Override // com.baidu.tieba.play.b.a
                public void J(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.play.b.a
                public void K(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.play.b.a
                public void L(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("localVideoMd5", str);
                }
            });
        }
    }

    public void setPbLoadingTime(final long j) {
        if (this.fFY != null) {
            this.fFY.a(new com.baidu.tieba.play.b.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
                private long fGA = 0;

                @Override // com.baidu.tieba.play.b.a
                public void J(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.play.b.a
                public void K(JSONObject jSONObject) throws JSONException {
                    this.fGA = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.play.b.a
                public void L(JSONObject jSONObject) throws JSONException {
                    if (this.fGA != 0 && j != 0 && this.fGA <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.fGA + j);
                    }
                }
            });
        }
    }
}

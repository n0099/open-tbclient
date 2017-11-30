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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.plugin.api.PayPluginManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.i.e;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.g;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl, com.baidu.tieba.play.b.c {
    private static h fOH;
    private static com.baidu.tieba.i.k fOI;
    private static int fPd = 0;
    private static int fPe = 1;
    private static int fPf = 2;
    private static int fPg = 1;
    private static int fPh = 0;
    private Map<String, String> Am;
    private String aMR;
    private final CustomMessageListener aZC;
    private g.a aZm;
    private g.f aZn;
    private g.b aZo;
    private g.c aZp;
    private g.e aZq;
    private g.InterfaceC0123g aZr;
    private g.i aZs;
    private g.d aZt;
    private g.h aZu;
    private int bdz;
    private b blr;
    private e.a eEh;
    private o fOE;
    private String fOF;
    private g fOG;
    private com.baidu.tieba.i.i fOJ;
    private com.baidu.tieba.i.e fOK;
    private String fOL;
    private boolean fOM;
    private d fON;
    private boolean fOO;
    private int fOP;
    private boolean fOQ;
    private int fOR;
    private boolean fOS;
    private SurfaceTexture fOT;
    private boolean fOU;
    private com.baidu.tieba.play.b.a fOV;
    private boolean fOW;
    private boolean fOX;
    private String fOY;
    private long fOZ;
    private a fOu;
    private boolean fPa;
    private long fPb;
    private long fPc;
    private int fPi;
    private int fPj;
    private int fPk;
    private int fPl;
    private int fPm;
    private int fPn;
    private TextureView.SurfaceTextureListener fPo;
    private g.f fPp;
    private g.a fPq;
    private g.InterfaceC0123g fPr;
    private Runnable fPs;
    private Runnable fPt;
    private Runnable fPu;
    private int fmN;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void biU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fOH = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            fOI = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fOU = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fmN = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdz = 0;
        this.fPo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNO();
                    }
                } else if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOu != null) {
                        QuickVideoView.this.fOu.biU();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNP();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lW(false);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.blr != null) {
                        QuickVideoView.this.blr.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPp = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.aNQ();
                }
                if (QuickVideoView.this.aZn != null) {
                    QuickVideoView.this.aZn.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    QuickVideoView.this.fON.onPrepared();
                    QuickVideoView.this.bjg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bja();
                        QuickVideoView.this.bjl();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOE != null && gVar != null) {
                    QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOF)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fOF).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fOF;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bjH()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fPq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lW(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZm != null) {
                        QuickVideoView.this.aZm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                QuickVideoView.this.start();
            }
        };
        this.aZp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bjC().av(QuickVideoView.this.fON.biV(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fON != null && !StringUtils.isNull(QuickVideoView.this.fON.biV())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fON.biV());
                        }
                    } else {
                        QuickVideoView.this.bjj();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fOV != null) {
                        z = QuickVideoView.this.fOV.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fOJ != null && z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (QuickVideoView.this.fON != null && !QuickVideoView.this.fOX && !z && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fOV.bjH();
                        QuickVideoView.this.fOX = true;
                        if (QuickVideoView.this.fOJ != null) {
                            QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                            QuickVideoView.this.fOJ = null;
                        }
                        QuickVideoView.this.fOZ = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fOJ != null && !z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (!z) {
                        QuickVideoView.this.bjm();
                    } else {
                        if (QuickVideoView.this.getPlayerType() == -100) {
                            i4 = 0;
                        } else {
                            i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                        }
                        TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                        return true;
                    }
                } else {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                }
                if (QuickVideoView.this.aZo == null || QuickVideoView.this.aZo.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fPr = new g.InterfaceC0123g() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.InterfaceC0123g
            public void a(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fPs, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZr != null) {
                    QuickVideoView.this.aZr.a(gVar);
                }
            }
        };
        this.aZq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fOP = i2;
                    if (QuickVideoView.this.fOE != null && gVar != null) {
                        QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNR();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNS();
                    QuickVideoView.this.fOW = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fPs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fOW = false;
            }
        };
        this.aZs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.17
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.g(i, i2, str);
                }
            }
        };
        this.aZt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pd(str);
                }
            }
        };
        this.aZu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fON != null && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV()))) {
                    QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fOV.bjH();
                    QuickVideoView.this.fOX = true;
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                    QuickVideoView.this.start();
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.biW() && QuickVideoView.this.fON.biX() && QuickVideoView.this.fON.biY() && QuickVideoView.this.fOG != null) {
                    int Ln = QuickVideoView.this.fOG.Ln();
                    int currentPosition = QuickVideoView.this.fOG.getCurrentPosition();
                    int duration = QuickVideoView.this.fOG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fON.biZ() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    if (QuickVideoView.this.bjh() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fmN == QuickVideoView.fPg) {
                        QuickVideoView.this.bjl();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pa(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
            }
        };
        this.eEh = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.i.e.a
            public void pl(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMR);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMR);
                    httpMessage.addParam("video_url", QuickVideoView.this.fOY);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.1
                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void I(JSONObject jSONObject) throws JSONException {
                                jSONObject.put("moov_bottom", 1);
                            }
                        });
                    }
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void onChange(final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", QuickVideoView.this.aMR);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.2
                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void I(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void is(boolean z) {
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fmN = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdz = 0;
        this.fPo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNO();
                    }
                } else if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOu != null) {
                        QuickVideoView.this.fOu.biU();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNP();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lW(false);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.blr != null) {
                        QuickVideoView.this.blr.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPp = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.aNQ();
                }
                if (QuickVideoView.this.aZn != null) {
                    QuickVideoView.this.aZn.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    QuickVideoView.this.fON.onPrepared();
                    QuickVideoView.this.bjg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bja();
                        QuickVideoView.this.bjl();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOE != null && gVar != null) {
                    QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOF)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fOF).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fOF;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bjH()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fPq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lW(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZm != null) {
                        QuickVideoView.this.aZm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                QuickVideoView.this.start();
            }
        };
        this.aZp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bjC().av(QuickVideoView.this.fON.biV(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fON != null && !StringUtils.isNull(QuickVideoView.this.fON.biV())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fON.biV());
                        }
                    } else {
                        QuickVideoView.this.bjj();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fOV != null) {
                        z = QuickVideoView.this.fOV.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fOJ != null && z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (QuickVideoView.this.fON != null && !QuickVideoView.this.fOX && !z && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fOV.bjH();
                        QuickVideoView.this.fOX = true;
                        if (QuickVideoView.this.fOJ != null) {
                            QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                            QuickVideoView.this.fOJ = null;
                        }
                        QuickVideoView.this.fOZ = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fOJ != null && !z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (!z) {
                        QuickVideoView.this.bjm();
                    } else {
                        if (QuickVideoView.this.getPlayerType() == -100) {
                            i4 = 0;
                        } else {
                            i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                        }
                        TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                        return true;
                    }
                } else {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                }
                if (QuickVideoView.this.aZo == null || QuickVideoView.this.aZo.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fPr = new g.InterfaceC0123g() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.InterfaceC0123g
            public void a(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fPs, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZr != null) {
                    QuickVideoView.this.aZr.a(gVar);
                }
            }
        };
        this.aZq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fOP = i2;
                    if (QuickVideoView.this.fOE != null && gVar != null) {
                        QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNR();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNS();
                    QuickVideoView.this.fOW = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fPs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fOW = false;
            }
        };
        this.aZs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.17
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.g(i, i2, str);
                }
            }
        };
        this.aZt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pd(str);
                }
            }
        };
        this.aZu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fON != null && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV()))) {
                    QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fOV.bjH();
                    QuickVideoView.this.fOX = true;
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                    QuickVideoView.this.start();
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.biW() && QuickVideoView.this.fON.biX() && QuickVideoView.this.fON.biY() && QuickVideoView.this.fOG != null) {
                    int Ln = QuickVideoView.this.fOG.Ln();
                    int currentPosition = QuickVideoView.this.fOG.getCurrentPosition();
                    int duration = QuickVideoView.this.fOG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fON.biZ() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    if (QuickVideoView.this.bjh() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fmN == QuickVideoView.fPg) {
                        QuickVideoView.this.bjl();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pa(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
            }
        };
        this.eEh = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.i.e.a
            public void pl(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMR);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMR);
                    httpMessage.addParam("video_url", QuickVideoView.this.fOY);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.1
                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void I(JSONObject jSONObject) throws JSONException {
                                jSONObject.put("moov_bottom", 1);
                            }
                        });
                    }
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void onChange(final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", QuickVideoView.this.aMR);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.2
                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void I(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void is(boolean z) {
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fOM = false;
        this.fOO = false;
        this.fOP = 0;
        this.fOQ = false;
        this.fOR = -1;
        this.fOS = false;
        this.fOT = null;
        this.fOU = true;
        this.fPb = 0L;
        this.fPc = 0L;
        this.fmN = fPh;
        this.fPi = 0;
        this.fPj = 0;
        this.fPk = -1;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdz = 0;
        this.fPo = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fOO) {
                    QuickVideoView.this.fOO = false;
                    if (QuickVideoView.this.fOG != null) {
                        QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNO();
                    }
                } else if (QuickVideoView.this.fOG != null && QuickVideoView.this.fOS) {
                    QuickVideoView.this.fOG.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Am, surfaceTexture, QuickVideoView.this.fOR);
                    if (QuickVideoView.this.fOu != null) {
                        QuickVideoView.this.fOu.biU();
                    }
                    if (QuickVideoView.this.e(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fOJ.aNP();
                    }
                }
                QuickVideoView.this.fOT = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lW(false);
                if (QuickVideoView.this.fOG != null) {
                    QuickVideoView.this.fOG.release();
                }
                if (!QuickVideoView.this.fOO) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onStop();
                    }
                    if (QuickVideoView.this.blr != null) {
                        QuickVideoView.this.blr.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fOT = null;
                if (QuickVideoView.this.fOJ != null && QuickVideoView.this.fOJ.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fOJ = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fPp = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.aNQ();
                }
                if (QuickVideoView.this.aZn != null) {
                    QuickVideoView.this.aZn.onPrepared(gVar);
                }
                if (QuickVideoView.this.fON != null) {
                    QuickVideoView.this.fON.onPrepared();
                    QuickVideoView.this.bjg();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fON.bja();
                        QuickVideoView.this.bjl();
                    }
                }
                if (QuickVideoView.this.fOM) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fOE != null && gVar != null) {
                    QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fOF)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fOF).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fOF;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fOV != null && QuickVideoView.this.fOV.bjH()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fPq = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lW(true);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
                if (!QuickVideoView.this.fOQ || QuickVideoView.this.fON == null) {
                    if (QuickVideoView.this.fON != null) {
                        QuickVideoView.this.fON.onCompletion();
                    }
                    QuickVideoView.this.fOM = false;
                    if (QuickVideoView.this.aZm != null) {
                        QuickVideoView.this.aZm.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fOL = null;
                QuickVideoView.this.fOZ = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                QuickVideoView.this.start();
            }
        };
        this.aZp = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i2, i22, i3);
                if (QuickVideoView.this.fON != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPa = true;
                    x.bjC().av(QuickVideoView.this.fON.biV(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fON != null && !StringUtils.isNull(QuickVideoView.this.fON.biV())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fON.biV());
                        }
                    } else {
                        QuickVideoView.this.bjj();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fOV != null) {
                        z = QuickVideoView.this.fOV.a(gVar, i2, i22, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fOJ != null && z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (QuickVideoView.this.fON != null && !QuickVideoView.this.fOX && !z && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fOV.bjH();
                        QuickVideoView.this.fOX = true;
                        if (QuickVideoView.this.fOJ != null) {
                            QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                            QuickVideoView.this.fOJ = null;
                        }
                        QuickVideoView.this.fOZ = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fOJ != null && !z) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    if (!z) {
                        QuickVideoView.this.bjm();
                    } else {
                        if (QuickVideoView.this.getPlayerType() == -100) {
                            i4 = 0;
                        } else {
                            i4 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                        }
                        TiebaStatic.log(new ak("c12493").r("obj_type", i4));
                        return true;
                    }
                } else {
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                }
                if (QuickVideoView.this.aZo == null || QuickVideoView.this.aZo.onError(gVar, i22, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fPr = new g.InterfaceC0123g() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.InterfaceC0123g
            public void a(g gVar) {
                if (QuickVideoView.this.fPa) {
                    QuickVideoView.this.fPa = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fPs, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fON != null && z) {
                    QuickVideoView.this.fON.onSeekComplete();
                }
                if (QuickVideoView.this.aZr != null) {
                    QuickVideoView.this.aZr.a(gVar);
                }
            }
        };
        this.aZq = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fOP = i22;
                    if (QuickVideoView.this.fOE != null && gVar != null) {
                        QuickVideoView.this.fOE.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fOP);
                        return true;
                    }
                    return true;
                } else if ((i2 == 701 || i22 == 701) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNR();
                    return true;
                } else if ((i2 == 702 || i22 == 702) && QuickVideoView.this.fOJ != null && !QuickVideoView.this.fOW) {
                    QuickVideoView.this.fOJ.aNS();
                    QuickVideoView.this.fOW = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fPs);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fPs = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fOW = false;
            }
        };
        this.aZs = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.17
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.g(i2, i22, str);
                }
            }
        };
        this.aZt = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pd(str);
                }
            }
        };
        this.aZu = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fOZ = j;
                }
            }
        };
        this.fPt = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if (QuickVideoView.this.fON != null && QuickVideoView.ro(QuickVideoView.this.fON.hE(QuickVideoView.this.fON.biV()))) {
                    QuickVideoView.this.fOG.forceUseSystemMediaPlayer(false);
                    QuickVideoView.this.fOV.bjH();
                    QuickVideoView.this.fOX = true;
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOL = QuickVideoView.this.fOJ.a(QuickVideoView.this.getPlayerType(), -5000, -5000, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fOZ);
                        QuickVideoView.this.fOJ = null;
                    }
                    QuickVideoView.this.fOZ = 0L;
                    QuickVideoView.this.setVideoPath(QuickVideoView.this.fON.biV());
                    QuickVideoView.this.start();
                }
            }
        };
        this.fPu = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fON != null && QuickVideoView.this.fON.biW() && QuickVideoView.this.fON.biX() && QuickVideoView.this.fON.biY() && QuickVideoView.this.fOG != null) {
                    int Ln = QuickVideoView.this.fOG.Ln();
                    int currentPosition = QuickVideoView.this.fOG.getCurrentPosition();
                    int duration = QuickVideoView.this.fOG.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPb;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fON.biZ() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    if (QuickVideoView.this.bjh() && currentPosition == QuickVideoView.this.fPc && j > 500) {
                        QuickVideoView.this.fPb = currentTimeMillis;
                        QuickVideoView.this.fON.sq(0);
                    }
                    QuickVideoView.this.fPc = currentPosition;
                    if (QuickVideoView.this.fmN == QuickVideoView.fPg) {
                        QuickVideoView.this.bjl();
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.pa(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fOJ = null;
                }
            }
        };
        this.eEh = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // com.baidu.tieba.i.e.a
            public void pl(int i2) {
                if (i2 == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMR);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMR);
                    httpMessage.addParam("video_url", QuickVideoView.this.fOY);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fOJ != null) {
                        QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.1
                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void I(JSONObject jSONObject) throws JSONException {
                                jSONObject.put("moov_bottom", 1);
                            }
                        });
                    }
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void onChange(final boolean z) {
                ak akVar = new ak("c12621");
                akVar.r("obj_locate", 1);
                akVar.r("obj_param1", z ? 1 : 0);
                akVar.ac("tid", QuickVideoView.this.aMR);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fOJ != null) {
                    QuickVideoView.this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.9.2
                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void I(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void is(boolean z) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fOE = new o(context);
        this.fOE.setSurfaceTextureListener(this.fPo);
        if (fOH != null) {
            this.fOG = fOH.Lo();
        }
        if (this.fOG != null) {
            this.fOG.setOnPreparedListener(this.fPp);
            this.fOG.setOnCompletionListener(this.fPq);
            this.fOG.a(this.aZp);
            this.fOG.setOnSeekCompleteListener(this.fPr);
            this.fOG.a(this.aZq);
            this.fOG.a(this.aZs);
            this.fOG.a(this.aZt);
            this.fOG.a(this.aZu);
        }
        aj.k(this, d.C0082d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fOV = new com.baidu.tieba.play.b.a(this);
        MessageManager.getInstance().registerListener(this.aZC);
    }

    public void bQ(String str, String str2) {
        this.aMR = str2;
        if (this.fOV != null) {
            this.fOV.clear();
            this.fOV.bjH();
        }
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
            if (fOI != null) {
                this.fOJ = fOI.F(this.aMR, str, "");
                if (this.fOJ != null) {
                    this.fOJ.a(-300, -44399, -44399, getLocateSource(), false, this.fOZ);
                    this.fOJ = null;
                }
            }
        }
        if (this.fOK != null) {
            this.fOK.a(null);
            this.fOK.aNH();
            this.fOK = null;
        }
        this.fOL = null;
        this.fOZ = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fOJ != null) {
            this.fOJ.aNU();
            this.fOJ = null;
        }
        if (!am.isEmpty(str)) {
            this.fOY = str;
            if (e(Uri.parse(str)) != null) {
                this.fOJ.aNN();
            }
            if (this.fON != null) {
                str = this.fON.hE(str);
                if (this.fON.getMediaProgressObserver() != null) {
                    this.fON.getMediaProgressObserver().setPlayer(this);
                }
                if (fOI != null && rp(str)) {
                    this.fOK = fOI.pf(str);
                }
                if (this.fOK != null) {
                    this.fOK.a(this.eEh);
                    this.fOK.aNG();
                }
                rn(str);
            }
            if (!com.baidu.adp.lib.util.j.hh() && !rp(str)) {
                if (this.aZo != null) {
                    this.aZo.onError(this.fOG, PayPluginManager.RESULT_CODE_UNKNOWN, PayPluginManager.RESULT_CODE_UNKNOWN);
                    return;
                }
                return;
            }
            setVideoURI(Uri.parse(str));
        }
    }

    private void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    private void a(Uri uri, Map<String, String> map) {
        if (e(uri) != null) {
            this.fOJ.oZ(uri.toString());
        }
        bjf();
        this.fOO = true;
        this.mUri = uri;
        this.Am = map;
        this.fOP = 0;
        removeView(this.fOE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fOU) {
            addView(this.fOE, layoutParams);
        } else {
            addView(this.fOE, 0, layoutParams);
        }
        aj.k(this, d.C0082d.cp_bg_line_k);
    }

    private void bjf() {
        this.fOO = false;
        this.fOM = false;
        if (this.fOG != null) {
            this.fOG.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPu);
    }

    private void rn(String str) {
        this.fPj = 0;
        this.fPk = 0;
        this.fPl = 0;
        this.fPm = 0;
        this.fPn = 0;
        this.bdz = 0;
        if (this.fON.biW()) {
            this.fPi = fPe;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fPk = (int) t.rr(QuickVideoView.this.fOY);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fOY != null && this.fOY.equals(str)) {
            this.fPi = fPd;
        } else {
            this.fPi = fPf;
        }
        this.fmN = fPg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjg() {
        this.fmN = fPg;
        if (this.fOG != null) {
            this.fPj = this.fOG.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(boolean z) {
        if (this.fmN == fPg && this.fOG != null) {
            this.fmN = fPh;
            this.fPm = this.fOG.getDuration();
            if (z) {
                this.fPn = 0;
                this.fPl = this.fPm;
            } else {
                this.fPl = this.fOG.getCurrentPosition();
                this.fPn = this.fOG.getCachedSize();
            }
            if (this.fPl > 0) {
                if (this.fPi == fPd) {
                    this.fPk = (int) t.rr(this.fOY);
                    if (this.fPj > 0) {
                        long j = (this.fPj * (this.fPl / 1000)) / 8;
                        if (this.fPn < 0) {
                            this.fPn = 0;
                        }
                        long j2 = this.fPn + j;
                        if (this.fPk > 0) {
                            j2 += this.fPk;
                        }
                        a(j2, this.fPl, this.fPm, this.bdz);
                    } else if (this.fPj == -1) {
                        this.fPj = 603327;
                        a((this.fPj * (this.fPl / 1000)) / 8, this.fPl, this.fPm, this.bdz);
                    }
                } else if (this.fPi == fPe) {
                    if (this.fPj > 0) {
                        long j3 = (this.fPj * (this.fPl / 1000)) / 8;
                        if (this.fPn < 0) {
                            this.fPn = 0;
                        }
                        long j4 = this.fPn + j3;
                        if (this.fPk > 0) {
                            j4 -= this.fPk;
                        }
                        a(j4, this.fPl, this.fPm, this.bdz);
                    } else if (this.fPj == -1) {
                        this.fPj = 603327;
                        a((this.fPj * (this.fPl / 1000)) / 8, this.fPl, this.fPm, this.bdz);
                    }
                } else {
                    a(0L, this.fPl, this.fPm, this.bdz);
                }
            }
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPu);
    }

    public void stopPlayback() {
        lW(false);
        if (this.fOV != null) {
            this.fOV.clear();
        }
        this.fOF = null;
        bjf();
        this.fOQ = false;
        if (this.fON != null) {
            this.fON.onStop();
        }
        com.baidu.tieba.play.a.b.bjF().a((b.InterfaceC0120b) null);
        if (this.fOJ != null && this.fOJ.pc(getLocateSource())) {
            this.fOJ = null;
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPu);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aZn = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aZm = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aZo = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0123g interfaceC0123g) {
        this.aZr = interfaceC0123g;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4) {
        if (this.fOG != null) {
            try {
                this.fOG.release();
                this.fOF = str;
                URI uri = new URI(this.mUri.toString());
                this.fOG.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Am, this.fOT, this.mUri.getHost());
                if (e(this.mUri) != null) {
                    this.fOJ.a(0, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4) {
        if (this.fOG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fOG.release();
            this.fOG.a(this.mContext, this.mUri, this.Am, this.fOT, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fOJ.a(1, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4) {
        if (this.fOG != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fOG.forceUseSystemMediaPlayer(true);
            }
            this.fOG.release();
            this.fOG.a(this.mContext, this.mUri, this.Am, this.fOT, this.mUri.getHost());
            if (e(this.mUri) != null) {
                this.fOJ.a(2, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fOM = true;
        if (this.fOG != null) {
            if (this.fOT != null && this.fOS && !this.fOG.isExistInRemote()) {
                this.fOG.a(this.mContext, this.mUri, this.Am, this.fOT, this.fOR);
                if (this.fOu != null) {
                    this.fOu.biU();
                }
                if (e(this.mUri) != null) {
                    this.fOJ.aNP();
                    return;
                }
                return;
            }
            this.fOG.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fON != null) {
            this.fON.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (e(this.mUri) != null) {
            this.fOJ.pm(this.fOG.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fOG != null) {
            this.fOG.pause();
        }
        if (this.fON != null) {
            this.fON.onPause();
        }
        this.fOM = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOJ != null) {
            this.fOJ.aNT();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fOG != null) {
            return this.fOG.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fOG != null) {
            return this.fOG.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdz = i;
        ss(i);
    }

    public void ss(int i) {
        this.fOW = true;
        if (this.fOG != null) {
            this.fOG.seekTo(i);
        }
        if (this.fON != null) {
            this.fON.sq(0);
            bjl();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fOG != null) {
            return this.fOG.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fOG != null) {
            this.fOG.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fOR = i;
    }

    public int getRecoveryState() {
        return this.fOR;
    }

    public void setNeedRecovery(boolean z) {
        this.fOS = z;
    }

    public void setLooping(boolean z) {
        this.fOQ = z;
    }

    public boolean bjh() {
        return this.fOM;
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
        this.blr = bVar;
    }

    public void setBusiness(d dVar) {
        this.fON = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fOQ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fOG != null) {
            this.fOG.Hp();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPs);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPt);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPu);
        MessageManager.getInstance().unRegisterListener(this.aZC);
        if (this.fOV != null) {
            this.fOV.clear();
        }
        if (this.fOK != null) {
            this.fOK.a(null);
            this.fOK.aNH();
        }
    }

    public g getPlayer() {
        return this.fOG;
    }

    public int getPlayerType() {
        if (this.fOG == null) {
            return -300;
        }
        return this.fOG.getPlayerType();
    }

    public boolean bji() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.fOX) {
            if (this.fOJ != null) {
                this.fOL = this.fOJ.a(getPlayerType(), -4399, -4399, getLocateSource(), false, this.fOZ);
                this.fOJ = null;
            }
            this.fOZ = 0L;
            if (getPlayerType() == -100) {
                i = 0;
            } else {
                i = getPlayerType() == -200 ? 1 : 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i));
            bjm();
            return false;
        } else if (this.fOV != null) {
            boolean a2 = this.fOV.a(this.fOG, getPlayerType(), 0, -4399, this.mUri);
            if (a2) {
                if (getPlayerType() != -100) {
                    i3 = getPlayerType() == -200 ? 1 : 2;
                }
                TiebaStatic.log(new ak("c12493").r("obj_type", i3));
            }
            if (this.fOJ != null) {
                this.fOL = this.fOJ.a(getPlayerType(), -4399, -4399, getLocateSource(), a2, this.fOZ);
                this.fOJ = null;
            }
            this.fOZ = 0L;
            return a2;
        } else {
            if (getPlayerType() == -100) {
                i2 = 0;
            } else if (getPlayerType() != -200) {
                i2 = 2;
            }
            TiebaStatic.log(new ak("c12194").r("obj_type", i2));
            bjm();
            return false;
        }
    }

    public void bjj() {
        if (this.fON != null) {
            this.fON.bjb();
        }
    }

    public void bjk() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPt);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fPt, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void bjl() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPu);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fPu, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjm() {
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
        this.fOu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fON instanceof n) || ((n) this.fON).bjs() == null) ? "" : ((n) this.fON).bjs().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i e(Uri uri) {
        String uri2;
        if (this.fOJ != null) {
            return this.fOJ;
        }
        if (!StringUtils.isNull(this.fOY)) {
            uri2 = this.fOY;
        } else if (fOI != null && this.fON != null && !StringUtils.isNull(this.fON.biV())) {
            uri2 = this.fON.biV();
        } else {
            uri2 = (fOI == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fOI != null) {
            this.fOJ = fOI.F(this.aMR, uri2, this.fOL);
        }
        this.fOL = null;
        this.fOZ = 0L;
        return this.fOJ;
    }

    public static boolean ro(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("127.0.0.1") || !str.contains("http");
    }

    public void a(final long j, final long j2, final long j3, final long j4) {
        if (this.fOJ != null) {
            this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.7
                @Override // com.baidu.tieba.i.b
                public void G(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void I(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put("video_duration", j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }

    public void setPbLoadingTime(final long j) {
        if (this.fOJ != null) {
            this.fOJ.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8
                private long fPA = 0;

                @Override // com.baidu.tieba.i.b
                public void G(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                    this.fPA = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.i.b
                public void I(JSONObject jSONObject) throws JSONException {
                    if (this.fPA != 0 && j != 0 && this.fPA <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.fPA + j);
                    }
                }
            });
        }
    }

    public static boolean rp(String str) {
        return (StringUtils.isNull(str) || str.contains("http")) ? false : true;
    }
}

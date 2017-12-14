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
    private static h fPA;
    private static com.baidu.tieba.i.k fPB;
    private static int fPW = 0;
    private static int fPX = 1;
    private static int fPY = 2;
    private static int fPZ = 1;
    private static int fQa = 0;
    private Map<String, String> Aj;
    private String aMU;
    private final CustomMessageListener aZD;
    private g.a aZo;
    private g.f aZp;
    private g.b aZq;
    private g.c aZr;
    private g.e aZs;
    private g.InterfaceC0138g aZt;
    private g.i aZu;
    private g.d aZv;
    private g.h aZw;
    private int bdA;
    private b bls;
    private e.a eFl;
    private com.baidu.tieba.i.i fPC;
    private com.baidu.tieba.i.e fPD;
    private String fPE;
    private boolean fPF;
    private d fPG;
    private boolean fPH;
    private int fPI;
    private boolean fPJ;
    private int fPK;
    private boolean fPL;
    private SurfaceTexture fPM;
    private boolean fPN;
    private com.baidu.tieba.play.b.a fPO;
    private boolean fPP;
    private boolean fPQ;
    private String fPR;
    private long fPS;
    private boolean fPT;
    private long fPU;
    private long fPV;
    private a fPn;
    private o fPx;
    private String fPy;
    private g fPz;
    private int fQb;
    private int fQc;
    private int fQd;
    private int fQe;
    private int fQf;
    private int fQg;
    private TextureView.SurfaceTextureListener fQh;
    private g.f fQi;
    private g.a fQj;
    private g.InterfaceC0138g fQk;
    private Runnable fQl;
    private Runnable fQm;
    private int fnL;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void bjc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, h.class);
        if (runTask != null) {
            fPA = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            fPB = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fPN = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fPF = false;
        this.fPH = false;
        this.fPI = 0;
        this.fPJ = false;
        this.fPK = -1;
        this.fPL = false;
        this.fPM = null;
        this.fPN = true;
        this.fPU = 0L;
        this.fPV = 0L;
        this.fnL = fQa;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = -1;
        this.fQe = 0;
        this.fQf = 0;
        this.fQg = 0;
        this.bdA = 0;
        this.fQh = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPH) {
                    QuickVideoView.this.fPH = false;
                    if (QuickVideoView.this.fPz != null) {
                        QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNX();
                    }
                } else if (QuickVideoView.this.fPz != null && QuickVideoView.this.fPL) {
                    QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fPK);
                    if (QuickVideoView.this.fPn != null) {
                        QuickVideoView.this.fPn.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNY();
                    }
                }
                QuickVideoView.this.fPM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPz != null) {
                    QuickVideoView.this.fPz.release();
                }
                if (!QuickVideoView.this.fPH) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onStop();
                    }
                    if (QuickVideoView.this.bls != null) {
                        QuickVideoView.this.bls.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPM = null;
                if (QuickVideoView.this.fPC != null && QuickVideoView.this.fPC.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPC = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQi = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.aNZ();
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPG != null) {
                    QuickVideoView.this.fPG.cI(QuickVideoView.this.fPz != null ? QuickVideoView.this.fPz.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPG.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPx != null && gVar != null) {
                    QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPy)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPy).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPO != null && QuickVideoView.this.fPO.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQj = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPC = null;
                }
                if (!QuickVideoView.this.fPJ || QuickVideoView.this.fPG == null) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onCompletion();
                    }
                    QuickVideoView.this.fPF = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPE = null;
                QuickVideoView.this.fPS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fPG != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPT = true;
                    x.bjK().aw(QuickVideoView.this.fPG.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPG != null && !StringUtils.isNull(QuickVideoView.this.fPG.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPG.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPO != null) {
                        z = QuickVideoView.this.fPO.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPC != null && z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (QuickVideoView.this.fPG != null && !QuickVideoView.this.fPQ && !z && QuickVideoView.ro(QuickVideoView.this.fPG.hC(QuickVideoView.this.fPG.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPz.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPO.bjP();
                        QuickVideoView.this.fPQ = true;
                        if (QuickVideoView.this.fPC != null) {
                            QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPS);
                            QuickVideoView.this.fPC = null;
                        }
                        QuickVideoView.this.fPS = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPC != null && !z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (!z) {
                        QuickVideoView.this.bjt();
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
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQk = new g.InterfaceC0138g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0138g
            public void a(g gVar) {
                if (QuickVideoView.this.fPT) {
                    QuickVideoView.this.fPT = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQl, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPG != null && z) {
                    QuickVideoView.this.fPG.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.a(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fPI = i2;
                    if (QuickVideoView.this.fPx != null && gVar != null) {
                        QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOa();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOb();
                    QuickVideoView.this.fPP = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPP = false;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.g(i, i2, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pd(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPS = j;
                }
            }
        };
        this.fQm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPG != null && QuickVideoView.this.fPG.bje() && QuickVideoView.this.fPG.bjf() && QuickVideoView.this.fPG.bjg() && QuickVideoView.this.fPz != null) {
                    int Ln = QuickVideoView.this.fPz.Ln();
                    int currentPosition = QuickVideoView.this.fPz.getCurrentPosition();
                    int duration = QuickVideoView.this.fPz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPU;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPG.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fPV && j > 500) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    QuickVideoView.this.fPV = currentPosition;
                    if (QuickVideoView.this.fnL == QuickVideoView.fPZ) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.bjk();
                    }
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPC = null;
                    }
                }
            }
        };
        this.eFl = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMU);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMU);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPR);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
                            @Override // com.baidu.tieba.i.b
                            public void F(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
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
                akVar.ac("tid", QuickVideoView.this.aMU);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
                        @Override // com.baidu.tieba.i.b
                        public void F(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void it(boolean z) {
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPF = false;
        this.fPH = false;
        this.fPI = 0;
        this.fPJ = false;
        this.fPK = -1;
        this.fPL = false;
        this.fPM = null;
        this.fPN = true;
        this.fPU = 0L;
        this.fPV = 0L;
        this.fnL = fQa;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = -1;
        this.fQe = 0;
        this.fQf = 0;
        this.fQg = 0;
        this.bdA = 0;
        this.fQh = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPH) {
                    QuickVideoView.this.fPH = false;
                    if (QuickVideoView.this.fPz != null) {
                        QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNX();
                    }
                } else if (QuickVideoView.this.fPz != null && QuickVideoView.this.fPL) {
                    QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fPK);
                    if (QuickVideoView.this.fPn != null) {
                        QuickVideoView.this.fPn.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNY();
                    }
                }
                QuickVideoView.this.fPM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPz != null) {
                    QuickVideoView.this.fPz.release();
                }
                if (!QuickVideoView.this.fPH) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onStop();
                    }
                    if (QuickVideoView.this.bls != null) {
                        QuickVideoView.this.bls.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPM = null;
                if (QuickVideoView.this.fPC != null && QuickVideoView.this.fPC.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPC = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQi = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.aNZ();
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPG != null) {
                    QuickVideoView.this.fPG.cI(QuickVideoView.this.fPz != null ? QuickVideoView.this.fPz.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPG.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPx != null && gVar != null) {
                    QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPy)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPy).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPO != null && QuickVideoView.this.fPO.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQj = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPC = null;
                }
                if (!QuickVideoView.this.fPJ || QuickVideoView.this.fPG == null) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onCompletion();
                    }
                    QuickVideoView.this.fPF = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPE = null;
                QuickVideoView.this.fPS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fPG != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPT = true;
                    x.bjK().aw(QuickVideoView.this.fPG.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPG != null && !StringUtils.isNull(QuickVideoView.this.fPG.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPG.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPO != null) {
                        z = QuickVideoView.this.fPO.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPC != null && z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (QuickVideoView.this.fPG != null && !QuickVideoView.this.fPQ && !z && QuickVideoView.ro(QuickVideoView.this.fPG.hC(QuickVideoView.this.fPG.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPz.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPO.bjP();
                        QuickVideoView.this.fPQ = true;
                        if (QuickVideoView.this.fPC != null) {
                            QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPS);
                            QuickVideoView.this.fPC = null;
                        }
                        QuickVideoView.this.fPS = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPC != null && !z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (!z) {
                        QuickVideoView.this.bjt();
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
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQk = new g.InterfaceC0138g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0138g
            public void a(g gVar) {
                if (QuickVideoView.this.fPT) {
                    QuickVideoView.this.fPT = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQl, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPG != null && z) {
                    QuickVideoView.this.fPG.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.a(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fPI = i2;
                    if (QuickVideoView.this.fPx != null && gVar != null) {
                        QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOa();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOb();
                    QuickVideoView.this.fPP = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPP = false;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.g(i, i2, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pd(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPS = j;
                }
            }
        };
        this.fQm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPG != null && QuickVideoView.this.fPG.bje() && QuickVideoView.this.fPG.bjf() && QuickVideoView.this.fPG.bjg() && QuickVideoView.this.fPz != null) {
                    int Ln = QuickVideoView.this.fPz.Ln();
                    int currentPosition = QuickVideoView.this.fPz.getCurrentPosition();
                    int duration = QuickVideoView.this.fPz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPU;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPG.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fPV && j > 500) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    QuickVideoView.this.fPV = currentPosition;
                    if (QuickVideoView.this.fnL == QuickVideoView.fPZ) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.bjk();
                    }
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPC = null;
                    }
                }
            }
        };
        this.eFl = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMU);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMU);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPR);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
                            @Override // com.baidu.tieba.i.b
                            public void F(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
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
                akVar.ac("tid", QuickVideoView.this.aMU);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
                        @Override // com.baidu.tieba.i.b
                        public void F(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void it(boolean z) {
            }
        };
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPF = false;
        this.fPH = false;
        this.fPI = 0;
        this.fPJ = false;
        this.fPK = -1;
        this.fPL = false;
        this.fPM = null;
        this.fPN = true;
        this.fPU = 0L;
        this.fPV = 0L;
        this.fnL = fQa;
        this.fQb = 0;
        this.fQc = 0;
        this.fQd = -1;
        this.fQe = 0;
        this.fQf = 0;
        this.fQg = 0;
        this.bdA = 0;
        this.fQh = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fPH) {
                    QuickVideoView.this.fPH = false;
                    if (QuickVideoView.this.fPz != null) {
                        QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNX();
                    }
                } else if (QuickVideoView.this.fPz != null && QuickVideoView.this.fPL) {
                    QuickVideoView.this.fPz.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Aj, surfaceTexture, QuickVideoView.this.fPK);
                    if (QuickVideoView.this.fPn != null) {
                        QuickVideoView.this.fPn.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPC.aNY();
                    }
                }
                QuickVideoView.this.fPM = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPz != null) {
                    QuickVideoView.this.fPz.release();
                }
                if (!QuickVideoView.this.fPH) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onStop();
                    }
                    if (QuickVideoView.this.bls != null) {
                        QuickVideoView.this.bls.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPM = null;
                if (QuickVideoView.this.fPC != null && QuickVideoView.this.fPC.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPC = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQi = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.aNZ();
                }
                if (QuickVideoView.this.aZp != null) {
                    QuickVideoView.this.aZp.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPG != null) {
                    QuickVideoView.this.fPG.cI(QuickVideoView.this.fPz != null ? QuickVideoView.this.fPz.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPG.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPF) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPx != null && gVar != null) {
                    QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPy)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPy).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPy;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPO != null && QuickVideoView.this.fPO.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQj = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPC = null;
                }
                if (!QuickVideoView.this.fPJ || QuickVideoView.this.fPG == null) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.onCompletion();
                    }
                    QuickVideoView.this.fPF = false;
                    if (QuickVideoView.this.aZo != null) {
                        QuickVideoView.this.aZo.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPE = null;
                QuickVideoView.this.fPS = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZr = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i2, i22, i3);
                if (QuickVideoView.this.fPG != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPT = true;
                    x.bjK().aw(QuickVideoView.this.fPG.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPG != null && !StringUtils.isNull(QuickVideoView.this.fPG.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPG.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPO != null) {
                        z = QuickVideoView.this.fPO.a(gVar, i2, i22, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPC != null && z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (QuickVideoView.this.fPG != null && !QuickVideoView.this.fPQ && !z && QuickVideoView.ro(QuickVideoView.this.fPG.hC(QuickVideoView.this.fPG.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPz.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPO.bjP();
                        QuickVideoView.this.fPQ = true;
                        if (QuickVideoView.this.fPC != null) {
                            QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPS);
                            QuickVideoView.this.fPC = null;
                        }
                        QuickVideoView.this.fPS = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPG.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPC != null && !z) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                    if (!z) {
                        QuickVideoView.this.bjt();
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
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPE = QuickVideoView.this.fPC.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPS);
                        QuickVideoView.this.fPC = null;
                    }
                    QuickVideoView.this.fPS = 0L;
                }
                if (QuickVideoView.this.aZq == null || QuickVideoView.this.aZq.onError(gVar, i22, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQk = new g.InterfaceC0138g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0138g
            public void a(g gVar) {
                if (QuickVideoView.this.fPT) {
                    QuickVideoView.this.fPT = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQl, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPG != null && z) {
                    QuickVideoView.this.fPG.onSeekComplete();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.a(gVar);
                }
            }
        };
        this.aZs = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fPI = i22;
                    if (QuickVideoView.this.fPx != null && gVar != null) {
                        QuickVideoView.this.fPx.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPI);
                        return true;
                    }
                    return true;
                } else if ((i2 == 701 || i22 == 701) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOa();
                    return true;
                } else if ((i2 == 702 || i22 == 702) && QuickVideoView.this.fPC != null && !QuickVideoView.this.fPP) {
                    QuickVideoView.this.fPC.aOb();
                    QuickVideoView.this.fPP = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQl);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQl = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPP = false;
            }
        };
        this.aZu = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.g(i2, i22, str);
                }
            }
        };
        this.aZv = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.pd(str);
                }
            }
        };
        this.aZw = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPS = j;
                }
            }
        };
        this.fQm = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPG != null && QuickVideoView.this.fPG.bje() && QuickVideoView.this.fPG.bjf() && QuickVideoView.this.fPG.bjg() && QuickVideoView.this.fPz != null) {
                    int Ln = QuickVideoView.this.fPz.Ln();
                    int currentPosition = QuickVideoView.this.fPz.getCurrentPosition();
                    int duration = QuickVideoView.this.fPz.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPU;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPG.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fPV && j > 500) {
                        QuickVideoView.this.fPU = currentTimeMillis;
                        QuickVideoView.this.fPG.sx(0);
                    }
                    QuickVideoView.this.fPV = currentPosition;
                    if (QuickVideoView.this.fnL == QuickVideoView.fPZ) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPG != null) {
                        QuickVideoView.this.fPG.bjk();
                    }
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPC = null;
                    }
                }
            }
        };
        this.eFl = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i2) {
                if (i2 == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMU);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMU);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPR);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPC != null) {
                        QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
                            @Override // com.baidu.tieba.i.b
                            public void F(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void G(JSONObject jSONObject) throws JSONException {
                            }

                            @Override // com.baidu.tieba.i.b
                            public void H(JSONObject jSONObject) throws JSONException {
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
                akVar.ac("tid", QuickVideoView.this.aMU);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPC != null) {
                    QuickVideoView.this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
                        @Override // com.baidu.tieba.i.b
                        public void F(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void G(JSONObject jSONObject) throws JSONException {
                        }

                        @Override // com.baidu.tieba.i.b
                        public void H(JSONObject jSONObject) throws JSONException {
                            jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                        }
                    });
                }
            }

            @Override // com.baidu.tieba.i.e.a
            public void it(boolean z) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fPx = new o(context);
        this.fPx.setSurfaceTextureListener(this.fQh);
        if (fPA != null) {
            this.fPz = fPA.Lo();
        }
        if (this.fPz != null) {
            this.fPz.setOnPreparedListener(this.fQi);
            this.fPz.setOnCompletionListener(this.fQj);
            this.fPz.a(this.aZr);
            this.fPz.setOnSeekCompleteListener(this.fQk);
            this.fPz.a(this.aZs);
            this.fPz.a(this.aZu);
            this.fPz.a(this.aZv);
            this.fPz.a(this.aZw);
        }
        aj.k(this, d.C0096d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fPO = new com.baidu.tieba.play.b.a(this);
        MessageManager.getInstance().registerListener(this.aZD);
    }

    public void bR(String str, String str2) {
        this.aMU = str2;
        if (this.fPO != null) {
            this.fPO.clear();
            this.fPO.bjP();
        }
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
            if (fPB != null) {
                this.fPC = fPB.F(this.aMU, str, "");
                if (this.fPC != null) {
                    this.fPC.a(-300, -44399, -44399, getLocateSource(), false, this.fPS);
                    this.fPC = null;
                }
            }
        }
        if (this.fPD != null) {
            this.fPD.a(null);
            this.fPD.aNQ();
            this.fPD = null;
        }
        this.fPE = null;
        this.fPS = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fPC != null) {
            this.fPC.aOd();
            this.fPC = null;
        }
        if (!am.isEmpty(str)) {
            this.fPR = str;
            if (f(Uri.parse(str)) != null) {
                this.fPC.aNW();
            }
            if (this.fPG != null) {
                str = this.fPG.hC(str);
                if (this.fPG.getMediaProgressObserver() != null) {
                    this.fPG.getMediaProgressObserver().setPlayer(this);
                }
                if (fPB != null && rp(str)) {
                    this.fPD = fPB.pf(str);
                }
                if (this.fPD != null) {
                    this.fPD.a(this.eFl);
                    this.fPD.aNP();
                }
                rn(str);
            }
            if (!com.baidu.adp.lib.util.j.hh() && !rp(str)) {
                if (this.aZq != null) {
                    this.aZq.onError(this.fPz, PayPluginManager.RESULT_CODE_UNKNOWN, PayPluginManager.RESULT_CODE_UNKNOWN);
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
        if (f(uri) != null) {
            this.fPC.oZ(uri.toString());
        }
        bjo();
        this.fPH = true;
        this.mUri = uri;
        this.Aj = map;
        this.fPI = 0;
        removeView(this.fPx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fPN) {
            addView(this.fPx, layoutParams);
        } else {
            addView(this.fPx, 0, layoutParams);
        }
        aj.k(this, d.C0096d.cp_bg_line_k);
    }

    private void bjo() {
        this.fPH = false;
        this.fPF = false;
        if (this.fPz != null) {
            this.fPz.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQm);
    }

    private void rn(String str) {
        this.fQc = 0;
        this.fQd = 0;
        this.fQe = 0;
        this.fQf = 0;
        this.fQg = 0;
        this.bdA = 0;
        if (this.fPG.bje()) {
            this.fQb = fPX;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fQd = (int) t.rr(QuickVideoView.this.fPR);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fPR != null && this.fPR.equals(str)) {
            this.fQb = fPW;
        } else {
            this.fQb = fPY;
        }
        this.fnL = fPZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjp() {
        this.fnL = fPZ;
        if (this.fPz != null) {
            this.fQc = this.fPz.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (this.fnL == fPZ && this.fPz != null) {
            this.fnL = fQa;
            this.fQf = this.fPz.getDuration();
            if (z) {
                this.fQg = 0;
                this.fQe = this.fQf;
            } else {
                this.fQe = this.fPz.getCurrentPosition();
                this.fQg = this.fPz.getCachedSize();
            }
            if (this.fQe > 0) {
                if (this.fQb == fPW) {
                    this.fQd = (int) t.rr(this.fPR);
                    if (this.fQc > 0) {
                        long j = (this.fQc * (this.fQe / 1000)) / 8;
                        if (this.fQg < 0) {
                            this.fQg = 0;
                        }
                        long j2 = this.fQg + j;
                        if (this.fQd > 0) {
                            j2 += this.fQd;
                        }
                        a(j2, this.fQe, this.fQf, this.bdA);
                    } else if (this.fQc == -1) {
                        this.fQc = 603327;
                        a((this.fQc * (this.fQe / 1000)) / 8, this.fQe, this.fQf, this.bdA);
                    }
                } else if (this.fQb == fPX) {
                    if (this.fQc > 0) {
                        long j3 = (this.fQc * (this.fQe / 1000)) / 8;
                        if (this.fQg < 0) {
                            this.fQg = 0;
                        }
                        long j4 = this.fQg + j3;
                        if (this.fQd > 0) {
                            j4 -= this.fQd;
                        }
                        a(j4, this.fQe, this.fQf, this.bdA);
                    } else if (this.fQc == -1) {
                        this.fQc = 603327;
                        a((this.fQc * (this.fQe / 1000)) / 8, this.fQe, this.fQf, this.bdA);
                    }
                } else {
                    a(0L, this.fQe, this.fQf, this.bdA);
                }
            }
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQm);
    }

    public void stopPlayback() {
        lY(false);
        if (this.fPO != null) {
            this.fPO.clear();
        }
        this.fPy = null;
        bjo();
        this.fPJ = false;
        if (this.fPG != null) {
            this.fPG.onStop();
        }
        com.baidu.tieba.play.a.b.bjN().a((b.InterfaceC0135b) null);
        if (this.fPC != null && this.fPC.pc(getLocateSource())) {
            this.fPC = null;
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQm);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aZp = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aZo = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aZq = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0138g interfaceC0138g) {
        this.aZt = interfaceC0138g;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4) {
        if (this.fPz != null) {
            try {
                this.fPz.release();
                this.fPy = str;
                URI uri = new URI(this.mUri.toString());
                this.fPz.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Aj, this.fPM, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.fPC.a(0, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4) {
        if (this.fPz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fPz.release();
            this.fPz.a(this.mContext, this.mUri, this.Aj, this.fPM, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPC.a(1, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4) {
        if (this.fPz != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fPz.forceUseSystemMediaPlayer(true);
            }
            this.fPz.release();
            this.fPz.a(this.mContext, this.mUri, this.Aj, this.fPM, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPC.a(2, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fPF = true;
        if (this.fPz != null) {
            if (this.fPM != null && this.fPL && !this.fPz.isExistInRemote()) {
                this.fPz.a(this.mContext, this.mUri, this.Aj, this.fPM, this.fPK);
                if (this.fPn != null) {
                    this.fPn.bjc();
                }
                if (f(this.mUri) != null) {
                    this.fPC.aNY();
                    return;
                }
                return;
            }
            this.fPz.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fPG != null) {
            this.fPG.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.fPC.pt(this.fPz.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fPz != null) {
            this.fPz.pause();
        }
        if (this.fPG != null) {
            this.fPG.onPause();
        }
        this.fPF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPC != null) {
            this.fPC.aOc();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fPz != null) {
            return this.fPz.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fPz != null) {
            return this.fPz.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdA = i;
        sz(i);
    }

    public void sz(int i) {
        this.fPP = true;
        if (this.fPz != null) {
            this.fPz.seekTo(i);
        }
        if (this.fPG != null) {
            this.fPG.sx(0);
            bjs();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fPz != null) {
            return this.fPz.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fPz != null) {
            this.fPz.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fPK = i;
    }

    public int getRecoveryState() {
        return this.fPK;
    }

    public void setNeedRecovery(boolean z) {
        this.fPL = z;
    }

    public void setLooping(boolean z) {
        this.fPJ = z;
    }

    public boolean bjq() {
        return this.fPF;
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
        this.bls = bVar;
    }

    public void setBusiness(d dVar) {
        this.fPG = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fPJ = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPz != null) {
            this.fPz.Hq();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQl);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQm);
        MessageManager.getInstance().unRegisterListener(this.aZD);
        if (this.fPO != null) {
            this.fPO.clear();
        }
        if (this.fPD != null) {
            this.fPD.a(null);
            this.fPD.aNQ();
        }
    }

    public g getPlayer() {
        return this.fPz;
    }

    public int getPlayerType() {
        if (this.fPz == null) {
            return -300;
        }
        return this.fPz.getPlayerType();
    }

    public void bjr() {
        if (this.fPG != null) {
            this.fPG.bjj();
        }
    }

    public void bjs() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQm);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fQm, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjt() {
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
        this.fPn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fPG instanceof n) || ((n) this.fPG).bjA() == null) ? "" : ((n) this.fPG).bjA().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i f(Uri uri) {
        String uri2;
        if (this.fPC != null) {
            return this.fPC;
        }
        if (!StringUtils.isNull(this.fPR)) {
            uri2 = this.fPR;
        } else if (fPB != null && this.fPG != null && !StringUtils.isNull(this.fPG.bjd())) {
            uri2 = this.fPG.bjd();
        } else {
            uri2 = (fPB == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fPB != null) {
            this.fPC = fPB.F(this.aMU, uri2, this.fPE);
        }
        this.fPE = null;
        this.fPS = 0L;
        return this.fPC;
    }

    public static boolean ro(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("127.0.0.1") || !str.contains("http");
    }

    public void a(final long j, final long j2, final long j3, final long j4) {
        if (this.fPC != null) {
            this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.6
                @Override // com.baidu.tieba.i.b
                public void F(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void G(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put("video_duration", j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }

    public void setPbLoadingTime(final long j) {
        if (this.fPC != null) {
            this.fPC.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.7
                private long fQs = 0;

                @Override // com.baidu.tieba.i.b
                public void F(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void G(JSONObject jSONObject) throws JSONException {
                    this.fQs = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                    if (this.fQs != 0 && j != 0 && this.fQs <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.fQs + j);
                    }
                }
            });
        }
    }

    public static boolean rp(String str) {
        return (StringUtils.isNull(str) || str.contains("http")) ? false : true;
    }
}

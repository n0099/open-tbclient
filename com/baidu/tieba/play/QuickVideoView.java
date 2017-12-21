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
    private static h fPF;
    private static com.baidu.tieba.i.k fPG;
    private static int fQb = 0;
    private static int fQc = 1;
    private static int fQd = 2;
    private static int fQe = 1;
    private static int fQf = 0;
    private Map<String, String> Ak;
    private String aMX;
    private g.h aZA;
    private final CustomMessageListener aZH;
    private g.a aZs;
    private g.f aZt;
    private g.b aZu;
    private g.c aZv;
    private g.e aZw;
    private g.InterfaceC0137g aZx;
    private g.i aZy;
    private g.d aZz;
    private int bdE;
    private b blw;
    private e.a eFp;
    private o fPC;
    private String fPD;
    private g fPE;
    private com.baidu.tieba.i.i fPH;
    private com.baidu.tieba.i.e fPI;
    private String fPJ;
    private boolean fPK;
    private d fPL;
    private boolean fPM;
    private int fPN;
    private boolean fPO;
    private int fPP;
    private boolean fPQ;
    private SurfaceTexture fPR;
    private boolean fPS;
    private com.baidu.tieba.play.b.a fPT;
    private boolean fPU;
    private boolean fPV;
    private String fPW;
    private long fPX;
    private boolean fPY;
    private long fPZ;
    private a fPs;
    private long fQa;
    private int fQg;
    private int fQh;
    private int fQi;
    private int fQj;
    private int fQk;
    private int fQl;
    private TextureView.SurfaceTextureListener fQm;
    private g.f fQn;
    private g.a fQo;
    private g.InterfaceC0137g fQp;
    private Runnable fQq;
    private Runnable fQr;
    private int fnQ;
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
            fPF = (h) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        if (runTask2 != null) {
            fPG = (com.baidu.tieba.i.k) runTask2.getData();
        }
    }

    public void setIsVideoViewToTop(boolean z) {
        this.fPS = z;
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fPK = false;
        this.fPM = false;
        this.fPN = 0;
        this.fPO = false;
        this.fPP = -1;
        this.fPQ = false;
        this.fPR = null;
        this.fPS = true;
        this.fPZ = 0L;
        this.fQa = 0L;
        this.fnQ = fQf;
        this.fQg = 0;
        this.fQh = 0;
        this.fQi = -1;
        this.fQj = 0;
        this.fQk = 0;
        this.fQl = 0;
        this.bdE = 0;
        this.fQm = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPM) {
                    QuickVideoView.this.fPM = false;
                    if (QuickVideoView.this.fPE != null) {
                        QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNX();
                    }
                } else if (QuickVideoView.this.fPE != null && QuickVideoView.this.fPQ) {
                    QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.fPP);
                    if (QuickVideoView.this.fPs != null) {
                        QuickVideoView.this.fPs.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNY();
                    }
                }
                QuickVideoView.this.fPR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPE != null) {
                    QuickVideoView.this.fPE.release();
                }
                if (!QuickVideoView.this.fPM) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onStop();
                    }
                    if (QuickVideoView.this.blw != null) {
                        QuickVideoView.this.blw.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPR = null;
                if (QuickVideoView.this.fPH != null && QuickVideoView.this.fPH.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQn = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.aNZ();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPL != null) {
                    QuickVideoView.this.fPL.cI(QuickVideoView.this.fPE != null ? QuickVideoView.this.fPE.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPL.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPC != null && gVar != null) {
                    QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPD)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPD).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPD;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPT != null && QuickVideoView.this.fPT.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQo = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPH = null;
                }
                if (!QuickVideoView.this.fPO || QuickVideoView.this.fPL == null) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onCompletion();
                    }
                    QuickVideoView.this.fPK = false;
                    if (QuickVideoView.this.aZs != null) {
                        QuickVideoView.this.aZs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPJ = null;
                QuickVideoView.this.fPX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fPL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPY = true;
                    x.bjK().aw(QuickVideoView.this.fPL.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPL != null && !StringUtils.isNull(QuickVideoView.this.fPL.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPL.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPT != null) {
                        z = QuickVideoView.this.fPT.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPH != null && z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                    if (QuickVideoView.this.fPL != null && !QuickVideoView.this.fPV && !z && QuickVideoView.ro(QuickVideoView.this.fPL.hC(QuickVideoView.this.fPL.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPE.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPT.bjP();
                        QuickVideoView.this.fPV = true;
                        if (QuickVideoView.this.fPH != null) {
                            QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPX);
                            QuickVideoView.this.fPH = null;
                        }
                        QuickVideoView.this.fPX = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPH != null && !z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
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
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                }
                if (QuickVideoView.this.aZu == null || QuickVideoView.this.aZu.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQp = new g.InterfaceC0137g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0137g
            public void a(g gVar) {
                if (QuickVideoView.this.fPY) {
                    QuickVideoView.this.fPY = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQq, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPL != null && z) {
                    QuickVideoView.this.fPL.onSeekComplete();
                }
                if (QuickVideoView.this.aZx != null) {
                    QuickVideoView.this.aZx.a(gVar);
                }
            }
        };
        this.aZw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fPN = i2;
                    if (QuickVideoView.this.fPC != null && gVar != null) {
                        QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOa();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOb();
                    QuickVideoView.this.fPU = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPU = false;
            }
        };
        this.aZy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.g(i, i2, str);
                }
            }
        };
        this.aZz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pd(str);
                }
            }
        };
        this.aZA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPX = j;
                }
            }
        };
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPL != null && QuickVideoView.this.fPL.bje() && QuickVideoView.this.fPL.bjf() && QuickVideoView.this.fPL.bjg() && QuickVideoView.this.fPE != null) {
                    int Ln = QuickVideoView.this.fPE.Ln();
                    int currentPosition = QuickVideoView.this.fPE.getCurrentPosition();
                    int duration = QuickVideoView.this.fPE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPZ;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPL.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fQa && j > 500) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    QuickVideoView.this.fQa = currentPosition;
                    if (QuickVideoView.this.fnQ == QuickVideoView.fQe) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZH = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.bjk();
                    }
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPH = null;
                    }
                }
            }
        };
        this.eFp = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMX);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMX);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPW);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
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
                akVar.ac("tid", QuickVideoView.this.aMX);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
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
        this.fPK = false;
        this.fPM = false;
        this.fPN = 0;
        this.fPO = false;
        this.fPP = -1;
        this.fPQ = false;
        this.fPR = null;
        this.fPS = true;
        this.fPZ = 0L;
        this.fQa = 0L;
        this.fnQ = fQf;
        this.fQg = 0;
        this.fQh = 0;
        this.fQi = -1;
        this.fQj = 0;
        this.fQk = 0;
        this.fQl = 0;
        this.bdE = 0;
        this.fQm = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (QuickVideoView.this.fPM) {
                    QuickVideoView.this.fPM = false;
                    if (QuickVideoView.this.fPE != null) {
                        QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNX();
                    }
                } else if (QuickVideoView.this.fPE != null && QuickVideoView.this.fPQ) {
                    QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.fPP);
                    if (QuickVideoView.this.fPs != null) {
                        QuickVideoView.this.fPs.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNY();
                    }
                }
                QuickVideoView.this.fPR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPE != null) {
                    QuickVideoView.this.fPE.release();
                }
                if (!QuickVideoView.this.fPM) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onStop();
                    }
                    if (QuickVideoView.this.blw != null) {
                        QuickVideoView.this.blw.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPR = null;
                if (QuickVideoView.this.fPH != null && QuickVideoView.this.fPH.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQn = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.aNZ();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPL != null) {
                    QuickVideoView.this.fPL.cI(QuickVideoView.this.fPE != null ? QuickVideoView.this.fPE.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPL.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPC != null && gVar != null) {
                    QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPD)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPD).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPD;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPT != null && QuickVideoView.this.fPT.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i = 0;
                    } else {
                        i = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQo = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPH = null;
                }
                if (!QuickVideoView.this.fPO || QuickVideoView.this.fPL == null) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onCompletion();
                    }
                    QuickVideoView.this.fPK = false;
                    if (QuickVideoView.this.aZs != null) {
                        QuickVideoView.this.aZs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPJ = null;
                QuickVideoView.this.fPX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i, int i2, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i, i2, i3);
                if (QuickVideoView.this.fPL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPY = true;
                    x.bjK().aw(QuickVideoView.this.fPL.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPL != null && !StringUtils.isNull(QuickVideoView.this.fPL.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPL.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPT != null) {
                        z = QuickVideoView.this.fPT.a(gVar, i, i2, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPH != null && z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                    if (QuickVideoView.this.fPL != null && !QuickVideoView.this.fPV && !z && QuickVideoView.ro(QuickVideoView.this.fPL.hC(QuickVideoView.this.fPL.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPE.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPT.bjP();
                        QuickVideoView.this.fPV = true;
                        if (QuickVideoView.this.fPH != null) {
                            QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPX);
                            QuickVideoView.this.fPH = null;
                        }
                        QuickVideoView.this.fPX = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPH != null && !z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
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
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i, i2, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                }
                if (QuickVideoView.this.aZu == null || QuickVideoView.this.aZu.onError(gVar, i2, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQp = new g.InterfaceC0137g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0137g
            public void a(g gVar) {
                if (QuickVideoView.this.fPY) {
                    QuickVideoView.this.fPY = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQq, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPL != null && z) {
                    QuickVideoView.this.fPL.onSeekComplete();
                }
                if (QuickVideoView.this.aZx != null) {
                    QuickVideoView.this.aZx.a(gVar);
                }
            }
        };
        this.aZw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i, int i2) {
                if (i == 10001) {
                    QuickVideoView.this.fPN = i2;
                    if (QuickVideoView.this.fPC != null && gVar != null) {
                        QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                        return true;
                    }
                    return true;
                } else if ((i == 701 || i2 == 701) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOa();
                    return true;
                } else if ((i == 702 || i2 == 702) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOb();
                    QuickVideoView.this.fPU = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPU = false;
            }
        };
        this.aZy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i, int i2, String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.g(i, i2, str);
                }
            }
        };
        this.aZz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pd(str);
                }
            }
        };
        this.aZA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPX = j;
                }
            }
        };
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPL != null && QuickVideoView.this.fPL.bje() && QuickVideoView.this.fPL.bjf() && QuickVideoView.this.fPL.bjg() && QuickVideoView.this.fPE != null) {
                    int Ln = QuickVideoView.this.fPE.Ln();
                    int currentPosition = QuickVideoView.this.fPE.getCurrentPosition();
                    int duration = QuickVideoView.this.fPE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPZ;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPL.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fQa && j > 500) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    QuickVideoView.this.fQa = currentPosition;
                    if (QuickVideoView.this.fnQ == QuickVideoView.fQe) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZH = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.bjk();
                    }
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPH = null;
                    }
                }
            }
        };
        this.eFp = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i) {
                if (i == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMX);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMX);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPW);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
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
                akVar.ac("tid", QuickVideoView.this.aMX);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
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
        this.fPK = false;
        this.fPM = false;
        this.fPN = 0;
        this.fPO = false;
        this.fPP = -1;
        this.fPQ = false;
        this.fPR = null;
        this.fPS = true;
        this.fPZ = 0L;
        this.fQa = 0L;
        this.fnQ = fQf;
        this.fQg = 0;
        this.fQh = 0;
        this.fQi = -1;
        this.fQj = 0;
        this.fQk = 0;
        this.fQl = 0;
        this.bdE = 0;
        this.fQm = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.play.QuickVideoView.9
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i22) {
                if (QuickVideoView.this.fPM) {
                    QuickVideoView.this.fPM = false;
                    if (QuickVideoView.this.fPE != null) {
                        QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.mUri.getHost());
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNX();
                    }
                } else if (QuickVideoView.this.fPE != null && QuickVideoView.this.fPQ) {
                    QuickVideoView.this.fPE.a(QuickVideoView.this.mContext, QuickVideoView.this.mUri, QuickVideoView.this.Ak, surfaceTexture, QuickVideoView.this.fPP);
                    if (QuickVideoView.this.fPs != null) {
                        QuickVideoView.this.fPs.bjc();
                    }
                    if (QuickVideoView.this.f(QuickVideoView.this.mUri) != null) {
                        QuickVideoView.this.fPH.aNY();
                    }
                }
                QuickVideoView.this.fPR = surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i22) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                QuickVideoView.this.lY(false);
                if (QuickVideoView.this.fPE != null) {
                    QuickVideoView.this.fPE.release();
                }
                if (!QuickVideoView.this.fPM) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onStop();
                    }
                    if (QuickVideoView.this.blw != null) {
                        QuickVideoView.this.blw.onSurfaceDestroyed();
                    }
                }
                QuickVideoView.this.fPR = null;
                if (QuickVideoView.this.fPH != null && QuickVideoView.this.fPH.pc(QuickVideoView.this.getLocateSource())) {
                    QuickVideoView.this.fPH = null;
                }
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.fQn = new g.f() { // from class: com.baidu.tieba.play.QuickVideoView.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.aNZ();
                }
                if (QuickVideoView.this.aZt != null) {
                    QuickVideoView.this.aZt.onPrepared(gVar);
                }
                if (QuickVideoView.this.fPL != null) {
                    QuickVideoView.this.fPL.cI(QuickVideoView.this.fPE != null ? QuickVideoView.this.fPE.getDuration() : 0L);
                    QuickVideoView.this.bjp();
                    if (QuickVideoView.this.getPlayerType() == -200) {
                        QuickVideoView.this.fPL.bji();
                        QuickVideoView.this.bjs();
                    }
                }
                if (QuickVideoView.this.fPK) {
                    QuickVideoView.this.start();
                }
                if (QuickVideoView.this.fPC != null && gVar != null) {
                    QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                }
                if (!TextUtils.isEmpty(QuickVideoView.this.fPD)) {
                    TiebaStatic.log(new ak("c12199").ac("obj_param1", QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString()).ac("obj_param2", QuickVideoView.this.fPD).ac("obj_param3", com.baidu.tbadk.core.util.d.getIp()));
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    Object[] objArr = new Object[6];
                    objArr[0] = "url";
                    objArr[1] = QuickVideoView.this.mUri == null ? "null" : QuickVideoView.this.mUri.toString();
                    objArr[2] = "dnsIP";
                    objArr[3] = QuickVideoView.this.fPD;
                    objArr[4] = "clientip";
                    objArr[5] = com.baidu.tbadk.core.util.d.getIp();
                    bdStatisticsManager.newDebug("videoplay", 0L, null, objArr);
                }
                if (QuickVideoView.this.fPT != null && QuickVideoView.this.fPT.bjP()) {
                    if (QuickVideoView.this.getPlayerType() == -100) {
                        i2 = 0;
                    } else {
                        i2 = QuickVideoView.this.getPlayerType() == -200 ? 1 : 2;
                    }
                    TiebaStatic.log(new ak("c12494").r("obj_type", i2).r("obj_param1", com.baidu.adp.lib.util.j.hi() ? 0 : 1));
                }
            }
        };
        this.fQo = new g.a() { // from class: com.baidu.tieba.play.QuickVideoView.11
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                QuickVideoView.this.lY(true);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pb(QuickVideoView.this.getLocateSource());
                    QuickVideoView.this.fPH = null;
                }
                if (!QuickVideoView.this.fPO || QuickVideoView.this.fPL == null) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.onCompletion();
                    }
                    QuickVideoView.this.fPK = false;
                    if (QuickVideoView.this.aZs != null) {
                        QuickVideoView.this.aZs.onCompletion(gVar);
                        return;
                    }
                    return;
                }
                QuickVideoView.this.fPJ = null;
                QuickVideoView.this.fPX = 0L;
                QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                QuickVideoView.this.start();
            }
        };
        this.aZv = new g.c() { // from class: com.baidu.tieba.play.QuickVideoView.12
            @Override // com.baidu.tieba.play.g.c
            public boolean a(g gVar, int i2, int i22, int i3) {
                int i4;
                com.baidu.tieba.play.b.a.Y(i2, i22, i3);
                if (QuickVideoView.this.fPL != null && QuickVideoView.this.getCurrentPosition() > 0) {
                    QuickVideoView.this.fPY = true;
                    x.bjK().aw(QuickVideoView.this.fPL.bjd(), QuickVideoView.this.getCurrentPosition());
                }
                if (com.baidu.adp.lib.util.j.hh()) {
                    if (QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        if (QuickVideoView.this.fPL != null && !StringUtils.isNull(QuickVideoView.this.fPL.bjd())) {
                            String uri = QuickVideoView.this.mUri.toString();
                            if (!uri.contains("http")) {
                                com.baidu.tieba.play.b.a.rw(uri);
                            }
                            QuickVideoView.this.mUri = Uri.parse(QuickVideoView.this.fPL.bjd());
                        }
                    } else {
                        QuickVideoView.this.bjr();
                    }
                    boolean z = false;
                    if (QuickVideoView.this.fPT != null) {
                        z = QuickVideoView.this.fPT.a(gVar, i2, i22, i3, QuickVideoView.this.mUri);
                    }
                    if (QuickVideoView.this.fPH != null && z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                    if (QuickVideoView.this.fPL != null && !QuickVideoView.this.fPV && !z && QuickVideoView.ro(QuickVideoView.this.fPL.hC(QuickVideoView.this.fPL.bjd())) && !QuickVideoView.ro(QuickVideoView.this.mUri.toString())) {
                        z = true;
                        QuickVideoView.this.fPE.forceUseSystemMediaPlayer(false);
                        QuickVideoView.this.fPT.bjP();
                        QuickVideoView.this.fPV = true;
                        if (QuickVideoView.this.fPH != null) {
                            QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), true, QuickVideoView.this.fPX);
                            QuickVideoView.this.fPH = null;
                        }
                        QuickVideoView.this.fPX = 0L;
                        QuickVideoView.this.setVideoPath(QuickVideoView.this.fPL.bjd());
                        QuickVideoView.this.start();
                    }
                    if (QuickVideoView.this.fPH != null && !z) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), z, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
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
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPJ = QuickVideoView.this.fPH.a(i2, i22, i3, QuickVideoView.this.getLocateSource(), false, QuickVideoView.this.fPX);
                        QuickVideoView.this.fPH = null;
                    }
                    QuickVideoView.this.fPX = 0L;
                }
                if (QuickVideoView.this.aZu == null || QuickVideoView.this.aZu.onError(gVar, i22, i3)) {
                    return true;
                }
                return true;
            }
        };
        this.fQp = new g.InterfaceC0137g() { // from class: com.baidu.tieba.play.QuickVideoView.13
            @Override // com.baidu.tieba.play.g.InterfaceC0137g
            public void a(g gVar) {
                if (QuickVideoView.this.fPY) {
                    QuickVideoView.this.fPY = false;
                    return;
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                com.baidu.adp.lib.g.e.fP().postDelayed(QuickVideoView.this.fQq, 500L);
                boolean z = QuickVideoView.this.getPlayerType() == -200;
                if (QuickVideoView.this.fPL != null && z) {
                    QuickVideoView.this.fPL.onSeekComplete();
                }
                if (QuickVideoView.this.aZx != null) {
                    QuickVideoView.this.aZx.a(gVar);
                }
            }
        };
        this.aZw = new g.e() { // from class: com.baidu.tieba.play.QuickVideoView.14
            @Override // com.baidu.tieba.play.g.e
            public boolean a(g gVar, int i2, int i22) {
                if (i2 == 10001) {
                    QuickVideoView.this.fPN = i22;
                    if (QuickVideoView.this.fPC != null && gVar != null) {
                        QuickVideoView.this.fPC.X(gVar.getVideoWidth(), gVar.getVideoHeight(), QuickVideoView.this.fPN);
                        return true;
                    }
                    return true;
                } else if ((i2 == 701 || i22 == 701) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOa();
                    return true;
                } else if ((i2 == 702 || i22 == 702) && QuickVideoView.this.fPH != null && !QuickVideoView.this.fPU) {
                    QuickVideoView.this.fPH.aOb();
                    QuickVideoView.this.fPU = false;
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(QuickVideoView.this.fQq);
                    return true;
                } else {
                    return true;
                }
            }
        };
        this.fQq = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                QuickVideoView.this.fPU = false;
            }
        };
        this.aZy = new g.i() { // from class: com.baidu.tieba.play.QuickVideoView.16
            @Override // com.baidu.tieba.play.g.i
            public void onSubError(int i2, int i22, String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.g(i2, i22, str);
                }
            }
        };
        this.aZz = new g.d() { // from class: com.baidu.tieba.play.QuickVideoView.2
            @Override // com.baidu.tieba.play.g.d
            public void onHandleOppoError(String str) {
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.pd(str);
                }
            }
        };
        this.aZA = new g.h() { // from class: com.baidu.tieba.play.QuickVideoView.3
            @Override // com.baidu.tieba.play.g.h
            public void onSpeed(long j) {
                if (j != 0) {
                    QuickVideoView.this.fPX = j;
                }
            }
        };
        this.fQr = new Runnable() { // from class: com.baidu.tieba.play.QuickVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((QuickVideoView.this.getPlayerType() == -200) && QuickVideoView.this.fPL != null && QuickVideoView.this.fPL.bje() && QuickVideoView.this.fPL.bjf() && QuickVideoView.this.fPL.bjg() && QuickVideoView.this.fPE != null) {
                    int Ln = QuickVideoView.this.fPE.Ln();
                    int currentPosition = QuickVideoView.this.fPE.getCurrentPosition();
                    int duration = QuickVideoView.this.fPE.getDuration();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - QuickVideoView.this.fPZ;
                    boolean z = currentPosition + Ln < duration;
                    if (Ln < QuickVideoView.this.fPL.bjh() * 1000 && j > TbConfig.NOTIFY_SOUND_INTERVAL && z) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    if (QuickVideoView.this.bjq() && currentPosition == QuickVideoView.this.fQa && j > 500) {
                        QuickVideoView.this.fPZ = currentTimeMillis;
                        QuickVideoView.this.fPL.sx(0);
                    }
                    QuickVideoView.this.fQa = currentPosition;
                    if (QuickVideoView.this.fnQ == QuickVideoView.fQe) {
                        QuickVideoView.this.bjs();
                    }
                }
            }
        };
        this.aZH = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.QuickVideoView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (QuickVideoView.this.fPL != null) {
                        QuickVideoView.this.fPL.bjk();
                    }
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.pa(QuickVideoView.this.getLocateSource());
                        QuickVideoView.this.fPH = null;
                    }
                }
            }
        };
        this.eFp = new e.a() { // from class: com.baidu.tieba.play.QuickVideoView.8
            @Override // com.baidu.tieba.i.e.a
            public void ps(int i2) {
                if (i2 == 1) {
                    ak akVar = new ak("c12620");
                    akVar.r("obj_locate", 1);
                    akVar.ac("tid", QuickVideoView.this.aMX);
                    TiebaStatic.log(akVar);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
                    httpMessage.addParam("thread_id", QuickVideoView.this.aMX);
                    httpMessage.addParam("video_url", QuickVideoView.this.fPW);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    if (QuickVideoView.this.fPH != null) {
                        QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.1
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
                akVar.ac("tid", QuickVideoView.this.aMX);
                TiebaStatic.log(akVar);
                if (QuickVideoView.this.fPH != null) {
                    QuickVideoView.this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.8.2
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
        this.fPC = new o(context);
        this.fPC.setSurfaceTextureListener(this.fQm);
        if (fPF != null) {
            this.fPE = fPF.Lo();
        }
        if (this.fPE != null) {
            this.fPE.setOnPreparedListener(this.fQn);
            this.fPE.setOnCompletionListener(this.fQo);
            this.fPE.a(this.aZv);
            this.fPE.setOnSeekCompleteListener(this.fQp);
            this.fPE.a(this.aZw);
            this.fPE.a(this.aZy);
            this.fPE.a(this.aZz);
            this.fPE.a(this.aZA);
        }
        aj.k(this, d.C0095d.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(536870922, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.fPT = new com.baidu.tieba.play.b.a(this);
        MessageManager.getInstance().registerListener(this.aZH);
    }

    public void bR(String str, String str2) {
        this.aMX = str2;
        if (this.fPT != null) {
            this.fPT.clear();
            this.fPT.bjP();
        }
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
            if (fPG != null) {
                this.fPH = fPG.F(this.aMX, str, "");
                if (this.fPH != null) {
                    this.fPH.a(-300, -44399, -44399, getLocateSource(), false, this.fPX);
                    this.fPH = null;
                }
            }
        }
        if (this.fPI != null) {
            this.fPI.a(null);
            this.fPI.aNQ();
            this.fPI = null;
        }
        this.fPJ = null;
        this.fPX = 0L;
        setVideoPath(str);
    }

    public void setVideoPath(String str) {
        if (this.fPH != null) {
            this.fPH.aOd();
            this.fPH = null;
        }
        if (!am.isEmpty(str)) {
            this.fPW = str;
            if (f(Uri.parse(str)) != null) {
                this.fPH.aNW();
            }
            if (this.fPL != null) {
                str = this.fPL.hC(str);
                if (this.fPL.getMediaProgressObserver() != null) {
                    this.fPL.getMediaProgressObserver().setPlayer(this);
                }
                if (fPG != null && rp(str)) {
                    this.fPI = fPG.pf(str);
                }
                if (this.fPI != null) {
                    this.fPI.a(this.eFp);
                    this.fPI.aNP();
                }
                rn(str);
            }
            if (!com.baidu.adp.lib.util.j.hh() && !rp(str)) {
                if (this.aZu != null) {
                    this.aZu.onError(this.fPE, PayPluginManager.RESULT_CODE_UNKNOWN, PayPluginManager.RESULT_CODE_UNKNOWN);
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
            this.fPH.oZ(uri.toString());
        }
        bjo();
        this.fPM = true;
        this.mUri = uri;
        this.Ak = map;
        this.fPN = 0;
        removeView(this.fPC);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        if (this.fPS) {
            addView(this.fPC, layoutParams);
        } else {
            addView(this.fPC, 0, layoutParams);
        }
        aj.k(this, d.C0095d.cp_bg_line_k);
    }

    private void bjo() {
        this.fPM = false;
        this.fPK = false;
        if (this.fPE != null) {
            this.fPE.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQr);
    }

    private void rn(String str) {
        this.fQh = 0;
        this.fQi = 0;
        this.fQj = 0;
        this.fQk = 0;
        this.fQl = 0;
        this.bdE = 0;
        if (this.fPL.bje()) {
            this.fQg = fQc;
            new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.play.QuickVideoView.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    QuickVideoView.this.fQi = (int) t.rr(QuickVideoView.this.fPW);
                    return null;
                }
            }.execute(new Void[0]);
        } else if (this.fPW != null && this.fPW.equals(str)) {
            this.fQg = fQb;
        } else {
            this.fQg = fQd;
        }
        this.fnQ = fQe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjp() {
        this.fnQ = fQe;
        if (this.fPE != null) {
            this.fQh = this.fPE.getBitRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (this.fnQ == fQe && this.fPE != null) {
            this.fnQ = fQf;
            this.fQk = this.fPE.getDuration();
            if (z) {
                this.fQl = 0;
                this.fQj = this.fQk;
            } else {
                this.fQj = this.fPE.getCurrentPosition();
                this.fQl = this.fPE.getCachedSize();
            }
            if (this.fQj > 0) {
                if (this.fQg == fQb) {
                    this.fQi = (int) t.rr(this.fPW);
                    if (this.fQh > 0) {
                        long j = (this.fQh * (this.fQj / 1000)) / 8;
                        if (this.fQl < 0) {
                            this.fQl = 0;
                        }
                        long j2 = this.fQl + j;
                        if (this.fQi > 0) {
                            j2 += this.fQi;
                        }
                        a(j2, this.fQj, this.fQk, this.bdE);
                    } else if (this.fQh == -1) {
                        this.fQh = 603327;
                        a((this.fQh * (this.fQj / 1000)) / 8, this.fQj, this.fQk, this.bdE);
                    }
                } else if (this.fQg == fQc) {
                    if (this.fQh > 0) {
                        long j3 = (this.fQh * (this.fQj / 1000)) / 8;
                        if (this.fQl < 0) {
                            this.fQl = 0;
                        }
                        long j4 = this.fQl + j3;
                        if (this.fQi > 0) {
                            j4 -= this.fQi;
                        }
                        a(j4, this.fQj, this.fQk, this.bdE);
                    } else if (this.fQh == -1) {
                        this.fQh = 603327;
                        a((this.fQh * (this.fQj / 1000)) / 8, this.fQj, this.fQk, this.bdE);
                    }
                } else {
                    a(0L, this.fQj, this.fQk, this.bdE);
                }
            }
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQr);
    }

    public void stopPlayback() {
        lY(false);
        if (this.fPT != null) {
            this.fPT.clear();
        }
        this.fPD = null;
        bjo();
        this.fPO = false;
        if (this.fPL != null) {
            this.fPL.onStop();
        }
        com.baidu.tieba.play.a.b.bjN().a((b.InterfaceC0134b) null);
        if (this.fPH != null && this.fPH.pc(getLocateSource())) {
            this.fPH = null;
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQr);
    }

    public void setOnPreparedListener(g.f fVar) {
        this.aZt = fVar;
    }

    public void setOnCompletionListener(g.a aVar) {
        this.aZs = aVar;
    }

    public void setOnErrorListener(g.b bVar) {
        this.aZu = bVar;
    }

    public void setOnSeekCompleteListener(g.InterfaceC0137g interfaceC0137g) {
        this.aZx = interfaceC0137g;
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, String str, int i4) {
        if (this.fPE != null) {
            try {
                this.fPE.release();
                this.fPD = str;
                URI uri = new URI(this.mUri.toString());
                this.fPE.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.Ak, this.fPR, this.mUri.getHost());
                if (f(this.mUri) != null) {
                    this.fPH.a(0, this.mUri.toString(), i, i2, i3, str, i4);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void a(g gVar, int i, int i2, int i3, int i4) {
        if (this.fPE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            this.fPE.release();
            this.fPE.a(this.mContext, this.mUri, this.Ak, this.fPR, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPH.a(1, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // com.baidu.tieba.play.b.c
    public void b(g gVar, int i, int i2, int i3, int i4) {
        if (this.fPE != null && this.mUri != null && !TextUtils.isEmpty(this.mUri.toString())) {
            if (i == -200 || i == -300) {
                this.fPE.forceUseSystemMediaPlayer(true);
            }
            this.fPE.release();
            this.fPE.a(this.mContext, this.mUri, this.Ak, this.fPR, this.mUri.getHost());
            if (f(this.mUri) != null) {
                this.fPH.a(2, this.mUri.toString(), i, i2, i3, "", i4);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fPK = true;
        if (this.fPE != null) {
            if (this.fPR != null && this.fPQ && !this.fPE.isExistInRemote()) {
                this.fPE.a(this.mContext, this.mUri, this.Ak, this.fPR, this.fPP);
                if (this.fPs != null) {
                    this.fPs.bjc();
                }
                if (f(this.mUri) != null) {
                    this.fPH.aNY();
                    return;
                }
                return;
            }
            this.fPE.start();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
        }
        if (this.fPL != null) {
            this.fPL.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (f(this.mUri) != null) {
            this.fPH.pt(this.fPE.getPlayerType());
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.fPE != null) {
            this.fPE.pause();
        }
        if (this.fPL != null) {
            this.fPL.onPause();
        }
        this.fPK = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPH != null) {
            this.fPH.aOc();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.fPE != null) {
            return this.fPE.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fPE != null) {
            return this.fPE.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdE = i;
        sz(i);
    }

    public void sz(int i) {
        this.fPU = true;
        if (this.fPE != null) {
            this.fPE.seekTo(i);
        }
        if (this.fPL != null) {
            this.fPL.sx(0);
            bjs();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fPE != null) {
            return this.fPE.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fPE != null) {
            this.fPE.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fPP = i;
    }

    public int getRecoveryState() {
        return this.fPP;
    }

    public void setNeedRecovery(boolean z) {
        this.fPQ = z;
    }

    public void setLooping(boolean z) {
        this.fPO = z;
    }

    public boolean bjq() {
        return this.fPK;
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
        this.blw = bVar;
    }

    public void setBusiness(d dVar) {
        this.fPL = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fPO = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (this.fPE != null) {
            this.fPE.Hq();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQq);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQr);
        MessageManager.getInstance().unRegisterListener(this.aZH);
        if (this.fPT != null) {
            this.fPT.clear();
        }
        if (this.fPI != null) {
            this.fPI.a(null);
            this.fPI.aNQ();
        }
    }

    public g getPlayer() {
        return this.fPE;
    }

    public int getPlayerType() {
        if (this.fPE == null) {
            return -300;
        }
        return this.fPE.getPlayerType();
    }

    public void bjr() {
        if (this.fPL != null) {
            this.fPL.bjj();
        }
    }

    public void bjs() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fQr);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fQr, 200L);
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
        this.fPs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocateSource() {
        return (!(this.fPL instanceof n) || ((n) this.fPL).bjA() == null) ? "" : ((n) this.fPL).bjA().mLocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.i.i f(Uri uri) {
        String uri2;
        if (this.fPH != null) {
            return this.fPH;
        }
        if (!StringUtils.isNull(this.fPW)) {
            uri2 = this.fPW;
        } else if (fPG != null && this.fPL != null && !StringUtils.isNull(this.fPL.bjd())) {
            uri2 = this.fPL.bjd();
        } else {
            uri2 = (fPG == null || uri == null) ? null : uri.toString();
        }
        if (!StringUtils.isNull(uri2) && fPG != null) {
            this.fPH = fPG.F(this.aMX, uri2, this.fPJ);
        }
        this.fPJ = null;
        this.fPX = 0L;
        return this.fPH;
    }

    public static boolean ro(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.contains("127.0.0.1") || !str.contains("http");
    }

    public void a(final long j, final long j2, final long j3, final long j4) {
        if (this.fPH != null) {
            this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.6
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
        if (this.fPH != null) {
            this.fPH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.QuickVideoView.7
                private long fQx = 0;

                @Override // com.baidu.tieba.i.b
                public void F(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void G(JSONObject jSONObject) throws JSONException {
                    this.fQx = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                    if (this.fQx != 0 && j != 0 && this.fQx <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.fQx + j);
                    }
                }
            });
        }
    }

    public static boolean rp(String str) {
        return (StringUtils.isNull(str) || str.contains("http")) ? false : true;
    }
}

package com.baidu.tieba.yuyinala.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ae.e;
import com.baidu.live.ag.c;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.aa;
import com.baidu.live.data.ab;
import com.baidu.live.data.bw;
import com.baidu.live.data.dd;
import com.baidu.live.data.dj;
import com.baidu.live.data.v;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.al;
import com.baidu.live.gift.am;
import com.baidu.live.gift.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.log.StayTimeBean;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.u.g;
import com.baidu.live.utils.p;
import com.baidu.live.utils.t;
import com.baidu.tieba.yuyinala.liveroom.grabredpacket.d;
import com.baidu.tieba.yuyinala.liveroom.k.a;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.m;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.compatible.menukey.MenuKeyUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends BdBaseView<TbPageContext> {
    private ab aDd;
    private CustomMessageListener bgy;
    private long buN;
    private String buO;
    private boolean byF;
    private ViewGroup hGq;
    private LayerRootView hGr;
    private long hGv;
    private Runnable hJK;
    private String hoC;
    private AlaLastLiveroomInfo idS;
    private boolean idT;
    private boolean idU;
    private boolean idV;
    private boolean idX;
    private ArrayList<AlaBroadcastGiftToastData> idY;
    private String idZ;
    private c ieD;
    com.baidu.live.liveroom.a.c ieK;
    ViewPager.OnPageChangeListener ieL;
    CustomMessageListener ieP;
    private g ieX;
    private String iec;
    private long ied;
    private JSONObject iee;
    private boolean ief;
    private boolean iei;
    private boolean iel;
    private boolean iem;
    private String ien;
    private boolean ieo;
    private bw iep;
    private boolean ieq;
    private boolean ier;
    private Runnable iew;
    private Runnable iex;
    private Runnable iey;
    private String mAudioUrl;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private AlaLiveView oCn;
    private d oMU;
    private a oMV;
    private com.baidu.tieba.yuyinala.liveroom.k.a oMW;
    private AlaLiveRoomBlurPageLayout oMX;
    private AlaLoopViewPager oMY;
    private AlaLoopViewPagerAdapter oMZ;
    private com.baidu.tieba.yuyinala.liveroom.d.a oNa;
    private com.baidu.tieba.yuyinala.liveroom.d.b oNb;
    private boolean oNc;
    private String oNd;
    private com.baidu.tieba.yuyinala.endliveroom.a oNe;
    private com.baidu.tieba.yuyinala.liveroom.c.b oNf;
    private com.baidu.tieba.yuyinala.liveroom.task.b oNg;
    private StayTimeBean oNh;
    private com.baidu.tieba.yuyinala.liveroom.g.a oNi;
    private com.baidu.tieba.yuyinala.liveroom.p.c oNj;
    private Set<String> oNk;
    private Runnable oNl;
    private int oNm;
    private Bitmap oNn;
    private boolean oNo;
    private String oNp;
    private String oNq;
    private CustomMessageListener oNr;
    CustomMessageListener oNs;
    private CustomMessageListener oNt;
    private CustomMessageListener oNu;
    CustomMessageListener oNv;
    CustomMessageListener oNw;
    private String otherParams;
    private a.InterfaceC0926a owA;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.idT = true;
        this.hGv = 0L;
        this.idU = false;
        this.byF = true;
        this.oNc = false;
        this.buO = "";
        this.mForumName = "";
        this.idV = false;
        this.idX = false;
        this.idZ = "0";
        this.oNd = "0";
        this.mHandler = new Handler();
        this.ied = -1L;
        this.otherParams = "";
        this.ief = false;
        this.oNg = com.baidu.tieba.yuyinala.liveroom.task.b.ebM();
        this.iei = false;
        this.iem = false;
        this.ieo = false;
        this.ier = false;
        this.oNk = new HashSet();
        this.hJK = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ciU();
            }
        };
        this.iew = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnQ();
            }
        };
        this.iex = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.oMW.cjq();
            }
        };
        this.oNl = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oMW.Fm() != null) {
                    b.this.oMW.ag(b.this.oMW.Fm());
                }
            }
        };
        this.oNm = 5000;
        this.mAudioUrl = "";
        this.oNp = "";
        this.oNq = "";
        this.oNr = new CustomMessageListener(2501082) { // from class: com.baidu.tieba.yuyinala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oMW != null && b.this.oMW.Fm() != null) {
                    b.this.oMW.ag(b.this.oMW.Fm());
                }
            }
        };
        this.bgy = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.iey = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
            }
        };
        this.ieK = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // com.baidu.live.liveroom.a.c
            public void cC(final boolean z) {
                if (!m.eds().isShowing()) {
                    i.edp().Ad(false);
                    boolean aA = m.eds().aA(b.this.mTbPageContext.getPageActivity());
                    m.eds().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edu() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edv() {
                            if (z || b.this.oNf == null || b.this.oNf.cbQ()) {
                                b.this.pf(true);
                                b.this.bYU();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edw() {
                        }
                    });
                    if (aA) {
                        if (z || b.this.oNf == null || b.this.oNf.cbQ()) {
                            b.this.pf(true);
                            b.this.bYU();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cD(boolean z) {
                b.this.e(b.this.aDd, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oMY != null) {
                    b.this.oMY.setIsScrollable(b.this.ieq && z);
                    b.this.oMY.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
            }
        };
        this.ieL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.oCn != null && b.this.oMW != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oMY.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oNh != null && b.this.oMW != null && b.this.oMW.Fm() != null && b.this.oMW.Fm().mLiveInfo != null && b.this.oMW.Fm().aIU != null) {
                        if (b.this.oNh.liveId == b.this.oMW.Fm().mLiveInfo.live_id && b.this.oNh.startTime > 0) {
                            b.this.oNh.endTime = System.currentTimeMillis();
                            long j = b.this.oNh.endTime - b.this.oNh.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oMW.Fm().aIU.aTK, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.byF, b.this.oMW.Fm().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oNh = null;
                    }
                    if (b.this.byF || b.this.oMW.cjp() == null || ListUtils.getCount(b.this.oMW.cjp()) > 1) {
                        if (b.this.oMW.cju() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.oMW == null || !b.this.oMW.cju() || i2 >= 0) {
                            if (b.this.oMW != null && b.this.oMW.cjv() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oMY.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.oMW != null) {
                                b.this.oMW.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nU(true);
                            b.this.oMX.clc();
                            b.this.oMX.Xi();
                            b.this.oMX.cld();
                            b.this.cob();
                            if (b.this.ieD != null) {
                                b.this.ieD.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oMX = b.this.oMZ.LZ(b.this.mSelectedPosition);
                            b.this.oMX.cle();
                            b.this.wy(i2);
                            b.this.efF();
                            b.this.MF(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oMY.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oMY.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oMW.g(b.this.oMW.cjz());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oMY != null && i == 0) {
                    com.baidu.live.d.xc().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.owA = new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0926a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.oMW.Fm());
                } else if (i2 == 2) {
                    b.this.f(b.this.oMW.bTK());
                } else if (i2 == 3) {
                    b.this.bx(i, str);
                } else if (i2 == 12) {
                    b.this.c(b.this.oMW.ebB());
                } else if (i2 == 11) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_IS_INIT, b.this.byF ? "1" : "0");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle", jSONObject);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cnP();
                }
            }
        };
        this.oNs = new CustomMessageListener(2913169) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    q.edE().setMaskBg(false);
                }
            }
        };
        this.ieP = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oMW != null && b.this.oMW.Fm() != null && b.this.oMW.Fm().aIz != null) {
                        if (l.longValue() == b.this.oMW.Fm().aIz.userId) {
                            b.this.oMW.Fm().aIz.isNewUser = false;
                            if (b.this.oNi != null) {
                                b.this.oNi.o(b.this.oMW.Fm());
                            }
                        }
                    }
                }
            }
        };
        this.oNt = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.efJ();
                    } else {
                        b.this.W((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oNu = new CustomMessageListener(2501078) { // from class: com.baidu.tieba.yuyinala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501078) {
                    String str = null;
                    if (customResponsedMessage.getData() instanceof String) {
                        str = (String) customResponsedMessage.getData();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.this.WJ(str);
                    }
                }
            }
        };
        this.oNv = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ciU();
            }
        };
        this.oNw = new CustomMessageListener(2501080) { // from class: com.baidu.tieba.yuyinala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501080 && (customResponsedMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig)) {
                    final YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customResponsedMessage.getData();
                    if (!m.eds().isShowing()) {
                        i.edp().Ad(false);
                        if (m.eds().aA(b.this.mTbPageContext.getPageActivity())) {
                            b.this.pf(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            return;
                        }
                        m.eds().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edu() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edv() {
                                b.this.pf(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edw() {
                            }
                        });
                    }
                }
            }
        };
        this.hGv = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oMV = aVar;
        this.idT = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.ieD = (c) runTask.getData();
        }
        this.oMW = new com.baidu.tieba.yuyinala.liveroom.k.a(getPageContext());
        this.oMW.a(this.owA);
        this.oNe = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.oNs);
        MessageManager.getInstance().registerListener(this.ieP);
        MessageManager.getInstance().registerListener(this.oNt);
        MessageManager.getInstance().registerListener(this.oNu);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oNv);
        MessageManager.getInstance().registerListener(this.oNw);
        MessageManager.getInstance().registerListener(this.oNr);
        this.ieX = new g(tbPageContext.getPageActivity());
        this.ieX.setIPlayerAudioFocusCallBack(new com.baidu.live.u.a() { // from class: com.baidu.tieba.yuyinala.player.b.17
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().muteOrUnmuteAudio(!z);
                }
            }
        });
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.idY = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.idY.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void au(Intent intent) {
        R(intent);
        this.buO = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.buO)) {
            this.buO = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.iec = intent.getStringExtra("room_id");
        this.buN = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.mAudioUrl = new String(Base64.decode(optString.getBytes()));
                if (!this.mAudioUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mAudioUrl = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.oNp = new String(Base64.decode(optString2.getBytes()));
                if (!this.oNp.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oNp = "";
                }
            }
            this.oNq = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.ief = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oMW.b((AlaLiveInfoCoreData) serializableExtra);
            this.ief = true;
        }
        TbConfig.liveScene = 2;
        av(intent);
        this.ieq = this.iep == null || !this.iep.aQd;
        this.oNe.setOtherParams(this.otherParams);
        this.idX = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        efC();
        Aq(true);
        this.mHandler.removeCallbacks(this.iey);
        this.mHandler.postDelayed(this.iey, 1000L);
    }

    private void av(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoC = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.iee = new JSONObject(stringExtra);
                if (this.iee != null) {
                    String optString2 = this.iee.optString("enterRoomId");
                    String optString3 = this.iee.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.iec, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.buN + "", optString3))) {
                        String optString4 = this.iee.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.iee.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.ief) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.buN;
                            alaLiveInfoCoreData.screenDirection = this.iee.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oMW.b(alaLiveInfoCoreData);
                            this.ief = true;
                        }
                    }
                    String optString6 = this.iee.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.iep = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oMW != null) {
                            this.oMW.Hs(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoC = jSONObject.optString("live_back_scheme");
                        this.iep = new bw();
                        this.iep.aQd = jSONObject.optInt("is_hot") == 1;
                        if (this.iep.aQd) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.iep.aQe = jSONObject.optString("task_id");
                        this.iep.aQc = TextUtils.isEmpty(this.iep.aQe) ? false : true;
                        this.iep.aQf = jSONObject.optInt("task_type");
                        this.iep.aQg = jSONObject.optInt("task_im_count");
                        this.iep.aQh = jSONObject.optLong("task_gift_total_price");
                        this.iep.aQi = jSONObject.optLong("task_watch_time");
                        this.iep.aQj = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oNb = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oNb.setScheme(optString8);
                            this.oNb.setImageUrl(optString9);
                            this.oNb.setTitle(optString10);
                        }
                    }
                    this.idZ = this.iee.optString("open_giftlist");
                    this.oNd = this.iee.optString(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.iee.remove("cover");
                    this.iee.remove("live_url");
                    this.iee.remove("enterRoomId");
                    this.iee.remove("enterLiveId");
                    this.iee.remove("open_giftlist");
                    this.iee.remove(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.iee.remove("extra");
                    this.otherParams = this.iee.toString();
                    if (this.oMW != null) {
                        this.oMW.setOtherParams(this.otherParams);
                    }
                    this.iee.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("source");
                    }
                    this.ier = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.iee.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oMW != null) {
                        this.oMW.vY(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.idS = new AlaLastLiveroomInfo();
                this.idS.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.iec), null, cnJ());
        UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.iec), cnJ());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_IS_INIT, "1");
        } catch (JSONException e3) {
            BdLog.e(e3);
        }
        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject2));
        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject2));
        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject2));
        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject2));
        UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_FEED_LOAD_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject2));
    }

    private void a(String str, AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (!TextUtils.isEmpty(str) && alaLiveInfoCoreData != null) {
            if (str.toLowerCase().endsWith(".flv")) {
                alaLiveInfoCoreData.flvUrl = str;
            } else if (str.toLowerCase().endsWith(".m3u8")) {
                alaLiveInfoCoreData.hlsUrl = str;
            } else if (str.toLowerCase().startsWith("rtmp://")) {
                alaLiveInfoCoreData.rtmpUrl = str;
            }
        }
    }

    public void Aq(boolean z) {
        boolean z2 = false;
        if (this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null && this.oMW.Fm().mLiveInfo.room_id > 0) {
            this.oMW.VI(this.oMW.Fm().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.iec)) {
            this.oMW.VI(this.iec);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.oMW.aw(this.uk, this.buO, this.mForumName);
            z2 = true;
        } else if (this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null && this.oMW.Fm().mLiveInfo.live_id > 0) {
            this.oMW.a(this.oMW.Fm().mLiveInfo.live_id, false, this.buO, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.buO = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                pf(false);
                return;
            }
            this.oMW.aw(this.uk, this.buO, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.iec)) {
            this.oMW.HX(this.iec);
            z2 = true;
        } else if (this.buN > 0) {
            this.oMW.a(this.buN, false, this.buO, "");
            z2 = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
        if (z2) {
            efF();
            if (z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_IS_INIT, "1");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApi", jSONObject);
                UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject), "micLiteApi", null);
            }
        }
    }

    private void efC() {
        this.byF = true;
        this.idU = false;
        efD();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bc().l(this.hGr);
        this.oNf = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oNf.a(this.ieK);
        this.oNf.setOtherParams(this.otherParams);
        this.oNf.nO(this.ier);
        try {
            ab abVar = new ab();
            abVar.aJo = false;
            abVar.aIU = new dj();
            abVar.aIU.live_id = String.valueOf(this.buN);
            abVar.aIU.cover = "";
            abVar.aIU.room_name = ".....";
            abVar.aIU.aTK = "0";
            abVar.aIU.croom_id = "0";
            abVar.aIU.is_followed = true;
            abVar.aIU.bg_cover = this.oNp;
            abVar.mLiveInfo = new AlaLiveInfoData();
            abVar.aIz = new AlaLiveUserInfoData();
            abVar.aIA = new aa();
            abVar.aIY = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            abVar.bx(true);
            this.oMW.setLiveShowData(abVar);
            cnx();
            cnu();
            this.oNf.a(abVar, this.mAudioUrl, this.oNq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void efD() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oMY = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oMY.setOnPageChangeListener(this.ieL);
        this.oMY.setBoundaryCaching(true);
        this.oMY.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oMZ = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oMZ.cgD();
        this.oMX = this.oMZ.LY(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oNp)) {
                this.oMX.setBgImageUrl(this.oNp, null);
            } else {
                this.oMX.setDefaultBg();
            }
            this.oMZ.LY(0).setDefaultBg();
            this.oMZ.LY(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oMW != null) {
            this.oMZ.a(this.mSelectedPosition, this.oMW.Fm());
        }
        this.oMY.setAdapter(this.oMZ);
        this.oMY.setCurrentItem(this.mSelectedPosition);
        this.oMY.setIsScrollable(this.ieq);
        this.hGq = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGr = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oMY.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.21
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                ab Fm;
                if ((b.this.oMW == null || (Fm = b.this.oMW.Fm()) == null || Fm.mLiveInfo == null || Fm.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oNo = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oMW == null || !b.this.oMW.cju() || rawY <= 0.0f) {
                            if (b.this.oMW == null || !b.this.oMW.cjv() || rawY >= 0.0f) {
                                if (m.eds().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                i.edp().Ad(false);
                                m.eds().aA(b.this.mTbPageContext.getPageActivity());
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean LX(int i) {
                ab Fm;
                if (b.this.oMW == null || (Fm = b.this.oMW.Fm()) == null || Fm.mLiveInfo == null || Fm.mLiveInfo.live_status != 2) {
                    m.eds().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.21.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edu() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edv() {
                            if (b.this.oMY != null) {
                                if (b.this.oMW == null || !b.this.oMW.cju() || !b.this.oNo) {
                                    if (b.this.oMW == null || !b.this.oMW.cjv() || b.this.oNo) {
                                        int currentItem = b.this.oMY.getCurrentItem();
                                        if (b.this.oNo) {
                                            if (currentItem == 0) {
                                                b.this.oMY.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oMY.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oMY.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oMY.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oMY.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oMY.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edw() {
                        }
                    });
                    if (b.this.oMW != null && b.this.oMW.cju() && b.this.oNo) {
                        return true;
                    }
                    if (b.this.oMW == null || !b.this.oMW.cjv() || b.this.oNo) {
                        if (m.eds().isShowing()) {
                            return false;
                        }
                        i.edp().Ad(false);
                        return m.eds().aA(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        q edE = q.edE();
        edE.a(this.mTbPageContext, this.oMX, rect);
        edE.a(this);
    }

    private void cnu() {
        this.oNa = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hGq);
    }

    private void c(Rect rect) {
        this.oCn = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.oCn.setSwipeClearEnable(false);
        this.oCn.hRi = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oMX.a(this.oCn, layoutParams);
    }

    private void cnx() {
        if (this.oMW != null && this.oMW.Fm() != null) {
            this.aDd = this.oMW.Fm();
            if (this.aDd.mLiveInfo != null) {
                a(this.aDd.mLiveInfo, this.ief);
                if (this.aDd.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.idV);
                    }
                    if (this.oNf != null) {
                        this.oNf.a(this.mTbPageContext, this.oCn, null, this.oMX, this.oMW, this.buO, this.idX, this.hGv, this.idY, this.iep);
                        efI();
                    }
                }
            }
        }
    }

    private void cnF() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.idX || !this.ieq) {
                this.oMY.setIsScrollable(false);
            } else {
                this.oMY.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bc().onBackPressed() && ((this.oNf == null || !this.oNf.onKeyDown(i, keyEvent)) && (this.oNf == null || !this.oNf.cbP()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnF();
            } else if (!m.eds().aA(this.mTbPageContext.getPageActivity())) {
                i.edp().Ad(false);
            } else if (this.oNf == null || this.oNf.cbQ()) {
                pf(true);
                bYU();
            }
        }
        return true;
    }

    public void bYU() {
        if (!TextUtils.isEmpty(this.hoC)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoC);
                this.hoC = null;
            }
        }
    }

    public void pf(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nU(!z);
        com.baidu.live.core.layer.b.Bc().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnH();
        long j = -1;
        if (this.oMW != null && this.oMW.cjz() != null) {
            j = this.oMW.cjz().room_id;
        }
        this.oMV.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void nU(boolean z) {
        if (this.oNc) {
            efH();
            this.oNc = false;
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.idS = null;
        if (al.FB() != null) {
            al.FB().FA();
        }
        com.baidu.live.core.layer.b.Bc().Bd();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().dh(this.oCn);
        if (this.ieD != null) {
            this.ieD.release();
        }
        if (this.oNi != null) {
            this.oNi.release();
        }
        this.iep = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oMY);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oMW != null) {
            this.oMW.Hs(null);
            AlaLiveInfoData cjz = this.oMW.cjz();
            if (cjz != null) {
                this.oMW.fI(cjz.live_id);
            }
        }
        this.oNg.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnG();
        if (this.oNf != null) {
            this.oNf.nU(z);
        }
        this.iei = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mu().brr != null) {
            com.baidu.live.liveroom.a.b.Mu().brr.b(this.aDd.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().aAJ();
        }
        q.edE().Ar();
        aj.gn("");
        if (this.oMV != null && this.oMV.cnp()) {
            am.FC().EZ();
        }
    }

    private void cnG() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            if (this.oCn.findViewById(a.f.ala_live_header_view).getMeasuredWidth() == 0) {
                if (abVar.mLiveInfo != null && abVar.mLiveInfo.live_id > 0) {
                    this.oMW.fI(abVar.mLiveInfo.live_id);
                    cnK();
                    this.oMW.a(abVar.mLiveInfo.live_id, false, this.buO, "");
                    return;
                }
                return;
            }
            if (abVar.aIU != null && this.oMW.owJ) {
                aN(abVar);
            }
            aO(abVar);
            this.aDd = abVar;
            if (this.oNf != null) {
                this.oNf.a(abVar);
            }
        }
    }

    private void aN(ab abVar) {
        if (abVar.aIU.aTP) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().Wv(abVar.aIU.aTO)) {
                WJ(com.baidu.live.storage.b.hH(abVar.aIU.aTO));
                return;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501079, new String[]{abVar.aIU.aTN, abVar.aIU.aTO}));
                return;
            }
        }
        this.oMX.setBgImageUrl(abVar.aIU.bg_cover, null);
        this.oMX.ecm();
    }

    private void aO(final ab abVar) {
        List<dd.a> list;
        if (abVar.aIV != null && abVar.aIU != null && (list = abVar.aIV.aTf) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final dd.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aTj + aVar.aTl + aVar.aTn + abVar.aIU.aTK;
                    if (!this.oNk.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aTj - (System.currentTimeMillis() / 1000));
                        this.oNk.add(str);
                        if (this.oMU == null) {
                            this.oMU = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!efE() || StringUtils.isNull(aVar.aTl, true) || StringUtils.isNull(aVar.aTn, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oMU.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oMU.a(z, aVar.aTj, aVar.aTl, aVar.aTn, abVar.aIU.aTK, abVar.aIU.live_id, abVar.aIU.croom_id, aVar.aTk, aVar.aTm, abVar.aIV.aTe + "", abVar.aIU.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oMU.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oMU.a(false, aVar.aTj, aVar.aTl, aVar.aTn, abVar.aIU.aTK, abVar.aIU.live_id, abVar.aIU.croom_id, aVar.aTk, aVar.aTm, abVar.aIV.aTe + "", abVar.aIU.is_followed);
                                }
                            }, (currentTimeMillis - 15) * 1000);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private boolean efE() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CE(), true);
    }

    private void c(v vVar) {
        if (this.oNf != null) {
            this.oNf.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aDd = abVar;
    }

    private void cnI() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oMY.setIsScrollable(false);
            this.ieq = false;
        }
        if (this.aDd != null) {
            a(this.aDd.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oMX.a(this.oCn, null);
            a(this.oMX, this.aDd.mLiveInfo, this.byF);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.mLiveInfo.room_id), String.valueOf(this.aDd.mLiveInfo.feed_id), cnJ());
            if (com.baidu.live.liveroom.a.b.Mu().brr != null) {
                com.baidu.live.liveroom.a.b.Mu().brr.a(this.aDd.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
                String str = "normal";
                if (this.aDd != null && this.aDd.aIY != null && this.aDd.aIY.getRoomMode() == 1) {
                    str = "dating";
                } else if (this.aDd != null && this.aDd.aIY != null && this.aDd.aIY.getRoomMode() == 2) {
                    str = "battle";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.byF = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cnJ() {
        if (this.iee == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.iee.optString("source");
            String optString2 = this.iee.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.iee.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.iee.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.iee.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        q edE = q.edE();
        ViewGroup edG = edE.edG();
        if (edG != null && edG.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cz(edG)) {
                        ((ViewGroup) edG.getParent()).removeView(edG);
                        alaLiveRoomBlurPageLayout.f(edG, null);
                        edE.edF();
                    } else if (edE != null) {
                        edE.edF();
                    }
                } else if (edE != null) {
                    edE.edF();
                }
            } else if (edE != null) {
                edE.edF();
            }
        } else if (edG != null && edG.getParent() == null) {
            alaLiveRoomBlurPageLayout.f(edG, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        ViewGroup edG = q.edE().edG();
        if (edG != null) {
            edG.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.bs(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.bt(this.mTbPageContext.getPageActivity());
                int br = p.br(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = br + i;
                } else {
                    dimensionPixelSize = br + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
                }
                layoutParams.topMargin = dimensionPixelSize;
            } else {
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                layoutParams.topMargin = 0;
            }
        } else {
            layoutParams.width = iArr[0];
            layoutParams.height = iArr[1] - i3;
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    public void cnK() {
        this.byF = true;
    }

    public boolean cnL() {
        return this.byF;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (alaLiveInfoData != null) {
            z2 = alaLiveInfoData.screen_direction == 2;
        } else {
            z2 = false;
        }
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.mTbPageContext.getPageActivity(), 48.0f) : 0;
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z && (screenFullSize[0] <= 0 || screenFullSize[1] <= 0)) {
            screenFullSize[0] = getScreenWidth(this.mTbPageContext.getPageActivity());
            screenFullSize[1] = getScreenHeight(this.mTbPageContext.getPageActivity());
        }
        if (realScreenOrientation == 1) {
            z3 = screenFullSize[1] < screenFullSize[0];
        } else {
            z3 = screenFullSize[1] > screenFullSize[0];
        }
        if (z3) {
            int i = screenFullSize[0];
            screenFullSize[0] = screenFullSize[1];
            screenFullSize[1] = i;
        }
        ViewGroup edG = q.edE().edG();
        if (edG != null) {
            int i2 = edG.getLayoutParams().width;
            int i3 = edG.getLayoutParams().height;
            int i4 = edG.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) edG.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i2 || b2.height != i3 || b2.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.oCn != null) {
                this.oCn.setLayoutParams(c);
            }
            if (this.oMX != null) {
                this.oMX.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oNe != null) {
                this.oNe.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oNf != null) {
                this.oNf.l(c.width, c.height, realScreenOrientation);
            }
        }
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private FrameLayout.LayoutParams c(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = iArr[0];
                layoutParams.height = (iArr[1] - i) - i3;
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    layoutParams.topMargin = i;
                } else {
                    layoutParams.topMargin = 0;
                }
            } else {
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    layoutParams.height = iArr[1] - i;
                }
                layoutParams.gravity = 3;
                layoutParams.topMargin = 0;
            }
        } else {
            layoutParams.width = iArr[0];
            layoutParams.height = (iArr[1] - i) - i3;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = i;
            } else {
                layoutParams.topMargin = 0;
            }
        }
        layoutParams.bottomMargin = 0;
        return layoutParams;
    }

    private void i(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            if (alaLiveInfoData.room_id > 0) {
                this.oMW.VI(alaLiveInfoData.room_id + "");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_IS_INIT, "0");
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MIC_LITE_API_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject), "micLiteApi", null);
            UbcAudioFlowStatisticManager.getInstance().beginFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
            this.oMW.a(alaLiveInfoData.live_id, true, this.buO, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MF(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = this.oMW.Fm();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fm.aIU.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : "up");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void wy(int i) {
        if (i < 0) {
            this.oMW.vZ(this.oMW.cjw() - 1);
        } else if (i > 0) {
            this.oMW.vZ(this.oMW.cjw() + 1);
        }
        if (this.oNf != null) {
            this.oNf.a(this.oMX);
        }
        this.oMZ.a(this.mSelectedPosition, cnN(), this.aDd);
        this.oMZ.b(this.mSelectedPosition, cnO(), this.aDd);
        if (this.oMW != null) {
            AlaLiveInfoData cjz = this.oMW.cjz();
            if (cjz != null) {
                cjz.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cjz);
                a(this.oMX, cjz, this.byF);
                this.byF = false;
                if (this.oNf != null) {
                    this.oNf.a(this.mTbPageContext, this.oCn, null, this.oMX, this.oMW, this.buO, this.idX, this.hGv, null, this.iep);
                    efI();
                }
                a(cjz, false);
            }
            i(cjz);
            if (this.oNf != null) {
                this.oNf.cbN();
            }
            this.oMW.g(cjz);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.oCn.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.oCn.findViewById(a.f.ala_live_footer_view);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        try {
            ab abVar = new ab();
            abVar.aJo = false;
            abVar.aIU = new dj();
            if (alaLiveInfoData != null) {
                this.oMX.setBgImageUrl(alaLiveInfoData.bg_cover, null);
                abVar.aIU.bg_cover = alaLiveInfoData.bg_cover;
                abVar.aIU.live_id = String.valueOf(alaLiveInfoData.live_id);
                abVar.aIU.cover = alaLiveInfoData.cover;
                abVar.aIU.aTK = String.valueOf(alaLiveInfoData.room_id);
                abVar.aIU.croom_id = alaLiveInfoData.croom_id;
                abVar.aIU.is_followed = alaLiveInfoData.is_followed;
                abVar.aIU.room_name = alaLiveInfoData.room_name;
            }
            abVar.mLiveInfo = new AlaLiveInfoData();
            if (alaLiveInfoData != null) {
                abVar.mLiveInfo.live_id = alaLiveInfoData.live_id;
            }
            abVar.aIz = new AlaLiveUserInfoData();
            abVar.aIA = new aa();
            abVar.aIY = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            abVar.bx(true);
            this.oMW.setLiveShowData(abVar);
            abVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.oNf != null) {
                this.oNf.a(abVar, str, str2);
            }
            UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.aIU.aTK), cnJ());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oMX.a(this.oCn, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efF() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eep().bdh();
    }

    private AlaLiveInfoData cnN() {
        List<AlaLiveInfoData> cjp = this.oMW.cjp();
        if (cjp == null || cjp.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        int cjw = this.oMW.cjw();
        int size = cjp.size();
        return cjp.get(((cjw + size) - 1) % size);
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjp = this.oMW.cjp();
        if (cjp == null || cjp.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        return cjp.get((this.oMW.cjw() + 1) % cjp.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (cVar != null) {
            if (!this.idU) {
                b(cVar);
            }
            if (this.oMW.owK) {
                this.mHandler.removeCallbacks(this.oNl);
                this.mHandler.postDelayed(this.oNl, 1000L);
            }
        }
    }

    private void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (this.oNf != null) {
            this.oNf.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.idV) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            pf(false);
            return;
        }
        ab Fm = this.oMW.Fm();
        V(Fm);
        if (Fm != null && Fm.aIU != null) {
            aN(Fm);
        }
        this.oNc = true;
        efG();
        this.oMW.cjq();
        if (this.byF) {
            this.oMW.oG(false);
        }
        this.hGv = System.currentTimeMillis() / 1000;
        if (this.oNf != null) {
            this.oNf.a(this.mTbPageContext, this.oCn, null, this.oMX, this.oMW, this.buO, this.idX, this.hGv, this.idY, this.iep);
            efI();
        }
        cnI();
        if (Fm != null && Fm.mLiveInfo != null && Fm.mLiveInfo.live_status == 2) {
            this.oMZ.a(this.mSelectedPosition, this.oMW.Fm());
            e(Fm, false);
            this.byF = false;
            return;
        }
        boolean z = (this.oNf == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        aj.e(Fm);
        if (z) {
            if (!this.iem || !TextUtils.equals(t.Vv(), this.ien)) {
                aj.b(getPageContext(), false, this.oMV.cnp());
                e.Qz().QA();
                this.iem = true;
                this.ien = t.Vv();
            }
            aj.Ft();
        }
        if (this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null) {
            this.oMW.hM(this.oMW.Fm().mLiveInfo.live_id);
            this.iei = true;
        }
        if (this.oNf != null) {
            this.oNf.b(this.idS);
            this.oNf.aF(TextUtils.equals(this.idZ, "1"), TextUtils.equals(this.oNd, "1"));
            this.idZ = "";
            this.oNd = "";
        }
        if (this.oNa != null) {
            this.oNa.a(this.aDd, this.oNb);
        }
        a(this.oMW.Fm());
        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_IS_INIT, this.byF ? "1" : "0");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.oMW.Fm() != null && b.this.oMW.Fm().mLiveInfo != null) {
                    b.this.oMW.a(b.this.oMW.Fm().mLiveInfo.live_id, b.this.buO, b.this.hGv);
                }
            }
        });
        this.byF = false;
        if (z && this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null && this.oMW.Fm().aId != null && this.oNf != null) {
            long j = this.oMW.Fm().mLiveInfo.live_id;
            long j2 = this.oMW.Fm().mLiveInfo.room_id;
            String str2 = this.oMW.Fm().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FB() != null) {
                    al.FB().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.ieD != null) {
                    this.ieD.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IS() != null) {
                com.baidu.live.guardclub.e.IS().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oNi == null) {
                this.oNi = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oNi.a(this.mTbPageContext.getPageActivity(), this.oMW.Fm(), this.otherParams);
        }
        if (this.oNj == null) {
            this.oNj = new com.baidu.tieba.yuyinala.liveroom.p.c(this.mTbPageContext);
        }
        if (z && this.oMW.Fm() != null && this.oMW.Fm().aIz != null && !this.iel) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oNj.a(this.oMW.Fm(), this.oMW.Fm().aIz.userId);
                this.iel = true;
            }
        }
    }

    private void efG() {
        try {
            if (this.oMW != null && this.oMW.Fm() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oMW.Fm().aIz.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMW.Fm().aIU.croom_id);
                    jSONObject.put("room_id", this.oMW.Fm().aIU.aTK);
                    jSONObject.put("vid", this.oMW.Fm().mLiveInfo.feed_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.byF) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oMW.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oMW.Fm().mLiveInfo.feed_id);
                }
                if (!this.oMW.cjp().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oMW.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oMW.Fm().mLiveInfo.feed_id);
                    this.oMW.cjp().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oMW.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oMW.Fm().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oMW.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oMW.Fm().mLiveInfo.feed_id);
                this.oNh = new StayTimeBean();
                this.oNh.liveId = this.oMW.Fm().mLiveInfo.live_id;
                this.oNh.roomId = this.oMW.Fm().mLiveInfo.room_id;
                this.oNh.vid = this.oMW.Fm().mLiveInfo.feed_id;
                this.oNh.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    private void efH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("identity", this.oMW.Fm().aIz.getUserTypeStr());
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMW.Fm().aIU.croom_id);
            jSONObject.put("room_id", this.oMW.Fm().aIU.aTK);
            jSONObject.put("vid", this.oMW.Fm().mLiveInfo.feed_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnP() {
        if (this.idT) {
            this.oMZ.a(this.mSelectedPosition, cnN(), this.aDd);
            this.oMZ.b(this.mSelectedPosition, cnO(), this.aDd);
            this.idT = false;
        }
        if (this.oNe != null && cnZ()) {
            this.oNe.X(this.oMW.cjr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.idV) {
            this.mHandler.removeCallbacks(this.iex);
            this.mHandler.postDelayed(this.iex, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.idV) {
                this.mHandler.removeCallbacks(this.iew);
                this.mHandler.postDelayed(this.iew, 5000L);
                return;
            }
            return;
        }
        if (!this.idU) {
            c(vVar);
        }
        if (!this.idV) {
            this.mHandler.removeCallbacks(this.iew);
            this.mHandler.postDelayed(this.iew, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null) {
            this.oMW.hM(this.oMW.Fm().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.aIz != null && abVar.aIz.logined == 1) {
            pf(false);
        } else if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.oMZ.a(this.mSelectedPosition, this.oMW.Fm());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.idU) {
                aj.e(abVar);
                a(abVar);
            }
            if (!this.idV) {
                this.mHandler.removeCallbacks(this.hJK);
                this.mHandler.postDelayed(this.hJK, abVar.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciU() {
        if (this.mTbPageContext != null && this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null) {
            this.oMW.a(this.oMW.Fm().mLiveInfo.live_id, this.buO, this.hGv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        View view = null;
        nU(true);
        if (!cnZ()) {
            this.oMW.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oMX != null) {
                this.oMX.Xi();
                this.oMX.clc();
            }
            if (abVar != null && abVar.mLiveInfo != null) {
                this.ied = abVar.mLiveInfo.live_id;
            }
            cnF();
            cnR();
            cnS();
            if (abVar != null) {
                if (this.oNf != null && this.oNf.cbT() != null) {
                    view = this.oNf.cbT().a(this.oNf.eaF().pageContext.getPageActivity(), abVar, z);
                }
                if (this.oMX != null) {
                    this.oNe.a(this.oMX, view, abVar, z, this.oMW.cjr());
                }
                if (this.oNf != null) {
                    this.oNf.nU(false);
                    this.oNf.cbO();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oMX != null) {
                    this.oMX.cle();
                }
                long j = abVar.mLiveInfo.live_id;
                long j2 = abVar.mLiveInfo.room_id;
                String str = abVar.mLiveInfo.feed_id;
                long j3 = abVar.aId.userId;
                String str2 = abVar.aId.userName;
            }
            cob();
            if (this.oNa != null) {
                this.oNa.a(this.aDd, this.oNb);
            }
        }
    }

    private void cnR() {
    }

    private void cnS() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oMY);
        }
    }

    public void cnT() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oMW != null && this.oMW.Fm() != null) {
            alaLiveInfoData = this.oMW.Fm().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        this.oMY.setIsScrollable(!z && this.ieq);
        if (this.oNf != null) {
            this.oNf.onKeyboardVisibilityChanged(z);
        }
        if (this.oCn != null) {
            this.oCn.onKeyboardVisibilityChanged(z);
        }
        if (z) {
            q.edE().setMaskBg(z);
        }
    }

    public void cr(int i) {
    }

    public void cnU() {
        if (this.oMY != null) {
            com.baidu.live.utils.i.ae(this.oMY);
        }
    }

    public void cnV() {
        if (this.oMY != null) {
            com.baidu.live.utils.i.af(this.oMY);
        }
    }

    public void onResume() {
        if (this.oMW != null) {
            this.oMW.cjb();
        }
        if (this.oNf != null) {
            this.oNf.enterForeground();
        }
        if (this.oNi != null) {
            this.oNi.onResume();
        }
        if (this.oNj != null) {
            this.oNj.onResume();
        }
        if (this.ieX != null && !this.ieX.hasFocus()) {
            this.ieX.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.Bc().onResume();
    }

    public void onStart() {
        if (!this.ieo) {
            if (this.idV) {
                this.idV = false;
                cnY();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cnY() {
        ciU();
        cnQ();
        this.oMW.cjq();
        if (this.oMX != null) {
            this.oMX.eco();
        }
        if (this.oNf != null) {
            this.oNf.cbS();
        }
        if (this.oMW != null && this.oMW.Fm() != null && this.oMW.Fm().mLiveInfo != null) {
            this.oNg.fL(this.oMW.Fm().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDd.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oMW != null) {
            this.oMW.cjc();
        }
        if (this.oNf != null) {
            this.oNf.enterBackground();
        }
        com.baidu.live.core.layer.b.Bc().onPause();
    }

    public void pc(boolean z) {
        this.idV = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hJK);
        this.mHandler.removeCallbacks(this.oNl);
        this.mHandler.removeCallbacks(this.iew);
        this.mHandler.removeCallbacks(this.iex);
        if (this.oMX != null) {
            this.oMX.ecn();
        }
        if (this.oNf != null) {
            this.oNf.cbR();
        }
        this.oNg.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FB() != null) {
                al.FB().a(i, i2, intent, this.aDd, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oNf != null) {
            this.oNf.onActivityResult(i, i2, intent);
        }
    }

    public boolean cnZ() {
        return this.oNe != null && this.oNe.bUE();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.oNs);
        MessageManager.getInstance().unRegisterListener(this.ieP);
        MessageManager.getInstance().unRegisterListener(this.oNt);
        MessageManager.getInstance().unRegisterListener(this.oNu);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oNv);
        MessageManager.getInstance().unRegisterListener(this.oNw);
        MessageManager.getInstance().unRegisterListener(this.oNr);
        if (this.ieD != null) {
            this.ieD.release();
        }
        if (this.oNa != null) {
            this.oNa.onDestory();
        }
        q.edE().cKQ();
        if (this.oNb != null) {
            this.oNb.reset();
        }
        if (this.oNf != null) {
            this.oNf.onDestroy();
        }
        if (this.oMZ != null) {
            this.oMZ.onDestroy();
        }
        this.oMX.Xi();
        if (this.oMX != null) {
            this.oMX.release();
            this.oMX = null;
        }
        if (this.oNe != null) {
            this.oNe.onDestroy();
        }
        if (this.ieX != null) {
            this.ieX.abandonAudioFocus();
        }
        if (this.oNh != null && this.oMW != null && this.oMW.Fm() != null) {
            if (this.oNh.liveId == this.oMW.Fm().mLiveInfo.live_id && this.oNh.startTime > 0) {
                this.oNh.endTime = System.currentTimeMillis();
                long j = this.oNh.endTime - this.oNh.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oMW.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oMW.Fm().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oNh = null;
        }
        if (this.oCn != null) {
            this.oCn.clk();
            this.oCn = null;
        }
        if (this.oMW != null) {
            this.oMW.destory();
        }
        z.Fe().release();
        if (this.oNj != null) {
            this.oNj.release();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eep().release();
        m.eds().a((m.a) null);
    }

    public void ph(boolean z) {
        this.ieo = z;
    }

    public void coa() {
        if (this.iee != null) {
            this.otherParams = this.iee.toString();
            if (this.oMW != null) {
                this.oMW.setOtherParams(this.otherParams);
            }
            if (this.oNf != null) {
                this.oNf.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oNe != null) {
                this.oNe.setOtherParams(this.otherParams);
            }
        }
    }

    public void cob() {
        if (this.iee != null) {
            String optString = this.iee.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.iee.put("tab", "live_jump");
                        this.iee.put("tag", "");
                        this.iee.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.iee.put("tab", "liveroom");
                        this.iee.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                coa();
            }
        }
    }

    public void coc() {
        aj.Fw();
    }

    private void efI() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oNf.e((short) 2);
        } else {
            this.oNf.eaG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oNn = bitmap;
            this.oMX.setBgImageBitmap(this.oNn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oMX.setBgVideo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efJ() {
        if (this.oNn != null) {
            if (!this.oNn.isRecycled()) {
                this.oNn.recycle();
            }
            this.oNn = null;
        }
        aN(this.aDd);
    }

    public boolean edM() {
        return this.ieo;
    }
}

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
    private ViewGroup hGE;
    private LayerRootView hGF;
    private long hGJ;
    private Runnable hJY;
    private String hoQ;
    private boolean ieA;
    private String ieB;
    private boolean ieC;
    private bw ieD;
    private boolean ieE;
    private boolean ieF;
    private Runnable ieK;
    private Runnable ieL;
    private Runnable ieM;
    private c ieR;
    com.baidu.live.liveroom.a.c ieY;
    ViewPager.OnPageChangeListener ieZ;
    private AlaLastLiveroomInfo ieg;
    private boolean ieh;
    private boolean iei;
    private boolean iej;
    private boolean iel;
    private ArrayList<AlaBroadcastGiftToastData> iem;
    private String ien;
    private String ieq;
    private long ier;
    private JSONObject ies;
    private boolean iet;
    private boolean iew;
    private boolean iez;
    CustomMessageListener ifd;
    private g ifl;
    private String mAudioUrl;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private AlaLiveView oCN;
    private com.baidu.tieba.yuyinala.liveroom.d.a oNA;
    private com.baidu.tieba.yuyinala.liveroom.d.b oNB;
    private boolean oNC;
    private String oND;
    private com.baidu.tieba.yuyinala.endliveroom.a oNE;
    private com.baidu.tieba.yuyinala.liveroom.c.b oNF;
    private com.baidu.tieba.yuyinala.liveroom.task.b oNG;
    private StayTimeBean oNH;
    private com.baidu.tieba.yuyinala.liveroom.g.a oNI;
    private com.baidu.tieba.yuyinala.liveroom.p.c oNJ;
    private Set<String> oNK;
    private Runnable oNL;
    private int oNM;
    private Bitmap oNN;
    private boolean oNO;
    private String oNP;
    private String oNQ;
    private CustomMessageListener oNR;
    CustomMessageListener oNS;
    private CustomMessageListener oNT;
    private CustomMessageListener oNU;
    CustomMessageListener oNV;
    CustomMessageListener oNW;
    private d oNu;
    private a oNv;
    private com.baidu.tieba.yuyinala.liveroom.k.a oNw;
    private AlaLiveRoomBlurPageLayout oNx;
    private AlaLoopViewPager oNy;
    private AlaLoopViewPagerAdapter oNz;
    private String otherParams;
    private a.InterfaceC0928a oxa;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.ieh = true;
        this.hGJ = 0L;
        this.iei = false;
        this.byF = true;
        this.oNC = false;
        this.buO = "";
        this.mForumName = "";
        this.iej = false;
        this.iel = false;
        this.ien = "0";
        this.oND = "0";
        this.mHandler = new Handler();
        this.ier = -1L;
        this.otherParams = "";
        this.iet = false;
        this.oNG = com.baidu.tieba.yuyinala.liveroom.task.b.ebU();
        this.iew = false;
        this.ieA = false;
        this.ieC = false;
        this.ieF = false;
        this.oNK = new HashSet();
        this.hJY = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjb();
            }
        };
        this.ieK = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnX();
            }
        };
        this.ieL = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.oNw.cjx();
            }
        };
        this.oNL = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oNw.Fm() != null) {
                    b.this.oNw.ag(b.this.oNw.Fm());
                }
            }
        };
        this.oNM = 5000;
        this.mAudioUrl = "";
        this.oNP = "";
        this.oNQ = "";
        this.oNR = new CustomMessageListener(2501082) { // from class: com.baidu.tieba.yuyinala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oNw != null && b.this.oNw.Fm() != null) {
                    b.this.oNw.ag(b.this.oNw.Fm());
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
        this.ieM = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.20
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
        this.ieY = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // com.baidu.live.liveroom.a.c
            public void cC(final boolean z) {
                if (!m.edA().isShowing()) {
                    i.edx().Ad(false);
                    boolean aA = m.edA().aA(b.this.mTbPageContext.getPageActivity());
                    m.edA().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edC() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edD() {
                            if (z || b.this.oNF == null || b.this.oNF.cbX()) {
                                b.this.pf(true);
                                b.this.bZb();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edE() {
                        }
                    });
                    if (aA) {
                        if (z || b.this.oNF == null || b.this.oNF.cbX()) {
                            b.this.pf(true);
                            b.this.bZb();
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
                if (b.this.oNy != null) {
                    b.this.oNy.setIsScrollable(b.this.ieE && z);
                    b.this.oNy.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
            }
        };
        this.ieZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.oCN != null && b.this.oNw != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oNy.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oNH != null && b.this.oNw != null && b.this.oNw.Fm() != null && b.this.oNw.Fm().mLiveInfo != null && b.this.oNw.Fm().aIU != null) {
                        if (b.this.oNH.liveId == b.this.oNw.Fm().mLiveInfo.live_id && b.this.oNH.startTime > 0) {
                            b.this.oNH.endTime = System.currentTimeMillis();
                            long j = b.this.oNH.endTime - b.this.oNH.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oNw.Fm().aIU.aTK, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.byF, b.this.oNw.Fm().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oNH = null;
                    }
                    if (b.this.byF || b.this.oNw.cjw() == null || ListUtils.getCount(b.this.oNw.cjw()) > 1) {
                        if (b.this.oNw.cjB() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.oNw == null || !b.this.oNw.cjB() || i2 >= 0) {
                            if (b.this.oNw != null && b.this.oNw.cjC() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oNy.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.oNw != null) {
                                b.this.oNw.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nU(true);
                            b.this.oNx.clj();
                            b.this.oNx.Xi();
                            b.this.oNx.clk();
                            b.this.coi();
                            if (b.this.ieR != null) {
                                b.this.ieR.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oNx = b.this.oNz.Ma(b.this.mSelectedPosition);
                            b.this.oNx.cll();
                            b.this.wy(i2);
                            b.this.efN();
                            b.this.MG(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oNy.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oNy.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oNw.g(b.this.oNw.cjG());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oNy != null && i == 0) {
                    com.baidu.live.d.xc().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.oxa = new a.InterfaceC0928a() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0928a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.oNw.Fm());
                } else if (i2 == 2) {
                    b.this.f(b.this.oNw.bTR());
                } else if (i2 == 3) {
                    b.this.bx(i, str);
                } else if (i2 == 12) {
                    b.this.c(b.this.oNw.ebJ());
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
                    b.this.cnW();
                }
            }
        };
        this.oNS = new CustomMessageListener(2913169) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    q.edM().setMaskBg(false);
                }
            }
        };
        this.ifd = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oNw != null && b.this.oNw.Fm() != null && b.this.oNw.Fm().aIz != null) {
                        if (l.longValue() == b.this.oNw.Fm().aIz.userId) {
                            b.this.oNw.Fm().aIz.isNewUser = false;
                            if (b.this.oNI != null) {
                                b.this.oNI.o(b.this.oNw.Fm());
                            }
                        }
                    }
                }
            }
        };
        this.oNT = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.efR();
                    } else {
                        b.this.W((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oNU = new CustomMessageListener(2501078) { // from class: com.baidu.tieba.yuyinala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501078) {
                    String str = null;
                    if (customResponsedMessage.getData() instanceof String) {
                        str = (String) customResponsedMessage.getData();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.this.WV(str);
                    }
                }
            }
        };
        this.oNV = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cjb();
            }
        };
        this.oNW = new CustomMessageListener(2501080) { // from class: com.baidu.tieba.yuyinala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501080 && (customResponsedMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig)) {
                    final YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customResponsedMessage.getData();
                    if (!m.edA().isShowing()) {
                        i.edx().Ad(false);
                        if (m.edA().aA(b.this.mTbPageContext.getPageActivity())) {
                            b.this.pf(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            return;
                        }
                        m.edA().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edC() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edD() {
                                b.this.pf(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edE() {
                            }
                        });
                    }
                }
            }
        };
        this.hGJ = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oNv = aVar;
        this.ieh = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.ieR = (c) runTask.getData();
        }
        this.oNw = new com.baidu.tieba.yuyinala.liveroom.k.a(getPageContext());
        this.oNw.a(this.oxa);
        this.oNE = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.oNS);
        MessageManager.getInstance().registerListener(this.ifd);
        MessageManager.getInstance().registerListener(this.oNT);
        MessageManager.getInstance().registerListener(this.oNU);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oNV);
        MessageManager.getInstance().registerListener(this.oNW);
        MessageManager.getInstance().registerListener(this.oNR);
        this.ifl = new g(tbPageContext.getPageActivity());
        this.ifl.setIPlayerAudioFocusCallBack(new com.baidu.live.u.a() { // from class: com.baidu.tieba.yuyinala.player.b.17
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().muteOrUnmuteAudio(!z);
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
                        this.iem = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.iem.add(alaBroadcastGiftToastData);
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
        this.ieq = intent.getStringExtra("room_id");
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
                this.oNP = new String(Base64.decode(optString2.getBytes()));
                if (!this.oNP.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oNP = "";
                }
            }
            this.oNQ = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.iet = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oNw.b((AlaLiveInfoCoreData) serializableExtra);
            this.iet = true;
        }
        TbConfig.liveScene = 2;
        av(intent);
        this.ieE = this.ieD == null || !this.ieD.aQd;
        this.oNE.setOtherParams(this.otherParams);
        this.iel = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        efK();
        Aq(true);
        this.mHandler.removeCallbacks(this.ieM);
        this.mHandler.postDelayed(this.ieM, 1000L);
    }

    private void av(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoQ = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.ies = new JSONObject(stringExtra);
                if (this.ies != null) {
                    String optString2 = this.ies.optString("enterRoomId");
                    String optString3 = this.ies.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.ieq, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.buN + "", optString3))) {
                        String optString4 = this.ies.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.ies.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.iet) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.buN;
                            alaLiveInfoCoreData.screenDirection = this.ies.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oNw.b(alaLiveInfoCoreData);
                            this.iet = true;
                        }
                    }
                    String optString6 = this.ies.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.ieD = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oNw != null) {
                            this.oNw.Ht(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoQ = jSONObject.optString("live_back_scheme");
                        this.ieD = new bw();
                        this.ieD.aQd = jSONObject.optInt("is_hot") == 1;
                        if (this.ieD.aQd) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ieD.aQe = jSONObject.optString("task_id");
                        this.ieD.aQc = TextUtils.isEmpty(this.ieD.aQe) ? false : true;
                        this.ieD.aQf = jSONObject.optInt("task_type");
                        this.ieD.aQg = jSONObject.optInt("task_im_count");
                        this.ieD.aQh = jSONObject.optLong("task_gift_total_price");
                        this.ieD.aQi = jSONObject.optLong("task_watch_time");
                        this.ieD.aQj = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oNB = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oNB.setScheme(optString8);
                            this.oNB.setImageUrl(optString9);
                            this.oNB.setTitle(optString10);
                        }
                    }
                    this.ien = this.ies.optString("open_giftlist");
                    this.oND = this.ies.optString(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.ies.remove("cover");
                    this.ies.remove("live_url");
                    this.ies.remove("enterRoomId");
                    this.ies.remove("enterLiveId");
                    this.ies.remove("open_giftlist");
                    this.ies.remove(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.ies.remove("extra");
                    this.otherParams = this.ies.toString();
                    if (this.oNw != null) {
                        this.oNw.setOtherParams(this.otherParams);
                    }
                    this.ies.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("source");
                    }
                    this.ieF = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.ies.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oNw != null) {
                        this.oNw.vY(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ieg = new AlaLastLiveroomInfo();
                this.ieg.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.ieq), null, cnQ());
        UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.ieq), cnQ());
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
        if (this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null && this.oNw.Fm().mLiveInfo.room_id > 0) {
            this.oNw.VU(this.oNw.Fm().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.ieq)) {
            this.oNw.VU(this.ieq);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.oNw.aw(this.uk, this.buO, this.mForumName);
            z2 = true;
        } else if (this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null && this.oNw.Fm().mLiveInfo.live_id > 0) {
            this.oNw.a(this.oNw.Fm().mLiveInfo.live_id, false, this.buO, this.mForumName);
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
            this.oNw.aw(this.uk, this.buO, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.ieq)) {
            this.oNw.HY(this.ieq);
            z2 = true;
        } else if (this.buN > 0) {
            this.oNw.a(this.buN, false, this.buO, "");
            z2 = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
        if (z2) {
            efN();
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

    private void efK() {
        this.byF = true;
        this.iei = false;
        efL();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bc().l(this.hGF);
        this.oNF = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oNF.a(this.ieY);
        this.oNF.setOtherParams(this.otherParams);
        this.oNF.nO(this.ieF);
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
            abVar.aIU.bg_cover = this.oNP;
            abVar.mLiveInfo = new AlaLiveInfoData();
            abVar.aIz = new AlaLiveUserInfoData();
            abVar.aIA = new aa();
            abVar.aIY = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            abVar.bx(true);
            this.oNw.setLiveShowData(abVar);
            cnE();
            cnB();
            this.oNF.a(abVar, this.mAudioUrl, this.oNQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void efL() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oNy = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oNy.setOnPageChangeListener(this.ieZ);
        this.oNy.setBoundaryCaching(true);
        this.oNy.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oNz = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oNz.cgK();
        this.oNx = this.oNz.LZ(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oNP)) {
                this.oNx.setBgImageUrl(this.oNP, null);
            } else {
                this.oNx.setDefaultBg();
            }
            this.oNz.LZ(0).setDefaultBg();
            this.oNz.LZ(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oNw != null) {
            this.oNz.a(this.mSelectedPosition, this.oNw.Fm());
        }
        this.oNy.setAdapter(this.oNz);
        this.oNy.setCurrentItem(this.mSelectedPosition);
        this.oNy.setIsScrollable(this.ieE);
        this.hGE = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGF = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oNy.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.21
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                ab Fm;
                if ((b.this.oNw == null || (Fm = b.this.oNw.Fm()) == null || Fm.mLiveInfo == null || Fm.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oNO = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oNw == null || !b.this.oNw.cjB() || rawY <= 0.0f) {
                            if (b.this.oNw == null || !b.this.oNw.cjC() || rawY >= 0.0f) {
                                if (m.edA().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                i.edx().Ad(false);
                                m.edA().aA(b.this.mTbPageContext.getPageActivity());
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
            public boolean LY(int i) {
                ab Fm;
                if (b.this.oNw == null || (Fm = b.this.oNw.Fm()) == null || Fm.mLiveInfo == null || Fm.mLiveInfo.live_status != 2) {
                    m.edA().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.21.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edC() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edD() {
                            if (b.this.oNy != null) {
                                if (b.this.oNw == null || !b.this.oNw.cjB() || !b.this.oNO) {
                                    if (b.this.oNw == null || !b.this.oNw.cjC() || b.this.oNO) {
                                        int currentItem = b.this.oNy.getCurrentItem();
                                        if (b.this.oNO) {
                                            if (currentItem == 0) {
                                                b.this.oNy.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oNy.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oNy.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oNy.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oNy.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oNy.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edE() {
                        }
                    });
                    if (b.this.oNw != null && b.this.oNw.cjB() && b.this.oNO) {
                        return true;
                    }
                    if (b.this.oNw == null || !b.this.oNw.cjC() || b.this.oNO) {
                        if (m.edA().isShowing()) {
                            return false;
                        }
                        i.edx().Ad(false);
                        return m.edA().aA(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        q edM = q.edM();
        edM.a(this.mTbPageContext, this.oNx, rect);
        edM.a(this);
    }

    private void cnB() {
        this.oNA = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hGE);
    }

    private void c(Rect rect) {
        this.oCN = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.oCN.setSwipeClearEnable(false);
        this.oCN.hRw = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oNx.a(this.oCN, layoutParams);
    }

    private void cnE() {
        if (this.oNw != null && this.oNw.Fm() != null) {
            this.aDd = this.oNw.Fm();
            if (this.aDd.mLiveInfo != null) {
                a(this.aDd.mLiveInfo, this.iet);
                if (this.aDd.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.iej);
                    }
                    if (this.oNF != null) {
                        this.oNF.a(this.mTbPageContext, this.oCN, null, this.oNx, this.oNw, this.buO, this.iel, this.hGJ, this.iem, this.ieD);
                        efQ();
                    }
                }
            }
        }
    }

    private void cnM() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.iel || !this.ieE) {
                this.oNy.setIsScrollable(false);
            } else {
                this.oNy.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bc().onBackPressed() && ((this.oNF == null || !this.oNF.onKeyDown(i, keyEvent)) && (this.oNF == null || !this.oNF.cbW()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnM();
            } else if (!m.edA().aA(this.mTbPageContext.getPageActivity())) {
                i.edx().Ad(false);
            } else if (this.oNF == null || this.oNF.cbX()) {
                pf(true);
                bZb();
            }
        }
        return true;
    }

    public void bZb() {
        if (!TextUtils.isEmpty(this.hoQ)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoQ);
                this.hoQ = null;
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
        cnO();
        long j = -1;
        if (this.oNw != null && this.oNw.cjG() != null) {
            j = this.oNw.cjG().room_id;
        }
        this.oNv.b(z, z2, j);
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
        if (this.oNC) {
            efP();
            this.oNC = false;
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ieg = null;
        if (al.FB() != null) {
            al.FB().FA();
        }
        com.baidu.live.core.layer.b.Bc().Bd();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().dh(this.oCN);
        if (this.ieR != null) {
            this.ieR.release();
        }
        if (this.oNI != null) {
            this.oNI.release();
        }
        this.ieD = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oNy);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oNw != null) {
            this.oNw.Ht(null);
            AlaLiveInfoData cjG = this.oNw.cjG();
            if (cjG != null) {
                this.oNw.fI(cjG.live_id);
            }
        }
        this.oNG.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnN();
        if (this.oNF != null) {
            this.oNF.nU(z);
        }
        this.iew = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mu().brr != null) {
            com.baidu.live.liveroom.a.b.Mu().brr.b(this.aDd.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().aAJ();
        }
        q.edM().Ar();
        aj.gn("");
        if (this.oNv != null && this.oNv.cnw()) {
            am.FC().EZ();
        }
    }

    private void cnN() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            if (this.oCN.findViewById(a.f.ala_live_header_view).getMeasuredWidth() == 0) {
                if (abVar.mLiveInfo != null && abVar.mLiveInfo.live_id > 0) {
                    this.oNw.fI(abVar.mLiveInfo.live_id);
                    cnR();
                    this.oNw.a(abVar.mLiveInfo.live_id, false, this.buO, "");
                    return;
                }
                return;
            }
            if (abVar.aIU != null && this.oNw.oxj) {
                aN(abVar);
            }
            aO(abVar);
            this.aDd = abVar;
            if (this.oNF != null) {
                this.oNF.a(abVar);
            }
        }
    }

    private void aN(ab abVar) {
        if (abVar.aIU.aTP) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().WH(abVar.aIU.aTO)) {
                WV(com.baidu.live.storage.b.hH(abVar.aIU.aTO));
                return;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501079, new String[]{abVar.aIU.aTN, abVar.aIU.aTO}));
                return;
            }
        }
        this.oNx.setBgImageUrl(abVar.aIU.bg_cover, null);
        this.oNx.ecu();
    }

    private void aO(final ab abVar) {
        List<dd.a> list;
        if (abVar.aIV != null && abVar.aIU != null && (list = abVar.aIV.aTf) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final dd.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aTj + aVar.aTl + aVar.aTn + abVar.aIU.aTK;
                    if (!this.oNK.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aTj - (System.currentTimeMillis() / 1000));
                        this.oNK.add(str);
                        if (this.oNu == null) {
                            this.oNu = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!efM() || StringUtils.isNull(aVar.aTl, true) || StringUtils.isNull(aVar.aTn, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oNu.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oNu.a(z, aVar.aTj, aVar.aTl, aVar.aTn, abVar.aIU.aTK, abVar.aIU.live_id, abVar.aIU.croom_id, aVar.aTk, aVar.aTm, abVar.aIV.aTe + "", abVar.aIU.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oNu.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oNu.a(false, aVar.aTj, aVar.aTl, aVar.aTn, abVar.aIU.aTK, abVar.aIU.live_id, abVar.aIU.croom_id, aVar.aTk, aVar.aTm, abVar.aIV.aTe + "", abVar.aIU.is_followed);
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

    private boolean efM() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CE(), true);
    }

    private void c(v vVar) {
        if (this.oNF != null) {
            this.oNF.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aDd = abVar;
    }

    private void cnP() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oNy.setIsScrollable(false);
            this.ieE = false;
        }
        if (this.aDd != null) {
            a(this.aDd.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oNx.a(this.oCN, null);
            a(this.oNx, this.aDd.mLiveInfo, this.byF);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.mLiveInfo.room_id), String.valueOf(this.aDd.mLiveInfo.feed_id), cnQ());
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

    private String cnQ() {
        if (this.ies == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.ies.optString("source");
            String optString2 = this.ies.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ies.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.ies.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.ies.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        q edM = q.edM();
        ViewGroup edO = edM.edO();
        if (edO != null && edO.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cz(edO)) {
                        ((ViewGroup) edO.getParent()).removeView(edO);
                        alaLiveRoomBlurPageLayout.f(edO, null);
                        edM.edN();
                    } else if (edM != null) {
                        edM.edN();
                    }
                } else if (edM != null) {
                    edM.edN();
                }
            } else if (edM != null) {
                edM.edN();
            }
        } else if (edO != null && edO.getParent() == null) {
            alaLiveRoomBlurPageLayout.f(edO, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        ViewGroup edO = q.edM().edO();
        if (edO != null) {
            edO.setLayoutParams(b2);
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

    public void cnR() {
        this.byF = true;
    }

    public boolean cnS() {
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
        ViewGroup edO = q.edM().edO();
        if (edO != null) {
            int i2 = edO.getLayoutParams().width;
            int i3 = edO.getLayoutParams().height;
            int i4 = edO.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) edO.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i2 || b2.height != i3 || b2.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.oCN != null) {
                this.oCN.setLayoutParams(c);
            }
            if (this.oNx != null) {
                this.oNx.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oNE != null) {
                this.oNE.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oNF != null) {
                this.oNF.l(c.width, c.height, realScreenOrientation);
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
                this.oNw.VU(alaLiveInfoData.room_id + "");
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
            this.oNw.a(alaLiveInfoData.live_id, true, this.buO, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fm = this.oNw.Fm();
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
            this.oNw.vZ(this.oNw.cjD() - 1);
        } else if (i > 0) {
            this.oNw.vZ(this.oNw.cjD() + 1);
        }
        if (this.oNF != null) {
            this.oNF.a(this.oNx);
        }
        this.oNz.a(this.mSelectedPosition, cnU(), this.aDd);
        this.oNz.b(this.mSelectedPosition, cnV(), this.aDd);
        if (this.oNw != null) {
            AlaLiveInfoData cjG = this.oNw.cjG();
            if (cjG != null) {
                cjG.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cjG);
                a(this.oNx, cjG, this.byF);
                this.byF = false;
                if (this.oNF != null) {
                    this.oNF.a(this.mTbPageContext, this.oCN, null, this.oNx, this.oNw, this.buO, this.iel, this.hGJ, null, this.ieD);
                    efQ();
                }
                a(cjG, false);
            }
            i(cjG);
            if (this.oNF != null) {
                this.oNF.cbU();
            }
            this.oNw.g(cjG);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.oCN.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.oCN.findViewById(a.f.ala_live_footer_view);
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
                this.oNx.setBgImageUrl(alaLiveInfoData.bg_cover, null);
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
            this.oNw.setLiveShowData(abVar);
            abVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.oNF != null) {
                this.oNF.a(abVar, str, str2);
            }
            UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.aIU.aTK), cnQ());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oNx.a(this.oCN, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efN() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eex().bdh();
    }

    private AlaLiveInfoData cnU() {
        List<AlaLiveInfoData> cjw = this.oNw.cjw();
        if (cjw == null || cjw.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        int cjD = this.oNw.cjD();
        int size = cjw.size();
        return cjw.get(((cjD + size) - 1) % size);
    }

    private AlaLiveInfoData cnV() {
        List<AlaLiveInfoData> cjw = this.oNw.cjw();
        if (cjw == null || cjw.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        return cjw.get((this.oNw.cjD() + 1) % cjw.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (cVar != null) {
            if (!this.iei) {
                b(cVar);
            }
            if (this.oNw.oxk) {
                this.mHandler.removeCallbacks(this.oNL);
                this.mHandler.postDelayed(this.oNL, 1000L);
            }
        }
    }

    private void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (this.oNF != null) {
            this.oNF.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.iej) {
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
        ab Fm = this.oNw.Fm();
        V(Fm);
        if (Fm != null && Fm.aIU != null) {
            aN(Fm);
        }
        this.oNC = true;
        efO();
        this.oNw.cjx();
        if (this.byF) {
            this.oNw.oG(false);
        }
        this.hGJ = System.currentTimeMillis() / 1000;
        if (this.oNF != null) {
            this.oNF.a(this.mTbPageContext, this.oCN, null, this.oNx, this.oNw, this.buO, this.iel, this.hGJ, this.iem, this.ieD);
            efQ();
        }
        cnP();
        if (Fm != null && Fm.mLiveInfo != null && Fm.mLiveInfo.live_status == 2) {
            this.oNz.a(this.mSelectedPosition, this.oNw.Fm());
            e(Fm, false);
            this.byF = false;
            return;
        }
        boolean z = (this.oNF == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        aj.e(Fm);
        if (z) {
            if (!this.ieA || !TextUtils.equals(t.Vv(), this.ieB)) {
                aj.b(getPageContext(), false, this.oNv.cnw());
                e.Qz().QA();
                this.ieA = true;
                this.ieB = t.Vv();
            }
            aj.Ft();
        }
        if (this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null) {
            this.oNw.hM(this.oNw.Fm().mLiveInfo.live_id);
            this.iew = true;
        }
        if (this.oNF != null) {
            this.oNF.b(this.ieg);
            this.oNF.aF(TextUtils.equals(this.ien, "1"), TextUtils.equals(this.oND, "1"));
            this.ien = "";
            this.oND = "";
        }
        if (this.oNA != null) {
            this.oNA.a(this.aDd, this.oNB);
        }
        a(this.oNw.Fm());
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
                if (b.this.mTbPageContext != null && b.this.oNw.Fm() != null && b.this.oNw.Fm().mLiveInfo != null) {
                    b.this.oNw.a(b.this.oNw.Fm().mLiveInfo.live_id, b.this.buO, b.this.hGJ);
                }
            }
        });
        this.byF = false;
        if (z && this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null && this.oNw.Fm().aId != null && this.oNF != null) {
            long j = this.oNw.Fm().mLiveInfo.live_id;
            long j2 = this.oNw.Fm().mLiveInfo.room_id;
            String str2 = this.oNw.Fm().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FB() != null) {
                    al.FB().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.ieR != null) {
                    this.ieR.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IS() != null) {
                com.baidu.live.guardclub.e.IS().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oNI == null) {
                this.oNI = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oNI.a(this.mTbPageContext.getPageActivity(), this.oNw.Fm(), this.otherParams);
        }
        if (this.oNJ == null) {
            this.oNJ = new com.baidu.tieba.yuyinala.liveroom.p.c(this.mTbPageContext);
        }
        if (z && this.oNw.Fm() != null && this.oNw.Fm().aIz != null && !this.iez) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oNJ.a(this.oNw.Fm(), this.oNw.Fm().aIz.userId);
                this.iez = true;
            }
        }
    }

    private void efO() {
        try {
            if (this.oNw != null && this.oNw.Fm() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oNw.Fm().aIz.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oNw.Fm().aIU.croom_id);
                    jSONObject.put("room_id", this.oNw.Fm().aIU.aTK);
                    jSONObject.put("vid", this.oNw.Fm().mLiveInfo.feed_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.byF) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oNw.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oNw.Fm().mLiveInfo.feed_id);
                }
                if (!this.oNw.cjw().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oNw.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oNw.Fm().mLiveInfo.feed_id);
                    this.oNw.cjw().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oNw.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oNw.Fm().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oNw.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oNw.Fm().mLiveInfo.feed_id);
                this.oNH = new StayTimeBean();
                this.oNH.liveId = this.oNw.Fm().mLiveInfo.live_id;
                this.oNH.roomId = this.oNw.Fm().mLiveInfo.room_id;
                this.oNH.vid = this.oNw.Fm().mLiveInfo.feed_id;
                this.oNH.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    private void efP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("identity", this.oNw.Fm().aIz.getUserTypeStr());
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oNw.Fm().aIU.croom_id);
            jSONObject.put("room_id", this.oNw.Fm().aIU.aTK);
            jSONObject.put("vid", this.oNw.Fm().mLiveInfo.feed_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnW() {
        if (this.ieh) {
            this.oNz.a(this.mSelectedPosition, cnU(), this.aDd);
            this.oNz.b(this.mSelectedPosition, cnV(), this.aDd);
            this.ieh = false;
        }
        if (this.oNE != null && cog()) {
            this.oNE.X(this.oNw.cjy());
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
        if (!this.iej) {
            this.mHandler.removeCallbacks(this.ieL);
            this.mHandler.postDelayed(this.ieL, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.iej) {
                this.mHandler.removeCallbacks(this.ieK);
                this.mHandler.postDelayed(this.ieK, 5000L);
                return;
            }
            return;
        }
        if (!this.iei) {
            c(vVar);
        }
        if (!this.iej) {
            this.mHandler.removeCallbacks(this.ieK);
            this.mHandler.postDelayed(this.ieK, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnX() {
        if (this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null) {
            this.oNw.hM(this.oNw.Fm().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.aIz != null && abVar.aIz.logined == 1) {
            pf(false);
        } else if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.oNz.a(this.mSelectedPosition, this.oNw.Fm());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.iei) {
                aj.e(abVar);
                a(abVar);
            }
            if (!this.iej) {
                this.mHandler.removeCallbacks(this.hJY);
                this.mHandler.postDelayed(this.hJY, abVar.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (this.mTbPageContext != null && this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null) {
            this.oNw.a(this.oNw.Fm().mLiveInfo.live_id, this.buO, this.hGJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        View view = null;
        nU(true);
        if (!cog()) {
            this.oNw.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oNx != null) {
                this.oNx.Xi();
                this.oNx.clj();
            }
            if (abVar != null && abVar.mLiveInfo != null) {
                this.ier = abVar.mLiveInfo.live_id;
            }
            cnM();
            cnY();
            cnZ();
            if (abVar != null) {
                if (this.oNF != null && this.oNF.cca() != null) {
                    view = this.oNF.cca().a(this.oNF.eaN().pageContext.getPageActivity(), abVar, z);
                }
                if (this.oNx != null) {
                    this.oNE.a(this.oNx, view, abVar, z, this.oNw.cjy());
                }
                if (this.oNF != null) {
                    this.oNF.nU(false);
                    this.oNF.cbV();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oNx != null) {
                    this.oNx.cll();
                }
                long j = abVar.mLiveInfo.live_id;
                long j2 = abVar.mLiveInfo.room_id;
                String str = abVar.mLiveInfo.feed_id;
                long j3 = abVar.aId.userId;
                String str2 = abVar.aId.userName;
            }
            coi();
            if (this.oNA != null) {
                this.oNA.a(this.aDd, this.oNB);
            }
        }
    }

    private void cnY() {
    }

    private void cnZ() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oNy);
        }
    }

    public void coa() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cob();
        } else {
            coc();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oNw != null && this.oNw.Fm() != null) {
            alaLiveInfoData = this.oNw.Fm().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cob();
        } else {
            coc();
        }
        this.oNy.setIsScrollable(!z && this.ieE);
        if (this.oNF != null) {
            this.oNF.onKeyboardVisibilityChanged(z);
        }
        if (this.oCN != null) {
            this.oCN.onKeyboardVisibilityChanged(z);
        }
        if (z) {
            q.edM().setMaskBg(z);
        }
    }

    public void cr(int i) {
    }

    public void cob() {
        if (this.oNy != null) {
            com.baidu.live.utils.i.ae(this.oNy);
        }
    }

    public void coc() {
        if (this.oNy != null) {
            com.baidu.live.utils.i.af(this.oNy);
        }
    }

    public void onResume() {
        if (this.oNw != null) {
            this.oNw.cji();
        }
        if (this.oNF != null) {
            this.oNF.enterForeground();
        }
        if (this.oNI != null) {
            this.oNI.onResume();
        }
        if (this.oNJ != null) {
            this.oNJ.onResume();
        }
        if (this.ifl != null && !this.ifl.hasFocus()) {
            this.ifl.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.Bc().onResume();
    }

    public void onStart() {
        if (!this.ieC) {
            if (this.iej) {
                this.iej = false;
                cof();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cof() {
        cjb();
        cnX();
        this.oNw.cjx();
        if (this.oNx != null) {
            this.oNx.ecw();
        }
        if (this.oNF != null) {
            this.oNF.cbZ();
        }
        if (this.oNw != null && this.oNw.Fm() != null && this.oNw.Fm().mLiveInfo != null) {
            this.oNG.fL(this.oNw.Fm().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDd.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oNw != null) {
            this.oNw.cjj();
        }
        if (this.oNF != null) {
            this.oNF.enterBackground();
        }
        com.baidu.live.core.layer.b.Bc().onPause();
    }

    public void pc(boolean z) {
        this.iej = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hJY);
        this.mHandler.removeCallbacks(this.oNL);
        this.mHandler.removeCallbacks(this.ieK);
        this.mHandler.removeCallbacks(this.ieL);
        if (this.oNx != null) {
            this.oNx.ecv();
        }
        if (this.oNF != null) {
            this.oNF.cbY();
        }
        this.oNG.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FB() != null) {
                al.FB().a(i, i2, intent, this.aDd, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oNF != null) {
            this.oNF.onActivityResult(i, i2, intent);
        }
    }

    public boolean cog() {
        return this.oNE != null && this.oNE.bUL();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.oNS);
        MessageManager.getInstance().unRegisterListener(this.ifd);
        MessageManager.getInstance().unRegisterListener(this.oNT);
        MessageManager.getInstance().unRegisterListener(this.oNU);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oNV);
        MessageManager.getInstance().unRegisterListener(this.oNW);
        MessageManager.getInstance().unRegisterListener(this.oNR);
        if (this.ieR != null) {
            this.ieR.release();
        }
        if (this.oNA != null) {
            this.oNA.onDestory();
        }
        q.edM().cKX();
        if (this.oNB != null) {
            this.oNB.reset();
        }
        if (this.oNF != null) {
            this.oNF.onDestroy();
        }
        if (this.oNz != null) {
            this.oNz.onDestroy();
        }
        this.oNx.Xi();
        if (this.oNx != null) {
            this.oNx.release();
            this.oNx = null;
        }
        if (this.oNE != null) {
            this.oNE.onDestroy();
        }
        if (this.ifl != null) {
            this.ifl.abandonAudioFocus();
        }
        if (this.oNH != null && this.oNw != null && this.oNw.Fm() != null) {
            if (this.oNH.liveId == this.oNw.Fm().mLiveInfo.live_id && this.oNH.startTime > 0) {
                this.oNH.endTime = System.currentTimeMillis();
                long j = this.oNH.endTime - this.oNH.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oNw.Fm().aIU.aTK, this.otherParams, this.mSelectedPosition + 1, this.byF, this.oNw.Fm().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oNH = null;
        }
        if (this.oCN != null) {
            this.oCN.clr();
            this.oCN = null;
        }
        if (this.oNw != null) {
            this.oNw.destory();
        }
        z.Fe().release();
        if (this.oNJ != null) {
            this.oNJ.release();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eex().release();
        m.edA().a((m.a) null);
    }

    public void ph(boolean z) {
        this.ieC = z;
    }

    public void coh() {
        if (this.ies != null) {
            this.otherParams = this.ies.toString();
            if (this.oNw != null) {
                this.oNw.setOtherParams(this.otherParams);
            }
            if (this.oNF != null) {
                this.oNF.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oNE != null) {
                this.oNE.setOtherParams(this.otherParams);
            }
        }
    }

    public void coi() {
        if (this.ies != null) {
            String optString = this.ies.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.ies.put("tab", "live_jump");
                        this.ies.put("tag", "");
                        this.ies.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.ies.put("tab", "liveroom");
                        this.ies.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                coh();
            }
        }
    }

    public void coj() {
        aj.Fw();
    }

    private void efQ() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oNF.e((short) 2);
        } else {
            this.oNF.eaO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oNN = bitmap;
            this.oNx.setBgImageBitmap(this.oNN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oNx.setBgVideo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efR() {
        if (this.oNN != null) {
            if (!this.oNN.isRecycled()) {
                this.oNN.recycle();
            }
            this.oNN = null;
        }
        aN(this.aDd);
    }

    public boolean edU() {
        return this.ieC;
    }
}

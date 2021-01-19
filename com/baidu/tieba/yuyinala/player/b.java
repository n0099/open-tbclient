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
import com.baidu.live.af.e;
import com.baidu.live.ai.c;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.br;
import com.baidu.live.data.cx;
import com.baidu.live.data.dd;
import com.baidu.live.data.r;
import com.baidu.live.data.w;
import com.baidu.live.data.x;
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
import com.baidu.live.utils.i;
import com.baidu.live.utils.p;
import com.baidu.live.utils.t;
import com.baidu.live.v.g;
import com.baidu.tieba.yuyinala.liveroom.grabredpacket.d;
import com.baidu.tieba.yuyinala.liveroom.k.a;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
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
/* loaded from: classes10.dex */
public class b extends BdBaseView<TbPageContext> {
    private x aBr;
    private CustomMessageListener bdo;
    private long brk;
    private String brl;
    private boolean bvd;
    private ViewGroup hCh;
    private LayerRootView hCi;
    private long hCm;
    private Runnable hFy;
    private ArrayList<AlaBroadcastGiftToastData> hZA;
    private String hZB;
    private String hZE;
    private long hZF;
    private JSONObject hZG;
    private boolean hZH;
    private boolean hZK;
    private boolean hZN;
    private boolean hZO;
    private String hZP;
    private boolean hZQ;
    private br hZR;
    private boolean hZS;
    private boolean hZT;
    private Runnable hZY;
    private Runnable hZZ;
    private AlaLastLiveroomInfo hZu;
    private boolean hZv;
    private boolean hZw;
    private boolean hZx;
    private boolean hZz;
    private String hkk;
    private Runnable iaa;
    private c iaf;
    com.baidu.live.liveroom.a.c iam;
    ViewPager.OnPageChangeListener ian;
    CustomMessageListener iar;
    private g iaz;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private d oCL;
    private a oCM;
    private com.baidu.tieba.yuyinala.liveroom.k.a oCN;
    private AlaLiveRoomBlurPageLayout oCO;
    private AlaLoopViewPager oCP;
    private AlaLoopViewPagerAdapter oCQ;
    private com.baidu.tieba.yuyinala.liveroom.d.a oCR;
    private com.baidu.tieba.yuyinala.liveroom.d.b oCS;
    private String oCT;
    private com.baidu.tieba.yuyinala.endliveroom.a oCU;
    private com.baidu.tieba.yuyinala.liveroom.c.b oCV;
    private com.baidu.tieba.yuyinala.liveroom.task.b oCW;
    private StayTimeBean oCX;
    private com.baidu.tieba.yuyinala.liveroom.g.a oCY;
    private com.baidu.tieba.yuyinala.liveroom.p.c oCZ;
    private Set<String> oDa;
    private Runnable oDb;
    private int oDc;
    private Bitmap oDd;
    private boolean oDe;
    private String oDf;
    private String oDg;
    private String oDh;
    private CustomMessageListener oDi;
    CustomMessageListener oDj;
    private CustomMessageListener oDk;
    private CustomMessageListener oDl;
    CustomMessageListener oDm;
    CustomMessageListener oDn;
    private a.InterfaceC0922a omI;
    private AlaLiveView osC;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hZv = true;
        this.hCm = 0L;
        this.hZw = false;
        this.bvd = true;
        this.brl = "";
        this.mForumName = "";
        this.hZx = false;
        this.hZz = false;
        this.hZB = "0";
        this.oCT = "0";
        this.mHandler = new Handler();
        this.hZF = -1L;
        this.otherParams = "";
        this.hZH = false;
        this.oCW = com.baidu.tieba.yuyinala.liveroom.task.b.dZz();
        this.hZK = false;
        this.hZO = false;
        this.hZQ = false;
        this.hZT = false;
        this.oDa = new HashSet();
        this.hFy = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cib();
            }
        };
        this.hZY = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cmS();
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.oCN.cix();
            }
        };
        this.oDb = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oCN.DW() != null) {
                    b.this.oCN.ag(b.this.oCN.DW());
                }
            }
        };
        this.oDc = 5000;
        this.oDf = "";
        this.oDg = "";
        this.oDh = "";
        this.oDi = new CustomMessageListener(2501082) { // from class: com.baidu.tieba.yuyinala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oCN != null && b.this.oCN.DW() != null) {
                    b.this.oCN.ag(b.this.oCN.DW());
                }
            }
        };
        this.bdo = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.iaa = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.20
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
        this.iam = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // com.baidu.live.liveroom.a.c
            public void ct(final boolean z) {
                if (!k.ebf().isShowing()) {
                    h.ebd().zK(false);
                    boolean aH = k.ebf().aH(b.this.mTbPageContext.getPageActivity());
                    k.ebf().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebh() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebi() {
                            if (z || b.this.oCV == null || b.this.oCV.caW()) {
                                b.this.oV(true);
                                b.this.bXW();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebj() {
                        }
                    });
                    if (aH) {
                        if (z || b.this.oCV == null || b.this.oCV.caW()) {
                            b.this.oV(true);
                            b.this.bXW();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cu(boolean z) {
                b.this.e(b.this.aBr, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oCP != null) {
                    b.this.oCP.setIsScrollable(b.this.hZS && z);
                    b.this.oCP.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cv(boolean z) {
            }
        };
        this.ian = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.osC != null && b.this.oCN != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oCP.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oCX != null && b.this.oCN != null && b.this.oCN.DW() != null && b.this.oCN.DW().mLiveInfo != null && b.this.oCN.DW().aGy != null) {
                        if (b.this.oCX.liveId == b.this.oCN.DW().mLiveInfo.live_id && b.this.oCX.startTime > 0) {
                            b.this.oCX.endTime = System.currentTimeMillis();
                            long j = b.this.oCX.endTime - b.this.oCX.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oCN.DW().aGy.aQH, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bvd, b.this.oCN.DW().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oCX = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.oCN != null && b.this.oCN.DW() != null && b.this.oCN.DW().aGd != null) {
                            jSONObject.put("identity", b.this.oCN.DW().aGd.getUserTypeStr());
                        }
                        if (b.this.oCN != null && b.this.oCN.DW() != null && b.this.oCN.DW().aGy != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.oCN.DW().aGy.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bvd || b.this.oCN.ciw() == null || ListUtils.getCount(b.this.oCN.ciw()) > 1) {
                        if (b.this.oCN.ciB() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.oCN == null || !b.this.oCN.ciB() || i2 >= 0) {
                            if (b.this.oCN != null && b.this.oCN.ciC() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oCP.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.oCN != null) {
                                b.this.oCN.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nJ(true);
                            b.this.oCO.cke();
                            b.this.oCO.Vz();
                            b.this.oCO.ckf();
                            b.this.cnd();
                            if (b.this.iaf != null) {
                                b.this.iaf.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oCO = b.this.oCQ.LE(b.this.mSelectedPosition);
                            b.this.oCO.ckg();
                            b.this.wn(i2);
                            b.this.edo();
                            b.this.Mj(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oCP.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oCP.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oCN.g(b.this.oCN.ciG());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oCP != null && i == 0) {
                    com.baidu.live.d.xf().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.omI = new a.InterfaceC0922a() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0922a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.oCN.DW());
                } else if (i2 == 2) {
                    b.this.f(b.this.oCN.bTh());
                } else if (i2 == 3) {
                    b.this.bs(i, str);
                } else if (i2 == 12) {
                    b.this.c(b.this.oCN.dZp());
                } else if (i2 == 11) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_IS_INIT, b.this.bvd ? "1" : "0");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle", jSONObject);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cmR();
                }
            }
        };
        this.oDj = new CustomMessageListener(2913169) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    o.ebo().setMaskBg(false);
                }
            }
        };
        this.iar = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oCN != null && b.this.oCN.DW() != null && b.this.oCN.DW().aGd != null) {
                        if (l.longValue() == b.this.oCN.DW().aGd.userId) {
                            b.this.oCN.DW().aGd.isNewUser = false;
                            if (b.this.oCY != null) {
                                b.this.oCY.o(b.this.oCN.DW());
                            }
                        }
                    }
                }
            }
        };
        this.oDk = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.edr();
                    } else {
                        b.this.X((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oDl = new CustomMessageListener(2501078) { // from class: com.baidu.tieba.yuyinala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501078) {
                    String str = null;
                    if (customResponsedMessage.getData() instanceof String) {
                        str = (String) customResponsedMessage.getData();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.this.VK(str);
                    }
                }
            }
        };
        this.oDm = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cib();
            }
        };
        this.oDn = new CustomMessageListener(2501080) { // from class: com.baidu.tieba.yuyinala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501080 && (customResponsedMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig)) {
                    final YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customResponsedMessage.getData();
                    if (!k.ebf().isShowing()) {
                        h.ebd().zK(false);
                        if (k.ebf().aH(b.this.mTbPageContext.getPageActivity())) {
                            b.this.oV(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            return;
                        }
                        k.ebf().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void ebh() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void ebi() {
                                b.this.oV(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void ebj() {
                            }
                        });
                    }
                }
            }
        };
        this.hCm = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oCM = aVar;
        this.hZv = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.iaf = (c) runTask.getData();
        }
        this.oCN = new com.baidu.tieba.yuyinala.liveroom.k.a(getPageContext());
        this.oCN.a(this.omI);
        this.oCU = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.oDj);
        MessageManager.getInstance().registerListener(this.iar);
        MessageManager.getInstance().registerListener(this.oDk);
        MessageManager.getInstance().registerListener(this.oDl);
        MessageManager.getInstance().registerListener(this.bdo);
        MessageManager.getInstance().registerListener(this.oDm);
        MessageManager.getInstance().registerListener(this.oDn);
        MessageManager.getInstance().registerListener(this.oDi);
        this.iaz = new g(tbPageContext.getPageActivity());
        this.iaz.setIPlayerAudioFocusCallBack(new com.baidu.live.v.a() { // from class: com.baidu.tieba.yuyinala.player.b.17
            @Override // com.baidu.live.v.a
            public void cC(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().muteOrUnmuteAudio(!z);
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
                        this.hZA = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hZA.add(alaBroadcastGiftToastData);
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
        this.brl = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.brl)) {
            this.brl = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hZE = intent.getStringExtra("room_id");
        this.brk = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.oDf = new String(Base64.decode(optString.getBytes()));
                if (!this.oDf.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oDf = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.oDg = new String(Base64.decode(optString2.getBytes()));
                if (!this.oDg.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oDg = "";
                }
            }
            this.oDh = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.hZH = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oCN.b((AlaLiveInfoCoreData) serializableExtra);
            this.hZH = true;
        }
        TbConfig.liveScene = 2;
        av(intent);
        this.hZS = this.hZR == null || !this.hZR.aNc;
        this.oCU.setOtherParams(this.otherParams);
        this.hZz = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        edl();
        zX(true);
        this.mHandler.removeCallbacks(this.iaa);
        this.mHandler.postDelayed(this.iaa, 1000L);
    }

    private void av(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hkk = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hZG = new JSONObject(stringExtra);
                if (this.hZG != null) {
                    String optString2 = this.hZG.optString("enterRoomId");
                    String optString3 = this.hZG.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hZE, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.brk + "", optString3))) {
                        String optString4 = this.hZG.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hZG.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hZH) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brk;
                            alaLiveInfoCoreData.screenDirection = this.hZG.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oCN.b(alaLiveInfoCoreData);
                            this.hZH = true;
                        }
                    }
                    String optString6 = this.hZG.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hZR = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oCN != null) {
                            this.oCN.GO(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hkk = jSONObject.optString("live_back_scheme");
                        this.hZR = new br();
                        this.hZR.aNc = jSONObject.optInt("is_hot") == 1;
                        if (this.hZR.aNc) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hZR.aNd = jSONObject.optString("task_id");
                        this.hZR.aNb = TextUtils.isEmpty(this.hZR.aNd) ? false : true;
                        this.hZR.aNe = jSONObject.optInt("task_type");
                        this.hZR.aNf = jSONObject.optInt("task_im_count");
                        this.hZR.aNg = jSONObject.optLong("task_gift_total_price");
                        this.hZR.aNh = jSONObject.optLong("task_watch_time");
                        this.hZR.aNi = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oCS = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oCS.setScheme(optString8);
                            this.oCS.setImageUrl(optString9);
                            this.oCS.setTitle(optString10);
                        }
                    }
                    this.hZB = this.hZG.optString("open_giftlist");
                    this.oCT = this.hZG.optString(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.hZG.remove("cover");
                    this.hZG.remove("live_url");
                    this.hZG.remove("enterRoomId");
                    this.hZG.remove("enterLiveId");
                    this.hZG.remove("open_giftlist");
                    this.hZG.remove(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.hZG.remove("extra");
                    this.otherParams = this.hZG.toString();
                    if (this.oCN != null) {
                        this.oCN.setOtherParams(this.otherParams);
                    }
                    this.hZG.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("source");
                    }
                    this.hZT = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hZG.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oCN != null) {
                        this.oCN.vN(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hZu = new AlaLastLiveroomInfo();
                this.hZu.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brk), String.valueOf(this.hZE), null, cmL());
        UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brk), String.valueOf(this.hZE), cmL());
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

    public void zX(boolean z) {
        boolean z2 = false;
        if (this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null && this.oCN.DW().mLiveInfo.room_id > 0) {
            this.oCN.UK(this.oCN.DW().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.hZE)) {
            this.oCN.UK(this.hZE);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.oCN.av(this.uk, this.brl, this.mForumName);
            z2 = true;
        } else if (this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null && this.oCN.DW().mLiveInfo.live_id > 0) {
            this.oCN.a(this.oCN.DW().mLiveInfo.live_id, false, this.brl, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.brl = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oV(false);
                return;
            }
            this.oCN.av(this.uk, this.brl, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.hZE)) {
            this.oCN.Ht(this.hZE);
            z2 = true;
        } else if (this.brk > 0) {
            this.oCN.a(this.brk, false, this.brl, "");
            z2 = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oV(false);
        }
        if (z2) {
            edo();
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

    private void edl() {
        this.bvd = true;
        this.hZw = false;
        edm();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.As().l(this.hCi);
        this.oCV = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oCV.a(this.iam);
        this.oCV.setOtherParams(this.otherParams);
        this.oCV.nD(this.hZT);
        try {
            x xVar = new x();
            xVar.aGQ = false;
            xVar.aGy = new dd();
            xVar.aGy.live_id = String.valueOf(this.brk);
            xVar.aGy.cover = "";
            xVar.aGy.room_name = ".....";
            xVar.aGy.aQH = "0";
            xVar.aGy.croom_id = "0";
            xVar.aGy.is_followed = true;
            xVar.aGy.bg_cover = this.oDg;
            xVar.mLiveInfo = new AlaLiveInfoData();
            xVar.aGd = new AlaLiveUserInfoData();
            xVar.aGe = new w();
            xVar.aGD = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            xVar.bs(true);
            this.oCN.setLiveShowData(xVar);
            cmz();
            cmw();
            this.oCV.a(xVar, this.oDf, this.oDh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void edm() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oCP = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oCP.setOnPageChangeListener(this.ian);
        this.oCP.setBoundaryCaching(true);
        this.oCP.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oCQ = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oCQ.cfK();
        this.oCO = this.oCQ.LD(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oDg)) {
                this.oCO.setBgImageUrl(this.oDg, null);
            } else {
                this.oCO.setDefaultBg();
            }
            this.oCQ.LD(0).setDefaultBg();
            this.oCQ.LD(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oCN != null) {
            this.oCQ.a(this.mSelectedPosition, this.oCN.DW());
        }
        this.oCP.setAdapter(this.oCQ);
        this.oCP.setCurrentItem(this.mSelectedPosition);
        this.oCP.setIsScrollable(this.hZS);
        this.hCh = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hCi = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oCP.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.21
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                x DW;
                if ((b.this.oCN == null || (DW = b.this.oCN.DW()) == null || DW.mLiveInfo == null || DW.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oDe = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oCN == null || !b.this.oCN.ciB() || rawY <= 0.0f) {
                            if (b.this.oCN == null || !b.this.oCN.ciC() || rawY >= 0.0f) {
                                if (k.ebf().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.ebd().zK(false);
                                k.ebf().aH(b.this.mTbPageContext.getPageActivity());
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
            public boolean LC(int i) {
                x DW;
                if (b.this.oCN == null || (DW = b.this.oCN.DW()) == null || DW.mLiveInfo == null || DW.mLiveInfo.live_status != 2) {
                    k.ebf().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.21.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebh() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebi() {
                            if (b.this.oCP != null) {
                                if (b.this.oCN == null || !b.this.oCN.ciB() || !b.this.oDe) {
                                    if (b.this.oCN == null || !b.this.oCN.ciC() || b.this.oDe) {
                                        int currentItem = b.this.oCP.getCurrentItem();
                                        if (b.this.oDe) {
                                            if (currentItem == 0) {
                                                b.this.oCP.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oCP.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oCP.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oCP.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oCP.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oCP.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void ebj() {
                        }
                    });
                    if (b.this.oCN != null && b.this.oCN.ciB() && b.this.oDe) {
                        return true;
                    }
                    if (b.this.oCN == null || !b.this.oCN.ciC() || b.this.oDe) {
                        if (k.ebf().isShowing()) {
                            return false;
                        }
                        h.ebd().zK(false);
                        return k.ebf().aH(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        o ebo = o.ebo();
        ebo.a(this.mTbPageContext, this.oCO, rect);
        ebo.a(this);
    }

    private void cmw() {
        this.oCR = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hCh);
    }

    private void c(Rect rect) {
        this.osC = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.osC.setSwipeClearEnable(false);
        this.osC.hMO = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oCO.a(this.osC, layoutParams);
    }

    private void cmz() {
        if (this.oCN != null && this.oCN.DW() != null) {
            this.aBr = this.oCN.DW();
            if (this.aBr.mLiveInfo != null) {
                a(this.aBr.mLiveInfo, this.hZH);
                if (this.aBr.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hZx);
                    }
                    if (this.oCV != null) {
                        this.oCV.a(this.mTbPageContext, this.osC, null, this.oCO, this.oCN, this.brl, this.hZz, this.hCm, this.hZA, this.hZR);
                        edq();
                    }
                }
            }
        }
    }

    private void cmH() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hZz || !this.hZS) {
                this.oCP.setIsScrollable(false);
            } else {
                this.oCP.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.As().onBackPressed() && ((this.oCV == null || !this.oCV.onKeyDown(i, keyEvent)) && (this.oCV == null || !this.oCV.caV()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cmH();
            } else if (!k.ebf().aH(this.mTbPageContext.getPageActivity())) {
                h.ebd().zK(false);
            } else if (this.oCV == null || this.oCV.caW()) {
                oV(true);
                bXW();
            }
        }
        return true;
    }

    public void bXW() {
        if (!TextUtils.isEmpty(this.hkk)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hkk);
                this.hkk = null;
            }
        }
    }

    public void oV(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nJ(!z);
        com.baidu.live.core.layer.b.As().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cmJ();
        long j = -1;
        if (this.oCN != null && this.oCN.ciG() != null) {
            j = this.oCN.ciG().room_id;
        }
        this.oCM.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void nJ(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hZu = null;
        if (al.El() != null) {
            al.El().Ek();
        }
        com.baidu.live.core.layer.b.As().At();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().dh(this.osC);
        if (this.iaf != null) {
            this.iaf.release();
        }
        if (this.oCY != null) {
            this.oCY.release();
        }
        this.hZR = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oCP);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oCN != null) {
            this.oCN.GO(null);
            AlaLiveInfoData ciG = this.oCN.ciG();
            if (ciG != null) {
                this.oCN.fD(ciG.live_id);
            }
        }
        this.oCW.stopRecord();
        LiveTimerManager.getInstance().stop();
        cmI();
        if (this.oCV != null) {
            this.oCV.nJ(z);
        }
        this.hZK = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.KW().bnQ != null) {
            com.baidu.live.liveroom.a.b.KW().bnQ.b(this.aBr.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().aAl();
        }
        aj.fR("");
        if (this.oCM != null && this.oCM.cmr()) {
            am.Em().DJ();
        }
    }

    private void cmI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cmJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(x xVar) {
        if (xVar != null) {
            if (this.osC.findViewById(a.f.ala_live_header_view).getMeasuredWidth() == 0) {
                if (xVar.mLiveInfo != null && xVar.mLiveInfo.live_id > 0) {
                    this.oCN.fD(xVar.mLiveInfo.live_id);
                    cmM();
                    this.oCN.a(xVar.mLiveInfo.live_id, false, this.brl, "");
                    return;
                }
                return;
            }
            if (xVar.aGy != null && this.oCN.omR) {
                aK(xVar);
            }
            aL(xVar);
            this.aBr = xVar;
            if (this.oCV != null) {
                this.oCV.a(xVar);
            }
        }
    }

    private void aK(x xVar) {
        if (xVar.aGy.aQM) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().Vw(xVar.aGy.aQL)) {
                VK(com.baidu.live.ah.b.hl(xVar.aGy.aQL));
                return;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501079, new String[]{xVar.aGy.aQK, xVar.aGy.aQL}));
                return;
            }
        }
        this.oCO.setBgImageUrl(xVar.aGy.bg_cover, null);
        this.oCO.dZZ();
    }

    private void aL(final x xVar) {
        List<cx.a> list;
        if (xVar.aGz != null && xVar.aGy != null && (list = xVar.aGz.aQc) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final cx.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aQg + aVar.aQi + aVar.aQk + xVar.aGy.aQH;
                    if (!this.oDa.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aQg - (System.currentTimeMillis() / 1000));
                        this.oDa.add(str);
                        if (this.oCL == null) {
                            this.oCL = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!edn() || StringUtils.isNull(aVar.aQi, true) || StringUtils.isNull(aVar.aQk, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oCL.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oCL.a(z, aVar.aQg, aVar.aQi, aVar.aQk, xVar.aGy.aQH, xVar.aGy.live_id, xVar.aGy.croom_id, aVar.aQh, aVar.aQj, xVar.aGz.aQb + "", xVar.aGy.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oCL.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oCL.a(false, aVar.aQg, aVar.aQi, aVar.aQk, xVar.aGy.aQH, xVar.aGy.live_id, xVar.aGy.croom_id, aVar.aQh, aVar.aQj, xVar.aGz.aQb + "", xVar.aGy.is_followed);
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

    private boolean edn() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKD == null || com.baidu.live.af.a.OJ().bru.aKD.aOf == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().a(com.baidu.live.af.a.OJ().bru.aKD.aOf.Br(), true);
    }

    private void c(r rVar) {
        if (this.oCV != null) {
            this.oCV.c(rVar);
        }
    }

    private void T(x xVar) {
        this.aBr = xVar;
    }

    private void cmK() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oCP.setIsScrollable(false);
            this.hZS = false;
        }
        if (this.aBr != null) {
            a(this.aBr.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oCO.a(this.osC, null);
            a(this.oCO, this.aBr.mLiveInfo, this.bvd);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aBr.mLiveInfo.live_id), String.valueOf(this.aBr.mLiveInfo.room_id), String.valueOf(this.aBr.mLiveInfo.feed_id), cmL());
            if (com.baidu.live.liveroom.a.b.KW().bnQ != null) {
                com.baidu.live.liveroom.a.b.KW().bnQ.a(this.aBr.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
                String str = "normal";
                if (this.aBr != null && this.aBr.aGD != null && this.aBr.aGD.getRoomMode() == 1) {
                    str = "dating";
                } else if (this.aBr != null && this.aBr.aGD != null && this.aBr.aGD.getRoomMode() == 2) {
                    str = "battle";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bvd = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cmL() {
        if (this.hZG == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hZG.optString("source");
            String optString2 = this.hZG.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hZG.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hZG.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hZG.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        o ebo = o.ebo();
        ViewGroup ebq = ebo.ebq();
        if (ebq != null && ebq.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cD(ebq)) {
                        ((ViewGroup) ebq.getParent()).removeView(ebq);
                        alaLiveRoomBlurPageLayout.f(ebq, null);
                        ebo.ebp();
                    } else if (ebo != null) {
                        ebo.ebp();
                    }
                } else if (ebo != null) {
                    ebo.ebp();
                }
            } else if (ebo != null) {
                ebo.ebp();
            }
        } else if (ebq != null && ebq.getParent() == null) {
            alaLiveRoomBlurPageLayout.f(ebq, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        ViewGroup ebq = o.ebo().ebq();
        if (ebq != null) {
            ebq.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.t(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.u(this.mTbPageContext.getPageActivity());
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

    public void cmM() {
        this.bvd = true;
    }

    public boolean cmN() {
        return this.bvd;
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
        ViewGroup ebq = o.ebo().ebq();
        if (ebq != null) {
            int i2 = ebq.getLayoutParams().width;
            int i3 = ebq.getLayoutParams().height;
            int i4 = ebq.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) ebq.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i2 || b2.height != i3 || b2.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.osC != null) {
                this.osC.setLayoutParams(c);
            }
            if (this.oCO != null) {
                this.oCO.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oCU != null) {
                this.oCU.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oCV != null) {
                this.oCV.l(c.width, c.height, realScreenOrientation);
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
                this.oCN.UK(alaLiveInfoData.room_id + "");
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
            this.oCN.a(alaLiveInfoData.live_id, true, this.brl, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            x DW = this.oCN.DW();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DW.aGy.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : "up");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void wn(int i) {
        if (i < 0) {
            this.oCN.vO(this.oCN.ciD() - 1);
        } else if (i > 0) {
            this.oCN.vO(this.oCN.ciD() + 1);
        }
        if (this.oCV != null) {
            this.oCV.a(this.oCO);
        }
        this.oCQ.a(this.mSelectedPosition, cmP(), this.aBr);
        this.oCQ.b(this.mSelectedPosition, cmQ(), this.aBr);
        if (this.oCN != null) {
            AlaLiveInfoData ciG = this.oCN.ciG();
            if (ciG != null) {
                ciG.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(ciG);
                a(this.oCO, ciG, this.bvd);
                this.bvd = false;
                if (this.oCV != null) {
                    this.oCV.a(this.mTbPageContext, this.osC, null, this.oCO, this.oCN, this.brl, this.hZz, this.hCm, null, this.hZR);
                    edq();
                }
                a(ciG, false);
            }
            i(ciG);
            if (this.oCV != null) {
                this.oCV.caT();
            }
            this.oCN.g(ciG);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.osC.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.osC.findViewById(a.f.ala_live_footer_view);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        try {
            x xVar = new x();
            xVar.aGQ = false;
            xVar.aGy = new dd();
            if (alaLiveInfoData != null) {
                this.oCO.setBgImageUrl(alaLiveInfoData.bg_cover, null);
                xVar.aGy.bg_cover = alaLiveInfoData.bg_cover;
                xVar.aGy.live_id = String.valueOf(alaLiveInfoData.live_id);
                xVar.aGy.cover = alaLiveInfoData.cover;
                xVar.aGy.aQH = String.valueOf(alaLiveInfoData.room_id);
                xVar.aGy.croom_id = alaLiveInfoData.croom_id;
                xVar.aGy.is_followed = alaLiveInfoData.is_followed;
                xVar.aGy.room_name = alaLiveInfoData.room_name;
            }
            xVar.mLiveInfo = new AlaLiveInfoData();
            if (alaLiveInfoData != null) {
                xVar.mLiveInfo.live_id = alaLiveInfoData.live_id;
            }
            xVar.aGd = new AlaLiveUserInfoData();
            xVar.aGe = new w();
            xVar.aGD = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            xVar.bs(true);
            this.oCN.setLiveShowData(xVar);
            xVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.oCV != null) {
                this.oCV.a(xVar, str, str2);
            }
            UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.aGy.aQH), cmL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oCO.a(this.osC, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edo() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.ecb().bcU();
    }

    private AlaLiveInfoData cmP() {
        List<AlaLiveInfoData> ciw = this.oCN.ciw();
        if (ciw == null || ciw.size() == 0) {
            if (this.aBr == null) {
                return null;
            }
            return this.aBr.mLiveInfo;
        }
        int ciD = this.oCN.ciD();
        int size = ciw.size();
        return ciw.get(((ciD + size) - 1) % size);
    }

    private AlaLiveInfoData cmQ() {
        List<AlaLiveInfoData> ciw = this.oCN.ciw();
        if (ciw == null || ciw.size() == 0) {
            if (this.aBr == null) {
                return null;
            }
            return this.aBr.mLiveInfo;
        }
        return ciw.get((this.oCN.ciD() + 1) % ciw.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (dVar != null) {
            if (!this.hZw) {
                a(dVar);
            }
            if (this.oCN.omS) {
                this.mHandler.removeCallbacks(this.oDb);
                this.mHandler.postDelayed(this.oDb, 1000L);
            }
        }
    }

    private void a(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (this.oCV != null) {
            this.oCV.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hZx) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oV(false);
            return;
        }
        x DW = this.oCN.DW();
        T(DW);
        if (DW != null && DW.aGy != null) {
            aK(DW);
        }
        edp();
        this.oCN.cix();
        if (this.bvd) {
            this.oCN.ow(false);
        }
        this.hCm = System.currentTimeMillis() / 1000;
        if (this.oCV != null) {
            this.oCV.a(this.mTbPageContext, this.osC, null, this.oCO, this.oCN, this.brl, this.hZz, this.hCm, this.hZA, this.hZR);
            edq();
        }
        cmK();
        if (DW != null && DW.mLiveInfo != null && DW.mLiveInfo.live_status == 2) {
            this.oCQ.a(this.mSelectedPosition, this.oCN.DW());
            e(DW, false);
            this.bvd = false;
            return;
        }
        boolean z = (this.oCV == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ah.a.b.Pv().cN(com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aKF && DW != null && DW.aGC);
        aj.e(DW);
        if (z) {
            if (!this.hZO || !TextUtils.equals(t.TO(), this.hZP)) {
                aj.b(getPageContext(), false, this.oCM.cmr());
                e.OY().OZ();
                this.hZO = true;
                this.hZP = t.TO();
            }
            aj.Ed();
        }
        if (this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null) {
            this.oCN.hH(this.oCN.DW().mLiveInfo.live_id);
            this.hZK = true;
        }
        if (this.oCV != null) {
            this.oCV.b(this.hZu);
            this.oCV.aF(TextUtils.equals(this.hZB, "1"), TextUtils.equals(this.oCT, "1"));
            this.hZB = "";
            this.oCT = "";
        }
        if (this.oCR != null) {
            this.oCR.a(this.aBr, this.oCS);
        }
        a(this.oCN.DW());
        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_IS_INIT, this.bvd ? "1" : "0");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.oCN.DW() != null && b.this.oCN.DW().mLiveInfo != null) {
                    b.this.oCN.a(b.this.oCN.DW().mLiveInfo.live_id, b.this.brl, b.this.hCm);
                }
            }
        });
        this.bvd = false;
        if (z && this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null && this.oCN.DW().aFH != null && this.oCV != null) {
            long j = this.oCN.DW().mLiveInfo.live_id;
            long j2 = this.oCN.DW().mLiveInfo.room_id;
            String str2 = this.oCN.DW().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.El() != null) {
                    al.El().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.iaf != null) {
                    this.iaf.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.HC() != null) {
                com.baidu.live.guardclub.e.HC().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oCY == null) {
                this.oCY = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oCY.a(this.mTbPageContext.getPageActivity(), this.oCN.DW(), this.otherParams);
        }
        if (this.oCZ == null) {
            this.oCZ = new com.baidu.tieba.yuyinala.liveroom.p.c(this.mTbPageContext);
        }
        if (z && this.oCN.DW() != null && this.oCN.DW().aGd != null && !this.hZN) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oCZ.a(this.oCN.DW(), this.oCN.DW().aGd.userId);
                this.hZN = true;
            }
        }
    }

    private void edp() {
        try {
            if (this.oCN != null && this.oCN.DW() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oCN.DW().aGd.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oCN.DW().aGy.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bvd) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oCN.DW().aGy.aQH, this.otherParams, this.mSelectedPosition + 1, this.bvd, this.oCN.DW().mLiveInfo.feed_id);
                }
                if (!this.oCN.ciw().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oCN.DW().aGy.aQH, this.otherParams, this.mSelectedPosition + 1, this.bvd, this.oCN.DW().mLiveInfo.feed_id);
                    this.oCN.ciw().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oCN.DW().aGy.aQH, this.otherParams, this.mSelectedPosition + 1, this.bvd, this.oCN.DW().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oCN.DW().aGy.aQH, this.otherParams, this.mSelectedPosition + 1, this.bvd, this.oCN.DW().mLiveInfo.feed_id);
                this.oCX = new StayTimeBean();
                this.oCX.liveId = this.oCN.DW().mLiveInfo.live_id;
                this.oCX.roomId = this.oCN.DW().mLiveInfo.room_id;
                this.oCX.vid = this.oCN.DW().mLiveInfo.feed_id;
                this.oCX.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        if (this.hZv) {
            this.oCQ.a(this.mSelectedPosition, cmP(), this.aBr);
            this.oCQ.b(this.mSelectedPosition, cmQ(), this.aBr);
            this.hZv = false;
        }
        if (this.oCU != null && cnb()) {
            this.oCU.Y(this.oCN.ciy());
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
        if (!this.hZx) {
            this.mHandler.removeCallbacks(this.hZZ);
            this.mHandler.postDelayed(this.hZZ, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(r rVar) {
        if (rVar == null) {
            if (!this.hZx) {
                this.mHandler.removeCallbacks(this.hZY);
                this.mHandler.postDelayed(this.hZY, 5000L);
                return;
            }
            return;
        }
        if (!this.hZw) {
            c(rVar);
        }
        if (!this.hZx) {
            this.mHandler.removeCallbacks(this.hZY);
            this.mHandler.postDelayed(this.hZY, rVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        if (this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null) {
            this.oCN.hH(this.oCN.DW().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && xVar.aGd != null && xVar.aGd.logined == 1) {
            oV(false);
        } else if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_status == 2) {
            this.oCQ.a(this.mSelectedPosition, this.oCN.DW());
            e(xVar, false);
        } else if (xVar != null) {
            if (!this.hZw) {
                aj.e(xVar);
                a(xVar);
            }
            if (!this.hZx) {
                this.mHandler.removeCallbacks(this.hFy);
                this.mHandler.postDelayed(this.hFy, xVar.aFM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        if (this.mTbPageContext != null && this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null) {
            this.oCN.a(this.oCN.DW().mLiveInfo.live_id, this.brl, this.hCm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(x xVar, boolean z) {
        View view = null;
        nJ(true);
        if (!cnb()) {
            this.oCN.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oCO != null) {
                this.oCO.Vz();
                this.oCO.cke();
            }
            if (xVar != null && xVar.mLiveInfo != null) {
                this.hZF = xVar.mLiveInfo.live_id;
            }
            cmH();
            cmT();
            cmU();
            if (xVar != null) {
                if (this.oCV != null && this.oCV.caZ() != null) {
                    view = this.oCV.caZ().a(this.oCV.dYs().pageContext.getPageActivity(), xVar, z);
                }
                if (this.oCO != null) {
                    this.oCU.a(this.oCO, view, xVar, z, this.oCN.ciy());
                }
                if (this.oCV != null) {
                    this.oCV.nJ(false);
                    this.oCV.caU();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oCO != null) {
                    this.oCO.ckg();
                }
                long j = xVar.mLiveInfo.live_id;
                long j2 = xVar.mLiveInfo.room_id;
                String str = xVar.mLiveInfo.feed_id;
                long j3 = xVar.aFH.userId;
                String str2 = xVar.aFH.userName;
            }
            cnd();
            if (this.oCR != null) {
                this.oCR.a(this.aBr, this.oCS);
            }
        }
    }

    private void cmT() {
    }

    private void cmU() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oCP);
        }
    }

    public void cmV() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cmW();
        } else {
            cmX();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oCN != null && this.oCN.DW() != null) {
            alaLiveInfoData = this.oCN.DW().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cmW();
        } else {
            cmX();
        }
        this.oCP.setIsScrollable(!z && this.hZS);
        if (this.oCV != null) {
            this.oCV.onKeyboardVisibilityChanged(z);
        }
        if (this.osC != null) {
            this.osC.onKeyboardVisibilityChanged(z);
        }
        if (z) {
            o.ebo().setMaskBg(z);
        }
    }

    public void co(int i) {
    }

    public void cmW() {
        if (this.oCP != null) {
            i.ae(this.oCP);
        }
    }

    public void cmX() {
        if (this.oCP != null) {
            i.af(this.oCP);
        }
    }

    public void onResume() {
        if (this.oCN != null) {
            this.oCN.cii();
        }
        if (this.oCV != null) {
            this.oCV.enterForeground();
        }
        if (this.oCY != null) {
            this.oCY.onResume();
        }
        if (this.oCZ != null) {
            this.oCZ.onResume();
        }
        if (this.iaz != null && !this.iaz.hasFocus()) {
            this.iaz.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.As().onResume();
    }

    public void onStart() {
        if (!this.hZQ) {
            if (this.hZx) {
                this.hZx = false;
                cna();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cna() {
        cib();
        cmS();
        this.oCN.cix();
        if (this.oCO != null) {
            this.oCO.eab();
        }
        if (this.oCV != null) {
            this.oCV.caY();
        }
        if (this.oCN != null && this.oCN.DW() != null && this.oCN.DW().mLiveInfo != null) {
            this.oCW.fG(this.oCN.DW().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aBr.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oCN != null) {
            this.oCN.cij();
        }
        if (this.oCV != null) {
            this.oCV.enterBackground();
        }
        com.baidu.live.core.layer.b.As().onPause();
    }

    public void oS(boolean z) {
        this.hZx = true;
        oW(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oW(boolean z) {
        this.mHandler.removeCallbacks(this.hFy);
        this.mHandler.removeCallbacks(this.oDb);
        this.mHandler.removeCallbacks(this.hZY);
        this.mHandler.removeCallbacks(this.hZZ);
        if (this.oCO != null) {
            this.oCO.eaa();
        }
        if (this.oCV != null) {
            this.oCV.caX();
        }
        this.oCW.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.El() != null) {
                al.El().a(i, i2, intent, this.aBr, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oCV != null) {
            this.oCV.onActivityResult(i, i2, intent);
        }
    }

    public boolean cnb() {
        return this.oCU != null && this.oCU.bTZ();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.oDj);
        MessageManager.getInstance().unRegisterListener(this.iar);
        MessageManager.getInstance().unRegisterListener(this.oDk);
        MessageManager.getInstance().unRegisterListener(this.oDl);
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.oDm);
        MessageManager.getInstance().unRegisterListener(this.oDn);
        MessageManager.getInstance().unRegisterListener(this.oDi);
        if (this.iaf != null) {
            this.iaf.release();
        }
        if (this.oCR != null) {
            this.oCR.onDestory();
        }
        o.ebo().cJD();
        if (this.oCS != null) {
            this.oCS.reset();
        }
        if (this.oCV != null) {
            this.oCV.onDestroy();
        }
        if (this.oCQ != null) {
            this.oCQ.onDestroy();
        }
        this.oCO.Vz();
        if (this.oCO != null) {
            this.oCO.release();
            this.oCO = null;
        }
        if (this.oCU != null) {
            this.oCU.onDestroy();
        }
        if (this.iaz != null) {
            this.iaz.abandonAudioFocus();
        }
        if (this.oCX != null && this.oCN != null && this.oCN.DW() != null) {
            if (this.oCX.liveId == this.oCN.DW().mLiveInfo.live_id && this.oCX.startTime > 0) {
                this.oCX.endTime = System.currentTimeMillis();
                long j = this.oCX.endTime - this.oCX.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oCN.DW().aGy.aQH, this.otherParams, this.mSelectedPosition + 1, this.bvd, this.oCN.DW().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oCX = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oCN != null) {
                jSONObject.put("identity", this.oCN.DW().aGd.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oCN.DW().aGy.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.osC != null) {
            this.osC.ckm();
            this.osC = null;
        }
        if (this.oCN != null) {
            this.oCN.destory();
        }
        z.DO().release();
        if (this.oCZ != null) {
            this.oCZ.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.ecb().release();
        k.ebf().a((k.a) null);
    }

    public void oX(boolean z) {
        this.hZQ = z;
    }

    public void cnc() {
        if (this.hZG != null) {
            this.otherParams = this.hZG.toString();
            if (this.oCN != null) {
                this.oCN.setOtherParams(this.otherParams);
            }
            if (this.oCV != null) {
                this.oCV.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oCU != null) {
                this.oCU.setOtherParams(this.otherParams);
            }
        }
    }

    public void cnd() {
        if (this.hZG != null) {
            String optString = this.hZG.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hZG.put("tab", "live_jump");
                        this.hZG.put("tag", "");
                        this.hZG.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hZG.put("tab", "liveroom");
                        this.hZG.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cnc();
            }
        }
    }

    public void cne() {
        aj.Eg();
    }

    private void edq() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oCV.e((short) 2);
        } else {
            this.oCV.dYt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oDd = bitmap;
            this.oCO.setBgImageBitmap(this.oDd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oCO.setBgVideo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edr() {
        if (this.oDd != null) {
            if (!this.oDd.isRecycled()) {
                this.oDd.recycle();
            }
            this.oDd = null;
        }
        aK(this.aBr);
    }

    public boolean ebw() {
        return this.hZQ;
    }
}

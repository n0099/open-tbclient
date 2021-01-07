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
import com.baidu.platform.comapi.map.MapBundleKey;
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
/* loaded from: classes11.dex */
public class b extends BdBaseView<TbPageContext> {
    private x aGe;
    private CustomMessageListener bih;
    private long bvY;
    private String bvZ;
    private boolean bzP;
    private ViewGroup hGN;
    private LayerRootView hGO;
    private long hGS;
    private Runnable hKe;
    private String hoR;
    private String ieA;
    private boolean ieB;
    private br ieC;
    private boolean ieD;
    private boolean ieE;
    private Runnable ieJ;
    private Runnable ieK;
    private Runnable ieL;
    private c ieQ;
    com.baidu.live.liveroom.a.c ieX;
    ViewPager.OnPageChangeListener ieY;
    private AlaLastLiveroomInfo ief;
    private boolean ieg;
    private boolean ieh;
    private boolean iei;
    private boolean iek;
    private ArrayList<AlaBroadcastGiftToastData> iel;
    private String iem;
    private String iep;
    private long ieq;
    private JSONObject ier;
    private boolean ies;
    private boolean iev;
    private boolean iey;
    private boolean iez;
    CustomMessageListener ifc;
    private g ifk;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private com.baidu.tieba.yuyinala.liveroom.task.b oHA;
    private StayTimeBean oHB;
    private com.baidu.tieba.yuyinala.liveroom.g.a oHC;
    private com.baidu.tieba.yuyinala.liveroom.p.c oHD;
    private Set<String> oHE;
    private Runnable oHF;
    private int oHG;
    private Bitmap oHH;
    private boolean oHI;
    private String oHJ;
    private String oHK;
    private String oHL;
    private CustomMessageListener oHM;
    CustomMessageListener oHN;
    private CustomMessageListener oHO;
    private CustomMessageListener oHP;
    CustomMessageListener oHQ;
    CustomMessageListener oHR;
    private d oHp;
    private a oHq;
    private com.baidu.tieba.yuyinala.liveroom.k.a oHr;
    private AlaLiveRoomBlurPageLayout oHs;
    private AlaLoopViewPager oHt;
    private AlaLoopViewPagerAdapter oHu;
    private com.baidu.tieba.yuyinala.liveroom.d.a oHv;
    private com.baidu.tieba.yuyinala.liveroom.d.b oHw;
    private String oHx;
    private com.baidu.tieba.yuyinala.endliveroom.a oHy;
    private com.baidu.tieba.yuyinala.liveroom.c.b oHz;
    private a.InterfaceC0939a orp;
    private String otherParams;
    private AlaLiveView oxh;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.ieg = true;
        this.hGS = 0L;
        this.ieh = false;
        this.bzP = true;
        this.bvZ = "";
        this.mForumName = "";
        this.iei = false;
        this.iek = false;
        this.iem = "0";
        this.oHx = "0";
        this.mHandler = new Handler();
        this.ieq = -1L;
        this.otherParams = "";
        this.ies = false;
        this.oHA = com.baidu.tieba.yuyinala.liveroom.task.b.edr();
        this.iev = false;
        this.iez = false;
        this.ieB = false;
        this.ieE = false;
        this.oHE = new HashSet();
        this.hKe = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.clT();
            }
        };
        this.ieJ = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cqK();
            }
        };
        this.ieK = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.oHr.cmp();
            }
        };
        this.oHF = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oHr.HR() != null) {
                    b.this.oHr.ag(b.this.oHr.HR());
                }
            }
        };
        this.oHG = 5000;
        this.oHJ = "";
        this.oHK = "";
        this.oHL = "";
        this.oHM = new CustomMessageListener(2501082) { // from class: com.baidu.tieba.yuyinala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oHr != null && b.this.oHr.HR() != null) {
                    b.this.oHr.ag(b.this.oHr.HR());
                }
            }
        };
        this.bih = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.ieL = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.20
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
        this.ieX = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // com.baidu.live.liveroom.a.c
            public void cx(final boolean z) {
                if (!k.eeX().isShowing()) {
                    h.eeV().zO(false);
                    boolean aH = k.eeX().aH(b.this.mTbPageContext.getPageActivity());
                    k.eeX().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeZ() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void efa() {
                            if (z || b.this.oHz == null || b.this.oHz.ceO()) {
                                b.this.oZ(true);
                                b.this.cbO();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void efb() {
                        }
                    });
                    if (aH) {
                        if (z || b.this.oHz == null || b.this.oHz.ceO()) {
                            b.this.oZ(true);
                            b.this.cbO();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cy(boolean z) {
                b.this.e(b.this.aGe, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oHt != null) {
                    b.this.oHt.setIsScrollable(b.this.ieD && z);
                    b.this.oHt.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cz(boolean z) {
            }
        };
        this.ieY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.oxh != null && b.this.oHr != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oHt.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oHB != null && b.this.oHr != null && b.this.oHr.HR() != null && b.this.oHr.HR().mLiveInfo != null && b.this.oHr.HR().aLl != null) {
                        if (b.this.oHB.liveId == b.this.oHr.HR().mLiveInfo.live_id && b.this.oHB.startTime > 0) {
                            b.this.oHB.endTime = System.currentTimeMillis();
                            long j = b.this.oHB.endTime - b.this.oHB.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oHr.HR().aLl.aVu, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bzP, b.this.oHr.HR().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oHB = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.oHr != null && b.this.oHr.HR() != null && b.this.oHr.HR().aKQ != null) {
                            jSONObject.put("identity", b.this.oHr.HR().aKQ.getUserTypeStr());
                        }
                        if (b.this.oHr != null && b.this.oHr.HR() != null && b.this.oHr.HR().aLl != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.oHr.HR().aLl.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bzP || b.this.oHr.cmo() == null || ListUtils.getCount(b.this.oHr.cmo()) > 1) {
                        if (b.this.oHr.cmt() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.oHr == null || !b.this.oHr.cmt() || i2 >= 0) {
                            if (b.this.oHr != null && b.this.oHr.cmu() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oHt.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.oHr != null) {
                                b.this.oHr.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nN(true);
                            b.this.oHs.cnW();
                            b.this.oHs.Zs();
                            b.this.oHs.cnX();
                            b.this.cqV();
                            if (b.this.ieQ != null) {
                                b.this.ieQ.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oHs = b.this.oHu.Nl(b.this.mSelectedPosition);
                            b.this.oHs.cnY();
                            b.this.xT(i2);
                            b.this.ehg();
                            b.this.NQ(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oHt.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oHt.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oHr.g(b.this.oHr.cmy());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oHt != null && i == 0) {
                    com.baidu.live.d.Ba().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.orp = new a.InterfaceC0939a() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0939a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.oHr.HR());
                } else if (i2 == 2) {
                    b.this.f(b.this.oHr.bWZ());
                } else if (i2 == 3) {
                    b.this.br(i, str);
                } else if (i2 == 12) {
                    b.this.c(b.this.oHr.edh());
                } else if (i2 == 11) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_IS_INIT, b.this.bzP ? "1" : "0");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle", jSONObject);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cqJ();
                }
            }
        };
        this.oHN = new CustomMessageListener(2913169) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    o.efg().setMaskBg(false);
                }
            }
        };
        this.ifc = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oHr != null && b.this.oHr.HR() != null && b.this.oHr.HR().aKQ != null) {
                        if (l.longValue() == b.this.oHr.HR().aKQ.userId) {
                            b.this.oHr.HR().aKQ.isNewUser = false;
                            if (b.this.oHC != null) {
                                b.this.oHC.o(b.this.oHr.HR());
                            }
                        }
                    }
                }
            }
        };
        this.oHO = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.ehj();
                    } else {
                        b.this.X((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oHP = new CustomMessageListener(2501078) { // from class: com.baidu.tieba.yuyinala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501078) {
                    String str = null;
                    if (customResponsedMessage.getData() instanceof String) {
                        str = (String) customResponsedMessage.getData();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.this.WR(str);
                    }
                }
            }
        };
        this.oHQ = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.clT();
            }
        };
        this.oHR = new CustomMessageListener(2501080) { // from class: com.baidu.tieba.yuyinala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501080 && (customResponsedMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig)) {
                    final YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customResponsedMessage.getData();
                    if (!k.eeX().isShowing()) {
                        h.eeV().zO(false);
                        if (k.eeX().aH(b.this.mTbPageContext.getPageActivity())) {
                            b.this.oZ(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            return;
                        }
                        k.eeX().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void eeZ() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void efa() {
                                b.this.oZ(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                            public void efb() {
                            }
                        });
                    }
                }
            }
        };
        this.hGS = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oHq = aVar;
        this.ieg = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.ieQ = (c) runTask.getData();
        }
        this.oHr = new com.baidu.tieba.yuyinala.liveroom.k.a(getPageContext());
        this.oHr.a(this.orp);
        this.oHy = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.oHN);
        MessageManager.getInstance().registerListener(this.ifc);
        MessageManager.getInstance().registerListener(this.oHO);
        MessageManager.getInstance().registerListener(this.oHP);
        MessageManager.getInstance().registerListener(this.bih);
        MessageManager.getInstance().registerListener(this.oHQ);
        MessageManager.getInstance().registerListener(this.oHR);
        MessageManager.getInstance().registerListener(this.oHM);
        this.ifk = new g(tbPageContext.getPageActivity());
        this.ifk.setIPlayerAudioFocusCallBack(new com.baidu.live.v.a() { // from class: com.baidu.tieba.yuyinala.player.b.17
            @Override // com.baidu.live.v.a
            public void cG(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(!z);
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
                        this.iel = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.iel.add(alaBroadcastGiftToastData);
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
        this.bvZ = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bvZ)) {
            this.bvZ = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.iep = intent.getStringExtra("room_id");
        this.bvY = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.oHJ = new String(Base64.decode(optString.getBytes()));
                if (!this.oHJ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oHJ = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.oHK = new String(Base64.decode(optString2.getBytes()));
                if (!this.oHK.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oHK = "";
                }
            }
            this.oHL = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.ies = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oHr.b((AlaLiveInfoCoreData) serializableExtra);
            this.ies = true;
        }
        TbConfig.liveScene = 2;
        av(intent);
        this.ieD = this.ieC == null || !this.ieC.aRP;
        this.oHy.setOtherParams(this.otherParams);
        this.iek = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        ehd();
        Ab(true);
        this.mHandler.removeCallbacks(this.ieL);
        this.mHandler.postDelayed(this.ieL, 1000L);
    }

    private void av(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoR = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.ier = new JSONObject(stringExtra);
                if (this.ier != null) {
                    String optString2 = this.ier.optString("enterRoomId");
                    String optString3 = this.ier.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.iep, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bvY + "", optString3))) {
                        String optString4 = this.ier.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.ier.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.ies) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bvY;
                            alaLiveInfoCoreData.screenDirection = this.ier.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oHr.b(alaLiveInfoCoreData);
                            this.ies = true;
                        }
                    }
                    String optString6 = this.ier.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.ieC = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oHr != null) {
                            this.oHr.HZ(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoR = jSONObject.optString("live_back_scheme");
                        this.ieC = new br();
                        this.ieC.aRP = jSONObject.optInt("is_hot") == 1;
                        if (this.ieC.aRP) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ieC.aRQ = jSONObject.optString("task_id");
                        this.ieC.aRO = TextUtils.isEmpty(this.ieC.aRQ) ? false : true;
                        this.ieC.aRR = jSONObject.optInt("task_type");
                        this.ieC.aRS = jSONObject.optInt("task_im_count");
                        this.ieC.aRT = jSONObject.optLong("task_gift_total_price");
                        this.ieC.aRU = jSONObject.optLong("task_watch_time");
                        this.ieC.aRV = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oHw = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oHw.setScheme(optString8);
                            this.oHw.setImageUrl(optString9);
                            this.oHw.setTitle(optString10);
                        }
                    }
                    this.iem = this.ier.optString("open_giftlist");
                    this.oHx = this.ier.optString(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.ier.remove("cover");
                    this.ier.remove("live_url");
                    this.ier.remove("enterRoomId");
                    this.ier.remove("enterLiveId");
                    this.ier.remove("open_giftlist");
                    this.ier.remove(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.ier.remove("extra");
                    this.otherParams = this.ier.toString();
                    if (this.oHr != null) {
                        this.oHr.setOtherParams(this.otherParams);
                    }
                    this.ier.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("source");
                    }
                    this.ieE = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.ier.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oHr != null) {
                        this.oHr.xt(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ief = new AlaLastLiveroomInfo();
                this.ief.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bvY), String.valueOf(this.iep), null, cqD());
        UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bvY), String.valueOf(this.iep), cqD());
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

    public void Ab(boolean z) {
        boolean z2 = false;
        if (this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null && this.oHr.HR().mLiveInfo.room_id > 0) {
            this.oHr.VR(this.oHr.HR().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.iep)) {
            this.oHr.VR(this.iep);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.oHr.aw(this.uk, this.bvZ, this.mForumName);
            z2 = true;
        } else if (this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null && this.oHr.HR().mLiveInfo.live_id > 0) {
            this.oHr.a(this.oHr.HR().mLiveInfo.live_id, false, this.bvZ, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bvZ = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oZ(false);
                return;
            }
            this.oHr.aw(this.uk, this.bvZ, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.iep)) {
            this.oHr.IE(this.iep);
            z2 = true;
        } else if (this.bvY > 0) {
            this.oHr.a(this.bvY, false, this.bvZ, "");
            z2 = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oZ(false);
        }
        if (z2) {
            ehg();
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

    private void ehd() {
        this.bzP = true;
        this.ieh = false;
        ehe();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.En().l(this.hGO);
        this.oHz = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oHz.a(this.ieX);
        this.oHz.setOtherParams(this.otherParams);
        this.oHz.nH(this.ieE);
        try {
            x xVar = new x();
            xVar.aLD = false;
            xVar.aLl = new dd();
            xVar.aLl.live_id = String.valueOf(this.bvY);
            xVar.aLl.cover = "";
            xVar.aLl.room_name = ".....";
            xVar.aLl.aVu = "0";
            xVar.aLl.croom_id = "0";
            xVar.aLl.is_followed = true;
            xVar.aLl.bg_cover = this.oHK;
            xVar.mLiveInfo = new AlaLiveInfoData();
            xVar.aKQ = new AlaLiveUserInfoData();
            xVar.aKR = new w();
            xVar.aLq = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            xVar.bw(true);
            this.oHr.setLiveShowData(xVar);
            cqr();
            cqo();
            this.oHz.a(xVar, this.oHJ, this.oHL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ehe() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oHt = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oHt.setOnPageChangeListener(this.ieY);
        this.oHt.setBoundaryCaching(true);
        this.oHt.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oHu = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oHu.cjC();
        this.oHs = this.oHu.Nk(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oHK)) {
                this.oHs.setBgImageUrl(this.oHK, null);
            } else {
                this.oHs.setDefaultBg();
            }
            this.oHu.Nk(0).setDefaultBg();
            this.oHu.Nk(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oHr != null) {
            this.oHu.a(this.mSelectedPosition, this.oHr.HR());
        }
        this.oHt.setAdapter(this.oHu);
        this.oHt.setCurrentItem(this.mSelectedPosition);
        this.oHt.setIsScrollable(this.ieD);
        this.hGN = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGO = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oHt.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.21
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                x HR;
                if ((b.this.oHr == null || (HR = b.this.oHr.HR()) == null || HR.mLiveInfo == null || HR.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oHI = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oHr == null || !b.this.oHr.cmt() || rawY <= 0.0f) {
                            if (b.this.oHr == null || !b.this.oHr.cmu() || rawY >= 0.0f) {
                                if (k.eeX().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.eeV().zO(false);
                                k.eeX().aH(b.this.mTbPageContext.getPageActivity());
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
            public boolean Nj(int i) {
                x HR;
                if (b.this.oHr == null || (HR = b.this.oHr.HR()) == null || HR.mLiveInfo == null || HR.mLiveInfo.live_status != 2) {
                    k.eeX().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.21.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeZ() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void efa() {
                            if (b.this.oHt != null) {
                                if (b.this.oHr == null || !b.this.oHr.cmt() || !b.this.oHI) {
                                    if (b.this.oHr == null || !b.this.oHr.cmu() || b.this.oHI) {
                                        int currentItem = b.this.oHt.getCurrentItem();
                                        if (b.this.oHI) {
                                            if (currentItem == 0) {
                                                b.this.oHt.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oHt.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oHt.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oHt.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oHt.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oHt.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void efb() {
                        }
                    });
                    if (b.this.oHr != null && b.this.oHr.cmt() && b.this.oHI) {
                        return true;
                    }
                    if (b.this.oHr == null || !b.this.oHr.cmu() || b.this.oHI) {
                        if (k.eeX().isShowing()) {
                            return false;
                        }
                        h.eeV().zO(false);
                        return k.eeX().aH(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        o efg = o.efg();
        efg.a(this.mTbPageContext, this.oHs, rect);
        efg.a(this);
    }

    private void cqo() {
        this.oHv = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hGN);
    }

    private void c(Rect rect) {
        this.oxh = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.oxh.setSwipeClearEnable(false);
        this.oxh.hRu = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oHs.a(this.oxh, layoutParams);
    }

    private void cqr() {
        if (this.oHr != null && this.oHr.HR() != null) {
            this.aGe = this.oHr.HR();
            if (this.aGe.mLiveInfo != null) {
                a(this.aGe.mLiveInfo, this.ies);
                if (this.aGe.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.iei);
                    }
                    if (this.oHz != null) {
                        this.oHz.a(this.mTbPageContext, this.oxh, null, this.oHs, this.oHr, this.bvZ, this.iek, this.hGS, this.iel, this.ieC);
                        ehi();
                    }
                }
            }
        }
    }

    private void cqz() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.iek || !this.ieD) {
                this.oHt.setIsScrollable(false);
            } else {
                this.oHt.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.En().onBackPressed() && ((this.oHz == null || !this.oHz.onKeyDown(i, keyEvent)) && (this.oHz == null || !this.oHz.ceN()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cqz();
            } else if (!k.eeX().aH(this.mTbPageContext.getPageActivity())) {
                h.eeV().zO(false);
            } else if (this.oHz == null || this.oHz.ceO()) {
                oZ(true);
                cbO();
            }
        }
        return true;
    }

    public void cbO() {
        if (!TextUtils.isEmpty(this.hoR)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoR);
                this.hoR = null;
            }
        }
    }

    public void oZ(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nN(!z);
        com.baidu.live.core.layer.b.En().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cqB();
        long j = -1;
        if (this.oHr != null && this.oHr.cmy() != null) {
            j = this.oHr.cmy().room_id;
        }
        this.oHq.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void nN(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ief = null;
        if (al.Ig() != null) {
            al.Ig().If();
        }
        com.baidu.live.core.layer.b.En().Eo();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().dh(this.oxh);
        if (this.ieQ != null) {
            this.ieQ.release();
        }
        if (this.oHC != null) {
            this.oHC.release();
        }
        this.ieC = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oHt);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oHr != null) {
            this.oHr.HZ(null);
            AlaLiveInfoData cmy = this.oHr.cmy();
            if (cmy != null) {
                this.oHr.fD(cmy.live_id);
            }
        }
        this.oHA.stopRecord();
        LiveTimerManager.getInstance().stop();
        cqA();
        if (this.oHz != null) {
            this.oHz.nN(z);
        }
        this.iev = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.OR().bsC != null) {
            com.baidu.live.liveroom.a.b.OR().bsC.b(this.aGe.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().aEf();
        }
        aj.hd("");
        if (this.oHq != null && this.oHq.cqj()) {
            am.Ih().HE();
        }
    }

    private void cqA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cqB() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(x xVar) {
        if (xVar != null) {
            if (this.oxh.findViewById(a.f.ala_live_header_view).getMeasuredWidth() == 0) {
                if (xVar.mLiveInfo != null && xVar.mLiveInfo.live_id > 0) {
                    this.oHr.fD(xVar.mLiveInfo.live_id);
                    cqE();
                    this.oHr.a(xVar.mLiveInfo.live_id, false, this.bvZ, "");
                    return;
                }
                return;
            }
            if (xVar.aLl != null && this.oHr.ory) {
                aK(xVar);
            }
            aL(xVar);
            this.aGe = xVar;
            if (this.oHz != null) {
                this.oHz.a(xVar);
            }
        }
    }

    private void aK(x xVar) {
        if (xVar.aLl.aVz) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().WD(xVar.aLl.aVy)) {
                WR(com.baidu.live.ah.b.iw(xVar.aLl.aVy));
                return;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501079, new String[]{xVar.aLl.aVx, xVar.aLl.aVy}));
                return;
            }
        }
        this.oHs.setBgImageUrl(xVar.aLl.bg_cover, null);
        this.oHs.edR();
    }

    private void aL(final x xVar) {
        List<cx.a> list;
        if (xVar.aLm != null && xVar.aLl != null && (list = xVar.aLm.aUP) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final cx.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aUT + aVar.aUV + aVar.aUX + xVar.aLl.aVu;
                    if (!this.oHE.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aUT - (System.currentTimeMillis() / 1000));
                        this.oHE.add(str);
                        if (this.oHp == null) {
                            this.oHp = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!ehf() || StringUtils.isNull(aVar.aUV, true) || StringUtils.isNull(aVar.aUX, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oHp.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oHp.a(z, aVar.aUT, aVar.aUV, aVar.aUX, xVar.aLl.aVu, xVar.aLl.live_id, xVar.aLl.croom_id, aVar.aUU, aVar.aUW, xVar.aLm.aUO + "", xVar.aLl.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oHp.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oHp.a(false, aVar.aUT, aVar.aUV, aVar.aUX, xVar.aLl.aVu, xVar.aLl.live_id, xVar.aLl.croom_id, aVar.aUU, aVar.aUW, xVar.aLm.aUO + "", xVar.aLl.is_followed);
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

    private boolean ehf() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null || com.baidu.live.af.a.SE().bwi.aPq.aSS == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().a(com.baidu.live.af.a.SE().bwi.aPq.aSS.Fm(), true);
    }

    private void c(r rVar) {
        if (this.oHz != null) {
            this.oHz.c(rVar);
        }
    }

    private void T(x xVar) {
        this.aGe = xVar;
    }

    private void cqC() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oHt.setIsScrollable(false);
            this.ieD = false;
        }
        if (this.aGe != null) {
            a(this.aGe.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oHs.a(this.oxh, null);
            a(this.oHs, this.aGe.mLiveInfo, this.bzP);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aGe.mLiveInfo.live_id), String.valueOf(this.aGe.mLiveInfo.room_id), String.valueOf(this.aGe.mLiveInfo.feed_id), cqD());
            if (com.baidu.live.liveroom.a.b.OR().bsC != null) {
                com.baidu.live.liveroom.a.b.OR().bsC.a(this.aGe.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
                String str = "normal";
                if (this.aGe != null && this.aGe.aLq != null && this.aGe.aLq.getRoomMode() == 1) {
                    str = "dating";
                } else if (this.aGe != null && this.aGe.aLq != null && this.aGe.aLq.getRoomMode() == 2) {
                    str = "battle";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bzP = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cqD() {
        if (this.ier == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.ier.optString("source");
            String optString2 = this.ier.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ier.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.ier.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.ier.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        o efg = o.efg();
        ViewGroup efi = efg.efi();
        if (efi != null && efi.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cD(efi)) {
                        ((ViewGroup) efi.getParent()).removeView(efi);
                        alaLiveRoomBlurPageLayout.f(efi, null);
                        efg.efh();
                    } else if (efg != null) {
                        efg.efh();
                    }
                } else if (efg != null) {
                    efg.efh();
                }
            } else if (efg != null) {
                efg.efh();
            }
        } else if (efi != null && efi.getParent() == null) {
            alaLiveRoomBlurPageLayout.f(efi, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        ViewGroup efi = o.efg().efi();
        if (efi != null) {
            efi.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.t(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.u(this.mTbPageContext.getPageActivity());
                int bs = p.bs(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bs + i;
                } else {
                    dimensionPixelSize = bs + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cqE() {
        this.bzP = true;
    }

    public boolean cqF() {
        return this.bzP;
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
        ViewGroup efi = o.efg().efi();
        if (efi != null) {
            int i2 = efi.getLayoutParams().width;
            int i3 = efi.getLayoutParams().height;
            int i4 = efi.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) efi.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i2 || b2.height != i3 || b2.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.oxh != null) {
                this.oxh.setLayoutParams(c);
            }
            if (this.oHs != null) {
                this.oHs.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oHy != null) {
                this.oHy.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oHz != null) {
                this.oHz.l(c.width, c.height, realScreenOrientation);
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
                this.oHr.VR(alaLiveInfoData.room_id + "");
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
            this.oHr.a(alaLiveInfoData.live_id, true, this.bvZ, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NQ(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            x HR = this.oHr.HR();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, HR.aLl.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : MapBundleKey.OfflineMapKey.OFFLINE_UPDATE);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void xT(int i) {
        if (i < 0) {
            this.oHr.xu(this.oHr.cmv() - 1);
        } else if (i > 0) {
            this.oHr.xu(this.oHr.cmv() + 1);
        }
        if (this.oHz != null) {
            this.oHz.a(this.oHs);
        }
        this.oHu.a(this.mSelectedPosition, cqH(), this.aGe);
        this.oHu.b(this.mSelectedPosition, cqI(), this.aGe);
        if (this.oHr != null) {
            AlaLiveInfoData cmy = this.oHr.cmy();
            if (cmy != null) {
                cmy.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cmy);
                a(this.oHs, cmy, this.bzP);
                this.bzP = false;
                if (this.oHz != null) {
                    this.oHz.a(this.mTbPageContext, this.oxh, null, this.oHs, this.oHr, this.bvZ, this.iek, this.hGS, null, this.ieC);
                    ehi();
                }
                a(cmy, false);
            }
            i(cmy);
            if (this.oHz != null) {
                this.oHz.ceL();
            }
            this.oHr.g(cmy);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.oxh.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.oxh.findViewById(a.f.ala_live_footer_view);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        try {
            x xVar = new x();
            xVar.aLD = false;
            xVar.aLl = new dd();
            if (alaLiveInfoData != null) {
                this.oHs.setBgImageUrl(alaLiveInfoData.bg_cover, null);
                xVar.aLl.bg_cover = alaLiveInfoData.bg_cover;
                xVar.aLl.live_id = String.valueOf(alaLiveInfoData.live_id);
                xVar.aLl.cover = alaLiveInfoData.cover;
                xVar.aLl.aVu = String.valueOf(alaLiveInfoData.room_id);
                xVar.aLl.croom_id = alaLiveInfoData.croom_id;
                xVar.aLl.is_followed = alaLiveInfoData.is_followed;
                xVar.aLl.room_name = alaLiveInfoData.room_name;
            }
            xVar.mLiveInfo = new AlaLiveInfoData();
            if (alaLiveInfoData != null) {
                xVar.mLiveInfo.live_id = alaLiveInfoData.live_id;
            }
            xVar.aKQ = new AlaLiveUserInfoData();
            xVar.aKR = new w();
            xVar.aLq = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            xVar.bw(true);
            this.oHr.setLiveShowData(xVar);
            xVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.oHz != null) {
                this.oHz.a(xVar, str, str2);
            }
            UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.aLl.aVu), cqD());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oHs.a(this.oxh, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehg() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.efT().bgO();
    }

    private AlaLiveInfoData cqH() {
        List<AlaLiveInfoData> cmo = this.oHr.cmo();
        if (cmo == null || cmo.size() == 0) {
            if (this.aGe == null) {
                return null;
            }
            return this.aGe.mLiveInfo;
        }
        int cmv = this.oHr.cmv();
        int size = cmo.size();
        return cmo.get(((cmv + size) - 1) % size);
    }

    private AlaLiveInfoData cqI() {
        List<AlaLiveInfoData> cmo = this.oHr.cmo();
        if (cmo == null || cmo.size() == 0) {
            if (this.aGe == null) {
                return null;
            }
            return this.aGe.mLiveInfo;
        }
        return cmo.get((this.oHr.cmv() + 1) % cmo.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (dVar != null) {
            if (!this.ieh) {
                a(dVar);
            }
            if (this.oHr.orz) {
                this.mHandler.removeCallbacks(this.oHF);
                this.mHandler.postDelayed(this.oHF, 1000L);
            }
        }
    }

    private void a(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d dVar) {
        if (this.oHz != null) {
            this.oHz.a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.iei) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oZ(false);
            return;
        }
        x HR = this.oHr.HR();
        T(HR);
        if (HR != null && HR.aLl != null) {
            aK(HR);
        }
        ehh();
        this.oHr.cmp();
        if (this.bzP) {
            this.oHr.oA(false);
        }
        this.hGS = System.currentTimeMillis() / 1000;
        if (this.oHz != null) {
            this.oHz.a(this.mTbPageContext, this.oxh, null, this.oHs, this.oHr, this.bvZ, this.iek, this.hGS, this.iel, this.ieC);
            ehi();
        }
        cqC();
        if (HR != null && HR.mLiveInfo != null && HR.mLiveInfo.live_status == 2) {
            this.oHu.a(this.mSelectedPosition, this.oHr.HR());
            e(HR, false);
            this.bzP = false;
            return;
        }
        boolean z = (this.oHz == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ah.a.b.Tq().cR(com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aPs && HR != null && HR.aLp);
        aj.e(HR);
        if (z) {
            if (!this.iez || !TextUtils.equals(t.XH(), this.ieA)) {
                aj.b(getPageContext(), false, this.oHq.cqj());
                e.ST().SU();
                this.iez = true;
                this.ieA = t.XH();
            }
            aj.HY();
        }
        if (this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null) {
            this.oHr.hH(this.oHr.HR().mLiveInfo.live_id);
            this.iev = true;
        }
        if (this.oHz != null) {
            this.oHz.b(this.ief);
            this.oHz.aF(TextUtils.equals(this.iem, "1"), TextUtils.equals(this.oHx, "1"));
            this.iem = "";
            this.oHx = "";
        }
        if (this.oHv != null) {
            this.oHv.a(this.aGe, this.oHw);
        }
        a(this.oHr.HR());
        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_IS_INIT, this.bzP ? "1" : "0");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.oHr.HR() != null && b.this.oHr.HR().mLiveInfo != null) {
                    b.this.oHr.a(b.this.oHr.HR().mLiveInfo.live_id, b.this.bvZ, b.this.hGS);
                }
            }
        });
        this.bzP = false;
        if (z && this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null && this.oHr.HR().aKu != null && this.oHz != null) {
            long j = this.oHr.HR().mLiveInfo.live_id;
            long j2 = this.oHr.HR().mLiveInfo.room_id;
            String str2 = this.oHr.HR().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.Ig() != null) {
                    al.Ig().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.ieQ != null) {
                    this.ieQ.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.Lx() != null) {
                com.baidu.live.guardclub.e.Lx().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oHC == null) {
                this.oHC = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oHC.a(this.mTbPageContext.getPageActivity(), this.oHr.HR(), this.otherParams);
        }
        if (this.oHD == null) {
            this.oHD = new com.baidu.tieba.yuyinala.liveroom.p.c(this.mTbPageContext);
        }
        if (z && this.oHr.HR() != null && this.oHr.HR().aKQ != null && !this.iey) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oHD.a(this.oHr.HR(), this.oHr.HR().aKQ.userId);
                this.iey = true;
            }
        }
    }

    private void ehh() {
        try {
            if (this.oHr != null && this.oHr.HR() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oHr.HR().aKQ.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oHr.HR().aLl.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bzP) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oHr.HR().aLl.aVu, this.otherParams, this.mSelectedPosition + 1, this.bzP, this.oHr.HR().mLiveInfo.feed_id);
                }
                if (!this.oHr.cmo().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oHr.HR().aLl.aVu, this.otherParams, this.mSelectedPosition + 1, this.bzP, this.oHr.HR().mLiveInfo.feed_id);
                    this.oHr.cmo().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oHr.HR().aLl.aVu, this.otherParams, this.mSelectedPosition + 1, this.bzP, this.oHr.HR().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oHr.HR().aLl.aVu, this.otherParams, this.mSelectedPosition + 1, this.bzP, this.oHr.HR().mLiveInfo.feed_id);
                this.oHB = new StayTimeBean();
                this.oHB.liveId = this.oHr.HR().mLiveInfo.live_id;
                this.oHB.roomId = this.oHr.HR().mLiveInfo.room_id;
                this.oHB.vid = this.oHr.HR().mLiveInfo.feed_id;
                this.oHB.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqJ() {
        if (this.ieg) {
            this.oHu.a(this.mSelectedPosition, cqH(), this.aGe);
            this.oHu.b(this.mSelectedPosition, cqI(), this.aGe);
            this.ieg = false;
        }
        if (this.oHy != null && cqT()) {
            this.oHy.ad(this.oHr.cmq());
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
        if (!this.iei) {
            this.mHandler.removeCallbacks(this.ieK);
            this.mHandler.postDelayed(this.ieK, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(r rVar) {
        if (rVar == null) {
            if (!this.iei) {
                this.mHandler.removeCallbacks(this.ieJ);
                this.mHandler.postDelayed(this.ieJ, 5000L);
                return;
            }
            return;
        }
        if (!this.ieh) {
            c(rVar);
        }
        if (!this.iei) {
            this.mHandler.removeCallbacks(this.ieJ);
            this.mHandler.postDelayed(this.ieJ, rVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqK() {
        if (this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null) {
            this.oHr.hH(this.oHr.HR().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && xVar.aKQ != null && xVar.aKQ.logined == 1) {
            oZ(false);
        } else if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_status == 2) {
            this.oHu.a(this.mSelectedPosition, this.oHr.HR());
            e(xVar, false);
        } else if (xVar != null) {
            if (!this.ieh) {
                aj.e(xVar);
                a(xVar);
            }
            if (!this.iei) {
                this.mHandler.removeCallbacks(this.hKe);
                this.mHandler.postDelayed(this.hKe, xVar.aKz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clT() {
        if (this.mTbPageContext != null && this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null) {
            this.oHr.a(this.oHr.HR().mLiveInfo.live_id, this.bvZ, this.hGS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(x xVar, boolean z) {
        View view = null;
        nN(true);
        if (!cqT()) {
            this.oHr.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oHs != null) {
                this.oHs.Zs();
                this.oHs.cnW();
            }
            if (xVar != null && xVar.mLiveInfo != null) {
                this.ieq = xVar.mLiveInfo.live_id;
            }
            cqz();
            cqL();
            cqM();
            if (xVar != null) {
                if (this.oHz != null && this.oHz.ceR() != null) {
                    view = this.oHz.ceR().a(this.oHz.eck().pageContext.getPageActivity(), xVar, z);
                }
                if (this.oHs != null) {
                    this.oHy.a(this.oHs, view, xVar, z, this.oHr.cmq());
                }
                if (this.oHz != null) {
                    this.oHz.nN(false);
                    this.oHz.ceM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oHs != null) {
                    this.oHs.cnY();
                }
                long j = xVar.mLiveInfo.live_id;
                long j2 = xVar.mLiveInfo.room_id;
                String str = xVar.mLiveInfo.feed_id;
                long j3 = xVar.aKu.userId;
                String str2 = xVar.aKu.userName;
            }
            cqV();
            if (this.oHv != null) {
                this.oHv.a(this.aGe, this.oHw);
            }
        }
    }

    private void cqL() {
    }

    private void cqM() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oHt);
        }
    }

    public void cqN() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cqO();
        } else {
            cqP();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oHr != null && this.oHr.HR() != null) {
            alaLiveInfoData = this.oHr.HR().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cqO();
        } else {
            cqP();
        }
        this.oHt.setIsScrollable(!z && this.ieD);
        if (this.oHz != null) {
            this.oHz.onKeyboardVisibilityChanged(z);
        }
        if (this.oxh != null) {
            this.oxh.onKeyboardVisibilityChanged(z);
        }
        if (z) {
            o.efg().setMaskBg(z);
        }
    }

    public void dU(int i) {
    }

    public void cqO() {
        if (this.oHt != null) {
            i.ae(this.oHt);
        }
    }

    public void cqP() {
        if (this.oHt != null) {
            i.af(this.oHt);
        }
    }

    public void onResume() {
        if (this.oHr != null) {
            this.oHr.cma();
        }
        if (this.oHz != null) {
            this.oHz.enterForeground();
        }
        if (this.oHC != null) {
            this.oHC.onResume();
        }
        if (this.oHD != null) {
            this.oHD.onResume();
        }
        if (this.ifk != null && !this.ifk.hasFocus()) {
            this.ifk.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.En().onResume();
    }

    public void onStart() {
        if (!this.ieB) {
            if (this.iei) {
                this.iei = false;
                cqS();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cqS() {
        clT();
        cqK();
        this.oHr.cmp();
        if (this.oHs != null) {
            this.oHs.edT();
        }
        if (this.oHz != null) {
            this.oHz.ceQ();
        }
        if (this.oHr != null && this.oHr.HR() != null && this.oHr.HR().mLiveInfo != null) {
            this.oHA.fG(this.oHr.HR().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aGe.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oHr != null) {
            this.oHr.cmb();
        }
        if (this.oHz != null) {
            this.oHz.enterBackground();
        }
        com.baidu.live.core.layer.b.En().onPause();
    }

    public void oW(boolean z) {
        this.iei = true;
        pa(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pa(boolean z) {
        this.mHandler.removeCallbacks(this.hKe);
        this.mHandler.removeCallbacks(this.oHF);
        this.mHandler.removeCallbacks(this.ieJ);
        this.mHandler.removeCallbacks(this.ieK);
        if (this.oHs != null) {
            this.oHs.edS();
        }
        if (this.oHz != null) {
            this.oHz.ceP();
        }
        this.oHA.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.Ig() != null) {
                al.Ig().a(i, i2, intent, this.aGe, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oHz != null) {
            this.oHz.onActivityResult(i, i2, intent);
        }
    }

    public boolean cqT() {
        return this.oHy != null && this.oHy.bXR();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.oHN);
        MessageManager.getInstance().unRegisterListener(this.ifc);
        MessageManager.getInstance().unRegisterListener(this.oHO);
        MessageManager.getInstance().unRegisterListener(this.oHP);
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.oHQ);
        MessageManager.getInstance().unRegisterListener(this.oHR);
        MessageManager.getInstance().unRegisterListener(this.oHM);
        if (this.ieQ != null) {
            this.ieQ.release();
        }
        if (this.oHv != null) {
            this.oHv.onDestory();
        }
        o.efg().cNv();
        if (this.oHw != null) {
            this.oHw.reset();
        }
        if (this.oHz != null) {
            this.oHz.onDestroy();
        }
        if (this.oHu != null) {
            this.oHu.onDestroy();
        }
        this.oHs.Zs();
        if (this.oHs != null) {
            this.oHs.release();
            this.oHs = null;
        }
        if (this.oHy != null) {
            this.oHy.onDestroy();
        }
        if (this.ifk != null) {
            this.ifk.abandonAudioFocus();
        }
        if (this.oHB != null && this.oHr != null && this.oHr.HR() != null) {
            if (this.oHB.liveId == this.oHr.HR().mLiveInfo.live_id && this.oHB.startTime > 0) {
                this.oHB.endTime = System.currentTimeMillis();
                long j = this.oHB.endTime - this.oHB.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oHr.HR().aLl.aVu, this.otherParams, this.mSelectedPosition + 1, this.bzP, this.oHr.HR().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oHB = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oHr != null) {
                jSONObject.put("identity", this.oHr.HR().aKQ.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oHr.HR().aLl.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.oxh != null) {
            this.oxh.coe();
            this.oxh = null;
        }
        if (this.oHr != null) {
            this.oHr.destory();
        }
        z.HJ().release();
        if (this.oHD != null) {
            this.oHD.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.efT().release();
        k.eeX().a((k.a) null);
    }

    public void pb(boolean z) {
        this.ieB = z;
    }

    public void cqU() {
        if (this.ier != null) {
            this.otherParams = this.ier.toString();
            if (this.oHr != null) {
                this.oHr.setOtherParams(this.otherParams);
            }
            if (this.oHz != null) {
                this.oHz.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oHy != null) {
                this.oHy.setOtherParams(this.otherParams);
            }
        }
    }

    public void cqV() {
        if (this.ier != null) {
            String optString = this.ier.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.ier.put("tab", "live_jump");
                        this.ier.put("tag", "");
                        this.ier.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.ier.put("tab", "liveroom");
                        this.ier.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cqU();
            }
        }
    }

    public void cqW() {
        aj.Ib();
    }

    private void ehi() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oHz.e((short) 2);
        } else {
            this.oHz.ecl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oHH = bitmap;
            this.oHs.setBgImageBitmap(this.oHH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oHs.setBgVideo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehj() {
        if (this.oHH != null) {
            if (!this.oHH.isRecycled()) {
                this.oHH.recycle();
            }
            this.oHH = null;
        }
        aK(this.aGe);
    }

    public boolean efo() {
        return this.ieB;
    }
}

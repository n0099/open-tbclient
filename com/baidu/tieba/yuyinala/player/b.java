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
/* loaded from: classes10.dex */
public class b extends BdBaseView<TbPageContext> {
    private ab aED;
    private boolean bAf;
    private CustomMessageListener bhY;
    private long bwn;
    private String bwo;
    private ViewGroup hIn;
    private LayerRootView hIo;
    private long hIs;
    private Runnable hLH;
    private String hqz;
    private AlaLastLiveroomInfo ifP;
    private boolean ifQ;
    private boolean ifR;
    private boolean ifS;
    private boolean ifU;
    private ArrayList<AlaBroadcastGiftToastData> ifV;
    private String ifW;
    private String ifZ;
    private c igA;
    com.baidu.live.liveroom.a.c igH;
    ViewPager.OnPageChangeListener igI;
    CustomMessageListener igM;
    private g igU;
    private long iga;
    private JSONObject igb;
    private boolean igc;
    private boolean igf;
    private boolean igi;
    private boolean igj;
    private String igk;
    private boolean igl;
    private bw igm;
    private boolean ign;
    private boolean igo;
    private Runnable igt;
    private Runnable igu;
    private Runnable igv;
    private String mAudioUrl;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private AlaLiveView oES;
    private a oPA;
    private com.baidu.tieba.yuyinala.liveroom.k.a oPB;
    private AlaLiveRoomBlurPageLayout oPC;
    private AlaLoopViewPager oPD;
    private AlaLoopViewPagerAdapter oPE;
    private com.baidu.tieba.yuyinala.liveroom.d.a oPF;
    private com.baidu.tieba.yuyinala.liveroom.d.b oPG;
    private boolean oPH;
    private String oPI;
    private com.baidu.tieba.yuyinala.endliveroom.a oPJ;
    private com.baidu.tieba.yuyinala.liveroom.c.b oPK;
    private com.baidu.tieba.yuyinala.liveroom.task.b oPL;
    private StayTimeBean oPM;
    private com.baidu.tieba.yuyinala.liveroom.g.a oPN;
    private com.baidu.tieba.yuyinala.liveroom.p.c oPO;
    private Set<String> oPP;
    private Runnable oPQ;
    private int oPR;
    private Bitmap oPS;
    private boolean oPT;
    private String oPU;
    private String oPV;
    private CustomMessageListener oPW;
    CustomMessageListener oPX;
    private CustomMessageListener oPY;
    private CustomMessageListener oPZ;
    private d oPz;
    CustomMessageListener oQa;
    CustomMessageListener oQb;
    private String otherParams;
    private a.InterfaceC0934a ozf;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.ifQ = true;
        this.hIs = 0L;
        this.ifR = false;
        this.bAf = true;
        this.oPH = false;
        this.bwo = "";
        this.mForumName = "";
        this.ifS = false;
        this.ifU = false;
        this.ifW = "0";
        this.oPI = "0";
        this.mHandler = new Handler();
        this.iga = -1L;
        this.otherParams = "";
        this.igc = false;
        this.oPL = com.baidu.tieba.yuyinala.liveroom.task.b.ecc();
        this.igf = false;
        this.igj = false;
        this.igl = false;
        this.igo = false;
        this.oPP = new HashSet();
        this.hLH = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjh();
            }
        };
        this.igt = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cod();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.oPB.cjD();
            }
        };
        this.oPQ = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.oPB.Fp() != null) {
                    b.this.oPB.ag(b.this.oPB.Fp());
                }
            }
        };
        this.oPR = 5000;
        this.mAudioUrl = "";
        this.oPU = "";
        this.oPV = "";
        this.oPW = new CustomMessageListener(2501082) { // from class: com.baidu.tieba.yuyinala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oPB != null && b.this.oPB.Fp() != null) {
                    b.this.oPB.ag(b.this.oPB.Fp());
                }
            }
        };
        this.bhY = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.igv = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.20
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
        this.igH = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // com.baidu.live.liveroom.a.c
            public void cC(final boolean z) {
                if (!m.edI().isShowing()) {
                    i.edF().Ac(false);
                    boolean aB = m.edI().aB(b.this.mTbPageContext.getPageActivity());
                    m.edI().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.2.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edK() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edL() {
                            if (z || b.this.oPK == null || b.this.oPK.ccd()) {
                                b.this.pf(true);
                                b.this.bZh();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edM() {
                        }
                    });
                    if (aB) {
                        if (z || b.this.oPK == null || b.this.oPK.ccd()) {
                            b.this.pf(true);
                            b.this.bZh();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cD(boolean z) {
                b.this.e(b.this.aED, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oPD != null) {
                    b.this.oPD.setIsScrollable(b.this.ign && z);
                    b.this.oPD.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
            }
        };
        this.igI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.oES != null && b.this.oPB != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oPD.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oPM != null && b.this.oPB != null && b.this.oPB.Fp() != null && b.this.oPB.Fp().mLiveInfo != null && b.this.oPB.Fp().aKu != null) {
                        if (b.this.oPM.liveId == b.this.oPB.Fp().mLiveInfo.live_id && b.this.oPM.startTime > 0) {
                            b.this.oPM.endTime = System.currentTimeMillis();
                            long j = b.this.oPM.endTime - b.this.oPM.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oPB.Fp().aKu.aVk, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bAf, b.this.oPB.Fp().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oPM = null;
                    }
                    if (b.this.bAf || b.this.oPB.cjC() == null || ListUtils.getCount(b.this.oPB.cjC()) > 1) {
                        if (b.this.oPB.cjH() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.oPB == null || !b.this.oPB.cjH() || i2 >= 0) {
                            if (b.this.oPB != null && b.this.oPB.cjI() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oPD.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.oPB != null) {
                                b.this.oPB.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nU(true);
                            b.this.oPC.clp();
                            b.this.oPC.Xl();
                            b.this.oPC.clq();
                            b.this.coo();
                            if (b.this.igA != null) {
                                b.this.igA.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oPC = b.this.oPE.Me(b.this.mSelectedPosition);
                            b.this.oPC.clr();
                            b.this.wz(i2);
                            b.this.efV();
                            b.this.MK(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oPD.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oPD.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oPB.g(b.this.oPB.cjM());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oPD != null && i == 0) {
                    com.baidu.live.d.xf().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.ozf = new a.InterfaceC0934a() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // com.baidu.tieba.yuyinala.liveroom.k.a.InterfaceC0934a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.oPB.Fp());
                } else if (i2 == 2) {
                    b.this.f(b.this.oPB.bTX());
                } else if (i2 == 3) {
                    b.this.bx(i, str);
                } else if (i2 == 12) {
                    b.this.c(b.this.oPB.ebR());
                } else if (i2 == 11) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_IS_INIT, b.this.bAf ? "1" : "0");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApi");
                    UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "enterLiveApiHandle", jSONObject);
                } else if (i2 == 4) {
                    b.this.aK(obj);
                } else if (i2 == 5) {
                    b.this.coc();
                }
            }
        };
        this.oPX = new CustomMessageListener(2913169) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    q.edU().setMaskBg(false);
                }
            }
        };
        this.igM = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oPB != null && b.this.oPB.Fp() != null && b.this.oPB.Fp().aJZ != null) {
                        if (l.longValue() == b.this.oPB.Fp().aJZ.userId) {
                            b.this.oPB.Fp().aJZ.isNewUser = false;
                            if (b.this.oPN != null) {
                                b.this.oPN.o(b.this.oPB.Fp());
                            }
                        }
                    }
                }
            }
        };
        this.oPY = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.efZ();
                    } else {
                        b.this.W((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oPZ = new CustomMessageListener(2501078) { // from class: com.baidu.tieba.yuyinala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501078) {
                    String str = null;
                    if (customResponsedMessage.getData() instanceof String) {
                        str = (String) customResponsedMessage.getData();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        b.this.Xc(str);
                    }
                }
            }
        };
        this.oQa = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cjh();
            }
        };
        this.oQb = new CustomMessageListener(2501080) { // from class: com.baidu.tieba.yuyinala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501080 && (customResponsedMessage.getData() instanceof YuyinAlaLiveRoomActivityConfig)) {
                    final YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = (YuyinAlaLiveRoomActivityConfig) customResponsedMessage.getData();
                    if (!m.edI().isShowing()) {
                        i.edF().Ac(false);
                        if (m.edI().aB(b.this.mTbPageContext.getPageActivity())) {
                            b.this.pf(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            return;
                        }
                        m.edI().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edK() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edL() {
                                b.this.pf(true);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                            public void edM() {
                            }
                        });
                    }
                }
            }
        };
        this.hIs = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oPA = aVar;
        this.ifQ = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.igA = (c) runTask.getData();
        }
        this.oPB = new com.baidu.tieba.yuyinala.liveroom.k.a(getPageContext());
        this.oPB.a(this.ozf);
        this.oPJ = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.oPX);
        MessageManager.getInstance().registerListener(this.igM);
        MessageManager.getInstance().registerListener(this.oPY);
        MessageManager.getInstance().registerListener(this.oPZ);
        MessageManager.getInstance().registerListener(this.bhY);
        MessageManager.getInstance().registerListener(this.oQa);
        MessageManager.getInstance().registerListener(this.oQb);
        MessageManager.getInstance().registerListener(this.oPW);
        this.igU = new g(tbPageContext.getPageActivity());
        this.igU.setIPlayerAudioFocusCallBack(new com.baidu.live.u.a() { // from class: com.baidu.tieba.yuyinala.player.b.17
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().muteOrUnmuteAudio(!z);
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
                        this.ifV = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.ifV.add(alaBroadcastGiftToastData);
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
        this.bwo = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bwo)) {
            this.bwo = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.ifZ = intent.getStringExtra("room_id");
        this.bwn = intent.getLongExtra("live_id", 0L);
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
                this.oPU = new String(Base64.decode(optString2.getBytes()));
                if (!this.oPU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oPU = "";
                }
            }
            this.oPV = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.igc = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oPB.b((AlaLiveInfoCoreData) serializableExtra);
            this.igc = true;
        }
        TbConfig.liveScene = 2;
        av(intent);
        this.ign = this.igm == null || !this.igm.aRD;
        this.oPJ.setOtherParams(this.otherParams);
        this.ifU = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        efS();
        Ap(true);
        this.mHandler.removeCallbacks(this.igv);
        this.mHandler.postDelayed(this.igv, 1000L);
    }

    private void av(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hqz = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.igb = new JSONObject(stringExtra);
                if (this.igb != null) {
                    String optString2 = this.igb.optString("enterRoomId");
                    String optString3 = this.igb.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.ifZ, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bwn + "", optString3))) {
                        String optString4 = this.igb.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.igb.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.igc) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bwn;
                            alaLiveInfoCoreData.screenDirection = this.igb.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oPB.b(alaLiveInfoCoreData);
                            this.igc = true;
                        }
                    }
                    String optString6 = this.igb.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.igm = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oPB != null) {
                            this.oPB.HC(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hqz = jSONObject.optString("live_back_scheme");
                        this.igm = new bw();
                        this.igm.aRD = jSONObject.optInt("is_hot") == 1;
                        if (this.igm.aRD) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.igm.aRE = jSONObject.optString("task_id");
                        this.igm.aRC = TextUtils.isEmpty(this.igm.aRE) ? false : true;
                        this.igm.aRF = jSONObject.optInt("task_type");
                        this.igm.aRG = jSONObject.optInt("task_im_count");
                        this.igm.aRH = jSONObject.optLong("task_gift_total_price");
                        this.igm.aRI = jSONObject.optLong("task_watch_time");
                        this.igm.aRJ = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oPG = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oPG.setScheme(optString8);
                            this.oPG.setImageUrl(optString9);
                            this.oPG.setTitle(optString10);
                        }
                    }
                    this.ifW = this.igb.optString("open_giftlist");
                    this.oPI = this.igb.optString(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.igb.remove("cover");
                    this.igb.remove("live_url");
                    this.igb.remove("enterRoomId");
                    this.igb.remove("enterLiveId");
                    this.igb.remove("open_giftlist");
                    this.igb.remove(YuyinAlaLiveRoomActivityConfig.LIVE_SHOW_IM_PANEL);
                    this.igb.remove("extra");
                    this.otherParams = this.igb.toString();
                    if (this.oPB != null) {
                        this.oPB.setOtherParams(this.otherParams);
                    }
                    this.igb.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("source");
                    }
                    this.igo = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.igb.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oPB != null) {
                        this.oPB.wa(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ifP = new AlaLastLiveroomInfo();
                this.ifP.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bwn), String.valueOf(this.ifZ), null, cnW());
        UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bwn), String.valueOf(this.ifZ), cnW());
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

    public void Ap(boolean z) {
        boolean z2 = false;
        if (this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null && this.oPB.Fp().mLiveInfo.room_id > 0) {
            this.oPB.Wb(this.oPB.Fp().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.ifZ)) {
            this.oPB.Wb(this.ifZ);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.oPB.aw(this.uk, this.bwo, this.mForumName);
            z2 = true;
        } else if (this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null && this.oPB.Fp().mLiveInfo.live_id > 0) {
            this.oPB.a(this.oPB.Fp().mLiveInfo.live_id, false, this.bwo, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bwo = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                pf(false);
                return;
            }
            this.oPB.aw(this.uk, this.bwo, this.mForumName);
            z2 = true;
        } else if (!TextUtils.isEmpty(this.ifZ)) {
            this.oPB.Ih(this.ifZ);
            z2 = true;
        } else if (this.bwn > 0) {
            this.oPB.a(this.bwn, false, this.bwo, "");
            z2 = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
        if (z2) {
            efV();
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

    private void efS() {
        this.bAf = true;
        this.ifR = false;
        efT();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bf().l(this.hIo);
        this.oPK = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oPK.a(this.igH);
        this.oPK.setOtherParams(this.otherParams);
        this.oPK.nO(this.igo);
        try {
            ab abVar = new ab();
            abVar.aKO = false;
            abVar.aKu = new dj();
            abVar.aKu.live_id = String.valueOf(this.bwn);
            abVar.aKu.cover = "";
            abVar.aKu.room_name = ".....";
            abVar.aKu.aVk = "0";
            abVar.aKu.croom_id = "0";
            abVar.aKu.is_followed = true;
            abVar.aKu.bg_cover = this.oPU;
            abVar.mLiveInfo = new AlaLiveInfoData();
            abVar.aJZ = new AlaLiveUserInfoData();
            abVar.aKa = new aa();
            abVar.aKy = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            abVar.bx(true);
            this.oPB.setLiveShowData(abVar);
            cnK();
            cnH();
            this.oPK.a(abVar, this.mAudioUrl, this.oPV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void efT() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oPD = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oPD.setOnPageChangeListener(this.igI);
        this.oPD.setBoundaryCaching(true);
        this.oPD.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oPE = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oPE.cgQ();
        this.oPC = this.oPE.Md(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oPU)) {
                this.oPC.setBgImageUrl(this.oPU, null);
            } else {
                this.oPC.setDefaultBg();
            }
            this.oPE.Md(0).setDefaultBg();
            this.oPE.Md(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oPB != null) {
            this.oPE.a(this.mSelectedPosition, this.oPB.Fp());
        }
        this.oPD.setAdapter(this.oPE);
        this.oPD.setCurrentItem(this.mSelectedPosition);
        this.oPD.setIsScrollable(this.ign);
        this.hIn = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hIo = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oPD.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.21
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                ab Fp;
                if ((b.this.oPB == null || (Fp = b.this.oPB.Fp()) == null || Fp.mLiveInfo == null || Fp.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oPT = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oPB == null || !b.this.oPB.cjH() || rawY <= 0.0f) {
                            if (b.this.oPB == null || !b.this.oPB.cjI() || rawY >= 0.0f) {
                                if (m.edI().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                i.edF().Ac(false);
                                m.edI().aB(b.this.mTbPageContext.getPageActivity());
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
            public boolean Mc(int i) {
                ab Fp;
                if (b.this.oPB == null || (Fp = b.this.oPB.Fp()) == null || Fp.mLiveInfo == null || Fp.mLiveInfo.live_status != 2) {
                    m.edI().a(new m.a() { // from class: com.baidu.tieba.yuyinala.player.b.21.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edK() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edL() {
                            if (b.this.oPD != null) {
                                if (b.this.oPB == null || !b.this.oPB.cjH() || !b.this.oPT) {
                                    if (b.this.oPB == null || !b.this.oPB.cjI() || b.this.oPT) {
                                        int currentItem = b.this.oPD.getCurrentItem();
                                        if (b.this.oPT) {
                                            if (currentItem == 0) {
                                                b.this.oPD.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oPD.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oPD.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oPD.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oPD.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oPD.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                        public void edM() {
                        }
                    });
                    if (b.this.oPB != null && b.this.oPB.cjH() && b.this.oPT) {
                        return true;
                    }
                    if (b.this.oPB == null || !b.this.oPB.cjI() || b.this.oPT) {
                        if (m.edI().isShowing()) {
                            return false;
                        }
                        i.edF().Ac(false);
                        return m.edI().aB(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        q edU = q.edU();
        edU.a(this.mTbPageContext, this.oPC, rect);
        edU.a(this);
    }

    private void cnH() {
        this.oPF = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hIn);
    }

    private void c(Rect rect) {
        this.oES = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.oES.setSwipeClearEnable(false);
        this.oES.hTf = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oPC.a(this.oES, layoutParams);
    }

    private void cnK() {
        if (this.oPB != null && this.oPB.Fp() != null) {
            this.aED = this.oPB.Fp();
            if (this.aED.mLiveInfo != null) {
                a(this.aED.mLiveInfo, this.igc);
                if (this.aED.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.ifS);
                    }
                    if (this.oPK != null) {
                        this.oPK.a(this.mTbPageContext, this.oES, null, this.oPC, this.oPB, this.bwo, this.ifU, this.hIs, this.ifV, this.igm);
                        efY();
                    }
                }
            }
        }
    }

    private void cnS() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.ifU || !this.ign) {
                this.oPD.setIsScrollable(false);
            } else {
                this.oPD.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bf().onBackPressed() && ((this.oPK == null || !this.oPK.onKeyDown(i, keyEvent)) && (this.oPK == null || !this.oPK.ccc()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnS();
            } else if (!m.edI().aB(this.mTbPageContext.getPageActivity())) {
                i.edF().Ac(false);
            } else if (this.oPK == null || this.oPK.ccd()) {
                pf(true);
                bZh();
            }
        }
        return true;
    }

    public void bZh() {
        if (!TextUtils.isEmpty(this.hqz)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hqz);
                this.hqz = null;
            }
        }
    }

    public void pf(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nU(!z);
        com.baidu.live.core.layer.b.Bf().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnU();
        long j = -1;
        if (this.oPB != null && this.oPB.cjM() != null) {
            j = this.oPB.cjM().room_id;
        }
        this.oPA.b(z, z2, j);
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
        if (this.oPH) {
            efX();
            this.oPH = false;
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ifP = null;
        if (al.FE() != null) {
            al.FE().FD();
        }
        com.baidu.live.core.layer.b.Bf().Bg();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().dg(this.oES);
        if (this.igA != null) {
            this.igA.release();
        }
        if (this.oPN != null) {
            this.oPN.release();
        }
        this.igm = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oPD);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oPB != null) {
            this.oPB.HC(null);
            AlaLiveInfoData cjM = this.oPB.cjM();
            if (cjM != null) {
                this.oPB.fI(cjM.live_id);
            }
        }
        this.oPL.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnT();
        if (this.oPK != null) {
            this.oPK.nU(z);
        }
        this.igf = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mx().bsR != null) {
            com.baidu.live.liveroom.a.b.Mx().bsR.b(this.aED.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().aAM();
        }
        q.edU().Au();
        aj.gu("");
        if (this.oPA != null && this.oPA.cnC()) {
            am.FF().Fc();
        }
    }

    private void cnT() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            if (this.oES.findViewById(a.f.ala_live_header_view).getMeasuredWidth() == 0) {
                if (abVar.mLiveInfo != null && abVar.mLiveInfo.live_id > 0) {
                    this.oPB.fI(abVar.mLiveInfo.live_id);
                    cnX();
                    this.oPB.a(abVar.mLiveInfo.live_id, false, this.bwo, "");
                    return;
                }
                return;
            }
            if (abVar.aKu != null && this.oPB.ozo) {
                aN(abVar);
            }
            aO(abVar);
            this.aED = abVar;
            if (this.oPK != null) {
                this.oPK.a(abVar);
            }
        }
    }

    private void aN(ab abVar) {
        if (abVar.aKu.aVp) {
            if (com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().WO(abVar.aKu.aVo)) {
                Xc(com.baidu.live.storage.b.hN(abVar.aKu.aVo));
                return;
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501079, new String[]{abVar.aKu.aVn, abVar.aKu.aVo}));
                return;
            }
        }
        this.oPC.setBgImageUrl(abVar.aKu.bg_cover, null);
        this.oPC.ecC();
    }

    private void aO(final ab abVar) {
        List<dd.a> list;
        if (abVar.aKv != null && abVar.aKu != null && (list = abVar.aKv.aUF) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final dd.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aUJ + aVar.aUL + aVar.aUN + abVar.aKu.aVk;
                    if (!this.oPP.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aUJ - (System.currentTimeMillis() / 1000));
                        this.oPP.add(str);
                        if (this.oPz == null) {
                            this.oPz = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!efU() || StringUtils.isNull(aVar.aUL, true) || StringUtils.isNull(aVar.aUN, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oPz.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oPz.a(z, aVar.aUJ, aVar.aUL, aVar.aUN, abVar.aKu.aVk, abVar.aKu.live_id, abVar.aKu.croom_id, aVar.aUK, aVar.aUM, abVar.aKv.aUE + "", abVar.aKu.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oPz.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oPz.a(false, aVar.aUJ, aVar.aUL, aVar.aUN, abVar.aKu.aVk, abVar.aKu.live_id, abVar.aKu.croom_id, aVar.aUK, aVar.aUM, abVar.aKv.aUE + "", abVar.aKu.is_followed);
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

    private boolean efU() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOT == null || com.baidu.live.ae.a.Qm().bwx.aOT.aSI == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().a(com.baidu.live.ae.a.Qm().bwx.aOT.aSI.CH(), true);
    }

    private void c(v vVar) {
        if (this.oPK != null) {
            this.oPK.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aED = abVar;
    }

    private void cnV() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oPD.setIsScrollable(false);
            this.ign = false;
        }
        if (this.aED != null) {
            a(this.aED.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oPC.a(this.oES, null);
            a(this.oPC, this.aED.mLiveInfo, this.bAf);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aED.mLiveInfo.live_id), String.valueOf(this.aED.mLiveInfo.room_id), String.valueOf(this.aED.mLiveInfo.feed_id), cnW());
            if (com.baidu.live.liveroom.a.b.Mx().bsR != null) {
                com.baidu.live.liveroom.a.b.Mx().bsR.a(this.aED.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
                String str = "normal";
                if (this.aED != null && this.aED.aKy != null && this.aED.aKy.getRoomMode() == 1) {
                    str = "dating";
                } else if (this.aED != null && this.aED.aKy != null && this.aED.aKy.getRoomMode() == 2) {
                    str = "battle";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bAf = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cnW() {
        if (this.igb == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.igb.optString("source");
            String optString2 = this.igb.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.igb.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.igb.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.igb.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        q edU = q.edU();
        ViewGroup edW = edU.edW();
        if (edW != null && edW.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cz(edW)) {
                        ((ViewGroup) edW.getParent()).removeView(edW);
                        alaLiveRoomBlurPageLayout.f(edW, null);
                        edU.edV();
                    } else if (edU != null) {
                        edU.edV();
                    }
                } else if (edU != null) {
                    edU.edV();
                }
            } else if (edU != null) {
                edU.edV();
            }
        } else if (edW != null && edW.getParent() == null) {
            alaLiveRoomBlurPageLayout.f(edW, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        ViewGroup edW = q.edU().edW();
        if (edW != null) {
            edW.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.br(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.bs(this.mTbPageContext.getPageActivity());
                int bq = p.bq(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bq + i;
                } else {
                    dimensionPixelSize = bq + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cnX() {
        this.bAf = true;
    }

    public boolean cnY() {
        return this.bAf;
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
        ViewGroup edW = q.edU().edW();
        if (edW != null) {
            int i2 = edW.getLayoutParams().width;
            int i3 = edW.getLayoutParams().height;
            int i4 = edW.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) edW.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.oES != null) {
                this.oES.setLayoutParams(c);
            }
            if (this.oPC != null) {
                this.oPC.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oPJ != null) {
                this.oPJ.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oPK != null) {
                this.oPK.l(c.width, c.height, realScreenOrientation);
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
                this.oPB.Wb(alaLiveInfoData.room_id + "");
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
            this.oPB.a(alaLiveInfoData.live_id, true, this.bwo, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MK(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Fp = this.oPB.Fp();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Fp.aKu.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : "up");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void wz(int i) {
        if (i < 0) {
            this.oPB.wb(this.oPB.cjJ() - 1);
        } else if (i > 0) {
            this.oPB.wb(this.oPB.cjJ() + 1);
        }
        if (this.oPK != null) {
            this.oPK.a(this.oPC);
        }
        this.oPE.a(this.mSelectedPosition, coa(), this.aED);
        this.oPE.b(this.mSelectedPosition, cob(), this.aED);
        if (this.oPB != null) {
            AlaLiveInfoData cjM = this.oPB.cjM();
            if (cjM != null) {
                cjM.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cjM);
                a(this.oPC, cjM, this.bAf);
                this.bAf = false;
                if (this.oPK != null) {
                    this.oPK.a(this.mTbPageContext, this.oES, null, this.oPC, this.oPB, this.bwo, this.ifU, this.hIs, null, this.igm);
                    efY();
                }
                a(cjM, false);
            }
            i(cjM);
            if (this.oPK != null) {
                this.oPK.cca();
            }
            this.oPB.g(cjM);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.oES.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.oES.findViewById(a.f.ala_live_footer_view);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        try {
            ab abVar = new ab();
            abVar.aKO = false;
            abVar.aKu = new dj();
            if (alaLiveInfoData != null) {
                this.oPC.setBgImageUrl(alaLiveInfoData.bg_cover, null);
                abVar.aKu.bg_cover = alaLiveInfoData.bg_cover;
                abVar.aKu.live_id = String.valueOf(alaLiveInfoData.live_id);
                abVar.aKu.cover = alaLiveInfoData.cover;
                abVar.aKu.aVk = String.valueOf(alaLiveInfoData.room_id);
                abVar.aKu.croom_id = alaLiveInfoData.croom_id;
                abVar.aKu.is_followed = alaLiveInfoData.is_followed;
                abVar.aKu.room_name = alaLiveInfoData.room_name;
            }
            abVar.mLiveInfo = new AlaLiveInfoData();
            if (alaLiveInfoData != null) {
                abVar.mLiveInfo.live_id = alaLiveInfoData.live_id;
            }
            abVar.aJZ = new AlaLiveUserInfoData();
            abVar.aKa = new aa();
            abVar.aKy = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            abVar.bx(true);
            this.oPB.setLiveShowData(abVar);
            abVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.oPK != null) {
                this.oPK.a(abVar, str, str2);
            }
            UbcAudioFlowStatisticManager.getInstance().updateLiveRoom(String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.aKu.aVk), cnW());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.oPC.a(this.oES, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efV() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eeF().bdj();
    }

    private AlaLiveInfoData coa() {
        List<AlaLiveInfoData> cjC = this.oPB.cjC();
        if (cjC == null || cjC.size() == 0) {
            if (this.aED == null) {
                return null;
            }
            return this.aED.mLiveInfo;
        }
        int cjJ = this.oPB.cjJ();
        int size = cjC.size();
        return cjC.get(((cjJ + size) - 1) % size);
    }

    private AlaLiveInfoData cob() {
        List<AlaLiveInfoData> cjC = this.oPB.cjC();
        if (cjC == null || cjC.size() == 0) {
            if (this.aED == null) {
                return null;
            }
            return this.aED.mLiveInfo;
        }
        return cjC.get((this.oPB.cjJ() + 1) % cjC.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (cVar != null) {
            if (!this.ifR) {
                b(cVar);
            }
            if (this.oPB.ozp) {
                this.mHandler.removeCallbacks(this.oPQ);
                this.mHandler.postDelayed(this.oPQ, 1000L);
            }
        }
    }

    private void b(com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c cVar) {
        if (this.oPK != null) {
            this.oPK.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.ifS) {
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
        ab Fp = this.oPB.Fp();
        V(Fp);
        if (Fp != null && Fp.aKu != null) {
            aN(Fp);
        }
        this.oPH = true;
        efW();
        this.oPB.cjD();
        if (this.bAf) {
            this.oPB.oG(false);
        }
        this.hIs = System.currentTimeMillis() / 1000;
        if (this.oPK != null) {
            this.oPK.a(this.mTbPageContext, this.oES, null, this.oPC, this.oPB, this.bwo, this.ifU, this.hIs, this.ifV, this.igm);
            efY();
        }
        cnV();
        if (Fp != null && Fp.mLiveInfo != null && Fp.mLiveInfo.live_status == 2) {
            this.oPE.a(this.mSelectedPosition, this.oPB.Fp());
            e(Fp, false);
            this.bAf = false;
            return;
        }
        boolean z = (this.oPK == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        aj.e(Fp);
        if (z) {
            if (!this.igj || !TextUtils.equals(t.Vy(), this.igk)) {
                aj.b(getPageContext(), false, this.oPA.cnC());
                e.QC().QD();
                this.igj = true;
                this.igk = t.Vy();
            }
            aj.Fw();
        }
        if (this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null) {
            this.oPB.hM(this.oPB.Fp().mLiveInfo.live_id);
            this.igf = true;
        }
        if (this.oPK != null) {
            this.oPK.b(this.ifP);
            this.oPK.aF(TextUtils.equals(this.ifW, "1"), TextUtils.equals(this.oPI, "1"));
            this.ifW = "";
            this.oPI = "";
        }
        if (this.oPF != null) {
            this.oPF.a(this.aED, this.oPG);
        }
        a(this.oPB.Fp());
        UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "UIRendering");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_IS_INIT, this.bAf ? "1" : "0");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_AUDIO_ROOM_PERF_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "").setContentExt(jSONObject));
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.oPB.Fp() != null && b.this.oPB.Fp().mLiveInfo != null) {
                    b.this.oPB.a(b.this.oPB.Fp().mLiveInfo.live_id, b.this.bwo, b.this.hIs);
                }
            }
        });
        this.bAf = false;
        if (z && this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null && this.oPB.Fp().aJD != null && this.oPK != null) {
            long j = this.oPB.Fp().mLiveInfo.live_id;
            long j2 = this.oPB.Fp().mLiveInfo.room_id;
            String str2 = this.oPB.Fp().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FE() != null) {
                    al.FE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.igA != null) {
                    this.igA.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IV() != null) {
                com.baidu.live.guardclub.e.IV().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oPN == null) {
                this.oPN = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oPN.a(this.mTbPageContext.getPageActivity(), this.oPB.Fp(), this.otherParams);
        }
        if (this.oPO == null) {
            this.oPO = new com.baidu.tieba.yuyinala.liveroom.p.c(this.mTbPageContext);
        }
        if (z && this.oPB.Fp() != null && this.oPB.Fp().aJZ != null && !this.igi) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oPO.a(this.oPB.Fp(), this.oPB.Fp().aJZ.userId);
                this.igi = true;
            }
        }
    }

    private void efW() {
        try {
            if (this.oPB != null && this.oPB.Fp() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oPB.Fp().aJZ.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oPB.Fp().aKu.croom_id);
                    jSONObject.put("room_id", this.oPB.Fp().aKu.aVk);
                    jSONObject.put("vid", this.oPB.Fp().mLiveInfo.feed_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bAf) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oPB.Fp().aKu.aVk, this.otherParams, this.mSelectedPosition + 1, this.bAf, this.oPB.Fp().mLiveInfo.feed_id);
                }
                if (!this.oPB.cjC().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oPB.Fp().aKu.aVk, this.otherParams, this.mSelectedPosition + 1, this.bAf, this.oPB.Fp().mLiveInfo.feed_id);
                    this.oPB.cjC().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oPB.Fp().aKu.aVk, this.otherParams, this.mSelectedPosition + 1, this.bAf, this.oPB.Fp().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oPB.Fp().aKu.aVk, this.otherParams, this.mSelectedPosition + 1, this.bAf, this.oPB.Fp().mLiveInfo.feed_id);
                this.oPM = new StayTimeBean();
                this.oPM.liveId = this.oPB.Fp().mLiveInfo.live_id;
                this.oPM.roomId = this.oPB.Fp().mLiveInfo.room_id;
                this.oPM.vid = this.oPB.Fp().mLiveInfo.feed_id;
                this.oPM.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    private void efX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("identity", this.oPB.Fp().aJZ.getUserTypeStr());
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oPB.Fp().aKu.croom_id);
            jSONObject.put("room_id", this.oPB.Fp().aKu.aVk);
            jSONObject.put("vid", this.oPB.Fp().mLiveInfo.feed_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        if (this.ifQ) {
            this.oPE.a(this.mSelectedPosition, coa(), this.aED);
            this.oPE.b(this.mSelectedPosition, cob(), this.aED);
            this.ifQ = false;
        }
        if (this.oPJ != null && com()) {
            this.oPJ.X(this.oPB.cjE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.ifS) {
            this.mHandler.removeCallbacks(this.igu);
            this.mHandler.postDelayed(this.igu, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.ifS) {
                this.mHandler.removeCallbacks(this.igt);
                this.mHandler.postDelayed(this.igt, 5000L);
                return;
            }
            return;
        }
        if (!this.ifR) {
            c(vVar);
        }
        if (!this.ifS) {
            this.mHandler.removeCallbacks(this.igt);
            this.mHandler.postDelayed(this.igt, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        if (this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null) {
            this.oPB.hM(this.oPB.Fp().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.aJZ != null && abVar.aJZ.logined == 1) {
            pf(false);
        } else if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.oPE.a(this.mSelectedPosition, this.oPB.Fp());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.ifR) {
                aj.e(abVar);
                a(abVar);
            }
            if (!this.ifS) {
                this.mHandler.removeCallbacks(this.hLH);
                this.mHandler.postDelayed(this.hLH, abVar.aJI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjh() {
        if (this.mTbPageContext != null && this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null) {
            this.oPB.a(this.oPB.Fp().mLiveInfo.live_id, this.bwo, this.hIs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        View view = null;
        nU(true);
        if (!com()) {
            this.oPB.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oPC != null) {
                this.oPC.Xl();
                this.oPC.clp();
            }
            if (abVar != null && abVar.mLiveInfo != null) {
                this.iga = abVar.mLiveInfo.live_id;
            }
            cnS();
            coe();
            cof();
            if (abVar != null) {
                if (this.oPK != null && this.oPK.ccg() != null) {
                    view = this.oPK.ccg().a(this.oPK.eaV().pageContext.getPageActivity(), abVar, z);
                }
                if (this.oPC != null) {
                    this.oPJ.a(this.oPC, view, abVar, z, this.oPB.cjE());
                }
                if (this.oPK != null) {
                    this.oPK.nU(false);
                    this.oPK.ccb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oPC != null) {
                    this.oPC.clr();
                }
                long j = abVar.mLiveInfo.live_id;
                long j2 = abVar.mLiveInfo.room_id;
                String str = abVar.mLiveInfo.feed_id;
                long j3 = abVar.aJD.userId;
                String str2 = abVar.aJD.userName;
            }
            coo();
            if (this.oPF != null) {
                this.oPF.a(this.aED, this.oPG);
            }
        }
    }

    private void coe() {
    }

    private void cof() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oPD);
        }
    }

    public void cog() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            coh();
        } else {
            coi();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oPB != null && this.oPB.Fp() != null) {
            alaLiveInfoData = this.oPB.Fp().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            coh();
        } else {
            coi();
        }
        this.oPD.setIsScrollable(!z && this.ign);
        if (this.oPK != null) {
            this.oPK.onKeyboardVisibilityChanged(z);
        }
        if (this.oES != null) {
            this.oES.onKeyboardVisibilityChanged(z);
        }
        if (z) {
            q.edU().setMaskBg(z);
        }
    }

    public void cs(int i) {
    }

    public void coh() {
        if (this.oPD != null) {
            com.baidu.live.utils.i.ae(this.oPD);
        }
    }

    public void coi() {
        if (this.oPD != null) {
            com.baidu.live.utils.i.af(this.oPD);
        }
    }

    public void onResume() {
        if (this.oPB != null) {
            this.oPB.cjo();
        }
        if (this.oPK != null) {
            this.oPK.enterForeground();
        }
        if (this.oPN != null) {
            this.oPN.onResume();
        }
        if (this.oPO != null) {
            this.oPO.onResume();
        }
        if (this.igU != null && !this.igU.hasFocus()) {
            this.igU.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.Bf().onResume();
    }

    public void onStart() {
        if (!this.igl) {
            if (this.ifS) {
                this.ifS = false;
                col();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void col() {
        cjh();
        cod();
        this.oPB.cjD();
        if (this.oPC != null) {
            this.oPC.ecE();
        }
        if (this.oPK != null) {
            this.oPK.ccf();
        }
        if (this.oPB != null && this.oPB.Fp() != null && this.oPB.Fp().mLiveInfo != null) {
            this.oPL.fL(this.oPB.Fp().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aED.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oPB != null) {
            this.oPB.cjp();
        }
        if (this.oPK != null) {
            this.oPK.enterBackground();
        }
        com.baidu.live.core.layer.b.Bf().onPause();
    }

    public void pc(boolean z) {
        this.ifS = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hLH);
        this.mHandler.removeCallbacks(this.oPQ);
        this.mHandler.removeCallbacks(this.igt);
        this.mHandler.removeCallbacks(this.igu);
        if (this.oPC != null) {
            this.oPC.ecD();
        }
        if (this.oPK != null) {
            this.oPK.cce();
        }
        this.oPL.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FE() != null) {
                al.FE().a(i, i2, intent, this.aED, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oPK != null) {
            this.oPK.onActivityResult(i, i2, intent);
        }
    }

    public boolean com() {
        return this.oPJ != null && this.oPJ.bUR();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.oPX);
        MessageManager.getInstance().unRegisterListener(this.igM);
        MessageManager.getInstance().unRegisterListener(this.oPY);
        MessageManager.getInstance().unRegisterListener(this.oPZ);
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.oQa);
        MessageManager.getInstance().unRegisterListener(this.oQb);
        MessageManager.getInstance().unRegisterListener(this.oPW);
        if (this.igA != null) {
            this.igA.release();
        }
        if (this.oPF != null) {
            this.oPF.onDestory();
        }
        q.edU().cLd();
        if (this.oPG != null) {
            this.oPG.reset();
        }
        if (this.oPK != null) {
            this.oPK.onDestroy();
        }
        if (this.oPE != null) {
            this.oPE.onDestroy();
        }
        this.oPC.Xl();
        if (this.oPC != null) {
            this.oPC.release();
            this.oPC = null;
        }
        if (this.oPJ != null) {
            this.oPJ.onDestroy();
        }
        if (this.igU != null) {
            this.igU.abandonAudioFocus();
        }
        if (this.oPM != null && this.oPB != null && this.oPB.Fp() != null) {
            if (this.oPM.liveId == this.oPB.Fp().mLiveInfo.live_id && this.oPM.startTime > 0) {
                this.oPM.endTime = System.currentTimeMillis();
                long j = this.oPM.endTime - this.oPM.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oPB.Fp().aKu.aVk, this.otherParams, this.mSelectedPosition + 1, this.bAf, this.oPB.Fp().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oPM = null;
        }
        if (this.oES != null) {
            this.oES.clx();
            this.oES = null;
        }
        if (this.oPB != null) {
            this.oPB.destory();
        }
        z.Fh().release();
        if (this.oPO != null) {
            this.oPO.release();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eeF().release();
        m.edI().a((m.a) null);
    }

    public void ph(boolean z) {
        this.igl = z;
    }

    public void con() {
        if (this.igb != null) {
            this.otherParams = this.igb.toString();
            if (this.oPB != null) {
                this.oPB.setOtherParams(this.otherParams);
            }
            if (this.oPK != null) {
                this.oPK.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oPJ != null) {
                this.oPJ.setOtherParams(this.otherParams);
            }
        }
    }

    public void coo() {
        if (this.igb != null) {
            String optString = this.igb.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.igb.put("tab", "live_jump");
                        this.igb.put("tag", "");
                        this.igb.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.igb.put("tab", "liveroom");
                        this.igb.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                con();
            }
        }
    }

    public void cop() {
        aj.Fz();
    }

    private void efY() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oPK.e((short) 2);
        } else {
            this.oPK.eaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oPS = bitmap;
            this.oPC.setBgImageBitmap(this.oPS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.oPC.setBgVideo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efZ() {
        if (this.oPS != null) {
            if (!this.oPS.isRecycled()) {
                this.oPS.recycle();
            }
            this.oPS = null;
        }
        aN(this.aED);
    }

    public boolean eec() {
        return this.igl;
    }
}

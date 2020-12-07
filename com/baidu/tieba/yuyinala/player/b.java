package com.baidu.tieba.yuyinala.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import com.baidu.live.ah.c;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.bp;
import com.baidu.live.data.cv;
import com.baidu.live.data.cz;
import com.baidu.live.data.q;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.al;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.u.g;
import com.baidu.live.utils.i;
import com.baidu.live.utils.s;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.yuyinala.liveroom.grabredpacket.d;
import com.baidu.tieba.yuyinala.liveroom.i.a;
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
/* loaded from: classes4.dex */
public class b extends BdBaseView<TbPageContext> {
    private w aFN;
    private CustomMessageListener bgy;
    private long brr;
    private String brs;
    private boolean bve;
    private AlaLastLiveroomInfo hRD;
    private boolean hRE;
    private boolean hRF;
    private boolean hRG;
    private boolean hRI;
    private ArrayList<AlaBroadcastGiftToastData> hRJ;
    private String hRK;
    private String hRN;
    private long hRO;
    private JSONObject hRP;
    private boolean hRQ;
    private boolean hRT;
    private boolean hRW;
    private boolean hRX;
    private String hRY;
    private boolean hRZ;
    CustomMessageListener hSA;
    private g hSI;
    private bp hSa;
    private boolean hSb;
    private boolean hSc;
    private Runnable hSh;
    private Runnable hSi;
    private Runnable hSj;
    private c hSo;
    com.baidu.live.liveroom.a.c hSv;
    ViewPager.OnPageChangeListener hSw;
    private String hdc;
    private ViewGroup huP;
    private LayerRootView huQ;
    private long huU;
    private Runnable hye;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String oAa;
    private String oAb;
    private CustomMessageListener oAc;
    CustomMessageListener oAd;
    private a.InterfaceC0926a onY;
    private AlaLiveView orc;
    private String otherParams;
    private d ozH;
    private a ozI;
    private com.baidu.tieba.yuyinala.liveroom.i.a ozJ;
    private AlaLiveRoomBlurPageLayout ozK;
    private AlaLoopViewPager ozL;
    private AlaLoopViewPagerAdapter ozM;
    private com.baidu.tieba.yuyinala.liveroom.d.a ozN;
    private com.baidu.tieba.yuyinala.liveroom.d.b ozO;
    private com.baidu.tieba.yuyinala.endliveroom.a ozP;
    private com.baidu.tieba.yuyinala.liveroom.c.b ozQ;
    private com.baidu.tieba.yuyinala.liveroom.task.b ozR;
    private StayTimeBean ozS;
    private com.baidu.tieba.yuyinala.liveroom.g.a ozT;
    private com.baidu.tieba.yuyinala.liveroom.n.c ozU;
    private Set<String> ozV;
    private int ozW;
    private Bitmap ozX;
    private boolean ozY;
    private String ozZ;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hRE = true;
        this.huU = 0L;
        this.hRF = false;
        this.bve = true;
        this.brs = "";
        this.mForumName = "";
        this.hRG = false;
        this.hRI = false;
        this.hRK = "0";
        this.mHandler = new Handler();
        this.hRO = -1L;
        this.otherParams = "";
        this.hRQ = false;
        this.ozR = com.baidu.tieba.yuyinala.liveroom.task.b.edX();
        this.hRT = false;
        this.hRX = false;
        this.hRZ = false;
        this.hSc = false;
        this.ozV = new HashSet();
        this.hye = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjf();
            }
        };
        this.hSh = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnQ();
            }
        };
        this.hSi = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.ozJ.cjB();
            }
        };
        this.ozW = 5000;
        this.ozZ = "";
        this.oAa = "";
        this.oAb = "";
        this.bgy = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.hSj = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.13
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
        this.hSv = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // com.baidu.live.liveroom.a.c
            public void cu(final boolean z) {
                if (!k.eeU().isShowing()) {
                    h.eeS().zM(false);
                    boolean aD = k.eeU().aD(b.this.mTbPageContext.getPageActivity());
                    k.eeU().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.15.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeW() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeX() {
                            if (z || b.this.ozQ == null || b.this.ozQ.ccd()) {
                                b.this.oA(true);
                                b.this.bZf();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeY() {
                        }
                    });
                    if (aD) {
                        if (z || b.this.ozQ == null || b.this.ozQ.ccd()) {
                            b.this.oA(true);
                            b.this.bZf();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cv(boolean z) {
                b.this.d(b.this.aFN, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.ozL != null) {
                    b.this.ozL.setIsScrollable(b.this.hSb && z);
                    b.this.ozL.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cw(boolean z) {
            }
        };
        this.hSw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.orc != null && b.this.ozJ != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.ozL.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.ozS != null && b.this.ozJ != null && b.this.ozJ.Iq() != null && b.this.ozJ.Iq().mLiveInfo != null && b.this.ozJ.Iq().aKL != null) {
                        if (b.this.ozS.liveId == b.this.ozJ.Iq().mLiveInfo.live_id && b.this.ozS.startTime > 0) {
                            b.this.ozS.endTime = System.currentTimeMillis();
                            long j = b.this.ozS.endTime - b.this.ozS.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.ozJ.Iq().aKL.aUg, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bve, b.this.ozJ.Iq().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.ozS = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.ozJ != null && b.this.ozJ.Iq() != null && b.this.ozJ.Iq().aKr != null) {
                            jSONObject.put("identity", b.this.ozJ.Iq().aKr.getUserTypeStr());
                        }
                        if (b.this.ozJ != null && b.this.ozJ.Iq() != null && b.this.ozJ.Iq().aKL != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.ozJ.Iq().aKL.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bve || b.this.ozJ.cjA() == null || ListUtils.getCount(b.this.ozJ.cjA()) > 1) {
                        if (b.this.ozJ.cjF() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.ozJ == null || !b.this.ozJ.cjF() || i2 >= 0) {
                            if (b.this.ozJ != null && b.this.ozJ.cjG() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.ozL.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.ozJ != null) {
                                b.this.ozJ.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nn(true);
                            b.this.ozK.cld();
                            b.this.ozK.Yj();
                            b.this.ozK.cle();
                            b.this.cob();
                            if (b.this.hSo != null) {
                                b.this.hSo.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.ozK = b.this.ozM.Ny(b.this.mSelectedPosition);
                            b.this.ozK.clf();
                            b.this.xG(i2);
                            b.this.egz();
                            b.this.NW(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.ozL.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.ozL.setCurrentItem(b.this.mSelectedPosition);
                    b.this.ozJ.g(b.this.ozJ.cjK());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.ozL != null && i == 0) {
                    com.baidu.live.d.BM().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.onY = new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.player.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0926a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.ozJ.Iq());
                } else if (i2 == 2) {
                    b.this.f(b.this.ozJ.bUt());
                } else if (i2 == 3) {
                    b.this.bp(i, str);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cnP();
                }
            }
        };
        this.hSA = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.ozJ != null && b.this.ozJ.Iq() != null && b.this.ozJ.Iq().aKr != null) {
                        if (l.longValue() == b.this.ozJ.Iq().aKr.userId) {
                            b.this.ozJ.Iq().aKr.isNewUser = false;
                            if (b.this.ozT != null) {
                                b.this.ozT.n(b.this.ozJ.Iq());
                            }
                        }
                    }
                }
            }
        };
        this.oAc = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.egC();
                    } else {
                        b.this.Y((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oAd = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cjf();
            }
        };
        this.huU = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.ozI = aVar;
        this.hRE = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.hSo = (c) runTask.getData();
        }
        this.ozJ = new com.baidu.tieba.yuyinala.liveroom.i.a(getPageContext());
        this.ozJ.a(this.onY);
        this.ozP = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hSA);
        MessageManager.getInstance().registerListener(this.oAc);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oAd);
        this.hSI = new g(tbPageContext.getPageActivity());
        this.hSI.setIPlayerAudioFocusCallBack(new com.baidu.live.u.a() { // from class: com.baidu.tieba.yuyinala.player.b.11
            @Override // com.baidu.live.u.a
            public void cD(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().muteOrUnmuteAudio(!z);
                }
            }
        });
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hRJ = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hRJ.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void aw(Intent intent) {
        Q(intent);
        this.brs = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.brs)) {
            this.brs = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hRN = intent.getStringExtra("room_id");
        this.brr = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.ozZ = new String(Base64.decode(optString.getBytes()));
                if (!this.ozZ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.ozZ = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.oAa = new String(Base64.decode(optString2.getBytes()));
                if (!this.oAa.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oAa = "";
                }
            }
            this.oAb = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.hRQ = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.ozJ.b((AlaLiveInfoCoreData) serializableExtra);
            this.hRQ = true;
        }
        TbConfig.liveScene = 2;
        ax(intent);
        this.hSb = this.hSa == null || !this.hSa.aRa;
        this.ozP.setOtherParams(this.otherParams);
        this.hRI = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        egw();
        cnt();
        this.mHandler.removeCallbacks(this.hSj);
        this.mHandler.postDelayed(this.hSj, 1000L);
    }

    private void ax(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hdc = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hRP = new JSONObject(stringExtra);
                if (this.hRP != null) {
                    String optString2 = this.hRP.optString("enterRoomId");
                    String optString3 = this.hRP.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hRN, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.brr + "", optString3))) {
                        String optString4 = this.hRP.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hRP.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hRQ) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brr;
                            alaLiveInfoCoreData.screenDirection = this.hRP.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.ozJ.b(alaLiveInfoCoreData);
                            this.hRQ = true;
                        }
                    }
                    String optString6 = this.hRP.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hSa = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.ozJ != null) {
                            this.ozJ.Ia(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hdc = jSONObject.optString("live_back_scheme");
                        this.hSa = new bp();
                        this.hSa.aRa = jSONObject.optInt("is_hot") == 1;
                        if (this.hSa.aRa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hSa.aRb = jSONObject.optString("task_id");
                        this.hSa.aQZ = TextUtils.isEmpty(this.hSa.aRb) ? false : true;
                        this.hSa.aRc = jSONObject.optInt("task_type");
                        this.hSa.aRd = jSONObject.optInt("task_im_count");
                        this.hSa.aRe = jSONObject.optLong("task_gift_total_price");
                        this.hSa.aRf = jSONObject.optLong("task_watch_time");
                        this.hSa.aRg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.ozO = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.ozO.setScheme(optString8);
                            this.ozO.setImageUrl(optString9);
                            this.ozO.setTitle(optString10);
                        }
                    }
                    this.hRK = this.hRP.optString("open_giftlist");
                    this.hRP.remove("cover");
                    this.hRP.remove("live_url");
                    this.hRP.remove("enterRoomId");
                    this.hRP.remove("enterLiveId");
                    this.hRP.remove("open_giftlist");
                    this.hRP.remove("extra");
                    this.otherParams = this.hRP.toString();
                    if (this.ozJ != null) {
                        this.ozJ.setOtherParams(this.otherParams);
                    }
                    this.hRP.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("source");
                    }
                    this.hSc = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hRP.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.ozJ != null) {
                        this.ozJ.xi(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hRD = new AlaLastLiveroomInfo();
                this.hRD.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brr), String.valueOf(this.hRN), null, cnJ());
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

    public void cnt() {
        boolean z = false;
        if (this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null && this.ozJ.Iq().mLiveInfo.room_id > 0) {
            this.ozJ.Wr(this.ozJ.Iq().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.hRN)) {
            this.ozJ.Wr(this.hRN);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.ozJ.at(this.uk, this.brs, this.mForumName);
            z = true;
        } else if (this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null && this.ozJ.Iq().mLiveInfo.live_id > 0) {
            this.ozJ.a(this.ozJ.Iq().mLiveInfo.live_id, false, this.brs, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.brs = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oA(false);
                return;
            }
            this.ozJ.at(this.uk, this.brs, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.hRN)) {
            this.ozJ.ID(this.hRN);
            z = true;
        } else if (this.brr > 0) {
            this.ozJ.a(this.brr, false, this.brs, "");
            z = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oA(false);
        }
        if (z) {
            egz();
        }
    }

    private void egw() {
        this.bve = true;
        this.hRF = false;
        egx();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.EY().j(this.huQ);
        this.ozQ = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.ozQ.a(this.hSv);
        this.ozQ.setOtherParams(this.otherParams);
        this.ozQ.nh(this.hSc);
        try {
            w wVar = new w();
            wVar.aLd = false;
            wVar.aKL = new cz();
            wVar.aKL.live_id = String.valueOf(this.brr);
            wVar.aKL.cover = "";
            wVar.aKL.room_name = ".....";
            wVar.aKL.aUg = "0";
            wVar.aKL.croom_id = "0";
            wVar.aKL.is_followed = true;
            wVar.aKL.bg_cover = this.oAa;
            wVar.mLiveInfo = new AlaLiveInfoData();
            wVar.aKr = new AlaLiveUserInfoData();
            wVar.aKs = new v();
            wVar.aKQ = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            wVar.bz(true);
            this.ozJ.setLiveShowData(wVar);
            cnx();
            cnu();
            this.ozQ.a(wVar, this.ozZ, this.oAb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void egx() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.ozL = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.ozL.setOnPageChangeListener(this.hSw);
        this.ozL.setBoundaryCaching(true);
        this.ozL.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.ozM = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.ozM.cgM();
        this.ozK = this.ozM.Nx(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oAa)) {
                this.ozK.setBgImageUrl(this.oAa, null);
            } else {
                this.ozK.setDefaultBg();
            }
            this.ozM.Nx(0).setDefaultBg();
            this.ozM.Nx(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.ozJ != null) {
            this.ozM.a(this.mSelectedPosition, this.ozJ.Iq());
        }
        this.ozL.setAdapter(this.ozM);
        this.ozL.setCurrentItem(this.mSelectedPosition);
        this.ozL.setIsScrollable(this.hSb);
        this.huP = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.huQ = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.ozL.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.14
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                w Iq;
                if ((b.this.ozJ == null || (Iq = b.this.ozJ.Iq()) == null || Iq.mLiveInfo == null || Iq.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.ozY = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.ozJ == null || !b.this.ozJ.cjF() || rawY <= 0.0f) {
                            if (b.this.ozJ == null || !b.this.ozJ.cjG() || rawY >= 0.0f) {
                                if (k.eeU().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.eeS().zM(false);
                                k.eeU().aD(b.this.mTbPageContext.getPageActivity());
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
            public boolean Nw(int i) {
                w Iq;
                if (b.this.ozJ == null || (Iq = b.this.ozJ.Iq()) == null || Iq.mLiveInfo == null || Iq.mLiveInfo.live_status != 2) {
                    k.eeU().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeW() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeX() {
                            if (b.this.ozL != null) {
                                if (b.this.ozJ == null || !b.this.ozJ.cjF() || !b.this.ozY) {
                                    if (b.this.ozJ == null || !b.this.ozJ.cjG() || b.this.ozY) {
                                        int currentItem = b.this.ozL.getCurrentItem();
                                        if (b.this.ozY) {
                                            if (currentItem == 0) {
                                                b.this.ozL.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.ozL.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.ozL.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.ozL.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.ozL.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.ozL.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeY() {
                        }
                    });
                    if (b.this.ozJ != null && b.this.ozJ.cjF() && b.this.ozY) {
                        return true;
                    }
                    if (b.this.ozJ == null || !b.this.ozJ.cjG() || b.this.ozY) {
                        if (k.eeU().isShowing()) {
                            return false;
                        }
                        h.eeS().zM(false);
                        return k.eeU().aD(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        o efd = o.efd();
        efd.a(this.mTbPageContext, this.ozK, rect);
        efd.a(this);
    }

    private void cnu() {
        this.ozN = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.huP);
    }

    private void d(Rect rect) {
        this.orc = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.orc.setSwipeClearEnable(false);
        this.orc.hFs = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.ozK.a(this.orc, layoutParams);
    }

    private void cnx() {
        if (this.ozJ != null && this.ozJ.Iq() != null) {
            this.aFN = this.ozJ.Iq();
            if (this.aFN.mLiveInfo != null) {
                a(this.aFN.mLiveInfo, this.hRQ);
                if (this.aFN.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hRG);
                    }
                    if (this.ozQ != null) {
                        this.ozQ.a(this.mTbPageContext, this.orc, null, this.ozK, this.ozJ, this.brs, this.hRI, this.huU, this.hRJ, this.hSa);
                        egB();
                    }
                }
            }
        }
    }

    private void cnF() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hRI || !this.hSb) {
                this.ozL.setIsScrollable(false);
            } else {
                this.ozL.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.EY().onBackPressed() && ((this.ozQ == null || !this.ozQ.onKeyDown(i, keyEvent)) && (this.ozQ == null || !this.ozQ.ccc()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnF();
            } else if (!k.eeU().aD(this.mTbPageContext.getPageActivity())) {
                h.eeS().zM(false);
            } else if (this.ozQ == null || this.ozQ.ccd()) {
                oA(true);
                bZf();
            }
        }
        return true;
    }

    public void bZf() {
        if (!TextUtils.isEmpty(this.hdc)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hdc);
                this.hdc = null;
            }
        }
    }

    public void oA(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        nn(!z);
        com.baidu.live.core.layer.b.EY().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnH();
        long j = -1;
        if (this.ozJ != null && this.ozJ.cjK() != null) {
            j = this.ozJ.cjK().room_id;
        }
        this.ozI.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void nn(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hRD = null;
        if (al.IE() != null) {
            al.IE().ID();
        }
        com.baidu.live.core.layer.b.EY().EZ();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().cV(this.orc);
        if (this.hSo != null) {
            this.hSo.release();
        }
        if (this.ozT != null) {
            this.ozT.release();
        }
        this.hSa = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ozL);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ozJ != null) {
            this.ozJ.Ia(null);
            AlaLiveInfoData cjK = this.ozJ.cjK();
            if (cjK != null) {
                this.ozJ.fD(cjK.live_id);
            }
        }
        this.ozR.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnG();
        if (this.ozQ != null) {
            this.ozQ.nn(z);
        }
        this.hRT = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Pd().bqI != null) {
            com.baidu.live.liveroom.a.b.Pd().bqI.b(this.aFN.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().aCN();
        }
        aj.hs("");
    }

    private void cnG() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.aKL != null && this.ozJ.ooh) {
                this.ozK.setBgImageUrl(wVar.aKL.bg_cover, null);
            }
            ay(wVar);
            this.aFN = wVar;
            if (this.ozQ != null) {
                this.ozQ.a(wVar);
            }
        }
    }

    private void ay(final w wVar) {
        List<cv.a> list;
        if (wVar.aKM != null && wVar.aKL != null && (list = wVar.aKM.aTR) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final cv.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aTU + aVar.aTW + aVar.aTY + wVar.aKL.aUg;
                    if (!this.ozV.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aTU - (System.currentTimeMillis() / 1000));
                        this.ozV.add(str);
                        if (this.ozH == null) {
                            this.ozH = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!egy() || StringUtils.isNull(aVar.aTW, true) || StringUtils.isNull(aVar.aTY, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.ozH.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.ozH.a(z, aVar.aTU, aVar.aTW, aVar.aTY, wVar.aKL.aUg, wVar.aKL.live_id, wVar.aKL.croom_id, aVar.aTV, aVar.aTX, wVar.aKM.aTQ + "", wVar.aKL.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.ozH.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.ozH.a(false, aVar.aTU, aVar.aTW, aVar.aTY, wVar.aKL.aUg, wVar.aKL.live_id, wVar.aKL.croom_id, aVar.aTV, aVar.aTX, wVar.aKM.aTQ + "", wVar.aKL.is_followed);
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

    private boolean egy() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null || com.baidu.live.ae.a.RB().brA.aOJ.aRX == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().a(com.baidu.live.ae.a.RB().brA.aOJ.aRX.FW(), true);
    }

    private void c(q qVar) {
        if (this.ozQ != null) {
            this.ozQ.c(qVar);
        }
    }

    private void S(w wVar) {
        this.aFN = wVar;
    }

    private void cnI() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.ozL.setIsScrollable(false);
            this.hSb = false;
        }
        if (this.aFN != null) {
            a(this.aFN.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.ozK.a(this.orc, null);
            a(this.ozK, this.aFN.mLiveInfo, this.bve);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.feed_id), cnJ());
            if (com.baidu.live.liveroom.a.b.Pd().bqI != null) {
                com.baidu.live.liveroom.a.b.Pd().bqI.a(this.aFN.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
                String str = "normal";
                if (this.aFN != null && this.aFN.aKQ != null && this.aFN.aKQ.getRoomMode() == 1) {
                    str = "dating";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bve = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cnJ() {
        if (this.hRP == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hRP.optString("source");
            String optString2 = this.hRP.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hRP.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hRP.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hRP.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        o efd = o.efd();
        ViewGroup eff = efd.eff();
        if (eff != null && eff.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cu(eff)) {
                        ((ViewGroup) eff.getParent()).removeView(eff);
                        alaLiveRoomBlurPageLayout.d(eff, null);
                        efd.efe();
                    } else if (efd != null) {
                        efd.efe();
                    }
                } else if (efd != null) {
                    efd.efe();
                }
            } else if (efd != null) {
                efd.efe();
            }
        } else if (eff != null && eff.getParent() == null) {
            alaLiveRoomBlurPageLayout.d(eff, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        ViewGroup eff = o.efd().eff();
        if (eff != null) {
            eff.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = com.baidu.live.utils.o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = com.baidu.live.utils.o.v(this.mTbPageContext.getPageActivity());
                int bm = com.baidu.live.utils.o.bm(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bm + i;
                } else {
                    dimensionPixelSize = bm + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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
        this.bve = true;
    }

    public boolean cnL() {
        return this.bve;
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
        ViewGroup eff = o.efd().eff();
        if (eff != null) {
            int i2 = eff.getLayoutParams().width;
            int i3 = eff.getLayoutParams().height;
            int i4 = eff.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) eff.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.orc != null) {
                this.orc.setLayoutParams(c);
            }
            if (this.ozK != null) {
                this.ozK.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ozP != null) {
                this.ozP.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ozQ != null) {
                this.ozQ.l(c.width, c.height, realScreenOrientation);
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
                this.ozJ.Wr(alaLiveInfoData.room_id + "");
            }
            this.ozJ.a(alaLiveInfoData.live_id, true, this.brs, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = this.ozJ.Iq();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Iq.aKL.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : MapBundleKey.OfflineMapKey.OFFLINE_UPDATE);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void xG(int i) {
        if (i < 0) {
            this.ozJ.xj(this.ozJ.cjH() - 1);
        } else if (i > 0) {
            this.ozJ.xj(this.ozJ.cjH() + 1);
        }
        if (this.ozQ != null) {
            this.ozQ.a(this.ozK);
        }
        this.ozM.a(this.mSelectedPosition, cnN(), this.aFN);
        this.ozM.b(this.mSelectedPosition, cnO(), this.aFN);
        if (this.ozJ != null) {
            AlaLiveInfoData cjK = this.ozJ.cjK();
            if (cjK != null) {
                cjK.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cjK);
                a(this.ozK, cjK, this.bve);
                this.bve = false;
                if (this.ozQ != null) {
                    this.ozQ.a(this.mTbPageContext, this.orc, null, this.ozK, this.ozJ, this.brs, this.hRI, this.huU, null, this.hSa);
                    egB();
                }
                a(cjK, false);
            }
            i(cjK);
            if (this.ozQ != null) {
                this.ozQ.cca();
            }
            this.ozJ.g(cjK);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.orc.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.orc.findViewById(a.f.ala_live_footer_view);
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        try {
            w wVar = new w();
            wVar.aLd = false;
            wVar.aKL = new cz();
            if (alaLiveInfoData != null) {
                this.ozK.setBgImageUrl(alaLiveInfoData.bg_cover, null);
                wVar.aKL.bg_cover = alaLiveInfoData.bg_cover;
                wVar.aKL.live_id = String.valueOf(alaLiveInfoData.live_id);
                wVar.aKL.cover = alaLiveInfoData.cover;
                wVar.aKL.aUg = String.valueOf(alaLiveInfoData.room_id);
                wVar.aKL.croom_id = alaLiveInfoData.croom_id;
                wVar.aKL.is_followed = alaLiveInfoData.is_followed;
                wVar.aKL.room_name = alaLiveInfoData.room_name;
            }
            wVar.mLiveInfo = new AlaLiveInfoData();
            if (alaLiveInfoData != null) {
                wVar.mLiveInfo.live_id = alaLiveInfoData.live_id;
            }
            wVar.aKr = new AlaLiveUserInfoData();
            wVar.aKs = new v();
            wVar.aKQ = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            wVar.bz(true);
            this.ozJ.setLiveShowData(wVar);
            wVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.ozQ != null) {
                this.ozQ.a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ozK.a(this.orc, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egz() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.efI().bes();
    }

    private AlaLiveInfoData cnN() {
        List<AlaLiveInfoData> cjA = this.ozJ.cjA();
        if (cjA == null || cjA.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        int cjH = this.ozJ.cjH();
        int size = cjA.size();
        return cjA.get(((cjH + size) - 1) % size);
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjA = this.ozJ.cjA();
        if (cjA == null || cjA.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        return cjA.get((this.ozJ.cjH() + 1) % cjA.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hRG) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oA(false);
            return;
        }
        w Iq = this.ozJ.Iq();
        S(Iq);
        if (Iq != null && Iq.aKL != null) {
            this.ozK.setBgImageUrl(Iq.aKL.bg_cover, null);
        }
        egA();
        this.ozJ.cjB();
        if (this.bve) {
            this.ozJ.ob(false);
        }
        this.huU = System.currentTimeMillis() / 1000;
        if (this.ozQ != null) {
            this.ozQ.a(this.mTbPageContext, this.orc, null, this.ozK, this.ozJ, this.brs, this.hRI, this.huU, this.hRJ, this.hSa);
            egB();
        }
        cnI();
        if (Iq != null && Iq.mLiveInfo != null && Iq.mLiveInfo.live_status == 2) {
            this.ozM.a(this.mSelectedPosition, this.ozJ.Iq());
            d(Iq, false);
            this.bve = false;
            return;
        }
        boolean z = (this.ozQ == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ag.a.b.Sm().cO(com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aOL && Iq != null && Iq.aKP);
        aj.d(Iq);
        if (z) {
            if (!this.hRX || !TextUtils.equals(s.WC(), this.hRY)) {
                aj.b(getPageContext(), false);
                e.RP().RQ();
                this.hRX = true;
                this.hRY = s.WC();
            }
            aj.Ix();
        }
        if (this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null) {
            this.ozJ.hN(this.ozJ.Iq().mLiveInfo.live_id);
            this.hRT = true;
        }
        if (this.ozQ != null) {
            this.ozQ.b(this.hRD);
            this.ozQ.nm(TextUtils.equals(this.hRK, "1"));
            this.hRK = "";
        }
        if (this.ozN != null) {
            this.ozN.a(this.aFN, this.ozO);
        }
        a(this.ozJ.Iq());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.ozJ.Iq() != null && b.this.ozJ.Iq().mLiveInfo != null) {
                    b.this.ozJ.a(b.this.ozJ.Iq().mLiveInfo.live_id, b.this.brs, b.this.huU);
                }
            }
        });
        this.bve = false;
        if (z && this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null && this.ozJ.Iq().aJV != null && this.ozQ != null) {
            long j = this.ozJ.Iq().mLiveInfo.live_id;
            long j2 = this.ozJ.Iq().mLiveInfo.room_id;
            String str2 = this.ozJ.Iq().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.IE() != null) {
                    al.IE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.hSo != null) {
                    this.hSo.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.LY() != null) {
                com.baidu.live.guardclub.e.LY().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.ozT == null) {
                this.ozT = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.ozT.a(this.mTbPageContext.getPageActivity(), this.ozJ.Iq(), this.otherParams);
        }
        if (this.ozU == null) {
            this.ozU = new com.baidu.tieba.yuyinala.liveroom.n.c(this.mTbPageContext);
        }
        if (z && this.ozJ.Iq() != null && this.ozJ.Iq().aKr != null && !this.hRW) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.ozU.a(this.ozJ.Iq(), this.ozJ.Iq().aKr.userId);
                this.hRW = true;
            }
        }
    }

    private void egA() {
        try {
            if (this.ozJ != null && this.ozJ.Iq() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.ozJ.Iq().aKr.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ozJ.Iq().aKL.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bve) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.ozJ.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozJ.Iq().mLiveInfo.feed_id);
                }
                if (!this.ozJ.cjA().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.ozJ.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozJ.Iq().mLiveInfo.feed_id);
                    this.ozJ.cjA().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.ozJ.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozJ.Iq().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.ozJ.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozJ.Iq().mLiveInfo.feed_id);
                this.ozS = new StayTimeBean();
                this.ozS.liveId = this.ozJ.Iq().mLiveInfo.live_id;
                this.ozS.roomId = this.ozJ.Iq().mLiveInfo.room_id;
                this.ozS.vid = this.ozJ.Iq().mLiveInfo.feed_id;
                this.ozS.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnP() {
        if (this.hRE) {
            this.ozM.a(this.mSelectedPosition, cnN(), this.aFN);
            this.ozM.b(this.mSelectedPosition, cnO(), this.aFN);
            this.hRE = false;
        }
        if (this.ozP != null && cnZ()) {
            this.ozP.ad(this.ozJ.cjC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.hRG) {
            this.mHandler.removeCallbacks(this.hSi);
            this.mHandler.postDelayed(this.hSi, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hRG) {
                this.mHandler.removeCallbacks(this.hSh);
                this.mHandler.postDelayed(this.hSh, 5000L);
                return;
            }
            return;
        }
        if (!this.hRF) {
            c(qVar);
        }
        if (!this.hRG) {
            this.mHandler.removeCallbacks(this.hSh);
            this.mHandler.postDelayed(this.hSh, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null) {
            this.ozJ.hN(this.ozJ.Iq().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(w wVar) {
        if (wVar != null && wVar.aKr != null && wVar.aKr.logined == 1) {
            oA(false);
        } else if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.ozM.a(this.mSelectedPosition, this.ozJ.Iq());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hRF) {
                aj.d(wVar);
                a(wVar);
            }
            if (!this.hRG) {
                this.mHandler.removeCallbacks(this.hye);
                this.mHandler.postDelayed(this.hye, wVar.aKa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        if (this.mTbPageContext != null && this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null) {
            this.ozJ.a(this.ozJ.Iq().mLiveInfo.live_id, this.brs, this.huU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        View view = null;
        nn(true);
        if (!cnZ()) {
            this.ozJ.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.ozK != null) {
                this.ozK.Yj();
                this.ozK.cld();
            }
            if (wVar != null && wVar.mLiveInfo != null) {
                this.hRO = wVar.mLiveInfo.live_id;
            }
            cnF();
            cnR();
            cnS();
            if (wVar != null) {
                if (this.ozQ != null && this.ozQ.ccg() != null) {
                    view = this.ozQ.ccg().a(this.ozQ.eda().pageContext.getPageActivity(), wVar, z);
                }
                if (this.ozK != null) {
                    this.ozP.a(this.ozK, view, wVar, z, this.ozJ.cjC());
                }
                if (this.ozQ != null) {
                    this.ozQ.nn(false);
                    this.ozQ.ccb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.ozK != null) {
                    this.ozK.clf();
                }
                long j = wVar.mLiveInfo.live_id;
                long j2 = wVar.mLiveInfo.room_id;
                String str = wVar.mLiveInfo.feed_id;
                long j3 = wVar.aJV.userId;
                String str2 = wVar.aJV.userName;
            }
            cob();
            if (this.ozN != null) {
                this.ozN.a(this.aFN, this.ozO);
            }
        }
    }

    private void cnR() {
    }

    private void cnS() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ozL);
        }
    }

    public void cnT() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.ozJ != null && this.ozJ.Iq() != null) {
            alaLiveInfoData = this.ozJ.Iq().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        this.ozL.setIsScrollable(!z && this.hSb);
        if (this.ozQ != null) {
            this.ozQ.onKeyboardVisibilityChanged(z);
        }
        if (this.orc != null) {
            this.orc.onKeyboardVisibilityChanged(z);
        }
        o.efd().setMaskBg(z);
    }

    public void dX(int i) {
    }

    public void cnU() {
        if (this.ozL != null) {
            i.ae(this.ozL);
        }
    }

    public void cnV() {
        if (this.ozL != null) {
            i.af(this.ozL);
        }
    }

    public void onResume() {
        if (this.ozJ != null) {
            this.ozJ.cjm();
        }
        if (this.ozQ != null) {
            this.ozQ.enterForeground();
        }
        if (this.ozT != null) {
            this.ozT.onResume();
        }
        if (this.ozU != null) {
            this.ozU.onResume();
        }
        if (this.hSI != null && !this.hSI.hasFocus()) {
            this.hSI.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.EY().onResume();
    }

    public void onStart() {
        if (!this.hRZ) {
            if (this.hRG) {
                this.hRG = false;
                cnY();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cnY() {
        cjf();
        cnQ();
        this.ozJ.cjB();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
        }
        if (this.ozQ != null) {
            this.ozQ.ccf();
        }
        if (this.ozJ != null && this.ozJ.Iq() != null && this.ozJ.Iq().mLiveInfo != null) {
            this.ozR.fG(this.ozJ.Iq().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aFN.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.ozJ != null) {
            this.ozJ.cjn();
        }
        if (this.ozQ != null) {
            this.ozQ.enterBackground();
        }
        com.baidu.live.core.layer.b.EY().onPause();
    }

    public void ox(boolean z) {
        this.hRG = true;
        oB(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oB(boolean z) {
        this.mHandler.removeCallbacks(this.hye);
        this.mHandler.removeCallbacks(this.hSh);
        this.mHandler.removeCallbacks(this.hSi);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || !z) {
        }
        if (this.ozQ != null) {
            this.ozQ.cce();
        }
        this.ozR.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.IE() != null) {
                al.IE().a(i, i2, intent, this.aFN, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ozQ != null) {
            this.ozQ.onActivityResult(i, i2, intent);
        }
    }

    private void az(w wVar) {
        if (wVar != null) {
            if (wVar.aKL != null && !TextUtils.isEmpty(wVar.aKL.bg_cover)) {
                this.ozK.setBgImageUrl(wVar.aKL.bg_cover, null);
            } else if (wVar.aJV != null && !TextUtils.isEmpty(wVar.aJV.portrait)) {
                this.ozK.setBgImageUrl(wVar.aJV.portrait, 12, null);
            }
        }
    }

    public boolean cnZ() {
        return this.ozP != null && this.ozP.bVk();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hSA);
        MessageManager.getInstance().unRegisterListener(this.oAc);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oAd);
        if (this.hSo != null) {
            this.hSo.release();
        }
        if (this.ozN != null) {
            this.ozN.onDestory();
        }
        o.efd().cKt();
        if (this.ozO != null) {
            this.ozO.reset();
        }
        if (this.ozQ != null) {
            this.ozQ.onDestroy();
        }
        if (this.ozM != null) {
            this.ozM.onDestroy();
        }
        this.ozK.Yj();
        if (this.ozK != null) {
            this.ozK.release();
            this.ozK = null;
        }
        if (this.ozP != null) {
            this.ozP.onDestroy();
        }
        if (this.hSI != null) {
            this.hSI.abandonAudioFocus();
        }
        if (this.ozS != null && this.ozJ != null && this.ozJ.Iq() != null) {
            if (this.ozS.liveId == this.ozJ.Iq().mLiveInfo.live_id && this.ozS.startTime > 0) {
                this.ozS.endTime = System.currentTimeMillis();
                long j = this.ozS.endTime - this.ozS.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.ozJ.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozJ.Iq().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.ozS = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ozJ != null) {
                jSONObject.put("identity", this.ozJ.Iq().aKr.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ozJ.Iq().aKL.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.orc != null) {
            this.orc.cll();
            this.orc = null;
        }
        if (this.ozJ != null) {
            this.ozJ.destory();
        }
        z.Ii().release();
        if (this.ozU != null) {
            this.ozU.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
    }

    public void oC(boolean z) {
        this.hRZ = z;
    }

    public void coa() {
        if (this.hRP != null) {
            this.otherParams = this.hRP.toString();
            if (this.ozJ != null) {
                this.ozJ.setOtherParams(this.otherParams);
            }
            if (this.ozQ != null) {
                this.ozQ.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ozP != null) {
                this.ozP.setOtherParams(this.otherParams);
            }
        }
    }

    public void cob() {
        if (this.hRP != null) {
            String optString = this.hRP.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hRP.put("tab", "live_jump");
                        this.hRP.put("tag", "");
                        this.hRP.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hRP.put("tab", "liveroom");
                        this.hRP.put("tag", "");
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
        aj.IA();
    }

    private void egB() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ozQ.e((short) 2);
        } else {
            this.ozQ.edb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.ozX = bitmap;
            this.ozK.setBgImageBitmap(this.ozX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egC() {
        if (this.ozX != null) {
            if (!this.ozX.isRecycled()) {
                this.ozX.recycle();
            }
            this.ozX = null;
            az(this.aFN);
        }
    }

    public boolean efk() {
        return this.hRZ;
    }
}

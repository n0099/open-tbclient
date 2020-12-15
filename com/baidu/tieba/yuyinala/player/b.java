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
    private AlaLastLiveroomInfo hRF;
    private boolean hRG;
    private boolean hRH;
    private boolean hRI;
    private boolean hRK;
    private ArrayList<AlaBroadcastGiftToastData> hRL;
    private String hRM;
    private String hRP;
    private long hRQ;
    private JSONObject hRR;
    private boolean hRS;
    private boolean hRV;
    private boolean hRY;
    private boolean hRZ;
    CustomMessageListener hSC;
    private g hSK;
    private String hSa;
    private boolean hSb;
    private bp hSc;
    private boolean hSd;
    private boolean hSe;
    private Runnable hSj;
    private Runnable hSk;
    private Runnable hSl;
    private c hSq;
    com.baidu.live.liveroom.a.c hSx;
    ViewPager.OnPageChangeListener hSy;
    private String hde;
    private ViewGroup huR;
    private LayerRootView huS;
    private long huW;
    private Runnable hyg;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private boolean oAa;
    private String oAb;
    private String oAc;
    private String oAd;
    private CustomMessageListener oAe;
    CustomMessageListener oAf;
    private a.InterfaceC0926a ooa;
    private AlaLiveView ore;
    private String otherParams;
    private d ozJ;
    private a ozK;
    private com.baidu.tieba.yuyinala.liveroom.i.a ozL;
    private AlaLiveRoomBlurPageLayout ozM;
    private AlaLoopViewPager ozN;
    private AlaLoopViewPagerAdapter ozO;
    private com.baidu.tieba.yuyinala.liveroom.d.a ozP;
    private com.baidu.tieba.yuyinala.liveroom.d.b ozQ;
    private com.baidu.tieba.yuyinala.endliveroom.a ozR;
    private com.baidu.tieba.yuyinala.liveroom.c.b ozS;
    private com.baidu.tieba.yuyinala.liveroom.task.b ozT;
    private StayTimeBean ozU;
    private com.baidu.tieba.yuyinala.liveroom.g.a ozV;
    private com.baidu.tieba.yuyinala.liveroom.n.c ozW;
    private Set<String> ozX;
    private int ozY;
    private Bitmap ozZ;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hRG = true;
        this.huW = 0L;
        this.hRH = false;
        this.bve = true;
        this.brs = "";
        this.mForumName = "";
        this.hRI = false;
        this.hRK = false;
        this.hRM = "0";
        this.mHandler = new Handler();
        this.hRQ = -1L;
        this.otherParams = "";
        this.hRS = false;
        this.ozT = com.baidu.tieba.yuyinala.liveroom.task.b.edY();
        this.hRV = false;
        this.hRZ = false;
        this.hSb = false;
        this.hSe = false;
        this.ozX = new HashSet();
        this.hyg = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjg();
            }
        };
        this.hSj = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnR();
            }
        };
        this.hSk = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.ozL.cjC();
            }
        };
        this.ozY = 5000;
        this.oAb = "";
        this.oAc = "";
        this.oAd = "";
        this.bgy = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.hSl = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.13
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
        this.hSx = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // com.baidu.live.liveroom.a.c
            public void cu(final boolean z) {
                if (!k.eeV().isShowing()) {
                    h.eeT().zM(false);
                    boolean aD = k.eeV().aD(b.this.mTbPageContext.getPageActivity());
                    k.eeV().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.15.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeX() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeY() {
                            if (z || b.this.ozS == null || b.this.ozS.cce()) {
                                b.this.oA(true);
                                b.this.bZg();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeZ() {
                        }
                    });
                    if (aD) {
                        if (z || b.this.ozS == null || b.this.ozS.cce()) {
                            b.this.oA(true);
                            b.this.bZg();
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
                if (b.this.ozN != null) {
                    b.this.ozN.setIsScrollable(b.this.hSd && z);
                    b.this.ozN.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cw(boolean z) {
            }
        };
        this.hSy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.ore != null && b.this.ozL != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.ozN.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.ozU != null && b.this.ozL != null && b.this.ozL.Iq() != null && b.this.ozL.Iq().mLiveInfo != null && b.this.ozL.Iq().aKL != null) {
                        if (b.this.ozU.liveId == b.this.ozL.Iq().mLiveInfo.live_id && b.this.ozU.startTime > 0) {
                            b.this.ozU.endTime = System.currentTimeMillis();
                            long j = b.this.ozU.endTime - b.this.ozU.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.ozL.Iq().aKL.aUg, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bve, b.this.ozL.Iq().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.ozU = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.ozL != null && b.this.ozL.Iq() != null && b.this.ozL.Iq().aKr != null) {
                            jSONObject.put("identity", b.this.ozL.Iq().aKr.getUserTypeStr());
                        }
                        if (b.this.ozL != null && b.this.ozL.Iq() != null && b.this.ozL.Iq().aKL != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.ozL.Iq().aKL.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bve || b.this.ozL.cjB() == null || ListUtils.getCount(b.this.ozL.cjB()) > 1) {
                        if (b.this.ozL.cjG() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.ozL == null || !b.this.ozL.cjG() || i2 >= 0) {
                            if (b.this.ozL != null && b.this.ozL.cjH() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.ozN.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.ozL != null) {
                                b.this.ozL.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.nn(true);
                            b.this.ozM.cle();
                            b.this.ozM.Yj();
                            b.this.ozM.clf();
                            b.this.coc();
                            if (b.this.hSq != null) {
                                b.this.hSq.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.ozM = b.this.ozO.Ny(b.this.mSelectedPosition);
                            b.this.ozM.clg();
                            b.this.xG(i2);
                            b.this.egA();
                            b.this.NW(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.ozN.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.ozN.setCurrentItem(b.this.mSelectedPosition);
                    b.this.ozL.g(b.this.ozL.cjL());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.ozN != null && i == 0) {
                    com.baidu.live.d.BM().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.ooa = new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.player.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0926a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.ozL.Iq());
                } else if (i2 == 2) {
                    b.this.f(b.this.ozL.bUu());
                } else if (i2 == 3) {
                    b.this.bp(i, str);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cnQ();
                }
            }
        };
        this.hSC = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.ozL != null && b.this.ozL.Iq() != null && b.this.ozL.Iq().aKr != null) {
                        if (l.longValue() == b.this.ozL.Iq().aKr.userId) {
                            b.this.ozL.Iq().aKr.isNewUser = false;
                            if (b.this.ozV != null) {
                                b.this.ozV.n(b.this.ozL.Iq());
                            }
                        }
                    }
                }
            }
        };
        this.oAe = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.egD();
                    } else {
                        b.this.Y((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.oAf = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cjg();
            }
        };
        this.huW = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.ozK = aVar;
        this.hRG = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.hSq = (c) runTask.getData();
        }
        this.ozL = new com.baidu.tieba.yuyinala.liveroom.i.a(getPageContext());
        this.ozL.a(this.ooa);
        this.ozR = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hSC);
        MessageManager.getInstance().registerListener(this.oAe);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oAf);
        this.hSK = new g(tbPageContext.getPageActivity());
        this.hSK.setIPlayerAudioFocusCallBack(new com.baidu.live.u.a() { // from class: com.baidu.tieba.yuyinala.player.b.11
            @Override // com.baidu.live.u.a
            public void cD(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(!z);
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
                        this.hRL = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hRL.add(alaBroadcastGiftToastData);
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
        this.hRP = intent.getStringExtra("room_id");
        this.brr = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.oAb = new String(Base64.decode(optString.getBytes()));
                if (!this.oAb.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oAb = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.oAc = new String(Base64.decode(optString2.getBytes()));
                if (!this.oAc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.oAc = "";
                }
            }
            this.oAd = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.hRS = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.ozL.b((AlaLiveInfoCoreData) serializableExtra);
            this.hRS = true;
        }
        TbConfig.liveScene = 2;
        ax(intent);
        this.hSd = this.hSc == null || !this.hSc.aRa;
        this.ozR.setOtherParams(this.otherParams);
        this.hRK = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        egx();
        cnu();
        this.mHandler.removeCallbacks(this.hSl);
        this.mHandler.postDelayed(this.hSl, 1000L);
    }

    private void ax(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hde = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hRR = new JSONObject(stringExtra);
                if (this.hRR != null) {
                    String optString2 = this.hRR.optString("enterRoomId");
                    String optString3 = this.hRR.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hRP, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.brr + "", optString3))) {
                        String optString4 = this.hRR.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hRR.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hRS) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brr;
                            alaLiveInfoCoreData.screenDirection = this.hRR.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.ozL.b(alaLiveInfoCoreData);
                            this.hRS = true;
                        }
                    }
                    String optString6 = this.hRR.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hSc = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.ozL != null) {
                            this.ozL.Ia(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hde = jSONObject.optString("live_back_scheme");
                        this.hSc = new bp();
                        this.hSc.aRa = jSONObject.optInt("is_hot") == 1;
                        if (this.hSc.aRa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hSc.aRb = jSONObject.optString("task_id");
                        this.hSc.aQZ = TextUtils.isEmpty(this.hSc.aRb) ? false : true;
                        this.hSc.aRc = jSONObject.optInt("task_type");
                        this.hSc.aRd = jSONObject.optInt("task_im_count");
                        this.hSc.aRe = jSONObject.optLong("task_gift_total_price");
                        this.hSc.aRf = jSONObject.optLong("task_watch_time");
                        this.hSc.aRg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.ozQ = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.ozQ.setScheme(optString8);
                            this.ozQ.setImageUrl(optString9);
                            this.ozQ.setTitle(optString10);
                        }
                    }
                    this.hRM = this.hRR.optString("open_giftlist");
                    this.hRR.remove("cover");
                    this.hRR.remove("live_url");
                    this.hRR.remove("enterRoomId");
                    this.hRR.remove("enterLiveId");
                    this.hRR.remove("open_giftlist");
                    this.hRR.remove("extra");
                    this.otherParams = this.hRR.toString();
                    if (this.ozL != null) {
                        this.ozL.setOtherParams(this.otherParams);
                    }
                    this.hRR.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("source");
                    }
                    this.hSe = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hRR.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.ozL != null) {
                        this.ozL.xi(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hRF = new AlaLastLiveroomInfo();
                this.hRF.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brr), String.valueOf(this.hRP), null, cnK());
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

    public void cnu() {
        boolean z = false;
        if (this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null && this.ozL.Iq().mLiveInfo.room_id > 0) {
            this.ozL.Wr(this.ozL.Iq().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.hRP)) {
            this.ozL.Wr(this.hRP);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.ozL.at(this.uk, this.brs, this.mForumName);
            z = true;
        } else if (this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null && this.ozL.Iq().mLiveInfo.live_id > 0) {
            this.ozL.a(this.ozL.Iq().mLiveInfo.live_id, false, this.brs, this.mForumName);
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
            this.ozL.at(this.uk, this.brs, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.hRP)) {
            this.ozL.ID(this.hRP);
            z = true;
        } else if (this.brr > 0) {
            this.ozL.a(this.brr, false, this.brs, "");
            z = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oA(false);
        }
        if (z) {
            egA();
        }
    }

    private void egx() {
        this.bve = true;
        this.hRH = false;
        egy();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.EY().j(this.huS);
        this.ozS = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.ozS.a(this.hSx);
        this.ozS.setOtherParams(this.otherParams);
        this.ozS.nh(this.hSe);
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
            wVar.aKL.bg_cover = this.oAc;
            wVar.mLiveInfo = new AlaLiveInfoData();
            wVar.aKr = new AlaLiveUserInfoData();
            wVar.aKs = new v();
            wVar.aKQ = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            wVar.bz(true);
            this.ozL.setLiveShowData(wVar);
            cny();
            cnv();
            this.ozS.a(wVar, this.oAb, this.oAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void egy() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.ozN = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.ozN.setOnPageChangeListener(this.hSy);
        this.ozN.setBoundaryCaching(true);
        this.ozN.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.ozO = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.ozO.cgN();
        this.ozM = this.ozO.Nx(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.oAc)) {
                this.ozM.setBgImageUrl(this.oAc, null);
            } else {
                this.ozM.setDefaultBg();
            }
            this.ozO.Nx(0).setDefaultBg();
            this.ozO.Nx(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.ozL != null) {
            this.ozO.a(this.mSelectedPosition, this.ozL.Iq());
        }
        this.ozN.setAdapter(this.ozO);
        this.ozN.setCurrentItem(this.mSelectedPosition);
        this.ozN.setIsScrollable(this.hSd);
        this.huR = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.huS = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.ozN.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.14
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                w Iq;
                if ((b.this.ozL == null || (Iq = b.this.ozL.Iq()) == null || Iq.mLiveInfo == null || Iq.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oAa = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.ozL == null || !b.this.ozL.cjG() || rawY <= 0.0f) {
                            if (b.this.ozL == null || !b.this.ozL.cjH() || rawY >= 0.0f) {
                                if (k.eeV().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.eeT().zM(false);
                                k.eeV().aD(b.this.mTbPageContext.getPageActivity());
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
                if (b.this.ozL == null || (Iq = b.this.ozL.Iq()) == null || Iq.mLiveInfo == null || Iq.mLiveInfo.live_status != 2) {
                    k.eeV().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeX() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeY() {
                            if (b.this.ozN != null) {
                                if (b.this.ozL == null || !b.this.ozL.cjG() || !b.this.oAa) {
                                    if (b.this.ozL == null || !b.this.ozL.cjH() || b.this.oAa) {
                                        int currentItem = b.this.ozN.getCurrentItem();
                                        if (b.this.oAa) {
                                            if (currentItem == 0) {
                                                b.this.ozN.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.ozN.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.ozN.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.ozN.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.ozN.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.ozN.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void eeZ() {
                        }
                    });
                    if (b.this.ozL != null && b.this.ozL.cjG() && b.this.oAa) {
                        return true;
                    }
                    if (b.this.ozL == null || !b.this.ozL.cjH() || b.this.oAa) {
                        if (k.eeV().isShowing()) {
                            return false;
                        }
                        h.eeT().zM(false);
                        return k.eeV().aD(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        o efe = o.efe();
        efe.a(this.mTbPageContext, this.ozM, rect);
        efe.a(this);
    }

    private void cnv() {
        this.ozP = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.huR);
    }

    private void d(Rect rect) {
        this.ore = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.ore.setSwipeClearEnable(false);
        this.ore.hFu = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.ozM.a(this.ore, layoutParams);
    }

    private void cny() {
        if (this.ozL != null && this.ozL.Iq() != null) {
            this.aFN = this.ozL.Iq();
            if (this.aFN.mLiveInfo != null) {
                a(this.aFN.mLiveInfo, this.hRS);
                if (this.aFN.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hRI);
                    }
                    if (this.ozS != null) {
                        this.ozS.a(this.mTbPageContext, this.ore, null, this.ozM, this.ozL, this.brs, this.hRK, this.huW, this.hRL, this.hSc);
                        egC();
                    }
                }
            }
        }
    }

    private void cnG() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hRK || !this.hSd) {
                this.ozN.setIsScrollable(false);
            } else {
                this.ozN.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.EY().onBackPressed() && ((this.ozS == null || !this.ozS.onKeyDown(i, keyEvent)) && (this.ozS == null || !this.ozS.ccd()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnG();
            } else if (!k.eeV().aD(this.mTbPageContext.getPageActivity())) {
                h.eeT().zM(false);
            } else if (this.ozS == null || this.ozS.cce()) {
                oA(true);
                bZg();
            }
        }
        return true;
    }

    public void bZg() {
        if (!TextUtils.isEmpty(this.hde)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hde);
                this.hde = null;
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
        cnI();
        long j = -1;
        if (this.ozL != null && this.ozL.cjL() != null) {
            j = this.ozL.cjL().room_id;
        }
        this.ozK.b(z, z2, j);
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
        this.hRF = null;
        if (al.IE() != null) {
            al.IE().ID();
        }
        com.baidu.live.core.layer.b.EY().EZ();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().cV(this.ore);
        if (this.hSq != null) {
            this.hSq.release();
        }
        if (this.ozV != null) {
            this.ozV.release();
        }
        this.hSc = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ozN);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ozL != null) {
            this.ozL.Ia(null);
            AlaLiveInfoData cjL = this.ozL.cjL();
            if (cjL != null) {
                this.ozL.fD(cjL.live_id);
            }
        }
        this.ozT.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnH();
        if (this.ozS != null) {
            this.ozS.nn(z);
        }
        this.hRV = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Pd().bqI != null) {
            com.baidu.live.liveroom.a.b.Pd().bqI.b(this.aFN.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().aCN();
        }
        aj.hs("");
    }

    private void cnH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.aKL != null && this.ozL.ooj) {
                this.ozM.setBgImageUrl(wVar.aKL.bg_cover, null);
            }
            ay(wVar);
            this.aFN = wVar;
            if (this.ozS != null) {
                this.ozS.a(wVar);
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
                    if (!this.ozX.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aTU - (System.currentTimeMillis() / 1000));
                        this.ozX.add(str);
                        if (this.ozJ == null) {
                            this.ozJ = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!egz() || StringUtils.isNull(aVar.aTW, true) || StringUtils.isNull(aVar.aTY, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.ozJ.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.ozJ.a(z, aVar.aTU, aVar.aTW, aVar.aTY, wVar.aKL.aUg, wVar.aKL.live_id, wVar.aKL.croom_id, aVar.aTV, aVar.aTX, wVar.aKM.aTQ + "", wVar.aKL.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.ozJ.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.ozJ.a(false, aVar.aTU, aVar.aTW, aVar.aTY, wVar.aKL.aUg, wVar.aKL.live_id, wVar.aKL.croom_id, aVar.aTV, aVar.aTX, wVar.aKM.aTQ + "", wVar.aKL.is_followed);
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

    private boolean egz() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null || com.baidu.live.ae.a.RB().brA.aOJ.aRX == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().a(com.baidu.live.ae.a.RB().brA.aOJ.aRX.FW(), true);
    }

    private void c(q qVar) {
        if (this.ozS != null) {
            this.ozS.c(qVar);
        }
    }

    private void S(w wVar) {
        this.aFN = wVar;
    }

    private void cnJ() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.ozN.setIsScrollable(false);
            this.hSd = false;
        }
        if (this.aFN != null) {
            a(this.aFN.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.ozM.a(this.ore, null);
            a(this.ozM, this.aFN.mLiveInfo, this.bve);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.feed_id), cnK());
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

    private String cnK() {
        if (this.hRR == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hRR.optString("source");
            String optString2 = this.hRR.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hRR.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hRR.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hRR.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        o efe = o.efe();
        ViewGroup efg = efe.efg();
        if (efg != null && efg.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cu(efg)) {
                        ((ViewGroup) efg.getParent()).removeView(efg);
                        alaLiveRoomBlurPageLayout.d(efg, null);
                        efe.eff();
                    } else if (efe != null) {
                        efe.eff();
                    }
                } else if (efe != null) {
                    efe.eff();
                }
            } else if (efe != null) {
                efe.eff();
            }
        } else if (efg != null && efg.getParent() == null) {
            alaLiveRoomBlurPageLayout.d(efg, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        ViewGroup efg = o.efe().efg();
        if (efg != null) {
            efg.setLayoutParams(b);
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

    public void cnL() {
        this.bve = true;
    }

    public boolean cnM() {
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
        ViewGroup efg = o.efe().efg();
        if (efg != null) {
            int i2 = efg.getLayoutParams().width;
            int i3 = efg.getLayoutParams().height;
            int i4 = efg.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) efg.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.ore != null) {
                this.ore.setLayoutParams(c);
            }
            if (this.ozM != null) {
                this.ozM.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ozR != null) {
                this.ozR.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ozS != null) {
                this.ozS.l(c.width, c.height, realScreenOrientation);
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
                this.ozL.Wr(alaLiveInfoData.room_id + "");
            }
            this.ozL.a(alaLiveInfoData.live_id, true, this.brs, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            w Iq = this.ozL.Iq();
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
            this.ozL.xj(this.ozL.cjI() - 1);
        } else if (i > 0) {
            this.ozL.xj(this.ozL.cjI() + 1);
        }
        if (this.ozS != null) {
            this.ozS.a(this.ozM);
        }
        this.ozO.a(this.mSelectedPosition, cnO(), this.aFN);
        this.ozO.b(this.mSelectedPosition, cnP(), this.aFN);
        if (this.ozL != null) {
            AlaLiveInfoData cjL = this.ozL.cjL();
            if (cjL != null) {
                cjL.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                j(cjL);
                a(this.ozM, cjL, this.bve);
                this.bve = false;
                if (this.ozS != null) {
                    this.ozS.a(this.mTbPageContext, this.ore, null, this.ozM, this.ozL, this.brs, this.hRK, this.huW, null, this.hSc);
                    egC();
                }
                a(cjL, false);
            }
            i(cjL);
            if (this.ozS != null) {
                this.ozS.ccb();
            }
            this.ozL.g(cjL);
        }
    }

    private void j(AlaLiveInfoData alaLiveInfoData) {
        RelativeLayout relativeLayout = (RelativeLayout) this.ore.findViewById(a.f.ala_live_header_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.ore.findViewById(a.f.ala_live_footer_view);
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
                this.ozM.setBgImageUrl(alaLiveInfoData.bg_cover, null);
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
            this.ozL.setLiveShowData(wVar);
            wVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
            String str = (alaLiveInfoData == null || alaLiveInfoData.session_info == null) ? "" : alaLiveInfoData.session_info.flvUrl;
            String str2 = "";
            if (alaLiveInfoData != null && !TextUtils.isEmpty(alaLiveInfoData.chat_mcast_id)) {
                str2 = alaLiveInfoData.chat_mcast_id;
            }
            if (alaLiveInfoData != null && TextUtils.isEmpty(str2)) {
                str2 = String.valueOf(alaLiveInfoData.room_id);
            }
            if (this.ozS != null) {
                this.ozS.a(wVar, str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ozM.a(this.ore, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egA() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.efJ().bes();
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjB = this.ozL.cjB();
        if (cjB == null || cjB.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        int cjI = this.ozL.cjI();
        int size = cjB.size();
        return cjB.get(((cjI + size) - 1) % size);
    }

    private AlaLiveInfoData cnP() {
        List<AlaLiveInfoData> cjB = this.ozL.cjB();
        if (cjB == null || cjB.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        return cjB.get((this.ozL.cjI() + 1) % cjB.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hRI) {
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
        w Iq = this.ozL.Iq();
        S(Iq);
        if (Iq != null && Iq.aKL != null) {
            this.ozM.setBgImageUrl(Iq.aKL.bg_cover, null);
        }
        egB();
        this.ozL.cjC();
        if (this.bve) {
            this.ozL.ob(false);
        }
        this.huW = System.currentTimeMillis() / 1000;
        if (this.ozS != null) {
            this.ozS.a(this.mTbPageContext, this.ore, null, this.ozM, this.ozL, this.brs, this.hRK, this.huW, this.hRL, this.hSc);
            egC();
        }
        cnJ();
        if (Iq != null && Iq.mLiveInfo != null && Iq.mLiveInfo.live_status == 2) {
            this.ozO.a(this.mSelectedPosition, this.ozL.Iq());
            d(Iq, false);
            this.bve = false;
            return;
        }
        boolean z = (this.ozS == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ag.a.b.Sm().cO(com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aOL && Iq != null && Iq.aKP);
        aj.d(Iq);
        if (z) {
            if (!this.hRZ || !TextUtils.equals(s.WC(), this.hSa)) {
                aj.b(getPageContext(), false);
                e.RP().RQ();
                this.hRZ = true;
                this.hSa = s.WC();
            }
            aj.Ix();
        }
        if (this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null) {
            this.ozL.hN(this.ozL.Iq().mLiveInfo.live_id);
            this.hRV = true;
        }
        if (this.ozS != null) {
            this.ozS.b(this.hRF);
            this.ozS.nm(TextUtils.equals(this.hRM, "1"));
            this.hRM = "";
        }
        if (this.ozP != null) {
            this.ozP.a(this.aFN, this.ozQ);
        }
        a(this.ozL.Iq());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.ozL.Iq() != null && b.this.ozL.Iq().mLiveInfo != null) {
                    b.this.ozL.a(b.this.ozL.Iq().mLiveInfo.live_id, b.this.brs, b.this.huW);
                }
            }
        });
        this.bve = false;
        if (z && this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null && this.ozL.Iq().aJV != null && this.ozS != null) {
            long j = this.ozL.Iq().mLiveInfo.live_id;
            long j2 = this.ozL.Iq().mLiveInfo.room_id;
            String str2 = this.ozL.Iq().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.IE() != null) {
                    al.IE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.hSq != null) {
                    this.hSq.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.LY() != null) {
                com.baidu.live.guardclub.e.LY().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.ozV == null) {
                this.ozV = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.ozV.a(this.mTbPageContext.getPageActivity(), this.ozL.Iq(), this.otherParams);
        }
        if (this.ozW == null) {
            this.ozW = new com.baidu.tieba.yuyinala.liveroom.n.c(this.mTbPageContext);
        }
        if (z && this.ozL.Iq() != null && this.ozL.Iq().aKr != null && !this.hRY) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.ozW.a(this.ozL.Iq(), this.ozL.Iq().aKr.userId);
                this.hRY = true;
            }
        }
    }

    private void egB() {
        try {
            if (this.ozL != null && this.ozL.Iq() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.ozL.Iq().aKr.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ozL.Iq().aKL.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bve) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.ozL.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozL.Iq().mLiveInfo.feed_id);
                }
                if (!this.ozL.cjB().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.ozL.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozL.Iq().mLiveInfo.feed_id);
                    this.ozL.cjB().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.ozL.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozL.Iq().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.ozL.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozL.Iq().mLiveInfo.feed_id);
                this.ozU = new StayTimeBean();
                this.ozU.liveId = this.ozL.Iq().mLiveInfo.live_id;
                this.ozU.roomId = this.ozL.Iq().mLiveInfo.room_id;
                this.ozU.vid = this.ozL.Iq().mLiveInfo.feed_id;
                this.ozU.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.hRG) {
            this.ozO.a(this.mSelectedPosition, cnO(), this.aFN);
            this.ozO.b(this.mSelectedPosition, cnP(), this.aFN);
            this.hRG = false;
        }
        if (this.ozR != null && coa()) {
            this.ozR.ad(this.ozL.cjD());
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
        if (!this.hRI) {
            this.mHandler.removeCallbacks(this.hSk);
            this.mHandler.postDelayed(this.hSk, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hRI) {
                this.mHandler.removeCallbacks(this.hSj);
                this.mHandler.postDelayed(this.hSj, 5000L);
                return;
            }
            return;
        }
        if (!this.hRH) {
            c(qVar);
        }
        if (!this.hRI) {
            this.mHandler.removeCallbacks(this.hSj);
            this.mHandler.postDelayed(this.hSj, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        if (this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null) {
            this.ozL.hN(this.ozL.Iq().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(w wVar) {
        if (wVar != null && wVar.aKr != null && wVar.aKr.logined == 1) {
            oA(false);
        } else if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.ozO.a(this.mSelectedPosition, this.ozL.Iq());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hRH) {
                aj.d(wVar);
                a(wVar);
            }
            if (!this.hRI) {
                this.mHandler.removeCallbacks(this.hyg);
                this.mHandler.postDelayed(this.hyg, wVar.aKa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (this.mTbPageContext != null && this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null) {
            this.ozL.a(this.ozL.Iq().mLiveInfo.live_id, this.brs, this.huW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        View view = null;
        nn(true);
        if (!coa()) {
            this.ozL.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.ozM != null) {
                this.ozM.Yj();
                this.ozM.cle();
            }
            if (wVar != null && wVar.mLiveInfo != null) {
                this.hRQ = wVar.mLiveInfo.live_id;
            }
            cnG();
            cnS();
            cnT();
            if (wVar != null) {
                if (this.ozS != null && this.ozS.cch() != null) {
                    view = this.ozS.cch().a(this.ozS.edb().pageContext.getPageActivity(), wVar, z);
                }
                if (this.ozM != null) {
                    this.ozR.a(this.ozM, view, wVar, z, this.ozL.cjD());
                }
                if (this.ozS != null) {
                    this.ozS.nn(false);
                    this.ozS.ccc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.ozM != null) {
                    this.ozM.clg();
                }
                long j = wVar.mLiveInfo.live_id;
                long j2 = wVar.mLiveInfo.room_id;
                String str = wVar.mLiveInfo.feed_id;
                long j3 = wVar.aJV.userId;
                String str2 = wVar.aJV.userName;
            }
            coc();
            if (this.ozP != null) {
                this.ozP.a(this.aFN, this.ozQ);
            }
        }
    }

    private void cnS() {
    }

    private void cnT() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ozN);
        }
    }

    public void cnU() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnV();
        } else {
            cnW();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.ozL != null && this.ozL.Iq() != null) {
            alaLiveInfoData = this.ozL.Iq().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnV();
        } else {
            cnW();
        }
        this.ozN.setIsScrollable(!z && this.hSd);
        if (this.ozS != null) {
            this.ozS.onKeyboardVisibilityChanged(z);
        }
        if (this.ore != null) {
            this.ore.onKeyboardVisibilityChanged(z);
        }
        o.efe().setMaskBg(z);
    }

    public void dX(int i) {
    }

    public void cnV() {
        if (this.ozN != null) {
            i.ae(this.ozN);
        }
    }

    public void cnW() {
        if (this.ozN != null) {
            i.af(this.ozN);
        }
    }

    public void onResume() {
        if (this.ozL != null) {
            this.ozL.cjn();
        }
        if (this.ozS != null) {
            this.ozS.enterForeground();
        }
        if (this.ozV != null) {
            this.ozV.onResume();
        }
        if (this.ozW != null) {
            this.ozW.onResume();
        }
        if (this.hSK != null && !this.hSK.hasFocus()) {
            this.hSK.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.EY().onResume();
    }

    public void onStart() {
        if (!this.hSb) {
            if (this.hRI) {
                this.hRI = false;
                cnZ();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cnZ() {
        cjg();
        cnR();
        this.ozL.cjC();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
        }
        if (this.ozS != null) {
            this.ozS.ccg();
        }
        if (this.ozL != null && this.ozL.Iq() != null && this.ozL.Iq().mLiveInfo != null) {
            this.ozT.fG(this.ozL.Iq().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aFN.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.ozL != null) {
            this.ozL.cjo();
        }
        if (this.ozS != null) {
            this.ozS.enterBackground();
        }
        com.baidu.live.core.layer.b.EY().onPause();
    }

    public void ox(boolean z) {
        this.hRI = true;
        oB(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oB(boolean z) {
        this.mHandler.removeCallbacks(this.hyg);
        this.mHandler.removeCallbacks(this.hSj);
        this.mHandler.removeCallbacks(this.hSk);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || !z) {
        }
        if (this.ozS != null) {
            this.ozS.ccf();
        }
        this.ozT.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.IE() != null) {
                al.IE().a(i, i2, intent, this.aFN, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ozS != null) {
            this.ozS.onActivityResult(i, i2, intent);
        }
    }

    private void az(w wVar) {
        if (wVar != null) {
            if (wVar.aKL != null && !TextUtils.isEmpty(wVar.aKL.bg_cover)) {
                this.ozM.setBgImageUrl(wVar.aKL.bg_cover, null);
            } else if (wVar.aJV != null && !TextUtils.isEmpty(wVar.aJV.portrait)) {
                this.ozM.setBgImageUrl(wVar.aJV.portrait, 12, null);
            }
        }
    }

    public boolean coa() {
        return this.ozR != null && this.ozR.bVl();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hSC);
        MessageManager.getInstance().unRegisterListener(this.oAe);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oAf);
        if (this.hSq != null) {
            this.hSq.release();
        }
        if (this.ozP != null) {
            this.ozP.onDestory();
        }
        o.efe().cKu();
        if (this.ozQ != null) {
            this.ozQ.reset();
        }
        if (this.ozS != null) {
            this.ozS.onDestroy();
        }
        if (this.ozO != null) {
            this.ozO.onDestroy();
        }
        this.ozM.Yj();
        if (this.ozM != null) {
            this.ozM.release();
            this.ozM = null;
        }
        if (this.ozR != null) {
            this.ozR.onDestroy();
        }
        if (this.hSK != null) {
            this.hSK.abandonAudioFocus();
        }
        if (this.ozU != null && this.ozL != null && this.ozL.Iq() != null) {
            if (this.ozU.liveId == this.ozL.Iq().mLiveInfo.live_id && this.ozU.startTime > 0) {
                this.ozU.endTime = System.currentTimeMillis();
                long j = this.ozU.endTime - this.ozU.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.ozL.Iq().aKL.aUg, this.otherParams, this.mSelectedPosition + 1, this.bve, this.ozL.Iq().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.ozU = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ozL != null) {
                jSONObject.put("identity", this.ozL.Iq().aKr.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ozL.Iq().aKL.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.ore != null) {
            this.ore.clm();
            this.ore = null;
        }
        if (this.ozL != null) {
            this.ozL.destory();
        }
        z.Ii().release();
        if (this.ozW != null) {
            this.ozW.release();
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
    }

    public void oC(boolean z) {
        this.hSb = z;
    }

    public void cob() {
        if (this.hRR != null) {
            this.otherParams = this.hRR.toString();
            if (this.ozL != null) {
                this.ozL.setOtherParams(this.otherParams);
            }
            if (this.ozS != null) {
                this.ozS.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ozR != null) {
                this.ozR.setOtherParams(this.otherParams);
            }
        }
    }

    public void coc() {
        if (this.hRR != null) {
            String optString = this.hRR.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hRR.put("tab", "live_jump");
                        this.hRR.put("tag", "");
                        this.hRR.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hRR.put("tab", "liveroom");
                        this.hRR.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cob();
            }
        }
    }

    public void cod() {
        aj.IA();
    }

    private void egC() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ozS.e((short) 2);
        } else {
            this.ozS.edc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.ozZ = bitmap;
            this.ozM.setBgImageBitmap(this.ozZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egD() {
        if (this.ozZ != null) {
            if (!this.ozZ.isRecycled()) {
                this.ozZ.recycle();
            }
            this.ozZ = null;
            az(this.aFN);
        }
    }

    public boolean efl() {
        return this.hSb;
    }
}

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
import com.baidu.live.aa.e;
import com.baidu.live.ad.c;
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
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.bo;
import com.baidu.live.data.ct;
import com.baidu.live.data.cx;
import com.baidu.live.data.q;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.y;
import com.baidu.live.s.g;
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
    private w aDh;
    private CustomMessageListener bcy;
    private long bmk;
    private String bml;
    private boolean bpT;
    private String gTP;
    private AlaLastLiveroomInfo hHW;
    private boolean hHX;
    private boolean hHY;
    private boolean hHZ;
    private Runnable hIA;
    private Runnable hIB;
    private Runnable hIC;
    private c hIH;
    com.baidu.live.liveroom.a.c hIO;
    ViewPager.OnPageChangeListener hIP;
    CustomMessageListener hIT;
    private boolean hIb;
    private ArrayList<AlaBroadcastGiftToastData> hIc;
    private String hId;
    private String hIg;
    private long hIh;
    private JSONObject hIi;
    private boolean hIj;
    private boolean hIm;
    private boolean hIp;
    private boolean hIq;
    private String hIr;
    private boolean hIs;
    private bo hIt;
    private boolean hIu;
    private boolean hIv;
    private g hJb;
    private ViewGroup hlq;
    private LayerRootView hlr;
    private long hlv;
    private Runnable hoA;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private a.InterfaceC0909a nYY;
    private AlaLiveView occ;
    private o ogd;
    private d okH;
    private a okI;
    private com.baidu.tieba.yuyinala.liveroom.i.a okJ;
    private AlaLiveRoomBlurPageLayout okK;
    private AlaLoopViewPager okL;
    private AlaLoopViewPagerAdapter okM;
    private com.baidu.tieba.yuyinala.liveroom.d.a okN;
    private com.baidu.tieba.yuyinala.liveroom.d.b okO;
    private com.baidu.tieba.yuyinala.endliveroom.a okP;
    private com.baidu.tieba.yuyinala.liveroom.c.b okQ;
    private com.baidu.tieba.yuyinala.liveroom.task.b okR;
    private StayTimeBean okS;
    private com.baidu.tieba.yuyinala.liveroom.g.a okT;
    private com.baidu.tieba.yuyinala.liveroom.n.c okU;
    private Set<String> okV;
    private int okW;
    private Bitmap okX;
    private boolean okY;
    private String okZ;
    private String ola;
    private String olb;
    private CustomMessageListener olc;
    CustomMessageListener old;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hHX = true;
        this.hlv = 0L;
        this.hHY = false;
        this.bpT = true;
        this.bml = "";
        this.mForumName = "";
        this.hHZ = false;
        this.hIb = false;
        this.hId = "0";
        this.mHandler = new Handler();
        this.hIh = -1L;
        this.otherParams = "";
        this.hIj = false;
        this.okR = com.baidu.tieba.yuyinala.liveroom.task.b.dYt();
        this.hIm = false;
        this.hIq = false;
        this.hIs = false;
        this.hIv = false;
        this.okV = new HashSet();
        this.hoA = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cfl();
            }
        };
        this.hIA = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjV();
            }
        };
        this.hIB = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.okJ.cfH();
            }
        };
        this.okW = 5000;
        this.okZ = "";
        this.ola = "";
        this.olb = "";
        this.bcy = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.hIC = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.13
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
            }
        };
        this.hIO = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // com.baidu.live.liveroom.a.c
            public void cg(final boolean z) {
                if (!k.dZq().isShowing()) {
                    h.dZo().zi(false);
                    boolean aC = k.dZq().aC(b.this.mTbPageContext.getPageActivity());
                    k.dZq().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.15.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZs() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZt() {
                            if (z || b.this.okQ == null || b.this.okQ.bYk()) {
                                b.this.of(true);
                                b.this.bVv();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZu() {
                        }
                    });
                    if (aC) {
                        if (z || b.this.okQ == null || b.this.okQ.bYk()) {
                            b.this.of(true);
                            b.this.bVv();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ch(boolean z) {
                b.this.d(b.this.aDh, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.okL != null) {
                    b.this.okL.setIsScrollable(b.this.hIu && z);
                    b.this.okL.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ci(boolean z) {
            }
        };
        this.hIP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.occ != null && b.this.okJ != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.okL.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.okS != null && b.this.okJ != null && b.this.okJ.Gz() != null && b.this.okJ.Gz().mLiveInfo != null && b.this.okJ.Gz().aHZ != null) {
                        if (b.this.okS.liveId == b.this.okJ.Gz().mLiveInfo.live_id && b.this.okS.startTime > 0) {
                            b.this.okS.endTime = System.currentTimeMillis();
                            long j = b.this.okS.endTime - b.this.okS.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.okJ.Gz().aHZ.aRe, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bpT, b.this.okJ.Gz().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.okS = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.okJ != null && b.this.okJ.Gz() != null && b.this.okJ.Gz().aHG != null) {
                            jSONObject.put("identity", b.this.okJ.Gz().aHG.getUserTypeStr());
                        }
                        if (b.this.okJ != null && b.this.okJ.Gz() != null && b.this.okJ.Gz().aHZ != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.okJ.Gz().aHZ.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bpT || b.this.okJ.cfG() == null || ListUtils.getCount(b.this.okJ.cfG()) > 1) {
                        if (b.this.okJ.cfL() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.okJ == null || !b.this.okJ.cfL() || i2 >= 0) {
                            if (b.this.okJ != null && b.this.okJ.cfM() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.okL.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.okJ != null) {
                                b.this.okJ.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.mS(true);
                            b.this.okK.chj();
                            b.this.okK.VJ();
                            b.this.okK.chk();
                            b.this.ckg();
                            if (b.this.hIH != null) {
                                b.this.hIH.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.okK = b.this.okM.MG(b.this.mSelectedPosition);
                            b.this.okK.chl();
                            b.this.xb(i2);
                            b.this.eaU();
                            b.this.Ne(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.okL.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.okL.setCurrentItem(b.this.mSelectedPosition);
                    b.this.okJ.g(b.this.okJ.cfQ());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.okL != null && i == 0) {
                    com.baidu.live.d.Aq().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.nYY = new a.InterfaceC0909a() { // from class: com.baidu.tieba.yuyinala.player.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0909a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.K(b.this.okJ.Gz());
                } else if (i2 == 2) {
                    b.this.f(b.this.okJ.bQJ());
                } else if (i2 == 3) {
                    b.this.bp(i, str);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cjU();
                }
            }
        };
        this.hIT = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.okJ != null && b.this.okJ.Gz() != null && b.this.okJ.Gz().aHG != null) {
                        if (l.longValue() == b.this.okJ.Gz().aHG.userId) {
                            b.this.okJ.Gz().aHG.isNewUser = false;
                            if (b.this.okT != null) {
                                b.this.okT.n(b.this.okJ.Gz());
                            }
                        }
                    }
                }
            }
        };
        this.olc = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.eaX();
                    } else {
                        b.this.Y((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.old = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cfl();
            }
        };
        this.hlv = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.okI = aVar;
        this.hHX = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.hIH = (c) runTask.getData();
        }
        this.okJ = new com.baidu.tieba.yuyinala.liveroom.i.a(getPageContext());
        this.okJ.a(this.nYY);
        this.okP = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hIT);
        MessageManager.getInstance().registerListener(this.olc);
        MessageManager.getInstance().registerListener(this.bcy);
        MessageManager.getInstance().registerListener(this.old);
        this.hJb = new g(tbPageContext.getPageActivity());
        this.hJb.setIPlayerAudioFocusCallBack(new com.baidu.live.s.a() { // from class: com.baidu.tieba.yuyinala.player.b.11
            @Override // com.baidu.live.s.a
            public void cp(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().muteOrUnmuteAudio(!z);
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
                        this.hIc = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hIc.add(alaBroadcastGiftToastData);
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
        this.bml = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bml)) {
            this.bml = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hIg = intent.getStringExtra("room_id");
        this.bmk = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.okZ = new String(Base64.decode(optString.getBytes()));
                if (!this.okZ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.okZ = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.ola = new String(Base64.decode(optString2.getBytes()));
                if (!this.ola.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.ola = "";
                }
            }
            this.olb = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.hIj = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.okJ.b((AlaLiveInfoCoreData) serializableExtra);
            this.hIj = true;
        }
        TbConfig.liveScene = 2;
        ax(intent);
        this.hIu = this.hIt == null || !this.hIt.aOa;
        this.okP.setOtherParams(this.otherParams);
        this.hIb = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        eaR();
        cjz();
        this.mHandler.removeCallbacks(this.hIC);
        this.mHandler.postDelayed(this.hIC, 1000L);
    }

    private void ax(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gTP = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hIi = new JSONObject(stringExtra);
                if (this.hIi != null) {
                    String optString2 = this.hIi.optString("enterRoomId");
                    String optString3 = this.hIi.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hIg, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bmk + "", optString3))) {
                        String optString4 = this.hIi.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hIi.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hIj) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bmk;
                            alaLiveInfoCoreData.screenDirection = this.hIi.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.okJ.b(alaLiveInfoCoreData);
                            this.hIj = true;
                        }
                    }
                    String optString6 = this.hIi.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hIt = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.okJ != null) {
                            this.okJ.Hm(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gTP = jSONObject.optString("live_back_scheme");
                        this.hIt = new bo();
                        this.hIt.aOa = jSONObject.optInt("is_hot") == 1;
                        if (this.hIt.aOa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hIt.aOb = jSONObject.optString("task_id");
                        this.hIt.aNZ = TextUtils.isEmpty(this.hIt.aOb) ? false : true;
                        this.hIt.aOc = jSONObject.optInt("task_type");
                        this.hIt.aOd = jSONObject.optInt("task_im_count");
                        this.hIt.aOe = jSONObject.optLong("task_gift_total_price");
                        this.hIt.aOf = jSONObject.optLong("task_watch_time");
                        this.hIt.aOg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.okO = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.okO.setScheme(optString8);
                            this.okO.setImageUrl(optString9);
                            this.okO.setTitle(optString10);
                        }
                    }
                    this.hId = this.hIi.optString("open_giftlist");
                    this.hIi.remove("cover");
                    this.hIi.remove("live_url");
                    this.hIi.remove("enterRoomId");
                    this.hIi.remove("enterLiveId");
                    this.hIi.remove("open_giftlist");
                    this.hIi.remove("extra");
                    this.otherParams = this.hIi.toString();
                    if (this.okJ != null) {
                        this.okJ.setOtherParams(this.otherParams);
                    }
                    this.hIi.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("source");
                    }
                    this.hIv = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hIi.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.okJ != null) {
                        this.okJ.wD(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hHW = new AlaLastLiveroomInfo();
                this.hHW.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bmk), String.valueOf(this.hIg), null, cjO());
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

    public void cjz() {
        boolean z = false;
        if (this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null && this.okJ.Gz().mLiveInfo.room_id > 0) {
            this.okJ.Vc(this.okJ.Gz().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.hIg)) {
            this.okJ.Vc(this.hIg);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.okJ.ar(this.uk, this.bml, this.mForumName);
            z = true;
        } else if (this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null && this.okJ.Gz().mLiveInfo.live_id > 0) {
            this.okJ.a(this.okJ.Gz().mLiveInfo.live_id, false, this.bml, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bml = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                of(false);
                return;
            }
            this.okJ.ar(this.uk, this.bml, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.hIg)) {
            this.okJ.HO(this.hIg);
            z = true;
        } else if (this.bmk > 0) {
            this.okJ.a(this.bmk, false, this.bml, "");
            z = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            of(false);
        }
        if (z) {
            eaU();
        }
    }

    private void eaR() {
        this.bpT = true;
        this.hHY = false;
        eaS();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.Do().j(this.hlr);
        this.okQ = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.okQ.a(this.hIO);
        this.okQ.setOtherParams(this.otherParams);
        this.okQ.mN(this.hIv);
        try {
            w wVar = new w();
            wVar.aIr = false;
            wVar.aHZ = new cx();
            wVar.aHZ.live_id = String.valueOf(this.bmk);
            wVar.aHZ.cover = "";
            wVar.aHZ.room_name = ".....";
            wVar.aHZ.aRe = "0";
            wVar.aHZ.croom_id = "0";
            wVar.aHZ.is_followed = true;
            wVar.aHZ.bg_cover = this.ola;
            wVar.mLiveInfo = new AlaLiveInfoData();
            wVar.aHG = new AlaLiveUserInfoData();
            wVar.aHH = new v();
            wVar.aIe = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            wVar.br(true);
            this.okJ.setLiveShowData(wVar);
            cjC();
            cjA();
            this.okQ.a(wVar, this.okZ, this.olb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eaS() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.okL = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.okL.setOnPageChangeListener(this.hIP);
        this.okL.setBoundaryCaching(true);
        this.okL.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.okM = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.okM.ccU();
        this.okK = this.okM.MF(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.ola)) {
                this.okK.setBgImageUrl(this.ola, null);
            } else {
                this.okK.setDefaultBg();
            }
            this.okM.MF(0).setDefaultBg();
            this.okM.MF(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.okJ != null) {
            this.okM.a(this.mSelectedPosition, this.okJ.Gz());
        }
        this.okL.setAdapter(this.okM);
        this.okL.setCurrentItem(this.mSelectedPosition);
        this.okL.setIsScrollable(this.hIu);
        this.hlq = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hlr = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.okL.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.14
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                w Gz;
                if ((b.this.okJ == null || (Gz = b.this.okJ.Gz()) == null || Gz.mLiveInfo == null || Gz.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.okY = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.okJ == null || !b.this.okJ.cfL() || rawY <= 0.0f) {
                            if (b.this.okJ == null || !b.this.okJ.cfM() || rawY >= 0.0f) {
                                if (k.dZq().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.dZo().zi(false);
                                k.dZq().aC(b.this.mTbPageContext.getPageActivity());
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
            public boolean ME(int i) {
                w Gz;
                if (b.this.okJ == null || (Gz = b.this.okJ.Gz()) == null || Gz.mLiveInfo == null || Gz.mLiveInfo.live_status != 2) {
                    k.dZq().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZs() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZt() {
                            if (b.this.okL != null) {
                                if (b.this.okJ == null || !b.this.okJ.cfL() || !b.this.okY) {
                                    if (b.this.okJ == null || !b.this.okJ.cfM() || b.this.okY) {
                                        int currentItem = b.this.okL.getCurrentItem();
                                        if (b.this.okY) {
                                            if (currentItem == 0) {
                                                b.this.okL.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.okL.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.okL.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.okL.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.okL.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.okL.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZu() {
                        }
                    });
                    if (b.this.okJ != null && b.this.okJ.cfL() && b.this.okY) {
                        return true;
                    }
                    if (b.this.okJ == null || !b.this.okJ.cfM() || b.this.okY) {
                        if (k.dZq().isShowing()) {
                            return false;
                        }
                        h.dZo().zi(false);
                        return k.dZq().aC(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        this.ogd = o.dZz();
        this.ogd.a(this.mTbPageContext, this.okK, rect);
        this.ogd.a(this);
    }

    private void cjA() {
        this.okN = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hlq);
    }

    private void d(Rect rect) {
        this.occ = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.occ.setSwipeClearEnable(false);
        this.occ.hvO = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.okK.a(this.occ, layoutParams);
    }

    private void cjC() {
        if (this.okJ != null && this.okJ.Gz() != null) {
            this.aDh = this.okJ.Gz();
            if (this.aDh.mLiveInfo != null) {
                a(this.aDh.mLiveInfo, this.hIj);
                if (this.aDh.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hHZ);
                    }
                    if (this.okQ != null) {
                        this.okQ.a(this.mTbPageContext, this.occ, null, this.okK, this.okJ, this.bml, this.hIb, this.hlv, this.hIc, this.hIt);
                        eaW();
                    }
                }
            }
        }
    }

    private void cjK() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hIb || !this.hIu) {
                this.okL.setIsScrollable(false);
            } else {
                this.okL.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Do().onBackPressed() && ((this.okQ == null || !this.okQ.onKeyDown(i, keyEvent)) && (this.okQ == null || !this.okQ.bYj()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cjK();
            } else if (!k.dZq().aC(this.mTbPageContext.getPageActivity())) {
                h.dZo().zi(false);
            } else if (this.okQ == null || this.okQ.bYk()) {
                of(true);
                bVv();
            }
        }
        return true;
    }

    public void bVv() {
        if (!TextUtils.isEmpty(this.gTP)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gTP);
                this.gTP = null;
            }
        }
    }

    public void of(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mS(!z);
        com.baidu.live.core.layer.b.Do().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cjM();
        long j = -1;
        if (this.okJ != null && this.okJ.cfQ() != null) {
            j = this.okJ.cfQ().room_id;
        }
        this.okI.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void mS(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hHW = null;
        if (aj.GN() != null) {
            aj.GN().GM();
        }
        com.baidu.live.core.layer.b.Do().Dp();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZV().cS(this.occ);
        if (this.hIH != null) {
            this.hIH.release();
        }
        if (this.okT != null) {
            this.okT.release();
        }
        this.hIt = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.okL);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.okJ != null) {
            this.okJ.Hm(null);
            AlaLiveInfoData cfQ = this.okJ.cfQ();
            if (cfQ != null) {
                this.okJ.eZ(cfQ.live_id);
            }
        }
        this.okR.stopRecord();
        LiveTimerManager.getInstance().stop();
        cjL();
        if (this.okQ != null) {
            this.okQ.mS(z);
        }
        this.hIm = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.ML().blB != null) {
            com.baidu.live.liveroom.a.b.ML().blB.b(this.aDh.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().azE();
        }
        ah.gX("");
    }

    private void cjL() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cjM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.aHZ != null && this.okJ.nZh) {
                this.okK.setBgImageUrl(wVar.aHZ.bg_cover, null);
            }
            at(wVar);
            this.aDh = wVar;
            if (this.okQ != null) {
                this.okQ.a(wVar);
            }
        }
    }

    private void at(final w wVar) {
        List<ct.a> list;
        if (wVar.aIa != null && wVar.aHZ != null && (list = wVar.aIa.aQP) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final ct.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aQS + aVar.aQU + aVar.aQW + wVar.aHZ.aRe;
                    if (!this.okV.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aQS - (System.currentTimeMillis() / 1000));
                        this.okV.add(str);
                        if (this.okH == null) {
                            this.okH = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!eaT() || StringUtils.isNull(aVar.aQU, true) || StringUtils.isNull(aVar.aQW, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.okH.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.okH.a(z, aVar.aQS, aVar.aQU, aVar.aQW, wVar.aHZ.aRe, wVar.aHZ.live_id, wVar.aHZ.croom_id, aVar.aQT, aVar.aQV, wVar.aIa.aQO + "", wVar.aHZ.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.okH.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.okH.a(false, aVar.aQS, aVar.aQU, aVar.aQW, wVar.aHZ.aRe, wVar.aHZ.live_id, wVar.aHZ.croom_id, aVar.aQT, aVar.aQV, wVar.aIa.aQO + "", wVar.aHZ.is_followed);
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

    private boolean eaT() {
        if (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aLN == null || com.baidu.live.aa.a.Ph().bms.aLN.aOV == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZV().a(com.baidu.live.aa.a.Ph().bms.aLN.aOV.El(), true);
    }

    private void c(q qVar) {
        if (this.okQ != null) {
            this.okQ.c(qVar);
        }
    }

    private void N(w wVar) {
        this.aDh = wVar;
    }

    private void cjN() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.okL.setIsScrollable(false);
            this.hIu = false;
        }
        if (this.aDh != null) {
            a(this.aDh.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.okK.a(this.occ, null);
            a(this.okK, this.aDh.mLiveInfo, this.bpT);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDh.mLiveInfo.live_id), String.valueOf(this.aDh.mLiveInfo.room_id), String.valueOf(this.aDh.mLiveInfo.feed_id), cjO());
            if (com.baidu.live.liveroom.a.b.ML().blB != null) {
                com.baidu.live.liveroom.a.b.ML().blB.a(this.aDh.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
                String str = "normal";
                if (this.aDh != null && this.aDh.aIe != null && this.aDh.aIe.getRoomMode() == 1) {
                    str = "dating";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bpT = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String cjO() {
        if (this.hIi == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hIi.optString("source");
            String optString2 = this.hIi.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hIi.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hIi.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hIi.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        ViewGroup dZB = this.ogd.dZB();
        if (dZB != null && dZB.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cn(dZB)) {
                        ((ViewGroup) dZB.getParent()).removeView(dZB);
                        alaLiveRoomBlurPageLayout.d(dZB, null);
                        this.ogd.dZA();
                    } else if (this.ogd != null) {
                        this.ogd.dZA();
                    }
                } else if (this.ogd != null) {
                    this.ogd.dZA();
                }
            } else if (this.ogd != null) {
                this.ogd.dZA();
            }
        } else if (dZB != null && dZB.getParent() == null) {
            alaLiveRoomBlurPageLayout.d(dZB, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        ViewGroup dZB = this.ogd.dZB();
        if (dZB != null) {
            dZB.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = com.baidu.live.utils.o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = com.baidu.live.utils.o.v(this.mTbPageContext.getPageActivity());
                int aI = com.baidu.live.utils.o.aI(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aI + i;
                } else {
                    dimensionPixelSize = aI + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cjP() {
        this.bpT = true;
    }

    public boolean cjQ() {
        return this.bpT;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        ViewGroup dZB;
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
        if (this.ogd != null && (dZB = this.ogd.dZB()) != null) {
            int i2 = dZB.getLayoutParams().width;
            int i3 = dZB.getLayoutParams().height;
            int i4 = dZB.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) dZB.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.occ != null) {
                this.occ.setLayoutParams(c);
            }
            if (this.okK != null) {
                this.okK.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.okP != null) {
                this.okP.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.okQ != null) {
                this.okQ.l(c.width, c.height, realScreenOrientation);
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
                this.okJ.Vc(alaLiveInfoData.room_id + "");
            }
            this.okJ.a(alaLiveInfoData.live_id, true, this.bml, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ne(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            w Gz = this.okJ.Gz();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Gz.aHZ.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : MapBundleKey.OfflineMapKey.OFFLINE_UPDATE);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void xb(int i) {
        if (i < 0) {
            this.okJ.wE(this.okJ.cfN() - 1);
        } else if (i > 0) {
            this.okJ.wE(this.okJ.cfN() + 1);
        }
        if (this.okQ != null) {
            this.okQ.a(this.okK);
        }
        this.okM.a(this.mSelectedPosition, cjS(), this.aDh);
        this.okM.b(this.mSelectedPosition, cjT(), this.aDh);
        if (this.okJ != null) {
            AlaLiveInfoData cfQ = this.okJ.cfQ();
            if (cfQ != null) {
                cfQ.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.okK, cfQ, this.bpT);
                this.bpT = false;
                if (this.okQ != null) {
                    this.okQ.a(this.mTbPageContext, this.occ, null, this.okK, this.okJ, this.bml, this.hIb, this.hlv, null, this.hIt);
                    eaW();
                }
                a(cfQ, false);
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.occ.findViewById(a.f.ala_live_header_view);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.occ.findViewById(a.f.ala_live_footer_view);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            try {
                w wVar = new w();
                wVar.aIr = false;
                wVar.aHZ = new cx();
                if (cfQ != null) {
                    this.okK.setBgImageUrl(cfQ.bg_cover, null);
                    wVar.aHZ.bg_cover = cfQ.bg_cover;
                    wVar.aHZ.live_id = String.valueOf(cfQ.live_id);
                    wVar.aHZ.cover = cfQ.cover;
                    wVar.aHZ.aRe = String.valueOf(cfQ.room_id);
                    wVar.aHZ.croom_id = cfQ.croom_id;
                    wVar.aHZ.is_followed = cfQ.is_followed;
                    wVar.aHZ.room_name = cfQ.room_name;
                }
                wVar.mLiveInfo = new AlaLiveInfoData();
                if (cfQ != null) {
                    wVar.mLiveInfo.live_id = cfQ.live_id;
                }
                wVar.aHG = new AlaLiveUserInfoData();
                wVar.aHH = new v();
                wVar.aIe = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
                wVar.br(true);
                this.okJ.setLiveShowData(wVar);
                wVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
                String str = (cfQ == null || cfQ.session_info == null) ? "" : cfQ.session_info.flvUrl;
                String str2 = "";
                if (cfQ != null && !TextUtils.isEmpty(cfQ.chat_mcast_id)) {
                    str2 = cfQ.chat_mcast_id;
                }
                if (cfQ != null && TextUtils.isEmpty(str2)) {
                    str2 = String.valueOf(cfQ.room_id);
                }
                if (this.okQ != null) {
                    this.okQ.a(wVar, str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i(cfQ);
            this.okK.a(this.occ, null);
            if (this.okQ != null) {
                this.okQ.bYh();
            }
            this.okJ.g(cfQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaU() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.ead().bbn();
    }

    private AlaLiveInfoData cjS() {
        List<AlaLiveInfoData> cfG = this.okJ.cfG();
        if (cfG == null || cfG.size() == 0) {
            if (this.aDh == null) {
                return null;
            }
            return this.aDh.mLiveInfo;
        }
        int cfN = this.okJ.cfN();
        int size = cfG.size();
        return cfG.get(((cfN + size) - 1) % size);
    }

    private AlaLiveInfoData cjT() {
        List<AlaLiveInfoData> cfG = this.okJ.cfG();
        if (cfG == null || cfG.size() == 0) {
            if (this.aDh == null) {
                return null;
            }
            return this.aDh.mLiveInfo;
        }
        return cfG.get((this.okJ.cfN() + 1) % cfG.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hHZ) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            of(false);
            return;
        }
        w Gz = this.okJ.Gz();
        N(Gz);
        if (Gz != null && Gz.aHZ != null) {
            this.okK.setBgImageUrl(Gz.aHZ.bg_cover, null);
        }
        eaV();
        this.okJ.cfH();
        if (this.bpT) {
            this.okJ.nG(false);
        }
        this.hlv = System.currentTimeMillis() / 1000;
        if (this.okQ != null) {
            this.okQ.a(this.mTbPageContext, this.occ, null, this.okK, this.okJ, this.bml, this.hIb, this.hlv, this.hIc, this.hIt);
            eaW();
        }
        cjN();
        if (Gz != null && Gz.mLiveInfo != null && Gz.mLiveInfo.live_status == 2) {
            this.okM.a(this.mSelectedPosition, this.okJ.Gz());
            d(Gz, false);
            this.bpT = false;
            return;
        }
        boolean z = (this.okQ == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ac.a.b.PO().cA(com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aLO && Gz != null && Gz.aId);
        ah.d(Gz);
        if (z) {
            if (!this.hIq || !TextUtils.equals(s.Uc(), this.hIr)) {
                ah.b(getPageContext(), false);
                e.Pv().Pw();
                this.hIq = true;
                this.hIr = s.Uc();
            }
            ah.GG();
        }
        if (this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null) {
            this.okJ.hi(this.okJ.Gz().mLiveInfo.live_id);
            this.hIm = true;
        }
        if (this.okQ != null) {
            this.okQ.b(this.hHW);
            this.okQ.mR(TextUtils.equals(this.hId, "1"));
            this.hId = "";
        }
        if (this.okN != null) {
            this.okN.a(this.aDh, this.okO);
        }
        a(this.okJ.Gz());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.okJ.Gz() != null && b.this.okJ.Gz().mLiveInfo != null) {
                    b.this.okJ.a(b.this.okJ.Gz().mLiveInfo.live_id, b.this.bml, b.this.hlv);
                }
            }
        });
        this.bpT = false;
        if (z && this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null && this.okJ.Gz().aHk != null && this.okQ != null) {
            long j = this.okJ.Gz().mLiveInfo.live_id;
            long j2 = this.okJ.Gz().mLiveInfo.room_id;
            String str2 = this.okJ.Gz().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (aj.GN() != null) {
                    aj.GN().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.hIH != null) {
                    this.hIH.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.JV() != null) {
                com.baidu.live.guardclub.e.JV().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.okT == null) {
                this.okT = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.okT.a(this.mTbPageContext.getPageActivity(), this.okJ.Gz(), this.otherParams);
        }
        if (this.okU == null) {
            this.okU = new com.baidu.tieba.yuyinala.liveroom.n.c(this.mTbPageContext);
        }
        if (z && this.okJ.Gz() != null && this.okJ.Gz().aHG != null && !this.hIp) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.okU.a(this.okJ.Gz(), this.okJ.Gz().aHG.userId);
                this.hIp = true;
            }
        }
    }

    private void eaV() {
        try {
            if (this.okJ != null && this.okJ.Gz() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.okJ.Gz().aHG.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okJ.Gz().aHZ.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bpT) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.okJ.Gz().aHZ.aRe, this.otherParams, this.mSelectedPosition + 1, this.bpT, this.okJ.Gz().mLiveInfo.feed_id);
                }
                if (!this.okJ.cfG().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.okJ.Gz().aHZ.aRe, this.otherParams, this.mSelectedPosition + 1, this.bpT, this.okJ.Gz().mLiveInfo.feed_id);
                    this.okJ.cfG().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.okJ.Gz().aHZ.aRe, this.otherParams, this.mSelectedPosition + 1, this.bpT, this.okJ.Gz().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.okJ.Gz().aHZ.aRe, this.otherParams, this.mSelectedPosition + 1, this.bpT, this.okJ.Gz().mLiveInfo.feed_id);
                this.okS = new StayTimeBean();
                this.okS.liveId = this.okJ.Gz().mLiveInfo.live_id;
                this.okS.roomId = this.okJ.Gz().mLiveInfo.room_id;
                this.okS.vid = this.okJ.Gz().mLiveInfo.feed_id;
                this.okS.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjU() {
        if (this.hHX) {
            this.okM.a(this.mSelectedPosition, cjS(), this.aDh);
            this.okM.b(this.mSelectedPosition, cjT(), this.aDh);
            this.hHX = false;
        }
        if (this.okP != null && cke()) {
            this.okP.ac(this.okJ.cfI());
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
        if (!this.hHZ) {
            this.mHandler.removeCallbacks(this.hIB);
            this.mHandler.postDelayed(this.hIB, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hHZ) {
                this.mHandler.removeCallbacks(this.hIA);
                this.mHandler.postDelayed(this.hIA, 5000L);
                return;
            }
            return;
        }
        if (!this.hHY) {
            c(qVar);
        }
        if (!this.hHZ) {
            this.mHandler.removeCallbacks(this.hIA);
            this.mHandler.postDelayed(this.hIA, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        if (this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null) {
            this.okJ.hi(this.okJ.Gz().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && wVar.aHG != null && wVar.aHG.logined == 1) {
            of(false);
        } else if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.okM.a(this.mSelectedPosition, this.okJ.Gz());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hHY) {
                ah.d(wVar);
                a(wVar);
            }
            if (!this.hHZ) {
                this.mHandler.removeCallbacks(this.hoA);
                this.mHandler.postDelayed(this.hoA, wVar.aHp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (this.mTbPageContext != null && this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null) {
            this.okJ.a(this.okJ.Gz().mLiveInfo.live_id, this.bml, this.hlv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        View view = null;
        mS(true);
        if (!cke()) {
            this.okJ.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.okK != null) {
                this.okK.VJ();
                this.okK.chj();
            }
            if (wVar != null && wVar.mLiveInfo != null) {
                this.hIh = wVar.mLiveInfo.live_id;
            }
            cjK();
            cjW();
            cjX();
            if (wVar != null) {
                if (this.okQ != null && this.okQ.bYn() != null) {
                    view = this.okQ.bYn().a(this.okQ.dXw().pageContext.getPageActivity(), wVar, z);
                }
                if (this.okK != null) {
                    this.okP.a(this.okK, view, wVar, z, this.okJ.cfI());
                }
                if (this.okQ != null) {
                    this.okQ.mS(false);
                    this.okQ.bYi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.okK != null) {
                    this.okK.chl();
                }
                long j = wVar.mLiveInfo.live_id;
                long j2 = wVar.mLiveInfo.room_id;
                String str = wVar.mLiveInfo.feed_id;
                long j3 = wVar.aHk.userId;
                String str2 = wVar.aHk.userName;
            }
            ckg();
            if (this.okN != null) {
                this.okN.a(this.aDh, this.okO);
            }
        }
    }

    private void cjW() {
    }

    private void cjX() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.okL);
        }
    }

    public void cjY() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cjZ();
        } else {
            cka();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.okJ != null && this.okJ.Gz() != null) {
            alaLiveInfoData = this.okJ.Gz().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cjZ();
        } else {
            cka();
        }
        this.okL.setIsScrollable(!z && this.hIu);
        if (this.okQ != null) {
            this.okQ.onKeyboardVisibilityChanged(z);
        }
        if (this.occ != null) {
            this.occ.onKeyboardVisibilityChanged(z);
        }
        if (this.ogd != null) {
            this.ogd.setMaskBg(z);
        }
    }

    public void dE(int i) {
    }

    public void cjZ() {
        if (this.okL != null) {
            i.ae(this.okL);
        }
    }

    public void cka() {
        if (this.okL != null) {
            i.af(this.okL);
        }
    }

    public void onResume() {
        if (this.okJ != null) {
            this.okJ.cfs();
        }
        if (this.okQ != null) {
            this.okQ.enterForeground();
        }
        if (this.okT != null) {
            this.okT.onResume();
        }
        if (this.okU != null) {
            this.okU.onResume();
        }
        if (this.hJb != null && !this.hJb.hasFocus()) {
            this.hJb.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.Do().onResume();
    }

    public void onStart() {
        if (!this.hIs) {
            if (this.hHZ) {
                this.hHZ = false;
                ckd();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void ckd() {
        cfl();
        cjV();
        this.okJ.cfH();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
        }
        if (this.okQ != null) {
            this.okQ.bYm();
        }
        if (this.okJ != null && this.okJ.Gz() != null && this.okJ.Gz().mLiveInfo != null) {
            this.okR.fc(this.okJ.Gz().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDh.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.okJ != null) {
            this.okJ.cft();
        }
        if (this.okQ != null) {
            this.okQ.enterBackground();
        }
        com.baidu.live.core.layer.b.Do().onPause();
    }

    public void oc(boolean z) {
        this.hHZ = true;
        og(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void og(boolean z) {
        this.mHandler.removeCallbacks(this.hoA);
        this.mHandler.removeCallbacks(this.hIA);
        this.mHandler.removeCallbacks(this.hIB);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || !z) {
        }
        if (this.okQ != null) {
            this.okQ.bYl();
        }
        this.okR.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aj.GN() != null) {
                aj.GN().a(i, i2, intent, this.aDh, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.okQ != null) {
            this.okQ.onActivityResult(i, i2, intent);
        }
    }

    private void au(w wVar) {
        if (wVar != null) {
            if (wVar.aHZ != null && !TextUtils.isEmpty(wVar.aHZ.bg_cover)) {
                this.okK.setBgImageUrl(wVar.aHZ.bg_cover, null);
            } else if (wVar.aHk != null && !TextUtils.isEmpty(wVar.aHk.portrait)) {
                this.okK.setBgImageUrl(wVar.aHk.portrait, 12, null);
            }
        }
    }

    public boolean cke() {
        return this.okP != null && this.okP.bRA();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hIT);
        MessageManager.getInstance().unRegisterListener(this.olc);
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.old);
        if (this.hIH != null) {
            this.hIH.release();
        }
        if (this.okN != null) {
            this.okN.onDestory();
        }
        if (this.ogd != null) {
            this.ogd.cFe();
        }
        if (this.okO != null) {
            this.okO.reset();
        }
        if (this.okQ != null) {
            this.okQ.onDestroy();
        }
        if (this.okM != null) {
            this.okM.onDestroy();
        }
        this.okK.VJ();
        if (this.okK != null) {
            this.okK.release();
            this.okK = null;
        }
        if (this.okP != null) {
            this.okP.onDestroy();
        }
        if (this.hJb != null) {
            this.hJb.abandonAudioFocus();
        }
        if (this.okS != null && this.okJ != null && this.okJ.Gz() != null) {
            if (this.okS.liveId == this.okJ.Gz().mLiveInfo.live_id && this.okS.startTime > 0) {
                this.okS.endTime = System.currentTimeMillis();
                long j = this.okS.endTime - this.okS.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.okJ.Gz().aHZ.aRe, this.otherParams, this.mSelectedPosition + 1, this.bpT, this.okJ.Gz().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.okS = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.okJ != null) {
                jSONObject.put("identity", this.okJ.Gz().aHG.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okJ.Gz().aHZ.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.occ != null) {
            this.occ.chq();
            this.occ = null;
        }
        if (this.okJ != null) {
            this.okJ.destory();
        }
        y.Gt().release();
        if (this.okU != null) {
            this.okU.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
    }

    public void oh(boolean z) {
        this.hIs = z;
    }

    public void ckf() {
        if (this.hIi != null) {
            this.otherParams = this.hIi.toString();
            if (this.okJ != null) {
                this.okJ.setOtherParams(this.otherParams);
            }
            if (this.okQ != null) {
                this.okQ.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.okP != null) {
                this.okP.setOtherParams(this.otherParams);
            }
        }
    }

    public void ckg() {
        if (this.hIi != null) {
            String optString = this.hIi.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hIi.put("tab", "live_jump");
                        this.hIi.put("tag", "");
                        this.hIi.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hIi.put("tab", "liveroom");
                        this.hIi.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ckf();
            }
        }
    }

    public void ckh() {
        ah.GJ();
    }

    private void eaW() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.okQ.e((short) 2);
        } else {
            this.okQ.dXx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.okX = bitmap;
            this.okK.setBgImageBitmap(this.okX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaX() {
        if (this.okX != null) {
            if (!this.okX.isRecycled()) {
                this.okX.recycle();
            }
            this.okX = null;
            au(this.aDh);
        }
    }

    public boolean dZG() {
        return this.hIs;
    }
}

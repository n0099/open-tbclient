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
    private w aES;
    private CustomMessageListener bek;
    private long bnV;
    private String bnW;
    private boolean brE;
    private String gUi;
    private long hIA;
    private JSONObject hIB;
    private boolean hIC;
    private boolean hIF;
    private boolean hII;
    private boolean hIJ;
    private String hIK;
    private boolean hIL;
    private bo hIM;
    private boolean hIN;
    private boolean hIO;
    private Runnable hIT;
    private Runnable hIU;
    private Runnable hIV;
    private AlaLastLiveroomInfo hIp;
    private boolean hIq;
    private boolean hIr;
    private boolean hIs;
    private boolean hIu;
    private ArrayList<AlaBroadcastGiftToastData> hIv;
    private String hIw;
    private String hIz;
    private c hJa;
    com.baidu.live.liveroom.a.c hJh;
    ViewPager.OnPageChangeListener hJi;
    CustomMessageListener hJm;
    private g hJu;
    private ViewGroup hlJ;
    private LayerRootView hlK;
    private long hlO;
    private Runnable hoT;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private a.InterfaceC0906a nXv;
    private AlaLiveView oay;
    private o oez;
    CustomMessageListener ojA;
    private d oje;
    private a ojf;
    private com.baidu.tieba.yuyinala.liveroom.i.a ojg;
    private AlaLiveRoomBlurPageLayout ojh;
    private AlaLoopViewPager oji;
    private AlaLoopViewPagerAdapter ojj;
    private com.baidu.tieba.yuyinala.liveroom.d.a ojk;
    private com.baidu.tieba.yuyinala.liveroom.d.b ojl;
    private com.baidu.tieba.yuyinala.endliveroom.a ojm;
    private com.baidu.tieba.yuyinala.liveroom.c.b ojn;
    private com.baidu.tieba.yuyinala.liveroom.task.b ojo;
    private StayTimeBean ojp;
    private com.baidu.tieba.yuyinala.liveroom.g.a ojq;
    private com.baidu.tieba.yuyinala.liveroom.n.c ojr;
    private Set<String> ojs;
    private int ojt;
    private Bitmap oju;
    private boolean ojv;
    private String ojw;
    private String ojx;
    private String ojy;
    private CustomMessageListener ojz;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hIq = true;
        this.hlO = 0L;
        this.hIr = false;
        this.brE = true;
        this.bnW = "";
        this.mForumName = "";
        this.hIs = false;
        this.hIu = false;
        this.hIw = "0";
        this.mHandler = new Handler();
        this.hIA = -1L;
        this.otherParams = "";
        this.hIC = false;
        this.ojo = com.baidu.tieba.yuyinala.liveroom.task.b.dYu();
        this.hIF = false;
        this.hIJ = false;
        this.hIL = false;
        this.hIO = false;
        this.ojs = new HashSet();
        this.hoT = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cfS();
            }
        };
        this.hIT = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckC();
            }
        };
        this.hIU = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.ojg.cgo();
            }
        };
        this.ojt = 5000;
        this.ojw = "";
        this.ojx = "";
        this.ojy = "";
        this.bek = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.hIV = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.13
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
        this.hJh = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.15
            @Override // com.baidu.live.liveroom.a.c
            public void ce(final boolean z) {
                if (!k.dZr().isShowing()) {
                    h.dZp().zb(false);
                    boolean aD = k.dZr().aD(b.this.mTbPageContext.getPageActivity());
                    k.dZr().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.15.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZt() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZu() {
                            if (z || b.this.ojn == null || b.this.ojn.bYR()) {
                                b.this.oe(true);
                                b.this.bWc();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZv() {
                        }
                    });
                    if (aD) {
                        if (z || b.this.ojn == null || b.this.ojn.bYR()) {
                            b.this.oe(true);
                            b.this.bWc();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cf(boolean z) {
                b.this.d(b.this.aES, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oji != null) {
                    b.this.oji.setIsScrollable(b.this.hIN && z);
                    b.this.oji.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cg(boolean z) {
            }
        };
        this.hJi = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.oay != null && b.this.ojg != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.h.sdk_neterror);
                        b.this.oji.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.ojp != null && b.this.ojg != null && b.this.ojg.Hi() != null && b.this.ojg.Hi().mLiveInfo != null && b.this.ojg.Hi().aJK != null) {
                        if (b.this.ojp.liveId == b.this.ojg.Hi().mLiveInfo.live_id && b.this.ojp.startTime > 0) {
                            b.this.ojp.endTime = System.currentTimeMillis();
                            long j = b.this.ojp.endTime - b.this.ojp.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.ojg.Hi().aJK.aSP, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.brE, b.this.ojg.Hi().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.ojp = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.ojg != null && b.this.ojg.Hi() != null && b.this.ojg.Hi().aJr != null) {
                            jSONObject.put("identity", b.this.ojg.Hi().aJr.getUserTypeStr());
                        }
                        if (b.this.ojg != null && b.this.ojg.Hi() != null && b.this.ojg.Hi().aJK != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.ojg.Hi().aJK.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.brE || b.this.ojg.cgn() == null || ListUtils.getCount(b.this.ojg.cgn()) > 1) {
                        if (b.this.ojg.cgs() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (b.this.ojg == null || !b.this.ojg.cgs() || i2 >= 0) {
                            if (b.this.ojg != null && b.this.ojg.cgt() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                                b.this.oji.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            if (b.this.ojg != null) {
                                b.this.ojg.cancelLoadData();
                            }
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.mR(true);
                            b.this.ojh.chQ();
                            b.this.ojh.Ws();
                            b.this.ojh.chR();
                            b.this.ckN();
                            if (b.this.hJa != null) {
                                b.this.hJa.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.ojh = b.this.ojj.Md(b.this.mSelectedPosition);
                            b.this.ojh.chS();
                            b.this.wD(i2);
                            b.this.eaV();
                            b.this.MB(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                        b.this.oji.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                    b.this.oji.setCurrentItem(b.this.mSelectedPosition);
                    b.this.ojg.g(b.this.ojg.cgx());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oji != null && i == 0) {
                    com.baidu.live.d.AZ().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.nXv = new a.InterfaceC0906a() { // from class: com.baidu.tieba.yuyinala.player.b.4
            @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0906a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.K(b.this.ojg.Hi());
                } else if (i2 == 2) {
                    b.this.f(b.this.ojg.bRq());
                } else if (i2 == 3) {
                    b.this.br(i, str);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.ckB();
                }
            }
        };
        this.hJm = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.ojg != null && b.this.ojg.Hi() != null && b.this.ojg.Hi().aJr != null) {
                        if (l.longValue() == b.this.ojg.Hi().aJr.userId) {
                            b.this.ojg.Hi().aJr.isNewUser = false;
                            if (b.this.ojq != null) {
                                b.this.ojq.n(b.this.ojg.Hi());
                            }
                        }
                    }
                }
            }
        };
        this.ojz = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.eaY();
                    } else {
                        b.this.Y((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.ojA = new CustomMessageListener(2501073) { // from class: com.baidu.tieba.yuyinala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.cfS();
            }
        };
        this.hlO = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.ojf = aVar;
        this.hIq = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.hJa = (c) runTask.getData();
        }
        this.ojg = new com.baidu.tieba.yuyinala.liveroom.i.a(getPageContext());
        this.ojg.a(this.nXv);
        this.ojm = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hJm);
        MessageManager.getInstance().registerListener(this.ojz);
        MessageManager.getInstance().registerListener(this.bek);
        MessageManager.getInstance().registerListener(this.ojA);
        this.hJu = new g(tbPageContext.getPageActivity());
        this.hJu.setIPlayerAudioFocusCallBack(new com.baidu.live.s.a() { // from class: com.baidu.tieba.yuyinala.player.b.11
            @Override // com.baidu.live.s.a
            public void cn(boolean z) {
                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN() != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().muteOrUnmuteAudio(!z);
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
                        this.hIv = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hIv.add(alaBroadcastGiftToastData);
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
        this.bnW = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bnW)) {
            this.bnW = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hIz = intent.getStringExtra("room_id");
        this.bnV = intent.getLongExtra("live_id", 0L);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("params"));
            String optString = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_URL);
            if (optString != null && !TextUtils.isEmpty(optString)) {
                this.ojw = new String(Base64.decode(optString.getBytes()));
                if (!this.ojw.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.ojw = "";
                }
            }
            String optString2 = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_BG);
            if (optString2 != null && !TextUtils.isEmpty(optString2)) {
                this.ojx = new String(Base64.decode(optString2.getBytes()));
                if (!this.ojx.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.ojx = "";
                }
            }
            this.ojy = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
        } catch (Exception e) {
        }
        this.hIC = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.ojg.b((AlaLiveInfoCoreData) serializableExtra);
            this.hIC = true;
        }
        TbConfig.liveScene = 2;
        ax(intent);
        this.hIN = this.hIM == null || !this.hIM.aPL;
        this.ojm.setOtherParams(this.otherParams);
        this.hIu = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        eaS();
        ckg();
        this.mHandler.removeCallbacks(this.hIV);
        this.mHandler.postDelayed(this.hIV, 1000L);
    }

    private void ax(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gUi = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hIB = new JSONObject(stringExtra);
                if (this.hIB != null) {
                    String optString2 = this.hIB.optString("enterRoomId");
                    String optString3 = this.hIB.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hIz, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bnV + "", optString3))) {
                        String optString4 = this.hIB.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hIB.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hIC) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bnV;
                            alaLiveInfoCoreData.screenDirection = this.hIB.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.ojg.b(alaLiveInfoCoreData);
                            this.hIC = true;
                        }
                    }
                    String optString6 = this.hIB.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hIM = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.ojg != null) {
                            this.ojg.HL(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gUi = jSONObject.optString("live_back_scheme");
                        this.hIM = new bo();
                        this.hIM.aPL = jSONObject.optInt("is_hot") == 1;
                        if (this.hIM.aPL) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hIM.aPM = jSONObject.optString("task_id");
                        this.hIM.aPK = TextUtils.isEmpty(this.hIM.aPM) ? false : true;
                        this.hIM.aPN = jSONObject.optInt("task_type");
                        this.hIM.aPO = jSONObject.optInt("task_im_count");
                        this.hIM.aPP = jSONObject.optLong("task_gift_total_price");
                        this.hIM.aPQ = jSONObject.optLong("task_watch_time");
                        this.hIM.aPR = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.ojl = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.ojl.setScheme(optString8);
                            this.ojl.setImageUrl(optString9);
                            this.ojl.setTitle(optString10);
                        }
                    }
                    this.hIw = this.hIB.optString("open_giftlist");
                    this.hIB.remove("cover");
                    this.hIB.remove("live_url");
                    this.hIB.remove("enterRoomId");
                    this.hIB.remove("enterLiveId");
                    this.hIB.remove("open_giftlist");
                    this.hIB.remove("extra");
                    this.otherParams = this.hIB.toString();
                    if (this.ojg != null) {
                        this.ojg.setOtherParams(this.otherParams);
                    }
                    this.hIB.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("source");
                    }
                    this.hIO = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hIB.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.ojg != null) {
                        this.ojg.wf(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hIp = new AlaLastLiveroomInfo();
                this.hIp.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bnV), String.valueOf(this.hIz), null, ckv());
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

    public void ckg() {
        boolean z = false;
        if (this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null && this.ojg.Hi().mLiveInfo.room_id > 0) {
            this.ojg.Vr(this.ojg.Hi().mLiveInfo.room_id + "");
        } else if (!TextUtils.isEmpty(this.hIz)) {
            this.ojg.Vr(this.hIz);
        }
        if (!TextUtils.isEmpty(this.uk)) {
            this.ojg.ar(this.uk, this.bnW, this.mForumName);
            z = true;
        } else if (this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null && this.ojg.Hi().mLiveInfo.live_id > 0) {
            this.ojg.a(this.ojg.Hi().mLiveInfo.live_id, false, this.bnW, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bnW = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oe(false);
                return;
            }
            this.ojg.ar(this.uk, this.bnW, this.mForumName);
            z = true;
        } else if (!TextUtils.isEmpty(this.hIz)) {
            this.ojg.In(this.hIz);
            z = true;
        } else if (this.bnV > 0) {
            this.ojg.a(this.bnV, false, this.bnW, "");
            z = true;
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oe(false);
        }
        if (z) {
            eaV();
        }
    }

    private void eaS() {
        this.brE = true;
        this.hIr = false;
        eaT();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        l(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.DX().n(this.hlK);
        this.ojn = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.ojn.a(this.hJh);
        this.ojn.setOtherParams(this.otherParams);
        this.ojn.mM(this.hIO);
        try {
            w wVar = new w();
            wVar.aKc = false;
            wVar.aJK = new cx();
            wVar.aJK.live_id = String.valueOf(this.bnV);
            wVar.aJK.cover = "";
            wVar.aJK.room_name = ".....";
            wVar.aJK.aSP = "0";
            wVar.aJK.croom_id = "0";
            wVar.aJK.is_followed = true;
            wVar.aJK.bg_cover = this.ojx;
            wVar.mLiveInfo = new AlaLiveInfoData();
            wVar.aJr = new AlaLiveUserInfoData();
            wVar.aJs = new v();
            wVar.aJP = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
            wVar.bp(true);
            this.ojg.setLiveShowData(wVar);
            ckj();
            ckh();
            this.ojn.a(wVar, this.ojw, this.ojy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eaT() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oji = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.oji.setOnPageChangeListener(this.hJi);
        this.oji.setBoundaryCaching(true);
        this.oji.setBackgroundResource(a.e.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.ojj = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.ojj.cdB();
        this.ojh = this.ojj.Mc(this.mSelectedPosition);
        try {
            if (!TextUtils.isEmpty(this.ojx)) {
                this.ojh.setBgImageUrl(this.ojx, null);
            } else {
                this.ojh.setDefaultBg();
            }
            this.ojj.Mc(0).setDefaultBg();
            this.ojj.Mc(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.ojg != null) {
            this.ojj.a(this.mSelectedPosition, this.ojg.Hi());
        }
        this.oji.setAdapter(this.ojj);
        this.oji.setCurrentItem(this.mSelectedPosition);
        this.oji.setIsScrollable(this.hIN);
        this.hlJ = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hlK = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
        this.oji.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.14
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                w Hi;
                if ((b.this.ojg == null || (Hi = b.this.ojg.Hi()) == null || Hi.mLiveInfo == null || Hi.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.ojv = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.ojg == null || !b.this.ojg.cgs() || rawY <= 0.0f) {
                            if (b.this.ojg == null || !b.this.ojg.cgt() || rawY >= 0.0f) {
                                if (k.dZr().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                h.dZp().zb(false);
                                k.dZr().aD(b.this.mTbPageContext.getPageActivity());
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
            public boolean Mb(int i) {
                w Hi;
                if (b.this.ojg == null || (Hi = b.this.ojg.Hi()) == null || Hi.mLiveInfo == null || Hi.mLiveInfo.live_status != 2) {
                    k.dZr().a(new k.a() { // from class: com.baidu.tieba.yuyinala.player.b.14.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZt() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZu() {
                            if (b.this.oji != null) {
                                if (b.this.ojg == null || !b.this.ojg.cgs() || !b.this.ojv) {
                                    if (b.this.ojg == null || !b.this.ojg.cgt() || b.this.ojv) {
                                        int currentItem = b.this.oji.getCurrentItem();
                                        if (b.this.ojv) {
                                            if (currentItem == 0) {
                                                b.this.oji.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oji.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oji.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oji.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oji.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oji.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
                        public void dZv() {
                        }
                    });
                    if (b.this.ojg != null && b.this.ojg.cgs() && b.this.ojv) {
                        return true;
                    }
                    if (b.this.ojg == null || !b.this.ojg.cgt() || b.this.ojv) {
                        if (k.dZr().isShowing()) {
                            return false;
                        }
                        h.dZp().zb(false);
                        return k.dZr().aD(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void l(Rect rect) {
        this.oez = o.dZA();
        this.oez.a(this.mTbPageContext, this.ojh, rect);
        this.oez.a(this);
    }

    private void ckh() {
        this.ojk = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hlJ);
    }

    private void d(Rect rect) {
        this.oay = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.yuyinala_liveroom_player_layout, null);
        this.oay.setSwipeClearEnable(false);
        this.oay.hwh = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.ojh.a(this.oay, layoutParams);
    }

    private void ckj() {
        if (this.ojg != null && this.ojg.Hi() != null) {
            this.aES = this.ojg.Hi();
            if (this.aES.mLiveInfo != null) {
                a(this.aES.mLiveInfo, this.hIC);
                if (this.aES.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hIs);
                    }
                    if (this.ojn != null) {
                        this.ojn.a(this.mTbPageContext, this.oay, null, this.ojh, this.ojg, this.bnW, this.hIu, this.hlO, this.hIv, this.hIM);
                        eaX();
                    }
                }
            }
        }
    }

    private void ckr() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hIu || !this.hIN) {
                this.oji.setIsScrollable(false);
            } else {
                this.oji.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.DX().onBackPressed() && ((this.ojn == null || !this.ojn.onKeyDown(i, keyEvent)) && (this.ojn == null || !this.ojn.bYQ()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                ckr();
            } else if (!k.dZr().aD(this.mTbPageContext.getPageActivity())) {
                h.dZp().zb(false);
            } else if (this.ojn == null || this.ojn.bYR()) {
                oe(true);
                bWc();
            }
        }
        return true;
    }

    public void bWc() {
        if (!TextUtils.isEmpty(this.gUi)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gUi);
                this.gUi = null;
            }
        }
    }

    public void oe(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mR(!z);
        com.baidu.live.core.layer.b.DX().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        ckt();
        long j = -1;
        if (this.ojg != null && this.ojg.cgx() != null) {
            j = this.ojg.cgx().room_id;
        }
        this.ojf.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void mR(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hIp = null;
        if (aj.Hw() != null) {
            aj.Hw().Hv();
        }
        com.baidu.live.core.layer.b.DX().DY();
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().cW(this.oay);
        if (this.hJa != null) {
            this.hJa.release();
        }
        if (this.ojq != null) {
            this.ojq.release();
        }
        this.hIM = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oji);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.ojg != null) {
            this.ojg.HL(null);
            AlaLiveInfoData cgx = this.ojg.cgx();
            if (cgx != null) {
                this.ojg.eZ(cgx.live_id);
            }
        }
        this.ojo.stopRecord();
        LiveTimerManager.getInstance().stop();
        cks();
        if (this.ojn != null) {
            this.ojn.mR(z);
        }
        this.hIF = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Nu().bnm != null) {
            com.baidu.live.liveroom.a.b.Nu().bnm.b(this.aES.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().aAm();
        }
        ah.hd("");
    }

    private void cks() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void ckt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.aJK != null && this.ojg.nXE) {
                this.ojh.setBgImageUrl(wVar.aJK.bg_cover, null);
            }
            at(wVar);
            this.aES = wVar;
            if (this.ojn != null) {
                this.ojn.a(wVar);
            }
        }
    }

    private void at(final w wVar) {
        List<ct.a> list;
        if (wVar.aJL != null && wVar.aJK != null && (list = wVar.aJL.aSA) != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final ct.a aVar = list.get(i);
                if (aVar != null) {
                    String str = aVar.aSD + aVar.aSF + aVar.aSH + wVar.aJK.aSP;
                    if (!this.ojs.contains(str)) {
                        int currentTimeMillis = (int) (aVar.aSD - (System.currentTimeMillis() / 1000));
                        this.ojs.add(str);
                        if (this.oje == null) {
                            this.oje = new d(getPageContext().getPageActivity());
                        }
                        final boolean z = (!eaU() || StringUtils.isNull(aVar.aSF, true) || StringUtils.isNull(aVar.aSH, true)) ? false : true;
                        if (currentTimeMillis >= 25) {
                            if (!this.oje.isShowing()) {
                                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.16
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.oje.a(z, aVar.aSD, aVar.aSF, aVar.aSH, wVar.aJK.aSP, wVar.aJK.live_id, wVar.aJK.croom_id, aVar.aSE, aVar.aSG, wVar.aJL.aSz + "", wVar.aJK.is_followed);
                                    }
                                }, z ? (currentTimeMillis - 25) * 1000 : (currentTimeMillis - 15) * 1000);
                            }
                        } else if (currentTimeMillis < 25 && currentTimeMillis > 3 && !this.oje.isShowing()) {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.oje.a(false, aVar.aSD, aVar.aSF, aVar.aSH, wVar.aJK.aSP, wVar.aJK.live_id, wVar.aJK.croom_id, aVar.aSE, aVar.aSG, wVar.aJL.aSz + "", wVar.aJK.is_followed);
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

    private boolean eaU() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNy == null || com.baidu.live.aa.a.PQ().bod.aNy.aQG == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().a(com.baidu.live.aa.a.PQ().bod.aNy.aQG.EU(), true);
    }

    private void c(q qVar) {
        if (this.ojn != null) {
            this.ojn.c(qVar);
        }
    }

    private void N(w wVar) {
        this.aES = wVar;
    }

    private void cku() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oji.setIsScrollable(false);
            this.hIN = false;
        }
        if (this.aES != null) {
            a(this.aES.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.ojh.a(this.oay, null);
            a(this.ojh, this.aES.mLiveInfo, this.brE);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aES.mLiveInfo.live_id), String.valueOf(this.aES.mLiveInfo.room_id), String.valueOf(this.aES.mLiveInfo.feed_id), ckv());
            if (com.baidu.live.liveroom.a.b.Nu().bnm != null) {
                com.baidu.live.liveroom.a.b.Nu().bnm.a(this.aES.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
                String str = "normal";
                if (this.aES != null && this.aES.aJP != null && this.aES.aJP.getRoomMode() == 1) {
                    str = "dating";
                }
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.brE = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String ckv() {
        if (this.hIB == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hIB.optString("source");
            String optString2 = this.hIB.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hIB.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hIB.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hIB.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        ViewGroup dZC = this.oez.dZC();
        if (dZC != null && dZC.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.ck(dZC)) {
                        ((ViewGroup) dZC.getParent()).removeView(dZC);
                        alaLiveRoomBlurPageLayout.d(dZC, null);
                        this.oez.dZB();
                    } else if (this.oez != null) {
                        this.oez.dZB();
                    }
                } else if (this.oez != null) {
                    this.oez.dZB();
                }
            } else if (this.oez != null) {
                this.oez.dZB();
            }
        } else if (dZC != null && dZC.getParent() == null) {
            alaLiveRoomBlurPageLayout.d(dZC, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        ViewGroup dZC = this.oez.dZC();
        if (dZC != null) {
            dZC.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = com.baidu.live.utils.o.v(this.mTbPageContext.getPageActivity());
                layoutParams.height = com.baidu.live.utils.o.w(this.mTbPageContext.getPageActivity());
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

    public void ckw() {
        this.brE = true;
    }

    public boolean ckx() {
        return this.brE;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        ViewGroup dZC;
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
        if (this.oez != null && (dZC = this.oez.dZC()) != null) {
            int i2 = dZC.getLayoutParams().width;
            int i3 = dZC.getLayoutParams().height;
            int i4 = dZC.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) dZC.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.oay != null) {
                this.oay.setLayoutParams(c);
            }
            if (this.ojh != null) {
                this.ojh.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ojm != null) {
                this.ojm.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ojn != null) {
                this.ojn.l(c.width, c.height, realScreenOrientation);
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
                this.ojg.Vr(alaLiveInfoData.room_id + "");
            }
            this.ojg.a(alaLiveInfoData.live_id, true, this.bnW, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MB(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            w Hi = this.ojg.Hi();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Hi.aJK.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : MapBundleKey.OfflineMapKey.OFFLINE_UPDATE);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void wD(int i) {
        if (i < 0) {
            this.ojg.wg(this.ojg.cgu() - 1);
        } else if (i > 0) {
            this.ojg.wg(this.ojg.cgu() + 1);
        }
        if (this.ojn != null) {
            this.ojn.a(this.ojh);
        }
        this.ojj.a(this.mSelectedPosition, ckz(), this.aES);
        this.ojj.b(this.mSelectedPosition, ckA(), this.aES);
        if (this.ojg != null) {
            AlaLiveInfoData cgx = this.ojg.cgx();
            if (cgx != null) {
                cgx.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.ojh, cgx, this.brE);
                this.brE = false;
                if (this.ojn != null) {
                    this.ojn.a(this.mTbPageContext, this.oay, null, this.ojh, this.ojg, this.bnW, this.hIu, this.hlO, null, this.hIM);
                    eaX();
                }
                a(cgx, false);
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.oay.findViewById(a.f.ala_live_header_view);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.oay.findViewById(a.f.ala_live_footer_view);
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            try {
                w wVar = new w();
                wVar.aKc = false;
                wVar.aJK = new cx();
                if (cgx != null) {
                    this.ojh.setBgImageUrl(cgx.bg_cover, null);
                    wVar.aJK.bg_cover = cgx.bg_cover;
                    wVar.aJK.live_id = String.valueOf(cgx.live_id);
                    wVar.aJK.cover = cgx.cover;
                    wVar.aJK.aSP = String.valueOf(cgx.room_id);
                    wVar.aJK.croom_id = cgx.croom_id;
                    wVar.aJK.is_followed = cgx.is_followed;
                    wVar.aJK.room_name = cgx.room_name;
                }
                wVar.mLiveInfo = new AlaLiveInfoData();
                if (cgx != null) {
                    wVar.mLiveInfo.live_id = cgx.live_id;
                }
                wVar.aJr = new AlaLiveUserInfoData();
                wVar.aJs = new v();
                wVar.aJP = new AlaWheatInfoDataWrapper("{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }");
                wVar.bp(true);
                this.ojg.setLiveShowData(wVar);
                wVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
                String str = (cgx == null || cgx.session_info == null) ? "" : cgx.session_info.flvUrl;
                String str2 = "";
                if (cgx != null && !TextUtils.isEmpty(cgx.chat_mcast_id)) {
                    str2 = cgx.chat_mcast_id;
                }
                if (cgx != null && TextUtils.isEmpty(str2)) {
                    str2 = String.valueOf(cgx.room_id);
                }
                if (this.ojn != null) {
                    this.ojn.a(wVar, str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i(cgx);
            this.ojh.a(this.oay, null);
            if (this.ojn != null) {
                this.ojn.bYO();
            }
            this.ojg.g(cgx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaV() {
        com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.a.eae().bbU();
    }

    private AlaLiveInfoData ckz() {
        List<AlaLiveInfoData> cgn = this.ojg.cgn();
        if (cgn == null || cgn.size() == 0) {
            if (this.aES == null) {
                return null;
            }
            return this.aES.mLiveInfo;
        }
        int cgu = this.ojg.cgu();
        int size = cgn.size();
        return cgn.get(((cgu + size) - 1) % size);
    }

    private AlaLiveInfoData ckA() {
        List<AlaLiveInfoData> cgn = this.ojg.cgn();
        if (cgn == null || cgn.size() == 0) {
            if (this.aES == null) {
                return null;
            }
            return this.aES.mLiveInfo;
        }
        return cgn.get((this.ojg.cgu() + 1) % cgn.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        TbConfig.liveScene = 2;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hIs) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oe(false);
            return;
        }
        w Hi = this.ojg.Hi();
        N(Hi);
        if (Hi != null && Hi.aJK != null) {
            this.ojh.setBgImageUrl(Hi.aJK.bg_cover, null);
        }
        eaW();
        this.ojg.cgo();
        if (this.brE) {
            this.ojg.nF(false);
        }
        this.hlO = System.currentTimeMillis() / 1000;
        if (this.ojn != null) {
            this.ojn.a(this.mTbPageContext, this.oay, null, this.ojh, this.ojg, this.bnW, this.hIu, this.hlO, this.hIv, this.hIM);
            eaX();
        }
        cku();
        if (Hi != null && Hi.mLiveInfo != null && Hi.mLiveInfo.live_status == 2) {
            this.ojj.a(this.mSelectedPosition, this.ojg.Hi());
            d(Hi, false);
            this.brE = false;
            return;
        }
        boolean z = (this.ojn == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ac.a.b.Qx().cy(com.baidu.live.aa.a.PQ().bod != null && com.baidu.live.aa.a.PQ().bod.aNz && Hi != null && Hi.aJO);
        ah.d(Hi);
        if (z) {
            if (!this.hIJ || !TextUtils.equals(s.UL(), this.hIK)) {
                ah.b(getPageContext(), false);
                e.Qe().Qf();
                this.hIJ = true;
                this.hIK = s.UL();
            }
            ah.Hp();
        }
        if (this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null) {
            this.ojg.hf(this.ojg.Hi().mLiveInfo.live_id);
            this.hIF = true;
        }
        if (this.ojn != null) {
            this.ojn.b(this.hIp);
            this.ojn.mQ(TextUtils.equals(this.hIw, "1"));
            this.hIw = "";
        }
        if (this.ojk != null) {
            this.ojk.a(this.aES, this.ojl);
        }
        a(this.ojg.Hi());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.ojg.Hi() != null && b.this.ojg.Hi().mLiveInfo != null) {
                    b.this.ojg.a(b.this.ojg.Hi().mLiveInfo.live_id, b.this.bnW, b.this.hlO);
                }
            }
        });
        this.brE = false;
        if (z && this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null && this.ojg.Hi().aIV != null && this.ojn != null) {
            long j = this.ojg.Hi().mLiveInfo.live_id;
            long j2 = this.ojg.Hi().mLiveInfo.room_id;
            String str2 = this.ojg.Hi().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (aj.Hw() != null) {
                    aj.Hw().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.hJa != null) {
                    this.hJa.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.KE() != null) {
                com.baidu.live.guardclub.e.KE().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.ojq == null) {
                this.ojq = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.ojq.a(this.mTbPageContext.getPageActivity(), this.ojg.Hi(), this.otherParams);
        }
        if (this.ojr == null) {
            this.ojr = new com.baidu.tieba.yuyinala.liveroom.n.c(this.mTbPageContext);
        }
        if (z && this.ojg.Hi() != null && this.ojg.Hi().aJr != null && !this.hII) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.ojr.a(this.ojg.Hi(), this.ojg.Hi().aJr.userId);
                this.hII = true;
            }
        }
    }

    private void eaW() {
        try {
            if (this.ojg != null && this.ojg.Hi() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.ojg.Hi().aJr.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ojg.Hi().aJK.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.brE) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.ojg.Hi().aJK.aSP, this.otherParams, this.mSelectedPosition + 1, this.brE, this.ojg.Hi().mLiveInfo.feed_id);
                }
                if (!this.ojg.cgn().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.ojg.Hi().aJK.aSP, this.otherParams, this.mSelectedPosition + 1, this.brE, this.ojg.Hi().mLiveInfo.feed_id);
                    this.ojg.cgn().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.ojg.Hi().aJK.aSP, this.otherParams, this.mSelectedPosition + 1, this.brE, this.ojg.Hi().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.ojg.Hi().aJK.aSP, this.otherParams, this.mSelectedPosition + 1, this.brE, this.ojg.Hi().mLiveInfo.feed_id);
                this.ojp = new StayTimeBean();
                this.ojp.liveId = this.ojg.Hi().mLiveInfo.live_id;
                this.ojp.roomId = this.ojg.Hi().mLiveInfo.room_id;
                this.ojp.vid = this.ojg.Hi().mLiveInfo.feed_id;
                this.ojp.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckB() {
        if (this.hIq) {
            this.ojj.a(this.mSelectedPosition, ckz(), this.aES);
            this.ojj.b(this.mSelectedPosition, ckA(), this.aES);
            this.hIq = false;
        }
        if (this.ojm != null && ckL()) {
            this.ojm.ac(this.ojg.cgp());
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
        if (!this.hIs) {
            this.mHandler.removeCallbacks(this.hIU);
            this.mHandler.postDelayed(this.hIU, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hIs) {
                this.mHandler.removeCallbacks(this.hIT);
                this.mHandler.postDelayed(this.hIT, 5000L);
                return;
            }
            return;
        }
        if (!this.hIr) {
            c(qVar);
        }
        if (!this.hIs) {
            this.mHandler.removeCallbacks(this.hIT);
            this.mHandler.postDelayed(this.hIT, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckC() {
        if (this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null) {
            this.ojg.hf(this.ojg.Hi().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && wVar.aJr != null && wVar.aJr.logined == 1) {
            oe(false);
        } else if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.ojj.a(this.mSelectedPosition, this.ojg.Hi());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hIr) {
                ah.d(wVar);
                a(wVar);
            }
            if (!this.hIs) {
                this.mHandler.removeCallbacks(this.hoT);
                this.mHandler.postDelayed(this.hoT, wVar.aJa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfS() {
        if (this.mTbPageContext != null && this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null) {
            this.ojg.a(this.ojg.Hi().mLiveInfo.live_id, this.bnW, this.hlO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        View view = null;
        mR(true);
        if (!ckL()) {
            this.ojg.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.ojh != null) {
                this.ojh.Ws();
                this.ojh.chQ();
            }
            if (wVar != null && wVar.mLiveInfo != null) {
                this.hIA = wVar.mLiveInfo.live_id;
            }
            ckr();
            ckD();
            ckE();
            if (wVar != null) {
                if (this.ojn != null && this.ojn.bYU() != null) {
                    view = this.ojn.bYU().a(this.ojn.dXx().pageContext.getPageActivity(), wVar, z);
                }
                if (this.ojh != null) {
                    this.ojm.a(this.ojh, view, wVar, z, this.ojg.cgp());
                }
                if (this.ojn != null) {
                    this.ojn.mR(false);
                    this.ojn.bYP();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.ojh != null) {
                    this.ojh.chS();
                }
                long j = wVar.mLiveInfo.live_id;
                long j2 = wVar.mLiveInfo.room_id;
                String str = wVar.mLiveInfo.feed_id;
                long j3 = wVar.aIV.userId;
                String str2 = wVar.aIV.userName;
            }
            ckN();
            if (this.ojk != null) {
                this.ojk.a(this.aES, this.ojl);
            }
        }
    }

    private void ckD() {
    }

    private void ckE() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oji);
        }
    }

    public void ckF() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            ckG();
        } else {
            ckH();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.ojg != null && this.ojg.Hi() != null) {
            alaLiveInfoData = this.ojg.Hi().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            ckG();
        } else {
            ckH();
        }
        this.oji.setIsScrollable(!z && this.hIN);
        if (this.ojn != null) {
            this.ojn.onKeyboardVisibilityChanged(z);
        }
        if (this.oay != null) {
            this.oay.onKeyboardVisibilityChanged(z);
        }
        if (this.oez != null) {
            this.oez.setMaskBg(z);
        }
    }

    public void dI(int i) {
    }

    public void ckG() {
        if (this.oji != null) {
            i.ae(this.oji);
        }
    }

    public void ckH() {
        if (this.oji != null) {
            i.af(this.oji);
        }
    }

    public void onResume() {
        if (this.ojg != null) {
            this.ojg.cfZ();
        }
        if (this.ojn != null) {
            this.ojn.enterForeground();
        }
        if (this.ojq != null) {
            this.ojq.onResume();
        }
        if (this.ojr != null) {
            this.ojr.onResume();
        }
        if (this.hJu != null && !this.hJu.hasFocus()) {
            this.hJu.requestAudioFocus();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.DX().onResume();
    }

    public void onStart() {
        if (!this.hIL) {
            if (this.hIs) {
                this.hIs = false;
                ckK();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void ckK() {
        cfS();
        ckC();
        this.ojg.cgo();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
        }
        if (this.ojn != null) {
            this.ojn.bYT();
        }
        if (this.ojg != null && this.ojg.Hi() != null && this.ojg.Hi().mLiveInfo != null) {
            this.ojo.fc(this.ojg.Hi().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aES.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.ojg != null) {
            this.ojg.cga();
        }
        if (this.ojn != null) {
            this.ojn.enterBackground();
        }
        com.baidu.live.core.layer.b.DX().onPause();
    }

    public void ob(boolean z) {
        this.hIs = true;
        of(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void of(boolean z) {
        this.mHandler.removeCallbacks(this.hoT);
        this.mHandler.removeCallbacks(this.hIT);
        this.mHandler.removeCallbacks(this.hIU);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || !z) {
        }
        if (this.ojn != null) {
            this.ojn.bYS();
        }
        this.ojo.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aj.Hw() != null) {
                aj.Hw().a(i, i2, intent, this.aES, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ojn != null) {
            this.ojn.onActivityResult(i, i2, intent);
        }
    }

    private void au(w wVar) {
        if (wVar != null) {
            if (wVar.aJK != null && !TextUtils.isEmpty(wVar.aJK.bg_cover)) {
                this.ojh.setBgImageUrl(wVar.aJK.bg_cover, null);
            } else if (wVar.aIV != null && !TextUtils.isEmpty(wVar.aIV.portrait)) {
                this.ojh.setBgImageUrl(wVar.aIV.portrait, 12, null);
            }
        }
    }

    public boolean ckL() {
        return this.ojm != null && this.ojm.bSh();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hJm);
        MessageManager.getInstance().unRegisterListener(this.ojz);
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.ojA);
        if (this.hJa != null) {
            this.hJa.release();
        }
        if (this.ojk != null) {
            this.ojk.onDestory();
        }
        if (this.oez != null) {
            this.oez.cFz();
        }
        if (this.ojl != null) {
            this.ojl.reset();
        }
        if (this.ojn != null) {
            this.ojn.onDestroy();
        }
        if (this.ojj != null) {
            this.ojj.onDestroy();
        }
        this.ojh.Ws();
        if (this.ojh != null) {
            this.ojh.release();
            this.ojh = null;
        }
        if (this.ojm != null) {
            this.ojm.onDestroy();
        }
        if (this.hJu != null) {
            this.hJu.abandonAudioFocus();
        }
        if (this.ojp != null && this.ojg != null && this.ojg.Hi() != null) {
            if (this.ojp.liveId == this.ojg.Hi().mLiveInfo.live_id && this.ojp.startTime > 0) {
                this.ojp.endTime = System.currentTimeMillis();
                long j = this.ojp.endTime - this.ojp.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.ojg.Hi().aJK.aSP, this.otherParams, this.mSelectedPosition + 1, this.brE, this.ojg.Hi().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.ojp = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ojg != null) {
                jSONObject.put("identity", this.ojg.Hi().aJr.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ojg.Hi().aJK.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.oay != null) {
            this.oay.chX();
            this.oay = null;
        }
        if (this.ojg != null) {
            this.ojg.destory();
        }
        y.Hc().release();
        if (this.ojr != null) {
            this.ojr.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
    }

    public void og(boolean z) {
        this.hIL = z;
    }

    public void ckM() {
        if (this.hIB != null) {
            this.otherParams = this.hIB.toString();
            if (this.ojg != null) {
                this.ojg.setOtherParams(this.otherParams);
            }
            if (this.ojn != null) {
                this.ojn.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ojm != null) {
                this.ojm.setOtherParams(this.otherParams);
            }
        }
    }

    public void ckN() {
        if (this.hIB != null) {
            String optString = this.hIB.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hIB.put("tab", "live_jump");
                        this.hIB.put("tag", "");
                        this.hIB.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hIB.put("tab", "liveroom");
                        this.hIB.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ckM();
            }
        }
    }

    public void ckO() {
        ah.Hs();
    }

    private void eaX() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ojn.e((short) 2);
        } else {
            this.ojn.dXy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oju = bitmap;
            this.ojh.setBgImageBitmap(this.oju);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaY() {
        if (this.oju != null) {
            if (!this.oju.isRecycled()) {
                this.oju.recycle();
            }
            this.oju = null;
            au(this.aES);
        }
    }

    public boolean dZH() {
        return this.hIL;
    }
}

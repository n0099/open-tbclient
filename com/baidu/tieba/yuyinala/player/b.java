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
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.ac.c;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.d;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.bn;
import com.baidu.live.data.ct;
import com.baidu.live.data.q;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.ak;
import com.baidu.live.gift.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.utils.o;
import com.baidu.live.utils.s;
import com.baidu.live.z.e;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.yuyinala.liveroom.i.a;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveView;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.j;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.compatible.menukey.MenuKeyUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BdBaseView<TbPageContext> {
    private w aEc;
    private CustomMessageListener bcQ;
    private long bmB;
    private String bmC;
    private boolean bql;
    private String gNJ;
    private String hCC;
    private long hCD;
    private JSONObject hCE;
    private boolean hCF;
    private boolean hCI;
    private boolean hCL;
    private boolean hCM;
    private String hCN;
    private boolean hCO;
    private bn hCP;
    private boolean hCQ;
    private boolean hCR;
    private Runnable hCW;
    private Runnable hCX;
    private Runnable hCY;
    private AlaLastLiveroomInfo hCs;
    private boolean hCt;
    private boolean hCu;
    private boolean hCv;
    private boolean hCx;
    private ArrayList<AlaBroadcastGiftToastData> hCy;
    private String hCz;
    private c hDd;
    com.baidu.live.liveroom.a.c hDk;
    ViewPager.OnPageChangeListener hDl;
    CustomMessageListener hDp;
    private ViewGroup hfO;
    private LayerRootView hfP;
    private long hfT;
    private Runnable hjc;
    private String mForumName;
    private Handler mHandler;
    private float mLastY;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private a.InterfaceC0890a nQm;
    private AlaLiveView nTl;
    private n nXj;
    private a oah;
    private com.baidu.tieba.yuyinala.liveroom.i.a oai;
    private AlaLiveRoomBlurPageLayout oaj;
    private AlaLoopViewPager oak;
    private AlaLoopViewPagerAdapter oal;
    private com.baidu.tieba.yuyinala.liveroom.d.a oam;
    private com.baidu.tieba.yuyinala.liveroom.d.b oan;
    private com.baidu.tieba.yuyinala.endliveroom.a oao;
    private com.baidu.tieba.yuyinala.liveroom.c.b oap;
    private com.baidu.tieba.yuyinala.liveroom.task.b oaq;
    private StayTimeBean oar;
    private com.baidu.tieba.yuyinala.liveroom.g.a oas;
    private com.baidu.tieba.yuyinala.liveroom.n.c oat;
    private int oau;
    private Bitmap oav;
    private boolean oaw;
    private CustomMessageListener oax;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hCt = true;
        this.hfT = 0L;
        this.hCu = false;
        this.bql = true;
        this.bmC = "";
        this.mForumName = "";
        this.hCv = false;
        this.hCx = false;
        this.hCz = "0";
        this.mHandler = new Handler();
        this.hCD = -1L;
        this.otherParams = "";
        this.hCF = false;
        this.oaq = com.baidu.tieba.yuyinala.liveroom.task.b.dVF();
        this.hCI = false;
        this.hCM = false;
        this.hCO = false;
        this.hCR = false;
        this.hjc = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cdr();
            }
        };
        this.hCW = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.cia();
            }
        };
        this.hCX = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.oai.cdN();
            }
        };
        this.oau = 5000;
        this.bcQ = new CustomMessageListener(2501058) { // from class: com.baidu.tieba.yuyinala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_yuyin_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.hCY = new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.8
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
        this.hDk = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.yuyinala.player.b.10
            @Override // com.baidu.live.liveroom.a.c
            public void cd(final boolean z) {
                if (!j.dWs().isShowing()) {
                    g.dWq().yT(false);
                    boolean aB = j.dWs().aB(b.this.mTbPageContext.getPageActivity());
                    j.dWs().a(new j.a() { // from class: com.baidu.tieba.yuyinala.player.b.10.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWu() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWv() {
                            if (z || b.this.oap == null || b.this.oap.bWq()) {
                                b.this.nV(true);
                                b.this.bTu();
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWw() {
                        }
                    });
                    if (aB) {
                        if (z || b.this.oap == null || b.this.oap.bWq()) {
                            b.this.nV(true);
                            b.this.bTu();
                        }
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ce(boolean z) {
                b.this.d(b.this.aEc, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.oak != null) {
                    b.this.oak.setIsScrollable(b.this.hCQ && z);
                    b.this.oak.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cf(boolean z) {
            }
        };
        this.hDl = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.player.b.11
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int i2;
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.nTl != null && b.this.oai != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.oak.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    if (b.this.oar != null && b.this.oai != null && b.this.oai.GH() != null && b.this.oai.GH().mLiveInfo != null && b.this.oai.GH().aIS != null) {
                        if (b.this.oar.liveId == b.this.oai.GH().mLiveInfo.live_id && b.this.oar.startTime > 0) {
                            b.this.oar.endTime = System.currentTimeMillis();
                            long j = b.this.oar.endTime - b.this.oar.startTime;
                            LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(b.this.oai.GH().aIS.aRy, b.this.otherParams, b.this.mSelectedPosition + 1, b.this.bql, b.this.oai.GH().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
                        }
                        b.this.oar = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        if (b.this.oai != null && b.this.oai.GH() != null && b.this.oai.GH().aIA != null) {
                            jSONObject.put("identity", b.this.oai.GH().aIA.getUserTypeStr());
                        }
                        if (b.this.oai != null && b.this.oai.GH() != null && b.this.oai.GH().aIS != null) {
                            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.oai.GH().aIS.croom_id);
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                    if (b.this.bql || b.this.oai.cdM() == null || ListUtils.getCount(b.this.oai.cdM()) > 1) {
                        if (b.this.oai.cdR() && i - b.this.mSelectedPosition == 0) {
                            i2 = -1;
                        } else {
                            i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        }
                        if (!b.this.oai.cdR() || i2 >= 0) {
                            if (b.this.oai.cdS() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                b.this.oak.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            b.this.oai.cancelLoadData();
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.mI(true);
                            b.this.oaj.cfn();
                            b.this.oaj.TS();
                            b.this.oaj.cfo();
                            b.this.cil();
                            if (b.this.hDd != null) {
                                b.this.hDd.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.oaj = b.this.oal.LL(b.this.mSelectedPosition);
                            b.this.oaj.cfp();
                            b.this.wq(i2);
                            b.this.Mi(i2);
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                        b.this.oak.setCurrentItem(b.this.mSelectedPosition);
                        return;
                    }
                    b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                    b.this.oak.setCurrentItem(b.this.mSelectedPosition);
                    b.this.oai.g(b.this.oai.cdW());
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.oak != null && i == 0) {
                    d.AZ().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.nQm = new a.InterfaceC0890a() { // from class: com.baidu.tieba.yuyinala.player.b.12
            @Override // com.baidu.tieba.yuyinala.liveroom.i.a.InterfaceC0890a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.F(b.this.oai.GH());
                } else if (i2 == 2) {
                    b.this.f(b.this.oai.bOQ());
                } else if (i2 == 3) {
                    b.this.bn(i, str);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.chZ();
                }
            }
        };
        this.hDp = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.yuyinala.player.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.oai != null && b.this.oai.GH() != null && b.this.oai.GH().aIA != null) {
                        if (l.longValue() == b.this.oai.GH().aIA.userId) {
                            b.this.oai.GH().aIA.isNewUser = false;
                            if (b.this.oas != null) {
                                b.this.oas.o(b.this.oai.GH());
                            }
                        }
                    }
                }
            }
        };
        this.oax = new CustomMessageListener(2501019) { // from class: com.baidu.tieba.yuyinala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501019) {
                    Bitmap bitmap = null;
                    if (customResponsedMessage.getData() instanceof Bitmap) {
                        bitmap = (Bitmap) customResponsedMessage.getData();
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        b.this.dXq();
                    } else {
                        b.this.Y((Bitmap) customResponsedMessage.getData());
                    }
                }
            }
        };
        this.hfT = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.oah = aVar;
        this.hCt = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, c.class);
        if (runTask != null) {
            this.hDd = (c) runTask.getData();
        }
        this.oai = new com.baidu.tieba.yuyinala.liveroom.i.a(getPageContext());
        this.oai.a(this.nQm);
        this.oao = new com.baidu.tieba.yuyinala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hDp);
        MessageManager.getInstance().registerListener(this.oax);
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hCy = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hCy.add(alaBroadcastGiftToastData);
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
        this.bmC = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bmC)) {
            this.bmC = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hCC = intent.getStringExtra("room_id");
        this.bmB = intent.getLongExtra("live_id", 0L);
        this.hCF = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra instanceof AlaLiveInfoCoreData) {
            this.oai.b((AlaLiveInfoCoreData) serializableExtra);
            this.hCF = true;
        }
        ax(intent);
        this.hCQ = this.hCP == null || !this.hCP.aOO;
        this.oao.setOtherParams(this.otherParams);
        this.hCx = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        dXm();
        chE();
        this.mHandler.removeCallbacks(this.hCY);
        this.mHandler.postDelayed(this.hCY, 1000L);
    }

    private void ax(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gNJ = null;
            String stringExtra = intent.getStringExtra("params");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hCE = new JSONObject(stringExtra);
                if (this.hCE != null) {
                    String optString2 = this.hCE.optString("enterRoomId");
                    String optString3 = this.hCE.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hCC, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bmB + "", optString3))) {
                        String optString4 = this.hCE.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        String optString5 = this.hCE.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        if (!this.hCF) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bmB;
                            alaLiveInfoCoreData.screenDirection = this.hCE.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.oai.b(alaLiveInfoCoreData);
                            this.hCF = true;
                        }
                    }
                    String optString6 = this.hCE.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.hCP = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.oai != null) {
                            this.oai.Ht(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gNJ = jSONObject.optString("live_back_scheme");
                        this.hCP = new bn();
                        this.hCP.aOO = jSONObject.optInt("is_hot") == 1;
                        if (this.hCP.aOO) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hCP.aOP = jSONObject.optString("task_id");
                        this.hCP.aON = TextUtils.isEmpty(this.hCP.aOP) ? false : true;
                        this.hCP.aOQ = jSONObject.optInt("task_type");
                        this.hCP.aOR = jSONObject.optInt("task_im_count");
                        this.hCP.aOS = jSONObject.optLong("task_gift_total_price");
                        this.hCP.aOT = jSONObject.optLong("task_watch_time");
                        this.hCP.aOU = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.oan = new com.baidu.tieba.yuyinala.liveroom.d.b();
                            this.oan.setScheme(optString8);
                            this.oan.setImageUrl(optString9);
                            this.oan.setTitle(optString10);
                        }
                    }
                    this.hCz = this.hCE.optString("open_giftlist");
                    this.hCE.remove("cover");
                    this.hCE.remove("live_url");
                    this.hCE.remove("enterRoomId");
                    this.hCE.remove("enterLiveId");
                    this.hCE.remove("open_giftlist");
                    this.hCE.remove("extra");
                    this.otherParams = this.hCE.toString();
                    if (this.oai != null) {
                        this.oai.setOtherParams(this.otherParams);
                    }
                    this.hCE.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("source");
                    }
                    this.hCR = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hCE.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.oai != null) {
                        this.oai.vS(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hCs = new AlaLastLiveroomInfo();
                this.hCs.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bmB), String.valueOf(this.hCC), null, chT());
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

    public void chE() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.oai.aq(this.uk, this.bmC, this.mForumName);
        } else if (this.oai.GH() != null && this.oai.GH().mLiveInfo != null && this.oai.GH().mLiveInfo.live_id > 0) {
            this.oai.a(this.oai.GH().mLiveInfo.live_id, false, this.bmC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bmC = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                nV(false);
                return;
            }
            this.oai.aq(this.uk, this.bmC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hCC)) {
            this.oai.HW(this.hCC);
        } else if (this.bmB > 0) {
            this.oai.a(this.bmB, false, this.bmC, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            nV(false);
        }
    }

    private void dXm() {
        this.bql = true;
        this.hCu = false;
        dXn();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        k(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.DE().n(this.hfP);
        this.oap = new com.baidu.tieba.yuyinala.liveroom.c.b();
        this.oap.a(this.hDk);
        this.oap.setOtherParams(this.otherParams);
        this.oap.mD(this.hCR);
        try {
            w wVar = new w();
            wVar.aIS = new ct();
            wVar.aIS.live_id = String.valueOf(this.bmB);
            wVar.aIS.cover = "";
            wVar.aIS.room_name = ".....";
            wVar.aIS.aRy = "0";
            wVar.aIS.croom_id = "0";
            wVar.aIS.is_followed = true;
            wVar.mLiveInfo = new AlaLiveInfoData();
            wVar.aIA = new AlaLiveUserInfoData();
            wVar.aIB = new v();
            wVar.aIW = "{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }";
            wVar.bo(true);
            this.oai.d(wVar);
            chH();
            chF();
            this.oap.a(wVar, "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dXn() {
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.yuyinala_liveroom_main_layout, (ViewGroup) null);
        this.oak = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.oak.setOnPageChangeListener(this.hDl);
        this.oak.setBoundaryCaching(true);
        this.oak.setBackgroundResource(a.f.yuyin_sdk_defalut_bg);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.oal = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.oal.cba();
        this.oaj = this.oal.LK(this.mSelectedPosition);
        try {
            this.oaj.setDefaultBg();
            this.oal.LK(0).setDefaultBg();
            this.oal.LK(2).setDefaultBg();
        } catch (Exception e) {
        }
        if (this.oai != null) {
            this.oal.a(this.mSelectedPosition, this.oai.GH());
        }
        this.oak.setAdapter(this.oal);
        this.oak.setCurrentItem(this.mSelectedPosition);
        this.oak.setIsScrollable(this.hCQ);
        this.hfO = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.hfP = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
        this.oak.setListener(new AlaLoopViewPager.a() { // from class: com.baidu.tieba.yuyinala.player.b.9
            @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.a
            public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
                w GH;
                if ((b.this.oai == null || (GH = b.this.oai.GH()) == null || GH.mLiveInfo == null || GH.mLiveInfo.live_status != 2) && b.this.mTbPageContext != null) {
                    if (motionEvent.getAction() == 0) {
                        b.this.mLastY = motionEvent.getRawY();
                    } else if (motionEvent.getAction() == 1) {
                        b.this.oaw = motionEvent.getRawY() - b.this.mLastY > 0.0f;
                    }
                    int screenHeight = b.this.getScreenHeight(b.this.mTbPageContext.getPageActivity());
                    if (screenHeight <= 80) {
                        screenHeight = WBConstants.SDK_NEW_PAY_VERSION;
                    }
                    float rawY = motionEvent.getRawY() - b.this.mLastY;
                    if (Math.abs(rawY) >= screenHeight / 14) {
                        if (b.this.oai == null || !b.this.oai.cdR() || rawY <= 0.0f) {
                            if (b.this.oai == null || !b.this.oai.cdS() || rawY >= 0.0f) {
                                if (j.dWs().isShowing()) {
                                    return motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
                                }
                                g.dWq().yT(false);
                                j.dWs().aB(b.this.mTbPageContext.getPageActivity());
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
            public boolean LJ(int i) {
                w GH;
                if (b.this.oai == null || (GH = b.this.oai.GH()) == null || GH.mLiveInfo == null || GH.mLiveInfo.live_status != 2) {
                    j.dWs().a(new j.a() { // from class: com.baidu.tieba.yuyinala.player.b.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWu() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWv() {
                            if (b.this.oak != null) {
                                if (b.this.oai == null || !b.this.oai.cdR() || !b.this.oaw) {
                                    if (b.this.oai == null || !b.this.oai.cdS() || b.this.oaw) {
                                        int currentItem = b.this.oak.getCurrentItem();
                                        if (b.this.oaw) {
                                            if (currentItem == 0) {
                                                b.this.oak.setCurrentItem(2);
                                            } else if (currentItem == 1) {
                                                b.this.oak.setCurrentItem(0);
                                            } else if (currentItem == 2) {
                                                b.this.oak.setCurrentItem(1);
                                            }
                                        } else if (currentItem == 0) {
                                            b.this.oak.setCurrentItem(1);
                                        } else if (currentItem == 1) {
                                            b.this.oak.setCurrentItem(2);
                                        } else if (currentItem == 2) {
                                            b.this.oak.setCurrentItem(0);
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.j.a
                        public void dWw() {
                        }
                    });
                    if (b.this.oai != null && b.this.oai.cdR() && b.this.oaw) {
                        return true;
                    }
                    if (b.this.oai == null || !b.this.oai.cdS() || b.this.oaw) {
                        if (j.dWs().isShowing()) {
                            return false;
                        }
                        g.dWq().yT(false);
                        return j.dWs().aB(b.this.mTbPageContext.getPageActivity());
                    }
                    return true;
                }
                return true;
            }
        });
    }

    private void k(Rect rect) {
        this.nXj = n.dWB();
        this.nXj.a(this.mTbPageContext, this.oaj, rect);
        this.nXj.a(this);
    }

    private void chF() {
        this.oam = new com.baidu.tieba.yuyinala.liveroom.d.a(this.mTbPageContext, this.hfO);
    }

    private void d(Rect rect) {
        this.nTl = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.yuyinala_liveroom_player_layout, null);
        this.nTl.setSwipeClearEnable(false);
        this.nTl.hqj = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.oaj.a(this.nTl, layoutParams);
    }

    private void chH() {
        if (this.oai != null && this.oai.GH() != null) {
            this.aEc = this.oai.GH();
            if (this.aEc.mLiveInfo != null) {
                a(this.aEc.mLiveInfo, this.hCF);
                if (this.aEc.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hCv);
                    }
                    if (this.oap != null) {
                        this.oap.a(this.mTbPageContext, this.nTl, null, this.oaj, this.oai, this.bmC, this.hCx, this.hfT, this.hCy, this.hCP);
                        dXp();
                    }
                }
            }
        }
    }

    private void chP() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hCx || !this.hCQ) {
                this.oak.setIsScrollable(false);
            } else {
                this.oak.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.DE().onBackPressed() && ((this.oap == null || !this.oap.onKeyDown(i, keyEvent)) && (this.oap == null || !this.oap.bWp()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                chP();
            } else if (!j.dWs().aB(this.mTbPageContext.getPageActivity())) {
                g.dWq().yT(false);
            } else if (this.oap == null || this.oap.bWq()) {
                nV(true);
                bTu();
            }
        }
        return true;
    }

    public void bTu() {
        if (!TextUtils.isEmpty(this.gNJ)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gNJ);
                this.gNJ = null;
            }
        }
    }

    public void nV(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mI(!z);
        com.baidu.live.core.layer.b.DE().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        chR();
        long j = -1;
        if (this.oai != null && this.oai.cdW() != null) {
            j = this.oai.cdW().room_id;
        }
        this.oah.b(z, z2, j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject));
        UbcStatisticManager.getInstance().clear();
    }

    public void mI(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hCs = null;
        if (ak.GV() != null) {
            ak.GV().GU();
        }
        com.baidu.live.core.layer.b.DE().DF();
        if (this.hDd != null) {
            this.hDd.release();
        }
        if (this.oas != null) {
            this.oas.release();
        }
        this.hCP = null;
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2913097, "into_end_view");
        BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oak);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (this.oai != null) {
            this.oai.Ht(null);
            AlaLiveInfoData cdW = this.oai.cdW();
            if (cdW != null) {
                this.oai.eD(cdW.live_id);
            }
        }
        this.oaq.stopRecord();
        LiveTimerManager.getInstance().stop();
        chQ();
        if (this.oap != null) {
            this.oap.mI(z);
        }
        this.hCI = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.MU().blS != null) {
            com.baidu.live.liveroom.a.b.MU().blS.b(this.aEc.mLiveInfo);
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().axM();
        }
    }

    private void chQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void chR() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501049));
    }

    private void a(w wVar) {
        if (wVar != null) {
            if (wVar.aIS != null && this.oai.nQv) {
                this.oaj.setBgImageUrl(wVar.aIS.bg_cover, null);
            }
            this.aEc = wVar;
            if (this.oap != null) {
                this.oap.a(wVar);
            }
        }
    }

    private void c(q qVar) {
        if (this.oap != null) {
            this.oap.c(qVar);
        }
    }

    private void I(w wVar) {
        this.aEc = wVar;
    }

    private void chS() {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.oak.setIsScrollable(false);
            this.hCQ = false;
        }
        if (this.aEc != null) {
            a(this.aEc.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.oaj.a(this.nTl, null);
            a(this.oaj, this.aEc.mLiveInfo, this.bql);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aEc.mLiveInfo.live_id), String.valueOf(this.aEc.mLiveInfo.room_id), String.valueOf(this.aEc.mLiveInfo.feed_id), chT());
            if (com.baidu.live.liveroom.a.b.MU().blS != null) {
                com.baidu.live.liveroom.a.b.MU().blS.a(this.aEc.mLiveInfo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", UbcStatConstant.Page.VOICE_ROOM, "").setContentExt(jSONObject));
            this.bql = false;
            TbadkCoreApplication.getInst().setIsYuyinRoom(true);
        }
    }

    private String chT() {
        if (this.hCE == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hCE.optString("source");
            String optString2 = this.hCE.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hCE.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hCE.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.hCE.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        WheatLayout dWE = this.nXj.dWE();
        if (dWE != null && dWE.getParent() != null) {
            if (alaLiveInfoData != null) {
                if (!z) {
                    if (!alaLiveRoomBlurPageLayout.cf(dWE)) {
                        ((ViewGroup) dWE.getParent()).removeView(dWE);
                        alaLiveRoomBlurPageLayout.d(dWE, null);
                        this.nXj.dWC();
                    } else if (this.nXj != null) {
                        this.nXj.dWC();
                    }
                } else if (this.nXj != null) {
                    this.nXj.dWC();
                }
            } else if (this.nXj != null) {
                this.nXj.dWC();
            }
        } else if (dWE != null && dWE.getParent() == null) {
            alaLiveRoomBlurPageLayout.d(dWE, null);
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        WheatLayout dWE = this.nXj.dWE();
        if (dWE != null) {
            dWE.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.v(this.mTbPageContext.getPageActivity());
                int aH = o.aH(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aH + i;
                } else {
                    dimensionPixelSize = aH + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void chU() {
        this.bql = true;
    }

    public boolean chV() {
        return this.bql;
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
        WheatLayout dWE = this.nXj.dWE();
        if (dWE != null) {
            int i2 = dWE.getLayoutParams().width;
            int i3 = dWE.getLayoutParams().height;
            int i4 = dWE.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) dWE.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.nTl != null) {
                this.nTl.setLayoutParams(c);
            }
            if (this.oaj != null) {
                this.oaj.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oao != null) {
                this.oao.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.oap != null) {
                this.oap.l(c.width, c.height, realScreenOrientation);
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
            this.oai.a(alaLiveInfoData.live_id, true, this.bmC, this.mForumName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            w GH = this.oai.GH();
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, GH.aIS.croom_id);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, i < 0 ? "down" : MapBundleKey.OfflineMapKey.OFFLINE_UPDATE);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "slide").setContentExt(jSONObject));
    }

    public void wq(int i) {
        if (i < 0) {
            this.oai.vT(this.oai.cdT() - 1);
        } else if (i > 0) {
            this.oai.vT(this.oai.cdT() + 1);
        }
        if (this.oap != null) {
            this.oap.a(this.oaj);
        }
        this.oal.a(this.mSelectedPosition, chX(), this.aEc);
        this.oal.b(this.mSelectedPosition, chY(), this.aEc);
        if (this.oai != null) {
            AlaLiveInfoData cdW = this.oai.cdW();
            if (cdW != null) {
                cdW.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.oaj, cdW, this.bql);
                this.bql = false;
                if (this.oap != null) {
                    this.oap.a(this.mTbPageContext, this.nTl, null, this.oaj, this.oai, this.bmC, this.hCx, this.hfT, null, this.hCP);
                    dXp();
                }
                a(cdW, false);
            }
            try {
                w wVar = new w();
                wVar.aIS = new ct();
                if (cdW != null) {
                    this.oaj.setBgImageUrl(cdW.bg_cover, null);
                    wVar.aIS.bg_cover = cdW.bg_cover;
                    wVar.aIS.live_id = String.valueOf(cdW.live_id);
                    wVar.aIS.cover = cdW.cover;
                    wVar.aIS.aRy = String.valueOf(cdW.room_id);
                    wVar.aIS.croom_id = cdW.croom_id;
                    wVar.aIS.is_followed = cdW.is_followed;
                    wVar.aIS.room_name = cdW.room_name;
                }
                wVar.mLiveInfo = new AlaLiveInfoData();
                if (cdW != null) {
                    wVar.mLiveInfo.live_id = cdW.live_id;
                }
                wVar.aIA = new AlaLiveUserInfoData();
                wVar.aIB = new v();
                wVar.aIW = "{\n            \"host\": [\n                {}\n            ],\n            \"anchor\": [\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {},\n                {}\n            ]\n        }";
                wVar.bo(true);
                this.oai.d(wVar);
                wVar.mLiveInfo.session_info = new AlaLiveStreamSessionInfo();
                String str = (cdW == null || cdW.session_info == null) ? "" : cdW.session_info.flvUrl;
                String str2 = "";
                if (cdW != null && !TextUtils.isEmpty(cdW.chat_mcast_id)) {
                    str2 = cdW.chat_mcast_id;
                }
                if (cdW != null && TextUtils.isEmpty(str2)) {
                    str2 = String.valueOf(cdW.room_id);
                }
                if (this.oap != null) {
                    this.oap.a(wVar, str, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i(cdW);
            this.oaj.a(this.nTl, null);
            if (this.oap != null) {
                this.oap.bWn();
            }
            this.oai.g(cdW);
        }
    }

    private AlaLiveInfoData chX() {
        List<AlaLiveInfoData> cdM = this.oai.cdM();
        if (cdM == null || cdM.size() == 0) {
            if (this.aEc == null) {
                return null;
            }
            return this.aEc.mLiveInfo;
        }
        int cdT = this.oai.cdT();
        int size = cdM.size();
        return cdM.get(((cdT + size) - 1) % size);
    }

    private AlaLiveInfoData chY() {
        List<AlaLiveInfoData> cdM = this.oai.cdM();
        if (cdM == null || cdM.size() == 0) {
            if (this.aEc == null) {
                return null;
            }
            return this.aEc.mLiveInfo;
        }
        return cdM.get((this.oai.cdT() + 1) % cdM.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hCv) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            nV(false);
            return;
        }
        w GH = this.oai.GH();
        I(GH);
        if (GH != null && GH.aIS != null) {
            this.oaj.setBgImageUrl(GH.aIS.bg_cover, null);
        }
        dXo();
        this.oai.cdN();
        if (this.bql) {
            this.oai.nw(false);
        }
        this.hfT = System.currentTimeMillis() / 1000;
        if (this.oap != null) {
            this.oap.a(this.mTbPageContext, this.nTl, null, this.oaj, this.oai, this.bmC, this.hCx, this.hfT, this.hCy, this.hCP);
            dXp();
        }
        chS();
        if (GH != null && GH.mLiveInfo != null && GH.mLiveInfo.live_status == 2) {
            this.oal.a(this.mSelectedPosition, this.oai.GH());
            d(GH, false);
            this.bql = false;
            return;
        }
        boolean z = (this.oap == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ab.c.PX().cx(GH != null && GH.aIV);
        ai.e(GH);
        if (z) {
            if (!this.hCM || !TextUtils.equals(s.Sd(), this.hCN)) {
                ai.b(getPageContext(), false);
                e.PD().PE();
                this.hCM = true;
                this.hCN = s.Sd();
            }
            ai.GO();
        }
        if (this.oai.GH() != null && this.oai.GH().mLiveInfo != null) {
            this.oai.gJ(this.oai.GH().mLiveInfo.live_id);
            this.hCI = true;
        }
        if (this.oap != null) {
            this.oap.b(this.hCs);
            this.oap.mH(TextUtils.equals(this.hCz, "1"));
            this.hCz = "";
        }
        if (this.oam != null) {
            this.oam.a(this.aEc, this.oan);
        }
        a(this.oai.GH());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.oai.GH() != null && b.this.oai.GH().mLiveInfo != null) {
                    b.this.oai.a(b.this.oai.GH().mLiveInfo.live_id, b.this.bmC, b.this.hfT);
                }
            }
        });
        this.bql = false;
        if (z && this.oai.GH() != null && this.oai.GH().mLiveInfo != null && this.oai.GH().aIe != null && this.oap != null) {
            long j = this.oai.GH().mLiveInfo.live_id;
            long j2 = this.oai.GH().mLiveInfo.room_id;
            String str2 = this.oai.GH().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (ak.GV() != null) {
                    ak.GV().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                }
                if (this.hDd != null) {
                    this.hDd.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.Ke() != null) {
                com.baidu.live.guardclub.e.Ke().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.oas == null) {
                this.oas = new com.baidu.tieba.yuyinala.liveroom.g.a();
            }
            this.oas.a(this.mTbPageContext.getPageActivity(), this.oai.GH(), this.otherParams);
        }
        if (this.oat == null) {
            this.oat = new com.baidu.tieba.yuyinala.liveroom.n.c(this.mTbPageContext);
        }
        if (z && this.oai.GH() != null && this.oai.GH().aIA != null && !this.hCL) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.oat.a(this.oai.GH(), this.oai.GH().aIA.userId);
                this.hCL = true;
            }
        }
    }

    private void dXo() {
        try {
            if (this.oai != null && this.oai.GH() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put("identity", this.oai.GH().aIA.getUserTypeStr());
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oai.GH().aIS.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
                if (this.bql) {
                    LogManager.getYuyinLiveLogger().doAccessPlayYuyinLiveGuestLog(this.oai.GH().aIS.aRy, this.otherParams, this.mSelectedPosition + 1, this.bql, this.oai.GH().mLiveInfo.feed_id);
                }
                if (!this.oai.cdM().get(this.mSelectedPosition).hasLogShow) {
                    LogManager.getYuyinLiveLogger().doShowYuyinLiveGuestLog(this.oai.GH().aIS.aRy, this.otherParams, this.mSelectedPosition + 1, this.bql, this.oai.GH().mLiveInfo.feed_id);
                    this.oai.cdM().get(this.mSelectedPosition).hasLogShow = true;
                }
                LogManager.getYuyinLiveLogger().doClickYuyinLiveGuestLog(this.oai.GH().aIS.aRy, this.otherParams, this.mSelectedPosition + 1, this.bql, this.oai.GH().mLiveInfo.feed_id);
                LogManager.getYuyinLiveLogger().doStartPlayYuyinLiveGuestLog(this.oai.GH().aIS.aRy, this.otherParams, this.mSelectedPosition + 1, this.bql, this.oai.GH().mLiveInfo.feed_id);
                this.oar = new StayTimeBean();
                this.oar.liveId = this.oai.GH().mLiveInfo.live_id;
                this.oar.roomId = this.oai.GH().mLiveInfo.room_id;
                this.oar.vid = this.oai.GH().mLiveInfo.feed_id;
                this.oar.startTime = System.currentTimeMillis();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chZ() {
        if (this.hCt) {
            this.oal.a(this.mSelectedPosition, chX(), this.aEc);
            this.oal.b(this.mSelectedPosition, chY(), this.aEc);
            this.hCt = false;
        }
        if (this.oao != null && cij()) {
            this.oao.ac(this.oai.cdO());
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
        if (!this.hCv) {
            this.mHandler.removeCallbacks(this.hCX);
            this.mHandler.postDelayed(this.hCX, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hCv) {
                this.mHandler.removeCallbacks(this.hCW);
                this.mHandler.postDelayed(this.hCW, 5000L);
                return;
            }
            return;
        }
        if (!this.hCu) {
            c(qVar);
        }
        if (!this.hCv) {
            this.mHandler.removeCallbacks(this.hCW);
            this.mHandler.postDelayed(this.hCW, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cia() {
        if (this.oai.GH() != null && this.oai.GH().mLiveInfo != null) {
            this.oai.gJ(this.oai.GH().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(w wVar) {
        if (wVar != null && wVar.aIA != null && wVar.aIA.logined == 1) {
            nV(false);
        } else if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.oal.a(this.mSelectedPosition, this.oai.GH());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hCu) {
                ai.e(wVar);
                a(wVar);
            }
            if (!this.hCv) {
                this.mHandler.removeCallbacks(this.hjc);
                this.mHandler.postDelayed(this.hjc, wVar.aIj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
        if (this.mTbPageContext != null && this.oai.GH() != null && this.oai.GH().mLiveInfo != null) {
            this.oai.a(this.oai.GH().mLiveInfo.live_id, this.bmC, this.hfT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        View view = null;
        mI(true);
        if (!cij()) {
            this.oai.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.oaj != null) {
                this.oaj.TS();
                this.oaj.cfn();
            }
            if (wVar != null && wVar.mLiveInfo != null) {
                this.hCD = wVar.mLiveInfo.live_id;
            }
            chP();
            cib();
            cic();
            if (wVar != null) {
                if (this.oap != null && this.oap.bWt() != null) {
                    view = this.oap.bWt().a(this.oap.dUX().pageContext.getPageActivity(), wVar, z);
                }
                if (this.oaj != null) {
                    this.oao.a(this.oaj, view, wVar, z, this.oai.cdO());
                }
                if (this.oap != null) {
                    this.oap.mI(false);
                    this.oap.bWo();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.oaj != null) {
                    this.oaj.cfp();
                }
                long j = wVar.mLiveInfo.live_id;
                long j2 = wVar.mLiveInfo.room_id;
                String str = wVar.mLiveInfo.feed_id;
                long j3 = wVar.aIe.userId;
                String str2 = wVar.aIe.userName;
            }
            cil();
            if (this.oam != null) {
                this.oam.a(this.aEc, this.oan);
            }
        }
    }

    private void cib() {
    }

    private void cic() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.oak);
        }
    }

    public void cid() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cie();
        } else {
            cif();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.oai != null && this.oai.GH() != null) {
            alaLiveInfoData = this.oai.GH().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cie();
        } else {
            cif();
        }
        this.oak.setIsScrollable(!z && this.hCQ);
        if (this.oap != null) {
            this.oap.onKeyboardVisibilityChanged(z);
        }
        if (this.nTl != null) {
            this.nTl.onKeyboardVisibilityChanged(z);
        }
        if (this.nXj != null) {
            this.nXj.setMaskBg(z);
        }
    }

    public void dI(int i) {
    }

    public void cie() {
        if (this.oak != null) {
            i.aa(this.oak);
        }
    }

    public void cif() {
        if (this.oak != null) {
            i.ab(this.oak);
        }
    }

    public void onResume() {
        if (this.oai != null) {
            this.oai.cdy();
        }
        if (this.oap != null) {
            this.oap.enterForeground();
        }
        if (this.oas != null) {
            this.oas.onResume();
        }
        if (this.oat != null) {
            this.oat.onResume();
        }
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX() != null) {
            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().muteOrUnmuteAudio(false);
        }
        com.baidu.live.core.layer.b.DE().onResume();
    }

    public void onStart() {
        if (!this.hCO) {
            if (this.hCv) {
                this.hCv = false;
                cii();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void cii() {
        cdr();
        cia();
        this.oai.cdN();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
        }
        if (this.oap != null) {
            this.oap.bWs();
        }
        if (this.oai != null && this.oai.GH() != null && this.oai.GH().mLiveInfo != null) {
            this.oaq.eG(this.oai.GH().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aEc.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.oai != null) {
            this.oai.cdz();
        }
        if (this.oap != null) {
            this.oap.enterBackground();
        }
        com.baidu.live.core.layer.b.DE().onPause();
    }

    public void nS(boolean z) {
        this.hCv = true;
        nW(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void nW(boolean z) {
        this.mHandler.removeCallbacks(this.hjc);
        this.mHandler.removeCallbacks(this.hCW);
        this.mHandler.removeCallbacks(this.hCX);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || !z) {
        }
        if (this.oap != null) {
            this.oap.bWr();
        }
        this.oaq.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ak.GV() != null) {
                ak.GV().a(i, i2, intent, this.aEc, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.oap != null) {
            this.oap.onActivityResult(i, i2, intent);
        }
    }

    private void W(w wVar) {
        if (wVar != null) {
            if (wVar.aIS != null && !TextUtils.isEmpty(wVar.aIS.bg_cover)) {
                this.oaj.setBgImageUrl(wVar.aIS.bg_cover, null);
            } else if (wVar.aIe != null && !TextUtils.isEmpty(wVar.aIe.portrait)) {
                this.oaj.setBgImageUrl(wVar.aIe.portrait, 12, null);
            }
        }
    }

    public boolean cij() {
        return this.oao != null && this.oao.bPH();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.hDp);
        MessageManager.getInstance().unRegisterListener(this.oax);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        if (this.hDd != null) {
            this.hDd.release();
        }
        if (this.oam != null) {
            this.oam.onDestory();
        }
        if (this.oan != null) {
            this.oan.reset();
        }
        if (this.oap != null) {
            this.oap.onDestroy();
        }
        if (this.oal != null) {
            this.oal.onDestroy();
        }
        this.oaj.TS();
        if (this.oaj != null) {
            this.oaj.release();
            this.oaj = null;
        }
        if (this.oao != null) {
            this.oao.onDestroy();
        }
        if (this.oar != null && this.oai != null && this.oai.GH() != null) {
            if (this.oar.liveId == this.oai.GH().mLiveInfo.live_id && this.oar.startTime > 0) {
                this.oar.endTime = System.currentTimeMillis();
                long j = this.oar.endTime - this.oar.startTime;
                LogManager.getYuyinLiveLogger().doPlayYuyinLiveStayTimeLog(this.oai.GH().aIS.aRy, this.otherParams, this.mSelectedPosition + 1, this.bql, this.oai.GH().mLiveInfo.feed_id, (j >= 0 ? j : 0L) / 1000);
            }
            this.oar = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oai != null) {
                jSONObject.put("identity", this.oai.GH().aIA.getUserTypeStr());
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oai.GH().aIS.croom_id);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, "playtime").setContentExt(jSONObject));
        if (this.nTl != null) {
            this.nTl.cfu();
            this.nTl = null;
        }
        if (this.oai != null) {
            this.oai.destory();
        }
        z.GB().release();
        if (this.oat != null) {
            this.oat.release();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, UbcStatConstant.Page.VOICE_ROOM, LogConfig.VALUE_STAYTIME).setContentExt(jSONObject2));
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().onDestroy();
        TbadkCoreApplication.getInst().setIsYuyinRoom(false);
    }

    public void nX(boolean z) {
        this.hCO = z;
    }

    public void cik() {
        if (this.hCE != null) {
            this.otherParams = this.hCE.toString();
            if (this.oai != null) {
                this.oai.setOtherParams(this.otherParams);
            }
            if (this.oap != null) {
                this.oap.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.oao != null) {
                this.oao.setOtherParams(this.otherParams);
            }
        }
    }

    public void cil() {
        if (this.hCE != null) {
            String optString = this.hCE.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hCE.put("tab", "live_jump");
                        this.hCE.put("tag", "");
                        this.hCE.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hCE.put("tab", "liveroom");
                        this.hCE.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cik();
            }
        }
    }

    public void cim() {
        ai.GR();
    }

    private void dXp() {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.oap.e((short) 2);
        } else {
            this.oap.dUY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.oav = bitmap;
            this.oaj.setBgImageBitmap(this.oav);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXq() {
        if (this.oav != null) {
            if (!this.oav.isRecycled()) {
                this.oav.recycle();
            }
            this.oav = null;
            W(this.aEc);
        }
    }

    public boolean dWO() {
        return this.hCO;
    }
}

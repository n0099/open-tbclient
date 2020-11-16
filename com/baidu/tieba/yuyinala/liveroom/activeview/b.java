package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.aa.f;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.message.AudioGetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private w aDh;
    private int aIN;
    private long aWj;
    private List<String> gRt;
    private CustomMessageListener gRu;
    private HttpMessageListener gUP;
    private CustomMessageListener gUQ;
    private Runnable gUS;
    private boolean gUT;
    private com.baidu.live.g.a gUV;
    private String gUW;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c nVI;
    private HandlerC0905b nVL;
    private String otherParams;
    private String gUJ = "";
    private boolean isHost = false;
    private Map<Integer, c> gUK = new HashMap();
    private Map<Integer, AlaActiveRootView> gUL = new HashMap();
    private SimpleArrayMap<Integer, Integer> gUM = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> nVJ = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> nVK = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gUO = new ArrayList<>();
    private h bMh = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public void iN(String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter(UbcStatConstant.KEY_CONTENT_ROOM);
                if (TextUtils.isEmpty(queryParameter)) {
                    int indexOf = str.indexOf("room=");
                    int length = UbcStatConstant.KEY_CONTENT_ROOM.length() + 1;
                    if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                        queryParameter = str.substring(indexOf + length, indexOf + length + 1);
                    }
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        z = Integer.parseInt(queryParameter) == 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    b.this.Hp(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a nVD = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean vQ(int i) {
            return b.this.vQ(i);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            if (obj instanceof o) {
                b.this.a(view, (o) obj, i);
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void c(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aWj >= 400) {
                b.this.aWj = currentTimeMillis;
                if ((obj instanceof o) && b.this.aDh != null && b.this.aDh.aHk != null && b.this.aDh.mLiveInfo != null) {
                    o oVar = (o) obj;
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDh != null && b.this.aDh.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDh.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDh.aHk.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDh.aHk.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDh.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aDh.aHk.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aDh.aHk.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vQ(oVar.aGX)) {
                        b.this.vP(oVar.aGX);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vJ(i);
                        }
                    }
                    b.this.aW(oVar.aHc, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDh.mLiveInfo != null) {
                        str3 = b.this.aDh.mLiveInfo.feed_id;
                        str4 = b.this.aDh.mLiveInfo.live_id + "";
                    }
                    b.this.a(oVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gUL != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.gUL.get(Integer.valueOf(i2));
                            if (alaActiveRootView != null) {
                                View lastChild = alaActiveRootView.getLastChild();
                                if (lastChild instanceof AlaActiveBannerView) {
                                    ((AlaActiveBannerView) lastChild).setOtherParams(b.this.otherParams);
                                }
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    private boolean mRunning = true;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj, int i);

        void c(View view, Object obj, int i);

        boolean vQ(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gUM.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.guV);
    }

    public void Hm(String str) {
        this.gUW = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.gUT = z;
        for (int i = 1; i <= 2; i++) {
            Mz(i);
        }
        if (this.gUK != null) {
            this.gUK.clear();
        }
        i(wVar);
        if (this.aDh != null) {
            this.gUJ = d.Aq().getString("ala_active_view_click_info", "");
            bWk();
            bWl();
            bCq();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gUK.put(Integer.valueOf(i), new c(pendantParentView));
            Mx(i);
        }
    }

    private void bWk() {
        if (this.gUP == null) {
            this.gUP = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aDh == null || b.this.aDh.mLiveInfo == null || b.this.aDh.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDh.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bWm();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.NA() != null) {
                                b.this.aIN = audioGetLiveActivityHttpResponseMessage.NA().aIN;
                                b.this.cv(audioGetLiveActivityHttpResponseMessage.NA().aNy);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gUP);
    }

    private void bWl() {
        if (this.gUQ == null) {
            this.gUQ = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Hp((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gUQ);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.gUL != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.gUL.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.gUL != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.gUL.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bVl()) {
                        bVg();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.nVI != null) {
            this.nVI.resume();
        }
        bCq();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gUL != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gUL.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.nVI != null) {
            this.nVI.pause();
        }
        bWn();
        bVe();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aDh = wVar;
    }

    public void setVisible(int i) {
        if (this.gUL != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bM(i2, i);
            }
        }
    }

    public void bM(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.gUM.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bN = bN(i, i2);
        if (this.gUL != null && (alaActiveRootView = this.gUL.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bN);
        }
    }

    private int bN(int i, int i2) {
        if (this.nVJ != null && this.nVJ.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.gUM != null && this.gUM.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gUM.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ho(String str) {
        if (f.Px().hT(str)) {
            bCq();
        }
    }

    public void release() {
        this.aDh = null;
        this.gUW = null;
        if (this.gUP != null) {
            MessageManager.getInstance().unRegisterListener(this.gUP);
            this.gUP = null;
        }
        if (this.guV != null) {
            MessageManager.getInstance().unRegisterListener(this.guV);
            this.guV = null;
        }
        if (this.gUQ != null) {
            MessageManager.getInstance().unRegisterListener(this.gUQ);
            this.gUQ = null;
        }
        if (this.nVL != null) {
            this.nVL.removeCallbacksAndMessages(null);
        }
        f.Px().release();
        bVe();
        if (this.gUL != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gUL.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    cc(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.gUL.clear();
        }
        if (this.nVI != null) {
            this.nVI.release();
            this.nVI = null;
        }
    }

    public void mI(boolean z) {
    }

    public void updateView() {
        if (this.gUL != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.gUL.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bN(i2, this.gUM.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        if (this.aDh != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.aa.c.Pt().a(this.aDh.aHG.userUk, this.aDh.mLiveInfo.user_uk, this.aDh.mLiveInfo.room_id, this.aDh.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWm() {
        if (this.mRunning) {
            if (this.nVL == null) {
                this.nVL = new HandlerC0905b(this);
            }
            if (this.gUS == null) {
                this.gUS = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bCq();
                    }
                };
            }
            bWn();
            if (this.aIN <= 0) {
                this.aIN = 5;
            }
            this.nVL.postDelayed(this.gUS, this.aIN * 1000);
        }
    }

    private void bWn() {
        if (this.nVL != null && this.gUS != null) {
            this.nVL.removeCallbacks(this.gUS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cv(List<o> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (o oVar : list) {
                if (oVar != null) {
                    if (oVar.aGZ == 1) {
                        long j = oVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= oVar.showTime && j <= oVar.end_time && oVar.aHe != null && oVar.aHe.pos >= 0 && oVar.aHe.pos <= 2) {
                            if (oVar.aHe.pos == 0) {
                                oVar.aHe.pos = 1;
                            }
                            switch (oVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(oVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aHe.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(oVar.aHe.pos), list2);
                                        }
                                        list2.add(oVar);
                                        if (!z2 || oVar.aHd == null) {
                                            z = z2;
                                        } else {
                                            f.Px().b(oVar.aHd);
                                            z = true;
                                        }
                                        z2 = z;
                                        break;
                                    }
                                    break;
                                case 1:
                                case 2:
                                default:
                                    if (hashMap == null) {
                                    }
                                    list2 = (List) hashMap.get(Integer.valueOf(oVar.aHe.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(oVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(oVar.webUrl) && oVar.aHe != null && oVar.aHe.width > 0 && oVar.aHe.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aHe.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(oVar);
                                        if (z2) {
                                        }
                                        z = z2;
                                        z2 = z;
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (!z2) {
            f.Px().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void k(int i, List<o> list) {
        int i2;
        o oVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bWo();
            Mz(i);
            return;
        }
        Iterator<o> it = list.iterator();
        ArrayList<o> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            o next = it.next();
            if (next.picType == 3) {
                i2 = next.picType;
                oVar = next;
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(next);
            if (arrayList.size() >= 5) {
                i2 = 0;
                break;
            }
        }
        this.nVK.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                Mz(i);
                break;
            case 3:
                z = a(i, oVar);
                break;
        }
        c cVar = this.gUK.get(Integer.valueOf(i));
        if (cVar != null && cVar.gUY != null && z) {
            cVar.gUY.a(this.gUL.get(Integer.valueOf(i)));
        }
        bWp();
    }

    private void bWo() {
        if (this.gUV != null) {
            Iterator<com.baidu.live.g.b> it = this.gUO.iterator();
            while (it.hasNext()) {
                this.gUV.b(it.next());
            }
            this.gUO.clear();
            this.gUV.Ew();
        }
    }

    private void bWp() {
        if (this.gUV != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView My = My(i);
                if (My != null && My.getVisibility() == 0 && My.getChildCount() > 0 && !this.gUO.contains(My)) {
                    this.gUO.add(My);
                    this.gUV.a(My);
                }
            }
            this.gUV.Ew();
        }
    }

    private AlaActiveRootView Mx(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.gUL == null || (alaActiveRootView = this.gUL.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.gUK != null && (cVar = this.gUK.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gUY;
                if (pendantParentView == null || this.gUL == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gUL.put(Integer.valueOf(i), alaActiveRootView2);
                cc(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void cc(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView My(int i) {
        if (this.gUL != null) {
            return this.gUL.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<o> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            Mz(i);
            return false;
        }
        AlaActiveRootView My = My(i);
        if (My != null && My.getChildCount() == 1) {
            View lastChild = My.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.nVJ.put(Integer.valueOf(i), null);
        Mz(i);
        AlaActiveRootView Mx = Mx(i);
        if (Mx == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(Mx.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.nVD);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.gUT || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.gUT && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        Mx.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, o oVar) {
        String v = v(oVar.webUrl, oVar.jump_url, oVar.aHc);
        if (!TextUtils.isEmpty(v) && oVar.aHe != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, oVar.aHe.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, oVar.aHe.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView My = My(i);
            if (My != null && My.getChildCount() == 1) {
                View lastChild = My.getLastChild();
                if (lastChild instanceof AlaActiveWebView) {
                    if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(v)) {
                        ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                        ((AlaActiveWebView) lastChild).loadUrl(v);
                    }
                    ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                    if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                        layoutParams.width = applyDimension;
                        layoutParams.height = applyDimension2;
                        lastChild.setLayoutParams(layoutParams);
                    }
                    if (this.nVD != null) {
                        this.nVD.b(lastChild, oVar, 0);
                    }
                    return false;
                }
            }
            this.nVJ.put(Integer.valueOf(i), null);
            Mz(i);
            AlaActiveRootView Mx = Mx(i);
            if (Mx == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(Mx.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void mF(boolean z) {
                    if (z) {
                        b.this.bVg();
                    }
                }
            });
            g gVar = new g();
            gVar.x(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void eT(int i2) {
                    b.this.nVJ.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bMh);
            com.baidu.live.view.web.a[] Wo = gVar.Wo();
            for (com.baidu.live.view.web.a aVar : Wo) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(v);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.gUT || i == 2) {
                layoutParams2.gravity = 5;
            }
            Mx.addView(alaActiveWebView, layoutParams2);
            if (this.nVD != null) {
                this.nVD.b(alaActiveWebView, oVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String v(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aDh != null) {
            Map<String, Object> dXv = dXv();
            if (i == 2) {
                dXv.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            dXv.put(BigdayActivityConfig.JUMP_URL, aH(str2, i));
            return WebviewHelper.addQueryParams(str, dXv);
        }
        return str;
    }

    private Map<String, Object> dXv() {
        HashMap hashMap = new HashMap();
        if (this.aDh != null) {
            if (this.aDh.aHG != null) {
                hashMap.put("user_id", Long.valueOf(this.aDh.aHG.userId));
            }
            if (this.aDh.aHk != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aDh.aHk.userId));
            }
            if (this.aDh.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aDh.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aDh.mLiveInfo.live_id));
            }
        }
        hashMap.put("subapp_type", TbConfig.getSubappType());
        hashMap.put("_client_type", "2");
        hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        if (this.isHost) {
            hashMap.put("is_host", 1);
        }
        return hashMap;
    }

    private String aH(String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            str2 = WebviewHelper.addQueryParams(str, hashMap);
        } else {
            str2 = str;
        }
        try {
            return URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVi();
            if (this.nVL == null) {
                this.nVL = new HandlerC0905b(this);
            }
            if (!this.nVL.hasMessages(1000)) {
                this.nVL.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bVe() {
        if (this.gRt != null) {
            this.gRt.clear();
        }
        if (this.nVL != null) {
            this.nVL.removeMessages(1000);
        }
        bVf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gUL != null) {
            if (this.gRt == null || (size = this.gRt.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRt.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gRt.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.gUL.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bVl()) {
                        if (!TextUtils.isEmpty(str)) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                ((AlaActiveWebView) lastChild).evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                                z = true;
                                i2++;
                                z2 = z;
                            } else {
                                ((AlaActiveWebView) lastChild).loadUrl("javascript:getClientInfo(" + str + ")");
                            }
                        }
                        z = true;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.nVL.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bVe();
            }
        }
    }

    private void bVi() {
        if (this.gRt == null) {
            this.gRt = new ArrayList();
        }
        this.gRt.clear();
        this.gRu = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.gRt.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gRu);
    }

    private void bVf() {
        if (this.gRu != null) {
            MessageManager.getInstance().unRegisterListener(this.gRu);
            this.gRu = null;
        }
    }

    private void Mz(int i) {
        AlaActiveRootView My = My(i);
        if (My != null) {
            My.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> dXv = dXv();
                dXv.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, dXv);
                if (!TextUtils.isEmpty(this.gUW)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.gUW;
                }
                Hp(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, dXv());
            }
            if (!TextUtils.isEmpty(this.gUW)) {
                str = str + ETAG.ITEM_SEPARATOR + this.gUW;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Hp(String str) {
        int i;
        if (this.nVI == null) {
            this.nVI = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.nVI.setHost(this.isHost);
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            this.nVI.e(this.aDh.mLiveInfo.user_id, this.aDh.mLiveInfo.getNameShow(), this.aDh.aHk != null ? this.aDh.aHk.portrait : null);
            this.nVI.setLiveId(this.aDh.mLiveInfo.live_id);
        }
        if (!this.gUT) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.nVI.bR(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, o oVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aDh != null && this.aDh.aHZ != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
        }
        if (oVar != null && oVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (oVar != null && oVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aDh != null && this.aDh.aHZ != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
        }
        if (oVar != null && oVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (oVar != null && oVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gUJ)) {
                jSONArray = new JSONArray(this.gUJ);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gUJ = jSONArray.toString();
            d.Aq().putString("ala_active_view_click_info", this.gUJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vQ(int i) {
        if (StringUtils.isNull(this.gUJ)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gUJ);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.optInt(i2, -1) == i) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {
        PendantParentView gUY;

        c(PendantParentView pendantParentView) {
            this.gUY = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0905b extends Handler {
        private final WeakReference<b> gRD;

        HandlerC0905b(b bVar) {
            this.gRD = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRD.get() != null && message.what == 1000) {
                this.gRD.get().bVh();
            }
        }
    }
}

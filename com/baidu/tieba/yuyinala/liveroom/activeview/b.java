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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ae.f;
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
    private w aFN;
    private int aLG;
    private long aZz;
    private List<String> haI;
    private CustomMessageListener haJ;
    private HttpMessageListener hed;
    private CustomMessageListener hee;
    private Runnable heg;
    private boolean heh;
    private com.baidu.live.i.a hej;
    private String hek;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c okI;
    private HandlerC0922b okL;
    private String otherParams;
    private String hdX = "";
    private boolean isHost = false;
    private Map<Integer, c> hdY = new HashMap();
    private Map<Integer, AlaActiveRootView> hdZ = new HashMap();
    private SimpleArrayMap<Integer, Integer> hea = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> okJ = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> okK = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hec = new ArrayList<>();
    private h bRm = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public void jr(String str) {
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
                    b.this.Id(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a okD = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean wv(int i) {
            return b.this.wv(i);
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
            if (currentTimeMillis - b.this.aZz >= 400) {
                b.this.aZz = currentTimeMillis;
                if ((obj instanceof o) && b.this.aFN != null && b.this.aFN.aJV != null && b.this.aFN.mLiveInfo != null) {
                    o oVar = (o) obj;
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aFN != null && b.this.aFN.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aFN.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aFN.aJV.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aFN.aJV.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aFN.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aFN.aJV.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aFN.aJV.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!wv(oVar.aJH)) {
                        b.this.wu(oVar.aJH);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).wo(i);
                        }
                    }
                    b.this.aW(oVar.aJM, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aFN.mLiveInfo != null) {
                        str3 = b.this.aFN.mLiveInfo.feed_id;
                        str4 = b.this.aFN.mLiveInfo.live_id + "";
                    }
                    b.this.a(oVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hdZ != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.hdZ.get(Integer.valueOf(i2));
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

        boolean wv(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hea.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gDG);
    }

    public void Ia(String str) {
        this.hek = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.heh = z;
        for (int i = 1; i <= 2; i++) {
            Nr(i);
        }
        if (this.hdY != null) {
            this.hdY.clear();
        }
        i(wVar);
        if (this.aFN != null) {
            this.hdX = d.BM().getString("ala_active_view_click_info", "");
            bZV();
            bZW();
            bFR();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hdY.put(Integer.valueOf(i), new c(pendantParentView));
            Np(i);
        }
    }

    private void bZV() {
        if (this.hed == null) {
            this.hed = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aFN == null || b.this.aFN.mLiveInfo == null || b.this.aFN.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aFN.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZX();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.PT() != null) {
                                b.this.aLG = audioGetLiveActivityHttpResponseMessage.PT().aLG;
                                b.this.cz(audioGetLiveActivityHttpResponseMessage.PT().aQx);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hed);
    }

    private void bZW() {
        if (this.hee == null) {
            this.hee = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Id((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hee);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.hdZ != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.hdZ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.hdZ != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.hdZ.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYW()) {
                        bYQ();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.okI != null) {
            this.okI.resume();
        }
        bFR();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hdZ != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hdZ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.okI != null) {
            this.okI.pause();
        }
        bZY();
        bYO();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aFN = wVar;
    }

    public void setVisible(int i) {
        if (this.hdZ != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bQ(i2, i);
            }
        }
    }

    public void bQ(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.hea.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bR = bR(i, i2);
        if (this.hdZ != null && (alaActiveRootView = this.hdZ.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bR);
        }
    }

    private int bR(int i, int i2) {
        if (this.okJ != null && this.okJ.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.hea != null && this.hea.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hea.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ic(String str) {
        if (f.RR().ix(str)) {
            bFR();
        }
    }

    public void release() {
        this.aFN = null;
        this.hek = null;
        if (this.hed != null) {
            MessageManager.getInstance().unRegisterListener(this.hed);
            this.hed = null;
        }
        if (this.gDG != null) {
            MessageManager.getInstance().unRegisterListener(this.gDG);
            this.gDG = null;
        }
        if (this.hee != null) {
            MessageManager.getInstance().unRegisterListener(this.hee);
            this.hee = null;
        }
        if (this.okL != null) {
            this.okL.removeCallbacksAndMessages(null);
        }
        f.RR().release();
        bYO();
        if (this.hdZ != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hdZ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    cj(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.hdZ.clear();
        }
        if (this.okI != null) {
            this.okI.release();
            this.okI = null;
        }
    }

    public void nc(boolean z) {
    }

    public void updateView() {
        if (this.hdZ != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.hdZ.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bR(i2, this.hea.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFR() {
        if (this.aFN != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.c.RN().a(this.aFN.aKr.userUk, this.aFN.mLiveInfo.user_uk, this.aFN.mLiveInfo.room_id, this.aFN.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZX() {
        if (this.mRunning) {
            if (this.okL == null) {
                this.okL = new HandlerC0922b(this);
            }
            if (this.heg == null) {
                this.heg = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bFR();
                    }
                };
            }
            bZY();
            if (this.aLG <= 0) {
                this.aLG = 5;
            }
            this.okL.postDelayed(this.heg, this.aLG * 1000);
        }
    }

    private void bZY() {
        if (this.okL != null && this.heg != null) {
            this.okL.removeCallbacks(this.heg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cz(List<o> list) {
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
                    if (oVar.aJJ == 1) {
                        long j = oVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= oVar.showTime && j <= oVar.end_time && oVar.aJO != null && oVar.aJO.pos >= 0 && oVar.aJO.pos <= 2) {
                            if (oVar.aJO.pos == 0) {
                                oVar.aJO.pos = 1;
                            }
                            switch (oVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(oVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aJO.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(oVar.aJO.pos), list2);
                                        }
                                        list2.add(oVar);
                                        if (!z2 || oVar.aJN == null) {
                                            z = z2;
                                        } else {
                                            f.RR().b(oVar.aJN);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(oVar.aJO.pos));
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
                                    if (!TextUtils.isEmpty(oVar.webUrl) && oVar.aJO != null && oVar.aJO.width > 0 && oVar.aJO.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aJO.pos));
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
            f.RR().b(null);
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
            bZZ();
            Nr(i);
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
        this.okK.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                Nr(i);
                break;
            case 3:
                z = a(i, oVar);
                break;
        }
        c cVar = this.hdY.get(Integer.valueOf(i));
        if (cVar != null && cVar.hem != null && z) {
            cVar.hem.a(this.hdZ.get(Integer.valueOf(i)));
        }
        caa();
    }

    private void bZZ() {
        if (this.hej != null) {
            Iterator<com.baidu.live.i.b> it = this.hec.iterator();
            while (it.hasNext()) {
                this.hej.b(it.next());
            }
            this.hec.clear();
            this.hej.Gh();
        }
    }

    private void caa() {
        if (this.hej != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView Nq = Nq(i);
                if (Nq != null && Nq.getVisibility() == 0 && Nq.getChildCount() > 0 && !this.hec.contains(Nq)) {
                    this.hec.add(Nq);
                    this.hej.a(Nq);
                }
            }
            this.hej.Gh();
        }
    }

    private AlaActiveRootView Np(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.hdZ == null || (alaActiveRootView = this.hdZ.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.hdY != null && (cVar = this.hdY.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hem;
                if (pendantParentView == null || this.hdZ == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hdZ.put(Integer.valueOf(i), alaActiveRootView2);
                cj(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void cj(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView Nq(int i) {
        if (this.hdZ != null) {
            return this.hdZ.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<o> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            Nr(i);
            return false;
        }
        AlaActiveRootView Nq = Nq(i);
        if (Nq != null && Nq.getChildCount() == 1) {
            View lastChild = Nq.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.okJ.put(Integer.valueOf(i), null);
        Nr(i);
        AlaActiveRootView Np = Np(i);
        if (Np == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(Np.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.okD);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.heh || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.heh && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        Np.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, o oVar) {
        String v = v(oVar.webUrl, oVar.jump_url, oVar.aJM);
        if (!TextUtils.isEmpty(v) && oVar.aJO != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, oVar.aJO.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, oVar.aJO.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView Nq = Nq(i);
            if (Nq != null && Nq.getChildCount() == 1) {
                View lastChild = Nq.getLastChild();
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
                    if (this.okD != null) {
                        this.okD.b(lastChild, oVar, 0);
                    }
                    return false;
                }
            }
            this.okJ.put(Integer.valueOf(i), null);
            Nr(i);
            AlaActiveRootView Np = Np(i);
            if (Np == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(Np.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void na(boolean z) {
                    if (z) {
                        b.this.bYQ();
                    }
                }
            });
            g gVar = new g();
            gVar.x(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void fr(int i2) {
                    b.this.okJ.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bRm);
            com.baidu.live.view.web.a[] YO = gVar.YO();
            for (com.baidu.live.view.web.a aVar : YO) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(v);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.heh || i == 2) {
                layoutParams2.gravity = 5;
            }
            Np.addView(alaActiveWebView, layoutParams2);
            if (this.okD != null) {
                this.okD.b(alaActiveWebView, oVar, 0);
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
        if (this.aFN != null) {
            Map<String, Object> eda = eda();
            if (i == 2) {
                eda.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            eda.put(BigdayActivityConfig.JUMP_URL, aI(str2, i));
            return WebviewHelper.addQueryParams(str, eda);
        }
        return str;
    }

    private Map<String, Object> eda() {
        HashMap hashMap = new HashMap();
        if (this.aFN != null) {
            if (this.aFN.aKr != null) {
                hashMap.put("user_id", Long.valueOf(this.aFN.aKr.userId));
            }
            if (this.aFN.aJV != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aFN.aJV.userId));
            }
            if (this.aFN.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aFN.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aFN.mLiveInfo.live_id));
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

    private String aI(String str, int i) {
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
    public void bYQ() {
        if (Build.VERSION.SDK_INT >= 19) {
            bYS();
            if (this.okL == null) {
                this.okL = new HandlerC0922b(this);
            }
            if (!this.okL.hasMessages(1000)) {
                this.okL.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYO() {
        if (this.haI != null) {
            this.haI.clear();
        }
        if (this.okL != null) {
            this.okL.removeMessages(1000);
        }
        bYP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYR() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hdZ != null) {
            if (this.haI == null || (size = this.haI.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.haI.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.haI.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.hdZ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYW()) {
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
                this.okL.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYO();
            }
        }
    }

    private void bYS() {
        if (this.haI == null) {
            this.haI = new ArrayList();
        }
        this.haI.clear();
        this.haJ = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.haI.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.haJ);
    }

    private void bYP() {
        if (this.haJ != null) {
            MessageManager.getInstance().unRegisterListener(this.haJ);
            this.haJ = null;
        }
    }

    private void Nr(int i) {
        AlaActiveRootView Nq = Nq(i);
        if (Nq != null) {
            Nq.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> eda = eda();
                eda.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, eda);
                if (!TextUtils.isEmpty(this.hek)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.hek;
                }
                Id(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, eda());
            }
            if (!TextUtils.isEmpty(this.hek)) {
                str = str + ETAG.ITEM_SEPARATOR + this.hek;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Id(String str) {
        int i;
        if (this.okI == null) {
            this.okI = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.okI.setHost(this.isHost);
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.okI.f(this.aFN.mLiveInfo.user_id, this.aFN.mLiveInfo.getNameShow(), this.aFN.aJV != null ? this.aFN.aJV.portrait : null);
            this.okI.setLiveId(this.aFN.mLiveInfo.live_id);
        }
        if (!this.heh) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.okI.bU(str, i);
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
        if (this.aFN != null && this.aFN.aKL != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
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
        if (this.aFN != null && this.aFN.aKL != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
        }
        if (oVar != null && oVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (oVar != null && oVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hdX)) {
                jSONArray = new JSONArray(this.hdX);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hdX = jSONArray.toString();
            d.BM().putString("ala_active_view_click_info", this.hdX);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wv(int i) {
        if (StringUtils.isNull(this.hdX)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hdX);
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
        PendantParentView hem;

        c(PendantParentView pendantParentView) {
            this.hem = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0922b extends Handler {
        private final WeakReference<b> haS;

        HandlerC0922b(b bVar) {
            this.haS = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.haS.get() != null && message.what == 1000) {
                this.haS.get().bYR();
            }
        }
    }
}

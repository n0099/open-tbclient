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
    private w aES;
    private int aKy;
    private long aXU;
    private List<String> gRM;
    private CustomMessageListener gRN;
    private HttpMessageListener gVi;
    private CustomMessageListener gVj;
    private Runnable gVl;
    private boolean gVm;
    private com.baidu.live.g.a gVo;
    private String gVp;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c nUf;
    private HandlerC0902b nUi;
    private String otherParams;
    private String gVc = "";
    private boolean isHost = false;
    private Map<Integer, c> gVd = new HashMap();
    private Map<Integer, AlaActiveRootView> gVe = new HashMap();
    private SimpleArrayMap<Integer, Integer> gVf = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> nUg = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> nUh = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gVh = new ArrayList<>();
    private h bNR = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public void iT(String str) {
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
                    b.this.HO(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a nUa = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean vs(int i) {
            return b.this.vs(i);
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
            if (currentTimeMillis - b.this.aXU >= 400) {
                b.this.aXU = currentTimeMillis;
                if ((obj instanceof o) && b.this.aES != null && b.this.aES.aIV != null && b.this.aES.mLiveInfo != null) {
                    o oVar = (o) obj;
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aES != null && b.this.aES.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aES.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aES.aIV.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aES.aIV.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aES.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aES.aIV.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aES.aIV.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vs(oVar.aII)) {
                        b.this.vr(oVar.aII);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vl(i);
                        }
                    }
                    b.this.aY(oVar.aIN, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aES.mLiveInfo != null) {
                        str3 = b.this.aES.mLiveInfo.feed_id;
                        str4 = b.this.aES.mLiveInfo.live_id + "";
                    }
                    b.this.a(oVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gVe != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.gVe.get(Integer.valueOf(i2));
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

        boolean vs(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gVf.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gvo);
    }

    public void HL(String str) {
        this.gVp = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.gVm = z;
        for (int i = 1; i <= 2; i++) {
            LW(i);
        }
        if (this.gVd != null) {
            this.gVd.clear();
        }
        i(wVar);
        if (this.aES != null) {
            this.gVc = d.AZ().getString("ala_active_view_click_info", "");
            bWR();
            bWS();
            bCX();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gVd.put(Integer.valueOf(i), new c(pendantParentView));
            LU(i);
        }
    }

    private void bWR() {
        if (this.gVi == null) {
            this.gVi = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aES == null || b.this.aES.mLiveInfo == null || b.this.aES.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aES.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bWT();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.Oj() != null) {
                                b.this.aKy = audioGetLiveActivityHttpResponseMessage.Oj().aKy;
                                b.this.cv(audioGetLiveActivityHttpResponseMessage.Oj().aPj);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gVi);
    }

    private void bWS() {
        if (this.gVj == null) {
            this.gVj = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.HO((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gVj);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.gVe != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.gVe.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.gVe != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.gVe.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bVS()) {
                        bVN();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.nUf != null) {
            this.nUf.resume();
        }
        bCX();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gVe != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gVe.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.nUf != null) {
            this.nUf.pause();
        }
        bWU();
        bVL();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aES = wVar;
    }

    public void setVisible(int i) {
        if (this.gVe != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bM(i2, i);
            }
        }
    }

    public void bM(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.gVf.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bN = bN(i, i2);
        if (this.gVe != null && (alaActiveRootView = this.gVe.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bN);
        }
    }

    private int bN(int i, int i2) {
        if (this.nUg != null && this.nUg.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.gVf != null && this.gVf.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gVf.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void HN(String str) {
        if (f.Qg().hZ(str)) {
            bCX();
        }
    }

    public void release() {
        this.aES = null;
        this.gVp = null;
        if (this.gVi != null) {
            MessageManager.getInstance().unRegisterListener(this.gVi);
            this.gVi = null;
        }
        if (this.gvo != null) {
            MessageManager.getInstance().unRegisterListener(this.gvo);
            this.gvo = null;
        }
        if (this.gVj != null) {
            MessageManager.getInstance().unRegisterListener(this.gVj);
            this.gVj = null;
        }
        if (this.nUi != null) {
            this.nUi.removeCallbacksAndMessages(null);
        }
        f.Qg().release();
        bVL();
        if (this.gVe != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.gVe.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bZ(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.gVe.clear();
        }
        if (this.nUf != null) {
            this.nUf.release();
            this.nUf = null;
        }
    }

    public void mH(boolean z) {
    }

    public void updateView() {
        if (this.gVe != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.gVe.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bN(i2, this.gVf.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        if (this.aES != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.aa.c.Qc().a(this.aES.aJr.userUk, this.aES.mLiveInfo.user_uk, this.aES.mLiveInfo.room_id, this.aES.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWT() {
        if (this.mRunning) {
            if (this.nUi == null) {
                this.nUi = new HandlerC0902b(this);
            }
            if (this.gVl == null) {
                this.gVl = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bCX();
                    }
                };
            }
            bWU();
            if (this.aKy <= 0) {
                this.aKy = 5;
            }
            this.nUi.postDelayed(this.gVl, this.aKy * 1000);
        }
    }

    private void bWU() {
        if (this.nUi != null && this.gVl != null) {
            this.nUi.removeCallbacks(this.gVl);
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
                    if (oVar.aIK == 1) {
                        long j = oVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= oVar.showTime && j <= oVar.end_time && oVar.aIP != null && oVar.aIP.pos >= 0 && oVar.aIP.pos <= 2) {
                            if (oVar.aIP.pos == 0) {
                                oVar.aIP.pos = 1;
                            }
                            switch (oVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(oVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aIP.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(oVar.aIP.pos), list2);
                                        }
                                        list2.add(oVar);
                                        if (!z2 || oVar.aIO == null) {
                                            z = z2;
                                        } else {
                                            f.Qg().b(oVar.aIO);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(oVar.aIP.pos));
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
                                    if (!TextUtils.isEmpty(oVar.webUrl) && oVar.aIP != null && oVar.aIP.width > 0 && oVar.aIP.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(oVar.aIP.pos));
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
            f.Qg().b(null);
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
            bWV();
            LW(i);
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
        this.nUh.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                LW(i);
                break;
            case 3:
                z = a(i, oVar);
                break;
        }
        c cVar = this.gVd.get(Integer.valueOf(i));
        if (cVar != null && cVar.gVr != null && z) {
            cVar.gVr.a(this.gVe.get(Integer.valueOf(i)));
        }
        bWW();
    }

    private void bWV() {
        if (this.gVo != null) {
            Iterator<com.baidu.live.g.b> it = this.gVh.iterator();
            while (it.hasNext()) {
                this.gVo.b(it.next());
            }
            this.gVh.clear();
            this.gVo.Ff();
        }
    }

    private void bWW() {
        if (this.gVo != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView LV = LV(i);
                if (LV != null && LV.getVisibility() == 0 && LV.getChildCount() > 0 && !this.gVh.contains(LV)) {
                    this.gVh.add(LV);
                    this.gVo.a(LV);
                }
            }
            this.gVo.Ff();
        }
    }

    private AlaActiveRootView LU(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.gVe == null || (alaActiveRootView = this.gVe.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.gVd != null && (cVar = this.gVd.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gVr;
                if (pendantParentView == null || this.gVe == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gVe.put(Integer.valueOf(i), alaActiveRootView2);
                bZ(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bZ(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView LV(int i) {
        if (this.gVe != null) {
            return this.gVe.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<o> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            LW(i);
            return false;
        }
        AlaActiveRootView LV = LV(i);
        if (LV != null && LV.getChildCount() == 1) {
            View lastChild = LV.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.nUg.put(Integer.valueOf(i), null);
        LW(i);
        AlaActiveRootView LU = LU(i);
        if (LU == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(LU.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.nUa);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.gVm || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.gVm && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        LU.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, o oVar) {
        String v = v(oVar.webUrl, oVar.jump_url, oVar.aIN);
        if (!TextUtils.isEmpty(v) && oVar.aIP != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, oVar.aIP.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, oVar.aIP.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView LV = LV(i);
            if (LV != null && LV.getChildCount() == 1) {
                View lastChild = LV.getLastChild();
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
                    if (this.nUa != null) {
                        this.nUa.b(lastChild, oVar, 0);
                    }
                    return false;
                }
            }
            this.nUg.put(Integer.valueOf(i), null);
            LW(i);
            AlaActiveRootView LU = LU(i);
            if (LU == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(LU.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void mE(boolean z) {
                    if (z) {
                        b.this.bVN();
                    }
                }
            });
            g gVar = new g();
            gVar.y(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void eX(int i2) {
                    b.this.nUg.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bNR);
            com.baidu.live.view.web.a[] WX = gVar.WX();
            for (com.baidu.live.view.web.a aVar : WX) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(v);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.gVm || i == 2) {
                layoutParams2.gravity = 5;
            }
            LU.addView(alaActiveWebView, layoutParams2);
            if (this.nUa != null) {
                this.nUa.b(alaActiveWebView, oVar, 0);
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
        if (this.aES != null) {
            Map<String, Object> dXw = dXw();
            if (i == 2) {
                dXw.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            dXw.put(BigdayActivityConfig.JUMP_URL, aI(str2, i));
            return WebviewHelper.addQueryParams(str, dXw);
        }
        return str;
    }

    private Map<String, Object> dXw() {
        HashMap hashMap = new HashMap();
        if (this.aES != null) {
            if (this.aES.aJr != null) {
                hashMap.put("user_id", Long.valueOf(this.aES.aJr.userId));
            }
            if (this.aES.aIV != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aES.aIV.userId));
            }
            if (this.aES.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aES.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aES.mLiveInfo.live_id));
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
    public void bVN() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVP();
            if (this.nUi == null) {
                this.nUi = new HandlerC0902b(this);
            }
            if (!this.nUi.hasMessages(1000)) {
                this.nUi.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bVL() {
        if (this.gRM != null) {
            this.gRM.clear();
        }
        if (this.nUi != null) {
            this.nUi.removeMessages(1000);
        }
        bVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gVe != null) {
            if (this.gRM == null || (size = this.gRM.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRM.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gRM.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.gVe.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bVS()) {
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
                this.nUi.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bVL();
            }
        }
    }

    private void bVP() {
        if (this.gRM == null) {
            this.gRM = new ArrayList();
        }
        this.gRM.clear();
        this.gRN = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.gRM.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gRN);
    }

    private void bVM() {
        if (this.gRN != null) {
            MessageManager.getInstance().unRegisterListener(this.gRN);
            this.gRN = null;
        }
    }

    private void LW(int i) {
        AlaActiveRootView LV = LV(i);
        if (LV != null) {
            LV.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> dXw = dXw();
                dXw.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, dXw);
                if (!TextUtils.isEmpty(this.gVp)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.gVp;
                }
                HO(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, dXw());
            }
            if (!TextUtils.isEmpty(this.gVp)) {
                str = str + ETAG.ITEM_SEPARATOR + this.gVp;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void HO(String str) {
        int i;
        if (this.nUf == null) {
            this.nUf = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.nUf.setHost(this.isHost);
        if (this.aES != null && this.aES.mLiveInfo != null) {
            this.nUf.e(this.aES.mLiveInfo.user_id, this.aES.mLiveInfo.getNameShow(), this.aES.aIV != null ? this.aES.aIV.portrait : null);
            this.nUf.setLiveId(this.aES.mLiveInfo.live_id);
        }
        if (!this.gVm) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.nUf.bS(str, i);
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
        if (this.aES != null && this.aES.aJK != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
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
        if (this.aES != null && this.aES.aJK != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
        }
        if (oVar != null && oVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (oVar != null && oVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gVc)) {
                jSONArray = new JSONArray(this.gVc);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gVc = jSONArray.toString();
            d.AZ().putString("ala_active_view_click_info", this.gVc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vs(int i) {
        if (StringUtils.isNull(this.gVc)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gVc);
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
        PendantParentView gVr;

        c(PendantParentView pendantParentView) {
            this.gVr = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0902b extends Handler {
        private final WeakReference<b> gRW;

        HandlerC0902b(b bVar) {
            this.gRW = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRW.get() != null && message.what == 1000) {
                this.gRW.get().bVO();
            }
        }
    }
}

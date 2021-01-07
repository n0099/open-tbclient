package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.SimpleArrayMap;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.af.f;
import com.baidu.live.d;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private x aGe;
    private int aMk;
    private long bbg;
    private List<String> hmy;
    private CustomMessageListener hmz;
    private HttpMessageListener hpQ;
    private CustomMessageListener hpR;
    private Runnable hpT;
    private boolean hpU;
    private com.baidu.live.j.a hpW;
    private String hpX;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c omw;
    private HandlerC0934b omz;
    private String otherParams;
    private String hpK = "";
    private boolean isHost = false;
    private Map<Integer, c> hpL = new HashMap();
    private Map<Integer, AlaActiveRootView> hpM = new HashMap();
    private SimpleArrayMap<Integer, Integer> hpN = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> omx = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> omy = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.j.b> hpP = new ArrayList<>();
    private h bWS = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public void jk(String str) {
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
                    b.this.Ic(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a omq = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean wG(int i) {
            return b.this.wG(i);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof p) {
                b.this.a(view, (p) obj, i);
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.bbg >= 400) {
                b.this.bbg = currentTimeMillis;
                if ((obj instanceof p) && b.this.aGe != null && b.this.aGe.aKu != null && b.this.aGe.mLiveInfo != null) {
                    p pVar = (p) obj;
                    String str = pVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aGe != null && b.this.aGe.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aGe.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aGe.aKu.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aGe.aKu.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aGe.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aGe.aKu.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aGe.aKu.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!wG(pVar.aKg)) {
                        b.this.wF(pVar.aKg);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).wz(i);
                        }
                    }
                    b.this.aY(pVar.aKl, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aGe.mLiveInfo != null) {
                        str3 = b.this.aGe.mLiveInfo.feed_id;
                        str4 = b.this.aGe.mLiveInfo.live_id + "";
                    }
                    b.this.a(pVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hpM != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.hpM.get(Integer.valueOf(i2));
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

    /* loaded from: classes11.dex */
    public interface a {
        void a(View view, Object obj, int i);

        void b(View view, Object obj, int i);

        boolean wG(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hpN.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gPs);
    }

    public void HZ(String str) {
        this.hpX = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(x xVar, boolean z) {
        this.hpU = z;
        for (int i = 1; i <= 2; i++) {
            Nc(i);
        }
        if (this.hpL != null) {
            this.hpL.clear();
        }
        j(xVar);
        if (this.aGe != null) {
            this.hpK = d.Ba().getString("ala_active_view_click_info", "");
            ccD();
            ccE();
            bIn();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hpL.put(Integer.valueOf(i), new c(pendantParentView));
            Na(i);
        }
    }

    private void ccD() {
        if (this.hpQ == null) {
            this.hpQ = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aGe == null || b.this.aGe.mLiveInfo == null || b.this.aGe.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aGe.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.ccF();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.QS() != null) {
                                b.this.aMk = audioGetLiveActivityHttpResponseMessage.QS().aMk;
                                b.this.cG(audioGetLiveActivityHttpResponseMessage.QS().aRm);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpQ);
    }

    private void ccE() {
        if (this.hpR == null) {
            this.hpR = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Ic((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpR);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.hpM != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.hpM.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.hpM != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.hpM.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).cbE()) {
                        cbw();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.omw != null) {
            this.omw.resume();
        }
        bIn();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hpM != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hpM.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.omw != null) {
            this.omw.pause();
        }
        ccG();
        cbu();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(x xVar) {
        this.aGe = xVar;
    }

    public void setVisible(int i) {
        if (this.hpM != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bP(i2, i);
            }
        }
    }

    public void bP(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.hpN.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bQ = bQ(i, i2);
        if (this.hpM != null && (alaActiveRootView = this.hpM.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bQ);
        }
    }

    private int bQ(int i, int i2) {
        if (this.omx != null && this.omx.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.hpN != null && this.hpN.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hpN.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ib(String str) {
        if (f.SV().ik(str)) {
            bIn();
        }
    }

    public void release() {
        this.aGe = null;
        this.hpX = null;
        if (this.hpQ != null) {
            MessageManager.getInstance().unRegisterListener(this.hpQ);
            this.hpQ = null;
        }
        if (this.gPs != null) {
            MessageManager.getInstance().unRegisterListener(this.gPs);
            this.gPs = null;
        }
        if (this.hpR != null) {
            MessageManager.getInstance().unRegisterListener(this.hpR);
            this.hpR = null;
        }
        if (this.omz != null) {
            this.omz.removeCallbacksAndMessages(null);
        }
        f.SV().release();
        cbu();
        if (this.hpM != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hpM.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    cs(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.hpM.clear();
        }
        if (this.omw != null) {
            this.omw.release();
            this.omw = null;
        }
    }

    public void nB(boolean z) {
    }

    public void updateView() {
        if (this.hpM != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.hpM.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bQ(i2, this.hpN.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.aGe != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.af.c.SR().a(this.aGe.aKQ.userUk, this.aGe.mLiveInfo.user_uk, this.aGe.mLiveInfo.room_id, this.aGe.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccF() {
        if (this.mRunning) {
            if (this.omz == null) {
                this.omz = new HandlerC0934b(this);
            }
            if (this.hpT == null) {
                this.hpT = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bIn();
                    }
                };
            }
            ccG();
            if (this.aMk <= 0) {
                this.aMk = 5;
            }
            this.omz.postDelayed(this.hpT, this.aMk * 1000);
        }
    }

    private void ccG() {
        if (this.omz != null && this.hpT != null) {
            this.omz.removeCallbacks(this.hpT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cG(List<p> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (p pVar : list) {
                if (pVar != null) {
                    if (pVar.aKi == 1) {
                        long j = pVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= pVar.showTime && j <= pVar.end_time && pVar.aKn != null && pVar.aKn.pos >= 0 && pVar.aKn.pos <= 2) {
                            if (pVar.aKn.pos == 0) {
                                pVar.aKn.pos = 1;
                            }
                            switch (pVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(pVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(pVar.aKn.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(pVar.aKn.pos), list2);
                                        }
                                        list2.add(pVar);
                                        if (!z2 || pVar.aKm == null) {
                                            z = z2;
                                        } else {
                                            f.SV().b(pVar.aKm);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(pVar.aKn.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(pVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(pVar.webUrl) && pVar.aKn != null && pVar.aKn.width > 0 && pVar.aKn.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(pVar.aKn.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(pVar);
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
            f.SV().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void k(int i, List<p> list) {
        int i2;
        p pVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            ccH();
            Nc(i);
            return;
        }
        Iterator<p> it = list.iterator();
        ArrayList<p> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            p next = it.next();
            if (next.picType == 3) {
                i2 = next.picType;
                pVar = next;
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
        this.omy.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                Nc(i);
                break;
            case 3:
                z = a(i, pVar);
                break;
        }
        c cVar = this.hpL.get(Integer.valueOf(i));
        if (cVar != null && cVar.hpZ != null && z) {
            cVar.hpZ.a(this.hpM.get(Integer.valueOf(i)));
        }
        ccI();
    }

    private void ccH() {
        if (this.hpW != null) {
            Iterator<com.baidu.live.j.b> it = this.hpP.iterator();
            while (it.hasNext()) {
                this.hpW.b(it.next());
            }
            this.hpP.clear();
            this.hpW.FA();
        }
    }

    private void ccI() {
        if (this.hpW != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView Nb = Nb(i);
                if (Nb != null && Nb.getVisibility() == 0 && Nb.getChildCount() > 0 && !this.hpP.contains(Nb)) {
                    this.hpP.add(Nb);
                    this.hpW.a(Nb);
                }
            }
            this.hpW.FA();
        }
    }

    private AlaActiveRootView Na(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.hpM == null || (alaActiveRootView = this.hpM.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.hpL != null && (cVar = this.hpL.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hpZ;
                if (pendantParentView == null || this.hpM == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hpM.put(Integer.valueOf(i), alaActiveRootView2);
                cs(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void cs(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView Nb(int i) {
        if (this.hpM != null) {
            return this.hpM.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<p> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            Nc(i);
            return false;
        }
        AlaActiveRootView Nb = Nb(i);
        if (Nb != null && Nb.getChildCount() == 1) {
            View lastChild = Nb.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.omx.put(Integer.valueOf(i), null);
        Nc(i);
        AlaActiveRootView Na = Na(i);
        if (Na == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(Na.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.omq);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hpU || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.hpU && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        Na.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, p pVar) {
        String x = x(pVar.webUrl, pVar.jump_url, pVar.aKl);
        if (!TextUtils.isEmpty(x) && pVar.aKn != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, pVar.aKn.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, pVar.aKn.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView Nb = Nb(i);
            if (Nb != null && Nb.getChildCount() == 1) {
                View lastChild = Nb.getLastChild();
                if (lastChild instanceof AlaActiveWebView) {
                    if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(x)) {
                        ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                        ((AlaActiveWebView) lastChild).loadUrl(x);
                    }
                    ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                    if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                        layoutParams.width = applyDimension;
                        layoutParams.height = applyDimension2;
                        lastChild.setLayoutParams(layoutParams);
                    }
                    if (this.omq != null) {
                        this.omq.a(lastChild, pVar, 0);
                    }
                    return false;
                }
            }
            this.omx.put(Integer.valueOf(i), null);
            Nc(i);
            AlaActiveRootView Na = Na(i);
            if (Na == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(Na.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void nz(boolean z) {
                    if (z) {
                        b.this.cbw();
                    }
                }
            });
            g gVar = new g();
            gVar.w(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void fr(int i2) {
                    b.this.omx.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bWS);
            com.baidu.live.view.web.a[] aaf = gVar.aaf();
            for (com.baidu.live.view.web.a aVar : aaf) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.hpU || i == 2) {
                layoutParams2.gravity = 5;
            }
            Na.addView(alaActiveWebView, layoutParams2);
            if (this.omq != null) {
                this.omq.a(alaActiveWebView, pVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String x(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aGe != null) {
            Map<String, Object> ebX = ebX();
            if (i == 2) {
                ebX.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            ebX.put(BigdayActivityConfig.JUMP_URL, aK(str2, i));
            return WebviewHelper.addQueryParams(str, ebX);
        }
        return str;
    }

    private Map<String, Object> ebX() {
        HashMap hashMap = new HashMap();
        if (this.aGe != null) {
            if (this.aGe.aKQ != null) {
                hashMap.put("user_id", Long.valueOf(this.aGe.aKQ.userId));
            }
            if (this.aGe.aKu != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aGe.aKu.userId));
            }
            if (this.aGe.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aGe.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aGe.mLiveInfo.live_id));
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

    private String aK(String str, int i) {
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
    public void cbw() {
        if (Build.VERSION.SDK_INT >= 19) {
            cby();
            if (this.omz == null) {
                this.omz = new HandlerC0934b(this);
            }
            if (!this.omz.hasMessages(1000)) {
                this.omz.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void cbu() {
        if (this.hmy != null) {
            this.hmy.clear();
        }
        if (this.omz != null) {
            this.omz.removeMessages(1000);
        }
        cbv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbx() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hpM != null) {
            if (this.hmy == null || (size = this.hmy.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmy.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hmy.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.hpM.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).cbE()) {
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
                this.omz.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                cbu();
            }
        }
    }

    private void cby() {
        if (this.hmy == null) {
            this.hmy = new ArrayList();
        }
        this.hmy.clear();
        this.hmz = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.hmy.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hmz);
    }

    private void cbv() {
        if (this.hmz != null) {
            MessageManager.getInstance().unRegisterListener(this.hmz);
            this.hmz = null;
        }
    }

    private void Nc(int i) {
        AlaActiveRootView Nb = Nb(i);
        if (Nb != null) {
            Nb.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> ebX = ebX();
                ebX.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, ebX);
                if (!TextUtils.isEmpty(this.hpX)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.hpX;
                }
                Ic(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, ebX());
            }
            if (!TextUtils.isEmpty(this.hpX)) {
                str = str + ETAG.ITEM_SEPARATOR + this.hpX;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Ic(String str) {
        int i;
        if (this.omw == null) {
            this.omw = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.omw.setHost(this.isHost);
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            this.omw.g(this.aGe.mLiveInfo.user_id, this.aGe.mLiveInfo.getNameShow(), this.aGe.aLl != null ? this.aGe.aLl.cover : "");
            this.omw.setLiveId(this.aGe.mLiveInfo.live_id);
        }
        if (!this.hpU) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.omw.cb(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, p pVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (pVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(pVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aGe != null && this.aGe.aLl != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
        }
        if (pVar != null && pVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (pVar != null && pVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (pVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(pVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aGe != null && this.aGe.aLl != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
        }
        if (pVar != null && pVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (pVar != null && pVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hpK)) {
                jSONArray = new JSONArray(this.hpK);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hpK = jSONArray.toString();
            d.Ba().putString("ala_active_view_click_info", this.hpK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wG(int i) {
        if (StringUtils.isNull(this.hpK)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hpK);
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
    /* loaded from: classes11.dex */
    public static class c {
        PendantParentView hpZ;

        c(PendantParentView pendantParentView) {
            this.hpZ = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0934b extends Handler {
        private final WeakReference<b> hmE;

        HandlerC0934b(b bVar) {
            this.hmE = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hmE.get() != null && message.what == 1000) {
                this.hmE.get().cbx();
            }
        }
    }
}

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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private x aBr;
    private int aHx;
    private long aWs;
    private List<String> hhR;
    private CustomMessageListener hhS;
    private HttpMessageListener hlj;
    private CustomMessageListener hlk;
    private Runnable hlm;
    private boolean hln;
    private com.baidu.live.j.a hlp;
    private String hlq;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c ohR;
    private HandlerC0917b ohU;
    private String otherParams;
    private String hld = "";
    private boolean isHost = false;
    private Map<Integer, c> hle = new HashMap();
    private Map<Integer, AlaActiveRootView> hlf = new HashMap();
    private SimpleArrayMap<Integer, Integer> hlg = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> ohS = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> ohT = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.j.b> hli = new ArrayList<>();
    private h bSg = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public void hZ(String str) {
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
                    b.this.GR(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a ohL = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean va(int i) {
            return b.this.va(i);
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
            if (currentTimeMillis - b.this.aWs >= 400) {
                b.this.aWs = currentTimeMillis;
                if ((obj instanceof p) && b.this.aBr != null && b.this.aBr.aFH != null && b.this.aBr.mLiveInfo != null) {
                    p pVar = (p) obj;
                    String str = pVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aBr != null && b.this.aBr.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aBr.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aBr.aFH.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aBr.aFH.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aBr.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aBr.aFH.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aBr.aFH.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!va(pVar.aFt)) {
                        b.this.uZ(pVar.aFt);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).uT(i);
                        }
                    }
                    b.this.aZ(pVar.aFy, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aBr.mLiveInfo != null) {
                        str3 = b.this.aBr.mLiveInfo.feed_id;
                        str4 = b.this.aBr.mLiveInfo.live_id + "";
                    }
                    b.this.a(pVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hlf != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.hlf.get(Integer.valueOf(i2));
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

    /* loaded from: classes10.dex */
    public interface a {
        void a(View view, Object obj, int i);

        void b(View view, Object obj, int i);

        boolean va(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hlg.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void GO(String str) {
        this.hlq = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(x xVar, boolean z) {
        this.hln = z;
        for (int i = 1; i <= 2; i++) {
            Lv(i);
        }
        if (this.hle != null) {
            this.hle.clear();
        }
        j(xVar);
        if (this.aBr != null) {
            this.hld = d.xf().getString("ala_active_view_click_info", "");
            bYL();
            bYM();
            bEv();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hle.put(Integer.valueOf(i), new c(pendantParentView));
            Lt(i);
        }
    }

    private void bYL() {
        if (this.hlj == null) {
            this.hlj = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aBr == null || b.this.aBr.mLiveInfo == null || b.this.aBr.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aBr.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bYN();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.MX() != null) {
                                b.this.aHx = audioGetLiveActivityHttpResponseMessage.MX().aHx;
                                b.this.cG(audioGetLiveActivityHttpResponseMessage.MX().aMz);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hlj);
    }

    private void bYM() {
        if (this.hlk == null) {
            this.hlk = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.GR((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hlk);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.hlf != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.hlf.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.hlf != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.hlf.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bXM()) {
                        bXE();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.ohR != null) {
            this.ohR.resume();
        }
        bEv();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hlf != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hlf.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.ohR != null) {
            this.ohR.pause();
        }
        bYO();
        bXC();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(x xVar) {
        this.aBr = xVar;
    }

    public void setVisible(int i) {
        if (this.hlf != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bP(i2, i);
            }
        }
    }

    public void bP(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.hlg.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bQ = bQ(i, i2);
        if (this.hlf != null && (alaActiveRootView = this.hlf.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bQ);
        }
    }

    private int bQ(int i, int i2) {
        if (this.ohS != null && this.ohS.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.hlg != null && this.hlg.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hlg.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void GQ(String str) {
        if (f.Pa().gZ(str)) {
            bEv();
        }
    }

    public void release() {
        this.aBr = null;
        this.hlq = null;
        if (this.hlj != null) {
            MessageManager.getInstance().unRegisterListener(this.hlj);
            this.hlj = null;
        }
        if (this.gKM != null) {
            MessageManager.getInstance().unRegisterListener(this.gKM);
            this.gKM = null;
        }
        if (this.hlk != null) {
            MessageManager.getInstance().unRegisterListener(this.hlk);
            this.hlk = null;
        }
        if (this.ohU != null) {
            this.ohU.removeCallbacksAndMessages(null);
        }
        f.Pa().release();
        bXC();
        if (this.hlf != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hlf.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    cs(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.hlf.clear();
        }
        if (this.ohR != null) {
            this.ohR.release();
            this.ohR = null;
        }
    }

    public void nx(boolean z) {
    }

    public void updateView() {
        if (this.hlf != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.hlf.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bQ(i2, this.hlg.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEv() {
        if (this.aBr != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.af.c.OW().a(this.aBr.aGd.userUk, this.aBr.mLiveInfo.user_uk, this.aBr.mLiveInfo.room_id, this.aBr.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYN() {
        if (this.mRunning) {
            if (this.ohU == null) {
                this.ohU = new HandlerC0917b(this);
            }
            if (this.hlm == null) {
                this.hlm = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bEv();
                    }
                };
            }
            bYO();
            if (this.aHx <= 0) {
                this.aHx = 5;
            }
            this.ohU.postDelayed(this.hlm, this.aHx * 1000);
        }
    }

    private void bYO() {
        if (this.ohU != null && this.hlm != null) {
            this.ohU.removeCallbacks(this.hlm);
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
                    if (pVar.aFv == 1) {
                        long j = pVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= pVar.showTime && j <= pVar.end_time && pVar.aFA != null && pVar.aFA.pos >= 0 && pVar.aFA.pos <= 2) {
                            if (pVar.aFA.pos == 0) {
                                pVar.aFA.pos = 1;
                            }
                            switch (pVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(pVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(pVar.aFA.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(pVar.aFA.pos), list2);
                                        }
                                        list2.add(pVar);
                                        if (!z2 || pVar.aFz == null) {
                                            z = z2;
                                        } else {
                                            f.Pa().b(pVar.aFz);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(pVar.aFA.pos));
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
                                    if (!TextUtils.isEmpty(pVar.webUrl) && pVar.aFA != null && pVar.aFA.width > 0 && pVar.aFA.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(pVar.aFA.pos));
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
            f.Pa().b(null);
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
            bYP();
            Lv(i);
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
        this.ohT.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                Lv(i);
                break;
            case 3:
                z = a(i, pVar);
                break;
        }
        c cVar = this.hle.get(Integer.valueOf(i));
        if (cVar != null && cVar.hls != null && z) {
            cVar.hls.a(this.hlf.get(Integer.valueOf(i)));
        }
        bYQ();
    }

    private void bYP() {
        if (this.hlp != null) {
            Iterator<com.baidu.live.j.b> it = this.hli.iterator();
            while (it.hasNext()) {
                this.hlp.b(it.next());
            }
            this.hli.clear();
            this.hlp.BF();
        }
    }

    private void bYQ() {
        if (this.hlp != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView Lu = Lu(i);
                if (Lu != null && Lu.getVisibility() == 0 && Lu.getChildCount() > 0 && !this.hli.contains(Lu)) {
                    this.hli.add(Lu);
                    this.hlp.a(Lu);
                }
            }
            this.hlp.BF();
        }
    }

    private AlaActiveRootView Lt(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.hlf == null || (alaActiveRootView = this.hlf.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.hle != null && (cVar = this.hle.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hls;
                if (pendantParentView == null || this.hlf == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hlf.put(Integer.valueOf(i), alaActiveRootView2);
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

    public AlaActiveRootView Lu(int i) {
        if (this.hlf != null) {
            return this.hlf.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<p> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            Lv(i);
            return false;
        }
        AlaActiveRootView Lu = Lu(i);
        if (Lu != null && Lu.getChildCount() == 1) {
            View lastChild = Lu.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.ohS.put(Integer.valueOf(i), null);
        Lv(i);
        AlaActiveRootView Lt = Lt(i);
        if (Lt == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(Lt.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.ohL);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hln || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.hln && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        Lt.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, p pVar) {
        String x = x(pVar.webUrl, pVar.jump_url, pVar.aFy);
        if (!TextUtils.isEmpty(x) && pVar.aFA != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, pVar.aFA.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, pVar.aFA.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView Lu = Lu(i);
            if (Lu != null && Lu.getChildCount() == 1) {
                View lastChild = Lu.getLastChild();
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
                    if (this.ohL != null) {
                        this.ohL.a(lastChild, pVar, 0);
                    }
                    return false;
                }
            }
            this.ohS.put(Integer.valueOf(i), null);
            Lv(i);
            AlaActiveRootView Lt = Lt(i);
            if (Lt == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(Lt.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void nv(boolean z) {
                    if (z) {
                        b.this.bXE();
                    }
                }
            });
            g gVar = new g();
            gVar.w(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void dL(int i2) {
                    b.this.ohS.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bSg);
            com.baidu.live.view.web.a[] Wm = gVar.Wm();
            for (com.baidu.live.view.web.a aVar : Wm) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.hln || i == 2) {
                layoutParams2.gravity = 5;
            }
            Lt.addView(alaActiveWebView, layoutParams2);
            if (this.ohL != null) {
                this.ohL.a(alaActiveWebView, pVar, 0);
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
        if (this.aBr != null) {
            Map<String, Object> dYf = dYf();
            if (i == 2) {
                dYf.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            dYf.put(BigdayActivityConfig.JUMP_URL, aK(str2, i));
            return WebviewHelper.addQueryParams(str, dYf);
        }
        return str;
    }

    private Map<String, Object> dYf() {
        HashMap hashMap = new HashMap();
        if (this.aBr != null) {
            if (this.aBr.aGd != null) {
                hashMap.put("user_id", Long.valueOf(this.aBr.aGd.userId));
            }
            if (this.aBr.aFH != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aBr.aFH.userId));
            }
            if (this.aBr.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aBr.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aBr.mLiveInfo.live_id));
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
    public void bXE() {
        if (Build.VERSION.SDK_INT >= 19) {
            bXG();
            if (this.ohU == null) {
                this.ohU = new HandlerC0917b(this);
            }
            if (!this.ohU.hasMessages(1000)) {
                this.ohU.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bXC() {
        if (this.hhR != null) {
            this.hhR.clear();
        }
        if (this.ohU != null) {
            this.ohU.removeMessages(1000);
        }
        bXD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXF() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hlf != null) {
            if (this.hhR == null || (size = this.hhR.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hhR.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hhR.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.hlf.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bXM()) {
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
                this.ohU.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bXC();
            }
        }
    }

    private void bXG() {
        if (this.hhR == null) {
            this.hhR = new ArrayList();
        }
        this.hhR.clear();
        this.hhS = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.hhR.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hhS);
    }

    private void bXD() {
        if (this.hhS != null) {
            MessageManager.getInstance().unRegisterListener(this.hhS);
            this.hhS = null;
        }
    }

    private void Lv(int i) {
        AlaActiveRootView Lu = Lu(i);
        if (Lu != null) {
            Lu.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> dYf = dYf();
                dYf.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, dYf);
                if (!TextUtils.isEmpty(this.hlq)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.hlq;
                }
                GR(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, dYf());
            }
            if (!TextUtils.isEmpty(this.hlq)) {
                str = str + ETAG.ITEM_SEPARATOR + this.hlq;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void GR(String str) {
        int i;
        if (this.ohR == null) {
            this.ohR = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.ohR.setHost(this.isHost);
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            this.ohR.g(this.aBr.mLiveInfo.user_id, this.aBr.mLiveInfo.getNameShow(), this.aBr.aGy != null ? this.aBr.aGy.cover : "");
            this.ohR.setLiveId(this.aBr.mLiveInfo.live_id);
        }
        if (!this.hln) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.ohR.cb(str, i);
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
        if (this.aBr != null && this.aBr.aGy != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
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
        if (this.aBr != null && this.aBr.aGy != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
        }
        if (pVar != null && pVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (pVar != null && pVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hld)) {
                jSONArray = new JSONArray(this.hld);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hld = jSONArray.toString();
            d.xf().putString("ala_active_view_click_info", this.hld);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(int i) {
        if (StringUtils.isNull(this.hld)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hld);
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
    /* loaded from: classes10.dex */
    public static class c {
        PendantParentView hls;

        c(PendantParentView pendantParentView) {
            this.hls = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0917b extends Handler {
        private final WeakReference<b> hhX;

        HandlerC0917b(b bVar) {
            this.hhX = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hhX.get() != null && message.what == 1000) {
                this.hhX.get().bXF();
            }
        }
    }
}

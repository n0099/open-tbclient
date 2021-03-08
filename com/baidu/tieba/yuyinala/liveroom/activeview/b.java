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
import com.baidu.live.ae.f;
import com.baidu.live.d;
import com.baidu.live.data.ab;
import com.baidu.live.data.t;
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
    private ab aED;
    private long baZ;
    private CustomMessageListener bmk;
    private List<String> hod;
    private com.baidu.live.i.a hrA;
    private String hrB;
    private HttpMessageListener hru;
    private CustomMessageListener hrv;
    private Runnable hrx;
    private boolean hry;
    private int interval;
    private TbPageContext mPageContext;
    private String otherParams;
    private com.baidu.tieba.yuyinala.liveroom.a.c our;
    private HandlerC0928b ouv;
    private String hro = "";
    private boolean isHost = false;
    private Map<Integer, c> hrp = new HashMap();
    private Map<Integer, AlaActiveRootView> hrq = new HashMap();
    private SimpleArrayMap<Integer, Integer> hrr = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> ous = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> ouu = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hrt = new ArrayList<>();
    private h bXA = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public boolean iF(String str) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
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
                b.this.HF(str);
            } else {
                SchemeUtils.openScheme(str);
            }
            return true;
        }
    };
    private a oul = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean vn(int i) {
            return b.this.vn(i);
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof t) {
                b.this.b(view, (t) obj, i);
            }
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.baZ >= 400) {
                b.this.baZ = currentTimeMillis;
                if ((obj instanceof t) && b.this.aED != null && b.this.aED.aJD != null && b.this.aED.mLiveInfo != null) {
                    t tVar = (t) obj;
                    String str = tVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aED != null && b.this.aED.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aED.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aED.aJD.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aED.aJD.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aED.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aED.aJD.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aED.aJD.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vn(tVar.aJp)) {
                        b.this.vm(tVar.aJp);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vc(i);
                        }
                    }
                    b.this.be(tVar.aJu, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aED.mLiveInfo != null) {
                        str3 = b.this.aED.mLiveInfo.feed_id;
                        str4 = b.this.aED.mLiveInfo.live_id + "";
                    }
                    b.this.a(tVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hrq != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.hrq.get(Integer.valueOf(i2));
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

        boolean vn(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hrr.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gPp);
    }

    public void HC(String str) {
        this.hrB = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(ab abVar, boolean z) {
        this.hry = z;
        for (int i = 1; i <= 2; i++) {
            LV(i);
        }
        if (this.hrp != null) {
            this.hrp.clear();
        }
        j(abVar);
        if (this.aED != null) {
            this.hro = d.xf().getString("ala_active_view_click_info", "");
            bZU();
            bZV();
            bER();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hrp.put(Integer.valueOf(i), new c(pendantParentView));
            LT(i);
        }
    }

    private void bZU() {
        if (this.hru == null) {
            this.hru = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aED == null || b.this.aED.mLiveInfo == null || b.this.aED.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aED.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZW();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.Oy() != null) {
                                b.this.interval = audioGetLiveActivityHttpResponseMessage.Oy().interval;
                                b.this.cB(audioGetLiveActivityHttpResponseMessage.Oy().aQX);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hru);
    }

    private void bZV() {
        if (this.hrv == null) {
            this.hrv = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.HF((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hrv);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.hrq != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.hrq.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.hrq != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.hrq.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYX()) {
                        bYQ();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.our != null) {
            this.our.resume();
        }
        bER();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hrq != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hrq.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.our != null) {
            this.our.pause();
        }
        bZX();
        bYP();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(ab abVar) {
        this.aED = abVar;
    }

    public void setVisible(int i) {
        if (this.hrq != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bN(i2, i);
            }
        }
    }

    public void bN(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.hrr.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bO = bO(i, i2);
        if (this.hrq != null && (alaActiveRootView = this.hrq.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bO);
        }
    }

    private int bO(int i, int i2) {
        if (this.ous != null && this.ous.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.hrr != null && this.hrr.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hrr.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void HE(String str) {
        if (f.QE().hB(str)) {
            bER();
        }
    }

    public void release() {
        this.aED = null;
        this.hrB = null;
        if (this.hru != null) {
            MessageManager.getInstance().unRegisterListener(this.hru);
            this.hru = null;
        }
        if (this.gPp != null) {
            MessageManager.getInstance().unRegisterListener(this.gPp);
            this.gPp = null;
        }
        if (this.hrv != null) {
            MessageManager.getInstance().unRegisterListener(this.hrv);
            this.hrv = null;
        }
        if (this.ouv != null) {
            this.ouv.removeCallbacksAndMessages(null);
        }
        f.QE().release();
        bYP();
        if (this.hrq != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hrq.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    co(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.hrq.clear();
        }
        if (this.our != null) {
            this.our.release();
            this.our = null;
        }
    }

    public void nI(boolean z) {
    }

    public void updateView() {
        if (this.hrq != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.hrq.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bO(i2, this.hrr.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bER() {
        if (this.aED != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.c.QA().a(this.aED.aJZ.userUk, this.aED.mLiveInfo.user_uk, this.aED.mLiveInfo.room_id, this.aED.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        if (this.mRunning) {
            if (this.ouv == null) {
                this.ouv = new HandlerC0928b(this);
            }
            if (this.hrx == null) {
                this.hrx = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bER();
                    }
                };
            }
            bZX();
            if (this.interval <= 0) {
                this.interval = 5;
            }
            this.ouv.postDelayed(this.hrx, this.interval * 1000);
        }
    }

    private void bZX() {
        if (this.ouv != null && this.hrx != null) {
            this.ouv.removeCallbacks(this.hrx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cB(List<t> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (t tVar : list) {
                if (tVar != null) {
                    if (tVar.aJr == 1) {
                        long j = tVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= tVar.showTime && j <= tVar.end_time && tVar.aJw != null && tVar.aJw.pos >= 0 && tVar.aJw.pos <= 2) {
                            if (tVar.aJw.pos == 0) {
                                tVar.aJw.pos = 1;
                            }
                            switch (tVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(tVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(tVar.aJw.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(tVar.aJw.pos), list2);
                                        }
                                        list2.add(tVar);
                                        if (!z2 || tVar.aJv == null) {
                                            z = z2;
                                        } else {
                                            f.QE().b(tVar.aJv);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(tVar.aJw.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(tVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(tVar.webUrl) && tVar.aJw != null && tVar.aJw.width > 0 && tVar.aJw.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(tVar.aJw.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(tVar);
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
            f.QE().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            l(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void l(int i, List<t> list) {
        int i2;
        t tVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bZY();
            LV(i);
            return;
        }
        Iterator<t> it = list.iterator();
        ArrayList<t> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            t next = it.next();
            if (next.picType == 3) {
                i2 = next.picType;
                tVar = next;
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
        this.ouu.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                LV(i);
                break;
            case 3:
                z = a(i, tVar);
                break;
        }
        c cVar = this.hrp.get(Integer.valueOf(i));
        if (cVar != null && cVar.hrD != null && z) {
            cVar.hrD.a(this.hrq.get(Integer.valueOf(i)));
        }
        bZZ();
    }

    private void bZY() {
        if (this.hrA != null) {
            Iterator<com.baidu.live.i.b> it = this.hrt.iterator();
            while (it.hasNext()) {
                this.hrA.b(it.next());
            }
            this.hrt.clear();
            this.hrA.CX();
        }
    }

    private void bZZ() {
        if (this.hrA != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView LU = LU(i);
                if (LU != null && LU.getVisibility() == 0 && LU.getChildCount() > 0 && !this.hrt.contains(LU)) {
                    this.hrt.add(LU);
                    this.hrA.a(LU);
                }
            }
            this.hrA.CX();
        }
    }

    private AlaActiveRootView LT(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.hrq == null || (alaActiveRootView = this.hrq.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.hrp != null && (cVar = this.hrp.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hrD;
                if (pendantParentView == null || this.hrq == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hrq.put(Integer.valueOf(i), alaActiveRootView2);
                co(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void co(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView LU(int i) {
        if (this.hrq != null) {
            return this.hrq.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<t> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            LV(i);
            return false;
        }
        AlaActiveRootView LU = LU(i);
        if (LU != null && LU.getChildCount() == 1) {
            View lastChild = LU.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.ous.put(Integer.valueOf(i), null);
        LV(i);
        AlaActiveRootView LT = LT(i);
        if (LT == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(LT.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.oul);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hry || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.hry && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        LT.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, t tVar) {
        String x = x(tVar.webUrl, tVar.jump_url, tVar.aJu);
        if (!TextUtils.isEmpty(x) && tVar.aJw != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, tVar.aJw.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, tVar.aJw.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView LU = LU(i);
            if (LU != null && LU.getChildCount() == 1) {
                View lastChild = LU.getLastChild();
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
                    if (this.oul != null) {
                        this.oul.a(lastChild, tVar, 0);
                    }
                    return false;
                }
            }
            this.ous.put(Integer.valueOf(i), null);
            LV(i);
            AlaActiveRootView LT = LT(i);
            if (LT == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(LT.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void nG(boolean z) {
                    if (z) {
                        b.this.bYQ();
                    }
                }
            });
            g gVar = new g();
            gVar.t(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void fq(int i2) {
                    b.this.ous.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bXA);
            com.baidu.live.view.web.a[] Yb = gVar.Yb();
            for (com.baidu.live.view.web.a aVar : Yb) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.hry || i == 2) {
                layoutParams2.gravity = 5;
            }
            LT.addView(alaActiveWebView, layoutParams2);
            if (this.oul != null) {
                this.oul.a(alaActiveWebView, tVar, 0);
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
        if (this.aED != null) {
            Map<String, Object> eaI = eaI();
            if (i == 2) {
                eaI.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            eaI.put(BigdayActivityConfig.JUMP_URL, aL(str2, i));
            return WebviewHelper.addQueryParams(str, eaI);
        }
        return str;
    }

    private Map<String, Object> eaI() {
        HashMap hashMap = new HashMap();
        if (this.aED != null) {
            if (this.aED.aJZ != null) {
                hashMap.put("user_id", Long.valueOf(this.aED.aJZ.userId));
            }
            if (this.aED.aJD != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aED.aJD.userId));
            }
            if (this.aED.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aED.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aED.mLiveInfo.live_id));
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

    private String aL(String str, int i) {
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
            Jy();
            if (this.ouv == null) {
                this.ouv = new HandlerC0928b(this);
            }
            if (!this.ouv.hasMessages(1000)) {
                this.ouv.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYP() {
        if (this.hod != null) {
            this.hod.clear();
        }
        if (this.ouv != null) {
            this.ouv.removeMessages(1000);
        }
        Jz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYR() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hrq != null) {
            if (this.hod == null || (size = this.hod.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hod.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hod.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.hrq.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYX()) {
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
                this.ouv.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYP();
            }
        }
    }

    private void Jy() {
        if (this.hod == null) {
            this.hod = new ArrayList();
        }
        this.hod.clear();
        this.bmk = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.hod.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bmk);
    }

    private void Jz() {
        if (this.bmk != null) {
            MessageManager.getInstance().unRegisterListener(this.bmk);
            this.bmk = null;
        }
    }

    private void LV(int i) {
        AlaActiveRootView LU = LU(i);
        if (LU != null) {
            LU.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> eaI = eaI();
                eaI.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, eaI);
                if (!TextUtils.isEmpty(this.hrB)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.hrB;
                }
                HF(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, eaI());
            }
            if (!TextUtils.isEmpty(this.hrB)) {
                str = str + ETAG.ITEM_SEPARATOR + this.hrB;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void HF(String str) {
        int i;
        if (this.our == null) {
            this.our = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.our.setHost(this.isHost);
        if (this.aED != null && this.aED.mLiveInfo != null) {
            this.our.g(this.aED.mLiveInfo.user_id, this.aED.mLiveInfo.getNameShow(), this.aED.aKu != null ? this.aED.aKu.cover : "");
            this.our.setLiveId(this.aED.mLiveInfo.live_id);
        }
        if (!this.hry) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.our.cc(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, t tVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (tVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(tVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aED != null && this.aED.aKu != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
        }
        if (tVar != null && tVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (tVar != null && tVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (tVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(tVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
        if (this.aED != null && this.aED.aKu != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
        }
        if (tVar != null && tVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (tVar != null && tVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hro)) {
                jSONArray = new JSONArray(this.hro);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hro = jSONArray.toString();
            d.xf().putString("ala_active_view_click_info", this.hro);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vn(int i) {
        if (StringUtils.isNull(this.hro)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hro);
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
        PendantParentView hrD;

        c(PendantParentView pendantParentView) {
            this.hrD = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0928b extends Handler {
        private final WeakReference<b> hoi;

        HandlerC0928b(b bVar) {
            this.hoi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hoi.get() != null && message.what == 1000) {
                this.hoi.get().bYR();
            }
        }
    }
}

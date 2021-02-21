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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private ab aDd;
    private long aZy;
    private CustomMessageListener bkK;
    private List<String> hmu;
    private HttpMessageListener hpL;
    private CustomMessageListener hpM;
    private Runnable hpO;
    private boolean hpP;
    private com.baidu.live.i.a hpR;
    private String hpS;
    private int interval;
    private TbPageContext mPageContext;
    private com.baidu.tieba.yuyinala.liveroom.a.c osm;
    private HandlerC0922b osp;
    private String otherParams;
    private String hpF = "";
    private boolean isHost = false;
    private Map<Integer, c> hpG = new HashMap();
    private Map<Integer, AlaActiveRootView> hpH = new HashMap();
    private SimpleArrayMap<Integer, Integer> hpI = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> osn = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> oso = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hpK = new ArrayList<>();
    private h bWa = new h() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.6
        @Override // com.baidu.live.view.web.h
        public boolean iz(String str) {
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
                b.this.Hw(str);
            } else {
                SchemeUtils.openScheme(str);
            }
            return true;
        }
    };
    private a osg = new a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.yuyinala.liveroom.activeview.b.a
        public boolean vl(int i) {
            return b.this.vl(i);
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
            if (currentTimeMillis - b.this.aZy >= 400) {
                b.this.aZy = currentTimeMillis;
                if ((obj instanceof t) && b.this.aDd != null && b.this.aDd.aId != null && b.this.aDd.mLiveInfo != null) {
                    t tVar = (t) obj;
                    String str = tVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDd != null && b.this.aDd.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDd.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDd.aId.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDd.aId.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDd.mLiveInfo.live_id);
                        String str2 = null;
                        if (b.this.aDd.aId.portrait != null) {
                            try {
                                str2 = URLEncoder.encode(b.this.aDd.aId.portrait, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vl(tVar.aHP)) {
                        b.this.vk(tVar.aHP);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).va(i);
                        }
                    }
                    b.this.be(tVar.aHU, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDd.mLiveInfo != null) {
                        str3 = b.this.aDd.mLiveInfo.feed_id;
                        str4 = b.this.aDd.mLiveInfo.live_id + "";
                    }
                    b.this.a(tVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hpH != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.hpH.get(Integer.valueOf(i2));
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

        boolean vl(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hpI.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gNG);
    }

    public void Ht(String str) {
        this.hpS = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(ab abVar, boolean z) {
        this.hpP = z;
        for (int i = 1; i <= 2; i++) {
            LR(i);
        }
        if (this.hpG != null) {
            this.hpG.clear();
        }
        j(abVar);
        if (this.aDd != null) {
            this.hpF = d.xc().getString("ala_active_view_click_info", "");
            bZO();
            bZP();
            bEN();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hpG.put(Integer.valueOf(i), new c(pendantParentView));
            LP(i);
        }
    }

    private void bZO() {
        if (this.hpL == null) {
            this.hpL = new HttpMessageListener(1031002) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031002 && (httpResponsedMessage instanceof AudioGetLiveActivityHttpResponseMessage)) {
                        if (b.this.aDd == null || b.this.aDd.mLiveInfo == null || b.this.aDd.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDd.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZQ();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            AudioGetLiveActivityHttpResponseMessage audioGetLiveActivityHttpResponseMessage = (AudioGetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (audioGetLiveActivityHttpResponseMessage.Ov() != null) {
                                b.this.interval = audioGetLiveActivityHttpResponseMessage.Ov().interval;
                                b.this.cB(audioGetLiveActivityHttpResponseMessage.Ov().aPx);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpL);
    }

    private void bZP() {
        if (this.hpM == null) {
            this.hpM = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Hw((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpM);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.hpH != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.hpH.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.hpH != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.hpH.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYR()) {
                        bYK();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.osm != null) {
            this.osm.resume();
        }
        bEN();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hpH != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hpH.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.osm != null) {
            this.osm.pause();
        }
        bZR();
        bYJ();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(ab abVar) {
        this.aDd = abVar;
    }

    public void setVisible(int i) {
        if (this.hpH != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bN(i2, i);
            }
        }
    }

    public void bN(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.hpI.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bO = bO(i, i2);
        if (this.hpH != null && (alaActiveRootView = this.hpH.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bO);
        }
    }

    private int bO(int i, int i2) {
        if (this.osn != null && this.osn.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.hpI != null && this.hpI.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hpI.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Hv(String str) {
        if (f.QB().hv(str)) {
            bEN();
        }
    }

    public void release() {
        this.aDd = null;
        this.hpS = null;
        if (this.hpL != null) {
            MessageManager.getInstance().unRegisterListener(this.hpL);
            this.hpL = null;
        }
        if (this.gNG != null) {
            MessageManager.getInstance().unRegisterListener(this.gNG);
            this.gNG = null;
        }
        if (this.hpM != null) {
            MessageManager.getInstance().unRegisterListener(this.hpM);
            this.hpM = null;
        }
        if (this.osp != null) {
            this.osp.removeCallbacksAndMessages(null);
        }
        f.QB().release();
        bYJ();
        if (this.hpH != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.hpH.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    co(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.hpH.clear();
        }
        if (this.osm != null) {
            this.osm.release();
            this.osm = null;
        }
    }

    public void nI(boolean z) {
    }

    public void updateView() {
        if (this.hpH != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.hpH.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bO(i2, this.hpI.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        if (this.aDd != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.c.Qx().a(this.aDd.aIz.userUk, this.aDd.mLiveInfo.user_uk, this.aDd.mLiveInfo.room_id, this.aDd.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZQ() {
        if (this.mRunning) {
            if (this.osp == null) {
                this.osp = new HandlerC0922b(this);
            }
            if (this.hpO == null) {
                this.hpO = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bEN();
                    }
                };
            }
            bZR();
            if (this.interval <= 0) {
                this.interval = 5;
            }
            this.osp.postDelayed(this.hpO, this.interval * 1000);
        }
    }

    private void bZR() {
        if (this.osp != null && this.hpO != null) {
            this.osp.removeCallbacks(this.hpO);
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
                    if (tVar.aHR == 1) {
                        long j = tVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= tVar.showTime && j <= tVar.end_time && tVar.aHW != null && tVar.aHW.pos >= 0 && tVar.aHW.pos <= 2) {
                            if (tVar.aHW.pos == 0) {
                                tVar.aHW.pos = 1;
                            }
                            switch (tVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(tVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(tVar.aHW.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(tVar.aHW.pos), list2);
                                        }
                                        list2.add(tVar);
                                        if (!z2 || tVar.aHV == null) {
                                            z = z2;
                                        } else {
                                            f.QB().b(tVar.aHV);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(tVar.aHW.pos));
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
                                    if (!TextUtils.isEmpty(tVar.webUrl) && tVar.aHW != null && tVar.aHW.width > 0 && tVar.aHW.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(tVar.aHW.pos));
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
            f.QB().b(null);
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
            bZS();
            LR(i);
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
        this.oso.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                LR(i);
                break;
            case 3:
                z = a(i, tVar);
                break;
        }
        c cVar = this.hpG.get(Integer.valueOf(i));
        if (cVar != null && cVar.hpU != null && z) {
            cVar.hpU.a(this.hpH.get(Integer.valueOf(i)));
        }
        bZT();
    }

    private void bZS() {
        if (this.hpR != null) {
            Iterator<com.baidu.live.i.b> it = this.hpK.iterator();
            while (it.hasNext()) {
                this.hpR.b(it.next());
            }
            this.hpK.clear();
            this.hpR.CU();
        }
    }

    private void bZT() {
        if (this.hpR != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView LQ = LQ(i);
                if (LQ != null && LQ.getVisibility() == 0 && LQ.getChildCount() > 0 && !this.hpK.contains(LQ)) {
                    this.hpK.add(LQ);
                    this.hpR.a(LQ);
                }
            }
            this.hpR.CU();
        }
    }

    private AlaActiveRootView LP(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.hpH == null || (alaActiveRootView = this.hpH.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.hpG != null && (cVar = this.hpG.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hpU;
                if (pendantParentView == null || this.hpH == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hpH.put(Integer.valueOf(i), alaActiveRootView2);
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

    public AlaActiveRootView LQ(int i) {
        if (this.hpH != null) {
            return this.hpH.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<t> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            LR(i);
            return false;
        }
        AlaActiveRootView LQ = LQ(i);
        if (LQ != null && LQ.getChildCount() == 1) {
            View lastChild = LQ.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.osn.put(Integer.valueOf(i), null);
        LR(i);
        AlaActiveRootView LP = LP(i);
        if (LP == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(LP.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.osg);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hpP || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.hpP && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        }
        LP.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, t tVar) {
        String x = x(tVar.webUrl, tVar.jump_url, tVar.aHU);
        if (!TextUtils.isEmpty(x) && tVar.aHW != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, tVar.aHW.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, tVar.aHW.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView LQ = LQ(i);
            if (LQ != null && LQ.getChildCount() == 1) {
                View lastChild = LQ.getLastChild();
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
                    if (this.osg != null) {
                        this.osg.a(lastChild, tVar, 0);
                    }
                    return false;
                }
            }
            this.osn.put(Integer.valueOf(i), null);
            LR(i);
            AlaActiveRootView LP = LP(i);
            if (LP == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(LP.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.4
                @Override // com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveWebView.a
                public void nG(boolean z) {
                    if (z) {
                        b.this.bYK();
                    }
                }
            });
            g gVar = new g();
            gVar.t(this.mPageContext.getPageActivity()).a(new com.baidu.live.view.web.f() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.5
                @Override // com.baidu.live.view.web.f
                public void fp(int i2) {
                    b.this.osn.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bWa);
            com.baidu.live.view.web.a[] XY = gVar.XY();
            for (com.baidu.live.view.web.a aVar : XY) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.hpP || i == 2) {
                layoutParams2.gravity = 5;
            }
            LP.addView(alaActiveWebView, layoutParams2);
            if (this.osg != null) {
                this.osg.a(alaActiveWebView, tVar, 0);
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
        if (this.aDd != null) {
            Map<String, Object> eaA = eaA();
            if (i == 2) {
                eaA.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            eaA.put(BigdayActivityConfig.JUMP_URL, aK(str2, i));
            return WebviewHelper.addQueryParams(str, eaA);
        }
        return str;
    }

    private Map<String, Object> eaA() {
        HashMap hashMap = new HashMap();
        if (this.aDd != null) {
            if (this.aDd.aIz != null) {
                hashMap.put("user_id", Long.valueOf(this.aDd.aIz.userId));
            }
            if (this.aDd.aId != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aDd.aId.userId));
            }
            if (this.aDd.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aDd.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aDd.mLiveInfo.live_id));
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
    public void bYK() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jv();
            if (this.osp == null) {
                this.osp = new HandlerC0922b(this);
            }
            if (!this.osp.hasMessages(1000)) {
                this.osp.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYJ() {
        if (this.hmu != null) {
            this.hmu.clear();
        }
        if (this.osp != null) {
            this.osp.removeMessages(1000);
        }
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYL() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hpH != null) {
            if (this.hmu == null || (size = this.hmu.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmu.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hmu.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.hpH.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bYR()) {
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
                this.osp.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYJ();
            }
        }
    }

    private void Jv() {
        if (this.hmu == null) {
            this.hmu = new ArrayList();
        }
        this.hmu.clear();
        this.bkK = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.hmu.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bkK);
    }

    private void Jw() {
        if (this.bkK != null) {
            MessageManager.getInstance().unRegisterListener(this.bkK);
            this.bkK = null;
        }
    }

    private void LR(int i) {
        AlaActiveRootView LQ = LQ(i);
        if (LQ != null) {
            LQ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> eaA = eaA();
                eaA.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, eaA);
                if (!TextUtils.isEmpty(this.hpS)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.hpS;
                }
                Hw(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, eaA());
            }
            if (!TextUtils.isEmpty(this.hpS)) {
                str = str + ETAG.ITEM_SEPARATOR + this.hpS;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Hw(String str) {
        int i;
        if (this.osm == null) {
            this.osm = new com.baidu.tieba.yuyinala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.osm.setHost(this.isHost);
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.osm.g(this.aDd.mLiveInfo.user_id, this.aDd.mLiveInfo.getNameShow(), this.aDd.aIU != null ? this.aDd.aIU.cover : "");
            this.osm.setLiveId(this.aDd.mLiveInfo.live_id);
        }
        if (!this.hpP) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.osm.cc(str, i);
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
        if (this.aDd != null && this.aDd.aIU != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
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
        if (this.aDd != null && this.aDd.aIU != null) {
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
        }
        if (tVar != null && tVar.type == 0) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "static");
        } else if (tVar != null && tVar.type == 3) {
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "h5");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hpF)) {
                jSONArray = new JSONArray(this.hpF);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hpF = jSONArray.toString();
            d.xc().putString("ala_active_view_click_info", this.hpF);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vl(int i) {
        if (StringUtils.isNull(this.hpF)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hpF);
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
        PendantParentView hpU;

        c(PendantParentView pendantParentView) {
            this.hpU = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.yuyinala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0922b extends Handler {
        private final WeakReference<b> hmz;

        HandlerC0922b(b bVar) {
            this.hmz = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hmz.get() != null && message.what == 1000) {
                this.hmz.get().bYL();
            }
        }
    }
}

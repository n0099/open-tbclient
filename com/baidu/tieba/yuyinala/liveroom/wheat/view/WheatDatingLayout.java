package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.chooselover.ChooseLoverView;
import com.baidu.tieba.yuyinala.liveroom.chooselover.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WheatDatingLayout extends BaseWheatLayout {
    private static long oif = 3399;
    private int Xo;
    private w bqS;
    private View mView;
    private RelativeLayout ohY;
    private ChooseLoverView oic;
    private f oid;
    private HashMap<String, CharmValueView> oie;
    private b oig;
    private List<String[]> oih;
    private boolean oii;
    private ImageView oij;
    private a oik;

    public WheatDatingLayout(@NonNull Context context) {
        this(context, null);
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xo = e.c(100.0f, getContext());
        this.oie = new HashMap<>();
        this.oih = new ArrayList();
        this.oii = false;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_dating_layout, this);
        this.ohY = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dfT = this.mView.findViewById(a.f.mask);
    }

    private void eaB() {
        ListUtils.clear(this.oih);
    }

    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final w wVar) {
        aq(wVar);
        this.bqS = wVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                boolean ap = WheatDatingLayout.this.ap(wVar);
                WheatDatingLayout.this.ogC = list;
                WheatDatingLayout.this.ogD = ap ? list3 : list2;
                if (ListUtils.getCount(WheatDatingLayout.this.ohz) == 0 || ListUtils.getCount(WheatDatingLayout.this.ohz) != ListUtils.getCount(WheatDatingLayout.this.ogC) || ListUtils.getCount(WheatDatingLayout.this.ohA) == 0 || ListUtils.getCount(WheatDatingLayout.this.ohA) != ListUtils.getCount(list2)) {
                    WheatDatingLayout.this.eav();
                    WheatDatingLayout.this.ohY.removeAllViews();
                    WheatDatingLayout.this.ohz.clear();
                    WheatDatingLayout.this.ohA.clear();
                    WheatDatingLayout.this.oie.clear();
                    WheatDatingLayout.this.eaG();
                    WheatDatingLayout.this.eaH();
                    WheatDatingLayout.this.ar(wVar);
                    if ((wVar.aJP.getRoomMode() == 0 || wVar.aJP.getActivityStage() != 2) && WheatDatingLayout.this.oig != null) {
                        WheatDatingLayout.this.oig.dismiss();
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.ogC)) {
                        for (int i = 0; i < WheatDatingLayout.this.ogC.size(); i++) {
                            WheatDatingLayout.this.a(ap ? WheatDatingLayout.this.b(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.ap(0, true), true);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.ogD)) {
                        for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.ogD); i2++) {
                            WheatDatingLayout.this.a(ap ? WheatDatingLayout.this.b(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.ap(i2, false), false);
                        }
                    }
                    if (ap) {
                        WheatDatingLayout.this.ao(wVar);
                    }
                }
                if (ap) {
                    if (WheatDatingLayout.this.oij != null) {
                        WheatDatingLayout.this.oij.setVisibility(8);
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oie)) {
                        WheatDatingLayout.this.an(wVar);
                    } else {
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.ohA)) {
                            for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.ohA); i3++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.b(i3, false, WheatDatingLayout.this.getMatches()), i3);
                            }
                        }
                        WheatDatingLayout.this.ao(wVar);
                    }
                } else {
                    if (WheatDatingLayout.this.oij != null) {
                        WheatDatingLayout.this.oij.setVisibility(0);
                    } else {
                        WheatDatingLayout.this.eaH();
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.ohA)) {
                        for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.ohA); i4++) {
                            WheatDatingLayout.this.b(WheatDatingLayout.this.ap(i4, false), i4);
                        }
                    }
                    WheatDatingLayout.this.eaC();
                }
                WheatDatingLayout.this.as(wVar);
                if (!ListUtils.isEmpty(WheatDatingLayout.this.ohz)) {
                    for (int i5 = 0; i5 < WheatDatingLayout.this.ohz.size(); i5++) {
                        WheatDatingLayout.this.ohz.get(i5).setData(WheatDatingLayout.this.ao(i5, true), i5, true, wVar);
                    }
                }
                if (!ListUtils.isEmpty(WheatDatingLayout.this.ohA)) {
                    for (int i6 = 0; i6 < WheatDatingLayout.this.ohA.size(); i6++) {
                        WheatDatingLayout.this.ohA.get(i6).setData(WheatDatingLayout.this.ao(i6, false), i6, false, wVar);
                    }
                }
                WheatDatingLayout.this.b(list, list2, wVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(w wVar) {
        int[] iArr;
        CharmValueView charmValueView;
        if (wVar != null && wVar.aJP != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = wVar.aJP.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(wVar.aJP.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oie.get(k(iArr))) != null) {
                        w Xn = c.dYL().Xn();
                        if (Xn != null && Xn.aJZ > 0) {
                            oif = Xn.aJZ;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oif) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oif));
                        }
                        charmValueView.setCharmValue(Long.toString(alaWheatInfoData.sum_charm_count));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaC() {
        if (this.ohY != null || !ListUtils.isEmpty(this.oie)) {
            for (Map.Entry<String, CharmValueView> entry : this.oie.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.ohY != null) {
                    this.ohY.removeView(value);
                }
            }
            this.oie.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        WheatItemView wheatItemView = this.ohA.get(i);
        if (wheatItemView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) wheatItemView.getLayoutParams();
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1];
            wheatItemView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(w wVar) {
        int[] iArr;
        if (wVar != null && wVar.aJP != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = wVar.aJP.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(wVar.aJP.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dJ = dJ(i, wVar.aJP.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dJ[0]);
                        charmValueView.setY(dJ[1]);
                        this.ohY.addView(charmValueView);
                        w Xn = c.dYL().Xn();
                        if (Xn != null && Xn.aJZ > 0) {
                            oif = Xn.aJZ;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oif) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oif));
                        }
                        charmValueView.setCharmValue(Long.toString(alaWheatInfoData.sum_charm_count));
                        this.oie.put(k(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.eaD();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bqS.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dJ(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.c(25.0f, getContext());
            iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + ((this.ohD / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - e.c(25.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + ((this.ohD / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.ohC) - e.c(25.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + ((this.ohD / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - e.c(25.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext()) + ((this.ohD / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.ohC) - e.c(25.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext()) + ((this.ohD / 2) - (e.c(45.0f, getContext()) / 2));
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.uk;
        String str2 = alaWheatInfoData2 == null ? null : alaWheatInfoData2.uk;
        if (Wd(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, Wd(str2) ? null : str2}));
    }

    private boolean Wd(String str) {
        if (StringUtils.isNull(str, true)) {
            return true;
        }
        return TextUtils.equals(str, getLoginUk());
    }

    protected String getLoginUk() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return null;
        }
        return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMatches() {
        if (this.bqS == null || this.bqS.aJP == null) {
            return 0;
        }
        return this.bqS.aJP.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ap(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aJP;
        if (alaWheatInfoDataWrapper != null) {
            return alaWheatInfoDataWrapper.getRoomMode() == 1 && alaWheatInfoDataWrapper.getActivityStage() == 4;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, w wVar) {
        boolean z;
        int[] iArr;
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(list, 0);
        if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.uk)) {
            z = TextUtils.equals(alaWheatInfoData.uk, o.dZA().Xm());
        } else {
            z = false;
        }
        if (z) {
            if (wVar == null || (wVar.aJP != null && wVar.aJP.getActivityStage() != 2 && wVar.aJP.getActivityStage() != 3)) {
                if (this.oid != null) {
                    this.oid.dZm();
                    this.oid.dZo();
                    return;
                }
                return;
            }
        } else if (wVar == null || (wVar.aJP != null && wVar.aJP.getActivityStage() != 3)) {
            if (this.oid != null) {
                this.oid.dZm();
                this.oid.dZo();
                return;
            }
            return;
        } else if (this.oid != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ohA.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oid.VI(this.oid.k(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oid != null && !ListUtils.isEmpty(this.oid.dZn())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oid.dZn().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oid.VI(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.ohA)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.ohA.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (iArr != null && iArr[0] >= 0 && iArr[1] >= 0 && list2.size() >= iArr[0] && list2.size() >= iArr[1] && list2.get(iArr[0] - 1) != null && list2.get(iArr[1] - 1) != null) {
                            double[] dArr = {ap(iArr[0] - 1, false)[0] + (this.ohC / 2), ap(iArr[0] - 1, false)[1] + e.c(45.0f, getContext())};
                            double[] dArr2 = {ap(iArr[1] - 1, false)[0] + (this.ohC / 2), ap(iArr[1] - 1, false)[1] + e.c(45.0f, getContext())};
                            if (this.oid == null) {
                                this.oid = new f();
                                this.oik = new a();
                                this.oid.a(this.oik);
                            }
                            if (this.oik != null) {
                                this.oik.a(wVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oid.a(iArr, this.ohY, dArr, dArr2, this.ohY.indexOfChild(this.oij));
                            if (z && !wVar.aJP.isEnterLiveData && wVar.aJP.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String k = k(alaWheatInfoData3.pre_together);
                                if (!this.oid.VJ(k)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, wVar.aJK.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oid.bh(k, true);
                                    b((AlaWheatInfoData) ListUtils.getItem(list2, iArr[0] - 1), (AlaWheatInfoData) ListUtils.getItem(list2, iArr[1] - 1));
                                }
                            }
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements f.a {
        private w alaLiveShowData;
        private AlaWheatInfoData bSs;
        private boolean oio;
        private List<AlaWheatInfoData> oip;
        private int[] together;

        public a() {
        }

        public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = wVar;
            this.bSs = alaWheatInfoData;
            this.together = iArr;
            this.oio = z;
            this.oip = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
        public void VK(String str) {
            if (this.alaLiveShowData.aJP.isEnterLiveData && this.bSs.publish == 1 && this.bSs.other_publish == 1) {
                WheatDatingLayout.this.oid.bh(WheatDatingLayout.this.k(this.together), true);
            }
            if (!this.alaLiveShowData.aJP.isEnterLiveData) {
                WheatDatingLayout.this.oid.l(this.together);
            }
            if (!this.alaLiveShowData.aJP.isEnterLiveData && !this.oio) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oip, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oip, this.together[1] - 1));
                if (this.alaLiveShowData.aJP.getActivityStage() == 3) {
                    WheatItemView wheatItemView = WheatDatingLayout.this.ohA.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = WheatDatingLayout.this.ohA.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.eaL();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.eaL();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaE() {
        if (ListUtils.isEmpty(this.oih)) {
            this.oii = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oih, 0);
        if (strArr == null || strArr.length < 2) {
            eaE();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            eaE();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            eaE();
        } else if (eaF()) {
            this.oii = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void eac() {
                    super.eac();
                    WheatDatingLayout.this.eaE();
                }
            });
        } else {
            eaE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oih.add(new String[]{str, str2});
            if (!this.oii) {
                eaE();
            }
        }
    }

    private void aq(w wVar) {
        if (wVar == null || wVar.aJP == null || !wVar.aJP.isResultsStage()) {
            eaB();
        }
    }

    private boolean eaF() {
        if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNy == null || com.baidu.live.aa.a.PQ().bod.aNy.aQG == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().a(com.baidu.live.aa.a.PQ().bod.aNy.aQG.ET(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaG() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Xo + e.c(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.ohY.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaH() {
        this.oij = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(152.0f, getContext()), e.c(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Xo + this.ohD) + e.c(31.0f, getContext())) + this.ohD) + this.ohD) - e.c(51.0f, getContext())) - e.c(77.0f, getContext())) - e.c(7.0f, getContext());
        this.oij.setLayoutParams(layoutParams);
        this.oij.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.ohY.addView(this.oij);
    }

    private boolean eaI() {
        String Xm = g.Xm();
        return Xm != null && o.dZA().VQ(Xm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(w wVar) {
        if (this.oic == null) {
            int c = this.Xo + this.ohD + e.c(114.0f, getContext());
            this.oic = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = c;
            this.oic.setLayoutParams(layoutParams);
            this.ohY.addView(this.oic);
            this.oic.setVisibility(8);
            this.oic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.eaJ();
                }
            });
        }
        this.oic.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaJ() {
        this.oig = new b(this.mTbPageContext.getPageActivity());
        this.oig.T(this.bqS);
        this.oig.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void g(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.o(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void h(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, g.Xm());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.o(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(w wVar) {
        if (wVar != null && eaI() && wVar.aJP != null && wVar.aJP.getActivityStage() == 2 && TextUtils.isEmpty(wVar.aKa)) {
            if (this.oic != null) {
                this.oic.setVisibility(0);
                return;
            }
            ar(wVar);
            this.oic.setVisibility(0);
        } else if (this.oic != null) {
            this.oic.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] b(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = eaw() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Xo;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.ohC;
                iArr[1] = (this.Xo + this.ohD) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Xo + this.ohD) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.ohC / 2)) - e.c(40.0f, getContext())) - this.ohC;
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.ohC / 2);
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.ohC / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.ohC / 2)) - e.c(40.0f, getContext())) - this.ohC;
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD + this.ohD;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.ohC / 2);
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD + this.ohD;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.ohC / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD + this.ohD;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.ohC;
            iArr[1] = this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext());
            return iArr;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] ap(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = eaw() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Xo;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - e.c(2.0f, getContext());
            iArr[1] = (this.Xo + this.ohD) - e.c(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.ohC) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.ohC) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(31.0f, getContext()) + this.ohD;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ohC) - e.c(2.0f, getContext());
            iArr[1] = ((((this.Xo + this.ohD) + e.c(31.0f, getContext())) + this.ohD) + this.ohD) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = ((((this.Xo + this.ohD) + e.c(31.0f, getContext())) + this.ohD) + this.ohD) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(31.0f, getContext()) + this.ohD;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Xo + this.ohD + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = (this.Xo + this.ohD) - e.c(20.0f, getContext());
            return iArr;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
            return iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        WheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ohC, this.ohD);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.ohY.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.ohy);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void We(String str) {
                if (WheatDatingLayout.this.oic != null) {
                    WheatDatingLayout.this.oic.setVisibility(0);
                    WheatDatingLayout.this.eaJ();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.ohz.add(wheatItemView);
        } else {
            this.ohA.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oig != null) {
            this.oig.dismiss();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaWheatInfoData alaWheatInfoData, String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
        if (this.oic != null) {
            this.oic.setVisibility(8);
        }
        if (this.ohA != null) {
            for (int i = 0; i < this.ohA.size(); i++) {
                WheatItemView wheatItemView = this.ohA.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.c(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.bqS != null) {
                        this.bqS.aKa = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AlaWheatInfoData alaWheatInfoData) {
        if (this.ohA != null) {
            for (int i = 0; i < this.ohA.size(); i++) {
                WheatItemView wheatItemView = this.ohA.get(i);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData != null && alaWheatInfoData2.uk.equals(alaWheatInfoData.uk)) {
                    wheatItemView.setChooseLoverBgView(true);
                } else {
                    wheatItemView.setChooseLoverBgView(false);
                }
            }
        }
    }

    public int getWheatHeight() {
        if (ap(this.bqS)) {
            if (getMatches() == 1) {
                return ((this.Xo + this.ohD) - e.c(20.0f, getContext())) + this.ohD + this.ohD + this.ohD;
            }
            return this.Xo + this.ohD + e.c(30.0f, getContext()) + this.ohD + e.c(10.0f, getContext()) + this.ohD;
        }
        return (((((this.Xo + this.ohD) + e.c(31.0f, getContext())) + this.ohD) + this.ohD) - e.c(51.0f, getContext())) + this.ohD;
    }

    public String k(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

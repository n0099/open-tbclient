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
    private static long oyJ = 3399;
    private int Yp;
    private w bur;
    private View mView;
    private b oxz;
    private RelativeLayout oyC;
    private ChooseLoverView oyG;
    private f oyH;
    private HashMap<String, CharmValueView> oyI;
    private List<String[]> oyK;
    private boolean oyL;
    private ImageView oyM;
    private a oyN;

    public WheatDatingLayout(@NonNull Context context) {
        this(context, null);
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yp = e.c(100.0f, getContext());
        this.oyI = new HashMap<>();
        this.oyK = new ArrayList();
        this.oyL = false;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_dating_layout, this);
        this.oyC = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dlk = this.mView.findViewById(a.f.mask);
    }

    private void egf() {
        ListUtils.clear(this.oyK);
    }

    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final w wVar) {
        av(wVar);
        this.bur = wVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean au = WheatDatingLayout.this.au(wVar);
                    WheatDatingLayout.this.oxf = list;
                    WheatDatingLayout.this.oxg = au ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oyd) == 0 || ListUtils.getCount(WheatDatingLayout.this.oyd) != ListUtils.getCount(WheatDatingLayout.this.oxf) || ListUtils.getCount(WheatDatingLayout.this.oye) == 0 || ListUtils.getCount(WheatDatingLayout.this.oye) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.efZ();
                        WheatDatingLayout.this.oyC.removeAllViews();
                        WheatDatingLayout.this.oyd.clear();
                        WheatDatingLayout.this.oye.clear();
                        WheatDatingLayout.this.oyI.clear();
                        WheatDatingLayout.this.egk();
                        WheatDatingLayout.this.egl();
                        WheatDatingLayout.this.aw(wVar);
                        if ((wVar.aKQ.getRoomMode() == 0 || wVar.aKQ.getActivityStage() != 2) && WheatDatingLayout.this.oxz != null) {
                            WheatDatingLayout.this.oxz.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oxf)) {
                            for (int i = 0; i < WheatDatingLayout.this.oxf.size(); i++) {
                                WheatDatingLayout.this.a(au ? WheatDatingLayout.this.b(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.ap(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oxg)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oxg); i2++) {
                                WheatDatingLayout.this.a(au ? WheatDatingLayout.this.b(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.ap(i2, false), false);
                            }
                        }
                        if (au) {
                            WheatDatingLayout.this.at(wVar);
                        }
                    }
                    if (au) {
                        if (WheatDatingLayout.this.oyM != null) {
                            WheatDatingLayout.this.oyM.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oyI)) {
                            WheatDatingLayout.this.as(wVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oye)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oye); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.b(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.at(wVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oyM != null) {
                            WheatDatingLayout.this.oyM.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.egl();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oye)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oye); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.ap(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.egg();
                    }
                    WheatDatingLayout.this.ax(wVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oyd)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oyd.size(); i5++) {
                            WheatDatingLayout.this.oyd.get(i5).setData(WheatDatingLayout.this.ao(i5, true), i5, true, wVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oye)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oye.size(); i6++) {
                            WheatDatingLayout.this.oye.get(i6).setData(WheatDatingLayout.this.ao(i6, false), i6, false, wVar);
                        }
                    }
                    WheatDatingLayout.this.b(list, list2, wVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(w wVar) {
        int[] iArr;
        CharmValueView charmValueView;
        if (wVar != null && wVar.aKQ != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = wVar.aKQ.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(wVar.aKQ.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oyI.get(n(iArr))) != null) {
                        w Zd = c.eeo().Zd();
                        if (Zd != null && Zd.aLa > 0) {
                            oyJ = Zd.aLa;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oyJ) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oyJ));
                        }
                        charmValueView.setCharmValue(Long.toString(alaWheatInfoData.sum_charm_count));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egg() {
        if (this.oyC != null || !ListUtils.isEmpty(this.oyI)) {
            for (Map.Entry<String, CharmValueView> entry : this.oyI.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oyC != null) {
                    this.oyC.removeView(value);
                }
            }
            this.oyI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        WheatItemView wheatItemView = this.oye.get(i);
        if (wheatItemView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) wheatItemView.getLayoutParams();
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1];
            wheatItemView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(w wVar) {
        int[] iArr;
        if (wVar != null && wVar.aKQ != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = wVar.aKQ.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(wVar.aKQ.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dP = dP(i, wVar.aKQ.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dP[0]);
                        charmValueView.setY(dP[1]);
                        this.oyC.addView(charmValueView);
                        w Zd = c.eeo().Zd();
                        if (Zd != null && Zd.aLa > 0) {
                            oyJ = Zd.aLa;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oyJ) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oyJ));
                        }
                        charmValueView.setCharmValue(Long.toString(alaWheatInfoData.sum_charm_count));
                        this.oyI.put(n(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.egh();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bur.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dP(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.c(25.0f, getContext());
            iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + ((this.oyh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - e.c(25.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + ((this.oyh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oyg) - e.c(25.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + ((this.oyh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - e.c(25.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext()) + ((this.oyh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oyg) - e.c(25.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext()) + ((this.oyh / 2) - (e.c(45.0f, getContext()) / 2));
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
        if (Xd(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, Xd(str2) ? null : str2}));
    }

    private boolean Xd(String str) {
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
        if (this.bur == null || this.bur.aKQ == null) {
            return 0;
        }
        return this.bur.aKQ.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean au(w wVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = wVar.aKQ;
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
            z = TextUtils.equals(alaWheatInfoData.uk, o.efd().Zc());
        } else {
            z = false;
        }
        if (z) {
            if (wVar == null || (wVar.aKQ != null && wVar.aKQ.getActivityStage() != 2 && wVar.aKQ.getActivityStage() != 3)) {
                if (this.oyH != null) {
                    this.oyH.eeP();
                    this.oyH.eeR();
                    return;
                }
                return;
            }
        } else if (wVar == null || (wVar.aKQ != null && wVar.aKQ.getActivityStage() != 3)) {
            if (this.oyH != null) {
                this.oyH.eeP();
                this.oyH.eeR();
                return;
            }
            return;
        } else if (this.oyH != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oye.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oyH.WI(this.oyH.n(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oyH != null && !ListUtils.isEmpty(this.oyH.eeQ())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oyH.eeQ().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oyH.WI(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oye)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oye.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (iArr != null && iArr[0] >= 0 && iArr[1] >= 0 && list2.size() >= iArr[0] && list2.size() >= iArr[1] && list2.get(iArr[0] - 1) != null && list2.get(iArr[1] - 1) != null) {
                            double[] dArr = {ap(iArr[0] - 1, false)[0] + (this.oyg / 2), ap(iArr[0] - 1, false)[1] + e.c(45.0f, getContext())};
                            double[] dArr2 = {ap(iArr[1] - 1, false)[0] + (this.oyg / 2), ap(iArr[1] - 1, false)[1] + e.c(45.0f, getContext())};
                            if (this.oyH == null) {
                                this.oyH = new f();
                                this.oyN = new a();
                                this.oyH.a(this.oyN);
                            }
                            if (this.oyN != null) {
                                this.oyN.a(wVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oyH.a(iArr, this.oyC, dArr, dArr2, this.oyC.indexOfChild(this.oyM));
                            if (z && !wVar.aKQ.isEnterLiveData && wVar.aKQ.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String n = n(alaWheatInfoData3.pre_together);
                                if (!this.oyH.WJ(n)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, wVar.aKL.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oyH.bi(n, true);
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
        private AlaWheatInfoData bVS;
        private boolean oyR;
        private List<AlaWheatInfoData> oyS;
        private int[] together;

        public a() {
        }

        public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = wVar;
            this.bVS = alaWheatInfoData;
            this.together = iArr;
            this.oyR = z;
            this.oyS = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
        public void WK(String str) {
            if (this.alaLiveShowData.aKQ.isEnterLiveData && this.bVS.publish == 1 && this.bVS.other_publish == 1) {
                WheatDatingLayout.this.oyH.bi(WheatDatingLayout.this.n(this.together), true);
            }
            if (!this.alaLiveShowData.aKQ.isEnterLiveData) {
                WheatDatingLayout.this.oyH.o(this.together);
            }
            if (!this.alaLiveShowData.aKQ.isEnterLiveData && !this.oyR) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oyS, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oyS, this.together[1] - 1));
                if (this.alaLiveShowData.aKQ.getActivityStage() == 3) {
                    WheatItemView wheatItemView = WheatDatingLayout.this.oye.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = WheatDatingLayout.this.oye.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.egp();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.egp();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egi() {
        if (ListUtils.isEmpty(this.oyK)) {
            this.oyL = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oyK, 0);
        if (strArr == null || strArr.length < 2) {
            egi();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            egi();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            egi();
        } else if (egj()) {
            this.oyL = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void efG() {
                    super.efG();
                    WheatDatingLayout.this.egi();
                }
            });
        } else {
            egi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oyK.add(new String[]{str, str2});
            if (!this.oyL) {
                egi();
            }
        }
    }

    private void av(w wVar) {
        if (wVar == null || wVar.aKQ == null || !wVar.aKQ.isResultsStage()) {
            egf();
        }
    }

    private boolean egj() {
        if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOJ == null || com.baidu.live.ae.a.RB().brA.aOJ.aRX == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().a(com.baidu.live.ae.a.RB().brA.aOJ.aRX.FV(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egk() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yp + e.c(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oyC.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egl() {
        this.oyM = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(152.0f, getContext()), e.c(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yp + this.oyh) + e.c(31.0f, getContext())) + this.oyh) + this.oyh) - e.c(51.0f, getContext())) - e.c(77.0f, getContext())) - e.c(7.0f, getContext());
        this.oyM.setLayoutParams(layoutParams);
        this.oyM.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oyC.addView(this.oyM);
    }

    private boolean egm() {
        String Zc = g.Zc();
        return Zc != null && o.efd().WQ(Zc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(w wVar) {
        if (this.oyG == null) {
            int c = this.Yp + this.oyh + e.c(114.0f, getContext());
            this.oyG = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = c;
            this.oyG.setLayoutParams(layoutParams);
            this.oyC.addView(this.oyG);
            this.oyG.setVisibility(8);
            this.oyG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.egn();
                }
            });
        }
        this.oyG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egn() {
        this.oxz = new b(this.mTbPageContext.getPageActivity());
        this.oxz.Y(this.bur);
        this.oxz.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void g(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.o(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void h(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, g.Zc());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.o(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(w wVar) {
        if (wVar != null && egm() && wVar.aKQ != null && wVar.aKQ.getActivityStage() == 2 && TextUtils.isEmpty(wVar.aLb)) {
            if (this.oyG != null) {
                this.oyG.setVisibility(0);
                return;
            }
            aw(wVar);
            this.oyG.setVisibility(0);
        } else if (this.oyG != null) {
            this.oyG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] b(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = ega() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yp;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oyg;
                iArr[1] = (this.Yp + this.oyh) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yp + this.oyh) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oyg / 2)) - e.c(40.0f, getContext())) - this.oyg;
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oyg / 2);
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oyg / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oyg / 2)) - e.c(40.0f, getContext())) - this.oyg;
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh + this.oyh;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oyg / 2);
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh + this.oyh;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oyg / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh + this.oyh;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oyg;
            iArr[1] = this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext());
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
            iArr[0] = ega() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yp;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - e.c(2.0f, getContext());
            iArr[1] = (this.Yp + this.oyh) - e.c(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oyg) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oyg) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(31.0f, getContext()) + this.oyh;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - e.c(2.0f, getContext());
            iArr[1] = ((((this.Yp + this.oyh) + e.c(31.0f, getContext())) + this.oyh) + this.oyh) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = ((((this.Yp + this.oyh) + e.c(31.0f, getContext())) + this.oyh) + this.oyh) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(31.0f, getContext()) + this.oyh;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yp + this.oyh + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = (this.Yp + this.oyh) - e.c(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oyg, this.oyh);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oyC.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oyc);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void Xe(String str) {
                if (WheatDatingLayout.this.oyG != null) {
                    WheatDatingLayout.this.oyG.setVisibility(0);
                    WheatDatingLayout.this.egn();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oyd.add(wheatItemView);
        } else {
            this.oye.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oxz != null) {
            this.oxz.dismiss();
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
        if (this.oyG != null) {
            this.oyG.setVisibility(8);
        }
        if (this.oye != null) {
            for (int i = 0; i < this.oye.size(); i++) {
                WheatItemView wheatItemView = this.oye.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.c(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.bur != null) {
                        this.bur.aLb = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AlaWheatInfoData alaWheatInfoData) {
        if (this.oye != null) {
            for (int i = 0; i < this.oye.size(); i++) {
                WheatItemView wheatItemView = this.oye.get(i);
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
        if (au(this.bur)) {
            if (getMatches() == 1) {
                return ((this.Yp + this.oyh) - e.c(20.0f, getContext())) + this.oyh + this.oyh + this.oyh;
            }
            return this.Yp + this.oyh + e.c(30.0f, getContext()) + this.oyh + e.c(10.0f, getContext()) + this.oyh;
        }
        return (((((this.Yp + this.oyh) + e.c(31.0f, getContext())) + this.oyh) + this.oyh) - e.c(51.0f, getContext())) + this.oyh;
    }

    public String n(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

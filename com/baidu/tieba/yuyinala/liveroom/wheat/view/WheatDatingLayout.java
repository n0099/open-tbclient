package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
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
import com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class WheatDatingLayout extends BaseWheatLayout {
    private static long oMm = 3399;
    private ab bxN;
    private ChooseLoverView oMj;
    private g oMk;
    private HashMap<String, CharmValueView> oMl;
    private b oMn;
    private List<String[]> oMo;
    private boolean oMp;
    private ImageView oMq;
    private a oMr;
    private DatingNavView oMs;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oMl = new HashMap<>();
        this.oMo = new ArrayList();
        this.oMp = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oMl = new HashMap<>();
        this.oMo = new ArrayList();
        this.oMp = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oMl = new HashMap<>();
        this.oMo = new ArrayList();
        this.oMp = false;
    }

    private void eft() {
        ListUtils.clear(this.oMo);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final ab abVar) {
        super.a(list, list2, list3, abVar);
        aI(abVar);
        this.bxN = abVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean aH = WheatDatingLayout.this.aH(abVar);
                    WheatDatingLayout.this.oJF = list;
                    WheatDatingLayout.this.oJG = aH ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oKJ) == 0 || ListUtils.getCount(WheatDatingLayout.this.oKJ) != ListUtils.getCount(WheatDatingLayout.this.oJF) || ListUtils.getCount(WheatDatingLayout.this.oKK) == 0 || ListUtils.getCount(WheatDatingLayout.this.oKK) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.eeT();
                        WheatDatingLayout.this.oKO.removeAllViews();
                        WheatDatingLayout.this.oKJ.clear();
                        WheatDatingLayout.this.oKK.clear();
                        WheatDatingLayout.this.oMl.clear();
                        WheatDatingLayout.this.aJ(abVar);
                        WheatDatingLayout.this.efy();
                        WheatDatingLayout.this.efz();
                        WheatDatingLayout.this.aL(abVar);
                        if ((abVar.aIY.getRoomMode() != 1 || abVar.aIY.getActivityStage() != 2) && WheatDatingLayout.this.oMn != null) {
                            WheatDatingLayout.this.oMn.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oJF)) {
                            for (int i = 0; i < WheatDatingLayout.this.oJF.size(); i++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oJG)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oJG); i2++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aH) {
                            WheatDatingLayout.this.aG(abVar);
                        }
                        WheatDatingLayout.this.oKO.invalidate();
                        WheatDatingLayout.this.oKO.requestLayout();
                    }
                    WheatDatingLayout.this.aK(abVar);
                    if (aH) {
                        if (WheatDatingLayout.this.oMq != null) {
                            WheatDatingLayout.this.oMq.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oMl)) {
                            WheatDatingLayout.this.aF(abVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oKK)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oKK); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.d(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aG(abVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oMq != null) {
                            WheatDatingLayout.this.oMq.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.efz();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oKK)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oKK); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.efu();
                    }
                    WheatDatingLayout.this.aM(abVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oKJ)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oKJ.size(); i5++) {
                            WheatDatingLayout.this.oKJ.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, abVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oKK)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oKK.size(); i6++) {
                            WheatDatingLayout.this.oKK.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, abVar);
                        }
                    }
                    WheatDatingLayout.this.b(list, list2, abVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(ab abVar) {
        int[] iArr;
        CharmValueView charmValueView;
        if (abVar != null && abVar.aIY != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = abVar.aIY.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(abVar.aIY.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oMl.get(o(iArr))) != null) {
                        ab Yq = c.ecR().Yq();
                        if (Yq != null && Yq.aJl > 0) {
                            oMm = Yq.aJl;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oMm) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oMm));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efu() {
        if (this.oKO != null || !ListUtils.isEmpty(this.oMl)) {
            for (Map.Entry<String, CharmValueView> entry : this.oMl.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oKO != null) {
                    this.oKO.removeView(value);
                }
            }
            this.oMl.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        BaseWheatItemView baseWheatItemView = this.oKK.get(i);
        if (baseWheatItemView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) baseWheatItemView.getLayoutParams();
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1];
            baseWheatItemView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(ab abVar) {
        int[] iArr;
        if (abVar != null && abVar.aIY != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = abVar.aIY.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(abVar.aIY.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dL = dL(i, abVar.aIY.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dL[0]);
                        charmValueView.setY(dL[1]);
                        this.oKO.addView(charmValueView);
                        ab Yq = c.ecR().Yq();
                        if (Yq != null && Yq.aJl > 0) {
                            oMm = Yq.aJl;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oMm) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oMm));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oMl.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.efv();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bxN.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dL(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.d(25.0f, getContext());
            iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + ((this.oKN / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + ((this.oKN / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oKM) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + ((this.oKN / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext()) + ((this.oKN / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oKM) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext()) + ((this.oKN / 2) - (e.d(45.0f, getContext()) / 2));
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
        if (WS(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, WS(str2) ? null : str2}));
    }

    private boolean WS(String str) {
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
        ab abVar = this.bxN;
        if (abVar == null) {
            abVar = q.edM().Yq();
        }
        if (abVar == null || abVar.aIY == null) {
            return 0;
        }
        return abVar.aIY.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aH(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        boolean z = true;
        if (abVar == null) {
            abVar = q.edM().Yq();
        }
        if (abVar == null || (alaWheatInfoDataWrapper = abVar.aIY) == null) {
            return false;
        }
        if (alaWheatInfoDataWrapper.getRoomMode() != 1 || alaWheatInfoDataWrapper.getActivityStage() != 4) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, ab abVar) {
        boolean z;
        int[] iArr;
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(list, 0);
        if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.uk)) {
            z = TextUtils.equals(alaWheatInfoData.uk, q.edM().Yp());
        } else {
            z = false;
        }
        if (z) {
            if (abVar == null || (abVar.aIY != null && abVar.aIY.getActivityStage() != 2 && abVar.aIY.getActivityStage() != 3)) {
                if (this.oMk != null) {
                    this.oMk.edu();
                    this.oMk.edw();
                    return;
                }
                return;
            }
        } else if (abVar == null || (abVar.aIY != null && abVar.aIY.getActivityStage() != 3)) {
            if (this.oMk != null) {
                this.oMk.edu();
                this.oMk.edw();
                return;
            }
            return;
        } else if (this.oMk != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oKK.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oMk.Wt(this.oMk.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oMk != null && !ListUtils.isEmpty(this.oMk.edv())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oMk.edv().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oMk.Wt(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oKK)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oKK.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (a(list2, iArr)) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oKM / 2), an(iArr[0] - 1, false)[1] + e.d(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oKM / 2), an(iArr[1] - 1, false)[1] + e.d(45.0f, getContext())};
                            if (this.oMk == null) {
                                this.oMk = new g();
                                this.oMr = new a();
                                this.oMk.a(this.oMr);
                            }
                            if (this.oMr != null) {
                                this.oMr.a(abVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oMk.a(iArr, this.oKO, dArr, dArr2, this.oKO.indexOfChild(this.oMq));
                            if (z && !abVar.aIY.isEnterLiveData && abVar.aIY.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oMk.Wu(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, abVar.aIU.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oMk.bh(o, true);
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

    private boolean a(List<AlaWheatInfoData> list, int[] iArr) {
        if (iArr == null || iArr.length != 2 || iArr[0] <= 0 || iArr[0] > list.size() || iArr[1] <= 0 || iArr[1] > list.size()) {
            return false;
        }
        return Integer.parseInt(list.get(iArr[0] + (-1)).phoneOrder) == list.get(iArr[1] + (-1)).select && Integer.parseInt(list.get(iArr[1] + (-1)).phoneOrder) == list.get(iArr[0] + (-1)).select;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements g.a {
        private ab alaLiveShowData;
        private AlaWheatInfoData cbv;
        private boolean oMw;
        private List<AlaWheatInfoData> oMx;
        private int[] together;

        public a() {
        }

        public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = abVar;
            this.cbv = alaWheatInfoData;
            this.together = iArr;
            this.oMw = z;
            this.oMx = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.g.a
        public void Wv(String str) {
            if (this.alaLiveShowData.aIY.isEnterLiveData && this.cbv.publish == 1 && this.cbv.other_publish == 1) {
                WheatDatingLayout.this.oMk.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aIY.isEnterLiveData) {
                WheatDatingLayout.this.oMk.p(this.together);
            }
            if (!this.alaLiveShowData.aIY.isEnterLiveData && !this.oMw) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oMx, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oMx, this.together[1] - 1));
                if (this.alaLiveShowData.aIY.getActivityStage() == 3) {
                    WheatItemView wheatItemView = (WheatItemView) WheatDatingLayout.this.oKK.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = (WheatItemView) WheatDatingLayout.this.oKK.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.efD();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.efD();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efw() {
        if (ListUtils.isEmpty(this.oMo)) {
            this.oMp = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oMo, 0);
        if (strArr == null || strArr.length < 2) {
            efw();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            efw();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            efw();
        } else if (efx()) {
            this.oMp = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void eev() {
                    super.eev();
                    WheatDatingLayout.this.efw();
                }
            });
        } else {
            efw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oMo.add(new String[]{str, str2});
            if (!this.oMp) {
                efw();
            }
        }
    }

    private void aI(ab abVar) {
        if (abVar == null || abVar.aIY == null || !abVar.aIY.isResultsStage()) {
            eft();
        }
    }

    private boolean efx() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CD(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oMs = new DatingNavView(this.mTbPageContext.getPageActivity());
            this.oMs.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = this.Yh + e.d(26.0f, getContext());
            layoutParams.width = BdUtilHelper.getScreenSize(this.mTbPageContext.getPageActivity()).widthPixels - e.d(eeU() ? 100.0f : 110.0f, getContext());
            this.oKO.addView(this.oMs, layoutParams);
            this.oMs.f(abVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(ab abVar) {
        this.oMs.k(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efy() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yh + e.d(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oKO.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efz() {
        this.oMq = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(152.0f, getContext()), e.d(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yh + this.oKN) + e.d(31.0f, getContext())) + this.oKN) + this.oKN) - e.d(51.0f, getContext())) - e.d(77.0f, getContext())) - e.d(7.0f, getContext());
        this.oMq.setLayoutParams(layoutParams);
        this.oMq.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oKO.addView(this.oMq);
    }

    private boolean efA() {
        String Yp = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
        return Yp != null && q.edM().WD(Yp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(ab abVar) {
        if (this.oMj == null) {
            int d = this.Yh + this.oKN + e.d(114.0f, getContext());
            this.oMj = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = d;
            this.oMj.setLayoutParams(layoutParams);
            this.oKO.addView(this.oMj);
            this.oMj.setVisibility(8);
            this.oMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.efB();
                }
            });
        }
        this.oMj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efB() {
        this.oMn = new b(this.mTbPageContext.getPageActivity());
        this.oMn.ab(this.bxN);
        this.oMn.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void e(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void f(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.m(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(ab abVar) {
        if (abVar != null && efA() && abVar.aIY != null && abVar.aIY.getActivityStage() == 2 && TextUtils.isEmpty(abVar.aJm)) {
            if (this.oMj != null) {
                this.oMj.setVisibility(0);
                return;
            }
            aL(abVar);
            this.oMj.setVisibility(0);
        } else if (this.oMj != null) {
            this.oMj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] d(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = eeU() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yh;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oKM;
                iArr[1] = (this.Yh + this.oKN) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yh + this.oKN) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oKM / 2)) - e.d(40.0f, getContext())) - this.oKM;
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oKM / 2);
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oKM / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oKM / 2)) - e.d(40.0f, getContext())) - this.oKM;
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN + this.oKN;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oKM / 2);
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN + this.oKN;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oKM / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN + this.oKN;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKM;
            iArr[1] = this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext());
            return iArr;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = eeU() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yh;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - e.d(2.0f, getContext());
            iArr[1] = (this.Yh + this.oKN) - e.d(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oKM) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oKM) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(31.0f, getContext()) + this.oKN;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - e.d(2.0f, getContext());
            iArr[1] = ((((this.Yh + this.oKN) + e.d(31.0f, getContext())) + this.oKN) + this.oKN) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = ((((this.Yh + this.oKN) + e.d(31.0f, getContext())) + this.oKN) + this.oKN) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(31.0f, getContext()) + this.oKN;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yh + this.oKN + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = (this.Yh + this.oKN) - e.d(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKM, this.oKN);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oKO.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oKI);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void WT(String str) {
                if (WheatDatingLayout.this.oMj != null) {
                    WheatDatingLayout.this.oMj.setVisibility(0);
                    WheatDatingLayout.this.efB();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oKJ.add(wheatItemView);
        } else {
            this.oKK.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oMn != null) {
            this.oMn.dismiss();
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
        if (this.oMj != null) {
            this.oMj.setVisibility(8);
        }
        if (this.oKK != null) {
            for (int i = 0; i < this.oKK.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oKK.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.d(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.bxN != null) {
                        this.bxN.aJm = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        if (this.oKK != null) {
            for (int i = 0; i < this.oKK.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oKK.get(i);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData != null && alaWheatInfoData2.uk.equals(alaWheatInfoData.uk)) {
                    wheatItemView.setChooseLoverBgView(true);
                } else {
                    wheatItemView.setChooseLoverBgView(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public int getWheatHeight() {
        if (aH(this.bxN)) {
            if (getMatches() == 1) {
                return ((this.Yh + this.oKN) - e.d(20.0f, getContext())) + this.oKN + this.oKN + this.oKN;
            }
            return this.Yh + this.oKN + e.d(30.0f, getContext()) + this.oKN + e.d(10.0f, getContext()) + this.oKN;
        }
        return (((((this.Yh + this.oKN) + e.d(31.0f, getContext())) + this.oKN) + this.oKN) - e.d(51.0f, getContext())) + this.oKN;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

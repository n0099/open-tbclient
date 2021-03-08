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
/* loaded from: classes10.dex */
public class WheatDatingLayout extends BaseWheatLayout {
    private static long oOr = 3399;
    private ab bzn;
    private ChooseLoverView oOo;
    private g oOp;
    private HashMap<String, CharmValueView> oOq;
    private b oOs;
    private List<String[]> oOt;
    private boolean oOu;
    private ImageView oOv;
    private a oOw;
    private DatingNavView oOx;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oOq = new HashMap<>();
        this.oOt = new ArrayList();
        this.oOu = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oOq = new HashMap<>();
        this.oOt = new ArrayList();
        this.oOu = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oOq = new HashMap<>();
        this.oOt = new ArrayList();
        this.oOu = false;
    }

    private void efB() {
        ListUtils.clear(this.oOt);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final ab abVar) {
        super.a(list, list2, list3, abVar);
        aI(abVar);
        this.bzn = abVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean aH = WheatDatingLayout.this.aH(abVar);
                    WheatDatingLayout.this.oLK = list;
                    WheatDatingLayout.this.oLL = aH ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oMO) == 0 || ListUtils.getCount(WheatDatingLayout.this.oMO) != ListUtils.getCount(WheatDatingLayout.this.oLK) || ListUtils.getCount(WheatDatingLayout.this.oMP) == 0 || ListUtils.getCount(WheatDatingLayout.this.oMP) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.efb();
                        WheatDatingLayout.this.oMT.removeAllViews();
                        WheatDatingLayout.this.oMO.clear();
                        WheatDatingLayout.this.oMP.clear();
                        WheatDatingLayout.this.oOq.clear();
                        WheatDatingLayout.this.aJ(abVar);
                        WheatDatingLayout.this.efG();
                        WheatDatingLayout.this.efH();
                        WheatDatingLayout.this.aL(abVar);
                        if ((abVar.aKy.getRoomMode() != 1 || abVar.aKy.getActivityStage() != 2) && WheatDatingLayout.this.oOs != null) {
                            WheatDatingLayout.this.oOs.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oLK)) {
                            for (int i = 0; i < WheatDatingLayout.this.oLK.size(); i++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oLL)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oLL); i2++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aH) {
                            WheatDatingLayout.this.aG(abVar);
                        }
                        WheatDatingLayout.this.oMT.invalidate();
                        WheatDatingLayout.this.oMT.requestLayout();
                    }
                    WheatDatingLayout.this.aK(abVar);
                    if (aH) {
                        if (WheatDatingLayout.this.oOv != null) {
                            WheatDatingLayout.this.oOv.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oOq)) {
                            WheatDatingLayout.this.aF(abVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oMP)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oMP); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.d(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aG(abVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oOv != null) {
                            WheatDatingLayout.this.oOv.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.efH();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oMP)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oMP); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.efC();
                    }
                    WheatDatingLayout.this.aM(abVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oMO)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oMO.size(); i5++) {
                            WheatDatingLayout.this.oMO.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, abVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oMP)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oMP.size(); i6++) {
                            WheatDatingLayout.this.oMP.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, abVar);
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
        if (abVar != null && abVar.aKy != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = abVar.aKy.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(abVar.aKy.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oOq.get(o(iArr))) != null) {
                        ab Yt = c.ecZ().Yt();
                        if (Yt != null && Yt.aKL > 0) {
                            oOr = Yt.aKL;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oOr) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oOr));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efC() {
        if (this.oMT != null || !ListUtils.isEmpty(this.oOq)) {
            for (Map.Entry<String, CharmValueView> entry : this.oOq.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oMT != null) {
                    this.oMT.removeView(value);
                }
            }
            this.oOq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        BaseWheatItemView baseWheatItemView = this.oMP.get(i);
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
        if (abVar != null && abVar.aKy != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = abVar.aKy.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(abVar.aKy.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dL = dL(i, abVar.aKy.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dL[0]);
                        charmValueView.setY(dL[1]);
                        this.oMT.addView(charmValueView);
                        ab Yt = c.ecZ().Yt();
                        if (Yt != null && Yt.aKL > 0) {
                            oOr = Yt.aKL;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oOr) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oOr));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oOq.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.efD();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bzn.aKu.croom_id);
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
            iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + ((this.oMS / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - e.d(25.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + ((this.oMS / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oMR) - e.d(25.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + ((this.oMS / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - e.d(25.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext()) + ((this.oMS / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oMR) - e.d(25.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext()) + ((this.oMS / 2) - (e.d(45.0f, getContext()) / 2));
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
        if (WZ(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, WZ(str2) ? null : str2}));
    }

    private boolean WZ(String str) {
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
        ab abVar = this.bzn;
        if (abVar == null) {
            abVar = q.edU().Yt();
        }
        if (abVar == null || abVar.aKy == null) {
            return 0;
        }
        return abVar.aKy.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aH(ab abVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        boolean z = true;
        if (abVar == null) {
            abVar = q.edU().Yt();
        }
        if (abVar == null || (alaWheatInfoDataWrapper = abVar.aKy) == null) {
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
            z = TextUtils.equals(alaWheatInfoData.uk, q.edU().Ys());
        } else {
            z = false;
        }
        if (z) {
            if (abVar == null || (abVar.aKy != null && abVar.aKy.getActivityStage() != 2 && abVar.aKy.getActivityStage() != 3)) {
                if (this.oOp != null) {
                    this.oOp.edC();
                    this.oOp.edE();
                    return;
                }
                return;
            }
        } else if (abVar == null || (abVar.aKy != null && abVar.aKy.getActivityStage() != 3)) {
            if (this.oOp != null) {
                this.oOp.edC();
                this.oOp.edE();
                return;
            }
            return;
        } else if (this.oOp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oMP.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oOp.WA(this.oOp.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oOp != null && !ListUtils.isEmpty(this.oOp.edD())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oOp.edD().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oOp.WA(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oMP)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oMP.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (a(list2, iArr)) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oMR / 2), an(iArr[0] - 1, false)[1] + e.d(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oMR / 2), an(iArr[1] - 1, false)[1] + e.d(45.0f, getContext())};
                            if (this.oOp == null) {
                                this.oOp = new g();
                                this.oOw = new a();
                                this.oOp.a(this.oOw);
                            }
                            if (this.oOw != null) {
                                this.oOw.a(abVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oOp.a(iArr, this.oMT, dArr, dArr2, this.oMT.indexOfChild(this.oOv));
                            if (z && !abVar.aKy.isEnterLiveData && abVar.aKy.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oOp.WB(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, abVar.aKu.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oOp.bh(o, true);
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
    /* loaded from: classes10.dex */
    public class a implements g.a {
        private ab alaLiveShowData;
        private AlaWheatInfoData ccW;
        private boolean oOB;
        private List<AlaWheatInfoData> oOC;
        private int[] together;

        public a() {
        }

        public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = abVar;
            this.ccW = alaWheatInfoData;
            this.together = iArr;
            this.oOB = z;
            this.oOC = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.g.a
        public void WC(String str) {
            if (this.alaLiveShowData.aKy.isEnterLiveData && this.ccW.publish == 1 && this.ccW.other_publish == 1) {
                WheatDatingLayout.this.oOp.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aKy.isEnterLiveData) {
                WheatDatingLayout.this.oOp.p(this.together);
            }
            if (!this.alaLiveShowData.aKy.isEnterLiveData && !this.oOB) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oOC, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oOC, this.together[1] - 1));
                if (this.alaLiveShowData.aKy.getActivityStage() == 3) {
                    WheatItemView wheatItemView = (WheatItemView) WheatDatingLayout.this.oMP.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = (WheatItemView) WheatDatingLayout.this.oMP.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.efL();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.efL();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efE() {
        if (ListUtils.isEmpty(this.oOt)) {
            this.oOu = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oOt, 0);
        if (strArr == null || strArr.length < 2) {
            efE();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            efE();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            efE();
        } else if (efF()) {
            this.oOu = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void eeD() {
                    super.eeD();
                    WheatDatingLayout.this.efE();
                }
            });
        } else {
            efE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oOt.add(new String[]{str, str2});
            if (!this.oOu) {
                efE();
            }
        }
    }

    private void aI(ab abVar) {
        if (abVar == null || abVar.aKy == null || !abVar.aKy.isResultsStage()) {
            efB();
        }
    }

    private boolean efF() {
        if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOT == null || com.baidu.live.ae.a.Qm().bwx.aOT.aSI == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().a(com.baidu.live.ae.a.Qm().bwx.aOT.aSI.CG(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oOx = new DatingNavView(this.mTbPageContext.getPageActivity());
            this.oOx.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = this.ZA + e.d(26.0f, getContext());
            layoutParams.width = BdUtilHelper.getScreenSize(this.mTbPageContext.getPageActivity()).widthPixels - e.d(efc() ? 100.0f : 110.0f, getContext());
            this.oMT.addView(this.oOx, layoutParams);
            this.oOx.f(abVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(ab abVar) {
        this.oOx.k(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efG() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.ZA + e.d(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oMT.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efH() {
        this.oOv = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(152.0f, getContext()), e.d(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.ZA + this.oMS) + e.d(31.0f, getContext())) + this.oMS) + this.oMS) - e.d(51.0f, getContext())) - e.d(77.0f, getContext())) - e.d(7.0f, getContext());
        this.oOv.setLayoutParams(layoutParams);
        this.oOv.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oMT.addView(this.oOv);
    }

    private boolean efI() {
        String Ys = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Ys();
        return Ys != null && q.edU().WK(Ys);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(ab abVar) {
        if (this.oOo == null) {
            int d = this.ZA + this.oMS + e.d(114.0f, getContext());
            this.oOo = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = d;
            this.oOo.setLayoutParams(layoutParams);
            this.oMT.addView(this.oOo);
            this.oOo.setVisibility(8);
            this.oOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.efJ();
                }
            });
        }
        this.oOo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efJ() {
        this.oOs = new b(this.mTbPageContext.getPageActivity());
        this.oOs.ab(this.bzn);
        this.oOs.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void e(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void f(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Ys());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.m(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(ab abVar) {
        if (abVar != null && efI() && abVar.aKy != null && abVar.aKy.getActivityStage() == 2 && TextUtils.isEmpty(abVar.aKM)) {
            if (this.oOo != null) {
                this.oOo.setVisibility(0);
                return;
            }
            aL(abVar);
            this.oOo.setVisibility(0);
        } else if (this.oOo != null) {
            this.oOo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] d(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = efc() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.ZA;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oMR;
                iArr[1] = (this.ZA + this.oMS) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.ZA + this.oMS) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oMR / 2)) - e.d(40.0f, getContext())) - this.oMR;
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oMR / 2);
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oMR / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oMR / 2)) - e.d(40.0f, getContext())) - this.oMR;
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS + this.oMS;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oMR / 2);
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS + this.oMS;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oMR / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS + this.oMS;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oMR;
            iArr[1] = this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext());
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
            iArr[0] = efc() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.ZA;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - e.d(2.0f, getContext());
            iArr[1] = (this.ZA + this.oMS) - e.d(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oMR) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oMR) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(31.0f, getContext()) + this.oMS;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - e.d(2.0f, getContext());
            iArr[1] = ((((this.ZA + this.oMS) + e.d(31.0f, getContext())) + this.oMS) + this.oMS) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = ((((this.ZA + this.oMS) + e.d(31.0f, getContext())) + this.oMS) + this.oMS) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(31.0f, getContext()) + this.oMS;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.ZA + this.oMS + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = (this.ZA + this.oMS) - e.d(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oMR, this.oMS);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oMT.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oMN);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void Xa(String str) {
                if (WheatDatingLayout.this.oOo != null) {
                    WheatDatingLayout.this.oOo.setVisibility(0);
                    WheatDatingLayout.this.efJ();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oMO.add(wheatItemView);
        } else {
            this.oMP.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oOs != null) {
            this.oOs.dismiss();
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
        if (this.oOo != null) {
            this.oOo.setVisibility(8);
        }
        if (this.oMP != null) {
            for (int i = 0; i < this.oMP.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oMP.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.d(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.bzn != null) {
                        this.bzn.aKM = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        if (this.oMP != null) {
            for (int i = 0; i < this.oMP.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oMP.get(i);
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
        if (aH(this.bzn)) {
            if (getMatches() == 1) {
                return ((this.ZA + this.oMS) - e.d(20.0f, getContext())) + this.oMS + this.oMS + this.oMS;
            }
            return this.ZA + this.oMS + e.d(30.0f, getContext()) + this.oMS + e.d(10.0f, getContext()) + this.oMS;
        }
        return (((((this.ZA + this.oMS) + e.d(31.0f, getContext())) + this.oMS) + this.oMS) - e.d(51.0f, getContext())) + this.oMS;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

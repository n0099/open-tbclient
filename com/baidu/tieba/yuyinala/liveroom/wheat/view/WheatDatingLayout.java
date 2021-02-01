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
    private static long oLM = 3399;
    private ab bxN;
    private ChooseLoverView oLJ;
    private g oLK;
    private HashMap<String, CharmValueView> oLL;
    private b oLN;
    private List<String[]> oLO;
    private boolean oLP;
    private ImageView oLQ;
    private a oLR;
    private DatingNavView oLS;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oLL = new HashMap<>();
        this.oLO = new ArrayList();
        this.oLP = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oLL = new HashMap<>();
        this.oLO = new ArrayList();
        this.oLP = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oLL = new HashMap<>();
        this.oLO = new ArrayList();
        this.oLP = false;
    }

    private void efl() {
        ListUtils.clear(this.oLO);
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
                    WheatDatingLayout.this.oJf = list;
                    WheatDatingLayout.this.oJg = aH ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oKj) == 0 || ListUtils.getCount(WheatDatingLayout.this.oKj) != ListUtils.getCount(WheatDatingLayout.this.oJf) || ListUtils.getCount(WheatDatingLayout.this.oKk) == 0 || ListUtils.getCount(WheatDatingLayout.this.oKk) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.eeL();
                        WheatDatingLayout.this.oKo.removeAllViews();
                        WheatDatingLayout.this.oKj.clear();
                        WheatDatingLayout.this.oKk.clear();
                        WheatDatingLayout.this.oLL.clear();
                        WheatDatingLayout.this.aJ(abVar);
                        WheatDatingLayout.this.efq();
                        WheatDatingLayout.this.efr();
                        WheatDatingLayout.this.aL(abVar);
                        if ((abVar.aIY.getRoomMode() != 1 || abVar.aIY.getActivityStage() != 2) && WheatDatingLayout.this.oLN != null) {
                            WheatDatingLayout.this.oLN.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oJf)) {
                            for (int i = 0; i < WheatDatingLayout.this.oJf.size(); i++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oJg)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oJg); i2++) {
                                WheatDatingLayout.this.a(aH ? WheatDatingLayout.this.d(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aH) {
                            WheatDatingLayout.this.aG(abVar);
                        }
                        WheatDatingLayout.this.oKo.invalidate();
                        WheatDatingLayout.this.oKo.requestLayout();
                    }
                    WheatDatingLayout.this.aK(abVar);
                    if (aH) {
                        if (WheatDatingLayout.this.oLQ != null) {
                            WheatDatingLayout.this.oLQ.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oLL)) {
                            WheatDatingLayout.this.aF(abVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oKk)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oKk); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.d(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aG(abVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oLQ != null) {
                            WheatDatingLayout.this.oLQ.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.efr();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oKk)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oKk); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.efm();
                    }
                    WheatDatingLayout.this.aM(abVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oKj)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oKj.size(); i5++) {
                            WheatDatingLayout.this.oKj.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, abVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oKk)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oKk.size(); i6++) {
                            WheatDatingLayout.this.oKk.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, abVar);
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
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oLL.get(o(iArr))) != null) {
                        ab Yq = c.ecJ().Yq();
                        if (Yq != null && Yq.aJl > 0) {
                            oLM = Yq.aJl;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oLM) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oLM));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efm() {
        if (this.oKo != null || !ListUtils.isEmpty(this.oLL)) {
            for (Map.Entry<String, CharmValueView> entry : this.oLL.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oKo != null) {
                    this.oKo.removeView(value);
                }
            }
            this.oLL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        BaseWheatItemView baseWheatItemView = this.oKk.get(i);
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
                        int[] dK = dK(i, abVar.aIY.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dK[0]);
                        charmValueView.setY(dK[1]);
                        this.oKo.addView(charmValueView);
                        ab Yq = c.ecJ().Yq();
                        if (Yq != null && Yq.aJl > 0) {
                            oLM = Yq.aJl;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oLM) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oLM));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oLL.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.efn();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bxN.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dK(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.d(25.0f, getContext());
            iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + ((this.oKn / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + ((this.oKn / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oKm) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + ((this.oKn / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext()) + ((this.oKn / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oKm) - e.d(25.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext()) + ((this.oKn / 2) - (e.d(45.0f, getContext()) / 2));
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
        if (WG(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, WG(str2) ? null : str2}));
    }

    private boolean WG(String str) {
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
            abVar = q.edE().Yq();
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
            abVar = q.edE().Yq();
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
            z = TextUtils.equals(alaWheatInfoData.uk, q.edE().Yp());
        } else {
            z = false;
        }
        if (z) {
            if (abVar == null || (abVar.aIY != null && abVar.aIY.getActivityStage() != 2 && abVar.aIY.getActivityStage() != 3)) {
                if (this.oLK != null) {
                    this.oLK.edm();
                    this.oLK.edo();
                    return;
                }
                return;
            }
        } else if (abVar == null || (abVar.aIY != null && abVar.aIY.getActivityStage() != 3)) {
            if (this.oLK != null) {
                this.oLK.edm();
                this.oLK.edo();
                return;
            }
            return;
        } else if (this.oLK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oKk.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oLK.Wh(this.oLK.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oLK != null && !ListUtils.isEmpty(this.oLK.edn())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oLK.edn().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oLK.Wh(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oKk)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oKk.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (a(list2, iArr)) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oKm / 2), an(iArr[0] - 1, false)[1] + e.d(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oKm / 2), an(iArr[1] - 1, false)[1] + e.d(45.0f, getContext())};
                            if (this.oLK == null) {
                                this.oLK = new g();
                                this.oLR = new a();
                                this.oLK.a(this.oLR);
                            }
                            if (this.oLR != null) {
                                this.oLR.a(abVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oLK.a(iArr, this.oKo, dArr, dArr2, this.oKo.indexOfChild(this.oLQ));
                            if (z && !abVar.aIY.isEnterLiveData && abVar.aIY.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oLK.Wi(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, abVar.aIU.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oLK.bh(o, true);
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
        private boolean oLW;
        private List<AlaWheatInfoData> oLX;
        private int[] together;

        public a() {
        }

        public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = abVar;
            this.cbv = alaWheatInfoData;
            this.together = iArr;
            this.oLW = z;
            this.oLX = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.g.a
        public void Wj(String str) {
            if (this.alaLiveShowData.aIY.isEnterLiveData && this.cbv.publish == 1 && this.cbv.other_publish == 1) {
                WheatDatingLayout.this.oLK.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aIY.isEnterLiveData) {
                WheatDatingLayout.this.oLK.p(this.together);
            }
            if (!this.alaLiveShowData.aIY.isEnterLiveData && !this.oLW) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oLX, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oLX, this.together[1] - 1));
                if (this.alaLiveShowData.aIY.getActivityStage() == 3) {
                    WheatItemView wheatItemView = (WheatItemView) WheatDatingLayout.this.oKk.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = (WheatItemView) WheatDatingLayout.this.oKk.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.efv();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.efv();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efo() {
        if (ListUtils.isEmpty(this.oLO)) {
            this.oLP = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oLO, 0);
        if (strArr == null || strArr.length < 2) {
            efo();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            efo();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            efo();
        } else if (efp()) {
            this.oLP = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void een() {
                    super.een();
                    WheatDatingLayout.this.efo();
                }
            });
        } else {
            efo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oLO.add(new String[]{str, str2});
            if (!this.oLP) {
                efo();
            }
        }
    }

    private void aI(ab abVar) {
        if (abVar == null || abVar.aIY == null || !abVar.aIY.isResultsStage()) {
            efl();
        }
    }

    private boolean efp() {
        if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNt == null || com.baidu.live.ae.a.Qj().buX.aNt.aRi == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().a(com.baidu.live.ae.a.Qj().buX.aNt.aRi.CD(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oLS = new DatingNavView(this.mTbPageContext.getPageActivity());
            this.oLS.setId(a.f.ala_liveroom_dating_nav);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
            layoutParams.topMargin = this.Yh + e.d(26.0f, getContext());
            layoutParams.width = BdUtilHelper.getScreenSize(this.mTbPageContext.getPageActivity()).widthPixels - e.d(eeM() ? 100.0f : 110.0f, getContext());
            this.oKo.addView(this.oLS, layoutParams);
            this.oLS.f(abVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(ab abVar) {
        this.oLS.k(abVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efq() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yh + e.d(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oKo.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efr() {
        this.oLQ = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(152.0f, getContext()), e.d(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yh + this.oKn) + e.d(31.0f, getContext())) + this.oKn) + this.oKn) - e.d(51.0f, getContext())) - e.d(77.0f, getContext())) - e.d(7.0f, getContext());
        this.oLQ.setLayoutParams(layoutParams);
        this.oLQ.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oKo.addView(this.oLQ);
    }

    private boolean efs() {
        String Yp = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Yp();
        return Yp != null && q.edE().Wr(Yp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(ab abVar) {
        if (this.oLJ == null) {
            int d = this.Yh + this.oKn + e.d(114.0f, getContext());
            this.oLJ = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = d;
            this.oLJ.setLayoutParams(layoutParams);
            this.oKo.addView(this.oLJ);
            this.oLJ.setVisibility(8);
            this.oLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.eft();
                }
            });
        }
        this.oLJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eft() {
        this.oLN = new b(this.mTbPageContext.getPageActivity());
        this.oLN.ab(this.bxN);
        this.oLN.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
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
        if (abVar != null && efs() && abVar.aIY != null && abVar.aIY.getActivityStage() == 2 && TextUtils.isEmpty(abVar.aJm)) {
            if (this.oLJ != null) {
                this.oLJ.setVisibility(0);
                return;
            }
            aL(abVar);
            this.oLJ.setVisibility(0);
        } else if (this.oLJ != null) {
            this.oLJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] d(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = eeM() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yh;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oKm;
                iArr[1] = (this.Yh + this.oKn) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yh + this.oKn) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oKm / 2)) - e.d(40.0f, getContext())) - this.oKm;
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oKm / 2);
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oKm / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oKm / 2)) - e.d(40.0f, getContext())) - this.oKm;
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn + this.oKn;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oKm / 2);
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn + this.oKn;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oKm / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn + this.oKn;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKm;
            iArr[1] = this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext());
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
            iArr[0] = eeM() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yh;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - e.d(2.0f, getContext());
            iArr[1] = (this.Yh + this.oKn) - e.d(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oKm) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oKm) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(31.0f, getContext()) + this.oKn;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - e.d(2.0f, getContext());
            iArr[1] = ((((this.Yh + this.oKn) + e.d(31.0f, getContext())) + this.oKn) + this.oKn) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = ((((this.Yh + this.oKn) + e.d(31.0f, getContext())) + this.oKn) + this.oKn) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(31.0f, getContext()) + this.oKn;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yh + this.oKn + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = (this.Yh + this.oKn) - e.d(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKm, this.oKn);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oKo.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oKi);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void WH(String str) {
                if (WheatDatingLayout.this.oLJ != null) {
                    WheatDatingLayout.this.oLJ.setVisibility(0);
                    WheatDatingLayout.this.eft();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oKj.add(wheatItemView);
        } else {
            this.oKk.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oLN != null) {
            this.oLN.dismiss();
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
        if (this.oLJ != null) {
            this.oLJ.setVisibility(8);
        }
        if (this.oKk != null) {
            for (int i = 0; i < this.oKk.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oKk.get(i);
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
        if (this.oKk != null) {
            for (int i = 0; i < this.oKk.size(); i++) {
                WheatItemView wheatItemView = (WheatItemView) this.oKk.get(i);
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
                return ((this.Yh + this.oKn) - e.d(20.0f, getContext())) + this.oKn + this.oKn + this.oKn;
            }
            return this.Yh + this.oKn + e.d(30.0f, getContext()) + this.oKn + e.d(10.0f, getContext()) + this.oKn;
        }
        return (((((this.Yh + this.oKn) + e.d(31.0f, getContext())) + this.oKn) + this.oKn) - e.d(51.0f, getContext())) + this.oKn;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

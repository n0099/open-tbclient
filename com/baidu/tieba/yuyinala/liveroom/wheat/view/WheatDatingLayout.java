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
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class WheatDatingLayout extends BaseWheatLayout {
    private static long oGo = 3399;
    private x bzc;
    private ChooseLoverView oGl;
    private f oGm;
    private HashMap<String, CharmValueView> oGn;
    private b oGp;
    private List<String[]> oGq;
    private boolean oGr;
    private ImageView oGs;
    private a oGt;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oGn = new HashMap<>();
        this.oGq = new ArrayList();
        this.oGr = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oGn = new HashMap<>();
        this.oGq = new ArrayList();
        this.oGr = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oGn = new HashMap<>();
        this.oGq = new ArrayList();
        this.oGr = false;
    }

    private void egM() {
        ListUtils.clear(this.oGq);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final x xVar) {
        super.a(list, list2, list3, xVar);
        aH(xVar);
        this.bzc = xVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean aG = WheatDatingLayout.this.aG(xVar);
                    WheatDatingLayout.this.oEb = list;
                    WheatDatingLayout.this.oEc = aG ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oFd) == 0 || ListUtils.getCount(WheatDatingLayout.this.oFd) != ListUtils.getCount(WheatDatingLayout.this.oEb) || ListUtils.getCount(WheatDatingLayout.this.oFe) == 0 || ListUtils.getCount(WheatDatingLayout.this.oFe) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.egp();
                        WheatDatingLayout.this.oFi.removeAllViews();
                        WheatDatingLayout.this.oFd.clear();
                        WheatDatingLayout.this.oFe.clear();
                        WheatDatingLayout.this.oGn.clear();
                        WheatDatingLayout.this.egR();
                        WheatDatingLayout.this.egS();
                        WheatDatingLayout.this.aI(xVar);
                        if ((xVar.aLq.getRoomMode() != 1 || xVar.aLq.getActivityStage() != 2) && WheatDatingLayout.this.oGp != null) {
                            WheatDatingLayout.this.oGp.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oEb)) {
                            for (int i = 0; i < WheatDatingLayout.this.oEb.size(); i++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.c(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oEc)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oEc); i2++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.c(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aG) {
                            WheatDatingLayout.this.aF(xVar);
                        }
                        WheatDatingLayout.this.oFi.invalidate();
                        WheatDatingLayout.this.oFi.requestLayout();
                    }
                    if (aG) {
                        if (WheatDatingLayout.this.oGs != null) {
                            WheatDatingLayout.this.oGs.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oGn)) {
                            WheatDatingLayout.this.aE(xVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oFe)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oFe); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.c(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aF(xVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oGs != null) {
                            WheatDatingLayout.this.oGs.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.egS();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oFe)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oFe); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.egN();
                    }
                    WheatDatingLayout.this.aJ(xVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oFd)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oFd.size(); i5++) {
                            WheatDatingLayout.this.oFd.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, xVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oFe)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oFe.size(); i6++) {
                            WheatDatingLayout.this.oFe.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, xVar);
                        }
                    }
                    WheatDatingLayout.this.b(list, list2, xVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(x xVar) {
        int[] iArr;
        CharmValueView charmValueView;
        if (xVar != null && xVar.aLq != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = xVar.aLq.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(xVar.aLq.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oGn.get(o(iArr))) != null) {
                        x aat = c.eep().aat();
                        if (aat != null && aat.aLA > 0) {
                            oGo = aat.aLA;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oGo) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oGo));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egN() {
        if (this.oFi != null || !ListUtils.isEmpty(this.oGn)) {
            for (Map.Entry<String, CharmValueView> entry : this.oGn.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oFi != null) {
                    this.oFi.removeView(value);
                }
            }
            this.oGn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        WheatItemView wheatItemView = this.oFe.get(i);
        if (wheatItemView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) wheatItemView.getLayoutParams();
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1];
            wheatItemView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(x xVar) {
        int[] iArr;
        if (xVar != null && xVar.aLq != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = xVar.aLq.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(xVar.aLq.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dN = dN(i, xVar.aLq.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dN[0]);
                        charmValueView.setY(dN[1]);
                        this.oFi.addView(charmValueView);
                        x aat = c.eep().aat();
                        if (aat != null && aat.aLA > 0) {
                            oGo = aat.aLA;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oGo) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oGo));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oGn.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.egO();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bzc.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dN(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.c(25.0f, getContext());
            iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + ((this.oFh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + ((this.oFh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oFg) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + ((this.oFh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext()) + ((this.oFh / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oFg) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext()) + ((this.oFh / 2) - (e.c(45.0f, getContext()) / 2));
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
        if (WO(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, WO(str2) ? null : str2}));
    }

    private boolean WO(String str) {
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
        x xVar = this.bzc;
        if (xVar == null) {
            xVar = o.efg().aat();
        }
        if (xVar == null || xVar.aLq == null) {
            return 0;
        }
        return xVar.aLq.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aG(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        boolean z = true;
        if (xVar == null) {
            xVar = o.efg().aat();
        }
        if (xVar == null || (alaWheatInfoDataWrapper = xVar.aLq) == null) {
            return false;
        }
        if (alaWheatInfoDataWrapper.getRoomMode() != 1 || alaWheatInfoDataWrapper.getActivityStage() != 4) {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, x xVar) {
        boolean z;
        int[] iArr;
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(list, 0);
        if (alaWheatInfoData != null && !TextUtils.isEmpty(alaWheatInfoData.uk)) {
            z = TextUtils.equals(alaWheatInfoData.uk, o.efg().aas());
        } else {
            z = false;
        }
        if (z) {
            if (xVar == null || (xVar.aLq != null && xVar.aLq.getActivityStage() != 2 && xVar.aLq.getActivityStage() != 3)) {
                if (this.oGm != null) {
                    this.oGm.eeS();
                    this.oGm.eeU();
                    return;
                }
                return;
            }
        } else if (xVar == null || (xVar.aLq != null && xVar.aLq.getActivityStage() != 3)) {
            if (this.oGm != null) {
                this.oGm.eeS();
                this.oGm.eeU();
                return;
            }
            return;
        } else if (this.oGm != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oFe.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oGm.Wr(this.oGm.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oGm != null && !ListUtils.isEmpty(this.oGm.eeT())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oGm.eeT().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oGm.Wr(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oFe)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oFe.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (iArr != null && iArr[0] >= 0 && iArr[1] >= 0 && list2.size() >= iArr[0] && list2.size() >= iArr[1] && list2.get(iArr[0] - 1) != null && list2.get(iArr[1] - 1) != null) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oFg / 2), an(iArr[0] - 1, false)[1] + e.c(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oFg / 2), an(iArr[1] - 1, false)[1] + e.c(45.0f, getContext())};
                            if (this.oGm == null) {
                                this.oGm = new f();
                                this.oGt = new a();
                                this.oGm.a(this.oGt);
                            }
                            if (this.oGt != null) {
                                this.oGt.a(xVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oGm.a(iArr, this.oFi, dArr, dArr2, this.oFi.indexOfChild(this.oGs));
                            if (z && !xVar.aLq.isEnterLiveData && xVar.aLq.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oGm.Ws(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, xVar.aLl.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oGm.bh(o, true);
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
    /* loaded from: classes11.dex */
    public class a implements f.a {
        private x alaLiveShowData;
        private AlaWheatInfoData ccf;
        private boolean oGx;
        private List<AlaWheatInfoData> oGy;
        private int[] together;

        public a() {
        }

        public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = xVar;
            this.ccf = alaWheatInfoData;
            this.together = iArr;
            this.oGx = z;
            this.oGy = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
        public void Wt(String str) {
            if (this.alaLiveShowData.aLq.isEnterLiveData && this.ccf.publish == 1 && this.ccf.other_publish == 1) {
                WheatDatingLayout.this.oGm.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aLq.isEnterLiveData) {
                WheatDatingLayout.this.oGm.p(this.together);
            }
            if (!this.alaLiveShowData.aLq.isEnterLiveData && !this.oGx) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oGy, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oGy, this.together[1] - 1));
                if (this.alaLiveShowData.aLq.getActivityStage() == 3) {
                    WheatItemView wheatItemView = WheatDatingLayout.this.oFe.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = WheatDatingLayout.this.oFe.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.egW();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.egW();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egP() {
        if (ListUtils.isEmpty(this.oGq)) {
            this.oGr = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oGq, 0);
        if (strArr == null || strArr.length < 2) {
            egP();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            egP();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            egP();
        } else if (egQ()) {
            this.oGr = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void efR() {
                    super.efR();
                    WheatDatingLayout.this.egP();
                }
            });
        } else {
            egP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oGq.add(new String[]{str, str2});
            if (!this.oGr) {
                egP();
            }
        }
    }

    private void aH(x xVar) {
        if (xVar == null || xVar.aLq == null || !xVar.aLq.isResultsStage()) {
            egM();
        }
    }

    private boolean egQ() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null || com.baidu.live.af.a.SE().bwi.aPq.aSS == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efK().a(com.baidu.live.af.a.SE().bwi.aPq.aSS.Fl(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egR() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yn + e.c(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oFi.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egS() {
        this.oGs = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(152.0f, getContext()), e.c(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yn + this.oFh) + e.c(31.0f, getContext())) + this.oFh) + this.oFh) - e.c(51.0f, getContext())) - e.c(77.0f, getContext())) - e.c(7.0f, getContext());
        this.oGs.setLayoutParams(layoutParams);
        this.oGs.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oFi.addView(this.oGs);
    }

    private boolean egT() {
        String aas = g.aas();
        return aas != null && o.efg().Wz(aas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(x xVar) {
        if (this.oGl == null) {
            int c = this.Yn + this.oFh + e.c(114.0f, getContext());
            this.oGl = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = c;
            this.oGl.setLayoutParams(layoutParams);
            this.oFi.addView(this.oGl);
            this.oGl.setVisibility(8);
            this.oGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.egU();
                }
            });
        }
        this.oGl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egU() {
        this.oGp = new b(this.mTbPageContext.getPageActivity());
        this.oGp.ac(this.bzc);
        this.oGp.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void e(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void f(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, g.aas());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.m(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(x xVar) {
        if (xVar != null && egT() && xVar.aLq != null && xVar.aLq.getActivityStage() == 2 && TextUtils.isEmpty(xVar.aLB)) {
            if (this.oGl != null) {
                this.oGl.setVisibility(0);
                return;
            }
            aI(xVar);
            this.oGl.setVisibility(0);
        } else if (this.oGl != null) {
            this.oGl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] c(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = egq() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yn;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oFg;
                iArr[1] = (this.Yn + this.oFh) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yn + this.oFh) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oFg / 2)) - e.c(40.0f, getContext())) - this.oFg;
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oFg / 2);
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oFg / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oFg / 2)) - e.c(40.0f, getContext())) - this.oFg;
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh + this.oFh;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oFg / 2);
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh + this.oFh;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oFg / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh + this.oFh;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFg;
            iArr[1] = this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext());
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
            iArr[0] = egq() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yn;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - e.c(2.0f, getContext());
            iArr[1] = (this.Yn + this.oFh) - e.c(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oFg) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oFg) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(31.0f, getContext()) + this.oFh;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - e.c(2.0f, getContext());
            iArr[1] = ((((this.Yn + this.oFh) + e.c(31.0f, getContext())) + this.oFh) + this.oFh) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = ((((this.Yn + this.oFh) + e.c(31.0f, getContext())) + this.oFh) + this.oFh) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(31.0f, getContext()) + this.oFh;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yn + this.oFh + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = (this.Yn + this.oFh) - e.c(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oFg, this.oFh);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oFi.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oFc);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void WP(String str) {
                if (WheatDatingLayout.this.oGl != null) {
                    WheatDatingLayout.this.oGl.setVisibility(0);
                    WheatDatingLayout.this.egU();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oFd.add(wheatItemView);
        } else {
            this.oFe.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oGp != null) {
            this.oGp.dismiss();
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
        if (this.oGl != null) {
            this.oGl.setVisibility(8);
        }
        if (this.oFe != null) {
            for (int i = 0; i < this.oFe.size(); i++) {
                WheatItemView wheatItemView = this.oFe.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.c(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.bzc != null) {
                        this.bzc.aLB = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        if (this.oFe != null) {
            for (int i = 0; i < this.oFe.size(); i++) {
                WheatItemView wheatItemView = this.oFe.get(i);
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
        if (aG(this.bzc)) {
            if (getMatches() == 1) {
                return ((this.Yn + this.oFh) - e.c(20.0f, getContext())) + this.oFh + this.oFh + this.oFh;
            }
            return this.Yn + this.oFh + e.c(30.0f, getContext()) + this.oFh + e.c(10.0f, getContext()) + this.oFh;
        }
        return (((((this.Yn + this.oFh) + e.c(31.0f, getContext())) + this.oFh) + this.oFh) - e.c(51.0f, getContext())) + this.oFh;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

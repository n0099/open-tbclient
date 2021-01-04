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
    private static long oGp = 3399;
    private x bzc;
    private ChooseLoverView oGm;
    private f oGn;
    private HashMap<String, CharmValueView> oGo;
    private b oGq;
    private List<String[]> oGr;
    private boolean oGs;
    private ImageView oGt;
    private a oGu;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oGo = new HashMap<>();
        this.oGr = new ArrayList();
        this.oGs = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oGo = new HashMap<>();
        this.oGr = new ArrayList();
        this.oGs = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oGo = new HashMap<>();
        this.oGr = new ArrayList();
        this.oGs = false;
    }

    private void egL() {
        ListUtils.clear(this.oGr);
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
                    WheatDatingLayout.this.oEc = list;
                    WheatDatingLayout.this.oEd = aG ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oFe) == 0 || ListUtils.getCount(WheatDatingLayout.this.oFe) != ListUtils.getCount(WheatDatingLayout.this.oEc) || ListUtils.getCount(WheatDatingLayout.this.oFf) == 0 || ListUtils.getCount(WheatDatingLayout.this.oFf) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.ego();
                        WheatDatingLayout.this.oFj.removeAllViews();
                        WheatDatingLayout.this.oFe.clear();
                        WheatDatingLayout.this.oFf.clear();
                        WheatDatingLayout.this.oGo.clear();
                        WheatDatingLayout.this.egQ();
                        WheatDatingLayout.this.egR();
                        WheatDatingLayout.this.aI(xVar);
                        if ((xVar.aLq.getRoomMode() != 1 || xVar.aLq.getActivityStage() != 2) && WheatDatingLayout.this.oGq != null) {
                            WheatDatingLayout.this.oGq.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oEc)) {
                            for (int i = 0; i < WheatDatingLayout.this.oEc.size(); i++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.c(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oEd)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.oEd); i2++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.c(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aG) {
                            WheatDatingLayout.this.aF(xVar);
                        }
                        WheatDatingLayout.this.oFj.invalidate();
                        WheatDatingLayout.this.oFj.requestLayout();
                    }
                    if (aG) {
                        if (WheatDatingLayout.this.oGt != null) {
                            WheatDatingLayout.this.oGt.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oGo)) {
                            WheatDatingLayout.this.aE(xVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oFf)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oFf); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.c(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aF(xVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oGt != null) {
                            WheatDatingLayout.this.oGt.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.egR();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oFf)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oFf); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.egM();
                    }
                    WheatDatingLayout.this.aJ(xVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oFe)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oFe.size(); i5++) {
                            WheatDatingLayout.this.oFe.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, xVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oFf)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oFf.size(); i6++) {
                            WheatDatingLayout.this.oFf.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, xVar);
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
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oGo.get(o(iArr))) != null) {
                        x aas = c.eeo().aas();
                        if (aas != null && aas.aLA > 0) {
                            oGp = aas.aLA;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oGp) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oGp));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egM() {
        if (this.oFj != null || !ListUtils.isEmpty(this.oGo)) {
            for (Map.Entry<String, CharmValueView> entry : this.oGo.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oFj != null) {
                    this.oFj.removeView(value);
                }
            }
            this.oGo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        WheatItemView wheatItemView = this.oFf.get(i);
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
                        this.oFj.addView(charmValueView);
                        x aas = c.eeo().aas();
                        if (aas != null && aas.aLA > 0) {
                            oGp = aas.aLA;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oGp) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oGp));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oGo.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.egN();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egN() {
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
            iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + ((this.oFi / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + ((this.oFi / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oFh) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + ((this.oFi / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext()) + ((this.oFi / 2) - (e.c(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oFh) - e.c(25.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext()) + ((this.oFi / 2) - (e.c(45.0f, getContext()) / 2));
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
        if (WP(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, WP(str2) ? null : str2}));
    }

    private boolean WP(String str) {
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
            xVar = o.eff().aas();
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
            xVar = o.eff().aas();
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
            z = TextUtils.equals(alaWheatInfoData.uk, o.eff().aar());
        } else {
            z = false;
        }
        if (z) {
            if (xVar == null || (xVar.aLq != null && xVar.aLq.getActivityStage() != 2 && xVar.aLq.getActivityStage() != 3)) {
                if (this.oGn != null) {
                    this.oGn.eeR();
                    this.oGn.eeT();
                    return;
                }
                return;
            }
        } else if (xVar == null || (xVar.aLq != null && xVar.aLq.getActivityStage() != 3)) {
            if (this.oGn != null) {
                this.oGn.eeR();
                this.oGn.eeT();
                return;
            }
            return;
        } else if (this.oGn != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oFf.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oGn.Ws(this.oGn.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oGn != null && !ListUtils.isEmpty(this.oGn.eeS())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oGn.eeS().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oGn.Ws(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oFf)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oFf.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (iArr != null && iArr[0] >= 0 && iArr[1] >= 0 && list2.size() >= iArr[0] && list2.size() >= iArr[1] && list2.get(iArr[0] - 1) != null && list2.get(iArr[1] - 1) != null) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oFh / 2), an(iArr[0] - 1, false)[1] + e.c(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oFh / 2), an(iArr[1] - 1, false)[1] + e.c(45.0f, getContext())};
                            if (this.oGn == null) {
                                this.oGn = new f();
                                this.oGu = new a();
                                this.oGn.a(this.oGu);
                            }
                            if (this.oGu != null) {
                                this.oGu.a(xVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oGn.a(iArr, this.oFj, dArr, dArr2, this.oFj.indexOfChild(this.oGt));
                            if (z && !xVar.aLq.isEnterLiveData && xVar.aLq.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oGn.Wt(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, xVar.aLl.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oGn.bh(o, true);
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
        private boolean oGy;
        private List<AlaWheatInfoData> oGz;
        private int[] together;

        public a() {
        }

        public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = xVar;
            this.ccf = alaWheatInfoData;
            this.together = iArr;
            this.oGy = z;
            this.oGz = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
        public void Wu(String str) {
            if (this.alaLiveShowData.aLq.isEnterLiveData && this.ccf.publish == 1 && this.ccf.other_publish == 1) {
                WheatDatingLayout.this.oGn.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aLq.isEnterLiveData) {
                WheatDatingLayout.this.oGn.p(this.together);
            }
            if (!this.alaLiveShowData.aLq.isEnterLiveData && !this.oGy) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oGz, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oGz, this.together[1] - 1));
                if (this.alaLiveShowData.aLq.getActivityStage() == 3) {
                    WheatItemView wheatItemView = WheatDatingLayout.this.oFf.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = WheatDatingLayout.this.oFf.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.egV();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.egV();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egO() {
        if (ListUtils.isEmpty(this.oGr)) {
            this.oGs = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oGr, 0);
        if (strArr == null || strArr.length < 2) {
            egO();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            egO();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            egO();
        } else if (egP()) {
            this.oGs = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void efQ() {
                    super.efQ();
                    WheatDatingLayout.this.egO();
                }
            });
        } else {
            egO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oGr.add(new String[]{str, str2});
            if (!this.oGs) {
                egO();
            }
        }
    }

    private void aH(x xVar) {
        if (xVar == null || xVar.aLq == null || !xVar.aLq.isResultsStage()) {
            egL();
        }
    }

    private boolean egP() {
        if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPq == null || com.baidu.live.af.a.SE().bwi.aPq.aSS == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().a(com.baidu.live.af.a.SE().bwi.aPq.aSS.Fl(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egQ() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yn + e.c(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oFj.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egR() {
        this.oGt = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.c(152.0f, getContext()), e.c(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yn + this.oFi) + e.c(31.0f, getContext())) + this.oFi) + this.oFi) - e.c(51.0f, getContext())) - e.c(77.0f, getContext())) - e.c(7.0f, getContext());
        this.oGt.setLayoutParams(layoutParams);
        this.oGt.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oFj.addView(this.oGt);
    }

    private boolean egS() {
        String aar = g.aar();
        return aar != null && o.eff().WA(aar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(x xVar) {
        if (this.oGm == null) {
            int c = this.Yn + this.oFi + e.c(114.0f, getContext());
            this.oGm = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = c;
            this.oGm.setLayoutParams(layoutParams);
            this.oFj.addView(this.oGm);
            this.oGm.setVisibility(8);
            this.oGm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.egT();
                }
            });
        }
        this.oGm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egT() {
        this.oGq = new b(this.mTbPageContext.getPageActivity());
        this.oGq.ac(this.bzc);
        this.oGq.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void e(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void f(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, g.aar());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.m(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(x xVar) {
        if (xVar != null && egS() && xVar.aLq != null && xVar.aLq.getActivityStage() == 2 && TextUtils.isEmpty(xVar.aLB)) {
            if (this.oGm != null) {
                this.oGm.setVisibility(0);
                return;
            }
            aI(xVar);
            this.oGm.setVisibility(0);
        } else if (this.oGm != null) {
            this.oGm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] c(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = egp() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yn;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oFh;
                iArr[1] = (this.Yn + this.oFi) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yn + this.oFi) - e.c(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oFh / 2)) - e.c(40.0f, getContext())) - this.oFh;
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oFh / 2);
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oFh / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oFh / 2)) - e.c(40.0f, getContext())) - this.oFh;
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi + this.oFi;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oFh / 2);
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi + this.oFi;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oFh / 2) + e.c(40.0f, getContext());
                iArr[1] = ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi + this.oFi;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFh;
            iArr[1] = this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext());
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
            iArr[0] = egp() ? 0 : e.c(10.0f, getContext());
            iArr[1] = this.Yn;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - e.c(2.0f, getContext());
            iArr[1] = (this.Yn + this.oFi) - e.c(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oFh) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oFh) - e.c(83.0f, getContext())) - e.c(2.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(31.0f, getContext()) + this.oFi;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - e.c(2.0f, getContext());
            iArr[1] = ((((this.Yn + this.oFi) + e.c(31.0f, getContext())) + this.oFi) + this.oFi) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = ((((this.Yn + this.oFi) + e.c(31.0f, getContext())) + this.oFi) + this.oFi) - e.c(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(31.0f, getContext()) + this.oFi;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(83.0f, getContext());
            iArr[1] = this.Yn + this.oFi + e.c(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.c(2.0f, getContext());
            iArr[1] = (this.Yn + this.oFi) - e.c(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oFh, this.oFi);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oFj.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oFd);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void WQ(String str) {
                if (WheatDatingLayout.this.oGm != null) {
                    WheatDatingLayout.this.oGm.setVisibility(0);
                    WheatDatingLayout.this.egT();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oFe.add(wheatItemView);
        } else {
            this.oFf.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oGq != null) {
            this.oGq.dismiss();
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
        if (this.oGm != null) {
            this.oGm.setVisibility(8);
        }
        if (this.oFf != null) {
            for (int i = 0; i < this.oFf.size(); i++) {
                WheatItemView wheatItemView = this.oFf.get(i);
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
        if (this.oFf != null) {
            for (int i = 0; i < this.oFf.size(); i++) {
                WheatItemView wheatItemView = this.oFf.get(i);
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
                return ((this.Yn + this.oFi) - e.c(20.0f, getContext())) + this.oFi + this.oFi + this.oFi;
            }
            return this.Yn + this.oFi + e.c(30.0f, getContext()) + this.oFi + e.c(10.0f, getContext()) + this.oFi;
        }
        return (((((this.Yn + this.oFi) + e.c(31.0f, getContext())) + this.oFi) + this.oFi) - e.c(51.0f, getContext())) + this.oFi;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

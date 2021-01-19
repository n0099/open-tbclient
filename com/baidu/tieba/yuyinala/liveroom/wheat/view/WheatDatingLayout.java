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
/* loaded from: classes10.dex */
public class WheatDatingLayout extends BaseWheatLayout {
    private static long oBK = 3399;
    private x buq;
    private ChooseLoverView oBH;
    private f oBI;
    private HashMap<String, CharmValueView> oBJ;
    private b oBL;
    private List<String[]> oBM;
    private boolean oBN;
    private ImageView oBO;
    private a oBP;

    public WheatDatingLayout(@NonNull Context context) {
        super(context, null);
        this.oBJ = new HashMap<>();
        this.oBM = new ArrayList();
        this.oBN = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.oBJ = new HashMap<>();
        this.oBM = new ArrayList();
        this.oBN = false;
    }

    public WheatDatingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oBJ = new HashMap<>();
        this.oBM = new ArrayList();
        this.oBN = false;
    }

    private void ecU() {
        ListUtils.clear(this.oBM);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final List<AlaWheatInfoData> list3, final x xVar) {
        super.a(list, list2, list3, xVar);
        aH(xVar);
        this.buq = xVar;
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean aG = WheatDatingLayout.this.aG(xVar);
                    WheatDatingLayout.this.ozx = list;
                    WheatDatingLayout.this.ozy = aG ? list3 : list2;
                    if (ListUtils.getCount(WheatDatingLayout.this.oAz) == 0 || ListUtils.getCount(WheatDatingLayout.this.oAz) != ListUtils.getCount(WheatDatingLayout.this.ozx) || ListUtils.getCount(WheatDatingLayout.this.oAA) == 0 || ListUtils.getCount(WheatDatingLayout.this.oAA) != ListUtils.getCount(list2)) {
                        WheatDatingLayout.this.ecx();
                        WheatDatingLayout.this.oAE.removeAllViews();
                        WheatDatingLayout.this.oAz.clear();
                        WheatDatingLayout.this.oAA.clear();
                        WheatDatingLayout.this.oBJ.clear();
                        WheatDatingLayout.this.ecZ();
                        WheatDatingLayout.this.eda();
                        WheatDatingLayout.this.aI(xVar);
                        if ((xVar.aGD.getRoomMode() != 1 || xVar.aGD.getActivityStage() != 2) && WheatDatingLayout.this.oBL != null) {
                            WheatDatingLayout.this.oBL.dismiss();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.ozx)) {
                            for (int i = 0; i < WheatDatingLayout.this.ozx.size(); i++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.d(0, true, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.ozy)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(WheatDatingLayout.this.ozy); i2++) {
                                WheatDatingLayout.this.a(aG ? WheatDatingLayout.this.d(i2, false, WheatDatingLayout.this.getMatches()) : WheatDatingLayout.this.an(i2, false), false);
                            }
                        }
                        if (aG) {
                            WheatDatingLayout.this.aF(xVar);
                        }
                        WheatDatingLayout.this.oAE.invalidate();
                        WheatDatingLayout.this.oAE.requestLayout();
                    }
                    if (aG) {
                        if (WheatDatingLayout.this.oBO != null) {
                            WheatDatingLayout.this.oBO.setVisibility(8);
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oBJ)) {
                            WheatDatingLayout.this.aE(xVar);
                        } else {
                            if (!ListUtils.isEmpty(WheatDatingLayout.this.oAA)) {
                                for (int i3 = 0; i3 < ListUtils.getCount(WheatDatingLayout.this.oAA); i3++) {
                                    WheatDatingLayout.this.b(WheatDatingLayout.this.d(i3, false, WheatDatingLayout.this.getMatches()), i3);
                                }
                            }
                            WheatDatingLayout.this.aF(xVar);
                        }
                    } else {
                        if (WheatDatingLayout.this.oBO != null) {
                            WheatDatingLayout.this.oBO.setVisibility(0);
                        } else {
                            WheatDatingLayout.this.eda();
                        }
                        if (!ListUtils.isEmpty(WheatDatingLayout.this.oAA)) {
                            for (int i4 = 0; i4 < ListUtils.getCount(WheatDatingLayout.this.oAA); i4++) {
                                WheatDatingLayout.this.b(WheatDatingLayout.this.an(i4, false), i4);
                            }
                        }
                        WheatDatingLayout.this.ecV();
                    }
                    WheatDatingLayout.this.aJ(xVar);
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oAz)) {
                        for (int i5 = 0; i5 < WheatDatingLayout.this.oAz.size(); i5++) {
                            WheatDatingLayout.this.oAz.get(i5).setData(WheatDatingLayout.this.am(i5, true), i5, true, xVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatDatingLayout.this.oAA)) {
                        for (int i6 = 0; i6 < WheatDatingLayout.this.oAA.size(); i6++) {
                            WheatDatingLayout.this.oAA.get(i6).setData(WheatDatingLayout.this.am(i6, false), i6, false, xVar);
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
        if (xVar != null && xVar.aGD != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = xVar.aGD.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(xVar.aGD.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0 && (charmValueView = this.oBJ.get(o(iArr))) != null) {
                        x WA = c.eax().WA();
                        if (WA != null && WA.aGN > 0) {
                            oBK = WA.aGN;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oBK) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oBK));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecV() {
        if (this.oAE != null || !ListUtils.isEmpty(this.oBJ)) {
            for (Map.Entry<String, CharmValueView> entry : this.oBJ.entrySet()) {
                CharmValueView value = entry.getValue();
                if (this.oAE != null) {
                    this.oAE.removeView(value);
                }
            }
            this.oBJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int[] iArr, int i) {
        WheatItemView wheatItemView = this.oAA.get(i);
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
        if (xVar != null && xVar.aGD != null) {
            List<AlaWheatInfoData> anchorWheatBackupLists = xVar.aGD.getAnchorWheatBackupLists();
            for (int i = 0; i < ListUtils.getCount(xVar.aGD.getXiangqinLists()); i++) {
                if (i % 2 == 0) {
                    final AlaWheatInfoData alaWheatInfoData = anchorWheatBackupLists.get(i);
                    final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(anchorWheatBackupLists, i + 1);
                    if (alaWheatInfoData != null && alaWheatInfoData.publish == 1 && alaWheatInfoData.other_publish == 1 && (iArr = alaWheatInfoData.together) != null && iArr[0] >= 0 && iArr[1] >= 0) {
                        int[] dN = dN(i, xVar.aGD.getXqCount());
                        CharmValueView charmValueView = new CharmValueView(getContext());
                        charmValueView.setX(dN[0]);
                        charmValueView.setY(dN[1]);
                        this.oAE.addView(charmValueView);
                        x WA = c.eax().WA();
                        if (WA != null && WA.aGN > 0) {
                            oBK = WA.aGN;
                        }
                        if (alaWheatInfoData.sum_charm_count >= oBK) {
                            charmValueView.setProgress(100);
                        } else {
                            charmValueView.setProgress((int) ((alaWheatInfoData.sum_charm_count * 100) / oBK));
                        }
                        charmValueView.setCharmValue(alaWheatInfoData.sum_charm_count);
                        this.oBJ.put(o(iArr), charmValueView);
                        charmValueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                WheatDatingLayout.this.a(alaWheatInfoData, alaWheatInfoData2);
                                WheatDatingLayout.this.ecW();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.buq.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "heartbar_clk").setContentExt(jSONObject));
    }

    private int[] dN(int i, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (i2 == 2) {
            iArr[0] = (screenFullSize[0] / 2) - e.d(25.0f, getContext());
            iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + ((this.oAD / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - e.d(25.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + ((this.oAD / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 2) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oAC) - e.d(25.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + ((this.oAD / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - e.d(25.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext()) + ((this.oAD / 2) - (e.d(45.0f, getContext()) / 2));
        } else if (i == 6) {
            iArr[0] = ((screenFullSize[0] / 2) + this.oAC) - e.d(25.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext()) + ((this.oAD / 2) - (e.d(45.0f, getContext()) / 2));
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
        if (VH(str)) {
            str = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501011, new String[]{str, VH(str2) ? null : str2}));
    }

    private boolean VH(String str) {
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
        x xVar = this.buq;
        if (xVar == null) {
            xVar = o.ebo().WA();
        }
        if (xVar == null || xVar.aGD == null) {
            return 0;
        }
        return xVar.aGD.getXqCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aG(x xVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        boolean z = true;
        if (xVar == null) {
            xVar = o.ebo().WA();
        }
        if (xVar == null || (alaWheatInfoDataWrapper = xVar.aGD) == null) {
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
            z = TextUtils.equals(alaWheatInfoData.uk, o.ebo().Wz());
        } else {
            z = false;
        }
        if (z) {
            if (xVar == null || (xVar.aGD != null && xVar.aGD.getActivityStage() != 2 && xVar.aGD.getActivityStage() != 3)) {
                if (this.oBI != null) {
                    this.oBI.eba();
                    this.oBI.ebc();
                    return;
                }
                return;
            }
        } else if (xVar == null || (xVar.aGD != null && xVar.aGD.getActivityStage() != 3)) {
            if (this.oBI != null) {
                this.oBI.eba();
                this.oBI.ebc();
                return;
            }
            return;
        } else if (this.oBI != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oAA.size()) {
                    break;
                }
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null && (alaWheatInfoData2.publish != 1 || alaWheatInfoData2.other_publish != 1)) {
                    this.oBI.Vk(this.oBI.o(alaWheatInfoData2.pre_together));
                }
                i = i2 + 1;
            }
        }
        if (this.oBI != null && !ListUtils.isEmpty(this.oBI.ebb())) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oBI.ebb().entrySet()) {
                String key = entry.getKey();
                if (key != null && key.length() == 2) {
                    int parseInt = Integer.parseInt(key.substring(0, 1)) - 1;
                    int parseInt2 = Integer.parseInt(key.substring(1, 2)) - 1;
                    if (parseInt >= 0 && parseInt2 >= 0 && parseInt < list2.size() && parseInt2 < list2.size() && (list2.get(parseInt) == null || list2.get(parseInt2) == null)) {
                        this.oBI.Vk(key);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(list2) && !ListUtils.isEmpty(this.oAA)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.oAA.size()) {
                    AlaWheatInfoData alaWheatInfoData3 = list2.get(i4);
                    if (alaWheatInfoData3 != null) {
                        if (z) {
                            iArr = alaWheatInfoData3.pre_together;
                        } else {
                            iArr = alaWheatInfoData3.together;
                        }
                        if (iArr != null && iArr[0] >= 0 && iArr[1] >= 0 && list2.size() >= iArr[0] && list2.size() >= iArr[1] && list2.get(iArr[0] - 1) != null && list2.get(iArr[1] - 1) != null) {
                            double[] dArr = {an(iArr[0] - 1, false)[0] + (this.oAC / 2), an(iArr[0] - 1, false)[1] + e.d(45.0f, getContext())};
                            double[] dArr2 = {an(iArr[1] - 1, false)[0] + (this.oAC / 2), an(iArr[1] - 1, false)[1] + e.d(45.0f, getContext())};
                            if (this.oBI == null) {
                                this.oBI = new f();
                                this.oBP = new a();
                                this.oBI.a(this.oBP);
                            }
                            if (this.oBP != null) {
                                this.oBP.a(xVar, alaWheatInfoData3, iArr, z, list2);
                            }
                            this.oBI.a(iArr, this.oAE, dArr, dArr2, this.oAE.indexOfChild(this.oBO));
                            if (z && !xVar.aGD.isEnterLiveData && xVar.aGD.isResultsStage() && alaWheatInfoData3.publish == 1 && alaWheatInfoData3.other_publish == 1) {
                                String o = o(alaWheatInfoData3.pre_together);
                                if (!this.oBI.Vl(o)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, xVar.aGy.croom_id);
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                    }
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "marry_suc").setContentExt(jSONObject));
                                    this.oBI.bh(o, true);
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
    /* loaded from: classes10.dex */
    public class a implements f.a {
        private x alaLiveShowData;
        private AlaWheatInfoData bXs;
        private boolean oBT;
        private List<AlaWheatInfoData> oBU;
        private int[] together;

        public a() {
        }

        public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int[] iArr, boolean z, List<AlaWheatInfoData> list) {
            this.alaLiveShowData = xVar;
            this.bXs = alaWheatInfoData;
            this.together = iArr;
            this.oBT = z;
            this.oBU = list;
        }

        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
        public void Vm(String str) {
            if (this.alaLiveShowData.aGD.isEnterLiveData && this.bXs.publish == 1 && this.bXs.other_publish == 1) {
                WheatDatingLayout.this.oBI.bh(WheatDatingLayout.this.o(this.together), true);
            }
            if (!this.alaLiveShowData.aGD.isEnterLiveData) {
                WheatDatingLayout.this.oBI.p(this.together);
            }
            if (!this.alaLiveShowData.aGD.isEnterLiveData && !this.oBT) {
                WheatDatingLayout.this.b((AlaWheatInfoData) ListUtils.getItem(this.oBU, this.together[0] - 1), (AlaWheatInfoData) ListUtils.getItem(this.oBU, this.together[1] - 1));
                if (this.alaLiveShowData.aGD.getActivityStage() == 3) {
                    WheatItemView wheatItemView = WheatDatingLayout.this.oAA.get(this.together[0] - 1);
                    WheatItemView wheatItemView2 = WheatDatingLayout.this.oAA.get(this.together[1] - 1);
                    if (wheatItemView != null) {
                        wheatItemView.ede();
                    }
                    if (wheatItemView2 != null) {
                        wheatItemView2.ede();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecX() {
        if (ListUtils.isEmpty(this.oBM)) {
            this.oBN = false;
            return;
        }
        String[] strArr = (String[]) ListUtils.remove(this.oBM, 0);
        if (strArr == null || strArr.length < 2) {
            ecX();
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true)) {
            ecX();
            return;
        }
        View view = null;
        if (this.mTbPageContext.getPageActivity() != null) {
            view = this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (!(view instanceof ViewGroup)) {
            ecX();
        } else if (ecY()) {
            this.oBN = true;
            com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().a((ViewGroup) view, str, str2, new com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.lottie.c
                public void ebZ() {
                    super.ebZ();
                    WheatDatingLayout.this.ecX();
                }
            });
        } else {
            ecX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaWheatInfoData alaWheatInfoData, AlaWheatInfoData alaWheatInfoData2) {
        String str = alaWheatInfoData == null ? null : alaWheatInfoData.bigPortrait;
        String str2 = alaWheatInfoData2 != null ? alaWheatInfoData2.bigPortrait : null;
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str2, true)) {
            this.oBM.add(new String[]{str, str2});
            if (!this.oBN) {
                ecX();
            }
        }
    }

    private void aH(x xVar) {
        if (xVar == null || xVar.aGD == null || !xVar.aGD.isResultsStage()) {
            ecU();
        }
    }

    private boolean ecY() {
        if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKD == null || com.baidu.live.af.a.OJ().bru.aKD.aOf == null) {
            return false;
        }
        return com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().a(com.baidu.live.af.a.OJ().bru.aKD.aOf.Bq(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecZ() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(441.0f, getContext()), -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yl + e.d(63.0f, getContext());
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(a.e.yuyin_sdk_wheat_dating_bg);
        this.oAE.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eda() {
        this.oBO = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.d(152.0f, getContext()), e.d(74.0f, getContext()));
        layoutParams.addRule(14);
        layoutParams.topMargin = ((((((this.Yl + this.oAD) + e.d(31.0f, getContext())) + this.oAD) + this.oAD) - e.d(51.0f, getContext())) - e.d(77.0f, getContext())) - e.d(7.0f, getContext());
        this.oBO.setLayoutParams(layoutParams);
        this.oBO.setImageResource(a.e.yuyin_sdk_wheat_sweet_confression);
        this.oAE.addView(this.oBO);
    }

    private boolean edb() {
        String Wz = g.Wz();
        return Wz != null && o.ebo().Vs(Wz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(x xVar) {
        if (this.oBH == null) {
            int d = this.Yl + this.oAD + e.d(114.0f, getContext());
            this.oBH = new ChooseLoverView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = d;
            this.oBH.setLayoutParams(layoutParams);
            this.oAE.addView(this.oBH);
            this.oBH.setVisibility(8);
            this.oBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WheatDatingLayout.this.edc();
                }
            });
        }
        this.oBH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edc() {
        this.oBL = new b(this.mTbPageContext.getPageActivity());
        this.oBL.ac(this.buq);
        this.oBL.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void e(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void f(AlaWheatInfoData alaWheatInfoData) {
                WheatDatingLayout.this.a(alaWheatInfoData, g.Wz());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.b.a
            public void onDismiss() {
                WheatDatingLayout.this.m(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(x xVar) {
        if (xVar != null && edb() && xVar.aGD != null && xVar.aGD.getActivityStage() == 2 && TextUtils.isEmpty(xVar.aGO)) {
            if (this.oBH != null) {
                this.oBH.setVisibility(0);
                return;
            }
            aI(xVar);
            this.oBH.setVisibility(0);
        } else if (this.oBH != null) {
            this.oBH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] d(int i, boolean z, int i2) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = ecy() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yl;
            return iArr;
        }
        if (i2 == 2) {
            if (i == 0) {
                iArr[0] = (screenFullSize[0] / 2) - this.oAC;
                iArr[1] = (this.Yl + this.oAD) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 1) {
                iArr[0] = screenFullSize[0] / 2;
                iArr[1] = (this.Yl + this.oAD) - e.d(20.0f, getContext());
                return iArr;
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oAC / 2)) - e.d(40.0f, getContext())) - this.oAC;
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD;
                return iArr;
            } else if (i == 3) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oAC / 2);
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD;
                return iArr;
            } else if (i == 4) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oAC / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD;
                return iArr;
            } else if (i == 5) {
                iArr[0] = (((screenFullSize[0] / 2) - (this.oAC / 2)) - e.d(40.0f, getContext())) - this.oAC;
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD + this.oAD;
                return iArr;
            } else if (i == 6) {
                iArr[0] = (screenFullSize[0] / 2) - (this.oAC / 2);
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD + this.oAD;
                return iArr;
            } else if (i == 7) {
                iArr[0] = (screenFullSize[0] / 2) + (this.oAC / 2) + e.d(40.0f, getContext());
                iArr[1] = ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD + this.oAD;
                return iArr;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oAC;
            iArr[1] = this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext());
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
            iArr[0] = ecy() ? 0 : e.d(10.0f, getContext());
            iArr[1] = this.Yl;
            return iArr;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - e.d(2.0f, getContext());
            iArr[1] = (this.Yl + this.oAD) - e.d(20.0f, getContext());
            return iArr;
        } else if (i == 1) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oAC) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 2) {
            iArr[0] = (((screenFullSize[0] / 2) - this.oAC) - e.d(83.0f, getContext())) - e.d(2.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(31.0f, getContext()) + this.oAD;
            return iArr;
        } else if (i == 3) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oAC) - e.d(2.0f, getContext());
            iArr[1] = ((((this.Yl + this.oAD) + e.d(31.0f, getContext())) + this.oAD) + this.oAD) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 4) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = ((((this.Yl + this.oAD) + e.d(31.0f, getContext())) + this.oAD) + this.oAD) - e.d(51.0f, getContext());
            return iArr;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(31.0f, getContext()) + this.oAD;
            return iArr;
        } else if (i == 6) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(83.0f, getContext());
            iArr[1] = this.Yl + this.oAD + e.d(31.0f, getContext());
            return iArr;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + e.d(2.0f, getContext());
            iArr[1] = (this.Yl + this.oAD) - e.d(20.0f, getContext());
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oAC, this.oAD);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oAE.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oAy);
        wheatItemView.setDialogLister(new WheatItemView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.a
            public void VI(String str) {
                if (WheatDatingLayout.this.oBH != null) {
                    WheatDatingLayout.this.oBH.setVisibility(0);
                    WheatDatingLayout.this.edc();
                    BdUtilHelper.showToast(WheatDatingLayout.this.mTbPageContext.getPageActivity(), str + "嘉宾已下麦，请重新选择");
                }
            }
        });
        if (z) {
            this.oAz.add(wheatItemView);
        } else {
            this.oAA.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.oBL != null) {
            this.oBL.dismiss();
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
        if (this.oBH != null) {
            this.oBH.setVisibility(8);
        }
        if (this.oAA != null) {
            for (int i = 0; i < this.oAA.size(); i++) {
                WheatItemView wheatItemView = this.oAA.get(i);
                wheatItemView.setChooseLoverBgView(false);
                AlaWheatInfoData alaWheatInfoData2 = wheatItemView.getAlaWheatInfoData();
                if (alaWheatInfoData2 != null && alaWheatInfoData2.uk.equals(str)) {
                    wheatItemView.c(alaWheatInfoData2.sex != 2, "选" + alaWheatInfoData.realWheatPosition, false);
                    if (this.buq != null) {
                        this.buq.aGO = alaWheatInfoData.userName;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        if (this.oAA != null) {
            for (int i = 0; i < this.oAA.size(); i++) {
                WheatItemView wheatItemView = this.oAA.get(i);
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
        if (aG(this.buq)) {
            if (getMatches() == 1) {
                return ((this.Yl + this.oAD) - e.d(20.0f, getContext())) + this.oAD + this.oAD + this.oAD;
            }
            return this.Yl + this.oAD + e.d(30.0f, getContext()) + this.oAD + e.d(10.0f, getContext()) + this.oAD;
        }
        return (((((this.Yl + this.oAD) + e.d(31.0f, getContext())) + this.oAD) + this.oAD) - e.d(51.0f, getContext())) + this.oAD;
    }

    public String o(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }
}

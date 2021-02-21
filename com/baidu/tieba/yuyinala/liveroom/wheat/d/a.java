package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.l;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a {
    public boolean aYV;
    protected ab bxN;
    private long cxN;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext oGE;
    private AlaLiveRoomBlurPageLayout oHt;
    private com.baidu.tieba.yuyinala.player.b oHv;
    public List<AlaWheatInfoData> oJF = new ArrayList();
    public List<AlaWheatInfoData> oJG = new ArrayList();
    public List<AlaWheatInfoData> oJH = new ArrayList();
    public List<AlaWheatInfoData> oJI = new ArrayList();
    public List<AlaWheatInfoData> oJJ = new ArrayList();
    public List<AlaWheatInfoData> oJK = new ArrayList();
    public Set<String> oJL = new HashSet();
    private boolean oJM;
    public int oJN;
    private boolean oJO;
    public boolean oJP;
    private l oJQ;
    private boolean oJR;
    public BaseWheatLayout oJS;

    public abstract void Mk();

    public abstract View eeJ();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oGE = tbPageContext;
        this.oHt = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eeK();
    }

    private void initData() {
        this.oJF.clear();
        this.oJG.clear();
        this.oJH.clear();
        this.oJI.clear();
        this.oJJ.clear();
        this.oJK.clear();
        this.oJL.clear();
        this.oJM = false;
        this.oJN = 0;
        this.oJO = false;
        this.oJP = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().az(this.mActivity);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup edO() {
        return this.oJS;
    }

    public void initView() {
        this.oHt.f(eeJ(), k(this.mRect));
    }

    public void eeK() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().az(this.mActivity);
        this.oJS.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.oJN = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? h.oGK : h.oGL);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Yn() {
        return this.oJF;
    }

    public List<AlaWheatInfoData> Ym() {
        return this.oJG;
    }

    public List<AlaWheatInfoData> edP() {
        return this.oJJ;
    }

    public boolean edQ() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || Yk() || !iJ(encryptionUserId)) ? false : true;
    }

    public boolean Yk() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return iI(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iI(String str) {
        return (this.bxN == null || this.bxN.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bxN.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Wf(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (iJ(str)) {
            return true;
        }
        return WD(str);
    }

    public boolean iJ(String str) {
        List<AlaWheatInfoData> Yn = Yn();
        for (int i = 0; i < ListUtils.getCount(Yn); i++) {
            AlaWheatInfoData alaWheatInfoData = Yn.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean WD(String str) {
        List<AlaWheatInfoData> Ym = Ym();
        for (int i = 0; i < ListUtils.getCount(Ym); i++) {
            AlaWheatInfoData alaWheatInfoData = Ym.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData iK(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.oJF)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oJF.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oJG); i2++) {
                alaWheatInfoData2 = this.oJG.get(i2);
                if (str != null && alaWheatInfoData2 != null && str.equals(alaWheatInfoData2.uk)) {
                    break;
                }
            }
        }
        alaWheatInfoData2 = alaWheatInfoData;
        if (alaWheatInfoData2 != null) {
            if (z) {
                return (AlaWheatInfoData) alaWheatInfoData2.clone();
            }
            return alaWheatInfoData2;
        }
        return null;
    }

    public AlaWheatInfoData WL(String str) {
        if (this.oJS != null) {
            return this.oJS.iK(str);
        }
        return null;
    }

    public AlaWheatInfoData Yl() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        if (Yq == null || Yq.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = Yq.mLiveInfo.user_uk;
        alaWheatInfoData.userName = Yq.mLiveInfo.user_name;
        alaWheatInfoData.portrait = Yq.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oJM;
    }

    public void Af(boolean z) {
        this.oJM = z;
    }

    public void aT(String str, String str2, String str3) {
        if (this.oJS != null && !edU()) {
            this.oJS.aT(str, str2, str3);
        }
    }

    public void WM(String str) {
        if (this.oJS != null) {
            this.oJS.WM(str);
        }
    }

    public void WN(String str) {
        if (this.oJS != null) {
            this.oJS.WN(str);
        }
    }

    public synchronized void eeL() {
        if (this.oJS != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    Mk();
                } else {
                    this.oJS.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Mk();
                        }
                    });
                }
            } catch (Exception e) {
                Log.i("BaseMode", "notifyWheatData crash : " + BdUtilHelper.isMainThread());
                e.printStackTrace();
            }
        }
    }

    public void ar(ab abVar) {
        if (abVar != null && abVar.aIY != null) {
            this.bxN = abVar;
            q.edM().Af(abVar.aIY.isApplying());
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
                }
            }, 100L);
            if (this.oJR) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cxN > 100 && currentTimeMillis - this.cxN < 5000) {
                    if (iH(g.Yp())) {
                        if (Yk()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.oJR = false;
                    }
                } else {
                    this.oJR = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oJL != null) {
            if (z) {
                if (!this.oJL.contains(str)) {
                    this.oJL.add(str);
                    return;
                }
                return;
            }
            this.oJL.remove(str);
        }
    }

    public boolean iL(String str) {
        return this.oJL != null && this.oJL.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.oJS != null) {
            this.oJS.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.oJS != null) {
            this.oJS.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext edS() {
        return this.oGE;
    }

    public boolean eeM() {
        return this.oJO;
    }

    public void Ag(boolean z) {
        this.oJO = z;
    }

    public int edR() {
        return this.oJN;
    }

    private void eeN() {
        if (Yk() && this.bxN != null && this.bxN.mLiveInfo != null && this.bxN.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bxN.mLiveInfo.apply_count);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONObject);
                jSONObject2.toString();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, jSONObject2.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void m(ab abVar) {
        this.bxN = abVar;
        this.aYV = true;
        ar(abVar);
        eeN();
        if ((abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) && this.oJS != null && this.oJS.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void Ar() {
        this.oJF.clear();
        this.oJG.clear();
        this.oJH.clear();
        this.oJI.clear();
        this.oJJ.clear();
        this.oJK.clear();
        this.oJL.clear();
        this.oJM = false;
        this.oJN = 0;
        this.oJO = false;
        this.oJP = false;
        setVisible(false);
    }

    public void G(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oJP = false;
        this.oJF.clear();
        this.oJG.clear();
        this.oJH.clear();
        this.oJI.clear();
        this.oJJ.clear();
        this.oJK.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oJI.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oJJ.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oJK.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oJP = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oJF.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oJP = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oJG.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oJP = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oJH.add(alaWheatInfoData3);
                }
            }
        }
        eeL();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (eeM()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aYV = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aYV + "  havePersonOnWheat:" + this.oJP + "  isOnWheat(getCurrentUserUK())" + iH(g.Yp()));
        }
        if (!this.aYV && this.oJP && !iH(g.Yp()) && !Yk()) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecT = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
                StringBuilder append = new StringBuilder().append("am != null").append(ecT != null).append("  am.isPlayerPlaying():");
                if (ecT == null || ecT.ecD()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (ecT != null && !ecT.ecD()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oJQ == null) {
                        this.oJQ = new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oEa) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && ecT != null) {
                                    ecT.ecL();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oJQ.request();
                } else if (ecT != null) {
                    ecT.ecL();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new com.baidu.tieba.yuyinala.liveroom.data.e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oHv = bVar;
    }

    public void Ah(boolean z) {
        this.oJR = z;
        this.cxN = System.currentTimeMillis();
    }

    public boolean edU() {
        if (this.oHv != null) {
            return this.oHv.edU();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oJQ != null) {
            this.oJQ.onDestroy();
            this.oJQ = null;
        }
    }

    public int getWheatHeight() {
        if (this.oJS != null) {
            return this.oJS.getWheatHeight();
        }
        return 0;
    }
}

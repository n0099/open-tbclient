package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.data.e;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a {
    public boolean aXu;
    protected w bqS;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext ocV;
    private AlaLiveRoomBlurPageLayout oeB;
    private com.baidu.tieba.yuyinala.player.b oeD;
    public List<AlaWheatInfoData> ogC = new ArrayList();
    public List<AlaWheatInfoData> ogD = new ArrayList();
    public List<AlaWheatInfoData> ogE = new ArrayList();
    public List<AlaWheatInfoData> ogF = new ArrayList();
    public List<AlaWheatInfoData> ogG = new ArrayList();
    public List<AlaWheatInfoData> ogH = new ArrayList();
    public Set<String> ogI = new HashSet();
    private com.baidu.live.al.a ogJ;
    private boolean ogK;
    public int ogL;
    private boolean ogM;
    public boolean ogN;
    private j ogO;
    private boolean ogP;
    private long ogQ;

    public abstract AlaWheatInfoData VX(String str);

    public abstract ViewGroup dZC();

    abstract View eap();

    abstract ViewGroup.LayoutParams k(Rect rect);

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.ocV = tbPageContext;
        this.oeB = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eaq();
    }

    private void initData() {
        this.ogC.clear();
        this.ogD.clear();
        this.ogE.clear();
        this.ogF.clear();
        this.ogG.clear();
        this.ogH.clear();
        this.ogI.clear();
        this.ogK = false;
        this.ogL = 0;
        this.ogM = false;
        this.ogN = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().aC(this.mActivity).f(this.ocV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initView() {
        this.oeB.d(eap(), k(this.mRect));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eaq() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().aC(this.mActivity).f(this.ocV);
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Xk() {
        return this.ogC;
    }

    public List<AlaWheatInfoData> Xj() {
        return this.ogD;
    }

    public boolean dZD() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || dYS() || !iX(encryptionUserId)) ? false : true;
    }

    public boolean dYS() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return iW(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iW(String str) {
        return (this.bqS == null || this.bqS.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bqS.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Vu(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (iX(str)) {
            return true;
        }
        return VQ(str);
    }

    public boolean iX(String str) {
        List<AlaWheatInfoData> Xk = Xk();
        for (int i = 0; i < ListUtils.getCount(Xk); i++) {
            AlaWheatInfoData alaWheatInfoData = Xk.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean VQ(String str) {
        List<AlaWheatInfoData> Xj = Xj();
        for (int i = 0; i < ListUtils.getCount(Xj); i++) {
            AlaWheatInfoData alaWheatInfoData = Xj.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData iY(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.ogC)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.ogC.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.ogD); i2++) {
                alaWheatInfoData2 = this.ogD.get(i2);
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

    public AlaWheatInfoData Xi() {
        w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
        if (Xn == null || Xn.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = Xn.mLiveInfo.user_uk;
        alaWheatInfoData.userName = Xn.mLiveInfo.user_name;
        alaWheatInfoData.portrait = Xn.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.ogK;
    }

    public void zd(boolean z) {
        this.ogK = z;
    }

    public void a(com.baidu.live.al.a aVar) {
        this.ogJ = aVar;
    }

    public void aM(String str, String str2, String str3) {
    }

    public void VY(String str) {
    }

    public void VZ(String str) {
    }

    public synchronized void ear() {
    }

    public void ai(w wVar) {
        if (wVar != null && wVar.aJP != null) {
            this.bqS = wVar;
            if (this.bqS != null && this.bqS.aJP != null) {
                o.dZA().zd(this.bqS.aJP.isApplying());
            }
            if (this.ogJ != null) {
                this.ogJ.Xg();
            }
            if (this.ogP) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ogQ > 100 && currentTimeMillis - this.ogQ < 5000) {
                    if (iV(g.Xm())) {
                        if (dYS()) {
                            d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.ogP = false;
                    }
                } else {
                    this.ogP = false;
                }
            }
            if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo || com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN() != null) {
            }
        }
    }

    public void F(String str, boolean z) {
        if (this.ogI != null) {
            if (z) {
                if (!this.ogI.contains(str)) {
                    this.ogI.add(str);
                    return;
                }
                return;
            }
            this.ogI.remove(str);
        }
    }

    public boolean iZ(String str) {
        return this.ogI != null && this.ogI.contains(str);
    }

    public void setMaskBg(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisible(boolean z) {
    }

    public TbPageContext dZF() {
        return this.ocV;
    }

    public boolean eas() {
        return this.ogM;
    }

    public void ze(boolean z) {
        this.ogM = z;
    }

    public int dZE() {
        return this.ogL;
    }

    private void eat() {
        if (dYS() && this.bqS != null && this.bqS.mLiveInfo != null && this.bqS.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bqS.mLiveInfo.apply_count);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONObject);
                jSONObject2.toString();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, jSONObject2.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void l(w wVar) {
        this.bqS = wVar;
        this.aXu = true;
        ai(wVar);
        eat();
    }

    public void Dm() {
        this.ogC.clear();
        this.ogD.clear();
        this.ogE.clear();
        this.ogF.clear();
        this.ogG.clear();
        this.ogH.clear();
        this.ogI.clear();
        this.ogK = false;
        this.ogL = 0;
        this.ogM = false;
        this.ogN = false;
    }

    public void E(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        b(list, list2, null);
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.ogN = false;
        this.ogC.clear();
        this.ogD.clear();
        this.ogE.clear();
        this.ogF.clear();
        this.ogG.clear();
        this.ogH.clear();
        if (!ListUtils.isEmpty(list)) {
            this.ogF.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.ogG.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.ogH.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.ogN = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.ogC.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.ogN = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.ogD.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.ogN = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.ogE.add(alaWheatInfoData3);
                }
            }
        }
        ear();
        if (eas()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aXu = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aXu + "  havePersonOnWheat:" + this.ogN + "  isOnWheat(getCurrentUserUK())" + iV(g.Xm()));
        }
        if (!this.aXu && this.ogN && !iV(g.Xm())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYN = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
                StringBuilder append = new StringBuilder().append("am != null").append(dYN != null).append("  am.isPlayerPlaying():");
                if (dYN == null || dYN.dYy()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (dYN != null && !dYN.dYy()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.ogO == null) {
                        this.ogO = new j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.obo) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && dYN != null) {
                                    dYN.dYH();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.ogO.request();
                } else if (dYN != null) {
                    dYN.dYH();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oeD = bVar;
    }

    public void zf(boolean z) {
        this.ogP = z;
        this.ogQ = System.currentTimeMillis();
    }

    public boolean dZH() {
        if (this.oeD != null) {
            return this.oeD.dZH();
        }
        return false;
    }

    public void onDestroy() {
        if (this.ogO != null) {
            this.ogO.onDestroy();
            this.ogO = null;
        }
    }

    public int getWheatHeight() {
        return 0;
    }
}

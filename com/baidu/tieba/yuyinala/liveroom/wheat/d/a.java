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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.yuyinala.liveroom.data.e;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaOnLineHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a {
    public boolean aVN;
    protected x buq;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext ovz;
    private AlaLiveRoomBlurPageLayout oxn;
    private com.baidu.tieba.yuyinala.player.b oxp;
    private boolean ozD;
    public int ozE;
    private boolean ozF;
    public boolean ozG;
    private k ozH;
    private boolean ozI;
    private long ozJ;
    public BaseWheatLayout ozK;
    public List<AlaWheatInfoData> ozw = new ArrayList();
    public List<AlaWheatInfoData> ozx = new ArrayList();
    public List<AlaWheatInfoData> ozy = new ArrayList();
    public List<AlaWheatInfoData> ozz = new ArrayList();
    public List<AlaWheatInfoData> ozA = new ArrayList();
    public List<AlaWheatInfoData> ozB = new ArrayList();
    public Set<String> ozC = new HashSet();

    public abstract void KM();

    public abstract View ecn();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.ovz = tbPageContext;
        this.oxn = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eco();
    }

    private void initData() {
        this.ozw.clear();
        this.ozx.clear();
        this.ozy.clear();
        this.ozz.clear();
        this.ozA.clear();
        this.ozB.clear();
        this.ozC.clear();
        this.ozD = false;
        this.ozE = 0;
        this.ozF = false;
        this.ozG = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().aG(this.mActivity).f(this.ovz);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup ebq() {
        return this.ozK;
    }

    public void initView() {
        this.oxn.f(ecn(), k(this.mRect));
    }

    public void eco() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().aG(this.mActivity).f(this.ovz);
        this.ozK.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.ozE = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.owK : g.owL);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Wx() {
        return this.ozw;
    }

    public List<AlaWheatInfoData> Ww() {
        return this.ozx;
    }

    public List<AlaWheatInfoData> ebr() {
        return this.ozA;
    }

    public boolean ebs() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || eaE() || !id(encryptionUserId)) ? false : true;
    }

    public boolean eaE() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ic(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean ic(String str) {
        return (this.buq == null || this.buq.mLiveInfo == null || str == null || !TextUtils.equals(str, this.buq.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean UU(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean ib(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (id(str)) {
            return true;
        }
        return Vr(str);
    }

    public boolean id(String str) {
        List<AlaWheatInfoData> Wx = Wx();
        for (int i = 0; i < ListUtils.getCount(Wx); i++) {
            AlaWheatInfoData alaWheatInfoData = Wx.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean Vr(String str) {
        List<AlaWheatInfoData> Ww = Ww();
        for (int i = 0; i < ListUtils.getCount(Ww); i++) {
            AlaWheatInfoData alaWheatInfoData = Ww.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData ie(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.ozw)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.ozw.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.ozx); i2++) {
                alaWheatInfoData2 = this.ozx.get(i2);
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

    public AlaWheatInfoData VA(String str) {
        if (this.ozK != null) {
            return this.ozK.ie(str);
        }
        return null;
    }

    public AlaWheatInfoData Wv() {
        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
        if (WA == null || WA.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = WA.mLiveInfo.user_uk;
        alaWheatInfoData.userName = WA.mLiveInfo.user_name;
        alaWheatInfoData.portrait = WA.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.ozD;
    }

    public void zM(boolean z) {
        this.ozD = z;
    }

    public void aS(String str, String str2, String str3) {
        if (this.ozK != null && !ebw()) {
            this.ozK.aS(str, str2, str3);
        }
    }

    public void VB(String str) {
        if (this.ozK != null) {
            this.ozK.VB(str);
        }
    }

    public void VC(String str) {
        if (this.ozK != null) {
            this.ozK.VC(str);
        }
    }

    public synchronized void ecp() {
        if (this.ozK != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    KM();
                } else {
                    this.ozK.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.KM();
                        }
                    });
                }
            } catch (Exception e) {
                Log.i("BaseMode", "notifyWheatData crash : " + BdUtilHelper.isMainThread());
                e.printStackTrace();
            }
        }
    }

    public void ar(x xVar) {
        if (xVar != null && xVar.aGD != null) {
            this.buq = xVar;
            if (this.buq != null && this.buq.aGD != null) {
                o.ebo().zM(this.buq.aGD.isApplying());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
            if (this.ozI) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ozJ > 100 && currentTimeMillis - this.ozJ < 5000) {
                    if (ib(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Wz())) {
                        if (eaE()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.ozI = false;
                    }
                } else {
                    this.ozI = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.ozC != null) {
            if (z) {
                if (!this.ozC.contains(str)) {
                    this.ozC.add(str);
                    return;
                }
                return;
            }
            this.ozC.remove(str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m48if(String str) {
        return this.ozC != null && this.ozC.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.ozK != null) {
            this.ozK.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.ozK != null) {
            this.ozK.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext ebu() {
        return this.ovz;
    }

    public boolean ecq() {
        return this.ozF;
    }

    public void zN(boolean z) {
        this.ozF = z;
    }

    public int ebt() {
        return this.ozE;
    }

    private void ecr() {
        if (eaE() && this.buq != null && this.buq.mLiveInfo != null && this.buq.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.buq.mLiveInfo.apply_count);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONObject);
                jSONObject2.toString();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501027, jSONObject2.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void m(x xVar) {
        this.buq = xVar;
        this.aVN = true;
        ar(xVar);
        ecr();
        if ((xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) && this.ozK != null && this.ozK.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void zH() {
        this.ozw.clear();
        this.ozx.clear();
        this.ozy.clear();
        this.ozz.clear();
        this.ozA.clear();
        this.ozB.clear();
        this.ozC.clear();
        this.ozD = false;
        this.ozE = 0;
        this.ozF = false;
        this.ozG = false;
        setVisible(false);
    }

    public void H(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.ozG = false;
        this.ozw.clear();
        this.ozx.clear();
        this.ozy.clear();
        this.ozz.clear();
        this.ozA.clear();
        this.ozB.clear();
        if (!ListUtils.isEmpty(list)) {
            this.ozz.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.ozA.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.ozB.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.ozG = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.ozw.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.ozG = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.ozx.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.ozG = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.ozy.add(alaWheatInfoData3);
                }
            }
        }
        ecp();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (ecq()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aVN = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aVN + "  havePersonOnWheat:" + this.ozG + "  isOnWheat(getCurrentUserUK())" + ib(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Wz()));
        }
        if (!this.aVN && this.ozG && !ib(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.Wz())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b eaz = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
                StringBuilder append = new StringBuilder().append("am != null").append(eaz != null).append("  am.isPlayerPlaying():");
                if (eaz == null || eaz.eak()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (eaz != null && !eaz.eak()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.ozH == null) {
                        this.ozH = new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.otO) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && eaz != null) {
                                    eaz.eat();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.ozH.request();
                } else if (eaz != null) {
                    eaz.eat();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oxp = bVar;
    }

    public void zO(boolean z) {
        this.ozI = z;
        this.ozJ = System.currentTimeMillis();
    }

    public boolean ebw() {
        if (this.oxp != null) {
            return this.oxp.ebw();
        }
        return false;
    }

    public void onDestroy() {
        if (this.ozH != null) {
            this.ozH.onDestroy();
            this.ozH = null;
        }
    }

    public int getWheatHeight() {
        if (this.ozK != null) {
            return this.ozK.getWheatHeight();
        }
        return 0;
    }
}

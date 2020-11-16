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
    public boolean aVJ;
    protected w bph;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext oey;
    private AlaLiveRoomBlurPageLayout ogf;
    private com.baidu.tieba.yuyinala.player.b ogh;
    public List<AlaWheatInfoData> oif = new ArrayList();
    public List<AlaWheatInfoData> oig = new ArrayList();
    public List<AlaWheatInfoData> oih = new ArrayList();
    public List<AlaWheatInfoData> oii = new ArrayList();
    public List<AlaWheatInfoData> oij = new ArrayList();
    public List<AlaWheatInfoData> oik = new ArrayList();
    public Set<String> oil = new HashSet();
    private com.baidu.live.al.a oim;
    private boolean oin;
    public int oio;
    private boolean oip;
    public boolean oiq;
    private j oir;
    private boolean ois;
    private long oit;

    public abstract AlaWheatInfoData VI(String str);

    public abstract ViewGroup dZB();

    abstract View eao();

    abstract ViewGroup.LayoutParams k(Rect rect);

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oey = tbPageContext;
        this.ogf = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eap();
    }

    private void initData() {
        this.oif.clear();
        this.oig.clear();
        this.oih.clear();
        this.oii.clear();
        this.oij.clear();
        this.oik.clear();
        this.oil.clear();
        this.oin = false;
        this.oio = 0;
        this.oip = false;
        this.oiq = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().aB(this.mActivity).f(this.oey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initView() {
        this.ogf.d(eao(), k(this.mRect));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eap() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().aB(this.mActivity).f(this.oey);
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> WB() {
        return this.oif;
    }

    public List<AlaWheatInfoData> WA() {
        return this.oig;
    }

    public boolean dZC() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || dYR() || !iR(encryptionUserId)) ? false : true;
    }

    public boolean dYR() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return iQ(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iQ(String str) {
        return (this.bph == null || this.bph.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bph.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Vf(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (iR(str)) {
            return true;
        }
        return VB(str);
    }

    public boolean iR(String str) {
        List<AlaWheatInfoData> WB = WB();
        for (int i = 0; i < ListUtils.getCount(WB); i++) {
            AlaWheatInfoData alaWheatInfoData = WB.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean VB(String str) {
        List<AlaWheatInfoData> WA = WA();
        for (int i = 0; i < ListUtils.getCount(WA); i++) {
            AlaWheatInfoData alaWheatInfoData = WA.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData iS(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.oif)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oif.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oig); i2++) {
                alaWheatInfoData2 = this.oig.get(i2);
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

    public AlaWheatInfoData Wz() {
        w WE = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
        if (WE == null || WE.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = WE.mLiveInfo.user_uk;
        alaWheatInfoData.userName = WE.mLiveInfo.user_name;
        alaWheatInfoData.portrait = WE.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oin;
    }

    public void zk(boolean z) {
        this.oin = z;
    }

    public void a(com.baidu.live.al.a aVar) {
        this.oim = aVar;
    }

    public void aM(String str, String str2, String str3) {
    }

    public void VJ(String str) {
    }

    public void VK(String str) {
    }

    public synchronized void eaq() {
    }

    public void ai(w wVar) {
        if (wVar != null && wVar.aIe != null) {
            this.bph = wVar;
            if (this.bph != null && this.bph.aIe != null) {
                o.dZz().zk(this.bph.aIe.isApplying());
            }
            if (this.oim != null) {
                this.oim.Wx();
            }
            if (this.ois) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oit > 100 && currentTimeMillis - this.oit < 5000) {
                    if (iP(g.WD())) {
                        if (dYR()) {
                            d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.ois = false;
                    }
                } else {
                    this.ois = false;
                }
            }
            if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS || com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM() != null) {
            }
        }
    }

    public void F(String str, boolean z) {
        if (this.oil != null) {
            if (z) {
                if (!this.oil.contains(str)) {
                    this.oil.add(str);
                    return;
                }
                return;
            }
            this.oil.remove(str);
        }
    }

    public boolean iT(String str) {
        return this.oil != null && this.oil.contains(str);
    }

    public void setMaskBg(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisible(boolean z) {
    }

    public TbPageContext dZE() {
        return this.oey;
    }

    public boolean ear() {
        return this.oip;
    }

    public void zl(boolean z) {
        this.oip = z;
    }

    public int dZD() {
        return this.oio;
    }

    private void eas() {
        if (dYR() && this.bph != null && this.bph.mLiveInfo != null && this.bph.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bph.mLiveInfo.apply_count);
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
        this.bph = wVar;
        this.aVJ = true;
        ai(wVar);
        eas();
    }

    public void CD() {
        this.oif.clear();
        this.oig.clear();
        this.oih.clear();
        this.oii.clear();
        this.oij.clear();
        this.oik.clear();
        this.oil.clear();
        this.oin = false;
        this.oio = 0;
        this.oip = false;
        this.oiq = false;
    }

    public void E(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        b(list, list2, null);
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oiq = false;
        this.oif.clear();
        this.oig.clear();
        this.oih.clear();
        this.oii.clear();
        this.oij.clear();
        this.oik.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oii.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oij.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oik.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oiq = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oif.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oiq = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oig.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oiq = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oih.add(alaWheatInfoData3);
                }
            }
        }
        eaq();
        if (ear()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aVJ = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aVJ + "  havePersonOnWheat:" + this.oiq + "  isOnWheat(getCurrentUserUK())" + iP(g.WD()));
        }
        if (!this.aVJ && this.oiq && !iP(g.WD())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b dYM = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
                StringBuilder append = new StringBuilder().append("am != null").append(dYM != null).append("  am.isPlayerPlaying():");
                if (dYM == null || dYM.dYx()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (dYM != null && !dYM.dYx()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oir == null) {
                        this.oir = new j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.ocS) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && dYM != null) {
                                    dYM.dYG();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oir.request();
                } else if (dYM != null) {
                    dYM.dYG();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ogh = bVar;
    }

    public void zm(boolean z) {
        this.ois = z;
        this.oit = System.currentTimeMillis();
    }

    public boolean dZG() {
        if (this.ogh != null) {
            return this.ogh.dZG();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oir != null) {
            this.oir.onDestroy();
            this.oir = null;
        }
    }

    public int getWheatHeight() {
        return 0;
    }
}

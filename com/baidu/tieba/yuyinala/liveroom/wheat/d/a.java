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
    public boolean aYU;
    protected w bur;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext otA;
    private AlaLiveRoomBlurPageLayout ovh;
    private com.baidu.tieba.yuyinala.player.b ovj;
    public List<AlaWheatInfoData> oxh = new ArrayList();
    public List<AlaWheatInfoData> oxi = new ArrayList();
    public List<AlaWheatInfoData> oxj = new ArrayList();
    public List<AlaWheatInfoData> oxk = new ArrayList();
    public List<AlaWheatInfoData> oxl = new ArrayList();
    public List<AlaWheatInfoData> oxm = new ArrayList();
    public Set<String> oxn = new HashSet();
    private com.baidu.live.ap.a oxo;
    private boolean oxp;
    public int oxq;
    private boolean oxr;
    public boolean oxs;
    private j oxt;
    private boolean oxu;
    private long oxv;

    public abstract AlaWheatInfoData WX(String str);

    abstract View efU();

    public abstract ViewGroup efg();

    abstract ViewGroup.LayoutParams k(Rect rect);

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.otA = tbPageContext;
        this.ovh = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        efV();
    }

    private void initData() {
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        this.oxl.clear();
        this.oxm.clear();
        this.oxn.clear();
        this.oxp = false;
        this.oxq = 0;
        this.oxr = false;
        this.oxs = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aC(this.mActivity).f(this.otA);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initView() {
        this.ovh.d(efU(), k(this.mRect));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void efV() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aC(this.mActivity).f(this.otA);
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Za() {
        return this.oxh;
    }

    public List<AlaWheatInfoData> YZ() {
        return this.oxi;
    }

    public boolean efh() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || eew() || !jv(encryptionUserId)) ? false : true;
    }

    public boolean eew() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ju(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean ju(String str) {
        return (this.bur == null || this.bur.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bur.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Wu(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean jt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (jv(str)) {
            return true;
        }
        return WQ(str);
    }

    public boolean jv(String str) {
        List<AlaWheatInfoData> Za = Za();
        for (int i = 0; i < ListUtils.getCount(Za); i++) {
            AlaWheatInfoData alaWheatInfoData = Za.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean WQ(String str) {
        List<AlaWheatInfoData> YZ = YZ();
        for (int i = 0; i < ListUtils.getCount(YZ); i++) {
            AlaWheatInfoData alaWheatInfoData = YZ.get(i);
            if (alaWheatInfoData != null && str.equals(alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData jw(String str) {
        return bj(str, true);
    }

    public AlaWheatInfoData bj(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.oxh)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oxh.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oxi); i2++) {
                alaWheatInfoData2 = this.oxi.get(i2);
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

    public AlaWheatInfoData YY() {
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
        if (Zd == null || Zd.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = Zd.mLiveInfo.user_uk;
        alaWheatInfoData.userName = Zd.mLiveInfo.user_name;
        alaWheatInfoData.portrait = Zd.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oxp;
    }

    public void zO(boolean z) {
        this.oxp = z;
    }

    public void a(com.baidu.live.ap.a aVar) {
        this.oxo = aVar;
    }

    public void aP(String str, String str2, String str3) {
    }

    public void WY(String str) {
    }

    public void WZ(String str) {
    }

    public synchronized void efW() {
    }

    public void an(w wVar) {
        if (wVar != null && wVar.aKQ != null) {
            this.bur = wVar;
            if (this.bur != null && this.bur.aKQ != null) {
                o.efe().zO(this.bur.aKQ.isApplying());
            }
            if (this.oxo != null) {
                this.oxo.YW();
            }
            if (this.oxu) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oxv > 100 && currentTimeMillis - this.oxv < 5000) {
                    if (jt(g.Zc())) {
                        if (eew()) {
                            d.bk("connection_wheat_succ_host_5", true);
                        } else {
                            d.bk("connection_wheat_succ_anchor_8", false);
                        }
                        this.oxu = false;
                    }
                } else {
                    this.oxu = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oxn != null) {
            if (z) {
                if (!this.oxn.contains(str)) {
                    this.oxn.add(str);
                    return;
                }
                return;
            }
            this.oxn.remove(str);
        }
    }

    public boolean jx(String str) {
        return this.oxn != null && this.oxn.contains(str);
    }

    public void setMaskBg(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisible(boolean z) {
    }

    public TbPageContext efj() {
        return this.otA;
    }

    public boolean efX() {
        return this.oxr;
    }

    public void zP(boolean z) {
        this.oxr = z;
    }

    public int efi() {
        return this.oxq;
    }

    private void efY() {
        if (eew() && this.bur != null && this.bur.mLiveInfo != null && this.bur.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bur.mLiveInfo.apply_count);
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
        this.bur = wVar;
        this.aYU = true;
        an(wVar);
        efY();
    }

    public void En() {
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        this.oxl.clear();
        this.oxm.clear();
        this.oxn.clear();
        this.oxp = false;
        this.oxq = 0;
        this.oxr = false;
        this.oxs = false;
    }

    public void E(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        b(list, list2, null);
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oxs = false;
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        this.oxl.clear();
        this.oxm.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oxk.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oxl.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oxm.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oxs = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oxh.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oxs = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oxi.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oxs = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oxj.add(alaWheatInfoData3);
                }
            }
        }
        efW();
        if (efX()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aYU = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aYU + "  havePersonOnWheat:" + this.oxs + "  isOnWheat(getCurrentUserUK())" + jt(g.Zc()));
        }
        if (!this.aYU && this.oxs && !jt(g.Zc())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
                StringBuilder append = new StringBuilder().append("am != null").append(eer != null).append("  am.isPlayerPlaying():");
                if (eer == null || eer.eec()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (eer != null && !eer.eec()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oxt == null) {
                        this.oxt = new j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orU) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && eer != null) {
                                    eer.eel();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oxt.request();
                } else if (eer != null) {
                    eer.eel();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ovj = bVar;
    }

    public void zQ(boolean z) {
        this.oxu = z;
        this.oxv = System.currentTimeMillis();
    }

    public boolean efl() {
        if (this.ovj != null) {
            return this.ovj.efl();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oxt != null) {
            this.oxt.onDestroy();
            this.oxt = null;
        }
    }

    public int getWheatHeight() {
        return 0;
    }
}

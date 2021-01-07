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
/* loaded from: classes11.dex */
public abstract class a {
    public boolean baB;
    protected x bzc;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext oAe;
    private AlaLiveRoomBlurPageLayout oBS;
    private com.baidu.tieba.yuyinala.player.b oBU;
    public List<AlaWheatInfoData> oEb = new ArrayList();
    public List<AlaWheatInfoData> oEc = new ArrayList();
    public List<AlaWheatInfoData> oEd = new ArrayList();
    public List<AlaWheatInfoData> oEe = new ArrayList();
    public List<AlaWheatInfoData> oEf = new ArrayList();
    public List<AlaWheatInfoData> oEg = new ArrayList();
    public Set<String> oEh = new HashSet();
    private boolean oEi;
    public int oEj;
    private boolean oEk;
    public boolean oEl;
    private k oEm;
    private boolean oEn;
    private long oEo;
    public BaseWheatLayout oEp;

    public abstract void OH();

    public abstract View egf();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oAe = tbPageContext;
        this.oBS = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        egg();
    }

    private void initData() {
        this.oEb.clear();
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        this.oEh.clear();
        this.oEi = false;
        this.oEj = 0;
        this.oEk = false;
        this.oEl = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aG(this.mActivity).f(this.oAe);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup efi() {
        return this.oEp;
    }

    public void initView() {
        this.oBS.f(egf(), k(this.mRect));
    }

    public void egg() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aG(this.mActivity).f(this.oAe);
        this.oEp.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.oEj = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.oBp : g.oBq);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> aaq() {
        return this.oEb;
    }

    public List<AlaWheatInfoData> aap() {
        return this.oEc;
    }

    public List<AlaWheatInfoData> efj() {
        return this.oEf;
    }

    public boolean efk() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || eew() || !jo(encryptionUserId)) ? false : true;
    }

    public boolean eew() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return jn(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean jn(String str) {
        return (this.bzc == null || this.bzc.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bzc.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Wc(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean jm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (jo(str)) {
            return true;
        }
        return Wz(str);
    }

    public boolean jo(String str) {
        List<AlaWheatInfoData> aaq = aaq();
        for (int i = 0; i < ListUtils.getCount(aaq); i++) {
            AlaWheatInfoData alaWheatInfoData = aaq.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean Wz(String str) {
        List<AlaWheatInfoData> aap = aap();
        for (int i = 0; i < ListUtils.getCount(aap); i++) {
            AlaWheatInfoData alaWheatInfoData = aap.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData jp(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.oEb)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oEb.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oEc); i2++) {
                alaWheatInfoData2 = this.oEc.get(i2);
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

    public AlaWheatInfoData WI(String str) {
        if (this.oEp != null) {
            return this.oEp.jp(str);
        }
        return null;
    }

    public AlaWheatInfoData aao() {
        x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
        if (aat == null || aat.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = aat.mLiveInfo.user_uk;
        alaWheatInfoData.userName = aat.mLiveInfo.user_name;
        alaWheatInfoData.portrait = aat.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oEi;
    }

    public void zQ(boolean z) {
        this.oEi = z;
    }

    public void aT(String str, String str2, String str3) {
        if (this.oEp != null && !efo()) {
            this.oEp.aT(str, str2, str3);
        }
    }

    public void WJ(String str) {
        if (this.oEp != null) {
            this.oEp.WJ(str);
        }
    }

    public void WK(String str) {
        if (this.oEp != null) {
            this.oEp.WK(str);
        }
    }

    public synchronized void egh() {
        if (this.oEp != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    OH();
                } else {
                    this.oEp.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.OH();
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
        if (xVar != null && xVar.aLq != null) {
            this.bzc = xVar;
            if (this.bzc != null && this.bzc.aLq != null) {
                o.efg().zQ(this.bzc.aLq.isApplying());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
            if (this.oEn) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oEo > 100 && currentTimeMillis - this.oEo < 5000) {
                    if (jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aas())) {
                        if (eew()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.oEn = false;
                    }
                } else {
                    this.oEn = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oEh != null) {
            if (z) {
                if (!this.oEh.contains(str)) {
                    this.oEh.add(str);
                    return;
                }
                return;
            }
            this.oEh.remove(str);
        }
    }

    public boolean jq(String str) {
        return this.oEh != null && this.oEh.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.oEp != null) {
            this.oEp.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.oEp != null) {
            this.oEp.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext efm() {
        return this.oAe;
    }

    public boolean egi() {
        return this.oEk;
    }

    public void zR(boolean z) {
        this.oEk = z;
    }

    public int efl() {
        return this.oEj;
    }

    private void egj() {
        if (eew() && this.bzc != null && this.bzc.mLiveInfo != null && this.bzc.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bzc.mLiveInfo.apply_count);
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
        this.bzc = xVar;
        this.baB = true;
        ar(xVar);
        egj();
        if ((xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) && this.oEp != null && this.oEp.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void DC() {
        this.oEb.clear();
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        this.oEh.clear();
        this.oEi = false;
        this.oEj = 0;
        this.oEk = false;
        this.oEl = false;
        setVisible(false);
    }

    public void H(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oEl = false;
        this.oEb.clear();
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oEe.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oEf.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oEg.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oEl = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oEb.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oEl = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oEc.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oEl = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oEd.add(alaWheatInfoData3);
                }
            }
        }
        egh();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (egi()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.baB = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.baB + "  havePersonOnWheat:" + this.oEl + "  isOnWheat(getCurrentUserUK())" + jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aas()));
        }
        if (!this.baB && this.oEl && !jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aas())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b eer = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
                StringBuilder append = new StringBuilder().append("am != null").append(eer != null).append("  am.isPlayerPlaying():");
                if (eer == null || eer.eec()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (eer != null && !eer.eec()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oEm == null) {
                        this.oEm = new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyu) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && eer != null) {
                                    eer.eel();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oEm.request();
                } else if (eer != null) {
                    eer.eel();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oBU = bVar;
    }

    public void zS(boolean z) {
        this.oEn = z;
        this.oEo = System.currentTimeMillis();
    }

    public boolean efo() {
        if (this.oBU != null) {
            return this.oBU.efo();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oEm != null) {
            this.oEm.onDestroy();
            this.oEm = null;
        }
    }

    public int getWheatHeight() {
        if (this.oEp != null) {
            return this.oEp.getWheatHeight();
        }
        return 0;
    }
}

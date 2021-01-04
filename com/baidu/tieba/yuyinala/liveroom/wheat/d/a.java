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
    public TbPageContext oAf;
    private AlaLiveRoomBlurPageLayout oBT;
    private com.baidu.tieba.yuyinala.player.b oBV;
    public List<AlaWheatInfoData> oEc = new ArrayList();
    public List<AlaWheatInfoData> oEd = new ArrayList();
    public List<AlaWheatInfoData> oEe = new ArrayList();
    public List<AlaWheatInfoData> oEf = new ArrayList();
    public List<AlaWheatInfoData> oEg = new ArrayList();
    public List<AlaWheatInfoData> oEh = new ArrayList();
    public Set<String> oEi = new HashSet();
    private boolean oEj;
    public int oEk;
    private boolean oEl;
    public boolean oEm;
    private k oEn;
    private boolean oEo;
    private long oEp;
    public BaseWheatLayout oEq;

    public abstract void OH();

    public abstract View ege();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oAf = tbPageContext;
        this.oBT = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        egf();
    }

    private void initData() {
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        this.oEh.clear();
        this.oEi.clear();
        this.oEj = false;
        this.oEk = 0;
        this.oEl = false;
        this.oEm = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aG(this.mActivity).f(this.oAf);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup efh() {
        return this.oEq;
    }

    public void initView() {
        this.oBT.f(ege(), k(this.mRect));
    }

    public void egf() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aG(this.mActivity).f(this.oAf);
        this.oEq.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.oEk = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? g.oBq : g.oBr);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> aap() {
        return this.oEc;
    }

    public List<AlaWheatInfoData> aao() {
        return this.oEd;
    }

    public List<AlaWheatInfoData> efi() {
        return this.oEg;
    }

    public boolean efj() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || eev() || !jo(encryptionUserId)) ? false : true;
    }

    public boolean eev() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return jn(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean jn(String str) {
        return (this.bzc == null || this.bzc.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bzc.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Wd(String str) {
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
        return WA(str);
    }

    public boolean jo(String str) {
        List<AlaWheatInfoData> aap = aap();
        for (int i = 0; i < ListUtils.getCount(aap); i++) {
            AlaWheatInfoData alaWheatInfoData = aap.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean WA(String str) {
        List<AlaWheatInfoData> aao = aao();
        for (int i = 0; i < ListUtils.getCount(aao); i++) {
            AlaWheatInfoData alaWheatInfoData = aao.get(i);
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
            if (i >= ListUtils.getCount(this.oEc)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oEc.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oEd); i2++) {
                alaWheatInfoData2 = this.oEd.get(i2);
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

    public AlaWheatInfoData WJ(String str) {
        if (this.oEq != null) {
            return this.oEq.jp(str);
        }
        return null;
    }

    public AlaWheatInfoData aan() {
        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
        if (aas == null || aas.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = aas.mLiveInfo.user_uk;
        alaWheatInfoData.userName = aas.mLiveInfo.user_name;
        alaWheatInfoData.portrait = aas.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oEj;
    }

    public void zQ(boolean z) {
        this.oEj = z;
    }

    public void aT(String str, String str2, String str3) {
        if (this.oEq != null && !efn()) {
            this.oEq.aT(str, str2, str3);
        }
    }

    public void WK(String str) {
        if (this.oEq != null) {
            this.oEq.WK(str);
        }
    }

    public void WL(String str) {
        if (this.oEq != null) {
            this.oEq.WL(str);
        }
    }

    public synchronized void egg() {
        if (this.oEq != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    OH();
                } else {
                    this.oEq.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
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
                o.eff().zQ(this.bzc.aLq.isApplying());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
            if (this.oEo) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oEp > 100 && currentTimeMillis - this.oEp < 5000) {
                    if (jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aar())) {
                        if (eev()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.oEo = false;
                    }
                } else {
                    this.oEo = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oEi != null) {
            if (z) {
                if (!this.oEi.contains(str)) {
                    this.oEi.add(str);
                    return;
                }
                return;
            }
            this.oEi.remove(str);
        }
    }

    public boolean jq(String str) {
        return this.oEi != null && this.oEi.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.oEq != null) {
            this.oEq.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.oEq != null) {
            this.oEq.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext efl() {
        return this.oAf;
    }

    public boolean egh() {
        return this.oEl;
    }

    public void zR(boolean z) {
        this.oEl = z;
    }

    public int efk() {
        return this.oEk;
    }

    private void egi() {
        if (eev() && this.bzc != null && this.bzc.mLiveInfo != null && this.bzc.mLiveInfo.apply_count > 0) {
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
        egi();
        if ((xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) && this.oEq != null && this.oEq.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void DC() {
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        this.oEh.clear();
        this.oEi.clear();
        this.oEj = false;
        this.oEk = 0;
        this.oEl = false;
        this.oEm = false;
        setVisible(false);
    }

    public void H(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oEm = false;
        this.oEc.clear();
        this.oEd.clear();
        this.oEe.clear();
        this.oEf.clear();
        this.oEg.clear();
        this.oEh.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oEf.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oEg.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oEh.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oEm = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oEc.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oEm = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oEd.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oEm = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oEe.add(alaWheatInfoData3);
                }
            }
        }
        egg();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (egh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.baB = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.baB + "  havePersonOnWheat:" + this.oEm + "  isOnWheat(getCurrentUserUK())" + jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aar()));
        }
        if (!this.baB && this.oEm && !jm(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.aar())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
                StringBuilder append = new StringBuilder().append("am != null").append(eeq != null).append("  am.isPlayerPlaying():");
                if (eeq == null || eeq.eeb()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (eeq != null && !eeq.eeb()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oEn == null) {
                        this.oEn = new k(null, new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && eeq != null) {
                                    eeq.eek();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.k.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oEn.request();
                } else if (eeq != null) {
                    eeq.eek();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oBV = bVar;
    }

    public void zS(boolean z) {
        this.oEo = z;
        this.oEp = System.currentTimeMillis();
    }

    public boolean efn() {
        if (this.oBV != null) {
            return this.oBV.efn();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oEn != null) {
            this.oEn.onDestroy();
            this.oEn = null;
        }
    }

    public int getWheatHeight() {
        if (this.oEq != null) {
            return this.oEq.getWheatHeight();
        }
        return 0;
    }
}

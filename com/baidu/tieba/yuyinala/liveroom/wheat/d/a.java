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
    public TbPageContext oty;
    private AlaLiveRoomBlurPageLayout ovf;
    private com.baidu.tieba.yuyinala.player.b ovh;
    public List<AlaWheatInfoData> oxf = new ArrayList();
    public List<AlaWheatInfoData> oxg = new ArrayList();
    public List<AlaWheatInfoData> oxh = new ArrayList();
    public List<AlaWheatInfoData> oxi = new ArrayList();
    public List<AlaWheatInfoData> oxj = new ArrayList();
    public List<AlaWheatInfoData> oxk = new ArrayList();
    public Set<String> oxl = new HashSet();
    private com.baidu.live.ap.a oxm;
    private boolean oxn;
    public int oxo;
    private boolean oxp;
    public boolean oxq;
    private j oxr;
    private boolean oxs;
    private long oxt;

    public abstract AlaWheatInfoData WX(String str);

    abstract View efT();

    public abstract ViewGroup eff();

    abstract ViewGroup.LayoutParams k(Rect rect);

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oty = tbPageContext;
        this.ovf = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        efU();
    }

    private void initData() {
        this.oxf.clear();
        this.oxg.clear();
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        this.oxl.clear();
        this.oxn = false;
        this.oxo = 0;
        this.oxp = false;
        this.oxq = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aC(this.mActivity).f(this.oty);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initView() {
        this.ovf.d(efT(), k(this.mRect));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void efU() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aC(this.mActivity).f(this.oty);
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Za() {
        return this.oxf;
    }

    public List<AlaWheatInfoData> YZ() {
        return this.oxg;
    }

    public boolean efg() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || eev() || !jv(encryptionUserId)) ? false : true;
    }

    public boolean eev() {
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
            if (i >= ListUtils.getCount(this.oxf)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oxf.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oxg); i2++) {
                alaWheatInfoData2 = this.oxg.get(i2);
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
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
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
        return this.oxn;
    }

    public void zO(boolean z) {
        this.oxn = z;
    }

    public void a(com.baidu.live.ap.a aVar) {
        this.oxm = aVar;
    }

    public void aP(String str, String str2, String str3) {
    }

    public void WY(String str) {
    }

    public void WZ(String str) {
    }

    public synchronized void efV() {
    }

    public void an(w wVar) {
        if (wVar != null && wVar.aKQ != null) {
            this.bur = wVar;
            if (this.bur != null && this.bur.aKQ != null) {
                o.efd().zO(this.bur.aKQ.isApplying());
            }
            if (this.oxm != null) {
                this.oxm.YW();
            }
            if (this.oxs) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oxt > 100 && currentTimeMillis - this.oxt < 5000) {
                    if (jt(g.Zc())) {
                        if (eev()) {
                            d.bk("connection_wheat_succ_host_5", true);
                        } else {
                            d.bk("connection_wheat_succ_anchor_8", false);
                        }
                        this.oxs = false;
                    }
                } else {
                    this.oxs = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oxl != null) {
            if (z) {
                if (!this.oxl.contains(str)) {
                    this.oxl.add(str);
                    return;
                }
                return;
            }
            this.oxl.remove(str);
        }
    }

    public boolean jx(String str) {
        return this.oxl != null && this.oxl.contains(str);
    }

    public void setMaskBg(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisible(boolean z) {
    }

    public TbPageContext efi() {
        return this.oty;
    }

    public boolean efW() {
        return this.oxp;
    }

    public void zP(boolean z) {
        this.oxp = z;
    }

    public int efh() {
        return this.oxo;
    }

    private void efX() {
        if (eev() && this.bur != null && this.bur.mLiveInfo != null && this.bur.mLiveInfo.apply_count > 0) {
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
        efX();
    }

    public void En() {
        this.oxf.clear();
        this.oxg.clear();
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        this.oxl.clear();
        this.oxn = false;
        this.oxo = 0;
        this.oxp = false;
        this.oxq = false;
    }

    public void E(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        b(list, list2, null);
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oxq = false;
        this.oxf.clear();
        this.oxg.clear();
        this.oxh.clear();
        this.oxi.clear();
        this.oxj.clear();
        this.oxk.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oxi.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oxj.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oxk.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oxq = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oxf.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oxq = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oxg.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oxq = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oxh.add(alaWheatInfoData3);
                }
            }
        }
        efV();
        if (efW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aYU = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aYU + "  havePersonOnWheat:" + this.oxq + "  isOnWheat(getCurrentUserUK())" + jt(g.Zc()));
        }
        if (!this.aYU && this.oxq && !jt(g.Zc())) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b eeq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
                StringBuilder append = new StringBuilder().append("am != null").append(eeq != null).append("  am.isPlayerPlaying():");
                if (eeq == null || eeq.eeb()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (eeq != null && !eeq.eeb()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oxr == null) {
                        this.oxr = new j(null, new j.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.orS) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && eeq != null) {
                                    eeq.eek();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.j.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oxr.request();
                } else if (eeq != null) {
                    eeq.eek();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.ovh = bVar;
    }

    public void zQ(boolean z) {
        this.oxs = z;
        this.oxt = System.currentTimeMillis();
    }

    public boolean efk() {
        if (this.ovh != null) {
            return this.ovh.efk();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oxr != null) {
            this.oxr.onDestroy();
            this.oxr = null;
        }
    }

    public int getWheatHeight() {
        return 0;
    }
}

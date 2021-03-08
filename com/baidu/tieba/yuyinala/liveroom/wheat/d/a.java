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
/* loaded from: classes10.dex */
public abstract class a {
    public boolean baw;
    protected ab bzn;
    private long czn;
    public Activity mActivity;
    private Rect mRect;
    public TbPageContext oIJ;
    private com.baidu.tieba.yuyinala.player.b oJA;
    private AlaLiveRoomBlurPageLayout oJy;
    public List<AlaWheatInfoData> oLK = new ArrayList();
    public List<AlaWheatInfoData> oLL = new ArrayList();
    public List<AlaWheatInfoData> oLM = new ArrayList();
    public List<AlaWheatInfoData> oLN = new ArrayList();
    public List<AlaWheatInfoData> oLO = new ArrayList();
    public List<AlaWheatInfoData> oLP = new ArrayList();
    public Set<String> oLQ = new HashSet();
    private boolean oLR;
    public int oLS;
    private boolean oLT;
    public boolean oLU;
    private l oLV;
    private boolean oLW;
    public BaseWheatLayout oLX;

    public abstract void Mn();

    public abstract View eeR();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oIJ = tbPageContext;
        this.oJy = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eeS();
    }

    private void initData() {
        this.oLK.clear();
        this.oLL.clear();
        this.oLM.clear();
        this.oLN.clear();
        this.oLO.clear();
        this.oLP.clear();
        this.oLQ.clear();
        this.oLR = false;
        this.oLS = 0;
        this.oLT = false;
        this.oLU = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().aA(this.mActivity);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup edW() {
        return this.oLX;
    }

    public void initView() {
        this.oJy.f(eeR(), k(this.mRect));
    }

    public void eeS() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().aA(this.mActivity);
        this.oLX.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.oLS = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? h.oIP : h.oIQ);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Yq() {
        return this.oLK;
    }

    public List<AlaWheatInfoData> Yp() {
        return this.oLL;
    }

    public List<AlaWheatInfoData> edX() {
        return this.oLO;
    }

    public boolean edY() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            return false;
        }
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        return (TextUtils.isEmpty(encryptionUserId) || Yn() || !iP(encryptionUserId)) ? false : true;
    }

    public boolean Yn() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return iO(ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iO(String str) {
        return (this.bzn == null || this.bzn.mLiveInfo == null || str == null || !TextUtils.equals(str, this.bzn.mLiveInfo.user_uk)) ? false : true;
    }

    public boolean Wm(String str) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return TextUtils.equals(str, ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()));
        }
        return false;
    }

    public boolean iN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (iP(str)) {
            return true;
        }
        return WK(str);
    }

    public boolean iP(String str) {
        List<AlaWheatInfoData> Yq = Yq();
        for (int i = 0; i < ListUtils.getCount(Yq); i++) {
            AlaWheatInfoData alaWheatInfoData = Yq.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public boolean WK(String str) {
        List<AlaWheatInfoData> Yp = Yp();
        for (int i = 0; i < ListUtils.getCount(Yp); i++) {
            AlaWheatInfoData alaWheatInfoData = Yp.get(i);
            if (alaWheatInfoData != null && TextUtils.equals(str, alaWheatInfoData.uk)) {
                return true;
            }
        }
        return false;
    }

    public AlaWheatInfoData iQ(String str) {
        return bi(str, true);
    }

    public AlaWheatInfoData bi(String str, boolean z) {
        AlaWheatInfoData alaWheatInfoData;
        AlaWheatInfoData alaWheatInfoData2;
        int i = 0;
        while (true) {
            if (i >= ListUtils.getCount(this.oLK)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oLK.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oLL); i2++) {
                alaWheatInfoData2 = this.oLL.get(i2);
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

    public AlaWheatInfoData WS(String str) {
        if (this.oLX != null) {
            return this.oLX.iQ(str);
        }
        return null;
    }

    public AlaWheatInfoData Yo() {
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        if (Yt == null || Yt.mLiveInfo == null) {
            return null;
        }
        AlaWheatInfoData alaWheatInfoData = new AlaWheatInfoData();
        alaWheatInfoData.uk = Yt.mLiveInfo.user_uk;
        alaWheatInfoData.userName = Yt.mLiveInfo.user_name;
        alaWheatInfoData.portrait = Yt.mLiveInfo.user_avatar;
        return alaWheatInfoData;
    }

    public boolean isApplying() {
        return this.oLR;
    }

    public void Ae(boolean z) {
        this.oLR = z;
    }

    public void aT(String str, String str2, String str3) {
        if (this.oLX != null && !eec()) {
            this.oLX.aT(str, str2, str3);
        }
    }

    public void WT(String str) {
        if (this.oLX != null) {
            this.oLX.WT(str);
        }
    }

    public void WU(String str) {
        if (this.oLX != null) {
            this.oLX.WU(str);
        }
    }

    public synchronized void eeT() {
        if (this.oLX != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    Mn();
                } else {
                    this.oLX.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.Mn();
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
        if (abVar != null && abVar.aKy != null) {
            this.bzn = abVar;
            q.edU().Ae(abVar.aKy.isApplying());
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
                }
            }, 100L);
            if (this.oLW) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.czn > 100 && currentTimeMillis - this.czn < 5000) {
                    if (iN(g.Ys())) {
                        if (Yn()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.oLW = false;
                    }
                } else {
                    this.oLW = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oLQ != null) {
            if (z) {
                if (!this.oLQ.contains(str)) {
                    this.oLQ.add(str);
                    return;
                }
                return;
            }
            this.oLQ.remove(str);
        }
    }

    public boolean iR(String str) {
        return this.oLQ != null && this.oLQ.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.oLX != null) {
            this.oLX.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.oLX != null) {
            this.oLX.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext eea() {
        return this.oIJ;
    }

    public boolean eeU() {
        return this.oLT;
    }

    public void Af(boolean z) {
        this.oLT = z;
    }

    public int edZ() {
        return this.oLS;
    }

    private void eeV() {
        if (Yn() && this.bzn != null && this.bzn.mLiveInfo != null && this.bzn.mLiveInfo.apply_count > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.bzn.mLiveInfo.apply_count);
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
        this.bzn = abVar;
        this.baw = true;
        ar(abVar);
        eeV();
        if ((abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) && this.oLX != null && this.oLX.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void Au() {
        this.oLK.clear();
        this.oLL.clear();
        this.oLM.clear();
        this.oLN.clear();
        this.oLO.clear();
        this.oLP.clear();
        this.oLQ.clear();
        this.oLR = false;
        this.oLS = 0;
        this.oLT = false;
        this.oLU = false;
        setVisible(false);
    }

    public void F(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oLU = false;
        this.oLK.clear();
        this.oLL.clear();
        this.oLM.clear();
        this.oLN.clear();
        this.oLO.clear();
        this.oLP.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oLN.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oLO.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oLP.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oLU = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oLK.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oLU = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oLL.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oLU = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oLM.add(alaWheatInfoData3);
                }
            }
        }
        eeT();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (eeU()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.baw = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.baw + "  havePersonOnWheat:" + this.oLU + "  isOnWheat(getCurrentUserUK())" + iN(g.Ys()));
        }
        if (!this.baw && this.oLU && !iN(g.Ys()) && !Yn()) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b edb = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
                StringBuilder append = new StringBuilder().append("am != null").append(edb != null).append("  am.isPlayerPlaying():");
                if (edb == null || edb.ecL()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (edb != null && !edb.ecL()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oLV == null) {
                        this.oLV = new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oGf) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && edb != null) {
                                    edb.ecT();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oLV.request();
                } else if (edb != null) {
                    edb.ecT();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new com.baidu.tieba.yuyinala.liveroom.data.e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oJA = bVar;
    }

    public void Ag(boolean z) {
        this.oLW = z;
        this.czn = System.currentTimeMillis();
    }

    public boolean eec() {
        if (this.oJA != null) {
            return this.oJA.eec();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oLV != null) {
            this.oLV.onDestroy();
            this.oLV = null;
        }
    }

    public int getWheatHeight() {
        if (this.oLX != null) {
            return this.oLX.getWheatHeight();
        }
        return 0;
    }
}

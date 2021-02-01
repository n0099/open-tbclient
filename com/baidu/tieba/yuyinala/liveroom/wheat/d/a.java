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
    private AlaLiveRoomBlurPageLayout oGT;
    private com.baidu.tieba.yuyinala.player.b oGV;
    public TbPageContext oGe;
    public List<AlaWheatInfoData> oJf = new ArrayList();
    public List<AlaWheatInfoData> oJg = new ArrayList();
    public List<AlaWheatInfoData> oJh = new ArrayList();
    public List<AlaWheatInfoData> oJi = new ArrayList();
    public List<AlaWheatInfoData> oJj = new ArrayList();
    public List<AlaWheatInfoData> oJk = new ArrayList();
    public Set<String> oJl = new HashSet();
    private boolean oJm;
    public int oJn;
    private boolean oJo;
    public boolean oJp;
    private l oJq;
    private boolean oJr;
    public BaseWheatLayout oJs;

    public abstract void Mk();

    public abstract View eeB();

    public void a(TbPageContext tbPageContext, AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, Rect rect) {
        this.mActivity = tbPageContext.getPageActivity();
        this.oGe = tbPageContext;
        this.oGT = alaLiveRoomBlurPageLayout;
        this.mRect = rect;
        initData();
        initView();
        eeC();
    }

    private void initData() {
        this.oJf.clear();
        this.oJg.clear();
        this.oJh.clear();
        this.oJi.clear();
        this.oJj.clear();
        this.oJk.clear();
        this.oJl.clear();
        this.oJm = false;
        this.oJn = 0;
        this.oJo = false;
        this.oJp = false;
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().az(this.mActivity);
    }

    public ViewGroup.LayoutParams k(Rect rect) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        return layoutParams;
    }

    public ViewGroup edG() {
        return this.oJs;
    }

    public void initView() {
        this.oGT.f(eeB(), k(this.mRect));
    }

    public void eeC() {
        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().az(this.mActivity);
        this.oJs.setOnItemClickListener(new BaseWheatLayout.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.a
            public void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i) {
                a.this.oJn = i;
                a.this.a(alaWheatInfoData, z ? 0 : i + 1, z ? h.oGk : h.oGl);
            }
        });
    }

    public void loadData() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
    }

    public List<AlaWheatInfoData> Yn() {
        return this.oJf;
    }

    public List<AlaWheatInfoData> Ym() {
        return this.oJg;
    }

    public List<AlaWheatInfoData> edH() {
        return this.oJj;
    }

    public boolean edI() {
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

    public boolean VT(String str) {
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
        return Wr(str);
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

    public boolean Wr(String str) {
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
            if (i >= ListUtils.getCount(this.oJf)) {
                alaWheatInfoData = null;
                break;
            }
            AlaWheatInfoData alaWheatInfoData3 = this.oJf.get(i);
            if (str != null && alaWheatInfoData3 != null && str.equals(alaWheatInfoData3.uk)) {
                alaWheatInfoData = alaWheatInfoData3;
                break;
            }
            i++;
        }
        if (alaWheatInfoData == null) {
            for (int i2 = 0; i2 < ListUtils.getCount(this.oJg); i2++) {
                alaWheatInfoData2 = this.oJg.get(i2);
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

    public AlaWheatInfoData Wz(String str) {
        if (this.oJs != null) {
            return this.oJs.iK(str);
        }
        return null;
    }

    public AlaWheatInfoData Yl() {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
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
        return this.oJm;
    }

    public void Af(boolean z) {
        this.oJm = z;
    }

    public void aT(String str, String str2, String str3) {
        if (this.oJs != null && !edM()) {
            this.oJs.aT(str, str2, str3);
        }
    }

    public void WA(String str) {
        if (this.oJs != null) {
            this.oJs.WA(str);
        }
    }

    public void WB(String str) {
        if (this.oJs != null) {
            this.oJs.WB(str);
        }
    }

    public synchronized void eeD() {
        if (this.oJs != null) {
            try {
                if (BdUtilHelper.isMainThread()) {
                    Mk();
                } else {
                    this.oJs.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.2
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
            q.edE().Af(abVar.aIY.isApplying());
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.3
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501074));
                }
            }, 100L);
            if (this.oJr) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cxN > 100 && currentTimeMillis - this.cxN < 5000) {
                    if (iH(g.Yp())) {
                        if (Yk()) {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_host_5", true);
                        } else {
                            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("connection_wheat_succ_anchor_8", false);
                        }
                        this.oJr = false;
                    }
                } else {
                    this.oJr = false;
                }
            }
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
                com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
            }
        }
    }

    public void G(String str, boolean z) {
        if (this.oJl != null) {
            if (z) {
                if (!this.oJl.contains(str)) {
                    this.oJl.add(str);
                    return;
                }
                return;
            }
            this.oJl.remove(str);
        }
    }

    public boolean iL(String str) {
        return this.oJl != null && this.oJl.contains(str);
    }

    public void setMaskBg(boolean z) {
        if (this.oJs != null) {
            this.oJs.setMaskBg(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.oJs != null) {
            this.oJs.setVisibility(z ? 0 : 8);
        }
    }

    public TbPageContext edK() {
        return this.oGe;
    }

    public boolean eeE() {
        return this.oJo;
    }

    public void Ag(boolean z) {
        this.oJo = z;
    }

    public int edJ() {
        return this.oJn;
    }

    private void eeF() {
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
        eeF();
        if ((abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) && this.oJs != null && this.oJs.getVisibility() != 0) {
            setVisible(true);
        }
    }

    public void Ar() {
        this.oJf.clear();
        this.oJg.clear();
        this.oJh.clear();
        this.oJi.clear();
        this.oJj.clear();
        this.oJk.clear();
        this.oJl.clear();
        this.oJm = false;
        this.oJn = 0;
        this.oJo = false;
        this.oJp = false;
        setVisible(false);
    }

    public void G(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        c(list, list2, null);
    }

    public void c(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3) {
        this.oJp = false;
        this.oJf.clear();
        this.oJg.clear();
        this.oJh.clear();
        this.oJi.clear();
        this.oJj.clear();
        this.oJk.clear();
        if (!ListUtils.isEmpty(list)) {
            this.oJi.addAll(list);
        }
        if (!ListUtils.isEmpty(list2)) {
            this.oJj.addAll(list2);
        }
        if (!ListUtils.isEmpty(list3)) {
            this.oJk.addAll(list3);
        }
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                AlaWheatInfoData alaWheatInfoData = list.get(i);
                if (alaWheatInfoData != null) {
                    this.oJp = true;
                    alaWheatInfoData.realWheatPosition = i;
                    this.oJf.add(alaWheatInfoData);
                }
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                AlaWheatInfoData alaWheatInfoData2 = list2.get(i2);
                if (alaWheatInfoData2 != null) {
                    this.oJp = true;
                    alaWheatInfoData2.realWheatPosition = i2 + 1;
                    this.oJg.add(alaWheatInfoData2);
                }
            }
        }
        if (!ListUtils.isEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                AlaWheatInfoData alaWheatInfoData3 = list3.get(i3);
                if (alaWheatInfoData3 != null) {
                    this.oJp = true;
                    alaWheatInfoData3.realWheatPosition = i3 + 1;
                    this.oJh.add(alaWheatInfoData3);
                }
            }
        }
        eeD();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501081));
        if (eeE()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501068));
        }
        startPlayer();
        this.aYV = false;
    }

    private void startPlayer() {
        boolean z = true;
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
            Log.i("AudioRoom", "isFirstEnterLiveRoom" + this.aYV + "  havePersonOnWheat:" + this.oJp + "  isOnWheat(getCurrentUserUK())" + iH(g.Yp()));
        }
        if (!this.aYV && this.oJp && !iH(g.Yp()) && !Yk()) {
            final com.baidu.tieba.yuyinala.liveroom.wheat.a.b ecL = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
                StringBuilder append = new StringBuilder().append("am != null").append(ecL != null).append("  am.isPlayerPlaying():");
                if (ecL == null || ecL.ecv()) {
                    z = false;
                }
                Log.i("AudioRoom", append.append(z).toString());
            }
            if (ecL != null && !ecL.ecv()) {
                if (TbadkCoreApplication.isLogin()) {
                    if (this.oJq == null) {
                        this.oJq = new l(null, new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.a.4
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void a(AlaOnLineHttpResponseMessage alaOnLineHttpResponseMessage) {
                                if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oDA) {
                                    Log.i("AudioRoom", "resp.isSuccess()" + alaOnLineHttpResponseMessage.isSuccess() + "  resp.isOnline():" + alaOnLineHttpResponseMessage.isOnline());
                                }
                                if (alaOnLineHttpResponseMessage.isSuccess() && !alaOnLineHttpResponseMessage.isOnline() && ecL != null) {
                                    ecL.ecD();
                                }
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.l.a
                            public void onFail(int i, String str) {
                            }
                        });
                    }
                    this.oJq.request();
                } else if (ecL != null) {
                    ecL.ecD();
                }
            }
        }
    }

    public void a(AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501010, new com.baidu.tieba.yuyinala.liveroom.data.e(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq(), alaWheatInfoData, i2, i)));
    }

    public void a(com.baidu.tieba.yuyinala.player.b bVar) {
        this.oGV = bVar;
    }

    public void Ah(boolean z) {
        this.oJr = z;
        this.cxN = System.currentTimeMillis();
    }

    public boolean edM() {
        if (this.oGV != null) {
            return this.oGV.edM();
        }
        return false;
    }

    public void onDestroy() {
        if (this.oJq != null) {
            this.oJq.onDestroy();
            this.oJq = null;
        }
    }

    public int getWheatHeight() {
        if (this.oJs != null) {
            return this.oJs.getWheatHeight();
        }
        return 0;
    }
}

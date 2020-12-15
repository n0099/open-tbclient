package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.yuyinala.charm.charmrank.b;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int gDF;
    private String mLiveId;
    private int mUserType;
    private String ohF;
    private YuyinCharmRankTotalActivity ojg;
    private c ojw;
    private b ojx;
    b.a ojy = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(i iVar) {
            if (d.this.ojw != null) {
                if (iVar == null) {
                    d.this.ojw.dG(true);
                    return;
                }
                d.this.ojw.Yb();
                d.this.ojw.gx(iVar.aIZ);
                int size = iVar.aIZ.size();
                if (size > 0) {
                    i.a aVar = iVar.aIY;
                    aVar.by(iVar.aIZ.size() == 1);
                    for (int i = 0; i < iVar.aIZ.size(); i++) {
                        if (iVar.aIZ.get(i).rank == 100) {
                            aVar.aL(iVar.aIZ.get(i).aJg);
                        }
                    }
                    if (d.this.ojw != null) {
                        d.this.ojw.b(aVar);
                    }
                    boolean jv = com.baidu.live.ap.b.YX().jv(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && jv)) && d.this.gDF == 0 && d.this.ojw != null) {
                        d.this.ojw.Nl(iVar.aIX);
                    }
                }
                if (size <= 0) {
                    d.this.ojw.dG(true);
                    if (d.this.ojw != null) {
                        i.a aVar2 = new i.a();
                        aVar2.aJb = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.ojw.b(aVar2);
                    }
                } else if (size < 100) {
                    d.this.ojw.Hm(d.this.ojg.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    d.this.ojw.Hm(d.this.ojg.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void t(int i, String str) {
            if (d.this.ojw != null) {
                d.this.ojw.dG(false);
                d.this.ojw.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.loadData();
                        } else {
                            d.this.ojg.getPageContext().showToast(d.this.ojg.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ojg = yuyinCharmRankTotalActivity;
        this.gDF = i;
        this.ohF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.ojw = new c(this.ojg, this.gDF, this.ohF, this.mLiveId, this.mUserType);
        loadData();
    }

    public void loadData() {
        if (this.ojx == null) {
            this.ojx = new b(this.ojg.getPageContext(), this.ojy);
        }
        if (this.gDF == 0) {
            this.ojx.gM("contribution", this.ohF);
        } else {
            this.ojx.gM(SdkStaticKeys.RANK_TYPE_CHARM, this.ohF);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ojw == null) {
            return null;
        }
        return this.ojw.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gDF == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.ojx != null) {
            this.ojx.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.yuyinala.charm.charmrank.b;
/* loaded from: classes10.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int gPo;
    private String mLiveId;
    private int mUserType;
    private String orf;
    private YuyinCharmRankTotalActivity osK;
    private c otc;
    private b otd;
    b.a ote = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.otc != null) {
                d.this.otc.ir(false);
                if (jVar == null) {
                    d.this.otc.dQ(true);
                    d.this.otc.zQ(false);
                    return;
                }
                d.this.otc.Xc();
                d.this.otc.gn(jVar.aHX);
                int size = jVar.aHX.size();
                if (size > 0) {
                    j.a aVar = jVar.aHW;
                    aVar.bt(jVar.aHX.size() == 1);
                    for (int i = 0; i < jVar.aHX.size(); i++) {
                        if (jVar.aHX.get(i).rank == 100) {
                            aVar.aM(jVar.aHX.get(i).aIe);
                        }
                    }
                    if (d.this.otc != null) {
                        d.this.otc.b(aVar);
                    }
                    boolean iP = com.baidu.live.ao.a.Ym().iP(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && iP)) && d.this.gPo == 0 && d.this.otc != null) {
                        d.this.otc.LP(jVar.aHV);
                    }
                }
                if (size <= 0) {
                    d.this.otc.dQ(true);
                    d.this.otc.zQ(false);
                    if (d.this.otc != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aHZ = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.otc.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.otc.GJ(d.this.osK.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.Cp(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void A(int i, String str) {
            if (d.this.otc != null) {
                d.this.otc.ir(false);
                d.this.otc.dQ(false);
                d.this.otc.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mH(true);
                        } else {
                            d.this.osK.getPageContext().showToast(d.this.osK.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.osK = yuyinCharmRankTotalActivity;
        this.gPo = i;
        this.orf = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.otc = new c(this.osK, this.gPo, this.orf, this.mLiveId, this.mUserType);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.otd == null) {
            this.otd = new b(this.osK.getPageContext(), this.ote);
        }
        if (this.gPo == 0) {
            this.otd.gQ("contribution", this.orf);
        } else {
            this.otd.gQ(SdkStaticKeys.RANK_TYPE_CHARM, this.orf);
        }
        if (this.otc != null) {
            this.otc.ir(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(final int i) {
        if (this.otc != null && this.otc.getListView() != null) {
            this.otc.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.otc.getListView().getHeight() < d.this.osK.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.otc.GJ(d.this.osK.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.otc == null) {
            return null;
        }
        return this.otc.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gPo == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.otd != null) {
            this.otd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

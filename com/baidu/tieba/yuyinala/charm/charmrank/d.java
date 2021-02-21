package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.yuyinala.charm.charmrank.b;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int gNF;
    private String mLiveId;
    private int mUserType;
    private String ooZ;
    private YuyinCharmRankTotalActivity oqE;
    private c oqW;
    private b oqX;
    b.a oqY = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.oqW != null) {
                d.this.oqW.ir(false);
                if (jVar == null) {
                    d.this.oqW.dQ(true);
                    d.this.oqW.zR(false);
                    return;
                }
                d.this.oqW.WZ();
                d.this.oqW.gn(jVar.aGx);
                int size = jVar.aGx.size();
                if (size > 0) {
                    j.a aVar = jVar.aGw;
                    aVar.bt(jVar.aGx.size() == 1);
                    for (int i = 0; i < jVar.aGx.size(); i++) {
                        if (jVar.aGx.get(i).rank == 100) {
                            aVar.aM(jVar.aGx.get(i).aGE);
                        }
                    }
                    if (d.this.oqW != null) {
                        d.this.oqW.b(aVar);
                    }
                    boolean iJ = com.baidu.live.ao.a.Yj().iJ(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && iJ)) && d.this.gNF == 0 && d.this.oqW != null) {
                        d.this.oqW.LL(jVar.aGv);
                    }
                }
                if (size <= 0) {
                    d.this.oqW.dQ(true);
                    d.this.oqW.zR(false);
                    if (d.this.oqW != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aGz = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.oqW.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.oqW.GA(d.this.oqE.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.Cm(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void A(int i, String str) {
            if (d.this.oqW != null) {
                d.this.oqW.ir(false);
                d.this.oqW.dQ(false);
                d.this.oqW.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mH(true);
                        } else {
                            d.this.oqE.getPageContext().showToast(d.this.oqE.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.oqE = yuyinCharmRankTotalActivity;
        this.gNF = i;
        this.ooZ = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.oqW = new c(this.oqE, this.gNF, this.ooZ, this.mLiveId, this.mUserType);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.oqX == null) {
            this.oqX = new b(this.oqE.getPageContext(), this.oqY);
        }
        if (this.gNF == 0) {
            this.oqX.gQ("contribution", this.ooZ);
        } else {
            this.oqX.gQ(SdkStaticKeys.RANK_TYPE_CHARM, this.ooZ);
        }
        if (this.oqW != null) {
            this.oqW.ir(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cm(final int i) {
        if (this.oqW != null && this.oqW.getListView() != null) {
            this.oqW.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oqW.getListView().getHeight() < d.this.oqE.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.oqW.GA(d.this.oqE.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oqW == null) {
            return null;
        }
        return this.oqW.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gNF == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.oqX != null) {
            this.oqX.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

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
    private int guU;
    private String mLiveId;
    private int mUserType;
    private String nSF;
    private YuyinCharmRankTotalActivity nUg;
    private c nUw;
    private b nUx;
    b.a nUy = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(i iVar) {
            if (d.this.nUw != null) {
                if (iVar == null) {
                    d.this.nUw.ds(true);
                    return;
                }
                d.this.nUw.VB();
                d.this.nUw.gj(iVar.aGq);
                int size = iVar.aGq.size();
                if (size > 0) {
                    i.a aVar = iVar.aGp;
                    aVar.bq(iVar.aGq.size() == 1);
                    for (int i = 0; i < iVar.aGq.size(); i++) {
                        if (iVar.aGq.get(i).rank == 100) {
                            aVar.an(iVar.aGq.get(i).point);
                        }
                    }
                    if (d.this.nUw != null) {
                        d.this.nUw.b(aVar);
                    }
                    boolean iR = com.baidu.live.al.b.Wy().iR(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && iR)) && d.this.guU == 0 && d.this.nUw != null) {
                        d.this.nUw.Mt(iVar.aGo);
                    }
                }
                if (size <= 0) {
                    d.this.nUw.ds(true);
                    if (d.this.nUw != null) {
                        i.a aVar2 = new i.a();
                        aVar2.aGs = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.nUw.b(aVar2);
                    }
                } else if (size < 100) {
                    d.this.nUw.Gy(d.this.nUg.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    d.this.nUw.Gy(d.this.nUg.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void t(int i, String str) {
            if (d.this.nUw != null) {
                d.this.nUw.ds(false);
                d.this.nUw.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.loadData();
                        } else {
                            d.this.nUg.getPageContext().showToast(d.this.nUg.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nUg = yuyinCharmRankTotalActivity;
        this.guU = i;
        this.nSF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.nUw = new c(this.nUg, this.guU, this.nSF, this.mLiveId, this.mUserType);
        loadData();
    }

    public void loadData() {
        if (this.nUx == null) {
            this.nUx = new b(this.nUg.getPageContext(), this.nUy);
        }
        if (this.guU == 0) {
            this.nUx.gH("contribution", this.nSF);
        } else {
            this.nUx.gH(SdkStaticKeys.RANK_TYPE_CHARM, this.nSF);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nUw == null) {
            return null;
        }
        return this.nUw.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.guU == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.nUx != null) {
            this.nUx.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

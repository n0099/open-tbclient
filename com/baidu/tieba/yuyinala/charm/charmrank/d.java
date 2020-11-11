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
    private int gvn;
    private String mLiveId;
    private int mUserType;
    private String nRc;
    private YuyinCharmRankTotalActivity nSD;
    private c nST;
    private b nSU;
    b.a nSV = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(i iVar) {
            if (d.this.nST != null) {
                if (iVar == null) {
                    d.this.nST.dq(true);
                    return;
                }
                d.this.nST.Wk();
                d.this.nST.gj(iVar.aIb);
                int size = iVar.aIb.size();
                if (size > 0) {
                    i.a aVar = iVar.aIa;
                    aVar.bo(iVar.aIb.size() == 1);
                    for (int i = 0; i < iVar.aIb.size(); i++) {
                        if (iVar.aIb.get(i).rank == 100) {
                            aVar.an(iVar.aIb.get(i).point);
                        }
                    }
                    if (d.this.nST != null) {
                        d.this.nST.b(aVar);
                    }
                    boolean iX = com.baidu.live.al.b.Xh().iX(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && iX)) && d.this.gvn == 0 && d.this.nST != null) {
                        d.this.nST.LQ(iVar.aHZ);
                    }
                }
                if (size <= 0) {
                    d.this.nST.dq(true);
                    if (d.this.nST != null) {
                        i.a aVar2 = new i.a();
                        aVar2.aId = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.nST.b(aVar2);
                    }
                } else if (size < 100) {
                    d.this.nST.GX(d.this.nSD.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    d.this.nST.GX(d.this.nSD.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void t(int i, String str) {
            if (d.this.nST != null) {
                d.this.nST.dq(false);
                d.this.nST.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.loadData();
                        } else {
                            d.this.nSD.getPageContext().showToast(d.this.nSD.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nSD = yuyinCharmRankTotalActivity;
        this.gvn = i;
        this.nRc = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.nST = new c(this.nSD, this.gvn, this.nRc, this.mLiveId, this.mUserType);
        loadData();
    }

    public void loadData() {
        if (this.nSU == null) {
            this.nSU = new b(this.nSD.getPageContext(), this.nSV);
        }
        if (this.gvn == 0) {
            this.nSU.gH("contribution", this.nRc);
        } else {
            this.nSU.gH(SdkStaticKeys.RANK_TYPE_CHARM, this.nRc);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nST == null) {
            return null;
        }
        return this.nST.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gvn == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.nSU != null) {
            this.nSU.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

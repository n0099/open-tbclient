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
    private int gpz;
    private String mLiveId;
    private int mUserType;
    private String nLi;
    private YuyinCharmRankTotalActivity nMJ;
    private c nMZ;
    private b nNa;
    b.a nNb = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(i iVar) {
            if (d.this.nMZ != null) {
                if (iVar == null) {
                    d.this.nMZ.dj(true);
                    return;
                }
                d.this.nMZ.TK();
                d.this.nMZ.gb(iVar.aHk);
                int size = iVar.aHk.size();
                if (size > 0) {
                    i.a aVar = iVar.aHj;
                    aVar.bn(iVar.aHk.size() == 1);
                    for (int i = 0; i < iVar.aHk.size(); i++) {
                        if (iVar.aHk.get(i).rank == 100) {
                            aVar.ab(iVar.aHk.get(i).point);
                        }
                    }
                    if (d.this.nMZ != null) {
                        d.this.nMZ.b(aVar);
                    }
                    boolean iK = com.baidu.live.aj.b.UH().iK(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && iK)) && d.this.gpz == 0 && d.this.nMZ != null) {
                        d.this.nMZ.LD(iVar.aHi);
                    }
                }
                if (size <= 0) {
                    d.this.nMZ.dj(true);
                    if (d.this.nMZ != null) {
                        i.a aVar2 = new i.a();
                        aVar2.aHm = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.nMZ.b(aVar2);
                    }
                } else if (size < 100) {
                    d.this.nMZ.GK(d.this.nMJ.getPageContext().getResources().getString(a.i.yuyin_charm_list_no_more));
                } else {
                    d.this.nMZ.GK(d.this.nMJ.getPageContext().getResources().getString(a.i.yuyin_charm_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void t(int i, String str) {
            if (d.this.nMZ != null) {
                d.this.nMZ.dj(false);
                d.this.nMZ.l(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.loadData();
                        } else {
                            d.this.nMJ.getPageContext().showToast(d.this.nMJ.getResources().getString(a.i.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.nMJ = yuyinCharmRankTotalActivity;
        this.gpz = i;
        this.nLi = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.nMZ = new c(this.nMJ, this.gpz, this.nLi, this.mLiveId, this.mUserType);
        loadData();
    }

    public void loadData() {
        if (this.nNa == null) {
            this.nNa = new b(this.nMJ.getPageContext(), this.nNb);
        }
        if (this.gpz == 0) {
            this.nNa.gH("contribution", this.nLi);
        } else {
            this.nNa.gH(SdkStaticKeys.RANK_TYPE_CHARM, this.nLi);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nMZ == null) {
            return null;
        }
        return this.nMZ.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gpz == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.nNa != null) {
            this.nNa.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

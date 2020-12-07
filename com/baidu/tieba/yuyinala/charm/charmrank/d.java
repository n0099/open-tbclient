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
    private int gDD;
    private String mLiveId;
    private int mUserType;
    private String ohD;
    private YuyinCharmRankTotalActivity oje;
    private c oju;
    private b ojv;
    b.a ojw = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(i iVar) {
            if (d.this.oju != null) {
                if (iVar == null) {
                    d.this.oju.dG(true);
                    return;
                }
                d.this.oju.Yb();
                d.this.oju.gx(iVar.aIZ);
                int size = iVar.aIZ.size();
                if (size > 0) {
                    i.a aVar = iVar.aIY;
                    aVar.by(iVar.aIZ.size() == 1);
                    for (int i = 0; i < iVar.aIZ.size(); i++) {
                        if (iVar.aIZ.get(i).rank == 100) {
                            aVar.aL(iVar.aIZ.get(i).aJg);
                        }
                    }
                    if (d.this.oju != null) {
                        d.this.oju.b(aVar);
                    }
                    boolean jv = com.baidu.live.ap.b.YX().jv(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                    if ((d.this.mUserType == 1 || (d.this.mUserType == 2 && jv)) && d.this.gDD == 0 && d.this.oju != null) {
                        d.this.oju.Nl(iVar.aIX);
                    }
                }
                if (size <= 0) {
                    d.this.oju.dG(true);
                    if (d.this.oju != null) {
                        i.a aVar2 = new i.a();
                        aVar2.aJb = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.oju.b(aVar2);
                    }
                } else if (size < 100) {
                    d.this.oju.Hm(d.this.oje.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    d.this.oju.Hm(d.this.oje.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void t(int i, String str) {
            if (d.this.oju != null) {
                d.this.oju.dG(false);
                d.this.oju.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.loadData();
                        } else {
                            d.this.oje.getPageContext().showToast(d.this.oje.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.oje = yuyinCharmRankTotalActivity;
        this.gDD = i;
        this.ohD = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.oju = new c(this.oje, this.gDD, this.ohD, this.mLiveId, this.mUserType);
        loadData();
    }

    public void loadData() {
        if (this.ojv == null) {
            this.ojv = new b(this.oje.getPageContext(), this.ojw);
        }
        if (this.gDD == 0) {
            this.ojv.gM("contribution", this.ohD);
        } else {
            this.ojv.gM(SdkStaticKeys.RANK_TYPE_CHARM, this.ohD);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oju == null) {
            return null;
        }
        return this.oju.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gDD == 0 ? "贡献榜" : "魅力榜";
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
        if (this.ojv != null) {
            this.ojv.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

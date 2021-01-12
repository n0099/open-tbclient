package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.yuyinala.charm.charmrank.b;
/* loaded from: classes10.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int gKL;
    private String mLiveId;
    private int mUserType;
    private String oeF;
    private c ogC;
    private b ogD;
    b.a ogE = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.ogC != null) {
                d.this.ogC.ip(false);
                if (jVar == null) {
                    d.this.ogC.dI(true);
                    d.this.ogC.zw(false);
                    return;
                }
                d.this.ogC.Vq();
                d.this.ogC.gp(jVar.aEK);
                int size = jVar.aEK.size();
                if (size > 0) {
                    j.a aVar = jVar.aEJ;
                    aVar.br(jVar.aEK.size() == 1);
                    for (int i = 0; i < jVar.aEK.size(); i++) {
                        if (jVar.aEK.get(i).rank == 100) {
                            aVar.aK(jVar.aEK.get(i).aER);
                        }
                    }
                    if (d.this.ogC != null) {
                        d.this.ogC.b(aVar);
                    }
                }
                if (size <= 0) {
                    d.this.ogC.dI(true);
                    d.this.ogC.zw(false);
                    if (d.this.ogC != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aEM = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.ogC.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.ogC.Ga(d.this.ogk.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.BV(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void w(int i, String str) {
            if (d.this.ogC != null) {
                d.this.ogC.ip(false);
                d.this.ogC.dI(false);
                d.this.ogC.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mD(true);
                        } else {
                            d.this.ogk.getPageContext().showToast(d.this.ogk.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };
    private YuyinCharmRankTotalActivity ogk;

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ogk = yuyinCharmRankTotalActivity;
        this.gKL = i;
        this.oeF = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.ogC = new c(this.ogk, this.gKL, this.oeF, this.mLiveId, this.mUserType);
        mD(true);
    }

    public void mD(boolean z) {
        if (this.ogD == null) {
            this.ogD = new b(this.ogk.getPageContext(), this.ogE);
        }
        if (this.gKL == 0) {
            this.ogD.gI("contribution", this.oeF);
        } else {
            this.ogD.gI(SdkStaticKeys.RANK_TYPE_CHARM, this.oeF);
        }
        if (this.ogC != null) {
            this.ogC.ip(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BV(final int i) {
        if (this.ogC != null && this.ogC.getListView() != null) {
            this.ogC.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ogC.getListView().getHeight() < d.this.ogk.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.ogC.Ga(d.this.ogk.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ogC == null) {
            return null;
        }
        return this.ogC.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gKL == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.ogD != null) {
            this.ogD.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

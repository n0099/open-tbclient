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
    private String oeG;
    private c ogD;
    private b ogE;
    b.a ogF = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.ogD != null) {
                d.this.ogD.ip(false);
                if (jVar == null) {
                    d.this.ogD.dI(true);
                    d.this.ogD.zw(false);
                    return;
                }
                d.this.ogD.Vq();
                d.this.ogD.gp(jVar.aEK);
                int size = jVar.aEK.size();
                if (size > 0) {
                    j.a aVar = jVar.aEJ;
                    aVar.br(jVar.aEK.size() == 1);
                    for (int i = 0; i < jVar.aEK.size(); i++) {
                        if (jVar.aEK.get(i).rank == 100) {
                            aVar.aK(jVar.aEK.get(i).aER);
                        }
                    }
                    if (d.this.ogD != null) {
                        d.this.ogD.b(aVar);
                    }
                }
                if (size <= 0) {
                    d.this.ogD.dI(true);
                    d.this.ogD.zw(false);
                    if (d.this.ogD != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aEM = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.ogD.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.ogD.Ga(d.this.ogl.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.BU(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void w(int i, String str) {
            if (d.this.ogD != null) {
                d.this.ogD.ip(false);
                d.this.ogD.dI(false);
                d.this.ogD.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mD(true);
                        } else {
                            d.this.ogl.getPageContext().showToast(d.this.ogl.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };
    private YuyinCharmRankTotalActivity ogl;

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.ogl = yuyinCharmRankTotalActivity;
        this.gKL = i;
        this.oeG = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.ogD = new c(this.ogl, this.gKL, this.oeG, this.mLiveId, this.mUserType);
        mD(true);
    }

    public void mD(boolean z) {
        if (this.ogE == null) {
            this.ogE = new b(this.ogl.getPageContext(), this.ogF);
        }
        if (this.gKL == 0) {
            this.ogE.gI("contribution", this.oeG);
        } else {
            this.ogE.gI(SdkStaticKeys.RANK_TYPE_CHARM, this.oeG);
        }
        if (this.ogD != null) {
            this.ogD.ip(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU(final int i) {
        if (this.ogD != null && this.ogD.getListView() != null) {
            this.ogD.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ogD.getListView().getHeight() < d.this.ogl.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.ogD.Ga(d.this.ogl.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ogD == null) {
            return null;
        }
        return this.ogD.getRootView();
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
        if (this.ogE != null) {
            this.ogE.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

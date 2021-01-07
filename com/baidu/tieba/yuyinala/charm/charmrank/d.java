package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.yuyinala.charm.charmrank.b;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int gPr;
    private String mLiveId;
    private int mUserType;
    private String ojl;
    private YuyinCharmRankTotalActivity okP;
    private c olh;
    private b oli;
    b.a olj = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.olh != null) {
                d.this.olh.it(false);
                if (jVar == null) {
                    d.this.olh.dM(true);
                    d.this.olh.zA(false);
                    return;
                }
                d.this.olh.Zj();
                d.this.olh.gp(jVar.aJx);
                int size = jVar.aJx.size();
                if (size > 0) {
                    j.a aVar = jVar.aJw;
                    aVar.bv(jVar.aJx.size() == 1);
                    for (int i = 0; i < jVar.aJx.size(); i++) {
                        if (jVar.aJx.get(i).rank == 100) {
                            aVar.aK(jVar.aJx.get(i).aJE);
                        }
                    }
                    if (d.this.olh != null) {
                        d.this.olh.b(aVar);
                    }
                }
                if (size <= 0) {
                    d.this.olh.dM(true);
                    d.this.olh.zA(false);
                    if (d.this.olh != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aJz = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.olh.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.olh.Hl(d.this.okP.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.DB(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void v(int i, String str) {
            if (d.this.olh != null) {
                d.this.olh.it(false);
                d.this.olh.dM(false);
                d.this.olh.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mH(true);
                        } else {
                            d.this.okP.getPageContext().showToast(d.this.okP.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.okP = yuyinCharmRankTotalActivity;
        this.gPr = i;
        this.ojl = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.olh = new c(this.okP, this.gPr, this.ojl, this.mLiveId, this.mUserType);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.oli == null) {
            this.oli = new b(this.okP.getPageContext(), this.olj);
        }
        if (this.gPr == 0) {
            this.oli.gJ("contribution", this.ojl);
        } else {
            this.oli.gJ(SdkStaticKeys.RANK_TYPE_CHARM, this.ojl);
        }
        if (this.olh != null) {
            this.olh.it(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DB(final int i) {
        if (this.olh != null && this.olh.getListView() != null) {
            this.olh.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.olh.getListView().getHeight() < d.this.okP.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.olh.Hl(d.this.okP.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.olh == null) {
            return null;
        }
        return this.olh.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gPr == 0 ? "贡献榜" : "魅力榜";
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        if (this.oli != null) {
            this.oli.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

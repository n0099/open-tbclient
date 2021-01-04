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
    private String ojm;
    private YuyinCharmRankTotalActivity okQ;
    private c oli;
    private b olj;
    b.a olk = new b.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1
        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void a(j jVar) {
            if (d.this.oli != null) {
                d.this.oli.it(false);
                if (jVar == null) {
                    d.this.oli.dM(true);
                    d.this.oli.zA(false);
                    return;
                }
                d.this.oli.Zi();
                d.this.oli.gp(jVar.aJx);
                int size = jVar.aJx.size();
                if (size > 0) {
                    j.a aVar = jVar.aJw;
                    aVar.bv(jVar.aJx.size() == 1);
                    for (int i = 0; i < jVar.aJx.size(); i++) {
                        if (jVar.aJx.get(i).rank == 100) {
                            aVar.aK(jVar.aJx.get(i).aJE);
                        }
                    }
                    if (d.this.oli != null) {
                        d.this.oli.b(aVar);
                    }
                }
                if (size <= 0) {
                    d.this.oli.dM(true);
                    d.this.oli.zA(false);
                    if (d.this.oli != null) {
                        j.a aVar2 = new j.a();
                        aVar2.aJz = 0L;
                        aVar2.bd_portrait = TbadkCoreApplication.getCurrentPortrait();
                        aVar2.user_name = TbadkCoreApplication.getCurrentAccountName();
                        d.this.oli.b(aVar2);
                    }
                } else if (size >= 100) {
                    d.this.oli.Hm(d.this.okQ.getPageContext().getResources().getString(a.h.yuyin_charm_show_100));
                }
                d.this.DB(size);
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.charmrank.b.a
        public void v(int i, String str) {
            if (d.this.oli != null) {
                d.this.oli.it(false);
                d.this.oli.dM(false);
                d.this.oli.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            d.this.mH(true);
                        } else {
                            d.this.okQ.getPageContext().showToast(d.this.okQ.getResources().getString(a.h.sdk_no_network_guide));
                        }
                    }
                });
            }
        }
    };

    public d(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, int i, String str, String str2, int i2) {
        this.okQ = yuyinCharmRankTotalActivity;
        this.gPr = i;
        this.ojm = str;
        this.mLiveId = str2;
        this.mUserType = i2;
    }

    public void createView() {
        this.oli = new c(this.okQ, this.gPr, this.ojm, this.mLiveId, this.mUserType);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.olj == null) {
            this.olj = new b(this.okQ.getPageContext(), this.olk);
        }
        if (this.gPr == 0) {
            this.olj.gJ("contribution", this.ojm);
        } else {
            this.olj.gJ(SdkStaticKeys.RANK_TYPE_CHARM, this.ojm);
        }
        if (this.oli != null) {
            this.oli.it(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DB(final int i) {
        if (this.oli != null && this.oli.getListView() != null) {
            this.oli.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.oli.getListView().getHeight() < d.this.okQ.getResources().getDimensionPixelSize(a.d.sdk_ds164) * i && i < 100) {
                        d.this.oli.Hm(d.this.okQ.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oli == null) {
            return null;
        }
        return this.oli.getRootView();
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
        if (this.olj != null) {
            this.olj.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

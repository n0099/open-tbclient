package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity opa;
    private e opn;
    private d opo;
    d.a opp = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.opn != null) {
                f.this.opn.dR(false);
                if (bVar == null) {
                    f.this.opn.dQ(true);
                    return;
                }
                f.this.opn.WZ();
                f.this.opn.gn(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.opn.dQ(true);
                } else if (size < 100) {
                    if (f.this.opn != null && f.this.opn.getListView() != null) {
                        f.this.opn.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.opn.getListView().getHeight() < f.this.opa.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.opn.Gz(f.this.opa.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.opn.Gz(f.this.opa.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void A(int i, String str) {
            if (f.this.opn != null) {
                f.this.opn.dQ(false);
                f.this.opn.dR(false);
                f.this.opn.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.opo != null) {
                                f.this.opo.Vx(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.opa.getPageContext().showToast(f.this.opa.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.opa = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.opn = new e(this.opa, this.mLiveId);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.opo == null) {
            this.opo = new d(this.opa.getPageContext(), this.opp);
        }
        this.opo.Vx(this.mLiveId);
        if (this.opn != null) {
            this.opn.dR(z);
        }
    }

    public f Vy(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.opn == null) {
            return null;
        }
        return this.opn.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.opa.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.opo != null) {
            this.opo.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

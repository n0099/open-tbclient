package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity opB;
    private e opO;
    private d opP;
    d.a opQ = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.opO != null) {
                f.this.opO.dR(false);
                if (bVar == null) {
                    f.this.opO.dQ(true);
                    return;
                }
                f.this.opO.WZ();
                f.this.opO.gn(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.opO.dQ(true);
                } else if (size < 100) {
                    if (f.this.opO != null && f.this.opO.getListView() != null) {
                        f.this.opO.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.opO.getListView().getHeight() < f.this.opB.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.opO.GA(f.this.opB.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.opO.GA(f.this.opB.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void A(int i, String str) {
            if (f.this.opO != null) {
                f.this.opO.dQ(false);
                f.this.opO.dR(false);
                f.this.opO.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.opP != null) {
                                f.this.opP.VJ(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.opB.getPageContext().showToast(f.this.opB.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.opB = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.opO = new e(this.opB, this.mLiveId);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.opP == null) {
            this.opP = new d(this.opB.getPageContext(), this.opQ);
        }
        this.opP.VJ(this.mLiveId);
        if (this.opO != null) {
            this.opO.dR(z);
        }
    }

    public f VK(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.opO == null) {
            return null;
        }
        return this.opO.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.opB.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.opP != null) {
            this.opP.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

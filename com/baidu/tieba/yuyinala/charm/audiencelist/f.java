package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity ojM;
    private e ojZ;
    private d oka;
    d.a okb = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.ojZ != null) {
                f.this.ojZ.dN(false);
                if (bVar == null) {
                    f.this.ojZ.dM(true);
                    return;
                }
                f.this.ojZ.Zj();
                f.this.ojZ.gp(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.ojZ.dM(true);
                } else if (size < 100) {
                    if (f.this.ojZ != null && f.this.ojZ.getListView() != null) {
                        f.this.ojZ.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.ojZ.getListView().getHeight() < f.this.ojM.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.ojZ.Hl(f.this.ojM.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.ojZ.Hl(f.this.ojM.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void v(int i, String str) {
            if (f.this.ojZ != null) {
                f.this.ojZ.dM(false);
                f.this.ojZ.dN(false);
                f.this.ojZ.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.oka != null) {
                                f.this.oka.VG(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.ojM.getPageContext().showToast(f.this.ojM.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ojM = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.ojZ = new e(this.ojM, this.mLiveId);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.oka == null) {
            this.oka = new d(this.ojM.getPageContext(), this.okb);
        }
        this.oka.VG(this.mLiveId);
        if (this.ojZ != null) {
            this.ojZ.dN(z);
        }
    }

    public f VH(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ojZ == null) {
            return null;
        }
        return this.ojZ.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ojM.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.oka != null) {
            this.oka.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

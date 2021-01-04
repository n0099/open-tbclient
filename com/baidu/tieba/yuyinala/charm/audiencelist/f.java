package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity ojN;
    private e oka;
    private d okb;
    d.a okc = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.oka != null) {
                f.this.oka.dN(false);
                if (bVar == null) {
                    f.this.oka.dM(true);
                    return;
                }
                f.this.oka.Zi();
                f.this.oka.gp(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.oka.dM(true);
                } else if (size < 100) {
                    if (f.this.oka != null && f.this.oka.getListView() != null) {
                        f.this.oka.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.oka.getListView().getHeight() < f.this.ojN.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.oka.Hm(f.this.ojN.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.oka.Hm(f.this.ojN.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void v(int i, String str) {
            if (f.this.oka != null) {
                f.this.oka.dM(false);
                f.this.oka.dN(false);
                f.this.oka.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.okb != null) {
                                f.this.okb.VH(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.ojN.getPageContext().showToast(f.this.ojN.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ojN = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.oka = new e(this.ojN, this.mLiveId);
        mH(true);
    }

    public void mH(boolean z) {
        if (this.okb == null) {
            this.okb = new d(this.ojN.getPageContext(), this.okc);
        }
        this.okb.VH(this.mLiveId);
        if (this.oka != null) {
            this.oka.dN(z);
        }
    }

    public f VI(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oka == null) {
            return null;
        }
        return this.oka.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ojN.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.okb != null) {
            this.okb.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

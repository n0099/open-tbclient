package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes10.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity ofi;
    private e ofv;
    private d ofw;
    d.a ofx = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.ofv != null) {
                f.this.ofv.dJ(false);
                if (bVar == null) {
                    f.this.ofv.dI(true);
                    return;
                }
                f.this.ofv.Vq();
                f.this.ofv.gp(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.ofv.dI(true);
                } else if (size < 100) {
                    if (f.this.ofv != null && f.this.ofv.getListView() != null) {
                        f.this.ofv.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.ofv.getListView().getHeight() < f.this.ofi.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.ofv.Ga(f.this.ofi.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.ofv.Ga(f.this.ofi.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void w(int i, String str) {
            if (f.this.ofv != null) {
                f.this.ofv.dI(false);
                f.this.ofv.dJ(false);
                f.this.ofv.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.ofw != null) {
                                f.this.ofw.Uz(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.ofi.getPageContext().showToast(f.this.ofi.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ofi = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.ofv = new e(this.ofi, this.mLiveId);
        mD(true);
    }

    public void mD(boolean z) {
        if (this.ofw == null) {
            this.ofw = new d(this.ofi.getPageContext(), this.ofx);
        }
        this.ofw.Uz(this.mLiveId);
        if (this.ofv != null) {
            this.ofv.dJ(z);
        }
    }

    public f UA(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ofv == null) {
            return null;
        }
        return this.ofv.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ofi.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.ofw != null) {
            this.ofw.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

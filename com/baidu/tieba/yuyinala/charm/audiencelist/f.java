package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes10.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity ofh;
    private e ofu;
    private d ofv;
    d.a ofw = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.ofu != null) {
                f.this.ofu.dJ(false);
                if (bVar == null) {
                    f.this.ofu.dI(true);
                    return;
                }
                f.this.ofu.Vq();
                f.this.ofu.gp(bVar.getList());
                final int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.ofu.dI(true);
                } else if (size < 100) {
                    if (f.this.ofu != null && f.this.ofu.getListView() != null) {
                        f.this.ofu.getListView().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (f.this.ofu.getListView().getHeight() < f.this.ofh.getResources().getDimensionPixelSize(a.d.sdk_ds144) * size) {
                                        f.this.ofu.Ga(f.this.ofh.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                } else {
                    f.this.ofu.Ga(f.this.ofh.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void w(int i, String str) {
            if (f.this.ofu != null) {
                f.this.ofu.dI(false);
                f.this.ofu.dJ(false);
                f.this.ofu.n(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.ofv != null) {
                                f.this.ofv.Uy(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.ofh.getPageContext().showToast(f.this.ofh.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.ofh = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.ofu = new e(this.ofh, this.mLiveId);
        mD(true);
    }

    public void mD(boolean z) {
        if (this.ofv == null) {
            this.ofv = new d(this.ofh.getPageContext(), this.ofw);
        }
        this.ofv.Uy(this.mLiveId);
        if (this.ofu != null) {
            this.ofu.dJ(z);
        }
    }

    public f Uz(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ofu == null) {
            return null;
        }
        return this.ofu.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.ofh.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.ofv != null) {
            this.ofv.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

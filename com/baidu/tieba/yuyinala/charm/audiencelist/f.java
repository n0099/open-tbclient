package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity oic;
    private e oio;
    private d oip;
    d.a oiq = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.oio != null) {
                f.this.oio.eZ(j);
                if (bVar == null) {
                    f.this.oio.dG(true);
                    return;
                }
                f.this.oio.Yb();
                f.this.oio.gx(bVar.getList());
                int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.oio.dG(true);
                } else if (size < 100) {
                    f.this.oio.Hm(f.this.oic.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    f.this.oio.Hm(f.this.oic.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void t(int i, String str) {
            if (f.this.oio != null) {
                f.this.oio.dG(false);
                f.this.oio.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.oip != null) {
                                f.this.oip.Wh(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.oic.getPageContext().showToast(f.this.oic.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.oic = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.oio = new e(this.oic, this.mLiveId);
        loadData();
    }

    public void loadData() {
        if (this.oip == null) {
            this.oip = new d(this.oic.getPageContext(), this.oiq);
        }
        this.oip.Wh(this.mLiveId);
    }

    public f Wi(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oio == null) {
            return null;
        }
        return this.oio.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.oic.getResources().getString(a.h.yuyin_audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        if (this.oip != null) {
            this.oip.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

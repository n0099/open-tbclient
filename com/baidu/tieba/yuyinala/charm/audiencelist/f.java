package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity oie;
    private e oiq;
    private d oir;
    d.a ois = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.oiq != null) {
                f.this.oiq.eZ(j);
                if (bVar == null) {
                    f.this.oiq.dG(true);
                    return;
                }
                f.this.oiq.Yb();
                f.this.oiq.gx(bVar.getList());
                int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.oiq.dG(true);
                } else if (size < 100) {
                    f.this.oiq.Hm(f.this.oie.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    f.this.oiq.Hm(f.this.oie.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void t(int i, String str) {
            if (f.this.oiq != null) {
                f.this.oiq.dG(false);
                f.this.oiq.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.oir != null) {
                                f.this.oir.Wh(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.oie.getPageContext().showToast(f.this.oie.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.oie = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.oiq = new e(this.oie, this.mLiveId);
        loadData();
    }

    public void loadData() {
        if (this.oir == null) {
            this.oir = new d(this.oie.getPageContext(), this.ois);
        }
        this.oir.Wh(this.mLiveId);
    }

    public f Wi(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.oiq == null) {
            return null;
        }
        return this.oiq.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.oie.getResources().getString(a.h.yuyin_audience_list_title);
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
        if (this.oir != null) {
            this.oir.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

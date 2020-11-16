package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity nTe;
    private e nTq;
    private d nTr;
    d.a nTs = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.nTq != null) {
                f.this.nTq.ew(j);
                if (bVar == null) {
                    f.this.nTq.ds(true);
                    return;
                }
                f.this.nTq.VB();
                f.this.nTq.gj(bVar.getList());
                int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.nTq.ds(true);
                } else if (size < 100) {
                    f.this.nTq.Gy(f.this.nTe.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    f.this.nTq.Gy(f.this.nTe.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void t(int i, String str) {
            if (f.this.nTq != null) {
                f.this.nTq.ds(false);
                f.this.nTq.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.nTr != null) {
                                f.this.nTr.US(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.nTe.getPageContext().showToast(f.this.nTe.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nTe = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.nTq = new e(this.nTe, this.mLiveId);
        loadData();
    }

    public void loadData() {
        if (this.nTr == null) {
            this.nTr = new d(this.nTe.getPageContext(), this.nTs);
        }
        this.nTr.US(this.mLiveId);
    }

    public f UT(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nTq == null) {
            return null;
        }
        return this.nTq.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.nTe.getResources().getString(a.h.yuyin_audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.nTr != null) {
            this.nTr.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

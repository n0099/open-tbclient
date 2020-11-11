package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity nRB;
    private e nRN;
    private d nRO;
    d.a nRP = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.nRN != null) {
                f.this.nRN.ew(j);
                if (bVar == null) {
                    f.this.nRN.dq(true);
                    return;
                }
                f.this.nRN.Wk();
                f.this.nRN.gj(bVar.getList());
                int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.nRN.dq(true);
                } else if (size < 100) {
                    f.this.nRN.GX(f.this.nRB.getPageContext().getResources().getString(a.h.yuyin_charm_list_no_more));
                } else {
                    f.this.nRN.GX(f.this.nRB.getPageContext().getResources().getString(a.h.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void t(int i, String str) {
            if (f.this.nRN != null) {
                f.this.nRN.dq(false);
                f.this.nRN.m(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.nRO != null) {
                                f.this.nRO.Vh(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.nRB.getPageContext().showToast(f.this.nRB.getResources().getString(a.h.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nRB = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.nRN = new e(this.nRB, this.mLiveId);
        loadData();
    }

    public void loadData() {
        if (this.nRO == null) {
            this.nRO = new d(this.nRB.getPageContext(), this.nRP);
        }
        this.nRO.Vh(this.mLiveId);
    }

    public f Vi(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nRN == null) {
            return null;
        }
        return this.nRN.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.nRB.getResources().getString(a.h.yuyin_audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        if (this.nRO != null) {
            this.nRO.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

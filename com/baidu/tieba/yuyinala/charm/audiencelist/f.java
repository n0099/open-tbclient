package com.baidu.tieba.yuyinala.charm.audiencelist;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.charm.audiencelist.d;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.liveroom.d.d {
    private String mLiveId;
    private YuyinALaAudiencesActivity nLH;
    private e nLT;
    private d nLU;
    d.a nLV = new d.a() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1
        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void a(long j, b bVar) {
            if (f.this.nLT != null) {
                f.this.nLT.ea(j);
                if (bVar == null) {
                    f.this.nLT.dj(true);
                    return;
                }
                f.this.nLT.TK();
                f.this.nLT.gb(bVar.getList());
                int size = bVar.getList().size();
                if (size <= 0) {
                    f.this.nLT.dj(true);
                } else if (size < 100) {
                    f.this.nLT.GK(f.this.nLH.getPageContext().getResources().getString(a.i.yuyin_charm_list_no_more));
                } else {
                    f.this.nLT.GK(f.this.nLH.getPageContext().getResources().getString(a.i.yuyin_online_show_100));
                }
            }
        }

        @Override // com.baidu.tieba.yuyinala.charm.audiencelist.d.a
        public void t(int i, String str) {
            if (f.this.nLT != null) {
                f.this.nLT.dj(false);
                f.this.nLT.l(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.audiencelist.f.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                            if (f.this.nLU != null) {
                                f.this.nLU.UQ(f.this.mLiveId);
                                return;
                            }
                            return;
                        }
                        f.this.nLH.getPageContext().showToast(f.this.nLH.getResources().getString(a.i.sdk_no_network_guide));
                    }
                });
            }
        }
    };

    public f(YuyinALaAudiencesActivity yuyinALaAudiencesActivity) {
        this.nLH = yuyinALaAudiencesActivity;
    }

    public void createView() {
        this.nLT = new e(this.nLH, this.mLiveId);
        loadData();
    }

    public void loadData() {
        if (this.nLU == null) {
            this.nLU = new d(this.nLH.getPageContext(), this.nLV);
        }
        this.nLU.UQ(this.mLiveId);
    }

    public f UR(String str) {
        this.mLiveId = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.nLT == null) {
            return null;
        }
        return this.nLT.getRootView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.nLH.getResources().getString(a.i.yuyin_audience_list_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        if (this.nLU != null) {
            this.nLU.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}

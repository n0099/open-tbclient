package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.x;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout;
/* loaded from: classes11.dex */
public class d extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View egf() {
        this.oEp = new TeamFightLayout(this.mActivity);
        this.oEp.setTbPageContext(this.oAe);
        return this.oEp;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void OH() {
        if (this.oEp != null) {
            this.oEp.a(this.oEe, this.oEf, this.bzc);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ar(x xVar) {
        super.ar(xVar);
        if (xVar != null && xVar.aLq != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aLq;
            H(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }

    public void setTeamFightProgressData(String str) {
        if (this.oEp != null && (this.oEp instanceof TeamFightLayout)) {
            ((TeamFightLayout) this.oEp).setTeamFightProgressData(str);
        }
    }
}

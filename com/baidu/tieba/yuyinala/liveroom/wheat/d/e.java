package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout;
/* loaded from: classes11.dex */
public class e extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View eeJ() {
        this.oJS = new TeamFightLayout(this.mActivity);
        this.oJS.setTbPageContext(this.oGE);
        return this.oJS;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void Mk() {
        if (this.oJS != null) {
            this.oJS.a(this.oJI, this.oJJ, this.bxN);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ar(ab abVar) {
        super.ar(abVar);
        if (abVar != null && abVar.aIY != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
            G(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }

    public void setTeamFightProgressData(String str) {
        if (this.oJS != null && (this.oJS instanceof TeamFightLayout)) {
            ((TeamFightLayout) this.oJS).setTeamFightProgressData(str);
        }
    }
}

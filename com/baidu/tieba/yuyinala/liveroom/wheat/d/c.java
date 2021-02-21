package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatDatingLayout;
/* loaded from: classes11.dex */
public class c extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View eeJ() {
        this.oJS = new WheatDatingLayout(this.mActivity);
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
            this.oJS.a(this.oJI, this.oJJ, this.oJK, this.bxN);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ar(ab abVar) {
        super.ar(abVar);
        if (abVar != null && abVar.aIY != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aIY;
            c(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists(), alaWheatInfoDataWrapper.getXiangqinLists());
        }
    }
}

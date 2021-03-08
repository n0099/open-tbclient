package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatLayout;
/* loaded from: classes10.dex */
public class d extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View eeR() {
        this.oLX = new SingleWheatLayout(this.mActivity);
        this.oLX.setTbPageContext(this.oIJ);
        return this.oLX;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void Mn() {
        if (this.oLX != null) {
            this.oLX.a(this.oLN, this.oLO, this.bzn);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ar(ab abVar) {
        super.ar(abVar);
        if (abVar != null && abVar.aKy != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = abVar.aKy;
            F(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }
}

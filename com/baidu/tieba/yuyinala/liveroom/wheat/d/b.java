package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.x;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout;
/* loaded from: classes10.dex */
public class b extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View ecn() {
        this.ozL = new WheatCommonLayout(this.mActivity);
        this.ozL.setTbPageContext(this.ovA);
        return this.ozL;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void KM() {
        if (this.ozL != null) {
            this.ozL.a(this.ozA, this.ozB, this.buq);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void ar(x xVar) {
        super.ar(xVar);
        if (xVar != null && xVar.aGD != null) {
            AlaWheatInfoDataWrapper alaWheatInfoDataWrapper = xVar.aGD;
            H(alaWheatInfoDataWrapper.getHostWheatLists(), alaWheatInfoDataWrapper.getAnchorWheatLists());
        }
    }
}

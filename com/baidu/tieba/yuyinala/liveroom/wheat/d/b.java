package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.x;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout;
/* loaded from: classes10.dex */
public class b extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View ecn() {
        this.ozK = new WheatCommonLayout(this.mActivity);
        this.ozK.setTbPageContext(this.ovz);
        return this.ozK;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void KM() {
        if (this.ozK != null) {
            this.ozK.a(this.ozz, this.ozA, this.buq);
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

package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.x;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout;
/* loaded from: classes11.dex */
public class b extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View ege() {
        this.oEq = new WheatCommonLayout(this.mActivity);
        this.oEq.setTbPageContext(this.oAf);
        return this.oEq;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void OH() {
        if (this.oEq != null) {
            this.oEq.a(this.oEf, this.oEg, this.bzc);
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
}

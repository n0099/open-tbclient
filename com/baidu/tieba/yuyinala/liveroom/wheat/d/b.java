package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.view.View;
import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.data.ab;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout;
/* loaded from: classes11.dex */
public class b extends a {
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public View eeB() {
        this.oJs = new WheatCommonLayout(this.mActivity);
        this.oJs.setTbPageContext(this.oGe);
        return this.oJs;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void initView() {
        super.initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.d.a
    public void Mk() {
        if (this.oJs != null) {
            this.oJs.a(this.oJi, this.oJj, this.bxN);
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
}

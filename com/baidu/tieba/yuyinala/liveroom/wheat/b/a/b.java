package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d otW;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.otW = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.otW.a(wVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void WD(String str) {
        this.otW.WD(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void WE(String str) {
        this.otW.WE(str);
    }
}

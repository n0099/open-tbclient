package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d odr;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.odr = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.odr.a(wVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void VD(String str) {
        this.odr.VD(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void VE(String str) {
        this.odr.VE(str);
    }
}

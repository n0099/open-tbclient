package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a odq;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.odq = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.odq.a(wVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void VD(String str) {
        this.odq.VD(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void VE(String str) {
        this.odq.VE(str);
    }
}

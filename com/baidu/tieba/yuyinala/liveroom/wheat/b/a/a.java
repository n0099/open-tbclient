package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oHX;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oHX = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oHX.a(abVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wv(String str) {
        this.oHX.Wv(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Ww(String str) {
        this.oHX.Ww(str);
    }
}

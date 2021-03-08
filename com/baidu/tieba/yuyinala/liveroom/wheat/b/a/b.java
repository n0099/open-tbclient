package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d oHY;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oHY = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oHY.a(abVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wv(String str) {
        this.oHY.Wv(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Ww(String str) {
        this.oHY.Ww(str);
    }
}

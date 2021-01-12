package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d owc;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.owc = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(xVar, alaWheatInfoData, i, i2);
        this.owc.a(xVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Ve(String str) {
        this.owc.Ve(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Vf(String str) {
        this.owc.Vf(str);
    }
}

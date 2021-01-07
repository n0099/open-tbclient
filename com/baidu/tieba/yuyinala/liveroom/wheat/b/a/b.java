package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d oAH;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oAH = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(xVar, alaWheatInfoData, i, i2);
        this.oAH.a(xVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wm(String str) {
        this.oAH.Wm(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wn(String str) {
        this.oAH.Wn(str);
    }
}

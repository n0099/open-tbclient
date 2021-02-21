package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private d oFT;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oFT = new d(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oFT.a(abVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wo(String str) {
        this.oFT.Wo(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wp(String str) {
        this.oFT.Wp(str);
    }
}

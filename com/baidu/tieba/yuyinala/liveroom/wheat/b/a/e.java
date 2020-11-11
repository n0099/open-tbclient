package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a odq;

    public e(TbPageContext tbPageContext) {
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
        if (dYU()) {
            dZb();
        } else if (dYV()) {
            if (o.dZA().dYS()) {
                if (o.dZA().iV(str)) {
                    if (o.dZA().iX(str)) {
                        dZa();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                dYZ();
            } else if (o.dZA().iX(str)) {
                dZa();
            } else if (o.dZA().VQ(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                dYZ();
            }
        }
    }
}

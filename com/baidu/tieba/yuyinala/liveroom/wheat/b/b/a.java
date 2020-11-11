package com.baidu.tieba.yuyinala.liveroom.wheat.b.b;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void VD(String str) {
        if (o.dZA().dYS()) {
            dZa();
        } else if (o.dZA().dZD()) {
            dZa();
        } else if (o.dZA().iV(str)) {
            e.dZk().h(this.mPageContext);
        } else {
            dYZ();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void VE(String str) {
        if (dYU()) {
            dZb();
        } else if (dYV()) {
            if (o.dZA().dYS()) {
                if (o.dZA().iV(str)) {
                    if (o.dZA().iX(str)) {
                        dZa();
                        return;
                    } else {
                        dZc();
                        return;
                    }
                }
                dYZ();
            } else if (o.dZA().iX(str)) {
                dZa();
            } else if (o.dZA().VQ(str)) {
                dZc();
            } else {
                dYZ();
            }
        }
    }
}

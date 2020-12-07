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
    public void WD(String str) {
        if (o.efd().eev()) {
            eeD();
        } else if (o.efd().efg()) {
            eeD();
        } else if (o.efd().jt(str)) {
            e.eeN().h(this.mPageContext);
        } else {
            eeC();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void WE(String str) {
        if (eex()) {
            eeE();
        } else if (eey()) {
            if (o.efd().eev()) {
                if (o.efd().jt(str)) {
                    if (o.efd().jv(str)) {
                        eeD();
                        return;
                    } else {
                        eeF();
                        return;
                    }
                }
                eeC();
            } else if (o.efd().jv(str)) {
                eeD();
            } else if (o.efd().WQ(str)) {
                eeF();
            } else {
                eeC();
            }
        }
    }
}

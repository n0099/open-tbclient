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
        if (o.efe().eew()) {
            eeE();
        } else if (o.efe().efh()) {
            eeE();
        } else if (o.efe().jt(str)) {
            e.eeO().h(this.mPageContext);
        } else {
            eeD();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void WE(String str) {
        if (eey()) {
            eeF();
        } else if (eez()) {
            if (o.efe().eew()) {
                if (o.efe().jt(str)) {
                    if (o.efe().jv(str)) {
                        eeE();
                        return;
                    } else {
                        eeG();
                        return;
                    }
                }
                eeD();
            } else if (o.efe().jv(str)) {
                eeE();
            } else if (o.efe().WQ(str)) {
                eeG();
            } else {
                eeD();
            }
        }
    }
}

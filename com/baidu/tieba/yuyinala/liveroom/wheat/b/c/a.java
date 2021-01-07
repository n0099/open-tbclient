package com.baidu.tieba.yuyinala.liveroom.wheat.b.c;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wm(String str) {
        if (o.efg().eew()) {
            eeF();
        } else if (o.efg().efk()) {
            eeF();
        } else if (o.efg().jm(str)) {
            e.eeP().h(this.mPageContext);
        } else {
            eeE();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wn(String str) {
        if (eez()) {
            eeG();
        } else if (eeA()) {
            if (o.efg().eew()) {
                if (o.efg().jm(str)) {
                    if (o.efg().jo(str)) {
                        eeF();
                        return;
                    } else {
                        eeH();
                        return;
                    }
                }
                eeF();
            } else if (o.efg().jo(str)) {
                eeF();
            } else if (o.efg().Wz(str)) {
                eeH();
            } else {
                eeE();
            }
        }
    }
}

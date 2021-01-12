package com.baidu.tieba.yuyinala.liveroom.wheat.b.c;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Ve(String str) {
        if (o.ebo().eaE()) {
            eaN();
        } else if (o.ebo().ebs()) {
            eaN();
        } else if (o.ebo().ib(str)) {
            e.eaX().h(this.mPageContext);
        } else {
            eaM();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Vf(String str) {
        if (eaH()) {
            eaO();
        } else if (eaI()) {
            if (o.ebo().eaE()) {
                if (o.ebo().ib(str)) {
                    if (o.ebo().id(str)) {
                        eaN();
                        return;
                    } else {
                        eaP();
                        return;
                    }
                }
                eaN();
            } else if (o.ebo().id(str)) {
                eaN();
            } else if (o.ebo().Vr(str)) {
                eaP();
            } else {
                eaM();
            }
        }
    }
}

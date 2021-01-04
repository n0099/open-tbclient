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
    public void Wn(String str) {
        if (o.eff().eev()) {
            eeE();
        } else if (o.eff().efj()) {
            eeE();
        } else if (o.eff().jm(str)) {
            e.eeO().h(this.mPageContext);
        } else {
            eeD();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wo(String str) {
        if (eey()) {
            eeF();
        } else if (eez()) {
            if (o.eff().eev()) {
                if (o.eff().jm(str)) {
                    if (o.eff().jo(str)) {
                        eeE();
                        return;
                    } else {
                        eeG();
                        return;
                    }
                }
                eeE();
            } else if (o.eff().jo(str)) {
                eeE();
            } else if (o.eff().WA(str)) {
                eeG();
            } else {
                eeD();
            }
        }
    }
}

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
    public void Vo(String str) {
        if (o.dZz().dYR()) {
            dYZ();
        } else if (o.dZz().dZC()) {
            dYZ();
        } else if (o.dZz().iP(str)) {
            e.dZj().h(this.mPageContext);
        } else {
            dYY();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Vp(String str) {
        if (dYT()) {
            dZa();
        } else if (dYU()) {
            if (o.dZz().dYR()) {
                if (o.dZz().iP(str)) {
                    if (o.dZz().iR(str)) {
                        dYZ();
                        return;
                    } else {
                        dZb();
                        return;
                    }
                }
                dYY();
            } else if (o.dZz().iR(str)) {
                dYZ();
            } else if (o.dZz().VB(str)) {
                dZb();
            } else {
                dYY();
            }
        }
    }
}

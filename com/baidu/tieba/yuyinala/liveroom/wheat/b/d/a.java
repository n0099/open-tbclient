package com.baidu.tieba.yuyinala.liveroom.wheat.b.d;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wv(String str) {
        if (q.edU().Yn()) {
            edp();
        } else if (q.edU().edY()) {
            edp();
        } else if (q.edU().iN(str)) {
            f.edz().f(this.mPageContext);
        } else {
            edo();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Ww(String str) {
        if (edj()) {
            edq();
        } else if (edk()) {
            if (q.edU().Yn()) {
                if (q.edU().iN(str)) {
                    if (q.edU().iP(str)) {
                        edp();
                        return;
                    } else {
                        edr();
                        return;
                    }
                }
                edp();
            } else if (q.edU().iP(str)) {
                edp();
            } else if (q.edU().WK(str)) {
                edr();
            } else {
                edo();
            }
        }
    }
}

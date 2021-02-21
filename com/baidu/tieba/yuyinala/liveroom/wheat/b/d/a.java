package com.baidu.tieba.yuyinala.liveroom.wheat.b.d;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wo(String str) {
        if (q.edM().Yk()) {
            edh();
        } else if (q.edM().edQ()) {
            edh();
        } else if (q.edM().iH(str)) {
            f.edr().f(this.mPageContext);
        } else {
            edg();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wp(String str) {
        if (edb()) {
            edi();
        } else if (edc()) {
            if (q.edM().Yk()) {
                if (q.edM().iH(str)) {
                    if (q.edM().iJ(str)) {
                        edh();
                        return;
                    } else {
                        edj();
                        return;
                    }
                }
                edh();
            } else if (q.edM().iJ(str)) {
                edh();
            } else if (q.edM().WD(str)) {
                edj();
            } else {
                edg();
            }
        }
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.b.b;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wc(String str) {
        if (q.edE().Yk()) {
            ecZ();
        } else if (q.edE().edI()) {
            ecZ();
        } else if (q.edE().iH(str)) {
            f.edj().f(this.mPageContext);
        } else {
            ecY();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wd(String str) {
        if (ecT()) {
            eda();
        } else if (ecU()) {
            if (q.edE().Yk()) {
                if (q.edE().iH(str)) {
                    if (q.edE().iJ(str)) {
                        ecZ();
                        return;
                    } else {
                        edb();
                        return;
                    }
                }
                ecZ();
            } else if (q.edE().iJ(str)) {
                ecZ();
            } else if (q.edE().Wr(str)) {
                edb();
            } else {
                ecY();
            }
        }
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a otT;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.otT = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.otT.a(wVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void WD(String str) {
        this.otT.WD(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void WE(String str) {
        if (eex()) {
            eeE();
        } else if (eey()) {
            if (o.efd().eev()) {
                if (o.efd().jt(str)) {
                    if (o.efd().jv(str)) {
                        eeD();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                eeC();
            } else if (o.efd().jv(str)) {
                eeD();
            } else if (o.efd().WQ(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                eeC();
            }
        }
    }
}

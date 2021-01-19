package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a owc;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.owc = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(xVar, alaWheatInfoData, i, i2);
        this.owc.a(xVar, alaWheatInfoData, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Vf(String str) {
        this.owc.Vf(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Vg(String str) {
        if (eaH()) {
            eaO();
        } else if (eaI()) {
            if (o.ebo().eaE()) {
                if (o.ebo().ib(str)) {
                    if (o.ebo().id(str)) {
                        eaN();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                eaN();
            } else if (o.ebo().id(str)) {
                eaN();
            } else if (o.ebo().Vs(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                eaM();
            }
        }
    }
}

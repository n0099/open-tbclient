package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oAH;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oAH = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(x xVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(xVar, alaWheatInfoData, i, i2);
        this.oAH.a(xVar, alaWheatInfoData, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wn(String str) {
        this.oAH.Wn(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                eeE();
            } else if (o.eff().jo(str)) {
                eeE();
            } else if (o.eff().WA(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                eeD();
            }
        }
    }
}

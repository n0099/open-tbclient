package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a otV;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.otV = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.otV.a(wVar, alaWheatInfoData, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void WD(String str) {
        this.otV.WD(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void WE(String str) {
        if (eey()) {
            eeF();
        } else if (eez()) {
            if (o.efe().eew()) {
                if (o.efe().jt(str)) {
                    if (o.efe().jv(str)) {
                        eeE();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                eeD();
            } else if (o.efe().jv(str)) {
                eeE();
            } else if (o.efe().WQ(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                eeD();
            }
        }
    }
}

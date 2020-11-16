package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oeT;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oeT = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(w wVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(wVar, alaWheatInfoData, i, i2);
        this.oeT.a(wVar, alaWheatInfoData, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Vo(String str) {
        this.oeT.Vo(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                dYY();
            } else if (o.dZz().iR(str)) {
                dYZ();
            } else if (o.dZz().VB(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                dYY();
            }
        }
    }
}

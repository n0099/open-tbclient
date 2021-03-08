package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oHX;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oHX = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oHX.a(abVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wv(String str) {
        this.oHX.Wv(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Ww(String str) {
        if (edj()) {
            edq();
        } else if (edk()) {
            if (q.edU().Yn()) {
                if (q.edU().iN(str)) {
                    if (q.edU().iP(str)) {
                        edp();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                edp();
            } else if (q.edU().iP(str)) {
                edp();
            } else if (q.edU().WK(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                edo();
            }
        }
    }
}

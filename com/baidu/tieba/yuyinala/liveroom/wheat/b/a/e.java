package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class e extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oFS;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oFS = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oFS.a(abVar, alaWheatInfoData, i, i2);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wo(String str) {
        this.oFS.Wo(str);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    protected void Wp(String str) {
        if (edb()) {
            edi();
        } else if (edc()) {
            if (q.edM().Yk()) {
                if (q.edM().iH(str)) {
                    if (q.edM().iJ(str)) {
                        edh();
                        return;
                    } else {
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                edh();
            } else if (q.edM().iJ(str)) {
                edh();
            } else if (q.edM().WD(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                edg();
            }
        }
    }
}

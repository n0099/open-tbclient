package com.baidu.tieba.yuyinala.liveroom.wheat.b.a;

import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class d extends com.baidu.tieba.yuyinala.liveroom.wheat.b.a {
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a oFs;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.oFs = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(tbPageContext);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void a(ab abVar, AlaWheatInfoData alaWheatInfoData, int i, int i2) {
        super.a(abVar, alaWheatInfoData, i, i2);
        this.oFs.a(abVar, alaWheatInfoData, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a
    public void Wc(String str) {
        this.oFs.Wc(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                        showToast(a.h.yuyin_not_allow_switchwheat_text);
                        return;
                    }
                }
                ecZ();
            } else if (q.edE().iJ(str)) {
                ecZ();
            } else if (q.edE().Wr(str)) {
                showToast(a.h.yuyin_not_allow_switchwheat_text);
            } else {
                ecY();
            }
        }
    }
}

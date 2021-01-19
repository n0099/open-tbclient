package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class g {
    public static int owL = 1;
    public static int owM = 2;
    public static int owN = 3;
    private TbPageContext ovA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a owK;

    public g(TbPageContext tbPageContext) {
        this.ovA = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hcZ != null && (alaWheatInfoDataWrapper = eVar.hcZ.aGD) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.ovA);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.ovA);
                            break;
                        }
                        break;
                    case 2:
                        if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.ovA);
                            break;
                        }
                        break;
                    case 3:
                        if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.ovA);
                            break;
                        }
                        break;
                    case 4:
                        if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.ovA);
                            break;
                        }
                        break;
                    default:
                        if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.ovA);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.ovA);
                }
            } else if (this.owK == null || !(this.owK instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.owK = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.ovA);
            }
            if (this.owK != null) {
                this.owK.a(eVar.hcZ, eVar.bYs, eVar.okn, eVar.oko);
                this.owK.eaG();
            }
        }
    }

    public void onDestroy() {
        if (this.owK != null) {
            this.owK.onDestory();
        }
        e.eaX().onDestroy();
    }
}

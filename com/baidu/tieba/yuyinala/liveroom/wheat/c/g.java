package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class g {
    public static int owK = 1;
    public static int owL = 2;
    public static int owM = 3;
    private TbPageContext ovz;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a owJ;

    public g(TbPageContext tbPageContext) {
        this.ovz = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hcZ != null && (alaWheatInfoDataWrapper = eVar.hcZ.aGD) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.ovz);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.ovz);
                            break;
                        }
                        break;
                    case 2:
                        if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.ovz);
                            break;
                        }
                        break;
                    case 3:
                        if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.ovz);
                            break;
                        }
                        break;
                    case 4:
                        if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.ovz);
                            break;
                        }
                        break;
                    default:
                        if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.ovz);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.ovz);
                }
            } else if (this.owJ == null || !(this.owJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.owJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.ovz);
            }
            if (this.owJ != null) {
                this.owJ.a(eVar.hcZ, eVar.bYs, eVar.okm, eVar.okn);
                this.owJ.eaG();
            }
        }
    }

    public void onDestroy() {
        if (this.owJ != null) {
            this.owJ.onDestory();
        }
        e.eaX().onDestroy();
    }
}

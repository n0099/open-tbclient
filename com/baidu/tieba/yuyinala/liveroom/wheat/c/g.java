package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class g {
    public static int ouD = 1;
    public static int ouE = 2;
    public static int ouF = 3;
    private TbPageContext oty;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a ouC;

    public g(TbPageContext tbPageContext) {
        this.oty = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.gVQ != null && (alaWheatInfoDataWrapper = eVar.gVQ.aKQ) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oty);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oty);
                            break;
                        }
                        break;
                    case 2:
                        if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oty);
                            break;
                        }
                        break;
                    case 3:
                        if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oty);
                            break;
                        }
                        break;
                    case 4:
                        if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oty);
                            break;
                        }
                        break;
                    default:
                        if (this.ouC == null || !(this.ouC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.ouC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oty);
                            break;
                        }
                        break;
                }
            }
            if (this.ouC != null) {
                this.ouC.a(eVar.gVQ, eVar.olV, eVar.olW, eVar.olX);
                this.ouC.eew();
            }
        }
    }

    public void onDestroy() {
        if (this.ouC != null) {
            this.ouC.onDestory();
        }
        e.eeN().onDestroy();
    }
}

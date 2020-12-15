package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class g {
    public static int ouF = 1;
    public static int ouG = 2;
    public static int ouH = 3;
    private TbPageContext otA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a ouE;

    public g(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.gVS != null && (alaWheatInfoDataWrapper = eVar.gVS.aKQ) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.otA);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.otA);
                            break;
                        }
                        break;
                    case 2:
                        if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.otA);
                            break;
                        }
                        break;
                    case 3:
                        if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.otA);
                            break;
                        }
                        break;
                    case 4:
                        if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.otA);
                            break;
                        }
                        break;
                    default:
                        if (this.ouE == null || !(this.ouE instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.ouE = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.otA);
                            break;
                        }
                        break;
                }
            }
            if (this.ouE != null) {
                this.ouE.a(eVar.gVS, eVar.olX, eVar.olY, eVar.olZ);
                this.ouE.eex();
            }
        }
    }

    public void onDestroy() {
        if (this.ouE != null) {
            this.ouE.onDestory();
        }
        e.eeO().onDestroy();
    }
}

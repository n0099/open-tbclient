package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class g {
    public static int odZ = 1;
    public static int oea = 2;
    public static int oeb = 3;
    private TbPageContext ocV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a odY;

    public g(TbPageContext tbPageContext) {
        this.ocV = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.gMW != null && (alaWheatInfoDataWrapper = eVar.gMW.aJP) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.ocV);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.ocV);
                            break;
                        }
                        break;
                    case 2:
                        if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.ocV);
                            break;
                        }
                        break;
                    case 3:
                        if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.ocV);
                            break;
                        }
                        break;
                    case 4:
                        if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.ocV);
                            break;
                        }
                        break;
                    default:
                        if (this.odY == null || !(this.odY instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.odY = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.ocV);
                            break;
                        }
                        break;
                }
            }
            if (this.odY != null) {
                this.odY.a(eVar.gMW, eVar.nVu, eVar.nVv, eVar.nVw);
                this.odY.dYT();
            }
        }
    }

    public void onDestroy() {
        if (this.odY != null) {
            this.odY.onDestory();
        }
        e.dZk().onDestroy();
    }
}

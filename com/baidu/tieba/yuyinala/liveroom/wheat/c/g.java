package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class g {
    public static int oBp = 1;
    public static int oBq = 2;
    public static int oBr = 3;
    private TbPageContext oAe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a oBo;

    public g(TbPageContext tbPageContext) {
        this.oAe = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hhF != null && (alaWheatInfoDataWrapper = eVar.hhF.aLq) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oAe);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oAe);
                            break;
                        }
                        break;
                    case 2:
                        if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oAe);
                            break;
                        }
                        break;
                    case 3:
                        if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oAe);
                            break;
                        }
                        break;
                    case 4:
                        if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oAe);
                            break;
                        }
                        break;
                    default:
                        if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oAe);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.oAe);
                }
            } else if (this.oBo == null || !(this.oBo instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.oBo = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oAe);
            }
            if (this.oBo != null) {
                this.oBo.a(eVar.hhF, eVar.cdg, eVar.ooS, eVar.ooT);
                this.oBo.eey();
            }
        }
    }

    public void onDestroy() {
        if (this.oBo != null) {
            this.oBo.onDestory();
        }
        e.eeP().onDestroy();
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class g {
    public static int oBq = 1;
    public static int oBr = 2;
    public static int oBs = 3;
    private TbPageContext oAf;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a oBp;

    public g(TbPageContext tbPageContext) {
        this.oAf = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hhF != null && (alaWheatInfoDataWrapper = eVar.hhF.aLq) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oAf);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oAf);
                            break;
                        }
                        break;
                    case 2:
                        if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oAf);
                            break;
                        }
                        break;
                    case 3:
                        if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oAf);
                            break;
                        }
                        break;
                    case 4:
                        if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oAf);
                            break;
                        }
                        break;
                    default:
                        if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oAf);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.oAf);
                }
            } else if (this.oBp == null || !(this.oBp instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.oBp = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oAf);
            }
            if (this.oBp != null) {
                this.oBp.a(eVar.hhF, eVar.cdg, eVar.ooT, eVar.ooU);
                this.oBp.eex();
            }
        }
    }

    public void onDestroy() {
        if (this.oBp != null) {
            this.oBp.onDestory();
        }
        e.eeO().onDestroy();
    }
}

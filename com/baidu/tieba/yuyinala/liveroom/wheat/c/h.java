package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class h {
    public static int oGK = 1;
    public static int oGL = 2;
    public static int oGM = 3;
    private TbPageContext oGE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a oGJ;

    public h(TbPageContext tbPageContext) {
        this.oGE = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hfW != null && (alaWheatInfoDataWrapper = eVar.hfW.aIY) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oGE);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oGE);
                            break;
                        }
                        break;
                    case 2:
                        if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oGE);
                            break;
                        }
                        break;
                    case 3:
                        if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oGE);
                            break;
                        }
                        break;
                    case 4:
                        if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oGE);
                            break;
                        }
                        break;
                    default:
                        if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oGE);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a)) {
                    this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a(this.oGE);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
                if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.oGE);
                }
            } else if (this.oGJ == null || !(this.oGJ instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.oGJ = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oGE);
            }
            if (this.oGJ != null) {
                this.oGJ.a(eVar.hfW, eVar.ccw, eVar.ouG, eVar.ouH);
                this.oGJ.eda();
            }
        }
    }

    public void onDestroy() {
        if (this.oGJ != null) {
            this.oGJ.onDestory();
        }
        f.edr().onDestroy();
    }
}

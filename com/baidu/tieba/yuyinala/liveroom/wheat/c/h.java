package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class h {
    public static int oGk = 1;
    public static int oGl = 2;
    public static int oGm = 3;
    private TbPageContext oGe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a oGj;

    public h(TbPageContext tbPageContext) {
        this.oGe = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hfI != null && (alaWheatInfoDataWrapper = eVar.hfI.aIY) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oGe);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oGe);
                            break;
                        }
                        break;
                    case 2:
                        if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oGe);
                            break;
                        }
                        break;
                    case 3:
                        if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oGe);
                            break;
                        }
                        break;
                    case 4:
                        if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oGe);
                            break;
                        }
                        break;
                    default:
                        if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oGe);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a)) {
                    this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a(this.oGe);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
                if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.oGe);
                }
            } else if (this.oGj == null || !(this.oGj instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.oGj = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oGe);
            }
            if (this.oGj != null) {
                this.oGj.a(eVar.hfI, eVar.ccw, eVar.ouf, eVar.oug);
                this.oGj.ecS();
            }
        }
    }

    public void onDestroy() {
        if (this.oGj != null) {
            this.oGj.onDestory();
        }
        f.edj().onDestroy();
    }
}

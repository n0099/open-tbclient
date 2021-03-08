package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class h {
    public static int oIP = 1;
    public static int oIQ = 2;
    public static int oIR = 3;
    private TbPageContext oIJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a oIO;

    public h(TbPageContext tbPageContext) {
        this.oIJ = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.hhF != null && (alaWheatInfoDataWrapper = eVar.hhF.aKy) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oIJ);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oIJ);
                            break;
                        }
                        break;
                    case 2:
                        if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oIJ);
                            break;
                        }
                        break;
                    case 3:
                        if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oIJ);
                            break;
                        }
                        break;
                    case 4:
                        if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oIJ);
                            break;
                        }
                        break;
                    default:
                        if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oIJ);
                            break;
                        }
                        break;
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 2) {
                if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a)) {
                    this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a(this.oIJ);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 100) {
                if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a)) {
                    this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a(this.oIJ);
                }
            } else if (this.oIO == null || !(this.oIO instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                this.oIO = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oIJ);
            }
            if (this.oIO != null) {
                this.oIO.a(eVar.hhF, eVar.cdY, eVar.owL, eVar.owM);
                this.oIO.edi();
            }
        }
    }

    public void onDestroy() {
        if (this.oIO != null) {
            this.oIO.onDestory();
        }
        f.edz().onDestroy();
    }
}

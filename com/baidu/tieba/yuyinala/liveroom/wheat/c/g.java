package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class g {
    public static int ofD = 1;
    public static int ofE = 2;
    public static int ofF = 3;
    private TbPageContext oey;
    private com.baidu.tieba.yuyinala.liveroom.wheat.b.a ofC;

    public g(TbPageContext tbPageContext) {
        this.oey = tbPageContext;
    }

    public void b(com.baidu.tieba.yuyinala.liveroom.data.e eVar) {
        AlaWheatInfoDataWrapper alaWheatInfoDataWrapper;
        if (eVar != null && eVar.gMD != null && (alaWheatInfoDataWrapper = eVar.gMD.aIe) != null) {
            if (alaWheatInfoDataWrapper.getRoomMode() == 0) {
                if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a)) {
                    this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.b.a(this.oey);
                }
            } else if (alaWheatInfoDataWrapper.getRoomMode() == 1) {
                switch (alaWheatInfoDataWrapper.getActivityStage()) {
                    case 1:
                        if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c)) {
                            this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.c(this.oey);
                            break;
                        }
                        break;
                    case 2:
                        if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e)) {
                            this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.e(this.oey);
                            break;
                        }
                        break;
                    case 3:
                        if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d)) {
                            this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.d(this.oey);
                            break;
                        }
                        break;
                    case 4:
                        if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b)) {
                            this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.b(this.oey);
                            break;
                        }
                        break;
                    default:
                        if (this.ofC == null || !(this.ofC instanceof com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a)) {
                            this.ofC = new com.baidu.tieba.yuyinala.liveroom.wheat.b.a.a(this.oey);
                            break;
                        }
                        break;
                }
            }
            if (this.ofC != null) {
                this.ofC.a(eVar.gMD, eVar.nWX, eVar.nWY, eVar.nWZ);
                this.ofC.dYS();
            }
        }
    }

    public void onDestroy() {
        if (this.ofC != null) {
            this.ofC.onDestory();
        }
        e.dZj().onDestroy();
    }
}

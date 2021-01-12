package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class e {
    private static e owE;
    private TbPageContext ovz;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c owF;

    public static e eaX() {
        if (owE == null) {
            owE = new e();
        }
        return owE;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.ovz) {
            this.ovz = tbPageContext;
            hide();
        }
        if (this.ovz == null) {
            this.ovz = o.ebo().ebu();
        }
        if (this.ovz != null) {
            if (this.owF == null) {
                this.owF = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.ovz);
            }
            if (this.owF.ebG()) {
                this.owF.show();
                return;
            }
            this.owF.show();
            this.owF.startTimer();
        }
    }

    public e eaY() {
        if (this.owF != null) {
            this.owF.startTimer();
        }
        return this;
    }

    public e eaZ() {
        if (this.owF != null) {
            this.owF.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.owF != null) {
            this.owF.dismiss();
            this.owF = null;
        }
    }

    public void onDestroy() {
        eaZ();
        hide();
    }
}

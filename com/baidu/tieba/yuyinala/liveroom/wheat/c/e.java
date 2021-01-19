package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class e {
    private static e owF;
    private TbPageContext ovA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c owG;

    public static e eaX() {
        if (owF == null) {
            owF = new e();
        }
        return owF;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.ovA) {
            this.ovA = tbPageContext;
            hide();
        }
        if (this.ovA == null) {
            this.ovA = o.ebo().ebu();
        }
        if (this.ovA != null) {
            if (this.owG == null) {
                this.owG = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.ovA);
            }
            if (this.owG.ebG()) {
                this.owG.show();
                return;
            }
            this.owG.show();
            this.owG.startTimer();
        }
    }

    public e eaY() {
        if (this.owG != null) {
            this.owG.startTimer();
        }
        return this;
    }

    public e eaZ() {
        if (this.owG != null) {
            this.owG.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.owG != null) {
            this.owG.dismiss();
            this.owG = null;
        }
    }

    public void onDestroy() {
        eaZ();
        hide();
    }
}

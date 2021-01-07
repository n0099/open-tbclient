package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class e {
    private static e oBj;
    private TbPageContext oAe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c oBk;

    public static e eeP() {
        if (oBj == null) {
            oBj = new e();
        }
        return oBj;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oAe) {
            this.oAe = tbPageContext;
            hide();
        }
        if (this.oAe == null) {
            this.oAe = o.efg().efm();
        }
        if (this.oAe != null) {
            if (this.oBk == null) {
                this.oBk = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oAe);
            }
            if (this.oBk.efy()) {
                this.oBk.show();
                return;
            }
            this.oBk.show();
            this.oBk.startTimer();
        }
    }

    public e eeQ() {
        if (this.oBk != null) {
            this.oBk.startTimer();
        }
        return this;
    }

    public e eeR() {
        if (this.oBk != null) {
            this.oBk.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.oBk != null) {
            this.oBk.dismiss();
            this.oBk = null;
        }
    }

    public void onDestroy() {
        eeR();
        hide();
    }
}

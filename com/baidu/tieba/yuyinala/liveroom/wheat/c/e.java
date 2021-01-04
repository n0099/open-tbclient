package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class e {
    private static e oBk;
    private TbPageContext oAf;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c oBl;

    public static e eeO() {
        if (oBk == null) {
            oBk = new e();
        }
        return oBk;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oAf) {
            this.oAf = tbPageContext;
            hide();
        }
        if (this.oAf == null) {
            this.oAf = o.eff().efl();
        }
        if (this.oAf != null) {
            if (this.oBl == null) {
                this.oBl = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oAf);
            }
            if (this.oBl.efx()) {
                this.oBl.show();
                return;
            }
            this.oBl.show();
            this.oBl.startTimer();
        }
    }

    public e eeP() {
        if (this.oBl != null) {
            this.oBl.startTimer();
        }
        return this;
    }

    public e eeQ() {
        if (this.oBl != null) {
            this.oBl.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.oBl != null) {
            this.oBl.dismiss();
            this.oBl = null;
        }
    }

    public void onDestroy() {
        eeQ();
        hide();
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private static e ouz;
    private TbPageContext otA;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c ouA;

    public static e eeO() {
        if (ouz == null) {
            ouz = new e();
        }
        return ouz;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.otA) {
            this.otA = tbPageContext;
            hide();
        }
        if (this.otA == null) {
            this.otA = o.efe().efj();
        }
        if (this.otA != null) {
            if (this.ouA == null) {
                this.ouA = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.otA);
            }
            if (this.ouA.efu()) {
                this.ouA.show();
                return;
            }
            this.ouA.show();
            this.ouA.startTimer();
        }
    }

    public e eeP() {
        if (this.ouA != null) {
            this.ouA.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.ouA != null) {
            this.ouA.dismiss();
            this.ouA = null;
        }
    }

    public void onDestroy() {
        eeP();
        hide();
    }
}

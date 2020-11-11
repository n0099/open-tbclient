package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private static e odT;
    private TbPageContext ocV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c odU;

    public static e dZk() {
        if (odT == null) {
            odT = new e();
        }
        return odT;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.ocV) {
            this.ocV = tbPageContext;
            hide();
        }
        if (this.ocV == null) {
            this.ocV = o.dZA().dZF();
        }
        if (this.ocV != null) {
            if (this.odU == null) {
                this.odU = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.ocV);
            }
            if (this.odU.dZP()) {
                this.odU.show();
                return;
            }
            this.odU.show();
            this.odU.startTimer();
        }
    }

    public e dZl() {
        if (this.odU != null) {
            this.odU.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.odU != null) {
            this.odU.dismiss();
            this.odU = null;
        }
    }

    public void onDestroy() {
        dZl();
        hide();
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private static e nWr;
    private TbPageContext nVE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c nWs;

    public static e dWm() {
        if (nWr == null) {
            nWr = new e();
        }
        return nWr;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.nVE) {
            this.nVE = tbPageContext;
            hide();
        }
        if (this.nVE == null) {
            this.nVE = n.dWB().dWK();
        }
        if (this.nVE != null) {
            if (this.nWs == null) {
                this.nWs = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.nVE);
            }
            if (this.nWs.dWQ()) {
                this.nWs.show();
                return;
            }
            this.nWs.show();
            this.nWs.startTimer();
        }
    }

    public e dWn() {
        if (this.nWs != null) {
            this.nWs.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.nWs != null) {
            this.nWs.dismiss();
            this.nWs = null;
        }
    }

    public void onDestroy() {
        dWn();
        hide();
    }
}

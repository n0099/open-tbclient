package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private static e oux;
    private TbPageContext oty;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c ouy;

    public static e eeN() {
        if (oux == null) {
            oux = new e();
        }
        return oux;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oty) {
            this.oty = tbPageContext;
            hide();
        }
        if (this.oty == null) {
            this.oty = o.efd().efi();
        }
        if (this.oty != null) {
            if (this.ouy == null) {
                this.ouy = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oty);
            }
            if (this.ouy.eft()) {
                this.ouy.show();
                return;
            }
            this.ouy.show();
            this.ouy.startTimer();
        }
    }

    public e eeO() {
        if (this.ouy != null) {
            this.ouy.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.ouy != null) {
            this.ouy.dismiss();
            this.ouy = null;
        }
    }

    public void onDestroy() {
        eeO();
        hide();
    }
}

package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    private static e ofx;
    private TbPageContext oey;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c ofy;

    public static e dZj() {
        if (ofx == null) {
            ofx = new e();
        }
        return ofx;
    }

    private e() {
    }

    public void h(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oey) {
            this.oey = tbPageContext;
            hide();
        }
        if (this.oey == null) {
            this.oey = o.dZz().dZE();
        }
        if (this.oey != null) {
            if (this.ofy == null) {
                this.ofy = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oey);
            }
            if (this.ofy.dZO()) {
                this.ofy.show();
                return;
            }
            this.ofy.show();
            this.ofy.startTimer();
        }
    }

    public e dZk() {
        if (this.ofy != null) {
            this.ofy.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.ofy != null) {
            this.ofy.dismiss();
            this.ofy = null;
        }
    }

    public void onDestroy() {
        dZk();
        hide();
    }
}

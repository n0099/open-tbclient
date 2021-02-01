package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class f {
    private static f oGd;
    private TbPageContext oGe;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c oGf;

    public static f edj() {
        if (oGd == null) {
            oGd = new f();
        }
        return oGd;
    }

    private f() {
    }

    public void f(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oGe) {
            this.oGe = tbPageContext;
            hide();
        }
        if (this.oGe == null) {
            this.oGe = q.edE().edK();
        }
        if (this.oGe != null) {
            if (this.oGf == null) {
                this.oGf = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oGe);
            }
            if (this.oGf.edU()) {
                this.oGf.show();
                return;
            }
            this.oGf.show();
            this.oGf.startTimer();
        }
    }

    public f edk() {
        if (this.oGf != null) {
            this.oGf.startTimer();
        }
        return this;
    }

    public f edl() {
        if (this.oGf != null) {
            this.oGf.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.oGf != null) {
            this.oGf.dismiss();
            this.oGf = null;
        }
    }

    public void onDestroy() {
        edl();
        hide();
    }
}

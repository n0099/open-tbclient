package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class f {
    private static f oGD;
    private TbPageContext oGE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c oGF;

    public static f edr() {
        if (oGD == null) {
            oGD = new f();
        }
        return oGD;
    }

    private f() {
    }

    public void f(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oGE) {
            this.oGE = tbPageContext;
            hide();
        }
        if (this.oGE == null) {
            this.oGE = q.edM().edS();
        }
        if (this.oGE != null) {
            if (this.oGF == null) {
                this.oGF = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oGE);
            }
            if (this.oGF.eec()) {
                this.oGF.show();
                return;
            }
            this.oGF.show();
            this.oGF.startTimer();
        }
    }

    public f eds() {
        if (this.oGF != null) {
            this.oGF.startTimer();
        }
        return this;
    }

    public f edt() {
        if (this.oGF != null) {
            this.oGF.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.oGF != null) {
            this.oGF.dismiss();
            this.oGF = null;
        }
    }

    public void onDestroy() {
        edt();
        hide();
    }
}

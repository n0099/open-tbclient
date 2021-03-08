package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class f {
    private static f oII;
    private TbPageContext oIJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c oIK;

    public static f edz() {
        if (oII == null) {
            oII = new f();
        }
        return oII;
    }

    private f() {
    }

    public void f(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext != this.oIJ) {
            this.oIJ = tbPageContext;
            hide();
        }
        if (this.oIJ == null) {
            this.oIJ = q.edU().eea();
        }
        if (this.oIJ != null) {
            if (this.oIK == null) {
                this.oIK = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.c(this.oIJ);
            }
            if (this.oIK.eek()) {
                this.oIK.show();
                return;
            }
            this.oIK.show();
            this.oIK.startTimer();
        }
    }

    public f edA() {
        if (this.oIK != null) {
            this.oIK.startTimer();
        }
        return this;
    }

    public f edB() {
        if (this.oIK != null) {
            this.oIK.cancelTimer();
        }
        return this;
    }

    private void hide() {
        if (this.oIK != null) {
            this.oIK.dismiss();
            this.oIK = null;
        }
    }

    public void onDestroy() {
        edB();
        hide();
    }
}

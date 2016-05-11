package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean aoz;
        boolean z;
        if (this.cMQ.cMj == null || this.cMQ.cMj.trim().length() < 1) {
            com.baidu.adp.lib.util.k.a(this.cMQ.getPageContext().getPageActivity(), this.cMQ.cLO);
            aoz = this.cMQ.aoz();
            if (!aoz) {
                this.cMQ.showToast(this.cMQ.getResources().getString(t.j.write_keyword));
            }
        } else if (this.cMQ.mMode != 0) {
            if (this.cMQ.mMode == 3) {
                com.baidu.adp.lib.util.k.a(this.cMQ.getPageContext().getPageActivity(), this.cMQ.cLO);
                if (!TextUtils.isEmpty(this.cMQ.cMj) && this.cMQ.cMj.trim().length() != 0) {
                    this.cMQ.cMj = this.cMQ.cMj.trim();
                    this.cMQ.gN(this.cMQ.cMj);
                    return;
                }
                return;
            }
            this.cMQ.C(1, this.cMQ.cMj);
        } else {
            z = this.cMQ.aqS;
            if (z) {
                this.cMQ.aoI();
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends as {
    private TextView fKI;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fKI = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fKI = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fKI.setVisibility(8);
    }

    public void jU(boolean z) {
        if (this.fKI != null) {
            if (z) {
                this.fKI.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.r(this.fKI, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.s(this.fKI, d.f.push_bg_selector);
                this.fKI.setClickable(true);
            } else {
                this.fKI.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.s(this.fKI, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.r(this.fKI, d.C0140d.cp_cont_d);
                this.fKI.setClickable(false);
            }
            this.fKI.setVisibility(0);
        }
    }

    public void Z(bd bdVar) {
        if (bdVar != null && bdVar.zI() != null) {
            int status = bdVar.zI().getStatus();
            if (status == 1) {
                jU(true);
            } else if (status == 2) {
                jU(false);
            }
        }
    }

    public TextView bbL() {
        return this.fKI;
    }
}

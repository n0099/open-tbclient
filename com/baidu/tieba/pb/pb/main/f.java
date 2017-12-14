package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends as {
    private TextView eSL;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eSL = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.eSL = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.eSL.setVisibility(8);
    }

    public void jd(boolean z) {
        if (this.eSL != null) {
            if (z) {
                this.eSL.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.i(this.eSL, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eSL, d.f.push_bg_selector);
                this.eSL.setClickable(true);
            } else {
                this.eSL.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eSL, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eSL, d.C0096d.cp_cont_d);
                this.eSL.setClickable(false);
            }
            this.eSL.setVisibility(0);
        }
    }

    public void Y(bd bdVar) {
        if (bdVar != null && bdVar.rQ() != null) {
            int status = bdVar.rQ().getStatus();
            if (status == 1) {
                jd(true);
            } else if (status == 2) {
                jd(false);
            }
        }
    }

    public TextView aSL() {
        return this.eSL;
    }
}

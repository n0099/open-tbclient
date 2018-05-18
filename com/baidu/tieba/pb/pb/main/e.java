package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends at {
    private TextView ffw;

    public e(BaseActivity baseActivity, View view2) {
        super(baseActivity, view2);
        this.ffw = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.ffw = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.ffw.setVisibility(8);
    }

    public void jw(boolean z) {
        if (this.ffw != null) {
            if (z) {
                this.ffw.setText(d.k.push);
                com.baidu.tbadk.core.util.ak.h(this.ffw, d.f.push_text_selector);
                com.baidu.tbadk.core.util.ak.i(this.ffw, d.f.push_bg_selector);
                this.ffw.setClickable(true);
            } else {
                this.ffw.setText(d.k.already_push);
                com.baidu.tbadk.core.util.ak.i(this.ffw, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.ak.h(this.ffw, d.C0126d.cp_cont_d);
                this.ffw.setClickable(false);
            }
            this.ffw.setVisibility(0);
        }
    }

    public void ab(bd bdVar) {
        if (bdVar != null && bdVar.si() != null) {
            int status = bdVar.si().getStatus();
            if (status == 1) {
                jw(true);
            } else if (status == 2) {
                jw(false);
            }
        }
    }

    public TextView aWI() {
        return this.ffw;
    }
}

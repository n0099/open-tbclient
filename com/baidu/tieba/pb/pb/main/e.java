package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hmA;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hmA = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hmA = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.hmA.setVisibility(8);
    }

    public void nh(boolean z) {
        if (this.hmA != null) {
            if (z) {
                this.hmA.setText(d.j.push);
                com.baidu.tbadk.core.util.al.j(this.hmA, d.f.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hmA, d.f.push_bg_selector);
                this.hmA.setClickable(true);
            } else {
                this.hmA.setText(d.j.already_push);
                com.baidu.tbadk.core.util.al.k(this.hmA, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hmA, d.C0236d.cp_cont_d);
                this.hmA.setClickable(false);
            }
            this.hmA.setVisibility(0);
        }
    }

    public void aw(bg bgVar) {
        if (bgVar != null && bgVar.Zl() != null) {
            int status = bgVar.Zl().getStatus();
            if (status == 1) {
                nh(true);
            } else if (status == 2) {
                nh(false);
            }
        }
    }

    public TextView bJl() {
        return this.hmA;
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hmw;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hmw = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hmw = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.hmw.setVisibility(8);
    }

    public void nh(boolean z) {
        if (this.hmw != null) {
            if (z) {
                this.hmw.setText(d.j.push);
                com.baidu.tbadk.core.util.al.j(this.hmw, d.f.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hmw, d.f.push_bg_selector);
                this.hmw.setClickable(true);
            } else {
                this.hmw.setText(d.j.already_push);
                com.baidu.tbadk.core.util.al.k(this.hmw, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hmw, d.C0277d.cp_cont_d);
                this.hmw.setClickable(false);
            }
            this.hmw.setVisibility(0);
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
        return this.hmw;
    }
}

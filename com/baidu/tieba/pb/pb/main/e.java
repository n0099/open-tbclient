package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hmj;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hmj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hmj = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.hmj.setVisibility(8);
    }

    public void nh(boolean z) {
        if (this.hmj != null) {
            if (z) {
                this.hmj.setText(d.j.push);
                com.baidu.tbadk.core.util.al.j(this.hmj, d.f.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hmj, d.f.push_bg_selector);
                this.hmj.setClickable(true);
            } else {
                this.hmj.setText(d.j.already_push);
                com.baidu.tbadk.core.util.al.k(this.hmj, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hmj, d.C0277d.cp_cont_d);
                this.hmj.setClickable(false);
            }
            this.hmj.setVisibility(0);
        }
    }

    public void av(bg bgVar) {
        if (bgVar != null && bgVar.Zi() != null) {
            int status = bgVar.Zi().getStatus();
            if (status == 1) {
                nh(true);
            } else if (status == 2) {
                nh(false);
            }
        }
    }

    public TextView bJi() {
        return this.hmj;
    }
}

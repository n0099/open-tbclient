package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hKb;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hKb = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hKb = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hKb.setVisibility(8);
    }

    public void ol(boolean z) {
        if (this.hKb != null) {
            if (z) {
                this.hKb.setText(R.string.push);
                com.baidu.tbadk.core.util.am.j(this.hKb, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.k(this.hKb, R.drawable.push_bg_selector);
                this.hKb.setClickable(true);
            } else {
                this.hKb.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.k(this.hKb, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.j(this.hKb, R.color.cp_cont_d);
                this.hKb.setClickable(false);
            }
            this.hKb.setVisibility(0);
        }
    }

    public void at(bg bgVar) {
        if (bgVar != null && bgVar.aeR() != null) {
            int status = bgVar.aeR().getStatus();
            if (status == 1) {
                ol(true);
            } else if (status == 2) {
                ol(false);
            }
        }
    }

    public TextView bTP() {
        return this.hKb;
    }
}

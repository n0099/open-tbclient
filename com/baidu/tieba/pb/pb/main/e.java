package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hMR;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hMR = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hMR = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hMR.setVisibility(8);
    }

    public void op(boolean z) {
        if (this.hMR != null) {
            if (z) {
                this.hMR.setText(R.string.push);
                com.baidu.tbadk.core.util.am.j(this.hMR, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.k(this.hMR, R.drawable.push_bg_selector);
                this.hMR.setClickable(true);
            } else {
                this.hMR.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.k(this.hMR, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.j(this.hMR, R.color.cp_cont_d);
                this.hMR.setClickable(false);
            }
            this.hMR.setVisibility(0);
        }
    }

    public void av(bh bhVar) {
        if (bhVar != null && bhVar.aeW() != null) {
            int status = bhVar.aeW().getStatus();
            if (status == 1) {
                op(true);
            } else if (status == 2) {
                op(false);
            }
        }
    }

    public TextView bUQ() {
        return this.hMR;
    }
}

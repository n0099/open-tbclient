package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hLv;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hLv = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hLv = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hLv.setVisibility(8);
    }

    public void nY(boolean z) {
        if (this.hLv != null) {
            if (z) {
                this.hLv.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hLv, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hLv, R.drawable.push_bg_selector);
                this.hLv.setClickable(true);
            } else {
                this.hLv.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hLv, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hLv, (int) R.color.cp_cont_d);
                this.hLv.setClickable(false);
            }
            this.hLv.setVisibility(0);
        }
    }

    public void at(bh bhVar) {
        if (bhVar != null && bhVar.aja() != null) {
            int status = bhVar.aja().getStatus();
            if (status == 1) {
                nY(true);
            } else if (status == 2) {
                nY(false);
            }
        }
    }

    public TextView bRR() {
        return this.hLv;
    }
}

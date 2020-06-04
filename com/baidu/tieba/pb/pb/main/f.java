package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends aw {
    private TextView jHU;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.jHU = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aw
    protected void a(e eVar) {
        this.jHU = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.jHU.setVisibility(8);
    }

    public void rj(boolean z) {
        if (this.jHU != null) {
            if (z) {
                this.jHU.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jHU, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jHU, R.drawable.push_bg_selector);
                this.jHU.setClickable(true);
            } else {
                this.jHU.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jHU, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jHU, (int) R.color.cp_cont_d);
                this.jHU.setClickable(false);
            }
            this.jHU.setVisibility(0);
        }
    }

    public void aH(bk bkVar) {
        if (bkVar != null && bkVar.aQT() != null) {
            int status = bkVar.aQT().getStatus();
            if (status == 1) {
                rj(true);
            } else if (status == 2) {
                rj(false);
            }
        }
    }

    public TextView cDY() {
        return this.jHU;
    }
}

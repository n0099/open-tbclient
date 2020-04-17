package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView jqb;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.jqb = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.jqb = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.jqb.setVisibility(8);
    }

    public void qL(boolean z) {
        if (this.jqb != null) {
            if (z) {
                this.jqb.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jqb, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jqb, R.drawable.push_bg_selector);
                this.jqb.setClickable(true);
            } else {
                this.jqb.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jqb, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jqb, (int) R.color.cp_cont_d);
                this.jqb.setClickable(false);
            }
            this.jqb.setVisibility(0);
        }
    }

    public void aH(bj bjVar) {
        if (bjVar != null && bjVar.aKY() != null) {
            int status = bjVar.aKY().getStatus();
            if (status == 1) {
                qL(true);
            } else if (status == 2) {
                qL(false);
            }
        }
    }

    public TextView cwN() {
        return this.jqb;
    }
}

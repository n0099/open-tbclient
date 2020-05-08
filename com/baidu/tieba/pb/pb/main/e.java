package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView jqf;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.jqf = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.jqf = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.jqf.setVisibility(8);
    }

    public void qL(boolean z) {
        if (this.jqf != null) {
            if (z) {
                this.jqf.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jqf, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jqf, R.drawable.push_bg_selector);
                this.jqf.setClickable(true);
            } else {
                this.jqf.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jqf, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jqf, (int) R.color.cp_cont_d);
                this.jqf.setClickable(false);
            }
            this.jqf.setVisibility(0);
        }
    }

    public void aH(bj bjVar) {
        if (bjVar != null && bjVar.aKW() != null) {
            int status = bjVar.aKW().getStatus();
            if (status == 1) {
                qL(true);
            } else if (status == 2) {
                qL(false);
            }
        }
    }

    public TextView cwK() {
        return this.jqf;
    }
}

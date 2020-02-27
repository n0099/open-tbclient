package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView iEf;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iEf = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.iEf = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iEf.setVisibility(8);
    }

    public void pB(boolean z) {
        if (this.iEf != null) {
            if (z) {
                this.iEf.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEf, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEf, R.drawable.push_bg_selector);
                this.iEf.setClickable(true);
            } else {
                this.iEf.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEf, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEf, (int) R.color.cp_cont_d);
                this.iEf.setClickable(false);
            }
            this.iEf.setVisibility(0);
        }
    }

    public void aF(bj bjVar) {
        if (bjVar != null && bjVar.aCG() != null) {
            int status = bjVar.aCG().getStatus();
            if (status == 1) {
                pB(true);
            } else if (status == 2) {
                pB(false);
            }
        }
    }

    public TextView clJ() {
        return this.iEf;
    }
}

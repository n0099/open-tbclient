package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView iEt;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iEt = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.iEt = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iEt.setVisibility(8);
    }

    public void pB(boolean z) {
        if (this.iEt != null) {
            if (z) {
                this.iEt.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEt, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEt, R.drawable.push_bg_selector);
                this.iEt.setClickable(true);
            } else {
                this.iEt.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEt, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEt, (int) R.color.cp_cont_d);
                this.iEt.setClickable(false);
            }
            this.iEt.setVisibility(0);
        }
    }

    public void aF(bj bjVar) {
        if (bjVar != null && bjVar.aCI() != null) {
            int status = bjVar.aCI().getStatus();
            if (status == 1) {
                pB(true);
            } else if (status == 2) {
                pB(false);
            }
        }
    }

    public TextView clM() {
        return this.iEt;
    }
}

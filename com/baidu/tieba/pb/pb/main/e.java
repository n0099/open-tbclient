package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView iEh;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iEh = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.iEh = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iEh.setVisibility(8);
    }

    public void pB(boolean z) {
        if (this.iEh != null) {
            if (z) {
                this.iEh.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEh, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEh, R.drawable.push_bg_selector);
                this.iEh.setClickable(true);
            } else {
                this.iEh.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iEh, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iEh, (int) R.color.cp_cont_d);
                this.iEh.setClickable(false);
            }
            this.iEh.setVisibility(0);
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

    public TextView clL() {
        return this.iEh;
    }
}

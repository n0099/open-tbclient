package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends ao {
    private TextView iFU;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iFU = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(d dVar) {
        this.iFU = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iFU.setVisibility(8);
    }

    public void pH(boolean z) {
        if (this.iFU != null) {
            if (z) {
                this.iFU.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iFU, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iFU, R.drawable.push_bg_selector);
                this.iFU.setClickable(true);
            } else {
                this.iFU.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iFU, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iFU, (int) R.color.cp_cont_d);
                this.iFU.setClickable(false);
            }
            this.iFU.setVisibility(0);
        }
    }

    public void aG(bj bjVar) {
        if (bjVar != null && bjVar.aCL() != null) {
            int status = bjVar.aCL().getStatus();
            if (status == 1) {
                pH(true);
            } else if (status == 2) {
                pH(false);
            }
        }
    }

    public TextView cmh() {
        return this.iFU;
    }
}

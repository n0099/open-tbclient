package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends ba {
    private TextView kzC;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kzC = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kzC = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kzC.setVisibility(8);
    }

    public void sI(boolean z) {
        if (this.kzC != null) {
            if (z) {
                this.kzC.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kzC, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kzC, R.drawable.push_bg_selector);
                this.kzC.setClickable(true);
            } else {
                this.kzC.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kzC, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kzC, R.color.cp_cont_d);
                this.kzC.setClickable(false);
            }
            this.kzC.setVisibility(0);
        }
    }

    public void aF(bw bwVar) {
        if (bwVar != null && bwVar.beZ() != null) {
            int status = bwVar.beZ().getStatus();
            if (status == 1) {
                sI(true);
            } else if (status == 2) {
                sI(false);
            }
        }
    }

    public TextView cWN() {
        return this.kzC;
    }
}

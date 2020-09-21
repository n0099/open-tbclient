package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends ba {
    private TextView kIg;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kIg = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kIg = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kIg.setVisibility(8);
    }

    public void sR(boolean z) {
        if (this.kIg != null) {
            if (z) {
                this.kIg.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIg, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kIg, R.drawable.push_bg_selector);
                this.kIg.setClickable(true);
            } else {
                this.kIg.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kIg, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kIg, R.color.cp_cont_d);
                this.kIg.setClickable(false);
            }
            this.kIg.setVisibility(0);
        }
    }

    public void aG(bw bwVar) {
        if (bwVar != null && bwVar.bfT() != null) {
            int status = bwVar.bfT().getStatus();
            if (status == 1) {
                sR(true);
            } else if (status == 2) {
                sR(false);
            }
        }
    }

    public TextView dar() {
        return this.kIg;
    }
}

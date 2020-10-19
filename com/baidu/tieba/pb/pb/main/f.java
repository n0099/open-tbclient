package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends ba {
    private TextView kXr;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kXr = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kXr = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kXr.setVisibility(8);
    }

    public void ty(boolean z) {
        if (this.kXr != null) {
            if (z) {
                this.kXr.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kXr, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kXr, R.drawable.push_bg_selector);
                this.kXr.setClickable(true);
            } else {
                this.kXr.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kXr, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kXr, R.color.cp_cont_d);
                this.kXr.setClickable(false);
            }
            this.kXr.setVisibility(0);
        }
    }

    public void aG(bw bwVar) {
        if (bwVar != null && bwVar.biC() != null) {
            int status = bwVar.biC().getStatus();
            if (status == 1) {
                ty(true);
            } else if (status == 2) {
                ty(false);
            }
        }
    }

    public TextView dea() {
        return this.kXr;
    }
}

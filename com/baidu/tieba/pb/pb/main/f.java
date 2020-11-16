package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends ba {
    private TextView lqg;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lqg = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.lqg = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lqg.setVisibility(8);
    }

    public void ub(boolean z) {
        if (this.lqg != null) {
            if (z) {
                this.lqg.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqg, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lqg, R.drawable.push_bg_selector);
                this.lqg.setClickable(true);
            } else {
                this.lqg.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lqg, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqg, R.color.CAM_X0109);
                this.lqg.setClickable(false);
            }
            this.lqg.setVisibility(0);
        }
    }

    public void aI(bx bxVar) {
        if (bxVar != null && bxVar.blX() != null) {
            int status = bxVar.blX().getStatus();
            if (status == 1) {
                ub(true);
            } else if (status == 2) {
                ub(false);
            }
        }
    }

    public TextView djf() {
        return this.lqg;
    }
}

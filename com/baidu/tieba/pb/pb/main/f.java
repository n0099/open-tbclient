package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends ba {
    private TextView lpR;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lpR = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.lpR = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lpR.setVisibility(8);
    }

    public void tY(boolean z) {
        if (this.lpR != null) {
            if (z) {
                this.lpR.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpR, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lpR, R.drawable.push_bg_selector);
                this.lpR.setClickable(true);
            } else {
                this.lpR.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lpR, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lpR, R.color.cp_cont_d);
                this.lpR.setClickable(false);
            }
            this.lpR.setVisibility(0);
        }
    }

    public void aG(bw bwVar) {
        if (bwVar != null && bwVar.bmV() != null) {
            int status = bwVar.bmV().getStatus();
            if (status == 1) {
                tY(true);
            } else if (status == 2) {
                tY(false);
            }
        }
    }

    public TextView djJ() {
        return this.lpR;
    }
}

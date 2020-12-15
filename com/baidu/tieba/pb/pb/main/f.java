package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends ba {
    private TextView lDR;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lDR = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.lDR = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lDR.setVisibility(8);
    }

    public void uD(boolean z) {
        if (this.lDR != null) {
            if (z) {
                this.lDR.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lDR, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lDR, R.drawable.push_bg_selector);
                this.lDR.setClickable(true);
            } else {
                this.lDR.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lDR, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lDR, R.color.CAM_X0109);
                this.lDR.setClickable(false);
            }
            this.lDR.setVisibility(0);
        }
    }

    public void aI(by byVar) {
        if (byVar != null && byVar.bpk() != null) {
            int status = byVar.bpk().getStatus();
            if (status == 1) {
                uD(true);
            } else if (status == 2) {
                uD(false);
            }
        }
    }

    public TextView dov() {
        return this.lDR;
    }
}

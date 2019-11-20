package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hKE;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hKE = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hKE = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hKE.setVisibility(8);
    }

    public void nY(boolean z) {
        if (this.hKE != null) {
            if (z) {
                this.hKE.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hKE, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hKE, R.drawable.push_bg_selector);
                this.hKE.setClickable(true);
            } else {
                this.hKE.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hKE, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hKE, (int) R.color.cp_cont_d);
                this.hKE.setClickable(false);
            }
            this.hKE.setVisibility(0);
        }
    }

    public void at(bh bhVar) {
        if (bhVar != null && bhVar.aiY() != null) {
            int status = bhVar.aiY().getStatus();
            if (status == 1) {
                nY(true);
            } else if (status == 2) {
                nY(false);
            }
        }
    }

    public TextView bRP() {
        return this.hKE;
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends aw {
    private TextView kbE;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kbE = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aw
    protected void a(e eVar) {
        this.kbE = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kbE.setVisibility(8);
    }

    public void rw(boolean z) {
        if (this.kbE != null) {
            if (z) {
                this.kbE.setText(R.string.push);
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kbE, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kbE, R.drawable.push_bg_selector);
                this.kbE.setClickable(true);
            } else {
                this.kbE.setText(R.string.already_push);
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kbE, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kbE, (int) R.color.cp_cont_d);
                this.kbE.setClickable(false);
            }
            this.kbE.setVisibility(0);
        }
    }

    public void aH(bu buVar) {
        if (buVar != null && buVar.aSK() != null) {
            int status = buVar.aSK().getStatus();
            if (status == 1) {
                rw(true);
            } else if (status == 2) {
                rw(false);
            }
        }
    }

    public TextView cIp() {
        return this.kbE;
    }
}

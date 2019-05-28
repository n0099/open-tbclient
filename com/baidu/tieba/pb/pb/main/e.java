package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hDN;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hDN = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hDN = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hDN.setVisibility(8);
    }

    public void nW(boolean z) {
        if (this.hDN != null) {
            if (z) {
                this.hDN.setText(R.string.push);
                com.baidu.tbadk.core.util.al.j(this.hDN, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hDN, R.drawable.push_bg_selector);
                this.hDN.setClickable(true);
            } else {
                this.hDN.setText(R.string.already_push);
                com.baidu.tbadk.core.util.al.k(this.hDN, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hDN, R.color.cp_cont_d);
                this.hDN.setClickable(false);
            }
            this.hDN.setVisibility(0);
        }
    }

    public void at(bg bgVar) {
        if (bgVar != null && bgVar.adP() != null) {
            int status = bgVar.adP().getStatus();
            if (status == 1) {
                nW(true);
            } else if (status == 2) {
                nW(false);
            }
        }
    }

    public TextView bRc() {
        return this.hDN;
    }
}

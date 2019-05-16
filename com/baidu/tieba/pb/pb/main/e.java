package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hDK;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hDK = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hDK = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hDK.setVisibility(8);
    }

    public void nW(boolean z) {
        if (this.hDK != null) {
            if (z) {
                this.hDK.setText(R.string.push);
                com.baidu.tbadk.core.util.al.j(this.hDK, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hDK, R.drawable.push_bg_selector);
                this.hDK.setClickable(true);
            } else {
                this.hDK.setText(R.string.already_push);
                com.baidu.tbadk.core.util.al.k(this.hDK, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hDK, R.color.cp_cont_d);
                this.hDK.setClickable(false);
            }
            this.hDK.setVisibility(0);
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

    public TextView bQZ() {
        return this.hDK;
    }
}

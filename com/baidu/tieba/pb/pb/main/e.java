package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hDO;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hDO = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hDO = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hDO.setVisibility(8);
    }

    public void nX(boolean z) {
        if (this.hDO != null) {
            if (z) {
                this.hDO.setText(R.string.push);
                com.baidu.tbadk.core.util.al.j(this.hDO, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.al.k(this.hDO, R.drawable.push_bg_selector);
                this.hDO.setClickable(true);
            } else {
                this.hDO.setText(R.string.already_push);
                com.baidu.tbadk.core.util.al.k(this.hDO, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.al.j(this.hDO, R.color.cp_cont_d);
                this.hDO.setClickable(false);
            }
            this.hDO.setVisibility(0);
        }
    }

    public void at(bg bgVar) {
        if (bgVar != null && bgVar.adP() != null) {
            int status = bgVar.adP().getStatus();
            if (status == 1) {
                nX(true);
            } else if (status == 2) {
                nX(false);
            }
        }
    }

    public TextView bRd() {
        return this.hDO;
    }
}

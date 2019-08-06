package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends ar {
    private TextView hKU;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.hKU = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.hKU = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.hKU.setVisibility(8);
    }

    public void ol(boolean z) {
        if (this.hKU != null) {
            if (z) {
                this.hKU.setText(R.string.push);
                com.baidu.tbadk.core.util.am.j(this.hKU, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.k(this.hKU, R.drawable.push_bg_selector);
                this.hKU.setClickable(true);
            } else {
                this.hKU.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.k(this.hKU, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.j(this.hKU, R.color.cp_cont_d);
                this.hKU.setClickable(false);
            }
            this.hKU.setVisibility(0);
        }
    }

    public void au(bh bhVar) {
        if (bhVar != null && bhVar.aeS() != null) {
            int status = bhVar.aeS().getStatus();
            if (status == 1) {
                ol(true);
            } else if (status == 2) {
                ol(false);
            }
        }
    }

    public TextView bUd() {
        return this.hKU;
    }
}

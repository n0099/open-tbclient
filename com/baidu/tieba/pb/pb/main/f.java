package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends aw {
    private TextView jGO;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.jGO = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aw
    protected void a(e eVar) {
        this.jGO = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.jGO.setVisibility(8);
    }

    public void rj(boolean z) {
        if (this.jGO != null) {
            if (z) {
                this.jGO.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jGO, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jGO, R.drawable.push_bg_selector);
                this.jGO.setClickable(true);
            } else {
                this.jGO.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jGO, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jGO, (int) R.color.cp_cont_d);
                this.jGO.setClickable(false);
            }
            this.jGO.setVisibility(0);
        }
    }

    public void aH(bk bkVar) {
        if (bkVar != null && bkVar.aQT() != null) {
            int status = bkVar.aQT().getStatus();
            if (status == 1) {
                rj(true);
            } else if (status == 2) {
                rj(false);
            }
        }
    }

    public TextView cDI() {
        return this.jGO;
    }
}

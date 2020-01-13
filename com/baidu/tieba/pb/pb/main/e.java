package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class e extends ar {
    private TextView iCw;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iCw = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.iCw = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iCw.setVisibility(8);
    }

    public void py(boolean z) {
        if (this.iCw != null) {
            if (z) {
                this.iCw.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iCw, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iCw, R.drawable.push_bg_selector);
                this.iCw.setClickable(true);
            } else {
                this.iCw.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iCw, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iCw, (int) R.color.cp_cont_d);
                this.iCw.setClickable(false);
            }
            this.iCw.setVisibility(0);
        }
    }

    public void aB(bj bjVar) {
        if (bjVar != null && bjVar.aAr() != null) {
            int status = bjVar.aAr().getStatus();
            if (status == 1) {
                py(true);
            } else if (status == 2) {
                py(false);
            }
        }
    }

    public TextView ckn() {
        return this.iCw;
    }
}

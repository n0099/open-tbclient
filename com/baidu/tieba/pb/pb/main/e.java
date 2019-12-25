package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends ar {
    private TextView iyS;

    public e(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.iyS = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(d dVar) {
        this.iyS = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.iyS.setVisibility(8);
    }

    public void pm(boolean z) {
        if (this.iyS != null) {
            if (z) {
                this.iyS.setText(R.string.push);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iyS, (int) R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iyS, R.drawable.push_bg_selector);
                this.iyS.setClickable(true);
            } else {
                this.iyS.setText(R.string.already_push);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iyS, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iyS, (int) R.color.cp_cont_d);
                this.iyS.setClickable(false);
            }
            this.iyS.setVisibility(0);
        }
    }

    public void aA(bj bjVar) {
        if (bjVar != null && bjVar.azY() != null) {
            int status = bjVar.azY().getStatus();
            if (status == 1) {
                pm(true);
            } else if (status == 2) {
                pm(false);
            }
        }
    }

    public TextView cjf() {
        return this.iyS;
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends ba {
    private TextView ljQ;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.ljQ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.ljQ = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.ljQ.setVisibility(8);
    }

    public void tP(boolean z) {
        if (this.ljQ != null) {
            if (z) {
                this.ljQ.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ljQ, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ljQ, R.drawable.push_bg_selector);
                this.ljQ.setClickable(true);
            } else {
                this.ljQ.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ljQ, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ljQ, R.color.cp_cont_d);
                this.ljQ.setClickable(false);
            }
            this.ljQ.setVisibility(0);
        }
    }

    public void aG(bw bwVar) {
        if (bwVar != null && bwVar.bkv() != null) {
            int status = bwVar.bkv().getStatus();
            if (status == 1) {
                tP(true);
            } else if (status == 2) {
                tP(false);
            }
        }
    }

    public TextView dhh() {
        return this.ljQ;
    }
}

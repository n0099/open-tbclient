package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends ba {
    private TextView kzJ;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kzJ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kzJ = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kzJ.setVisibility(8);
    }

    public void sK(boolean z) {
        if (this.kzJ != null) {
            if (z) {
                this.kzJ.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kzJ, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kzJ, R.drawable.push_bg_selector);
                this.kzJ.setClickable(true);
            } else {
                this.kzJ.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kzJ, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kzJ, R.color.cp_cont_d);
                this.kzJ.setClickable(false);
            }
            this.kzJ.setVisibility(0);
        }
    }

    public void aF(bw bwVar) {
        if (bwVar != null && bwVar.beZ() != null) {
            int status = bwVar.beZ().getStatus();
            if (status == 1) {
                sK(true);
            } else if (status == 2) {
                sK(false);
            }
        }
    }

    public TextView cWO() {
        return this.kzJ;
    }
}

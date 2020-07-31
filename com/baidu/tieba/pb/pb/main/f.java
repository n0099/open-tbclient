package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends ba {
    private TextView kki;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kki = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kki = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kki.setVisibility(8);
    }

    public void sb(boolean z) {
        if (this.kki != null) {
            if (z) {
                this.kki.setText(R.string.push);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kki, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kki, R.drawable.push_bg_selector);
                this.kki.setClickable(true);
            } else {
                this.kki.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kki, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kki, R.color.cp_cont_d);
                this.kki.setClickable(false);
            }
            this.kki.setVisibility(0);
        }
    }

    public void aE(bv bvVar) {
        if (bvVar != null && bvVar.aWG() != null) {
            int status = bvVar.aWG().getStatus();
            if (status == 1) {
                sb(true);
            } else if (status == 2) {
                sb(false);
            }
        }
    }

    public TextView cLZ() {
        return this.kki;
    }
}

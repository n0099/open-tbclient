package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends ba {
    private TextView kkk;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.kkk = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ba
    protected void a(e eVar) {
        this.kkk = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.kkk.setVisibility(8);
    }

    public void sb(boolean z) {
        if (this.kkk != null) {
            if (z) {
                this.kkk.setText(R.string.push);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kkk, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kkk, R.drawable.push_bg_selector);
                this.kkk.setClickable(true);
            } else {
                this.kkk.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kkk, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kkk, R.color.cp_cont_d);
                this.kkk.setClickable(false);
            }
            this.kkk.setVisibility(0);
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
        return this.kkk;
    }
}

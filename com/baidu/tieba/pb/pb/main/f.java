package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lEr;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lEr = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lEr = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lEr.setVisibility(8);
    }

    public void uA(boolean z) {
        if (this.lEr != null) {
            if (z) {
                this.lEr.setText(R.string.push);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lEr, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lEr, R.drawable.push_bg_selector);
                this.lEr.setClickable(true);
            } else {
                this.lEr.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lEr, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lEr, R.color.CAM_X0109);
                this.lEr.setClickable(false);
            }
            this.lEr.setVisibility(0);
        }
    }

    public void aJ(bz bzVar) {
        if (bzVar != null && bzVar.bnR() != null) {
            int status = bzVar.bnR().getStatus();
            if (status == 1) {
                uA(true);
            } else if (status == 2) {
                uA(false);
            }
        }
    }

    public TextView dkn() {
        return this.lEr;
    }
}

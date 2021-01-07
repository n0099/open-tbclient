package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lIW;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lIW = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lIW = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lIW.setVisibility(8);
    }

    public void uE(boolean z) {
        if (this.lIW != null) {
            if (z) {
                this.lIW.setText(R.string.push);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lIW, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lIW, R.drawable.push_bg_selector);
                this.lIW.setClickable(true);
            } else {
                this.lIW.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lIW, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lIW, R.color.CAM_X0109);
                this.lIW.setClickable(false);
            }
            this.lIW.setVisibility(0);
        }
    }

    public void aJ(bz bzVar) {
        if (bzVar != null && bzVar.brL() != null) {
            int status = bzVar.brL().getStatus();
            if (status == 1) {
                uE(true);
            } else if (status == 2) {
                uE(false);
            }
        }
    }

    public TextView dog() {
        return this.lIW;
    }
}

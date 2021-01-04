package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lIX;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lIX = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lIX = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lIX.setVisibility(8);
    }

    public void uE(boolean z) {
        if (this.lIX != null) {
            if (z) {
                this.lIX.setText(R.string.push);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lIX, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lIX, R.drawable.push_bg_selector);
                this.lIX.setClickable(true);
            } else {
                this.lIX.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lIX, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lIX, R.color.CAM_X0109);
                this.lIX.setClickable(false);
            }
            this.lIX.setVisibility(0);
        }
    }

    public void aJ(bz bzVar) {
        if (bzVar != null && bzVar.brK() != null) {
            int status = bzVar.brK().getStatus();
            if (status == 1) {
                uE(true);
            } else if (status == 2) {
                uE(false);
            }
        }
    }

    public TextView dof() {
        return this.lIX;
    }
}

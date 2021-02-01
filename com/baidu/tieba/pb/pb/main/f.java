package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lNg;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lNg = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lNg = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lNg.setVisibility(8);
    }

    public void uO(boolean z) {
        if (this.lNg != null) {
            if (z) {
                this.lNg.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNg, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNg, R.drawable.push_bg_selector);
                this.lNg.setClickable(true);
            } else {
                this.lNg.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNg, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNg, R.color.CAM_X0109);
                this.lNg.setClickable(false);
            }
            this.lNg.setVisibility(0);
        }
    }

    public void aK(cb cbVar) {
        if (cbVar != null && cbVar.bok() != null) {
            int status = cbVar.bok().getStatus();
            if (status == 1) {
                uO(true);
            } else if (status == 2) {
                uO(false);
            }
        }
    }

    public TextView dmA() {
        return this.lNg;
    }
}

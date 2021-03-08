package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lPx;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lPx = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lPx = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lPx.setVisibility(8);
    }

    public void uO(boolean z) {
        if (this.lPx != null) {
            if (z) {
                this.lPx.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPx, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lPx, R.drawable.push_bg_selector);
                this.lPx.setClickable(true);
            } else {
                this.lPx.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lPx, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPx, R.color.CAM_X0109);
                this.lPx.setClickable(false);
            }
            this.lPx.setVisibility(0);
        }
    }

    public void aK(cb cbVar) {
        if (cbVar != null && cbVar.bom() != null) {
            int status = cbVar.bom().getStatus();
            if (status == 1) {
                uO(true);
            } else if (status == 2) {
                uO(false);
            }
        }
    }

    public TextView dmQ() {
        return this.lPx;
    }
}

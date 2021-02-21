package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends aq {
    private TextView lNv;

    public f(BaseFragmentActivity baseFragmentActivity, View view) {
        super(baseFragmentActivity, view);
        this.lNv = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(e eVar) {
        this.lNv = (TextView) this.mRootView.findViewById(R.id.icon_push);
        this.lNv.setVisibility(8);
    }

    public void uO(boolean z) {
        if (this.lNv != null) {
            if (z) {
                this.lNv.setText(R.string.push);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNv, R.drawable.push_text_selector);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNv, R.drawable.push_bg_selector);
                this.lNv.setClickable(true);
            } else {
                this.lNv.setText(R.string.already_push);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNv, R.drawable.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNv, R.color.CAM_X0109);
                this.lNv.setClickable(false);
            }
            this.lNv.setVisibility(0);
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

    public TextView dmH() {
        return this.lNv;
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends gl {
    private TextView ehm;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ehm = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void a(e eVar) {
        this.ehm = (TextView) this.mRootView.findViewById(r.h.icon_push);
        this.ehm.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void onChangeSkinType(int i) {
    }

    public void il(boolean z) {
        if (this.ehm != null) {
            if (z) {
                this.ehm.setText(r.l.push);
                com.baidu.tbadk.core.util.ap.i((View) this.ehm, r.g.push_text_selector);
                com.baidu.tbadk.core.util.ap.j((View) this.ehm, r.g.push_bg_selector);
                this.ehm.setClickable(true);
            } else {
                this.ehm.setText(r.l.already_push);
                com.baidu.tbadk.core.util.ap.j((View) this.ehm, r.g.label_bg_gray80);
                com.baidu.tbadk.core.util.ap.i((View) this.ehm, r.e.cp_cont_d);
                this.ehm.setClickable(false);
            }
            this.ehm.setVisibility(0);
        }
    }

    public void F(com.baidu.tbadk.core.data.bh bhVar) {
        if (bhVar != null && bhVar.rQ() != null) {
            int status = bhVar.rQ().getStatus();
            if (status == 1) {
                il(true);
            } else if (status == 2) {
                il(false);
            }
        }
    }

    public TextView aKJ() {
        return this.ehm;
    }
}

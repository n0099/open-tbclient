package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends gl {
    private TextView eke;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eke = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void a(e eVar) {
        this.eke = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.eke.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void onChangeSkinType(int i) {
    }

    public void ig(boolean z) {
        if (this.eke != null) {
            if (z) {
                this.eke.setText(w.l.push);
                com.baidu.tbadk.core.util.aq.i((View) this.eke, w.g.push_text_selector);
                com.baidu.tbadk.core.util.aq.j(this.eke, w.g.push_bg_selector);
                this.eke.setClickable(true);
            } else {
                this.eke.setText(w.l.already_push);
                com.baidu.tbadk.core.util.aq.j(this.eke, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aq.i((View) this.eke, w.e.cp_cont_d);
                this.eke.setClickable(false);
            }
            this.eke.setVisibility(0);
        }
    }

    public void G(com.baidu.tbadk.core.data.bj bjVar) {
        if (bjVar != null && bjVar.sk() != null) {
            int status = bjVar.sk().getStatus();
            if (status == 1) {
                ig(true);
            } else if (status == 2) {
                ig(false);
            }
        }
    }

    public TextView aKe() {
        return this.eke;
    }
}

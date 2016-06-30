package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g extends ga {
    private TextView dOj;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.dOj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ga
    protected void a(e eVar) {
        this.dOj = (TextView) this.mRootView.findViewById(u.g.icon_push);
        this.dOj.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.ga
    protected void onChangeSkinType(int i) {
    }

    public void hm(boolean z) {
        if (this.dOj != null) {
            if (z) {
                this.dOj.setText(u.j.push);
                com.baidu.tbadk.core.util.av.j((View) this.dOj, u.f.push_text_selector);
                com.baidu.tbadk.core.util.av.k(this.dOj, u.f.push_bg_selector);
                this.dOj.setClickable(true);
            } else {
                this.dOj.setText(u.j.already_push);
                com.baidu.tbadk.core.util.av.k(this.dOj, u.f.label_bg_gray80);
                com.baidu.tbadk.core.util.av.j((View) this.dOj, u.d.cp_cont_d);
                this.dOj.setClickable(false);
            }
            this.dOj.setVisibility(0);
        }
    }

    public void q(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null && azVar.qY() != null) {
            int status = azVar.qY().getStatus();
            if (status == 1) {
                hm(true);
            } else if (status == 2) {
                hm(false);
            }
        }
    }

    public TextView aEy() {
        return this.dOj;
    }
}

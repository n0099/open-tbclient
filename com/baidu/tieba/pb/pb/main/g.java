package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends gi {
    private TextView euj;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.euj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gi
    protected void a(e eVar) {
        this.euj = (TextView) this.mRootView.findViewById(r.g.icon_push);
        this.euj.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gi
    protected void onChangeSkinType(int i) {
    }

    public void im(boolean z) {
        if (this.euj != null) {
            if (z) {
                this.euj.setText(r.j.push);
                com.baidu.tbadk.core.util.at.j((View) this.euj, r.f.push_text_selector);
                com.baidu.tbadk.core.util.at.k(this.euj, r.f.push_bg_selector);
                this.euj.setClickable(true);
            } else {
                this.euj.setText(r.j.already_push);
                com.baidu.tbadk.core.util.at.k(this.euj, r.f.label_bg_gray80);
                com.baidu.tbadk.core.util.at.j((View) this.euj, r.d.cp_cont_d);
                this.euj.setClickable(false);
            }
            this.euj.setVisibility(0);
        }
    }

    public void v(com.baidu.tbadk.core.data.bk bkVar) {
        if (bkVar != null && bkVar.sh() != null) {
            int status = bkVar.sh().getStatus();
            if (status == 1) {
                im(true);
            } else if (status == 2) {
                im(false);
            }
        }
    }

    public TextView aOX() {
        return this.euj;
    }
}

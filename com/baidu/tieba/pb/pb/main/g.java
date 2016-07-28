package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g extends ge {
    private TextView eaw;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eaw = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ge
    protected void a(e eVar) {
        this.eaw = (TextView) this.mRootView.findViewById(u.g.icon_push);
        this.eaw.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.ge
    protected void onChangeSkinType(int i) {
    }

    public void hx(boolean z) {
        if (this.eaw != null) {
            if (z) {
                this.eaw.setText(u.j.push);
                com.baidu.tbadk.core.util.av.j((View) this.eaw, u.f.push_text_selector);
                com.baidu.tbadk.core.util.av.k(this.eaw, u.f.push_bg_selector);
                this.eaw.setClickable(true);
            } else {
                this.eaw.setText(u.j.already_push);
                com.baidu.tbadk.core.util.av.k(this.eaw, u.f.label_bg_gray80);
                com.baidu.tbadk.core.util.av.j((View) this.eaw, u.d.cp_cont_d);
                this.eaw.setClickable(false);
            }
            this.eaw.setVisibility(0);
        }
    }

    public void s(com.baidu.tbadk.core.data.be beVar) {
        if (beVar != null && beVar.qO() != null) {
            int status = beVar.qO().getStatus();
            if (status == 1) {
                hx(true);
            } else if (status == 2) {
                hx(false);
            }
        }
    }

    public TextView aHI() {
        return this.eaw;
    }
}

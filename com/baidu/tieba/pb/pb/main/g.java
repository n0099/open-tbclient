package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends gf {
    private TextView eoz;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eoz = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void a(e eVar) {
        this.eoz = (TextView) this.mRootView.findViewById(r.g.icon_push);
        this.eoz.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void onChangeSkinType(int i) {
    }

    public void hW(boolean z) {
        if (this.eoz != null) {
            if (z) {
                this.eoz.setText(r.j.push);
                com.baidu.tbadk.core.util.av.j((View) this.eoz, r.f.push_text_selector);
                com.baidu.tbadk.core.util.av.k(this.eoz, r.f.push_bg_selector);
                this.eoz.setClickable(true);
            } else {
                this.eoz.setText(r.j.already_push);
                com.baidu.tbadk.core.util.av.k(this.eoz, r.f.label_bg_gray80);
                com.baidu.tbadk.core.util.av.j((View) this.eoz, r.d.cp_cont_d);
                this.eoz.setClickable(false);
            }
            this.eoz.setVisibility(0);
        }
    }

    public void s(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar != null && biVar.sf() != null) {
            int status = biVar.sf().getStatus();
            if (status == 1) {
                hW(true);
            } else if (status == 2) {
                hW(false);
            }
        }
    }

    public TextView aNf() {
        return this.eoz;
    }
}

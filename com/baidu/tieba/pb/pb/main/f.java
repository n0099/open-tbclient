package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends as {
    private TextView eRI;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eRI = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.eRI = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.eRI.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.eRI != null) {
            if (z) {
                this.eRI.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.i(this.eRI, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eRI, d.f.push_bg_selector);
                this.eRI.setClickable(true);
            } else {
                this.eRI.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eRI, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eRI, d.C0082d.cp_cont_d);
                this.eRI.setClickable(false);
            }
            this.eRI.setVisibility(0);
        }
    }

    public void W(bd bdVar) {
        if (bdVar != null && bdVar.rS() != null) {
            int status = bdVar.rS().getStatus();
            if (status == 1) {
                jc(true);
            } else if (status == 2) {
                jc(false);
            }
        }
    }

    public TextView aSC() {
        return this.eRI;
    }
}

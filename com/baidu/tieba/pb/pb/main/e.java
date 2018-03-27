package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends as {
    private TextView fKN;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fKN = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fKN = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fKN.setVisibility(8);
    }

    public void jZ(boolean z) {
        if (this.fKN != null) {
            if (z) {
                this.fKN.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.r(this.fKN, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.s(this.fKN, d.f.push_bg_selector);
                this.fKN.setClickable(true);
            } else {
                this.fKN.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.s(this.fKN, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.r(this.fKN, d.C0141d.cp_cont_d);
                this.fKN.setClickable(false);
            }
            this.fKN.setVisibility(0);
        }
    }

    public void Z(bd bdVar) {
        if (bdVar != null && bdVar.zI() != null) {
            int status = bdVar.zI().getStatus();
            if (status == 1) {
                jZ(true);
            } else if (status == 2) {
                jZ(false);
            }
        }
    }

    public TextView bbL() {
        return this.fKN;
    }
}

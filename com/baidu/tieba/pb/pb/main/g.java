package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends ha {
    private TextView elj;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.elj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ha
    protected void a(e eVar) {
        this.elj = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.elj.setVisibility(8);
    }

    public void ie(boolean z) {
        if (this.elj != null) {
            if (z) {
                this.elj.setText(w.l.push);
                com.baidu.tbadk.core.util.aq.i(this.elj, w.g.push_text_selector);
                com.baidu.tbadk.core.util.aq.j(this.elj, w.g.push_bg_selector);
                this.elj.setClickable(true);
            } else {
                this.elj.setText(w.l.already_push);
                com.baidu.tbadk.core.util.aq.j(this.elj, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aq.i(this.elj, w.e.cp_cont_d);
                this.elj.setClickable(false);
            }
            this.elj.setVisibility(0);
        }
    }

    public void O(com.baidu.tbadk.core.data.bl blVar) {
        if (blVar != null && blVar.rO() != null) {
            int status = blVar.rO().getStatus();
            if (status == 1) {
                ie(true);
            } else if (status == 2) {
                ie(false);
            }
        }
    }

    public TextView aJz() {
        return this.elj;
    }
}

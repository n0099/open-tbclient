package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fWo;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fWo = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fWo = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fWo.setVisibility(8);
    }

    public void kH(boolean z) {
        if (this.fWo != null) {
            if (z) {
                this.fWo.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fWo, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fWo, e.f.push_bg_selector);
                this.fWo.setClickable(true);
            } else {
                this.fWo.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fWo, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fWo, e.d.cp_cont_d);
                this.fWo.setClickable(false);
            }
            this.fWo.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.Ao() != null) {
            int status = bbVar.Ao().getStatus();
            if (status == 1) {
                kH(true);
            } else if (status == 2) {
                kH(false);
            }
        }
    }

    public TextView biO() {
        return this.fWo;
    }
}

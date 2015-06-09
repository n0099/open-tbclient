package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView ccl;
    private View ccm;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hr().inflate(context, r.scroll_fragment_indicator, this);
        this.ccl = (TextView) findViewById(q.scroll_fragment_indicator_text);
        this.ccm = findViewById(q.scroll_fragment_indicator_line);
        setSelected(false);
    }

    public void setText(String str) {
        this.ccl.setText(str);
    }

    public void setTextSize(float f) {
        this.ccl.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.ccl.setTextSize(i, f);
    }

    public void setText(int i) {
        this.ccl.setText(i);
    }

    public void rU() {
        if (isSelected()) {
            ay.b(this.ccl, n.cp_link_tip_a, 1);
        } else {
            ay.b(this.ccl, n.cp_cont_f, 1);
        }
        ay.j(this.ccm, n.cp_link_tip_a);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (isSelected()) {
            ay.b(this.ccl, n.cp_link_tip_a, 1);
            this.ccm.setVisibility(0);
            return;
        }
        ay.b(this.ccl, n.cp_cont_f, 1);
        this.ccm.setVisibility(4);
    }
}

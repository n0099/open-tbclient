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
    private TextView cck;
    private View ccl;

    public b(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        com.baidu.adp.lib.g.b.hr().inflate(context, r.scroll_fragment_indicator, this);
        this.cck = (TextView) findViewById(q.scroll_fragment_indicator_text);
        this.ccl = findViewById(q.scroll_fragment_indicator_line);
        setSelected(false);
    }

    public void setText(String str) {
        this.cck.setText(str);
    }

    public void setTextSize(float f) {
        this.cck.setTextSize(f);
    }

    public void setTextSize(int i, float f) {
        this.cck.setTextSize(i, f);
    }

    public void setText(int i) {
        this.cck.setText(i);
    }

    public void rU() {
        if (isSelected()) {
            ay.b(this.cck, n.cp_link_tip_a, 1);
        } else {
            ay.b(this.cck, n.cp_cont_f, 1);
        }
        ay.j(this.ccl, n.cp_link_tip_a);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (isSelected()) {
            ay.b(this.cck, n.cp_link_tip_a, 1);
            this.ccl.setVisibility(0);
            return;
        }
        ay.b(this.cck, n.cp_cont_f, 1);
        this.ccl.setVisibility(4);
    }
}

package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView cBd;
    private ImageView cBe;
    private View cBf;
    private Context mContext;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cBd = (TextView) findViewById(q.prefix_text);
        this.cBe = (ImageView) findViewById(q.prefix_checked);
        this.cBf = findViewById(q.prefix_item_divider);
        this.cBd.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ay.i((View) this.cBd, n.cp_bg_line_d);
        this.cBe.setBackgroundDrawable(ay.getDrawable(p.icon_set_list_ok_s));
        ay.i(this.cBf, n.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cBd.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cBd.setTextColor(i);
    }

    public void fD(boolean z) {
        if (z) {
            this.cBe.setVisibility(0);
        } else {
            this.cBe.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.cBf.getLayoutParams()).setMargins(com.baidu.adp.lib.util.n.d(this.mContext, o.ds30), 0, com.baidu.adp.lib.util.n.d(this.mContext, o.ds30), 0);
        }
    }
}

package com.baidu.tieba.write.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView cwL;
    private ImageView cwM;
    private View cwN;
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
        com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.prefix_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.cwL = (TextView) findViewById(v.prefix_text);
        this.cwM = (ImageView) findViewById(v.prefix_checked);
        this.cwN = findViewById(v.prefix_item_divider);
        this.cwL.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ba.i((View) this.cwL, s.cp_bg_line_d);
        this.cwM.setBackgroundDrawable(ba.getDrawable(u.icon_set_list_ok_s));
        ba.i(this.cwN, s.cp_bg_line_c);
    }

    public void setPrefixText(String str) {
        this.cwL.setText(str);
    }

    public void setPrefixTextColor(int i) {
        this.cwL.setTextColor(i);
    }

    public void fh(boolean z) {
        if (z) {
            this.cwM.setVisibility(0);
        } else {
            this.cwM.setVisibility(8);
        }
    }

    public void setDividerStyle(boolean z) {
        if (!z) {
            ((LinearLayout.LayoutParams) this.cwN.getLayoutParams()).setMargins(n.d(this.mContext, t.ds30), 0, n.d(this.mContext, t.ds30), 0);
        }
    }
}

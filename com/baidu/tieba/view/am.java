package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class am {
    View a;
    private View b;
    private FrameLayout c;
    private TextView d;
    private Context e;

    public am(View view, Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.e = context;
        this.a = view;
        this.b = this.a.findViewById(R.id.frs_header_divider_fortune);
        this.c = (FrameLayout) this.a.findViewById(R.id.frs_fortune_layout);
        this.d = (TextView) this.a.findViewById(R.id.frs_header_fortune_arrow);
        this.d.setText("");
    }

    public final void a(String str) {
        this.d.setText(String.format(this.e.getResources().getString(R.string.frs_fu_text), str));
    }

    public final void a() {
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    public final void b() {
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public final boolean a(View view) {
        return view != null && view.equals(this.c);
    }
}

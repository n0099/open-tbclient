package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchBoxView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1963a;
    private String b;
    private LinearLayout c;
    private LinearLayout d;
    private TextView e;
    private View.OnClickListener f;

    public SearchBoxView(Context context) {
        super(context);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bc(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bc(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bc(this);
        a(context);
    }

    private void a(Context context) {
        this.f1963a = (Activity) context;
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.widget_search_box, (ViewGroup) null));
        requestLayout();
        invalidate();
        this.c = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.d = (LinearLayout) findViewById(R.id.search_tap_layout);
        this.e = (TextView) findViewById(R.id.search_bar_text);
        this.c.setOnClickListener(this.f);
    }

    public void setClickStatKey(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (this.f1963a instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.f1963a;
            jVar.l().a(i == 1);
            jVar.l().a(this);
        }
        if (i == 1) {
            this.e.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text_1));
        } else {
            this.e.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text));
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.e.setHint(charSequence);
    }

    public void setText(int i) {
        this.e.setHint(i);
    }
}

package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class SearchBoxView extends RelativeLayout {
    private Activity a;
    private String b;
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private View.OnClickListener f;
    private View.OnClickListener g;

    public SearchBoxView(Context context) {
        super(context);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new x(this);
        this.g = new y(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new x(this);
        this.g = new y(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new x(this);
        this.g = new y(this);
        a(context);
    }

    private void a(Context context) {
        this.a = (Activity) context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.widget_search_box, this);
        this.c = (LinearLayout) findViewById(com.baidu.tieba.v.search_bg_layout);
        this.d = (TextView) findViewById(com.baidu.tieba.v.search_bar_text);
        this.c.setOnClickListener(this.g);
        this.e = (TextView) findViewById(com.baidu.tieba.v.search_from_qr);
        this.e.setOnClickListener(this.f);
    }

    public void setClickStatKey(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (this.a instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.a;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a((View) this);
        }
        if (this.a instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.a;
            baseFragmentActivity.a().a(i == 1);
            baseFragmentActivity.a().a((View) this);
        }
        if (i == 1) {
            this.d.setHintTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text_1));
            setBackgroundColor(getResources().getColor(com.baidu.tieba.s.search_box_bg_1));
            return;
        }
        this.d.setHintTextColor(getResources().getColor(com.baidu.tieba.s.widget_searchbox_text));
        setBackgroundColor(getResources().getColor(com.baidu.tieba.s.search_box_bg));
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.d.setHint(charSequence);
    }

    public void setText(int i) {
        this.d.setHint(i);
    }
}

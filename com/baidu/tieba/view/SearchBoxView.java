package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchBoxView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2549a;
    private String b;
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private View.OnClickListener f;

    public SearchBoxView(Context context) {
        super(context);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.f = new bc(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.f = new bc(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.f = new bc(this);
        a(context);
    }

    private void a(Context context) {
        this.f2549a = (Activity) context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.widget_search_box, this);
        this.c = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.d = (TextView) findViewById(R.id.search_bar_text);
        this.c.setOnClickListener(this.f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int a2 = UtilHelper.a(context, 10.0f);
        int a3 = UtilHelper.a(context, 6.0f);
        layoutParams.setMargins(a2, a3, a2, a3);
        this.c.setLayoutParams(layoutParams);
        this.e = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, UtilHelper.a(context, 1.0f));
        layoutParams2.addRule(3, R.id.search_bg_layout);
        this.e.setLayoutParams(layoutParams2);
        addView(this.e);
    }

    public void setClickStatKey(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (this.f2549a instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.f2549a;
            jVar.getLayoutMode().a(i == 1);
            jVar.getLayoutMode().a(this);
        }
        if (this.f2549a instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.f2549a;
            baseFragmentActivity.a().a(i == 1);
            baseFragmentActivity.a().a(this);
        }
        if (i == 1) {
            this.d.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text_1));
            this.e.setBackgroundColor(getResources().getColor(R.color.search_box_line_1));
            setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            return;
        }
        this.d.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text));
        this.e.setBackgroundColor(getResources().getColor(R.color.search_box_line));
        setBackgroundColor(getResources().getColor(R.color.search_box_bg));
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

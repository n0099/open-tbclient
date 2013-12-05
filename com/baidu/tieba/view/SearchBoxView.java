package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchBoxView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2647a;
    private String b;
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private View.OnClickListener f;
    private View.OnClickListener g;

    public void a(int i, int i2, Intent intent) {
    }

    public SearchBoxView(Context context) {
        super(context);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bd(this);
        this.g = new be(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bd(this);
        this.g = new be(this);
        a(context);
    }

    public SearchBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "sq_tb_search";
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new bd(this);
        this.g = new be(this);
        a(context);
    }

    private void a(Context context) {
        this.f2647a = (Activity) context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.widget_search_box, this);
        this.c = (LinearLayout) findViewById(R.id.search_bg_layout);
        this.d = (TextView) findViewById(R.id.search_bar_text);
        this.c.setOnClickListener(this.g);
        this.e = (TextView) findViewById(R.id.search_from_qr);
        this.e.setOnClickListener(this.f);
    }

    public void setClickStatKey(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (this.f2647a instanceof com.baidu.tieba.j) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.f2647a;
            jVar.getLayoutMode().a(i == 1);
            jVar.getLayoutMode().a(this);
        }
        if (this.f2647a instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.f2647a;
            baseFragmentActivity.a().a(i == 1);
            baseFragmentActivity.a().a(this);
        }
        if (i == 1) {
            this.d.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text_1));
            setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            return;
        }
        this.d.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text));
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

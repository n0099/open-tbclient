package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonTabView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20706e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20707f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20708g;

    /* renamed from: h  reason: collision with root package name */
    public View f20709h;

    /* renamed from: i  reason: collision with root package name */
    public View f20710i;
    public View j;
    public View k;
    public int l;
    public int m;
    public int n;
    public b o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.main_thread_btn) {
                PersonTabView.this.setCurrentTab(0);
            } else if (view.getId() == R.id.reply_btn) {
                PersonTabView.this.setCurrentTab(1);
            }
            if (PersonTabView.this.o != null) {
                PersonTabView.this.o.onTabSelect(PersonTabView.this.l);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onTabSelect(int i2);
    }

    public PersonTabView(Context context) {
        super(context);
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a();
        c(context);
    }

    public final void c(Context context) {
        this.f20706e = context;
        LayoutInflater.from(context).inflate(R.layout.person_button_header_view, this);
        TextView textView = (TextView) findViewById(R.id.main_thread_btn);
        this.f20707f = textView;
        textView.setOnClickListener(this.p);
        TextView textView2 = (TextView) findViewById(R.id.reply_btn);
        this.f20708g = textView2;
        textView2.setOnClickListener(this.p);
        this.f20709h = findViewById(R.id.main_thread_divider);
        this.f20710i = findViewById(R.id.reply_btn_divider);
        this.j = findViewById(R.id.main_thread_bottom_divider);
        this.k = findViewById(R.id.reply_btn_bottom_divider);
        setCurrentTab(0);
    }

    public void setCurrentTab(int i2) {
        if (i2 == this.l) {
            return;
        }
        this.l = i2;
        if (i2 == 0) {
            this.f20709h.setVisibility(0);
            this.f20710i.setVisibility(4);
            this.f20707f.setTextColor(this.m);
            this.f20708g.setTextColor(this.n);
        } else if (i2 == 1) {
            this.f20709h.setVisibility(4);
            this.f20710i.setVisibility(0);
            this.f20707f.setTextColor(this.n);
            this.f20708g.setTextColor(this.m);
        }
    }

    public void setOnTabSelectListener(b bVar) {
        this.o = bVar;
    }

    public PersonTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a();
        c(context);
    }

    public PersonTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = 0;
        this.m = SkinManager.getColor(R.color.CAM_X0105);
        this.n = SkinManager.getColor(R.color.CAM_X0106);
        this.p = new a();
        c(context);
    }
}

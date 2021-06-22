package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import d.a.c.a.j;
import d.a.o0.s1.c.b.d;
/* loaded from: classes4.dex */
public class CategoryView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18364e;

    /* renamed from: f  reason: collision with root package name */
    public View f18365f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18366g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18367h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f18368i;
    public d j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || CategoryView.this.j == null || StringUtils.isNull(CategoryView.this.j.c()) || StringUtils.isNull(CategoryView.this.j.b())) {
                return;
            }
            int a2 = CategoryView.this.j.a();
            if (a2 == 1) {
                TiebaStatic.log("c10441");
            } else if (a2 == 2) {
                TiebaStatic.log("c10443");
            } else if (a2 == 3) {
                TiebaStatic.log("c10449");
            }
            MemberCenterStatic.a((TbPageContext) j.a(CategoryView.this.f18364e), new String[]{CategoryView.this.j.c()});
        }
    }

    public CategoryView(Context context) {
        super(context);
        this.k = new a();
        this.f18364e = context;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f18364e).inflate(R.layout.index_category, this);
        this.f18365f = inflate;
        this.f18366g = (TextView) inflate.findViewById(R.id.class_name);
        this.f18367h = (TextView) this.f18365f.findViewById(R.id.sprend_name);
        this.f18368i = (ImageView) this.f18365f.findViewById(R.id.spread_icon);
        this.f18365f.setOnClickListener(this.k);
        this.f18368i.setOnClickListener(this.k);
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a();
        this.f18364e = context;
        c();
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.k = new a();
        this.f18364e = context;
        c();
    }
}

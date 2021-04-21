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
import d.b.c.a.j;
import d.b.j0.r1.c.b.d;
/* loaded from: classes3.dex */
public class CategoryView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18592e;

    /* renamed from: f  reason: collision with root package name */
    public View f18593f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18594g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18595h;
    public ImageView i;
    public d j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
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
            MemberCenterStatic.a((TbPageContext) j.a(CategoryView.this.f18592e), new String[]{CategoryView.this.j.c()});
        }
    }

    public CategoryView(Context context) {
        super(context);
        this.k = new a();
        this.f18592e = context;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f18592e).inflate(R.layout.index_category, this);
        this.f18593f = inflate;
        this.f18594g = (TextView) inflate.findViewById(R.id.class_name);
        this.f18595h = (TextView) this.f18593f.findViewById(R.id.sprend_name);
        this.i = (ImageView) this.f18593f.findViewById(R.id.spread_icon);
        this.f18593f.setOnClickListener(this.k);
        this.i.setOnClickListener(this.k);
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a();
        this.f18592e = context;
        c();
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.k = new a();
        this.f18592e = context;
        c();
    }
}

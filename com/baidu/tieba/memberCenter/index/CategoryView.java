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
import d.a.j0.r1.c.b.d;
/* loaded from: classes3.dex */
public class CategoryView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19008e;

    /* renamed from: f  reason: collision with root package name */
    public View f19009f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19010g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19011h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19012i;
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
            MemberCenterStatic.a((TbPageContext) j.a(CategoryView.this.f19008e), new String[]{CategoryView.this.j.c()});
        }
    }

    public CategoryView(Context context) {
        super(context);
        this.k = new a();
        this.f19008e = context;
        c();
    }

    public final void c() {
        View inflate = LayoutInflater.from(this.f19008e).inflate(R.layout.index_category, this);
        this.f19009f = inflate;
        this.f19010g = (TextView) inflate.findViewById(R.id.class_name);
        this.f19011h = (TextView) this.f19009f.findViewById(R.id.sprend_name);
        this.f19012i = (ImageView) this.f19009f.findViewById(R.id.spread_icon);
        this.f19009f.setOnClickListener(this.k);
        this.f19012i.setOnClickListener(this.k);
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a();
        this.f19008e = context;
        c();
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.k = new a();
        this.f19008e = context;
        c();
    }
}

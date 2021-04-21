package com.baidu.tieba.write.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import d.b.c.e.p.l;
import d.b.j0.q0.c0;
import d.b.j0.q0.e1;
import java.util.List;
/* loaded from: classes5.dex */
public class PostCategoryView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public Context f22066e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22067f;

    /* renamed from: g  reason: collision with root package name */
    public MorePopupWindow f22068g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f22069h;
    public LinearLayout i;
    public TabMenuPopView j;
    public View k;
    public Drawable l;
    public Drawable m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostCategoryView.this.c();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements KeyEventDealContainerView.a {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            if (PostCategoryView.this.f22068g != null) {
                PostCategoryView.this.f22068g.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f22072e;

        public c(PostCategoryView postCategoryView) {
            this.f22072e = postCategoryView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PostCategoryView postCategoryView = this.f22072e;
            if (postCategoryView != null) {
                postCategoryView.e();
            }
        }
    }

    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22066e = context;
        this.f22067f = false;
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_title_down);
        this.l = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_title_up);
        this.m = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.l, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f22066e).inflate(R.layout.pop_category, (ViewGroup) null);
        this.f22069h = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.pop_category_layout);
        this.i = linearLayout2;
        this.j = (TabMenuPopView) linearLayout2.findViewById(R.id.pop_category_view);
        View findViewById = this.f22069h.findViewById(R.id.pop_category_grav);
        this.k = findViewById;
        findViewById.setOnClickListener(new a());
    }

    public void b() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
        }
        TabMenuPopView tabMenuPopView = this.j;
        if (tabMenuPopView != null) {
            tabMenuPopView.d();
        }
    }

    public void c() {
        MorePopupWindow morePopupWindow = this.f22068g;
        if (morePopupWindow != null) {
            morePopupWindow.dismiss();
        }
    }

    public final void d(PostCategoryView postCategoryView) {
        if (this.f22068g == null) {
            MorePopupWindow morePopupWindow = new MorePopupWindow((Activity) this.f22066e, this.f22069h, this, SkinManager.getDrawable(R.drawable.transparent_bg), new b());
            this.f22068g = morePopupWindow;
            morePopupWindow.setOnDismissListener(new c(postCategoryView));
        }
    }

    public void e() {
        if (this.f22067f) {
            setCompoundDrawables(null, null, this.l, null);
            this.f22067f = false;
        } else {
            d(this);
            MorePopupWindow morePopupWindow = this.f22068g;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f22068g.setWidthAsWidthOfDeviceScreen((Activity) this.f22066e);
                this.f22068g.setHeight(-1);
                this.f22068g.showWindowInCustomPosition(0, 0);
                setCompoundDrawables(null, null, this.m, null);
                this.f22067f = true;
            }
        }
        invalidate();
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.c cVar) {
        this.j.setOnItemClickCallBack(cVar);
    }

    public void setCategoryContainerData(List<e1> list, e1 e1Var) {
        this.j.setData(list, e1Var);
    }

    public void setCategoryContainerData(List<c0> list, c0 c0Var, int i) {
        this.j.setData(list, c0Var, i);
    }
}

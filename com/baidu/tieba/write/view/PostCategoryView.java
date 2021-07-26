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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.u0.b0;
import d.a.q0.u0.d1;
import java.util.List;
/* loaded from: classes4.dex */
public class PostCategoryView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f22839e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22840f;

    /* renamed from: g  reason: collision with root package name */
    public MorePopupWindow f22841g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f22842h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f22843i;
    public TabMenuPopView j;
    public View k;
    public Drawable l;
    public Drawable m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f22844e;

        public a(PostCategoryView postCategoryView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22844e = postCategoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22844e.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f22845a;

        public b(PostCategoryView postCategoryView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22845a = postCategoryView;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22845a.f22841g == null) {
                return;
            }
            this.f22845a.f22841g.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f22846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f22847f;

        public c(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView, postCategoryView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22847f = postCategoryView;
            this.f22846e = postCategoryView2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PostCategoryView postCategoryView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postCategoryView = this.f22846e) == null) {
                return;
            }
            postCategoryView.e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22839e = context;
        this.f22840f = false;
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_title_down);
        this.l = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_title_up);
        this.m = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.l, null);
        setPadding(0, 0, l.g(getContext(), R.dimen.ds50), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f22839e).inflate(R.layout.pop_category, (ViewGroup) null);
        this.f22842h = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.pop_category_layout);
        this.f22843i = linearLayout2;
        this.j = (TabMenuPopView) linearLayout2.findViewById(R.id.pop_category_view);
        View findViewById = this.f22842h.findViewById(R.id.pop_category_grav);
        this.k = findViewById;
        findViewById.setOnClickListener(new a(this));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            LinearLayout linearLayout = this.f22843i;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TabMenuPopView tabMenuPopView = this.j;
            if (tabMenuPopView != null) {
                tabMenuPopView.d();
            }
        }
    }

    public void c() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f22841g) == null) {
            return;
        }
        morePopupWindow.dismiss();
    }

    public final void d(PostCategoryView postCategoryView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postCategoryView) == null) && this.f22841g == null) {
            MorePopupWindow morePopupWindow = new MorePopupWindow((Activity) this.f22839e, this.f22842h, this, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            this.f22841g = morePopupWindow;
            morePopupWindow.setOnDismissListener(new c(this, postCategoryView));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f22840f) {
                setCompoundDrawables(null, null, this.l, null);
                this.f22840f = false;
            } else {
                d(this);
                MorePopupWindow morePopupWindow = this.f22841g;
                if (morePopupWindow != null) {
                    morePopupWindow.refresh();
                    this.f22841g.setWidthAsWidthOfDeviceScreen((Activity) this.f22839e);
                    this.f22841g.setHeight(-1);
                    this.f22841g.showWindowInCustomPosition(0, 0);
                    setCompoundDrawables(null, null, this.m, null);
                    this.f22840f = true;
                }
            }
            invalidate();
        }
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.j.setOnItemClickCallBack(cVar);
        }
    }

    public void setCategoryContainerData(List<d1> list, d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, d1Var) == null) {
            this.j.setData(list, d1Var);
        }
    }

    public void setCategoryContainerData(List<b0> list, b0 b0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, list, b0Var, i2) == null) {
            this.j.setData(list, b0Var, i2);
        }
    }
}

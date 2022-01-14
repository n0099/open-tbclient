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
import c.a.d.f.p.n;
import c.a.t0.d1.c0;
import c.a.t0.d1.o1;
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class PostCategoryView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49717e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49718f;

    /* renamed from: g  reason: collision with root package name */
    public MorePopupWindow f49719g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f49720h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f49721i;

    /* renamed from: j  reason: collision with root package name */
    public TabMenuPopView f49722j;
    public View k;
    public Drawable l;
    public Drawable m;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f49723e;

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
            this.f49723e = postCategoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49723e.dismissPopWindow();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostCategoryView a;

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
            this.a = postCategoryView;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f49719g == null) {
                return;
            }
            this.a.f49719g.dismiss();
        }
    }

    /* loaded from: classes13.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f49724e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f49725f;

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
            this.f49725f = postCategoryView;
            this.f49724e = postCategoryView2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PostCategoryView postCategoryView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postCategoryView = this.f49724e) == null) {
                return;
            }
            postCategoryView.processClick();
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
        this.f49717e = context;
        this.f49718f = false;
        Drawable drawable = SkinManager.getDrawable(f.icon_title_down);
        this.l = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(f.icon_title_up);
        this.m = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.l, null);
        setPadding(0, 0, n.f(getContext(), e.ds50), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f49717e).inflate(h.pop_category, (ViewGroup) null);
        this.f49720h = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(g.pop_category_layout);
        this.f49721i = linearLayout2;
        this.f49722j = (TabMenuPopView) linearLayout2.findViewById(g.pop_category_view);
        View findViewById = this.f49720h.findViewById(g.pop_category_grav);
        this.k = findViewById;
        findViewById.setOnClickListener(new a(this));
    }

    public final void b(PostCategoryView postCategoryView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, postCategoryView) == null) && this.f49719g == null) {
            MorePopupWindow morePopupWindow = new MorePopupWindow((Activity) this.f49717e, this.f49720h, this, SkinManager.getDrawable(f.transparent_bg), new b(this));
            this.f49719g = morePopupWindow;
            morePopupWindow.setOnDismissListener(new c(this, postCategoryView));
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, d.CAM_X0201);
            SkinManager.setViewTextColor(this, d.CAM_X0105, 1);
            LinearLayout linearLayout = this.f49721i;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, d.CAM_X0201);
            }
            TabMenuPopView tabMenuPopView = this.f49722j;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    public void dismissPopWindow() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (morePopupWindow = this.f49719g) == null) {
            return;
        }
        morePopupWindow.dismiss();
    }

    public void processClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f49718f) {
                setCompoundDrawables(null, null, this.l, null);
                this.f49718f = false;
            } else {
                b(this);
                MorePopupWindow morePopupWindow = this.f49719g;
                if (morePopupWindow != null) {
                    morePopupWindow.refresh();
                    this.f49719g.setWidthAsWidthOfDeviceScreen((Activity) this.f49717e);
                    this.f49719g.setHeight(-1);
                    this.f49719g.showWindowInCustomPosition(0, 0);
                    setCompoundDrawables(null, null, this.m, null);
                    this.f49718f = true;
                }
            }
            invalidate();
        }
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f49722j.setOnItemClickCallBack(cVar);
        }
    }

    public void setCategoryContainerData(List<o1> list, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, o1Var) == null) {
            this.f49722j.setData(list, o1Var);
        }
    }

    public void setCategoryContainerData(List<c0> list, c0 c0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, list, c0Var, i2) == null) {
            this.f49722j.setData(list, c0Var, i2);
        }
    }
}

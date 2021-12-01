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
import c.a.d.f.p.l;
import c.a.r0.d1.c0;
import c.a.r0.d1.o1;
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
import java.util.List;
/* loaded from: classes11.dex */
public class PostCategoryView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50911e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50912f;

    /* renamed from: g  reason: collision with root package name */
    public MorePopupWindow f50913g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f50914h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f50915i;

    /* renamed from: j  reason: collision with root package name */
    public TabMenuPopView f50916j;

    /* renamed from: k  reason: collision with root package name */
    public View f50917k;
    public Drawable l;
    public Drawable m;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f50918e;

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
            this.f50918e = postCategoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50918e.dismissPopWindow();
            }
        }
    }

    /* loaded from: classes11.dex */
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f50913g == null) {
                return;
            }
            this.a.f50913g.dismiss();
        }
    }

    /* loaded from: classes11.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f50919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f50920f;

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
            this.f50920f = postCategoryView;
            this.f50919e = postCategoryView2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PostCategoryView postCategoryView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postCategoryView = this.f50919e) == null) {
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
        this.f50911e = context;
        this.f50912f = false;
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_title_down);
        this.l = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_title_up);
        this.m = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.l.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.l, null);
        setPadding(0, 0, l.f(getContext(), R.dimen.ds50), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f50911e).inflate(R.layout.pop_category, (ViewGroup) null);
        this.f50914h = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.pop_category_layout);
        this.f50915i = linearLayout2;
        this.f50916j = (TabMenuPopView) linearLayout2.findViewById(R.id.pop_category_view);
        View findViewById = this.f50914h.findViewById(R.id.pop_category_grav);
        this.f50917k = findViewById;
        findViewById.setOnClickListener(new a(this));
    }

    public final void b(PostCategoryView postCategoryView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, postCategoryView) == null) && this.f50913g == null) {
            MorePopupWindow morePopupWindow = new MorePopupWindow((Activity) this.f50911e, this.f50914h, this, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            this.f50913g = morePopupWindow;
            morePopupWindow.setOnDismissListener(new c(this, postCategoryView));
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            LinearLayout linearLayout = this.f50915i;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TabMenuPopView tabMenuPopView = this.f50916j;
            if (tabMenuPopView != null) {
                tabMenuPopView.changeSkinType();
            }
        }
    }

    public void dismissPopWindow() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (morePopupWindow = this.f50913g) == null) {
            return;
        }
        morePopupWindow.dismiss();
    }

    public void processClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f50912f) {
                setCompoundDrawables(null, null, this.l, null);
                this.f50912f = false;
            } else {
                b(this);
                MorePopupWindow morePopupWindow = this.f50913g;
                if (morePopupWindow != null) {
                    morePopupWindow.refresh();
                    this.f50913g.setWidthAsWidthOfDeviceScreen((Activity) this.f50911e);
                    this.f50913g.setHeight(-1);
                    this.f50913g.showWindowInCustomPosition(0, 0);
                    setCompoundDrawables(null, null, this.m, null);
                    this.f50912f = true;
                }
            }
            invalidate();
        }
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f50916j.setOnItemClickCallBack(cVar);
        }
    }

    public void setCategoryContainerData(List<o1> list, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, o1Var) == null) {
            this.f50916j.setData(list, o1Var);
        }
    }

    public void setCategoryContainerData(List<c0> list, c0 c0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, list, c0Var, i2) == null) {
            this.f50916j.setData(list, c0Var, i2);
        }
    }
}

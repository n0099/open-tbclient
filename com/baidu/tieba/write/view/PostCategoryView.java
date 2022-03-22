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
import c.a.p0.f1.c0;
import c.a.p0.f1.e1;
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
/* loaded from: classes6.dex */
public class PostCategoryView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37375b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f37376c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f37377d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f37378e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f37379f;

    /* renamed from: g  reason: collision with root package name */
    public View f37380g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f37381h;
    public Drawable i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostCategoryView a;

        public a(PostCategoryView postCategoryView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postCategoryView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f37376c == null) {
                return;
            }
            this.a.f37376c.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostCategoryView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PostCategoryView f37382b;

        public c(PostCategoryView postCategoryView, PostCategoryView postCategoryView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postCategoryView, postCategoryView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37382b = postCategoryView;
            this.a = postCategoryView2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PostCategoryView postCategoryView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postCategoryView = this.a) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f37375b = false;
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_title_down);
        this.f37381h = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f37381h.getIntrinsicHeight());
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_title_up);
        this.i = drawable2;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f37381h.getIntrinsicHeight());
        setCompoundDrawables(null, null, this.f37381h, null);
        setPadding(0, 0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06f5, (ViewGroup) null);
        this.f37377d = linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09189d);
        this.f37378e = linearLayout2;
        this.f37379f = (TabMenuPopView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f09189e);
        View findViewById = this.f37377d.findViewById(R.id.obfuscated_res_0x7f09189c);
        this.f37380g = findViewById;
        findViewById.setOnClickListener(new a(this));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
            LinearLayout linearLayout = this.f37378e;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TabMenuPopView tabMenuPopView = this.f37379f;
            if (tabMenuPopView != null) {
                tabMenuPopView.d();
            }
        }
    }

    public void c() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f37376c) == null) {
            return;
        }
        morePopupWindow.dismiss();
    }

    public final void d(PostCategoryView postCategoryView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postCategoryView) == null) && this.f37376c == null) {
            MorePopupWindow morePopupWindow = new MorePopupWindow((Activity) this.a, this.f37377d, this, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f081200), new b(this));
            this.f37376c = morePopupWindow;
            morePopupWindow.setOnDismissListener(new c(this, postCategoryView));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f37375b) {
                setCompoundDrawables(null, null, this.f37381h, null);
                this.f37375b = false;
            } else {
                d(this);
                MorePopupWindow morePopupWindow = this.f37376c;
                if (morePopupWindow != null) {
                    morePopupWindow.refresh();
                    this.f37376c.setWidthAsWidthOfDeviceScreen((Activity) this.a);
                    this.f37376c.setHeight(-1);
                    this.f37376c.showWindowInCustomPosition(0, 0);
                    setCompoundDrawables(null, null, this.i, null);
                    this.f37375b = true;
                }
            }
            invalidate();
        }
    }

    public void setCategoryContainerClickCallback(TabMenuPopView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f37379f.setOnItemClickCallBack(cVar);
        }
    }

    public void setCategoryContainerData(List<e1> list, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, e1Var) == null) {
            this.f37379f.setData(list, e1Var);
        }
    }

    public void setCategoryContainerData(List<c0> list, c0 c0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, list, c0Var, i) == null) {
            this.f37379f.setData(list, c0Var, i);
        }
    }
}

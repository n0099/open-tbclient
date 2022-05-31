package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.bl7;
import com.repackage.f9;
import com.repackage.j48;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.s35;
import com.repackage.t35;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;
    public BdTypeRecyclerView b;
    public bl7 c;
    public s35 d;
    public t35 e;
    public PbListView f;
    public RecyclerView.OnScrollListener g;
    public j48 h;
    public int i;
    public RecyclerView.OnScrollListener j;
    public e k;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ HotTopicDetailFeedView b;

        public a(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.b.h != null) {
                    this.b.h.n(this.b.b.getFirstVisiblePosition(), this.b.b.getLastVisiblePosition(), this.a, true);
                }
                if (this.b.g != null) {
                    this.b.g.onScrollStateChanged(recyclerView, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a = i2 <= 0;
                if (this.b.g != null) {
                    this.b.g.onScrolled(recyclerView, i, i2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailFeedView a;

        public b(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.b != null) {
                    this.a.b.stopScroll();
                }
                ((HotTopicDetailActivity) this.a.a.getOrignalPage()).onScrollToBottom();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailFeedView a;

        public c(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view2 = viewHolder.itemView) == null || this.a.h == null) {
                return;
            }
            this.a.h.k(view2);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailFeedView a;

        public d(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.A()) {
                ((HotTopicDetailActivity) this.a.a.getOrignalPage()).refreshFeedData(this.a.i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = 1;
        this.j = new a(this);
        i(context);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j48 j48Var = this.h;
            if (j48Var != null) {
                j48Var.h();
            }
            mg.a().removeCallbacks(this.k);
        }
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.b) == null || this.f == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.f.j();
    }

    public void g() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (s35Var = this.d) == null) {
            return;
        }
        s35Var.dettachView(this);
        this.d = null;
    }

    public void h() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t35Var = this.e) == null) {
            return;
        }
        t35Var.dettachView(this);
        this.e = null;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            b9<?> a2 = f9.a(context);
            if (a2 instanceof TbPageContext) {
                this.a = (TbPageContext) a2;
            }
            if (this.a == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.b = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.b.setOverScrollMode(2);
            this.b.setVerticalScrollBarEnabled(false);
            this.b.setLayoutManager(new LinearLayoutManager(context));
            this.b.addOnScrollListener(this.j);
            this.b.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.a;
            this.c = new bl7(tbPageContext, tbPageContext.getUniqueId(), this.b);
            addView(this.b);
            ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0703c2);
            if (this.h == null) {
                this.h = new j48(this.a, this.b);
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.h.p(2);
                } else {
                    this.h.p(1);
                }
                this.h.u(this.a.getUniqueId());
            }
            this.b.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.a();
            this.f.p(R.color.CAM_X0205);
            this.f.x();
            this.f.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f.A(R.color.CAM_X0110);
            this.b.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            s35 s35Var = this.d;
            if (s35Var != null) {
                s35Var.onChangeSkinType();
            }
            t35 t35Var = this.e;
            if (t35Var != null) {
                t35Var.onChangeSkinType();
            }
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f.d(i);
            }
            bl7 bl7Var = this.c;
            if (bl7Var != null) {
                bl7Var.c();
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public void k() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (j48Var = this.h) == null) {
            return;
        }
        j48Var.y();
        this.h.r(false);
    }

    public void l() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (j48Var = this.h) == null) {
            return;
        }
        j48Var.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            this.h.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
        }
    }

    public HotTopicDetailFeedView m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.i = i;
            this.c.b(i == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.b) == null || (pbListView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f.G(R.dimen.tbfontsize33);
        this.f.L(0);
        this.f.t(li.f(getContext(), R.dimen.tbds182));
        this.f.Q();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.d == null) {
                s35 s35Var = new s35(getContext());
                this.d = s35Var;
                s35Var.i();
                this.d.onChangeSkinType();
                this.d.setWrapStyle(true);
            }
            this.d.attachView(this, z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e();
            super.onDetachedFromWindow();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (this.e == null) {
                t35 t35Var = new t35(getContext(), new d(this));
                this.e = t35Var;
                t35Var.setWrapStyle(false);
            }
            this.e.attachView(this, false);
            this.e.p();
            if (z) {
                this.e.n(getResources().getString(R.string.obfuscated_res_0x7f0f0f95));
            } else {
                this.e.n(getResources().getString(R.string.obfuscated_res_0x7f0f0882));
            }
            this.e.b().setClickable(false);
        }
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.b) == null || (pbListView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f.f();
        this.f.L(0);
        this.f.C(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f09f5));
    }

    public void setData(@NonNull List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.c.d(list);
            j48 j48Var = this.h;
            if (j48Var != null) {
                j48Var.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onScrollListener) == null) {
            this.g = onScrollListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 1;
        this.j = new a(this);
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailFeedView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 1;
        this.j = new a(this);
        i(context);
    }
}

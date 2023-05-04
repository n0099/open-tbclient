package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.g9;
import com.baidu.tieba.ih5;
import com.baidu.tieba.ii;
import com.baidu.tieba.in;
import com.baidu.tieba.jg;
import com.baidu.tieba.jh5;
import com.baidu.tieba.la9;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.qr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;
    public BdTypeRecyclerView b;
    public qr8 c;
    public ih5 d;
    public jh5 e;
    public PbListView f;
    public RecyclerView.OnScrollListener g;
    public la9 h;
    public int i;
    public RecyclerView.OnScrollListener j;
    public e k;

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
                if (this.b.g != null) {
                    this.b.g.onScrolled(recyclerView, i, i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && this.a.h != null) {
                this.a.h.k(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                ((HotTopicDetailActivity) this.a.a.getOrignalPage()).H1(this.a.i);
            }
        }
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

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            ih5 ih5Var = this.d;
            if (ih5Var != null) {
                ih5Var.onChangeSkinType();
            }
            jh5 jh5Var = this.e;
            if (jh5Var != null) {
                jh5Var.onChangeSkinType();
            }
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(R.color.CAM_X0109));
                this.f.e(i);
            }
            qr8 qr8Var = this.c;
            if (qr8Var != null) {
                qr8Var.c();
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
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

    public HotTopicDetailFeedView m(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.i = i;
            qr8 qr8Var = this.c;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            qr8Var.b(z);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.d == null) {
                ih5 ih5Var = new ih5(getContext());
                this.d = ih5Var;
                ih5Var.i();
                this.d.onChangeSkinType();
                this.d.setWrapStyle(true);
            }
            this.d.attachView(this, z);
        }
    }

    public void setData(@NonNull List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.c.d(list);
            la9 la9Var = this.h;
            if (la9Var != null) {
                la9Var.n(this.b.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onScrollListener) == null) {
            this.g = onScrollListener;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            la9 la9Var = this.h;
            if (la9Var != null) {
                la9Var.h();
            }
            jg.a().removeCallbacks(this.k);
        }
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeRecyclerView = this.b) != null && this.f != null) {
            bdTypeRecyclerView.setNextPage(null);
            this.f.l();
        }
    }

    public void g() {
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ih5Var = this.d) != null) {
            ih5Var.dettachView(this);
            this.d = null;
        }
    }

    public void h() {
        jh5 jh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jh5Var = this.e) != null) {
            jh5Var.dettachView(this);
            this.e = null;
        }
    }

    public void k() {
        la9 la9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (la9Var = this.h) != null) {
            la9Var.z();
            this.h.r(false);
        }
    }

    public void l() {
        la9 la9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (la9Var = this.h) != null) {
            la9Var.r(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                this.h.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.b.getLastVisiblePosition(), false, true);
            }
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

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            a9<?> a2 = g9.a(context);
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
            this.c = new qr8(tbPageContext, tbPageContext.getUniqueId(), this.b);
            addView(this.b);
            ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070413);
            if (this.h == null) {
                la9 la9Var = new la9(this.a, this.b);
                this.h = la9Var;
                la9Var.p(2);
                this.h.u(this.a.getUniqueId());
            }
            this.b.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f = pbListView;
            pbListView.a();
            this.f.r(R.color.CAM_X0205);
            this.f.A();
            this.f.H(SkinManager.getColor(R.color.CAM_X0109));
            this.f.D(R.color.CAM_X0110);
            this.b.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bdTypeRecyclerView = this.b) != null && (pbListView = this.f) != null) {
            bdTypeRecyclerView.setNextPage(pbListView);
            this.f.J(R.dimen.tbfontsize33);
            this.f.N(0);
            this.f.v(ii.g(getContext(), R.dimen.tbds182));
            this.f.S();
        }
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (bdTypeRecyclerView = this.b) != null && (pbListView = this.f) != null) {
            bdTypeRecyclerView.setNextPage(pbListView);
            this.f.g();
            this.f.N(0);
            this.f.F(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (this.e == null) {
                jh5 jh5Var = new jh5(getContext(), new d(this));
                this.e = jh5Var;
                jh5Var.setWrapStyle(false);
            }
            this.e.attachView(this, false);
            this.e.p();
            if (z) {
                this.e.n(getResources().getString(R.string.refresh_view_title_text));
            } else {
                this.e.n(getResources().getString(R.string.obfuscated_res_0x7f0f094f));
            }
            this.e.b().setClickable(false);
        }
    }
}

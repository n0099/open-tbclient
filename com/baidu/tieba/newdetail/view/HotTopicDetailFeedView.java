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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.p0.f0.g;
import d.a.p0.f0.h;
import d.a.q0.b2.d.c.l;
import d.a.q0.n2.i;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18884e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f18885f;

    /* renamed from: g  reason: collision with root package name */
    public l f18886g;

    /* renamed from: h  reason: collision with root package name */
    public g f18887h;

    /* renamed from: i  reason: collision with root package name */
    public h f18888i;
    public PbListView j;
    public RecyclerView.OnScrollListener k;
    public i l;
    public int m;
    public RecyclerView.OnScrollListener n;
    public e o;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f18889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f18890b;

        public a(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18890b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f18890b.l != null) {
                    this.f18890b.l.n(this.f18890b.f18885f.getFirstVisiblePosition(), this.f18890b.f18885f.getLastVisiblePosition(), this.f18889a, true);
                }
                if (this.f18890b.k != null) {
                    this.f18890b.k.onScrollStateChanged(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f18889a = i3 <= 0;
                if (this.f18890b.k != null) {
                    this.f18890b.k.onScrolled(recyclerView, i2, i3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f18891e;

        public b(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18891e = hotTopicDetailFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f18891e.f18885f != null) {
                    this.f18891e.f18885f.stopScroll();
                }
                ((HotTopicDetailActivity) this.f18891e.f18884e.getOrignalPage()).onScrollToBottom();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f18892a;

        public c(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18892a = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f18892a.l == null) {
                return;
            }
            this.f18892a.l.k(view);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f18893e;

        public d(HotTopicDetailFeedView hotTopicDetailFeedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18893e = hotTopicDetailFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                ((HotTopicDetailActivity) this.f18893e.f18884e.getOrignalPage()).refreshFeedData(this.f18893e.m);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailFeedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = new a(this);
        i(context);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i iVar = this.l;
            if (iVar != null) {
                iVar.h();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.o);
        }
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f18885f) == null || this.j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.j.i();
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f18887h) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f18887h = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f18888i) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f18888i = null;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            f<?> a2 = d.a.d.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f18884e = (TbPageContext) a2;
            }
            if (this.f18884e == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f18885f = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.f18885f.setOverScrollMode(2);
            this.f18885f.setVerticalScrollBarEnabled(false);
            this.f18885f.setLayoutManager(new LinearLayoutManager(context));
            this.f18885f.addOnScrollListener(this.n);
            this.f18885f.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.f18884e;
            this.f18886g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f18885f);
            addView(this.f18885f);
            ((FrameLayout.LayoutParams) this.f18885f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.l == null) {
                i iVar = new i(this.f18884e, this.f18885f);
                this.l = iVar;
                iVar.p(1);
                this.l.t(this.f18884e.getUniqueId());
            }
            this.f18885f.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.j = pbListView;
            pbListView.a();
            this.j.o(R.color.CAM_X0205);
            this.j.v();
            this.j.C(SkinManager.getColor(R.color.CAM_X0109));
            this.j.y(R.color.CAM_X0110);
            this.f18885f.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            g gVar = this.f18887h;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f18888i;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.j.d(i2);
            }
            l lVar = this.f18886g;
            if (lVar != null) {
                lVar.c();
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public void k() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.l) == null) {
            return;
        }
        iVar.x();
        this.l.q(false);
    }

    public void l() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.l) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f18885f;
        if (bdTypeRecyclerView != null) {
            this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f18885f.getLastVisiblePosition(), false, true);
        }
    }

    public HotTopicDetailFeedView m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.m = i2;
            this.f18886g.b(i2 == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.f18885f) == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.E(R.dimen.tbfontsize33);
        this.j.J(0);
        this.j.r(d.a.d.e.p.l.g(getContext(), R.dimen.tbds182));
        this.j.O();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.f18887h == null) {
                g gVar = new g(getContext());
                this.f18887h = gVar;
                gVar.h();
                this.f18887h.onChangeSkinType();
                this.f18887h.setWrapStyle(true);
            }
            this.f18887h.attachView(this, z);
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
            if (this.f18888i == null) {
                h hVar = new h(getContext(), new d(this));
                this.f18888i = hVar;
                hVar.setWrapStyle(false);
            }
            this.f18888i.attachView(this, false);
            this.f18888i.o();
            if (z) {
                this.f18888i.m(getResources().getString(R.string.refresh_view_title_text));
            } else {
                this.f18888i.m(getResources().getString(R.string.hot_topic_no_data));
            }
            this.f18888i.b().setClickable(false);
        }
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f18885f) == null || (pbListView = this.j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.j.f();
        this.j.J(0);
        this.j.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public void setData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.f18886g.d(list);
            i iVar = this.l;
            if (iVar != null) {
                iVar.n(this.f18885f.getFirstVisiblePosition(), this.f18885f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onScrollListener) == null) {
            this.k = onScrollListener;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = new a(this);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 1;
        this.n = new a(this);
        i(context);
    }
}

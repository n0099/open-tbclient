package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.a.f;
import c.a.d.a.j;
import c.a.d.n.e.n;
import c.a.s0.g0.g;
import c.a.s0.g0.h;
import c.a.t0.m2.d.c.l;
import c.a.t0.z2.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f46089e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f46090f;

    /* renamed from: g  reason: collision with root package name */
    public l f46091g;

    /* renamed from: h  reason: collision with root package name */
    public g f46092h;

    /* renamed from: i  reason: collision with root package name */
    public h f46093i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f46094j;
    public RecyclerView.OnScrollListener k;
    public k l;
    public RecyclerView.OnScrollListener m;
    public e n;
    public int sortType;

    /* loaded from: classes12.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f46095b;

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
            this.f46095b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f46095b.l != null) {
                    this.f46095b.l.n(this.f46095b.f46090f.getFirstVisiblePosition(), this.f46095b.f46090f.getLastVisiblePosition(), this.a, true);
                }
                if (this.f46095b.k != null) {
                    this.f46095b.k.onScrollStateChanged(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.a = i3 <= 0;
                if (this.f46095b.k != null) {
                    this.f46095b.k.onScrolled(recyclerView, i2, i3);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f46096e;

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
            this.f46096e = hotTopicDetailFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46096e.f46090f != null) {
                    this.f46096e.f46090f.stopScroll();
                }
                ((HotTopicDetailActivity) this.f46096e.f46089e.getOrignalPage()).onScrollToBottom();
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.l == null) {
                return;
            }
            this.a.l.k(view);
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f46097e;

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
            this.f46097e = hotTopicDetailFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.d.f.p.l.A()) {
                ((HotTopicDetailActivity) this.f46097e.f46089e.getOrignalPage()).refreshFeedData(this.f46097e.sortType);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f46098e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f46099f;

        public e(HotTopicDetailFeedView hotTopicDetailFeedView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailFeedView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46099f = hotTopicDetailFeedView;
            this.f46098e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46099f.f46090f.smoothScrollBy(Math.abs(this.f46098e), 1);
            }
        }
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
        this.sortType = 1;
        this.m = new a(this);
        e(context);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = this.l;
            if (kVar != null) {
                kVar.h();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.n);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            f<?> a2 = j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f46089e = (TbPageContext) a2;
            }
            if (this.f46089e == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f46090f = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.f46090f.setOverScrollMode(2);
            this.f46090f.setVerticalScrollBarEnabled(false);
            this.f46090f.setLayoutManager(new LinearLayoutManager(context));
            this.f46090f.addOnScrollListener(this.m);
            this.f46090f.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.f46089e;
            this.f46091g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f46090f);
            addView(this.f46090f);
            ((FrameLayout.LayoutParams) this.f46090f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(c.a.t0.q1.c.line_magin_bottom);
            if (this.l == null) {
                this.l = new k(this.f46089e, this.f46090f);
                if (c.a.s0.b.d.l()) {
                    this.l.p(2);
                } else {
                    this.l.p(1);
                }
                this.l.u(this.f46089e.getUniqueId());
            }
            this.f46090f.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f46094j = pbListView;
            pbListView.a();
            this.f46094j.p(c.a.t0.q1.b.CAM_X0205);
            this.f46094j.y();
            this.f46094j.F(SkinManager.getColor(c.a.t0.q1.b.CAM_X0109));
            this.f46094j.B(c.a.t0.q1.b.CAM_X0110);
            this.f46090f.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hideLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f46090f) == null || this.f46094j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.f46094j.j();
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f46092h) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f46092h = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f46093i) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f46093i = null;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            g gVar = this.f46092h;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f46093i;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.f46094j;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c.a.t0.q1.b.CAM_X0109));
                this.f46094j.d(i2);
            }
            l lVar = this.f46091g;
            if (lVar != null) {
                lVar.c();
            }
            SkinManager.setBackgroundColor(this, c.a.t0.q1.b.CAM_X0201);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            destroy();
            super.onDetachedFromWindow();
        }
    }

    public void pause() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kVar = this.l) == null) {
            return;
        }
        kVar.y();
        this.l.r(false);
    }

    public void resume() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (kVar = this.l) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f46090f;
        if (bdTypeRecyclerView != null) {
            this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f46090f.getLastVisiblePosition(), false, true);
        }
    }

    public void scrollToTop(float f2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (bdTypeRecyclerView = this.f46090f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        this.n = new e(this, (int) f2);
        c.a.d.f.m.e.a().post(this.n);
    }

    public void setData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f46091g.d(list);
            k kVar = this.l;
            if (kVar != null) {
                kVar.n(this.f46090f.getFirstVisiblePosition(), this.f46090f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.k = onScrollListener;
        }
    }

    public HotTopicDetailFeedView setSortType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.sortType = i2;
            this.f46091g.b(i2 == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void showLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f46090f) == null || (pbListView = this.f46094j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f46094j.H(c.a.t0.q1.c.tbfontsize33);
        this.f46094j.M(0);
        this.f46094j.t(c.a.d.f.p.n.f(getContext(), c.a.t0.q1.c.tbds182));
        this.f46094j.R();
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.f46092h == null) {
                g gVar = new g(getContext());
                this.f46092h = gVar;
                gVar.h();
                this.f46092h.onChangeSkinType();
                this.f46092h.setWrapStyle(true);
            }
            this.f46092h.attachView(this, z);
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (this.f46093i == null) {
                h hVar = new h(getContext(), new d(this));
                this.f46093i = hVar;
                hVar.setWrapStyle(false);
            }
            this.f46093i.attachView(this, false);
            this.f46093i.p();
            if (z) {
                this.f46093i.n(getResources().getString(c.a.t0.q1.h.refresh_view_title_text));
            } else {
                this.f46093i.n(getResources().getString(c.a.t0.q1.h.hot_topic_no_data));
            }
            this.f46093i.b().setClickable(false);
        }
    }

    public void showNoMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.f46090f) == null || (pbListView = this.f46094j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f46094j.f();
        this.f46094j.M(0);
        this.f46094j.D(getContext().getResources().getString(c.a.t0.q1.h.list_no_more));
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
        this.sortType = 1;
        this.m = new a(this);
        e(context);
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
        this.sortType = 1;
        this.m = new a(this);
        e(context);
    }
}

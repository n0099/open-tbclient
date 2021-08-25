package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.a.f;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.p0.f0.g;
import c.a.p0.f0.h;
import c.a.q0.c2.d.c.l;
import c.a.q0.o2.i;
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
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f54383e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f54384f;

    /* renamed from: g  reason: collision with root package name */
    public l f54385g;

    /* renamed from: h  reason: collision with root package name */
    public g f54386h;

    /* renamed from: i  reason: collision with root package name */
    public h f54387i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f54388j;
    public RecyclerView.OnScrollListener k;
    public i l;
    public RecyclerView.OnScrollListener m;
    public e n;
    public int sortType;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f54389a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54390b;

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
            this.f54390b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f54390b.l != null) {
                    this.f54390b.l.n(this.f54390b.f54384f.getFirstVisiblePosition(), this.f54390b.f54384f.getLastVisiblePosition(), this.f54389a, true);
                }
                if (this.f54390b.k != null) {
                    this.f54390b.k.onScrollStateChanged(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f54389a = i3 <= 0;
                if (this.f54390b.k != null) {
                    this.f54390b.k.onScrolled(recyclerView, i2, i3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54391e;

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
            this.f54391e = hotTopicDetailFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54391e.f54384f != null) {
                    this.f54391e.f54384f.stopScroll();
                }
                ((HotTopicDetailActivity) this.f54391e.f54383e.getOrignalPage()).onScrollToBottom();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54392a;

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
            this.f54392a = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f54392a.l == null) {
                return;
            }
            this.f54392a.l.k(view);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54393e;

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
            this.f54393e = hotTopicDetailFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                ((HotTopicDetailActivity) this.f54393e.f54383e.getOrignalPage()).refreshFeedData(this.f54393e.sortType);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f54394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54395f;

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
            this.f54395f = hotTopicDetailFeedView;
            this.f54394e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54395f.f54384f.smoothScrollBy(Math.abs(this.f54394e), 1);
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
            i iVar = this.l;
            if (iVar != null) {
                iVar.h();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.n);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            f<?> a2 = c.a.e.a.j.a(context);
            if (a2 instanceof TbPageContext) {
                this.f54383e = (TbPageContext) a2;
            }
            if (this.f54383e == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f54384f = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.f54384f.setOverScrollMode(2);
            this.f54384f.setVerticalScrollBarEnabled(false);
            this.f54384f.setLayoutManager(new LinearLayoutManager(context));
            this.f54384f.addOnScrollListener(this.m);
            this.f54384f.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.f54383e;
            this.f54385g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f54384f);
            addView(this.f54384f);
            ((FrameLayout.LayoutParams) this.f54384f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.l == null) {
                i iVar = new i(this.f54383e, this.f54384f);
                this.l = iVar;
                iVar.p(1);
                this.l.t(this.f54383e.getUniqueId());
            }
            this.f54384f.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f54388j = pbListView;
            pbListView.a();
            this.f54388j.o(R.color.CAM_X0205);
            this.f54388j.v();
            this.f54388j.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54388j.y(R.color.CAM_X0110);
            this.f54384f.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hideLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f54384f) == null || this.f54388j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.f54388j.i();
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f54386h) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f54386h = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f54387i) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f54387i = null;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            g gVar = this.f54386h;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f54387i;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.f54388j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f54388j.d(i2);
            }
            l lVar = this.f54385g;
            if (lVar != null) {
                lVar.c();
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
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
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.l) == null) {
            return;
        }
        iVar.x();
        this.l.q(false);
    }

    public void resume() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iVar = this.l) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f54384f;
        if (bdTypeRecyclerView != null) {
            this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f54384f.getLastVisiblePosition(), false, true);
        }
    }

    public void scrollToTop(float f2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (bdTypeRecyclerView = this.f54384f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        this.n = new e(this, (int) f2);
        c.a.e.e.m.e.a().post(this.n);
    }

    public void setData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f54385g.d(list);
            i iVar = this.l;
            if (iVar != null) {
                iVar.n(this.f54384f.getFirstVisiblePosition(), this.f54384f.getLastVisiblePosition(), false, true);
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
            this.f54385g.b(i2 == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void showLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f54384f) == null || (pbListView = this.f54388j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f54388j.E(R.dimen.tbfontsize33);
        this.f54388j.J(0);
        this.f54388j.r(c.a.e.e.p.l.g(getContext(), R.dimen.tbds182));
        this.f54388j.O();
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.f54386h == null) {
                g gVar = new g(getContext());
                this.f54386h = gVar;
                gVar.h();
                this.f54386h.onChangeSkinType();
                this.f54386h.setWrapStyle(true);
            }
            this.f54386h.attachView(this, z);
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (this.f54387i == null) {
                h hVar = new h(getContext(), new d(this));
                this.f54387i = hVar;
                hVar.setWrapStyle(false);
            }
            this.f54387i.attachView(this, false);
            this.f54387i.o();
            if (z) {
                this.f54387i.m(getResources().getString(R.string.refresh_view_title_text));
            } else {
                this.f54387i.m(getResources().getString(R.string.hot_topic_no_data));
            }
            this.f54387i.b().setClickable(false);
        }
    }

    public void showNoMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.f54384f) == null || (pbListView = this.f54388j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f54388j.f();
        this.f54388j.J(0);
        this.f54388j.A(getContext().getResources().getString(R.string.list_no_more));
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

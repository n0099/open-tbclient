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
import c.a.q0.g0.g;
import c.a.q0.g0.h;
import c.a.r0.d2.d.c.l;
import c.a.r0.p2.i;
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
    public TbPageContext<HotTopicDetailActivity> f54646e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f54647f;

    /* renamed from: g  reason: collision with root package name */
    public l f54648g;

    /* renamed from: h  reason: collision with root package name */
    public g f54649h;

    /* renamed from: i  reason: collision with root package name */
    public h f54650i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f54651j;
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
        public boolean f54652a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54653b;

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
            this.f54653b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f54653b.l != null) {
                    this.f54653b.l.n(this.f54653b.f54647f.getFirstVisiblePosition(), this.f54653b.f54647f.getLastVisiblePosition(), this.f54652a, true);
                }
                if (this.f54653b.k != null) {
                    this.f54653b.k.onScrollStateChanged(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f54652a = i3 <= 0;
                if (this.f54653b.k != null) {
                    this.f54653b.k.onScrolled(recyclerView, i2, i3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54654e;

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
            this.f54654e = hotTopicDetailFeedView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54654e.f54647f != null) {
                    this.f54654e.f54647f.stopScroll();
                }
                ((HotTopicDetailActivity) this.f54654e.f54646e.getOrignalPage()).onScrollToBottom();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54655a;

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
            this.f54655a = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f54655a.l == null) {
                return;
            }
            this.f54655a.l.k(view);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54656e;

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
            this.f54656e = hotTopicDetailFeedView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                ((HotTopicDetailActivity) this.f54656e.f54646e.getOrignalPage()).refreshFeedData(this.f54656e.sortType);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f54657e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f54658f;

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
            this.f54658f = hotTopicDetailFeedView;
            this.f54657e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54658f.f54647f.smoothScrollBy(Math.abs(this.f54657e), 1);
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
                this.f54646e = (TbPageContext) a2;
            }
            if (this.f54646e == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f54647f = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.f54647f.setOverScrollMode(2);
            this.f54647f.setVerticalScrollBarEnabled(false);
            this.f54647f.setLayoutManager(new LinearLayoutManager(context));
            this.f54647f.addOnScrollListener(this.m);
            this.f54647f.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.f54646e;
            this.f54648g = new l(tbPageContext, tbPageContext.getUniqueId(), this.f54647f);
            addView(this.f54647f);
            ((FrameLayout.LayoutParams) this.f54647f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            if (this.l == null) {
                i iVar = new i(this.f54646e, this.f54647f);
                this.l = iVar;
                iVar.p(1);
                this.l.t(this.f54646e.getUniqueId());
            }
            this.f54647f.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f54651j = pbListView;
            pbListView.a();
            this.f54651j.o(R.color.CAM_X0205);
            this.f54651j.v();
            this.f54651j.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54651j.y(R.color.CAM_X0110);
            this.f54647f.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void hideLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeRecyclerView = this.f54647f) == null || this.f54651j == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.f54651j.i();
    }

    public void hideLoadingView() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.f54649h) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f54649h = null;
    }

    public void hideNetRefreshView() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f54650i) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f54650i = null;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            g gVar = this.f54649h;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f54650i;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.f54651j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f54651j.d(i2);
            }
            l lVar = this.f54648g;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f54647f;
        if (bdTypeRecyclerView != null) {
            this.l.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f54647f.getLastVisiblePosition(), false, true);
        }
    }

    public void scrollToTop(float f2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (bdTypeRecyclerView = this.f54647f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
        this.n = new e(this, (int) f2);
        c.a.e.e.m.e.a().post(this.n);
    }

    public void setData(@NonNull List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f54648g.d(list);
            i iVar = this.l;
            if (iVar != null) {
                iVar.n(this.f54647f.getFirstVisiblePosition(), this.f54647f.getLastVisiblePosition(), false, true);
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
            this.f54648g.b(i2 == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void showLoadMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f54647f) == null || (pbListView = this.f54651j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f54651j.E(R.dimen.tbfontsize33);
        this.f54651j.J(0);
        this.f54651j.r(c.a.e.e.p.l.g(getContext(), R.dimen.tbds182));
        this.f54651j.O();
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.f54649h == null) {
                g gVar = new g(getContext());
                this.f54649h = gVar;
                gVar.h();
                this.f54649h.onChangeSkinType();
                this.f54649h.setWrapStyle(true);
            }
            this.f54649h.attachView(this, z);
        }
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (this.f54650i == null) {
                h hVar = new h(getContext(), new d(this));
                this.f54650i = hVar;
                hVar.setWrapStyle(false);
            }
            this.f54650i.attachView(this, false);
            this.f54650i.o();
            if (z) {
                this.f54650i.m(getResources().getString(R.string.refresh_view_title_text));
            } else {
                this.f54650i.m(getResources().getString(R.string.hot_topic_no_data));
            }
            this.f54650i.b().setClickable(false);
        }
    }

    public void showNoMoreView() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bdTypeRecyclerView = this.f54647f) == null || (pbListView = this.f54651j) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f54651j.f();
        this.f54651j.J(0);
        this.f54651j.A(getContext().getResources().getString(R.string.list_no_more));
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

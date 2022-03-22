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
import c.a.d.f.p.n;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.p0.c3.k;
import c.a.p0.q2.d.c.l;
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
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicDetailFeedView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f34615b;

    /* renamed from: c  reason: collision with root package name */
    public l f34616c;

    /* renamed from: d  reason: collision with root package name */
    public g f34617d;

    /* renamed from: e  reason: collision with root package name */
    public h f34618e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f34619f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.OnScrollListener f34620g;

    /* renamed from: h  reason: collision with root package name */
    public k f34621h;
    public int i;
    public RecyclerView.OnScrollListener j;
    public e k;

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailFeedView f34622b;

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
            this.f34622b = hotTopicDetailFeedView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i == 0 && this.f34622b.f34621h != null) {
                    this.f34622b.f34621h.n(this.f34622b.f34615b.getFirstVisiblePosition(), this.f34622b.f34615b.getLastVisiblePosition(), this.a, true);
                }
                if (this.f34622b.f34620g != null) {
                    this.f34622b.f34620g.onScrollStateChanged(recyclerView, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a = i2 <= 0;
                if (this.f34622b.f34620g != null) {
                    this.f34622b.f34620g.onScrolled(recyclerView, i, i2);
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
                if (this.a.f34615b != null) {
                    this.a.f34615b.stopScroll();
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
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.a.f34621h == null) {
                return;
            }
            this.a.f34621h.k(view);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.d.f.p.l.A()) {
                ((HotTopicDetailActivity) this.a.a.getOrignalPage()).refreshFeedData(this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            k kVar = this.f34621h;
            if (kVar != null) {
                kVar.h();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.k);
        }
    }

    public void f() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f34615b) == null || this.f34619f == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(null);
        this.f34619f.j();
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f34617d) == null) {
            return;
        }
        gVar.dettachView(this);
        this.f34617d = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f34618e) == null) {
            return;
        }
        hVar.dettachView(this);
        this.f34618e = null;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            f<?> a2 = j.a(context);
            if (a2 instanceof TbPageContext) {
                this.a = (TbPageContext) a2;
            }
            if (this.a == null) {
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = new BdTypeRecyclerView(context);
            this.f34615b = bdTypeRecyclerView;
            bdTypeRecyclerView.setFadingEdgeLength(0);
            this.f34615b.setOverScrollMode(2);
            this.f34615b.setVerticalScrollBarEnabled(false);
            this.f34615b.setLayoutManager(new LinearLayoutManager(context));
            this.f34615b.addOnScrollListener(this.j);
            this.f34615b.setOnSrollToBottomListener(new b(this));
            TbPageContext<HotTopicDetailActivity> tbPageContext = this.a;
            this.f34616c = new l(tbPageContext, tbPageContext.getUniqueId(), this.f34615b);
            addView(this.f34615b);
            ((FrameLayout.LayoutParams) this.f34615b.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0703b8);
            if (this.f34621h == null) {
                this.f34621h = new k(this.a, this.f34615b);
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.f34621h.p(2);
                } else {
                    this.f34621h.p(1);
                }
                this.f34621h.u(this.a.getUniqueId());
            }
            this.f34615b.setRecyclerListener(new c(this));
            PbListView pbListView = new PbListView(context);
            this.f34619f = pbListView;
            pbListView.a();
            this.f34619f.p(R.color.CAM_X0205);
            this.f34619f.y();
            this.f34619f.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f34619f.B(R.color.CAM_X0110);
            this.f34615b.setVisibility(0);
            setFocusableInTouchMode(true);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            g gVar = this.f34617d;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            h hVar = this.f34618e;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            PbListView pbListView = this.f34619f;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f34619f.d(i);
            }
            l lVar = this.f34616c;
            if (lVar != null) {
                lVar.c();
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        }
    }

    public void k() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kVar = this.f34621h) == null) {
            return;
        }
        kVar.y();
        this.f34621h.r(false);
    }

    public void l() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kVar = this.f34621h) == null) {
            return;
        }
        kVar.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f34615b;
        if (bdTypeRecyclerView != null) {
            this.f34621h.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f34615b.getLastVisiblePosition(), false, true);
        }
    }

    public HotTopicDetailFeedView m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.i = i;
            this.f34616c.b(i == 0);
            return this;
        }
        return (HotTopicDetailFeedView) invokeI.objValue;
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bdTypeRecyclerView = this.f34615b) == null || (pbListView = this.f34619f) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f34619f.H(R.dimen.tbfontsize33);
        this.f34619f.M(0);
        this.f34619f.t(n.f(getContext(), R.dimen.tbds182));
        this.f34619f.R();
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.f34617d == null) {
                g gVar = new g(getContext());
                this.f34617d = gVar;
                gVar.i();
                this.f34617d.onChangeSkinType();
                this.f34617d.setWrapStyle(true);
            }
            this.f34617d.attachView(this, z);
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
            if (this.f34618e == null) {
                h hVar = new h(getContext(), new d(this));
                this.f34618e = hVar;
                hVar.setWrapStyle(false);
            }
            this.f34618e.attachView(this, false);
            this.f34618e.p();
            if (z) {
                this.f34618e.n(getResources().getString(R.string.obfuscated_res_0x7f0f0f65));
            } else {
                this.f34618e.n(getResources().getString(R.string.obfuscated_res_0x7f0f0874));
            }
            this.f34618e.b().setClickable(false);
        }
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bdTypeRecyclerView = this.f34615b) == null || (pbListView = this.f34619f) == null) {
            return;
        }
        bdTypeRecyclerView.setNextPage(pbListView);
        this.f34619f.f();
        this.f34619f.M(0);
        this.f34619f.D(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
    }

    public void setData(@NonNull List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.f34616c.d(list);
            k kVar = this.f34621h;
            if (kVar != null) {
                kVar.n(this.f34615b.getFirstVisiblePosition(), this.f34615b.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onScrollListener) == null) {
            this.f34620g = onScrollListener;
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

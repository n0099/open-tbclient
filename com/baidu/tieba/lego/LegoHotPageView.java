package com.baidu.tieba.lego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.q0.s.g0.f;
import b.a.r0.q1.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.q1.p.e f51004e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.s.g0.g f51005f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f51006g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f51007h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.q1.n.a f51008i;
    public TbPageContext<?> j;
    public b.a.r0.q1.c k;
    public h l;
    public b.a.q0.g0.g m;
    public b.a.q0.g0.h n;
    public long o;
    public String p;
    public boolean q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public h.c u;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51009a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51009a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f45667a) {
                return;
            }
            this.f51009a.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51010a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f22719a = String.valueOf(customResponsedMessage.getData());
                bVar.f22720b = true;
                this.f51010a.p(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51011a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51011a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                b.a.r0.q1.p.b bVar = new b.a.r0.q1.p.b();
                bVar.f22719a = String.valueOf(customResponsedMessage.getData());
                bVar.f22720b = false;
                this.f51011a.p(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51012a;

        public d(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51012a = legoHotPageView;
        }

        @Override // b.a.r0.q1.h.c
        public void a(List<b.a.r0.q1.p.d> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || this.f51012a.k == null) {
                return;
            }
            this.f51012a.k.a(list);
        }

        @Override // b.a.r0.q1.h.c
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                boolean t = this.f51012a.t();
                this.f51012a.r();
                if (t) {
                    LegoHotPageView legoHotPageView = this.f51012a;
                    legoHotPageView.v(true, legoHotPageView.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (this.f51012a.k != null) {
                    this.f51012a.k.c(j, str);
                }
            }
        }

        @Override // b.a.r0.q1.h.c
        public void c(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) || this.f51012a.k == null || this.f51012a.f51004e == null) {
                return;
            }
            this.f51012a.k.e(this.f51012a.f51004e.f22738a, this.f51012a.f51004e.f22739b, i2, str);
        }

        @Override // b.a.r0.q1.h.c
        public void d(String str, String str2, String str3, List<b.a.r0.q1.p.e> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) || this.f51012a.k == null) {
                return;
            }
            this.f51012a.k.d(str, str2, str3, list);
        }

        @Override // b.a.r0.q1.h.c
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f51012a.q();
                if (i2 != 1) {
                    this.f51012a.f51007h.setVisibility(8);
                    LegoHotPageView legoHotPageView = this.f51012a;
                    legoHotPageView.w(legoHotPageView, str, true);
                } else if (j.z()) {
                    this.f51012a.j.showToast(str);
                }
            }
        }

        @Override // b.a.r0.q1.h.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f51012a.q();
                this.f51012a.r();
                this.f51012a.f51007h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51013e;

        public e(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51013e = legoHotPageView;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f51013e.l.update(this.f51013e.o, this.f51013e.p);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51014e;

        public f(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51014e = legoHotPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51014e.q) {
                if (this.f51014e.f51006g != null) {
                    this.f51014e.f51006g.Q();
                }
                this.f51014e.l.g();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f51015e;

        public g(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51015e = legoHotPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51015e.l == null) {
                return;
            }
            if (this.f51015e.f51004e != null) {
                this.f51015e.l.update(this.f51015e.f51004e.f22738a, this.f51015e.f51004e.f22739b);
            } else {
                this.f51015e.l.update(this.f51015e.o, this.f51015e.p);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context) {
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
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }

    private void setHasMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            this.q = z;
            if (this.f51007h == null) {
                return;
            }
            if (this.f51006g.b().getParent() == null) {
                this.f51007h.setNextPage(this.f51006g);
            }
            if (this.q) {
                this.f51006g.C(getContext().getString(R.string.pb_load_more));
            } else {
                this.f51006g.C("");
            }
        }
    }

    public long getTagCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.q1.p.e eVar = this.f51004e;
            if (eVar == null) {
                return 0L;
            }
            return eVar.f22738a;
        }
        return invokeV.longValue;
    }

    public void notifyListViewBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f51007h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51007h.getChildCount(); i2++) {
            View childAt = this.f51007h.getChildAt(i2);
            if (childAt instanceof b.a.r0.q1.o.l.e) {
                if (z) {
                    ((b.a.r0.q1.o.l.e) childAt).onViewBackground();
                } else {
                    ((b.a.r0.q1.o.l.e) childAt).onViewForeground();
                }
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b.a.q0.g0.g gVar = this.m;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            b.a.q0.g0.h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            b.a.q0.s.g0.g gVar2 = this.f51005f;
            if (gVar2 != null) {
                gVar2.C(i2);
            }
            BdListView bdListView = this.f51007h;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i2);
            }
            PbListView pbListView = this.f51006g;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f51006g.d(i2);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            u();
        }
    }

    public final void p(Object obj) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, obj) == null) || this.f51008i == null || (hVar = this.l) == null || hVar.b() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.l.b()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f51008i.notifyDataSetChanged();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.q0.g0.g gVar = this.m;
            if (gVar != null) {
                gVar.dettachView(this);
                this.m = null;
            }
            b.a.r0.q1.c cVar = this.k;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public final void r() {
        b.a.q0.g0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            b.a.e.a.f<?> a2 = b.a.e.a.j.a(context);
            a2.registerListener(this.r);
            a2.registerListener(this.s);
            a2.registerListener(this.t);
            if (a2 instanceof TbPageContext) {
                this.j = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f51007h = bdListView;
            bdListView.setDividerHeight(0);
            this.f51007h.setSelector(17170445);
            b.a.r0.q1.n.a aVar = new b.a.r0.q1.n.a(this.j);
            this.f51008i = aVar;
            this.f51007h.setAdapter((ListAdapter) aVar);
            PbListView pbListView = new PbListView(context);
            this.f51006g = pbListView;
            pbListView.a();
            this.f51006g.p(R.color.CAM_X0204);
            this.f51006g.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f51006g.d(TbadkCoreApplication.getInst().getSkinType());
            b.a.q0.s.g0.g gVar = new b.a.q0.s.g0.g(this.j);
            this.f51005f = gVar;
            this.f51007h.setPullRefresh(gVar);
            this.f51005f.v(true);
            this.f51005f.a(new e(this));
            this.f51007h.setOnSrollToBottomListener(new f(this));
            this.f51007h.setOnScrollListener(this);
            h hVar = new h(this.f51007h, this.f51008i);
            this.l = hVar;
            hVar.l(this.u);
            addView(this.f51007h);
        }
    }

    public void setCallback(b.a.r0.q1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        b.a.q0.s.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (gVar = this.f51005f) == null) {
            return;
        }
        gVar.U(bdUniqueId);
    }

    public void setTagInfo(b.a.r0.q1.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f51004e = eVar;
        }
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            notifyListViewBackground(true);
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            notifyListViewBackground(false);
        }
    }

    public void startFirstLoad(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048590, this, j, str) == null) {
            this.o = j;
            this.p = str;
            h hVar = this.l;
            if (hVar != null) {
                hVar.update(j, str);
            }
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            b.a.q0.g0.h hVar = this.n;
            return hVar != null && hVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f51007h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51007h.getChildCount(); i2++) {
            View childAt = this.f51007h.getChildAt(i2);
            if (childAt instanceof b.a.r0.q1.o.l.e) {
                ((b.a.r0.q1.o.l.e) childAt).onScrollIdle();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, dataRes, z) == null) {
            PbListView pbListView = this.f51006g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(z, dataRes, 0, null);
            setHasMore(this.l.c());
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i2) == null) {
            PbListView pbListView = this.f51006g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(true, null, i2, str);
        }
    }

    public final void v(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.m == null) {
                if (i2 < 0) {
                    this.m = new b.a.q0.g0.g(getContext());
                } else {
                    this.m = new b.a.q0.g0.g(getContext(), i2);
                }
                this.m.onChangeSkinType();
            }
            this.m.attachView(this, z);
        }
    }

    public final void w(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, view, str, z) == null) {
            if (this.n == null) {
                this.n = new b.a.q0.g0.h(getContext(), new g(this));
            }
            this.n.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.n.l(str);
            this.n.attachView(view, z);
            this.n.o();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context, AttributeSet attributeSet) {
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
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }
}

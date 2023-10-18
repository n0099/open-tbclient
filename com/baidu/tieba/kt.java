package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.jv4;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class kt<T extends jv4> implements rs, xz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qs<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public wr<T> g;
    public wr<T> h;
    public List<ds> i;
    public wr<T> j;
    public ArrayList<yr> k;
    public rs l;
    public lt m;
    public T n;
    public vt o;
    public int p;
    public vt.a q;

    @Override // com.baidu.tieba.xz5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt a;

        public a(kt ktVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ktVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ktVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                        }
                    }
                    this.a.q.d(Boolean.FALSE);
                    kt ktVar = this.a;
                    ktVar.q(ktVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                kt ktVar2 = this.a;
                ktVar2.q(ktVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wr a;
        public wr b;
        public List<ds> c;
        public wr d;
        public ArrayList<yr> e;
        public Context f;
        public lt g;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            this(context, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public b(Context context, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.d = null;
            this.f = context;
            this.e = new ArrayList<>();
            lt ltVar = new lt();
            this.g = ltVar;
            if (!z) {
                ltVar.j(0);
            }
            this.c = new ArrayList();
        }

        public b h(ds dsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dsVar)) == null) {
                this.c.add(dsVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(wr wrVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wrVar)) == null) {
                this.d = wrVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(wr wrVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wrVar)) == null) {
                this.b = wrVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(wr wrVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, wrVar)) == null) {
                this.a = wrVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public kt i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new kt(this, (a) null);
            }
            return (kt) invokeV.objValue;
        }

        public lt l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (lt) invokeV.objValue;
        }

        public kt j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) {
                return new kt(this, supportType, viewGroup, (a) null);
            }
            return (kt) invokeLL.objValue;
        }

        public kt k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, ei eiVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, eiVar)) == null) {
                return new kt(this, supportType, viewGroup, eiVar, null);
            }
            return (kt) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kt(b bVar) {
        this(bVar, BaseCardInfo.SupportType.FULL);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                if (8 != viewGroup.getChildAt(i2).getVisibility()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            }
            if (!z) {
                i = 8;
            }
            viewGroup.setVisibility(i);
        }
    }

    public void p(yr yrVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, yrVar) == null) && yrVar != null && yrVar.getDecorView() != null) {
            this.k.remove(yrVar);
            if (yrVar.getDecorView().getParent() != null) {
                ((ViewGroup) yrVar.getDecorView().getParent()).removeView(yrVar.getDecorView());
                yrVar.onDetachCard();
                yrVar.setThreadCard(null);
            }
        }
    }

    public void r(bk6<T> bk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bk6Var) == null) {
            wr<T> wrVar = this.g;
            if (wrVar != null) {
                wrVar.p(bk6Var);
            }
            wr<T> wrVar2 = this.h;
            if (wrVar2 != null) {
                wrVar2.p(bk6Var);
            }
            for (ds dsVar : this.i) {
                if (dsVar != null) {
                    dsVar.p(bk6Var);
                }
            }
            wr<T> wrVar3 = this.j;
            if (wrVar3 != null) {
                wrVar3.p(bk6Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kt(b bVar, BaseCardInfo.SupportType supportType) {
        this(bVar, supportType, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kt(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (ei) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (ei) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public kt(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, ei eiVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, eiVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.l = null;
        this.o = new vt();
        this.p = 0;
        this.q = new vt.a(7);
        this.b = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.thread_card_layout, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.b);
            this.c = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.thread_card_layout, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.d = threadCardView;
        this.e = (RelativeLayout) threadCardView.findViewById(R.id.card_decor_layer);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.body_root);
        this.f = linearLayout;
        linearLayout.setClipToPadding(false);
        this.g = bVar.a;
        this.h = bVar.b;
        this.i = bVar.c;
        this.j = bVar.d;
        this.k = bVar.e;
        this.m = bVar.g;
        this.d.setParent(viewGroup);
        this.d.setITypeListView(eiVar);
        m();
        int dimens = this.m.a() ? BdUtilHelper.getDimens(this.b, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + dimens, marginLayoutParams.topMargin + this.m.j, marginLayoutParams.rightMargin + dimens, marginLayoutParams.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + dimens, marginLayoutParams2.topMargin + this.m.e, marginLayoutParams2.rightMargin + dimens, marginLayoutParams2.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (dimens != 0 && (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + dimens, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + dimens, marginLayoutParams3.bottomMargin);
            this.d.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    public /* synthetic */ kt(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, ei eiVar, a aVar) {
        this(bVar, supportType, viewGroup, eiVar);
    }

    public /* synthetic */ kt(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public /* synthetic */ kt(b bVar, a aVar) {
        this(bVar);
    }

    public void o(int i, vt.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public boolean q(vt.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            return this.o.b(aVar);
        }
        return invokeL.booleanValue;
    }

    public void s(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (threadCardView = this.d) != null) {
            threadCardView.setPosition(i);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.p = i;
        }
    }

    public void c(yr yrVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yrVar) == null) && yrVar != null && yrVar.getDecorView() != null) {
            p(yrVar);
            yrVar.getDecorView().setVisibility(0);
            if (yrVar.getLayoutParams() == null) {
                this.e.addView(yrVar.getDecorView(), yrVar.getInsertIndex());
            } else {
                this.e.addView(yrVar.getDecorView(), yrVar.getInsertIndex(), yrVar.getLayoutParams());
            }
            yrVar.setThreadCard(this);
            yrVar.onAttachCard();
            this.k.add(yrVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yr yrVar = new yr();
            yrVar.setDecorView(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f070386), BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0703ec));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.h;
            yrVar.setLayoutParams(layoutParams);
            yrVar.setInsertIndex(-1);
            this.k.add(yrVar);
        }
    }

    public wr<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (wr) invokeV.objValue;
    }

    public wr<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (wr) invokeV.objValue;
    }

    public Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public T i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (T) invokeV.objValue;
    }

    public List<ds> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                return frameLayout;
            }
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.m == null) {
            return;
        }
        if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            lt ltVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(ltVar.g, ltVar.d, ltVar.h, ltVar.f);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        wr<T> wrVar = this.g;
        if (wrVar != null) {
            wrVar.n(this);
            this.f.addView(this.g.k());
            this.g.l();
        }
        wr<T> wrVar2 = this.h;
        if (wrVar2 != null) {
            wrVar2.n(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.i().booleanValue()) {
                lt ltVar2 = this.m;
                layoutParams.leftMargin = -ltVar2.g;
                layoutParams.rightMargin = -ltVar2.h;
            }
            this.f.addView(this.h.k(), layoutParams);
            this.h.l();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                ds dsVar = this.i.get(i);
                if (dsVar != null) {
                    dsVar.n(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = dsVar.u();
                    layoutParams2.bottomMargin = dsVar.t();
                    if (dsVar.i().booleanValue()) {
                        lt ltVar3 = this.m;
                        layoutParams2.leftMargin = -ltVar3.g;
                        layoutParams2.rightMargin = -ltVar3.h;
                    }
                    this.f.addView(dsVar.k(), layoutParams2);
                    dsVar.l();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.n(this);
            this.f.addView(this.j.k(), layoutParams3);
            this.j.l();
        }
        if (!ListUtils.isEmpty(this.k)) {
            Iterator<yr> it = this.k.iterator();
            while (it.hasNext()) {
                yr next = it.next();
                if (next != null && next.getDecorView() != null) {
                    if (next.getLayoutParams() == null) {
                        this.e.addView(next.getDecorView(), next.getInsertIndex());
                    } else {
                        this.e.addView(next.getDecorView(), next.getInsertIndex(), next.getLayoutParams());
                    }
                    next.setThreadCard(this);
                    next.onAttachCard();
                }
            }
        }
    }

    public void n(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            this.n = t;
            if (t.isHighLight()) {
                this.m.i = R.color.CAM_X0313;
            } else {
                this.m.i = R.color.CAM_X0205;
            }
            if (this.g != null) {
                this.d.setTag(R.id.virtual_image_user_head, null);
                this.g.onBindDataToView(t);
                wr<T> wrVar = this.g;
                if (wrVar instanceof lva) {
                    this.d.setTag(R.id.virtual_image_user_head, wrVar);
                }
            }
            wr<T> wrVar2 = this.h;
            if (wrVar2 != null) {
                wrVar2.onBindDataToView(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    ds dsVar = this.i.get(i);
                    dsVar.onBindDataToView(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(dsVar.k(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            wr<T> wrVar3 = this.j;
            if (wrVar3 != null) {
                wrVar3.onBindDataToView(t);
            }
            qs<T> qsVar = this.a;
            if (qsVar != null) {
                qsVar.onBindDataToView(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.i);
            }
            wr<T> wrVar = this.g;
            if (wrVar != null) {
                wrVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    EMManager.from(this.d).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            wr<T> wrVar2 = this.h;
            if (wrVar2 != null) {
                wrVar2.onChangeSkinType(tbPageContext, i);
            }
            for (ds dsVar : this.i) {
                if (dsVar != null) {
                    dsVar.onChangeSkinType(tbPageContext, i);
                }
            }
            wr<T> wrVar3 = this.j;
            if (wrVar3 != null) {
                wrVar3.onChangeSkinType(tbPageContext, i);
                if (this.g == null && ((t = this.n) == null || !t.isSupportContent())) {
                    EMManager.from(this.d).setCardType(2).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            if (this.g != null && this.j != null) {
                EMManager.from(this.d).setCorner(R.string.J_X06).setBackGroundSelectorColor(this.m.i, R.color.CAM_X0206);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
            }
            if (!ListUtils.isEmpty(this.k)) {
                Iterator<yr> it = this.k.iterator();
                while (it.hasNext()) {
                    yr next = it.next();
                    if (next != null && (next instanceof rs)) {
                        ((rs) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            rs rsVar = this.l;
            if (rsVar != null) {
                rsVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}

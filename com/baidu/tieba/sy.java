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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.yq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class sy<T extends yq4> implements xx, so5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wx<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public gx<T> g;
    public gx<T> h;
    public List<nx> i;
    public gx<T> j;
    public ArrayList<ix> k;
    public xx l;
    public ty m;
    public T n;
    public dz o;
    public int p;
    public dz.a q;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public a(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
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
                    sy syVar = this.a;
                    syVar.o(syVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                sy syVar2 = this.a;
                syVar2.o(syVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public /* synthetic */ sy(b bVar, a aVar) {
        this(bVar);
    }

    @Override // com.baidu.tieba.so5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void c(ix ixVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ixVar) == null) || ixVar == null || ixVar.b() == null) {
            return;
        }
        n(ixVar);
        ixVar.b().setVisibility(0);
        if (ixVar.d() == null) {
            this.e.addView(ixVar.b(), ixVar.c());
        } else {
            this.e.addView(ixVar.b(), ixVar.c(), ixVar.d());
        }
        ixVar.j(this);
        ixVar.e();
        this.k.add(ixVar);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ix ixVar = new ix();
            ixVar.g(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ej.f(this.b, R.dimen.obfuscated_res_0x7f070260), ej.f(this.b, R.dimen.obfuscated_res_0x7f0702d2));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.g;
            ixVar.i(layoutParams);
            ixVar.h(-1);
            this.k.add(ixVar);
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                z = 8 != viewGroup.getChildAt(i).getVisibility();
                if (z) {
                    break;
                }
            }
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public gx<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (gx) invokeV.objValue;
    }

    public gx<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (gx) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    public List<nx> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout frameLayout = this.c;
            return frameLayout != null ? frameLayout : this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.m == null) {
            return;
        }
        if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ty tyVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(tyVar.f, tyVar.d, tyVar.g, tyVar.e);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        gx<T> gxVar = this.g;
        if (gxVar != null) {
            gxVar.k(this);
            this.f.addView(this.g.h());
            this.g.i();
        }
        gx<T> gxVar2 = this.h;
        if (gxVar2 != null) {
            gxVar2.k(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.g().booleanValue()) {
                ty tyVar2 = this.m;
                layoutParams.leftMargin = -tyVar2.f;
                layoutParams.rightMargin = -tyVar2.g;
            }
            this.f.addView(this.h.h(), layoutParams);
            this.h.i();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                nx nxVar = this.i.get(i);
                if (nxVar != null) {
                    nxVar.k(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = nxVar.q();
                    layoutParams2.bottomMargin = nxVar.p();
                    if (nxVar.g().booleanValue()) {
                        ty tyVar3 = this.m;
                        layoutParams2.leftMargin = -tyVar3.f;
                        layoutParams2.rightMargin = -tyVar3.g;
                    }
                    this.f.addView(nxVar.h(), layoutParams2);
                    nxVar.i();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.k(this);
            this.f.addView(this.j.h(), layoutParams3);
            this.j.i();
        }
        if (ListUtils.isEmpty(this.k)) {
            return;
        }
        Iterator<ix> it = this.k.iterator();
        while (it.hasNext()) {
            ix next = it.next();
            if (next != null && next.b() != null) {
                if (next.d() == null) {
                    this.e.addView(next.b(), next.c());
                } else {
                    this.e.addView(next.b(), next.c(), next.d());
                }
                next.j(this);
                next.e();
            }
        }
    }

    public void l(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            this.n = t;
            if (t.isHighLight()) {
                this.m.h = R.color.CAM_X0313;
            } else {
                this.m.h = R.color.CAM_X0205;
            }
            if (this.g != null) {
                this.d.setTag(R.id.obfuscated_res_0x7f09260a, null);
                this.g.a(t);
                gx<T> gxVar = this.g;
                if (gxVar instanceof j19) {
                    this.d.setTag(R.id.obfuscated_res_0x7f09260a, gxVar);
                }
            }
            gx<T> gxVar2 = this.h;
            if (gxVar2 != null) {
                gxVar2.a(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    nx nxVar = this.i.get(i);
                    nxVar.a(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(nxVar.h(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            gx<T> gxVar3 = this.j;
            if (gxVar3 != null) {
                gxVar3.a(t);
            }
            wx<T> wxVar = this.a;
            if (wxVar != null) {
                wxVar.a(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    public void m(int i, dz.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public void n(ix ixVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ixVar) == null) || ixVar == null || ixVar.b() == null) {
            return;
        }
        this.k.remove(ixVar);
        if (ixVar.b().getParent() != null) {
            ((ViewGroup) ixVar.b().getParent()).removeView(ixVar.b());
            ixVar.f();
            ixVar.j(null);
        }
    }

    public boolean o(dz.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) ? this.o.b(aVar) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.h);
            }
            gx<T> gxVar = this.g;
            if (gxVar != null) {
                gxVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    hv4 d = hv4.d(this.d);
                    d.m(1);
                    d.n(R.string.J_X06);
                    d.f(this.m.h);
                }
            }
            gx<T> gxVar2 = this.h;
            if (gxVar2 != null) {
                gxVar2.onChangeSkinType(tbPageContext, i);
            }
            for (nx nxVar : this.i) {
                if (nxVar != null) {
                    nxVar.onChangeSkinType(tbPageContext, i);
                }
            }
            gx<T> gxVar3 = this.j;
            if (gxVar3 != null) {
                gxVar3.onChangeSkinType(tbPageContext, i);
                if (this.g == null && ((t = this.n) == null || !t.isSupportContent())) {
                    hv4 d2 = hv4.d(this.d);
                    d2.m(2);
                    d2.n(R.string.J_X06);
                    d2.f(this.m.h);
                }
            }
            if (this.g != null && this.j != null) {
                hv4 d3 = hv4.d(this.d);
                d3.n(R.string.J_X06);
                d3.i(this.m.h, R.color.CAM_X0206);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
            }
            if (!ListUtils.isEmpty(this.k)) {
                Iterator<ix> it = this.k.iterator();
                while (it.hasNext()) {
                    ix next = it.next();
                    if (next != null && (next instanceof xx)) {
                        ((xx) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            xx xxVar = this.l;
            if (xxVar != null) {
                xxVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void p(i26<T> i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, i26Var) == null) {
            gx<T> gxVar = this.g;
            if (gxVar != null) {
                gxVar.m(i26Var);
            }
            gx<T> gxVar2 = this.h;
            if (gxVar2 != null) {
                gxVar2.m(i26Var);
            }
            for (nx nxVar : this.i) {
                if (nxVar != null) {
                    nxVar.m(i26Var);
                }
            }
            gx<T> gxVar3 = this.j;
            if (gxVar3 != null) {
                gxVar3.m(i26Var);
            }
        }
    }

    public void q(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (threadCardView = this.d) == null) {
            return;
        }
        threadCardView.setPosition(i);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.p = i;
        }
    }

    public /* synthetic */ sy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, jo joVar, a aVar) {
        this(bVar, supportType, viewGroup, joVar);
    }

    public /* synthetic */ sy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sy(b bVar) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sy(b bVar, BaseCardInfo.SupportType supportType) {
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
    public sy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (jo) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (jo) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public sy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, jo joVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, joVar};
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
        this.o = new dz();
        this.p = 0;
        this.q = new dz.a(7);
        this.b = bVar.f;
        if (bVar.l().a()) {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0880, (ViewGroup) null);
            FrameLayout frameLayout = new FrameLayout(this.b);
            this.c = frameLayout;
            frameLayout.addView(inflate);
        } else {
            inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0880, viewGroup, false);
        }
        ThreadCardView threadCardView = (ThreadCardView) inflate.findViewById(R.id.obfuscated_res_0x7f092181);
        this.d = threadCardView;
        this.e = (RelativeLayout) threadCardView.findViewById(R.id.obfuscated_res_0x7f0904fd);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0903b6);
        this.f = linearLayout;
        linearLayout.setClipToPadding(false);
        this.g = bVar.a;
        this.h = bVar.b;
        this.i = bVar.c;
        this.j = bVar.d;
        this.k = bVar.e;
        this.m = bVar.g;
        this.d.setParent(viewGroup);
        this.d.setITypeListView(joVar);
        k();
        int f = this.m.a() ? ej.f(this.b, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + f, marginLayoutParams.topMargin + this.m.i, marginLayoutParams.rightMargin + f, marginLayoutParams.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + f, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin + f, marginLayoutParams2.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (f != 0 && (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + f, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + f, marginLayoutParams3.bottomMargin);
            this.d.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gx a;
        public gx b;
        public List<nx> c;
        public gx d;
        public ArrayList<ix> e;
        public Context f;
        public ty g;

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
            ty tyVar = new ty();
            this.g = tyVar;
            if (!z) {
                tyVar.i(0);
            }
            this.c = new ArrayList();
        }

        public b h(nx nxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nxVar)) == null) {
                this.c.add(nxVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public sy i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new sy(this, (a) null) : (sy) invokeV.objValue;
        }

        public sy j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) ? new sy(this, supportType, viewGroup, (a) null) : (sy) invokeLL.objValue;
        }

        public sy k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, jo joVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, joVar)) == null) ? new sy(this, supportType, viewGroup, joVar, null) : (sy) invokeLLL.objValue;
        }

        public ty l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (ty) invokeV.objValue;
        }

        public b m(gx gxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gxVar)) == null) {
                this.d = gxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(gx gxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gxVar)) == null) {
                this.b = gxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(gx gxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gxVar)) == null) {
                this.a = gxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

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
    }
}

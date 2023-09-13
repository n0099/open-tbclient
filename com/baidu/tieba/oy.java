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
import com.baidu.tieba.b15;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class oy<T extends b15> implements vx, n56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ux<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public ax<T> g;
    public ax<T> h;
    public List<hx> i;
    public ax<T> j;
    public ArrayList<cx> k;
    public vx l;
    public py m;
    public T n;
    public zy o;
    public int p;
    public zy.a q;

    @Override // com.baidu.tieba.n56
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy a;

        public a(oy oyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oyVar;
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
                    oy oyVar = this.a;
                    oyVar.p(oyVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                oy oyVar2 = this.a;
                oyVar2.p(oyVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ax a;
        public ax b;
        public List<hx> c;
        public ax d;
        public ArrayList<cx> e;
        public Context f;
        public py g;

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
            py pyVar = new py();
            this.g = pyVar;
            if (!z) {
                pyVar.j(0);
            }
            this.c = new ArrayList();
        }

        public b h(hx hxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hxVar)) == null) {
                this.c.add(hxVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(ax axVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, axVar)) == null) {
                this.d = axVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(ax axVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, axVar)) == null) {
                this.b = axVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(ax axVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, axVar)) == null) {
                this.a = axVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public oy i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new oy(this, (a) null);
            }
            return (oy) invokeV.objValue;
        }

        public py l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (py) invokeV.objValue;
        }

        public oy j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) {
                return new oy(this, supportType, viewGroup, (a) null);
            }
            return (oy) invokeLL.objValue;
        }

        public oy k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, in inVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, inVar)) == null) {
                return new oy(this, supportType, viewGroup, inVar, null);
            }
            return (oy) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oy(b bVar) {
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

    public void o(cx cxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, cxVar) == null) && cxVar != null && cxVar.getDecorView() != null) {
            this.k.remove(cxVar);
            if (cxVar.getDecorView().getParent() != null) {
                ((ViewGroup) cxVar.getDecorView().getParent()).removeView(cxVar.getDecorView());
                cxVar.onDetachCard();
                cxVar.setThreadCard(null);
            }
        }
    }

    public void q(mp6<T> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mp6Var) == null) {
            ax<T> axVar = this.g;
            if (axVar != null) {
                axVar.o(mp6Var);
            }
            ax<T> axVar2 = this.h;
            if (axVar2 != null) {
                axVar2.o(mp6Var);
            }
            for (hx hxVar : this.i) {
                if (hxVar != null) {
                    hxVar.o(mp6Var);
                }
            }
            ax<T> axVar3 = this.j;
            if (axVar3 != null) {
                axVar3.o(mp6Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oy(b bVar, BaseCardInfo.SupportType supportType) {
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
    public oy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (in) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (in) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public oy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, in inVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, inVar};
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
        this.o = new zy();
        this.p = 0;
        this.q = new zy.a(7);
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
        this.d.setITypeListView(inVar);
        l();
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

    public /* synthetic */ oy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, in inVar, a aVar) {
        this(bVar, supportType, viewGroup, inVar);
    }

    public /* synthetic */ oy(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public /* synthetic */ oy(b bVar, a aVar) {
        this(bVar);
    }

    public void n(int i, zy.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public boolean p(zy.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, aVar)) == null) {
            return this.o.b(aVar);
        }
        return invokeL.booleanValue;
    }

    public void r(int i) {
        ThreadCardView threadCardView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (threadCardView = this.d) != null) {
            threadCardView.setPosition(i);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.p = i;
        }
    }

    public void c(cx cxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cxVar) == null) && cxVar != null && cxVar.getDecorView() != null) {
            o(cxVar);
            cxVar.getDecorView().setVisibility(0);
            if (cxVar.getLayoutParams() == null) {
                this.e.addView(cxVar.getDecorView(), cxVar.getInsertIndex());
            } else {
                this.e.addView(cxVar.getDecorView(), cxVar.getInsertIndex(), cxVar.getLayoutParams());
            }
            cxVar.setThreadCard(this);
            cxVar.onAttachCard();
            this.k.add(cxVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cx cxVar = new cx();
            cxVar.setDecorView(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f07038a), BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0703f0));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.h;
            cxVar.setLayoutParams(layoutParams);
            cxVar.setInsertIndex(-1);
            this.k.add(cxVar);
        }
    }

    public ax<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (ax) invokeV.objValue;
    }

    public ax<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (ax) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public T h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (T) invokeV.objValue;
    }

    public List<hx> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public View k() {
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

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.m == null) {
            return;
        }
        if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            py pyVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(pyVar.g, pyVar.d, pyVar.h, pyVar.f);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        ax<T> axVar = this.g;
        if (axVar != null) {
            axVar.m(this);
            this.f.addView(this.g.j());
            this.g.k();
        }
        ax<T> axVar2 = this.h;
        if (axVar2 != null) {
            axVar2.m(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.i().booleanValue()) {
                py pyVar2 = this.m;
                layoutParams.leftMargin = -pyVar2.g;
                layoutParams.rightMargin = -pyVar2.h;
            }
            this.f.addView(this.h.j(), layoutParams);
            this.h.k();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                hx hxVar = this.i.get(i);
                if (hxVar != null) {
                    hxVar.m(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = hxVar.t();
                    layoutParams2.bottomMargin = hxVar.s();
                    if (hxVar.i().booleanValue()) {
                        py pyVar3 = this.m;
                        layoutParams2.leftMargin = -pyVar3.g;
                        layoutParams2.rightMargin = -pyVar3.h;
                    }
                    this.f.addView(hxVar.j(), layoutParams2);
                    hxVar.k();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.m(this);
            this.f.addView(this.j.j(), layoutParams3);
            this.j.k();
        }
        if (!ListUtils.isEmpty(this.k)) {
            Iterator<cx> it = this.k.iterator();
            while (it.hasNext()) {
                cx next = it.next();
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

    public void m(T t) {
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
                ax<T> axVar = this.g;
                if (axVar instanceof rya) {
                    this.d.setTag(R.id.virtual_image_user_head, axVar);
                }
            }
            ax<T> axVar2 = this.h;
            if (axVar2 != null) {
                axVar2.onBindDataToView(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    hx hxVar = this.i.get(i);
                    hxVar.onBindDataToView(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(hxVar.j(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            ax<T> axVar3 = this.j;
            if (axVar3 != null) {
                axVar3.onBindDataToView(t);
            }
            ux<T> uxVar = this.a;
            if (uxVar != null) {
                uxVar.onBindDataToView(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.i);
            }
            ax<T> axVar = this.g;
            if (axVar != null) {
                axVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    EMManager.from(this.d).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            ax<T> axVar2 = this.h;
            if (axVar2 != null) {
                axVar2.onChangeSkinType(tbPageContext, i);
            }
            for (hx hxVar : this.i) {
                if (hxVar != null) {
                    hxVar.onChangeSkinType(tbPageContext, i);
                }
            }
            ax<T> axVar3 = this.j;
            if (axVar3 != null) {
                axVar3.onChangeSkinType(tbPageContext, i);
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
                Iterator<cx> it = this.k.iterator();
                while (it.hasNext()) {
                    cx next = it.next();
                    if (next != null && (next instanceof vx)) {
                        ((vx) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            vx vxVar = this.l;
            if (vxVar != null) {
                vxVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}

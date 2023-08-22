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
import com.baidu.tieba.w05;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ny<T extends w05> implements ux, r46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tx<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public zw<T> g;
    public zw<T> h;
    public List<gx> i;
    public zw<T> j;
    public ArrayList<bx> k;
    public ux l;
    public oy m;
    public T n;
    public yy o;
    public int p;
    public yy.a q;

    @Override // com.baidu.tieba.r46
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny a;

        public a(ny nyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nyVar;
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
                    ny nyVar = this.a;
                    nyVar.p(nyVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                ny nyVar2 = this.a;
                nyVar2.p(nyVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zw a;
        public zw b;
        public List<gx> c;
        public zw d;
        public ArrayList<bx> e;
        public Context f;
        public oy g;

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
            oy oyVar = new oy();
            this.g = oyVar;
            if (!z) {
                oyVar.j(0);
            }
            this.c = new ArrayList();
        }

        public b h(gx gxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gxVar)) == null) {
                this.c.add(gxVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(zw zwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zwVar)) == null) {
                this.d = zwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(zw zwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zwVar)) == null) {
                this.b = zwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(zw zwVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zwVar)) == null) {
                this.a = zwVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ny i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new ny(this, (a) null);
            }
            return (ny) invokeV.objValue;
        }

        public oy l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (oy) invokeV.objValue;
        }

        public ny j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) {
                return new ny(this, supportType, viewGroup, (a) null);
            }
            return (ny) invokeLL.objValue;
        }

        public ny k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, hn hnVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, hnVar)) == null) {
                return new ny(this, supportType, viewGroup, hnVar, null);
            }
            return (ny) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ny(b bVar) {
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

    public void o(bx bxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bxVar) == null) && bxVar != null && bxVar.getDecorView() != null) {
            this.k.remove(bxVar);
            if (bxVar.getDecorView().getParent() != null) {
                ((ViewGroup) bxVar.getDecorView().getParent()).removeView(bxVar.getDecorView());
                bxVar.onDetachCard();
                bxVar.setThreadCard(null);
            }
        }
    }

    public void q(jo6<T> jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jo6Var) == null) {
            zw<T> zwVar = this.g;
            if (zwVar != null) {
                zwVar.p(jo6Var);
            }
            zw<T> zwVar2 = this.h;
            if (zwVar2 != null) {
                zwVar2.p(jo6Var);
            }
            for (gx gxVar : this.i) {
                if (gxVar != null) {
                    gxVar.p(jo6Var);
                }
            }
            zw<T> zwVar3 = this.j;
            if (zwVar3 != null) {
                zwVar3.p(jo6Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ny(b bVar, BaseCardInfo.SupportType supportType) {
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
    public ny(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (hn) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (hn) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ny(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, hn hnVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, hnVar};
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
        this.o = new yy();
        this.p = 0;
        this.q = new yy.a(7);
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
        this.d.setITypeListView(hnVar);
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

    public /* synthetic */ ny(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, hn hnVar, a aVar) {
        this(bVar, supportType, viewGroup, hnVar);
    }

    public /* synthetic */ ny(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public /* synthetic */ ny(b bVar, a aVar) {
        this(bVar);
    }

    public void n(int i, yy.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public boolean p(yy.a aVar) {
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

    public void c(bx bxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bxVar) == null) && bxVar != null && bxVar.getDecorView() != null) {
            o(bxVar);
            bxVar.getDecorView().setVisibility(0);
            if (bxVar.getLayoutParams() == null) {
                this.e.addView(bxVar.getDecorView(), bxVar.getInsertIndex());
            } else {
                this.e.addView(bxVar.getDecorView(), bxVar.getInsertIndex(), bxVar.getLayoutParams());
            }
            bxVar.setThreadCard(this);
            bxVar.onAttachCard();
            this.k.add(bxVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bx bxVar = new bx();
            bxVar.setDecorView(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f070386), BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0703ec));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.h;
            bxVar.setLayoutParams(layoutParams);
            bxVar.setInsertIndex(-1);
            this.k.add(bxVar);
        }
    }

    public zw<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (zw) invokeV.objValue;
    }

    public zw<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (zw) invokeV.objValue;
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

    public List<gx> i() {
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
            oy oyVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(oyVar.g, oyVar.d, oyVar.h, oyVar.f);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        zw<T> zwVar = this.g;
        if (zwVar != null) {
            zwVar.n(this);
            this.f.addView(this.g.k());
            this.g.l();
        }
        zw<T> zwVar2 = this.h;
        if (zwVar2 != null) {
            zwVar2.n(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.j().booleanValue()) {
                oy oyVar2 = this.m;
                layoutParams.leftMargin = -oyVar2.g;
                layoutParams.rightMargin = -oyVar2.h;
            }
            this.f.addView(this.h.k(), layoutParams);
            this.h.l();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                gx gxVar = this.i.get(i);
                if (gxVar != null) {
                    gxVar.n(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = gxVar.u();
                    layoutParams2.bottomMargin = gxVar.t();
                    if (gxVar.j().booleanValue()) {
                        oy oyVar3 = this.m;
                        layoutParams2.leftMargin = -oyVar3.g;
                        layoutParams2.rightMargin = -oyVar3.h;
                    }
                    this.f.addView(gxVar.k(), layoutParams2);
                    gxVar.l();
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
            Iterator<bx> it = this.k.iterator();
            while (it.hasNext()) {
                bx next = it.next();
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
                zw<T> zwVar = this.g;
                if (zwVar instanceof twa) {
                    this.d.setTag(R.id.virtual_image_user_head, zwVar);
                }
            }
            zw<T> zwVar2 = this.h;
            if (zwVar2 != null) {
                zwVar2.onBindDataToView(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    gx gxVar = this.i.get(i);
                    gxVar.onBindDataToView(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(gxVar.k(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            zw<T> zwVar3 = this.j;
            if (zwVar3 != null) {
                zwVar3.onBindDataToView(t);
            }
            tx<T> txVar = this.a;
            if (txVar != null) {
                txVar.onBindDataToView(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.i);
            }
            zw<T> zwVar = this.g;
            if (zwVar != null) {
                zwVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    EMManager.from(this.d).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(this.m.i);
                }
            }
            zw<T> zwVar2 = this.h;
            if (zwVar2 != null) {
                zwVar2.onChangeSkinType(tbPageContext, i);
            }
            for (gx gxVar : this.i) {
                if (gxVar != null) {
                    gxVar.onChangeSkinType(tbPageContext, i);
                }
            }
            zw<T> zwVar3 = this.j;
            if (zwVar3 != null) {
                zwVar3.onChangeSkinType(tbPageContext, i);
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
                Iterator<bx> it = this.k.iterator();
                while (it.hasNext()) {
                    bx next = it.next();
                    if (next != null && (next instanceof ux)) {
                        ((ux) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            ux uxVar = this.l;
            if (uxVar != null) {
                uxVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}

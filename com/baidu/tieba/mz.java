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
import com.baidu.tieba.t15;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class mz<T extends t15> implements sy, s66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ry<T> a;
    public Context b;
    public FrameLayout c;
    public ThreadCardView d;
    public RelativeLayout e;
    public LinearLayout f;
    public xx<T> g;
    public xx<T> h;
    public List<ey> i;
    public xx<T> j;
    public ArrayList<zx> k;
    public sy l;
    public nz m;
    public T n;
    public xz o;
    public int p;
    public xz.a q;

    @Override // com.baidu.tieba.s66
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz a;

        public a(mz mzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mzVar;
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
                    mz mzVar = this.a;
                    mzVar.p(mzVar.q);
                    return false;
                }
                this.a.q.d(Boolean.TRUE);
                mz mzVar2 = this.a;
                mzVar2.p(mzVar2.q);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xx a;
        public xx b;
        public List<ey> c;
        public xx d;
        public ArrayList<zx> e;
        public Context f;
        public nz g;

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
            nz nzVar = new nz();
            this.g = nzVar;
            if (!z) {
                nzVar.j(0);
            }
            this.c = new ArrayList();
        }

        public b h(ey eyVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eyVar)) == null) {
                this.c.add(eyVar);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(xx xxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xxVar)) == null) {
                this.d = xxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b n(xx xxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xxVar)) == null) {
                this.b = xxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b o(xx xxVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xxVar)) == null) {
                this.a = xxVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public mz i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new mz(this, (a) null);
            }
            return (mz) invokeV.objValue;
        }

        public nz l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.g;
            }
            return (nz) invokeV.objValue;
        }

        public mz j(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, supportType, viewGroup)) == null) {
                return new mz(this, supportType, viewGroup, (a) null);
            }
            return (mz) invokeLL.objValue;
        }

        public mz k(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, eo eoVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, supportType, viewGroup, eoVar)) == null) {
                return new mz(this, supportType, viewGroup, eoVar, null);
            }
            return (mz) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mz(b bVar) {
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

    public void o(zx zxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, zxVar) == null) && zxVar != null && zxVar.a() != null) {
            this.k.remove(zxVar);
            if (zxVar.a().getParent() != null) {
                ((ViewGroup) zxVar.a().getParent()).removeView(zxVar.a());
                zxVar.f();
                zxVar.j(null);
            }
        }
    }

    public void q(up6<T> up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, up6Var) == null) {
            xx<T> xxVar = this.g;
            if (xxVar != null) {
                xxVar.q(up6Var);
            }
            xx<T> xxVar2 = this.h;
            if (xxVar2 != null) {
                xxVar2.q(up6Var);
            }
            for (ey eyVar : this.i) {
                if (eyVar != null) {
                    eyVar.q(up6Var);
                }
            }
            xx<T> xxVar3 = this.j;
            if (xxVar3 != null) {
                xxVar3.q(up6Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mz(b bVar, BaseCardInfo.SupportType supportType) {
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
    public mz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(bVar, supportType, viewGroup, (eo) null);
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
                this((b) objArr2[0], (BaseCardInfo.SupportType) objArr2[1], (ViewGroup) objArr2[2], (eo) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public mz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, eo eoVar) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, supportType, viewGroup, eoVar};
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
        this.o = new xz();
        this.p = 0;
        this.q = new xz.a(7);
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
        this.d.setITypeListView(eoVar);
        l();
        int g = this.m.a() ? yi.g(this.b, R.dimen.M_W_X004) : 0;
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin + g, marginLayoutParams.topMargin + this.m.j, marginLayoutParams.rightMargin + g, marginLayoutParams.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL) {
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin + g, marginLayoutParams2.topMargin + this.m.e, marginLayoutParams2.rightMargin + g, marginLayoutParams2.bottomMargin);
                this.d.postInvalidate();
            }
        } else if (g != 0 && (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin + g, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin + g, marginLayoutParams3.bottomMargin);
            this.d.postInvalidate();
        }
        inflate.setOnTouchListener(new a(this));
    }

    public /* synthetic */ mz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, eo eoVar, a aVar) {
        this(bVar, supportType, viewGroup, eoVar);
    }

    public /* synthetic */ mz(b bVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, a aVar) {
        this(bVar, supportType, viewGroup);
    }

    public /* synthetic */ mz(b bVar, a aVar) {
        this(bVar);
    }

    public void n(int i, xz.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, bVar) == null) {
            this.o.a(i, bVar);
        }
    }

    public boolean p(xz.a aVar) {
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

    public void c(zx zxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zxVar) == null) && zxVar != null && zxVar.a() != null) {
            o(zxVar);
            zxVar.a().setVisibility(0);
            if (zxVar.d() == null) {
                this.e.addView(zxVar.a(), zxVar.c());
            } else {
                this.e.addView(zxVar.a(), zxVar.c(), zxVar.d());
            }
            zxVar.j(this);
            zxVar.e();
            this.k.add(zxVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zx zxVar = new zx();
            zxVar.g(new TbImageView(this.b));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(this.b, R.dimen.obfuscated_res_0x7f070386), yi.g(this.b, R.dimen.obfuscated_res_0x7f0703ec));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = -this.m.h;
            zxVar.i(layoutParams);
            zxVar.h(-1);
            this.k.add(zxVar);
        }
    }

    public xx<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (xx) invokeV.objValue;
    }

    public xx<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (xx) invokeV.objValue;
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

    public List<ey> i() {
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
            nz nzVar = this.m;
            ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(nzVar.g, nzVar.d, nzVar.h, nzVar.f);
            this.f.postInvalidate();
        }
        if (this.m.a) {
            d();
        }
        xx<T> xxVar = this.g;
        if (xxVar != null) {
            xxVar.o(this);
            this.f.addView(this.g.l());
            this.g.m();
        }
        xx<T> xxVar2 = this.h;
        if (xxVar2 != null) {
            xxVar2.o(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.m.b;
            if (this.h.k().booleanValue()) {
                nz nzVar2 = this.m;
                layoutParams.leftMargin = -nzVar2.g;
                layoutParams.rightMargin = -nzVar2.h;
            }
            this.f.addView(this.h.l(), layoutParams);
            this.h.m();
        }
        if (this.i != null) {
            for (int i = 0; i < this.i.size(); i++) {
                ey eyVar = this.i.get(i);
                if (eyVar != null) {
                    eyVar.o(this);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = eyVar.x();
                    layoutParams2.bottomMargin = eyVar.u();
                    if (eyVar.k().booleanValue()) {
                        nz nzVar3 = this.m;
                        layoutParams2.leftMargin = -nzVar3.g;
                        layoutParams2.rightMargin = -nzVar3.h;
                    }
                    this.f.addView(eyVar.l(), layoutParams2);
                    eyVar.m();
                }
            }
        }
        if (this.j != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = this.m.c;
            this.j.o(this);
            this.f.addView(this.j.l(), layoutParams3);
            this.j.m();
        }
        if (!ListUtils.isEmpty(this.k)) {
            Iterator<zx> it = this.k.iterator();
            while (it.hasNext()) {
                zx next = it.next();
                if (next != null && next.a() != null) {
                    if (next.d() == null) {
                        this.e.addView(next.a(), next.c());
                    } else {
                        this.e.addView(next.a(), next.c(), next.d());
                    }
                    next.j(this);
                    next.e();
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
                this.g.b(t);
                xx<T> xxVar = this.g;
                if (xxVar instanceof fta) {
                    this.d.setTag(R.id.virtual_image_user_head, xxVar);
                }
            }
            xx<T> xxVar2 = this.h;
            if (xxVar2 != null) {
                xxVar2.b(t);
            }
            if (!ListUtils.isEmpty(this.i)) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    ey eyVar = this.i.get(i);
                    eyVar.b(t);
                    if (i == 0) {
                        boolean z = true;
                        ThreadCardUtils.dealMainViewTopMargin(eyVar.l(), (ThreadCardUtils.isNoThreadTitle(t.getThreadData()) && ThreadCardUtils.isNoThreadAbstract(t.getThreadData()) && ThreadCardUtils.isNoThreadVoice(t.getThreadData()) && t.getThreadData().picCount() < 1 && t.getThreadData().getThreadVideoInfo() == null) ? false : false, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    }
                }
            }
            xx<T> xxVar3 = this.j;
            if (xxVar3 != null) {
                xxVar3.b(t);
            }
            ry<T> ryVar = this.a;
            if (ryVar != null) {
                ryVar.b(t);
            }
            e(this.f);
            e(this.e);
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        T t;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, tbPageContext, i) == null) {
            T t3 = this.n;
            if (t3 != null && !t3.isSupportNone()) {
                SkinManager.setBackgroundResource(this.d, this.m.i);
            }
            xx<T> xxVar = this.g;
            if (xxVar != null) {
                xxVar.onChangeSkinType(tbPageContext, i);
                if (this.j == null && ((t2 = this.n) == null || !t2.isSupportContent())) {
                    d85 d = d85.d(this.d);
                    d.n(1);
                    d.o(R.string.J_X06);
                    d.f(this.m.i);
                }
            }
            xx<T> xxVar2 = this.h;
            if (xxVar2 != null) {
                xxVar2.onChangeSkinType(tbPageContext, i);
            }
            for (ey eyVar : this.i) {
                if (eyVar != null) {
                    eyVar.onChangeSkinType(tbPageContext, i);
                }
            }
            xx<T> xxVar3 = this.j;
            if (xxVar3 != null) {
                xxVar3.onChangeSkinType(tbPageContext, i);
                if (this.g == null && ((t = this.n) == null || !t.isSupportContent())) {
                    d85 d2 = d85.d(this.d);
                    d2.n(2);
                    d2.o(R.string.J_X06);
                    d2.f(this.m.i);
                }
            }
            if (this.g != null && this.j != null) {
                d85 d3 = d85.d(this.d);
                d3.o(R.string.J_X06);
                d3.j(this.m.i, R.color.CAM_X0206);
            }
            FrameLayout frameLayout = this.c;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
            }
            if (!ListUtils.isEmpty(this.k)) {
                Iterator<zx> it = this.k.iterator();
                while (it.hasNext()) {
                    zx next = it.next();
                    if (next != null && (next instanceof sy)) {
                        ((sy) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            sy syVar = this.l;
            if (syVar != null) {
                syVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }
}

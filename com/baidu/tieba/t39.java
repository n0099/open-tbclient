package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class t39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public int b;
    public int c;
    public ListView d;
    public String e;
    public int f;
    public Map<String, Integer> g;
    public View h;
    public boolean i;
    public yy9 j;
    public iz9 k;
    public boolean l;
    public uy9 m;
    public final CustomMessageListener n;
    public n39 o;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t39 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t39 t39Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t39Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t39Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.s();
            if (!this.a.l || !this.a.l) {
                return;
            }
            t39 t39Var = this.a;
            t39Var.k(t39Var.k.a(), this.a.k.b(), this.a.k.d(), this.a.k.c());
        }
    }

    public t39(BdPageContext bdPageContext, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.e = null;
        this.f = 0;
        this.g = new HashMap();
        this.i = false;
        this.l = true;
        this.m = new uy9();
        this.n = new a(this, 2000994);
        this.o = new n39(this);
        this.a = bdPageContext;
        this.b = BdUtilHelper.getEquipmentHeight(bdPageContext.getPageActivity());
        this.d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new iz9();
        bdPageContext.registerListener(this.n);
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.g.containsKey(str)) {
                return this.g.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.g.containsKey(str)) {
            this.g.put(str, 0);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.e = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f = i;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.m);
            SafeHandler.getInst().removeCallbacks(this.o);
            d();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof yy9) {
                    ((yy9) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public void h(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 != null && !i(view2) && (view2.getTag() instanceof yy9)) {
            yy9 yy9Var = (yy9) view2.getTag();
            if (!TextUtils.isEmpty(yy9Var.getPlayUrl()) && yy9Var.getCurrentPosition() > 0) {
                q(yy9Var.getPlayUrl(), yy9Var.getCurrentPosition());
            }
            yy9Var.stopPlay();
        }
    }

    public boolean i(View view2) {
        InterceptResult invokeL;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            if (view2 == null) {
                return false;
            }
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (view2 == null || (measuredHeight = i + (view2.getMeasuredHeight() / 2)) <= this.c || measuredHeight >= this.b) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j(int i, int i2, boolean z, int i3) {
        ListAdapter adapter;
        boolean z2;
        boolean z3;
        int childCount;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.k.e(i, i2, z);
            ListView listView = this.d;
            if (listView != null && listView.getChildCount() != 0) {
                ListView listView2 = this.d;
                if (listView2 instanceof BdListView) {
                    adapter = ((BdListView) listView2).getWrappedAdapter();
                } else {
                    adapter = listView2.getAdapter();
                }
                if (adapter != null && adapter.getCount() != 0) {
                    yy9 yy9Var = this.j;
                    if (yy9Var != null && !i(yy9Var.getVideoContainer())) {
                        this.j.stopPlay();
                    }
                    int count = adapter.getCount() + this.d.getHeaderViewsCount() + this.d.getFooterViewsCount();
                    int i5 = 0;
                    if (i == 0) {
                        z2 = true;
                    } else {
                        int i6 = count - 1;
                        z2 = false;
                    }
                    if (i != 0 && i2 != count - 1) {
                        z3 = false;
                    } else {
                        z3 = false;
                        for (int i7 = 0; i7 < this.d.getChildCount(); i7++) {
                            if (z2) {
                                childCount = i7;
                            } else {
                                childCount = (this.d.getChildCount() - 1) - i7;
                            }
                            View childAt = this.d.getChildAt(childCount);
                            if (childAt.getTag() instanceof yy9) {
                                yy9 yy9Var2 = (yy9) childAt.getTag();
                                if (!z3 && i(yy9Var2.getVideoContainer())) {
                                    r(i3, childAt);
                                    z3 = true;
                                } else {
                                    if (!TextUtils.isEmpty(yy9Var2.getPlayUrl()) && yy9Var2.getCurrentPosition() > 0) {
                                        q(yy9Var2.getPlayUrl(), yy9Var2.getCurrentPosition());
                                    }
                                    u(i3, childAt);
                                }
                            }
                        }
                    }
                    if (z3) {
                        return;
                    }
                    int i8 = -1;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= this.d.getChildCount()) {
                            break;
                        }
                        View childAt2 = this.d.getChildAt(i9);
                        if (childAt2.getTag() instanceof yy9) {
                            yy9 yy9Var3 = (yy9) childAt2.getTag();
                            if (yy9Var3.isPlayStarted() && i(yy9Var3.getVideoContainer())) {
                                i8 = i9;
                                break;
                            }
                        }
                        i9++;
                    }
                    if (i8 >= 0) {
                        while (i5 < this.d.getChildCount()) {
                            View childAt3 = this.d.getChildAt(i5);
                            if (i5 == i8) {
                                r(i3, childAt3);
                            } else {
                                if (childAt3.getTag() instanceof yy9) {
                                    yy9 yy9Var4 = (yy9) childAt3.getTag();
                                    if (!TextUtils.isEmpty(yy9Var4.getPlayUrl()) && yy9Var4.getCurrentPosition() > 0) {
                                        q(yy9Var4.getPlayUrl(), yy9Var4.getCurrentPosition());
                                    }
                                }
                                u(i3, childAt3);
                            }
                            i5++;
                        }
                        return;
                    }
                    boolean z4 = false;
                    while (i5 < this.d.getChildCount()) {
                        if (z) {
                            i4 = (this.d.getChildCount() - 1) - i5;
                        } else {
                            i4 = i5;
                        }
                        View childAt4 = this.d.getChildAt(i4);
                        if (childAt4.getTag() instanceof yy9) {
                            yy9 yy9Var5 = (yy9) childAt4.getTag();
                            if (!z4 && i(yy9Var5.getVideoContainer())) {
                                r(i3, childAt4);
                                z4 = true;
                            } else {
                                if (!TextUtils.isEmpty(yy9Var5.getPlayUrl()) && yy9Var5.getCurrentPosition() > 0) {
                                    q(yy9Var5.getPlayUrl(), yy9Var5.getCurrentPosition());
                                }
                                u(i3, childAt4);
                            }
                        }
                        i5++;
                    }
                }
            }
        }
    }

    public void k(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SafeHandler.getInst().removeCallbacks(this.o);
            this.o.a(i);
            this.o.c(i2);
            this.o.b(z);
            this.o.d(z2);
            this.k.f(z2);
            SafeHandler.getInst().post(this.o);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !this.l) {
            return;
        }
        View view2 = this.h;
        if (view2 != null && (view2.getTag() instanceof yy9)) {
            yy9 yy9Var = (yy9) this.h.getTag();
            if (this.i) {
                yy9Var.startPlay();
            }
            if (this.h.getTag() instanceof xy9) {
                ((xy9) this.h.getTag()).b();
            }
        }
        this.h = null;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.m);
            SafeHandler.getInst().removeCallbacks(this.o);
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof yy9) {
                    yy9 yy9Var = (yy9) childAt.getTag();
                    if (yy9Var.isPlayStarted()) {
                        yy9Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.d.getChildCount(); i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt.getTag() instanceof yy9) {
                    yy9 yy9Var = (yy9) childAt.getTag();
                    if (yy9Var.isPlayStarted()) {
                        p(yy9Var.getCurrentPosition());
                        o(yy9Var.getPlayUrl());
                        this.h = childAt;
                        this.i = yy9Var.isPlaying();
                        yy9Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            if (this.g.containsKey(str)) {
                if (this.g.get(str).intValue() == 0) {
                    return;
                }
                this.g.put(str, Integer.valueOf(i));
                return;
            }
            this.g.put(str, Integer.valueOf(i));
        }
    }

    public final void u(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view2) == null) {
            if (i == 1 && (view2.getTag() instanceof yy9)) {
                ((yy9) view2.getTag()).stopPlay();
            } else if (i == 2 && (view2.getTag() instanceof xy9)) {
                ((xy9) view2.getTag()).e();
            }
        }
    }

    public final void r(int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048591, this, i, view2) != null) || view2 == null) {
            return;
        }
        this.h = view2;
        if (i == 1 && (view2.getTag() instanceof yy9)) {
            yy9 yy9Var = (yy9) view2.getTag();
            if (this.l && !yy9Var.isPlayStarted()) {
                yy9Var.startPlay();
            }
        } else if (i == 2 && (view2.getTag() instanceof xy9)) {
            ((xy9) view2.getTag()).a();
        }
    }
}

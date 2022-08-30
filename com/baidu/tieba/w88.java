package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public d9 b;
    public int c;
    public int d;
    public rn e;
    public View f;
    public boolean g;
    public q88 h;
    public z88 i;
    public boolean j;
    public float k;
    public boolean l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public m88 o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public n88 r;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w88 w88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var, Integer.valueOf(i)};
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
            this.a = w88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            sg.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w88 w88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var, Integer.valueOf(i)};
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
            this.a = w88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            sg.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w88 w88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var, Integer.valueOf(i)};
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
            this.a = w88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.x();
                if (this.a.l && this.a.l) {
                    w88 w88Var = this.a;
                    w88Var.n(w88Var.i.a(), this.a.i.b(), this.a.i.d(), this.a.i.c());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w88 w88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var, Integer.valueOf(i)};
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
            this.a = w88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (qi.isEmpty(str)) {
                    return;
                }
                sg.a().removeCallbacks(this.a.o);
                sg.a().removeCallbacks(this.a.r);
                if (this.a.f != null && (this.a.f.getTag() instanceof q88)) {
                    if (str.equals(((q88) this.a.f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((q88) this.a.f.getTag()).stopPlay();
                }
                for (int i = 0; i < this.a.e.getListView().getChildCount(); i++) {
                    View childAt = this.a.e.getListView().getChildAt(i);
                    if ((childAt.getTag() instanceof q88) && str.equals(((q88) childAt.getTag()).getPlayUrl())) {
                        this.a.f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public w88(d9 d9Var, rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, rnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = 0;
        this.d = 0;
        this.g = false;
        this.j = true;
        this.k = 0.0f;
        this.l = true;
        this.m = new a(this, 2921637);
        this.n = new b(this, 2921636);
        this.o = new m88();
        this.p = new c(this, 2000994);
        this.q = new d(this, 2921387);
        this.r = new n88(this);
        this.b = d9Var;
        this.c = ri.i(d9Var.getPageActivity());
        this.e = rnVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.i = new z88();
        d9Var.registerListener(this.p);
        d9Var.registerListener(this.n);
        d9Var.registerListener(this.m);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            sg.a().removeCallbacks(this.o);
            sg.a().removeCallbacks(this.r);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof q88) {
                    ((q88) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public void k(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null || l(view2) || !(view2.getTag() instanceof q88)) {
            return;
        }
        ((q88) view2.getTag()).stopPlay();
    }

    public boolean l(View view2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            int i2 = this.a;
            if (i2 == 1) {
                int i3 = ri.i(this.b.getPageActivity()) / 2;
                int i4 = rect.top;
                return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view2.getMeasuredHeight();
            } else if (i2 == 2) {
                int j = ri.j(this.b.getPageActivity(), true);
                float measuredHeight = (view2.getMeasuredHeight() * 2.0f) / 3.0f;
                float statusBarHeight = UtilHelper.getStatusBarHeight() + measuredHeight + ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                int mainTabBottomBarHeight = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (this.j) {
                    this.k = measuredHeight + mainTabBottomBarHeight;
                } else {
                    this.k = measuredHeight;
                }
                return ((float) rect.top) <= ((float) j) - this.k && ((float) rect.bottom) >= statusBarHeight;
            } else {
                int i5 = rect.top;
                return i5 >= 0 && (i = rect.bottom) <= this.c - this.d && i - i5 >= view2.getMeasuredHeight();
            }
        }
        return invokeL.booleanValue;
    }

    public void m(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.i.e(i, i2, z);
            rn rnVar = this.e;
            if (rnVar == null || rnVar.getListView().getChildCount() == 0 || this.e.getContentViewsCount() == 0) {
                return;
            }
            q88 q88Var = this.h;
            if (q88Var != null && !l(q88Var.getVideoContainer())) {
                this.h.stopPlay();
            }
            View view3 = this.f;
            int i4 = 0;
            if (view3 != null && (view3.getTag() instanceof q88) && this.g) {
                if (l(((q88) this.f.getTag()).getVideoContainer())) {
                    w(i3, this.f);
                    this.g = false;
                    return;
                }
                this.f = null;
            }
            int contentViewsCount = this.e.getContentViewsCount() + this.e.getHeaderViewsCount() + this.e.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                int i5 = contentViewsCount - 1;
                z2 = false;
            }
            int childCount = this.e.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = this.e.getListView().getChildAt(z2 ? i6 : (childCount - 1) - i6);
                    if (childAt.getTag() instanceof q88) {
                        q88 q88Var2 = (q88) childAt.getTag();
                        if (!z3 && l(q88Var2.getVideoContainer())) {
                            w(i3, childAt);
                            z3 = true;
                        } else {
                            z(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
            int i7 = -1;
            int i8 = 0;
            while (true) {
                if (i8 >= childCount) {
                    break;
                }
                View childAt2 = this.e.getListView().getChildAt(i8);
                if (childAt2.getTag() instanceof q88) {
                    q88 q88Var3 = (q88) childAt2.getTag();
                    if (q88Var3.isPlayStarted() && l(q88Var3.getVideoContainer())) {
                        i7 = i8;
                        break;
                    }
                }
                i8++;
            }
            if (i7 >= 0) {
                while (i4 < childCount) {
                    View childAt3 = this.e.getListView().getChildAt(i4);
                    if (i4 != i7) {
                        z(i3, childAt3);
                    } else {
                        w(i3, childAt3);
                    }
                    i4++;
                }
                return;
            }
            boolean z4 = false;
            while (i4 < childCount) {
                View childAt4 = this.e.getListView().getChildAt(z ? (childCount - 1) - i4 : i4);
                if (childAt4.getTag() instanceof q88) {
                    q88 q88Var4 = (q88) childAt4.getTag();
                    if (!z4 && (q88Var4.isFullScreen() || l(q88Var4.getVideoContainer()))) {
                        w(i3, childAt4);
                        z4 = true;
                    } else {
                        z(i3, childAt4);
                    }
                }
                i4++;
            }
            if (z4 || (view2 = this.f) == null || !(view2.getTag() instanceof q88)) {
                return;
            }
            ((q88) this.f.getTag()).stopPlay();
        }
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            sg.a().removeCallbacks(this.r);
            this.r.a(i);
            this.r.c(i2);
            this.r.b(z);
            this.r.d(z2);
            this.i.f(z2);
            sg.a().postDelayed(this.r, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.l) {
            View view2 = this.f;
            if (view2 != null && (view2.getTag() instanceof q88)) {
                q88 q88Var = (q88) this.f.getTag();
                if (this.g) {
                    q88Var.startPlay();
                    this.g = false;
                }
                if (this.f.getTag() instanceof p88) {
                    ((p88) this.f.getTag()).b();
                }
            }
            this.f = null;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
        }
    }

    public void r(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
            if (z || (view2 = this.f) == null || !(view2.getTag() instanceof q88) || ((q88) this.f.getTag()).getVideoContainer() == null) {
                return;
            }
            ((q88) this.f.getTag()).getVideoContainer().setTag(-1001, "1");
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.p;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.q;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.q.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.d = i;
        }
    }

    public final void w(int i, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i, view2) == null) || view2 == null) {
            return;
        }
        View view3 = this.f;
        if (view3 != null && view3 != view2 && (view3.getTag() instanceof q88)) {
            ((q88) this.f.getTag()).stopPlay();
        }
        this.f = view2;
        if (i == 1 && (view2.getTag() instanceof q88)) {
            q88 q88Var = (q88) view2.getTag();
            if (!this.l || q88Var.isPlayStarted()) {
                return;
            }
            q88Var.startPlay();
        } else if (i == 2 && (view2.getTag() instanceof p88)) {
            ((p88) view2.getTag()).a();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            sg.a().removeCallbacks(this.o);
            sg.a().removeCallbacks(this.r);
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof q88) {
                    q88 q88Var = (q88) childAt.getTag();
                    if (q88Var.isPlayStarted()) {
                        q88Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.e.getListView().getChildCount(); i++) {
                View childAt = this.e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof q88) {
                    q88 q88Var = (q88) childAt.getTag();
                    if (q88Var.isPlayStarted()) {
                        t(q88Var.getCurrentPosition());
                        s(q88Var.getPlayUrl());
                        this.f = childAt;
                        this.g = q88Var.isPlaying();
                        q88Var.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void z(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view2) == null) {
            if (i == 1 && (view2.getTag() instanceof q88)) {
                q88 q88Var = (q88) view2.getTag();
                if (q88Var.isPlaying()) {
                    q88Var.stopPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof p88)) {
                ((p88) view2.getTag()).e();
            }
        }
    }
}

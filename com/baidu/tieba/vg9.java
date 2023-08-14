package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class vg9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public boolean b;
    public boolean c;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public final Handler l;
    public boolean m;
    public final Runnable n;
    public long o;
    public long p;
    public long q;
    public boolean r;
    public int s;
    public final int t;
    public final BdTypeListView u;
    public int v;
    public int w;
    public boolean x;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg9 a;

        public a(vg9 vg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r = true;
            if (vg9.y) {
                Log.d("PbEnterFrsTipShowRule-C", "completeStayPageTime = true");
            }
            this.a.o();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948239969, "Lcom/baidu/tieba/vg9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948239969, "Lcom/baidu/tieba/vg9;");
                return;
            }
        }
        y = GlobalBuildConfig.isDebug();
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.r || !this.x) {
                return true;
            }
            if (this.c) {
                return g();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m = false;
            this.l.removeCallbacks(this.n);
            this.p += System.currentTimeMillis() - this.q;
        }
    }

    public vg9(BdTypeListView bdTypeListView, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = 0;
        this.t = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
        this.v = -1;
        this.w = -1;
        this.u = bdTypeListView;
        this.a = bVar;
        this.l = new Handler(Looper.getMainLooper());
        this.n = new a(this);
    }

    public final int c(List<ym> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, list, z)) == null) {
            if (ListUtils.isEmpty(list)) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof rba) && list.get(i2).getType() == rba.W0 && (i = i + 1) == this.s) {
                    return i2;
                }
            }
            if (z) {
                return -1;
            }
            return list.size() - 1;
        }
        return invokeLZ.intValue;
    }

    public void i(boolean z, int i) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || !this.i || i == 3 || (bdTypeListView = this.u) == null) {
            return;
        }
        this.w = c(bdTypeListView.getData(), z);
        if (y) {
            Log.d("PbEnterFrsTipShowRule-C", "onDataSet mTargetIndex = " + this.w);
        }
    }

    public void m(@Nullable ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, forumData) == null) && forumData != null && !TextUtils.isEmpty(forumData.getId())) {
            e(forumData);
            f();
            d();
        }
    }

    public final void d() {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = true;
            this.h = 0;
            this.f = this.e;
            VisitedForumData p = my6.n().p(this.d);
            if (p != null) {
                if (y) {
                    Log.d("PbEnterFrsTipShowRule-C", "lastVisitedTime = " + p.getVisitedTime());
                    Log.d("PbEnterFrsTipShowRule-C", "lastPostNum = " + p.getPostNum());
                }
                b2 = p.getPostNum();
                this.h = JavaTypesHelper.toInt(p.getVisitedTime(), 0);
            } else {
                b2 = ug9.a().b(this.d);
            }
            if (b2 < 0) {
                b2 = 0;
            }
            int i = this.e - b2;
            this.f = i;
            if (i <= 0) {
                this.f = 0;
            }
            if (this.f < this.k) {
                this.g = false;
            }
            if (y) {
                Log.d("PbEnterFrsTipShowRule-C", "满足新贴数条件 = " + this.g);
            }
        }
    }

    public final void e(@Nullable ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData) == null) {
            boolean z = true;
            if (forumData.isLike() != 1) {
                z = false;
            }
            this.c = z;
            this.d = forumData.getId();
            this.e = forumData.getPost_num();
            if (y) {
                Log.d("PbEnterFrsTipShowRule-C", "newForumPostNum" + this.e);
            }
            if (this.c && ug9.a().b(this.d) < 0) {
                ug9.a().e(forumData.getId(), forumData.getPost_num());
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = hk9.h(this.c) * 1000;
            this.s = hk9.e(this.c);
            this.j = hk9.d();
            this.k = hk9.b();
            this.i = true;
            n();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.g) {
                if (y) {
                    Log.d("PbEnterFrsTipShowRule-C", "新贴数 拦截");
                }
                return true;
            } else if (((int) (System.currentTimeMillis() / 1000)) - this.h < this.j * 86400) {
                if (y) {
                    Log.d("PbEnterFrsTipShowRule-C", "距离上次浏览时间 拦截");
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = true;
            d();
            this.l.removeCallbacks(this.n);
            this.q = System.currentTimeMillis();
            if (!this.r) {
                if (this.o > 0) {
                    n();
                    return;
                }
                return;
            }
            o();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !this.b && this.i) {
            if (h()) {
                if (y) {
                    Log.d("PbEnterFrsTipShowRule", "tryToShowTip = false");
                    return;
                }
                return;
            }
            if (y) {
                Log.d("PbEnterFrsTipShowRule-C", "tryToShowTip = hasShown");
            }
            this.b = true;
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(this.f);
            }
        }
    }

    public void l(int i, int i2) {
        BdTypeListView bdTypeListView;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048585, this, i, i2) != null) || (bdTypeListView = this.u) == null || this.b || !this.i || this.w < 0 || (childAt = bdTypeListView.getChildAt(i2 - 1)) == null) {
            return;
        }
        if (this.v <= 0) {
            this.v = this.u.getHeight() - this.t;
        }
        if (this.v <= 0) {
            return;
        }
        if (this.x) {
            o();
            return;
        }
        int headerViewsCount = this.w + this.u.getHeaderViewsCount();
        int i3 = (i + i2) - 1;
        if (i3 > headerViewsCount) {
            if (i3 - 1 == headerViewsCount && childAt.getTop() > this.v) {
                return;
            }
            this.x = true;
            if (y) {
                Log.d("PbEnterFrsTipShowRule-C", "completeGuideFloor = true");
            }
            o();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.b && this.i && this.m) {
            this.l.removeCallbacks(this.n);
            long j = this.o - this.p;
            if (y) {
                Log.d("PbEnterFrsTipShowRule", "remainTime = " + j);
            }
            if (j <= 0) {
                this.l.post(this.n);
            } else {
                this.l.postDelayed(this.n, j);
            }
        }
    }
}

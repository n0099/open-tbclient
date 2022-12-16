package com.baidu.tieba;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aw6 a;
    public LongSparseArray<Integer> b;
    public cr6 c;
    public yv6 d;
    public Runnable e;
    public FrsFragment f;
    public boolean g;
    public boolean h;
    public ar8 i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw6 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(zv6 zv6Var, uw6 uw6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var, uw6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw6Var;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                uw6 uw6Var = this.a;
                if (uw6Var != null) {
                    uw6Var.o(this.b, this.c);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumData a;
        public final /* synthetic */ zv6 b;

        public b(zv6 zv6Var, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var, forumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv6Var;
            this.a = forumData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.h) {
                    this.b.r(this.a.getName(), this.a.getId(), this.a.getImage_url(), true);
                } else {
                    this.b.g = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zv6 zv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv6Var, Integer.valueOf(i)};
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
            this.a = zv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof ForumData) {
                    this.a.i((ForumData) customResponsedMessage.getData());
                } else if (customResponsedMessage.getData() instanceof Long) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (this.a.m(longValue) && this.a.d(longValue) >= 3) {
                        this.a.e(longValue);
                        this.a.g = true;
                    }
                }
            }
        }
    }

    public zv6(FrsFragment frsFragment, ar8 ar8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ar8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.g = false;
        this.h = false;
        this.j = new c(this, 2921498);
        this.a = new aw6();
        this.b = new LongSparseArray<>();
        this.f = frsFragment;
        this.i = ar8Var;
    }

    public zv6(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
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
        this.g = false;
        this.h = false;
        this.j = new c(this, 2921498);
        this.d = new yv6(str, str2);
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j != 0) {
            this.b.remove(j);
        }
    }

    public boolean m(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            ar8 ar8Var = this.i;
            if (ar8Var == null || j == 0 || (forum = ar8Var.getForum()) == null || xg.g(forum.getId(), 0L) != j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.h = z;
        }
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.b(str, str2);
        }
    }

    public int d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.b.get(j);
            if (num == null) {
                this.b.put(j, 1);
                return 1;
            }
            this.b.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void g() {
        cr6 cr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cr6Var = this.c) != null) {
            cr6Var.n();
        }
    }

    public aw6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (aw6) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cr6 cr6Var = this.c;
            if (cr6Var != null && cr6Var.o()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ah.a().removeCallbacks(this.e);
        }
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, forumData) != null) || forumData == null) {
            return;
        }
        boolean z = false;
        if (r(forumData.getName(), forumData.getId(), forumData.getImage_url(), false)) {
            if (this.e != null) {
                ah.a().removeCallbacks(this.e);
            }
            z = true;
        }
        if (z) {
            return;
        }
        Runnable runnable = this.e;
        if (runnable == null) {
            runnable = new b(this, forumData);
        }
        this.e = runnable;
        ah.a().postDelayed(this.e, 60000L);
    }

    public void i(ForumData forumData) {
        FrsFragment frsFragment;
        ar8 ar8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, forumData) == null) && (frsFragment = this.f) != null && frsFragment.q0() != null) {
            if (forumData == null && (ar8Var = this.i) != null) {
                forumData = ar8Var.getForum();
            }
            if (forumData != null && forumData.isLike() != 1) {
                if (!this.h) {
                    this.g = true;
                } else if (r(forumData.getName(), forumData.getId(), forumData.getImage_url(), false) && this.e != null) {
                    ah.a().removeCallbacks(this.e);
                }
            }
        }
    }

    public void p(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, activity, str, str2) == null) && activity != null && this.d.c()) {
            if (this.c == null) {
                this.c = new cr6(activity, R.id.obfuscated_res_0x7f090b7e);
            }
            this.c.r(str);
            this.c.s(str2);
            this.c.t();
        }
    }

    public boolean q(String str, String str2) {
        InterceptResult invokeLL;
        aw6 aw6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (aw6Var = this.a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - aw6Var.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.a.e(str, str2) > 3 && currentTimeMillis < 2592000000L) {
                return false;
            }
            long c2 = this.a.c(str, str2);
            if (c2 != 0 && System.currentTimeMillis() - c2 <= 604800000) {
                return true;
            }
            return this.a.d(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean r(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!q(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.f) == null || frsFragment.q0() == null) {
                return false;
            }
            this.g = false;
            s(this.f.getActivity(), str, str2, str3, this.f.q0().C());
            j().g(TbadkCoreApplication.getCurrentAccount(), str2, System.currentTimeMillis(), z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void s(Activity activity, String str, String str2, String str3, uw6 uw6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048591, this, activity, str, str2, str3, uw6Var) != null) || activity == null) {
            return;
        }
        if (this.c == null) {
            this.c = new cr6(activity, R.id.obfuscated_res_0x7f090b82);
        }
        if (!StringUtils.isNull(str3)) {
            this.c.p(str3);
        }
        this.c.q(new a(this, uw6Var, str, str2));
        this.c.u();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

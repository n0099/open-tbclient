package com.baidu.tieba;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes7.dex */
public class o68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xz7 a;
    public l68 b;
    public p68 c;
    public LongSparseArray<Integer> d;
    public FrsFragment e;
    public boolean f;
    public boolean g;
    public eva h;
    public FrsSpriteGuideTipController i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a implements FrsSpriteGuideTipController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k78 c;
        public final /* synthetic */ o68 d;

        public a(o68 o68Var, String str, String str2, k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o68Var, str, str2, k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o68Var;
            this.a = str;
            this.b = str2;
            this.c = k78Var;
        }

        @Override // com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.d.d(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k78 c;
        public final /* synthetic */ o68 d;

        public b(o68 o68Var, String str, String str2, k78 k78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o68Var, str, str2, k78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o68Var;
            this.a = str;
            this.b = str2;
            this.c = k78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.d.d(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(o68 o68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o68Var, Integer.valueOf(i)};
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
            this.a = o68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.m(longValue) && this.a.c(longValue) >= 1) {
                    this.a.e(longValue);
                    this.a.f = true;
                }
            }
        }
    }

    public o68(FrsFragment frsFragment, eva evaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, evaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.f = false;
        this.g = false;
        this.j = new c(this, 2921498);
        this.c = new p68();
        this.d = new LongSparseArray<>();
        this.e = frsFragment;
        this.h = evaVar;
    }

    public boolean p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (l(str) && l(str2)) {
                if (TimeHelper.getDayDifference(System.currentTimeMillis(), this.c.b(str, str2)) < 1) {
                    DefaultLog.getInstance().e("FrsGuide", "显示frs吧关注引导失败: 一天内只出现一次");
                    return false;
                }
                return true;
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("FrsGuide", "显示frs吧关注引导失败: 不是有效id " + str + " " + str2);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public o68(String str, String str2) {
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
        this.c = null;
        this.f = false;
        this.g = false;
        this.j = new c(this, 2921498);
        this.b = new l68(str, str2);
    }

    public final void s(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) {
            i().c(TbadkCoreApplication.getCurrentAccount(), str, System.currentTimeMillis(), z);
        }
    }

    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.d.get(j);
            if (num == null) {
                this.d.put(j, 1);
                return 1;
            }
            this.d.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public final void d(String str, String str2, k78 k78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, k78Var) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("FrsGuide", "吧关注弹窗按钮点击:吧Id：" + str + " 吧名：" + str2);
            if (k78Var != null) {
                k78Var.v(str2, str);
            }
            TiebaStatic.log(new StatisticItem("c13982").param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && j != 0) {
            this.d.remove(j);
        }
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!StringUtils.isNull(str) && !"0".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            eva evaVar = this.h;
            if (evaVar == null || j == 0 || (forum = evaVar.getForum()) == null || JavaTypesHelper.toLong(forum.getId(), 0L) != j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.g = z;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            xz7 xz7Var = this.a;
            if (xz7Var != null) {
                xz7Var.o();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.i;
            if (frsSpriteGuideTipController != null) {
                frsSpriteGuideTipController.g();
            }
            h();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921827, Boolean.TRUE));
        }
    }

    public p68 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (p68) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsSpriteGuideTipController frsSpriteGuideTipController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            xz7 xz7Var = this.a;
            if ((xz7Var != null && xz7Var.p()) || ((frsSpriteGuideTipController = this.i) != null && frsSpriteGuideTipController.h())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(ForumData forumData) {
        eva evaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumData) == null) {
            FrsFragment frsFragment = this.e;
            if (frsFragment != null && frsFragment.c1() != null) {
                if (forumData == null && (evaVar = this.h) != null) {
                    forumData = evaVar.getForum();
                }
                if (forumData != null && forumData.isLike() != 1) {
                    if (!this.g) {
                        DefaultLog.getInstance().i("FrsGuide", "显示frs吧关注引导失败: 当前页面不可见");
                        this.f = true;
                        return;
                    }
                    q(forumData.getName(), forumData.getId(), forumData.getImage_url(), false);
                    return;
                }
                return;
            }
            DefaultLog.getInstance().i("FrsGuide", "显示frs吧关注引导失败: headerView为空");
        }
    }

    public void o(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, activity, str, str2) == null) && activity != null && this.b.c()) {
            if (this.a == null) {
                this.a = new xz7(activity, R.id.obfuscated_res_0x7f090d25);
            }
            this.a.s(str);
            this.a.u(str2);
            this.a.v();
        }
    }

    public final boolean q(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!p(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.e) == null || frsFragment.c1() == null) {
                return false;
            }
            this.f = false;
            r(this.e.getActivity(), str, str2, str3, this.e.c1().W());
            s(str2, z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void r(Activity activity, String str, String str2, String str3, k78 k78Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048591, this, activity, str, str2, str3, k78Var) != null) || activity == null) {
            return;
        }
        if (lk5.e()) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("FrsGuide", "使用精灵动画吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            FrsSpriteGuideTipController frsSpriteGuideTipController = new FrsSpriteGuideTipController(activity, str2);
            this.i = frsSpriteGuideTipController;
            frsSpriteGuideTipController.i(new a(this, str2, str, k78Var));
            v05.g(Collections.singletonList(new yz7(activity, null, this.i)));
        } else {
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.i("FrsGuide", "使用线上吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            if (this.a == null) {
                this.a = new xz7(activity, R.id.obfuscated_res_0x7f090d29);
            }
            if (!StringUtils.isNull(str3)) {
                this.a.q(str3);
            }
            this.a.r(new b(this, str2, str, k78Var));
            v05.g(Collections.singletonList(new yz7(activity, this.a, null)));
        }
        TbLog defaultLog3 = DefaultLog.getInstance();
        defaultLog3.i("FrsGuide", "吧关注弹窗曝光:吧Id：" + str2 + " 吧名：" + str);
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.gametab.FrsNewUserGuideTipController;
import com.baidu.tieba.frs.gametab.FrsSpriteGuideTipController;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.no6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes8.dex */
public class tq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mk7 a;
    public sq7 b;
    public uq7 c;
    public LongSparseArray<Integer> d;
    public FrsFragment e;
    public boolean f;
    public boolean g;
    public fda h;
    public FrsSpriteGuideTipController i;
    public FrsNewUserGuideTipController j;
    public boolean k;
    public CustomMessageListener l;

    /* loaded from: classes8.dex */
    public class a implements no6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(tq7 tq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.no6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements FrsSpriteGuideTipController.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pr7 c;
        public final /* synthetic */ tq7 d;

        public b(tq7 tq7Var, String str, String str2, pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq7Var, str, str2, pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tq7Var;
            this.a = str;
            this.b = str2;
            this.c = pr7Var;
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

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pr7 c;
        public final /* synthetic */ tq7 d;

        public c(tq7 tq7Var, String str, String str2, pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq7Var, str, str2, pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tq7Var;
            this.a = str;
            this.b = str2;
            this.c = pr7Var;
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

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(tq7 tq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq7Var, Integer.valueOf(i)};
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
            this.a = tq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.o(longValue) && this.a.c(longValue) >= 1) {
                    this.a.e(longValue);
                    this.a.f = true;
                }
            }
        }
    }

    public tq7(FrsFragment frsFragment, fda fdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, fdaVar};
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
        this.k = true;
        this.l = new d(this, 2921498);
        this.c = new uq7();
        this.d = new LongSparseArray<>();
        this.e = frsFragment;
        this.h = fdaVar;
    }

    public boolean s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) {
            if (n(str) && n(str2)) {
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

    public tq7(String str, String str2) {
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
        this.k = true;
        this.l = new d(this, 2921498);
        this.b = new sq7(str, str2);
    }

    public final void v(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, str, z) == null) {
            j().c(TbadkCoreApplication.getCurrentAccount(), str, System.currentTimeMillis(), z);
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

    public final void d(String str, String str2, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, pr7Var) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("FrsGuide", "吧关注弹窗按钮点击:吧Id：" + str + " 吧名：" + str2);
            if (pr7Var != null) {
                pr7Var.u(str2, str);
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

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!StringUtils.isNull(str) && !"0".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean o(long j) {
        InterceptResult invokeJ;
        ForumData forum;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            fda fdaVar = this.h;
            if (fdaVar == null || j == 0 || (forum = fdaVar.getForum()) == null || JavaTypesHelper.toLong(forum.getId(), 0L) != j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.g = z;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mk7 mk7Var = this.a;
            if (mk7Var != null) {
                mk7Var.o();
            }
            FrsSpriteGuideTipController frsSpriteGuideTipController = this.i;
            if (frsSpriteGuideTipController != null) {
                frsSpriteGuideTipController.g();
            }
            h();
        }
    }

    public void h() {
        FrsNewUserGuideTipController frsNewUserGuideTipController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (frsNewUserGuideTipController = this.j) != null) {
            frsNewUserGuideTipController.m();
        }
    }

    public uq7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (uq7) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsSpriteGuideTipController frsSpriteGuideTipController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            mk7 mk7Var = this.a;
            if ((mk7Var != null && mk7Var.p()) || ((frsSpriteGuideTipController = this.i) != null && frsSpriteGuideTipController.h())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsNewUserGuideTipController frsNewUserGuideTipController = this.j;
            if (frsNewUserGuideTipController != null && frsNewUserGuideTipController.n()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        FrsNewUserGuideTipController frsNewUserGuideTipController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (frsNewUserGuideTipController = this.j) != null) {
            frsNewUserGuideTipController.o();
        }
    }

    public void g(ForumData forumData) {
        fda fdaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumData) == null) {
            FrsFragment frsFragment = this.e;
            if (frsFragment != null && frsFragment.N0() != null) {
                if (forumData == null && (fdaVar = this.h) != null) {
                    forumData = fdaVar.getForum();
                }
                if (forumData != null && forumData.isLike() != 1) {
                    if (!this.g) {
                        DefaultLog.getInstance().i("FrsGuide", "显示frs吧关注引导失败: 当前页面不可见");
                        this.f = true;
                        return;
                    }
                    t(forumData.getName(), forumData.getId(), forumData.getImage_url(), false);
                    return;
                }
                return;
            }
            DefaultLog.getInstance().i("FrsGuide", "显示frs吧关注引导失败: headerView为空");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FrsFragment frsFragment = this.e;
            if (frsFragment != null && frsFragment.getActivity() != null) {
                fda fdaVar = this.h;
                if (fdaVar != null && fdaVar.getForum() != null && !TextUtils.isEmpty(this.h.getForum().getId())) {
                    if (!this.k) {
                        YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                        return;
                    }
                    String id = this.h.getForum().getId();
                    FragmentActivity activity = this.e.getActivity();
                    if (this.j == null) {
                        FrsNewUserGuideTipController frsNewUserGuideTipController = new FrsNewUserGuideTipController(activity);
                        this.j = frsNewUserGuideTipController;
                        frsNewUserGuideTipController.t(id);
                        this.j.u(new a(this));
                    }
                    this.j.w(this.h);
                    v(id, false);
                    this.k = false;
                    return;
                }
                YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
        }
    }

    public void r(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, activity, str, str2) == null) && activity != null && this.b.c()) {
            if (this.a == null) {
                this.a = new mk7(activity, R.id.obfuscated_res_0x7f090cd1);
            }
            this.a.s(str);
            this.a.u(str2);
            this.a.v();
        }
    }

    public final boolean t(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (!s(TbadkCoreApplication.getCurrentAccount(), str2) || (frsFragment = this.e) == null || frsFragment.N0() == null) {
                return false;
            }
            this.f = false;
            u(this.e.getActivity(), str, str2, str3, this.e.N0().S());
            v(str2, z);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void u(Activity activity, String str, String str2, String str3, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048594, this, activity, str, str2, str3, pr7Var) != null) || activity == null) {
            return;
        }
        if (mi5.e()) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("FrsGuide", "使用精灵动画吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            FrsSpriteGuideTipController frsSpriteGuideTipController = new FrsSpriteGuideTipController(activity, str2);
            this.i = frsSpriteGuideTipController;
            frsSpriteGuideTipController.i(new b(this, str2, str, pr7Var));
            xz4.g(Collections.singletonList(new nk7(activity, null, this.i)));
        } else {
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.i("FrsGuide", "使用线上吧关注提示控件吧Id：" + str2 + " 吧名：" + str);
            if (this.a == null) {
                this.a = new mk7(activity, R.id.obfuscated_res_0x7f090cd5);
            }
            if (!StringUtils.isNull(str3)) {
                this.a.q(str3);
            }
            this.a.r(new c(this, str2, str, pr7Var));
            xz4.g(Collections.singletonList(new nk7(activity, this.a, null)));
        }
        TbLog defaultLog3 = DefaultLog.getInstance();
        defaultLog3.i("FrsGuide", "吧关注弹窗曝光:吧Id：" + str2 + " 吧名：" + str);
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

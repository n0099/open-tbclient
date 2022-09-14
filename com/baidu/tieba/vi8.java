package com.baidu.tieba;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xi8 a;
    public wi8 b;
    public yi8 c;

    /* loaded from: classes6.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(vi8 vi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_IDLE_END_STAMP_KEY);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(vi8 vi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_HANDLER_END_STAMP_KEY);
            }
        }
    }

    public vi8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, baseFragmentActivity, viewGroup, i) == null) || baseFragmentActivity == null) {
            return;
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_METHOD_START_STAMP_KEY);
        b(baseFragmentActivity, viewGroup, i);
        c();
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_METHOD_END_STAMP_KEY);
    }

    public final void b(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, viewGroup, i) == null) {
            bj8 bj8Var = new bj8(baseFragmentActivity, viewGroup, i);
            this.a = bj8Var;
            cj8 cj8Var = new cj8(bj8Var);
            this.c = cj8Var;
            this.b = new fj8(this.a, cj8Var);
            viewGroup.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f8c);
            wk8.g().i(this.a.getUniqueId());
            MessageManager.getInstance().runTask(2921668, (Class) null);
            baseFragmentActivity.registerListener(new aj8(this.a, this.c));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean q = eg5.q();
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", q ? 1 : 0).param(TiebaStatic.Params.BEAR_CONFIG, q ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, eg5.w() ? 1 : 0).param("obj_param1", this.a.h() ? 2 : 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.h() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.a.i()).eventStat();
            Looper.myQueue().addIdleHandler(new a(this));
            gh.a().post(new b(this));
            this.b.b();
        }
    }

    public void d(Configuration configuration) {
        wi8 wi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (wi8Var = this.b) == null) {
            return;
        }
        wi8Var.onConfigurationChanged(configuration);
    }

    public void e() {
        xi8 xi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (xi8Var = this.a) == null) {
            return;
        }
        xi8Var.a(false);
    }

    public void f() {
        xi8 xi8Var;
        yi8 yi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xi8Var = this.a) == null) {
            return;
        }
        xi8Var.a(true);
        kc5 pageStayDurationItem = this.a.getActivity().getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.r(this.a.getAdSource());
        }
        if (!this.a.f() || (yi8Var = this.c) == null) {
            return;
        }
        yi8Var.a();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wi8 wi8Var = this.b;
            if (wi8Var != null) {
                wi8Var.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}

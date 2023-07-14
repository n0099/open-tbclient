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
/* loaded from: classes8.dex */
public class z6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b7a a;
    public a7a b;
    public c7a c;

    /* loaded from: classes8.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(z6a z6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z6aVar};
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

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(z6a z6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z6aVar};
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

    public z6a() {
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

    public void e() {
        b7a b7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (b7aVar = this.a) != null) {
            b7aVar.a(false);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a7a a7aVar = this.b;
            if (a7aVar != null) {
                a7aVar.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }

    public void a(@NonNull BaseFragmentActivity baseFragmentActivity, @NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048576, this, baseFragmentActivity, viewGroup, i) != null) || baseFragmentActivity == null) {
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
            f7a f7aVar = new f7a(baseFragmentActivity, viewGroup, i);
            this.a = f7aVar;
            g7a g7aVar = new g7a(f7aVar);
            this.c = g7aVar;
            this.b = new j7a(this.a, g7aVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            aba.g().i(this.a.getUniqueId());
            MessageManager.getInstance().runTask(2921668, (Class) null);
            baseFragmentActivity.registerListener(new e7a(this.a, this.c));
        }
    }

    public final void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean q = fx5.q();
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", q ? 1 : 0).param(TiebaStatic.Params.BEAR_CONFIG, q ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, fx5.w() ? 1 : 0);
            int i2 = 2;
            if (this.a.h()) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_param1", i);
            if (!this.a.h()) {
                i2 = 1;
            }
            param2.param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.a.i()).eventStat();
            Looper.myQueue().addIdleHandler(new a(this));
            zg.a().post(new b(this));
            this.b.b();
        }
    }

    public void d(Configuration configuration) {
        a7a a7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) && (a7aVar = this.b) != null) {
            a7aVar.onConfigurationChanged(configuration);
        }
    }

    public void f() {
        b7a b7aVar;
        c7a c7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (b7aVar = this.a) != null) {
            b7aVar.a(true);
            jt5 pageStayDurationItem = this.a.getActivity().getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.r(this.a.getAdSource());
            }
            if (this.a.f() && (c7aVar = this.c) != null) {
                c7aVar.a();
            }
        }
    }
}

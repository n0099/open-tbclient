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
/* loaded from: classes4.dex */
public class jh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lh8 a;
    public kh8 b;

    /* loaded from: classes4.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jh8 jh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh8Var};
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

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(jh8 jh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh8Var};
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

    public jh8() {
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
            ph8 ph8Var = new ph8(baseFragmentActivity, viewGroup, i);
            this.a = ph8Var;
            qh8 qh8Var = new qh8(ph8Var);
            this.b = new th8(this.a, qh8Var);
            viewGroup.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f67);
            kj8.g().i(this.a.getUniqueId());
            MessageManager.getInstance().runTask(2921668, (Class) null);
            baseFragmentActivity.registerListener(new oh8(this.a, qh8Var));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean q = be5.q();
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", q ? 1 : 0).param(TiebaStatic.Params.BEAR_CONFIG, q ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, be5.w() ? 1 : 0).param("obj_param1", this.a.h() ? 2 : 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.h() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.a.i()).eventStat();
            Looper.myQueue().addIdleHandler(new a(this));
            sg.a().post(new b(this));
            this.b.b();
        }
    }

    public void d(Configuration configuration) {
        kh8 kh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (kh8Var = this.b) == null) {
            return;
        }
        kh8Var.onConfigurationChanged(configuration);
    }

    public void e() {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (lh8Var = this.a) == null) {
            return;
        }
        lh8Var.a(false);
    }

    public void f() {
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lh8Var = this.a) == null) {
            return;
        }
        lh8Var.a(true);
        ea5 pageStayDurationItem = this.a.getActivity().getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.r(this.a.getAdSource());
        }
        if (this.a.f()) {
            rh8.g(this.a).b();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            kh8 kh8Var = this.b;
            if (kh8Var != null) {
                kh8Var.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}

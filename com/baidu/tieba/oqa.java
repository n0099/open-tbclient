package com.baidu.tieba;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qqa a;
    public pqa b;
    public rqa c;

    /* loaded from: classes7.dex */
    public class a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(oqa oqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oqaVar};
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

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(oqa oqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oqaVar};
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

    public oqa() {
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
        qqa qqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qqaVar = this.a) != null) {
            qqaVar.a(false);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            pqa pqaVar = this.b;
            if (pqaVar != null) {
                pqaVar.a();
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
            DefaultLog.getInstance().i("SplashAdDelegate", "开屏广告：initSplash");
            uqa uqaVar = new uqa(baseFragmentActivity, viewGroup, i);
            this.a = uqaVar;
            vqa vqaVar = new vqa(uqaVar);
            this.c = vqaVar;
            this.b = new yqa(this.a, vqaVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            qua.g().i(this.a.getUniqueId());
            MessageManager.getInstance().runTask(2921668, (Class) null);
            baseFragmentActivity.registerListener(new tqa(this.a, this.c));
        }
    }

    public final void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DefaultLog.getInstance().i("SplashAdDelegate", "开屏广告：loadSplash");
            boolean q = ws5.q();
            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", q ? 1 : 0).param(TiebaStatic.Params.BEAR_CONFIG, q ? 1 : 0).param(TiebaStatic.Params.PLG_CONFIG, ws5.w() ? 1 : 0);
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
            SafeHandler.getInst().post(new b(this));
            this.b.b();
        }
    }

    public void d(Configuration configuration) {
        pqa pqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) && (pqaVar = this.b) != null) {
            pqaVar.onConfigurationChanged(configuration);
        }
    }

    public void f() {
        qqa qqaVar;
        rqa rqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (qqaVar = this.a) != null) {
            qqaVar.a(true);
            PageStayDurationItem pageStayDurationItem = this.a.getActivity().getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.setAdSource(this.a.getAdSource());
            }
            if (this.a.f() && (rqaVar = this.c) != null) {
                rqaVar.a();
            }
        }
    }
}

package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r8a a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x8a a;

        public a(x8a x8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x8aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x8a a;

        public b(x8a x8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x8aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.getActivity().getWindow().clearFlags(1024);
            }
        }
    }

    public x8a() {
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

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bha.a(MainTabScheduleStrategy.FLUSHING);
            SafeHandler.getInst().post(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.getActivity().finish();
        }
    }

    @NonNull
    public static x8a h(@NonNull r8a r8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, r8aVar)) == null) {
            x8a x8aVar = new x8a();
            x8aVar.a = r8aVar;
            return x8aVar;
        }
        return (x8a) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            aha.a("SplashCloseManager closeInternal flag:" + this.a.g() + " isHot:" + this.a.h());
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("SplashCloseManager", "开屏广告：closeInternal, flag: " + this.a.g() + " isHot:" + this.a.h());
            this.a.getActivity();
            if (this.a.g() == 1) {
                if (this.a.h()) {
                    f();
                    LogoActivityConfig.IS_HOT_SPLASH_SHOW = false;
                } else {
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
                    e();
                }
            }
            if (this.a.g() == 2) {
                g();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
                MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = false;
                YunDialogManager.onShow(this.a.getActivity(), a05.g);
                YunDialogManager.onShow(this.a.getActivity(), a05.s);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921736, SpeedStatsUtils.UBC_VALUE_SPLASH));
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, -1));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DefaultLog.getInstance().i("SplashCloseManager", "开屏广告：removeAdView");
            ViewGroup viewGroup = (ViewGroup) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092292);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                viewGroup.removeAllViews();
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("SplashCloseManager", "开屏广告：removeAdView, 移除后子View数量（判断是否移除成功）：" + viewGroup.getChildCount());
            }
            SafeHandler.getInst().post(new b(this));
        }
    }
}

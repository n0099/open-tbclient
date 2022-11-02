package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ml8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gl8 a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml8 a;

        public a(ml8 ml8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    public ml8() {
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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jr8.a(MainTabScheduleStrategy.FLUSHING);
            zg.a().post(new a(this));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.getActivity().finish();
        }
    }

    @NonNull
    public static ml8 g(@NonNull gl8 gl8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gl8Var)) == null) {
            ml8 ml8Var = new ml8();
            ml8Var.a = gl8Var;
            return ml8Var;
        }
        return (ml8) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.getActivity();
            if (this.a.g() == 1) {
                if (this.a.h()) {
                    e();
                } else {
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
                    d();
                }
            }
            if (this.a.g() == 2) {
                f();
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
                MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921736, SpeedStatsUtils.UBC_VALUE_SPLASH));
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, -1));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f091f7e);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                viewGroup.removeAllViews();
            }
            this.a.getActivity().getWindow().clearFlags(1024);
        }
    }
}

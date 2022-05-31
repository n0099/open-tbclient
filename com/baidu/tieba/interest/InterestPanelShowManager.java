package com.baidu.tieba.interest;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jw4;
import com.repackage.m97;
import com.repackage.n97;
import com.repackage.o97;
import com.repackage.ys4;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestPanelShowManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile InterestPanelShowManager c;
    public transient /* synthetic */ FieldHolder $fh;
    public o97 a;
    public boolean b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class InterestPanelShowState {
        public static final /* synthetic */ InterestPanelShowState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InterestPanelShowState ALL;
        public static final InterestPanelShowState INTEREST_FORUM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1332496406, "Lcom/baidu/tieba/interest/InterestPanelShowManager$InterestPanelShowState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1332496406, "Lcom/baidu/tieba/interest/InterestPanelShowManager$InterestPanelShowState;");
                    return;
                }
            }
            ALL = new InterestPanelShowState("ALL", 0);
            InterestPanelShowState interestPanelShowState = new InterestPanelShowState("INTEREST_FORUM", 1);
            INTEREST_FORUM = interestPanelShowState;
            $VALUES = new InterestPanelShowState[]{ALL, interestPanelShowState};
        }

        public InterestPanelShowState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InterestPanelShowState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InterestPanelShowState) Enum.valueOf(InterestPanelShowState.class, str) : (InterestPanelShowState) invokeL.objValue;
        }

        public static InterestPanelShowState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InterestPanelShowState[]) $VALUES.clone() : (InterestPanelShowState[]) invokeV.objValue;
        }
    }

    public InterestPanelShowManager() {
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

    public static InterestPanelShowManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (InterestPanelShowManager.class) {
                    if (c == null) {
                        c = new InterestPanelShowManager();
                    }
                }
            }
            return c;
        }
        return (InterestPanelShowManager) invokeV.objValue;
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            jw4 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
            if (interestBoardConfigData == null) {
                return false;
            }
            long m = ys4.k().m("key_app_launch_time", 0L);
            return m != 0 && ((int) (((((j - m) / 1000) / 60) / 60) / 24)) >= interestBoardConfigData.b && TbSingleton.getInstance().interestGuideShowCountInLimit(ys4.k().q("key_interest_guide_show", ""), interestBoardConfigData);
        }
        return invokeJ.booleanValue;
    }

    public void c(o97 o97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o97Var) == null) {
            this.a = o97Var;
        }
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            e(context, false);
        }
    }

    public void e(Context context, boolean z) {
        InterestPanelShowState f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, context, z) == null) || (f = f()) == null) {
            return;
        }
        InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(context);
        if (InterestPanelShowState.INTEREST_FORUM == f && this.a.a() != null) {
            interestGuideActivityConfig.setOnlyShowInterestedForum(true, this.a.a().a());
        }
        if (this.b) {
            interestGuideActivityConfig.setScene(8);
        } else {
            interestGuideActivityConfig.setCustomTitle(new String[]{context.getResources().getString(R.string.obfuscated_res_0x7f0f0900), context.getResources().getString(R.string.obfuscated_res_0x7f0f0901), context.getResources().getString(R.string.obfuscated_res_0x7f0f08fc)});
            interestGuideActivityConfig.setScene(9);
        }
        if (z) {
            interestGuideActivityConfig.setRequestCode(25060);
            interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
    }

    public final InterestPanelShowState f() {
        InterceptResult invokeV;
        o97 o97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TimeHelper.isSameDay(ys4.k().m("key_interest_panel_show_time", 0L), System.currentTimeMillis()) && (o97Var = this.a) != null && o97Var.b() != null && this.a.a() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int registerTime = (int) (((currentTimeMillis - (this.a.b().getRegisterTime() * 1000)) / 86400000) + 1);
                m97 a = this.a.a();
                List<n97> b = a.b();
                if (ListUtils.isEmpty(b)) {
                    return null;
                }
                for (int i = 0; i < b.size(); i++) {
                    if (b.get(i).a() == registerTime) {
                        if (i == 0) {
                            this.b = true;
                            return InterestPanelShowState.ALL;
                        }
                        this.b = false;
                        if (a.c() < b.get(i).b() && a.d() == 0) {
                            return InterestPanelShowState.ALL;
                        }
                        if (a.c() < b.get(i).b() && a.d() == 1) {
                            return InterestPanelShowState.INTEREST_FORUM;
                        }
                    }
                }
                if (b(currentTimeMillis)) {
                    return InterestPanelShowState.ALL;
                }
            }
            return null;
        }
        return (InterestPanelShowState) invokeV.objValue;
    }
}

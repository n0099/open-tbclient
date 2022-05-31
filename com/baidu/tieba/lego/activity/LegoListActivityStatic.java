package com.baidu.tieba.lego.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ac7;
import com.repackage.ja7;
import com.repackage.ka7;
import com.repackage.la7;
import com.repackage.lj4;
import com.repackage.ma7;
import com.repackage.mj4;
import com.repackage.na7;
import com.repackage.oa7;
import com.repackage.ra7;
import com.repackage.sa7;
/* loaded from: classes3.dex */
public class LegoListActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<LegoListActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<LegoListActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(LegoListActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330828063, "Lcom/baidu/tieba/lego/activity/LegoListActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330828063, "Lcom/baidu/tieba/lego/activity/LegoListActivityStatic;");
                return;
            }
        }
        ac7.a.set(new ja7());
        TbConfig.setLegoLibVersion("3.0.0");
        ra7.h().g(sa7.f());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016447, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(2016470);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016470, Boolean.TRUE));
        la7.a().b(new oa7());
        ka7.a().b(new ma7());
        ka7.a().b(new na7());
        mj4.a.set(la7.a());
        lj4.a.set(ka7.a());
    }

    public LegoListActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

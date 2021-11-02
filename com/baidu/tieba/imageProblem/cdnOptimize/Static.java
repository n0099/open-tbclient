package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class Static {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CustomMessageTask f50879a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(516822155, "Lcom/baidu/tieba/imageProblem/cdnOptimize/Static;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(516822155, "Lcom/baidu/tieba/imageProblem/cdnOptimize/Static;");
                return;
            }
        }
        f50879a = new CustomMessageTask(2017000, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage != null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                            if (data != null && data.f50883a != null && data.f50883a.f50895e != null) {
                                String str = "";
                                boolean z = false;
                                if (data.f50890h == null) {
                                    if (data.f50884b < data.f50883a.f50895e.size()) {
                                        ArrayList<String> arrayList = data.f50883a.f50895e.get(data.f50884b);
                                        if (arrayList.size() > 0) {
                                            str = arrayList.get(0);
                                        }
                                    }
                                } else if (data.f50890h.length() > 0) {
                                    str = data.f50890h;
                                    z = true;
                                }
                                if (PermissionUtil.isAgreePrivacyPolicy() && str.length() > 0) {
                                    data.f50885c = data.f50888f.getTestImageData(data.f50883a.f50893c, str, data.f50883a.f50897g, data.f50883a.f50894d, data.f50889g);
                                    data.f50886d = System.currentTimeMillis() - currentTimeMillis;
                                    data.f50887e = str;
                                    if (z) {
                                        data.f50890h = str;
                                    }
                                    return new CustomResponsedMessage<>(2017000, data);
                                }
                            }
                            return null;
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        });
        new CustomMessageTask(2016101, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ICDNProblemUploader> run(CustomMessage<Object> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2016101, CDNProblemUploader.getInstance()) : (CustomResponsedMessage) invokeL.objValue;
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        new CustomMessageTask(2016102, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ICDNIPDirectConnect> run(CustomMessage<Object> customMessage) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2016102, CDNIPDirectConnect.getInstance()) : (CustomResponsedMessage) invokeL.objValue;
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        f50879a.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        f50879a.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
    }

    public Static() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

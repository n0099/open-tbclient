package com.baidu.tieba.video.localvideo;

import android.app.Activity;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.ou9;
import com.baidu.tieba.ov9;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.vl;
import com.baidu.tieba.wj6;
import com.baidu.tieba.wl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class LocalVideoActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a extends DefaultDownloadCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public String b;
            public String c;
            public final /* synthetic */ CustomResponsedMessage d;

            public a(b bVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = customResponsedMessage;
            }

            @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
            public void onDownloadCancel(PackageInfo packageInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                    ii.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                }
            }

            @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
            public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.FALSE));
                    ii.P(TbadkCoreApplication.getInst(), R.string.libso_load_faild);
                }
            }

            @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
            public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) != null) || packageInfo == null) {
                    return;
                }
                if ("libnama.so".equals(packageInfo.name)) {
                    this.a = BdBaseApplication.getInst().getResHashMap().get("libnama.so");
                }
                if ("face_beautification.mp3".equals(packageInfo.name)) {
                    this.b = BdBaseApplication.getInst().getResHashMap().get("face_beautification.mp3");
                }
                if ("v3.mp3".equals(packageInfo.name)) {
                    this.c = BdBaseApplication.getInst().getResHashMap().get("v3.mp3");
                }
                Activity currentActivity = UtilHelper.currentActivity();
                if (!StringUtils.isNull(this.a) && !StringUtils.isNull(this.b) && !StringUtils.isNull(this.c) && currentActivity != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, ((RecordVideoActivityConfig.b) this.d.getData()).a(currentActivity)));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921615 || !(customResponsedMessage.getData() instanceof RecordVideoActivityConfig.b)) {
                return;
            }
            String str = BdBaseApplication.getInst().getResHashMap().get("face_beautification.mp3");
            String str2 = BdBaseApplication.getInst().getResHashMap().get("v3.mp3");
            if (!StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libnama.so")) && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                Activity currentActivity = UtilHelper.currentActivity();
                if (currentActivity != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, ((RecordVideoActivityConfig.b) customResponsedMessage.getData()).a(currentActivity)));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921614, Boolean.TRUE));
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.baidu.tieba.soloader.libnama");
            arrayList.add("com.baidu.tieba.resloader.face_beautification.mp3");
            arrayList.add("com.baidu.tieba.resloader.v3.mp3");
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(wl.a);
            requestParams.setRunNode("aps");
            requestParams.addChannel(new vl(arrayList, new a(this, customResponsedMessage)));
            PmsManager.getInstance().execute(requestParams);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {
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
        public CustomResponsedMessage<wj6> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof ou9)) {
                    return new CustomResponsedMessage<>(2921466, new ov9((ou9) customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(51780465, "Lcom/baidu/tieba/video/localvideo/LocalVideoActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(51780465, "Lcom/baidu/tieba/video/localvideo/LocalVideoActivityStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(RecordVideoActivityConfig.class, RecordVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditVideoActivityConfig.class, EditVideoActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921466, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2921615, new b(0));
    }

    public LocalVideoActivityStatic() {
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

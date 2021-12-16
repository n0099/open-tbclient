package com.baidu.webkit.internal.resource;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class ResourceSchedulerEngine implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ResourceTaskSchedulerEngine";
    public static ResourceSchedulerEngine sIntance;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<IResourceScheduler> mZeusResourceScheduler;

    /* loaded from: classes2.dex */
    public interface IResourceScheduler extends INoProGuard {
        void fetchIntegrationInfoFromServer();

        void registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener);

        void unregistTaskAndListener(IResourceTask iResourceTask);
    }

    public ResourceSchedulerEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ResourceSchedulerEngine getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ResourceSchedulerEngine.class) {
                if (sIntance == null) {
                    sIntance = new ResourceSchedulerEngine();
                }
            }
            return sIntance;
        }
        return (ResourceSchedulerEngine) invokeV.objValue;
    }

    public boolean fetchIntegrationInfoFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            this.mZeusResourceScheduler.get().fetchIntegrationInfoFromServer();
            Log.i(LOG_TAG, "fetchIntegrationInfoFromServer success");
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean registTaskAndListener(IResourceTask iResourceTask, IResouceNetTaskListener iResouceNetTaskListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iResourceTask, iResouceNetTaskListener)) == null) {
            WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            this.mZeusResourceScheduler.get().registTaskAndListener(iResourceTask, iResouceNetTaskListener);
            Log.i(LOG_TAG, "registTaskAndListener success");
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mZeusResourceScheduler = null;
            sIntance = null;
        }
    }

    public void setZeusResourceScheduler(IResourceScheduler iResourceScheduler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, iResourceScheduler) == null) || iResourceScheduler == null) {
            return;
        }
        this.mZeusResourceScheduler = new WeakReference<>(iResourceScheduler);
        Log.i(LOG_TAG, "setZeusResourceScheduler success");
    }

    public boolean unregistTaskAndListener(IResourceTask iResourceTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iResourceTask)) == null) {
            WeakReference<IResourceScheduler> weakReference = this.mZeusResourceScheduler;
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            this.mZeusResourceScheduler.get().unregistTaskAndListener(iResourceTask);
            Log.i(LOG_TAG, "unregistTaskAndListener success");
            return true;
        }
        return invokeL.booleanValue;
    }
}

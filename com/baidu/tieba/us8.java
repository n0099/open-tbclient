package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class us8 {
    public static /* synthetic */ Interceptable $ic;
    public static us8 mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public a mICrabSdk;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Application application);

        void b(Exception exc);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private boolean isCrabSdkSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public us8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mICrabSdk = getCrabSdk();
    }

    private a getCrabSdk() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (isCrabSdkSwitchOn() && (runTask = MessageManager.getInstance().runTask(2016565, a.class)) != null) {
                return (a) runTask.getData();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public static us8 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (us8.class) {
                    if (mInstance == null) {
                        mInstance = new us8();
                    }
                }
            }
            return mInstance;
        }
        return (us8) invokeV.objValue;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, activity) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.f(motionEvent, activity);
        }
    }

    public void initSdk(Application application) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.a(application);
        }
    }

    public void onPause(Activity activity) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.onResume(activity);
        }
    }

    public void setFlutterPath(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.c(str);
        }
    }

    public void setLastFlutterPage(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.e(str);
        }
    }

    public void setOpenFlutterPage(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.d(str);
        }
    }

    public void uploadException(Exception exc) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, exc) == null) && (aVar = this.mICrabSdk) != null) {
            aVar.b(exc);
        }
    }
}

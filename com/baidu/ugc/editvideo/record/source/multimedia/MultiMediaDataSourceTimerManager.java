package com.baidu.ugc.editvideo.record.source.multimedia;

import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class MultiMediaDataSourceTimerManager {
    public static /* synthetic */ Interceptable $ic;
    public static MultiMediaDataSourceTimerManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread mHandlerThread;
    public HandlerThread mPlayerHandlerThread;
    public HandlerThread mReadPhotoHandlerThread;

    public MultiMediaDataSourceTimerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("MultiMediaDataSourceTimer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("playerThread");
        this.mPlayerHandlerThread = handlerThread2;
        handlerThread2.start();
        HandlerThread handlerThread3 = new HandlerThread("readPhotoThread");
        this.mReadPhotoHandlerThread = handlerThread3;
        handlerThread3.start();
    }

    public static MultiMediaDataSourceTimerManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (MultiMediaDataSourceTimerManager.class) {
                    if (sInstance == null) {
                        sInstance = new MultiMediaDataSourceTimerManager();
                    }
                }
            }
            return sInstance;
        }
        return (MultiMediaDataSourceTimerManager) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            HandlerThread handlerThread2 = this.mPlayerHandlerThread;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            HandlerThread handlerThread3 = this.mReadPhotoHandlerThread;
            if (handlerThread3 != null) {
                handlerThread3.quit();
            }
            sInstance = null;
        }
    }

    public Looper getPlayerLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPlayerHandlerThread.getLooper() : (Looper) invokeV.objValue;
    }

    public Looper getReadPhotoLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mReadPhotoHandlerThread.getLooper() : (Looper) invokeV.objValue;
    }

    public Looper getTimerLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mHandlerThread.getLooper() : (Looper) invokeV.objValue;
    }
}

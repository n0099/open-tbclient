package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
/* loaded from: classes12.dex */
public class ResourceRecycler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler handler;
    public boolean isRecycling;

    /* loaded from: classes12.dex */
    public static final class ResourceRecyclerCallback implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RECYCLE_RESOURCE = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public ResourceRecyclerCallback() {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1) {
                    ((Resource) message.obj).recycle();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public ResourceRecycler() {
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
        this.handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    }

    public void recycle(Resource<?> resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, resource) == null) {
            Util.assertMainThread();
            if (this.isRecycling) {
                this.handler.obtainMessage(1, resource).sendToTarget();
                return;
            }
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
    }
}

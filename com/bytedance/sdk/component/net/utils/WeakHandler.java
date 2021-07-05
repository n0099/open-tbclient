package com.bytedance.sdk.component.net.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class WeakHandler extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<IHandler> mRef;

    /* loaded from: classes6.dex */
    public interface IHandler {
        void handleMsg(Message message);
    }

    public WeakHandler(IHandler iHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRef = new WeakReference<>(iHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IHandler iHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (iHandler = this.mRef.get()) == null || message == null) {
            return;
        }
        iHandler.handleMsg(message);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, iHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRef = new WeakReference<>(iHandler);
    }
}

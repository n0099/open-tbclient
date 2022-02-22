package com.baidu.webkit.sdk.plugin;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface ZeusPlugin {

    /* loaded from: classes3.dex */
    public interface Callback {
        boolean onCallback(ZeusPlugin zeusPlugin, String str, Object obj);
    }

    /* loaded from: classes3.dex */
    public static class Command {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_POOL_SIZE = 50;
        public static Command sPool;
        public static int sPoolSize;
        public static final Object sPoolSync;
        public transient /* synthetic */ FieldHolder $fh;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public int flag;
        public Command next;
        public Object obj;
        public int ret;
        public String what;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1446794960, "Lcom/baidu/webkit/sdk/plugin/ZeusPlugin$Command;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1446794960, "Lcom/baidu/webkit/sdk/plugin/ZeusPlugin$Command;");
                    return;
                }
            }
            sPoolSync = new Object();
        }

        public Command() {
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

        public static Command obtain() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                synchronized (sPoolSync) {
                    if (sPool != null) {
                        Command command = sPool;
                        sPool = command.next;
                        command.next = null;
                        command.flag = 0;
                        sPoolSize--;
                        return command;
                    }
                    return new Command();
                }
            }
            return (Command) invokeV.objValue;
        }

        public static Command obtain(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                Command obtain = obtain();
                obtain.what = str;
                return obtain;
            }
            return (Command) invokeL.objValue;
        }

        public void recycle() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.flag == 1) {
                return;
            }
            this.flag = 1;
            this.what = null;
            this.arg1 = 0;
            this.arg2 = 0;
            this.arg3 = 0;
            this.arg4 = 0;
            this.obj = null;
            this.ret = 0;
            synchronized (sPoolSync) {
                if (sPoolSize < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize++;
                }
            }
        }
    }

    void sendCommand(Command command);

    void setCallback(Callback callback);
}

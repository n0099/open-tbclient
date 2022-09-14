package com.baidu.tieba;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wr8 {
    public static /* synthetic */ Interceptable $ic;
    public static wr8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public boolean b;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Application application);
    }

    public wr8() {
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
        this.b = false;
        this.a = c();
    }

    public static wr8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (wr8.class) {
                    if (c == null) {
                        c = new wr8();
                    }
                }
            }
            return c;
        }
        return (wr8) invokeV.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bx4.k().l("pref_key_jpush_sdk_enable", 0) == 1 : invokeV.booleanValue;
    }

    public final a c() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!a() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
                return null;
            }
            return (a) runTask.getData();
        }
        return (a) invokeV.objValue;
    }

    public void d(Application application) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, application) == null) || this.b || (aVar = this.a) == null) {
            return;
        }
        aVar.a(application);
        this.b = true;
    }
}

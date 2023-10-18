package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.sd5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class zu6 extends sd5 {
    public static /* synthetic */ Interceptable $ic;
    public static zu6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<vd5> a;

    @Override // com.baidu.tieba.sd5
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sd5
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948372494, "Lcom/baidu/tieba/zu6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948372494, "Lcom/baidu/tieba/zu6;");
                return;
            }
        }
        b = new zu6();
    }

    public zu6() {
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

    public static synchronized zu6 e() {
        InterceptResult invokeV;
        zu6 zu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (zu6.class) {
                zu6Var = b;
            }
            return zu6Var;
        }
        return (zu6) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<vd5> linkedList = this.a;
            if (linkedList != null && linkedList.size() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sd5
    public void b(sd5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            LinkedList<vd5> linkedList = this.a;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<vd5> it = this.a.iterator();
                while (it.hasNext()) {
                    vd5 next = it.next();
                    if (aVar != null) {
                        aVar.a(next);
                    }
                }
            } else if (TbFaceManager.i().m() > 0) {
                this.a = new LinkedList<>();
                yu6 yu6Var = new yu6();
                this.a.add(yu6Var);
                if (aVar != null) {
                    aVar.a(yu6Var);
                }
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<vd5> linkedList = this.a;
            if (linkedList != null) {
                Iterator<vd5> it = linkedList.iterator();
                while (it.hasNext()) {
                    if (it.next().m(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

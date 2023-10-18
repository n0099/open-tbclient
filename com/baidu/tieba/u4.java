package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes8.dex */
public class u4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> a;

    public u4() {
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
        this.a = null;
        this.a = new SparseArray<>();
    }

    public static u4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (u4.class) {
                    if (b == null) {
                        b = new u4();
                    }
                }
            }
            return b;
        }
        return (u4) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            String str = this.a.get(i);
            if (str != null) {
                return str;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void c(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && BdBaseApplication.getInst().isDebugMode() && list != null && list.size() != 0) {
            for (String str : list) {
                d(str);
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                Class<?> loadClass = u4.class.getClassLoader().loadClass(str);
                Object newInstance = loadClass.newInstance();
                Field[] fields = loadClass.getFields();
                if (fields != null && fields.length > 0) {
                    for (Field field : fields) {
                        int i = field.getInt(newInstance);
                        String name = field.getName();
                        if (this.a.get(i) == null) {
                            this.a.put(i, name);
                        } else {
                            throw new Error("cmd " + str + " " + name + " 和 " + this.a.get(i) + " 重复");
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }
}

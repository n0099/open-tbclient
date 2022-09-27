package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class s85 {
    public static /* synthetic */ Interceptable $ic;
    public static s85 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Class<? extends r85>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105305, "Lcom/baidu/tieba/s85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105305, "Lcom/baidu/tieba/s85;");
                return;
            }
        }
        b = new s85();
    }

    public s85() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        f(t85.class);
        f(v85.class);
        f(q85.class);
        f(u85.class);
        f(w85.class);
    }

    public static s85 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (s85) invokeV.objValue;
    }

    public r85 a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        r85 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class<? extends r85> cls = this.a.get(imageOperation.actionName);
            if (cls == null || (e = e(cls)) == null) {
                return null;
            }
            e.d(imageOperation.actionParam);
            return e;
        }
        return (r85) invokeL.objValue;
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), list, imageFileInfo})) == null) {
            if (bitmap == null || ListUtils.isEmpty(list)) {
                return bitmap;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                r85 a = a(list.get(i));
                if ((a instanceof w85) && imageFileInfo != null) {
                    ((w85) a).e(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            t85 t85Var = null;
            int i2 = 0;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    t85 t85Var2 = (t85) a(imageOperation);
                    if (t85Var == null || t85Var2.f() <= t85Var.f() || t85Var2.e() <= t85Var.e()) {
                        t85Var = t85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap b2 = t85Var != null ? t85Var.b(bitmap, z) : null;
            if (list != null) {
                for (int i3 = 0; i3 < size; i3++) {
                    r85 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (b2 == null) {
                            return null;
                        }
                        b2 = a2.b(bitmap, z);
                    }
                }
            }
            return b2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                r85 a = a(list.get(i));
                if ((a instanceof w85) && imageFileInfo != null) {
                    return a.c(imageFileInfo.getFilePath());
                }
            }
            t85 t85Var = null;
            int i2 = 0;
            while (i2 < list.size()) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    t85 t85Var2 = (t85) a(imageOperation);
                    if (t85Var == null || t85Var2.f() <= t85Var.f() || t85Var2.e() <= t85Var.e()) {
                        t85Var = t85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            Bitmap c = t85Var != null ? t85Var.c(str) : null;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    r85 a2 = a(list.get(i3));
                    if (a2 != null) {
                        if (c == null) {
                            c = a2.c(str);
                        } else {
                            c = a2.b(c, true);
                        }
                    }
                }
            }
            return c;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final r85 e(Class<? extends r85> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (r85) invokeL.objValue;
    }

    public final void f(Class<? extends r85> cls) {
        r85 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cls) == null) || (e = e(cls)) == null) {
            return;
        }
        this.a.put(e.a(), cls);
    }
}

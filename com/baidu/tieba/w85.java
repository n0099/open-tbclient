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
/* loaded from: classes6.dex */
public class w85 {
    public static /* synthetic */ Interceptable $ic;
    public static w85 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224469, "Lcom/baidu/tieba/w85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224469, "Lcom/baidu/tieba/w85;");
                return;
            }
        }
        b = new w85();
    }

    public static w85 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (w85) invokeV.objValue;
    }

    public w85() {
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
        this.a = new HashMap();
        f(x85.class);
        f(z85.class);
        f(u85.class);
        f(y85.class);
        f(a95.class);
    }

    public v85 a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        v85 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class cls = (Class) this.a.get(imageOperation.actionName);
            if (cls == null || (e = e(cls)) == null) {
                return null;
            }
            e.d(imageOperation.actionParam);
            return e;
        }
        return (v85) invokeL.objValue;
    }

    public final v85 e(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            try {
                return (v85) cls.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (v85) invokeL.objValue;
    }

    public final void f(Class cls) {
        v85 e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, cls) == null) && (e = e(cls)) != null) {
            this.a.put(e.a(), cls);
        }
    }

    public Bitmap b(Bitmap bitmap, boolean z, List list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeCommon;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), list, imageFileInfo})) == null) {
            if (bitmap == null) {
                return bitmap;
            }
            if (ListUtils.isEmpty(list)) {
                return bitmap;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                v85 a = a((ImageOperation) list.get(i));
                if ((a instanceof a95) && imageFileInfo != null) {
                    ((a95) a).e(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            x85 x85Var = null;
            int i2 = 0;
            while (i2 < size) {
                ImageOperation imageOperation = (ImageOperation) list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    x85 x85Var2 = (x85) a(imageOperation);
                    if (x85Var == null || x85Var2.f() <= x85Var.f() || x85Var2.e() <= x85Var.e()) {
                        x85Var = x85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            if (x85Var != null) {
                bitmap2 = x85Var.b(bitmap, z);
            } else {
                bitmap2 = null;
            }
            if (list != null) {
                for (int i3 = 0; i3 < size; i3++) {
                    v85 a2 = a((ImageOperation) list.get(i3));
                    if (a2 != null) {
                        if (bitmap2 == null) {
                            return null;
                        }
                        bitmap2 = a2.b(bitmap, z);
                    }
                }
            }
            return bitmap2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public Bitmap c(String str, List list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            Bitmap bitmap = null;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                v85 a = a((ImageOperation) list.get(i));
                if ((a instanceof a95) && imageFileInfo != null) {
                    return a.c(imageFileInfo.getFilePath());
                }
            }
            x85 x85Var = null;
            int i2 = 0;
            while (i2 < list.size()) {
                ImageOperation imageOperation = (ImageOperation) list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    x85 x85Var2 = (x85) a(imageOperation);
                    if (x85Var == null || x85Var2.f() <= x85Var.f() || x85Var2.e() <= x85Var.e()) {
                        x85Var = x85Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            if (x85Var != null) {
                bitmap = x85Var.c(str);
            }
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    v85 a2 = a((ImageOperation) list.get(i3));
                    if (a2 != null) {
                        if (bitmap == null) {
                            bitmap = a2.c(str);
                        } else {
                            bitmap = a2.b(bitmap, true);
                        }
                    }
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLLL.objValue;
    }
}

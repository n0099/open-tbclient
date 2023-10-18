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
/* loaded from: classes8.dex */
public class th5 {
    public static /* synthetic */ Interceptable $ic;
    public static th5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Class<? extends sh5>> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181224, "Lcom/baidu/tieba/th5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181224, "Lcom/baidu/tieba/th5;");
                return;
            }
        }
        b = new th5();
    }

    public static th5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (th5) invokeV.objValue;
    }

    public th5() {
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
        f(uh5.class);
        f(wh5.class);
        f(rh5.class);
        f(vh5.class);
        f(xh5.class);
    }

    public sh5 a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        sh5 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class<? extends sh5> cls = this.a.get(imageOperation.actionName);
            if (cls == null || (e = e(cls)) == null) {
                return null;
            }
            e.d(imageOperation.actionParam);
            return e;
        }
        return (sh5) invokeL.objValue;
    }

    public final sh5 e(Class<? extends sh5> cls) {
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
        return (sh5) invokeL.objValue;
    }

    public final void f(Class<? extends sh5> cls) {
        sh5 e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, cls) == null) && (e = e(cls)) != null) {
            this.a.put(e.a(), cls);
        }
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
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
                sh5 a = a(list.get(i));
                if ((a instanceof xh5) && imageFileInfo != null) {
                    ((xh5) a).e(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            uh5 uh5Var = null;
            int i2 = 0;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    uh5 uh5Var2 = (uh5) a(imageOperation);
                    if (uh5Var == null || uh5Var2.f() <= uh5Var.f() || uh5Var2.e() <= uh5Var.e()) {
                        uh5Var = uh5Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            if (uh5Var != null) {
                bitmap2 = uh5Var.b(bitmap, z);
            } else {
                bitmap2 = null;
            }
            if (list != null) {
                for (int i3 = 0; i3 < size; i3++) {
                    sh5 a2 = a(list.get(i3));
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

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            Bitmap bitmap = null;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sh5 a = a(list.get(i));
                if ((a instanceof xh5) && imageFileInfo != null) {
                    return a.c(imageFileInfo.getFilePath());
                }
            }
            uh5 uh5Var = null;
            int i2 = 0;
            while (i2 < list.size()) {
                ImageOperation imageOperation = list.get(i2);
                if ("resize".equals(imageOperation.actionName)) {
                    uh5 uh5Var2 = (uh5) a(imageOperation);
                    if (uh5Var == null || uh5Var2.f() <= uh5Var.f() || uh5Var2.e() <= uh5Var.e()) {
                        uh5Var = uh5Var2;
                    }
                    list.remove(i2);
                    i2--;
                }
                i2++;
            }
            if (uh5Var != null) {
                bitmap = uh5Var.c(str);
            }
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sh5 a2 = a(list.get(i3));
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

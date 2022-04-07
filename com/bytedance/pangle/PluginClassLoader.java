package com.bytedance.pangle;

import android.os.Build;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class PluginClassLoader extends DexClassLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginClassLoader";
    public transient /* synthetic */ FieldHolder $fh;
    public final ClassLoader hostClassLoader;
    public final List<ClassLoader> otherPluginClassLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginClassLoader(String str, String str2, String str3, List<ClassLoader> list) {
        super(str, str2, str3, DexClassLoader.getSystemClassLoader().getParent());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, sb, classNotFoundException, classNotFoundException2)) == null) {
            if (classNotFoundException == null) {
                return classNotFoundException2;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                classNotFoundException.addSuppressed(classNotFoundException2);
                return classNotFoundException;
            }
            sb.append(classNotFoundException2.getCause());
            sb.append("\n");
            return new ClassNotFoundException(sb.toString(), classNotFoundException2);
        }
        return (ClassNotFoundException) invokeLLL.objValue;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) {
        InterceptResult invokeL;
        List<ClassLoader> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Class<?> cls = null;
            try {
                e = null;
                cls = super.findClass(str);
            } catch (ClassNotFoundException e) {
                e = e;
            }
            StringBuilder sb = new StringBuilder("loadClass from :\n");
            if (cls == null && (list = this.otherPluginClassLoader) != null) {
                for (ClassLoader classLoader : list) {
                    try {
                        cls = classLoader.loadClass(str);
                    } catch (ClassNotFoundException e2) {
                        e = handleException(sb, e, e2);
                    }
                }
            }
            if (cls == null) {
                try {
                    cls = this.hostClassLoader.loadClass(str);
                } catch (ClassNotFoundException e3) {
                    e = handleException(sb, e, e3);
                }
            }
            if (cls == null) {
                if (e == null) {
                    throw new ClassNotFoundException(str + " class not found in PluginClassLoader");
                }
                throw e;
            }
            return cls;
        }
        return (Class) invokeL.objValue;
    }
}

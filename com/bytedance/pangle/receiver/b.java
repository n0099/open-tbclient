package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final c a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static Object b(Context context) {
            Field field;
            Object readField;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                try {
                    Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                    if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                        return null;
                    }
                    return FieldUtils.readField(field2, readField);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return invokeL.objValue;
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Object b = b(context);
                Object a = a(b, "mWhiteList");
                if (!(a instanceof String[])) {
                    if (b != null) {
                        FieldUtils.writeField(b, "mResourceConfig", (Object) null);
                        return false;
                    }
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(context.getPackageName());
                Collections.addAll(arrayList, (String[]) a);
                FieldUtils.writeField(b, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static Object a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? a(b(context), str) : invokeLL.objValue;
        }

        public static Object a(Object obj, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) {
                if (obj != null) {
                    try {
                        return FieldUtils.readField(obj, str);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                return null;
            }
            return invokeLL.objValue;
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0267b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0267b() {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0267b(byte b) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(Context context);
    }

    /* loaded from: classes4.dex */
    public static class d extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d() {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Object a = a.a(context, "mWhiteList");
                if (a instanceof List) {
                    ((List) a).add(context.getPackageName());
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super((byte) 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Byte) newInitContext.callArgs[0]).byteValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Object a = a.a(context, "mWhiteListMap");
                if (a instanceof Map) {
                    Map map = (Map) a;
                    List list = (List) map.get(0);
                    if (list == null) {
                        list = new ArrayList();
                        map.put(0, list);
                    }
                    list.add(context.getPackageName());
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1903647349, "Lcom/bytedance/pangle/receiver/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1903647349, "Lcom/bytedance/pangle/receiver/b;");
                return;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            a = new a((byte) 0);
        } else if (i < 26) {
            a = new d((byte) 0);
        } else if (i < 28) {
            a = new e((byte) 0);
        } else {
            a = new C0267b((byte) 0);
        }
    }

    public static void a(Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, application) == null) || application == null) {
            return;
        }
        try {
            if (TextUtils.equals(Build.BRAND.toLowerCase(), RomUtils.MANUFACTURER_HUAWEI)) {
                a.a(application.getBaseContext());
            }
        } catch (Throwable unused) {
        }
    }
}

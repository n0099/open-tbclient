package com.baidu.tieba;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ConcurrentModificationException;
/* loaded from: classes5.dex */
public interface no2 {
    public static final oo2 a = new d(Boolean.FALSE);
    public static final oo2 b = new e(0);
    public static final oo2 c = new f(0L);
    public static final oo2 d = new g(Float.valueOf(0.0f));
    public static final oo2 e = new h();
    public static final oo2 f = new a();
    public static final oo2 g = new b();
    public static final oo2 h = new c();

    /* loaded from: classes5.dex */
    public final class a extends oo2 {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public String[] c(Bundle bundle, String str, String[] strArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, strArr)) == null) {
                return bundle.getStringArray(str);
            }
            return (String[]) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, strArr) == null) {
                bundle.putStringArray(str, strArr);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Bundle c(Bundle bundle, String str, Bundle bundle2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, bundle2)) == null) {
                return bundle.getBundle(str);
            }
            return (Bundle) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, bundle2) == null) {
                bundle.putBundle(str, bundle2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Parcelable c(Bundle bundle, String str, Parcelable parcelable) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, parcelable)) == null) {
                return bundle.getParcelable(str);
            }
            return (Parcelable) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, parcelable) == null) {
                bundle.putParcelable(str, parcelable);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class d extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Boolean bool) {
            super(bool);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Boolean c(Bundle bundle, String str, Boolean bool) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, bool)) == null) {
                return Boolean.valueOf(bundle.getBoolean(str, bool.booleanValue()));
            }
            return (Boolean) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, bool) == null) {
                bundle.putBoolean(str, bool.booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class e extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Integer num) {
            super(num);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Integer c(Bundle bundle, String str, Integer num) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, num)) == null) {
                return Integer.valueOf(bundle.getInt(str, num.intValue()));
            }
            return (Integer) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Integer num) {
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, num) == null) {
                try {
                    bundle.putInt(str, num.intValue());
                } catch (ConcurrentModificationException e) {
                    u93.b bVar = new u93.b(10011);
                    if (m33.M() == null) {
                        O = "null appKey";
                    } else {
                        O = m33.M().O();
                    }
                    bVar.h(O);
                    bVar.k(str);
                    bVar.i(Log.getStackTraceString(e));
                    bVar.m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class f extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Long l) {
            super(l);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Long c(Bundle bundle, String str, Long l) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, l)) == null) {
                return Long.valueOf(bundle.getLong(str, l.longValue()));
            }
            return (Long) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, l) == null) {
                bundle.putLong(str, l.longValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class g extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Float f) {
            super(f);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public Float c(Bundle bundle, String str, Float f) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, f)) == null) {
                return Float.valueOf(bundle.getFloat(str, f.floatValue()));
            }
            return (Float) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, Float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, f) == null) {
                bundle.putFloat(str, f.floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class h extends oo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: f */
        public String c(Bundle bundle, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, str2)) == null) {
                return bundle.getString(str, str2);
            }
            return (String) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo2
        /* renamed from: g */
        public void e(Bundle bundle, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, str2) == null) {
                bundle.putString(str, str2);
            }
        }
    }
}

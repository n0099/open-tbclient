package com.baidu.tieba;

import android.text.TextUtils;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public class pd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface f {
        void a(LottieComposition lottieComposition);

        void b();
    }

    /* loaded from: classes5.dex */
    public class a implements LottieListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(pd1 pd1Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && (fVar = this.a) != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LottieListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(pd1 pd1Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                if (lottieComposition != null) {
                    f fVar = this.a;
                    if (fVar != null) {
                        fVar.a(lottieComposition);
                        return;
                    }
                    return;
                }
                f fVar2 = this.a;
                if (fVar2 != null) {
                    fVar2.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LottieListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(pd1 pd1Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, th) == null) && (fVar = this.a) != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements LottieListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public d(pd1 pd1Var, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pd1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                if (lottieComposition != null) {
                    f fVar = this.a;
                    if (fVar != null) {
                        fVar.a(lottieComposition);
                        return;
                    }
                    return;
                }
                f fVar2 = this.a;
                if (fVar2 != null) {
                    fVar2.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public static pd1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-521933557, "Lcom/baidu/tieba/pd1$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-521933557, "Lcom/baidu/tieba/pd1$e;");
                    return;
                }
            }
            a = new pd1(null);
        }
    }

    public pd1() {
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

    public static pd1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e.a;
        }
        return (pd1) invokeV.objValue;
    }

    public /* synthetic */ pd1(a aVar) {
        this();
    }

    public void a(File file, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, file, fVar) == null) && file != null && file.exists()) {
            try {
                LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(file.getPath())), null).addListener(new b(this, fVar)).addFailureListener(new a(this, fVar));
            } catch (Exception unused) {
                if (fVar != null) {
                    fVar.b();
                }
            }
        }
    }

    public void b(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fVar) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        File s = ae1.s(str);
        if (s != null && s.exists()) {
            a(s, fVar);
            return;
        }
        try {
            LottieCompositionFactory.fromUrl(aj0.b(), str).addListener(new d(this, fVar)).addFailureListener(new c(this, fVar));
        } catch (Exception unused) {
            if (fVar != null) {
                fVar.b();
            }
        }
    }
}

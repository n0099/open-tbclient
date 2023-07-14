package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rtb;
import com.baidu.tieba.ytb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.LoggerManager;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
/* loaded from: classes7.dex */
public final class qtb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CrashSdkUtil";
    public static final long b = 600;
    public static final qtb c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements ztb {
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

        @Override // com.baidu.tieba.ztb
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && str2 != null) {
                rtb.b.b(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void e(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && str2 != null) {
                rtb.b.d(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void i(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && str2 != null) {
                rtb.b.g(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void w(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && str2 != null) {
                rtb.b.j(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void e(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th) == null) && str2 != null) {
                rtb.b.d(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void i(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, th) == null) && str2 != null) {
                rtb.b.g(qtb.b(qtb.c), str2);
            }
        }

        @Override // com.baidu.tieba.ztb
        public void w(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) && str2 != null) {
                rtb.b.j(qtb.b(qtb.c), str2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ytb.e {
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

        @Override // com.baidu.tieba.ytb.e
        public void a(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                rtb.b.g(qtb.b(qtb.c), "afterCrashCallback");
            }
        }

        @Override // com.baidu.tieba.ytb.e
        public void b(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                rtb.b.g(qtb.b(qtb.c), "crashCallback");
            }
        }

        @Override // com.baidu.tieba.ytb.e
        public void c(boolean z, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                try {
                    rtb.b.g(qtb.b(qtb.c), "preCrashCallback");
                    ytb.s(qtb.c.e(qtb.a(qtb.c)));
                } catch (Throwable th) {
                    rtb.b.d(qtb.b(qtb.c), th.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104778, "Lcom/baidu/tieba/qtb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104778, "Lcom/baidu/tieba/qtb;");
                return;
            }
        }
        c = new qtb();
    }

    public qtb() {
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

    public static final /* synthetic */ long a(qtb qtbVar) {
        return b;
    }

    public static final /* synthetic */ String b(qtb qtbVar) {
        return a;
    }

    public final void d(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("processName", str);
            try {
                ytb.f fVar = new ytb.f();
                fVar.g(context);
                fVar.f("baidu-yyremoteview");
                fVar.i(str2);
                fVar.h(new a());
                ytb.n(fVar);
                dub.W(str3);
                ytb.r(hashMap);
                ytb.q(new b());
            } catch (Throwable th) {
                rtb.a aVar = rtb.b;
                String str4 = a;
                th.printStackTrace();
                aVar.d(str4, Unit.INSTANCE.toString());
            }
        }
    }

    public final List<String> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = currentTimeMillis - j;
            rtb.b.e(true);
            String baseDir = LoggerManager.getBaseDir();
            List<String> queryLogFiles = LoggerManager.queryLogFiles(j2, currentTimeMillis, "yylivesdk", "*");
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = queryLogFiles.iterator();
            while (it.hasNext()) {
                arrayList.add(baseDir + WebvttCueParser.CHAR_SLASH + it.next());
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }
}

package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.leb;
import com.baidu.tieba.seb;
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
/* loaded from: classes6.dex */
public final class keb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CrashSdkUtil";
    public static final long b = 600;
    public static final keb c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements seb.e {
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

        @Override // com.baidu.tieba.seb.e
        public void a(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                leb.b.g(keb.b(keb.c), "afterCrashCallback");
            }
        }

        @Override // com.baidu.tieba.seb.e
        public void b(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                leb.b.g(keb.b(keb.c), "crashCallback");
            }
        }

        @Override // com.baidu.tieba.seb.e
        public void c(boolean z, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                try {
                    leb.b.g(keb.b(keb.c), "preCrashCallback");
                    seb.s(keb.c.e(keb.a(keb.c)));
                } catch (Throwable th) {
                    leb.b.d(keb.b(keb.c), th.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947911617, "Lcom/baidu/tieba/keb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947911617, "Lcom/baidu/tieba/keb;");
                return;
            }
        }
        c = new keb();
    }

    public keb() {
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

    public static final /* synthetic */ long a(keb kebVar) {
        return b;
    }

    public static final /* synthetic */ String b(keb kebVar) {
        return a;
    }

    public final void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("processName", str);
            try {
                seb.f fVar = new seb.f();
                fVar.g(context);
                fVar.f("baidu-yyremoteview");
                fVar.h(str2);
                seb.n(fVar);
                seb.r(hashMap);
                seb.q(new a());
            } catch (Throwable th) {
                leb.a aVar = leb.b;
                String str3 = a;
                th.printStackTrace();
                aVar.d(str3, Unit.INSTANCE.toString());
            }
        }
    }

    public final List<String> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = currentTimeMillis - j;
            leb.b.e(true);
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

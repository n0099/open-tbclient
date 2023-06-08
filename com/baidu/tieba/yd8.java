package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.ImGroupChatLog;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yd8 {
    public static /* synthetic */ Interceptable $ic;
    public static final zd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements zd8.a {
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

        @Override // com.baidu.tieba.zd8.a
        public void a(@NonNull String str, @NonNull String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                ImGroupChatLog.getInstance().c(str, str2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326428, "Lcom/baidu/tieba/yd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326428, "Lcom/baidu/tieba/yd8;");
                return;
            }
        }
        a = new zd8(new a());
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            a.b();
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a.c();
        }
    }

    public static void a(@NonNull StringBuilder sb, long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            sb.append("roomId");
            sb.append("=");
            sb.append(j);
            sb.append(",");
            sb.append(StatConstants.KEY_EXT_ERR_CODE);
            sb.append("=");
            sb.append(i);
            sb.append(",");
            sb.append(StatConstants.KEY_EXT_ERR_MSG);
            sb.append("=");
            sb.append(str);
            sb.append(",");
        }
    }

    public static void b(@NonNull StringBuilder sb, long j, @NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{sb, Long.valueOf(j), th}) == null) {
            sb.append("roomId");
            sb.append("=");
            sb.append(j);
            sb.append(",");
            sb.append("stackTrace");
            sb.append("=");
            sb.append(Log.getStackTraceString(th));
            sb.append(",");
        }
    }

    public static void c(@NonNull StringBuilder sb, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, sb, z) == null) {
            if (z) {
                str = "success";
            } else {
                str = "fail";
            }
            sb.append(str);
            sb.append(",");
        }
    }

    public static void f(long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb, j, i, str);
            a.a("enter_chat_room_user", sb.toString());
        }
    }

    public static void g(@NonNull String str, long j, @NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Long.valueOf(j), th}) == null) {
            StringBuilder sb = new StringBuilder();
            b(sb, j, th);
            a.a(str, sb.toString());
        }
    }

    public static void h(long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb, j, i, str);
            a.a("exit_chat_room_user", sb.toString());
        }
    }

    public static void i(boolean z, long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            c(sb, z);
            a(sb, j, i, str);
            a.a("get_chat_room_detail", sb.toString());
        }
    }
}

package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull StringBuilder sb, long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{sb, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
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

    public static void b(@NonNull StringBuilder sb, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, sb, z) == null) {
            if (z) {
                str = "success";
            } else {
                str = "fail";
            }
            sb.append(str);
            sb.append(",");
        }
    }

    public static void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, null, str, j) == null) {
            o05.d(str + j);
        }
    }

    public static void k(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, str, j) == null) {
            o05.e(str + j);
        }
    }

    public static void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            o05.d(str);
        }
    }

    public static void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            StringBuilder sb = new StringBuilder();
            b(sb, z);
            o05.b("login_lcp", sb.toString());
        }
    }

    public static void j(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            o05.e(str);
        }
    }

    public static void e(long j, long j2, int i, boolean z, boolean z2, int i2, @NonNull String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            o05.b("fetch_chat_room_msg_request", "roomId=" + j + ",beginMsgId=" + j2 + ",count=" + i + ",isFirstFetch=" + z + ",isFetchHistory=" + z2 + ",errCode=" + i2 + ",errMsg=" + str + ",resultCount=" + i3 + ",");
        }
    }

    public static void f(long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb, j, i, str);
            o05.b("im_enter_auto_retry_" + j, sb.toString());
        }
    }

    public static void g(long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb, j, i, str);
            o05.b("im_exit_auto_retry_" + j, sb.toString());
        }
    }

    public static void h(long j, int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            StringBuilder sb = new StringBuilder();
            a(sb, j, i, str);
            o05.b("login_im", sb.toString());
        }
    }
}

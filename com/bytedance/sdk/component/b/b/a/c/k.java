package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.x;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes5.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final x f28256a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28257b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28258c;

    public k(x xVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28256a = xVar;
        this.f28257b = i2;
        this.f28258c = str;
    }

    public static k a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, abVar)) == null) ? new k(abVar.b(), abVar.c(), abVar.e()) : (k) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f28256a == x.f28659a ? "HTTP/1.0" : "HTTP/1.1");
            sb.append(' ');
            sb.append(this.f28257b);
            if (this.f28258c != null) {
                sb.append(' ');
                sb.append(this.f28258c);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static k a(String str) throws IOException {
        InterceptResult invokeL;
        x xVar;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i2 = 9;
            if (str.startsWith("HTTP/1.")) {
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int charAt = str.charAt(7) - '0';
                    if (charAt == 0) {
                        xVar = x.f28659a;
                    } else if (charAt == 1) {
                        xVar = x.f28660b;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (str.startsWith("ICY ")) {
                xVar = x.f28659a;
                i2 = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i3 = i2 + 3;
            if (str.length() >= i3) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i2, i3));
                    if (str.length() <= i3) {
                        str2 = "";
                    } else if (str.charAt(i3) == ' ') {
                        str2 = str.substring(i2 + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new k(xVar, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }
        return (k) invokeL.objValue;
    }
}

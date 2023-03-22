package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes5.dex */
public class j3 extends k1<i3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public com.badlogic.gdx.math.a c;

    /* loaded from: classes5.dex */
    public static class a extends u0<i3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public int c;
        public String[] d;

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
                    return;
                }
            }
            this.b = "i ";
            this.c = 1024;
            this.d = new String[]{"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(b1 b1Var) {
        super(b1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a();
        this.c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k1
    /* renamed from: e */
    public i3 c(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, w0Var, str, t2Var, aVar)) == null) {
            return f(new m3((Texture) w0Var.i(w0Var.n(str).first())), t2Var);
        }
        return (i3) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x0
    /* renamed from: d */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, t2Var, aVar)) == null) {
            if (aVar == null) {
                aVar = this.b;
            }
            try {
                BufferedReader q = t2Var.q(aVar.c);
                while (true) {
                    String readLine = q.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(aVar.b)) {
                            str2 = readLine.substring(aVar.b.length());
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                q.close();
                if (str2 == null && (strArr = aVar.d) != null) {
                    for (String str3 : strArr) {
                        t2 s = t2Var.s(t2Var.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 == null) {
                    return null;
                }
                k6<s0> k6Var = new k6<>(1);
                k6Var.a(new s0(t2Var.s(str2), Texture.class));
                return k6Var;
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading " + str, e);
            }
        }
        return (k6) invokeLLL.objValue;
    }

    public i3 f(m3 m3Var, t2 t2Var) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m3Var, t2Var)) == null) {
            BufferedReader q = t2Var.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            s7.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + t2Var);
                        }
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + t2Var, e);
                    }
                } finally {
                    s7.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            return new i3(m3Var, fArr, this.c.c(fArr).f());
        }
        return (i3) invokeLL.objValue;
    }
}

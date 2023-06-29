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
/* loaded from: classes7.dex */
public class s3 extends t1<r3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public com.badlogic.gdx.math.a c;

    /* loaded from: classes7.dex */
    public static class a extends d1<r3> {
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
    public s3(k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a();
        this.c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t1
    /* renamed from: e */
    public r3 c(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, f1Var, str, c3Var, aVar)) == null) {
            return f(new v3((Texture) f1Var.i(f1Var.n(str).first())), c3Var);
        }
        return (r3) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: d */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, c3Var, aVar)) == null) {
            if (aVar == null) {
                aVar = this.b;
            }
            try {
                BufferedReader q = c3Var.q(aVar.c);
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
                        c3 s = c3Var.s(c3Var.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 == null) {
                    return null;
                }
                t6<b1> t6Var = new t6<>(1);
                t6Var.a(new b1(c3Var.s(str2), Texture.class));
                return t6Var;
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading " + str, e);
            }
        }
        return (t6) invokeLLL.objValue;
    }

    public r3 f(v3 v3Var, c3 c3Var) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, v3Var, c3Var)) == null) {
            BufferedReader q = c3Var.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            b8.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + c3Var);
                        }
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + c3Var, e);
                    }
                } finally {
                    b8.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            return new r3(v3Var, fArr, this.c.c(fArr).f());
        }
        return (r3) invokeLL.objValue;
    }
}

package com.baidu.tieba;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.u1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class o4 extends u1<b> {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final j7 d;
    public final j7 e;
    public final j7 f;
    public final b7<a> g;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public String b;
        public b7<Integer> c;
        public int d;
        public boolean e;
        public boolean f;

        public a(o4 o4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.c = new b7<>(200);
            this.d = 0;
            new g4("");
            this.b = "default";
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends u1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean c;

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448311464, "Lcom/baidu/tieba/o4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448311464, "Lcom/baidu/tieba/o4;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o4(s1 s1Var) {
        super(s1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new j7(300);
        this.e = new j7(300);
        this.f = new j7(200);
        this.g = new b7<>(10);
    }

    public final int j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt < 0 ? i + parseInt : parseInt - 1;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1
    /* renamed from: k */
    public w4 h(k3 k3Var, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k3Var, bVar)) == null) {
            return l(k3Var, bVar != null && bVar.c);
        }
        return (w4) invokeLL.objValue;
    }

    public w4 l(k3 k3Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, k3Var, z)) == null) {
            if (h) {
                f1.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
            }
            n4 n4Var = new n4();
            a aVar = new a(this, "default");
            this.g.a(aVar);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(k3Var.m()), 4096);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length < 1) {
                        break;
                    } else if (split[0].length() != 0 && (charAt = split[0].toLowerCase().charAt(0)) != '#') {
                        if (charAt == 'v') {
                            if (split[0].length() == 1) {
                                this.d.a(Float.parseFloat(split[1]));
                                this.d.a(Float.parseFloat(split[2]));
                                this.d.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.e.a(Float.parseFloat(split[1]));
                                this.e.a(Float.parseFloat(split[2]));
                                this.e.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.f.a(Float.parseFloat(split[1]));
                                this.f.a(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                            }
                        } else if (charAt == 'f') {
                            b7<Integer> b7Var = aVar.c;
                            int i3 = 1;
                            while (i3 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                b7Var.a(Integer.valueOf(j(split2[0], this.d.b)));
                                if (split2.length > 2) {
                                    if (i3 == 1) {
                                        aVar.e = true;
                                    }
                                    b7Var.a(Integer.valueOf(j(split2[2], this.e.b)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i3 == 1) {
                                        aVar.f = true;
                                    }
                                    b7Var.a(Integer.valueOf(j(split2[1], this.f.b)));
                                }
                                int i4 = i3 + 1;
                                String[] split3 = split[i4].split("/");
                                b7Var.a(Integer.valueOf(j(split3[0], this.d.b)));
                                if (split3.length > 2) {
                                    b7Var.a(Integer.valueOf(j(split3[2], this.e.b)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    b7Var.a(Integer.valueOf(j(split3[1], this.f.b)));
                                }
                                int i5 = i4 + 1;
                                String[] split4 = split[i5].split("/");
                                b7Var.a(Integer.valueOf(j(split4[0], this.d.b)));
                                if (split4.length > 2) {
                                    b7Var.a(Integer.valueOf(j(split4[2], this.e.b)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    b7Var.a(Integer.valueOf(j(split4[1], this.f.b)));
                                }
                                aVar.d++;
                                i3 = i5 - 1;
                            }
                        } else {
                            if (charAt != 'o' && charAt != 'g') {
                                if (split[0].equals("mtllib")) {
                                    n4Var.b(k3Var.i().a(split[1]));
                                } else if (split[0].equals("usemtl")) {
                                    if (split.length == 1) {
                                        aVar.b = "default";
                                    } else {
                                        aVar.b = split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_');
                                    }
                                }
                            }
                            if (split.length > 1) {
                                aVar = m(split[1]);
                            } else {
                                aVar = m("default");
                            }
                        }
                    }
                } catch (IOException unused) {
                    return null;
                }
            }
            bufferedReader.close();
            int i6 = 0;
            while (true) {
                b7<a> b7Var2 = this.g;
                i = b7Var2.b;
                if (i6 >= i) {
                    break;
                }
                if (b7Var2.get(i6).d < 1) {
                    this.g.i(i6);
                    i6--;
                }
                i6++;
            }
            if (i < 1) {
                return null;
            }
            w4 w4Var = new w4();
            int i7 = 0;
            int i8 = 0;
            while (i7 < i) {
                a aVar2 = this.g.get(i7);
                b7<Integer> b7Var3 = aVar2.c;
                int i9 = b7Var3.b;
                int i10 = aVar2.d;
                boolean z2 = aVar2.e;
                boolean z3 = aVar2.f;
                int i11 = i10 * 3;
                float[] fArr = new float[i11 * ((z2 ? 3 : 0) + 3 + (z3 ? 2 : 0))];
                int i12 = 0;
                int i13 = 0;
                while (i12 < i9) {
                    int i14 = i12 + 1;
                    int intValue = b7Var3.get(i12).intValue() * 3;
                    int i15 = i13 + 1;
                    int i16 = i;
                    int i17 = i9;
                    int i18 = intValue + 1;
                    fArr[i13] = this.d.c(intValue);
                    int i19 = i15 + 1;
                    int i20 = i7;
                    fArr[i15] = this.d.c(i18);
                    int i21 = i19 + 1;
                    fArr[i19] = this.d.c(i18 + 1);
                    if (z2) {
                        int i22 = i14 + 1;
                        int intValue2 = b7Var3.get(i14).intValue() * 3;
                        int i23 = i21 + 1;
                        int i24 = intValue2 + 1;
                        fArr[i21] = this.e.c(intValue2);
                        int i25 = i23 + 1;
                        fArr[i23] = this.e.c(i24);
                        i21 = i25 + 1;
                        fArr[i25] = this.e.c(i24 + 1);
                        i14 = i22;
                    }
                    if (z3) {
                        int i26 = i14 + 1;
                        int intValue3 = b7Var3.get(i14).intValue() * 2;
                        int i27 = i21 + 1;
                        int i28 = intValue3 + 1;
                        fArr[i21] = this.f.c(intValue3);
                        i2 = i27 + 1;
                        fArr[i27] = this.f.c(i28);
                        i12 = i26;
                    } else {
                        i2 = i21;
                        i12 = i14;
                    }
                    i9 = i17;
                    i7 = i20;
                    i13 = i2;
                    i = i16;
                }
                int i29 = i7;
                int i30 = i;
                if (i11 >= 32767) {
                    i11 = 0;
                }
                short[] sArr = new short[i11];
                if (i11 > 0) {
                    for (int i31 = 0; i31 < i11; i31++) {
                        sArr[i31] = (short) i31;
                    }
                }
                b7 b7Var4 = new b7();
                b7Var4.a(new t3(1, 3, "a_position"));
                if (z2) {
                    b7Var4.a(new t3(8, 3, "a_normal"));
                }
                if (z3) {
                    b7Var4.a(new t3(16, 2, "a_texCoord0"));
                }
                i8++;
                String num = Integer.toString(i8);
                String str = "default".equals(aVar2.a) ? "node" + num : aVar2.a;
                if ("default".equals(aVar2.a)) {
                    String str2 = "mesh" + num;
                } else {
                    String str3 = aVar2.a;
                }
                String str4 = "default".equals(aVar2.a) ? "part" + num : aVar2.a;
                z4 z4Var = new z4();
                z4Var.a = str;
                z4Var.d = new Vector3(1.0f, 1.0f, 1.0f);
                z4Var.b = new Vector3();
                z4Var.c = new Quaternion();
                c5 c5Var = new c5();
                c5Var.b = str4;
                c5Var.a = aVar2.b;
                z4Var.e = new c5[]{c5Var};
                y4 y4Var = new y4();
                y4Var.a = str4;
                y4Var.b = sArr;
                y4Var.c = 4;
                x4 x4Var = new x4();
                x4Var.a = (t3[]) b7Var4.n(t3.class);
                x4Var.b = fArr;
                x4Var.c = new y4[]{y4Var};
                w4Var.d.a(z4Var);
                w4Var.b.a(x4Var);
                w4Var.c.a(n4Var.a(aVar2.b));
                i7 = i29 + 1;
                i = i30;
            }
            j7 j7Var = this.d;
            if (j7Var.b > 0) {
                j7Var.b();
            }
            j7 j7Var2 = this.e;
            if (j7Var2.b > 0) {
                j7Var2.b();
            }
            j7 j7Var3 = this.f;
            if (j7Var3.b > 0) {
                j7Var3.b();
            }
            b7<a> b7Var5 = this.g;
            if (b7Var5.b > 0) {
                b7Var5.clear();
            }
            return w4Var;
        }
        return (w4) invokeLZ.objValue;
    }

    public final a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            b7.b<a> it = this.g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            a aVar = new a(this, str);
            this.g.a(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
